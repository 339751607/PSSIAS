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
	<title><%=Pmdwnsxxb.TABLE_ALIAS%></title>
</head>

<style type="text/css" media=print>
.noprint{display : none }
</style>
<script language="javascript"> 
　　function printit() 
　　{ 
	
　　if (confirm('确定打印吗？')) { 
document.getElementById("printtr").style.display="none";
　　window.print();
document.getElementById("printtr").style.display="";
　　} 
　　} 
　　</script> 
<body>
<%@ include file="/commons/messages.jsp" %>
<s:form action="/pages/pmdd/Pmdwnsxxb/list.do" method="get" theme="simple">
	<s:hidden name="dwbm" id="dwbm" value="%{model.dwbm}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title" > 
							<%=Pmdwnsxxb.TABLE_ALIAS%>
				          </td>
		           </tr>
		           	 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_DWMC%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dwmc}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSND%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.nsnd}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="15%">
			                      <%=Pmdwnsxxb.ALIAS_NSRQ%>
		                  </td>
			              <td width="30%">
		                           <s:property value="%{model.nsrq}" />
		                  </td>
                          <td class="crosscolor_td" width="15%">
			                      <%=Pmdwnsxxb.ALIAS_NSJG%>
		                  </td>
			              <td width="30%">
			              <mytag:write property="%{model.nsjg}"   name="nsjg"  notEmpty="true"  dictName="nsjglb"/>
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJ%>
		                  </td>
			              <td colspan="3" height="101">
			              <s:property value="%{model.nsyj}" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJQSR%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.nsyjqsr}" />
		                  </td>
		                  </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSYJJBR%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.nsyjjbr}" />
		                  </td>
                   </tr>
                  
                   <tr id="printtr" style="">
						  <td colspan="4" class="tb_bottom">
						    <p class="noprint">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      	<input type="button" value="打印" onclick=" printit();"/>
	                      </p>
	                      </td>
	               </tr>
	             
	</table>	
</s:form>

</body>

</html>