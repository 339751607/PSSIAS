/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.service;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.springframework.stereotype.Component;

import java.io.Serializable;
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
public class SelectDeptManager  <E> extends BaseManager<SsDept,java.lang.String>{

	private SelectDeptDao SelectDeptDao;
	public SelectDeptDao getSelectDeptDao() {
		return SelectDeptDao;
	}
	public void setSelectDeptDao(SelectDeptDao selectDeptDao) {
		SelectDeptDao = selectDeptDao;
	}
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/

	@Override
	protected EntityDao getEntityDao() {
		// TODO Auto-generated method stub
		return null;
	}
	//根据派出所查企业
	public List getDeptByParentId(String parentId,String deptseq){
		
		return SelectDeptDao.getDeptByParentId(parentId,deptseq);
	}
	//根据派出所分局
//	public List getFj(String deptseq){
//		
//		return SelectDeptDao.getFj(deptseq);
//	}
	
    public List getFjByMpcode(String mpcode,String deptseq){
		
		return SelectDeptDao.getFjByMpcode(mpcode,deptseq);
	}

	//根据查派出所
	public List getPcs(String fjId,String deptseq){
	
		return SelectDeptDao.getPcs(fjId,deptseq);
	}
	//根据派出所查企业
	public List getDeptByParentid(String parentid,String deptseq){

		return SelectDeptDao.getDeptByParentid(parentid,deptseq);
	}
	public String getParentid(String deptid){
		List list=(List)SelectDeptDao.getParentid(deptid);
		if(!list.isEmpty())
		return list.get(0).toString();
		
		return null;
	}	
	//根据id查中文名
	public String getdeptFullName(String deptseq){
		String _deptseq;
		StringBuffer fullName=new StringBuffer();
		_deptseq=deptseq.substring(0, deptseq.length()-1);
		_deptseq="'"+_deptseq.replace(".1000."+DictHelpImpl.getInitData("prcode")+".", "").replace(".", "','")+"'";
		List list=SelectDeptDao.getdeptFullName(_deptseq);
		
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				fullName.append(map.get("deptname"));
			}
		}
		
		System.out.println(fullName.toString());
		return fullName.toString();
	}
	
	//根据分局查派出所
	public List getDeptByDeptId(String deptid){
		
		return SelectDeptDao.getDeptByDeptId(deptid);
	}
	//查询省
	public List<DictItem> getProvince(){
		
		return SelectDeptDao.getProvince();
	}
	//根据省查市
	public List<DictItem> getCityByProvince(String provinceId){
		
		return SelectDeptDao.getCityByProvince(provinceId);
	}
	//根据市查区县
	public List<DictItem> getCountiesByCity(String cityId){
		
		return SelectDeptDao.getCountiesByCity(cityId);
	}
}
