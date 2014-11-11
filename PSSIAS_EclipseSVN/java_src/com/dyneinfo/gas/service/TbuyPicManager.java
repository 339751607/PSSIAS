/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

import org.springframework.stereotype.Component;

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
public class TbuyPicManager extends BaseManager<TbuyPic,java.lang.String>{

	private TbuyPicDao tbuyPicDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTbuyPicDao(TbuyPicDao dao) {
		this.tbuyPicDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tbuyPicDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tbuyPicDao.findByPageRequest(pr);
	}
	
	// 取得照片
	public List getPic(String ID) {
		return (List) tbuyPicDao.getPic(ID);
	}
	
}
