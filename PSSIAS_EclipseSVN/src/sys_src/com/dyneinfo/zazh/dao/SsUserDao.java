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
import com.dyneinfo.zazh.dao.SsMenuDao.ItemMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Component
public class SsUserDao extends BaseSpringJdbcDao<SsUser,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsUser.class;
	}
	
	public String getIdentifierPropertyName() {
		return "userid";
	}
	
//已选部门角色
	
	public List<SsRole> findDeptRole(String deptId) {

		String SELECT_PREFIX_PRE = "select  "
				+ " ROLEID as roleid,"
				+ " ROLENAME as rolename,"
				+ " ROLEDESC as roledesc"
				+ " from SS_ROLE   where roleid in (select ROLEID  from SS_DEPT_ROLE where DEPTID = ? )";
		Object[] params = new Object[] { deptId };
		int[] types = new int[] { Types.VARCHAR };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params,
				types, new ItemMapper());
		return listSsMenu;
	}
	
	// 可选角色
	public List<SsRole> findUserNoExistRole(String session_deptId,Long userid) {

		String SELECT_PREFIX_PRE = "select  "
				+ " ROLEID as roleid,"
				+ " ROLENAME as rolename,"
				+ " ROLEDESC as roledesc"
				+ " from SS_ROLE   where " +
						"roleid in ( select ROLEID from SS_DEPT_ROLE  where  DEPTID = ? ) " +
						" and roleid not in (select ROLEID  from SS_ROLE_USER where Userid = ? )";
		
		Object[] params = new Object[] { session_deptId,userid };
		int[] types = new int[] { Types.VARCHAR,Types.BIGINT };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params,
				types, new ItemMapper());
		return listSsMenu;
	}
	
	
	public String getSelectPrefix() {
		return "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" DEPTID as deptid,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_USER where USERNAME != 'admin' and  USERID=?";
	}
	
	
	public void updateByDeptid(String cpcode,String enabled){
		String sql = "update SS_USER set "
			+ " ENABLED= ? "
			+ " where DEPTID=?";
		getSimpleJdbcTemplate().update(sql, new Object[]{enabled,cpcode});
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where USERID=? ";
	}
	
	public void save(SsUser entity) {
		String sql = "insert into SS_USER " 
			 + " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO,CREATEUSERID,DESCRIPTION,EXPIRATIONDATE) " 
			 + " values "
			 + " (:userid,:username,:password,:fullname,:sex,:sfzh,:policeid,:phone,:mobile,:fax,:address,:zip,:emailaddress,:createdate,:deptid,:enabled,:photo,:createuserid,:description,:expirationdate)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_USER",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsUser entity) {
		String sql = "update SS_USER set "
					+ " USERID=:userid,USERNAME=:username,PASSWORD=:password,FULLNAME=:fullname,SEX=:sex,SFZH=:sfzh,POLICEID=:policeid,PHONE=:phone,MOBILE=:mobile,FAX=:fax,ADDRESS=:address,ZIP=:zip,EMAILADDRESS=:emailaddress,CREATEDATE=:createdate,DEPTID=:deptid,ENABLED=:enabled,PHOTO=:photo,CREATEUSERID=:createuserid,DESCRIPTION=:description,EXPIRATIONDATE=:expirationdate "
					+ " where USERID=:userid";
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
				+ "/~ and t.USERNAME = '[username]' ~/"
				+ "/~ and t.PASSWORD = '[password]' ~/"
				+ "/~ and t.FULLNAME = '[fullname]' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.SFZH = '[sfzh]' ~/"
				+ "/~ and t.POLICEID = '[policeid]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.MOBILE = '[mobile]' ~/"
				+ "/~ and t.FAX = '[fax]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.ZIP = '[zip]' ~/"
				+ "/~ and t.EMAILADDRESS = '[emailaddress]' ~/"
				+ "/~ and t.CREATEDATE = '[createdate]' ~/"
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and t.ENABLED = '[enabled]' ~/"
				+ "/~ and t.PHOTO = '[photo]' ~/"
				+ "/~ and t.EXPIRATIONDATE = '[expirationdate]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public Page findUserByDeptSeqRequest(PageRequest<Map> pageRequest) {
		
		  String SelectPrefix = "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" t.DEPTID as deptid,"
				+" d.DEPTNAME as deptname,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER t ,ss_dept d ";

			String sql = SelectPrefix + "  where d.DEPTID(+)  = t.deptid "
					+ "/~ and t.USERNAME like '%[username]%' ~/"
					+ "/~ and t.FULLNAME like '%[fullname]%' ~/"
					+ "/~ and t.PASSWORD = '[password]' ~/"
					+ "/~ and t.SFZH = '[sfzh]' ~/"
					+ "/~ and d.DEPTSEQ like '[deptSEQ]%' ~/"
					+ "/~ and d.DEPTID = '[deptid]' ~/"
					+ "/~ and t.POLICEID = '[policeid]' ~/"
					+ "/~ and t.EMAILADDRESS = '[emailaddress]' ~/"
					+ "/~ and t.ENABLED = '[enabled]' ~/"
					+ "/~ and t.CREATEDATE = '[createdate]' ~/"
					+"/~ and createuserid = '[createuserid]' ~/"
					+ "/~ and t.EXPIRATIONDATE = '[expirationdate]' ~/"
					+ "/~ order by [sortColumns] ~/";
			return pageQuery(sql,pageRequest);
		}
	
	public Page findUserByDeptSeqRequestTwo(PageRequest<Map> pageRequest) {
		
		  String SelectPrefix = "select  "
				+" t.USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" t.DEPTID as deptid,"
				+" d.DEPTNAME as deptname,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER t ,ss_dept d  ";
		  
			String sql = SelectPrefix + "  where d.DEPTID(+)  = t.deptid "
					+ "/~ and d.deptseq like '%[deptid]%' ~/"
					//+ "/~ and t.deptid <> '[deptid]'  ~/"
					+ "/~ and USERNAME like '%[username]%' ~/"
					+ "/~ and FULLNAME like '%[fullname]%' ~/"
					+ "/~ order by [sortColumns] ~/";
			return pageQuery(sql,pageRequest);
		}
	
	public Page findUserByCreateuseridRequest(PageRequest<Map> pageRequest){
		  String sql = "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER where 1=1 " 
				+"/~ and createuserid = '[createuserid]' ~/"
				+ "/~ and USERNAME like '%[username]%' ~/"
				+ "/~ and FULLNAME like '%[fullname]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		
		return pageQuery(sql,pageRequest);
	}
	
	public Page findUserByDeptRequest4Hotel(PageRequest<Map> pageRequest) {
		
		  String SelectPrefix = "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" t.DEPTID as deptid,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER t ,v_deparment d ";

			String sql = SelectPrefix + "  where d.DEPID(+)  = t.deptid "
					+ "/~ and t.USERNAME like '%[username]%' ~/"
					+ "/~ and t.FULLNAME like '%[fullname]%' ~/"
					+ "/~ and t.PASSWORD = '[password]' ~/"
					+ "/~ and t.SFZH = '[sfzh]' ~/"
					+ "/~ and d.DEPID like '[deptSEQ]%' ~/"
					+ "/~ and t.POLICEID = '[policeid]' ~/"
					+ "/~ and t.EMAILADDRESS = '[emailaddress]' ~/"
					+ "/~ and t.ENABLED = '[enabled]' ~/"
					+ "/~ and t.CREATEDATE = '[createdate]' ~/"
					+ "/~ order by [sortColumns] ~/";
			return pageQuery(sql,pageRequest);
		}
	
	
	public Page findUserByRoleRequest(PageRequest<Map> pageRequest) {
		
		  String SelectPrefix = "select  "
				+" USERID as userid,"
				+" USERNAME as username,"
				+" PASSWORD as password,"
				+" FULLNAME as fullname,"
				+" SEX as sex,"
				+" SFZH as sfzh,"
				+" POLICEID as policeid,"
				+" PHONE as phone,"
				+" MOBILE as mobile,"
				+" FAX as fax,"
				+" ADDRESS as address,"
				+" ZIP as zip,"
				+" EMAILADDRESS as emailaddress,"
				+" CREATEDATE as createdate,"
				+" DEPTID as deptid,"
				+" ENABLED as enabled,"
				+" PHOTO as photo, "
				+" CREATEUSERID as createuserid, "
				+" DESCRIPTION as description, "
				+" EXPIRATIONDATE as expirationdate"
				+" from SS_USER  t ,ss_role b ";

			String sql = SelectPrefix + "  where t.userid = b.userid "
					+ "/~ and b.roleid = '[roleid]' ~/"
					+ "/~ order by [sortColumns] ~/";
			return pageQuery(sql,pageRequest);
		}
	
	
	
	public int getCountUserName(String username) {
		String sql = "select count(USERID) from SS_USER  where USERNAME=?  ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { username });

		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	
//	检查表权限角色存在与否
	public int getCountRoleUser(long roleid, long userid) {
		String sql = "select count(roleid) from SS_ROLE_USER  where ROLEID=? and USERID=? ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { roleid, userid });

		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	public void insertRoleUser(long roleid, long userid) {
		String sql = "INSERT INTO SS_ROLE_USER (ROLEID,USERID) VALUES(:roleid, :userid)";

		Map namedParameters = new HashMap();

		namedParameters.put("roleid", roleid);

		namedParameters.put("userid", userid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	public void insertGroupUser(long groupid, long userid) {
		String sql = "INSERT INTO SS_GROUP_USER (GROUPID,USERID) VALUES(:groupid, :userid)";

		Map namedParameters = new HashMap();

		namedParameters.put("groupid", groupid);

		namedParameters.put("userid", userid);

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	public void removeroleUser(java.lang.Long userid) {

//		String sql = " delete from  SS_ROLE_USER  where USERID =:userid  ";
//		
//		Map namedParameters = new HashMap();
//		namedParameters.put("userid", userid);
//		getNamedParameterJdbcTemplate().update(sql, namedParameters);

		
		getJdbcTemplate().update("delete from  SS_ROLE_USER  where USERID = ?", new Object[] {userid});
		
	
	}
	public void removeGroupUser(java.lang.Long userid) {

//		String sql = " delete from  SS_ROLE_USER  where USERID =:userid  ";
//		
//		Map namedParameters = new HashMap();
//		namedParameters.put("userid", userid);
//		getNamedParameterJdbcTemplate().update(sql, namedParameters);

		
		getJdbcTemplate().update("delete from  SS_GROUP_USER  where USERID = ?", new Object[] {userid});
		
	
	}
	
	//editpasswrodUser
	
	public void editpasswrodUser(java.lang.Long userid) {		
		getJdbcTemplate().update("update  SS_USER set password ='e10adc3949ba59abbe56e057f20f883e'   where USERID = ?", new Object[] {userid});
	}
	
	
	//已选角色
	
	public List<SsRole> findUserRole(Long userid) {
		
		String SELECT_PREFIX_PRE ="select  "
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" ROLESEQ as roleseq,"
			+" ROLELEVEL as rolelevel"
			+" from SS_ROLE   where roleid in (select ROLEID  from SS_ROLE_USER where Userid = ? )";
		Object[] params = new Object[] { userid };
		int[] types = new int[] { Types.BIGINT };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
				new ItemMapper());
		return listSsMenu;
	}
	
	//可选角色
public List<SsRole> findUserNoExistRole(Long sessionUserId ,Long userId) {
	
		List<SsRole> rolelist=findRoleParentidByUserID(sessionUserId);

		StringBuffer parentidSel=new StringBuffer("");
		if(!rolelist.isEmpty()){
			if(rolelist.size()>1){
				/*
				parentidSel.append("  and   parentid in (");
				for(int i=0;i<rolelist.size();i++){
					SsRole role=rolelist.get(i);
					parentidSel.append(role.getRoleid());
					if(i!=rolelist.size()-1){
						parentidSel.append(",");
					}
				}
				parentidSel.append(")");
				*/
				//由只能查询下一级角色改为可以查询本级角色下的所有角色 modify by zzq 2012/07/03
				parentidSel.append(" and (");
				for(int i=0;i<rolelist.size();i++){
					SsRole role=rolelist.get(i);
					parentidSel.append("(roleseq like '%"+role.getRoleid()+"%' and roleid<>'"+role.getRoleid()+"')");
					if(i!=rolelist.size()-1){
						parentidSel.append(" or ");
					}
				}
				parentidSel.append(")");
				
				//((roleseq like '%261%' and roleid<>'261') or (roleseq like '221%' and roleid<>'221'))
				
				
				//and ( parentid like '2%' or parentid like '3%')
			}else{
				SsRole role=rolelist.get(0);

				//parentidSel.append(" and  parentid = ").append(role.getRoleid());
				//由只能查询下一级角色改为可以查询本级角色下的所有角色 modify by zzq 2012/07/03
				parentidSel.append(" and (roleseq like '%"+role.getRoleid()+"%' and roleid<>'"+role.getRoleid()+"')");
				
			}
		}
		String SELECT_PREFIX_PRE ="select  "
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" ROLESEQ as roleseq,"
			+" ROLELEVEL as rolelevel"
			+" from SS_ROLE   where 1=1 "+parentidSel.toString()+" and roleid not in (select ROLEID  from SS_ROLE_USER where Userid = ? )";
		//System.out.println(SELECT_PREFIX_PRE+"======================================");
		Object[] params = new Object[] { userId };
		int[] types = new int[] { Types.BIGINT };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
				new ItemMapper());
		return listSsMenu;
	}
	public List<SsRole> findRoleParentidByUserID(Long userid){
		
		String sql="select " 
			+" ROLEID as roleid,"
			+" ROLENAME as rolename,"
			+" ROLEDESC as roledesc,"
			+" ROLESEQ as roleseq,"
			+" ROLELEVEL as rolelevel "
			+" from SS_ROLE "
			+" where roleid  in "
			+" (select ROLEID  from SS_ROLE_USER s where s.userid = ? ) order by rolelevel";
		Object[] params = new Object[] { userid };
		int[] types = new int[] { Types.BIGINT };	
		return getJdbcTemplate().query(sql, params, types,
				new ItemMapper());
	}
//可选工作组
public List<SsGroup> findLeftGroupByUserId(Long userId,String parentGroup) {	
	    String childSQL = " SELECT  distinct t.groupid FROM SS_GROUP t "
	    	             + " START WITH t.parentgroupid in ("+parentGroup+") " 
	    	             + " CONNECT BY t.parentgroupid = PRIOR t.groupid " ;

		String SELECT_PREFIX_PRE ="select  "
			+" GROUPID as groupid,"
			+" GROUPNAME as groupname,"
			+" GROUPDESC as groupdesc,"
			+" PARENTGROUPID as parentgroupid,"
			+" GROUPLEVEL as groupelevel"
			+" from SS_GROUP   " 
			+" where groupid in ( " + childSQL + " ) and groupid not in (select GROUPID  from SS_GROUP_USER where Userid = ? ) "
			;
		//System.out.println(SELECT_PREFIX_PRE+"======================================");
		Object[] params = new Object[] { userId };
		int[] types = new int[] { Types.BIGINT };
		List listSsGroup = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
				new groupItemMapper());
		return listSsGroup;
	}
	//用户已经拥有的工作组
	public List<SsGroup> findSelectedGroupByUserId(Long userId) {	
		
			String SELECT_PREFIX_PRE ="select  "
				+" GROUPID as groupid,"
				+" GROUPNAME as groupname,"
				+" GROUPDESC as groupdesc,"
				+" PARENTGROUPID as parentgroupid,"
				+" GROUPLEVEL as groupelevel"
				+" from SS_GROUP   where groupid in (select GROUPID  from SS_GROUP_USER where Userid = ? )";
			Object[] params = new Object[] { userId };
			int[] types = new int[] { Types.BIGINT };
			List listSsGroup = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
					new groupItemMapper());
			return listSsGroup;
		}
	protected class groupItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsGroup ssGroup = new SsGroup();
			ssGroup.setGroupid(rs.getLong(1));
			ssGroup.setGroupname(rs.getString(2));
			ssGroup.setGroupdesc(rs.getString(3));
			ssGroup.setParentgroupid(rs.getLong(4));
			ssGroup.setGrouplevel(rs.getInt(5));
			return ssGroup;
		}
	}
	
	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsRole ssRole = new SsRole();
			ssRole.setRoleid(rs.getLong(1));
			ssRole.setRolename(rs.getString(2));
			ssRole.setRoledesc(rs.getString(3));
			ssRole.setRoleseq(rs.getString(4));
			ssRole.setRolelevel(rs.getLong(5));
			return ssRole;
		}
	}

	
	//修改密码
	public SsUser getByUsername(String userName) {
		String sql = getSelectPrefix()+" where USERNAME=? ";	
		
		SsUser ssUser = null;
		try {   
			ssUser = (SsUser)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), userName);
			       } catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return ssUser;
	}
	
	
	public List<SsUser> findUserByDeptId(String deptid) {
		String sql = getSelectPrefix()+" where DEPTID=  '"+deptid+"'";	
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		     
			       
	}
	
	
	public void updatePasswd(String username ,String  newpwd) {
		String sql = "update SS_USER set "
			+ " PASSWORD=:userpwd "
			+ " where USERNAME=:username";

		Map namedParameters = new HashMap();
		namedParameters.put("username", username);
		namedParameters.put("userpwd", newpwd);

		

		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	

}
