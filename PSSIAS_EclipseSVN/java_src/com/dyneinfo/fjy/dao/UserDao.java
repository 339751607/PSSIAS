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
public class UserDao extends BaseSpringJdbcDao<User,Long>{
	
	public Class getEntityClass() {
		return User.class;
	}
	
	public String getIdentifierPropertyName() {
		return "userid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" DEPTID as deptid,"
				+" ENABLED as enabled,"
				+" PHOTO as photo"
				+" from SS_USER ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_USER where USERID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where USERID=? ";
	}
	
	public void save(User entity) {
		String sql = "insert into SS_USER " 
			 + " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO) " 
			 + " values "
			 + " (:userid,:username,:password,:fullname,:sex,:sfzh,:policeid,:phone,:mobile,:fax,:address,:zip,:emailaddress,:createdate,:deptid,:enabled,:photo)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_USER",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(User entity) {
		String sql = "update SS_USER set "
					+ " FULLNAME=:fullname,SEX=:sex,SFZH=:sfzh,PHONE=:phone,MOBILE=:mobile,FAX=:fax,ADDRESS=:address,ZIP=:zip,ENABLED=:enabled "
					+ " where USERID=:userid";
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
				+ "/~ and t.USERNAME like  '%'||{username}||'%'  ~/"
				+ "/~ and t.PASSWORD = '[password]' ~/"
				+ "/~ and t.FULLNAME like '%'||{fullname}||'%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.SFZH = '[sfzh]' ~/"
				+ "/~ and t.POLICEID = '[policeid]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.MOBILE = '[mobile]' ~/"
				+ "/~ and t.FAX = '[fax]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.ZIP = '[zip]' ~/"
				+ "/~ and t.EMAILADDRESS = '[emailaddress]' ~/"
				+ "/~ and t.CREATEDATE = '[createdate]' ~/"
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and t.ENABLED = '[enabled]' ~/"
				+ "/~ and t.PHOTO = '[photo]' ~/"
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
	
	
	private String createSql = "insert into SS_USER " 
		 + " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update SS_USER set "
		+ " USERNAME=?,PASSWORD=?,FULLNAME=?,SEX=?,SFZH=?,POLICEID=?,PHONE=?,MOBILE=?,FAX=?,ADDRESS=?,ZIP=?,EMAILADDRESS=?,CREATEDATE=?,ENABLED=?,PHOTO=? "
		+ " where USERID=? and DEPTID=? ";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	

	
	public void deleteUser(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
