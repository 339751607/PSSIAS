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
	<title><%=Clzydd.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Clzydd/redeemList.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Clzydd.TABLE_ALIAS%>查询</td>
		           </tr>
		                    <tr class="crosscolor_tr">
                         
                          
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.htid}"  size="50"   name="s_htid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sqr}"  name="s_sqr"  />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CZMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.czmc}"  name="s_czmc"  />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CPHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cphm}"  name="s_cphm"  />
		                  </td>
                          
                 
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FDJH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fdjh}"  name="s_fdjh"  />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRQ%>
		                  </td>
			              <td >
				           <table class="list">
			              		<tr>
			              	  		<td>
				                		<s:select name="dateSelect19" list="dateSelectMap"  onchange="dateselect(this,'s_ddrqBegin','s_ddrqEnd','yyyy-MM-dd');"  value="#request.dateSelect19" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                  		</td>          
			                  		<td>从</td>
			                  		<td>
			                  			<input id="d31319" name="s_ddrqBegin"  value="${pageRequest.filters.ddrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31419\')}'})"/>
			                  		</td>
			                  		<td>到</td>
			                		<td>
			                			<input id="d31419" name="s_ddrqEnd"   value="${pageRequest.filters.ddrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31319\')}'})"/>
		                  			</td>
		                   		</tr>
		                  	</table>
		                  </td>
		                   <td class="crosscolor_td">
			                    <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.sfsh}"  name="s_sfsh"   notEmpty="false"  dictName="shiFou"/>
		                          
		                  </td>
                   </tr>
		        
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Clzydd/redeemList.do'"/>
			             		   <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/Clzydd/redeemList.do" autoIncludeParameters="true">
	<ec:row>
		
		                   <ec:column property="htid"  title="<%=Clzydd.ALIAS_HTID%>"/>
		                    <ec:column property="sqr"  title="<%=Clzydd.ALIAS_SQR%>"/>
		                    <ec:column property="zjhm"  title="<%=Clzydd.ALIAS_ZJHM%>"/>
		                    <ec:column property="cphm"  title="<%=Clzydd.ALIAS_CPHM%>"/>
		                    <ec:column property="czmc"  title="<%=Clzydd.ALIAS_CZMC%>"/>
		                    <ec:column property="fdjh"  title="<%=Clzydd.ALIAS_FDJH%>"/>
		                    <ec:column property="sccj"  title="<%=Clzydd.ALIAS_SCCJ%>"/>
		                    <ec:column property="csys"  title="<%=Clzydd.ALIAS_CSYS%>"/>
				            <ec:column property="ddrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Clzydd.ALIAS_DDRQ%>"/>
				           <mytag:lookupcolumn property="sfsh"  title="<%=Clzydd.ALIAS_SFSH%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="shiFou" />
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			
			<c:if test="${item.sfsh=='1'}">
				<a href="${ctx}/pages/pmdd/Clzydd/redeemShow.do?dnumber=${item.dnumber}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${item.sfsh=='0'}">
			<a href="${ctx}/pages/pmdd/Clzydd/redeemEdit.do?dnumber=${item.dnumber}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">赎回</a>
			</c:if>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

