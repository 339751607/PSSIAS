<%@page import="com.dyneinfo.ylcs.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=TcpinfoYl.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/ylcs/TcpinfoYl/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TcpinfoYl.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.economy}"  name="s_economy"  />
		                  </td><%--
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpaddress}"  name="s_cpaddress"  />
		                  </td>
                   --%></tr>
		           <tr class="crosscolor_tr">
                          
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FJCODE%>
		                  </td>
			              <td>
		                           <mytag:select dictName="ssfj" value="${pageRequest.filters.fjcode}" name="s_fjcode" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATION%>
		                  </td>
			              <td>
		                          <select name="s_station" id="s_station" >
										<option value="">请选择...</option>
									</select>
		                  </td>
                         </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workarea}"  name="s_workarea"  />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_WORKAREASEC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workareasec}"  name="s_workareasec"  />
		                  </td>
                        </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_THCODE%>
		                  </td>
			              <td>
		                           <mytag:select dictName="t_dic_cptype" value="${pageRequest.filters.thcode}"  name="s_thcode" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licence}"  name="s_licence"  />
		                  </td>
                          
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CSXJ%>
		                  </td>
			              <td>
		                           <mytag:select dictName="T_DIC_CSXJ" name="s_csxj" value="${pageRequest.filters.csxj}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ZAJB%>
		                  </td>
			              <td>
		                           <mytag:select dictName="T_DIC_ZAJB" value="${pageRequest.filters.zajb}" styleClass="required" name="s_zajb"/>
		                  </td>
		                 </tr>
                    <tr class="crosscolor_tr">
                   		<td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STARTDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect1" list="dateSelectMap"  onchange="dateselect(this,'s_startdateBegin','s_startdateEnd','yyyy-MM-dd');"  value="#request.dateSelect1" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3131" name="s_startdateBegin"  value="${pageRequest.filters.startdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>',maxDate:'#F{$dp.$D(\'d3141\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3141" name="s_startdateEnd"   value="${pageRequest.filters.startdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STARTDATE%>',minDate:'#F{$dp.$D(\'d3131\')}'})"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STATE%>
		                  </td>
			              <td>
		                           <mytag:select dictName="T_DIC_YLCSSTATE" name="s_state" value="${pageRequest.filters.state}"/>
		                  </td>
		           </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>
<script>
	  $(document).ready(function(){
		
		$("select[name=s_fjcode]").change(function(){
			var url="${ctx}/pages/zazh/Tcoordinate/addStation.do?fjcode="+this.value;
			$.get(url,function(data){
				$("#s_station").html(data);
					//alert(data);
			});
		});
		var url="${ctx}/pages/zazh/Tcoordinate/addStation.do?fjcode=${pageRequest.filters.fjcode}&pcscode=${pageRequest.filters.station}";
		$.get(url,function(data){
			$("#s_station").html(data);
					//alert(data);
		});
	});
</script>
</html>