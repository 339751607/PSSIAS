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
public class TcpchangeManager extends BaseManager<Tcpchange,java.lang.String>{

	private TcpchangeDao tcpchangeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpchangeDao(TcpchangeDao dao) {
		this.tcpchangeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpchangeDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpchangeDao.findByPageRequest(pr);
	}
	
}
