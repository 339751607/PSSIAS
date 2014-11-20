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
public class SsUserManager extends BaseManager<SsUser,java.lang.Long>{

	private SsUserDao ssUserDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsUserDao(SsUserDao dao) {
		this.ssUserDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssUserDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssUserDao.findByPageRequest(pr);
	}
	/**
	 * @description: 获取可用用户总数。
	 * @author Liutao
	 * @param sql
	 * @return
	 */
	public Number getEnabledUserCount() {
		return ssUserDao.getEnabledUserCount();
	}
	//用户名是否存在
	public int getCountUserName(String username) {
		return (int)ssUserDao.getCountUserName(username);
	}
	//根据机构查询用户
	public Page findUserByDeptSeqRequest(PageRequest pr) {
		return ssUserDao.findUserByDeptSeqRequest(pr);
	}
	
	public Page findUserByDeptSeqRequestTwo(PageRequest pr) {
		return ssUserDao.findUserByDeptSeqRequestTwo(pr);
	}
	
	//根据创建用户查询用户列表
	public Page findUserByCreateuseridRequest(PageRequest pr) {
		return ssUserDao.findUserByCreateuseridRequest(pr);
	}
	
	public Page findUserByDeptRequest4Hotel(PageRequest pr) {
		return ssUserDao.findUserByDeptRequest4Hotel(pr);
	}
	
	//根据role查询用户
	public Page findUserByRoleRequest(PageRequest pr) {
		return ssUserDao.findUserByDeptSeqRequest(pr);
	}
	
	public List<SsRole> findUserNoExistRole(String session_deptId,Long userid) {
		return ssUserDao.findUserNoExistRole(session_deptId,userid);
	}
	
	//部门角色
	
	public List<SsRole> findDeptRole(String deptId) {
		return ssUserDao.findDeptRole(deptId);
	}
	
	public int getCountRoleUser(long roleid, long userid) {
		return (int)ssUserDao.getCountRoleUser(roleid,userid);
	}
	
	public void insertRoleUser(long roleid, long userid) {
		ssUserDao.insertRoleUser(roleid,userid);
	}
	
	public void insertGroupUser(long groupid, long userid) {
		ssUserDao.insertGroupUser(groupid,userid);
	}
	
	public void removeroleUser(java.lang.Long userid) {
		ssUserDao.removeroleUser(userid);
	}
	
	public void removeGroupUser(java.lang.Long userid) {
		ssUserDao.removeGroupUser(userid);
	}
	
	public void editpasswrod(java.lang.Long userid){
		ssUserDao.editpasswrodUser(userid);
	}
	
	public void updateByDeptid(String cpcode,String enabled){
		ssUserDao.updateByDeptid(cpcode,enabled);
	}
	
	
	
	public List<SsRole> findUserRole(Long userid) {
		return ssUserDao.findUserRole(userid);
	}
	
	public List<SsRole> findUserNoExistRole(Long sessionUserId ,Long userId) {		
		return ssUserDao.findUserNoExistRole(sessionUserId,userId);
	}
    public List<SsGroup> findLeftGroupByUserId(Long userId, String parentGroup) {		
		return ssUserDao.findLeftGroupByUserId(userId,parentGroup);
	}
    public List<SsGroup> findSelectedGroupByUserId(Long userId) {		
		return ssUserDao.findSelectedGroupByUserId(userId);
	}
    
	public SsUser getByUsername(String  username) {
		return (SsUser)ssUserDao.getByUsername(username);
	}
	public List<SsUser> findUserByDeptId(String deptid) {
		return ssUserDao.findUserByDeptId(deptid);
	}
	public void  updatePasswd(String username ,String  newpwd) {
		ssUserDao.updatePasswd(username,newpwd);
	}
}
