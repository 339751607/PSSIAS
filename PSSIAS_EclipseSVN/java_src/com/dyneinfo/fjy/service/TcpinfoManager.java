/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import org.springframework.dao.DataAccessException;
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
public class TcpinfoManager extends BaseManager<Tcpinfo,java.lang.String>{

	private TcpinfoDao tcpinfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpinfoDao(TcpinfoDao dao) {
		this.tcpinfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpinfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcpinfoDao.findByPageRequest(pr);
	}
	//企业代码存在否
	public int getCountCpcode(String Cpcod) {
		return (int)tcpinfoDao.getCountCpcode(Cpcod);
	}
	public int getCountDept(String Cpcod) {
		return (int)tcpinfoDao.getCountDept(Cpcod);
	}
	public Tcpinfo getTcpinfoById(java.lang.String cpcode) {
		return (Tcpinfo)tcpinfoDao.getTcpinfoById(cpcode);
	}
	public void deleteSSdeptinfo(String arg) {
		tcpinfoDao.deleteSSdeptinfo(arg);
	}
	public String getCurrentMax(String sql) {
		return (String)tcpinfoDao.getCurrentMax(sql);
	}
	public List getCpinfoFzr(String sql) {
		return (List)tcpinfoDao.getCpinfoFzr(sql);
	}
	
	public List getCpinfoSta(String sql) {
		return (List)tcpinfoDao.getCpinfoSta(sql);
	}
	public void insertiscode(Tcpinfo entity){
		tcpinfoDao.insertiscode(entity);
		
	}
	public String typecode(String id){
		return tcpinfoDao.gettypecode(id);
		
	}
	public String orcmmcode(String id){  //查询扫描仪授权码
		return tcpinfoDao.getorcmmcode(id);
		
	}
	
	
	public void insertDeptRole(String roleid, String deptid) {
		tcpinfoDao.insertDeptRole(roleid, deptid);
		
	}
	
	
}
