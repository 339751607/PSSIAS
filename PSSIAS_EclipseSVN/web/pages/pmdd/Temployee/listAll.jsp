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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Temployee.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Temployee/listAll.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cyrjzt" value="${pageRequest.filters.cyrjzt}"  notEmpty="false"  dictName="T_DIC_CYRJZT"/>
		                  </td>
                         
                   </tr>
		          
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td >
				                  
			                          从<input id="d3133" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                  </td>
		                   <td class="crosscolor_td">
			                     工作单位
		                  </td>
			              <td >
				                  
			                          <mytag:orgSelect  nullOption="false"  searchType="seq" value="%{s_cpcode}"    name="s_cpcode"  />
			             </td>
                          
                   </tr>
		           
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Temployee/listAll.do'"/>
	                               <authz:authorize ifNotGranted="ROLE_ADMIN,ROLE_HT_ADMIN">
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Temployee/createAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                                </authz:authorize>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Temployee/listAll.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="deptname"  title="工作单位"/>
		                    <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>"/>
				            <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="personid"  title="<%=Temployee.ALIAS_PERSONID%>"/>
				            <ec:column property="birth"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
		                  
				            <mytag:lookupcolumn property="folk"  title="<%=Temployee.ALIAS_FOLK%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_NATION" />
				               
				            <mytag:lookupcolumn property="npcode"  title="<%=Temployee.ALIAS_NPCODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_XZQH" />
		                  
		                    
				            <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_CYRJZT" />
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Temployee/showAll.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/pmdd/Temployee/editAll.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/pmdd/Temployee/tabAll.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">其他信息</a>
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
				input_txt.value = "!/pages/pmdd/Temployee/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Temployee/delete.do';
	            form.submit();
	        }
	  }
</script>