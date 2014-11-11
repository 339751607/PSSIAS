/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class StaClpmddManager extends BaseManager<StaCl,Long>{

	private StaClDao staClDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setStaClDao(StaClDao dao) {
		this.staClDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.staClDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return staClDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(String groupSql,PageRequest pr) {
		return staClDao.findByPageRequest(groupSql,pr);
	}
	public String getDeptLevelBySeq(String  deptseq) {
		return (String)staClDao.getDeptLevelBySeq(deptseq);
	}
	public int getTagOrgByDeptseq(String sql){
		return (int)staClDao.getTagOrgByDeptseq(sql);
}
	public String getDeptlevel(String sql){
		return staClDao.getDeptlevel(sql);
}
	public Object getXML(String sql){
		return staClDao.getXML(sql);
	}
	
}
