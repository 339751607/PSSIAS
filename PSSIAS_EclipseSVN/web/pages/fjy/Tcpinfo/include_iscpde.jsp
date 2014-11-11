<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String IDCardType = (String) DictHelpImpl.getInitData("IDCardType");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>注册</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>

<%
request.setAttribute("mpcode",mpcode);
 %>
 
<s:form action="/pages/fjy/Tcpinfo/saveiscode.do" theme="simple" name="inputForm"   method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <input type="hidden" name="cptype" id="cptype" value="E02"/>
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>新增
			    </td>
		   </tr>
        		<tr class="crosscolor_tr">
                         <td class="crosscolor_td">
		                    <FONT color="red">*</FONT> 软件授权码
	                  </td>
		              <td >
	                            <s:textfield label="%{@vs@ALIAS_AREA}" key="iscode" value="%{model.iscode}"  cssClass="required max-length-50 " required="false" />
	                  </td>
	                 <%
		             	if (IDCardType != null && IDCardType.equals("2")) {
		             %>   
                          <td class="crosscolor_td">
                         	  扫描仪授权码
		                  </td>
			              <td >
		                      <s:textfield label="%{@vs@ALIAS_AREA}" key="orcmmcode" value="%{model.orcmmcode}"  cssClass="max-length-50 " required="false" />
		                  </td>
		                  <%
	               			 } else if (IDCardType != null && (IDCardType.equals("0") || IDCardType.equals("1"))){
		                  %>
	                  <td class="crosscolor_td">
		                    读卡器授权码
	                  </td>
		              <td >
	                            <s:textfield label="%{@vs@ALIAS_AREA}" key="typecode" value="%{model.typecode}"  cssClass=" max-length-50 " required="false" />
	                  </td>
	                  
	                   <%
						  }
					    %>
	           </tr>
              <tr >
				<td colspan="4" class="tb_bottom">
				<input id="cp" name="cp" type="hidden" value="${cpcode}">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>

	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>

</body>
</html>