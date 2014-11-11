<%@ page contentType="text/html;charset=UTF-8"%>
<style>
.item_normal
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    width:180px;
    background-color:#ffffff;
    overflow:hidden;
}
.itemBg
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    cursor:default;
    background-color:#ffffff;
    width:180px;
}
.item_high
{
    background-color:#326BC5;
    cursor:default;
    width:180px;
    color:white;
}
.item_button
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    BORDER-BOTTOM: #666 1px solid;
    text-align:right;
    background-color:#ffffff;
    width:180px;
    cursor:hand;
}
.suggest_hidden
{
    display:none;
}

</style>
<script>

var array=new Array(); //定义一个全局变量数组，用来存放拆分字符串的值，后面具体介绍。
        var zz=-1; //此为指针，后面用到
function xmlHttpInitializtions()
        {
            try 
            {
                xmlhttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
            } 
            catch (e) 
            {
                try 
                {
                    xmlhttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                } 
                catch (e2) 
                {
                    xmlhttpRequest = false;
                }
            }
            if (!xmlhttpRequest && typeof XMLHttpRequest != 'undefined') 
            {
                xmlhttpRequest = new XMLHttpRequest();
            }
        }
   function Click()
        {
       
            var key = document.getElementById("s_staCode").value;
            if(key.length>0)//有值才POST，这里最好加个Trim()方法，但是JAVASCRIPT没有现成的方法，自己定义。
            {
             
                xmlHttpInitializtions();
            
                xmlhttpRequest.Open("POST","${ctx}/pages/hotel/Thotel/getHotelNameBySta.do?key=" + key,true);//POST
                xmlhttpRequest.onreadystatechange=stateChange;//返回状态调用方法stateChange
                xmlhttpRequest.Send();
            }
        }
      function getHotelNameByName()
   {
  
       var hotelName = document.getElementById("s_hotelname").value;
       if(hotelName.length>0)//有值才POST，这里最好加个Trim()方法，但是JAVASCRIPT没有现成的方法，自己定义。
       {
        
           xmlHttpInitializtions();
       
           xmlhttpRequest.Open("POST","${ctx}/pages/hotel/Thotel/getHotelNameByName.do?hotelName=" + encodeURI(hotelName),true);//POST
           xmlhttpRequest.onreadystatechange=stateChange;//返回状态调用方法stateChange
           xmlhttpRequest.Send();
       }
   }
        function stateChange()
        {
            if(xmlhttpRequest.readystate==4)
            {
                if(xmlhttpRequest.status==200)
                {
                    var responseStr=xmlhttpRequest.responseText;//获取返回值
                    if(responseStr.length>0)//返回值不为空才执行下面的代码
                    {
                        array=responseStr.split('|');//根据‘|’拆分，根据自己任意特殊字符，初始化数组
                        positionDiv();//调用方法，定位DIV显示，具体见方法解释
                        document.getElementById("search_suggest").style.display="block";
    					document.getElementById("search_suggest").innerHTML="";//每次清空DIV内容
                        for(var i=0;i<array.length;i++)
                        {
                        	
                            if(array[i]!="")//项值不为空，组合DIV，每个DIV有onmouseover、onmouseout、onclick对应事件
                            {
                                document.getElementById("search_suggest").innerHTML+="<div id='item" + i + "' class='itemBg' onmouseover='beMouseOver(" + i +")' onmouseout='beMouseOut(" + i + ")' onclick='beClick(" + i + ")'>" + array[i] + "</div>";
                            
                            }
                        }
    //最后一个DIV显示 关闭 效果 onclick方法
                        document.getElementById("search_suggest").innerHTML+="<div class='item_button' onclick='hiddenDiv();'><font color='#999999'>关闭</font></div>";
                        document.getElementById("search_suggest").style.display="inline";
                    }
                    else
                    {
                        document.getElementById("search_suggest").style.display="none";
                    }
                }
            }
        }
        //定位DIV显示
function positionDiv()
        {
              var DivRef= document.getElementById("search_suggest");
              DivRef.style.position = "absolute";
              var t=document.getElementById("s_hotelname");
              DivRef.style.top= getAbsolutePos(t).y;//相对文本框的TOP高度，方法见下面
              DivRef.style.left= getAbsolutePos(t).x ;//相对文本框的LEFT宽度
              DivRef.style.height=array.length * 20;//DIV的高度等于每行20个象素乘行数（也就是数组的长度，体现全局数组的作用，不然要传入数组长度的参数）
        }
//实现最后一个DIV 关闭 onclick方法
function hiddenDiv()
        {
            document.getElementById("search_suggest").style.display="none";
        }
//定位方法，不做解释
function getAbsolutePos(el)
        {
            var SL = 0, ST = 0;
            var is_div = /^div$/i.test(el.tagName);
            if (is_div && el.scrollLeft) SL = el.scrollLeft;
            if (is_div && el.scrollTop) ST = el.scrollTop;
            var r = { x: el.offsetLeft - SL, y: el.offsetTop - ST };
            if (el.offsetParent)
            {
                var tmp = this.getAbsolutePos(el.offsetParent);
                r.x += tmp.x;
                r.y += tmp.y;
            }
            return r;
        }

        //函数鼠标经过效果        
        function beMouseOverEFF(i)
        {
            if ((i>=0)&(i<=array.length-1))
            {
                document.getElementById("item" + i).className="item_high";
            }
        }

        //函数鼠标移开效果
        function beMouseOutEFF(i)
        {
            if ((i>=0)&(i<=array.length-1))
            {
                document.getElementById("item" + i).className="item_normal";
            }
        }

        //函数鼠标经过
        function beMouseOver(i)
        {
            document.getElementById("s_hotelname").focus();
            beMouseOutEFF(zz);
            zz=i;
            beMouseOverEFF(zz);
        }

        //函数鼠标移开
        function beMouseOut(i)
        {
            beMouseOutEFF(i);
        }
        //函数单击
        function beClick(i){
            document.getElementById("s_hotelname").value=array[i];
            document.getElementById("search_suggest").style.display="none";
            document.getElementById("s_hotelname").focus();
        }
    	function cleanHotelName(){
    		document.getElementById("s_hotelname").value="";
    	}

</script>