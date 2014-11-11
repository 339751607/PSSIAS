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
public class TcarlogManager extends BaseManager<Tcarlog,java.lang.Long>{

	private TcarlogDao tcarlogDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcarlogDao(TcarlogDao dao) {
		this.tcarlogDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcarlogDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcarlogDao.findByPageRequest(pr);
	}
	public Page findLogsInfoByPageRequest(PageRequest pr) {
		return tcarlogDao.findLogsInfoByPageRequest(pr);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest pr) {
		return tcarlogDao.findLogsInfoByPageRequestForItem(pr);
	}
	public List getLogCountByBusinessCode(String source , String carid, String starttime , String endtime) {		
		return tcarlogDao.getLogCountByBusinessCode( source ,  carid , starttime ,  endtime ) ;
	}
}
