<%@page import="com.dyneinfo.jxy.model.*" %>
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

<s:form action="/pages/jxy/Temployee/list.do" method="get" theme="simple">
	<s:hidden name="cpempcode" id="cpempcode" value="%{model.cpempcode}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Temployee.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sex}"   name="sex"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
		                  <td rowspan="12" width="18%" align="center" >
						      <%if(picCount != null && picCount.equals("1")) { %>
					             <a  href="#"> <img src='${ctx}/pages/jxy/Temployee/showPic.do?xh=<s:property value="%{model.cpempcode}" />'  height="126" alt="" width="102" border="0" name="photo"> </a>	
					           <% } else {%>
					             <a  href="#"> <IMG src="${ctx}/images/spacer.gif" height="126" alt="" width="102" border="0" name="photo"> </a>
					           <%} %>
					       </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.personid}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.birth}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alias}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.folk}"   name="folk"  notEmpty="true"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.nativeplace}"   name="nativeplace"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.polityvisage}"   name="polityvisage"  notEmpty="true"  dictName="T_DIC_POLITYVISAGE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.schoolage}"   name="schoolage"  notEmpty="true"  dictName="T_DIC_SCHOOLAGE"/>
		                  </td>
                          <td class="crosscolor_td">
			                    
		                  </td>
			              <td>
			                       <mytag:write property="%{model.hyzh}"   name="hyzh"  notEmpty="true"  dictName="T_DIC_HYZK"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stature}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.weight}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.posture}"   name="posture"  notEmpty="true"  dictName="T_DIC_SHAPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.npcode}"   name="npcode"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.address}" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.npaddress}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.cyrjzt}"   name="cyrjzt"  notEmpty="true"  dictName="T_DIC_CYRJZT"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.temporarycode}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.nowadress}" />
		                  </td>
                   </tr>
		         
		          
	</table>	
</s:form>
<mytag:tab id="orgInfo"  width="100%" height="100%"   >
     <mytag:tabContent url="${ctx}/pages/jxy/Tlinkmaninfo/list.do"     param="s_empcode"  paramValue="${model.cpempcode}"   frameBorder="0" tabType="frame" scrolling="auto" title="应急联系人"/>
	 <mytag:tabContent url="${ctx}/pages/jxy/Tempworklog/list.do"  selected="true"   param="s_empcode"  paramValue="${model.cpempcode}"   frameBorder="0" tabType="frame" scrolling="auto" title="从业记录"/>
</mytag:tab>
</body>

</html>
<script>
	
    function doBack(){
    	var url="";
    	url =  "${ctx}/pages/jxy/Temployee/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
    	location.href = url;
    }
</script>
