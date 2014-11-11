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
public class TcarinfoManager extends BaseManager<Tcarinfo,java.lang.String>{

	private TcarinfoDao tcarinfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcarinfoDao(TcarinfoDao dao) {
		this.tcarinfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcarinfoDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return tcarinfoDao.findByPageRequest(pr);
	}
	public Page findByPageRequest1(PageRequest pr) {
		return tcarinfoDao.findByPageRequest1(pr);
	}
	
	
	//保存图片
	public void savePic(File file,Tcarinfo tcarinfo) throws IOException{
		tcarinfoDao.savePic(file,tcarinfo);
	}
	//获得本部门当天最大数据系列号
	public String getMaxSequence(String sequence) throws IOException{
		String maxSequence=String.valueOf(tcarinfoDao.getMaxSequence(sequence)+1);
		int x=3-maxSequence.length();
		for(int i=0;i<x;i++){
			maxSequence=0+maxSequence;
		}
		return maxSequence;
		
	}
	// 取得照片
	public List getPic(String ENROLID) {
		return (List) tcarinfoDao.getPic(ENROLID);
	}
	
	public List getJsz(String name) {
		return (List) tcarinfoDao.getJsz(name);
	}
	// 修改图片
	public void updatePic(File file, String enrolid) throws IOException {
		tcarinfoDao.updatePic(file,enrolid);
	}
	//获得字典表服务项目数据
	public List getServeritemForLevelOne() {
		return tcarinfoDao.getServeritemForLevelOne();
	}
	public List getServeritemForLevelTwo(){
		return tcarinfoDao.getServeritemForLevelTwo();
	}

	public List getServeritem() {
		return tcarinfoDao.getServeritem();
	}

	public List getInfoByCarid(String carid){
		return tcarinfoDao.getInfoByCarid(carid);
	}
	public List getPicture(String sql) {
		return (List) tcarinfoDao.getPicture(sql);
	}
}
