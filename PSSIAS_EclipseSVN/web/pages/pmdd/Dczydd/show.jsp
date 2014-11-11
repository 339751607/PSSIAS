<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String sexName = "";
String hjdName = "";
String ddlxName = "";
String yxzjName = "";
String dwmc = "";
String htid = "";
String sqr = "";
String dwzj = "";
String zjhm = "";
String dz = "";
String lxdh = "";
String bsm = "";
String pp = "";
String gg = "";
String zl = "";
String wpxz = "";
String wplyqksm = "";
String wpcqzmcl = "";
String dnumber = "";
String sdr = "";
String ddrqFormat = "";
String deptname = "";
String qylxdh = "";
String dwdz = "";
String TXXKZH = "";
if(request.getAttribute("sexName") != null)
sexName =(String)request.getAttribute("sexName");
if(request.getAttribute("hjdName") != null)
hjdName =(String)request.getAttribute("hjdName");
if(request.getAttribute("ddlxName") != null)
ddlxName =(String)request.getAttribute("ddlxName");
if(request.getAttribute("yxzjName") != null)
yxzjName =(String)request.getAttribute("yxzjName");
if(request.getAttribute("dwmc") != null)
 dwmc =(String)request.getAttribute("dwmc");
if(request.getAttribute("htid") != null)
 htid =(String)request.getAttribute("htid");
if(request.getAttribute("sqr") != null)
 sqr =(String)request.getAttribute("sqr");
if(request.getAttribute("dwzj") != null)
 dwzj =(String)request.getAttribute("dwzj");
if(request.getAttribute("zjhm") != null)
 zjhm =(String)request.getAttribute("zjhm");
if(request.getAttribute("dz") != null)
 dz =(String)request.getAttribute("dz");
if(request.getAttribute("dwmc") != null)
 lxdh =(String)request.getAttribute("lxdh");
if(request.getAttribute("bsm") != null)
 bsm =(String)request.getAttribute("bsm");
if(request.getAttribute("pp") != null)
 pp =(String)request.getAttribute("pp");
if(request.getAttribute("gg") != null)
 gg =(String)request.getAttribute("gg");
if(request.getAttribute("zl") != null)
 zl =(String)request.getAttribute("zl");
if(request.getAttribute("wpxz") != null)
 wpxz =(String)request.getAttribute("wpxz");
if(request.getAttribute("wplyqksm") != null)
 wplyqksm =(String)request.getAttribute("wplyqksm");
if(request.getAttribute("wpcqzmcl") != null)
 wpcqzmcl =(String)request.getAttribute("wpcqzmcl");
if(request.getAttribute("dnumber") != null)
 dnumber =(String)request.getAttribute("dnumber");
if(request.getAttribute("ddrqFormat") != null)
 ddrqFormat =(String)request.getAttribute("ddrqFormat");
if(request.getAttribute("sdr") != null)
 sdr =(String)request.getAttribute("sdr");
if(request.getAttribute("deptname") != null)
	deptname =(String)request.getAttribute("deptname");

if(request.getAttribute("qylxdh") != null)
	qylxdh =(String)request.getAttribute("qylxdh");
if(request.getAttribute("dwdz") != null)
	dwdz =(String)request.getAttribute("dwdz");
if(request.getAttribute("TXXKZH") != null)
	TXXKZH =(String)request.getAttribute("TXXKZH");



%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
    <script language="javascript" src="CheckActivX.js"></script>
    <object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
    </object> 
	
	<base href="<%=basePath%>">
	<title><%=Dczydd.TABLE_ALIAS%>信息</title>
