package com.dyneinfo.zazh.action;




import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

import com.dyneinfo.zazh.model.AsecurityMenu;
import com.dyneinfo.zazh.model.MainMenuItemExt;
import com.dyneinfo.zazh.service.AsecurityMenuManager;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;




public class outlookmenuAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	

	
	protected static final String LIST_LEFT_TREE = "/pages/outlookmenu/work_body_leftTree.jsp";
	protected static final String LIST_TOP_MENU= "/pages/outlookmenu/top_menu.jsp";
	protected static final String LIST_DROP_MENU_welcome= "/pages/main/dropmenu/welcome.jsp";
	protected static final String MAP_JSP = "/pages/outlookmenu/map.jsp";
	protected static final String NEW_LEFT_MENU= "/pages/outlookmenu/new_leftmenu.jsp";
	
	protected static final String LIST_LOGIN="/login.jsp";
	
	private List mymenuList = null;
	private String dropMenuScript = null;
	private String outLookMenuScript = null;
	
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/hotel/AsecurityMenu/list.do";
	
	private AsecurityMenuManager asecurityMenuManager;
	private SsCommonManager ssCommonManager;
	
	private AsecurityMenu asecurityMenu;
	java.math.BigDecimal id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			asecurityMenu = new AsecurityMenu();
		} else {
			asecurityMenu = (AsecurityMenu)asecurityMenuManager.getById(id);
		}
	}
	
	/** 通过spring自动注入 */
	public void setAsecurityMenuManager(AsecurityMenuManager manager) {
		this.asecurityMenuManager = manager;
	}	
	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}

	
	public Object getModel() {
		return asecurityMenu;
	}
	
	public void setId(java.math.BigDecimal val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}


	
	public String topMenu() throws Exception {
		 HttpServletRequest request = ServletActionContext.getRequest();
		String username = "";
		String deptid = "";
		String deptSeq = "";

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();

		}

	    if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(deptSeq)){
	    	
	    }else{
	    	return LIST_LOGIN;
	    }
	    mymenuList = asecurityMenuManager.getAsecurityMenuDao().getUserMenusList(username);

		String outlookJscript = getOutLookMenuJavaScript();	
		request.setAttribute("outlookJscript", outlookJscript);
		
		String dataAuthorityFlag = asecurityMenuManager.queryDataAuthoritySwitchStatus();
	    request.getSession().setAttribute("dataAuthorityFlag", dataAuthorityFlag);
		return LIST_TOP_MENU;
	}
	public String newLeftMenu() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = "";
		String deptid = "";
		String deptSeq = "";

		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();

		}

	    if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(deptSeq)){
	    	
	    }else{
	    	return LIST_LOGIN;
	    }
	    
	    mymenuList = asecurityMenuManager.getAsecurityMenuDao().getUserMenusList(username);

		String menusJson = getMenusJson();	
		request.setAttribute("menusJson", menusJson);
	  
		return NEW_LEFT_MENU;
	}
	/*
	 * 为生成菜单Json数据 。
	 */
	public String getMenusJson(){
		String menus = "";
		StringBuffer menuBS = new StringBuffer();
		menuBS.append("var menusJson=[");	
		if( mymenuList != null && mymenuList.size() >0 ){			
			//生成所需要的json		        
	        Iterator iterator = mymenuList.iterator();
	        while( iterator.hasNext()){
	        	menuBS = creatJsonMenu((MainMenuItemExt)iterator.next(),menuBS);
	        	
	        }	       
		}
		menus = menuBS.toString();
	    menus = menus.substring(0, menus.length()-1);
		menus = menus +("];");
		return menus;
	}
	private StringBuffer creatJsonMenu(MainMenuItemExt menuItem,StringBuffer jsonmenu){

		jsonmenu.append("{");
		jsonmenu.append(" 'name' : ");
		jsonmenu.append(" '" + menuItem.getName() + "', ");
		
		//存在子菜单
		int num = menuItem.getChilds().length;	
		if(num > 0){	
			jsonmenu.append(" 'submenu' : [ ");			
			for(int i=0; i<num; i++){
				jsonmenu = creatJsonMenu((MainMenuItemExt)menuItem.getChilds()[i], jsonmenu);
				if(i==num-1){
					jsonmenu = new StringBuffer(jsonmenu.substring(0,jsonmenu.length()-1));					
				}
			}
			jsonmenu.append(" ] ");
		}else{
			jsonmenu.append(" 'url' : '");
			String url =  menuItem.getAction()==null?"":menuItem.getAction();
			jsonmenu.append( url );
			jsonmenu.append( "' ");
		}
		jsonmenu.append("},");
		return jsonmenu;
	}
	
	public String leftTree() {
		
		return LIST_LEFT_TREE;
	}	
	// dropMenu
	public String dropMenuWelcome() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    UserDetails details = (UserDetails)authentication.getPrincipal();
		    String userName = details.getUsername();
		    mymenuList = asecurityMenuManager.getUserMenusList(userName);
		    String dropMenuJscript = getDropMenuJavaScript();
		    
		    //System.out.println("outlookJscript = "+outlookJscript);
		    
			HttpServletRequest request = ServletActionContext.getRequest();

			request.setAttribute("dropMenuJscript", dropMenuJscript);
		return LIST_DROP_MENU_welcome;
	}
	
	public String mapMain(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 List hconfigList= asecurityMenuManager.getQuery("select * from t_config where key='ipAddress'");
		 Map hconfigMap=(Map)hconfigList.get(0);
		 String hcvalues = (String)hconfigMap.get("CODE");
		 request.getSession().setAttribute("hcvalues", hcvalues);
		return MAP_JSP;
	}
	
	
	/*
	 * 为生成OutLook式菜单准备数据 。
	 */
	public String getOutLookMenuJavaScript(){
		if( outLookMenuScript == null ){
			StringBuffer eosmenu = new StringBuffer();
			//生成所需要的javascript
	        eosmenu.append("<script language=\"javascript\">\n");
	        eosmenu.append("var menus=new Array(");
	        
	        Iterator iterator = mymenuList.iterator();
	        while( iterator.hasNext()){
	        	eosmenu = creatOutlookMenuScript((MainMenuItemExt)iterator.next(),eosmenu);
	        }
	        eosmenu.append("''\n);</script>");
	        outLookMenuScript = eosmenu.toString();
		}
		
		return outLookMenuScript;
	}
	
	private StringBuffer creatOutlookMenuScript(MainMenuItemExt menuItem,StringBuffer menuScript){

		menuScript.append("new Array('");
		menuScript.append(menuItem.getMenuID() + "','");
		menuScript.append(menuItem.getName() + "','");
		menuScript.append(menuItem.getAction() + "','");
		menuScript.append(menuItem.getParentID() + "','");
		menuScript.append(menuItem.getDisplayOrder() +"'),\n");
		
		int num = menuItem.getChilds().length;
		for(int i=0; i<num; i++){
			creatOutlookMenuScript((MainMenuItemExt)menuItem.getChilds()[i],menuScript);
		}
		return menuScript;
	}
	
	/*
	 * 为生成下来菜单准备数据 。
	 */
	public String getDropMenuJavaScript(){
		
		if( dropMenuScript == null ){
			StringBuffer eosmenu = new StringBuffer();
			//生成所需要的javascript
	        eosmenu.append("<script>");
	        Iterator iterator = mymenuList.iterator();
	        int num = 1;
	        String menuID = "" ;
	        while( iterator.hasNext()){
	        	menuID = "eosmenu" + num;
	        	eosmenu = creatDropMenuScript(menuID,eosmenu,(MainMenuItemExt)iterator.next());
	        	num++;
	        }
	        eosmenu.append("</script>");
	        dropMenuScript = eosmenu.toString();
		}
		
		return dropMenuScript;
	}
	
	private StringBuffer creatDropMenuScript(String menuID, StringBuffer menuScript, MainMenuItemExt menuItem){
		
		menuScript.append(menuID + "=new Array(" + menuItem.toJavaScriptString() + ");\n");
		int num = menuItem.getChilds().length;
		String tempMenuID = "";
		for(int i=0; i<num; i++){
			tempMenuID = menuID + "_" + (i +1);
			creatDropMenuScript(tempMenuID,menuScript,(MainMenuItemExt)menuItem.getChilds()[i]);
		}
		return menuScript;
	}
	

}
