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
public class DictitempmddManager  <E> extends BaseManager<SDictitem,java.lang.String>{

	private DictitempmddDao dictitemDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setDictitempmddDao(DictitempmddDao dao) {
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
}
