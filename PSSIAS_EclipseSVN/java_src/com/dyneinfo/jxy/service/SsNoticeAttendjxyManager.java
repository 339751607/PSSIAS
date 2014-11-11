/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.dao.SsNoticeAttendjxyDao;
import com.dyneinfo.jxy.model.SsNoticeAttend;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticeAttendjxyManager extends BaseManager<SsNoticeAttend,java.lang.Long>{

	private SsNoticeAttendjxyDao ssNoticeAttendjxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticeAttendjxyDao(SsNoticeAttendjxyDao dao) {
		this.ssNoticeAttendjxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticeAttendjxyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssNoticeAttendjxyDao.findByPageRequest(pr);
	}
	public void deleteParticipants(Long noticeid) {
		ssNoticeAttendjxyDao.deleteParticipants(noticeid);
	}
	public void deleteIssuescope(Long noticeid) {
		ssNoticeAttendjxyDao.deleteIssuescope(noticeid);
	}
	
}
