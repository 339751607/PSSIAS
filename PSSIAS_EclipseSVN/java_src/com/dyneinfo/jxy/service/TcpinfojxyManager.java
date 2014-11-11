/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

import java.io.IOException;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.security.userdetails.jdbc.MySecurityJdbcDaoImpl;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.dao.TcpinfojxyDao;
import com.dyneinfo.jxy.model.Tcpinfo;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.zazh.util.Encry;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpinfojxyManager extends BaseManager<Tcpinfo,java.lang.String>{
	Encry en = new Encry();
	private TcpinfojxyDao tcpinfojxyDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTcpinfojxyDao(TcpinfojxyDao dao) {
		this.tcpinfojxyDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcpinfojxyDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		
		return tcpinfojxyDao.findByPageRequest(pr);
	}
	
	//获得本部门当天最大数据系列号
	public String getMaxDwbm(String fjdm) throws IOException{
		String maxSequence=tcpinfojxyDao.getMaxDwbm(fjdm);
		
		return maxSequence;
	}
	
	/**
	 * 从配置文件中读取企业编码的中间值
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getQybmzjz() throws IOException {
		String qybmzjz = tcpinfojxyDao.getQybmzjz();
		return qybmzjz;
	}
	
	public void saveUser(SsUser entity) {
		tcpinfojxyDao.saveUser(entity);
	}
	
	public String getUserSeq(){
		return (String)tcpinfojxyDao.getUserSeq();
	}
	
	public void insertRoleUser(long roleid, long userid) {
		tcpinfojxyDao.insertRoleUser(roleid,userid);
	}
	
	public void savePmdwxxb(Tcpinfo tcpinfo,SsDept dept,SsUser user,long roleid, long userid) {
		tcpinfojxyDao.save(tcpinfo);
		tcpinfojxyDao.saveDept(dept);
		tcpinfojxyDao.saveUser(user);
		tcpinfojxyDao.insertRoleUser(roleid,userid);
	}
	
	public void updateDept(Tcpinfo tcpinfo,SsDept ssDept) {
		tcpinfojxyDao.update(tcpinfo);
		tcpinfojxyDao.updateDept(ssDept);
		
	}
	
	public int isExistChildDept(String cpcode){
		return (int)tcpinfojxyDao.isExistChildDept(cpcode);
	}
	public int isExistUser(String cpcode){
		return (int)tcpinfojxyDao.isExistUser(cpcode);
	}
	public void deleteCpinfo(String code){
		tcpinfojxyDao.deleteDept(code);
		tcpinfojxyDao.deleteCpinfo(code);
		tcpinfojxyDao.deleteUserandrole(code);   //添加删除用户和角色表信息
		
	}
	public int cpcode(){
		return tcpinfojxyDao.cpcode();
	}
	public void updatecode(Tcpinfo tcpinfo){
		tcpinfojxyDao.insertiscode(tcpinfo);
	}
	//扫描仪授权码验证
	public String smycode(String code) {
		Tcpinfo tcpinfo = tcpinfojxyDao.getById(code);
		if (tcpinfo.getSmycode() != null && !tcpinfo.getSmycode().equals("")) {
			String jmType = (String) DictHelpImpl.getInitData("JmType");
			String type = "";
			if ("1".equals(jmType)) {
				type = en.crypt_pwd("e", "energetically", tcpinfo.getSmycode());
			} else {
				type = en.crypt_pwd("e", "smyesok", tcpinfo.getSmycode());
			}
			if (type.equals(code.subSequence(3, code.length()))) {
				return "1";
			} else {
				return "0";
			}
		} else {
			return "0";
		}
	}
	// 读卡器授权码验证
	public String typecode(String code) {
		Tcpinfo tcpinfo = tcpinfojxyDao.getById(code);
		if (tcpinfo.getTypecode() != null && !tcpinfo.getTypecode().equals("")) {
			String jmType = (String) DictHelpImpl.getInitData("JmType");
			String type = "";
			if ("1".equals(jmType)) {
				type = en.crypt_pwd("e", "actively", tcpinfo.getTypecode());
			} else {
				type = en.crypt_pwd("e", "bsdkyes", tcpinfo.getTypecode());
			}
			if (type.equals(code.subSequence(3, code.length()))) {
				return "1";
			} else {
				return "0";
			}
		} else {
			return "0";
		}

	}
//	public String MySecurityJdbcDaoImpl(){
//		MySecurityJdbcDaoImpl m = new MySecurityJdbcDaoImpl();
//		return m.Remind_dept_count();
//	}
//	
	
}
