/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
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
public class ClzyddManager extends BaseManager<Clzydd,java.lang.String>{

	private ClzyddDao clzyddDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setClzyddDao(ClzyddDao dao) {
		this.clzyddDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.clzyddDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return clzyddDao.findByPageRequest(pr);
	}

	//取得照片
	public List getPicRy(String DNUMBER) {
		return (List)clzyddDao.getPicRy(DNUMBER);
	}
	//修改图片
	public void updatePicRy(byte[] file ,String D_NUMBER) throws IOException{
		clzyddDao.updatePicRy(file,D_NUMBER);
	}
	
	
	
	//取得照片
	public List getPicSmRy(String DNUMBER) {
		return (List)clzyddDao.getPicSmRy(DNUMBER);
	}
	//修改图片
	public void updatePicSmRy(byte[] file ,String D_NUMBER) throws IOException{
		clzyddDao.updatePicSmRy(file,D_NUMBER);
	}
	
	
	//取得照片
	public List getPicDw(String DNUMBER) {
		return (List)clzyddDao.getPicDw(DNUMBER);
	}
	//修改图片
	public void updatePicDw(byte[] file ,String D_NUMBER) throws IOException{
		clzyddDao.updatePicDw(file,D_NUMBER);
	}
	
	public void savePic(byte[] file,byte[] file1,byte[] file2,Clzydd entity) throws IOException{
		clzyddDao.savePic(file,file1,file2,entity);
	}
	public int getFindCountById(String HTID) {
		return (int)clzyddDao.getFindCountById(HTID);
	}
	public String getMaxID(String deptID,String currDate) {
		return (String)clzyddDao.getMaxID(deptID,currDate);
		
	}
	
}
