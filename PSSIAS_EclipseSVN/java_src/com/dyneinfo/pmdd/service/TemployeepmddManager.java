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
public class TemployeepmddManager extends BaseManager<Temployee,java.lang.String>{

	private TemployeepmddDao temployeeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTemployeepmddDao(TemployeepmddDao dao) {
		this.temployeeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.temployeeDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return temployeeDao.findByPageRequest(pr);
	}
	public Temployee getTemployeeById(String empcode) {
		return (Temployee)temployeeDao.getTemployeeById(empcode);
		
	}
	
	public int getCountByIdcard(String new_IDCard,String old_IDCard) {
		return (int)temployeeDao.getCountByIdcard(new_IDCard,old_IDCard);
	}
	public List<Temployee> findCyryByDeptId(String deptid) {
		return temployeeDao.findCyryByDeptId(deptid);
	}
	public List<Temployee> findCyryByIdcard(String new_IDCard,String old_IDCard) {
		return temployeeDao.findCyryByIdcard(new_IDCard,old_IDCard);
	}
	
}
