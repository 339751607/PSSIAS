/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeejxyManager extends BaseManager<Temployee,java.lang.String>{

	private TemployeejxyDao temployeejxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTemployeejxyDao(TemployeejxyDao dao) {
		this.temployeejxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.temployeejxyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return temployeejxyDao.findByPageRequest(pr);
	}
	public Temployee getTemployeeById(String empcode,String cpcode) {
		return (Temployee)temployeejxyDao.getTemployeeById(empcode,cpcode);
		
	}
	
	public int getCountByIdcard(String new_IDCard,String old_IDCard) {
		return (int)temployeejxyDao.getCountByIdcard(new_IDCard,old_IDCard);
	}
	public List<Temployee> findCyryByDeptId(String deptid) {
		return temployeejxyDao.findCyryByDeptId(deptid);
	}
	public List<Temployee> findCyryByIdcard(String new_IDCard,String old_IDCard) {
		return temployeejxyDao.findCyryByIdcard(new_IDCard,old_IDCard);
	}
	//保存图片
	public void savePic(File file,Temployee temployee) throws IOException{
		temployeejxyDao.savePic(file,temployee);
	}
	public void savePic1(byte[] file,Temployee temployee) throws IOException{
		temployeejxyDao.savePic1(file,temployee);
	}

	// 取得照片
	public List getPic(String ENROLID,String cpcode) {
		return (List) temployeejxyDao.getPic(ENROLID,cpcode);
	}
	// 修改图片
	public void updatePic(File file, String enrolid) throws IOException {
		temployeejxyDao.updatePic(file,enrolid);
	}
}
