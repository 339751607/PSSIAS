/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpinfoYlManager extends BaseManager<TcpinfoYl,java.lang.String>{

	private TcpinfoYlDao tcpinfoYlDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpinfoYlDao(TcpinfoYlDao dao) {
		this.tcpinfoYlDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpinfoYlDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpinfoYlDao.findByPageRequest(pr);
	}
	
}
