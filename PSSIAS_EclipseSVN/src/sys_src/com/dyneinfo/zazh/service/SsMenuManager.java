/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.service;

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
public class SsMenuManager extends BaseManager<SsMenu,java.lang.Long>{

	private SsMenuDao ssMenuDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsMenuDao(SsMenuDao dao) {
		this.ssMenuDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssMenuDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssMenuDao.findByPageRequest(pr);
	}
	public List<SsMenu> findByParentId(java.lang.Long menuid) {
		return ssMenuDao.findByParentId(menuid);
	}
	
	public List<SsMenu> findRootTree() {
		return ssMenuDao.findRootTree();
	}
	public void insertRoot(SsMenu entity) {
		ssMenuDao.insertRoot(entity);
	}
	public void updateRoot(SsMenu entity) {
		ssMenuDao.updateRoot(entity);
	}
	public void updateSEQ(SsMenu entity) {
		ssMenuDao.updateSEQ(entity);
	}
	public List<Menu> findAllByRoleID(Long roleID) {
		return ssMenuDao.findAllByRoleID(roleID);
	}
	
	
	public List<Menu> findCheckboxTreeByParentId(Long menuid) {
		return ssMenuDao.findCheckboxTreeByParentId(menuid);
	}
	
	public List<Menu> findRootCheckboxTree(String businessCode)  {
		return ssMenuDao.findRootCheckboxTree( businessCode);
	}
	
	public List<Menu> findSelectMenu(String sqlWhere) {
		return ssMenuDao.findSelectMenu(sqlWhere);
	}
	
	public void removeroleMenu(long menuid) {
		ssMenuDao.removeroleMenu(menuid);
	}
	public int getCountChildrenMenu(long parentid) {
	  return 	(int)ssMenuDao.getCountChildrenMenu(parentid);
	}
	public void updateIsleaf(String isleafvaue,long menuid) {
		ssMenuDao.updateIsleaf(isleafvaue,menuid);
	}
}
