<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String  picCount ="";
 if ( request.getAttribute("picCount") != null)
     picCount = (String)request.getAttribute("picCount");
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

<s:form action="/pages/fjy/Tfeijiuwupin/list.do" method="get" theme="simple">
	<s:hidden name="wupinxh" id="wupinxh" value="%{model.wupinxh}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	              <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tfeijiuwupin.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		 <tr class="crosscolor_tr">
                         <!--   <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WUPINMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wupinmc}" />
		                  </td>-->
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WUPINLB%>
		                  </td>
			              <td colspan="3">
			                       <mytag:write property="%{model.wupinlb}"   name="wupinlb"  notEmpty="true"  dictName="T_DIC_WUPINLB"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shougourq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shougouryXm}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushoury}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.chushourenxb}"   name="chushourenxb"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourensfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_BEIZHU%>
		                  </td>
			              <td>
		                           <s:property value="%{model.beizhu}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourenlxdh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_ISKEYI%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.iskeyi}"   name="iskeyi"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CSRLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.csrlxdh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbrsfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_JBRLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbrlxdh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPSL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgwpsl}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPGG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgwpgg}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGRLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgrlxdh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPYS%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.wpys}"   name="wpys"  notEmpty="true"  dictName="T_DIC_SJYS"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPPP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wppp}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPXZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpxz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPSF%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpsf}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPDX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpdx}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPZL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpzl}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPBZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpbz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPTZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wptz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPCD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpcd}" />
		                  </td>
                          <td class="crosscolor_td">
			                     企业名称
		                  </td>
			              <td>
		                           <s:property value="%{model.deptname}" />
		                  </td>
                   </tr>
		         
		          
	</table>	
</s:form>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
     <mytag:tabContent url="${ctx}/pages/fjy/TfeijiuwupinKeyi/list.do"     param="s_wupinxh"  paramValue="${model.wupinxh}"   frameBorder="0" tabType="frame" scrolling="auto" title="附加信息"/>
</mytag:tab>
</body>

</html>

<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/fjy/Tfeijiuwupin/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
</script>