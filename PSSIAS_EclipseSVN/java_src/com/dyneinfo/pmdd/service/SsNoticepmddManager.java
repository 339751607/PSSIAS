/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.security.userdetails.MyUserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticepmddManager extends BaseManager<SsNotice,java.lang.Long>{

	private SsNoticepmddDao ssNoticeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticepmddDao(SsNoticepmddDao dao) {
		this.ssNoticeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticeDao;
	}
	public Page findByPageRequest(String deptID,PageRequest pr) {
		return ssNoticeDao.findByPageRequest(deptID,pr);
	}
	public Page findByPageRequest(PageRequest pr,String sql) {
		return ssNoticeDao.findByPageRequest(pr,sql);
	}
	public SsNotice getSsNoticeById(java.lang.Long noticeid) {
		return (SsNotice)ssNoticeDao.getSsNoticeById(noticeid);
	}
	public void deleteNOTICE_attend(Long noticeid) {
		 ssNoticeDao.deleteNOTICE_attend(noticeid);
	}
	public List getByNoticeByUser(MyUserDetails userDetail) {
		return ssNoticeDao.getByNoticeByUser(userDetail);
	}
	public  Page findByPageRequestUser(MyUserDetails userDetail,PageRequest pr,String arg) {
		return ssNoticeDao.findByPageRequestUser(userDetail,pr,arg);
	}
	public int getNoticeReplyById(String noticeId,String deptId){
		return ssNoticeDao.getNoticeReplyById(noticeId,deptId);
	}
}
