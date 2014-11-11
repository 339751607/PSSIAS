/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.service;

import java.util.List;
import java.util.Map;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.hotel.dao.TtjGuestRepeatDao;
import com.dyneinfo.hotel.model.TchPre;
import com.dyneinfo.hotel.model.TtjGuestRepeat;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TtjGuestRepeatManager extends BaseManager<TtjGuestRepeat,java.lang.String>{

	private TtjGuestRepeatDao tjGuestRepeatDao;
	public TtjGuestRepeatDao getTtjGuestRepeatDao() {
		return tjGuestRepeatDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTtjGuestRepeatDao(TtjGuestRepeatDao dao) {
		this.tjGuestRepeatDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tjGuestRepeatDao;
	}
	public Page findByPageRequest(PageRequest pr,String tableName) {
		return tjGuestRepeatDao.findByPageRequest(pr,tableName);
	}
	public Page findByPageRequest(PageRequest pr) {
		return tjGuestRepeatDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(PageRequest<Map> pageRequest, TtjGuestRepeat tchPre) {
		return tjGuestRepeatDao.findByPageRequest(pageRequest,tchPre);
	}
	public TtjGuestRepeat getTchPreById(String id) {
		return tjGuestRepeatDao.getTchPreById(id);
	}

	
}
