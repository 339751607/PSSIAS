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
public class VemployeeStaManager extends BaseManager<VemployeeSta,Long>{

	private VemployeeStaDao vemployeeStaDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setVemployeeStaDao(VemployeeStaDao dao) {
		this.vemployeeStaDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.vemployeeStaDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return vemployeeStaDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(String groupSql,PageRequest pr) {
		return vemployeeStaDao.findByPageRequest(groupSql,pr);
	}
	public String getDeptLevelBySeq(String  deptseq) {
		return (String)vemployeeStaDao.getDeptLevelBySeq(deptseq);
	}
	public Object getXML(String sql){
		return vemployeeStaDao.getXML(sql);
	}
}
