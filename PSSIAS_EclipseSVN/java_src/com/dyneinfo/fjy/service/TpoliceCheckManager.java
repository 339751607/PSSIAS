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
public class TpoliceCheckManager extends BaseManager<TpoliceCheck,Long>{

	private TpoliceCheckDao tpoliceCheckDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpoliceCheckDao(TpoliceCheckDao dao) {
		this.tpoliceCheckDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpoliceCheckDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpoliceCheckDao.findByPageRequest(pr);
	}
    public TpoliceCheck getTpoliceCheckById(java.lang.Long checkid) {
	return (TpoliceCheck)tpoliceCheckDao.getTpoliceCheckById(checkid);
	}
  
}
