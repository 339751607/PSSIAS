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
public class TjwPreManager extends BaseManager<TjwPre,java.lang.String>{

	private TjwPreDao tjwPreDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTjwPreDao(TjwPreDao dao) {
		this.tjwPreDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tjwPreDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tjwPreDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(PageRequest pr,String tableName) {
		return tjwPreDao.findByPageRequest(pr,tableName);
	}
	public List getPic(String id) {
		return (List) tjwPreDao.getPic(id);
	}
}
