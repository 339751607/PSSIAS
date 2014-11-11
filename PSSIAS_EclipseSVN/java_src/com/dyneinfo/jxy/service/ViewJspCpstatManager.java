/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import org.springframework.stereotype.Component;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class ViewJspCpstatManager extends BaseManager<ViewJspCpstat,java.lang.String>{

	private ViewJspCpstatDao viewJspCpstatDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setViewJspCpstatDao(ViewJspCpstatDao dao) {
		this.viewJspCpstatDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.viewJspCpstatDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return viewJspCpstatDao.findByPageRequest(pr);
	}
	public Page findByPageRequest(String groupSql,PageRequest pr) {
		return viewJspCpstatDao.findByPageRequest(groupSql,pr);
	}
	
	public String getParentIDByDeptSeq(String  sql) {
		return (String)viewJspCpstatDao.getParentIDByDeptSeq(sql);
	}
	
	public Object getXML(String sql){
		return viewJspCpstatDao.getXML(sql);
	}
	
	public String getColBySql(String  sql) {
		return viewJspCpstatDao.getColBySql(sql);
	}
	
}
