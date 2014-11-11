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
public class VfeijiuwupinStaDao extends BaseSpringJdbcDao<VfeijiuwupinSta,Long>{
	
	public Class getEntityClass() {
		return VfeijiuwupinSta.class;
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
				+" NUM as num,"
				+" WPZLSUM as wpzlsum"
				+" from V_FEIJIUWUPIN_STA ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from V_FEIJIUWUPIN_STA where DEPTID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DEPTID=? ";
	}
	
	public void save(VfeijiuwupinSta entity) {
		String sql = "insert into V_FEIJIUWUPIN_STA " 
			 + " (DEPTID,DEPTNAME,DEPTSEQ,DEPTLEVEL,STATUS,NUM,WPZLSUM) " 
			 + " values "
			 + " (:deptid,:deptname,:deptseq,:deptlevel,:status,:num,:wpzlsum)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_V_FEIJIUWUPIN_STA",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(VfeijiuwupinSta entity) {
		String sql = "update V_FEIJIUWUPIN_STA set "
					+ " DEPTID=:deptid,DEPTNAME=:deptname,DEPTSEQ=:deptseq,DEPTLEVEL=:deptlevel,STATUS=:status,NUM=:num,WPZLSUM=:wpzlsum "
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
				+ "/~ and t.WPZLSUM = '[wpzlsum]' ~/"
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
		String sql = "select deptlevel from ss_dept  where deptseq = ?  ";
		String deptLevel ="2";
		Object[] obj ={deptseq}; 
		try {   
			 deptLevel = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class); 	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return deptLevel;
	}
//	public Object getXML(String sql){
//		   //使用 Object execute(String callString, CallableStatementCallback action)接口
//		return getJdbcTemplate().query(sql, new RowMapper() {
//	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//	       	    Map results = new HashMap();
//	       	    String deptname = rs.getString(2);
//		        results.put("deptname", deptname);
//		        String sumzl = rs.getString(11);
//		        results.put("sumzl", sumzl);
//			     return results;
//	           }
//	           
//	       });
//	
//	}
	public Object getXML(String sql){
		//Map results = sproc.execute(sjcode,fjcode,pcscode,lkType,ntime,deptLevel, deptid, parentid);
		   //使用 Object execute(String callString, CallableStatementCallback action)接口
		 return getJdbcTemplate().execute(sql,new CallableStatementCallback(){
		    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		    	cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
		        cs.execute();
		        ResultSet rst =(ResultSet)cs.getObject(1);
		        ArrayList list = new ArrayList();
		        while (rst.next()) {
		        	Map results = new HashMap();
	                for (int j = 1; j <= rst.getMetaData().getColumnCount(); j++) {
	                    String key = rst.getMetaData().getColumnName(j)
	                            .toLowerCase();
	                    String value = rst.getString(j);	                   
	                    if (value == null) {
	                        // 为空则加入空字符串z
	                        value = "";
	                    }
	                    results.put(key, value);
	                }
	                list.add(results);
	            }
		        rst.close();
				return list;
		    } 
		   });
	
	}
	
	

}
