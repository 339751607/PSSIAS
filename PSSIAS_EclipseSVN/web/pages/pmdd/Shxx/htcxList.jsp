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
	<title><%=Shxx.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Shxx/htcxList.do"  theme="simple" name="form1" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="6"><%=Shxx.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shrxm}"  name="s_shrxm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.shrsfzhm}"  name="s_shrsfzhm"  />
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
		             	<!--  <td class="crosscolor_td">
			                    <%=Shxx.ALIAS_FJDM%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.fjdm}"  name="s_fjdm"  onchange="getPcs()"  notEmpty="false"  dictName="ssfj"/>   
		                  </td>
		                  <td class="crosscolor_td">
				                    <%=Shxx.ALIAS_PCSDM%>
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
			                      <%=Shxx.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.htid}"  name="s_htid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td colspan="3">
			              <table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_shrqBegin','s_shrqEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d3137" name="s_shrqBegin"  value="${pageRequest.filters.shrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3147\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d3147" name="s_shrqEnd"   value="${pageRequest.filters.shrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
			              			</td>
			              		</tr>
			              	</table> 
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="6">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Shxx/htcxList.do'"/>
			             		 <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Shxx/htcxList.do" autoIncludeParameters="true">
	<ec:row>
	  						<ec:column property="dwmc"  title="<%=Shxx.ALIAS_DWMC%>"/>
		                    <ec:column property="htid"  title="<%=Shxx.ALIAS_HTID%>"/>
		                    <ec:column property="shrxm"  title="<%=Shxx.ALIAS_SHRXM%>"/>
		                    <ec:column property="shrsfzhm"  title="<%=Shxx.ALIAS_SHRSFZHM%>"/>
				            <ec:column property="shrq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss" cell="date"  title="<%=Shxx.ALIAS_SHRQ%>"/>
				            <ec:column property="lrrq"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Shxx.ALIAS_LRRQ%>"/>
		                   <ec:column property="tdr"  title="<%=Shxx.ALIAS_TDR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Shxx/htcxShow.do?xh=${item.xh}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
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