<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ page import="com.dyneinfo.jxy.model.*"%>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String sfzhcardtype = "1";	
String typecode = (String)request.getAttribute("typecode");
String smycode = (String)request.getAttribute("smycode");
String serveritemName = "";
if(request.getAttribute("serveritemName") != null)
	serveritemName =(String)request.getAttribute("serveritemName");
	
	String deploycity = (String)DictHelpImpl.getInitData("deploycity");
	request.setAttribute("city",deploycity);
	
	int inCol=0;
	if(deploycity.equals("ZhanJiang"))
		inCol=3;
	else
		inCol=1;
%>
<html>
	<head>
		<%@ include file="/commons/meta.jsp"%>
		<script src="../../extclient/serviceItems.js"></script>
		<base href="<%=basePath%>">
		<title><%=Tcarinfo.TABLE_ALIAS%>修改</title>	
<style type="text/css">
.crosscolor_td{width: 15%}
#carid1{width:30%}
#cartype{width:153}
		.crosscolor_tr input {
			float: left;
			margin: 0 0 0 0px;
			height: 20px;	
</style>	
	</head>

	<body onload="quickSelectInit()"  id="bd">
		<%@ include file="/commons/messages.jsp"%>
		
		<s:form action="/jxy/Tcarinfo/update.do" theme="simple"
			name="inputForm" enctype="multipart/form-data" method="post">
			<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
				<input type="hidden" name="returnUrl"
					value="!/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
				<s:hidden id="enrolid" name="enrolid" />
				
				 <s:hidden  id="serveritem" name="serveritem" value="%{model.serveritem}"></s:hidden>
				<tr>
					<td colspan="5" class="tb_title">
						<%=Tcarinfo.TABLE_ALIAS%>修改
					</td>
				</tr>
				<tr class="crosscolor_tr" >
					<td colspan="4" >
						<b>车辆信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b><%=Tcarinfo.ALIAS_CARPICTURE%></b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CAROWNER%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_CAROWNER}" key="carowner"
							value="%{model.carowner}" cssClass="required max-length-40 validate-chinese"
							required="false" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CARID%>
					</td>
					<td>
						<mytag:select property="%{model.carid1}"
							styleClass="required validate-selection" name="carid1"
							notEmpty="false" dictName="cpht" />
						<s:textfield label="%{@vs@ALIAS_CARID}" key="carid"
							value="%{model.carid}" cssClass="required max-length-20"
							required="false" size="7"/>
						
					</td>
					
					
					
					<td rowspan="4"  align="center">
									<a
							onclick="javascript:uploadEmpPhoto('<s:property value="%{model.enrolid}" />');return false;"
							href="#"> <img
								src='${ctx}/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />'
								onerror="this.src='${ctx}/images/noCar.gif'"   
								alt="" height="100" width="200" border="0" name="photo"> </a>
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_CARTYPE%>
					</td>
					<td>
					<mytag:select property="%{model.cartype}"
							styleClass="required validate-selection" name="cartype"
							notEmpty="false" dictName="cllx" />
						
					</td>
					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_BRAND%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_BRAND}" key="brand"
							value="%{model.brand}" cssClass="max-length-30" required="false" />
					</td>
					
					

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarinfo.ALIAS_ENGINECODE%>
					</td>
					 <td>    
			              
		                           <s:textfield label="%{@vs@ALIAS_ENGINECODE}" key="enginecode"  
		                  			
		      						title="只能输入 大写字母 、数字、中杠（-）、点（.）"
		      						onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') " 
			  						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z·]/g,''))" 
			  						onkeydown="if(event.keyCode==13)event.keyCode=9"
		      						value="%{model.enginecode}" cssClass="required max-length-30"  required="false">
		                            </s:textfield>
		                            
		                  </td>
				
					<td class="crosscolor_td">
			                      <%=Tcarinfo.ALIAS_CLSBCODE%>
		                  </td>
			               <td >
		                           <s:textfield label="%{@vs@ALIAS_BODYCODE}" key="clsbcode"
		                          
		      						title="只能输入 大写字母 、数字、中杠（-）、点（.）"
		      						onkeyup="value=value.replace(/[^ A-Z0-9.-]/g,'') " 
			  						onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^ A-Z·]/g,''))" 
			  						onkeydown="if(event.keyCode==13)event.keyCode=9"
		      						value="%{model.clsbcode}" cssClass="max-length-30" required="false">
		                            </s:textfield>
		                           
		                           
		                  </td>
					<!--
					<c:if test="${city ne 'ZhanJiang'}">部署城市不是湛江 add by zzq 2012/06/12
						<td class="crosscolor_td">
							<%=Tcarinfo.ALIAS_BODYCODE%>
						</td>
						<td>
							<s:textfield label="%{@vs@ALIAS_BODYCODE}" key="bodycode"
								value="%{model.bodycode}" cssClass="required max-length-30"
								required="false" />
							<FONT color="red">*</FONT>
						</td>
					</c:if>
					-->
					
				</tr>
				  
				<tr class="crosscolor_tr">

					<td class="crosscolor_td">
						<%=Tcarinfo.ALIAS_COLOR%>
					</td>
					<td colspan="3" class="crosscolor_td" align="left">
					<table class="list">
					<tr>
					<td>
						<mytag:select property="%{model.color1}"
							styleClass="required validate-selection" name="color1"
							notEmpty="false" dictName="csys" />
					</td>
					<td>
						<FONT color="red">*</FONT> 
					</td>
					<td>
						第一辅色:
					</td>
					<td>
						<mytag:select property="%{model.color2}"
							styleClass="validate-selection" name="color2" notEmpty="false"
							dictName="csys" />
					</td>
					<td>
						第二辅色: 
					</td>
					<td>
						<mytag:select property="%{model.color3}"
							styleClass="validate-selection" name="color3" notEmpty="false"
							dictName="csys" />
					</td>
					</tr>
					</table>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td colspan="4" class="crosscolor_d">
						<b>车辆交接信息</b>
					</td>
					<td	width="25%" align="center"> 
					<b>送车人照片</b>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_DELINAME%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DELINAME}" key="deliname"
							value="%{model.deliname}" cssClass="required max-length-30 validate-chinese"
							required="false" />
						
					</td>
					<td class="crosscolor_td">
