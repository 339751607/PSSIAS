package net.java.dev.common.dict.taglib;

import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import net.java.dev.common.dict.ISelectOption;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class DictSelect extends Component {

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

	public String getNotEmpty() {
		return notEmpty;
	}

	public void setNotEmpty(String notEmpty) {
		this.notEmpty = notEmpty;
	}
	
	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

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
	
	protected String styleClass;
	
	protected String onchange;

	protected String[] match;

	/** 是否禁止首项为空 */
	protected String notEmpty;

	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public DictSelect(ValueStack arg0, HttpServletRequest request) {
		super(arg0);
		this.request = request;

	}

	@Override
	public boolean end(Writer writer, String body) {
		boolean result = super.start(writer);
	//	System.out.println("pppppppppppppppppppppppppppppppppppppppppppppend="+property);
		try {
			if (property != null && property.startsWith("%{") && property.endsWith("}"))
			{
				property = property.substring(2, property.length() - 1);
				//System.out.println("property ==============================="+property);
				if(name == null)
				  name = property;
				property = (String) this.getStack().findValue(property);
				value = property;
				//System.out.println("property value =================================================="+value);
			}	
			StringBuilder sb = new StringBuilder();
			getMatchValue();
			sb.append(getStartElement());
			sb.append(getOptions());
			sb.append("</select>");
			writer.write(sb.toString());

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return result;

	}

	private String getStartElement() throws JspException {
		StringBuffer sb = new StringBuffer("<select");
		sb.append(" name=\"");
		sb.append(this.name);
		sb.append("\"");
		
		if (multiple != null)
			sb.append(" multiple=\"multiple\"");
		if (size != null) {
			sb.append(" id=\"");
			sb.append(size);
			sb.append("\"");
		}
		if (styleClass != null) {
			sb.append(" class=\"");
			sb.append(styleClass);
			sb.append("\"");
		}
		if (onchange != null) {
			sb.append(" onchange=\"");
			sb.append(onchange);
			sb.append("\"");
		}
		
		sb.append(">");
		return sb.toString();
	}

	protected String getOptions() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (language == null || language.equals("")) {
			Locale local = (Locale) request.getLocale();
			if (local != null)
				language = local.toString();
		}
		StringBuffer sb = new StringBuffer();
		if (this.notEmpty == null || !notEmpty.equalsIgnoreCase("true"))
			sb.append("<option value=''>请选择... </option>");
		List datas = null;
		if (listName != null)
			datas = (List) request.getAttribute(listName);
		else if (dictName != null) {
			try {
				if ("all".equalsIgnoreCase(language))
					datas = DictHelpImpl.getDict(dictName);
				else
					datas = DictHelpImpl.getDict(dictName, language);
			} catch (Exception e) {
				datas = null;
			}
		} else {
			System.out.println("未指定下拉菜单的数据源，请定义listName 或 dictName");
		}

		if (datas == null || datas.size() == 0)
			return "<option>-- 无选项 --</option>";
		for (int i = 0; i < datas.size(); i++) {
			ISelectOption bean = (ISelectOption) datas.get(i);

			sb.append("\n<option value=\"").append(bean.getValue().trim())
					.append("\"");
			//sb.append(getFieldStr(bean));
			
			if (matchValue(bean.getValue().trim()))
				sb.append(" selected='true' ");
			sb.append(">");
			sb.append(bean.getName()).append("</option>");
		}
		return sb.toString();
	}

	private String getFieldStr(Object obj) {
		StringBuffer sb = new StringBuffer(" ");
		Field[] fs = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			try {
				Object value = fs[i].get(obj);
				if (value != null)
					sb.append(fs[i].getName()).append("=\"").append(value)
							.append("\" ");
			} catch (Exception e) {

			}
		}
		return sb.toString();
	}

	protected void getMatchValue() throws IllegalAccessException,
			InvocationTargetException {
		//System.out.println("===================================getMatchValue");
		if (this.value == null)
			return;
		String[] beans = this.value.split("\\.");
		if (beans != null && beans.length < 2) {
			this.match = new String[1];
			this.match[0] = this.value;
			return;
		}
		try {
			if (beans != null) {
				this.match = new String[beans.length];
				for (int i = 1; i < beans.length - 1; i++) {
					this.match[i - 1] = beans[i - 1];

				}
			}

		} catch (Exception e) {
			this.match = new String[1];
			this.match[0] = this.value;
		}
	}

	protected boolean matchValue(String v) {
		if (this.match == null || this.match.length == 0)
			return false;
		for (int i = 0; i < this.match.length; i++) {
			if (match[i] != null)
				if (match[i].equals(v))
					return true;
		}
		return false;
	}

}
