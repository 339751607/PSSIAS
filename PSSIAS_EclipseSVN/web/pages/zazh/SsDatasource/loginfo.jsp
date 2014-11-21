<%@page import="com.dyneinfo.zazh.model.*"%>
<%@page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/commons/messages.jsp"%>
<script type="text/javascript" src="../../../scripts/jscharts.js"></script>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title>登录信息</title>
		<style type="text/css">
body {
	background: #C3E2FF;
	background: url(${ctx}/images/bg.gif);
	background-attachment:fixed;
}

.k1 {
	font: 14px/ 1.5 '微软雅黑';
	font-weight: bold;
	width: 100%;
	height: 100%;
	
	background-repeat: no-repeat;
	background-position: center top;
	
}
</style>

</head>

<body>
<script type="text/javascript">
function strToJson(str){ 
	var json = eval('(' + str + ')'); 
	return json; 
} 

var json1 =  strToJson('${jsonStr1}');
var arr1 = new Array();
for(var i1=0;i1<json1.length;i1++) {
	arr1.push([json1[i1].called, json1[i1].incount]);
}
var sum1 = 0;
for(var j1=0;j1<arr1.length;j1++) {
	sum1 = sum1+arr1[j1][1];
}

var json2 =  strToJson('${jsonStr2}');
var arr2 = new Array();
for(var i2=0;i2<json2.length;i2++) {
	arr2.push([json2[i2].called, json2[i2].incount]);
}
var sum2 = 0;
for(var j2=0;j2<arr2.length;j2++) {
	sum2 = sum2+arr2[j2][1];
}

var json3 =  strToJson('${jsonStr3}');
var arr3 = new Array();
for(var i3=0;i3<json3.length;i3++) {
	arr3.push([json3[i3].called, json3[i3].incount1,json3[i3].incount]);
}
var sum3$1=0;
var sum3$2 = 0;
for(var j3=0;j3<arr3.length;j3++) {
	sum3$1 = sum3$1+arr3[j3][1];
	sum3$2 = sum3$2+arr3[j3][2];
}


var json4 =  strToJson('${jsonStr4}');
var arr4 = new Array();
for(var i4=0;i4<json4.length;i4++) {
	arr4.push([json4[i4].called, json4[i4].incount]);
}
var sum4= 0;
for(var j4=0;j4<arr4.length;j4++) {
	sum4 = sum4+arr4[j4][1];
} 

</script>


		<div class="k1">
		<table align="center">
		        <tr>
					<td height="100px;" align="center" style="font-size: 20px;font-weight: bold; "><!-- font-size: 20px;font-weight: bold; -->
						系统状态一览表
					</td>
				</tr>
		</table>
			<div id="graph1" style="float: left;z-index: 100;">Loading graph...</div>
			<div id="graph2" style="float: left;">Loading graph...</div>
			<div id="graph3"style="float: left;">Loading graph...</div>
			<div id="graph4" style="float: left;">Loading graph...</div>
		</div>
		
		
<script>

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	//多彩颜色 ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9'];

	var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55','#B381C9', '#FA5E1F','#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9', '#FA5E1F','#FDCB3F'];
	var myChart = new JSChart('graph1', 'bar');
	myChart.setDataArray(arr1);
	myChart.colorizeBars(colors);
	myChart.setTitle('采录企业总数：'+sum1);
	myChart.setTitleColor('#b10000');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#b10000');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#b10000');
	myChart.setAxisValuesColor('#b10000');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#b10000');
	myChart.setGrid(false);
	myChart.setSize(1100, 521);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55','#B381C9', '#FA5E1F','#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9', '#FA5E1F','#FDCB3F'];
	var myChart = new JSChart('graph2', 'bar');
	myChart.setDataArray(arr2);
	myChart.colorizeBars(colors);
	myChart.setTitle('采录数据总数：'+sum2);
	myChart.setTitleColor('#b10000');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#b10000');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#b10000');
	myChart.setAxisValuesColor('#b10000');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#b10000');
	myChart.setGrid(false);
	myChart.setSize(1100, 521);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
	
	
	
	var myData = new Array(['旅馆业', 3, 2], ['废旧业', 0, 0], ['典当业', 0, 0], ['散装汽油', 0, 0], ['机修业', 1, 1], ['重点门卫', 0, 0], ['重点门卫', 0, 0]);
	var myChart = new JSChart('graph3', 'bar');
	myChart.setDataArray(arr3);
	//myChart.setTitle('报警总数/未处理数：'+'/'+' ');
	myChart.setTitle('未处理数/报警总数：'+sum3$1+'/'+sum3$2+' ');
	myChart.setTitleColor('#b10000');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisNameFontSize(16);
	myChart.setAxisNameColor('#b10000');
//	myChart.setAxisValuesAngle(30);
	myChart.setAxisValuesColor('#b10000');
	myChart.setAxisColor('#b10000');
	myChart.setAxisWidth(1);
	myChart.setBarValuesColor('#b10000');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingBottom(60);
	myChart.setAxisPaddingLeft(45);
	myChart.setTitleFontSize(11);
	myChart.setBarColor('#FA5E1F', 1);
	myChart.setBarColor('#ffde00', 2);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarOpacity(0.9);
	myChart.setFlagRadius(6);
	myChart.setTooltipPosition('nw');
	myChart.setTooltipOffset(3);
	myChart.setLegendShow(false);
	myChart.setLegendPosition('right top');
	myChart.setLegendForBar(1, '2005');
	myChart.setLegendForBar(2, '2010');
	myChart.setGrid(false);
	myChart.setSize(1100, 521);
	//myChart.setGridColor('#C6C6C6');
	myChart.draw();
	
	function callback() {
		alert('User click');
	}

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55','#B381C9', '#FA5E1F','#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9', '#FA5E1F','#FDCB3F'];
	var myChart = new JSChart('graph4', 'bar');
	myChart.setDataArray(arr4);
	myChart.colorizeBars(colors);
	myChart.setTitle('最近一周内(<s:property value="#request.disp_date"  />-昨日）未上传数据企业：'+sum4);
	myChart.setTitleColor('#b10000');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#b10000');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#b10000');
	myChart.setAxisValuesColor('#b10000');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#b10000');
	myChart.setGrid(false);
	myChart.setSize(1100, 521);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
</script>

</body>
</html>