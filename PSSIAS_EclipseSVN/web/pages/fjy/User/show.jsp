<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=User.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/User/list.do" method="get" theme="simple">
	<s:hidden name="userid" id="userid" value="%{model.userid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=User.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.username}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PASSWORD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.password}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fullname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sex}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_POLICEID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policeid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_MOBILE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.mobile}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ZIP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zip}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_EMAILADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.emailaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_CREATEDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.createdateString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ENABLED%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enabled}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHOTO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.photo}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/User/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>