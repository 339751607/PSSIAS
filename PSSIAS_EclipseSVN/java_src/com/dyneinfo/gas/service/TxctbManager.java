/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TxctbManager extends BaseManager<Txctb,Long>{

	private TxctbDao txctbDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTxctbDao(TxctbDao dao) {
		this.txctbDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.txctbDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return txctbDao.findByPageRequest(pr);
	}
	
	public long  getSeq(){
		return (int)txctbDao.getSeq();
	}
	// 取得照片
	public List getPic(String ID) {
		return (List) txctbDao.getPic(ID);
	}
	
}
