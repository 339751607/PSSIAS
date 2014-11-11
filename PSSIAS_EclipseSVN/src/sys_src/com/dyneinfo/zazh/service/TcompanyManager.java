/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcompanyManager extends BaseManager<Tcompany,java.lang.String>{

	private TcompanyDao tcompanyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcompanyDao(TcompanyDao dao) {
		this.tcompanyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcompanyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcompanyDao.findByPageRequest(pr);
	}
	public List getCompCountByDeptCode(String statisType , String deptCode,String status) {
		return tcompanyDao.getCompCountByDeptCode(statisType , deptCode , status);
	}
}
