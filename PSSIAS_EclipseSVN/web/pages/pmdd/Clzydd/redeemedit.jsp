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
	<title><%=Clzydd.TABLE_ALIAS%>信息</title>
</head>

<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Clzydd/list.do" method="get" theme="simple">
	<s:hidden name="dnumber" id="dnumber" value="%{model.dnumber}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="6" class="tb_title"> 
							<%=Clzydd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		            <tr class="crosscolor_tr">
		           		<td width="13%" class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMC%>
		                  </td>
			              <td  colspan="5">
		                           <s:property value="%{model.dwmc}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td width="13%" class="crosscolor_td">
			                      <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td width="22%">
		                           <s:property value="%{model.htid}" />
		                  </td>
                          <td width="13%" class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQR%>
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
			              
			               <mytag:write property="%{model.yxzj}"  name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zjhm}" />
		                  </td>
                         
		                   <td rowspan="6" width="15%" align="center" >
			                     <table align="center">
									<tr>
										<td align="center">
											 <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
										</td>
									</tr>
								</table>
		                  
		                   </td>
		                    <td rowspan="6" width="15%" align="center" >
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
			                      <%=Clzydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gzdw}" />
		                  </td>
		             </tr>
		           <tr class="crosscolor_tr">      
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CPHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cphm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CZMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.czmc}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FDJH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fdjh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SCCJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sccj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CJHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cjhm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CSYS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.csys}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CLXH%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.clxh}"   name="clxh"  notEmpty="true"  dictName="clxh"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXSGLS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yxsgls}" />
		                  </td>
		                   <td align="center"  colspan="2">
		                                                    当物照片
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.frdb}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDLX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.ddlx}"   name="ddlx"  notEmpty="true"  dictName="ddlb"/>
		                  </td>
		                 
		                   <td rowspan="5" width="15%"  colspan="2" align="center" >
			      <table align="center">
									<tr>
										<td align="center">
											 <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'"
 height="126" alt="" width="102" border="0" name="photo"> 	
										</td>
									</tr>
								</table>
		                  
		          
		                   </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddqx}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dwms}" />
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_REMARK%>
		                  </td>
			              <td>
		                           <s:property value="%{model.remark}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ddrq}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lrrq}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sdr}" />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td colspan="3">
			                       <mytag:write property="%{model.sfsh}"   name="sfsh"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		        
                   <tr>
						  <td colspan="6" class="tb_bottom">
						        <c:choose>
									<c:when test="${model.sfsh =='0'}">
										 <input type="button" value="赎回" onclick="javascript:redeem('<s:property value="%{model.dnumber}" />');return false;"/>
									</c:when>
									<c:when test="${model.sfsh =='1'}">
									      赎回信息:&nbsp;&nbsp;
										 <input type="button" value="查看" onclick="javascript:view('<s:property value="%{model.dnumber}" />');return false;"/>
										 <input type="button" value="修改" onclick="javascript:updates('<s:property value="%{model.dnumber}" />');return false;"/>
									</c:when>
									<c:otherwise>
										 <input type="button" value="赎回" onclick="javascript:redeem('<s:property value="%{model.dnumber}" />');return false;"/>
									</c:otherwise>
								</c:choose>
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/pmdd/Clzydd/redeemList.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
<script>
 function redeem(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/redeem.do?type=C&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
		 if (returnvalue == "yes")
	        window.location.href= "${ctx}/pages/pmdd/Clzydd/redeemEdit.do?dnumber="+dnumber+"&<mytag:params includes="ec*,s*" type="queryStringUtf"/>";				
    } 
 function view(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/showExt.do?type=C&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
   } 
 function updates(dnumber){				
	     var returnvalue = window.showModalDialog("${ctx}/pages/pmdd/Shxx/editExt.do?type=C&dnumber="+dnumber,"childWIn","dialogHeight:480px;dialogWidth:700px;scroll:off;center:yes");
   } 
 
</script>