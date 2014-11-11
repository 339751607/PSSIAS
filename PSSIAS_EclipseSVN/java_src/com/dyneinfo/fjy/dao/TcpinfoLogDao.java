/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
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
public class TcpinfoLogDao extends BaseSpringJdbcDao<TcpinfoLog,Long>{
	
	public Class getEntityClass() {
		return TcpinfoLog.class;
	}
	
	public String getIdentifierPropertyName() {
		return "logid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CPCODE as cpcode,"
				+" USERID as userid,"
				+" DEPTID as deptid,"
				+" TYPE as type,"
				+" LOGID as logid,"
				+" DEPTNAME as deptname,"
				+" USERNAME as username,"
				+" UPDATEDATE as updatedate"
				+" from T_CPINFO_LOG ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPINFO_LOG where LOGID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where LOGID=? ";
	}
	
	public void save(TcpinfoLog entity) {
//		String dataSourceName = DBContextHolder.getDBType();
//		System.out.println("========================"+dataSourceName);
//		System.out.println("========================"+getJdbcTemplate());
//		System.out.println("========================"+getJdbcTemplate().getDataSource());
		String sql = "insert into T_CPINFO_LOG " 
			 + " (CPCODE,USERID,DEPTID,TYPE,LOGID,DEPTNAME,USERNAME) " 
			 + " values "
			 + " (:cpcode,:userid,:deptid,:type,:logid,:deptname,:username)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_CPINFO_LOG",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TcpinfoLog entity) {
		String sql = "update T_CPINFO_LOG set "
					+ " CPCODE=:cpcode,USERID=:userid,DEPTID=:deptid,TYPE=:type,LOGID=:logid,DEPTNAME=:deptname,USERNAME=:username "
					+ " where LOGID=:logid";
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
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.USERID = '[userid]' ~/"
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and t.TYPE = '[type]' ~/"
				+ "/~ and t.DEPTNAME = '[deptname]' ~/"
				+ "/~ and t.USERNAME = '[username]' ~/"
				+ "/~ and t.UPDATEDATE = '[updatedate]' ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  updatedate desc ";
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
	
	
	private String createSql = "insert into T_CPINFO_LOG " 
		 + " (CPCODE,USERID,DEPTID,TYPE,LOGID,DEPTNAME,USERNAME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?)";
	private String updateSql = "update T_CPINFO_LOG set "
		+ " CPCODE=?,USERID=?,DEPTID=?,TYPE=?,LOGID=?,DEPTNAME=?,USERNAME=? "
		+ " where LOGID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TcpinfoLog entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getUserid());
						ps.setString(3, entity.getDeptid());
						ps.setString(4, entity.getType());
						ps.setLong(5, entity.getLogid());
						ps.setString(6, entity.getDeptname());
						ps.setString(7, entity.getUsername());

						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpinfoLog(final TcpinfoLog entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getUserid());
				ps.setString(3, entity.getDeptid());
				ps.setString(4, entity.getType());
				ps.setLong(5, entity.getLogid());
				ps.setString(6, entity.getDeptname());
				ps.setString(7, entity.getUsername());
			}
		});
	}

	
	public void updateTcpinfoLog(final TcpinfoLog entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getUserid());
				ps.setString(3, entity.getDeptid());
				ps.setString(4, entity.getType());
				ps.setLong(5, entity.getLogid());
				ps.setString(6, entity.getDeptname());
				ps.setString(7, entity.getUsername());

			}
		});
	}

	
	public void deleteTcpinfoLog(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
