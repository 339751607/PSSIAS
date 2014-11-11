<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String id="";
if(request.getAttribute("id") != null)
   id = (String)request.getAttribute("id");
%>

<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsDictItem.TABLE_ALIAS%>查询</title>
</head>

<body>


<s:form action="/pages/SsDictItem/list.do" name="queryForms"  target="result" method="post">	

	<table class="formTable">
	<input  type="hidden" name="s_dicttypeid" value="<%=id%>" />
	</table>
	<IFRAME height="100%" name="result" align="center" width="100%" frameBorder="0" marginHeight="0" scrolling="auto" marginWidth="0" ></IFRAME>
	
	
</s:form>	
			
</body>

</html>
<script type='text/javascript'>
     
	   function doSubmit(){
            document.queryForms.submit();
       }
       doSubmit();
</script>