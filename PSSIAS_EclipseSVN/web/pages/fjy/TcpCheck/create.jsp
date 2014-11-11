<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String IDCardType = (String) DictHelpImpl.getInitData("IDCardType");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<base href="<%=basePath%>">
	<title><%=TcpCheck.TABLE_ALIAS%>新增</title>
</head>
<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<iframe name="postFrame" style="display: none"></iframe>
<s:form action="/pages/fjy/TcpCheck/save.do"   target="postFrame"  name="inputForm" theme="simple"  method="post">
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	    <input type="hidden" name="returnUrl" value="!/pages/fjy/TcpCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	      	<s:hidden value="02" id="saveType" name="saveType" />
	       <tr>
				<td colspan="3" class="tb_title"> 
							检查维护新增
			    </td>
		   </tr>
              <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    所在部门
		                  </td>
			              <td>
			              

		                           
		                            <input type="text" class="required"  maxlength="0"  name="deptname" maxlength="0" value="<authz:authentication property="principal.deptName"/>"  class="max-length-60"/>
		                            <input type="hidden"  name="deptid" value="<authz:authentication property="principal.deptID"/>" />
		                           <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'deptname','deptid')"   value="选择" type="button" > 
		                 
		                 
		                            </td>
		                            
		                            <td width="25%" rowspan="6">
			             <%
			             	if (IDCardType != null && IDCardType.equals("0")) {
			             %>     
						  <IFRAME height="240" width="340" name="result"   src="${ctx}/pages/fjy/Temployee/IDcard_check.htm"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						  <%
						  	} else if (IDCardType != null && IDCardType.equals("1")) {
						  %>	
							<IFRAME height="240" width="280" name="result"   src="${ctx}/pages/fjy/Temployee/CVR_IDCard_check.html"
							align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
						  <%
						  	}
						  %>
					       </td>
		         </tr>
		           <tr class="crosscolor_tr">          
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_IDCARD}" onblur="javascript:getEmpType();" key="idcard" value="%{model.idcard}"  cssClass="max-length-20" required="false" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr" id="show0a" >
						<td>
							维护项目
						</td>
						<td>
							<s:checkboxlist value="" listKey="dictid"
								listValue="dictname" list="listCpMainTainItem" name="mtItems" />
						</td>
					</tr>
					 <tr class="crosscolor_tr" id="show0b" style="display:none">
						<td>
							检查项目
						</td>
						<td>
							<s:checkboxlist value="" listKey="dictid"
								listValue="dictname" list="listCpCheckItem" name="checkItems" />
						</td>
					</tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TcpCheck.ALIAS_DEMO%>
		                  </td>
			              <td>
			              
			              <s:textarea label="%{@vs@ALIAS_MEMO}" rows="6" cols="50"
							key="memo" value="%{model.memo}" cssClass="max-length-2000"
							required="false"></s:textarea>
							
		                          
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">          
                          <td class="crosscolor_td">
			                     时间
		                  </td>
			              <td>
		                          <s:property value="%{model.checktime}" />
		                  </td>
                   </tr>
	       <tr >
				<td colspan="3" class="tb_bottom">
							<input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/TcpCheck/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			    </td>
	        </tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		getEmpType();
		//在这里添加自定义验证
		var saveType = document.getElementById("saveType").value;
		
		if(saveType == "00"){
		   finalResult = false;
		} 
		else if(saveType == "01") {//民警
				if (!hasOneChecked("checkItems")){
		            alert('请选择检查项目!');
		            finalResult = false;
		        }
		}
		else if(saveType == "02") {//前台维护人员
				if (!hasOneChecked("mtItems")){
		            alert('请选择维护项目!');
		            finalResult = false;
		        }
		}
		
		//alert(document.getElementById("idcard").value);
		//alert(document.inputForm.action);
		if(document.getElementById("idcard").value == "")
			finalResult = false;
		return disableSubmit(finalResult,'submitButton');
	}});
	
	function getEmpType()
	{
	    var idcardVaule = $("idcard").value;
		menu.queryEmpTypeByIdcard(idcardVaule,callBackEmpType);	
	}
	function callBackEmpType(data){ 
        // 其中 date 接收方法的返回值     
        if(data == "01") {//民警
        	document.getElementById("saveType").value = "01";
        	eval('show0a').style.display="none"
        	eval('show0b').style.display=""
        	document.inputForm.action = "${ctx}/pages/fjy/TcpCheck/save.do";
        }
        else if(data == "02"){//前台维护人员
        	document.getElementById("saveType").value = "02";
        	eval('show0a').style.display=""
        	eval('show0b').style.display="none"
        	document.inputForm.action = "${ctx}/pages/fjy/TcpMaintain/save.do";
        }
        else if(data == "00"){
            document.getElementById("saveType").value = "00";
        	alert("检查失败,无对应信息!");
        }
    } 
	
	
	function selectDept(frm,displayName,hiddenName) {
	    window.showModalDialog('${ctx}/pages/fjy/SsDept/selectDept.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
    }
</script>

</body>
</html>