</head>
<body>
<!-- 
<script language="javascript">CheckLodop();</script>
 -->
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Dczydd/list.do" method="get" name="showForm" theme="simple">
	<s:hidden name="dnumber" id="dnumber" value="%{model.dnumber}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="6" class="tb_title"> 
							<%=Dczydd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                      <%=Dczydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                           <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                      <%=Dczydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sqr}" />
		                  </td>
		                   <td  width="15%" align="center" >
		                          申请人二代证照片
		                  </td>
		                  <td  width="15%" align="center" >
		                          申请人扫描照片
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                       <%=Dczydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
			              
			               <mytag:write property="%{model.yxzj}"    name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zjhm}" />
		                  </td>
		                 
                          
		                  <td rowspan="7" width="15%" align="center" valign="middle"   >
			                  <table align="center">
									<tr>
										<td align="center">
											 <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
										</td>
									</tr>
								</table>
		                   
		                   </td>
		                    <td rowspan="7" width="15%" align="center" valign="middle"   >
			                       <table align="center">
									<tr>
										<td align="center">
											 <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
										</td>
									</tr>
								</table>
		                  
		                   </td>
                   </tr>
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dz}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_GZDW%>
		                  </td>
			              <td >
		                           <s:property value="%{model.gzdw}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dwmc}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDLX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.ddlx}"   name="ddlx"  notEmpty="true"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWZJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dwzj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_FLAG%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.flag}"   name="flag"  notEmpty="true"  dictName="dczylb"/>
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPPP%>
		                  </td>
			              <td>
		                         <s:property value="%{model.wppp}" />   </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPGG%>
		                  </td>
			              <td>
		                          <s:property value="%{model.wpgg}" />   </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPZL%>
		                  </td>
			              <td>
		                            <s:property value="%{model.wpzl}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPXZ%>
		                  </td>
			              <td>
		                             <s:property value="%{model.wpxz}" />
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPLYQKSM%>
		                  </td>
			              <td>
		                            <s:property value="%{model.wplyqksm}" />
		                  </td>
		                
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_WPCQZMCL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.wpcqzmcl}" />
		                  </td>
		                   <td align="center" colspan="2" >
		                         当物照片
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddqx}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddrq}" />
		                  </td>
		                  <td rowspan="6" colspan="2"  align="center" >
				               <table align="center">
									<tr>
										<td align="center">
											 &nbsp; &nbsp; <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
				          
										</td>
									</tr>
								</table>
		                   </td>
                          
		                  
                   </tr>
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dwms}" />
		                  </td>
                           
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_REMARK%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.remark}" />
		                  </td>
                         
		                 
		                 
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lrrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sdr}" />
		                  </td>
		                  
		                 
                   </tr>
		           <tr class="crosscolor_tr">

                           <td class="crosscolor_td">
			                      <%=Dczydd.ALIAS_SFSH%>
		                  </td>
			              <td colspan="3">
			                       <mytag:write property="%{model.sfsh}"   name="sfsh"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		          
		          
		          
                   <tr>
						  <td colspan="6" class="tb_bottom">
						           <!-- <input type="button"  value="返回" onclick="javascript:window.history.go(-1);"/>-->
						          <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Dczydd/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
						           
						           <input type="button"  value="预览" onclick="javascript:myPreview()"/>
						           <input type="button"  value="打印" onclick="javascript:myPrint()"/>
						           <input type="button"  value="下载" onclick="doPrint();"/>
						           <input type="button"  value="当票" onclick="javascript:myPreviewDp()"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>

