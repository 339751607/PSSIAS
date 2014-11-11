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

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Clzyddcx/list.do" method="get" theme="simple">
	<s:hidden name="dnumber" id="dnumber" value="%{model.dnumber}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Clzydd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td width="15%" class="crosscolor_td">
			                      <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.htid}" />
		                  </td>
                          <td width="15%" class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sqr}" />
		                  </td>
		                   <td  width="20%" align="center" >
		                          申请人照片
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zjhm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gzdw}" />
		                  </td>
		                   <td rowspan="5" width="18%" align="center" >
			     
		                   <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'" height="126" alt="" width="102" border="0" name="photo"> 	
		          
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
			                      <%=Clzydd.ALIAS_DZ%>
		                  </td>
			              <td>
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
		                  <td align="center">
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
		                   <td rowspan="6" width="18%" align="center" >
			     
		                   <img src='${ctx}/images/spacer.gif'  onerror="this.src='${ctx}/images/spacer.gif'"
 height="126" alt="" width="102" border="0" name="photo"> 	
		          
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
			                      <%=Clzydd.ALIAS_OPTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.optime}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.sfsh}"   name="sfsh"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
		 
		           
		          
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>