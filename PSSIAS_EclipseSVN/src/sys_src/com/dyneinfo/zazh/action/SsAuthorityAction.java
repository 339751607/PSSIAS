/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.action;

import static javacommon.util.extjs.Struts2JsonHelper.outJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseStruts2Action;
import javacommon.util.extjs.ExtJsPageHelper;
import javacommon.util.extjs.ListRange;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.FilterSecurityInterceptor;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.SsAuthority;
import com.dyneinfo.zazh.service.SsAuthorityManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class SsAuthorityAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/SsAuthority/query.jsp";
	protected static final String LIST_JSP= "/pages/SsAuthority/list.jsp";
	protected static final String CREATE_JSP = "/pages/SsAuthority/create.jsp";
	protected static final String EDIT_JSP = "/pages/SsAuthority/edit.jsp";
	protected static final String SHOW_JSP = "/pages/SsAuthority/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/SsAuthority/list.do";
	
	private SsAuthorityManager ssAuthorityManager;
	
	private SsAuthority ssAuthority;
	java.lang.Long id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			ssAuthority = new SsAuthority();
		} else {
			ssAuthority = (SsAuthority)ssAuthorityManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setSsAuthorityManager(SsAuthorityManager manager) {
		this.ssAuthorityManager = manager;
	}	
	

	
	public Object getModel() {
		return ssAuthority;
	}
	
	public void setAuthorityid(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	/** 进入查询页面 */
	public String query() {
		return QUERY_JSP;
	}
	

	
	
	/**
	 * ExtGrid使用
	 * 列表
	 * @throws IOException
	 */
	public void extlist() throws IOException
	{
		PageRequest<Map> pr = ExtJsPageHelper.createPageRequestForExtJs(getRequest(), DEFAULT_SORT_COLUMNS);
		Page page = ssAuthorityManager.findByPageRequest(pr);
		
		List<SsAuthority> SsAuthoritylist = (List) page.getResult();
		ListRange<SsAuthority> resultList = new ListRange<SsAuthority>();
		resultList.setList(SsAuthoritylist);
		resultList.setTotalSize(page.getTotalCount());
		resultList.setMessage("ok");
		resultList.setSuccess(true);
		
		
		
	
		    
		outJson(resultList);
	}

	/**
	 * extGrid保存
	 * @throws IOException
	 */
	public void extsave() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			ssAuthorityManager.save(ssAuthority);
			result.put("success", true);
			result.put("msg", "添 加 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	/**
	 * extGrid修改
	 * @throws IOException
	 */
	public void extupdate() throws IOException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			ssAuthorityManager.update(ssAuthority);
			
			refreshAuthority();//刷新加载权限信息
			result.put("success", true);
			result.put("msg", "修 改 成 功!");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		//System.out.print("========================"+result.toString());
		outJson(result);
	}
	
	/**
	 * extGrid删除
	 * @throws IOException
	 */
	public void extdelete() throws IOException
	{
		String ids = getRequest().getParameter("ids");
		String[] idarray = ids.split(",");
		Map<String, Object> result = new HashMap<String, Object>();
		try
		{
			for (int i = 0; i < idarray.length; i++)
			{
				java.lang.Long id = new java.lang.Long((String)idarray[i]);
				ssAuthorityManager.removeroleAuthority(id.longValue());
				ssAuthorityManager.removeById(id);
			}
			refreshAuthority();//刷新加载权限信息
			result.put("success", true);
			result.put("msg", "删除成功");
		}
		catch (Exception e)
		{
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		outJson(result);
	}
	
	
	
	
	private static void refreshAuthority() throws IOException {
		
		try{	
			   ApplicationContext ctx =  WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			    FactoryBean factoryBean = (FactoryBean) ctx.getBean("&filterInvocationDefinitionSource");
			    FilterInvocationDefinitionSource fids = (FilterInvocationDefinitionSource) factoryBean.getObject();
			    FilterSecurityInterceptor filter = (FilterSecurityInterceptor) ctx.getBean("filterSecurityInterceptor");
			    filter.setObjectDefinitionSource(fids);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("==========="+e.getMessage());
		}
		
	}
	
	
	

}
