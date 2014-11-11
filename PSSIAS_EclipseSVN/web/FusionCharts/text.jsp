<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>从业人员统计 </title>
<script type="text/javascript" src="/fjy/FusionCharts/FusionCharts.js"></script>
<script type="text/javascript">
//var strXML = "${strXML}";
//var strXML = "<graph caption='Hours worked' showNames='1 '> <set name='Tom ' value='32' color='AFD8F8'/><set name='Mary' value='16' color='F6BD0F'/><set name='Jane' value='42' color='8BBA00'/></graph>";

var strXML="<graph xaxisname='所属区域' yaxisname='数量' hovercapbg='DEDEBE' hovercapborder='889E6D' rotateNames='0'  numdivlines='9' baseFontSize='12' divLineColor='CCCCCC' divLineAlpha='80' decimalPrecision='0' showAlternateHGridColor='1' AlternateHGridAlpha='30' plotSpacePercent='20' AlternateHGridColor='CCCCCC' caption='企业信息统计图'  ><categories font='Arial' fontSize='12' fontColor='000000'><category name='沧州市公安局新华分局' /><category name='沧州市公安局运河分局' /><category name='沧县公安局' /><category name='青县公安局' /><category name='东光县公安局' /><category name='海兴县公安局' /><category name='盐山县公安局' /><category name='肃宁县公安局' /><category name='南皮县公安局' /><category name='吴桥县公安局' /><category name='献县公安局' /><category name='孟村回族自治县公安局' /><category name='泊头市公安局' /><category name='任丘市公安局' /><category name='黄骅市公安局' /><category name='河间市公安局' /><category name='河北省沧州市公安局渤海新区分局' /></categories><dataset seriesname='企业总数' color='56B9F9'> <set value='1' /> <set value='0' /> <set value='1' /> <set value='1' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /></dataset><dataset seriesname='营业企业' color='FDC12E'> <set value='1' /> <set value='0' /> <set value='1' /> <set value='1' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /></dataset><dataset seriesname='取缔企业' color='FF0033' > <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /></dataset><dataset seriesname='已安系统' color='33FF66' > <set value='1' /> <set value='0' /> <set value='0' /> <set value='1' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /> <set value='0' /></dataset></graph>"
/*
 * 当用户单击按钮时调用这个方法。
 * 这个方法用来使用新的SWF 文件创建一个新的FusionCharts 实例。
 */
function updateChart(chartSWF){
	//Create another instance of the chart.
	var chart1 = new FusionCharts(chartSWF, "chart1Id", "800", "500");
	chart1.setDataXML(strXML);
	chart1.render("chartDiv");
}
</script> 
</head>
<body bgcolor="#ffffff" onload="updateChart('/fjy/FusionCharts/ScrollColumn2D.swf')">　　
  	<form name='frmUpdate'>
展现方式：
		<input type='button' value='柱状图' onClick="updateChart('/fjy/FusionCharts/Column2D.swf')" name='btnColumn' />
		<input type='button' value='折线图' onClick="updateChart('/fjy/FusionCharts/Line.swf')" name='btnLine' />
		<input type='button' value='饼状图' onClick="updateChart('/fjy/FusionCharts/Pie2D.swf')" name='btnPie' />
	</form>
  	<div id="chartDiv" align="center">对不起，有错误</div>
  	
</body>
</html>