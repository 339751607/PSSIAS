/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;



import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TxctbDao extends BaseSpringJdbcDao<Txctb,Long>{
	
	public Class getEntityClass() {
		return Txctb.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" FBR as fbr,"
				+" CZ as cz,"
				+" FBSJ as fbsj,"
				+" BT as bt,"
				+" NR as nr"
				+" from T_XCTB ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_XCTB where ID=?";
	}
	
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_T_XCTB");
		Long id = seq.nextLongValue();
        return id;
	}
	
	//从业人员基本信息 取得照片
	public List getPic(String ID) {
		String sql = "select id, tbid, picture from T_XCTB_PIC where id = ? ";
	       return getJdbcTemplate().query(sql, new String[] {ID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	    Long tbid = rs.getLong(2);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "picture");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("TBID", tbid);
			        return results;
	           }
	           
	       });
	   }
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(Txctb entity) {
		String sql = "insert into T_XCTB " 
			 + " (ID,FBR,CZ,FBSJ,BT,NR) " 
			 + " values "
			 + " (:id,:fbr,:cz,:fbsj,:bt,:nr)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_XCTB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Txctb entity) {
		String sql = "update T_XCTB set "
					+ " ID=:id,FBR=:fbr,CZ=:cz,FBSJ=:fbsj,BT=:bt,NR=:nr "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.FBR = '[fbr]' ~/"
				+ "/~ and t.CZ = '[cz]' ~/"
				+ "/~ and substr(t.fbsj,0,8) >= '[fbsjBeginFormat]' ~/"
				+ "/~ and substr(t.fbsj,0,8) <= '[fbsjEndFormat]' ~/"
				+ "/~ and t.BT like '%[bt]%' ~/"
				+ "/~ and t.NR = '[nr]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public String getCurrentMax(String sql,String arg) throws DataAccessException {
		String currentMaxID = "";
		//String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj ={arg}; 
		try {
			currentMaxID = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}
	
	
	private String createSql = "insert into T_XCTB " 
		 + " (ID,FBR,CZ,FBSJ,BT,NR) " 
		 + " values "
		 + " (?,?,?,?,?,?)";
	private String updateSql = "update T_XCTB set "
		+ " ID=?,FBR=?,CZ=?,FBSJ=?,BT=?,NR=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Txctb entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getFbr());
						ps.setString(3, entity.getCz());
						ps.setString(4, entity.getFbsj());
						ps.setString(5, entity.getBt());
						ps.setString(6, entity.getNr());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTxctb(final Txctb entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getFbr());
				ps.setString(3, entity.getCz());
				ps.setString(4, entity.getFbsj());
				ps.setString(5, entity.getBt());
				ps.setString(6, entity.getNr());
			}
		});
	}

	
	public void updateTxctb(final Txctb entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getFbr());
				ps.setString(3, entity.getCz());
				ps.setString(4, entity.getFbsj());
				ps.setString(5, entity.getBt());
				ps.setString(6, entity.getNr());
			}
		});
	}

	
	public void deleteTxctb(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
