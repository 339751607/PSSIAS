<%@page import="com.dyneinfo.jxy.model.*" %>
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
    <s:form action="/jxy/Temployee/list.do"  theme="simple" name="form1" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.name}" name = "s_name"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td class="crosscolor_td2">
		                             <mytag:select  name="s_sex" value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
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
			                      <td>
			                        <input id="d3135" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-01',maxDate:'#F{$dp.$D(\'d3145\')}'})"/> 
			                      </td>
			                      <td>到</td>
			                      <td>
			                        <input id="d3145" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-02',minDate:'#F{$dp.$D(\'d3135\')}'})"/>
		                          </td>
		                       </tr>
		                     </table>  
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                            <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INDATE%>
		                  </td>
			              <td colspan="1" align="left"> 
			                 <table class="list">
			                   <tr>
				                  <td> 
				                   <s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_indateBegin','s_indateEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                      </td>   
			                      <td>从</td>
			                      <td>   
			                          <input id="d31310" name="s_indateBegin"  value="${pageRequest.filters.indateBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			                      </td>   
			                      <td>到</td>
			                      <td>  
			                        <input id="d31410" name="s_indateEnd"   value="${pageRequest.filters.indateEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                          </td>
		                        </tr>
		                      </table>  
		                  </td>
			                  <td class="crosscolor_td">
				                      <%=Temployee.ALIAS_DEPTNAME%>
			                  </td>
				              <td >
			                            <input value="${pageRequest.filters.deptname}"  name="s_deptname"  />
			                  </td>
                   </tr>
                             <authz:authorize ifAnyGranted="ROLE_HT_ADMIN">
                           <tr class="crosscolor_tr">
                   	<td class="crosscolor_td">
							部门
						</td>
						<td>

							<input type="text" size="20"
								value="${pageRequest.filters.rowname}" name="s_rowname" />
							<input type="hidden" value="${pageRequest.filters.deptseq}"
								name="s_deptseq" />
							<input name="selectDeptButton"
								onclick="javascript:selectDept(form1,'s_rowname','s_deptseq')"
								value="选择" type="button">
						</td>
						<td></td>
						<td></td>
                   </tr>
                      </authz:authorize>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Temployee/list.do'"/>			                   
			                       <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Temployee/list.do" autoIncludeParameters="true">
	<ec:row>
							<authz:authorize ifAnyGranted="ROLE_HT_ADMIN">
		                   	 <ec:column property="deptname"  title="<%=Temployee.ALIAS_DEPTNAME%>"/>
		                    </authz:authorize>
		                    <ec:column property="name"   title="<%=Temployee.ALIAS_NAME%>"/>
				            <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="personid"  title="<%=Temployee.ALIAS_PERSONID%>"/>
				            <ec:column property="birth"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
				            <mytag:lookupcolumn property="folk"  title="<%=Temployee.ALIAS_FOLK%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_NATION" />
				            <mytag:lookupcolumn property="npcode"  title="<%=Temployee.ALIAS_NPCODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_XZQH" />
		                    <ec:column property="phone"  title="<%=Temployee.ALIAS_PHONE%>"/>
				            <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_EMPFLAG" />
		                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<!-- <a href="${ctx}/jxy/Temployee/show.do?cpempcode=${item.cpempcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp; -->
		<c:if test="${ deptid eq fn:trim(item.cpcode)}">
		<c:if test="${item.cyrjzt == '0'}">
				<a href="${ctx}/jxy/Temployee/edit.do?cpempcode=${item.cpempcode}&cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			</c:if>
			<c:if test="${item.cyrjzt == '1'}">
				<a href="${ctx}/jxy/Temployee/fz.do?cpempcode=${item.cpempcode}&cpcode=${item.cpcode}&returnUrl=<mytag:params includes="ec*,s*" type="queryStringUtf"/>">复职</a>
			</c:if>
		</c:if>
		<a href="${ctx}/jxy/Temployee/show.do?cpempcode=${item.cpempcode}&cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>
<script>
function selectDept(frm, displayName, hiddenName) {
	window.showModalDialog(
			'${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName='
					+ frm.name + '&inputName=' + displayName + '&hiddenName='
					+ hiddenName
					+ '&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT', frm,
			'dialogHeight:500px;dialogWidth:560px;center:yes');
}
</script>
</body>

</html>	

