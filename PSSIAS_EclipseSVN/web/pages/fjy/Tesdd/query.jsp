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
	<title><%=Tesdd.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Tesdd/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tesdd.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DDLX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_ddlx"   notEmpty="false"  dictName="T_DIC_JQLX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNPP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dnpp}"  name="s_dnpp"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DNXH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dnxh}"  name="s_dnxh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZBH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zbh}"  name="s_zbh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_YPH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.yph}"  name="s_yph"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_ZC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zc}"  name="s_zc"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushoury}"  name="s_chushoury"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_chushourenxb"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushourensfzh}"  name="s_chushourensfzh"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_BEIZHU%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.beizhu}"  name="s_beizhu"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CHUSHOURENLXDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushourenlxdh}"  name="s_chushourenlxdh"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tesdd.ALIAS_MACDZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.macdz}"  name="s_macdz"  />
		                  </td>
                          <td class="td_tb">
			                      <%=Tesdd.ALIAS_SGSJ%>
		                  </td>
			              <td class="td_input">
				                   <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_sgsjBegin','s_sgsjEnd','yyyy-MM-dd HH:mm:ss');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_sgsjBegin"  value="${pageRequest.filters.sgsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_sgsjEnd"   value="${pageRequest.filters.sgsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_DQSJH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dqsjh}"  name="s_dqsjh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_CSRJTZZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csrjtzz}"  name="s_csrjtzz"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                         
                          <td class="td_tb">
			                      <%=Tesdd.ALIAS_GMSJ%>
		                  </td>
			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect17" list="dateSelectMap"  onchange="dateselect(this,'s_gmsjBegin','s_gmsjEnd','yyyy-MM-dd HH:mm:ss');"  value="#request.dateSelect17" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31317" name="s_gmsjBegin"  value="${pageRequest.filters.gmsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'d31417\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31417" name="s_gmsjEnd"   value="${pageRequest.filters.gmsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d31317\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tesdd.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jbr}"  name="s_jbr"  />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tesdd/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tesdd/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>