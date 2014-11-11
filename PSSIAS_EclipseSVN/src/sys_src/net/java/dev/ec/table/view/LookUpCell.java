package net.java.dev.ec.table.view;

import java.util.List;
import java.util.Locale;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.cell.AbstractCell;
import org.extremecomponents.table.core.TableModel;

import com.dyneinfo.zazh.model.DictItem;

public class LookUpCell extends AbstractCell {
	
	protected String getCellValue(TableModel model, Column column) {
		
		
		String key = column.getValueAsString();
		String dictType = column.getAttributeAsString("dictType");
		Locale	locale = Locale.getDefault();
			
		 List maincatproduct = DictHelpImpl.getDict(dictType,locale.toString());
		 if (maincatproduct != null){
				for(int i=0;i<maincatproduct.size();i++){
					DictItem dictItem = (DictItem)maincatproduct.get(i);
				    if(dictItem.getDictid() != null && dictItem.getDictid().equals(key) )
				        return dictItem.getDictname();
				}
			}
		 
		return "";
	}


}
