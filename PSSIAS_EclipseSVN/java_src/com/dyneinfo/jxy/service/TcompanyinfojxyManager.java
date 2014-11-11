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
public class TcompanyinfojxyManager extends BaseManager<Tcompanyinfo,java.lang.String>{

	private TcompanyinfojxyDao tcompanyinfojxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcompanyinfojxyDao(TcompanyinfojxyDao dao) {
		this.tcompanyinfojxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcompanyinfojxyDao;
	}
public String getdeptname(String deptid){
	return tcompanyinfojxyDao.deptname(deptid);
}
	public Page findByPageRequest(PageRequest pr) {
		return tcompanyinfojxyDao.findByPageRequest(pr);
	}
	public void Insertdept(Tcompanyinfo entity){
		
		tcompanyinfojxyDao.InsertDept(entity);
		//tcompanyinfoDao.save(entity);
	}
	public void deletedept(String cpcode){
		tcompanyinfojxyDao.deletedept(cpcode);
		tcompanyinfojxyDao.delete(cpcode);
	}
	public int deptCount(String cpcode){
		return tcompanyinfojxyDao.dept(cpcode);
	}
	public int userCount(String cpcode){
		return tcompanyinfojxyDao.User(cpcode);
	}
	public void updateCpname(String cpname,String code){
		tcompanyinfojxyDao.updateCpname(cpname, code);	
	}
	public void updateCpaddress(String cpaddress,String code){
		tcompanyinfojxyDao.updateCpaddress(cpaddress, code);
	}
	public void updatestation(String station ,String code,String deptid,String deptLevel){
		tcompanyinfojxyDao.updatestation(station, code,deptid,deptLevel);
	}
	public void updatepoliceunit(String policeunit ,String code){
		tcompanyinfojxyDao.updatepoliceunit(policeunit, code);
	}
	public void updatepolicename(String policename ,String code){
		tcompanyinfojxyDao.updatepolicename(policename, code);
	}
	public void updateCorpname(String corpname ,String code){
		tcompanyinfojxyDao.updateCorpname(corpname, code);
	}
	public void insertCorpname(Tcompanyinfo entity,String beforeconten,String changedate,String aftercontent,String changecode){
		
		
		tcompanyinfojxyDao.insertCorpname(entity.getCpcode(),beforeconten, changedate, aftercontent, changecode);
		
	}
	
}
