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
public class TcpcaseinfoManager extends BaseManager<Tcpcaseinfo,java.lang.String>{

	private TcpcaseinfoDao tcpcaseinfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpcaseinfoDao(TcpcaseinfoDao dao) {
		this.tcpcaseinfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpcaseinfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpcaseinfoDao.findByPageRequest(pr);
	}
	public Tcpcaseinfo getById(String cpcode,String casecode){
		return tcpcaseinfoDao.getById(cpcode, casecode);
		
	}
	public void removeById1(String cpcode,String casecode){
		 tcpcaseinfoDao.deleteById1(cpcode, casecode);
	}
	public int count(String cpcode,String cassecode){
		return tcpcaseinfoDao.Tcpnsjl(cpcode, cassecode);
	}
}
