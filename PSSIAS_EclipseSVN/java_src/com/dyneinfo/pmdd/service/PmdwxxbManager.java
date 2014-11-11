/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.util.Encry;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class PmdwxxbManager extends BaseManager<Pmdwxxb,java.lang.String>{

	private PmdwxxbDao pmdwxxbDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setPmdwxxbDao(PmdwxxbDao dao) {
		this.pmdwxxbDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.pmdwxxbDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return pmdwxxbDao.findByPageRequest(pr);
	}
	public int getFindCountById(String dwbm) {
		return (int)pmdwxxbDao.getFindCountById(dwbm);
	}
	public Pmdwxxb getPmdwxxbById(String  dwbm) {
		return (Pmdwxxb)pmdwxxbDao.getPmdwxxbById(dwbm);
	}
	public String getFjmcByFjdm(String fjdm){
		return pmdwxxbDao.getFjmcByFjdm(fjdm);
	}
	//获得本部门当天最大数据系列号
	public String getMaxDwbm(String fjdm) throws IOException{
		String maxSequence=String.valueOf(pmdwxxbDao.getMaxDwbm(fjdm)+1);
		int x=4-maxSequence.length();
		for(int i=0;i<x;i++){
			maxSequence=0+maxSequence;
		}
		return maxSequence;
	}
	
	public String getQybmzjz() throws IOException{
		String qybmzjz = pmdwxxbDao.getZjzDwbm();
		return qybmzjz;
	}
	
	public int getQyjs(){
		return pmdwxxbDao.getQyjs();
	}
	public List getRegistrationInfo() {
		return (List)pmdwxxbDao.getRegistrationInfo();
	}
	
	public void saveDept(SsDept entity) {
		pmdwxxbDao.saveDept(entity);
	}
	
	public void saveUser(SsUser entity) {
		pmdwxxbDao.saveUser(entity);
	}
	
	public String getUserSeq(){
		return (String)pmdwxxbDao.getUserSeq();
	}
	
	public void insertRoleUser(long roleid, long userid) {
		pmdwxxbDao.insertRoleUser(roleid,userid);
	}
	
	public void savePmdwxxb(Pmdwxxb pmdwxxb,SsDept dept,SsUser user,long roleid, long userid) {
		pmdwxxbDao.save(pmdwxxb);
		pmdwxxbDao.saveDept(dept);
		pmdwxxbDao.saveUser(user);
		pmdwxxbDao.insertRoleUser(roleid,userid);
	}
	
	public void updateDept(Pmdwxxb pmdwxxb,SsDept ssDept) {
		pmdwxxbDao.update(pmdwxxb);
		pmdwxxbDao.updateDept(ssDept);
		
	}
	public void updatecode(Pmdwxxb pmdwxxb){
		pmdwxxbDao.updatecode(pmdwxxb);
	}

	public String getsmycode(String dwbm) {
		Encry en = new Encry();
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		String smycode = pmdwxxbDao.getsmycode(dwbm);
		if (!"".equals(smycode)&& null != smycode) {
			if("1".equals(jmType)){
				smycode = en.crypt_pwd("e", "energetically", smycode);
			}else{
				smycode = en.crypt_pwd("e", "smyesok", smycode);
			}
			if (smycode.equals(dwbm)) {
				return "1";
			} else {
				return "0";
			}
		} else {
			return "0";
		}

	}

	public String gettypecode(String dwbm) {
		Encry en = new Encry();
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		String typecode = pmdwxxbDao.gettypecode(dwbm);
		if (!"".equals(typecode) &&  null != typecode) {
			if("1".equals(jmType)){
				typecode = en.crypt_pwd("e", "actively", typecode);
			}else{
				typecode = en.crypt_pwd("e", "bsdkyes", typecode);
			}
			if (typecode.equals(dwbm)) {
				return "1";
			} else {
				return "0";
			}
		} else {
			return "0";
		}
	}
		
}
