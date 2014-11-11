/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.stereotype.Component;

import java.io.Serializable;
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
public class PmdwnsxxbManager<E,PK extends Serializable> extends BaseManager<Pmdwnsxxb,java.lang.String>{

	private PmdwnsxxbDao pmdwnsxxbDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setPmdwnsxxbDao(PmdwnsxxbDao dao) {
		this.pmdwnsxxbDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.pmdwnsxxbDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return pmdwnsxxbDao.findByPageRequest(pr);
	}
	public List findDwbm(String deptId,String chDeptId){
		return pmdwnsxxbDao.findDwbm(deptId,chDeptId);
	}
	
	public int getFindCountById(String dwbm,String nsnd) {
		return (int)pmdwnsxxbDao.getFindCountById(dwbm,nsnd);
	}
	
	public E getById(PK id,String nsnd) {
		return (E)pmdwnsxxbDao.getById(id,nsnd);
	}
	
}
