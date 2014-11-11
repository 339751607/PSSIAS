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
import com.dyneinfo.zazh.dao.SsDeptDao.ItemMapper;
import com.dyneinfo.zazh.dao.SsMenuDao.treeItemMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Component
public class SsRoleDao extends BaseSpringJdbcDao<SsRole,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsRole.class;
	}
	
	public String getIdentifierPropertyName() {
		return "roleid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ROLEID as roleid,"
				+" ROLENAME as rolename,"
				+" ROLEDESC as roledesc,"
				+" ROLESEQ as roleseq,"
				+" PARENTID as parentid,"
				+" ROLELEVEL as rolelevel,"
				+" BUSINESSCODE as businesscode "
				+" from SS_ROLE ";
	}
	
	private String sqlRoleType = "  select  code as roleid, " 
		                       + "  called as rolename, " 
		                       + "  called as roledesc, "
		                       + "  '1' as parentid,  " 
		                       + "  code as roleseq, "  
	                           + "  2 as rolelevel, "
	                           + "  '1' as businesscode "
	                           + "  from SS_DATASOURCE where  isvalid = '1'  " ;
	
	private String sqlRoleElement = "select  "
		+" to_char(ROLEID) as roleid,"
		+" ROLENAME as rolename,"
		+" ROLEDESC as roledesc,"
		+" ROLESEQ as roleseq,"
		+" to_char(PARENTID) as parentid,"
		+" ROLELEVEL as rolelevel,"
		+" BUSINESSCODE as businesscode "
		+" from SS_ROLE ";

	private String sqlAllRoles = "select  "
		+" roleid, "
		+" rolename, "
		+" roledesc, "
		+" roleseq, "
		+" parentid, "
		+" rolelevel, "
		+" businesscode from ( "
		+ sqlRoleType 
	    + " Union "
	    + sqlRoleElement + " ) " ;
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_ROLE where ROLEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ROLEID=? ";
	}
	
	public void save(SsRole entity) {
		String sql = "insert into SS_ROLE " 
			 + " (ROLEID,ROLENAME,ROLEDESC,ROLESEQ,PARENTID,ROLELEVEL,BUSINESSCODE) " 
			 + " values "
			 + " (:roleid,:rolename,:roledesc,:roleseq,:parentid,:rolelevel,:businesscode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_ROLE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsRole entity) {
		String sql = "update SS_ROLE set "
					+ " ROLEID=:roleid,ROLENAME=:rolename,ROLEDESC=:roledesc,ROLESEQ=:roleseq,PARENTID=:parentid,ROLELEVEL=:rolelevel "
					+ " where ROLEID=:roleid";
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
				+ "/~ and t.ROLENAME = '[rolename]' ~/"
				+ "/~ and t.ROLEDESC = '[roledesc]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ and t.ROLELEVEL = '[rolelevel]' ~/"
				+ "/~ and t.ROLESEQ like '[roleSEQ]%' ~/"
				+ "/~ and t.BUSINESSCODE = '[businesscode]' ~/";

		return pageQuery(sql+" order by t.ROLEID ",pageRequest);
	}
	
	
	//	检查表权限角色存在与否
	public int getCountRoleName(String ROLENAME, String parentId) {
		String sql = "select count(roleid) from SS_ROLE  where ROLENAME=? and PARENTID=? ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { ROLENAME, parentId });
		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	public int getCountRoleUser(long roleid ) {
		String sql = "select count(USERID) from SS_ROLE_USER  where ROLEID=? ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {roleid} );  
			
			 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public int getCountRole(long roleid ) {
		String sql = "select count(ROLEID) from SS_ROLE  where PARENTID=? ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {roleid} );  
			
			 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	//	检查表权限角色存在与否
	public int getCountRoleAuthority(long roleid ,long authid) {
		String sql = "select count(roleid) from SS_ROLE_AUTHORITY  where ROLEID=? and AUTHORITYID=? ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {roleid,authid} );  
			
			 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public void insertRoleAuthority(long roleid ,long authid) {
		String sql = "INSERT INTO SS_ROLE_AUTHORITY (ROLEID,AUTHORITYID) VALUES(:roleid, :authid)";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		namedParameters.put("authid", authid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void removeroleAuthority(long roleid ,long authid) {
		
		
		String sql = " delete from  SS_ROLE_AUTHORITY  where ROLEID =:roleid and AUTHORITYID  =:authid ";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);
		
		namedParameters.put("authid", authid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void removeroleAuthority(long roleid) {

		String sql = " delete from  SS_ROLE_AUTHORITY  where ROLEID =:roleid  ";

		Map namedParameters = new HashMap();
		namedParameters.put("roleid", roleid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	
	
	
	
	
	

	//	检查表权限角色存在与否
	public int getCountRoleMenu(long roleid, long menuid) {
		String sql = "select count(roleid) from SS_ROLE_MENU  where ROLEID=? and MENUID=? ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { roleid, menuid });
		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	public void insertRoleMenu(long roleid, long menuid) {
		String sql = "INSERT INTO SS_ROLE_MENU (ROLEID,MENUID) VALUES(:roleid, :menuid)";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		namedParameters.put("menuid", menuid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	public void removeroleMenu(long roleid) {

		String sql = " delete from  SS_ROLE_MENU  where ROLEID =:roleid  ";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	public void removeroleMenu(long roleid, String menuidStr) {

		String sql = " delete from  SS_ROLE_MENU  where ROLEID =:roleid and MENUID  In (:menuidStr) ";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		namedParameters.put("menuidStr", menuidStr);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	
	public void removeroleUser(long roleid) {

		String sql = " delete from  ss_role_user  where ROLEID =:roleid  ";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	//查找所有拥有下级部门的的部门ID
	public List getExistChildDept() {
		String sql = " SELECT parentid FROM SS_ROLE WHERE parentid is not null  Group By parentId Order By parentId ";
		
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String parentId = rs.getString(1);   
			        results.put("parentId", parentId);
			        return results;
	           }
	           
	       });
	   }
	
	public void updateSEQ(SsRole entity) {
		String sql = "update SS_ROLE set "
					+ " ROLESEQ=:roleseq "
					+ " where ROLEID=:roleid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
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
public List<SsRole> findRootTree() {
		String SELECT_PREFIX_PRE = "select  "
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" PARENTID as parentid,"
			+" ROLESEQ as roleseq,"
			+" ROLELEVEL as rolelevel"
			+" from SS_ROLE  where PARENTID = 0   ";
		List listSsDept = getJdbcTemplate().query(SELECT_PREFIX_PRE,new ItemMapper());
		return listSsDept;
	}
	
	
	public List<SsRole> findByUserId(Long userId) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" PARENTID as parentid,"
			+" ROLESEQ as roleseq,"
			+" ROLELEVEL as rolelevel"
			+" from SS_ROLE  where ROLEID in (select roleid from SS_ROLE_USER where userid = ? )  order by rolelevel";

		Object[] params = new Object[] { userId };
		int[] types = new int[] { Types.BIGINT };
		List listSsDept = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
				new ItemMapper());
		return listSsDept;
	}
	
	public List<SsRole> findByParentId(Long ParentId) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" PARENTID as parentid,"
			+" ROLESEQ as roleseq,"
			+" BUSINESSCODE as businesscode, "
			+" ROLELEVEL as rolelevel"
			+" from SS_ROLE  where parentid = " + ParentId;

		Object[] params = new Object[] { ParentId };
		int[] types = new int[] { Types.BIGINT };
		List listSsRole = getJdbcTemplate().query(SELECT_PREFIX_PRE, new ItemMapper());
		return listSsRole;
	}
	
	public List<SsRole> findByRoleType() {
		
		String SELECT_PREFIX_PRE = "select  "
			+" code as roleid,"
			+" called as rolename,"
			+" called as roledesc,"
			+" code as parentid,"
			+" code as roleseq,"
			+" code as businesscode, "
			+" '2' as rolelevel"
			+" from SS_DATASOURCE where  isvalid = '1' order by roleseq " ;

		List listSsRole = getJdbcTemplate().query(SELECT_PREFIX_PRE, new ItemMapper());
		return listSsRole;
	}
	public List<SsRole> findCheckboxTreeByParentId(Long menuid) {
			
			String SELECT_PREFIX_PRE = "select  "
				+" MENUID as menuid,"
				+" MENUNAME as menuname,"
				+" MENUDESC as menudesc,"
				+" MENULABEL as menulabel,"
				+" ISLEAF as isleaf,"
				+" MENUURL as menuurl,"
				+" MENULEVEL as menulevel,"
				+" PARENTID as parentid,"
				+" IMAGEPATH as imagepath,  "
				+" DISPLAYORDER as displayorder "
				+" from SS_MENU  where PARENTID = ?  order by menulevel, displayorder ";
			Object[] params = new Object[] { menuid };
			int[] types = new int[] { Types.BIGINT };
			List listMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
					new treeItemMapper());
			return listMenu;
		}
	
	protected class treeItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			String isLeaf = rs.getString(5);
			boolean allowChildren = false;
			if(isLeaf != null && isLeaf.toLowerCase().equals("y")){
				allowChildren = false;
			} else if(isLeaf != null && isLeaf.toLowerCase().equals("n")){
				allowChildren = true;
			}
			SsRole menu = new SsRole();
//			menu.setId(rs.getLong(1));
//			menu.setName(rs.getString(2));
//			menu.setDescn(rs.getString(3));
//			menu.setParentId(rs.getLong(8));
//			menu.setQtip(rs.getString(4));
//			menu.setTheSort(rs.getInt(10));
//			menu.setAllowChildren(allowChildren);
//			menu.setIconCls("");
		
			
			return menu;

		}
	}
	
	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsRole ssRole = new SsRole();
			System.out.println("+++++" + rs.getLong("roleid"));
			ssRole.setRoleid(rs.getLong("roleid"));
			
			ssRole.setRolename(rs.getString("rolename"));
			ssRole.setRoledesc(rs.getString("roledesc"));
			ssRole.setParentid(rs.getLong("parentid"));
			ssRole.setRoleseq(rs.getString("roleseq"));
			ssRole.setRolelevel(rs.getLong("rolelevel"));
			ssRole.setBusinesscode(rs.getString("businesscode"));
			ssRole.setStrRoleid(rs.getString("roleid"));
			return ssRole;

		}
	}

	public List<SsRole> getByRoles(String businessCode) {
		String sql = getSelectPrefix() 
		           + " WHERE  BUSINESSCODE = '" + businessCode + "' "
                   + " ORDER  BY ROLENAME ";
		List listRole = getJdbcTemplate().query(sql, new ItemMapper());
		return listRole;
	}
	public Number getChildRoleCount(String parentId) {
		String sql = " select count(*) from SS_ROLE WHERE  businesscode = '" + parentId + "' ";
		Number count = getJdbcTemplate().queryForInt(sql);
		return count;
	}
	
	public List<SsRole> getRolesByParentId(String parentId) {
		String sql = sqlAllRoles 
		           + " WHERE  businesscode = '" + parentId + "' " 
                   + " ORDER  BY roleid ";
		List listRole = getJdbcTemplate().query(sql, new ItemMapper());
		return listRole;
	}
	
	
	public List<SsRole> getRoleGroupBygroupID(String groupid) {
		String sql = getSelectPrefix() 
		           + " WHERE  ROLEID IN  (SELECT ROLEID from SS_ROLE_GROUP where GROUPID =" + groupid +" ) ";

		List listSsRole = getJdbcTemplate().query(sql, new ItemMapper() );
		return listSsRole;
	}
	//叶子节点
	public List<SsRole> getLeafRoleByGroupId(String groupid) {
		String sql = sqlAllRoles + " WHERE ROLELEVEL = 3  AND  ROLEID IN  (SELECT ROLEID from SS_ROLE_GROUP where GROUPID = "+groupid+"  ) " 
		           + " order by ROLELEVEL " ;
		List listSsRole = getJdbcTemplate().query(sql, new ItemMapper() );
		return listSsRole;
	}
	
	//非叶子节点
	public List<SsRole> getNotleafRoleByGroupId(String groupid) {
		String sql = sqlAllRoles + " WHERE ROLELEVEL <> 3  AND  ROLEID IN  (SELECT ROLEID from SS_ROLE_GROUP where GROUPID = "+groupid+"  ) " 
		+ " order by ROLELEVEL" ;
		List listSsRole = getJdbcTemplate().query(sql, new ItemMapper() );
		return listSsRole;
	}
	//所有的叶子节点
	public List<SsRole> getRoleByGroupId(String groupid) {
		String sql =  sqlAllRoles + " WHERE  ROLEID IN  (SELECT ROLEID from SS_ROLE_GROUP where GROUPID = "+groupid+"  ) " 
		+ " order by ROLELEVEL" ;
		List listSsRole = getJdbcTemplate().query(sql, new ItemMapper() );
		return listSsRole;
	}
    
}
