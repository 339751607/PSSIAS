/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticeManager extends BaseManager<SsNotice,java.lang.Long>{

	private SsNoticeDao ssNoticeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticeDao(SsNoticeDao dao) {
		this.ssNoticeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticeDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssNoticeDao.findByPageRequest(pr);
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
	public void insertNoticeReply(String noticeid ,String deptid,String replydate,String flag) {
		ssNoticeDao.insertNoticeReply(noticeid,deptid,replydate,flag);
	}
	
	public int getCountByKey(String noticeid,String deptid,String flag) {
		return ssNoticeDao.getCountByKey(noticeid,deptid,flag);
	}
	
	public List getDeptSeq( String eid) {
		return (List)ssNoticeDao.getDeptSeq(eid);
	}
	public int getTzReplyHotelCount(String noticeid) {
		return (int)ssNoticeDao.getTzReplyHotelCount(noticeid);
	}
	public int getTzNoReplyHotelCount(String sqlWhere,String noticeid) {
		return (int)ssNoticeDao.getTzNoReplyHotelCount(sqlWhere,noticeid);
	}
	public Page findByPageRequestReplyNotice(PageRequest<Map> pageRequest,String id) {
		return ssNoticeDao.findByPageRequestReplyNotice(pageRequest,id);
	}
	public Page findByPageRequesttzNoReply(PageRequest pageRequest) {
		return ssNoticeDao.findByPageRequesttzNoReply(pageRequest);
	}
	
	public int getNoticeNumber(String sql){
		return ssNoticeDao.getNoticeNumber(sql);
	}
	
}
