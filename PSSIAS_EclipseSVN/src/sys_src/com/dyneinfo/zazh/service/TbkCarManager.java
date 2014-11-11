/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.service;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TbkCarManager extends BaseManager<TbkCar,java.lang.String>{

	private TbkCarDao tbkCarDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTbkCarDao(TbkCarDao dao) {
		this.tbkCarDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tbkCarDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tbkCarDao.findByPageRequest(pr);
	}
	public Number getSeq(){
		return tbkCarDao.getSeq();
	}
	//图片id是否存在
	public int getPicIDIsExist(String BKID) {
		return (int)tbkCarDao.getPicIDIsExist(BKID);
	}
	//保存图片
	public void savePicSingle(File file,String BKID)  throws IOException {
		tbkCarDao.savePic(file , BKID);
	}
	//修改图片
	public void updatePicSingle(File file  ,String ID)  throws IOException {
		tbkCarDao.updatePic(file , ID);
	}
	//取得照片
	public List getPic(String BKID) {
		return (List)tbkCarDao.getPic(BKID);
	}
}
