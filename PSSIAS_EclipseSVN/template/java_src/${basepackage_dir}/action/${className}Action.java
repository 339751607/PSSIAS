<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do">
package ${basepackage}.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

<#include "/java_imports.include">

public class ${className}Action extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "${jspFileBasePath}/query.jsp";
	protected static final String LIST_JSP= "${jspFileBasePath}/list.jsp";
	protected static final String CREATE_JSP = "${jspFileBasePath}/create.jsp";
	protected static final String EDIT_JSP = "${jspFileBasePath}/edit.jsp";
	protected static final String SHOW_JSP = "${jspFileBasePath}/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!${actionBasePath}/list.${actionExtension}";
	
	private ${className}Manager ${classNameLower}Manager;
	
	private ${className} ${classNameLower};
	<#list table.compositeIdColumns as column>
	${column.javaType} id = null;
	</#list>
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			${classNameLower} = new ${className}();
		} else {
			${classNameLower} = (${className})${classNameLower}Manager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void set${className}Manager(${className}Manager manager) {
		this.${classNameLower}Manager = manager;
	}	
	
	public Object getModel() {
		return ${classNameLower};
	}
	
	<#list table.compositeIdColumns as column>
	public void set${column.columnName}(${column.javaType} val) {
		this.id = val;
	}
	</#list>	

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

	/** 进入查询页面 */
	public String query() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
//		DateUtil tt = new DateUtil();     
//      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
//      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		<#assign i = 0>    
		<#list table.columns as column>
		    <#if !column.htmlHidden>
		        <#if column.isDateTimeColumn>
		String dateSelect${i} = "";
		if (request.getParameter("dateSelect${i}") != null)
		    dateSelect${i} = request.getParameter("dateSelect${i}");
			request.setAttribute("dateSelect${i}",dateSelect${i});		        
		        <#elseif  column.htmlInputType=="date">
		String dateSelect${i} = "";
		if (request.getParameter("dateSelect${i}") != null)
		    dateSelect${i} = request.getParameter("dateSelect${i}");
			request.setAttribute("dateSelect${i}",dateSelect${i});		        
		String s_${column.columnNameLower}BeginFormat = DateUtil.parseString(request,"s_${column.columnNameLower}Begin","${column.displayFormat}","${column.parseFormat}");
		String s_${column.columnNameLower}EndFormat = DateUtil.parseString(request,"s_${column.columnNameLower}End","${column.displayFormat}","${column.parseFormat}");
		pageRequest.getFilters().put("${column.columnNameLower}BeginFormat",s_${column.columnNameLower}BeginFormat);
		pageRequest.getFilters().put("${column.columnNameLower}EndFormat",s_${column.columnNameLower}EndFormat);
		        <#else>
		        </#if>
		        <#assign i=i+1 />
		    </#if>
	    </#list>
		
		Page page = ${classNameLower}Manager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		<#assign i = 0>    
		<#list table.columns as column>
		    <#if !column.htmlHidden>
		        <#if column.isDateTimeColumn>	        
		        <#elseif  column.htmlInputType=="date">
		${column.javaType} ${column.columnNameLower} =  ${classNameLower}.get${column.columnName}();
		${column.javaType} ${column.columnNameLower}Format = DateUtil.parseString(${column.columnNameLower},"${column.parseFormat}","${column.displayFormat}");
		${classNameLower}.set${column.columnName}(${column.columnNameLower}Format);
		        <#else>
		        </#if>
		        <#assign i=i+1 />
		    </#if>
	    </#list>
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		<#assign i = 0>    
		<#list table.columns as column>
		    <#if !column.htmlHidden>
		        <#if column.isDateTimeColumn>	        
		        <#elseif  column.htmlInputType=="date">	        
		String ${column.columnNameLower}Format = DateUtil.parseString(request,"${column.columnNameLower}","${column.displayFormat}","${column.parseFormat}");
		${classNameLower}.set${column.columnName}(${column.columnNameLower}Format);
		        <#else>
		        </#if>
		        <#assign i=i+1 />
		    </#if>
	    </#list>
		${classNameLower}Manager.save(${classNameLower});
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		<#assign i = 0>    
		<#list table.columns as column>
		    <#if !column.htmlHidden>
		        <#if column.isDateTimeColumn>	        
		        <#elseif  column.htmlInputType=="date">
		${column.javaType} ${column.columnNameLower} =  ${classNameLower}.get${column.columnName}();
		${column.javaType} ${column.columnNameLower}Format = DateUtil.parseString(${column.columnNameLower},"${column.parseFormat}","${column.displayFormat}");
		${classNameLower}.set${column.columnName}(${column.columnNameLower}Format);
		        <#else>
		        </#if>
		        <#assign i=i+1 />
		    </#if>
	    </#list>
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		<#assign i = 0>    
		<#list table.columns as column>
		    <#if !column.htmlHidden>
		        <#if column.isDateTimeColumn>	        
		        <#elseif  column.htmlInputType=="date">	        
		String ${column.columnNameLower}Format = DateUtil.parseString(request,"${column.columnNameLower}","${column.displayFormat}","${column.parseFormat}");
		${classNameLower}.set${column.columnName}(${column.columnNameLower}Format);
		        <#else>
		        </#if>
		        <#assign i=i+1 />
		    </#if>
	    </#list>
		${classNameLower}Manager.update(this.${classNameLower});
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			<#if table.compositeId>
			${className}Id id = (${className}Id)copyProperties(${className}Id.class,params);
			<#else>
				<#list table.compositeIdColumns as column>
			${column.javaType} id = new ${column.javaType}((String)params.get("${column.columnNameLower}"));
				</#list>
			</#if>
			${classNameLower}Manager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

}
