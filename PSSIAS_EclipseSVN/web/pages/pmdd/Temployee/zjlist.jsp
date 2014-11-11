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
    <s:form action="/pages/pmdd/Temployee/list.do"  theme="simple" name="form1" style="display: inline;" method="post">
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
		                             <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
		                            <mytag:select  name="s_cyrjzt" value="${pageRequest.filters.cyrjzt}"  notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td> 
			              	<table class="list">
			              		<tr>
			              			<td>从</td>
			              			<td>
			              				<input id="d3135" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-01',maxDate:'#F{$dp.$D(\'d3145\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d3145" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-02',minDate:'#F{$dp.$D(\'d3135\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_RZRQ%>
		                  </td>
			              <td>
			              	<table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_rzrqBegin','s_rzrqEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d31310" name="s_rzrqBegin"  value="${pageRequest.filters.rzrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d31410" name="s_rzrqEnd"   value="${pageRequest.filters.rzrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>		                        
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td colspan="3">
		                            <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Temployee/zjlist.do'"/>			                   
			                       <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			                     <authz:authorize ifNotGranted="ROLE_ADMIN,ROLE_HT_ADMIN">
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Temployee/zjcreate.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			             		</authz:authorize>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Temployee/zjlist.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>"/>
				            <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
		                    <ec:column property="personid"  title="<%=Temployee.ALIAS_PERSONID%>"/>
				            <ec:column property="birth"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
				            <mytag:lookupcolumn property="folk"  title="<%=Temployee.ALIAS_FOLK%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nation" />
				            <mytag:lookupcolumn property="npcode"  title="<%=Temployee.ALIAS_NPCODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="xzqh" />
		                    <ec:column property="phone"  title="<%=Temployee.ALIAS_PHONE%>"/>
				            <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
		<c:if test="${ deptid eq fn:trim(item.cpcode)}">
		<c:if test="${item.cyrjzt == '0'}">
				<a href="${ctx}/pages/pmdd/Temployee/edit.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${item.cyrjzt == '1'}">
				<a href="${ctx}/pages/pmdd/Temployee/fz.do?empcode=${item.empcode}&returnUrl=<mytag:params includes="ec*,s*" type="queryStringUtf"/>">复职</a>&nbsp;&nbsp;&nbsp;
			</c:if>
		</c:if>
		<a href="${ctx}/pages/pmdd/Temployee/tab.do?empcode=${item.empcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>	

