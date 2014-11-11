/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class LoginHistoryDao extends BaseSpringJdbcDao<LoginHistory,Long>{
	
	public Class getEntityClass() {
		return LoginHistory.class;
	}
	
	public String getIdentifierPropertyName() {
		return "loginid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" LOGINID as loginid,"
				+" LOGINTIME as logintime,"
				+" LOGINNAME as loginname,"
				+" ISVALID as isvalid,"
				+" INVALIDPASSWORD as invalidpassword,"
				+" IPADDRESS as ipaddress,"
				+" BROWSER as browser,"
				+" HOSTNAME as hostname"
				+" from SS_LOGIN_HISTORY ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_LOGIN_HISTORY where LOGINID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where LOGINID=? ";
	}
	
	public void save(LoginHistory entity) {
		String sql = "insert into SS_LOGIN_HISTORY " 
			 + " (LOGINID,LOGINTIME,LOGINNAME,ISVALID,INVALIDPASSWORD,IPADDRESS,BROWSER,HOSTNAME) " 
			 + " values "
			 + " (:loginid,:logintime,:loginname,:isvalid,:invalidpassword,:ipaddress,:browser,:hostname)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_LOGS",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(LoginHistory entity) {
		String sql = "update SS_LOGIN_HISTORY set "
					+ " LOGINID=:loginid,LOGINTIME=:logintime,LOGINNAME=:loginname,ISVALID=:isvalid,INVALIDPASSWORD=:invalidpassword,IPADDRESS=:ipaddress,BROWSER=:browser,HOSTNAME=:hostname "
					+ " where LOGINID=:loginid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t,SS_USER U where t.loginname=u.username "
				+ "/~ and t.LOGINTIME >=to_date('[ltimeBegin]','yyyy-MM-dd hh24:mi:ss') ~/"
				+ "/~ and t.LOGINTIME <=to_date('[ltimeEnd]','yyyy-MM-dd hh24:mi:ss') ~/"
				+ "/~ and t.LOGINNAME = '[loginname]' ~/"
				+ "/~ and t.ISVALID like '%[isvalid]%' ~/"
				+ "/~ and t.INVALIDPASSWORD = '[invalidpassword]' ~/"
				+ "/~ and t.IPADDRESS = '[ipaddress]' ~/"
				+ "/~ and t.BROWSER = '[browser]' ~/"
				+ "/~ and t.HOSTNAME = '[hostname]' ~/"
				+ "/~ and U.DEPTID = '[deptid]' ~/"
				+ " order by t.LOGINTIME desc  ";
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
	
	
	private String createSql = "insert into SS_LOGIN_HISTORY " 
		 + " (LOGINID,LOGINTIME,LOGINNAME,ISVALID,INVALIDPASSWORD,IPADDRESS,BROWSER,HOSTNAME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?)";
	private String updateSql = "update SS_LOGIN_HISTORY set "
		+ " LOGINID=?,LOGINTIME=?,LOGINNAME=?,ISVALID=?,INVALIDPASSWORD=?,IPADDRESS=?,BROWSER=?,HOSTNAME=? "
		+ " where LOGINID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final LoginHistory entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getLoginid());
						ps.setString(2, entity.getLogintimeString());
						ps.setString(3, entity.getLoginname());
						ps.setString(4, entity.getIsvalid());
						ps.setString(5, entity.getInvalidpassword());
						ps.setString(6, entity.getIpaddress());
						ps.setString(7, entity.getBrowser());
						ps.setString(8, entity.getHostname());
						//lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createLoginHistory(final LoginHistory entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getLoginid());
				ps.setString(2, entity.getLogintimeString());
				ps.setString(3, entity.getLoginname());
				ps.setString(4, entity.getIsvalid());
				ps.setString(5, entity.getInvalidpassword());
				ps.setString(6, entity.getIpaddress());
				ps.setString(7, entity.getBrowser());
				ps.setString(8, entity.getHostname());
			}
		});
	}

	
	public void updateLoginHistory(final LoginHistory entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getLoginid());
				ps.setString(2, entity.getLogintimeString());
				ps.setString(3, entity.getLoginname());
				ps.setString(4, entity.getIsvalid());
				ps.setString(5, entity.getInvalidpassword());
				ps.setString(6, entity.getIpaddress());
				ps.setString(7, entity.getBrowser());
				ps.setString(8, entity.getHostname());
			}
		});
	}

	
	public void deleteLoginHistory(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
