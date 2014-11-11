<%@page import="com.dyneinfo.zazh.model.*" %>
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
	<title><%=TpersonbaseJn.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonbaseJn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonbaseJn.TABLE_ALIAS%>查询</td>
		           </tr>
			           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_SEX%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_sex"  value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  /><div align="left">(格式：yyyyMMdd)</div>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NATION%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_nation"  value="${pageRequest.filters.nation}"  notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                       <mytag:select  name="s_cardname"  value="${pageRequest.filters.cardname}"  notEmpty="false"  dictName="T_ID_NAME"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cardcode}"  name="s_cardcode"  />
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xzqh}"  name="s_xzqh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect8" list="dateSelectMap"  onchange="dateselect(this,'s_updatetimeBegin','s_updatetimeEnd','yyyy-MM-dd');"  value="#request.dateSelect8" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3138" name="s_updatetimeBegin"  value="${pageRequest.filters.updatetimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',maxDate:'#F{$dp.$D(\'d3148\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3148" name="s_updatetimeEnd"   value="${pageRequest.filters.updatetimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TpersonbaseJn.FORMAT_UPDATETIME%>',minDate:'#F{$dp.$D(\'d3138\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   -->
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJn/list.do'"/>
	                             <!-- 
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJn/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                               -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TpersonbaseJn/list.do" autoIncludeParameters="true">
	<ec:row>

        <ec:column property="name"  title="<%=TpersonbaseJn.ALIAS_NAME%>"/>
        <mytag:lookupcolumn property="sex"  title="<%=TpersonbaseJn.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		
		<mytag:lookupcolumn property="nation"  title="<%=TpersonbaseJn.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_NATION" />
		                    	                    
         <ec:column property="bdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" value="${item.bdate}" title="<%=TpersonbaseJn.ALIAS_BDATE%>"/>
		
        <mytag:lookupcolumn property="cardname"  title="<%=TpersonbaseJn.ALIAS_CARDNAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
		   
        <ec:column property="cardcode"  title="<%=TpersonbaseJn.ALIAS_CARDCODE%>"/>
        <ec:column property="address"  title="<%=TpersonbaseJn.ALIAS_ADDRESS%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/TpersonbaseJn/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			<!--  &nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/zazh/TpersonbaseJn/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		    -->
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
				input_txt.value = "!/pages/zazh/TpersonbaseJn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/TpersonbaseJn/delete.do';
	            form.submit();
	        }
	  }
</script>