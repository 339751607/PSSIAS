<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Dczydd.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Dczydd/htcxList.do" method="get" theme="simple">
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
			                   <table width="100%" align="center">
							<tr>
								<td style="border: none;" align="center">
									<img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
								</td>
							</tr>
						   </table>
		                   
		                   </td>
		                    <td rowspan="7" width="15%" align="center" valign="middle"   >
			                <table width="100%" align="center">
							<tr>
								<td style="border: none;" align="center">
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
			               <table width="100%" align="center">
							<tr>
								<td style="border: none;" align="center">
									 <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
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
						 	<c:if test="${model.sfsh=='1'}">
						    赎回信息：&nbsp;&nbsp;
										 <input type="button" value="查看" onclick="javascript:view('<s:property value="%{model.dnumber}" />');return false;"/>
						   </c:if>
						           
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>
</html>

<script>
 function redeem(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/redeem.do?type=D&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
		 if (returnvalue == "yes")
	        window.location.href= "${ctx}/pages/pmdd/Dczydd/redeemEdit.do?dnumber="+dnumber+"&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";				
    } 
 function view(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/showExt.do?type=D&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
   } 
 function updates(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/editExt.do?type=D&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
   }
   
</script>