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
public class TcppunishinfoManager extends BaseManager<Tcppunishinfo,java.lang.String>{

	private TcppunishinfoDao tcppunishinfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcppunishinfoDao(TcppunishinfoDao dao) {
		this.tcppunishinfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcppunishinfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcppunishinfoDao.findByPageRequest(pr);
	}
	public Tcppunishinfo finbyid(String cpcode,String pfileno){
		return tcppunishinfoDao.finbyid(cpcode, pfileno);
	}
	public void upd(Tcppunishinfo t){
		tcppunishinfoDao.update(t);
	}
	public void del(String cpcode,String pfileno){
		tcppunishinfoDao.deleteById1(cpcode, pfileno);
	}
	public int count(String cpcode,String pfileno){
		return tcppunishinfoDao.Tcpnsjl(cpcode, pfileno);
	}
}
