/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class StaClDao extends BaseSpringJdbcDao<StaCl,Long>{
	
	public Class getEntityClass() {
		return StaCl.class;
	}
	
	public String getIdentifierPropertyName() {
		return "rowkey";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ROWKEY as rowkey,"
				+" ROWNAME as rowname,"
				+" DEPTSEQ as deptseq,"
				+" SUMVALUE as sumvalue"
				+" from V_STA_CL_RESULT ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from V_STA_CL_RESULT where ROWKEY=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ROWKEY=? ";
	}
	
	public void save(StaCl entity) {
		String sql = "insert into V_STA_CL_RESULT " 
			 + " (ROWKEY,ROWNAME,DEPTSEQ,SUMVALUE) " 
			 + " values "
			 + " (:rowkey,:rowname,:deptseq,:sumvalue)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_V_STA_CL_RESULT",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(StaCl entity) {
		String sql = "update V_STA_CL_RESULT set "
					+ " ROWKEY=:rowkey,ROWNAME=:rowname,DEPTSEQ=:deptseq,SUMVALUE=:sumvalue "
					+ " where ROWKEY=:rowkey";
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
				+ "/~ and t.ROWNAME = '[rowname]' ~/"
				+ "/~ and t.DEPTSEQ = '[deptseq]' ~/"
				+ "/~ and t.SUMVALUE = '[sumvalue]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public Page findByPageRequest(String sql ,PageRequest<Map> pageRequest) {
		
		return pageGroupQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
		
	}
	
	

	
	
	
	public String getDeptLevelBySeq(String  sql_deptlevel) {
		String deptLevel ="";
		try {   
			 deptLevel = (String)this.getJdbcTemplate().queryForObject(sql_deptlevel, String.class); 	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return deptLevel;
	}
	
	
	public int getTagOrgByDeptseq(String sql) {
		int count = 0;
		try {   
			count = (int)this.getJdbcTemplate().queryForInt(sql); 	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	public String getDeptlevel(String sql) {
		String count = "";
		try {   
			count = (String)this.getJdbcTemplate().queryForObject(sql,String.class); 	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	public Object getXML(String sql){
		   //使用 Object execute(String callString, CallableStatementCallback action)接口
		return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	       	    Map results = new HashMap();
        	    String deptname = rs.getString(2);
        	    String deptseq = rs.getString(3);
        	    String sumZl = rs.getString(6);
		        results.put("deptname", deptname);
		        results.put("deptseq", deptseq);
		        results.put("sumZl", sumZl);
			        return results;
	           }
	           
	       });
	
	}
	

}
