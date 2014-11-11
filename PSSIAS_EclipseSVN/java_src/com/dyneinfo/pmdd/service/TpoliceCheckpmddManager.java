/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
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
public class TpoliceCheckpmddManager extends BaseManager<TpoliceCheck,Long>{

	private TpoliceCheckpmddDao tpoliceCheckDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpoliceCheckpmddDao(TpoliceCheckpmddDao dao) {
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
    
	public void saveTpoliceCheckinfo(TpoliceCheckinfo entity) {
		tpoliceCheckDao.saveTpoliceCheckinfo(entity);
	}
	public void saveTpoliceCheck(TpoliceCheck entity) {
		tpoliceCheckDao.saveTpoliceCheck(entity);
	}
	
	public void saveTpoliceCheckAndCheckInfo(TpoliceCheckinfo policeCheckinfo,TpoliceCheck policeCheck) {
		tpoliceCheckDao.saveTpoliceCheck(policeCheck);
		tpoliceCheckDao.saveTpoliceCheckinfo(policeCheckinfo);
	}
	
	public Long  getSeq(){
		return (Long)tpoliceCheckDao.getSeq();
	}
	
	public Long  getSeqCheckinfo(){
		return (Long)tpoliceCheckDao.getSeqCheckinfo();
		
	}
	
}
