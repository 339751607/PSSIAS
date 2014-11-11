/**//*  
**    ==================================================================================================  
**    类名：CLASS_MSN_MESSAGE  
**    功能：提供类似MSN消息框  
**    示例：  
    ---------------------------------------------------------------------------------------------------  
  
*    消息构造  
*/  
function CLASS_MSN_MESSAGE(id,width,height,caption,title,message,target,action,gwrq){  
    this.id     = id;  
    this.title  = title;  
    this.caption= caption;  
    this.message= message;  
    this.target = target;  
    this.action = action;  
    this.gwrq = gwrq;
    this.width    = width?width:200;  
    this.height = height?height:180;  
    this.timeout= 150;  
    this.speed    = 20; 
    this.step    = 1; 
    this.right    = screen.width -1;  
    this.bottom = screen.height; 
    this.left    = this.right - this.width; 
    this.top    = this.bottom - this.height; 
    this.timer    = 0; 
    this.pause    = false;
    this.close    = false;
    this.autoHide    = false;
}  
  
/**//*  
*    隐藏消息方法  
*/  
CLASS_MSN_MESSAGE.prototype.hide = function(){  
    if(this.onunload()){  
        var offset  = this.height>this.bottom-this.top?this.height:this.bottom-this.top; 
        var me  = this;  
        if(this.timer>0){   
            window.clearInterval(me.timer);  
        }  
        var fun = function(){  
            if(me.pause==false||me.close){
                var x  = me.left; 
                var y  = 0; 
                var width = me.width; 
                var height = 0; 
                if(me.offset>0){ 
                    height = me.offset; 
                } 
     
                y  = me.bottom - height; 
     
                if(y>=me.bottom){ 
                    window.clearInterval(me.timer);  
                    me.Pop.hide();  
                } else { 
                    me.offset = me.offset - me.step;  
                } 
                me.Pop.show(x,y,width,height);    
            }             
        }  
        this.timer = window.setInterval(fun,this.speed)      
    }  
}  
  
/**//*  
*    消息卸载事件，可以重写  
*/  
CLASS_MSN_MESSAGE.prototype.onunload = function() {  
    return true;  
}  
/**//*  
*    消息命令事件，要实现自己的连接，请重写它  
*  
*/  
CLASS_MSN_MESSAGE.prototype.oncommand = function(){  
    //this.close = true;
    this.hide();
	window.showModalDialog(this.target+"/pages/Tbuylog/tzrygyshow.do"+this.action,"prompt_tz","dialogHeight:450px;dialogWidth:900px;scroll:on;center:yes");
   
} 
CLASS_MSN_MESSAGE.prototype.zloncommand = function(){  
    //this.close = true;
    this.hide();
	window.showModalDialog(this.target+"/pages/Tbuylog/tzdllist.do"+this.action,"prompt_tz","dialogHeight:400px;dialogWidth:900px;scroll:on;center:yes");
   
} 
CLASS_MSN_MESSAGE.prototype.gwoncommand = function(){  
    //this.close = true;
    this.hide();
	window.showModalDialog(this.target+"/pages/Tbuylog/tzgwlist.do"+this.action+this.gwrq,"prompt_tz","dialogHeight:350px;dialogWidth:900px;scroll:on;center:yes");
   
} 

