
package com.dyneinfo.jxy.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.model.SDictitem;
import com.dyneinfo.jxy.service.DictitemManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class DictitemAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	protected static final String LIST_JSP= "/pages/Dictitem/list.jsp";

	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/Dictitem/list.do";
	
	private DictitemManager dictitemManager;
	
	private SDictitem dictitem;
	java.lang.String id = null;

	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {

			dictitem = new SDictitem();

	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setDictitemManager(DictitemManager manager) {
		this.dictitemManager = manager;
	}	
	
	public Object getModel() {
		return dictitem;
	}
	public void setDicttypeid(java.lang.String val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public TreeMap<String, String> getDateSelectMap() {
		return dateSelectMap;
	}

	public void setDateSelectMap(TreeMap<String, String> dateSelectMap) {
		this.dateSelectMap = dateSelectMap;
	}


	
	/** 执行搜索 */
	public String list() throws Exception{
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		String ajax=request.getParameter("ajax");
		String s_fjbm=request.getParameter("s_fjbm");
		String pcsbm=request.getParameter("pcsbm");
		
		StringBuffer htmls=new StringBuffer();

		List list=dictitemManager.getByParentId(s_fjbm.trim());
		
		for(int i=0;i<list.size();i++){
			Map map=(Map)list.get(i);
			htmls.append("<option ");
			htmls.append("value='"+map.get("dictid").toString().trim()+"'");
			if(matchValue(pcsbm,map.get("dictid").toString().trim())){
				htmls.append(" selected='true' ");
			}
			htmls.append(">");

			htmls.append(map.get("dictname"));
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
	public String getEmployeeList() throws Exception{

		HttpServletRequest request = ServletActionContext.getRequest();

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				deptid = ud.getDeptID();
			}
		}
		String ajax=request.getParameter("ajax");
		String recename=request.getParameter("recename");
		String show=request.getParameter("show");
		if(null != request.getParameter("cpcpde")){
			deptid = request.getParameter("cpcpde");
		}
		
		StringBuffer htmls=new StringBuffer();

		if(show!=null&&!show.equals("") ){
			List list=dictitemManager.getEmpnameByCode(recename);
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				htmls.append(map.get("name"));
			}
			
		}else{
			List list=dictitemManager.getEmployeeById(deptid);
			
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				htmls.append("<option ");
				htmls.append("value='"+map.get("code").toString().trim()+"'");
				if(matchValue(recename,map.get("code").toString().trim())){
					htmls.append(" selected='true' ");
				}
				htmls.append(">");

				htmls.append(map.get("name"));
				htmls.append("</option>");
			}
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
	
	
	protected boolean matchValue(String recename,String code){
		if(recename==null||recename.length()==0){
			return false;
		}
		if(recename.trim().equals(code)){
			return true;
		}
		return false;
	}

}
