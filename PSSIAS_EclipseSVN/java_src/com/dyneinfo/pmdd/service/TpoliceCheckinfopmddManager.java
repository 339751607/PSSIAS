/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpoliceCheckinfopmddManager extends BaseManager<TpoliceCheckinfo,Long>{

	private TpoliceCheckinfopmddDao tpoliceCheckinfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpoliceCheckinfopmddDao(TpoliceCheckinfopmddDao dao) {
		this.tpoliceCheckinfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpoliceCheckinfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpoliceCheckinfoDao.findByPageRequest(pr);
	}
	
}
