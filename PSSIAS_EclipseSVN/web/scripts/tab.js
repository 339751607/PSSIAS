function gmobj(mtxt)  /* Get object by object name */
{
  if (document.getElementById) {
      m=document.getElementById(mtxt);
  } else if (document.all) {
      m=document.all[mtxt];
  } else if (document.layers) {
      m=document.layers[mtxt];
  }
  return m;
}



function _mouse_over_tab(no)
{
	if (this.tabContent[no].tabType == "frame") {
		window.status = this.tabContent[no].frameUrl;
	
	}
}

function _mouse_out_tab(no)
{
	window.status = "";
}

function _show_tab_by_obj(obj)
{
	for (i=0; i<this.total; i++) {
		if (this.tabContent[i].tabContent.contains(obj)) {
			this.select_tab(i);
			break;
		}
	}
}

function _create_tab_content(type, frameUrl, selected)
{
	this.tabContent[this.total] = new TabContent(this, this.total, type, frameUrl);
	this.total++;
	if (selected != null && selected)
		this.defaultSelectNo = this.total - 1;
}

function _obj_select(obj)
{
	for (i=0; i<this.total; i++) {
		if (this.tabContent[i].tabContent.contains(obj)) {
			this.select_tab(i);
			break;
		}
	}
}

function _tab_select(no)
{
	if (no < 0 || no > this.total) 
		return;
	for (i=0; i<this.total; i++) {
		if (i != no) {
			this.tabContent[i].unSelect(no);
			this.tabContent[i].tabContent.style.display = "none";
		}
	}
	this.tabContent[no].onSelect();
	if (this.tabContent[no].tabType == "frame") {
		if (this.tabContent[no].frameUrl != null && this.tabContent[no].frameUrl != "#")
			this.tabContent[no].tabIframe.location = this.tabContent[no].frameUrl;
	}
	this.tabContent[no].tabContent.style.display = "block";
	return false;
}

function _init_tab_table()
{
	for (i=0; i<this.total; i++) {
		this.tabContent[i].tabContent = gmobj(this.id + "_tab_content_div"  + i);
		if (this.tabContent[i].tabType == "frame") {
			this.tabContent[i].tabIframe = window.frames[this.id + "_tab_content_frame"  + i];
		}
	}
	if (this.defaultSelectNo != -1)
		this.select_tab(this.defaultSelectNo);
	else
		this.select_tab(0);
}

/* 检测表单中所有输入项的正确性，一般用于表单的onsubmit事件 */
function checkTabForm(myform, tab)
{
	var i;
	for (i=0;i<myform.elements.length;i++)
	{
	    /* 非自定义属性的元素不予理睬 */		
		if (myform.elements[i].eos_displayname + "" == "undefined") continue;
		/* 非空校验 */
		if (myform.elements[i].eos_isnull=="false" && isnull(myform.elements[i].value))
		{
			gmobj(tab).select_obj(myform.elements[i]);
			f_alert(myform.elements[i],"不能为空");
			return false;
		}		
		if (checkInput(myform.elements[i])==false) {
			gmobj(tab).select_obj(myform.elements[i]);
			myform.elements[i].select();
			myform.elements[i].focus();
			return false;
		}
	 }
	 return true;
}

function TabContent(tabTable, no, type, frameUrl)
{
	this.no = no;
	this.tabTable = tabTable;
	this.isSelected = false;
	this.tabType = type;
	this.frameUrl = frameUrl;
	this.firstImg = null;
	if (no == 0)
		this.firstImg = gmobj(tabTable.id + "_tab_image_first");
	this.divideImg = gmobj(tabTable.id + "_tab_image_divide"  + no);
	this.tabText = gmobj(tabTable.id + "_tab_text"  + no);
	this.tabContent = null;
	this.tabIframe = null;

	this.onSelect = _on_select;
	this.unSelect = _un_select;
	
	function _on_select() {
		with (this) {
			if (no == 0)
				firstImg.src = tabTable.imgPath + "/" + "first_select.gif";
			if ((tabTable.total-1) == no)
				divideImg.src = tabTable.imgPath + "/" + "end_select.gif";
			else
				divideImg.src = tabTable.imgPath + "/" + "select_right.gif";
			tabText.className = "tabSelectUp";
		}
	}
	
	function _un_select(selectNo) {
		with (this) {
			if (no == 0)
				firstImg.src = tabTable.imgPath + "/" + "first_unselect.gif";
			if ((tabTable.total-1) == no)
				divideImg.src = tabTable.imgPath + "/" + "end_unselect.gif";
			else {
				if ((selectNo-no) == 1) 
					divideImg.src = tabTable.imgPath + "/" + "select_left.gif";
				else
					divideImg.src = tabTable.imgPath + "/" + "unselect_divide.gif";
			}
			tabText.className = "tabSelectDown";
		}
	}
}
