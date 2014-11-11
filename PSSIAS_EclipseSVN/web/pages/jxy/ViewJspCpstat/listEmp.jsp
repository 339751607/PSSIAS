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
	<title><%=ViewJspCpstat.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/ViewJspCpstat/listEmp.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">从业人员统计</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     企业名称
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      企业代码
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		            <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td>
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
		                   <td class="crosscolor_td">
			                    入职时间
		                  </td>
			              <td colspan="1" align="left"> 
			                 <table class="list">
			                   <tr>
			                      <td>
		                           <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                      </td>
			                      <td>从</td>
			                      <td>
			                      <input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> 
			                      </td>
			                      <td>到</td>
			                      <td>
			                      <input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                          </td>
		                       </tr>
		                    </table>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="统计" onclick="getReferenceForm(this).action='${ctx}/jxy/ViewJspCpstat/listEmp.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/ViewJspCpstat/listEmp.do" 
	
	autoIncludeParameters="true" border="1" style="text-align: center">
	<ec:exportXls fileName="empxx.xls" tooltip="输出Excel文件"/> 
	<ec:row>
		
		                    <ec:column property="cpname"  title="<%=ViewJspCpstat.ALIAS_CPNAME%>"/>
		                    <ec:column property="xsaj"  title="高中含以下"/>
		                    <ec:column property="zaaj"  title="高中以上本科含以下"/>
		                    <ec:column property="jgcs"  title="本科以上"/>
		                    <ec:column property="fmffsd"  title="暂住人口"/>
		                    
		
	</ec:row>
</ec:table>

</body>

</html>


<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
