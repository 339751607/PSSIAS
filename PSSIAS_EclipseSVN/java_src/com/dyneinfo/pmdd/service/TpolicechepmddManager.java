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
public class TpolicechepmddManager extends BaseManager<Tpoliceche,Long>{

	private TpolicechepmddDao tpolicecheDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpolicechepmddDao(TpolicechepmddDao dao) {
		this.tpolicecheDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpolicecheDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpolicecheDao.findByPageRequest(pr);
	}
	
	public Page findByPageRequest_ht(PageRequest pr) {
		return tpolicecheDao.findByPageRequest_ht(pr);
	}
	public String username(String userid){
		return tpolicecheDao.username(userid);
		
	}
	public String count(String userid){
		return tpolicecheDao.count(userid);
		
	}
	
}
