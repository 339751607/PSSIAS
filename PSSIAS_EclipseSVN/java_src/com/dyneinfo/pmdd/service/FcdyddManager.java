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
public class FcdyddManager extends BaseManager<Fcdydd,java.lang.String>{

	private FcdyddDao fcdyddDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setFcdyddDao(FcdyddDao dao) {
		this.fcdyddDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.fcdyddDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return fcdyddDao.findByPageRequest(pr);
	}
	//保存图片
	public void savePic(byte[] file,byte[] file1,byte[] file2,Fcdydd entity) throws IOException{
		fcdyddDao.savePic(file,file1,file2,entity);
	}
	//取得照片
	public List getPic(String DNUMBER) {
		return (List)fcdyddDao.getPic(DNUMBER);
	}
	
	public List getPicture(String sql) {
		return (List) fcdyddDao.getPicture(sql);
	}
	//修改图片
	public void updatePic(byte[] file ,String D_NUMBER) throws IOException{
		fcdyddDao.updatePic(file,D_NUMBER);
	}
	
	//取得扫描照片
	public List getSmPic(String DNUMBER) {
		return (List)fcdyddDao.getSmPic(DNUMBER);
	}
	//修改扫描图片
	public void updateSmPic(byte[] file ,String D_NUMBER) throws IOException{
		fcdyddDao.updateSmPic(file,D_NUMBER);
	}
	
	//取得扫描照片
	public List getDwPic(String DNUMBER) {
		return (List)fcdyddDao.getDwPic(DNUMBER);
	}
	//修改扫描图片
	public void updateDwPic(byte[] file ,String D_NUMBER) throws IOException{
		fcdyddDao.updateDwPic(file,D_NUMBER);
	}
	public int getFindCountById(String HTID) {
		return (int)fcdyddDao.getFindCountById(HTID);
	}
	public Fcdydd getMaxID(String deptID,String currDate) {
		return (Fcdydd)fcdyddDao.getMaxID(deptID,currDate);
		
	}
}
