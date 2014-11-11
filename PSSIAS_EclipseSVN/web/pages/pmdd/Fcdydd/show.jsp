<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
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
String fwqw="";
if(request.getAttribute("fwqw") != null )
	fwqw =(String)request.getAttribute("fwqw");
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
if(request.getAttribute("yxzj") != null)
 zjhm =(String)request.getAttribute("yxzj");
if(request.getAttribute("dz") != null && !"".equals(request.getAttribute("dz")))
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
	
	<script language="javascript" src="<c:url value="/pages/pmdd/Dczydd/CheckActivX.js"/>"></script>
    <object id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
    </object> 
	<base href="<%=basePath%>">
	<title><%=Fcdydd.TABLE_ALIAS%>信息</title>
</head>
<body>


<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Fcdydd/list.do" method="get" name="showForm" theme="simple">
	<s:hidden name="dnumber" id="dnumber" value="%{model.dnumber}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="6" class="tb_title"> 
							<%=Fcdydd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                           <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_SQR%>
		                  </td>
			              <td >
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
			                       <%=Fcdydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
			              
			               <mytag:write property="%{model.yxzj}"   name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zjhm}" />
		                  </td>
                         
		                    <td rowspan="6"  align="center" >
			                  <table align="center">
							<tr>
								<td align="center">
									<img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
								</td>
							</tr>
						</table>
		                   
		                   </td>
		                    <td rowspan="6"  align="center" >
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
			                      <%=Fcdydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_LB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.lb}"   name="lb"  notEmpty="true"  dictName="fcdylb"/>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
		                   <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gzdw}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.frdb}" />
		                  </td>
                         
                   </tr>
                     <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FWQW%>
		                  </td>
			               <td colspan="3">
		                           <s:property value="%{model.fwqw}" />
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dz}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                       
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_FWSYQZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fwsyqzh}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_JZMJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jzmj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_TDSYZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tdsyzh}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_ZDMJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zdmj}" />
		                  </td>
		                  <td  colspan="2" align="center" >
		                                    当物照片
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_BXXZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.bxxz}" />
		                  </td>
		                    <td rowspan="6" colspan="2" align="center" >
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
			                      <%=Fcdydd.ALIAS_DDLB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.ddlb}"   name="ddlb"  notEmpty="true"  dictName="ddlb"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddqx}" />
		                  </td>
		                  
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DWMS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dwms}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_REMARK%>
		                  </td>
			             <td colspan="3">
		                           <s:property value="%{model.remark}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lrrq}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sdr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Fcdydd.ALIAS_SFSH%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sfsh}"   name="sfsh"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		         
		          
                  
	</table>	
</s:form>

 <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
 <tr>
						  <td colspan="6" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
								   <input type="button"  value="预览" onclick="javascript:myPreview()"/>
						           <input type="button"  value="打印" onclick="javascript:myPrint()"/>
	                      </td>
	                   </tr>
	               	</table>	

</body>
</html>
<script>
$(document).ready(function(){  
		    CheckLodop();
	}); 
	
	  function myPrint() {		
		CreateOneFormPage();
		LODOP.PRINT();		
	};  
	
	function myPreview() {		
		CreateOneFormPage();
		LODOP.PREVIEW();		
	};	
	
	function CreateOneFormPage(){
		//--当前布局风格的控制代码(可复制到页面程序中做为缺省)：

		LODOP.SET_PRINT_PAPER(-13,7,796,1125,"打印插件功能");
		LODOP.SET_PRINT_STYLE("FontSize",11);
		LODOP.ADD_PRINT_RECT(96,42,706,904,0,1);
		LODOP.ADD_PRINT_RECT(753,42,707,45,0,1);
		LODOP.ADD_PRINT_TEXT(45,306,184,36,"典当物品登记表");
		LODOP.SET_PRINT_STYLEA(3,"FontSize",16);
		LODOP.ADD_PRINT_TEXT(765,324,149,30,"产 权 证 明 材 料");
		LODOP.ADD_PRINT_TEXT(720,532,88,30,"当户签字：");
		LODOP.ADD_PRINT_TEXT(521,303,190,30,"物 品 来 源 情 况 说 明");
		LODOP.ADD_PRINT_TEXT(721,623,100,30,"");
		LODOP.ADD_PRINT_TEXT(1010,44,128,30,"当行(加盖印章):");
		LODOP.ADD_PRINT_TEXT(1014,382,77,30,"收当人：");
		LODOP.ADD_PRINT_TEXT(1014,557,90,30,"收当时间:");
		LODOP.ADD_PRINT_TEXT(1014,643,106,30,"  年  月  日");
		LODOP.ADD_PRINT_TEXT(1014,456,85,30,"");
		LODOP.ADD_PRINT_RECT(508,42,707,45,0,1);
		LODOP.ADD_PRINT_HTM(99,44,702,404,document.getElementById("showForm").innerHTML);


	};
