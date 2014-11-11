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
public class SsDictTypeManager extends BaseManager<SsDictType,java.lang.String>{

	private SsDictTypeDao ssDictTypeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsDictTypeDao(SsDictTypeDao dao) {
		this.ssDictTypeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssDictTypeDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssDictTypeDao.findByPageRequest(pr);
	}
	public int getFindCountById(String dicttypeid) {
		return (int)ssDictTypeDao.getFindCountById(dicttypeid);
	}
	
}
