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
	<title><%=TcheckEmployee.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/TcheckEmployee/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TcheckEmployee.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcard}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.emptype}"   name="emptype"  notEmpty="true"  dictName="D_empType"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fullname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_SEX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sex}"   name="sex"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr" id="ssjg">
		                   <td class="crosscolor_td">
			                      部门名称
		                  </td>
			              <td >
		                        <s:property value="%{model.deptname}" />  
		                  </td>
		                  
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr" id="myTr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_POLICENO%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.policeno}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                  
					 <td class="crosscolor_td">
                          <%=TcheckEmployee.ALIAS_DEMO%>
                          </td>
                          <td colspan="3"> <s:property value="%{model.demo}" /></td>
                          </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TcheckEmployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

<script type="text/javascript">
showorhidden();
 function showorhidden(){
		var enptype = document.getElementById("emptype").value;
		var myTr= document.getElementById("myTr"); 
		var ssjg= document.getElementById("ssjg"); 
		if("01" == enptype){
			myTr.style.display ="block";
			ssjg.style.display ="block";
		}else{
			myTr.style.display ="none";
			ssjg.style.display ="none";
		}
	}
</script>
</body>

</html>
