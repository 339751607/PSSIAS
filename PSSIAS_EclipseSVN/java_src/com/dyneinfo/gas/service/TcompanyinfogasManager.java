/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

import java.io.IOException;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.gas.dao.TcompanyinfogasDao;
import com.dyneinfo.gas.model.Tcompanyinfo;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcompanyinfogasManager extends BaseManager<Tcompanyinfo,java.lang.String>{

	private TcompanyinfogasDao tcompanyinfogasDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcompanyinfogasDao(TcompanyinfogasDao dao) {
		this.tcompanyinfogasDao = dao;
	}
	
	//获得本部门当天最大数据系列号
	public String getMaxDwbm(String fjdm) throws IOException{
		return tcompanyinfogasDao.getMaxDwbm(fjdm);
	}
	
	public void saveTcompanyinfo(Tcompanyinfo tcompanyinfo,SsDept dept,SsUser user,long roleid, long userid) {
		tcompanyinfogasDao.save(tcompanyinfo);
		tcompanyinfogasDao.saveDept(dept);
		tcompanyinfogasDao.saveUser(user);
		tcompanyinfogasDao.insertRoleUser(roleid,userid);
	}
	
	public void updateDept(Tcompanyinfo tcompanyinfo,SsDept ssDept) {
		tcompanyinfogasDao.update(tcompanyinfo);
		tcompanyinfogasDao.updateDept(ssDept);
		
	}
	
	public String getUserSeq(){
		return (String)tcompanyinfogasDao.getUserSeq();
	}
	
	public EntityDao getEntityDao() {
		return this.tcompanyinfogasDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcompanyinfogasDao.findByPageRequest(pr);
	}
	
}