<script>

	$(document).ready(function(){  
		    CheckLodop();
	}); 
	  function doPrint() {
		    var form = document.showForm;
			if(!form) return;
			
		        form.action = '${ctx}/pages/DczyddExcelExport/listreport.do';
	            form.submit();
	        
	  }
	  function myPrint() {		
		CreatePrintPage();
		LODOP.PRINT();		
	};  
	
	function myPreview() {		
		CreatePrintPage();
		LODOP.PREVIEW();		
	};	
	
	function myPreviewDp() {		
		CreatePrintPageDp();
		LODOP.PREVIEW();		
	};	
	function CreatePrintPageDp() {

//--当前布局风格的控制代码(可复制到页面程序中做为缺省)：

LODOP.SET_PRINT_PAPER(-2,0,796,1125,"打印插件功能演示_Lodop功能_名片");
LODOP.SET_PRINT_STYLE("FontSize",11);
LODOP.ADD_PRINT_RECT(147,61,670,516,0,1);
LODOP.ADD_PRINT_RECT(294,61,670,50,0,1);
LODOP.ADD_PRINT_RECT(434,61,670,30,0,1);
LODOP.ADD_PRINT_RECT(235,124,607,30,0,1);
LODOP.ADD_PRINT_RECT(373,61,670,30,0,1);
LODOP.ADD_PRINT_RECT(177,124,607,30,0,1);
LODOP.ADD_PRINT_RECT(147,124,70,148,0,1);
LODOP.ADD_PRINT_RECT(147,61,670,60,0,1);
LODOP.ADD_PRINT_RECT(147,376,110,347,0,1);
LODOP.ADD_PRINT_RECT(294,250,127,200,0,1);
LODOP.ADD_PRINT_RECT(294,432,120,200,0,1);
LODOP.ADD_PRINT_TEXT(73,354,84,36,"当  票");
LODOP.SET_PRINT_STYLEA(12,"FontSize",16);
LODOP.SET_PRINT_STYLEA(12,"Bold",1);
LODOP.ADD_PRINT_RECT(147,61,64,347,0,1);
LODOP.ADD_PRINT_TEXT(235,62,60,30,"当 户");
LODOP.ADD_PRINT_TEXT(312,66,55,30,"序 号");
LODOP.ADD_PRINT_TEXT(674,61,56,30,"复核：");
LODOP.ADD_PRINT_TEXT(671,213,56,30,"经办：");
LODOP.ADD_PRINT_TEXT(676,538,88,30,"制单时间：");
LODOP.ADD_PRINT_TEXT(675,626,106,30," <%=ddrqFormat%>");
LODOP.ADD_PRINT_TEXT(152,129,60,25,"名 称");
LODOP.ADD_PRINT_TEXT(174,63,60,30,"典当行");
LODOP.ADD_PRINT_TEXT(316,388,45,25,"重量");
LODOP.ADD_PRINT_TEXT(673,362,56,30,"保管：");
LODOP.ADD_PRINT_TEXT(313,136,100,30,"当 物 名 称");
LODOP.ADD_PRINT_TEXT(182,130,60,25,"地 址");
LODOP.ADD_PRINT_TEXT(212,129,60,25,"名 称");
LODOP.ADD_PRINT_TEXT(240,129,60,25,"地 址");
LODOP.ADD_PRINT_TEXT(270,125,71,25,"证件名称");
LODOP.ADD_PRINT_TEXT(317,441,45,25,"估价");
LODOP.ADD_PRINT_RECT(319,711,20,145,0,1);
LODOP.ADD_PRINT_TEXT(300,493,55,46,"折当率\n   %");
LODOP.ADD_PRINT_RECT(319,671,20,145,0,1);
LODOP.ADD_PRINT_RECT(319,631,20,145,0,1);
LODOP.ADD_PRINT_RECT(319,590,20,145,0,1);
LODOP.ADD_PRINT_RECT(319,551,20,145,0,1);
LODOP.ADD_PRINT_RECT(493,61,491,30,0,1);
LODOP.ADD_PRINT_RECT(319,551,180,25,0,1);
LODOP.ADD_PRINT_TEXT(321,554,17,23,"百");
LODOP.ADD_PRINT_TEXT(322,574,17,23,"十");
LODOP.ADD_PRINT_TEXT(323,593,17,23,"万");
LODOP.ADD_PRINT_TEXT(323,615,17,23,"千");
LODOP.ADD_PRINT_TEXT(323,634,17,23,"百");
LODOP.ADD_PRINT_TEXT(321,655,17,23,"十");
LODOP.ADD_PRINT_TEXT(322,674,17,23,"元");
LODOP.ADD_PRINT_TEXT(323,695,17,23,"角");
LODOP.ADD_PRINT_TEXT(322,714,17,23,"分");
LODOP.ADD_PRINT_TEXT(350,553,17,23,"");
LODOP.ADD_PRINT_TEXT(379,551,17,23,"");
LODOP.ADD_PRINT_TEXT(412,553,17,23,"");
LODOP.ADD_PRINT_TEXT(441,553,17,23,"");
LODOP.ADD_PRINT_TEXT(352,573,17,23,"");
LODOP.ADD_PRINT_TEXT(379,573,17,23,"");
LODOP.ADD_PRINT_TEXT(413,574,17,23,"");
LODOP.ADD_PRINT_TEXT(441,573,17,23,"");
LODOP.ADD_PRINT_TEXT(350,593,17,23,"");
LODOP.ADD_PRINT_TEXT(378,592,17,23,"");
LODOP.ADD_PRINT_TEXT(412,592,17,23,"");
LODOP.ADD_PRINT_TEXT(440,592,17,23,"");
LODOP.ADD_PRINT_TEXT(349,615,17,23,"");
LODOP.ADD_PRINT_TEXT(378,615,17,23,"");
LODOP.ADD_PRINT_TEXT(413,613,17,23,"");
LODOP.ADD_PRINT_TEXT(440,614,17,23,"");
LODOP.ADD_PRINT_TEXT(441,633,17,23,"");
LODOP.ADD_PRINT_TEXT(441,655,17,23,"");
LODOP.ADD_PRINT_TEXT(442,673,17,23,"");
LODOP.ADD_PRINT_TEXT(442,695,17,23,"");
LODOP.ADD_PRINT_TEXT(444,714,17,23,"");
LODOP.ADD_PRINT_TEXT(348,632,17,23,"");
LODOP.ADD_PRINT_TEXT(380,633,17,23,"");
LODOP.ADD_PRINT_TEXT(411,634,17,23,"");
LODOP.ADD_PRINT_TEXT(351,655,17,23,"");
LODOP.ADD_PRINT_TEXT(379,654,17,23,"");
LODOP.ADD_PRINT_TEXT(411,654,17,23,"");
LODOP.ADD_PRINT_TEXT(349,673,17,23,"");
LODOP.ADD_PRINT_TEXT(378,673,17,23,"");
LODOP.ADD_PRINT_TEXT(409,673,17,23,"");
LODOP.ADD_PRINT_TEXT(350,695,17,23,"");
LODOP.ADD_PRINT_TEXT(380,694,17,23,"");
LODOP.ADD_PRINT_TEXT(411,695,17,23,"");
LODOP.ADD_PRINT_TEXT(350,714,17,23,"");
LODOP.ADD_PRINT_TEXT(379,714,17,23,"");
LODOP.ADD_PRINT_TEXT(411,714,17,23,"");
LODOP.ADD_PRINT_TEXT(295,589,107,25,"典 当 金 额");
LODOP.ADD_PRINT_TEXT(315,270,100,30,"规格和状况");
LODOP.ADD_PRINT_TEXT(151,409,60,25,"电  话");
LODOP.ADD_PRINT_TEXT(181,376,116,25,"经营许可证编码");
LODOP.ADD_PRINT_TEXT(210,403,60,25,"电  话");
LODOP.ADD_PRINT_TEXT(240,403,70,25,"联 系 人");
LODOP.ADD_PRINT_TEXT(270,402,70,25,"证件号码");
LODOP.ADD_PRINT_RECT(553,61,491,60,0,1);
LODOP.ADD_PRINT_RECT(613,374,178,50,0,1);
LODOP.ADD_PRINT_RECT(463,551,89,200,0,1);
LODOP.ADD_PRINT_TEXT(622,377,70,40,"除当票外双\n方其它约定\n");
LODOP.SET_PRINT_STYLEA(93,"FontSize",9);
LODOP.ADD_PRINT_TEXT(498,62,116,25,"典当金额(大写)");
LODOP.ADD_PRINT_RECT(493,551,180,170,0,1);
LODOP.ADD_PRINT_TEXT(529,62,116,25,"综合费用(大写)");
LODOP.ADD_PRINT_TEXT(557,62,116,25,"实付金额(大写)");
LODOP.ADD_PRINT_TEXT(588,62,116,25,"典当期限：");
LODOP.ADD_PRINT_TEXT(628,65,55,25,"备注：");
LODOP.ADD_PRINT_RECT(493,61,334,89,0,1);
LODOP.ADD_PRINT_TEXT(498,176,215,25,"佰 拾 万 仟 佰 拾 元 角 分");
LODOP.ADD_PRINT_TEXT(529,176,216,25,"佰 拾 万 仟 佰 拾 元 角 分");
LODOP.ADD_PRINT_TEXT(557,176,217,25,"佰 拾 万 仟 佰 拾 元 角 分");
LODOP.ADD_PRINT_TEXT(588,176,370,25,"由     年   月   日起至      年   月  日止");
LODOP.ADD_PRINT_TEXT(498,444,59,25,"合  计");
LODOP.ADD_PRINT_TEXT(529,398,153,25,"小写金额：");
LODOP.ADD_PRINT_TEXT(559,396,155,25,"小写金额：");
LODOP.ADD_PRINT_TEXT(469,652,78,25,"月利率 %");
LODOP.ADD_PRINT_TEXT(502,558,80,25,"当户签章");
LODOP.ADD_PRINT_TEXT(469,557,84,25,"月费率 %");
LODOP.ADD_PRINT_TEXT(501,648,85,25,"典当行签章");
LODOP.ADD_PRINT_TEXT(671,267,83,30,"<%=sdr%>");
LODOP.ADD_PRINT_TEXT(673,416,88,30,"");
LODOP.ADD_PRINT_TEXT(674,115,80,30,"");
LODOP.ADD_PRINT_TEXT(114,555,141,25,"NO:(A)<%=htid%>");
LODOP.SET_PRINT_STYLEA(115,"FontName","@Batang");
LODOP.SET_PRINT_STYLEA(115,"Bold",1);
LODOP.ADD_PRINT_TEXT(152,198,180,25,"<%=deptname%>");
LODOP.ADD_PRINT_TEXT(182,198,180,25,"<%=dwdz%>");
LODOP.ADD_PRINT_TEXT(211,197,180,25,"<%=sqr%>");
LODOP.ADD_PRINT_TEXT(240,197,180,25,"<%=dz%>");
LODOP.ADD_PRINT_TEXT(270,198,180,25,"<%=yxzjName%>");
LODOP.ADD_PRINT_TEXT(150,492,200,25,"<%=qylxdh%>");
LODOP.ADD_PRINT_TEXT(182,494,200,25,"<%=TXXKZH%>");
LODOP.ADD_PRINT_TEXT(209,494,200,25,"<%=lxdh%>");
LODOP.ADD_PRINT_TEXT(238,494,200,25,"");
LODOP.ADD_PRINT_TEXT(267,494,200,25,"<%=zjhm%>");
LODOP.ADD_PRINT_TEXT(343,65,55,30,"1");
LODOP.ADD_PRINT_TEXT(374,65,55,30,"2");
LODOP.ADD_PRINT_TEXT(404,65,55,30,"3");
LODOP.ADD_PRINT_TEXT(434,66,55,30,"4");
LODOP.ADD_PRINT_TEXT(462,66,55,30,"5");
LODOP.ADD_PRINT_TEXT(349,137,100,25,"<%=dwmc%>");
LODOP.ADD_PRINT_TEXT(377,138,100,25,"");
LODOP.ADD_PRINT_TEXT(409,138,100,25,"");
LODOP.ADD_PRINT_TEXT(438,139,100,25,"");
LODOP.ADD_PRINT_TEXT(468,140,100,25,"");
LODOP.ADD_PRINT_TEXT(350,269,100,25,"<%=gg%>");
LODOP.ADD_PRINT_TEXT(377,269,100,25,"");
LODOP.ADD_PRINT_TEXT(409,270,100,25,"");
LODOP.ADD_PRINT_TEXT(438,269,100,25,"");
LODOP.ADD_PRINT_TEXT(468,269,100,25,"");
LODOP.ADD_PRINT_TEXT(349,386,45,25,"<%=zl%>");
LODOP.ADD_PRINT_TEXT(377,385,45,25,"");
LODOP.ADD_PRINT_TEXT(409,385,45,25,"");
LODOP.ADD_PRINT_TEXT(439,385,45,25,"");
LODOP.ADD_PRINT_TEXT(468,385,45,25,"");
LODOP.ADD_PRINT_TEXT(348,439,45,25,"");
LODOP.ADD_PRINT_TEXT(377,440,45,25,"");
LODOP.ADD_PRINT_TEXT(408,439,45,25,"");
LODOP.ADD_PRINT_TEXT(439,439,45,25,"");
LODOP.ADD_PRINT_TEXT(468,440,45,25,"");
LODOP.ADD_PRINT_TEXT(350,504,45,25,"");
LODOP.ADD_PRINT_TEXT(377,504,45,25,"");
LODOP.ADD_PRINT_TEXT(409,505,45,25,"");
LODOP.ADD_PRINT_TEXT(439,506,45,25,"");
LODOP.ADD_PRINT_TEXT(469,505,45,25,"");
LODOP.ADD_PRINT_TEXT(612,118,256,52,"");
LODOP.SET_PRINT_STYLEA(156,"FontSize",6);
LODOP.ADD_PRINT_TEXT(568,648,74,77,"");
LODOP.ADD_PRINT_TEXT(568,562,74,79,"");
LODOP.ADD_PRINT_TEXT(614,443,107,47,"");
LODOP.ADD_PRINT_LINE(582,393,581,551,0,1);
	};	
	
	
	function CreatePrintPage() {



LODOP.SET_PRINT_PAPER(-13,7,796,1125,"打印插件功能");
LODOP.SET_PRINT_STYLE("FontSize",11);
LODOP.ADD_PRINT_RECT(200,94,600,835,0,1);
LODOP.ADD_PRINT_RECT(436,128,566,40,0,1);
LODOP.ADD_PRINT_RECT(781,94,600,45,0,1);
LODOP.ADD_PRINT_RECT(316,94,600,40,0,1);
LODOP.ADD_PRINT_RECT(548,94,600,40,0,1);
LODOP.ADD_PRINT_RECT(398,94,600,1,0,1);
LODOP.ADD_PRINT_RECT(236,94,600,40,0,1);
LODOP.ADD_PRINT_LINE(512,227,199,228,0,1);
LODOP.ADD_PRINT_RECT(236,330,100,81,0,1);
LODOP.ADD_PRINT_RECT(200,429,85,76,0,1);
LODOP.ADD_PRINT_RECT(236,513,94,40,0,1);
LODOP.ADD_PRINT_RECT(436,330,100,77,0,1);
LODOP.ADD_PRINT_RECT(512,128,100,37,0,1);
LODOP.ADD_PRINT_TEXT(143,310,184,36,"典当物品登记表");
LODOP.SET_PRINT_STYLEA(14,"FontSize",16);
LODOP.ADD_PRINT_TEXT(64,42,100,30,"附件");
LODOP.SET_PRINT_STYLEA(15,"FontSize",15);
LODOP.ADD_PRINT_TEXT(210,101,100,30,"典当物品");
LODOP.ADD_PRINT_TEXT(247,101,100,30,"当户姓名");
LODOP.ADD_PRINT_TEXT(406,130,60,30,"标识码");
LODOP.ADD_PRINT_TEXT(444,130,60,30,"类别");
LODOP.ADD_PRINT_TEXT(480,129,60,30,"重量");
LODOP.ADD_PRINT_RECT(398,94,35,151,0,1);
LODOP.ADD_PRINT_TEXT(288,101,100,30,"有效身份证件");
LODOP.ADD_PRINT_TEXT(327,101,100,30,"现住址");
LODOP.ADD_PRINT_TEXT(365,101,100,30,"联系方式");
LODOP.ADD_PRINT_TEXT(288,336,60,30,"号码");
LODOP.ADD_PRINT_TEXT(243,337,60,30,"性别");
LODOP.ADD_PRINT_TEXT(788,308,149,30,"产 权 证 明 材 料");
LODOP.ADD_PRINT_TEXT(207,434,60,30,"当票号");
LODOP.ADD_PRINT_TEXT(242,516,90,30,"户籍所在地");
LODOP.ADD_PRINT_TEXT(515,132,60,30,"规格");
LODOP.ADD_PRINT_TEXT(745,499,88,30,"当户签字：");
LODOP.ADD_PRINT_TEXT(553,287,190,30,"物 品 来 源 情 况 说 明");
LODOP.ADD_PRINT_TEXT(483,333,89,30,"形状特征");
LODOP.ADD_PRINT_TEXT(443,335,60,30,"品牌");
LODOP.ADD_PRINT_TEXT(745,590,100,30,"");
LODOP.ADD_PRINT_TEXT(409,97,30,129,"当\n物\n特征");
LODOP.ADD_PRINT_TEXT(1045,95,128,30,"当行(加盖印章):");
LODOP.ADD_PRINT_TEXT(1045,336,77,30,"收当人：");
LODOP.ADD_PRINT_TEXT(1045,511,90,30,"收当时间:");
LODOP.ADD_PRINT_TEXT(1045,597,106,30,"  ");
LODOP.ADD_PRINT_TEXT(1045,597,106,30,"<%=ddrqFormat%>");
LODOP.ADD_PRINT_TEXT(205,230,100,30,"<%=dwmc%>");
LODOP.ADD_PRINT_TEXT(244,228,100,30,"<%=sqr%>");
LODOP.ADD_PRINT_TEXT(287,228,100,30,"<%=yxzjName%>");
LODOP.ADD_PRINT_TEXT(322,229,423,30,"<%=dz%>");
LODOP.ADD_PRINT_TEXT(367,227,425,30,"<%=lxdh%>");
LODOP.ADD_PRINT_TEXT(447,227,100,30,"<%=ddlxName%>");
LODOP.ADD_PRINT_TEXT(406,228,425,30,"<%=dnumber%>");
LODOP.ADD_PRINT_TEXT(446,430,79,30,"<%=pp%>");
LODOP.ADD_PRINT_TEXT(482,228,100,30,"<%=zl%>");
LODOP.ADD_PRINT_TEXT(483,431,226,30,"<%=wpxz%>");
LODOP.ADD_PRINT_TEXT(242,608,84,30,"<%=hjdName%>");
LODOP.ADD_PRINT_TEXT(205,516,172,30,"<%=htid%>");
LODOP.ADD_PRINT_TEXT(283,430,236,30,"<%=zjhm%>");
LODOP.ADD_PRINT_TEXT(243,431,60,30,"<%=sexName%>");
LODOP.ADD_PRINT_TEXT(589,95,599,155,"<%=wplyqksm%>");
LODOP.ADD_PRINT_TEXT(828,96,599,202,"<%=wpcqzmcl%>");
LODOP.ADD_PRINT_TEXT(1045,410,85,30,"<%=sdr%>");

LODOP.ADD_PRINT_TEXT(517,230,429,30,"<%=gg%>");
LODOP.ADD_PRINT_RECT(512,128,566,37,0,1);







		

	};	
</script>