<%@page import="com.dyneinfo.jxy.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

String carowner = "";
if(request.getAttribute("carowner") != null)
	carowner =(String)request.getAttribute("carowner");
String cardidName = "";
if(request.getAttribute("cardidName") != null)
	cardidName =(String)request.getAttribute("cardidName");
String cartypeName = "";
if(request.getAttribute("cartypeName") != null)
	cartypeName =(String)request.getAttribute("cartypeName");
String brand = "";
if(request.getAttribute("brand") != null)
	brand =(String)request.getAttribute("brand");
String enginecode = "";
if(request.getAttribute("enginecode") != null)
	enginecode =(String)request.getAttribute("enginecode");
String bodycode = "";
if(request.getAttribute("bodycode") != null)
	bodycode =(String)request.getAttribute("bodycode");
String color1Name = "";
if(request.getAttribute("color1Name") != null)
	color1Name =(String)request.getAttribute("color1Name");
String color2Name = "";
if(request.getAttribute("color2Name") != null)
	color2Name =(String)request.getAttribute("color2Name");
String color3Name = "";
if(request.getAttribute("color3Name") != null)
	color3Name =(String)request.getAttribute("color3Name");
String deliname = "";
if(request.getAttribute("deliname") != null)
	deliname =(String)request.getAttribute("deliname");

String delicredcode = "";
if(request.getAttribute("delicredcode") != null)
	delicredcode =(String)request.getAttribute("delicredcode");

String delitelephone = "";
if(request.getAttribute("delitelephone") != null)
	delitelephone =(String)request.getAttribute("delitelephone");

String recename = "";
if(request.getAttribute("recename") != null)
	recename =(String)request.getAttribute("recename");

String recetime = "";
if(request.getAttribute("recetime") != null)
	recetime =(String)request.getAttribute("recetime");

String takeoffname = "";
if(request.getAttribute("takeoffname") != null)
	takeoffname =(String)request.getAttribute("takeoffname");

String tocredcode = "";
if(request.getAttribute("tocredcode") != null)
	tocredcode =(String)request.getAttribute("tocredcode");

String serveritemName = "";
if(request.getAttribute("serveritemName") != null)
	serveritemName =(String)request.getAttribute("serveritemName");

String totime = "";
if(request.getAttribute("totime") != null)
	totime =(String)request.getAttribute("totime");

String demo = "";
if(request.getAttribute("demo") != null)
	demo =(String)request.getAttribute("demo");


%>
<html>

	<head>
		<script language="javascript" src="${ctx}/pages/jxy/Tcarinfo/CheckActivX.js"></script>
	    <object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	    </object>
		<%@ include file="/commons/meta.jsp"%>
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
		<title><%=Tcarinfo.TABLE_ALIAS%></title>
	</head>

	<body>
		<%@ include file="/commons/messages.jsp"%>
        
        
		<s:form action="/jxy/Tcarinfo/list.do"  method="get" theme="simple">
			<s:hidden name="enrolid" id="enrolid" value="%{model.enrolid}" />
			<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
				<tr>
					<td colspan="5" class="tb_title">
						<%=Tcarinfo.TABLE_ALIAS%>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td colspan="4">
						<b>车辆信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b><%=Tcarinfo.ALIAS_CARPICTURE%></b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CAROWNER%>

					</td>
					<td>
						<s:property value="%{model.carowner}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARID%>
					</td>
					<td>
						<mytag:write property="%{model.carid1}" name="carid1"
							notEmpty="true" dictName="cpht" />
							<s:property value="%{model.carid}" />
							
					</td>
										<td rowspan="5"  align="center" width="25%">
					     
									<img
							src='${ctx}/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />'
							onerror="this.src='${ctx}/images/noCar.gif'"  alt=""
							height="100" width="200" border="0" name="photo">
								
						
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_CARTYPE%>
					</td>
					<td>
						<mytag:write property="%{model.cartype}" name="carid1"
							notEmpty="true" dictName="cllx" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BRAND%>
					</td>
					<td>
						<s:property value="%{model.brand}" />

					</td>
					
				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_ENGINECODE%>
					</td>
					<td>
						<s:property value="%{model.enginecode}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BODYCODE%>
					</td>
					<td>
						<s:property value="%{model.bodycode}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
				  <td class="crosscolor_td">
			                    <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			              <td>
			              <s:property value="%{model.clsbcode}"/>
		                         		                  </td>
		                         		                  <td></td>
		                         		                  <td></td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td" colspan="4">
						<%=Tcarinfo.ALIAS_COLOR%>：&nbsp;
						<mytag:write property="%{model.color1}" name="color1"
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第一辅色：&nbsp;
						<mytag:write property="%{model.color2}" name="color2"
							notEmpty="true" dictName="csys" />
						&nbsp;&nbsp;&nbsp;&nbsp;第二辅色：&nbsp;
						<mytag:write property="%{model.color3}" name="color3"
							notEmpty="true" dictName="csys" />
					</td>
				</tr >
				<tr class="crosscolor_tr">
					<td colspan="4">
						<b>车辆交接信息</b>
					</td>
					<td></td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELINAME%>
					</td>
					<td>
						<s:property value="%{model.deliname}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELICREDCODE%>
					</td>
					<td colspan="2">
					<s:property value="%{model.delicredcode}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DELITELEPHONE%>
					</td>
					<td colspan="4">
					<s:property value="%{model.delitelephone}" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECENAME%>
					</td>
					<td id="rece" >
	                <s:property value="%{model.recename}" />
		            </td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECETIME%>
					</td>
					<td colspan="2">
					<s:property value="%{model.recetime}" />
				</tr>
				<tr class="crosscolor_tr">
				         <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TAKEOFFNAME%>
		                  </td>
			              <td>
			              <s:property value="%{model.takeoffname}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcarreturn.ALIAS_TOCREDCODE%>
		                  </td>
			              <td colspan="2">
			               <s:property value="%{model.tocredcode}" />
		                  </td>
		         </tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_SERVERITEM%>
					</td>
					<td>
					 <s:property value="%{model.serveritem}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_TOTIME%>
					</td>
					<td colspan="2">
					 <s:property value="%{model.totime}" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DEMO%>
					</td>
					<td colspan="4">
					 <s:property value="%{model.demo}" />
					</td>
				</tr>
				
			</table>
			
		</s:form>


	</body>
	<script>
	$(document).ready(function(){  
		//    CheckLodop();
	}); 
	
   	getPcs();
	function getPcs(){
	var recename='${model.recename}';
	var url="${ctx}/jxy/Dictitem/getEmployeeList.do?ajax=true&show=true&recename="+recename;
	$.post(url, function(data) {
		$("#rece").html(data);
		$("#receprint").html(data);
	});
	}
	
    function myPrint() {		
		var strFormHtml="<body>"+document.getElementById("form1").innerHTML+"</body>";
		
		LODOP.ADD_PRINT_HTM(-2,0,796,1125,strFormHtml);
		LODOP.PRINT();		
	};  
	
	function myPreview() {		
		var strFormHtml="<body>"+document.getElementById("form1").innerHTML+"</body>";
		
		LODOP.ADD_PRINT_HTM(-2,0,796,1125,strFormHtml);
		
		LODOP.PREVIEW();		
	};	
	
	
</script>
</html>