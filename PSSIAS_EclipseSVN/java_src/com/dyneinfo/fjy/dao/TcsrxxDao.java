/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcsrxxDao extends BaseSpringJdbcDao<Tcsrxx,java.lang.Long>{
	
	public Class getEntityClass() {
		return Tcsrxx.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" IDCARD as idcard,"
				+" CSRXM as csrxm,"
				+" CSRDH as csrdh,"
				+" NPCODE as npcode,"
				+" npaddress as npaddress,"
				+" CPCODE as cpcode,"
				+" csrxb as csrxb, "
				+" praddress as praddress,"
				+" hjaddress as hjaddress"
				+" from T_CSRXX ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CSRXX where IDCARD=? ";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where IDCARD=?  and CPCODE = ?";
	}
	
	public void save(Tcsrxx entity) {
		String sql = "insert into T_CSRXX " 
			 + " (IDCARD,CSRXM,CSRDH,CPCODE,NPCODE,NPADDRESS,PRADDRESS,csrxb,hjaddress) " 
			 + " values "
			 + " (:idcard,:csrxm,:csrdh,:cpcode,:npcode,:npaddress,:praddress,:csrxb,:hjaddress)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_CSRXX",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcsrxx entity) {
		String sql = "update T_CSRXX set "
					+ " CSRXM=:csrxm,CSRDH=:csrdh,CPCODE=:cpcode,NPCODE=:npcode,NPADDRESS=:npaddress,PRADDRESS=:praddress,csrxb=:csrxb,uptime=:sysdate,hjaddress=:hjaddress "
					+ " where IDCARD=:idcard";
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
				+ "/~ and t.IDCARD = '[idcard]' ~/"
				+ "/~ and t.CSRXM = '[csrxm]' ~/"
				+ "/~ and t.CSRDH = '[csrdh]' ~/"
				+"/~  and t.csrxb = '[csrxb]' ~/"
				+ "/~ and t.NPCODE = '[npcode]' ~/"
				+ "/~ and t.NPADDRESS = '[npaddress]' ~/"
				+ "/~ and t.PRADDRESS = '[praddress]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+"/~ and t.hjaddress like '%[hjaddress]%' ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  uptime desc ";
		return pageQuery(sql,pageRequest);
	}
	
	public Page getOldCsrxx(PageRequest<Map> pageRequest,String deptid,String s_idcard,String s_csrxm){
		
		String sqlWhere = " 1=1 ";
		if(s_idcard != null && s_idcard.length() > 0 )
			sqlWhere = sqlWhere + " and  IDCARD like '"+s_idcard+"%'";
		if(s_csrxm != null && s_csrxm.length() > 0 )
			sqlWhere = sqlWhere + " and  CSRXM like '"+s_csrxm+"%'";
		
		String sql=getSelectPrefix()+" c where "+sqlWhere+" and c.cpcode =  '"+deptid.trim()+"'  order by uptime desc ";
		
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
	
	public int getRecorderCount(String sql) {
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	private String createSql = "insert into T_CSRXX " 
		 + " (IDCARD,CSRXM,CSRDH,CPCODE,NPCODE,NPADDRESS,praddress,csrxb,hjaddress,PIC) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CSRXX set "
		+ " CSRXM=?,CSRDH=?,CPCODE=?,NPCODE=?,NPADDRESS=?,praddress=?,CSRXB=?,uptime=sysdate,hjaddress=?"
		+ " where IDCARD=? and cpcode=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(final Tcsrxx entity,byte[] uploadBytes) throws IOException  {
		final byte[] f_file = uploadBytes;
		
//			final InputStream blobIs = new FileInputStream(blobIn);
			getJdbcTemplate().execute(createSql,
					new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
						protected void setValues(PreparedStatement ps,
								LobCreator lobCreator) throws SQLException {
							ps.setString(1, entity.getIdcard());
							ps.setString(2, entity.getCsrxm());
							ps.setString(3, entity.getCsrdh());
							ps.setString(4, entity.getCpcode());
							ps.setString(5, entity.getNpcode());
							ps.setString(6, entity.getNpaddress());
							ps.setString(7, entity.getPraddress());
							ps.setString(8, entity.getCsrxb());
							ps.setString(9, entity.getHjaddress());
							  lobCreator.setBlobAsBytes(ps,10,f_file);  
//							lobCreator.setBlobAsBinaryStream(ps, 10, blobIs,(int) blobIn.length());
						}
					});
		//	blobIs.close();
		

	}
	
	
	public void createTcsrxx(final Tcsrxx entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getIdcard());
				ps.setString(2, entity.getCsrxm());
				ps.setString(3, entity.getCsrdh());
				ps.setString(4, entity.getCpcode());
				ps.setString(5, entity.getNpcode());
				ps.setString(6, entity.getNpaddress());
				ps.setString(7, entity.getPraddress());
				ps.setString(8, entity.getCsrxb());
				ps.setString(9, entity.getHjaddress());
			}
		});
	}

	
	public void updateTcsrxx(final Tcsrxx entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCsrxm());
				ps.setString(2, entity.getCsrdh());
				ps.setString(3, entity.getCpcode());
				ps.setString(4, entity.getNpcode());
				ps.setString(5, entity.getNpaddress());
				ps.setString(6, entity.getPraddress());
				ps.setString(7, entity.getCsrxb());
				ps.setString(8, entity.getHjaddress());
				ps.setString(9, entity.getIdcard());
				ps.setString(10, entity.getCpcode());
				
			}
		});
	}
	
public void savePic(byte[] file,byte[] file1,byte[] file2,Tcsrxx entity) throws IOException{
		
		//final File blobIn = new File("spring2004.jpg");
		
		final byte[] f_file = file;
		final byte[] f_file1 = file1;
		final byte[] f_file2 = file2;


		String insertSql = "update T_CSRXX set DDRYZP = ? ,DWZP=?, DDRYSMZP=? where IDCARD='"+entity.getIdcard()+"' ";
 		
		
		
	
 		 
 		
		getJdbcTemplate().execute(
				insertSql,
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		
		       
		        
		           		lobCreator.setBlobAsBytes(ps,1,f_file);  
		       
		       
			           lobCreator.setBlobAsBytes(ps,2,f_file1);  
		      
			           lobCreator.setBlobAsBytes(ps,3,f_file2);  

		        
		      }
		  }
		);

     
		
	}

	
	public void deleteTcsrxx(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	@SuppressWarnings("unchecked")
	public Tcsrxx getById(String id,String cpcode) {
		List list = getSimpleJdbcTemplate().query(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()),new Object[]{id,cpcode});
		return (Tcsrxx)CollectionHelper.findSingleObject(list);
	}
	

}
