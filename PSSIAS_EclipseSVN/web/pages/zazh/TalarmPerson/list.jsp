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
	<title><%=TalarmPerson.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form  name="queryForm" action="/pages/zazh/TalarmPerson/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TalarmPerson.TABLE_ALIAS%>查询</td>
		           </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
		                 <!-- 
		                  <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SEX%>
		                  </td>
		           
			              <td>
		                           <mytag:select  name="s_sex"  
	         			             value="${pageRequest.filters.sex}" dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BDATE%>
		                  </td>
			              <td>
    	                            <input id="d31312" name="s_bdate"  value="${pageRequest.filters.bdate}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			              
		                  </td>
		             -->
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcode}"  name="s_idcode"  />
		                  </td>                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                            <mytag:select  name="s_bktype"  
	         			             value="${pageRequest.filters.bktype}" dictName="DIC_ITEM_BKLX"/>		         			         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
			                      <mytag:select  name="s_alarmtype"  
	         			             value="${pageRequest.filters.alarmtype}" dictName="DIC_ITEM_ALARMTYPE"/>	                     
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      处警状态
		                  </td>
			              <td>
		                            <mytag:select  name="s_clflag"  
	         			             value="${pageRequest.filters.clflag}" dictName="DIC_ITEM_CLFLAG"/>	         			             
		                  </td>
                          <td class="crosscolor_td">
			                    
		                  </td>
			              <td>
			                                         
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmPerson/list.do'"/>
	                               <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.queryForm)"/>
	                             <!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmPerson/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                             -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TalarmPerson/list.do" autoIncludeParameters="true">
	<ec:row>
              <ec:column property="name"  title="<%=TalarmPerson.ALIAS_NAME%>"/>
              <mytag:lookupcolumn property="idname"  title="<%=TalarmPerson.ALIAS_IDNAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />               
              <ec:column property="idcode"  title="<%=TalarmPerson.ALIAS_IDCODE%>"/>
              <mytag:lookupcolumn property="sex"  title="<%=TalarmPerson.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
              <mytag:lookupcolumn property="nation"  title="<%=TalarmPerson.ALIAS_NATION%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_NATION" />
              <ec:column property="address"  title="<%=TalarmPerson.ALIAS_ADDRESS%>"/>   
              <mytag:lookupcolumn property="bktype"  title="<%=TalarmPerson.ALIAS_BKTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BKLX" />
              <mytag:lookupcolumn property="alarmsource"  title="<%=TalarmPerson.ALIAS_ALARMSOURCE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ITEM_BUSSINESS" />
              <mytag:lookupcolumn property="alarmtype"  title="<%=TalarmPerson.ALIAS_ALARMTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_ALARMTYPE" />
              <ec:column property="alarmtime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.alarmtime}" title="<%=TalarmPerson.ALIAS_ALARMTIME%>"/>
		      <mytag:lookupcolumn property="clflag"  title="<%=TalarmPerson.ALIAS_CLFLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cjbz" />
              
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/TalarmPerson/alarmshow.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">处警</a> &nbsp;&nbsp;
		    <a href="${ctx}/pages/zazh/TalarmPerson/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
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
				input_txt.value = "!/pages/zazh/TalarmPerson/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/TalarmPerson/delete.do';
	            form.submit();
	        }
	  }
</script>