<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String s_dnid= "";
if (request.getParameter("s_dnid") != null)
	s_dnid = request.getParameter("s_dnid");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tesdnxs.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tesdnxs/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tesdnxs/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      <input type="hidden" value="<%=s_dnid%>"  name="dnid"  />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tesdnxs.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	         <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRXM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRXM}" key="gmrxm" value="%{model.gmrxm}"  cssClass="required max-length-30 validate-chinese" required="true" />
		                  </td>
                  
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRXB%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.gmrxb}"   styleClass="required validate-selection"  name="gmrxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_GMRSFZH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRSFZH}" key="gmrsfzh" value="%{model.gmrsfzh}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                 
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tesdnxs.ALIAS_GMRLXDH%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_GMRLXDH}" key="gmrlxdh" value="%{model.gmrlxdh}"  cssClass="required max-length-30 validate-number" required="true" />
		                  </td>
		             </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_GMRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_GMRJTZZ}" key="gmrjtzz" value="%{model.gmrjtzz}"  cssClass="max-length-100" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tesdnxs.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                         
		                         <s:textarea label="%{@vs@ALIAS_BZ}" rows="6" cols="55"
							key="bz" value="%{model.bz}" cssClass="max-length-200"
							required="false"></s:textarea>
		                         
		                  </td>
                   </tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tesdnxs/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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