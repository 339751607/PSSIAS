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
	<title><%=Pmdwxxb.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/Pmdwxxb/list.do" method="get" theme="simple">
	<s:hidden name="optime" id="optime" value="%{model.optime}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Pmdwxxb.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		             <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWBM%>
		                  </td>
			              <td colspan="3">
		                      <s:property value="%{model.dwbm}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_XZQHMC%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xzqhmc}" />
		                  </td>
		                       <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_XZQHDM%>
		                  </td>
			              <td>
			                    <s:property value="%{model.xzqhdm}" />
		                  </td>
		                  </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWMC%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dwmc}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWDZ%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.dwdz}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		           	 <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_CZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cz}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YZBM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yzbm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_KYRQ%>
		                  </td>
			              <td>
		                        <s:property value="%{model.kyrq}" />
		                  </td>
                   
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FRXM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.frxm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZGBM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zgbm}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZAFZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zafzr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_BABDH%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.babdh}" />
		                  </td>
		                  </tr>
		        <tr class="crosscolor_tr">          
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_JYFW%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.jyfw}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZCZB%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zczb}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZDMJ%>（平方米）
		                  </td>
			              <td>
		                         <s:property value="%{model.zdmj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_TXXKZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.txxkzh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_TXXKZFZDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.txxkzfzdw}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YYZZBH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yyzzbh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YYZZFZDW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.yyzzfzdw}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FJDM%>
		                  </td>
			              <td>
			            
		                      <mytag:write property="%{model.fjdm}"   name="fjdm"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                          <td class="crosscolor_td">
			                     <%=Pmdwxxb.ALIAS_PCSDM%>
		                  </td>
			              <td>
		                       <mytag:write property="%{model.pcsdm}"   name="pcsdm"  notEmpty="true"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="javascript:window.history.go(-1);"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>