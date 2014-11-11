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
public class TfeijiuwupinManager extends BaseManager<Tfeijiuwupin,java.lang.String>{

	private TfeijiuwupinDao tfeijiuwupinDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTfeijiuwupinDao(TfeijiuwupinDao dao) {
		this.tfeijiuwupinDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tfeijiuwupinDao;
	}
	public Page findByPageRequest(PageRequest pr,String deptseq) {
		return tfeijiuwupinDao.findByPageRequest(pr,deptseq);
	}
	public String getCurrentMax(String sql,String arg) {
		return (String)tfeijiuwupinDao.getCurrentMax(sql,arg);
	}
	public long  getSeq(){
		return (int)tfeijiuwupinDao.getSeq();
	}
	// 图片id是否存在
	public List getPicIDIsExist( String idcard) {
		return tfeijiuwupinDao.getPicIDIsExist(idcard);
	}
	
	
	public List getPicddryzp( String idcard) {
		return tfeijiuwupinDao.getPicddryzp(idcard);
	}
	public List getPicdwzp( String idcard) {
		return tfeijiuwupinDao.getPicdwzp(idcard);
	}
	public List getPicddrysmzp( String idcard) {
		return tfeijiuwupinDao.getPicddrysmzp(idcard);
	}
	
	
	// 取得照片
	public List getPic(String idcard) {
		return (List) tfeijiuwupinDao.getPic(idcard);
	}
	public Page findQueryList(PageRequest pr){
		 return tfeijiuwupinDao.findQueryList(pr);
	}
	public Tfeijiuwupin getByrq(String rq,String sfzh){
		return tfeijiuwupinDao.getByrq(rq, sfzh);
	}
	//保存图片
	public void savePic(byte[] file,byte[] file1,byte[] file2,Tfeijiuwupin entity) throws IOException{
		tfeijiuwupinDao.savePic(file,file1,file2,entity);
	}
	public List<Tfeijiuwupin> getFjwpList(String rq,String sfzh){
		return tfeijiuwupinDao.getFjwpList(rq, sfzh);
	}
}
