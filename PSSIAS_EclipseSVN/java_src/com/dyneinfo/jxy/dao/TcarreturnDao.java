/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcarreturnDao extends BaseSpringJdbcDao<Tcarreturn,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcarreturn.class;
	}
	
	public String getIdentifierPropertyName() {
		return "enrolid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ENROLID as enrolid,"
				+" DELINAME as deliname,"
				+" DELICREDTYPE as delicredtype,"
				+" DELICREDCODE as delicredcode,"
				+" RECETIME as recetime,"
				+" RECENAME as recename,"
				+" TAKEOFFNAME as takeoffname,"
				+" TOCREDTYPE as tocredtype,"
				+" TOCREDCODE as tocredcode,"
				+" TOTIME as totime,"
				+" FLAG as flag,"
				+" ENROLTIME as enroltime,"
				+" OPERATOR as operator,"
				+" DELITELEPHONE as delitelephone,"
				+" deliaddress as deliaddress,"	//接车人住址 add by zzq 2012/06/12
				+" SERVERITEM as serveritem,"
				+" DEMO as demo,"
				+" TOMOBILE as tomobile"
				+" from T_CARRETURN ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARRETURN where ENROLID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ENROLID=? ";
	}
	
	public void save(Tcarreturn entity) {
		String sql = "insert into T_CARRETURN " 
			 + " (ENROLID,DELINAME,DELICREDTYPE,DELICREDCODE,RECETIME,RECENAME,TAKEOFFNAME,TOCREDTYPE,TOCREDCODE,TOTIME,FLAG,ENROLTIME,OPERATOR,DELITELEPHONE,SERVERITEM,DEMO,TOMOBILE,deliaddress) " 
			 + " values "
			 + " (:enrolid,:deliname,:delicredtype,:delicredcode,:recetime,:recename,:takeoffname,:tocredtype,:tocredcode,:totime,:flag,:enroltime,:operator,:delitelephone,:serveritem,:demo,:tomobile,:deliaddress)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_CARRETURN",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarreturn entity) {
		String sql = "update T_CARRETURN set "
					+ " ENROLID=:enrolid,DELINAME=:deliname,DELICREDTYPE=:delicredtype,DELICREDCODE=:delicredcode,RECETIME=:recetime,RECENAME=:recename,TAKEOFFNAME=:takeoffname,TOCREDTYPE=:tocredtype,TOCREDCODE=:tocredcode,TOTIME=:totime,FLAG=:flag,ENROLTIME=:enroltime,OPERATOR=:operator,DELITELEPHONE=:delitelephone,SERVERITEM=:serveritem,DEMO=:demo,TOMOBILE=:tomobile,deliaddress=:deliaddress "
					+ " where ENROLID=:enrolid";
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
				+ "/~ and t.DELINAME = '[deliname]' ~/"
				+ "/~ and t.DELICREDTYPE = '[delicredtype]' ~/"
				+ "/~ and t.DELICREDCODE = '[delicredcode]' ~/"
				+ "/~ and t.RECETIME = '[recetime]' ~/"
				+ "/~ and t.RECENAME = '[recename]' ~/"
				+ "/~ and t.TAKEOFFNAME = '[takeoffname]' ~/"
				+ "/~ and t.TOCREDTYPE = '[tocredtype]' ~/"
				+ "/~ and t.TOCREDCODE = '[tocredcode]' ~/"
				+ "/~ and t.TOTIME = '[totime]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.ENROLTIME = '[enroltime]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.DELITELEPHONE = '[delitelephone]' ~/"
				+ "/~ and t.DELIADDRESS = '[deliaddress]' ~/" //add by zzq 2012/06/12
				+ "/~ and t.SERVERITEM = '[serveritem]' ~/"
				+ "/~ and t.DEMO = '[demo]' ~/"
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
	
	

	
	public void deleteTcarreturn(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
