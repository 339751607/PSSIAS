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
	<title><%=TelInfoView.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/fjy/TelInfoView/list.do"  theme="simple" style="display: inline;" name="inputForm" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TelInfoView.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TelInfoView.ALIAS_TELPP%>
		                  </td>
			              <td>
		                         <s:doubleselect name="s_telpp" list="provList" listKey="id"  
								listValue="name" doubleName="s_telxh"  
								value="#request.defaultItem"
								doubleValue="#request.doubleDefaultItem" 
								doubleList="cityMap.get(top.id)" doubleListKey="id"
								doubleListValue="name" theme="simple" />
		                  </td>
                         <td class="crosscolor_td">
			                     企业名称
		                  </td>
			              <td>
		                         
		                           <mytag:orgSelect  nullOption="false"  searchType="seq" value="%{s_cpcode}"    name="s_cpcode"  />
		                           
		                          <!--   <input type="text"   class="required"   name="s_sendunitname" maxlength="0" value="${pageRequest.filters.sendunitname}"  class="max-length-30"/>
		                            <input type="hidden"  name="s_cpcode" value="${pageRequest.filters.s_cpcode}"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'s_sendunitname','s_cpcode')"   value="选择" type="button" > 
		                 --> 
		                  </td>
                   </tr>
		            <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TelInfoView.ALIAS_JXXLH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jxxlh}"  name="s_jxxlh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TelInfoView.ALIAS_SJLB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sjlb" value="${pageRequest.filters.sjlb}"  notEmpty="false"  dictName="T_DIC_SJLB"/>
		                  </td>
                         
                   </tr>
		          
		       
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=TelInfoView.ALIAS_SGSJ%>
		                  </td>
			              <td colspan="3" class="td_input">
		                           <s:select name="dateSelect12" list="dateSelectMap"  onchange="dateselect('list_dateSelect12','d31312','d31412','yyyy-MM-dd');"  value="#request.dateSelect12" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31312" name="s_sgsjBegin"  value="${pageRequest.filters.sgsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31412" name="s_sgsjEnd"   value="${pageRequest.filters.sgsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
		                  </td>
		                  
                         
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/TelInfoView/listAll.do'"/>
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
	action="${ctx}/pages/fjy/TelInfoView/listAll.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="telinfoid=${item.telinfoid}&"/>
		</ec:column>
		                    <ec:column property="deptname"  title="企业名称"/>
		                    <mytag:lookupcolumn property="telpp"  title="<%=TelInfoView.ALIAS_TELPP%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SJPP" />
				            <mytag:lookupcolumn property="telxh"  title="<%=TelInfoView.ALIAS_TELXH%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SJXH" />
				            <mytag:lookupcolumn property="telys"  title="<%=TelInfoView.ALIAS_TELYS%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SJYS" />
		                    <ec:column property="jxxlh"  title="<%=TelInfoView.ALIAS_JXXLH%>"/>
				            <mytag:lookupcolumn property="sjlb"  title="<%=TelInfoView.ALIAS_SJLB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_SJLB" />
		                    <ec:column property="sgsj" value="${item.sgsjString}" title="<%=TelInfoView.ALIAS_SGSJ%>"/>
		                    <ec:column property="fullname"  title="<%=TelInfoView.ALIAS_FULLNAME%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TelInfoView/showAll.do?telinfoid=${item.telinfoid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		    <a href="${ctx}/pages/fjy/Telxs/tabshow.do?telinfoids=${item.telinfoid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">销售信息</a>
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
				input_txt.value = "!/pages/fjy/TelInfoView/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/TelInfo/delete.do';
	            form.submit();
	        }
	  }
	  
	   function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>