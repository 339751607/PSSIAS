package com.dyneinfo.fjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dyneinfo.fjy.dao.SsCommonfjyDao;
import java.io.File;
import java.io.IOException;

@Component
public class SsCommonfjyManager {
	
	private SsCommonfjyDao ssCommonfjyDao;
	
	



	public SsCommonfjyDao getssCommonfjyDao() {
		return ssCommonfjyDao;
	}

	public void setssCommonfjyDao(SsCommonfjyDao ssCommonfjyDao) {
		this.ssCommonfjyDao = ssCommonfjyDao;
	}

	public int update(String Sql) {
		return (int)ssCommonfjyDao.update(Sql);	
	}
	
	//根据deptid查deptseq
	public String getDeptFullNameByDeptId(String deptid){
		String _deptseq="";
	
		StringBuffer fullName=new StringBuffer();
	
		List name_list=ssCommonfjyDao.getdeptFullName(deptid);
		
		if(!name_list.isEmpty()){
			for(int i=name_list.size()-1;i>=0;i--){
				Map map=(Map)name_list.get(i);
				fullName.append(map.get("deptname"));
			}
		}
		
		return fullName.toString();
	}
	public String getDeptFullNameByDeptId12(String deptid){
		String _deptseq="";
	
		StringBuffer fullName=new StringBuffer();
	
		List name_list=ssCommonfjyDao.getdeptFullName(deptid);
		
		if(!name_list.isEmpty()){
			for(int i=name_list.size()-1;i>=0;i--){
				Map map=(Map)name_list.get(i);
				fullName.append(map.get("deptname"));
				fullName.append(",");
			}
		}
		
		return fullName.toString();
	}
	public String getDeptFullNameByDeptId11(String deptid){
		String _deptseq="";
	
		StringBuffer fullName=new StringBuffer();
	
		List name_list=ssCommonfjyDao.getdeptFullName(deptid);
		
		if(!name_list.isEmpty()){
			for(int i=name_list.size()-1;i>=0;i--){
				Map map=(Map)name_list.get(i);
				fullName.append(map.get("deptid"));
				fullName.append(",");
			}
		}
		
		return fullName.toString();
	}
	
	//根据deptid查deptseq
	public String getDeptDeptseq(String deptid){
		String _deptseq="";
		List list=ssCommonfjyDao.getdeptFullName(deptid);
		if(!list.isEmpty()){
			Map map=(Map)list.get(0);
			_deptseq=(String)map.get("deptseq");
		}

		
		return _deptseq;
	}
	//取得手机品牌代码
	public List getSjpp(String sqlWhere) {
		return (List)ssCommonfjyDao.getSjpp(sqlWhere);
	}
//	//取得手机型号代码
	public List getSjxh(String sqlWhere) {
		return (List)ssCommonfjyDao.getSjxh(sqlWhere);
	}
	
	// 图片id是否存在
	public int getPicIDIsExist(String ID) {
		return (int) ssCommonfjyDao.getPicIDIsExist(ID);
	}

	// 保存图片
	public void savePic(byte[] file, long Length, String ID) throws IOException {
		ssCommonfjyDao.savePic(file, Length, ID);
	}

	// 修改图片
	public void updatePic(byte[] file, long Length, String ID) throws IOException {
		ssCommonfjyDao.updatePic(file, Length, ID);
	}
	
	
	// 保存图片
	public void savePic(File file, Long Length, String ID) throws IOException {
		ssCommonfjyDao.savePic(file, Length, ID);
	}

	// 修改图片
	public void updatePic(File file, Long Length, String ID) throws IOException {
		ssCommonfjyDao.updatePic(file, Length, ID);
	}

	// 取得照片
	public List getPic(String ID) {
		return (List) ssCommonfjyDao.getPic(ID);
	}

	// 取得省
	public List getProv() {
		return (List) ssCommonfjyDao.getProv();
	}
	
	//发布范围（单位） 
	public List getNotice_issuescope(Long noticeID) {
		return (List)ssCommonfjyDao.getNotice_issuescope(noticeID);
	}
	
	//通知 参与人员
	public List getNotice_participants(Long noticeID) {
		return (List)ssCommonfjyDao.getNotice_participants(noticeID);
	}
	//弹出通知数量
	public int getNoticePopCount(String Sql) {
		 return (int)ssCommonfjyDao.getNoticePopCount(Sql);
	}

}
