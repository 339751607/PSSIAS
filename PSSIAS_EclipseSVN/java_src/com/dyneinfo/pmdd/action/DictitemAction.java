
package com.dyneinfo.pmdd.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.service.SsDeptManager;
import com.dyneinfo.pmdd.model.SDictitem;
import com.dyneinfo.pmdd.service.DictitempmddManager;
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
	
	private DictitempmddManager dictitemManager;
	private SsDeptManager ssDeptManager;
	
	private SDictitem dictitem;
	java.lang.String id = null;

	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {

			dictitem = new SDictitem();

	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setDictitempmddManager(DictitempmddManager manager) {
		this.dictitemManager = manager;
	}	
	
	public void setSsDeptManager(SsDeptManager manager) {
		this.ssDeptManager = manager;
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
	public String deptList() throws Exception{
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		String ajax=request.getParameter("ajax");
		String s_fjbm=request.getParameter("s_fjbm");
		String pcsbm=request.getParameter("pcsbm");
		
		StringBuffer htmls=new StringBuffer();
		
		String long_fjdm = s_fjbm.trim();

		List<SsDept> list=ssDeptManager.findByParentId(long_fjdm,"");
		
		for(SsDept dep2:list){	
			htmls.append("<option ");
			htmls.append("value='"+dep2.getDeptid().toString().trim()+"'");
			if(matchValue(pcsbm,dep2.getDeptid().toString().trim())){
				htmls.append(" selected='true' ");
			}
			htmls.append(">");

			htmls.append(dep2.getDeptname());
			htmls.append("</option>");
		}
//		for(int i=0;i<list.size();i++){
//			Map map=(Map)list.get(i);
//			htmls.append("<option ");
//			htmls.append("value='"+map.get("dictid").toString().trim()+"'");
//			if(matchValue(pcsbm,map.get("dictid").toString().trim())){
//				htmls.append(" selected='true' ");
//			}
//			htmls.append(">");
//
//			htmls.append(map.get("dictname"));
//			htmls.append("</option>");
//		}

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
	
	
	protected boolean matchValue(String pcsbm,String dictid){
		if(pcsbm==null||pcsbm.length()==0){
			return false;
		}
		if(pcsbm.trim().equals(dictid)){
			return true;
		}
		return false;
	}

}
