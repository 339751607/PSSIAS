/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.dao;

import java.io.Serializable;
import java.util.List;

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
public class SsLogsDao extends BaseSpringJdbcDao<SsLogs,java.math.BigDecimal>{
	
	public Class getEntityClass() {
		return SsLogs.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" XH as xh,"
				+" LOGINNAME as loginname,"
				+" LOGINTIME as logintime,"
				+" IPADDRESS as ipaddress,"
				+" BROWSER as browser,"
				+" HOSTNAME as hostname,"
				+" INVALIDPASSWORD as invalidpassword,"
				+" DEMO as demo"
				+" from SS_LOGS ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_LOGS where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where XH=? ";
	}
	
	public void save(SsLogs entity) {
		String sql = "insert into SS_LOGS " 
			 + " (XH,LOGINNAME,LOGINTIME,IPADDRESS,BROWSER,HOSTNAME,INVALIDPASSWORD,DEMO) " 
			 + " values "
			 + " (:xh,:loginname,:logintime,:ipaddress,:browser,:hostname,:invalidpassword,:demo)";
	//	insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_LOGS",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsLogs entity) {
		String sql = "update SS_LOGS set "
					+ " XH=:xh,LOGINNAME=:loginname,LOGINTIME=:logintime,IPADDRESS=:ipaddress,BROWSER=:browser,HOSTNAME=:hostname,INVALIDPASSWORD=:invalidpassword,DEMO=:demo "
					+ " where XH=:xh";
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
				+ "/~ and t.LOGINNAME like '%[loginname]%' ~/"
				+ "/~ and t.LOGINTIME >= '[s_inTime_start_sql]' ~/"
				+ "/~ and t.LOGINTIME <= '[s_inTime_end_sql]' ~/"
				+ "/~ and t.IPADDRESS like '%[ipaddress]%' ~/"
				+ "/~ and t.BROWSER = '%[browser]%' ~/"
				+ "/~ and t.HOSTNAME like '%[hostname]%' ~/"
				+ "/~ and t.INVALIDPASSWORD = '[invalidpassword]' ~/"
				+ "/~ and t.DEMO like '%[demo]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	

}
