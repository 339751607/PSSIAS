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
	<title>境内人员查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
			<s:form action="/pages/zazh/TpersonbaseJn/analylist.do"
				theme="simple" style="display: inline;" method="post">
				<table width="100%" border="1" bordercolor="#7c8ca7" align="center"
					cellPadding="0" cellSpacing="0" class="tb_all">
					<tr>
						<td class="tb_title" colspan="4">境内人员查询
						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=TpersonbaseJn.ALIAS_CARDNAME%>
						</td>
						<td>
							<mytag:select name="s_cardname"
								value="${pageRequest.filters.cardname}" notEmpty="false"
								dictName="T_ID_NAME" />

						</td>
						<td class="crosscolor_td">
							<%=TpersonbaseJn.ALIAS_CARDCODE%>
						</td>
						<td>
							<input value="${pageRequest.filters.cardcode}" name="s_cardcode" />

						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=TpersonbaseJn.ALIAS_NAME%>
						</td>
						<td>
							<input value="${pageRequest.filters.name}" name="s_name" />
						</td>
						<td class="crosscolor_td">
							
						</td>
						<td>
							
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
					    
					<!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect8" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect8" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3138" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d3148\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3148" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d3138\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   -->
					<tr>
						<td class="tb_bottom" colspan="4">
					     	<input id="submitButton" name="submitButton" type="submit" value="查询" />
					     	<!--  
					     	<a href="http://localhost:8080/PSSIAS/pages/zazh/TpersonbaseJn/track.jsp">图</a>  
					     	-->                         
						</td>
					</tr>
				</table>
			</s:form>
		</div>
			
</body>

</html>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
	    var s_name = document.getElementById("s_name").value;
		var s_cardcode = document.getElementById("s_cardcode").value;
		if(s_name =="" && s_cardcode =="" ){
		  alert("姓名和证件号码至少一项不能为空！");
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