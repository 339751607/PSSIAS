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
public class VfeijiuwupinStaManager extends BaseManager<VfeijiuwupinSta,Long>{

	private VfeijiuwupinStaDao vfeijiuwupinStaDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setVfeijiuwupinStaDao(VfeijiuwupinStaDao dao) {
		this.vfeijiuwupinStaDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.vfeijiuwupinStaDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return vfeijiuwupinStaDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(String groupSql,PageRequest pr) {
		return vfeijiuwupinStaDao.findByPageRequest(groupSql,pr);
	}
	
	public String getDeptLevelBySeq(String  deptseq) {
		return (String)vfeijiuwupinStaDao.getDeptLevelBySeq(deptseq);
	}
	public Object getXML(String sql){
		return vfeijiuwupinStaDao.getXML(sql);
	}
	
}
