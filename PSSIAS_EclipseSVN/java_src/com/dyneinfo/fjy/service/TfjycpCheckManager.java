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
public class TfjycpCheckManager extends BaseManager<TfjycpCheck,java.lang.String>{

	private TfjycpCheckDao tfjycpCheckDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTfjycpCheckDao(TfjycpCheckDao dao) {
		this.tfjycpCheckDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tfjycpCheckDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tfjycpCheckDao.findByPageRequest(pr);
	}
	public TfjycpCheck getById(String id,String t_checktype){
		
		return tfjycpCheckDao.getById(id,t_checktype);
	}
	public int getByIdcard(String idcard,String emptype){
	
		return tfjycpCheckDao.getByIdcard(idcard, emptype);
	}
	public String getCurrentMax(String sql,String arg) {
		return (String)tfjycpCheckDao.getCurrentMax(sql,arg);
	}
	
}
