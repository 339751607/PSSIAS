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
public class TpoliceCheckjxyManager extends BaseManager<TpoliceCheck,Long>{

	private TpoliceCheckjxyDao tpoliceCheckjxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpoliceCheckjxyDao(TpoliceCheckjxyDao dao) {
		this.tpoliceCheckjxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpoliceCheckjxyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpoliceCheckjxyDao.findByPageRequest(pr);
	}
	
    public TpoliceCheck getTpoliceCheckById(java.lang.Long checkid) {
    	return (TpoliceCheck)tpoliceCheckjxyDao.getTpoliceCheckById(checkid);
	}
    
	public void saveTpoliceCheckinfo(TpoliceCheckinfo entity) {
		tpoliceCheckjxyDao.saveTpoliceCheckinfo(entity);
	}
	public void saveTpoliceCheck(TpoliceCheck entity) {
		tpoliceCheckjxyDao.saveTpoliceCheck(entity);
	}
	
	public void saveTpoliceCheckAndCheckInfo(TpoliceCheckinfo policeCheckinfo,TpoliceCheck policeCheck) {
		tpoliceCheckjxyDao.saveTpoliceCheck(policeCheck);
		tpoliceCheckjxyDao.saveTpoliceCheckinfo(policeCheckinfo);
	}
	
	public Long  getSeq(){
		return (Long)tpoliceCheckjxyDao.getSeq();
	}
	
	public Long  getSeqCheckinfo(){
		return (Long)tpoliceCheckjxyDao.getSeqCheckinfo();
		
	}
	
}
