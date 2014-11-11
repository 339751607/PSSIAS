<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@page import="com.dyneinfo.pmdd.model.*" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self">
	<title><%=Shxx.TABLE_ALIAS%>编辑</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Shxx/updateExt.do"  theme="simple"  name="inputForm" method="post">
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	 
	    <s:hidden id="dnumber" name="dnumber" />
	      <s:hidden name="optime" value="%{model.optime}"></s:hidden>
	       <s:hidden name="ddlx" value="%{model.ddlx}"></s:hidden>
	        <s:hidden name="htid" value="%{model.htid}"></s:hidden>
	         <s:hidden name="lrrq" value="%{model.lrrq}"></s:hidden>
	          <s:hidden name="flag" value="%{model.flag}"></s:hidden>
	    
	    

	        <tr>
				      <td colspan="4" class="tb_title"> 
							<%=Shxx.TABLE_ALIAS%>编辑
				     </td>
		    </tr>
	          <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_HTID%>
		                  </td>
			              <td colspan="3">
		                            <s:property value="%{model.htid}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRXM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SHRXM}" key="shrxm" value="%{model.shrxm}"  cssClass="max-length-30" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-20 validate-number" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      有效证件
		                  </td>
			              <td>
			              
			               <mytag:select property="%{model.yxzj}"   styleClass="required validate-selection"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         <FONT color="red">*</FONT>
		                  </td>        
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_SHRSFZHM}" id="shrsfzhm" key="shrsfzhm" value="%{model.shrsfzhm}"  cssClass="max-length-18" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
	                               <s:textfield label="%{@vs@ALIAS_GZDW}" key="gzdw" value="%{model.gzdw}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BZ}" key="bz" value="%{model.bz}"  cssClass="max-length-120" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_TDR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TDR}" key="tdr" value="%{model.tdr}"  cssClass="max-length-30" required="false" />
		                             <input name="selectOrg" onclick="selectCyry(inputForm,'tdr','sdrid')"   value="选择"type="button"> 
		                            <input value="" type="hidden"  name="sdrid"  /> 
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td>
						           <input value="${model.shrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" id="shrq" name="shrq"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
		            <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
		                           赎回人照片
		                  </td>
		                   <td colspan="3">
		                    <a onclick="javascript:editPic('<s:property value="%{model.dnumber}" />','<s:property value="%{model.flag}" />');return false;" href="#">
		                            <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="180" alt="" width="150" border="0" id="photo" name="photo"> 	
		                    </a>
		                  </td>
                   </tr>
		          
	        <tr >
					 <td colspan="4" class="tb_bottom">
	                        <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                        <input type="button" value="关闭" onclick="window.close();"/>
					 </td>
			</tr>
	</table>
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		if(finalResult) {
			     if( ($F("yxzj")=="11" || $F("yxzj")=="12") && $F("shrsfzhm").length > 0  ) {
			          if(!f_check_IDno($F("shrsfzhm"))){
			             alert("身份证号错误！\r\n请重新确认身份证号，X请输入大写");	
			             finalResult = false;
			             }
			      }
		      }
		
		return disableSubmit(finalResult,'submitButton');
	}});
	
	 function selectCyry(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectCyry.do?formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
       
            
    function editPic(dnumber,flag){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/picEditFileUpload.jsp?id="+dnumber+"&type="+flag,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
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
	    pic.src='${ctx}/pages/pmdd/Shxx/showPic.do?flag=<s:property value="%{model.flag}" />&dnumber=<s:property value="%{model.dnumber}" />&rand='+rand(1000);
   }
    
</script>

</body>

</html>