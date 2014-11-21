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
	<title><%=Dczydd.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Dczydd/htcxList.do"  theme="simple"  name="form1" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Dczydd.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                         
                          
		                  <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_HTID%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.htid}" size="50" name="s_htid"  />
		                  </td>
                   </tr>
		             <tr class="crosscolor_tr">
		             	<td class="crosscolor_td">
			                    <%=Dczydd.ALIAS_FLAG%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.flag}"  name="s_flag"   notEmpty="false"  dictName="dczylb"/>   
		                  </td>
		           		  <td class="crosscolor_td">
			                    <%=Dczydd.ALIAS_SFSH%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.sfsh}"  name="s_sfsh"   notEmpty="false"  dictName="shiFou"/>   
		                  </td>
                   </tr>
                   	<tr class="crosscolor_tr">
		             <!--  	<td class="crosscolor_td">
			                    <%=Dczydd.ALIAS_FJDM%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.fjdm}"  name="s_fjdm"  onchange="getPcs()"  notEmpty="false"  dictName="ssfj"/>   
		                  </td>
		                  <td class="crosscolor_td">
				                    <%=Dczydd.ALIAS_PCSDM%>
		                  </td>
			              <td id="pcstd">
							<select name="s_pcsdm" id="pcsdm">
								<option value="">请选择...</option>
							</select>
		                  </td>-->
		                  <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td colspan="3">
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
                   </tr>
                   
		           <tr class="crosscolor_tr">
		          		 <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dw}"  name="s_dw"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
			              	<table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_ddrqBegin','s_ddrqEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d31313" name="s_ddrqBegin"  value="${pageRequest.filters.ddrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> 
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d31413" name="s_ddrqEnd"   value="${pageRequest.filters.ddrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>     
		                  </td>
		             </tr>
		              <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwmc}"  name="s_dwmc"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWZJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwzj}"  name="s_dwzj"  />
		                  </td>
                   </tr>
		             <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sqr}"  name="s_sqr"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zjhm}"  name="s_zjhm"  />
		                  </td>
                   </tr>		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Dczydd/htcxList.do'"/>
	                               <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms[0])"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

<div id="mytable"></div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Dczydd/htcxList.do" autoIncludeParameters="true">
	<ec:row>
		
		                     <ec:column property="htid"  title="<%=Dczydd.ALIAS_HTID%>"/>
		                      <ec:column property="dw"  title="<%=Dczydd.ALIAS_DW%>"/>
		                    <ec:column property="sqr"  title="<%=Dczydd.ALIAS_SQR%>"/>
		                    <mytag:lookupcolumn property="ddlx"  title="<%=Dczydd.ALIAS_DDLX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="ddlb" />
		                    <ec:column property="gzdw"  title="<%=Dczydd.ALIAS_GZDW%>"/>
		                    <ec:column property="lxdh"  title="<%=Dczydd.ALIAS_LXDH%>"/>
		                    <ec:column property="ddqx"  title="<%=Dczydd.ALIAS_DDQX%>"/>
		                    <ec:column property="dwmc"  title="<%=Dczydd.ALIAS_DWMC%>"/>
		                    <ec:column property="dwzj"  title="<%=Dczydd.ALIAS_DWZJ%>"/>
		                    
				            <ec:column property="ddrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Dczydd.ALIAS_DDRQ%>"/>
							<mytag:lookupcolumn property="sfsh"  title="<%=Dczydd.ALIAS_SFSH%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="shiFou" />
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			
			<a href="${ctx}/pages/pmdd/Dczydd/htcxShow.do?dnumber=${item.dnumber}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>
<script language="javascript">
//getPcs();
//function getPcs(){

//	var fjbm=form1.s_fjdm.value;
//	var pcsbm='${pageRequest.filters.pcsdm}';
//	var url="${ctx}/pages/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
//	$.post(url, function(data) {
//		$("#pcstd").html("<select name='s_pcsdm' id='pcsdm'><option value=''>请选择...</option></select>");
//		$("#pcsdm").append(data);
//	});
//}
</script>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
</body>

</html>
