/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
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
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Component
public class SsDeptDao extends BaseSpringJdbcDao<SsDept,java.lang.String>{
	
	public Class getEntityClass() {
		return SsDept.class;
	}
	
	public String getIdentifierPropertyName() {
		return "deptid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DEPTID as deptid,"
				+" DEPTNAME as deptname,"
				+" DEPTDESC as deptdesc,"
				+" DEPTCODE as deptcode,"
				+" DEPTSEQ as deptseq,"
				+" DISPLAYORDER as displayorder,"
				+" PARENTID as parentid,"
				+" DEPTLEVEL as deptlevel,"
				+" DEPTTYPEID as depttypeid,"
				+" STATUS as status"
				+" from SS_DEPT ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_DEPT where DEPTID=?";
	}
	
	
	public void updateSrcDept(SsDept entity) {
		String sql = "update SS_DEPT set "
			+ "DEPTSEQ=:deptseq,DISPLAYORDER=:displayorder,PARENTID=:parentid,DEPTLEVEL=:deptlevel,SERVICESTARTDATE=:servicestartdate,SERVICEENDDATE=:serviceenddate,SERVICEDAYS=:servicedays,SERVICEINFO=:serviceinfo"
			+ " where DEPTID=:deptid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DEPTID=? ";
	}
	
	public void save(SsDept entity) {
		String sql = "insert into SS_DEPT " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " (:deptid,:deptname,:deptdesc,:deptcode,:deptseq,:displayorder,:parentid,:deptlevel,:depttypeid,:status)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_SS_DEPT",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	
	
	public void insertRoot(SsDept entity) {
		String sql = "insert into SS_DEPT " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " (:deptid,:deptname,:deptdesc,:deptcode,:deptseq,:displayorder,:parentid,:deptlevel,:depttypeid,:status)";
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_SS_DEPT",sql); //oracle sequence: 
		insertWithAssigned(entity,sql); //手工分配
		
	}
	
	
	public void saveWithAssigned(SsDept entity) {
		String sql = "insert into SS_DEPT " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " (:deptid,:deptname,:deptdesc,:deptcode,:deptseq,:displayorder,:parentid,:deptlevel,:depttypeid,:status)";
		insertWithAssigned(entity,sql); //手工分配
	}
	
	
	

	
	
	public void update(SsDept entity) {
		String sql = "update SS_DEPT set "
			+ " DEPTNAME=:deptname,DEPTDESC=:deptdesc,DEPTCODE=:deptcode,DEPTSEQ=:deptseq,DISPLAYORDER=:displayorder,PARENTID=:parentid,DEPTLEVEL=:deptlevel,DEPTTYPEID=:depttypeid,STATUS=:status "
			+ " where DEPTID=:deptid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void updateRoot(SsDept entity) {
		String sql = "update SS_DEPT set "
					+ " DEPTID=:deptid,DEPTNAME=:deptname,DEPTDESC=:deptdesc "
					+ " where DEPTID=:deptid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	
	public void updateSEQ(SsDept entity) {
		String sql = "update SS_DEPT set "
					+ " DEPTSEQ=:deptseq "
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
				+ "/~ and t.DEPTDESC = '[deptdesc]' ~/"
				+ "/~ and t.DEPTCODE = '[deptcode]' ~/"
				+ "/~ and t.DEPTSEQ like '%[deptseq]%' ~/"
				+ "/~ and t.DISPLAYORDER = '[displayorder]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public List<SsDept> findRootTree(String deptTypeId) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" DEPTID as deptid,"
			+" DEPTNAME as deptname,"
			+" DEPTDESC as deptdesc,"
			+" PARENTID as parentid,"
			+" DEPTSEQ as deptseq,"
			+" DEPTLEVEL as deptlevel"
			+" from SS_DEPT  where PARENTID is null   ";
		if (deptTypeId != null && !deptTypeId.equals(""))
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " and DEPTTYPEID in (" + deptTypeId + ") order by DEPTLEVEL,displayorder ";
		else {
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " order by DEPTLEVEL,displayorder ";
		}
		
		List listSsDept = getJdbcTemplate().query(SELECT_PREFIX_PRE,new ItemMapper());
		return listSsDept;
	}
	
	
	public List<SsDept> findByDeptId(String deptid,String deptTypeId) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" DEPTID as deptid,"
			+" DEPTNAME as deptname,"
			+" DEPTDESC as deptdesc,"
			+" PARENTID as parentid,"
			+" DEPTSEQ as deptseq,"
			+" DEPTLEVEL as deptlevel"
			+" from SS_DEPT  where DEPTID = ?   ";
		if (deptTypeId != null && !deptTypeId.equals(""))
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " and DEPTTYPEID in (" + deptTypeId + ") order by DEPTLEVEL,displayorder ";
		else {
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " order by DEPTLEVEL,displayorder ";
		}
		Object[] params = new Object[] { deptid };
		int[] types = new int[] { Types.BIGINT };
		List listSsDept = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, 
				new ItemMapper());
		return listSsDept;
	}
	
