package com.dyneinfo.zazh.model;

import java.util.HashSet;
import java.util.Set;

public class JSONTreeNodeSel {
	
	 private String id;
	 private String text;
	 private boolean leaf=true;
	 private boolean checked	 =false;
	 private String  iconCls	= "dept";
	 private boolean dep		= false;
	 
	 private Set<JSONTreeNodeSel> children = new HashSet<JSONTreeNodeSel>(0);
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public boolean isDep() {
		return dep;
	}
	public void setDep(boolean dep) {
		this.dep = dep;
	}
	public Set<JSONTreeNodeSel> getChildren() {
		return children;
	}
	public void setChildren(Set<JSONTreeNodeSel> children) {
		this.children = children;
	}

}
