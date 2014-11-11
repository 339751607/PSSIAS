
package com.dyneinfo.zazh.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javacommon.base.BaseSpringJdbcDao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.AsecurityMenu;
import com.dyneinfo.zazh.model.MainMenuItemExt;
import com.dyneinfo.zazh.model.menuViewSpring;

@Component
public class AsecurityMenuDao extends BaseSpringJdbcDao<AsecurityMenu,java.math.BigDecimal>{
	
	static final String SELECT_PREFIX = "select ID,URL,THE_SORT,QTIP,DESCN,NAME,IMAGE,PARENT_ID,ISLEAF,ROOTID,MENULEVEL,MENUSEQ from A_SECURITY_MENU ";
	
	public Class getEntityClass() {
		return AsecurityMenu.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from A_SECURITY_MENU where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return SELECT_PREFIX + " where ID=? ";
	}
	
	public void save(AsecurityMenu entity) {
		String sql = "insert into A_SECURITY_MENU " 
			 + " (ID,URL,THE_SORT,QTIP,DESCN,NAME,IMAGE,PARENT_ID,ISLEAF,ROOTID,MENULEVEL,MENUSEQ) " 
			 + " values "
			 + " (:id,:url,:theSort,:qtip,:descn,:name,:image,:parentId,:isleaf,:rootid,:menulevel,:menuseq)";
		insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"sequenceName",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql) //手工分配
	}
	
	public void update(AsecurityMenu entity) {
		String sql = "update A_SECURITY_MENU set "
					+ " ID=:id,URL=:url,THE_SORT=:theSort,QTIP=:qtip,DESCN=:descn,NAME=:name,IMAGE=:image,PARENT_ID=:parentId,ISLEAF=:isleaf,ROOTID=:rootid,MENULEVEL=:menulevel,MENUSEQ=:menuseq "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = SELECT_PREFIX ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	
	
	 public List findUserByLoginid(String userid) {
			String sql = "select distinct c.menuLevel,c.displayorder as the_sort,c.menuid as id,c.isLeaf,c.parentid as parent_id,c.menuname as name,c.menuurl as url,c.menulabel as qtip,c.imagepath as image, c.businesscode as businesscode "
				+ "   from SS_GROUP_USER a, SS_ROLE_MENU b, SS_menu c, ss_user d ,ss_group g,ss_role_group gr ,ss_role r "
				+ "  where gr.roleid = b.ROLEID and b.MENUID = c.menuid and a.groupid= g.groupid and g.groupid = gr.groupid  and a.userid= d.userid and d.username = :usname order by c.businesscode, c.menuLevel, c.displayorder";

	       HashMap   salaryMap = new HashMap();
	        salaryMap.put("usname",userid);
	      
	      return getNamedParameterJdbcTemplate().query(sql, salaryMap,
	    		  new BeanPropertyRowMapper(menuViewSpring.class));
	    }

	 
		public int getCountBySql(String sql) {
			
			int  totalCount = 0;
			try {   
				totalCount = getSimpleJdbcTemplate().queryForInt(sql);   
			
			} catch (EmptyResultDataAccessException ex) {   
				           logger   
				                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
				       }   
			return totalCount;
		}
	
	

	public Page findByPageRequest(PageRequest pageRequest) {
		// $column$为字符串拼接, #column#为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// $column$ 为PageRequest.getFilters()中的key
		String sql = SELECT_PREFIX + "  a where 1=1 "
				+ "/~ and a.URL = '$url$' ~/"
				+ "/~ and a.THE_SORT = '$theSort$' ~/"
				+ "/~ and a.QTIP = '$qtip$' ~/"
				+ "/~ and a.DESCN = '$descn$' ~/"
				+ "/~ and a.NAME = '$name$' ~/"
				+ "/~ and a.IMAGE = '$image$' ~/"
				+ "/~ and a.PARENT_ID = '$parentId$' ~/"
				+ "/~ and a.ISLEAF = '$isleaf$' ~/"
				+ "/~ and a.ROOTID = '$rootid$' ~/"
				+ "/~ and a.MENULEVEL = '$menulevel$' ~/"
				+ "/~ and a.MENUSEQ = '$menuseq$' ~/"
				+ "/~ order by #sortColumns# ~/";
		return pageQuery(sql,pageRequest);
	}
	
public List getUserMenusList(String userName) {
		
		//System.out.println(sql);
		List topMenus = new ArrayList();
		HashMap menuTable = new HashMap();
		List list = findUserByLoginid(userName);

		//System.out.println("getUserMenusList 00000000000000" + list);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {

				menuViewSpring  menuviewSpring= 	(menuViewSpring)list.get(i);
				
				int level = Integer.parseInt(menuviewSpring.getMenuLevel())  - 1;
				int  order =Integer.parseInt(menuviewSpring.getThe_sort());
				Long menuId = Long.parseLong(menuviewSpring.getId());
				
				String isLeaf = (String) menuviewSpring.getIsLeaf();
				String strParentid = "0";
				if(menuviewSpring.getParent_id() != null){
					Long   parentsID =Long.parseLong(menuviewSpring.getParent_id());
				    Long objparentsID = new Long(parentsID);
				    strParentid = objparentsID.toString().trim();
				}
				String label = (String) menuviewSpring.getName();
				String action = (String) menuviewSpring.getUrl();
				String Tip = (String) menuviewSpring.getQtip();
				String image = (String) menuviewSpring.getImage();
				String target = "";
				boolean bLeaf = isLeaf != null && isLeaf.equalsIgnoreCase("Y");
				
				Long objMenuid = new Long(menuId);
				
				
				MainMenuItemExt item = new MainMenuItemExt();
				item.setAction(action);
				item.setLeaf(bLeaf);
				item.setLevel(level);
				item.setName(label);
				item.setMenuImage(image);
				item.setMenuTarget(target);
				item.setParentID(strParentid);
				item.setMenuID(objMenuid.toString());
				item.setDisplayOrder(order);
				//System.out.println("put id " + objMenuid.toString().trim());
				menuTable.put(objMenuid.toString().trim(), item);
				if (level == 0) {
					topMenus.add(item);
				} else {	
					MainMenuItemExt pItem = (MainMenuItemExt) menuTable.get(strParentid);
					
					if (pItem != null) {
						
						pItem.addChild(item);
					}
				}
			}
		}

		return topMenus;
	}
	

}