function CreatePrintPage() {

LODOP.SET_PRINT_PAPER(-13,7,796,1125,"打印插件功能");
LODOP.SET_PRINT_STYLE("FontSize",11);
LODOP.ADD_PRINT_RECT(200,94,600,800,0,1);
LODOP.ADD_PRINT_RECT(436,128,566,40,0,1);
LODOP.ADD_PRINT_RECT(753,94,600,45,0,1);
LODOP.ADD_PRINT_RECT(316,94,600,40,0,1);
LODOP.ADD_PRINT_RECT(513,94,600,40,0,1);
LODOP.ADD_PRINT_RECT(398,94,600,1,0,1);
LODOP.ADD_PRINT_RECT(236,94,600,40,0,1);
LODOP.ADD_PRINT_LINE(512,227,199,228,0,1);
LODOP.ADD_PRINT_RECT(236,330,100,81,0,1);
LODOP.ADD_PRINT_RECT(200,429,85,76,0,1);
LODOP.ADD_PRINT_RECT(236,513,94,40,0,1);
LODOP.ADD_PRINT_RECT(436,330,100,78,0,1);
LODOP.ADD_PRINT_RECT(436,515,89,40,0,1);
LODOP.ADD_PRINT_TEXT(143,310,184,36,"典当物品登记表");
LODOP.SET_PRINT_STYLEA(14,"FontSize",16);
LODOP.ADD_PRINT_TEXT(64,42,100,30,"附件");
LODOP.SET_PRINT_STYLEA(15,"FontSize",15);
LODOP.ADD_PRINT_TEXT(210,101,100,30,"房屋区位");
LODOP.ADD_PRINT_TEXT(247,101,100,30,"当户姓名");
LODOP.ADD_PRINT_TEXT(406,130,60,30,"标识码");
LODOP.ADD_PRINT_TEXT(444,130,60,30,"类别");
LODOP.ADD_PRINT_TEXT(483,131,80,30,"建筑面积");
LODOP.ADD_PRINT_RECT(398,94,35,116,0,1);
LODOP.ADD_PRINT_TEXT(288,101,100,30,"有效身份证件");
LODOP.ADD_PRINT_TEXT(327,101,100,30,"现住址");
LODOP.ADD_PRINT_TEXT(365,101,100,30,"联系方式");
LODOP.ADD_PRINT_TEXT(288,336,60,30,"号码");
LODOP.ADD_PRINT_TEXT(243,337,60,30,"性别");
LODOP.ADD_PRINT_TEXT(765,308,149,30,"产 权 证 明 材 料");
LODOP.ADD_PRINT_TEXT(207,434,60,30,"当票号");
LODOP.ADD_PRINT_TEXT(242,516,90,30,"户籍所在地");
LODOP.ADD_PRINT_TEXT(443,515,100,30,"土地使用证号");
LODOP.ADD_PRINT_TEXT(720,499,88,30,"当户签字：");
LODOP.ADD_PRINT_TEXT(521,287,190,30,"物 品 来 源 情 况 说 明");
LODOP.ADD_PRINT_TEXT(483,333,89,30,"占地面积");
LODOP.ADD_PRINT_TEXT(443,335,100,30,"房屋所有权证号");
LODOP.ADD_PRINT_TEXT(721,590,100,30,"");
LODOP.ADD_PRINT_TEXT(409,97,30,94,"当\n物\n特征");
LODOP.ADD_PRINT_TEXT(1010,95,128,30,"当行(加盖印章):");
LODOP.ADD_PRINT_TEXT(1014,336,77,30,"收当人：");
LODOP.ADD_PRINT_TEXT(1017,511,90,30,"收当时间:");
var zjlx='<mytag:write property="%{model.yxzj}"   name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>';
var zjhm='<s:property value="%{model.zjhm}" />';
var ddlb='<mytag:write property="%{model.ddlb}"   name="ddlb"  notEmpty="true"  dictName="ddlb"/>';
var fwsyqz='<s:property value="%{model.fwsyqzh}" />';
var tdsyzh='<s:property value="%{model.tdsyzh}" />';
var jzmj='<s:property value="%{model.jzmj}" />';
var zdmj='<s:property value="%{model.zdmj}" />';
LODOP.ADD_PRINT_TEXT(1017,597,106,30,"");
LODOP.ADD_PRINT_TEXT(205,230,100,30,"<%=fwqw%>");
LODOP.ADD_PRINT_TEXT(244,228,100,30,"<%=sqr %>");
LODOP.ADD_PRINT_TEXT(287,228,100,30,zjlx);
LODOP.ADD_PRINT_TEXT(322,229,423,30,"<%=dz %>");
LODOP.ADD_PRINT_TEXT(367,227,425,30,"<%=lxdh %>");
LODOP.ADD_PRINT_TEXT(447,227,100,30,ddlb);
LODOP.ADD_PRINT_TEXT(406,228,425,30,"<%=dnumber%>");
LODOP.ADD_PRINT_TEXT(446,430,79,30,fwsyqz);
LODOP.ADD_PRINT_TEXT(482,228,100,30,jzmj);
LODOP.ADD_PRINT_TEXT(483,431,226,30,zdmj);
LODOP.ADD_PRINT_TEXT(242,608,84,30,"");
LODOP.ADD_PRINT_TEXT(205,516,172,30,"<%=htid %>");
LODOP.ADD_PRINT_TEXT(283,430,236,30,zjhm);
LODOP.ADD_PRINT_TEXT(243,431,60,30,"");
LODOP.ADD_PRINT_TEXT(553,95,599,155,"");
LODOP.ADD_PRINT_TEXT(797,96,599,202,"");
LODOP.ADD_PRINT_TEXT(1014,410,85,30,"");
LODOP.ADD_PRINT_TEXT(444,604,79,30,tdsyzh);
	};	
</script>