package cn.org.rapid_framework.generator.provider.db.model;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class ComparatorColumn implements Comparator{

	 public int compare(Object arg0, Object arg1) {
		 Column column0=(Column)arg0;
		 Column column1=(Column)arg1;

	   //首先比较页面顺序，如果页面顺序相同，则比较数据库顺序
	  
		
		  int flag=column0.getColumncHtmlOrder().compareTo(column1.getColumncHtmlOrder());
		  if(flag==0){
		   return column0.getColumnOrder().compareTo(column1.getColumnOrder());
		  }else{
		   return flag;
		  }  

	 }
	 
	}


