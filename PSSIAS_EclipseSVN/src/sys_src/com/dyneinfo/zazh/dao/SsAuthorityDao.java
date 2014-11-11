/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class SsAuthorityDao extends BaseSpringJdbcDao<SsAuthority,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsAuthority.class;
	}
	
	public String getIdentifierPropertyName() {
		return "authorityid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" AUTHORITYID as authorityid,"
				+" AUTHORITYNAME as authorityname,"
				+" AUTHORITYDESC as authoritydesc,"
				+" AUTHORITYTYPE as authoritytype,"
				+" AUTHORITYVALUE as authorityvalue"
				+" from SS_AUTHORITY ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_AUTHORITY where AUTHORITYID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where AUTHORITYID=? ";
	}
	
	public void save(SsAuthority entity) {
		String sql = "insert into SS_AUTHORITY " 
			 + " (AUTHORITYID,AUTHORITYNAME,AUTHORITYDESC,AUTHORITYTYPE,AUTHORITYVALUE) " 
			 + " values "
			 + " (:authorityid,:authorityname,:authoritydesc,:authoritytype,:authorityvalue)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_AUTHORITY",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsAuthority entity) {
		String sql = "update SS_AUTHORITY set "
					+ " AUTHORITYID=:authorityid,AUTHORITYNAME=:authorityname,AUTHORITYDESC=:authoritydesc,AUTHORITYTYPE=:authoritytype,AUTHORITYVALUE=:authorityvalue "
					+ " where AUTHORITYID=:authorityid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	

	
	public List findAllByRoleID(Long roleID) {
		String sql = getSelectPrefix()  + "  where AUTHORITYID in (select AUTHORITYID from SS_ROLE_AUTHORITY where roleid = ?) ";
		
		System.out.println(  " sql" + sql+roleID);
		Object[] params = new Object[] { roleID };
		int[] types = new int[] { Types.BIGINT };
		List listUserRole = getJdbcTemplate().query(sql, params, types,
				new ItemMapper());
		return listUserRole;
	}

	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsAuthority ssAuthority = new SsAuthority();
			ssAuthority.setAuthorityid(rs.getLong(1));
			ssAuthority.setAuthorityname(rs.getString(2));
			
			return ssAuthority;

		}
	}
	


	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.AUTHORITYNAME = '[authorityname]' ~/"
				+ "/~ and t.AUTHORITYDESC = '[authoritydesc]' ~/"
				+ "/~ and t.AUTHORITYTYPE = '[authoritytype]' ~/"
				+ "/~ and t.AUTHORITYVALUE = '[authorityvalue]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public void removeroleAuthority(long authorityid) {

		String sql = " delete from  ss_role_authority  where AUTHORITYID =:authorityid  ";

		Map namedParameters = new HashMap();

		namedParameters.put("authorityid", authorityid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	

}
