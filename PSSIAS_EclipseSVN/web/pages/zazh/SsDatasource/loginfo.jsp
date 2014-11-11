<%@page import="com.dyneinfo.zazh.model.*" %>
<%@page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>登录信息</title>
	<style type="text/css">    

        body{ background:#7fd5ff;}
        .k1{  width:100%; height:100%; background:url(${ctx}/images/bg.png) no-repeat;
         background-repeat: no-repeat;
 background-position: center top; 
        }


</style>
	
</head>

<body >
<%@ include file="/commons/messages.jsp" %>
<div  class="k1"> 
<table align="center">
   <tr>
      <td>&nbsp;</td>
   </tr>
 <%
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
  <tr >
       <td height="1" bgcolor="#C7EAFA"></td>
   </tr>
   <tr >
      <td >&nbsp;</td>
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
	   <td  align="center">
	   <b><font color="#A05301">采录数据总数：<%=Total %></font></b>
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
      <td >&nbsp;</td>
   </tr>
 <%
  ArrayList alermList = (ArrayList)request.getAttribute("alermList");
 
 if(alermList != null && alermList.size()>0){
	 int Total = 0;
	 int Total1 = 0;
	 StringBuffer sb = new StringBuffer("");
	 for(int i=0; i < alermList.size(); i++){
		HashMap map =(HashMap) alermList.get(i);
		String name = map.get("called")==null?"":(String)map.get("called");
		int count = (Integer)map.get("incount");
		int count1 = (Integer)map.get("incount1");
		sb.append(name).append("：").append(count).append("&nbsp;/&nbsp;").append(count1).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		Total = Total + count;
		Total1 = Total1 + count1;
	 } 
	
	%>
	 <tr height="30">
	   <td align="center">
	   <b><font color="#A05301">报警总数/未处理数：<%=Total %>/<%=Total1 %></font></b>
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
      <td >&nbsp;</td>
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
	   <td align="center">
	  
	  <b><font color="#A05301"> <s:property value="#request.disp_date" />起未上传数据企业：&nbsp;<%=Total %> 家</font></b>
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
      <td >&nbsp;</td>
   </tr>
   <tr>
      <td>
       系统用户总数&nbsp;：&nbsp;<s:property value="#request.usertotal"/>&nbsp;个，  &nbsp; &nbsp;
       当前在线数&nbsp;：&nbsp;<s:property value="#request.usercount"/>&nbsp;个
      </td>
    </tr>
 </table>
 </div>
</body>

</html>