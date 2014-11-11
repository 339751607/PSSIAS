<%@page import="com.dyneinfo.fjy.model.*,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TfjycpCheck.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TfjycpCheck/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TfjycpCheck.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpcode}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      检查企业名称
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
		           </tr>
		             <tr class="crosscolor_tr">
		                	<td class="crosscolor_td">
			                      被检查人姓名
		                  </td>
			              <td>
		                           <s:property value="%{model.empname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                     派出所
		                  </td>
			              <td >
		                           <s:property value="%{model.pcsname}" />
		                  </td>
		                  </tr>
		             <tr class="crosscolor_tr">
		              		<td class="crosscolor_td">
			                      检查民警姓名
		                  </td>
			              <td>
		                           <s:property value="%{model.fullname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcard}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CHECKDATE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.checkdate}" />
		                  </td>
                   </tr>
                   <% 
                   	List checkInfoList =request.getAttribute("checkInfoList")!=null?(List)request.getAttribute("checkInfoList"):new ArrayList();
                   	
                   	if(!checkInfoList.isEmpty()){
                   		for(int i=0;i<checkInfoList.size();i++){
                   		Map map=(Map)checkInfoList.get(i);
                   	%>
                   		<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_ITEM%>
		                  </td>
			              <td colspan="3">
		                          <%=map.get("ITEM")%>
		                            
		                  </td>
                   		</tr>
                   			<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheckinfo.ALIAS_DETAIL%>
		                  </td>
			              <td colspan="3">
		                        <%=map.get("DETAIL")%>   
		                  </td>
                   		</tr>
                   	<%
                   	}
                   	}
                   %>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TfjycpCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>