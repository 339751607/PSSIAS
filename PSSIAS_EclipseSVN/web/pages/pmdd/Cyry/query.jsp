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
	<title><%=Cyry.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Cyry/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Cyry.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xm}"  name="s_xm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_XB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_xb"   notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_DWBM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwbm}"  name="s_dwbm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GMSFHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmsfhm}"  name="s_gmsfhm"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_DWNBM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwnbm}"  name="s_dwnbm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_BIRTHDAY%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect5" list="dateSelectMap"  onchange="dateselect(this,'s_birthdayBegin','s_birthdayEnd','yyyy-MM-dd');"  value="#request.dateSelect5" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3135" name="s_birthdayBegin"  value="${pageRequest.filters.birthdayBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3145\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3145" name="s_birthdayEnd"   value="${pageRequest.filters.birthdayEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3135\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zz}"  name="s_zz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_HKSZD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.hkszd}"  name="s_hkszd"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_WHCD%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_whcd"   notEmpty="false"  dictName="whcd"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GZLX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_gzlx"   notEmpty="false"  dictName="gzlx"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_RZRQ%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_rzrqBegin','s_rzrqEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31310" name="s_rzrqBegin"  value="${pageRequest.filters.rzrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31410" name="s_rzrqEnd"   value="${pageRequest.filters.rzrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_FLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_flag"   notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_LZRQ%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect12" list="dateSelectMap"  onchange="dateselect(this,'s_lzrqBegin','s_lzrqEnd','yyyy-MM-dd');"  value="#request.dateSelect12" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31312" name="s_lzrqBegin"  value="${pageRequest.filters.lzrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31412" name="s_lzrqEnd"   value="${pageRequest.filters.lzrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibFlowguid}"  name="s_tibFlowguid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibRowguid}"  name="s_tibRowguid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zzzh}"  name="s_zzzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZDZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zzdz}"  name="s_zzdz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZMM%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_zzmm"   notEmpty="false"  dictName="partyvisage"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZAPXZ_ID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zapxzId}"  name="s_zapxzId"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_ZZJGBH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zzjgbh}"  name="s_zzjgbh"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Cyry/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Cyry/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>