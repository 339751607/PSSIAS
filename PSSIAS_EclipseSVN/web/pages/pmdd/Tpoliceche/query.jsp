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
	<title><%=Tpoliceche.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Tpoliceche/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tpoliceche.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acceptcheckname}"  name="s_acceptcheckname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checkname1}"  name="s_checkname1"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAMEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checknamephone}"  name="s_checknamephone"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKTIME%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect4" list="dateSelectMap"  onchange="dateselect(this,'s_checktimeBegin','s_checktimeEnd','yyyy-MM-dd');"  value="#request.dateSelect4" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3134" name="s_checktimeBegin"  value="${pageRequest.filters.checktimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_CHECKTIME%>',maxDate:'#F{$dp.$D(\'d3144\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3144" name="s_checktimeEnd"   value="${pageRequest.filters.checktimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_CHECKTIME%>',minDate:'#F{$dp.$D(\'d3134\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checkname2}"  name="s_checkname2"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ENTERING%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.entering}"  name="s_entering"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_VISITOR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visitor}"  name="s_visitor"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DUTY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.duty}"  name="s_duty"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_FINANCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.finance}"  name="s_finance"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SPEECH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.speech}"  name="s_speech"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_IMPLEMENT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.implement}"  name="s_implement"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_IMPLEMENT_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.implementInput}"  name="s_implementInput"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_VISITOR_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.visitorInput}"  name="s_visitorInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DUTY_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dutyInput}"  name="s_dutyInput"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_FINANCE_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.financeInput}"  name="s_financeInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SPEECH_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.speechInput}"  name="s_speechInput"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ENTERING_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enteringInput}"  name="s_enteringInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SYSTEM_NORMAL_USE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.systemNormalUse}"  name="s_systemNormalUse"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SYSTEM_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.systemInput}"  name="s_systemInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_INTRADAYNEWS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.intradaynews}"  name="s_intradaynews"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_INTRADAYNEWS_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.intradaynewsInput}"  name="s_intradaynewsInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_JDCMAINTAIN%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdcmaintain}"  name="s_jdcmaintain"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_JDCMAINTAIN_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jdcmaintainInput}"  name="s_jdcmaintainInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADQUANTITYIS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.uploadquantityis}"  name="s_uploadquantityis"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADQUANTITYI_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.uploadquantityiInput}"  name="s_uploadquantityiInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADTIMELY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.uploadtimely}"  name="s_uploadtimely"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_UPLOADTIMELY_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.uploadtimelyInput}"  name="s_uploadtimelyInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SAFETY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.safety}"  name="s_safety"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_SAFETY_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.safetyInput}"  name="s_safetyInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_PROTECTION%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.protection}"  name="s_protection"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_PROTECTION_INPUT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.protectionInput}"  name="s_protectionInput"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DISPOSE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dispose}"  name="s_dispose"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_EXAMINE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.examine}"  name="s_examine"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_COMPANYINFO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.companyinfo}"  name="s_companyinfo"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_REMARK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.remark}"  name="s_remark"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEADLINE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect36" list="dateSelectMap"  onchange="dateselect(this,'s_deadlineBegin','s_deadlineEnd','yyyy-MM-dd');"  value="#request.dateSelect36" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31336" name="s_deadlineBegin"  value="${pageRequest.filters.deadlineBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',maxDate:'#F{$dp.$D(\'d31436\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31436" name="s_deadlineEnd"   value="${pageRequest.filters.deadlineEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',minDate:'#F{$dp.$D(\'d31336\')}'})"/>
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Tpoliceche/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Tpoliceche/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>