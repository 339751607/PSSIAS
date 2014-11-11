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
    <s:form action="/pages/pmdd/Clzydd/htcxList.do"  theme="simple" name="form1" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Clzydd.TABLE_ALIAS%>查询</td>
		           </tr>
		                    <tr class="crosscolor_tr">
                         
                          
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.htid}" size="50"   name="s_htid"  />
		                  </td>
                   </tr>
		       	 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LB%>
		                  </td>
			              <td>
		                             <mytag:select  value="${pageRequest.filters.lb}"  name="s_lb"   notEmpty="false"  dictName="clzylb"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td>
		                        <mytag:select  value="${pageRequest.filters.sfsh}"  name="s_sfsh"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
		             	<!--  <td class="crosscolor_td">
			                    <%=Clzydd.ALIAS_FJDM%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.fjdm}"  name="s_fjdm"  onchange="getPcs()"  notEmpty="false"  dictName="ssfj"/>   
		                  </td>
		                  <td class="crosscolor_td">
				                    <%=Clzydd.ALIAS_PCSDM%>
		                  </td>
			              <td id="pcstd">
							<select name="s_pcsdm" id="pcsdm">
								<option value="">请选择...</option>
							</select>
		                  </td>
		                  -->
		                    <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td >
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                            <input value="${pageRequest.filters.sqr}"  name="s_sqr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMC%>
		                  </td>
			              <td>
		                            <input value="${pageRequest.filters.dwmc}"  name="s_dwmc"  />
		                  </td>
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
			                      <%=Clzydd.ALIAS_CJHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjhm}"  name="s_cjhm"  />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CLXH%>
		                  </td>
			              <td>
		                        <input value="${pageRequest.filters.clxh}"  name="s_clxh"  />
		                  </td>
                   </tr>
                  
                   	<tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Clzydd/htcxList.do'"/>
	                              <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/Clzydd/htcxList.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="htid"  title="<%=Clzydd.ALIAS_HTID%>"/>
		                     <ec:column property="dwmc"  title="<%=Clzydd.ALIAS_DWMC%>"/>
		                    <ec:column property="sqr"  title="<%=Clzydd.ALIAS_SQR%>"/>
		                    <ec:column property="zjhm"  title="<%=Clzydd.ALIAS_ZJHM%>"/>
		                    <ec:column property="cphm"  title="<%=Clzydd.ALIAS_CPHM%>"/>
		                    <ec:column property="czmc"  title="<%=Clzydd.ALIAS_CZMC%>"/>
		                    <ec:column property="fdjh"  title="<%=Clzydd.ALIAS_FDJH%>"/>
		                    <ec:column property="sccj"  title="<%=Clzydd.ALIAS_SCCJ%>"/>
		                     <mytag:lookupcolumn property="csys"  title="<%=Clzydd.ALIAS_CSYS%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="clys" />
				            <ec:column property="ddrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Clzydd.ALIAS_DDRQ%>"/>
				           <mytag:lookupcolumn property="sfsh"  title="<%=Clzydd.ALIAS_SFSH%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="shiFou" />
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			
			<a href="${ctx}/pages/pmdd/Clzydd/htcxShow.do?dnumber=${item.dnumber}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>


<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
</body>

</html>

