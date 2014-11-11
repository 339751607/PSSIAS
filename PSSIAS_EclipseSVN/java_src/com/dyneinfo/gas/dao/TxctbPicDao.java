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
public class TxctbPicDao extends BaseSpringJdbcDao<TxctbPic,Long>{
	
	public Class getEntityClass() {
		return TxctbPic.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" TBID as tbid,"
				+" PICTURE as picture"
				+" from T_XCTB_PIC ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_XCTB_PIC where TBID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TxctbPic entity) {
		String sql = "insert into T_XCTB_PIC " 
			 + " (ID,TBID,PICTURE) " 
			 + " values "
			 + " (:id,:tbid,:picture)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_XCTB_PIC",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TxctbPic entity) {
		String sql = "update T_XCTB_PIC set "
					+ " ID=:id,TBID=:tbid,PICTURE=:picture "
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
				+ "/~ and t.TBID = '[tbid]' ~/"
				+ "/~ and t.PICTURE = '[picture]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	//从业人员基本信息 取得照片
	public List getPic(String ID) {
		String sql = "select id, tbid, picture from T_XCTB_PIC where tbid = ? ";
	       return getJdbcTemplate().query(sql, new String[] {ID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	    Long TBID = rs.getLong(2);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "picture");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("TBID", TBID);
			        return results;
	           }
	           
	       });
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
	
	
	private String createSql = "insert into T_XCTB_PIC " 
		 + " (ID,TBID,PICTURE) " 
		 + " values "
		 + " (?,?,?)";
	private String updateSql = "update T_XCTB_PIC set "
		+ " ID=?,TBID=?,PICTURE=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TxctbPic entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setLong(2, entity.getTbid());
//						ps.setjava.sql.Blob(3, entity.getPicture());
						lobCreator.setBlobAsBinaryStream(ps,3, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTxctbPic(final TxctbPic entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getTbid());
//				ps.setjava.sql.Blob(3, entity.getPicture());
			}
		});
	}

	
	public void updateTxctbPic(final TxctbPic entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getTbid());
//				ps.setjava.sql.Blob(3, entity.getPicture());
			}
		});
	}

	
	public void deleteTxctbPic(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
