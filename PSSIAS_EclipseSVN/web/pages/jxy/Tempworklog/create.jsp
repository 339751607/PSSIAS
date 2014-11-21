<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String s_empcode = "";
if (request.getParameter("s_empcode") != null)
	s_empcode = request.getParameter("s_empcode");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tempworklog.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>
<%@page import="com.dyneinfo.jxy.model.*" %>
<s:form action="/pages/jxy/Tempworklog/save.do" theme="simple"  name="inputForm" method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      <input type="hidden" value="<%=s_empcode%>"  name="empcode"  />
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tempworklog.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	               <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>单位名称
		                  </td>
			              <td>
		                          
		                   <input type="text" name="cpname" maxlength="0" value="" id="save_fullname" class="max-length-30"/>
		                            <input type="hidden" name="cpcode" value="" />
		                            
		                            <input name="selectOrg" onclick="selectDept(inputForm,'cpname','cpcode')"  value="选择" type="button">
		                  </td>
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_EMPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.emptype}"   styleClass="required validate-selection"  name="emptype"   notEmpty="false"  dictName="T_DIC_EMPTYPE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tempworklog.ALIAS_INDATE%>
		                  </td>
			              <td>
						           <input value="${model.indate}" onclick="WdatePicker({position:{left:100,top:0},dateFmt:'yyyy-MM-dd'})" id="indate" name="indate"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_LEFTDATE%>
		                  </td>
			              <td>
						           <input value="${model.leftdate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="leftdate" name="leftdate"  maxlength="0" class=" Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Tempworklog.ALIAS_DEMO%>
		                  </td>
			              <td colspan="3">
		                         
		                  
		                           <s:textarea label="%{@vs@ALIAS_DEMO}" rows="4" cols="55"
							key="demo" value="%{model.demo}" cssClass="max-length-200"
							required="false"></s:textarea>
		                  </td>
                   </tr>
	       <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tempworklog/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
	
	  function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=true&maxPatiNum=3&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>

</body>
</html>
