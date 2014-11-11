/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TelInfoViewManager extends BaseManager<TelInfoView,java.lang.String>{

	private TelInfoViewDao telInfoViewDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTelInfoViewDao(TelInfoViewDao dao) {
		this.telInfoViewDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.telInfoViewDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return telInfoViewDao.findByPageRequest(pr);
	}
	
}
