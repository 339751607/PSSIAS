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
public class SsLogsManager extends BaseManager<SsLogs,java.math.BigDecimal>{

	private SsLogsDao ssLogsDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsLogsDao(SsLogsDao dao) {
		this.ssLogsDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssLogsDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssLogsDao.findByPageRequest(pr);
	}
	
}
