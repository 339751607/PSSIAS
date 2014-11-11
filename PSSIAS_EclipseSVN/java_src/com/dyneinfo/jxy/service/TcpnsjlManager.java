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
public class TcpnsjlManager extends BaseManager<Tcpnsjl,java.lang.String>{

	private TcpnsjlDao tcpnsjlDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpnsjlDao(TcpnsjlDao dao) {
		this.tcpnsjlDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpnsjlDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpnsjlDao.findByPageRequest(pr);
	}
	public Tcpnsjl finbyid(String cpcode,String shnd){
		return tcpnsjlDao.getbyid(cpcode, shnd);
	}
	public void insert (Tcpnsjl entity){
	
			tcpnsjlDao.save(entity);
		
	}
	public int getbyidt(String cpcode,String shnd){
		return tcpnsjlDao.Tcpnsjl(cpcode,shnd);
	}
	public void update(Tcpnsjl entity){
		
		tcpnsjlDao.edit(entity);
		
	}
	public void upd(Tcpnsjl entity){
		
		tcpnsjlDao.edit(entity);
		
	}
	public String find(String cpcode){
		return tcpnsjlDao.find(cpcode);
	}
	
	
	
}
