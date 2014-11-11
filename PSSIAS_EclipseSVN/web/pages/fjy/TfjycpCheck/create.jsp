
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>民警检查</title>
</head>
<body>
<%@ include file="/commons/messages.jsp" %>
<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<script language="javascript">     
     var j$ = jQuery.noConflict();     
 </script> 
  <script src="<c:url value="/pages/fjy/TfjycpCheck/check.js"/>" type="text/javascript"></script>
 	<link href="${ctx}/pages/fjy/TfjycpCheck/check.css" type="text/css" rel=stylesheet>
<s:form action="/pages/fjy/TfjycpCheck/save.do" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TfjycpCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>&t_checktype=1" />
	    <input type="hidden" name="idcard" value="${model.idcard}"/>
	    <input type="hidden" name="checktype" value="1"/>
	       <tr>
				<td colspan="4" class="tb_title"> 
							民警检查
			    </td>
		   </tr>
		        <tr class="crosscolor_tr">
		         		<td class="crosscolor_td" width="15%">
			                    被检查企业
		                  </td>
			              <td >
			               		<authz:authentication property="principal.deptName"/>
		                  </td>
		                   <td class="crosscolor_td" width="15%">
			                    被检查人
		                  </td>
			              <td >
			               		<select  name="empcode" id="empcode" Class="max-length-24"></select>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
		         		<td class="crosscolor_td">
			                  检查项目
		                  </td>
			              <td colspan="3">
			                <mytag:select property="%{model.item}"   styleClass="required validate-selection"  name="item"   notEmpty="false"  dictName="D_check_item"/>

		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
		         		<td class="crosscolor_td">
			                 检查结果
		                  </td>
			              <td colspan="4">
			               		<TEXTAREA NAME="content" ROWS="3" COLS="70" class="required max-length-500" id="content"></TEXTAREA>
		                  </td>
                   </tr>
                   	       <tr>
				<td colspan="4" class="tb_bottom">
							<input type="button" id="but" value="添加" />
			    </td>
	        </tr>
                   <tr >

                   	<td colspan="5" >

<table id="tab"  border="0"  cellspacing="0"  cellpadding="0"   style=""  width="100%" >
	<thead>
	<tr>

		<th width="25%" > 检查项目</th>
		<th  width="70%"> 检查结果</th>
		<th  width="5%"> 操作</th>
	</tr>
	</thead>
	<tbody class="tableBody" id="jcjg">

	</tbody>
		
</table>


                   	</td>
     
                   </tr>
	       <tr>
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                      <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TfjycpCheck/listUser.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>&t_checktype=1'"/>
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
	getCyry();
	function getCyry(){
	var url="${ctx}/pages/fjy/Temployee/selectList.do?ajax=true";
	j$.post(url, function(data) {
		j$("#empcode").append(data);
	});
}



</script>

</body>
</html>