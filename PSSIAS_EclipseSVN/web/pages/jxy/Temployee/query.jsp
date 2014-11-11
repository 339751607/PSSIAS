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
	<title><%=Temployee.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/jxy/Temployee/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.name}"  name="s_name"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'s_birthBegin','s_birthEnd','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3133" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ALIAS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.alias}"  name="s_alias"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_folk"   notEmpty="false"  dictName="T_DIC_NATION"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_nativeplace"   notEmpty="false"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POLITYVISAGE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_polityvisage"   notEmpty="false"  dictName="T_DIC_POLITYVISAGE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_schoolage"   notEmpty="false"  dictName="T_DIC_SCHOOLAGE"/>
		                  </td>
                          <td class="crosscolor_td">
			                    
		                  </td>
			              <td>
				                   <mytag:select  name="s_hyzh"   notEmpty="false"  dictName="T_DIC_HYZK"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stature}"  name="s_stature"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.weight}"  name="s_weight"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_POSTURE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_posture"   notEmpty="false"  dictName="T_DIC_SHAPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPCODE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_npcode"   notEmpty="false"  dictName="T_DIC_XZQH"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.npaddress}"  name="s_npaddress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cyrjzt"   notEmpty="false"  dictName="T_DIC_CYRJZT"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_TEMPORARYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.temporarycode}"  name="s_temporarycode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NOWADRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nowadress}"  name="s_nowadress"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_INSERTTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect20" list="dateSelectMap"  onchange="dateselect(this,'s_inserttimeBegin','s_inserttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect20" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31320" name="s_inserttimeBegin"  value="${pageRequest.filters.inserttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Temployee.FORMAT_INSERTTIME%>',maxDate:'#F{$dp.$D(\'d31420\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31420" name="s_inserttimeEnd"   value="${pageRequest.filters.inserttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Temployee.FORMAT_INSERTTIME%>',minDate:'#F{$dp.$D(\'d31320\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EDITTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect21" list="dateSelectMap"  onchange="dateselect(this,'s_edittimeBegin','s_edittimeEnd','yyyy-MM-dd');"  value="#request.dateSelect21" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31321" name="s_edittimeBegin"  value="${pageRequest.filters.edittimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Temployee.FORMAT_EDITTIME%>',maxDate:'#F{$dp.$D(\'d31421\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31421" name="s_edittimeEnd"   value="${pageRequest.filters.edittimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Temployee.FORMAT_EDITTIME%>',minDate:'#F{$dp.$D(\'d31321\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Temployee/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Temployee/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>
