/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeegasManager extends BaseManager<Temployee,java.lang.String>{

	private TemployeegasDao temployeegasDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTemployeegasDao(TemployeegasDao dao) {
		this.temployeegasDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.temployeegasDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return temployeegasDao.findByPageRequest(pr);
	}
	// 取得照片
	public List getPic(String ID) {
		return (List) temployeegasDao.getPic(ID);
	}
	

	public String getCurrentMax(String prefixID) {
		return temployeegasDao.getCurrentMax(prefixID);
	}
	
	
}
