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
	<title><%=TpersonbaseJw.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/TpersonbaseJw/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpersonbaseJw.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SURNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.surname}"  name="s_surname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_CH_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chName}"  name="s_chName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SEX%>
		                  </td>
			              <td>		                           
		                      <mytag:select  name="s_sex"  value="${pageRequest.filters.sex}"  notEmpty="false"  dictName="T_DIC_SEX"/>
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bdate}"  name="s_bdate"  /><div align="left">(格式：yyyyMMdd)</div>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NATIONALITY%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_nationality"  value="${pageRequest.filters.nationality}"  notEmpty="false"  dictName="DIC_ITEM_COUNTRY"/>
	                      </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
			                       <mytag:select  name="s_passT"  value="${pageRequest.filters.passT}"  notEmpty="false"  dictName="DIC_ITEM_PASSPORT"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.passNo}"  name="s_passNo"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_T%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_visaT"  value="${pageRequest.filters.visaT}"  notEmpty="false"  dictName="DIC_ITEM_VISA"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visaNo}"  name="s_visaNo"  />
		                  </td>
                   </tr>		      
		           <tr>
		              <td class="tb_bottom" colspan="4">
	                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJw/list.do'"/>
                              <!-- 
                              <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TpersonbaseJw/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
                              -->
		              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TpersonbaseJw/list.do" autoIncludeParameters="true">
	<ec:row>
            <ec:column property="surname"  title="<%=TpersonbaseJw.ALIAS_SURNAME%>"/>
            <ec:column property="name"  title="<%=TpersonbaseJw.ALIAS_NAME%>"/>
            <ec:column property="chName"  title="<%=TpersonbaseJw.ALIAS_CH_NAME%>"/>
            <mytag:lookupcolumn property="sex"  title="<%=TpersonbaseJw.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
            <ec:column property="bdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" value="${item.bdate}" title="<%=TpersonbaseJw.ALIAS_BDATE%>"/>
		    <mytag:lookupcolumn property="nationality"  title="<%=TpersonbaseJw.ALIAS_NATIONALITY%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_COUNTRY" />
		    <mytag:lookupcolumn property="passT"  title="<%=TpersonbaseJw.ALIAS_PASS_T%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_PASSPORT" />
            <ec:column property="passNo"  title="<%=TpersonbaseJw.ALIAS_PASS_NO%>"/>
            <mytag:lookupcolumn property="visaT"  title="<%=TpersonbaseJw.ALIAS_VISA_T%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_VISA" />
		    <ec:column property="visaNo"  title="<%=TpersonbaseJw.ALIAS_VISA_NO%>"/> 
            <ec:column property="updatetime" value="${item.updatetimeString}" title="<%=TpersonbaseJw.ALIAS_UPDATETIME%>"/>
            
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/TpersonbaseJw/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
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
				input_txt.value = "!/pages/zazh/TpersonbaseJw/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/TpersonbaseJw/delete.do';
	            form.submit();
	        }
	  }
</script>