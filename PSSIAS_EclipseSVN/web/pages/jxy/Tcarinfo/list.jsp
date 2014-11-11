<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String webContext = request.getContextPath();
%>
<html>
<script src="<%=webContext%>/extclient/serviceItems.js"></script>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Tcarinfo.TABLE_ALIAS%> 维护</title>
	<style>
<!--
		.crosscolor_tr input {
			float: left;
			margin: 0 0 0 0px;
			height: 20px;	
-->
</style>
</head>

<body onload="quickSelectInit()" id="bd" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcarinfo/list.do"  name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden"  id="serveritem" name="serveritem" value="" />	
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcarinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
		             		 <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
	                          <mytag:select  name="s_flag" value="${pageRequest.filters.flag}"  notEmpty="false"  dictName="clzt">
	                          </mytag:select>
		                  </td>
		           		   <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARID%>
		                  </td>
			              <td>
	                          <mytag:select  name="s_carid1" value="${pageRequest.filters.carid1}"  notEmpty="false"  dictName="cpht"/>
	                          <input value="${pageRequest.filters.carid2}"  name="s_carid2"  id="KProvince" onkeyup="beKeyUp()" />
		                  </td>
		            </tr>
		             <div id="search_suggest" style="position:absolute;z-index:1;margin-top:4px;padding-top:20px;"></div>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
   							<!-- 
		                   <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_BODYCODE%>
		                  </td>
		                  
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                           
		                  </td>
		                  -->
		                 <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                      <mytag:select  name="s_cartype" value="${pageRequest.filters.cartype}"  notEmpty="false"  dictName="cllx"/>
		                  </td> 
		                  
		                   <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clsbcode}"  name="s_clsbcode"  />
		                           
		                  </td>    
                   </tr>

		           
                    <tr class="crosscolor_tr">
		             	  <td class="crosscolor_td">
			                    车辆颜色
		                  </td>
			              <td>
	                          <mytag:select  name="s_color" value="${pageRequest.filters.color}"  notEmpty="false"  dictName="csys"/>
		                  </td>
		           		   <td class="crosscolor_td">
			                     事故车辆
		                  </td>
			              <td>
	                          <mytag:select  name="s_sgcl" value="${pageRequest.filters.sgcl}"  notEmpty="false"  dictName="shiFou"/>
	                         
		                  </td>
		            </tr>
		             <tr class="crosscolor_tr">
		           <!--  	  <td class="crosscolor_td">
			                   服务项目
		                  </td>
			              <td>
			              
			               <s:select id="s_serveritem" name="s_serveritem" list="serverItemSelectMap"  
		                                   
		                                   value="#request.s_serveritem" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
	                          
		                  </td> -->
		                   <td class="crosscolor_td">
			                   <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
			                <input value="${pageRequest.filters.brand}"  name="s_brand"  />
			                
		                  </td>
		                   <td class="crosscolor_td">
			                  送车人姓名
		                  </td>
			              <td>
			                <input value="${pageRequest.filters.deliname}"  name="s_deliname"  />
			                
		                  </td>
		           		  
		            </tr>
		              <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_ENROLTIME%>
		                  </td>
			              <td colspan="3" align="left">
			              			               <table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_enroltimeBegin','s_enroltimeEnd','yyyy-MM-dd HH:mm');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d31310" name="s_enroltimeBegin"  value="${pageRequest.filters.enroltimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d31410" name="s_enroltimeEnd"   value="${pageRequest.filters.enroltimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
     	           <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td colspan="3" align="left">
			              			               <table class="list">
			               <tr>
			              <td>
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_totimeBegin','s_totimeEnd','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d3135" name="s_totimeBegin"  value="${pageRequest.filters.totimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3135\')}'})"/>
			               </td>
			               <td>到</td>
			               <td>
			                        <input id="d3145" name="s_totimeEnd"   value="${pageRequest.filters.totimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3145\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                   </tr>
		            <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                   服务项目
		                  </td>
		            <td colspan="3">
						
						<div id="addrinfo"><input name="input" id="test" value="选择" type="button" onclick="zzjs_net('popupAddr')" /></div><div id="result"></div>
					</td>
		            </tr>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarinfo/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcarinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcarinfo/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="carowner"  title="<%=Tcarinfo.ALIAS_CAROWNER%>"/>
		                    <mytag:lookupcolumn property="cartype"  title="<%=Tcarinfo.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
		                    <ec:column property="carid"  title="<%=Tcarinfo.ALIAS_CARID%>"/>
		                    <ec:column property="enginecode"  title="<%=Tcarinfo.ALIAS_ENGINECODE%>"/>
		                      <ec:column property="clsbcode"  title="车辆识别代码"/>  
		                    <ec:column property="delitelephone"  title="<%=Tcarreturn.ALIAS_DELITELEPHONE%>"/>
		                    <ec:column property="enroltime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date"  title="<%=Tcarinfo.ALIAS_ENROLTIME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<input type="image" src="images/query.gif" height="16" width="16" value="查看详细" alt="查看详细" border="0" onClick="view('${item.enrolid}')">&nbsp;&nbsp;
			<c:if test="${item.flag == '0'}">
				<input type="image" src="images/edit.gif" height="16" width="16" value="修改" alt="修改" border="0"  onClick="edit('${item.enrolid}')">&nbsp;&nbsp;
				<input type="image" src="images/collect_car.png" height="16" width="16" value="取车" alt="取车" border="0"  onClick="collect('${item.enrolid}')">&nbsp;&nbsp;
			
			<input type="image" src="images/carcase_car.png" height="16" width="16" value="事故车辆" alt="事故车辆" border="0" onClick="carcase('${item.enrolid}')">
		</c:if>
		</ec:column>
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
            
                xmlhttpRequest.Open("POST","${ctx}/jxy/Tcarinfo/getDataByIdNum.do?key=" + key,true);//POST
                xmlhttpRequest.onreadystatechange=stateChange;//返回状态调用方法stateChange
                xmlhttpRequest.Send();1
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
				input_txt.value = "!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tcarinfo/delete.do';
	            form.submit();
	        }
	  }
		function view(enrolid){
			var form = document.forms.ec;
			if(!form) return;
			inputParameters(enrolid,form);
	        form.action = '${ctx}/jxy/Tcarinfo/show.do';
            form.submit();

		}
		function edit(enrolid){
			var form = document.forms.ec;
			if(!form) return;
			inputParameters(enrolid,form);
	        form.action = '${ctx}/jxy/Tcarinfo/edit.do';
            form.submit();
		
		}
		function collect(enrolid){
			var form = document.forms.ec;
			if(!form) return;
			inputParameters(enrolid,form);
	        form.action = '${ctx}/jxy/Tcarinfo/collectCar.do';
            form.submit();
		}
		function carcase(enrolid){
			var url="${ctx}/jxy/Tcarcaseinfo/getCarcaseList.do?ajax=true&enrolid="+enrolid;
			$.post(url, function(data) {
			if(data=="edit"){
				window.location='${ctx}/jxy/Tcarcaseinfo/edit.do?enrolid='+enrolid+'&<mytag:params includes="ec*,s*" type="queryStringUtf"/>';
			}
			if(data=="create"){
				window.location='${ctx}/jxy/Tcarcaseinfo/create.do?oldenrolid='+enrolid+'&<mytag:params includes="ec*,s*" type="queryStringUtf"/>';
			}
			});
		}
		function inputParameters(enrolid,form){
		var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
		var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "enrolid";
				input_txt.value = enrolid;
						
				form.appendChild(input_txt);
		}

</script>

<script type="text/javascript">

//工作地点键值匹配数组
<%=request.getAttribute("data")%>
<%=request.getAttribute("dataTwo")%>

</script>
