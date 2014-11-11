/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SatisficInfoManager extends BaseManager<SatisficInfo,java.lang.String>{

	private SatisficInfoDao satisficInfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setSatisficInfoDao(SatisficInfoDao dao) {
		this.satisficInfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.satisficInfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return satisficInfoDao.findByPageRequest(pr);
	}
	public List<SatisficInfo> statisfic(String p_deptId, int p_d, String p_startTime, String p_endTime, String p_type, String p_deptLevel){
		return satisficInfoDao.statisfic(p_deptId,p_d,p_startTime,p_endTime,p_type,p_deptLevel);
	}
}
