package net.java.dev.common.dict.taglib;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;








/****
 * 
 * 
 * 
 * 
 * jsp页面中这样使用：
 * <s:form theme="simple" action="create" id="saveForm">
	<mytag:params includes="ec*,query*,s*" type="inputTag"></mytag:params>
</s:form>

或者
  <a href='edit.do?id=${item.id}&<mytag:params includes="ec*,query*,s*" type="queryString"/>'>edit</a>
 * 
 * 
 * 
 * @author lisc
 *
 */

public class ParametersTag extends BodyTagSupport {
	  private static Log log = LogFactory.getLog(ParametersTag.class);
	  /** 输出为input tag */
	  public static final String TYPE_INPUT_TAG = "inputTag";
	  /** 输出为query string */
	  public static final String TYPE_QUERY_STRING = "queryString";
	  /** 输出为query string */
	  public static final String TYPE_QUERY_STRING_UTF = "queryStringUtf";
	  
	  /**
	   * 指定包含的parameters，如果没有指定，则包含全部。可以使用*、?作为通配符。
	   */
	  private String includes;
	  /**
	   * @see #TYPE_INPUT_TAG
	   * @see #TYPE_QUERY_STRING
	   */
	  private String type;

	  /**
	   * @see javax.servlet.jsp.tagext.BodyTagSupport#release()
	   */
	  @Override
	  public void release() {
	    includes = null;
	    type = null;
	    super.release();
	  }

	  /**
	   * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	   */
	  @Override
	  public int doEndTag() throws JspException {    
		  try {
			  	pageContext.getRequest().setCharacterEncoding("UTF-8");
			     } catch (UnsupportedEncodingException uee) {
			  	throw new JspTagException(uee.getMessage());
			     }



	    Enumeration<String> keys = pageContext.getRequest().getParameterNames();
	    String str = "";    
	    if(StringUtils.isBlank(type) || StringUtils.equals(TYPE_INPUT_TAG, type)) {
	      log.debug("Build Input Tags.");
	      str = buildInputTags(keys);
	    } else if(StringUtils.isNotBlank(type) &&  StringUtils.equals(TYPE_QUERY_STRING_UTF, type))  {
	      log.debug("Build query string.");
	      str = buildQueryStringUtf(keys);
	    } else if(StringUtils.isNotBlank(type) &&  StringUtils.equals(TYPE_QUERY_STRING, type)) {
		      log.debug("Build query string.");
		      str = buildQueryString(keys);
		 }
	    try {
	      pageContext.getOut().write(str);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return BodyTagSupport.EVAL_PAGE;
	  }
	  
	  /**
	   * 根据参数构造queryString
	   * @param keys 参数名称
	   */
	  private String buildQueryString(Enumeration<String> keys) {
	    StringBuffer buf = new StringBuffer();
	    while(keys.hasMoreElements()) {
	      String key = keys.nextElement();
//	      System.out.println("key="+key);
	      if(!isInclude(key)) {
		        continue;
		      }
	      String value = pageContext.getRequest().getParameter(key);
//	      System.out.println(key+ " value="+value);
	      if(StringUtils.isBlank(value)) {
	        continue;
	      }
//	      if(value != null){
//	    	  value = value.replaceAll("\\s*", "");
//	      }
	      buf.append(key)
	      .append("=")
	      .append(value);
	      if(keys.hasMoreElements()) {
	        buf.append("&");
	      }
	    }
//	    System.out.println("buf="+buf.toString());
	    return buf.toString();
	  }
	  
	  
	  /**
	   * 根据参数构造queryString
	   * @param keys 参数名称
	   */
	  private String buildQueryStringUtf(Enumeration<String> keys) {
	    StringBuffer buf = new StringBuffer();
	    while(keys.hasMoreElements()) {
	      String key = keys.nextElement();
//	      System.out.println("utf-key="+key);
	      if(!isInclude(key)) {
		        continue;
		      }
	      String value = pageContext.getRequest().getParameter(key);
	      if(StringUtils.isBlank(value)) {
		        continue;
		      }
//	      if(value != null){
//	    	  value = value.replaceAll("\\s*", "");
//	      }
	      try{
	         value=java.net.URLEncoder.encode(value,"utf-8");  
	      } catch(Exception e){
	    	  
	      }
	     
	    
	      buf.append(key)
	      .append("=")
	      .append(value);
	      if(keys.hasMoreElements()) {
	        buf.append("&");
	      }
	    }
//	    System.out.println("utf-buf="+buf.toString());
	    return buf.toString();
	  }

	  /**
	   * 根据参数构造Input
	   * @param keys 参数名称
	   */
	  private String buildInputTags(Enumeration<String> keys) {
	    StringBuffer buf = new StringBuffer();
	    while(keys.hasMoreElements()) {
	      String key = keys.nextElement();
	      if(!isInclude(key)) {
	        continue;
	      }
	      String value = pageContext.getRequest().getParameter(key);
	      buf.append("<input type='hidden' name='")
	      .append(key) 
	      .append("' value='")
	      .append((value == null) ? StringUtils.EMPTY :value)
	      .append("'/>");
	    }
	    
	    return buf.toString();
	  }
	  
	  /**
	   * 判断某个参数是否可以包含。
	   */
	  private boolean isInclude(String target) {
	    if(StringUtils.isBlank(includes)) {
	      return true;
	    }
	   
	    PathMatcher matcher = new AntPathMatcher();
	   // Set<String> incs = StringUtil.parseCommaSplitedString(includes);  
	    
	    String[] incsArr = includes.split(",");
		Set<String> incs = new HashSet<String>();
		for (int j = 0; j < incsArr.length; j++) {
			incs.add(incsArr[j]);
		} 
	    for(String inc : incs) {
	      if(matcher.match(inc, target)) {
	        return true;
	      }
	    }
	    
	    return false;
	  }
	  
	  
	  /**
	   * @return the includes
	   */
	  public String getIncludes() {
	    return includes;
	  }

	  /**
	   * @param includes the includes to set
	   */
	  public void setIncludes(String includes) {
	    this.includes = includes;
	  }

	  /**
	   * @return the type
	   */
	  public String getType() {
	    return type;
	  }

	  /**
	   * @param type the type to set
	   */
	  public void setType(String type) {
	    this.type = type;
	  }
	}