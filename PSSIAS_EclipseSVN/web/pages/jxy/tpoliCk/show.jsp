<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tpoliceche.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/jxy/Tpoliceche/list.do" method="get" theme="simple">
	<s:hidden name="checkid" id="checkid" value="%{model.checkid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="6" class="tb_title"> 
							<%=Tpoliceche.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		          <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <%=Tpoliceche.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           
		                 
		                 <s:property  value="%{model.companyinfo}"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME1%>
		                  </td>
			              <td>
		                          
		                  <s:property value="%{model.checkname1}"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME2%>
		                  </td>
			              <td>
		                         
		                <s:property value="%{model.checkname2}"/>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		            
                          
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_COMPANYINFO%>
		                  </td>
			              <td>
		                          
		                          
		               				<s:property value="%{model.deptid}"/>
		                
		                  </td>
		                  
		                  <td class="crosscolor_td">
			                       <%=Tpoliceche.ALIAS_EXAMINE%>
		                  </td>
			              <td>
			          
		                   
		                      <mytag:write property="%{model.examine}"   name="examine"  notEmpty="true"  dictName="jxfs"/> 
		                 
		                  </td>
		                  <td class="crosscolor_td">
			                     <%=Tpoliceche.ALIAS_ACCEPTCHECKNAME%>
		                 
		                  </td>
			               <td>
		                    
		                  	<s:property value="%{model.acceptcheckname}"/>
		                  
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DISPOSE%>
		                  </td>
			              <td>
			           
		                     <mytag:write property="%{model.dispose}"   name="dispose"  notEmpty="true"  dictName="qlyj"/>       
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEADLINE%>
		                  </td>
			              <td colspan="3">
		              
		                <s:property value="%{model.deadlineString}"/>
		                  </td>
                         
                         
                   </tr>
                   <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_REMARK%>
		                  </td>
			           
 <td colspan="5">
		                           
							<s:property  value="%{model.remark}"/>
		                         
		                                  
 </td>
                         
                   </tr>
                   
                    <tr class="crosscolor_tr">
		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_IMPLEMENT%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="implement" value="0"  ${implement == 0?"checked":"" }>是
		                        <input type="radio" name="implement" value="1"   ${implement == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                <s:property value="%{model.implementInput}"/>	
		                 </td>
		                
                         
                         
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_VISITOR%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="visitor" value="0" ${visitor == 0?"checked":"" }>是
		                        <input type="radio" name="visitor" value="1"  ${visitor == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		               
		                 <s:property value="%{model.visitorInput}"/>	 
		                 </td>
		                
                         
                         
                   </tr>
                     <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DUTY%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="DUTY" value="0" ${duty == 0?"checked":"" }>是
		                        <input type="radio" name="DUTY" value="1" ${duty == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		               <s:property value="%{model.dutyInput}"/>	 
		                 </td>  
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_FINANCE%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="finance" value="0" ${finance == 0?"checked":"" }>是
		                        <input type="radio" name="finance" value="1" ${finance == 1	?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                <s:property value="%{model.financeInput}"/>	
		                 </td>  
                   </tr>
                    <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SPEECH%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="speech" value="0" ${speech == 0?"checked":"" }>是
		                        <input type="radio" name="speech" value="1"  ${speech == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                  
               <s:property value="%{model.speechInput}"/>		                
</td>  
                   </tr>
                      <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ENTERING%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="entering" value="0" ${entering == 0?"checked":"" }>是
		                        <input type="radio" name="entering" value="1" ${entering == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                <s:property value="%{model.enteringInput}"/>
		                 </td>  
                   </tr>
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SYSTEM_NORMAL_USE%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="systemNormalUse" value="0" ${systemNormalUse == 0?"checked":"" }>是
		                        <input type="radio" name="systemNormalUse" value="1" ${systemNormalUse == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                
		                   <s:property value="%{model.systemInput}"/>
		                 </td>  
                   </tr>
                   
                        <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_INTRADAYNEWS%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="intradaynews" value="0" ${intradaynews == 0?"checked":"" }>是
		                        <input type="radio" name="intradaynews" value="1" ${intradaynews == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                  
		                 <s:property value="%{intradaynewsInput}"/>
		                 </td>  
                   </tr>
		     
		     
		     
		        <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_JDCMAINTAIN%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="jdcmaintain" value="0" ${jdcmaintain == 0?"checked":"" }>是
		                        <input type="radio" name="jdcmaintain" value="1" ${jdcmaintain == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                  
		                 <s:property value="%{model.jdcmaintainInput}"/>
		                 </td>  
                   </tr>
                   
                   
                           <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADQUANTITYIS%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="uploadquantityis" value="0" ${uploadquantityis == 0?"checked":"" }>是
		                        <input type="radio" name="uploadquantityis" value="1" ${uploadquantityis == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                  
		                 <s:property value="%{model.uploadquantityiInput}"/>
		                 </td>  
                   </tr>
                   
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADTIMELY%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="uploadtimely" value="0" ${uploadtimely == 0?"checked":"" }>是
		                        <input type="radio" name="uploadtimely" value="1" ${uploadtimely == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                 <s:property value="%{model.uploadtimelyInput}"/>
		                 </td>  
                   </tr>
                   
                   
                         <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SAFETY%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="safety" value="0" ${safety == 0?"checked":"" }>是
		                        <input type="radio" name="safety" value="1" ${safety == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                 <s:property value="%{model.safetyInput}"/>
		                 </td>  
                   </tr>
                       <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_PROTECTION%>
		                  </td>
			              <td >
		                        
		                        <input type="radio" name="protection" value="0" ${protection == 0?"checked":"" }>是
		                        <input type="radio" name="protection" value="1" ${protection == 1?"checked":"" }>否
		                           
		                  </td>
		                 <td colspan="4">
		                 
		                <s:property value="%{model.protectionInput}"/>
		                 </td>  
                   </tr>
		       
		       
		           <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKTIME%>
		                  </td>
			              <td colspan="5">
		                        
		                 <s:property value="%{model.checktimeString}"/>
		                  </td>
                          
                        
                   </tr>
                   <tr>
						  <td colspan="6" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/jxy/Tpoliceche/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
