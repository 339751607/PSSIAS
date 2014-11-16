<%@page import="com.dyneinfo.zazh.model.*"%>
<%@page import="java.util.*"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/commons/messages.jsp"%>
<script type="text/javascript" src="../../../scripts/jscharts.js"></script>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
<%@ include file="/commons/meta.jsp"%>
<base href="<%=basePath%>">
<title>登录信息</title>
<style type="text/css">
body {
	background: #7fd5ff;
}

.k1 {
	width: 100%;
	height: 100%;
	background: url(${ctx}/images/bg.png) no-repeat;
	background-repeat: no-repeat;
	background-position: center top;
}
</style>

</head>

<body>

	<%

ArrayList alermList = (ArrayList)request.getAttribute("alermList");
int baojingTotal = 0;
int weichuliTotal1 = 0;
if(alermList != null && alermList.size()>0){
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < alermList.size(); i++){
		HashMap map =(HashMap) alermList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		int count1 = (Integer)map.get("incount1");
		sb.append(name).append("：").append(count).append("&nbsp;/&nbsp;").append(count1).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		baojingTotal = baojingTotal + count;
		weichuliTotal1 = weichuliTotal1 + count1;
	 } 
}
%>
	<input type="hidden" id="inputTxtTotal" value="<%=baojingTotal %>" />
	<input type="hidden" id="inputTxtTotal1" value="<%=weichuliTotal1 %>" />
	
	
	

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

<div id="graph1" style="float: left;">Loading graph...</div>
<div id="graph2" style="float: left;">Loading graph...</div>
<div id="graph3"style="float: left;">Loading...</div>
<div id="graph4" style="float: left;">Loading graph...</div>
<script>

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	//var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9'];
	var colors = ['#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99'];
	var myChart = new JSChart('graph1', 'bar');
	myChart.setDataArray(arr1);
	myChart.colorizeBars(colors);
	myChart.setTitle('采录企业总数：'+sum1);
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#c6c6c6');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#9a9a9a');
	myChart.setAxisValuesColor('#939393');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#737373');
	myChart.setGrid(false);
	myChart.setSize(616, 321);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
</script>


<script>

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	//var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9'];
	var colors = ['#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99'];
	var myChart = new JSChart('graph2', 'bar');
	myChart.setDataArray(arr2);
	myChart.colorizeBars(colors);
	myChart.setTitle('采录数据总数：'+sum2);
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#c6c6c6');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#9a9a9a');
	myChart.setAxisValuesColor('#939393');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#737373');
	myChart.setGrid(false);
	myChart.setSize(616, 321);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
</script>
	
	
	
	<script type="text/javascript">
	
	
	
	var myData = new Array(['旅馆业', 3, 2], ['废旧业', 0, 0], ['典当业', 0, 0], ['散装汽油', 0, 0], ['机修业', 1, 1], ['重点门卫', 0, 0], ['重点门卫', 0, 0]);
	var myChart = new JSChart('graph3', 'bar');
	myChart.setDataArray(arr3);
	//myChart.setTitle('报警总数/未处理数：'+'/'+' ');
	myChart.setTitle('未处理数/报警总数：'+sum3$1+'/'+sum3$2+' ');
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisNameFontSize(16);
	myChart.setAxisNameColor('#999');
//	myChart.setAxisValuesAngle(30);
	myChart.setAxisValuesColor('#777');
	myChart.setAxisColor('#B5B5B5');
	myChart.setAxisWidth(1);
	myChart.setBarValuesColor('#2F6D99');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingBottom(60);
	myChart.setAxisPaddingLeft(45);
	myChart.setTitleFontSize(11);
	myChart.setBarColor('#2D6B96', 1);
	myChart.setBarColor('#9CCEF0', 2);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarOpacity(0.9);
	myChart.setFlagRadius(6);
	//myChart.setTooltip(['旅馆业', 'Click me', 1], callback);   可以在图片上添加点击事件
	myChart.setTooltipPosition('nw');
	myChart.setTooltipOffset(3);
	myChart.setLegendShow(false);
	myChart.setLegendPosition('right top');
	myChart.setLegendForBar(1, '2005');
	myChart.setLegendForBar(2, '2010');
	myChart.setSize(616, 321);
	myChart.setGridColor('#C6C6C6');
	myChart.draw();
	
	function callback() {
		alert('User click');
	}
</script>


