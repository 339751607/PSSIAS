/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.dao.SsNoticeReplyDao;
import com.dyneinfo.jxy.model.SsNoticeReply;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticeReplyManager extends BaseManager<SsNoticeReply,java.lang.String>{

	private SsNoticeReplyDao ssNoticeReplyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticeReplyDao(SsNoticeReplyDao dao) {
		this.ssNoticeReplyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticeReplyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssNoticeReplyDao.findByPageRequest(pr);
	}
	public SsNoticeReply getById(String noticeid,String deptid) {
		return (SsNoticeReply)ssNoticeReplyDao.getById(noticeid,deptid);
	}
	
}
