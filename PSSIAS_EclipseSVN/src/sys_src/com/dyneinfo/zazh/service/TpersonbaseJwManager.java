/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonbaseJwManager extends BaseManager<TpersonbaseJw,Long>{

	private TpersonbaseJwDao tpersonbaseJwDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpersonbaseJwDao(TpersonbaseJwDao dao) {
		this.tpersonbaseJwDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpersonbaseJwDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpersonbaseJwDao.findByPageRequest(pr);
	}

	
}
