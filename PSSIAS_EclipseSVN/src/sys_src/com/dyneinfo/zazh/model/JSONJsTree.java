package com.dyneinfo.zazh.model;

import java.util.HashSet;
import java.util.Set;

public class JSONJsTree {

	private String data;
	private String state;
	private JSONJsTreeAttr attr; 
	
	 private Set<JSONJsTree> children = new HashSet<JSONJsTree>(0);

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Set<JSONJsTree> getChildren() {
		return children;
	}
	public void setChildren(Set<JSONJsTree> children) {
		this.children = children;
	}

	public JSONJsTreeAttr getAttr() {
		return attr;
	}

	public void setAttr(JSONJsTreeAttr attr) {
		this.attr = attr;
	}

	

	


	

}
