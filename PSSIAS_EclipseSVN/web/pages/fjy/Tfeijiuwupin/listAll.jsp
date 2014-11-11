<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
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
    <s:form action="/pages/fjy/Tfeijiuwupin/listAll.do" name="inputForm"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tfeijiuwupin.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WUPINMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.wupinmc}"  name="s_wupinmc"  />
		                  </td>
                           <td class="crosscolor_td">
			                      所在部门
		                  </td>
			              <td>
			              
			               <input type="text"   class="required"   name="s_deptname" maxlength="0" value="${pageRequest.filters.deptname}"  class="max-length-30"/>
		                            <input type="hidden"  name="s_deptSeq" value="${pageRequest.filters.deptSeq}"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept4Seq(inputForm,'s_deptname','s_deptSeq')"   value="选择" type="button" > 
		                 
		                 
		                          
		                  </td>
                   </tr>
		           
		           <tr class="crosscolor_tr">
		               
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushoury}"  name="s_chushoury"  />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushourensfzh}"  name="s_chushourensfzh"  />
		                  </td>
                   </tr>
                   <tr class="tr_tb">
                          
                          <td class="td_tb">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>
		                  </td>
			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('listAll_dateSelect2','d3132','d3142','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_shougourqBegin"  value="${pageRequest.filters.shougourqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_shougourqEnd"   value="${pageRequest.filters.shougourqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          
                   </tr>
		          
		        
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tfeijiuwupin/listAll.do'"/>
	                                 <authz:authorize ifAnyGranted="ROLE_ADMIN,ROLE_BACK_MANAGER">
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                                </authz:authorize>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tfeijiuwupin/listAll.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="wupinxh=${item.wupinxh}&"/>
		</ec:column>
		                    <ec:column property="deptname"  title="企业名称"/>
		                    <mytag:lookupcolumn property="wupinlb"  title="<%=Tfeijiuwupin.ALIAS_WUPINLB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_WUPINLB" />
				          
				            <ec:column property="shougourq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>"/>
		                    <ec:column property="shougouryXm"  title="<%=Tfeijiuwupin.ALIAS_SHOUGOURY%>"/>
		                    <ec:column property="csrxm"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURY%>"/>
				            <mytag:lookupcolumn property="csrxb"  title="<%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SEX" />
		                    
		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/Tfeijiuwupin/showAll.do?wupinxh=${item.wupinxh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tfeijiuwupin/tabAll.do?wupinxh=${item.wupinxh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">附加信息</a>
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
				input_txt.value = "!/pages/fjy/Tfeijiuwupin/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/Tfeijiuwupin/delete.do';
	            form.submit();
	        }
	  }
	  
	   function selectDept4Seq(frm, displayName, hiddenName) {
		window.showModalDialog("${ctx}/pages/fjy/SsDept/selectDept.do?random=" + Math.random() + "&formName=" + frm.name + "&inputName=" + displayName + "&hiddenName=" + hiddenName + "&idValueIsSeq=true&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT", frm, "dialogHeight:500px;dialogWidth:560px;center:yes");
	}
</script>