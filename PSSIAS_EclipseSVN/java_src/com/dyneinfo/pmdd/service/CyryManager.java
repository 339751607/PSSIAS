/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.dao.DataAccessException;
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
public class CyryManager extends BaseManager<Cyry,java.lang.String>{

	private CyryDao cyryDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setCyryDao(CyryDao dao) {
		this.cyryDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.cyryDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return cyryDao.findByPageRequest(pr);
	}
	public Cyry getCyryById(String dwbm,String dwnbm) {
		return (Cyry)cyryDao.getCyryById(dwbm,dwnbm);
		
	}
	public void removeRecorderById(String dwbm,String dwnbm) {
		 cyryDao.removeRecorderById(dwbm,dwnbm);
	}
	public String getCurrentMax(String arg) {
		return (String)cyryDao.getCurrentMax(arg);
	}
	public List<Cyry> findCyryByDeptId(String deptid) {
		return cyryDao.findCyryByDeptId(deptid);
	}
	
}
