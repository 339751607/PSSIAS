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
	<title><%=Tfeijiuwupin.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form  name="queryForm" action="/pages/fjy/Tfeijiuwupin/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
 				    <tr>
			              <td class="tb_title" colspan="4"><%=Tfeijiuwupin.TABLE_ALIAS%>查询</td>
		           </tr>
 					<tr class="crosscolor_tr">
		            	<td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGR%>
		                  </td>
			              <td  colspan="3">
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>


                   </tr>
                      <tr  class="tr_tb">
                   		      <td class="td_tb"">
			                      <%=Tfeijiuwupin.ALIAS_SHOUGOURQ%>
		                  </td>
			              <td colspan="3" class="td_input" >
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('dateSelect2','d3132','d3142','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_shougourqBegin"  value="${pageRequest.filters.shougourqBegin}"   maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3142\')}'})"/>到
			                        <input id="d3142" name="s_shougourqEnd"   value="${pageRequest.filters.shougourqEnd}"  maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3142\')}'})"/>
		                  </td>
		            </tr>
                   <tr  class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csrxm}"  name="s_csrxm"  />
		                  </td>
                  <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.chushourensfzh}"  name="s_chushourensfzh"  />
		                  </td>
                   </tr>
                       <tr class="crosscolor_tr">
        
                          <td class="crosscolor_td">
			                    <%=Tcsrxx.ALIAS_NPCODE%>
			             	
		                  </td>
		                  <td colspan="3"><%@ include file="/commons/xzqhselect.jsp" %>   
		                  </td>
                   </tr>	
		           <tr class="crosscolor_tr">
        
                          <td class="crosscolor_td">
			                      <%=Tcsrxx.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="3">
			             	 <input value="${pageRequest.filters.npaddress}" size="70" name="s_npaddress"  />
		                  </td>
                   </tr>
                  <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      出售人户籍地
		                  </td>
			              <td colspan="3">
			             	 <input value="${pageRequest.filters.hjaddress}" size="70" name="s_hjaddress"  />
		                  </td>
                   </tr>	
<!--		           <tr class="crosscolor_tr">-->
<!--        -->
<!--                          <td class="crosscolor_td">-->
<!--			                      <%=Tcsrxx.ALIAS_PRADDRESS%>-->
<!--		                  </td>-->
<!--			              <td colspan="3">-->
<!--			             	 <input value="${pageRequest.filters.praddress}" size="70" name="s_praddress"  />-->
<!--		                  </td>-->
<!--                   </tr>	-->
			       <tr class="crosscolor_tr">
			        <td class="crosscolor_td">
			            	  所属分局 
		           </td>
			        <td>     	
					<select id="fjid" value="" onchange="getPcs('fjid','pcsid');getDeptByParentid('fjid','dept');" >
						<option>请选择...</option>
					</select>
					</td>
					 <td class="crosscolor_td">
			                    所属派出所
		                  </td>
		                  <td>
					<select id="pcsid" value="" onchange="getDeptByParentid('pcsid','dept');" >
						<option>请选择...</option>
					</select>
					</td>
					</tr>
					 <tr class="crosscolor_tr">
					  <td class="crosscolor_td">
			                      所属企业
		                  </td>
					 <td  colspan="3">
					<select id="dept" value="" onchange="getParentid('dept','pcsid');">
						<option>请选择...</option>
					</select>
					<input type="hidden" name="s_deptSeq" id="s_deptSeq" />
				<input type="hidden" name="xx" id="xx"  value="ss"/>
				
		          </td>
		           </tr>	
		           	 <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="button"  value="查询" onclick="query();"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>

		</table>

    </s:form>
</div>
			
</body>
<script language="javascript">
function query(){
	submitValue('fjid','pcsid','dept','s_deptSeq')
	
	document.forms[0].action='${ctx}/pages/fjy/Tfeijiuwupin/queryList.do'
	document.forms[0].submit();
}

getFj('fjid')
</script>
</html>