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
	<title><%=TpoliceCheck.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/TpoliceCheck/list.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TpoliceCheck.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     部门
		                  </td>
			              <td>
		                         
		                           
		                            <input type="text"   class="required"   name="s_sendunitname" maxlength="0" value="${pageRequest.filters.sendunitname}"  class="max-length-30"/>
		                            <input type="hidden"  name="s_deptSeq" value="${pageRequest.filters.deptSeq}"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept4Seq(inputForm,'s_sendunitname','s_deptSeq')"   value="选择" type="button" > 
		                 
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acceptcheckname}"  name="s_acceptcheckname"  />
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
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=TpoliceCheck.ALIAS_CHECKTIME%>
		                  </td>
			              <td class="td_input">
		                           <s:select name="dateSelect4" list="dateSelectMap"  onchange="dateselect('list_dateSelect4','d3134','d3144','yyyy-MM-dd');"  value="#request.dateSelect4" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3134" name="s_checktimeBegin"  value="${pageRequest.filters.checktimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3144\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3144" name="s_checktimeEnd"   value="${pageRequest.filters.checktimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3134\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TpoliceCheck/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TpoliceCheck/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TpoliceCheck/list.do" autoIncludeParameters="true">
	<ec:row>
		
		                    <ec:column property="deptname"  title="<%=TpoliceCheck.ALIAS_DEPTID%>"/>
		                    <ec:column property="acceptchecknameXm"  title="<%=TpoliceCheck.ALIAS_ACCEPTCHECKNAME%>"/>
		                    <ec:column property="checknameXm"  title="<%=TpoliceCheck.ALIAS_CHECKNAME%>"/>
		                   
		                    <ec:column property="checktime" value="${item.checktimeString}" title="<%=TpoliceCheck.ALIAS_CHECKTIME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TpoliceCheck/show.do?checkid=${item.checkid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/TpoliceCheck/tab.do?checkid=${item.checkid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">检查信息</a>
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
				input_txt.value = "!/pages/fjy/TpoliceCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/TpoliceCheck/delete.do';
	            form.submit();
	        }
	  }
	  
	   function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
     function selectDept4Seq(frm, displayName, hiddenName) {
		window.showModalDialog("${ctx}/pages/fjy/SsDept/selectDept.do?random=" + Math.random() + "&formName=" + frm.name + "&inputName=" + displayName + "&hiddenName=" + hiddenName + "&idValueIsSeq=true&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT", frm, "dialogHeight:500px;dialogWidth:560px;center:yes");
	}
</script>