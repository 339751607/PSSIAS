/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.service;

import org.springframework.dao.EmptyResultDataAccessException;
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
public class SsRoleManager extends BaseManager<SsRole,java.lang.Long>{

	private SsRoleDao ssRoleDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsRoleDao(SsRoleDao dao) {
		this.ssRoleDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssRoleDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssRoleDao.findByPageRequest(pr);
	}
	
	public int getCountRoleUser(long roleid ) {
		return (int)ssRoleDao.getCountRoleUser(roleid);
	}
	public int getCountRole(long roleid ) {
		return (int)ssRoleDao.getCountRole(roleid);
	}

	public int getCountRoleAuthority(long roleid ,long authid) {
		return (int)ssRoleDao.getCountRoleAuthority(roleid,authid);
	}
	
	public void insertRoleAuthority(long roleid ,long authid) {
		 ssRoleDao.insertRoleAuthority(roleid,authid);
	}
	
	public void removeroleAuthority(long roleid) {	
		 ssRoleDao.removeroleAuthority(roleid);
	}
	
	
	public void removeroleAuthority(long roleid ,long authid) {	
		 ssRoleDao.removeroleAuthority(roleid,authid);
	}
	
	public int getCountRoleMenu(long roleid ,long menuid) {
		return (int)ssRoleDao.getCountRoleMenu(roleid,menuid);
	}
	

	public void insertRoleMenu(long roleid ,long menuid) {
		 ssRoleDao.insertRoleMenu(roleid,menuid);
	}
	
	public void removeroleMenu(long roleid) {	
		 ssRoleDao.removeroleMenu(roleid);
	}
	
	public int getCountRoleName(String ROLENAME, String parentId) {
		return (int)ssRoleDao.getCountRoleName(ROLENAME, parentId);
	}
	
	public void removeroleMenu(long roleid ,String menuidStr) {	
		 ssRoleDao.removeroleMenu(roleid,menuidStr);
	}
	
	public void removeroleUser(long roleid) {	
		 ssRoleDao.removeroleUser(roleid);
	}
	public void updateSEQ(SsRole entity) {
		ssRoleDao.updateSEQ(entity);
	}
	//查找所有拥有下级部门的的部门ID
	public List getExistChildDept() {
		return (List)ssRoleDao.getExistChildDept();
	}
	//查找所选中部门的父节点 jstree checkbox dept
	public List getDeptCheckbox(String sql) {
		return (List)ssRoleDao.getDeptCheckbox(sql);
	}
	
	public List<SsRole> findRootTree() {
		return ssRoleDao.findRootTree();
	}
	public List<SsRole> findByUserId(java.lang.Long userId) {
		return ssRoleDao.findByUserId(userId);
	}
	
	public List<SsRole> findByParentId(java.lang.Long parentid) {
		return ssRoleDao.findByParentId(parentid);
	}
	
	public List<SsRole> findByRoleType() {
		return ssRoleDao.findByRoleType();
	}
	
	public List<SsRole> findCheckboxTreeByParentId(Long menuid) {
		return ssRoleDao.findCheckboxTreeByParentId(menuid);
	}
	
	public List<SsRole> getByRoles(String businessCode) {
		return ssRoleDao.getByRoles( businessCode);
	}
 
	public List<SsRole> getRolesByParentId(String parentId) {
		return ssRoleDao.getRolesByParentId( parentId);
	}
	
	public Number getChildRoleCount(String parentId) {
		return ssRoleDao.getChildRoleCount(parentId);
	}
	public List<SsRole> getRoleGroupBygroupID(String groupid) {
		return ssRoleDao.getRoleGroupBygroupID(groupid);
	}
	//叶子节点
	public List<SsRole> getLeafRoleByGroupId(String groupid) {
		return ssRoleDao.getLeafRoleByGroupId(groupid);
	}
	
	//非叶子节点
	public List<SsRole> getNotleafRoleByGroupId(String groupid) {
		return ssRoleDao.getNotleafRoleByGroupId(groupid);
	}
	//所有的叶子节点
	public List<SsRole> getRoleByGroupId(String groupid) {
		return ssRoleDao.getRoleByGroupId(groupid);
	}
}
