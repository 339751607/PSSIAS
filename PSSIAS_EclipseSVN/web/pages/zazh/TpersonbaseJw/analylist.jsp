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
	<title>境外人员查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonbaseJw/analylist.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">境外人员查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SURNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.surname}"  name="s_surname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_CH_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chName}"  name="s_chName"  />
		                  </td>                          
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NATIONALITY%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_nationality"  value="${pageRequest.filters.nationality}"  notEmpty="false"  dictName="DIC_ITEM_COUNTRY"/>
	                      </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
			                       <mytag:select  name="s_passT"  value="${pageRequest.filters.passT}"  notEmpty="false"  dictName="DIC_ITEM_PASSPORT"/>
    	                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passNo}"  name="s_passNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_visaT"  value="${pageRequest.filters.visaT}"  notEmpty="false"  dictName="DIC_ITEM_VISA"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visaNo}"  name="s_visaNo"  />
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
	                      <input id="submitButton" name="submitButton" type="submit" value="查询" />
                              <!-- 
                              <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJw/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
                              -->
		              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TpersonbaseJw/analylist.do" autoIncludeParameters="true">
	<ec:row>
            <ec:column property="surname"  title="<%=TpersonbaseJw.ALIAS_SURNAME%>"/>
            <ec:column property="name"  title="<%=TpersonbaseJw.ALIAS_NAME%>"/>
            <ec:column property="chName"  title="<%=TpersonbaseJw.ALIAS_CH_NAME%>"/>
            <mytag:lookupcolumn property="sex"  title="<%=TpersonbaseJw.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
            <ec:column property="bdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" value="${item.bdate}" title="<%=TpersonbaseJw.ALIAS_BDATE%>"/>
		    <mytag:lookupcolumn property="nationality"  title="<%=TpersonbaseJw.ALIAS_NATIONALITY%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_COUNTRY" />
		    <mytag:lookupcolumn property="passT"  title="<%=TpersonbaseJw.ALIAS_PASS_T%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_PASSPORT" />
            <ec:column property="passNo"  title="<%=TpersonbaseJw.ALIAS_PASS_NO%>"/>
            <mytag:lookupcolumn property="visaT"  title="<%=TpersonbaseJw.ALIAS_VISA_T%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_VISA" />
		    <ec:column property="visaNo"  title="<%=TpersonbaseJw.ALIAS_VISA_NO%>"/> 
            <ec:column property="updatetime" value="${item.updatetimeString}" title="<%=TpersonbaseJw.ALIAS_UPDATETIME%>"/>
            
		<ec:column property="轨迹" title="轨迹" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/TpersonbaseJw/analyshowLine.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;

	    var s_surname = document.getElementById("s_surname").value;
		var s_name = document.getElementById("s_name").value;
		var s_chName = document.getElementById("s_chName").value;
		
	    var s_passNo = document.getElementById("s_passNo").value;
		var s_visaNo = document.getElementById("s_visaNo").value;

		if(s_surname =="" && s_name =="" && s_chName ==""
		    && s_passNo ==""  && s_visaNo ==""){
		  alert("英文姓名，中文姓名，证件号码或者签证号码至少一项不能为空！");
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
