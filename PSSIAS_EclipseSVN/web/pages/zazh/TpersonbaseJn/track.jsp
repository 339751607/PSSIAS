
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>新增</title>
	<script src="<c:url value="FusionCharts/FusionCharts.js"/>" type="text/javascript"></script>
</head>
<body onload="init();">
	<div id="chartContainer1"></div>
<script type="text/javascript">
	    function init(){
	        var chart = new FusionCharts("FusionCharts/Line.swf", "myChartId" ,"600","500","0","1");
	        //chart.setDataURL("${ctx}/pages/zazh/TpersonbaseJn/date2.xml");
	        chart.setDataXML("<graph caption='Monthly Unit Sales' xAxisName='Month' yAxisName='Units'"
                             +" showNames='1' decimalPrecision='0' formatNumberScale='0' showBorder='1'> "
                             +" <set label='Jan' value='462' /> "
                             +" <set label='Feb' value='857' /> "
                             +" <set label='Mar' value='671' /> " 
                             +" <set label='Apr' value='494' /> "
                             +" <set label='May' value='761' /> " 
                             +" <set label='Jun' value='960' /> "
                             +" <set label='Jul' value='629' /> "
                             +" <set label='Aug' value='622' /> "
                             +" <set label='Sep' value='376' link='javascript:alert(1222)' /> "
                             +" <set label='Oct' value='494' /> "
                             +" <set label='Nov' value='761' /> "
                             +" <set label='Dec' value='960' /> "
                             +" </graph> "); 
	        
	        chart.render("chartContainer1");
	    }
	</script>

</body>
</html>