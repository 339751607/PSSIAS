package net.java.dev.common.dict.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;



public class TabContent extends BodyTagSupport {
	private String id;
	private String title;
	private String titleProperty;
	private String tabType;
	private String url;
	private String urlProperty;
	private String param;
	private String paramValue;
	
	private String selected;
	private String titleStyle;
	private String frameBorder;
	private String frameStyle;
	private String scrolling;

	private String tabId;
	private String tabno;
	private boolean urlQuest;
	
	private Tab parentTab;
	String savebody;
	
	public TabContent() {
		id = "reqContext";
		title = null;
		tabType = "div";
		url = null;
		urlProperty = null;
		param = null;
		paramValue = null;
		selected = "false";
		titleStyle = null;
		savebody = null;
		frameBorder = null;
		frameStyle = "width:100%;height:100%";
		scrolling = null;
		
		urlQuest = false;
		tabId = null;
		tabno = "0";
		
		parentTab = null;
	}
	
	public int doStartTag() throws JspException {
		//TODO Add your code here. 
		Object tab = getParent();
		while (tab != null && !(tab instanceof net.java.dev.common.dict.taglib.Tab)) {
			tab = ((javax.servlet.jsp.tagext.TagSupport)tab).getParent();
		}
		if (tab == null || !(tab instanceof net.java.dev.common.dict.taglib.Tab)) {
			throw new JspException("the tabcontent not include in tab!");
		}
		HttpServletRequest req = ((HttpServletRequest) pageContext.getRequest());
		parentTab = (Tab)tab;
		try
		{
			if (pageContext.getRequest().getAttribute("id") != null) {
				id = (String) pageContext.getRequest().getAttribute("id");
			}
			if (pageContext.getRequest().getAttribute("title") != null) {
				title = (String) pageContext.getRequest().getAttribute("title");
			}
			if (pageContext.getRequest().getAttribute("titleProperty") != null) {
				titleProperty = (String) pageContext.getRequest().getAttribute("titleProperty");
			}
			if (pageContext.getRequest().getAttribute("titleStyle") != null) {
				titleStyle = (String) pageContext.getRequest().getAttribute("titleStyle");
			}
			if (pageContext.getRequest().getAttribute("tabType") != null) {
				tabType = (String) pageContext.getRequest().getAttribute("tabType");
			}
			
			if (pageContext.getRequest().getAttribute("url") != null) {
				url = (String) pageContext.getRequest().getAttribute("url");
			}
			if (pageContext.getRequest().getAttribute("urlProperty") != null) {
				urlProperty = (String) pageContext.getRequest().getAttribute("urlProperty");
			}
			if (pageContext.getRequest().getAttribute("param") != null) {
				param = (String) pageContext.getRequest().getAttribute("param");
			}
			if (pageContext.getRequest().getAttribute("selected") != null) {
				selected = (String) pageContext.getRequest().getAttribute("selected");
			}
			if (pageContext.getRequest().getAttribute("frameBorder") != null) {
				frameBorder = (String) pageContext.getRequest().getAttribute("frameBorder");
			}
			if (pageContext.getRequest().getAttribute("frameStyle") != null) {
				frameStyle = (String) pageContext.getRequest().getAttribute("frameStyle");
			}
			if (pageContext.getRequest().getAttribute("scrolling") != null) {
				scrolling = (String) pageContext.getRequest().getAttribute("scrolling");
			}
			
		
		}
		catch (Exception exception)
		{
			throw new JspException("get property fail!");
		}
		if (title == null)
			throw new JspException("tab content need title");
		if (tabType.equalsIgnoreCase("frame")) {
			try {
				getFrameUrl();
			} catch (Exception e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
				throw new JspException(e.toString());
			}
		}

		StringBuffer buff = new StringBuffer("");
		Tab parentTab = (Tab)tab;
		tabId = String.valueOf(parentTab.getId());
		tabno = String.valueOf(parentTab.getTotal());
		buff.append("  <td><table cellPadding=\"0\" cellSpacing=\"0\" onclick=\"gmobj('");
		buff.append(tabId);
		buff.append("').select_tab(");
		buff.append(tabno);
		buff.append(");\"");
		if (tabType.equalsIgnoreCase("frame")) {
			buff.append(" onmouseover=\"gmobj('");
			buff.append(tabId);
			buff.append("').mouseovertab(");
			buff.append(tabno);
			buff.append(");\" onmouseout=\"gmobj('");
			buff.append(tabId);
			buff.append("').mouseouttab(");
			buff.append(tabno);
			buff.append(");\"");
		}
		buff.append(">\n   <tr>\n");
		if (parentTab.getTotal() == 0) {
			buff.append("    <td><img id=\"");
			buff.append(tabId);
			buff.append("_tab_image_first\" src=\""+req.getContextPath()+"/images/tab/first_select.gif\" border=\"0\"></td>\n");
		}
		buff.append("    <td nowrap id=\"");
		buff.append(tabId);
		buff.append("_tab_text");
		buff.append(tabno);
		buff.append("\"");
		if (titleStyle != null) {
			buff.append(" style=\"");
			buff.append(titleStyle);
			buff.append("\"");
		}
		buff.append(" class=\"tabSelectUp\">");
		buff.append(title);
		buff.append("</td>\n");

		buff.append("    <td><img id=\"");
		buff.append(tabId);
		buff.append("_tab_image_divide");
		buff.append(tabno);
		buff.append("\" src=\""+req.getContextPath()+"/images/tab/select_right.gif\" border=\"0\"></td>\n");
		buff.append("<script>\n");
		if (parentTab.getTotal() == 0) {
			buff.append("createTabTable(gmobj(\"");
			buff.append(tabId);
			buff.append("\"));\n");
		}
		buff.append("gmobj(\"");
		buff.append(tabId);
		buff.append("\").createTabContent(\"");
		if (tabType.equalsIgnoreCase("frame")) {
			buff.append("frame\", \"");
			buff.append(url);
			buff.append("\"");
		}else
			buff.append("div\", null");
		if (selected != null && selected.equalsIgnoreCase("true")) {
			buff.append(", true");
		}
		buff.append(");\n</script>\n   </tr>\n  </table>\n  </td>\n");
		parentTab.appendTitle(buff.toString());
		
		parentTab.append("<div id=\"");
		parentTab.append(tabId);
		parentTab.append("_tab_content_div");
		parentTab.append(tabno);
		parentTab.append("\" style=\"overflow:auto;display:none\">\n");

		return super.doStartTag();
	}

