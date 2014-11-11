package com.dyneinfo.zazh.model;



public class MainMenuItemExt  extends MainMenuItem{
	
	private String menuImage;
	private String menuID;
	private String menuTarget;
	private String parentID;
	private int    displayOrder; 
	
	public MainMenuItemExt() {
		super();
	}
	
	public void setDisplayOrder(int displayOrder){
		this.displayOrder = displayOrder;
	}
	
	public int getDisplayOrder(){
		return this.displayOrder;
	}
	
	public void setMenuID(String menuID){
		this.menuID = menuID;
	}
	
	public String getMenuID(){
		return this.menuID;
	}

	public void setParentID(String parentID){
		this.parentID = parentID;
	}
	
	public String getParentID(){
		return this.parentID;
	}
	
	public void setMenuImage(String menuImage){
		this.menuImage = menuImage;
	}
	
	public String getMenuImage(){
		return this.menuImage;
	}
	
	public void setMenuTarget(String menuTarget){
		this.menuTarget = menuTarget;
	}
	
	public String getMenuTarget(){
		return this.menuTarget;
	}
	
	public String toJavaScriptString(){
		StringBuffer st = new StringBuffer();
		st.append("\"" + this.getName() +"\",");
		if (this.getAction() == null)
			st.append("\"\",");
		else
			st.append("\"" + this.getAction() +"\",");
		st.append("\"" + this.getChilds().length +"\",");
		
		if( this.getMenuImage() == null )
			st.append("\"\",");
		else
			st.append("\"" + this.getMenuImage() +"\",");
		if( this.getMenuTarget() == null )
			st.append("\"\"");
		else
			st.append("\"" + this.getMenuTarget() +"\"");
		
		return st.toString();
	}
}

