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
	<title><%=Cyry.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Cyry/list.do" method="get" theme="simple">
	<s:hidden name="dwbm" id="dwbm" value="%{model.dwbm}"/>
	<s:hidden name="dwnbm" id="dwnbm" value="%{model.dwnbm}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Cyry.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.xb}"   name="xb"  notEmpty="true"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GMSFHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmsfhm}" />
		                  </td>
                 
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_BIRTHDAY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.birthday}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.zz}" />
		                  </td>
		               </tr>
		           <tr class="crosscolor_tr">    
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_HKSZD%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.hkszd}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_WHCD%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.whcd}"   name="whcd"  notEmpty="true"  dictName="educations"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GZLX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.gzlx}"   name="gzlx"  notEmpty="true"  dictName="gzlx"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_RZRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.rzrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_FLAG%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.flag}"   name="flag"  notEmpty="true"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_LZRQ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.lzrq}" />
		                  </td>
                          
                   </tr>
		          
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Cyry/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>