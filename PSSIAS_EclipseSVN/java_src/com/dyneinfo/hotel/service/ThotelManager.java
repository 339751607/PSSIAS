/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class ThotelManager extends BaseManager<Thotel,java.lang.String>{

	private ThotelDao thotelDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setThotelDao(ThotelDao dao) {
		this.thotelDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.thotelDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return thotelDao.findByPageRequest(pr);
	}
	public List getHotelNameBySta(String key) {
		return thotelDao.getHotelNameBySta(key);
	}
	public List getHotelNameByName(String hotelname) {
		return thotelDao.getHotelNameByName(hotelname);
	}
}
