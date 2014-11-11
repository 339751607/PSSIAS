<%@page import="com.dyneinfo.zazh.model.*" %>
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
	<title><%=Tcarbase.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/Tcarbase/analylist.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">车辆轨迹查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
		           
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
						<td class="crosscolor_td">
							时间段
						</td>
						<td colspan="3">
							<table class="list">
								<tr>
									<td>
										<input id="d31312" name="s_starttime"  value="${pageRequest.filters.starttime}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/>
									</td>
									<td>到</td>
									<td>
										<input id="d31413" name="s_endtime"   value="${pageRequest.filters.endtime}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
									</td>
								</tr>
							</table>   
                        </td>
					</tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                      	<input id="submitButton" name="submitButton" type="submit" value="查询" /><!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcarbase/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			                       -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/Tcarbase/analylist.do" autoIncludeParameters="true">
	<ec:row>
        <ec:column property="carid"  title="<%=Tcarbase.ALIAS_CARID%>"/>        
        <ec:column property="carowner"  title="<%=Tcarbase.ALIAS_CAROWNER%>"/>  
        <ec:column property="enginecode"  title="<%=Tcarbase.ALIAS_ENGINECODE%>"/>
        <ec:column property="bodycode"  title="<%=Tcarbase.ALIAS_BODYCODE%>"/>      
        <mytag:lookupcolumn property="cartype"  title="<%=Tcarbase.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
                
        <ec:column property="brand"  title="<%=Tcarbase.ALIAS_BRAND%>"/>
        <ec:column property="carmode"  title="<%=Tcarbase.ALIAS_CARMODE%>"/>
        <mytag:lookupcolumn property="color"  title="<%=Tcarbase.ALIAS_COLOR%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="csys" />
        <ec:column property="updatetime"  parse="yyyyMMddhhmmss" format="yyyy-MM-dd HH:mm:ss" cell="date" value="${item.updatetime}" title="<%=Tcarbase.ALIAS_UPDATETIME%>"/>
             
		<ec:column property="轨迹" title="轨迹" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/Tcarbase/analyshowLine.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
	    var s_carowner = document.getElementById("s_carowner").value;
		var s_carid = document.getElementById("s_carid").value;
	    var s_enginecode = document.getElementById("s_enginecode").value;
		var s_bodycode = document.getElementById("s_bodycode").value;
		
		if(s_carowner =="" && s_carid =="" && s_enginecode =="" && s_bodycode =="" ){
		  alert("车主姓名，车牌号，发动机号和车架号至少一项不能为空！");
		  finalResult = false;
		  return false;
		}
		var s_starttime = document.getElementById("s_starttime").value;
		var s_endtime = document.getElementById("s_endtime").value;
		if(s_starttime =="" ){
		  alert("查询的开始时间段不能为空！");
		  finalResult = false;
		  return false;
		}
		if( s_endtime==""){
		  alert("查询的结束时间段不能为空！");
		  finalResult = false;
		   return false;
		}
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>