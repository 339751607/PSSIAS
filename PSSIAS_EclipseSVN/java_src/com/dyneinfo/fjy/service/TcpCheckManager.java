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
public class TcpCheckManager extends BaseManager<TcpCheck,java.lang.Long>{

	private TcpCheckDao tcpCheckDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpCheckDao(TcpCheckDao dao) {
		this.tcpCheckDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpCheckDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpCheckDao.findByPageRequest(pr);
	}
//	public int getCountByIdcard(String idcard) {
//		return (int)tcpCheckDao.getCountByIdcard(idcard);
//	}
	public Long  getSeq(){
		return this.tcpCheckDao.getSeq();
	}
	
	public void saveCpCheck(TcpCheck entity, Long id, String[] checkItemsArr) {
		tcpCheckDao.save(entity);
		if (checkItemsArr != null && checkItemsArr.length > 0)
			for (int i = 0; i < checkItemsArr.length; i++) {
				TcpCheckInfo cpCheckInfo = new TcpCheckInfo();
				cpCheckInfo.setCheckid(id);
				cpCheckInfo.setItem(checkItemsArr[i]);
				cpCheckInfo.setDetail("");
				tcpCheckDao.saveTcpCheckInfo(cpCheckInfo);
			}
	}
}
