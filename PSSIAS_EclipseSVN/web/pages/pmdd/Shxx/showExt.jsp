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
	<title><%=Shxx.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Shxx/list.do" method="get" theme="simple">
	
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Shxx.TABLE_ALIAS%>信息
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
		                           <s:property value="%{model.shrxm}" />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
		                 
		                  
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     有效证件
		                  </td>
			              <td>
		                           <mytag:write property="%{model.yxzj}"    name="yxzj"   notEmpty="false"  dictName="T_ID_NAME"/>
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRSFZHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shrsfzhm}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_GZDW%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.gzdw}" />
		                  </td>
		                  
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_BZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.bz}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_TDR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tdr}" />
		                  </td>
		                 <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_SHRQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.shrq}" />
		                  </td>
                          
                         
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Shxx.ALIAS_LRRQ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.lrrq}" />
		                  </td>
             
                        
                   </tr>
                    <tr class="crosscolor_tr">
                           <td class="crosscolor_td" style="width: 18%">
		                           赎回人照片
		                  </td>
		                   <td colspan="3">
		                            <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="180" alt="" width="150" border="0" name="photo"> 	
		                  </td>
                   </tr>
		         
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="关闭" onclick="window.close();"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>