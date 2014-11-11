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
public class TcarinfohotelManager extends BaseManager<Tcarinfo,java.lang.String>{

	private TcarinfohotelDao tcarinfohotelDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcarinfohotelDao(TcarinfohotelDao dao) {
		this.tcarinfohotelDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcarinfohotelDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcarinfohotelDao.findByPageRequest(pr);
	}
	// 取得照片
	public List getPic(String ENROLID) {
		return (List) tcarinfohotelDao.getPic(ENROLID);
	}
	public List getPicture(String sql) {
		return (List) tcarinfohotelDao.getPicture(sql);
	}
	
}
