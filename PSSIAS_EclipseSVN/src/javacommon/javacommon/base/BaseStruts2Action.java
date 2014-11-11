package javacommon.base;

import java.util.Map;

import javacommon.util.ConvertRegisterHelper;
import javacommon.util.PageRequestFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.util.Assert;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.util.ObjectUtils;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseStruts2Action extends ActionSupport implements RequestAware {
	protected Map requestMap = null;
	protected static final String MSG_JSP = "/commons/msgShow.jsp";
	protected static final String MSG1_JSP = "/commons/msg1.jsp";
	static {
		//注册converters
		ConvertRegisterHelper.registerConverters();
	}
	
	public void copyProperties(Object target,Object source) {
		BeanUtils.copyProperties(target, source);
	}

	public <T> T copyProperties(Class<T> destClass,Object orig) {
		return BeanUtils.copyProperties(destClass, orig);
	}
	
	public void setRequest(Map request) {
		this.requestMap = request;
	}

	public void savePage(Page page,PageRequest pageRequest){
		savePage("",page,pageRequest);
	}
	
	/**
	 * 用于一个页面有多个extremeTable是使用
	 * @param tableId 等于extremeTable的tableId属性
	 */
	public void savePage(String tableId,Page page,PageRequest pageRequest){
		Assert.notNull(tableId,"tableId must be not null");
		Assert.notNull(page,"page must be not null");
		
		getRequest().setAttribute(tableId+"page", page);
		getRequest().setAttribute(tableId+"totalRows", new Integer(page.getTotalCount()));
		getRequest().setAttribute(tableId+"pageRequest", pageRequest);
	}
	
	public PageRequest newPageRequest(String defaultSortColumns){
		return PageRequestFactory.newPageRequest(ServletActionContext.getRequest(), defaultSortColumns);
    }
	
	public boolean isNullOrEmptyString(Object o) {
		return ObjectUtils.isNullOrEmptyString(o);
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	

	public String getJsonString() {

		return jsonString;

	}

	public void setJsonString(String jsonString) {

		this.jsonString = jsonString;

	}

	public String jsonExecute() throws Exception {

		return super.execute();

	}

	public int getTotalCount() {

		return totalCount;

	}

	public void setTotalCount(int totalCount) {

		this.totalCount = totalCount;

	}

	public int getStart() {

		return start;

	}

	public void setStart(int start) {

		this.start = start;

	}

	public int getLimit() {

		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;

	}
	
	
	
	private int totalCount = 0;// 总数   

	private transient int start = 0;// 开始数   

	private transient int limit = 0;// 限制数量   

	private String jsonString = "";
}

