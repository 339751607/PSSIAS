package com.dyneinfo.pmdd.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import  com.dyneinfo.pmdd.dao.SsCommonPmddDao;
import java.io.File;
import java.io.IOException;

@Component
public class SsCommonPmddManager {
	
	private SsCommonPmddDao ssCommonDao;
	
	

	public SsCommonPmddDao getSsCommonDao() {
		return ssCommonDao;
	}
	public void setSsCommonPmddDao(SsCommonPmddDao ssCommonDao) {
		this.ssCommonDao = ssCommonDao;
	}
	
	public int update(String Sql) {
		return (int)ssCommonDao.update(Sql);	
	}
	
	//根据deptid查deptseq
	public String getDeptFullNameByDeptId(String deptid){
		String _deptseq="";
	
		StringBuffer fullName=new StringBuffer();
	
		List name_list=ssCommonDao.getdeptFullName(deptid);
		
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
	
		List name_list=ssCommonDao.getdeptFullName(deptid);
		
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
	
		List name_list=ssCommonDao.getdeptFullName(deptid);
		
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
		List list=ssCommonDao.getdeptFullName(deptid);
		if(!list.isEmpty()){
			Map map=(Map)list.get(0);
			_deptseq=(String)map.get("deptseq");
		}

		
		return _deptseq;
	}
	//取得手机品牌代码
	public List getSjpp(String sqlWhere) {
		return (List)ssCommonDao.getSjpp(sqlWhere);
	}
//	//取得手机型号代码
	public List getSjxh(String sqlWhere) {
		return (List)ssCommonDao.getSjxh(sqlWhere);
	}
	
	// 图片id是否存在
	public int getPicIDIsExist(String ID) {
		return (int) ssCommonDao.getPicIDIsExist(ID);
	}

	// 保存图片
	public void savePic(byte[] file, long Length, String ID) throws IOException {
		ssCommonDao.savePic(file, Length, ID);
	}

	// 修改图片
	public void updatePic(byte[] file, long Length, String ID) throws IOException {
		ssCommonDao.updatePic(file, Length, ID);
	}
	
	
	// 保存图片
	public void savePic(File file, Long Length, String ID) throws IOException {
		ssCommonDao.savePic(file, Length, ID);
	}

	// 修改图片
	public void updatePic(File file, Long Length, String ID) throws IOException {
		ssCommonDao.updatePic(file, Length, ID);
	}

	// 取得照片
	public List getPic(String ID) {
		return (List) ssCommonDao.getPic(ID);
	}

	// 取得省
	public List getProv() {
		return (List) ssCommonDao.getProv();
	}
	
	//发布范围（单位） 
	public List getNotice_issuescope(Long noticeID) {
		return (List)ssCommonDao.getNotice_issuescope(noticeID);
	}
	
	//通知 参与人员
	public List getNotice_participants(Long noticeID) {
		return (List)ssCommonDao.getNotice_participants(noticeID);
	}
	//弹出通知数量
	public int getNoticePopCount(String Sql) {
		 return (int)ssCommonDao.getNoticePopCount(Sql);
	}

}
