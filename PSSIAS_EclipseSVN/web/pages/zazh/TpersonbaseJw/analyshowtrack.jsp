<%@page import="com.dyneinfo.zazh.model.*" %>
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
	<title>境外人员轨迹</title>
     <script type="text/javascript" src="<%=request.getContextPath() %>/FusionCharts/FusionCharts.js"></script>
</head>

<body onload="quickSelectInit();init();">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TpersonbaseJw/analylist.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							境外人员信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJw.ALIAS_SURNAME%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.surname}" />
		                  </td>
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJw.ALIAS_NAME%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.name}" />
		                  </td>
		                   <td rowspan="8" width="10%">
		                        <%
		                           String sql = request.getAttribute("sql") == null ? "" : request.getAttribute("sql").toString();
		                           String pathInfo = request.getAttribute("pathInfo") == null ? "" : request.getAttribute("pathInfo").toString();
		                           String imageInfo = "images/spacer.gif";
		                           if(pathInfo != null && !"".equals(pathInfo)){
		                        	   imageInfo = pathInfo + "?sql="+sql;
		                           }
		                         %>
						         <img src="${ctx}/<%=imageInfo %>"
							          onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							           width="130" height="170"  border="0" name="photo">
    
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_CH_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chName}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SEX%>
		                  </td>
			              <td>
		                       <mytag:write  name="sex"  value="${model.sex}"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NATIONALITY%>
		                  </td>
			              <td>
		                           <mytag:write  name="nationality"  value="${model.nationality}"  dictName="DIC_ITEM_COUNTRY"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <mytag:write  name="passT"  value="${model.passT}"  dictName="DIC_ITEM_PASSPORT"/>
		                            <input type="hidden" id="s_passT" name="s_passT" value="<s:property value='%{model.passT}' />" />
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.passNo}" />
		                           <input type="hidden"  id="s_passNo" name="s_passNo" value="<s:property value='%{model.passNo}' />" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_T%>
		                  </td>
			              <td>
			                   <mytag:write  name="visaT"  value="${model.visaT}"  dictName="DIC_ITEM_VISA"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.visaNo}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stayDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <mytag:write  name="qfUnit"  value="${model.qfUnit}"  dictName="DIC_ITEM_VISADEP"/>		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <mytag:write  name="inPort"  value="${model.inPort}"  dictName="DIC_ITEM_PORT"/>
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                    <tr class="crosscolor_tr">
			             <td colspan="4">
	                         <ul id="tabs">
							    <li><a>人员行为轨迹图</a></li>
			                 </ul>			                 
			                       <input type="hidden"  id="starttime" name="starttime" value="<%=request.getAttribute("s_starttime") %>" />
			                       <input type="hidden"  id="endtime" name="endtime" value="<%=request.getAttribute("s_endtime") %>" />
		                  </td>
			             <td class="tb_bottom"  colspan="1">
			                  <input type="button"  value="列表模式"  
			                  onclick="window.location='${ctx}/pages/zazh/TpersonbaseJw/analyshow.do?id=<s:property value="%{model.id}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>	
			             </td>
                   </tr>
  </table>	
</s:form>
   <div id="chartContainer1"></div>
   <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
      <tr>
          <td  class="tb_bottom">
           <input type="button" value="返回" 
           onclick="window.location='${ctx}/pages/zazh/TpersonbaseJw/analylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>			                         
           </td>
       </tr>

	</table>	
</body>

</html>

<script type="text/javascript">
        var strXML = "${strXML}";
	    function init(){
	        var chart = new FusionCharts("FusionCharts/Line.swf", "myChartId" ,"100%","70%","0","1");
	        //xml字符串格式
	        chart.setDataXML(strXML);
	        //xml文件方式
	        //chart.setDataURL("${ctx}/pages/zazh/TpersonbaseJn/date2.xml"); 
	        chart.render("chartContainer1");
	    }
	</script>