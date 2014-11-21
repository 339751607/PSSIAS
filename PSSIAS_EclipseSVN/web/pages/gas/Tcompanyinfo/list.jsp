<%@page import="com.dyneinfo.gas.model.*" %>
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
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<title><%=Tcompanyinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="getPcs();quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<input id="pcscode" type="hidden" value="${pcscode}" /> 
<input id="pcsname" type="hidden" value="${pcsname}" />
<div class="queryPanel">
    <s:form action="/pages/gas/Tcompanyinfogas/list.do"  theme="simple"  name ="TcompanyinfoForms" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompanyinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td  >
			                      <%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td >
			                      <%=Tcompanyinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.legaLname}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td >
			                      <%=Tcompanyinfo.ALIAS_STATUS%>
		                  </td>
			              <td>
		                            <mytag:select  value="${pageRequest.filters.status}" name="s_status"   styleClass="select"  notEmpty="false"  dictName="T_DIC_CPSTATE"/> 
		                            
		                  </td>
                          <td  class="td_tb">
			                      <%=Tcompanyinfo.ALIAS_MOD_TIME%>
		                  </td>
			              <td class="td_input">
<!--		                           <input value="${pageRequest.filters.modTime}"  name="s_modTime"  />-->
		                           <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_modTimeBegin','s_modTimeEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_modTimeBegin"  value="${pageRequest.filters.modTimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_modTimeEnd"   value="${pageRequest.filters.modTimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                   
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td >
			                      <%=Tcompanyinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
		                            <mytag:select  value="${pageRequest.filters.cptype}" name="s_cptype"  styleClass="select"   notEmpty="false"  dictName="T_DIC_CPKIND"/> 
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                           <td >
			                      <%=Tcompanyinfo.ALIAS_BURCODE%>
		                  </td>
			              <td>
				                <s:select name="s_burcode" id="country"  value=""  onchange="getPcs();"   cssStyle="width:155px" list="provMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
		                  </td>
                          <td >
			                      <%=Tcompanyinfo.ALIAS_STACODE%>
		                  </td>
			              <td id="pcstd">
								<select id="province" name="s_stacode" style="width:155px" ></select>
		                  </td>
                   </tr>
                   
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tcompanyinfogas/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Tcompanyinfogas/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
<!--	                                <input onclick="javascript:resetData(document.TcompanyinfoForms);"	type="button" value="重置">-->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Tcompanyinfogas/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox'  class='formRadio' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items"  class="formRadio" value="cpcode=${item.cpcode}&"/>
		</ec:column>
              <ec:column property="cpname"  title="<%=Tcompanyinfo.ALIAS_CPNAME%>"/>
              
              <ec:column property="address"  title="<%=Tcompanyinfo.ALIAS_ADDRESS%>"/>
              <ec:column property="phone"  title="<%=Tcompanyinfo.ALIAS_PHONE%>"/>
              
              <mytag:lookupcolumn property="status"  title="<%=Tcompanyinfo.ALIAS_STATUS%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="comstutas" />
              <mytag:lookupcolumn property="stacode"  title="<%=Tcompanyinfo.ALIAS_STACODE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="teHangDwbm" />
               
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/Tcompanyinfogas/show.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/gas/Tcompanyinfogas/edit.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
function resetData(frm){
	          frm.reset();
        }
function getPcs()
	{
		var countryId = spider("country").value;
		//默认为不选择
		if(countryId == 0)
		{
			  DWRUtil.removeAllOptions("province");
			  DWRUtil.addOptions("province",{'':'请选择...'}); 
		}
		else
		{
			menu.queryProvinceById(countryId,provinceCallback);
		}	
	}
	
	//根据国家id查询所属省或州的回调函数
	function provinceCallback(provinces)
	{
        DWRUtil.removeAllOptions("province");
        var pcscode = spider("pcscode").value;
        var pcsname = spider("pcsname").value;
        if(pcscode == null || pcscode ==""){
	      //每次获得新的数据的时候先把每二个下拉框架的长度清0
	        try{
	           DWRUtil.addOptions("province",{'':'请选择...'});    
	           DWRUtil.addOptions("province",provinces,"id","provinceName");
	        }catch(e){
	        }
        }else{
			var obj = document.getElementById("province");    
       		obj.options.add(new Option(pcsname,pcscode)); 
        }
      }
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
				input_txt.value = "!/pages/gas/Tcompanyinfogas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/Tcompanyinfogas/delete.do';
	            form.submit();
	        }
	  }
</script>