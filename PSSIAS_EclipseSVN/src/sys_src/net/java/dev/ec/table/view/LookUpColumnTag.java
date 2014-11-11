package net.java.dev.ec.table.view;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.tag.ColumnTag;

public class LookUpColumnTag extends ColumnTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dictType;
	
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictType() {
		return dictType;
	}
	
	public void addColumnAttributes(TableModel model, Column column) {
		column.addAttribute("dictType", dictType);
    }


}
