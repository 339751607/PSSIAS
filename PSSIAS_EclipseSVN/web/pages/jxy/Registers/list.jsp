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
	<title><%=Registers.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Registers/list.do" name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Registers.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_CLUSTERGROUP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.clustergroup}"  name="s_clustergroup"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_IPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ipaddress}"  name="s_ipaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_DATASOURCENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.datasourcename}"  name="s_datasourcename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_NOTE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_note"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PACKAGES%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect4" list="dateSelectMap"  onchange="dateselect(this,'s_packagesBegin','s_packagesEnd','yyyy-MM-dd');"  value="#request.dateSelect4" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3134" name="s_packagesBegin"  value="${pageRequest.filters.packagesBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3144\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3144" name="s_packagesEnd"   value="${pageRequest.filters.packagesEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3134\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PORT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.port}"  name="s_port"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_PROTOCOL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.protocol}"  name="s_protocol"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Registers.ALIAS_REGISTERTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_registertimeBegin','s_registertimeEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3137" name="s_registertimeBegin"  value="${pageRequest.filters.registertimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Registers.FORMAT_REGISTERTIME%>',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3147" name="s_registertimeEnd"   value="${pageRequest.filters.registertimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Registers.FORMAT_REGISTERTIME%>',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     
		                  </td>
			              <td colspan="3">
		                          
		                  <input name="selectOrg" onclick="selectDept(inputForm,'orgName','orgID')"   value="选择"type="button">
		                  <input name="selectOrg" onclick="selectPerson(inputForm,'orgName','orgID')"   value="选择"type="button">
		                  <input name="selectOrg" onclick="selectDeptCheckbox(inputForm,'orgName','orgID')"   value="选择"type="button">
		                 <input value=""  name="orgID"  />
		                  <input value=""  name="orgName"  />
		                  </td>
                          
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Registers/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Registers/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Registers/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="unitid=${item.unitid}&"/>
		</ec:column>
		                    <ec:column property="clustergroup"  title="<%=Registers.ALIAS_CLUSTERGROUP%>"/>
		                    <ec:column property="ipaddress"  title="<%=Registers.ALIAS_IPADDRESS%>"/>
		                    <ec:column property="datasourcename"  title="<%=Registers.ALIAS_DATASOURCENAME%>"/>
				            <mytag:lookupcolumn property="note"  title="<%=Registers.ALIAS_NOTE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
				            <ec:column property="packages"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Registers.ALIAS_PACKAGES%>"/>
		                    <ec:column property="port"  title="<%=Registers.ALIAS_PORT%>"/>
		                    <ec:column property="protocol"  title="<%=Registers.ALIAS_PROTOCOL%>"/>
		                    <ec:column property="registertime" value="${item.registertimeString}" title="<%=Registers.ALIAS_REGISTERTIME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Registers/show.do?unitid=${item.unitid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/jxy/Registers/edit.do?unitid=${item.unitid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/jxy/Registers/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Registers/delete.do';
	            form.submit();
	        }
	  }
	  
	    
	   function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=true&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       function selectPerson(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectPerson.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=true&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       function selectDeptCheckbox(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDeptCheckbox.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=true&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:450px;center:yes');
       }
</script>
