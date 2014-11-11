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
			              <td width="25%">
		                           <s:property value="%{model.name}" />
		                  </td>
		                  <td class="crosscolor_td" width="25%">
			                      <%=TalarmPerson.ALIAS_NATION%>
		                  </td>
			              <td width="25%">
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
			                      企业名称
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />（<s:property value="%{model.cpcode}" />）
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
		                           <s:property value="%{model.deptname}" />
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
			               <mytag:write  name="validflag"  value="${model.validflag}" dictName="T_DICT_VALID"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CJSJ%>
		                  </td>
			              <td>
			                <s:property value="%{model.cjsj}" />                          
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_VOIDCAUSE%>
		                  </td>
			              <td colspan="3">
									<s:property value="%{model.voidcause}" />
		                  </td>
                        
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHFLAG%>
		                  </td>
			              <td colspan="3">
		                           <mytag:write  name="zhflag"  
	         			             value="${model.zhflag}" dictName="DIC_ITEM_ZHQK"/>
	         			             
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHDW%>
		                  </td>
			              <td>
			                      <s:property value="%{model.zhdw}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ZHSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.zhsj}" />
		                        
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_WZHYY%>
		                  </td>
			              <td  colspan="3">		                         
								<s:property value="%{model.wzhyy}" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_CLQK%>
		                  </td>
			              <td colspan="3">
									<s:property value="%{model.clqk}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELFLAG%>
		                  </td>
			              <td colspan="3">	                       
			                      <s:property value='#request.cancelflag'/>                  
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td colspan="3">
									<s:property value='#request.cancelcause' />
		                  </td>                       
                   </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TalarmPerson/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
