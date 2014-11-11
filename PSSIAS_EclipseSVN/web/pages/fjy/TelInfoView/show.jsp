<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String sbutton = "";
		if (request.getAttribute("sbutton") != null)
			sbutton = (String)request.getAttribute("sbutton");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TelInfoView.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TelInfoView/list.do" method="get" theme="simple">
	<s:hidden name="telinfoid" id="telinfoid" value="%{model.telinfoid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TelInfoView.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		          <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_TELPP%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.telpp}"   name="telpp"  notEmpty="true"  dictName="T_DIC_SJPP"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_TELXH%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.telxh}"   name="telxh"  notEmpty="true"  dictName="T_DIC_SJXH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_TELYS%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.telys}"   name="telys"  notEmpty="true"  dictName="T_DIC_SJYS"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_SJLB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sjlb}"   name="sjlb"  notEmpty="true"  dictName="T_DIC_SJLB"/>
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_JXXLH%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.jxxlh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BZ%>
		                  </td>
			               <td colspan="3">
		                           <s:property value="%{model.bz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushoury}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.chushourenxb}"   name="chushourenxb"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourensfzh}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourenlxdh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.beizhu}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_SGSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgsjString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_DQSJH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dqsjh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.csrdh}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_GJSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gjsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfo.ALIAS_CSRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.csrjtzz}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfoView.ALIAS_DEPTNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TelInfoView.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fullname}" />
		                  </td>
                   </tr>
                   <%if(sbutton != null && !sbutton.equals("1"))  {%>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TelInfoView/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	               <% } %>
	</table>	
</s:form>

</body>

</html>