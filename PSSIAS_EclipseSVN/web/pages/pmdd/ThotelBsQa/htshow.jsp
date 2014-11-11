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
	<title><%=ThotelBsQa.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/ThotelBsQa/list.do" method="get" theme="simple">
	<s:hidden name="xh" id="xh" value="%{model.xh}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=ThotelBsQa.TABLE_ALIAS%>信息
				          </td>
		           </tr>

		           <tr class="crosscolor_tr">
		         		 <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_DWMC%>
		                  </td>
			              <td >
		                           <s:property value="%{model.dwmc}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTFL%>
		                  </td>
			              <td>
		                             <mytag:write property="%{model.wtfl}"   name="wtfl"  notEmpty="true"  dictName="wtfl"/>
		                  </td>


                   </tr>
		           <tr class="crosscolor_tr">
		          		   <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wtsj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_USERTEL%>
		                  </td>
			              <td >
		                           <s:property value="%{model.usertel}" />
		                  </td>
		                  </tr>
		        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_WTNR%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.wtnr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
 				 	 <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDBZ%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.jdbz}"   name="jdbz"  notEmpty="true"  dictName="jdbz"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDSJ%>
		                  </td>
			              <td >
		                           <s:property value="%{model.jdsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jdr}" />
		                  </td>
		                   <td class="crosscolor_td">
			                     <%=ThotelBsQa.ALIAS_FLAG%>
		                  </td>
		                  	<td>
		                           <mytag:write property="%{model.flag}"   name="flag"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
					        <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_JDNR%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.jdnr}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=ThotelBsQa.ALIAS_NOTE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.note}" />
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/ThotelBsQa/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>