/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class SsDictTypeDao extends BaseSpringJdbcDao<SsDictType,java.lang.String>{
	
	public Class getEntityClass() {
		return SsDictType.class;
	}
	
	public String getIdentifierPropertyName() {
		return "dicttypeid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DICTTYPEID as dicttypeid,"
				+" DICTTYPENAME as dicttypename,"
				+" DICTLEVEL as dictlevel,"
				+" PARENTID as parentid,"
				+" SEQNO as seqno,"
				+" DICTFLAG as dictflag,"
				+" QUERYSQL as querysql"
				+" from SS_DICT_TYPE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_DICT_TYPE where DICTTYPEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DICTTYPEID=? ";
	}
	
	public void save(SsDictType entity) {
		String sql = "insert into SS_DICT_TYPE " 
			 + " (DICTTYPEID,DICTTYPENAME,DICTLEVEL,PARENTID,SEQNO,DICTFLAG,QUERYSQL) " 
			 + " values "
			 + " (:dicttypeid,:dicttypename,:dictlevel,:parentid,:seqno,:dictflag,:querysql)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_SS_DICT_TYPE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsDictType entity) {
		String sql = "update SS_DICT_TYPE set "
					+ " DICTTYPEID=:dicttypeid,DICTTYPENAME=:dicttypename,DICTLEVEL=:dictlevel,PARENTID=:parentid,SEQNO=:seqno,DICTFLAG=:dictflag,QUERYSQL=:querysql "
					+ " where DICTTYPEID=:dicttypeid";
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
		        + "/~ and t.DICTTYPEID like '%[dicttypeid]%' ~/"
				+ "/~ and t.DICTTYPENAME like '%[dicttypename]%' ~/"
				+ "/~ and t.DICTLEVEL = '[dictlevel]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ and t.SEQNO = '[seqno]' ~/"
				+ "/~ and t.DICTFLAG = '[dictflag]' ~/"
				+ "/~ and t.QUERYSQL like '%[querysql]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	//	检查表存在字典代码与否
	public int getFindCountById(String dicttypeid) {
		String sql = "select count(DICTTYPEID) from SS_DICT_TYPE  where DICTTYPEID=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {dicttypeid} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	

}
