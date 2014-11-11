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
public class TpersonlogJnManager extends BaseManager<TpersonlogJn,Long>{

	private TpersonlogJnDao tpersonlogJnDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpersonlogJnDao(TpersonlogJnDao dao) {
		this.tpersonlogJnDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpersonlogJnDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpersonlogJnDao.findByPageRequest(pr);
	}
	public List getLogJnCountByBusinessCode(String source , String idName, String idCode, 
			String starttime , String endtime) {
		
		return tpersonlogJnDao.getLogJnCountByBusinessCode( source ,  idName,  idCode,
				starttime ,  endtime ) ;
	}
	public List getCompCountByDeptCode(String statisType , String deptCode, String starttime, String endtime) {
		return tpersonlogJnDao.getCompCountByDeptCode(statisType , deptCode , starttime, endtime);
	}
	
	public Page findLogsInfoByPageRequest(PageRequest pr) {
		return tpersonlogJnDao.findLogsInfoByPageRequest(pr);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest pr) {
		return tpersonlogJnDao.findLogsInfoByPageRequestForItem(pr);
	}
}
