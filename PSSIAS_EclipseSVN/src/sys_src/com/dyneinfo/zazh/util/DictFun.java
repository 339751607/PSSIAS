package com.dyneinfo.zazh.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import com.dyneinfo.zazh.model.DictItem;

public class DictFun {

	public static final Map getDictMap(String dictName) {
		Map<String, String> options = new HashMap<String, String>();
		Locale locale = Locale.getDefault();
		List maincatproduct = DictHelpImpl.getDict(dictName, locale.toString());
		if (maincatproduct != null) {
			for (int i = 0; i < maincatproduct.size(); i++) {
				DictItem dictItem = (DictItem) maincatproduct.get(i);
				options.put(dictItem.getDictid(), dictItem.getDictname());
			}
		}
		return options;
	}
	
	
	public static final String getDictValue(String dictName,String dictId) {
		Locale locale = Locale.getDefault();
		List maincatproduct = DictHelpImpl.getDict(dictName, locale.toString());
		if (maincatproduct != null){
			for(int i=0;i<maincatproduct.size();i++){
				DictItem dictItem = (DictItem)maincatproduct.get(i);
			    if(dictItem.getDictid() != null && dictItem.getDictid().equals(dictId) )
			        return dictItem.getDictname();
			}
		}
	return "";
	}
	
	public static final String getDictValue(String dictName,Object obj) {
		Locale locale = Locale.getDefault();
		List maincatproduct = DictHelpImpl.getDict(dictName, locale.toString());
		String tmp_objvalue = "";
		if(obj != null)
			tmp_objvalue = obj.toString();
		if (maincatproduct != null){
			for(int i=0;i<maincatproduct.size();i++){
				DictItem dictItem = (DictItem)maincatproduct.get(i);
			    if(dictItem.getDictid() != null && dictItem.getDictid().equals(tmp_objvalue) )
			        return dictItem.getDictname();
			}
		}
	return "";
	}
	
	
}
