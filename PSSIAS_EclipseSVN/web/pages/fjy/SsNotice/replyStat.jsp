<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel="stylesheet">
	<title>入住情况统计 维护</title>
</head>

<%
	java.util.List presidents = new java.util.ArrayList();
%>

<%
	String tzReplyHotelCount="0", tzNoReplyHotelCount="0";
	String noticeid="";
	
	if (request.getAttribute("tzReplyHotelCount") != null)
		tzReplyHotelCount = (String)request.getAttribute("tzReplyHotelCount");
	if (request.getAttribute("tzNoReplyHotelCount") != null)
		tzNoReplyHotelCount = (String)request.getAttribute("tzNoReplyHotelCount");
	if (request.getAttribute("noticeid") != null)
		noticeid = (String)request.getAttribute("noticeid");
	
	
%>
<%
	java.util.Map president = new java.util.HashMap();
	president.put("replyhotelcount",tzReplyHotelCount);
	president.put("tzNoReplyHotelCount",tzNoReplyHotelCount);
	
	
	presidents.add(president);
	


	
%>
<%
	request.setAttribute("pres", presidents);
%>
<body >
<ec:table 
		items="pres" var="item"
	    action="${ctx}/pages/fjy/SsNotice/tzReplylist.do"
		view="org.extremecomponents.table.view.UserCompactView"
		width="100%"
		style="text-align:center"
		rowsDisplayed="5">
		
		<ec:row>
		  

          <ec:column property="回执企业数量" title="回执企业数量" sortable="false" >
			
			<a href="${ctx}/pages/fjy/SsNotice/listtz.do?noticeid=<%=noticeid%>&">${item.replyhotelcount}</a>&nbsp;&nbsp;&nbsp;
			
		</ec:column>

  <ec:column property="没有回执企业数量" title="没有回执企业数量" sortable="false" >
			
			<a href="${ctx}/pages/fjy/SsNotice/listNoReplytz.do?noticeid=<%=noticeid%>&">${item.tzNoReplyHotelCount}</a>&nbsp;&nbsp;&nbsp;
			
		</ec:column>
		    
		</ec:row>
	</ec:table>
	
		<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
                   <tr>
						  <td colspan="4" class="tb_bottom">
						 
						           <input type="button" value="返回" onclick="javascript:history.go(-1)"/>
	                      </td>
	               </tr>
	</table>


</body>
</html>

 