<script>

	var myData = new Array(['U.S.A.', 69.5], ['Canada', 2.8], ['Japan & SE.Asia', 5.6], ['Aus. & NZ.', 2.8], ['E.U.', 14.6], ['Others Europe', 2.7], ['Others', 1.9]);
	//var colors = ['#FA5E1F', '#FDCB3F', '#71D743', '#D23333', '#BAE73F', '#AB7B55', '#B381C9'];
	var colors = ['#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99', '#2F6D99'];
	var myChart = new JSChart('graph4', 'bar');
	myChart.setDataArray(arr4);
	myChart.colorizeBars(colors);
	myChart.setTitle('<s:property value="#request.disp_date"  />起未上传数据企业：'+sum4);
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisColor('#c6c6c6');
	myChart.setAxisWidth(1);
	myChart.setAxisNameColor('#9a9a9a');
	myChart.setAxisValuesColor('#939393');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingLeft(50);
	myChart.setAxisPaddingBottom(60);
	myChart.setTextPaddingBottom(20);
	myChart.setTextPaddingLeft(15);
	myChart.setTitleFontSize(11);
	myChart.setBarBorderWidth(0);
	myChart.setBarSpacingRatio(50);
	myChart.setBarValuesColor('#737373');
	myChart.setGrid(false);
	myChart.setSize(616, 321);
	myChart.setBackgroundImage('chart_bg.jpg');
	myChart.draw();
</script>

		<%--
	<div class="k1" style="position: relative;">
		<table align="center">
			<tr>
				<td>&nbsp;</td>
			</tr>
	
  ArrayList compList = (ArrayList)request.getAttribute("compList");
 
 if(compList != null && compList.size()>0){
	 int Total = 0;
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < compList.size(); i++){
		HashMap map =(HashMap) compList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		
		sb.append(name).append("：").append(count).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		Total = Total + count;
	 } 
	
	%>
	<tr height="30">
	   <td align="center">
	   <b ><font color="#A05301">采录企业总数：&nbsp;<%=Total %></font></b>
	   </td>
	</tr>
	<tr height="30">
	   <td >    
	   <%=sb.toString() %>
	  </td>
	</tr>
	<%
 }
 %>
			<tr>
				<td height="1" bgcolor="#C7EAFA"></td>
			</tr>

			<%
  ArrayList dataList = (ArrayList)request.getAttribute("dataList");
 
 if(dataList != null && dataList.size()>0){
	 int Total = 0;
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < dataList.size(); i++){
		HashMap map =(HashMap) dataList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		
		sb.append(name).append("：").append(count).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		Total = Total + count;
	 } 
	
	%>
			<tr height="30">
				<td align="center"><b><font color="#A05301">采录数据总数：<%=Total %></font></b>
				</td>
			</tr>
			<tr height="30">
				<td><%=sb.toString() %></td>
			</tr>
			<%
 }
 %>
			<tr>
				<td height="1" bgcolor="#C7EAFA"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<%
  //ArrayList alermList = (ArrayList)request.getAttribute("alermList");
 
 if(alermList != null && alermList.size()>0){
	 //int Total = 0;
	 //int Total1 = 0;
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < alermList.size(); i++){
		HashMap map =(HashMap) alermList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		int count1 = (Integer)map.get("incount1");
		sb.append(name).append("：").append(count).append("&nbsp;/&nbsp;").append(count1).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		//Total = Total + count;
		//Total1 = Total1 + count1;
	 } 
	
	%>
	<input type="hidden" id="inputTxtTotal" value="<%=baojingTotal %>" />
	   <input type="hidden" id="inputTxtTotal1" value="<%=weichuliTotal1 %>" />
	 <tr height="30">
	   <td align="center">
	   
	   <b><font color="#A05301">报警总数/未处理数：<%=baojingTotal %>/<%=weichuliTotal1 %></font></b>
	   </td>
	</tr>
	<tr height="30">
	   <td> 
	   <%=sb.toString() %>
	   </td>
	</tr>
	<%
 }
 %>
			<tr>
				<td height="1" bgcolor="#C7EAFA"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<%
  ArrayList uploadList = (ArrayList)request.getAttribute("uploadList");
 
 if(uploadList != null && uploadList.size()>0){
	 int Total = 0;
	
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < uploadList.size(); i++){
		HashMap map =(HashMap) uploadList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		sb.append(name).append("：").append(count).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		Total = Total + count;
		
	 } 
	
	%>
			<tr height="30">
				<td align="center"><b><font color="#A05301"> <s:property
								value="#request.disp_date" />起未上传数据企业：&nbsp;<%=Total %> 家
					</font></b></td>
			</tr>
			<tr height="30">
				<td><%=sb.toString() %></td>
			</tr>
			<%
 }
 %>
			<tr>
				<td height="1" bgcolor="#C7EAFA"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>系统用户总数&nbsp;：&nbsp;<s:property value="#request.usertotal" />&nbsp;个，
					&nbsp; &nbsp; 当前在线数&nbsp;：&nbsp;<s:property
						value="#request.usercount" />&nbsp;个
				</td>
			</tr>
		</table>
	</div>
	--%>
</body>

</html>