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
public class TpersonlogJwManager extends BaseManager<TpersonlogJw,Long>{

	private TpersonlogJwDao tpersonlogJwDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTpersonlogJwDao(TpersonlogJwDao dao) {
		this.tpersonlogJwDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tpersonlogJwDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tpersonlogJwDao.findByPageRequest(pr);
	}
	
	public List getLogJnCountByBusinessCode(String source , String passT , String passNo, 
			                                String s_starttime , String s_endtime) {
		
		return tpersonlogJwDao.getLogJnCountByBusinessCode( source ,  passT ,  passNo,
				s_starttime ,  s_endtime ) ;
	}
	public Page findLogsInfoByPageRequest(PageRequest pr) {
		return tpersonlogJwDao.findLogsInfoByPageRequest(pr);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest pr) {
		return tpersonlogJwDao.findLogsInfoByPageRequestForItem(pr);
	}
}
