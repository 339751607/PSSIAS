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
	<title><%=VemployeeSta.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/VemployeeSta/list.do"   name="inputForm"  theme="simple" style="display: inline;" method="post">
           <input type="hidden" name="tx" value=""/>
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=VemployeeSta.TABLE_ALIAS%></td>
		           </tr>
		           <tr class="crosscolor_tr">
	 					 <td class="crosscolor_td">
                          	所属公安机关
                          	</td>
                          	<td>
							<select id="fjid" onchange="getPcs('fjid','pcsid');">
								<option>请选择...</option>
							</select>
							<select id="pcsid"  >
								<option>请选择...</option>
							</select>
							
								<input type="hidden" name="s_deptseq" id="s_deptseq" value="${deptseq}" size="60"/>
							</td>
                   </tr>
                   <tr class="crosscolor_tr">
                   <td class="crosscolor_td">
                         户籍地
                          	</td>
			          <td >
						<%@ include file="/commons/xzqhselect.jsp" %>  
					</td>
                   </tr>	
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="图表" onclick="query();"/>

			                        <input type='button' value='柱状图' onClick="queryTx('btnColumn');" name='btnColumn' />
			                        <input type='button' value='折线图' onClick="queryTx('btnLine');" name='btnLine' />
			                        <input type='button' value='饼状图' onClick="queryTx('btnPie');" name='btnPie' />
			                        <input type="button" value="清空" onclick="resitData(document.forms[0]);document.getElementById('xzqh').value='';"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/VemployeeSta/list.do" autoIncludeParameters="true">
	<ec:row>
		
		                    <ec:column property="deptname"  title="<%=VemployeeSta.ALIAS_DEPTNAME%>"/>
		                    <ec:column property="onezl"  title="<%=VemployeeSta.ALIAS_ONEZL%>"/>
		                    <ec:column property="twozl"  title="<%=VemployeeSta.ALIAS_TWOZL%>"/>
		                    <ec:column property="threezl"  title="<%=VemployeeSta.ALIAS_THREEZL%>"/>
		                    <ec:column property="fourzl"  title="<%=VemployeeSta.ALIAS_FOURZL%>"/>
		                    <ec:column property="ninezl"  title="<%=VemployeeSta.ALIAS_NINEZL%>"/>
		                    <ec:column property="sumzl"  title="总人数">
		                    <c:choose>
							   <c:when test="${item.sumzl != '0'}">
							   	<a href="#" onclick="queryList('${item.DEPTSEQ}');return false;"><font color="red">${item.sumzl }</font></a>
							   </c:when>
							   <c:otherwise>
							 
							   </c:otherwise>
							</c:choose>
							</ec:column>
		
	</ec:row>
</ec:table>

</body>

</html>


<script>
function query(){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/VemployeeSta/list.do'
	document.forms[0].submit();
}
function queryTx(lx){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].tx.value=lx;
	document.forms[0].action='${ctx}/pages/fjy/VemployeeSta/list.do'
	document.forms[0].submit();
	
}
function queryList(deptseq){
	var url="${ctx}/pages/fjy/Temployee/queryList.do?dept_seq="+deptseq+"&fh=tj"
	document.forms[0].action=url;
	document.forms[0].submit();
}
setValueSelect('fjid','pcsid','','s_deptseq')	
</script>