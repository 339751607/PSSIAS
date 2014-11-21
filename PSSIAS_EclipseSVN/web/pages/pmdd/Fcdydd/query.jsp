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
	<title><%=Fcdydd.TABLE_ALIAS%> 查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Fcdydd/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Fcdydd.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                         
                          
		                  <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_HTID%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.htid}" size="50" name="s_htid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sqr}"  name="s_sqr"  />
		                  </td>
                 
                          
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FWQW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fwqw}"  name="s_fwqw"  />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">    
		                   
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FWSYQZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fwsyqzh}"  name="s_fwsyqzh"  />
		                  </td>
                 
                         
                 
                        
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_TDSYZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tdsyzh}"  name="s_tdsyzh"  />
		                  </td>
                   </tr>
		       
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDRQ%>
		                  </td>
			              <td >
			              <table class="list">
			              		<tr>
			              			<td>
			              				 <s:select name="dateSelect18" list="dateSelectMap"  onchange="dateselect(this,'s_ddrqBegin','s_ddrqEnd','yyyy-MM-dd');"  value="#request.dateSelect18" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d31318" name="s_ddrqBegin"  value="${pageRequest.filters.ddrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31418\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d31418" name="s_ddrqEnd"   value="${pageRequest.filters.ddrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31318\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>      
		                  </td>
		                   <td class="crosscolor_td">
			                    <%=Fcdydd.ALIAS_SFSH%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.sfsh}"  name="s_sfsh"   notEmpty="false"  dictName="shiFou"/>
		                          
		                  </td>
                          
                   </tr>
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Fcdydd/list.do?query=true'"/>
			             		   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Fcdydd/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="htid"  title="<%=Fcdydd.ALIAS_HTID%>"/>
		                    <ec:column property="sqr"  title="<%=Fcdydd.ALIAS_SQR%>"/>
				            <mytag:lookupcolumn property="lb"  title="<%=Fcdydd.ALIAS_LB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="fcdylb" />
		                    <ec:column property="fwqw"  title="<%=Fcdydd.ALIAS_FWQW%>"/>
		                    <ec:column property="fwsyqzh"  title="<%=Fcdydd.ALIAS_FWSYQZH%>"/>
		                    <ec:column property="tdsyzh"  title="<%=Fcdydd.ALIAS_TDSYZH%>"/>
		                    <ec:column property="ddqx"  title="<%=Fcdydd.ALIAS_DDQX%>"/>
				            <ec:column property="ddrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Fcdydd.ALIAS_DDRQ%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Fcdydd/htcxShow.do?dnumber=${item.dnumber}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		 </ec:column>
	</ec:row>
</ec:table>

</body>

</html>
