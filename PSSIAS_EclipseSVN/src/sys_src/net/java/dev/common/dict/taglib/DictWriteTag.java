package net.java.dev.common.dict.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class DictWriteTag extends ComponentTagSupport {
	
	
	
	
	
	/**
	 * 
	 */

	
	
	/** 下拉菜单缺省值 */
	protected String value;

	/** 不使用property时定义的下拉菜单名 */
	protected String name;

	/** 接受actionform 的属性 */
	protected String property;

	/** 页面传入的list数据 */
	protected String listName;

	/** 内存中字典数据名 */
	protected String dictName;

	/** 数据的所属语言种类,如果传入all 或 ALL 则返回所有语言种类的数据 */
	protected String language;

	protected String multiple;

	protected String size;

	protected String[] match;
	
	public String getNotEmpty() {
		return notEmpty;
	}

	public void setNotEmpty(String notEmpty) {
		this.notEmpty = notEmpty;
	}

	protected String notEmpty;
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String[] getMatch() {
		return match;
	}

	public void setMatch(String[] match) {
		this.match = match;
	}

	

	
	

	@Override
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		return new DictWrite(arg0, arg1);

	}

	protected void populateParams() {

		super.populateParams();

		DictWrite dictSelect = (DictWrite) component;
		dictSelect.setDictName(dictName);
		dictSelect.setLanguage(language);
		dictSelect.setListName(listName);
		dictSelect.setMatch(match);
		dictSelect.setMultiple(multiple);
		dictSelect.setName(name);
		dictSelect.setNotEmpty(notEmpty);
		dictSelect.setProperty(property);
		dictSelect.setSize(size);
		dictSelect.setValue(value);

	

	}

}
