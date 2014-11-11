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
public class TemployeehotelManager extends BaseManager<Temployee,java.lang.String>{

	private TemployeehotelDao temployeehotelDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTemployeehotelDao(TemployeehotelDao dao) {
		this.temployeehotelDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.temployeehotelDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return temployeehotelDao.findByPageRequest(pr);
	}
	public List getPic(String id) {
		return (List) temployeehotelDao.getPic(id);
	}
	
}
