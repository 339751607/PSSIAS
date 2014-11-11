/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
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
public class TcsrxxManager extends BaseManager<Tcsrxx,java.lang.Long>{

	private TcsrxxDao tcsrxxDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcsrxxDao(TcsrxxDao dao) {
		this.tcsrxxDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcsrxxDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcsrxxDao.findByPageRequest(pr);
	}
	public Tcsrxx getById(String id,String cpcode){
		return tcsrxxDao.getById(id,cpcode);
	}
	public void savePic(Tcsrxx tcsrxx,byte[] uploadBytes) throws IOException{
		tcsrxxDao.savePic(tcsrxx,uploadBytes);
	}
	public void updateTcsrxx(Tcsrxx tcsrxx) throws IOException{
		tcsrxxDao.updateTcsrxx(tcsrxx);
	}
	//保存图片
	public void savePic1(byte[] file,byte[] file1,byte[] file2,Tcsrxx entity) throws IOException{
		tcsrxxDao.savePic(file,file1,file2,entity);
	}
	public Page getOldCsrxx(PageRequest pr,String deptid,String s_idcard,String s_csrxm){
		return tcsrxxDao.getOldCsrxx(pr, deptid,s_idcard,s_csrxm);
	}
	public int getRecorderCount(String sql) {
		return tcsrxxDao.getRecorderCount(sql);
	}
}