CLASS_MSN_MESSAGE.prototype.alarmcommand = function(){  
    //this.close = true;
    this.hide();
	var sReturn =window.showModalDialog(this.target+"/pages/TpersonAlarm/messlist.do","prompt_tz","dialogHeight:500px;dialogWidth:1000px;scroll:on;center:yes");
     if (typeof(sReturn) == "undefined")
       {
       	window.name = "right"; 
		window.open("topRight.do","right");
       }
} 
/**//*  
*    消息显示方法  
*/  
CLASS_MSN_MESSAGE.prototype.show = function(){  
    var oPopup = window.createPopup(); //IE5.5+  
    
    this.Pop = oPopup;  
  
    var w = this.width;  
    var h = this.height;  
  

    var str = "<DIV style='BORDER-RIGHT: #0a4f79 1px solid; BORDER-TOP: #0a4f79 1px solid; Z-INDEX: 99999; LEFT: 0px; BORDER-LEFT: #0a4f79 1px solid; WIDTH: " + w + "px; BORDER-BOTTOM: #0a4f79 1px solid; POSITION: absolute; TOP: 0px; HEIGHT: " + h + "px;  repeat-x 0 0;'>"  
        str += "<TABLE cellSpacing=0 cellPadding=0 width='100%'  border=0>"  
        str += "<TR >"  
        str += "<TD style='FONT-SIZE: 12px;COLOR: #0f2c8c' width=30 height=24 bgcolor:#3bc6ed ></TD>"  
        str += "<TD style='PADDING-LEFT: 8px; FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #1f336b; PADDING-TOP: 6px; background:#3bc6ed '  vAlign=center width='100%'>" + this.caption + "</TD>"  
        str += "<TD style='PADDING-RIGHT: 2px; PADDING-TOP: 2px; background:#3bc6ed' vAlign=center align=right width=19>"  
        str += "<SPAN title=关闭 style='FONT-WEIGHT: bold; FONT-SIZE: 12px; CURSOR: hand; COLOR: red; MARGIN-RIGHT: 4px' id='btSysClose' >×</SPAN></TD>"  
        str += "</TR>"  
        str += "<TR>"  
        str += "<TD style='PADDING-RIGHT: 1px;PADDING-BOTTOM: 1px' colSpan=3 height=" + (h-28) + ">"  
        str += "<DIV style='overflow-y:auto; BORDER-RIGHT: #b9c9ef 0px solid; PADDING-RIGHT: 8px; BORDER-TOP: #728eb8 0px solid; PADDING-LEFT: 8px; FONT-SIZE: 12px; PADDING-BOTTOM: 8px; BORDER-LEFT: #728eb8 0px solid; WIDTH: 100%; COLOR: #1f336b; PADDING-TOP: 8px; BORDER-BOTTOM: #b9c9ef 0px solid; HEIGHT: 100%'>"  
        str += this.title + "<BR>"  
        str += this.message 
        str += "</DIV>"         
        str += "</TD>"  
        str += "</TR>"  
        str += "</TABLE>"  
        str += "</DIV>"    
  
    oPopup.document.body.innerHTML = str;     
    this.offset  = 0; 
    var me  = this;  
    oPopup.document.body.onmouseover = function(){me.pause=true;}
    oPopup.document.body.onmouseout = function(){me.pause=false;}
    var fun = function(){  
        var x  = me.left; 
        var y  = 0; 
        var width    = me.width; 
        var height    = me.height; 
            if(me.offset>me.height){ 
                height = me.height; 
            } else { 
                height = me.offset; 
            } 
        y  = me.bottom - me.offset; 
        if(y<=me.top){ 
            me.timeout--; 
            if(me.timeout==0){ 
                window.clearInterval(me.timer);  
                if(me.autoHide){
                    me.hide(); 
                }
            } 
        } else { 
            me.offset = me.offset + me.step; 
        } 
        me.Pop.show(x,y,width,height);    
    }  
  
    this.timer = window.setInterval(fun,this.speed)      
  
     
  
    var btClose = oPopup.document.getElementById("btSysClose");  
  
    btClose.onclick = function(){  
        me.close = true;
        me.hide();  
    }  
  
    var btCommand = oPopup.document.getElementById("btCommand");  
    btCommand.onclick = function(){  
        me.oncommand();  
    }    
    var zlbtCommand = oPopup.document.getElementById("zlbtCommand");  
    zlbtCommand.onclick = function(){  
        me.zloncommand();  
    }    
    var gwbtCommand = oPopup.document.getElementById("gwbtCommand");  
    gwbtCommand.onclick = function(){  
        me.gwoncommand();  
    }    
    var alarmCommand = oPopup.document.getElementById("alarmCommand");  
    alarmCommand.onclick = function(){  
        me.alarmcommand();  
    }    
}  
/**//* 
** 设置速度方法 
**/ 
CLASS_MSN_MESSAGE.prototype.speed = function(s){ 
    var t = 20; 
    try { 
        t = praseInt(s); 
    } catch(e){} 
    this.speed = t; 
} 
/**//* 
** 设置步长方法 
**/ 
CLASS_MSN_MESSAGE.prototype.step = function(s){ 
    var t = 1; 
    try { 
        t = praseInt(s); 
    } catch(e){} 
    this.step = t; 
} 
  
CLASS_MSN_MESSAGE.prototype.rect = function(left,right,top,bottom){ 
    try { 
        this.left        = left    !=null?left:this.right-this.width; 
        this.right        = right    !=null?right:this.left +this.width; 
        this.bottom        = bottom!=null?(bottom>screen.height?screen.height:bottom):screen.height; 
        this.top        = top    !=null?top:this.bottom - this.height; 
    } catch(e){} 
} 