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
	<title>境内人员轨迹</title>
     <script type="text/javascript" src="<%=request.getContextPath() %>/FusionCharts/FusionCharts.js"></script>
</head>

<body onload="quickSelectInit();">

<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/Tcarbase/analylist.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Tcarbase.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"  width="20%">
			                      <%=Tcarbase.ALIAS_CAROWNER%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.carowner}" />
		                  </td>
                          <td class="crosscolor_td"  width="25%">
			                      <%=Tcarbase.ALIAS_CARID%>
		                  </td>
			              <td  width="20%">
		                           <s:property value="%{model.carid}" />
		                  </td>
		                  <td rowspan="5"  width="10%" >
	                        <%
	                           String sql = request.getAttribute("sql") == null ? "" : request.getAttribute("sql").toString();
	                           String pathInfo = request.getAttribute("pathInfo") == null ? "" : request.getAttribute("pathInfo").toString();
	                           String imageInfo = "images/noCar.gif";
	                           if(pathInfo != null && !"".equals(pathInfo)){
	                        	   imageInfo = pathInfo + "?sql="+sql;
	                           }
	                          
	                         %>
					         <img src="${ctx}/<%=imageInfo %>"
						          onerror="this.src='${ctx}/images/noCar.gif'"  alt=""
						           width="200" height="100"  border="0" name="photo">   
	                           
	                     </td> 
                   </tr>
                    <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARTYPE%>
		                  </td>
			              <td>
		                            <mytag:write  name="cartype"  
	         			             value="${model.cartype}" dictName="cllx"/>	
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_COLOR%>
		                  </td>
			              <td>
		                           <mytag:write  name="color" value="${model.color}" dictName="csys"/>
		                  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enginecode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bodycode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_BRAND%>
		                  </td>
			              <td>
		                           <s:property value="%{model.brand}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_CARMODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.carmode}" />
		                  </td>
                   </tr>
		          
		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcarbase.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
	               <tr  class="tb_bottom"  class="crosscolor_tr">
                     <td  colspan="2">
	                         <ul id="tabs">
							    <li><a>车辆行为轨迹图</a></li>
			                 </ul>
	                  </td>
	                   <td  colspan="2">
			                     业务查询时间段：
                                    从 <%=request.getAttribute("s_starttime") %>
			                      到
			                      <%=request.getAttribute("s_endtime") %>
			           </td>
		             <td class="tb_bottom"  colspan="1">
		                   <input type="hidden"  id="starttime" name="starttime" value="<%=request.getAttribute("s_starttime") %>" />
		                   <input type="hidden"  id="endtime" name="endtime" value="<%=request.getAttribute("s_endtime") %>" />
	                  
		                  <input type="button"  value="列表模式"  
		                  onclick="window.location='${ctx}/pages/zazh/Tcarbase/analyshow.do?id=<s:property value="%{model.id}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>	
		             </td>	                  
                   </tr>
	</table>	
</s:form>
<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
   <tr >
   <td>
   <div id="chartContainer1" style="background:#FFF;">
     <table border="0" align="center"  cellPadding="0" cellSpacing="0" >
       ${trackInfo}
     </table>
   </div>
   </td>
   </tr>
   <tr>
       <td  class="tb_bottom">
            	<s:hidden name="id" id="id" value="%{model.id}"/>
              <input type="button" value="返回" 
           onclick="window.location='${ctx}/pages/zazh/Tcarbase/analylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>			    
        </td>
   </tr>
 </table>

</body>

</html>