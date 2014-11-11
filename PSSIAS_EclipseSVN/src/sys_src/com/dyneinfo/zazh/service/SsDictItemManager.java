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
public class SsDictItemManager extends BaseManager<SsDictItem,java.lang.String>{

	private SsDictItemDao ssDictItemDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSsDictItemDao(SsDictItemDao dao) {
		this.ssDictItemDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ssDictItemDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ssDictItemDao.findByPageRequest(pr);
	}
	public void removeRecorderById(String  dicttypeid) {
		ssDictItemDao.removeRecorderById(dicttypeid);
	}
	public SsDictItem getFindById(String DICTTYPEID,String DICTID) {
		return (SsDictItem)ssDictItemDao.getFindById(DICTTYPEID,DICTID);
	}
	public void removeRecorderById(String dicttypeid, String dictid) {
		ssDictItemDao.removeRecorderById(dicttypeid,dictid);
	}
	
}
