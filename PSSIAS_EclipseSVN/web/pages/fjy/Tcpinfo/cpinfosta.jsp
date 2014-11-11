<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<%

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String swf=request.getAttribute("scro")!=null&&request.getAttribute("scro")!=""?"ScrollColumn2D.swf":"MSColumn2D.swf";
System.out.print(swf);
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title>企业信息统计</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/FusionCharts/FusionCharts.js"></script>
<script type="text/javascript">
	var strXML = "${strXML}";
	function updateChart(chartSWF){
	//Create another instance of the chart.
	var chart1 = new FusionCharts(chartSWF, "chart1Id", "100%", "85%");
	chart1.setDataXML(strXML);
	chart1.render("chartDiv");
}
function init(){

		updateChart('<%=request.getContextPath() %>/FusionCharts/<%=swf%>');
}
</script> 
</head>

<body bgcolor="#ffffff"  onload="quickSelectInit();init();" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Tcpinfo/cpinfoSta.do"   name="inputForm"  theme="simple" style="display: inline;" method="post">
	       <input type="hidden" name="tx" value=""/>
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">企业信息统计图</td>
		           </tr>
		           
		           
		            <tr class="crosscolor_tr">
			        <td class="crosscolor_td">
			             	 所属分局
		           </td>
			        <td>     	
					<select id="fjid" value="" onchange="getPcs('fjid','pcsid');" >
						<option>请选择...</option>
					</select>
					</td>
					
					<td class="crosscolor_td">
			             	所属派出所
		           </td>
					<td><select id="pcsid" value="">
						<option>请选择...</option>
					</select>

					<input type="hidden" value="${deptseq}" name="s_deptseq" id="s_deptseq" />
                   </tr>
                    <tr>
			              <td class="tb_bottom" colspan="4">
			                     
	                               <input type="button"  value="查询" onclick="query();"/>
	                               <input type="button" value="清空" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
 				
	    </table>
    </s:form>
</div>

<div id="chartDiv" align="center">对不起，有错误</div>
</body>

</html>


<script>

function query(){
	submitValue('fjid','pcsid','','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/Tcpinfo/cpinfoSta.do'
	document.forms[0].submit();
}


setValueSelect('fjid','pcsid','','s_deptseq')

	

function getXML(xmlData){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/VfeijiuwupinSta/listBB.do'
	document.forms[0].submit();
}
</script>