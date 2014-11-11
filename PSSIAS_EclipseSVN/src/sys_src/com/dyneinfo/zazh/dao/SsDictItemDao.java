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
public class SsDictItemDao extends BaseSpringJdbcDao<SsDictItem,java.lang.String>{
	
	public Class getEntityClass() {
		return SsDictItem.class;
	}
	
	public String getIdentifierPropertyName() {
		return "dicttypeid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DICTTYPEID as dicttypeid,"
				+" DICTID as dictid,"
				+" DICTNAME as dictname,"
				+" STATUS as status,"
				+" SORTNO as sortno,"
				+" DICTLEVEL as dictlevel,"
				+" PARENTID as parentid,"
				+" SEQNO as seqno"
				+" from SS_DICT_ITEM ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_DICT_ITEM where DICTTYPEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DICTTYPEID=? ";
	}
	
	public void save(SsDictItem entity) {
		String sql = "insert into SS_DICT_ITEM " 
			 + " (DICTTYPEID,DICTID,DICTNAME,STATUS,SORTNO,DICTLEVEL,PARENTID,SEQNO) " 
			 + " values "
			 + " (:dicttypeid,:dictid,:dictname,:status,:sortno,:dictlevel,:parentid,:seqno)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_SS_DICT_ITEM",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsDictItem entity) {
		String sql = "update SS_DICT_ITEM set "
					+ " DICTNAME=:dictname,STATUS=:status,SORTNO=:sortno,DICTLEVEL=:dictlevel,PARENTID=:parentid,SEQNO=:seqno "
					+ " where DICTTYPEID=:dicttypeid and DICTID=:dictid";
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
		        + "/~ and t.DICTTYPEID = '[dicttypeid]' ~/"
				+ "/~ and t.DICTID like '%[dictid]%' ~/"
				+ "/~ and t.DICTNAME like '%[dictname]%' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.SORTNO = '[sortno]' ~/"
				+ "/~ and t.DICTLEVEL = '[dictlevel]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ and t.SEQNO = '[seqno]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public void removeRecorderById(String  dicttypeid) {
		String sql = " delete from  SS_DICT_ITEM  where DICTTYPEID =:dicttypeid  ";
		Map namedParameters = new HashMap();
		namedParameters.put("dicttypeid", dicttypeid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	
	public SsDictItem getFindById(String DICTTYPEID,String DICTID) {
		String sql = getSelectPrefix() + " where DICTTYPEID=? and DICTID = ? ";
		SsDictItem dictItem = null;
		try {
			dictItem = (SsDictItem) getSimpleJdbcTemplate().queryForObject(
					sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(getEntityClass()),  new Object[] {DICTTYPEID,DICTID});
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return dictItem;
	}
	

	public void removeRecorderById(String dicttypeid, String dictid) {
		String sql = " delete from  SS_DICT_ITEM  where DICTTYPEID =:dicttypeid and DICTID  =:dictid ";
		Map namedParameters = new HashMap();
		namedParameters.put("dicttypeid", dicttypeid);
		namedParameters.put("dictid", dictid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	

}
