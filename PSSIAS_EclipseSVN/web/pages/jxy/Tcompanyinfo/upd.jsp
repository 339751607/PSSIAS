<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcompanyinfo.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tcompanyinfo/updstatuts.do"  name="form1" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/jxy/Tcompanyinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Tcompanyinfo.TABLE_ALIAS%>变更
				     </td>
		    </tr>
	              <s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		                      <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%><font color="red">*</font>
		                  </td>
			              <td colspan="3">
		                             <s:textfield label="%{@vs@ALIAS_CPNAME}" size="70" key="s_cpname" value="%{model.cpname}"  cssClass=" max-length-80" required="false" />
		                  
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">       
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADDRESS%><font color="red">*</font>
		                  </td>
			              <td colspan="3">
		                            <s:textfield  label="%{@vs@ALIAS_CPADDRESS}" size="70" key="s_cpaddress" value="%{model.cpaddress}"  cssClass="required max-length-80" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <s:property value="%{model.workarea}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.phone}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fax}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <s:property value="%{model.enrolcapital}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                       
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                        ${start_date}
		                  </td>
		                  <td></td><td></td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.economy}"   name="economy"  notEmpty="true"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.corpcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPNAME%><font color="red">*</font>
		                  </td>
			              <td>
		                          <s:textfield  label="%{@vs@ALIAS_CORPNAME}" key="s_corpname" value="%{model.corpname}"  cssClass="required validate-chinese max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                          <s:textfield  label="%{@vs@ALIAS_POLICENAME}" key="s_policename" value="%{model.policename}"  cssClass="validate-chinese max-length-30" required="false" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.policephone}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.acreage}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEUNIT%><font color="red">*</font>
		                  </td>
			              <td>
			                         <mytag:select  property="%{model.policeunit}"  styleClass="required validate-selection"     name="s_policeunit"   notEmpty="false"  dictName="ssfj"/>
		                 <input type="hidden" name="policeuni"  id="policeuni" value="<mytag:write  property="%{model.policeunit}" notEmpty="false" dictName="ssfj"></mytag:write>"> 
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.scbackupno}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.scbackupunit}"   name="scbackupunit"  notEmpty="true"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BASJ%>
		                  </td>
			              <td>
		                           ${ba_date}
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licenceunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bcretunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taxunit}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.licence}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.flag}"   name="flag"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STATION%><font color="red">*</font>
		                  </td>
		                  <td>  
			               <s:textfield  key="stationName" id="stationName" maxlength="0" value="%{model.stationName}"  cssClass="required" required="false" />
		                           
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'stationName','s_station')"   value="选择" type="button" > 
		                          
		                           <s:hidden  id="s_station" key="s_station" value="%{model.station}"   required="false" />
		                  </td>
		                 
                   </tr>
                   <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      更新日期
		                  </td>
			              <td>
			            
			              <input value="${changedate}" name="s_changedate" id='s_changedate' readonly="true" disabled="true"     />
		             <input type="hidden" name="statio" id="statio" value="${model.stationName}"> 
		              <input type="hidden" name="policeunit1" id="policeunit1" value="">              
		                  </td>
		                  <td></td><td></td>
                   </tr>
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交"  />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>   
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
	
	
	 var obj=document.getElementById("s_station");
  		
		
	
</script>
 <script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>

</body>

</html>
