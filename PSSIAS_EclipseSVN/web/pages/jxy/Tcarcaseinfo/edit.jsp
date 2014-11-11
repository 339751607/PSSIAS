<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
			<link rel="stylesheet" href="${ctx}/styles/tab.css" type="text/css"/>
	<style type="text/css">
		.tabSelectUp {
			font-size: 12px;
			cursor: default;
			background: url("${ctx}/images/tab/tab_select.gif");
			color: buttontext;
			padding-left: 2px;
			padding-right: 2px;
			padding-top: 2px;
			text-decoration: underline;
		}
		.tabSelectDown {
			font-size: 12px;
			cursor: default;
			background: url("${ctx}images/tab/tab_unselect.gif");
			color: buttontext;
			padding-left: 2px;
			padding-right: 2px;
			padding-top: 5px;
		}
      </style>
	  <SCRIPT language="JavaScript" src="${ctx}/scripts/tab.js"></SCRIPT>
	  <script type='text/javascript'>	
		function createTabTable(tabId, imgPath) {
			tabId.defaultSelectNo = -1;
			tabId.total = 0;
			tabId.tabContent = new Array();
	
			tabId.select_tab = _tab_select;
			tabId.createTabContent = _create_tab_content;
			tabId.initTab = _init_tab_table;
			tabId.showTabByObj = _show_tab_by_obj;
			tabId.mouseovertab = _mouse_over_tab;
			tabId.mouseouttab = _mouse_out_tab;
			tabId.select_obj = _obj_select;
	
			tabId.imgPath = "${ctx}/images/tab";
			if (imgPath != null)
				tabId.imgPath = imgPath;
		}
      </script>
	<base href="<%=basePath%>">
	<title><%=Tcarcaseinfo.TABLE_ALIAS%>信息修改</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/Tcarcaseinfo/update.do"  theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <input type="hidden" name="enrolid" value="${model.enrolid}">       
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcarcaseinfo.TABLE_ALIAS%>信息修改
				     </td>
		    </tr>
	               <%@ include file="form_include.jsp" %>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="修改" />
	                        <input type="button"  value="删除" onclick="doDel();"/>
	                        <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
					 </td>
			</tr>
	</table>
</s:form>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
  
	 <mytag:tabContent url="${ctx}/jxy/Tcarinfo/view.do"  selected="true"   param="enrolid"  paramValue="${model.enrolid}"   frameBorder="0" tabType="frame" scrolling="auto" title="车辆信息"/>
</mytag:tab>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	 function doDel() {
		    var form = document.forms[0];
			if(!form) return;
	        if (confirm('确定执行[删除]操作?')){
		        form.action = '${ctx}/jxy/Tcarcaseinfo/delete.do';
	            form.submit();
	        }
	  }
</script>

</body>

</html>
