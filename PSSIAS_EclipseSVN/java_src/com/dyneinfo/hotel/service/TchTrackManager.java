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
public class TchTrackManager extends BaseManager<TchTrack,java.lang.String>{

	private TchTrackDao tchTrackDao;
	public TchTrackDao getTchTrackDao() {
		return tchTrackDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTchTrackDao(TchTrackDao dao) {
		this.tchTrackDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tchTrackDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tchTrackDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(String sql, PageRequest pageRequest) {
		return tchTrackDao.findByPageRequest(sql,pageRequest);
	}

	
}
