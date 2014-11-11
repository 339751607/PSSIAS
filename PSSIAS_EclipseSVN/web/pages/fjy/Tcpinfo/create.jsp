<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<%

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>注册</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>

<%
request.setAttribute("mpcode",mpcode);
 %>
 
<s:form action="/pages/fjy/Tcpinfo/save.do" theme="simple" name="inputForm"   method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    <input type="hidden" name="cptype" id="cptype" value="E02"/>
	       <tr>
				<td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>新增
			    </td>
		   </tr>
	        <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname"  value="%{model.cpname}"  cssClass="required max-length-100" required="false" />
		                  </td>
		                  
		           </tr>
		          <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>所属分局
		               </td>
			        <td>     	
					<select id="fjid" name="fjid" class="required" onchange="getPcs('fjid','pcsid');">
						<option>请选择...</option>
					</select>
					</td>
					  <td class="crosscolor_td">
					  所属派出所
					  </td>
					  <td>
					<select  name="pcsid" id="pcsid" class=" validate-selection">
						<option>请选择...</option>
					</select>
					<input type="hidden" name="sspcs" id="s_sspcs" />
		          </td>
					</tr>

                  <tr class="crosscolor_tr">
                  		 <td class="crosscolor_td">
			                     <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_CPSTATE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cpstate}"   styleClass="required"  name="cpstate"   notEmpty="false"  dictName="T_DIC_CPSTATE"/>
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPKIND%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cpkind}"    styleClass="required validate-selection"  name="cpkind"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>


                   </tr>                   
		           <tr class="crosscolor_tr">
		           		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_AREA%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_AREA}" key="area" value="%{model.area}"  cssClass="required max-length-6 validate-digits" required="false" />
		                  </td>
		                      <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_JYFW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JYFW}" key="jyfw" value="%{model.jyfw}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
                   
                   <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPADRESS%>
		                  </td>
			              <td colspan="3">
		                        <s:textfield label="%{@vs@ALIAS_CPADRESS}" size="80" key="cpadress" value="%{model.cpadress}"  cssClass="required max-length-200" required="false" />
		                  </td>
		                  
                   </tr>
                   	<tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPTEL%>
		                  </td>
			              <td>
		                             <s:textfield label="%{@vs@ALIAS_CPTEL}" key="cptel" value="%{model.cptel}"  cssClass="required max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			               <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_KYSJ%>
		                  </td>
			              <td>
						       <input value="${model.kysj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="kysj" name="kysj"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>


                    <tr class="crosscolor_tr">
                    	  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_SFGSZZH%>
		                  </td>
			              <td>
			              	  <mytag:select property="%{model.sfgszzh}"   onchange="createGszzh(this)" name="sfgszzh"   styleClass="required" notEmpty="false"  dictName="shiFou"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <span id ="spangszzh" style="display:none"> <FONT color="red">*</FONT></span>  <%=Tcpinfo.ALIAS_GSZZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GSZZH}" size = "80" key="gszzh" value="%{model.gszzh}" id="gszzh"  readonly="true" cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
	            <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_FRNAME%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_FRNAME}" key="frname" value="%{model.frname}"  cssClass="required max-length-30 validate-chinese" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_FRIDCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_FRIDCODE}" key="fridcode" value="%{model.fridcode}"  cssClass="required max-length-18 validate-id-number" required="false" />
		                  </td>
		           </tr>
		           	<tr class="crosscolor_tr">
		                                     <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRSEX%>
		                  </td>
			              <td colspan="3">
						           <mytag:select property="%{model.frsex}"    name="frsex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
		             </tr>
					<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAFZR}" key="zafzr" value="%{model.zafzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   	       <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZRDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAFZRDH}" key="zafzrdh" value="%{model.zafzrdh}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>

<tr class="crosscolor_tr">
 <c:choose>
   <c:when test="${deptid == mpcode}"> 
 		 <td class="crosscolor_td">
	        <%=Tcpinfo.ALIAS_SETUPFLAG%>
         </td>
	      <td >
			<mytag:select property="%{model.setupflag}"    name="setupflag"   notEmpty="false"  dictName="shiFou"/>
         </td>
               
        <td class="crosscolor_td">
	      <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_SFBAN%>
         </td>
	    <td >
			<mytag:select property="%{model.sfban}"    name="sfban"   styleClass="required"  notEmpty="false"  dictName="shiFou"/>
        </td>
   </c:when>
   <c:otherwise>
	       <td class="crosscolor_td">
                     <FONT color="red">*</FONT><%=Tcpinfo.ALIAS_SFBAN%>
                </td>
          <td colspan="3">
		           <mytag:select property="%{model.sfban}"   styleClass="required"   name="sfban"   notEmpty="false"  dictName="shiFou"/>
          </td>
   </c:otherwise>

</c:choose>
</tr>
                    <tr >
				<td colspan="4" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="保存" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>

getFj('fjid')
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		submitValueId('fjid','pcsid','','s_sspcs');
		return disableSubmit(finalResult,'submitButton');
	}});
function createGszzh(obj){
	
		if(obj.value=="1"){
			document.getElementById("gszzh").readOnly=false;
			document.getElementById("gszzh").className="required max-length-30";
			var spangszzh= document.getElementById("spangszzh"); 
			spangszzh.style.display ="inline";
		}else{
			document.getElementById("gszzh").value="";
			document.getElementById("gszzh").readOnly=true;
			document.getElementById("gszzh").className="max-length-30";
			var spangszzh= document.getElementById("spangszzh"); 
			spangszzh.style.display ="none";
		}
		
}

</script>

</body>
</html>