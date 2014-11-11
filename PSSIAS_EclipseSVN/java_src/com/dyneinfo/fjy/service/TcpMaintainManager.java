/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpMaintainManager extends BaseManager<TcpMaintain,java.lang.Long>{

	private TcpMaintainDao tcpMaintainDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpMaintainDao(TcpMaintainDao dao) {
		this.tcpMaintainDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpMaintainDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpMaintainDao.findByPageRequest(pr);
	}
	public Long  getSeq(){
		return this.tcpMaintainDao.getSeq();
	}
	public void saveCpCheck(TcpMaintain entity, Long id, String[] mtItemsArr) {
		tcpMaintainDao.save(entity);
		if (mtItemsArr != null && mtItemsArr.length > 0)
			for (int i = 0; i < mtItemsArr.length; i++) {
				TcpMaintainInfo cpMaintainInfo = new TcpMaintainInfo();
				cpMaintainInfo.setMaintainid(id);
				cpMaintainInfo.setItem(mtItemsArr[i]);
				cpMaintainInfo.setDetail("");
				tcpMaintainDao.saveTcpMaintainInfo(cpMaintainInfo);
			}
	}
}
