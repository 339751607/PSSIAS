package com.dyneinfo.zazh.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import com.dyneinfo.zazh.model.DictItem;
import com.dyneinfo.zazh.model.SsDictItem;
import com.dyneinfo.zazh.service.SelectDeptManager;

public class SelectXzqhAction extends BaseStruts2Action {
	public SelectDeptManager selectDeptManager;
	/** 执行搜索 */
	public String list() throws Exception{
	
		HttpServletRequest request = ServletActionContext.getRequest();

		String ajax=request.getParameter("ajax");

		String inputid=request.getParameter("inputid")!=null?(String)request.getParameter("inputid"):"";
		String outId=request.getParameter("outId")!=null?(String)request.getParameter("outId"):"";
		String oldId=request.getParameter("oldId")!=null?(String)request.getParameter("oldId"):"";
		StringBuffer htmls=new StringBuffer("");
		List<DictItem> list=new ArrayList();

		if(outId.equals("city")){
			list=selectDeptManager.getCityByProvince(inputid.trim());
		}else
		if(outId.equals("counties")){
			list=selectDeptManager.getCountiesByCity(inputid.trim());
		}else{
			list=selectDeptManager.getProvince();
		}
	
		htmls.append("<option value=\"\">请选择...</option>");
		for(int i=0;i<list.size();i++){
			DictItem item=(DictItem)list.get(i);
			htmls.append("<option ");
			htmls.append("value='"+item.getDictid()+"'");
			if(oldId!=null&&item.getDictid().equals(oldId.trim())){
				htmls.append(" selected='true'");
			}
			htmls.append(">");

			htmls.append(item.getName());
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
	public SelectDeptManager getSelectDeptManager() {
		return selectDeptManager;
	}
	public void setSelectDeptManager(SelectDeptManager selectDeptManager) {
		this.selectDeptManager = selectDeptManager;
	}


}
