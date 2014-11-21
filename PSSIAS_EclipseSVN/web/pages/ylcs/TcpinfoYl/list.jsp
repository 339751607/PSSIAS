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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TcpinfoYl.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
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
                   <%--
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ACREAGE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acreage}"  name="s_acreage"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolcapital}"  name="s_enrolcapital"  />
		                  </td>
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fax}"  name="s_fax"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.postalcode}"  name="s_postalcode"  />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpcode}"  name="s_corpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policename}"  name="s_policename"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICEPHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policephone}"  name="s_policephone"  />
		                  </td>
                   </tr>
		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupno}"  name="s_scbackupno"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupunit}"  name="s_scbackupunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licenceunit}"  name="s_licenceunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretcode}"  name="s_bcretcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretunit}"  name="s_bcretunit"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxcode}"  name="s_taxcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxunit}"  name="s_taxunit"  />
		                  </td>
                   </tr>
		           
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_STOPDATE%>
		                  </td>
			              <td>
		                           <s:select name="dateSelect27" list="dateSelectMap"  onchange="dateselect(this,'s_stopdateBegin','s_stopdateEnd','yyyy-MM-dd');"  value="#request.dateSelect27" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31327" name="s_stopdateBegin"  value="${pageRequest.filters.stopdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>',maxDate:'#F{$dp.$D(\'d31427\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31427" name="s_stopdateEnd"   value="${pageRequest.filters.stopdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=TcpinfoYl.FORMAT_STOPDATE%>',minDate:'#F{$dp.$D(\'d31327\')}'})"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_HIS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.his}"  name="s_his"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JWDZB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jwdzb}"  name="s_jwdzb"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_GDXX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gdxx}"  name="s_gdxx"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_XFZSL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xfzsl}"  name="s_xfzsl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_BXSL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bxsl}"  name="s_bxsl"  />
		                  </td>
                          
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_POLICELEVELCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policelevelcode}"  name="s_policelevelcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_FLAGPACK%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.flagpack}"  name="s_flagpack"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_AUTHORIZATIONCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authorizationcode}"  name="s_authorizationcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_SPJRURL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.spjrurl}"  name="s_spjrurl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_CURRENTSCORE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.currentscore}"  name="s_currentscore"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TcpinfoYl.ALIAS_JCJB%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jcjb}"  name="s_jcjb"  />
		                  </td>
                   </tr>
		           --%><tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/ylcs/TcpinfoYl/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button" value="硬件注销" onclick="Cancellation();" >
	                               <input type="button" value="锁定" onclick="Lock();" >
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/ylcs/TcpinfoYl/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" id="items" value="locode=${item.locode}&"/>
		</ec:column>
		                    <%--<ec:column property="station"  title="<%=TcpinfoYl.ALIAS_STATION%>"/>
		                   <ec:column property="startdate" format="yyyy-mm-dd" value="${item.startdateString}" title="<%=TcpinfoYl.ALIAS_STARTDATE%>"/>
		                    <ec:column property="acreage"  title="<%=TcpinfoYl.ALIAS_ACREAGE%>"/>
		                    <ec:column property="enrolcapital"  title="<%=TcpinfoYl.ALIAS_ENROLCAPITAL%>"/>
		                    --%>
		                    <ec:column property="locode"  title="<%=TcpinfoYl.ALIAS_LOCODE%>"/>
		                    <ec:column property="cpname"  title="<%=TcpinfoYl.ALIAS_CPNAME%>"/>
		                     <ec:column property="corpname"  title="<%=TcpinfoYl.ALIAS_CORPNAME%>"/>
		                     <ec:column property="policename"  title="<%=TcpinfoYl.ALIAS_POLICENAME%>"/>
		                     <mytag:lookupcolumn property="state" title="<%=TcpinfoYl.ALIAS_STATE%>" cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_YLCSSTATE" />
		                     <ec:column property="authorizationstatus"  title="<%=TcpinfoYl.ALIAS_AUTHORIZATIONSTATUS%>"/>
		                     
		                     
		                   <%-- <ec:column property="cpaddress"  title="<%=TcpinfoYl.ALIAS_CPADDRESS%>"/>
		                    <ec:column property="phone"  title="<%=TcpinfoYl.ALIAS_PHONE%>"/>
		                    <ec:column property="fax"  title="<%=TcpinfoYl.ALIAS_FAX%>"/>
		                    <ec:column property="postalcode"  title="<%=TcpinfoYl.ALIAS_POSTALCODE%>"/>
		                    <ec:column property="economy"  title="<%=TcpinfoYl.ALIAS_ECONOMY%>"/>
		                    <ec:column property="corpcode"  title="<%=TcpinfoYl.ALIAS_CORPCODE%>"/>
		                   
		                    
		                    <ec:column property="policephone"  title="<%=TcpinfoYl.ALIAS_POLICEPHONE%>"/>
		                    <ec:column property="workarea"  title="<%=TcpinfoYl.ALIAS_WORKAREA%>"/>
		                    <ec:column property="policeunit"  title="<%=TcpinfoYl.ALIAS_POLICEUNIT%>"/>
		                    <ec:column property="scbackupno"  title="<%=TcpinfoYl.ALIAS_SCBACKUPNO%>"/>
		                    <ec:column property="scbackupunit"  title="<%=TcpinfoYl.ALIAS_SCBACKUPUNIT%>"/>
		                    <ec:column property="licence"  title="<%=TcpinfoYl.ALIAS_LICENCE%>"/>
		                    <ec:column property="licenceunit"  title="<%=TcpinfoYl.ALIAS_LICENCEUNIT%>"/>
		                    <ec:column property="bcretcode"  title="<%=TcpinfoYl.ALIAS_BCRETCODE%>"/>
		                    <ec:column property="bcretunit"  title="<%=TcpinfoYl.ALIAS_BCRETUNIT%>"/>
		                    <ec:column property="taxcode"  title="<%=TcpinfoYl.ALIAS_TAXCODE%>"/>
		                    <ec:column property="taxunit"  title="<%=TcpinfoYl.ALIAS_TAXUNIT%>"/>
		                    <ec:column property="thcode"  title="<%=TcpinfoYl.ALIAS_THCODE%>"/>
		                    <ec:column property="fjcode"  title="<%=TcpinfoYl.ALIAS_FJCODE%>"/>
		                    <ec:column property="workareasec"  title="<%=TcpinfoYl.ALIAS_WORKAREASEC%>"/>
		                    <ec:column property="stopdate" value="${item.stopdateString}" title="<%=TcpinfoYl.ALIAS_STOPDATE%>"/>
		                    <ec:column property="his"  title="<%=TcpinfoYl.ALIAS_HIS%>"/>
		                    <ec:column property="jwdzb"  title="<%=TcpinfoYl.ALIAS_JWDZB%>"/>
		                    <ec:column property="gdxx"  title="<%=TcpinfoYl.ALIAS_GDXX%>"/>
		                    <ec:column property="xfzsl"  title="<%=TcpinfoYl.ALIAS_XFZSL%>"/>
		                    <ec:column property="bxsl"  title="<%=TcpinfoYl.ALIAS_BXSL%>"/>
		                    <ec:column property="zajb"  title="<%=TcpinfoYl.ALIAS_ZAJB%>"/>
		                    <ec:column property="csxj"  title="<%=TcpinfoYl.ALIAS_CSXJ%>"/>
		                    
		                    <ec:column property="policelevelcode"  title="<%=TcpinfoYl.ALIAS_POLICELEVELCODE%>"/>
		                    <ec:column property="flagpack"  title="<%=TcpinfoYl.ALIAS_FLAGPACK%>"/>
		                    <ec:column property="authorizationcode"  title="<%=TcpinfoYl.ALIAS_AUTHORIZATIONCODE%>"/>
		                    <ec:column property="spjrurl"  title="<%=TcpinfoYl.ALIAS_SPJRURL%>"/>
		                    <ec:column property="currentscore"  title="<%=TcpinfoYl.ALIAS_CURRENTSCORE%>"/>
		                    <ec:column property="jcjb"  title="<%=TcpinfoYl.ALIAS_JCJB%>"/>
		--%><ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/ylcs/TcpinfoYl/CpinfoTab.jsp?locode=${item.locode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/ylcs/TcpinfoYl/edit.do?locode=${item.locode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/ylcs/TcpinfoYl/authorize.do?locode=${item.locode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">企业授权</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>

<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/ylcs/TcpinfoYl/delete.do';
	            form.submit();
	        }
	  }
	  
	  function Cancellation(){
		   var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[硬件注销]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/ylcs/TcpinfoYl/cancellation.do';
	            form.submit();
	        }
	     }
		  
	    
	  function Lock(){
		   var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[锁定]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/pages/ylcs/TcpinfoYl/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/ylcs/TcpinfoYl/lock.do';
	            form.submit();
	        }
	  }
	  
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