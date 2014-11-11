<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title>人员处警</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TalarmPerson/alarmsave.do" method="post" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<input type="hidden" name="returnUrl" value="!/pages/zazh/TalarmPerson/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
	    
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							人员处警
				          </td>
		           </tr>

		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td" width="25%">
			                      <%=TalarmPerson.ALIAS_NAME%>
		                  </td>
			              <td  width="25%">
		                           <s:property value="%{model.name}" />
		                  </td>
		                  <td class="crosscolor_td"  width="25%">
			                      <%=TalarmPerson.ALIAS_NATION%>
		                  </td>
			              <td  width="25%">
		                            <mytag:write  name="nation" value="${model.nation}"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_SEX%>
		                  </td>
			              <td>
		                            <mytag:write  name="sex" value="${model.sex}"  dictName="T_DIC_SEX"/>	    
		                  </td>
                           <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDNAME%>
		                  </td>
			              <td>
		                           <mytag:write  name="idname" value="${model.idname}"  dictName="T_ID_NAME"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_IDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idcode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">


                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_HJD%>
		                  </td>
			              <td  colspan="3">
		                           <s:property value="%{model.hjd}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.address}" />
		                  </td>                         
                   </tr>
                   <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                          <mytag:write  name="bktype" value="${model.bktype}"  dictName="DIC_ITEM_BKLX"/>
		                  </td>        
		                            
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.alarmtime}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMSOURCE%>
		                  </td>
			              <td>
		                           <mytag:write  name="alarmsource" value="${model.alarmsource}"  dictName="T_ITEM_BUSSINESS"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      报警企业
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />(<s:property value="%{model.cpcode}" />)
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
		                           <mytag:write  name="alarmtype" value="${model.alarmtype}"  dictName="DIC_ITEM_ALARMTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BUSINESSTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.businesstime}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJDW%>
		                  </td>
			              <td>
			                      <input type="hidden" name="cjdw" value="<%=request.getAttribute("deptid") %>"  /> 
		                           <s:property value="%{model.cjdw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJR%>
		                  </td>
			              <td>
			                       <input type="hidden" name="cjr" value="<s:property value='%{model.cjr}' />"  /> 
		                           <s:property value="%{model.cjr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VALIDFLAG%>
		                  </td>
			              <td>
			               <mytag:select  name="validflag"  styleClass="required validate-selection"
	         			    onchange="validChange()"   value="${model.validflag}" dictName="T_DICT_VALID"/><FONT color="red">*</FONT>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJSJ%>
		                  </td>
			              <td>
                            <input id="d31312" name="cjsj"  value="<s:property value='%{model.cjsj}' />"   maxlength="0" size="20" class="required Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
			              <FONT color="red">*</FONT>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_VOIDCAUSE}" key="voidcause"  cssClass="max-length-50" required="false"
									value="%{model.voidcause}" rows="3" cols="60"></s:textarea>
		                  </td>
                        
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHFLAG%>
		                  </td>
			              <td colspan="3">
		                           <mytag:select  name="zhflag"  styleClass="required validate-selection"
	         			             value="${model.zhflag}" dictName="DIC_ITEM_ZHQK"/>
	         			             <FONT color="red">*</FONT>
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHDW%>
		                  </td>
			              <td>
			                      <s:textfield label="%{@vs@ALIAS_ZHDW}" key="zhdw" value="%{model.zhdw}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhsj}" />
		                           <input id="d31313" name="zhsj"  value="<s:property value='%{model.zhsj}' />"   maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
			              
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_WZHYY%>
		                  </td>
			              <td  colspan="3">		                         
		                         <s:textarea label="%{@vs@ALIAS_WZHYY}" key="wzhyy"  cssClass="max-length-50" required="false"
									value="%{model.wzhyy}" rows="3" cols="60"></s:textarea>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLQK%>
		                  </td>
			              <td colspan="3">
		                         <s:textarea label="%{@vs@ALIAS_CLQK}" key="clqk"  cssClass="max-length-100" required="false"
									value="%{model.clqk}" rows="3" cols="60"></s:textarea>
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELFLAG%>
		                  </td>
			              <td colspan="3">
			                       <input type="hidden" name="clflag" value="1" />			                       
			                       <mytag:select  name="cancelflag"    styleClass="required validate-selection"
	         			                 value="%{model.cancelflag}" dictName="shiFou"/>	
	         			                 <FONT color="red">*</FONT>	                      
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_CANCELCAUSE}" key="cancelcause"  cssClass="required max-length-200" required="false"
									value="" rows="6" cols="60"></s:textarea>
									
		                  </td>                       
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						          <input id="submitButton" name="submitButton" type="submit" value="提交" />
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;

        //	如果“是否有效”选择“无效”，则无效原因必填、
        var validflag = document.getElementById("validflag").value;
        var voidcause = document.getElementById("voidcause").value; 
              
        if(validflag == "0" && voidcause=="" ){
            alert("如果报警无效，请填写无效原因！");
            finalResult =  false;
            return false;
        }
             //	如果“抓获情况”选择“未抓获”，未抓获原因、处理情况必填。
        var zhflag = document.getElementById("zhflag").value;
        var wzhyy = document.getElementById("alarmsave_wzhyy").value;
        var clqk = document.getElementById("alarmsave_clqk").value;  
        
        if(zhflag == "1"){
            if(wzhyy=="" ){
	            alert("如果抓获情况选择未抓获，请填写未抓获原因！");
	            finalResult =  false;
	            return false;
            }
            if(clqk=="" ){
	            alert("如果抓获情况选择未抓获，处理情况不能为空！");
                finalResult =  false;
                return false;
            }  
        }
          //	如果“抓获情况”选择“已抓获”，抓获单位、抓获时间、处理情况必填。  
        var zhdw = document.getElementById("zhdw").value;
        var zhsj = document.getElementById("zhsj").value;
        if(zhflag == "0"){
             if(zhdw=="" ){
	            alert("如果抓获情况选择了已抓获，抓获单位不能为空！");
                finalResult =  false;
                return false;
            }
            if(zhsj=="" ){
	            alert("如果抓获情况选择了已抓获，抓获时间不能为空！");
                finalResult =  false;
                return false;
            }
            if(clqk=="" ){
	            alert("如果抓获情况选择了已抓获，处理情况不能为空！");
                finalResult =  false;
                return false;
            }
        }
        //	如果“是否撤控”选择“是”，撤控原因必填
        
        var cancelflag = document.getElementById("cancelflag").value;
        var cancelcause = document.getElementById("alarmsave_cancelcause").value;        
        if(cancelflag=="1"){
           if(cancelcause=="" ){
	            alert("如果是否撤控选择撤控，请填写撤控原因！");
                finalResult =  false;
                return false;
            }
        }
        
		return disableSubmit(finalResult,'submitButton');
		
	}});
	
	function validChange(){
	    var validflag = document.getElementById("validflag").value;
	    if( validflag == "0"){
	        document.getElementById("zhflag").value = "1";
	    }else{
	        document.getElementById("zhflag").value = "";
	    }
	}
</script>