	public List<SsDept> findByParentId(String deptid,String deptTypeId) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" DEPTID as deptid,"
			+" DEPTNAME as deptname,"
			+" DEPTDESC as deptdesc,"
			+" PARENTID as parentid,"
			+" DEPTSEQ as deptseq,"
			+" DEPTLEVEL as deptlevel"
			+" from SS_DEPT  where parentid = '"+deptid+"'   ";
		if (deptTypeId != null && !deptTypeId.equals(""))
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " and DEPTTYPEID in (" + deptTypeId + ") order by DEPTLEVEL,displayorder ";
		else {
			SELECT_PREFIX_PRE = SELECT_PREFIX_PRE + " order by DEPTLEVEL,displayorder ";
		}
		Object[] params = new Object[] { deptid };
		
		List listSsDept = getJdbcTemplate().query(SELECT_PREFIX_PRE,  new ItemMapper());
		return listSsDept;
	}
	
	



	
	
	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsDept ssDept = new SsDept();
			ssDept.setDeptid(rs.getString(1));
			ssDept.setDeptname(rs.getString(2));
			ssDept.setDeptdesc(rs.getString(3));
			ssDept.setParentid(rs.getString(4));
			ssDept.setDeptseq(rs.getString(5));
			ssDept.setDeptlevel(rs.getInt(6));
			
			return ssDept;

		}
	}
	
	
	//	检查部门是否存在用户
	public int getCountDeptUser(String deptid) {
		String sql = "select count(userID) from ss_user  where deptid=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {deptid} );  	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	//查找所有拥有下级部门的的部门ID
	public List getExistChildDept() {
		String sql = " SELECT parentid FROM SS_dept WHERE parentid is not null  Group By parentId Order By parentId ";
		
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String parentId = rs.getString(1);   
			        results.put("parentId", parentId);
			        return results;
	           }
	           
	       });
	   }
	
	
	//查找所选中部门的父节点
	public List getDeptCheckbox(String sql) {
		 return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String deptseq = rs.getString(1);   
			        results.put("deptseq", deptseq);
			        return results;
	           }
	           
	       });
	   }
	

	
	//	检查部门是否存在用户
	public int getCountChildDept(String deptid) {
		String sql = "select count(deptid)  FROM SS_dept WHERE parentid = ?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {deptid} );  	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public void deleteTcpinfo(String arg) {
		getJdbcTemplate().update(" delete from T_CPINFO where CPCODE=? ", new Object[] { arg });
	}
	
	
	public List<SsDept> getTagTree(String sql,String orgSeq) { 
	//	String sql = "select DEPTID, DEPTNAME, DEPTSEQ from SS_DEPT where DEPTSEQ like ?";
		 return getJdbcTemplate().query(sql, new Object[] {orgSeq}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String DEPTID = rs.getString(1); 
	        	    String DEPTNAME = rs.getString(2);  
	        	    String DEPTSEQ = rs.getString(3);  
			        results.put("DEPTID", DEPTID);
			        results.put("DEPTNAME", DEPTNAME);
			        results.put("DEPTSEQ", DEPTSEQ);
			        return results;
	           }
	           
	       });
	}

	public SsDept getById(String deptId){
		List list = getSimpleJdbcTemplate().query(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), deptId);
		System.out.println("-------"+getFindByIdSql());
		return (SsDept)CollectionHelper.findSingleObject(list);
	}
	public SsDept getDeptseq(String deptId){
		String sql = getSelectPrefix()+" where deptseq = ? ";
		List list = getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), deptId);
		return (SsDept)CollectionHelper.findSingleObject(list);
	}
}
