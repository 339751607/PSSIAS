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
public class SsNoticeAttendManager extends BaseManager<SsNoticeAttend,java.lang.Long>{

	private SsNoticeAttendDao ssNoticeAttendDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticeAttendDao(SsNoticeAttendDao dao) {
		this.ssNoticeAttendDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssNoticeAttendDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssNoticeAttendDao.findByPageRequest(pr);
	}
	public void deleteParticipants(Long noticeid) {
		ssNoticeAttendDao.deleteParticipants(noticeid);
	}
	public void deleteIssuescope(Long noticeid) {
		ssNoticeAttendDao.deleteIssuescope(noticeid);
	}
	
}
