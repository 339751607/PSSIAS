<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tlinkmaninfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Tlinkmaninfo/list.do" method="get" theme="simple">
	<s:hidden name="linkmanid" id="linkmanid" value="%{model.linkmanid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tlinkmaninfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_LINKMAN%>
		                  </td>
			              <td>
		                           <s:property value="%{model.linkman}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_SEX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sex}"   name="sex"  notEmpty="true"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcode}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_JOBORDWELL%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.jobordwell}" />
		                  </td>
		              </tr>
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_COMMADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.commaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tlinkmaninfo.ALIAS_RELATION%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.relation}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Tlinkmaninfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>