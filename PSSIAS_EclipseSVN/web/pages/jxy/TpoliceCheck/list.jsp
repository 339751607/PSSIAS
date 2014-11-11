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
	<title><%=TpoliceCheck.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/TpoliceCheck/list.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpoliceCheck.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     部门
		                  </td>
			              <td colspan="3">
		                            <input type="text"  name="s_deptname" value="${pageRequest.filters.deptname}"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checkname}"  name="s_checkname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checknamephone}"  name="s_checknamephone"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                          
		              			 <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'d3133','d3143','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_checktimeBegin"  value="${pageRequest.filters.checktimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_checktimeEnd"   value="${pageRequest.filters.checktimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
						  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/TpoliceCheck/list.do'"/>
			                       <input type="button" value="清空" onclick="resitData(document.forms.inputForm);"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/TpoliceCheck/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/TpoliceCheck/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="deptname"  title="<%=TpoliceCheck.ALIAS_DEPTID%>"/>
		                    <ec:column property="acceptcheckname"  title="<%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>"/>
		                    <ec:column property="checkname"  title="<%=TpoliceCheck.ALIAS_CHECKNAME%>"/>
		                    <ec:column property="checknamephone"  title="<%=TpoliceCheck.ALIAS_CHECKNAMEPHONE%>"/>
		                    <ec:column property="checktime" value="${item.checktimeString}" title="<%=TpoliceCheck.ALIAS_CHECKTIME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/TpoliceCheck/show.do?checkid=${item.checkid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/jxy/TpoliceCheck/tab.do?checkid=${item.checkid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">检查信息</a>
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
				input_txt.value = "!/jxy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/TpoliceCheck/delete.do';
	            form.submit();
	        }
	  }
	  
	   function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
