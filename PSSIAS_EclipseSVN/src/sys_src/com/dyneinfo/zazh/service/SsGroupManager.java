/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.service;

import org.springframework.dao.DataAccessException;
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
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsGroupManager extends BaseManager<SsGroup,java.lang.Long>{

	private SsGroupDao ssGroupDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsGroupDao(SsGroupDao dao) {
		this.ssGroupDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssGroupDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssGroupDao.findByPageRequest(pr);
	}
	public List<SsGroup> getByParentId(SsGroup ssGroup) {
		return ssGroupDao.getByParentId(ssGroup);
	}
	public Number getChildGroupCount(Long parentgroupid) {
		return ssGroupDao.getChildGroupCount(parentgroupid);
	}
	public void updateGroupseq(String groupseq,Long groupid) {
		ssGroupDao.updateGroupseq(groupseq,groupid);
	}
	public void updateIsleaf(String isleaf,Long groupid) {
		ssGroupDao.updateIsleaf( isleaf, groupid);
	}
	public List<SsGroup> getByGroupSeq(String groupseq) {
		return ssGroupDao.getByGroupSeq(groupseq);
	}
	public void updateGroupDisplayorder4NewParentCopy(Long parentgroupid,int displayorder,Long src_parentid) throws DataAccessException{
		 ssGroupDao.updateGroupDisplayorder4NewParentCopy( parentgroupid, displayorder, src_parentid);
	}
	//更新显示顺序  Not creating or copying - old parent is cleaned
	public void updateGroupDisplayorder4DelOrCut(Long parentgroupid,int displayorder) {
		ssGroupDao.updateGroupDisplayorder4DelOrCut(parentgroupid,displayorder);
	}
	public void updateSrcGroup(String groupseq, int displayorder,Long parentgroupid,int grouplevel,Long groupid){
		ssGroupDao.updateSrcGroup(groupseq,displayorder,parentgroupid,grouplevel,groupid);
	}
	public void updateSrcChildGroup(String groupseq,int grouplevel,Long groupid){
		ssGroupDao.updateSrcChildGroup(groupseq, grouplevel, groupid);
	}
	//更新显示顺序  Preparing new parent
	public void updateGroupDisplayorder4NewParent(Long parentgroupid,int displayorder) {
		ssGroupDao.updateGroupDisplayorder4NewParent(parentgroupid,displayorder);
	}
	public Number getGroupSeq() {
		return ssGroupDao.getGroupSeq();
	}
	public void deleteGroupRoleByGroupid(Long id) {
		ssGroupDao.deleteGroupRoleByGroupid(id);
	}
	public void deleteGroupUserByGroupid(Long id) {
		ssGroupDao.deleteGroupUserByGroupid(id);
	}
	public void updateGroupName(String  groupname,String groupdesc,Long groupid){
		ssGroupDao.updateGroupName(groupname,groupdesc,groupid);
	}
	 
	 public void deleteRoleGroupbyGroupid(String groupid) {
		 ssGroupDao.deleteRoleGroupbyGroupid(groupid);
	 }
	 public void insertRoleGroup(String roleid,String groupid) {
		 ssGroupDao.insertRoleGroup(roleid,groupid);
	 }

}
