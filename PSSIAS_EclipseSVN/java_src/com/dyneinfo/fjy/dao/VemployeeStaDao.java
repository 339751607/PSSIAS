/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class VemployeeStaDao extends BaseSpringJdbcDao<VemployeeSta,Long>{
	
	public Class getEntityClass() {
		return VemployeeSta.class;
	}
	
	public String getIdentifierPropertyName() {
		return "deptid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DEPTID as deptid,"
				+" DEPTNAME as deptname,"
				+" DEPTSEQ as deptseq,"
				+" DEPTLEVEL as deptlevel,"
				+" STATUS as status,"
				+" NUM as num"
				+" from V_EMPLOYEE_STA ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from V_EMPLOYEE_STA where DEPTID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DEPTID=? ";
	}
	
	public void save(VemployeeSta entity) {
		String sql = "insert into V_EMPLOYEE_STA " 
			 + " (DEPTID,DEPTNAME,DEPTSEQ,DEPTLEVEL,STATUS,NUM) " 
			 + " values "
			 + " (:deptid,:deptname,:deptseq,:deptlevel,:status,:num)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_V_EMPLOYEE_STA",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(VemployeeSta entity) {
		String sql = "update V_EMPLOYEE_STA set "
					+ " DEPTID=:deptid,DEPTNAME=:deptname,DEPTSEQ=:deptseq,DEPTLEVEL=:deptlevel,STATUS=:status,NUM=:num "
					+ " where DEPTID=:deptid";
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
				+ "/~ and t.DEPTNAME = '[deptname]' ~/"
				+ "/~ and t.DEPTSEQ = '[deptseq]' ~/"
				+ "/~ and t.DEPTLEVEL = '[deptlevel]' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.NUM = '[num]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	
	
	public Page findByPageRequest(String sql ,PageRequest<Map> pageRequest) {
		
		return pageGroupQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
		
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
	
	
	
	public String getDeptLevelBySeq(String  deptseq) {
		String sql = "select deptlevel from ss_dept  where deptseq =?  ";
		String deptLevel ="2";
		Object[] obj ={deptseq}; 
		try {   
			 deptLevel = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class); 	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return deptLevel;
	}
	public Object getXML(String sql){
		   //使用 Object execute(String callString, CallableStatementCallback action)接口
		return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	       	    Map results = new HashMap();
        	    String deptname = rs.getString(2);
		        results.put("deptname", deptname);
		        String sumZl = rs.getString(11);
		        results.put("sumZl", sumZl);
			        return results;
	           }
	           
	       });
	
	}
	

}
