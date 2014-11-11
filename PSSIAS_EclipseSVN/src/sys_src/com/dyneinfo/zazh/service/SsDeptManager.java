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
public class SsDeptManager extends BaseManager<SsDept,java.lang.String>{

	private SsDeptDao ssDeptDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsDeptDao(SsDeptDao dao) {
		this.ssDeptDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssDeptDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssDeptDao.findByPageRequest(pr);
	}
	

	public void updateSrcDept(SsDept entity) {
		ssDeptDao.updateSrcDept(entity);
	}
	
	public List<SsDept> findRootTree(String deptTypeId) {
		return ssDeptDao.findRootTree(deptTypeId);
	}
	public List<SsDept> findByDeptId(String deptid,String deptTypeId) {
		return ssDeptDao.findByDeptId(deptid,deptTypeId);
	}
	
	public List<SsDept> findByParentId(String deptid,String deptTypeId) {
		return ssDeptDao.findByParentId(deptid,deptTypeId);
	}
	
	
	public void insertRoot(SsDept entity) {
		ssDeptDao.insertRoot(entity);
	}
	public void saveWithAssigned(SsDept entity) {
		ssDeptDao.saveWithAssigned(entity);
	}
	public void updateRoot(SsDept entity) {
		ssDeptDao.updateRoot(entity);
	}
	public void updateSEQ(SsDept entity) {
		ssDeptDao.updateSEQ(entity);
	}
//	检查部门是否存在用户
	public int getCountDeptUser(String deptid) {
	  return 	(int)ssDeptDao.getCountDeptUser(deptid);
	}
	//查找所有拥有下级部门的的部门ID
	public List getExistChildDept() {
		return (List)ssDeptDao.getExistChildDept();
	}
	//查找所选中部门的父节点 jstree checkbox dept
	public List getDeptCheckbox(String sql) {
		return (List)ssDeptDao.getDeptCheckbox(sql);
	}
	public int getCountChildDept(String deptid) {
		  return 	(int)ssDeptDao.getCountChildDept(deptid);
	}
	//删除企业信息
	public void deleteTcpinfo(String arg) {
		ssDeptDao.deleteTcpinfo(arg);
	}
	

	public SsDept getById(String deptid) {
		return ssDeptDao.getById(deptid);
	}
	public SsDept getDeptseq(String deptseq){
		return ssDeptDao.getDeptseq(deptseq);
	}
	
	
	public List<SsDept> getTagTree(String sql ,String orgSeq) {
		return (List)ssDeptDao.getTagTree(sql,orgSeq);
	}
}
