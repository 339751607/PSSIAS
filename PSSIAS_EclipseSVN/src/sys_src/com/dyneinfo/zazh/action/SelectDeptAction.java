package com.dyneinfo.zazh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.java.dev.common.dict.taglib.DictHelpImpl;
import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import com.dyneinfo.zazh.service.SelectDeptManager;

public class SelectDeptAction extends BaseStruts2Action {
	

	public String deptid;
	public String deptseq;
	public String ajax;
	public String inputid=null;
	public String oldId=null;
	public String getOldId() {
		return oldId;
	}
	public void setOldId(String oldId) {
		this.oldId = oldId;
	}
	public SelectDeptAction (){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();


		if (userDetail != null) {

			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
	}
	
	public SelectDeptManager selectDeptManager;

	
	// 根据派出所分局
	public String getFj() {
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		String search_deptSeq = "";
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
			//System.out.println(deptseq);
			String [] ss = deptseq.split("\\.");
			if(ss != null ) {
				int level = ss.length-1;
				if(level >=5 ) {
					search_deptSeq = "."+ss[1]+"."+ss[2]+"."+ss[3]+"."+ss[4]+".";
				} else{
					search_deptSeq = deptseq;
				}
			}
			
		}
		String mpcode = (String) DictHelpImpl.getInitData("mpcode");
		return getHeml(selectDeptManager.getFjByMpcode(mpcode, search_deptSeq));
	}

	// 根据查派出所
	public String getPcs() {

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		String search_deptSeq = "";
		String deptlevel = "";
		if (userDetail != null) {
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
			deptlevel = userDetail.getDeptLevel();
			String [] ss = deptseq.split("\\.");
			if(ss != null ) {
				int level = ss.length-1;
				if(level >=6 ) {
					search_deptSeq = "."+ss[1]+"."+ss[2]+"."+ss[3]+"."+ss[4]+"."+ss[5]+".";
				} else{
					search_deptSeq = deptseq;
				}
			}
		}

		return getHeml(selectDeptManager.getPcs(inputid, deptseq));
	}
	//根据派出所查企业
	public String getDeptByParentid(){
		List list=new ArrayList();
		if(inputid!=null&&!inputid.trim().equals(""))
		list=	selectDeptManager.getDeptByParentid(inputid,deptseq);
		return getHeml(list);
	}
	public String getParentid(){
		
		String parentid = selectDeptManager.getParentid(inputid);
		
        if (parentid == null) {
            return null;
        }
        if(ajax!=null && ajax.equals("true")){
	        try {
	            byte[] contents = parentid.getBytes("UTF-8");
	            getResponse().getOutputStream().write(contents);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
        }

		return parentid;
	}
	public String getHeml(List list){
	
		StringBuffer htmls=new StringBuffer();
		//if(list.size()>1)
			htmls.append("<option value=\"\">请选择...</option>");
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			htmls.append("<option ");
			htmls.append("value='"+map.get("deptid").toString().trim()+"'");
			if(oldId!=null&&map.get("deptid").toString().trim().equals(oldId.trim())){
				htmls.append(" selected='true'");
			}
			htmls.append(">");

			htmls.append(map.get("deptname"));
			htmls.append("</option>");
		}
		String html = htmls.toString();
        if (html == null) {
            return null;
        }
        if(ajax!=null && ajax.equals("true")){
	        try {
	            byte[] contents = html.getBytes("UTF-8");
	            getResponse().getOutputStream().write(contents);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
        }

		return html;
	}
	/** 执行搜索 */
	/** 执行搜索 */
	public String list() throws Exception{
	
		HttpServletRequest request = ServletActionContext.getRequest();
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		String deptid = null;
		int userid;
		String deptseq=null;

		if (userDetail != null) {
			userid = userDetail.getUserId();
			deptid = userDetail.getDeptID();
			deptseq = userDetail.getDeptSeq();
		}
		String ajax=request.getParameter("ajax");
		String root=request.getParameter("root");
		String parentId=request.getParameter("parentId");
		

		StringBuffer htmls=new StringBuffer("");


		String[] deptseqs=null;
		if(deptseq!=null){
			deptseqs=deptseq.split("\\.");
		}
		
		List list=selectDeptManager.getDeptByParentId(parentId.trim(),deptseq);
		
		
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			htmls.append("<option ");
			htmls.append("value='"+map.get("deptid").toString().trim()+"'");
			for(int h=0;h<deptseqs.length;h++){
				if(map.get("deptid").toString().trim().equals(deptseqs[h])){
					htmls.append(" selected='true' ");
				}
			}
			

			htmls.append(">");

			htmls.append(map.get("deptname"));
			htmls.append("</option>");
		}


		 String html = htmls.toString();
	        if (html == null) {
	            return null;
	        }
	        if(ajax!=null && ajax.equals("true")){
		        try {
		            byte[] contents = html.getBytes("UTF-8");
		            getResponse().getOutputStream().write(contents);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        return null;
	        }
	        return html;
	}
	public String getdeptFullName(){

		return selectDeptManager.getdeptFullName(deptseq);
	}

	public String getDeptid() {
		return deptid;
	}

	public String getAjax() {
		return ajax;
	}

	public void setAjax(String ajax) {
		this.ajax = ajax;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptseq() {
		return deptseq;
	}

	public void setDeptseq(String deptseq) {
		this.deptseq = deptseq;
	}

	public SelectDeptManager getSelectDeptManager() {
		return selectDeptManager;
	}
	public void setSelectDeptManager(SelectDeptManager selectDeptManager) {
		this.selectDeptManager = selectDeptManager;
	}
	public String getInputid() {
		return inputid;
	}
	public void setInputid(String inputid) {
		this.inputid = inputid;
	}

}
