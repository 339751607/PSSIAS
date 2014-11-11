package net.java.dev.common.dict.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Tab extends BodyTagSupport {

	private String id;
	private String width;
	private String height;
	private String align;
	private String bgcolor;
	
	protected int total;
	protected StringBuffer contentHtml;
	protected StringBuffer titleHtml;

	/**
	 * 
	 */
	public Tab() {
		id = null;
		width="100%";
		height="100%";
		align=null;
		bgcolor="buttonface";
		total = 0;
		contentHtml = new StringBuffer("");
		titleHtml = new StringBuffer("");
	}
	
	public int getTotal() {
		return total;
	}
	
	public void addTab() {
		total++;
	}
	
	public void append(String s) {
		contentHtml.append(s);
	}

	public void appendTitle(String s) {
		titleHtml.append(s);
	}

	public int doStartTag() throws JspException {
		//TODO Add your code here.
		StringBuffer buff = new StringBuffer("");
		buff.append("<table id=\"");
		buff.append(id);
		if (align != null && !align.equals("")) {
			buff.append("\" align=\"");
			buff.append(align);
		}
		buff.append("\" width=\"");
		buff.append(width);
		buff.append("\" height=\"");
		buff.append(height);
		buff.append("\" cellPadding=\"0\" cellSpacing=\"0\" class=\"tabSelectBar\"  bgcolor=\"");
		buff.append(bgcolor);
		buff.append("\">\n<tr><td valign=\"top\">\n<table cellPadding=\"0\" cellSpacing=\"0\">\n");
		buff.append(" <tr class=\"tabSelectTable\">\n");

		try {
			JspWriter jspwriter = pageContext.getOut();
			jspwriter.print(buff.toString());
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			throw new JspException(e.toString());
		}
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		//TODO Add your code here. 
		StringBuffer buff = new StringBuffer("");
		buff.append(titleHtml);
		buff.append("  <td class=\"barPadding\">&nbsp;</td>\n");
		buff.append(" </tr>\n</table>\n<tr><td colspan=\"2\" class=\"tabSelectContent\">");
		buff.append("<table cellPadding=\"0\" cellSpacing=\"0\" class=\"tabSelectContentTable\">\n");
		buff.append(" <tr><td valign=\"top\" width=\"100%\" height=\"100%\">\n");
		buff.append(contentHtml);
		buff.append(" </td></tr>\n</table></td></tr></table>\n<script>gmobj('");
		buff.append(id);
		buff.append("').initTab();</script>\n");

		try {
			JspWriter jspwriter = pageContext.getOut();
			jspwriter.print(buff.toString());
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			throw new JspException(e.toString());
		}
		release();
		return super.doEndTag();
	}

	/* （非 Javadoc）
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	public void release() {
		// TODO 自动生成方法存根
		id = null;
		width="100%";
		height="100%";
		bgcolor="buttonface";
		align=null;
		total = 0;
		contentHtml = new StringBuffer("");
		titleHtml = new StringBuffer("");
		super.release();
	}

	public String getId() {
		return id;
	}
	public void setId(String value) {
		this.id = value;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String value) {
		this.width = value;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String value) {
		this.height = value;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public void setBgcolor(String value) {
		this.bgcolor = value;
	}
	/**
	 * @return 返回 align。
	 */
	public String getAlign() {
		return align;
	}
	/**
	 * @param align 要设置的 align。
	 */
	public void setAlign(String align) {
		this.align = align;
	}
}