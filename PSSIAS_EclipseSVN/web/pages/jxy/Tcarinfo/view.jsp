<%@page import="com.dyneinfo.jxy.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

	String deploycity = (String)DictHelpImpl.getInitData("deploycity");
	request.setAttribute("city",deploycity);
	
	int inCol=1;
//	if(deploycity.equals("ZhanJiang"))
//		inCol=3;
//	else
//		inCol=1;
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title><%=Tcarinfo.TABLE_ALIAS%></title>
	</head>

	<body>
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/pages/jxy/Tcarinfo/list.do" method="get" theme="simple">
			<s:hidden name="enrolid" id="enrolid" value="%{model.enrolid}" />
			<table cellpadding="0" cellspacing="0" border="0" class="tb_all">

				<tr class="crosscolor_tr" >
					<td colspan="4" >
						<b>车辆信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b><%=Tcarinfo.ALIAS_CARPICTURE%></b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CAROWNER%>

					</td>
					<td>
						<s:property value="%{model.carowner}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARID%>
					</td>
					<td>
						<mytag:write property="%{model.carid1}" name="carid1"
							notEmpty="true" dictName="cpht" />
							<s:property value="%{model.carid}" />
					</td>
						<td rowspan="4"  align="center" bgcolor="#EDF1FF" >
					     
									<img
							src='${ctx}/pages/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />'
							onerror="this.src='${ctx}/images/noCar.gif'"  alt=""
							height="100" width="200" border="0" name="photo">
							
						
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARTYPE%>
					</td>
					<td>
						<mytag:write property="%{model.cartype}" name="carid1"
							notEmpty="true" dictName="cllx" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BRAND%>
					</td>
					<td>
						<s:property value="%{model.brand}" />

					</td>
				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_ENGINECODE%>
					</td>
					<td colspan=<%=inCol %>>
						<s:property value="%{model.enginecode}" />
					</td>
					<td class="crosscolor_td">
			                    <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			              <td >
			              <s:property value="%{model.clsbcode}"/>
		                         		                  </td>
					<!-- 
					<c:if test="${city ne 'ZhanJiang'}"><!--部署城市不是湛江 add by zzq 2012/06/12
						<td class="crosscolor_td">
							<%=Tcarinfo.ALIAS_BODYCODE%>
						</td>
						<td>
							<s:property value="%{model.bodycode}" />
						</td>
					</c:if>
					 -->
				</tr>
				
				<tr class="crosscolor_tr">
					<td class="crosscolor_td" colspan="4">
						<%=Tcarinfo.ALIAS_COLOR%>：&nbsp;
						<mytag:write property="%{model.color1}" name="color1"
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第一辅色：&nbsp;
						<mytag:write property="%{model.color2}" name="color2"
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第二辅色：&nbsp;
						<mytag:write property="%{model.color3}" name="color3"
							notEmpty="true" dictName="csys" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td colspan="4" class="crosscolor_d">
						<b>车辆交接信息</b>
					</td>
					<td></td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELINAME%>
					</td>
					<td>
						<s:property value="%{model.deliname}" />
					</td>
					<td class="crosscolor_td">
<!--						<%=Tcarreturn.ALIAS_DELICREDCODE%>-->
						送车人证件号码
					</td>
					<td colspan="2">
					<s:property value="%{model.delicredcode}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELITELEPHONE%>
					</td>
					<td>
					<s:property value="%{model.delitelephone}" />
					</td>
					<td class="crosscolor_td">
			           		<%=Tcarreturn.ALIAS_DELIADDRESS%>
		                  </td>
			              <td colspan="2">
		                           <s:property  value="%{model.deliaddress}" />
		                  </td>
				</tr>
				
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECENAME%>
					</td>
				<td id="rece" >

		            </td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECETIME%>
					</td>
					<td colspan="2">
					<s:property value="%{model.recetime}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
				         <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
			              <s:property value="%{model.takeoffname}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td colspan="2">
			               <s:property value="%{model.tocredcode}" />
		                  </td>
		         </tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_SERVERITEM%>
					</td>
					<td>
					 <s:property value="%{model.serveritem}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_TOTIME%>
					</td>
					<td colspan="2">
					 <s:property value="%{model.totime}" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DEMO%>
					</td>
					
					<td colspan="4">
						<s:property value="%{model.demo}" />
					</td>
				</tr>
			</table>
		</s:form>

	</body>
	<script>
   getPcs();
	function getPcs(){
	var recename='${model.recename}';
	var url="${ctx}/pages/jxy/Dictitem/getEmployeeList.do?ajax=true&show=true&recename="+recename;
	$.post(url, function(data) {
		$("#rece").html(data);
	});
	}
</script>
</html>
