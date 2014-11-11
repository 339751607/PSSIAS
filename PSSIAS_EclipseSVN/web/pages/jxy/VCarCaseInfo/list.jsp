<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=VCarCaseInfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/VCarCaseInfo/list.do"  name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=VCarCaseInfo.TABLE_ALIAS%>查询</td>
		           </tr>
		             <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_CPCODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_CPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                           
		                           <mytag:select name="s_cartype" value="${pageRequest.filters.cartype}" notEmpty="false" dictName="cllx"></mytag:select>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid" id="KProvince" onkeyup="beKeyUp()" />
		                  </td>
		                   <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_REPORTER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.reporter}"  name="s_reporter"  />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=VCarCaseInfo.ALIAS_ERPTIME%>
		                  </td>
			              <td> 
			                 <table class="list">
			                   <tr>
			                       <td>
			                       <input id="d3135" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3145\')}'})"/> 
			                       </td>
			                       <td>到</td>
			                       <td>
			                       <input id="d3145" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3135\')}'})"/>
		                           </td>
		                       </tr>
		                     </table>  
		                  </td>
                          <td></td>
                          <td></td>
		        
		           <tr>
			              <td class="tb_bottom" colspan="4">
			              
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/VCarCaseInfo/list.do'"/>
	                       <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>         
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/VCarCaseInfo/list.do" autoIncludeParameters="true">
		<ec:exportXls fileName="empxx.xls" tooltip="输出Excel文件"/> 
	<ec:row>		
		                    <ec:column property="cpcode"  title="<%=VCarCaseInfo.ALIAS_CPCODE%>"/>
		                    <ec:column property="cpname"  title="<%=VCarCaseInfo.ALIAS_CPNAME%>"/>		                    
		                    <ec:column property="carowner"  title="<%=VCarCaseInfo.ALIAS_CAROWNER%>"/> 
		                    <mytag:lookupcolumn property="cartype"  title="<%=VCarCaseInfo.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="Diccon_cl" />
		                    <ec:column property="carid"  title="<%=VCarCaseInfo.ALIAS_CARID%>"/>
		                    <ec:column property="enginecode"  title="<%=VCarCaseInfo.ALIAS_ENGINECODE%>"/>
		                    <ec:column property="bodycode"  title="<%=VCarCaseInfo.ALIAS_BODYCODE%>"/>
		                    <ec:column property="reporter"  title="<%=VCarCaseInfo.ALIAS_REPORTER%>"/>
		                    <ec:column property="erptime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd hh:mm" cell="date" title="<%=VCarCaseInfo.ALIAS_ERPTIME%>"/>
		                    <ec:column property="part"  title="<%=VCarCaseInfo.ALIAS_PART%>"/>
	</ec:row>
</ec:table>

</body>

</html>

<style>
.item_normal
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    width:150px;
    background-color:#ffffff;
    overflow:hidden;
}
.itemBg
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    cursor:default;
    background-color:#ffffff;
    width:150px;
}
.item_high
{
    background-color:#326BC5;
    cursor:default;
    width:150px;
    color:white;
}
.item_button
{
    BORDER-LEFT: #666 1px solid;
    BORDER-RIGHT: #666 1px solid;
    BORDER-BOTTOM: #666 1px solid;
    text-align:right;
    background-color:#ffffff;
    width:150px;
    cursor:hand;
}
.suggest_hidden
{
    display:none;
}


</style>
<script type="text/javascript">

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
   function beKeyUp()
        {
       
            var key = document.getElementById("KProvince").value;
            if(key.length>0)//有值才POST，这里最好加个Trim()方法，但是JAVASCRIPT没有现成的方法，自己定义。
            {
             
                xmlHttpInitializtions();
            
                xmlhttpRequest.Open("POST","${ctx}/jxy/Tcarinfo/getDataByIdNum1.do?key=" + key,true);//POST
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
              var t=document.getElementById("KProvince");
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
            document.getElementById("KProvince").focus();
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
            document.getElementById("KProvince").value=array[i];
            document.getElementById("search_suggest").style.display="none";
            document.getElementById("KProvince").focus();
        }

</script>
<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/jxy/VCarCaseInfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/VCarCaseInfo/delete.do';
	            form.submit();
	        }
	  }
</script>
