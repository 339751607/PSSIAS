/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.dao.TemployeeDao;
import com.dyneinfo.fjy.model.Temployee;
import com.dyneinfo.fjy.model.Tempworklog;
import com.dyneinfo.zazh.model.SsRole;
import com.dyneinfo.zazh.model.SsUser;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeeManager extends BaseManager<Temployee,java.lang.String>{

	private TemployeeDao temployeeDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTemployeeDao(TemployeeDao dao) {
		this.temployeeDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.temployeeDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return temployeeDao.findByPageRequest(pr);
	}
	public Temployee getTemployeeById(String empcode) {
		return (Temployee)temployeeDao.getTemployeeById(empcode);
		
	}
	public int getCountByIdcard(String new_IDCard,String old_IDCard,String deptid) {
		return (int)temployeeDao.getCountByIdcard(new_IDCard,old_IDCard,deptid);
	}
	public void saveTempworklog(Tempworklog entity) {
		temployeeDao.saveTempworklog(entity);
	}
	public void saveSsUser(SsUser entity) {
		temployeeDao.saveSsUser(entity);
	}
	
	/**
	 * 根据登录用户查询用户编码
	 * @param deptID
	 * @param userid
	 * @return
	 */
	public String getemploee(String deptID ,int userid){
		String empcode ="";
		empcode = temployeeDao.getemploee(deptID, userid);
		return empcode;
	}
	
	
	// 取得从业人员
	public List getCyry(String deptId) {
		return (List) temployeeDao.getCyry(deptId);
	}
	
	
	// 图片id是否存在
	public int getPicIDIsExist(String ID) {
		return (int) temployeeDao.getPicIDIsExist(ID);
	}

	// 保存图片
	public void savePic(String filePath, String ID) throws IOException {
		temployeeDao.savePic(filePath, ID);
	}

	// 修改图片
	public void updatePic(String filePath, String ID) throws IOException {
		temployeeDao.updatePic(filePath, ID);
	}
	// 保存图片
	public void savePic(byte[] b, String ID) throws IOException {
		temployeeDao.savePic(b, ID);
	}

	// 修改图片
	public void updatePic(byte[] b, String ID) throws IOException {
		temployeeDao.updatePic(b, ID);
	}
	
	public void insertRoleUser(long roleid, long userid) {
		temployeeDao.insertRoleUser(roleid,userid);
	}
	public List<SsRole> findEnterpriseUserNoExistRole(String session_deptId,String  roleIds) {
		return temployeeDao.findEnterpriseUserNoExistRole(session_deptId,roleIds);
	}
	public Long  getSsUserSeq(){
		return (Long)temployeeDao.getSsUserSeq();
	}
	public Long  getEempworklogSeq(){
		return (Long)temployeeDao.getEempworklogSeq();
	}
	
	public void saveEmployee(Temployee temployee,Tempworklog tempworklog,SsUser ssUser,String[] selectRoles ,
			String empcode,Long userid,String deptID,byte[] b) throws IOException{
		temployeeDao.save(temployee);
		temployeeDao.saveTempworklog(tempworklog);
		if(ssUser.getUsername()!=null&&!ssUser.getUsername().trim().equals("")&&ssUser.getPassword()!=null&&!ssUser.getPassword().trim().equals("")){
			temployeeDao.saveSsUser(ssUser);
			temployeeDao.removeroleUser(userid);
		}
		
		String InIds = "";
		if (selectRoles != null) {
			for (int i = 0; i < selectRoles.length; i++) {
				String roleids = selectRoles[i];
				InIds += roleids + ",";
			}
			if (InIds != null && InIds.length() > 0) {
				InIds = InIds.substring(0, InIds.length() - 1);

				List<SsRole> rolelist = temployeeDao.findEnterpriseUserNoExistRole(deptID,InIds);
				Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
				for (SsRole role : roles) {
					temployeeDao.insertRoleUser(role.getRoleid(), userid);
				}
			}
		}
		
		System.out.println("getPersonid= start");
		if (temployee.getPersonid()  != null) {
			//String filePath="C:/"+temployee.getPersonid()+".jpg";
			int idCount = temployeeDao.getPicIDIsExist(empcode);
			
			System.out.println("idCount="+idCount);
			if (idCount > 0){
				temployeeDao.updatePic(b , empcode);
				System.out.println("1111111111111="+idCount);
			}
			else{
				temployeeDao.savePic(b, empcode);
				System.out.println("2222222222222222="+idCount);
			}
		}
	}
	public void updateEmpStatus(String  empcode) {
		temployeeDao.updateEmpStatus(empcode);
	}
	public void updateUserStatus(String  empcode) {
		temployeeDao.updateUserStatus(empcode);
	}
	
	public void updateSsUser(SsUser entity) {
		temployeeDao.updateSsUser(entity);
	}
	
	
	public void updateEmployee(Temployee temployee,SsUser ssUser,String[] selectRoles ,
			Long userid,String deptID) {
		temployeeDao.update(temployee);
		int usernameCount = temployeeDao.getCountUserName(ssUser.getUsername());
		if(usernameCount>0){
			temployeeDao.updateSsUser(ssUser);
			temployeeDao.removeroleUser(userid);
		}else{
			if(ssUser.getUsername()!=null&&!ssUser.getUsername().trim().equals("")&&ssUser.getPassword()!=null&&!ssUser.getPassword().trim().equals("")){
				temployeeDao.saveSsUser(ssUser);
				temployeeDao.removeroleUser(userid);
			}
		}

		
	
		String InIds = "";
		if (selectRoles != null) {
			for (int i = 0; i < selectRoles.length; i++) {
				String roleids = selectRoles[i];
				InIds += roleids + ",";
			}
			if (InIds != null && InIds.length() > 0) {
				InIds = InIds.substring(0, InIds.length() - 1);

				List<SsRole> rolelist = temployeeDao.findEnterpriseUserNoExistRole(deptID,InIds);
				Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
				for (SsRole role : roles) {
					temployeeDao.insertRoleUser(role.getRoleid(), userid);
				}
			}
		}
		
		
		
	}
	public  List getPicture(String sql) {
		return (List) temployeeDao.getPicture(sql);
	}
}
