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
	<title><%=Temployee.TABLE_ALIAS%> 维护</title>
</head>

<body onload="getPcs();quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<input id="pcscode" type="hidden" value="${pcscode}" /> 
<input id="pcsname" type="hidden" value="${pcsname}" />

<div class="queryPanel">
    <s:form action="/pages/gas/Temployeegas/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
			              	 <mytag:select  value="${pageRequest.filters.sex}" name="s_sex"   styleClass="select"  notEmpty="false"  dictName="T_DIC_SEX"/> 
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
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td>
			              	 <mytag:select  value="${pageRequest.filters.folk}" name="s_folk"  notEmpty="false"  styleClass="select"   dictName="T_DIC_NATION"/> 
		                  </td>
                   </tr>
                   
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      入职日期
		                  </td>
	                           <td class="td_input">
	                            <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_indateBegin','s_indateEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
		                          从<input id="d31313" name="s_indateBegin"  value="${pageRequest.filters.indateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
		                        <input id="d31413" name="s_indateEnd"   value="${pageRequest.filters.indateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                   
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CPCODE%>
		                  </td>
			              <td colspan ="3">
			              		 <s:select name="s_cpcode" id="cpcode" value=""  cssStyle="width:155px" list="compMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="售油企业"  emptyOption="false"  styleClass="select" ></s:select>
		                  </td>
                   </tr>
					<tr class="crosscolor_tr">
                    	   <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_BURCODE%>
		                  </td>
			              <td>
				                <s:select name="s_burcode" id="country"  value=""  cssStyle="width:155px" onchange="getPcs();" list="provMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" ></s:select>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_STACODE%>
		                  </td>
			              <td id="pcstd">
								<select id="province" name="s_stacode" style="width:155px;" ></select>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Temployeegas/list.do'"/>
<!--	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Temployeegas/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>-->
<!--	                               <input type="button"  value="删除" onclick="doDel();"/>-->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Temployeegas/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="empname"  title="<%=Temployee.ALIAS_EMPNAME%>">
		                     <a href="${ctx}/pages/gas/Temployeegas/show.do?empcode=${item.empcode}" style="color: #0000FF; text-decoration: underline;">
										${item.empname} </a>
		                    </ec:column>
		                    <mytag:lookupcolumn property="sex"  title="<%=Temployee.ALIAS_SEX%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
		                    <ec:column property="birth"  cell="date"  title="<%=Temployee.ALIAS_BIRTH%>"/>
		                    <ec:column property="cpcode"  title="<%=Temployee.ALIAS_CPCODE%>">
		                     <a href="${ctx}/pages/gas/Tcompanyinfogas/cpshow.do?cpcode=${item.cpcode}" style="color: #0000FF; text-decoration: underline;">
										${item.cpname} </a>
		                    </ec:column>
		                    
		                    <mytag:lookupcolumn property="cyrjzt"  title="<%=Temployee.ALIAS_CYRJZT%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
		                    
	</ec:row>
</ec:table>

</body>

</html>


<script>
	function getPcs()
	{
		var countryId = $("country").value;
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
        var pcscode = $("pcscode").value;
        var pcsname = $("pcsname").value;
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
				input_txt.value = "!/pages/gas/Temployeegas/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/Temployeegas/delete.do';
	            form.submit();
	        }
	  }
</script>