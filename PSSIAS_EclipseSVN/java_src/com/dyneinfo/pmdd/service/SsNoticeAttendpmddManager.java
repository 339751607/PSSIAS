/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

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
public class SsNoticeAttendpmddManager extends BaseManager<SsNoticeAttend,java.lang.Long>{

	private SsNoticeAttendpmddDao ssNoticeAttendDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsNoticeAttendpmddDao(SsNoticeAttendpmddDao dao) {
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
