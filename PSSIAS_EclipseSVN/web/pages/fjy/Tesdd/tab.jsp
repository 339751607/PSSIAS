<%@page import="com.dyneinfo.fjy.model.*" %>
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
		<title></title>
</head>
<body topmargin="0">
 <script language="javascript">    
    document.title = "销售信息";
 </script>

<s:form action="/pages/fjy/Tesdd/list.do" method="get" theme="simple">
	<s:hidden name="dnid" id="dnid" value="%{model.dnid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tesdd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.ddlx}"   name="ddlx"  notEmpty="true"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dnpp}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dnxh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zbh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yph}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zc}" />
		                  </td>
                   </tr>
                   
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.macdz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_GMSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmsj}" />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushoury}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.chushourenxb}"   name="chushourenxb"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourensfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourenlxdh}" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DQSJH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dqsjh}" />
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.csrdh}" />
		                  </td>
                         
                   </tr>
		          
                  
		          
		          
                    <tr class="crosscolor_tr">
                         
                         
			              <td>
		                           <s:property value="%{model.jbrXm}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                        
                   </tr>
                   
   
	</table>	
</s:form>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
     <mytag:tabContent url="${ctx}/pages/fjy/Tesdnxs/list.do"     param="s_dnid"  paramValue="${model.dnid}"   frameBorder="0" tabType="frame" scrolling="auto" title="销售信息"/>
</mytag:tab>
</body>

</html>

<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/fjy/Tesdd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
</script>