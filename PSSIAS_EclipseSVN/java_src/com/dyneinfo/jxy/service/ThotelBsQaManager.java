/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class ThotelBsQaManager extends BaseManager<ThotelBsQa,Long>{

	private ThotelBsQaDao thotelBsQaDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setThotelBsQaDao(ThotelBsQaDao dao) {
		this.thotelBsQaDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.thotelBsQaDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return thotelBsQaDao.findByPageRequest(pr);
	}
	
}
