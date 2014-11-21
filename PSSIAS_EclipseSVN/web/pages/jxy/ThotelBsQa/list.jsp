<%@page import="com.dyneinfo.jxy.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css"
			type="text/css" rel=stylesheet>
		<title><%=ThotelBsQa.TABLE_ALIAS%> 维护</title>
	</head>

	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>

		<div class="queryPanel">
			<s:form action="/pages/jxy/ThotelBsQa/htadlist.do" theme="simple" name="form1"
				style="display: inline;" method="post">
				<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
					<tr>
						<td class="tb_title" colspan="4"><%=ThotelBsQa.TABLE_ALIAS%>
						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_CODE%>
						</td>
						<td  colspan="3">
							<input value="${pageRequest.filters.code}" name="s_code" />
						</td>
					</tr>
					<tr class="crosscolor_tr">
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_WTSJ%>
						</td>
						<td  class="crosscolor_td2"> 
			                 <table class="list">
			                   <tr>
			                      <td>
							        <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_wtsjBegin','s_wtsjEnd','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                      </td>
			                      <td>从</td>
			                      <td>
			                         <input id="d3132" name="s_wtsjBegin"  value="${pageRequest.filters.wtsjBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> 
			                      </td>
			                      <td>到</td>
			                      <td>
			                        <input id="d3142" name="s_wtsjEnd"   value="${pageRequest.filters.wtsjEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
                                  </td>
                                </tr>
                             </table>     		                  
		                  </td>
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_WTFL%>
						</td>
						<td class="crosscolor_td2">
							<mytag:select  name="s_wtfl" value="${pageRequest.filters.wtfl}"  notEmpty="false"  dictName="wtfl"/>
						</td>
					</tr>

					<tr class="crosscolor_tr">
					<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_JDSJ%>
						</td>
						<td > 
			                 <table class="list">
			                   <tr>
			                      <td>
							         <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_jdsjBegin','s_jdsjEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                      </td>
			                      <td>从</td>
			                      <td>
			                          <input id="d3133" name="s_jdsjBegin"  value="${pageRequest.filters.jdsjBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/>
			                      </td>
			                      <td>到</td>
			                      <td>
			                        <input id="d3143" name="s_jdsjEnd"   value="${pageRequest.filters.jdsjEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
                                  </td> 	
                               </tr>
                              </table>					
						</td>
						
						<td class="crosscolor_td">
							<%=ThotelBsQa.ALIAS_JDBZ%>
						</td>
						<td>
							<mytag:select  name="s_jdbz" value="${pageRequest.filters.jdbz}"  notEmpty="false"  dictName="jdbz"/>
						</td>
					</tr>
					<tr>
						<td class="tb_bottom" colspan="4">
							<input type="submit" value="查询"
								onclick="getReferenceForm(this).action='${ctx}/pages/jxy/ThotelBsQa/htadlist.do'" />
						   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>



		<ec:table items='page.result' var="item" method="get"
			retrieveRowsCallback="limit" sortRowsCallback="limit"
			filterRowsCallback="limit" action="${ctx}/pages/jxy/ThotelBsQa/list.do"
			autoIncludeParameters="true">
			<ec:row>
				<ec:column property="dwmc" title="<%=ThotelBsQa.ALIAS_DWMC%>" />
				<ec:column property="username"
					title="<%=ThotelBsQa.ALIAS_USERNAME%>" />
				<ec:column property="wtsj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=ThotelBsQa.ALIAS_WTSJ%>"/>
				<ec:column property="usertel" title="<%=ThotelBsQa.ALIAS_USERTEL%>" />
				<mytag:lookupcolumn property="wtfl"  title="<%=ThotelBsQa.ALIAS_WTFL%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="wtfl" />
				<ec:column property="jdsj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=ThotelBsQa.ALIAS_JDSJ%>"/>
				<ec:column property="jdnr" width="250px" title="<%=ThotelBsQa.ALIAS_JDNR%>" />
				<ec:column property="jdr" title="<%=ThotelBsQa.ALIAS_JDR%>" />
				<mytag:lookupcolumn property="jdbz"  title="<%=ThotelBsQa.ALIAS_JDBZ%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="jdbz" />
				<ec:column width="30px" property="操作" title="操作" sortable="false"
					viewsAllowed="html">
					<a href="${ctx}/pages/jxy/ThotelBsQa/htadshow.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
					 <c:if test="${item.jdbz == '1'}">
						<a href="${ctx}/pages/jxy/ThotelBsQa/htadedit.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">解答</a>
					</c:if>
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
				input_txt.value = "!/pages/jxy/ThotelBsQa/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/jxy/ThotelBsQa/delete.do';
	            form.submit();
	        }
	  }
</script>
