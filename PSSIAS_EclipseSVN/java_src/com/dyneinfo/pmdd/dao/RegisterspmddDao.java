/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class RegisterspmddDao extends BaseSpringJdbcDao<Registers,Long>{
	
	public Class getEntityClass() {
		return Registers.class;
	}
	
	public String getIdentifierPropertyName() {
		return "unitid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CLUSTERGROUP as clustergroup,"
				+" IPADDRESS as ipaddress,"
				+" DATASOURCENAME as datasourcename,"
				+" NOTE as note,"
				+" PACKAGES as packages,"
				+" PORT as port,"
				+" PROTOCOL as protocol,"
				+" REGISTERTIME as registertime,"
				+" UNITID as unitid"
				+" from REGISTERS ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from REGISTERS where UNITID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where UNITID=? ";
	}
	
	public void save(Registers entity) {
		String sql = "insert into REGISTERS " 
			 + " (CLUSTERGROUP,IPADDRESS,DATASOURCENAME,NOTE,PACKAGES,PORT,PROTOCOL,REGISTERTIME,UNITID) " 
			 + " values "
			 + " (:clustergroup,:ipaddress,:datasourcename,:note,:packages,:port,:protocol,:registertime,:unitid)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_REGISTERS",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Registers entity) {
		String sql = "update REGISTERS set "
					+ " CLUSTERGROUP=:clustergroup,IPADDRESS=:ipaddress,DATASOURCENAME=:datasourcename,NOTE=:note,PACKAGES=:packages,PORT=:port,PROTOCOL=:protocol,REGISTERTIME=:registertime,UNITID=:unitid "
					+ " where UNITID=:unitid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		//XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.CLUSTERGROUP = '[clustergroup]' ~/"
				+ "/~ and t.IPADDRESS = '[ipaddress]' ~/"
				+ "/~ and t.DATASOURCENAME = '[datasourcename]' ~/"
				+ "/~ and t.NOTE = '[note]' ~/"
				+ "/~ and t.PACKAGES = '[packages]' ~/"
				+ "/~ and t.PORT = '[port]' ~/"
				+ "/~ and t.PROTOCOL = '[protocol]' ~/"
				+ "/~ and t.REGISTERTIME = '[registertime]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	

}
