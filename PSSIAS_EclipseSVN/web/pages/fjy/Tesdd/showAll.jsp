<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tesdd.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tesdd/listAll.do" method="get" theme="simple">
	<s:hidden name="dnid" id="dnid" value="%{model.dnid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tesdd.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.ddlx}"   name="ddlx"  notEmpty="true"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dnpp}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.dnxh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zbh}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yph}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zc}" />
		                  </td>
                   </tr>
                   
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.macdz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_GMSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.gmsj}" />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushoury}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.chushourenxb}"   name="chushourenxb"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourensfzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chushourenlxdh}" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DQSJH%>
		                  </td>
			             <td colspan="3">
		                           <s:property value="%{model.dqsjh}" />
		                  </td>
		                    
                         
                   </tr>
		           <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRJTZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.csrjtzz}" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_BEIZHU%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.beizhu}" />
		                  </td>
                         
                   </tr>
		          
		          
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_SGSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sgsj}" />
		                  </td>
                  
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jbrXm}" />
		                  </td>
                        
                   </tr>
                    
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tesdd/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>