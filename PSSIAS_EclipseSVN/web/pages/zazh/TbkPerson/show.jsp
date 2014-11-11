<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

String picCount = "";
 if(request.getAttribute("picCount") != null)
       picCount= (String)request.getAttribute("picCount");

%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TbkPerson.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TbkPerson/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TbkPerson.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xm}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hjd}" />
		                  </td>
		                  <td rowspan="7" width="20%">
		                          <%if(picCount != null && picCount.equals("1")) { %>
						             <img src='${ctx}/pages/zazh/TbkPerson/showPic.do?bkid=<s:property value="%{model.id}" />' height="150" alt="照片" width="120" border="0" name="photo"> 	
						           <% } else {%>
						           <IMG src="${ctx}/images/spacer.gif" height="150" alt="照片" width="120" border="0" name="photo">
						           <%} %>                
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sfzh}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XB%>
		                  </td>
			              <td>
		                         <mytag:write  name="xb"  value="${model.xb}"   dictName="T_DIC_SEX"  />		                  
		                  </td>                          
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm1}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:property value="%{model.hm2}" />
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_JG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jg}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zz}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_SG%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sg}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TX%>
		                  </td>
			              <td>
		                           <mytag:write  name="tx"  value="${model.tx}"   dictName="DIC_TEM_SHAPE"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TSTZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tstz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.xh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_AB%>
		                  </td>
			              <td>
		                           <mytag:write  name="ab"  value="${model.ab}"   dictName="DIC_ITEM_AJLX"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.ladw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LASJ%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.lasj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_PZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.pzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LXR%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.lxr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:property value="%{model.lxdh}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ZTSJ%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.ztsj}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_JYAQ%>
		                  </td>
			              <td colspan="4">
		                           <s:property value="%{model.jyaq}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf1}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF2%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.taf2}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF3%>
		                  </td>
			              <td>
		                           <s:property value="%{model.taf3}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF4%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.taf4}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH1%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjh1}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH2%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.tjh2}" />
		                  </td>
                       
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH3%>
		                  </td>
			              <td>
		                           <s:property value="%{model.tjh3}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TBDW%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.deptname}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKLX%>
		                  </td>
			              <td>
		                           <mytag:write  name="bklx"  value="${model.bklx}"  notEmpty="false"  dictName="DIC_ITEM_BKLX"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ALARM_TEL%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.alarmTel}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bkpzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CZR%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.czr}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bksj}" />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELFLAG%>
		                  </td>
			              <td colspan="2">
		                           <mytag:write  name="cancelflag"  value="${model.cancelflag}"   dictName="DIC_ITEM_CKBZ"  />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cancelname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELTIME%>
		                  </td>
			              <td colspan="2">
		                           <s:property value="%{model.canceltime}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td colspan="4">
		                           <s:property value="%{model.cancelcause}" />
		                  </td>
                         
                   </tr>
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TbkPerson/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>