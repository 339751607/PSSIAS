/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TbuylogManager extends BaseManager<Tbuylog,java.lang.String>{

	private TbuylogDao tbuylogDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTbuylogDao(TbuylogDao dao) {
		this.tbuylogDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tbuylogDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tbuylogDao.findByPageRequest(pr);
	}
	public Page jzfindByPageRequest(PageRequest pr) {
		return tbuylogDao.jzfindByPageRequest(pr);
	}
	public Page pffindByPageRequest(PageRequest pr) {
		return tbuylogDao.pffindByPageRequest(pr);
	}
	public Page gwfindByPageRequest(PageRequest pr) {
		return tbuylogDao.gwfindByPageRequest(pr);
	}
	public Page dlfindByPageRequest(PageRequest pr) {
		return tbuylogDao.dlfindByPageRequest(pr);
	}
	
	public String getCurrentMax(String prefixID) {
		return tbuylogDao.getCurrentMax(prefixID);
	}
	
	// 取得省
	public List getProv() {
		return (List) tbuylogDao.getProv();
	}
	
	//取得所有分局
	public List findAllBureau(){
		return (List)tbuylogDao.findAllBureau();
	}
	
	//取得组织机构
	public List findDept(String sqlWhere){
		return (List)tbuylogDao.findDept(sqlWhere);
	}
	//取得组织机构
	public List findComp(String sqlWhere){
		return (List)tbuylogDao.findComp(sqlWhere);
	}
	
	public List getPicture(String sql) {
		return (List) tbuylogDao.getPicture(sql);
	}
	
}
