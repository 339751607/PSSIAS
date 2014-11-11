<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String checkid = "";
		if (request.getParameter("checkid") != null)
			checkid = request.getParameter("checkid");
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
		<title></title>
</head>
<body topmargin="0">
 <script language="javascript">    
    document.title = "检查信息";
 </script>

<s:form action="/pages/fjy/TcpMaintain/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=TcpMaintain.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcard}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_MAINTAINTIME%>
		                  </td>
			              <td colspan="3" >
		                           <s:property value="%{model.maintaintime}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpMaintain.ALIAS_DEMO%>
		                  </td>
			              <td colspan="3" >
		                           <s:property value="%{model.demo}" />
		                  </td>
                   </tr>
                  
	</table>	
</s:form>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
     <mytag:tabContent url="${ctx}/pages/fjy/TcpMaintainInfo/list.do"     param="s_maintainid"  paramValue="<%=checkid%>"   frameBorder="0" tabType="frame" scrolling="auto" title="维护信息"/>
	 
</mytag:tab>
</body>

</html>
<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/fjy/TcpMaintain/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
</script>