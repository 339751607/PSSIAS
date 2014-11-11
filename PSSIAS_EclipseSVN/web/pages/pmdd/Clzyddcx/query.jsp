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
	<title><%=Clzydd.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/pmdd/Clzydd/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Clzydd.TABLE_ALIAS%>查询</td>
		           </tr>
		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_HTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.htid}"  name="s_htid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sqr}"  name="s_sqr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_ZJHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zjhm}"  name="s_zjhm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_GZDW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gzdw}"  name="s_gzdw"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.lxdh}"  name="s_lxdh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dz}"  name="s_dz"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CPHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cphm}"  name="s_cphm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CZMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.czmc}"  name="s_czmc"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FDJH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fdjh}"  name="s_fdjh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SCCJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sccj}"  name="s_sccj"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CJHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cjhm}"  name="s_cjhm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CSYS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csys}"  name="s_csys"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_CLXH%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_clxh"   notEmpty="false"  dictName="clxh"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXSGLS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.yxsgls}"  name="s_yxsgls"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FRDB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.frdb}"  name="s_frdb"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDLX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_ddlx"   notEmpty="false"  dictName="ddlb"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDQX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ddqx}"  name="s_ddqx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWMS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwms}"  name="s_dwms"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_REMARK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.remark}"  name="s_remark"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRQ%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect19" list="dateSelectMap"  onchange="dateselect(this,'s_ddrqBegin','s_ddrqEnd','yyyy-MM-dd');"  value="#request.dateSelect19" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31319" name="s_ddrqBegin"  value="${pageRequest.filters.ddrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31419\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31419" name="s_ddrqEnd"   value="${pageRequest.filters.ddrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31319\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LRRQ%>
		                  </td>
			              <td>
				                   <s:select name="dateSelect20" list="dateSelectMap"  onchange="dateselect(this,'s_lrrqBegin','s_lrrqEnd','yyyy-MM-dd');"  value="#request.dateSelect20" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31320" name="s_lrrqBegin"  value="${pageRequest.filters.lrrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31420\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31420" name="s_lrrqEnd"   value="${pageRequest.filters.lrrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31320\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SDR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sdr}"  name="s_sdr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_TIB_FLOWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibFlowguid}"  name="s_tibFlowguid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_TIB_ROWGUID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.tibRowguid}"  name="s_tibRowguid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_OPTIME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.optime}"  name="s_optime"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SQDDJE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sqddje}"  name="s_sqddje"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_YXZJ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.yxzj}"  name="s_yxzj"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_FLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_flag"   notEmpty="false"  dictName="fcdyddFlag"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_LB%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_lb"   notEmpty="false"  dictName="clzylb"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_SFSH%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sfsh"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DDRYZP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.ddryzp}"  name="s_ddryzp"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Clzydd.ALIAS_DWZP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwzp}"  name="s_dwzp"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Clzydd/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Clzydd/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>