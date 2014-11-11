<%@page import="com.dyneinfo.zazh.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title><%=SsDictItem.TABLE_ALIAS%>新增</title>
	</head>
	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/pages/SsDictItem/save.do" theme="simple"
			method="post">
			  <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
				<input type="hidden" name="returnUrl"
					value="!/pages/SsDictItem/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
			     <input type="hidden" name="s_dicttypeid" value="${dicttypeid}" id="dicttypeid"/>
			      <input type="hidden" name="dicttypeid" value="${dicttypeid}"/>
				<tr>
					<td colspan="4" class="tb_title">
						<%=SsDictItem.TABLE_ALIAS%>新增
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=SsDictItem.ALIAS_DICTID%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DICTID}" key="dictid"
							value="%{model.dictid}" cssClass="required max-length-128"
							required="true" />
					</td>
					<td class="crosscolor_td">
						<%=SsDictItem.ALIAS_DICTNAME%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DICTNAME}" key="dictname"
							value="%{model.dictname}" cssClass="required max-length-255"
							required="false" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=SsDictItem.ALIAS_STATUS%>
					</td>
					<td>
						<mytag:select property="%{model.status}"
							styleClass="required validate-selection" name="status"
							notEmpty="false" dictName="status" />
					</td>
					<td class="crosscolor_td">
						<%=SsDictItem.ALIAS_SORTNO%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_SORTNO}" key="sortno"
							value="%{model.sortno}" cssClass="validate-integer max-length-10"
							required="false" />
					</td>
				</tr>
				<tr>
					<td colspan="4" class="tb_bottom">
						<input id="submitButton" name="submitButton" type="submit"
							value="提交" />
						<input type="button" value="返回"
							onclick="window.location='${ctx}/pages/SsDictItem/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
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