<!--						<%=Tcarreturn.ALIAS_DELICREDCODE%>--><FONT color="red">*</FONT>送车人证件号
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_DELICREDCODE}" key="delicredcode"
							value="%{model.delicredcode}"
							cssClass="required max-length-18  "
							required="false" />
						
					</td>
					<td width="25%" rowspan="6"  id="clxxDevice" bgcolor="#EDF1FF">
					  <%if(typecode.equals("1") && smycode.equals("1")){ %>
						<IFRAME height="200" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/Edit.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							<IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCardEdit.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
					   <%}if(!smycode.equals("1") && typecode.equals("1")) { %>     
						<IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/Edit.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
					    <% } else if(!typecode.equals("1") && smycode.equals("1")) { %>	
					    <IFRAME height="170" width="200" name="ifranmename" src="${ctx}/pages/jxy/Tcarinfo/CVR_IDCardEdit.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						 <% } else if(sfzhcardtype != null && sfzhcardtype.equals("2")) { %>	
						  <IFRAME height="170" width="200" name="ifranmename" src="../IDcardnew.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							 <% } else if(sfzhcardtype != null && sfzhcardtype.equals("3")) { %>	
						  <IFRAME height="170" width="200" name="resultifranme" src="../CVR_IDCardnew.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
							<%} %>		
					</td>
					<td width ="25%" rowspan="6"  align="center" id="imgidtd" bgcolor="#EDF1FF" style="display:none;">
						<img id="imgid" width="120px" height="100px"  src='${ctx}/images/spacer.gif'  alt=""  border="0" name="photo">
					</td>
					
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_DELITELEPHONE%>
					</td>
					<td colspan="3">
						<s:textfield 
							title="固话区号和号码用'-'隔开"
							label="%{@vs@ALIAS_DELITELEPHONE}"
							key="delitelephone" value="%{model.delitelephone}"
							cssClass="required max-length-18 validate-mobile-or-phone" required="false" />
						
					</td>

				</tr>
				
                 <tr class="crosscolor_tr">
               
		                 <td class="crosscolor_td">
			           		<%=Tcarreturn.ALIAS_DELIADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield size="55" label="%{@vs@ALIAS_DELIADDRESS}" key="deliaddress" value="%{model.deliaddress}"  cssClass="max-length-80" required="false" />
		                  </td>
                  </tr>
				
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Tcarreturn.ALIAS_RECENAME%>
					</td>
					<td id="rece" >
							<select  name="recename" id="recename" Class="required max-length-30">
								<option value="">请选择...</option>
							</select>
		            </td>
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_RECETIME%>
					</td>
					<td>
					<input value="${model.recetime}" class="Wdate" size="20"
						onkeyup="DateFormat(this);" 	onclick="WdatePicker({startDate:'2010-01-01 00:00',dateFmt:'yyyy-MM-dd HH:mm',isShowClear:false})"
							id="recetime" name="recetime"  />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_SERVERITEM%>
					</td>
					<td colspan="3">
					
				<div id="addrinfo"><input name="input" id="test" value="选择" type="button" onclick="zzjs_net('popupAddr')" /></div> <span id="showserveritem"> <%=serveritemName%> </span><div id="result"></div>
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarreturn.ALIAS_DEMO%>
					</td>
					<td colspan="3" align="left">
						<s:textarea  style="margin-left:10px"  label="%{@vs@ALIAS_DEMO}" key="demo"
							value="%{model.demo}" rows="7" cols="45"
							cssClass="max-length-300" required="false" />
					</td>
				</tr>
				<tr>
					<td colspan="5" class="tb_bottom">
						<input id="submitButton" name="submitButton" type="submit"
							value="提交" />
						<input type="button" value="返回"
							onclick="window.location='${ctx}/jxy/Tcarinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
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
	
	function uploadEmpPhoto(enrolid) {
        var frm = document.forms("form1");
		var returnvalue = window.showModalDialog("${ctx}/jxy/Tcarinfo/uploadPhoto.jsp?enrolid="+enrolid,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	      }      
	}
	

	
	rnd.today=new Date();  
    rnd.seed=rnd.today.getTime(); 
    
    function rnd() {  
	　　　  rnd.seed = (rnd.seed*9301+49297) % 233280;  
	　　　　return rnd.seed/(233280.0);  
    };  
    function rand(number) {  
　　　　	return Math.ceil(rnd()*number);  
    };  
    
	function changesrc(){
	    var pic=document.getElementById('photo');
	    pic.src='${ctx}/jxy/Tcarinfo/showPic.do?enrolid=<s:property value="%{model.enrolid}" />&rand='+rand(1000);
   }  
   getPcs();
	function getPcs(){
	var recename='${model.recename}';
	var url="${ctx}/jxy/Dictitem/getEmployeeList.do?ajax=true&recename="+recename;
	$.post(url, function(data) {
		$("#rece").html("<select  name='recename'  id='recename' Class='required max-length-30'><option value=''>请选择...</option></select>");
		$("#recename").append(data);
	});
	}
 function clxxDevice(){ //用于框架调用
 	document.getElementById("clxxDevice").style.display ="none";
 	document.getElementById("imgidtd").style.display ="";
 }
 
</script>
<script type="text/javascript">
//工作地点键值匹配数组
<%=request.getAttribute("data")%>
<%=request.getAttribute("dataTwo")%>

</script>
	</body>

</html>
