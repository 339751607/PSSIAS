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
public class TtjGuestTypeManager extends BaseManager<TtjGuestType,java.lang.String>{

	private TtjGuestTypeDao tjGuestDao;
	public TtjGuestTypeDao getTtjGuestDao() {
		return tjGuestDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTtjGuestTypeDao(TtjGuestTypeDao dao) {
		this.tjGuestDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tjGuestDao;
	}
	public Page findByPageRequest(PageRequest pr,String tableName,String xzqhSql) {
		return tjGuestDao.findByPageRequest(pr,tableName,xzqhSql);
	}
	public Page findByPageRequest(PageRequest pr,String xzqhSql) {
		return tjGuestDao.findByPageRequest(pr,xzqhSql);
	}

	
}
