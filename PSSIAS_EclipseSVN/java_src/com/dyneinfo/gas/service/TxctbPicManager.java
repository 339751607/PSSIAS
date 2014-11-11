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
public class TxctbPicManager extends BaseManager<TxctbPic,Long>{

	private TxctbPicDao txctbPicDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTxctbPicDao(TxctbPicDao dao) {
		this.txctbPicDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.txctbPicDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return txctbPicDao.findByPageRequest(pr);
	}
	
	// 保存图片
	public void savePic(File file, TxctbPic entity) throws IOException {
		txctbPicDao.savePic(file, entity);
	}
	
	// 取得照片
	public List getPic(String ID) {
		return (List) txctbPicDao.getPic(ID);
	}
	
}
