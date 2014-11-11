/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import org.springframework.stereotype.Component;

import java.io.Serializable;
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
public class DictitemManager  <E> extends BaseManager<SDictitem,java.lang.String>{

	private DictitemDao dictitemDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setDictitemDao(DictitemDao dao) {
		this.dictitemDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.dictitemDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return dictitemDao.findByPageRequest(pr);
	}
	
	public List getByParentId(String id) {
		return dictitemDao.getByParentId(id);
	}
	public List getEmployeeById(String id) {
		return dictitemDao.getEmployeeById(id);
	}
	public List getEmpnameByCode(String code) {
		return dictitemDao.getEmpnameByCode(code);
	}
	
}
