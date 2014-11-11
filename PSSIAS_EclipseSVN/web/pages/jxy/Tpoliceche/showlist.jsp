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

<s:form action="/jxy/Tpoliceche/list.do" method="get" theme="simple">
	<s:hidden name="checkid" id="checkid" value="%{model.checkid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="6" class="tb_title"> 
							<%=Tpoliceche.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		          <tr class="crosscolor_tr">
                          <td align="right">
			                    <%=Tpoliceche.ALIAS_DEPTID%>
		                  </td>
			              <td width="30%">
		                           
		                 
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
		            <td class="crosscolor_td" >
			                      <%=Tpoliceche.ALIAS_CHECKTIME%>
		                  </td>
			              <td >
		                 		<s:property value="%{model.checktimeString}"/>
		                  </td>		           
		            <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DISPOSE%>
		                  </td>
			              <td>
			           
		                     <mytag:write property="%{model.dispose}"   name="dispose"  notEmpty="true"  dictName="qlyj"/>       
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEADLINE%>
		                  </td>
			              <td >
		              
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
		           
		            <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_IMPLEMENT%>
		                  </td>
			              <td>
		                  	 <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='implement=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='implement=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                        
		                        
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                <s:property value="%{model.implementInput}"/>	
		                 </td>
		                
                         
                         
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_VISITOR%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='visitor=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='visitor=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		               
		                 <s:property value="%{model.visitorInput}"/>	 
		                 </td>
		                
                         
                         
                   </tr>
                     <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_DUTY%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='duty=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='duty=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		               <s:property value="%{model.dutyInput}"/>	 
		                 </td>  
                   </tr>
                   <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_FINANCE%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='finance=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='finance=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                <s:property value="%{model.financeInput}"/>	
		                 </td>  
                   </tr>
                    <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_SPEECH%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='speech=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='speech=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                  
               <s:property value="%{model.speechInput}"/>		                
</td>  
                   </tr>
                      <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_ENTERING%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='entering=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='entering=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                <s:property value="%{model.enteringInput}"/>
		                 </td>  
                   </tr>
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_SYSTEM_NORMAL_USE%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='systemNormalUse=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='systemNormalUse=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                
		                   <s:property value="%{model.systemInput}"/>
		                 </td>  
                   </tr>
                   
                        <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_INTRADAYNEWS%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='intradaynews=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='intradaynews=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                  
		                 <s:property value="%{intradaynewsInput}"/>
		                 </td>  
                   </tr>
		     
		     
		     
		        <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_JDCMAINTAIN%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='jdcmaintain=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='jdcmaintain=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                  
		                 <s:property value="%{model.jdcmaintainInput}"/>
		                 </td>  
                   </tr>
                   
                   
                           <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_UPLOADQUANTITYIS%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='uploadquantityis=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='uploadquantityis=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                  
		                 <s:property value="%{model.uploadquantityiInput}"/>
		                 </td>  
                   </tr>
                   
                   
                   
                          <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_UPLOADTIMELY%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='uploadtimely=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='uploadtimely=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                 <s:property value="%{model.uploadtimelyInput}"/>
		                 </td>  
                   </tr>
                   
                   
                         <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_SAFETY%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='safety=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='safety=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                 <s:property value="%{model.safetyInput}"/>
		                 </td>  
                   </tr>
                       <tr class="crosscolor_tr">
                      <td class="crosscolor_td" colspan="2">
			                      <%=Tpoliceche.ALIAS_PROTECTION%>
		                  </td>
			              <td >
		                        
		                        <table class="crosscolor_td" >
			                   <tr>
		                           <td >
		                        <s:if test='protection=="0"'>
		                        <s:label>是</s:label>
		                        </s:if>
		                        <s:elseif test='protection=="1"'>
		                        <s:label>否</s:label>
		                        </s:elseif>
		                           
		                  </td>
		                       </tr>
		                     </table> 
		                           
		                  </td>
		                 <td colspan="3">
		                 
		                <s:property value="%{model.protectionInput}"/>
		                 </td>  
                   </tr>
		       
		       

                   <tr>
						  <td colspan="6" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/tpoliCk/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
