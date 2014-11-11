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
public class ShxxpmddManager extends BaseManager<Shxx,java.lang.String>{

	private ShxxDao shxxDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setShxxDao(ShxxDao dao) {
		this.shxxDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.shxxDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return shxxDao.findByPageRequest(pr);
	}
	//取得档案编号 当物名称
	public List getDwxx(String sql) {
		return shxxDao.getDwxx(sql);
	}
	public void savePic(byte[] file, Shxx entity) throws IOException {
		 shxxDao.savePic(file,entity);
	}
	public int getFindCountById(String sql) {
		return (int)shxxDao.getFindCountById(sql);
	}
	public long  getSeq(){
		return (int)shxxDao.getSeq();
	}
	public void updateFlagShiFouShuHui(String sql ,String D_NUMBER) {
		shxxDao.updateFlagShiFouShuHui(sql,D_NUMBER);
	}
	//取得照片
	public List getPic(String DNUMBER,String flag) {
		return (List)shxxDao.getPic(DNUMBER,flag);
	}
	//取得赎回人照片
	public List getShrPic(String DNUMBER,String flag) {
		return (List)shxxDao.getShrPic(DNUMBER,flag);
	}
	//修改图片
	public void updatePic(File file ,String D_NUMBER,String flag) throws IOException{
		shxxDao.updatePic(file,D_NUMBER,flag);
	}
	public Shxx getShxxById(String D_NUMBER,String FLAG) {
		return (Shxx)shxxDao.getShxxById(D_NUMBER,FLAG);
	}
	public void updateExt(Shxx entity) {
		shxxDao.updateExt(entity);
	}
	
	
	
	
}
