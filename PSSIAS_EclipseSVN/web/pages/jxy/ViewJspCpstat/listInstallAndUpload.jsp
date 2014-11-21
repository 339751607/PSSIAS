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
			              <td class="tb_title" colspan="4">安装上传统计</td>
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
			              <td  class="crosscolor_td2" > 
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
			                       <input type="submit"  value="统计" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/ViewJspCpstat/listInstallAndUpload.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<p style="text-align: center;font-size: 12pt; font-weight: bold;margin-top: 10px" >机动车修理业治安管理信息系统安装、数据上传情况通报</p>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/ViewJspCpstat/listInstallAndUpload.do" 
	
	autoIncludeParameters="true"  border="1" style="text-align: center" >
	<ec:exportXls fileName="InstallAndUpload.xls" tooltip="输出Excel文件"/> 
	<ec:row>
		                    <ec:column property="cpname" title="单位"/>
		                    <ec:column property="cpNum"  title="企业数量" />
		                    <ec:column property="jgcs"  title="系统安装数量" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="closeNum"  title="停业数量" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="openNum"  title="营业数量" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="unInstallNum"  title="未安装系统数量"/>
		                    <ec:column property="zaaj"  title="上传信息" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="unInstallPoints"  title="未装系统扣分" />
		                    <ec:column property="unUploadNum"  title="未上传家数扣分" cell="number" format="###,###,##0"  calc="total" calcTitle= "合计"/>
		                    <ec:column property="supervisorPoints"  title="督导扣分"/>
		                    <ec:column property="amountPoints" style="" title="合计扣分" />
		
	</ec:row>
</ec:table>
<p>备注：公安部暗访扣3分，省厅暗访扣2分，市局暗访扣1分</p>
</body>

</html>


<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
