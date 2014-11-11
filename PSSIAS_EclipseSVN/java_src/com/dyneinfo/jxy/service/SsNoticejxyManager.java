/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import java.util.List;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.security.userdetails.MyUserDetails;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.dao.SsNoticejxyDao;
import com.dyneinfo.jxy.model.SsNotice;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticejxyManager extends BaseManager<SsNotice,java.lang.Long>{

	private SsNoticejxyDao ssNoticejxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticejxyDao(SsNoticejxyDao dao) {
		this.ssNoticejxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticejxyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssNoticejxyDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(PageRequest pr,String sql) {
		return ssNoticejxyDao.findByPageRequest(pr,sql);
	}
	public SsNotice getSsNoticeById(java.lang.Long noticeid) {
		return (SsNotice)ssNoticejxyDao.getSsNoticeById(noticeid);
	}
	public void deleteNOTICE_attend(Long noticeid) {
		 ssNoticejxyDao.deleteNOTICE_attend(noticeid);
	}
	public List getByNoticeByUser(MyUserDetails userDetail) {
		return ssNoticejxyDao.getByNoticeByUser(userDetail);
	}
	public  Page findByPageRequestUser(MyUserDetails userDetail,PageRequest pr,String arg) {
		return ssNoticejxyDao.findByPageRequestUser(userDetail,pr,arg);
	}
	public int getNoticeReplyById(String noticeId,String deptId){
		return ssNoticejxyDao.getNoticeReplyById(noticeId,deptId);
	}
	//通知 参与人员
	public List getNotice_participants(Long noticeID) {
		return (List)ssNoticejxyDao.getNotice_participants(noticeID);
	}
	
	//发布范围（单位） 
	public List getNotice_issuescope(Long noticeID) {
		return (List)ssNoticejxyDao.getNotice_issuescope(noticeID);
	}
}
