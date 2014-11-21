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
	<title><%=Tfeijiuwupin.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form  name="queryForm" action="/pages/fjy/Tfeijiuwupin/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tfeijiuwupin.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">

                           <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csrxm}"  name="s_csrxm"  />
		                  </td>
		            	<td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                   </tr>
                   <tr class="tr_tb">
                          
                          <td class="td_tb">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>
		                  </td>
			               <td colspan="3" class="td_input">
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('list_dateSelect2','d3132','d3142','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_shougourqBegin"  value="${pageRequest.filters.shougourqBegin}"   maxlength="0" size="16" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_shougourqEnd"   value="${pageRequest.filters.shougourqEnd}"  maxlength="0" size="16" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          
                   </tr>
		          
		        
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tfeijiuwupin/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tfeijiuwupin/list.do" autoIncludeParameters="true">
	<ec:row>
							<ec:column property="csrxm"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURY%>"/>
				            <ec:column property="shougourq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm" cell="date"  title="收购时间"/>
		                    <ec:column property="empname"  title="<%=Tfeijiuwupin.ALIAS_SHOUGOURY%>"/>
		                    
				            <mytag:lookupcolumn property="csrxb"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    <ec:column property="chushourensfzh"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>"/>
		                    <ec:column property="wpzl"  title="<%=Tfeijiuwupin.ALIAS_WPZL%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tfeijiuwupin/show.do?wupinxh=${item.wupinxh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			 <!--<a href="${ctx}/pages/fjy/Tfeijiuwupin/edit.do?wupinxh=${item.wupinxh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			 <a href="${ctx}/pages/fjy/Tfeijiuwupin/tab.do?wupinxh=${item.wupinxh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">附加信息</a>-->
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


