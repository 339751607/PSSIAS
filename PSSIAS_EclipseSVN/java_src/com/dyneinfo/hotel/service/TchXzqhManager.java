/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TchXzqhManager extends BaseManager<TchPre,java.lang.String>{

	private TchXzqhDao tchXzqhDao;
	public TchXzqhDao getTchXzqhDao() {
		return tchXzqhDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTchXzqhDao(TchXzqhDao dao) {
		this.tchXzqhDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tchXzqhDao;
	}
	public Page findByPageRequest(PageRequest pr,String originSql) {
		return tchXzqhDao.findByPageRequest(pr,originSql);
	}
	public Page findByPageRequest(PageRequest pr) {
		return tchXzqhDao.findByPageRequest(pr);
	}

	
}
