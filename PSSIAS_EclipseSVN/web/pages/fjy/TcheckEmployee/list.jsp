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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TcheckEmployee.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/TcheckEmployee/list.do"  name="inputForm"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcheckEmployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcard}"  name="s_idcard"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_emptype" value="${pageRequest.filters.emptype}"  notEmpty="false"  dictName="D_empType"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_POLICENO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeno}"  name="s_policeno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcheckEmployee.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fullname}"  name="s_fullname"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=TcheckEmployee.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="td_tb">
			                     所属公安机关
		                  </td>
			              <td>
		                 			<select id="fjid"  onchange="getPcs('fjid','pcsid');">
										<option>请选择...</option>
										</select>&nbsp;&nbsp;
										<select id="pcsid" value="" >
											<option>请选择...</option>
										</select>
		                          <input type="hidden" name="s_deptSeq" id="deptSeq" />
		                  </td>
                   </tr>
		           
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="query();"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TcheckEmployee/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                                <input type="button" value="清空" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TcheckEmployee/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' class='formRadio' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox"  class="formRadio" name="items" value="id=${item.id}&"/>
		</ec:column>
		                    <ec:column property="idcard"  title="<%=TcheckEmployee.ALIAS_IDCARD%>"/>
				            <mytag:lookupcolumn property="emptype"  title="<%=TcheckEmployee.ALIAS_EMPTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="D_empType" />
		                    <ec:column property="policeno"  title="<%=TcheckEmployee.ALIAS_POLICENO%>"/>
		                    <ec:column property="fullname"  title="<%=TcheckEmployee.ALIAS_FULLNAME%>"/>
				            <mytag:lookupcolumn property="sex"  title="<%=TcheckEmployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="deptname"  title="部门名"/>
		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TcheckEmployee/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/TcheckEmployee/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/fjy/TcheckEmployee/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/TcheckEmployee/delete.do';
	            form.submit();
	        }
	  }
	  
	function query(){
	submitValue('fjid','pcsid','','deptSeq')
	document.forms[0].action='${ctx}/pages/fjy/TcheckEmployee/list.do'
	document.forms[0].submit();
}

setValueSelect('fjid','pcsid','','deptSeq')
</script>