	private void getFrameUrl() throws Exception {
		if (param == null) return;
		
		try
		{
			if (pageContext.getRequest().getAttribute("paramValue") != null) {
				paramValue = (String) pageContext.getRequest().getAttribute("paramValue");
			}
		
			if (urlProperty != null){
				if (pageContext.getRequest().getAttribute("url") != null) {
					url = (String) pageContext.getRequest().getAttribute("url");
				}
			}		
		}
		catch (Exception exception)
		{
			throw new JspException("get property fail!");
		}
		if (url == null || url.equals("")) return;
		StringBuffer urlBuff = new StringBuffer(url);
		if (url.indexOf('?') != -1) {
			if (url.endsWith("?")) {
				urlQuest = false;
				urlBuff = new StringBuffer(url.substring(0, url.length()-1));
			} else
				urlQuest = true;
		} else {
			urlQuest = false;
		}
		if (urlQuest)
			urlBuff.append("&");
		else {
			urlBuff.append("?");
			urlQuest = true;
		}
		urlBuff.append(param);
		urlBuff.append("=");
		urlBuff.append(paramValue);
		url = urlBuff.toString();
		
	}

	

	private String checkString(String s){
		if (s == null) return "";
		return s;
	}

	public int doAfterBody() throws JspException
	{
		if (bodyContent != null)
		{
			String s = bodyContent.getString();
			if (s == null)
				s = "";
			savebody = s.trim();
		}
		return 0;
	}

	/* （非 Javadoc）
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	public void release() {
		// TODO 自动生成方法存根
		id = "reqContext";
		title = null;
		tabType = "div";
		url = null;
		urlProperty = null;
		param = null;
		selected = "false";
		titleStyle = null;
		savebody = null;
		frameBorder = null;
		frameStyle = "width:100%;height:100%";
		scrolling = null;

		tabId = null;
		tabno = "0";
		
		parentTab = null;
		super.release();
	}

	public int doEndTag() throws JspException {
		//TODO Add your code here. 
		if (tabType.equalsIgnoreCase("frame")) {
			parentTab.append(" <IFRAME  name=\"");
			parentTab.append(tabId);
			parentTab.append("_tab_content_frame");
			parentTab.append(tabno);
			parentTab.append("\"");
			if (frameStyle != null) {
				parentTab.append(" style=\"");
				parentTab.append(frameStyle);
				parentTab.append("\"");
			}
			if (frameBorder != null) {
				parentTab.append(" frameBorder=\"");
				parentTab.append(frameBorder);
				parentTab.append("\"");
			}
			if (scrolling != null) {
				parentTab.append(" scrolling=\"");
				parentTab.append(scrolling);
				parentTab.append("\"");
			} else 
				parentTab.append(" scrolling=\"auto\"");
			parentTab.append(" src=\"\"></IFRAME>");
		} else
			parentTab.append(savebody);
		parentTab.append("\n</div>\n");
		parentTab.addTab();
		release();
		return super.doEndTag();
	}

	public String getTabType() {
		return tabType;
	}
	public void setTabType(String value) {
		this.tabType = value;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String value) {
		this.url = value;
	}
	public String getUrlProperty() {
		return urlProperty;
	}
	public void setUrlProperty(String value) {
		this.urlProperty = value;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String value) {
		this.param = value;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String value) {
		this.selected = value;
	}
	public String getTitleStyle() {
		return titleStyle;
	}
	public void setTitleStyle(String value) {
		this.titleStyle = value;
	}
	/**
	 * @return 返回 frameBorder。
	 */
	public String getFrameBorder() {
		return frameBorder;
	}
	/**
	 * @param frameBorder 要设置的 frameBorder。
	 */
	public void setFrameBorder(String frameBorder) {
		this.frameBorder = frameBorder;
	}
	/**
	 * @return 返回 frameStyle。
	 */
	public String getFrameStyle() {
		return frameStyle;
	}
	/**
	 * @param frameStyle 要设置的 frameStyle。
	 */
	public void setFrameStyle(String frameStyle) {
		this.frameStyle = frameStyle;
	}
	/**
	 * @return 返回 id。
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id。
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return 返回 scrolling。
	 */
	public String getScrolling() {
		return scrolling;
	}
	/**
	 * @param scrolling 要设置的 scrolling。
	 */
	public void setScrolling(String scrolling) {
		this.scrolling = scrolling;
	}
	/**
	 * @return 返回 title。
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title 要设置的 title。
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return 返回 titleProperty。
	 */
	public String getTitleProperty() {
		return titleProperty;
	}
	/**
	 * @param titleProperty 要设置的 titleProperty。
	 */
	public void setTitleProperty(String titleProperty) {
		this.titleProperty = titleProperty;
	}
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
}