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
	<title><%=TfjycpCheck.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/TfjycpCheck/list.do"  theme="simple" style="display: inline;" method="post">
		    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TfjycpCheck.TABLE_ALIAS%>查询</td>
		           </tr>
		            <tr class="crosscolor_tr">
		            		                   <td class="crosscolor_td">
			                     检查企业名称
		                  </td>
			              <td>
		                          	<input value="${pageRequest.filters.deptname}"  name="s_deptname"  />
		                  </td>
		              <td class="crosscolor_td">
			                      民警姓名
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.mjname}"  name="s_fullname"  />
		                  </td>

		                </tr>
		            <tr class="crosscolor_tr"> 
		              <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcard}"  name="s_idcard"  />
		                  </td>
		                   <td class="crosscolor_td">
			                  		    警号
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeno}"  name="s_policeno"  />
		                  </td>
		             </tr>
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
							<select id="pcsid" value="" onchange="getDeptByParentid('pcsid','dept');">
								<option>请选择...</option>
							</select>
							</td>
							</tr>
						<tr class="crosscolor_tr">		
							<td class="crosscolor_td">
		           				 所属企业
				            </td>
				            <td colspan="3">
							<select id="dept" value="" onchange="getParentid('dept','pcsid');">
								<option>请选择...</option>
							</select>
							<input type="hidden" name="s_deptseq" id="s_deptseq" />
				          </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TfjycpCheck.ALIAS_CONTENT%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.content}"  size="80" name="s_content"  />
		                  </td>
		                  </tr>
		                 <tr class="tr_tb"> 
                          <td class="td_tb">
			                      <%=TfjycpCheck.ALIAS_CHECKDATE%>
		                  </td>
		                  			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('dateSelect2','d3132','d3142','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_checkdateBegin"  value="${pageRequest.filters.checkdateBegin}"   maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_checkdateEnd"   value="${pageRequest.filters.checkdateEnd}"  maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3142\')}'})"/>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="query();"/>	
			                       <input type="button" value="重置" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>
<script language="javascript">
function query(){
	submitValue('fjid','pcsid','dept','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/TfjycpCheck/list.do'
	document.forms[0].submit();
}

getFj('fjid')
</script>
</html>