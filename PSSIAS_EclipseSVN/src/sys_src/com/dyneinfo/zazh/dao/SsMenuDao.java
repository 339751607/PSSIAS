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
import com.dyneinfo.zazh.service.*;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Component
public class SsMenuDao extends BaseSpringJdbcDao<SsMenu,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsMenu.class;
	}
	
	public String getIdentifierPropertyName() {
		return "menuid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" MENUID as menuid,"
				+" MENUNAME as menuname,"
				+" MENUDESC as menudesc,"
				+" MENULABEL as menulabel,"
				+" ISLEAF as isleaf,"
				+" MENUURL as menuurl,"
				+" MENULEVEL as menulevel,"
				+" ROOTID as rootid,"
				+" PARENTID as parentid,"
				+" IMAGEPATH as imagepath,"
				+" MENUSEQ as menuseq,"
				+" DISPLAYORDER as displayorder"
				+" from SS_MENU ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_MENU where MENUID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where MENUID=? ";
	}
	
	public void save(SsMenu entity) {
		String sql = "insert into SS_MENU " 
			 + " (MENUID,MENUNAME,MENUDESC,MENULABEL,ISLEAF,MENUURL,MENULEVEL,ROOTID,PARENTID,IMAGEPATH,MENUSEQ,DISPLAYORDER) " 
			 + " values "
			 + " (:menuid,:menuname,:menudesc,:menulabel,:isleaf,:menuurl,:menulevel,:rootid,:parentid,:imagepath,:menuseq,:displayorder)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_MENU",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void insertRoot(SsMenu entity) {
		String sql = "insert into SS_MENU " 
			 + " (MENUID,MENUNAME,MENUDESC,MENULABEL,ISLEAF,MENUURL,MENULEVEL,ROOTID,IMAGEPATH,MENUSEQ,DISPLAYORDER) " 
			 + " values "
			 + " (:menuid,:menuname,:menudesc,:menulabel,:isleaf,:menuurl,:menulevel,:rootid,:imagepath,:menuseq,:displayorder)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_MENU",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsMenu entity) {
		String sql = "update SS_MENU set "
					+ " MENUID=:menuid,MENUNAME=:menuname,MENUDESC=:menudesc,MENULABEL=:menulabel,ISLEAF=:isleaf,MENUURL=:menuurl,MENULEVEL=:menulevel,ROOTID=:rootid,PARENTID=:parentid,IMAGEPATH=:imagepath,MENUSEQ=:menuseq,DISPLAYORDER=:displayorder "
					+ " where MENUID=:menuid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void updateRoot(SsMenu entity) {
		String sql = "update SS_MENU set "
					+ " MENUID=:menuid,MENUNAME=:menuname,MENUDESC=:menudesc,MENULABEL=:menulabel,ISLEAF=:isleaf,MENUURL=:menuurl,MENULEVEL=:menulevel,ROOTID=:rootid,IMAGEPATH=:imagepath,MENUSEQ=:menuseq,DISPLAYORDER=:displayorder "
					+ " where MENUID=:menuid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void updateSEQ(SsMenu entity) {
		String sql = "update SS_MENU set "
					+ " MENUSEQ=:menuseq "
					+ " where MENUID=:menuid";
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
				+ "/~ and t.MENUNAME = '[menuname]' ~/"
				+ "/~ and t.MENUDESC = '[menudesc]' ~/"
				+ "/~ and t.MENULABEL = '[menulabel]' ~/"
				+ "/~ and t.ISLEAF = '[isleaf]' ~/"
				+ "/~ and t.MENUURL = '[menuurl]' ~/"
				+ "/~ and t.MENULEVEL = '[menulevel]' ~/"
				+ "/~ and t.ROOTID = '[rootid]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ and t.IMAGEPATH = '[imagepath]' ~/"
				+ "/~ and t.MENUSEQ like '[menuseq]%' ~/"
				+ "/~ and t.DISPLAYORDER = '[displayorder]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	
	
	
	
	
	public List<SsMenu> findRootTree() {
		
	
		
		String SELECT_PREFIX_PRE = "select  "
			+" MENUID as menuid,"
			+" MENUNAME as menuname,"
			+" MENUDESC as menudesc,"
			+" MENULABEL as menulabel,"
			+" ISLEAF as isleaf,"
			+" MENUURL as menuurl,"
			+" MENULEVEL as menulevel,"
			+" PARENTID as parentid,"
			+" IMAGEPATH as imagepath "
			+" from SS_MENU  where PARENTID is null  order by menulevel,displayorder  ";
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE,new ItemMapper());
		return listSsMenu;
	}
	
	
	
	public List<SsMenu> findByParentId(java.lang.Long menuid) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" MENUID as menuid,"
			+" MENUNAME as menuname,"
			+" MENUDESC as menudesc,"
			+" MENULABEL as menulabel,"
			+" ISLEAF as isleaf,"
			+" MENUURL as menuurl,"
			+" MENULEVEL as menulevel,"
			+" PARENTID as parentid,"
			+" IMAGEPATH as imagepath  from SS_MENU  where PARENTID = ?  order by menulevel,displayorder ";
		Object[] params = new Object[] { menuid };
		int[] types = new int[] { Types.BIGINT };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params, types,
				new ItemMapper());
		return listSsMenu;
	}

	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsMenu ssMenu = new SsMenu();
			ssMenu.setMenuid(rs.getLong(1));
			ssMenu.setMenuname(rs.getString(2));
			ssMenu.setMenudesc(rs.getString(3));
			ssMenu.setIsleaf(rs.getString(5));
			ssMenu.setParentid(rs.getLong(8));
			
			return ssMenu;

		}
	}
	
	
  //下拉checkbox树方法 start
	
	public List<Menu> findAllByRoleID(Long roleID) {
		String SELECT_PREFIX_PRE = "select  "
			+" MENUID as menuid,"
			+" MENUNAME as menuname,"
			+" MENUDESC as menudesc,"
			+" MENULABEL as menulabel,"
			+" ISLEAF as isleaf,"
			+" MENUURL as menuurl,"
			+" MENULEVEL as menulevel,"
			+" PARENTID as parentid,"
			+" IMAGEPATH as imagepath,"
			+" DISPLAYORDER as displayorder "
			+" from SS_MENU  ";
		String sql = SELECT_PREFIX_PRE + " where menuid in (select MENUID from SS_ROLE_MENU where roleid = ?) order by menulevel,displayorder ";
		
		Object[] params = new Object[] { roleID };
		int[] types = new int[] { Types.BIGINT };
		List<Menu> listMenu = getJdbcTemplate().query(sql, params, types,
				new treeItemMapper());
		
		return listMenu;
		}	
	
	
	
	
	
	
	
	
	
	
	
	public List<Menu> findRootCheckboxTree(String businessCode) {
		
		String SELECT_PREFIX_PRE = "select  "
			+" MENUID as menuid,"
			+" MENUNAME as menuname,"
			+" MENUDESC as menudesc,"
			+" MENULABEL as menulabel,"
			+" ISLEAF as isleaf,"
			+" MENUURL as menuurl,"
			+" MENULEVEL as menulevel,"
			+" PARENTID as parentid,"
			+" IMAGEPATH as imagepath,"
			+" DISPLAYORDER as displayorder "
			+" from SS_MENU  where PARENTID is null  " ;
		String sql = SELECT_PREFIX_PRE ;
		if(businessCode != null && !"".equals(businessCode)){
			sql += " AND businesscode = '"+businessCode+"' " ;
		}
		sql += " order by menulevel,displayorder ";
		List listMenu = getJdbcTemplate().query(sql,new treeItemMapper());
		return listMenu;
	}
	
	
	
	public List<Menu> findCheckboxTreeByParentId(Long menuid) {
		
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
			Menu menu = new Menu();
			menu.setId(rs.getLong(1));
			menu.setName(rs.getString(2));
			menu.setDescn(rs.getString(3));
			menu.setParentId(rs.getLong(8));
			menu.setQtip(rs.getString(4));
			menu.setTheSort(rs.getInt(10));
			menu.setAllowChildren(allowChildren);
			menu.setIconCls("");
		
			
			return menu;

		}
	}
	
	 //下拉checkbox树方法 end
	
	
	//选中的菜单在数据库中存在的id
	public List<Menu> findSelectMenu(String sqlWhere) {
		
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
			+" from SS_MENU  where MENUID in ("+sqlWhere+")  order by menulevel,displayorder ";
		 System.out.println("sql where "+sqlWhere);
		List listMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE,
				new treeItemMapper());
		return listMenu;
	}

	//删除菜单时角色菜单数据删除
	public void removeroleMenu(long menuid) {
		String sql = " delete from  SS_ROLE_MENU  where MENUID =:menuid  ";
		Map namedParameters = new HashMap();
		namedParameters.put("menuid", menuid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	//	检查表存在子菜单数量
	public int getCountChildrenMenu(long parentid) {
		String sql = "select count(MENUID) from SS_MENU  where PARENTID=?  ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { parentid });
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	public void updateIsleaf(String isleafvaue,long menuid) {

		String sql = " update  SS_MENU set isLeaf=:isLeaf where MENUID=:menuid  ";

		Map namedParameters = new HashMap();
		namedParameters.put("isLeaf", isleafvaue);
		namedParameters.put("menuid", menuid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	


}
