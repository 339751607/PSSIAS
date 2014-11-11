/*---------------------------说明-------------------------------------------------------*/
	//左侧XML菜单树层级分类:顶级菜单->一级菜单->二级菜单->多级菜单;
	/*样式引用及定义:1.默认状态在样式表:/fbrole/main/outlookmenu/css/main.css
	                  样式定义---顶级菜单: #treeBox .hasItems
	                             一级菜单: #treeBox .Items
	                             二级菜单: #treeBox .Items2
	                             多级菜单: #treeBox .Items_others
	                2.鼠标移上(onmouseover)样式在本页页头:
	                  样式定义---顶级菜单: 无
	                             一级菜单: HC
	                             二级菜单: HC2
	                             多级菜单: HC3   
	                3.鼠标点击后(onmousedown)样式在本页页头:
	                  样式定义---顶级菜单: 无
	                             一级菜单: SC
	                             二级菜单: SC2
	                             多级菜单: SC3 	
	var HC = "color:#EF2700;background:url(css/treebox_sub2.gif) repeat-x left top;width:135px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";// 一级菜单鼠标移动上样式
	var HC2= "color:#EF2700;background:url(css/treebox_son_sub2.gif) repeat-x left top;width:124px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";// 二级菜单鼠标移动上样式
	var HC3= "color:#EF2700;background:url(css/treebox_son_sub2.gif) repeat-x left top;width:124px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";// 多级菜单鼠标移动上样式
	var SC = "color:#DF1C1C;font-weight:bold;font-size:102%;background:url(css/treebox_sub2.gif) repeat-x left top;width:135px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";//一级菜单点击后状态
	var SC2="color:#DF1C1C;font-weight:bold;font-size:102%;background:url(css/treebox_son_sub2.gif) repeat-x left top;width:124px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";//二级菜单点击后状态;
	var SC3="color:#DF1C1C;font-weight:bold;font-size:102%;background:url(css/treebox_son_sub2.gif) repeat-x left top;width:124px;height:23px;border-top:1px solid #435d61;border-left:1px solid #101010;border-right:1px solid #101010;";//多级级菜单点击后状态;                                                
	*/
	var HC = "color:#01AAF0;width:160px;";// 一级菜单鼠标移动上样式
	var HC2= "color:#EF2700;width:160px;";// 二级菜单鼠标移动上样式
	var HC3= "color:#EF2700;width:160px;";// 多级菜单鼠标移动上样式
	var SC = "color:#DF1C1C;width:160px;font-weight:bold;";//一级菜单点击后状态
	var SC2="color:#DF1C1C;font-weight:bold;width:160px;";//二级菜单点击后状态;
	var SC3="color:#DF1C1C;font-weight:bold;width:160px;";//多级级菜单点击后状态;
	var IO = null;
	
	var firstDefaultNode = "";
	var menuLevel = 0;
	var defaultURL="";
	var openFirstMenu = 1;
	
	function initTree(){
		var rootn = document.all.menuXML.documentElement;
		var sd = 1;//菜单级别
		
		openFirstMenu = 1; //打开第一个菜单	
		document.onselectstart = function(){return false;}
		document.all.treeBox.appendChild(createTree(rootn,sd));
	}
	
	function openSelectTree(url){
	    defaultURL = url;
	    openFirstMenu = 0; //打开指定菜单
		var rootn = document.all.menuXML.documentElement;
		var sd = 1;//菜单级别
		document.onselectstart = function(){return false;}
		document.all.treeBox.appendChild(createTree(rootn,sd));
	}
			
	function createTree(thisn,sd){
		var nodeObj = document.createElement("span");
		var upobj = document.createElement("span");
		
		with(upobj){
		    if(sd==1){
		       style.marginLeft = sd*4;//节点菜单左侧空格距离
			   className="hasItems";   //一级菜单样式
		    }else if(sd==2){
		       style.marginLeft = sd*4;//节点菜单左侧空格距离
			   className="Items";       //二级菜单样式
		    }else if(sd==3){
		       style.marginLeft = sd*4;//节点菜单左侧空格距离
			   className="Items2";       //三级菜单样式
		    }else{
		       style.marginLeft = sd*4;//节点菜单左侧空格距离
			   className="Items_others";       //多级菜单样式
		    }
			//style.marginLeft = sd*4;//节点菜单左侧空格距离
			//className = thisn.hasChildNodes()?"hasItems":"Items";//节点菜单样式
			innerHTML = "<img src=img/expand.gif class=ec>"+ thisn.getAttribute("text") +"";
			
			onmousedown = function(){
				if(event.button != 1) return;
				if(this.getAttribute("cn")){
					this.setAttribute("open",!this.getAttribute("open"));
					this.cn.style.display = this.getAttribute("open")?"inline":"none";
					this.all.tags("img")[0].src = this.getAttribute("open")?"img/expand.gif":"img/contract.gif";
				}
				if(IO){
					IO.runtimeStyle.cssText = "";
					IO.setAttribute("selected",false);
				}
				IO = this;
				this.setAttribute("selected",true);
				if(sd==1){
					 this.runtimeStyle.cssText = "hasItems";
				}else if(sd==2){
				    this.runtimeStyle.cssText = SC;
				}else if(sd==3){
				    this.runtimeStyle.cssText = SC2;
				}else{
				    this.runtimeStyle.cssText = SC3;
				
				}
			}
			onmouseover = function(){
				if(this.getAttribute("selected"))return;
				if(sd==1){
				    this.runtimeStyle.cssText = "hasItems";
				}else if(sd==2){
					this.runtimeStyle.cssText = HC;
				}else if(sd==3){
				    this.runtimeStyle.cssText = HC2;
				}else{
				    this.runtimeStyle.cssText = HC3;
				}
				
			}
			onmouseout = function(){
				if(this.getAttribute("selected"))return;
				this.runtimeStyle.cssText = "";
			}
			oncontextmenu = contextMenuHandle;
			onclick = clickHandle;
		}
	
		if(thisn.getAttribute("treeId") != null){
			upobj.setAttribute("treeId",thisn.getAttribute("treeId"));
		}
		if(thisn.getAttribute("href") != null){
			upobj.setAttribute("href",thisn.getAttribute("href"));
		}
		if(thisn.getAttribute("target") != null){
			upobj.setAttribute("target",thisn.getAttribute("target"));
		}	
		if(thisn.getAttribute("status") != null){
			upobj.setAttribute("status",thisn.getAttribute("status"));
		}
	
		nodeObj.appendChild(upobj);
		nodeObj.insertAdjacentHTML("beforeEnd","<br>")
		if(thisn.hasChildNodes()){
			var i;
			var nodes = thisn.childNodes;
			var cn = document.createElement("span");
			upobj.setAttribute("cn",cn);
			//alert(thisn.getAttribute("open"));
			if(thisn.getAttribute("open") != null){
				menuLevel = menuLevel+1;
				if (menuLevel > 1  && openFirstMenu == 1)
				  upobj.setAttribute("open",(thisn.getAttribute("open")=="false"));
				 else  
				 upobj.setAttribute("open",(thisn.getAttribute("open")=="true"));	
				upobj.getAttribute("cn").style.display = upobj.getAttribute("open")?"inline":"none";
				if( !upobj.getAttribute("open"))upobj.all.tags("img")[0].src ="img/contract.gif";
			}
			
			for(i=0;i<nodes.length;cn.appendChild(createTree(nodes[i++],sd+1)));//菜单级别生成，下一级菜单加1
			nodeObj.appendChild(cn);
		}else {
			//------------->>将缺省打开的节点上色
			if (openFirstMenu == 1) {
				if( firstDefaultNode == "" ){
					firstDefaultNode = "yes";
					
					if(upobj.getAttribute("cn")){
						upobj.setAttribute("open",!upobj.getAttribute("open"));
						upobj.cn.style.display = upobj.getAttribute("open")?"inline":"none";
						upobj.all.tags("img")[0].src = upobj.getAttribute("open")?"img/expand.gif":"img/contract.gif";
					}
					if(IO){
						IO.runtimeStyle.cssText = "";
						IO.setAttribute("selected",false);
					}
					IO = upobj;
					upobj.setAttribute("selected",true);
					upobj.runtimeStyle.cssText = SC;
					
					//调用第一个叶子节点的行为
					
				    document.all.initmenu.target = "rightWorkSpace";
				    document.all.initmenu.href = upobj.getAttribute("href");
				    document.all.initmenu.click();
				}
			} else {
				    if( upobj.getAttribute("href") == defaultURL ){
						firstDefaultNode = "yes";
						
						if(upobj.getAttribute("cn")){
							upobj.setAttribute("open",!upobj.getAttribute("open"));
							upobj.cn.style.display = upobj.getAttribute("open")?"inline":"none";
							upobj.all.tags("img")[0].src = upobj.getAttribute("open")?"img/expand.gif":"img/contract.gif";
						}
						if(IO){
							IO.runtimeStyle.cssText = "";
							IO.setAttribute("selected",false);
						}
						IO = upobj;
						upobj.setAttribute("selected",true);
						upobj.runtimeStyle.cssText = SC;
						
						//调用第一个叶子节点的行为
						
					    document.all.initmenu.target = "rightWorkSpace";
					    document.all.initmenu.href = upobj.getAttribute("href");
					    document.all.initmenu.click();
					}	
			}
			
			//<<--------------------------------
			upobj.all.tags("img")[0].src ="img/endnode.gif";
		} 
		return nodeObj;
	}
	
	function clickHandle(){
	    if( this.getAttribute("status") == "0" ){
		   alert("菜单功能暂时停止使用!");
		   return;
		}
		if( this.getAttribute("href") != "null" ){
		    top.bodyFrame.rightWorkSpace.window.location.href = this.getAttribute("href");
		}
	}
	
	function contextMenuHandle(){
		event.returnValue = false;
		var treeId = this.getAttribute("treeId");
		// your code here
	}
