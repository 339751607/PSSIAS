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

import java.io.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class DczyddManager extends BaseManager<Dczydd,java.lang.String>{

	private DczyddDao dczyddDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setDczyddDao(DczyddDao dao) {
		this.dczyddDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.dczyddDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return dczyddDao.findByPageRequest(pr);
	}
	public int getFindCountById(String HTID) {
		return (int)dczyddDao.getFindCountById(HTID);
	}
	
	//取得照片
	public List getDDRYZP(String DNUMBER) {
		return (List)dczyddDao.getDDRYZP(DNUMBER);
	}
	
	public List getDWZP(String DNUMBER) {
		return (List)dczyddDao.getDWZP(DNUMBER);
	}
	
	public List getDDRYSMZP(String DNUMBER){
		return (List)dczyddDao.getDDRYSMZP(DNUMBER);
	}
	
	//图片id是否存在
	public int getPicIDIsExist(String ID) {
		return (int)dczyddDao.getPicIDIsExist(ID);
	}
	//删除图片
	public void removePicById(String D_NUMBER) {
		dczyddDao.removePicById(D_NUMBER);
	}
	
	//保存图片
	public void savePic(byte[] file,byte[] file1,byte[] file2,Dczydd entity) throws IOException{
		dczyddDao.savePic(file,file1,file2,entity);
	}
	//修改图片
	public void updateRyPic(byte[] file ,String D_NUMBER) throws IOException{
		dczyddDao.updateRyPic(file,D_NUMBER);
	}
	
	public void updateRyPicSm(byte[] file ,String D_NUMBER) throws IOException{
		dczyddDao.updateRyPicSm(file,D_NUMBER);
	}
	
	//修改图片
	public void updateDwPic(byte[] file ,String D_NUMBER) throws IOException{
		dczyddDao.updateDwPic(file,D_NUMBER);
	}
	public Dczydd getMaxID(String deptID,String currDate) {
		return (Dczydd)dczyddDao.getMaxID(deptID,currDate);
		
	}
	public List<Dczydd> getPmdwxxbById(String zjhm,String dnumber,String yxzj) {
		return dczyddDao.getPmdwxxbById(zjhm, dnumber, yxzj);
	}
	
	public List<Fcdydd> getfcdyddById(String zjhm,String dnumber,String yxzj){
		return dczyddDao.getfcddfrom(zjhm, dnumber, yxzj);
		
	}
	public List<Clzydd> getcldyddById(String dnumber){
		return dczyddDao.getclddfrom(dnumber);
		
	}
}
