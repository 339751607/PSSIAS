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
    <s:form action="/pages/jxy/ViewJspCpstat/listDataUpload.do"  name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">数据上传统计</td>
		           </tr>

		            <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td  class="crosscolor_td2">
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
		                   <td class="crosscolor_td">
			                    上传日期
		                  </td>
			              <td  class="crosscolor_td2"> 
			                 <table class="list">
			                   <tr>
			                      <td>
		                           <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                      </td>   
			                      <td>从</td>
			                      <td>
			                        <input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/>
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
			                       <input type="submit"  value="统计" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/ViewJspCpstat/listDataUpload.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/ViewJspCpstat/listDataUpload.do" 
	
	autoIncludeParameters="true" border="1" style="text-align: center">
	<ec:exportXls fileName="empxx.xls" tooltip="输出Excel文件"/> 
	<ec:row>
		
		                    <ec:column property="cpname"  title="部门名称"/>
		                    
		                    
		                    <ec:column property="jgcs"  title="企业总数" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="xsaj"  title="已上传企业 " cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="zaaj"  title="上传数据总数" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                   
		                    
		
	</ec:row>
</ec:table>

</body>

</html>


<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
