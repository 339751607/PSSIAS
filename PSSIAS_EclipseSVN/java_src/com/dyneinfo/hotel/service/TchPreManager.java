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
public class TchPreManager extends BaseManager<TchPre,java.lang.String>{

	private TchPreDao tchPreDao;
	public TchPreDao getTchPreDao() {
		return tchPreDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTchPreDao(TchPreDao dao) {
		this.tchPreDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tchPreDao;
	}
	public Page findByPageRequest(PageRequest pr,String tableName) {
		return tchPreDao.findByPageRequest(pr,tableName);
	}
	public Page findByPageRequest(PageRequest pr) {
		return tchPreDao.findByPageRequest(pr);
	}
	public List getPic(String id) {
		return (List) tchPreDao.getPic(id);
	}
	public List getPicture(String sql) {
		return (List) tchPreDao.getPicture(sql);
	}
	public Page findByPageRequest(PageRequest<Map> pageRequest, TchPre tchPre) {
		return tchPreDao.findByPageRequest(pageRequest,tchPre);
	}
	public Page findByRoommates(PageRequest<Map> pageRequest, String roommates) {
		return tchPreDao.findByRoommates(pageRequest, roommates);
	}
	public TchPre getTchPreById(String id) {
		return tchPreDao.getTchPreById(id);
	}
	public boolean existCar(String enrolid) {
		return tchPreDao.existCar(enrolid);
	}

	
}
