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
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Ttz.TABLE_ALIAS%> 维护</title>
</head>

<body onload="getPcs();quickSelectInit()" >
<input id="pcscode" type="hidden" value="${pcscode}" /> 
<input id="pcsname" type="hidden" value="${pcsname}" />
<%@ include file="/commons/messages.jsp" %>


<div class="queryPanel">
    <s:form action="/pages/gas/Ttz/list.do"  theme="simple" style="display: inline;" method="post">
	   <table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Ttz.TABLE_ALIAS%>查询</td>
		           </tr>
		         <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      所属分局
		                  </td>
			              <td>
				                <s:select name="s_burcode" id="country"   cssStyle="width:155px" value=""  onchange="getPcs();" list="provMap" listKey="key" headerKey=""  listValue="value" theme="simple" label="省市"  emptyOption="false" styleClass="select"></s:select>
		                  </td>
                          <td class="crosscolor_td">
			                     所属派出所
		                  </td>
			              <td id="pcstd">
								<select id="province" name="s_stacode"  style="width:155px" ></select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_BT%>
		                  </td>
			              <td  colspan="3">
		                           <input value="${pageRequest.filters.bt}"  style="width:520px ;" name="s_bt"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Ttz.ALIAS_RQ%>
		                  </td>
			              <td class="td_input">
		                        <s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_rqBegin','s_rqEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31313" name="s_rqBegin"  value="${pageRequest.filters.rqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31413" name="s_rqEnd"   value="${pageRequest.filters.rqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
		                   		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_HZFLAG%>
		                  </td>
			              <td>
			           		   <mytag:select  value="${pageRequest.filters.hzflag}" name="s_hzflag"  notEmpty="false"   styleClass="select"   dictName="shiFou"/> 
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttz/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms[0])"/>
	                               <input type="submit"  value="下发" onclick="getReferenceForm(this).action='${ctx}/pages/gas/Ttz/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/gas/Ttz/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox'  class='formRadio' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items"  class="formRadio" value="id=${item.id}&"/>
		</ec:column>
          <ec:column property="bt"  title="<%=Ttz.ALIAS_BT%>"/>
          <ec:column property="rq"  parse="yyyyMMddHHmmss" format="yyyy-MM-dd HH:mm:ss"  cell="date"   title="<%=Ttz.ALIAS_RQ%>"/>
          <ec:column property="fsr"  title="<%=Ttz.ALIAS_FSR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/gas/Ttz/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
<!--			<a href="${ctx}/pages/gas/Ttz/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>-->
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>

function getPcs()
	{
		var countryId = spider("country").value;
		//默认为不选择
		if(countryId == 0)
		{
			  DWRUtil.removeAllOptions("province");
			  DWRUtil.addOptions("province",{'':'全部'}); 
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
	           DWRUtil.addOptions("province",{'':'全部'});    
	           DWRUtil.addOptions("province",provinces,"id","provinceName");
	        }catch(e){
	        }
        }else{
			var obj = document.getElementById("province");    
       		obj.options.add(new Option(pcsname,pcscode)); 
        }
      }
 function changeprov()
	{
		var provinceId = spider("prov").value;
		var provincename = spider("prov").options[spider("prov").options.selectedIndex].text;
		var nativeplace = spider("s_nativeplace").value;
		var xzqh = spider("s_xzqh").value;
		if(nativeplace==""){
			spider("s_nativeplace").value = provincename;
			spider("s_xzqh").value = provinceId;
		}else{
			spider("s_nativeplace").value = nativeplace+","+provincename;
			spider("s_xzqh").value = xzqh+","+provinceId;
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
				input_txt.value = "!/pages/gas/Ttz/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/gas/Ttz/delete.do';
	            form.submit();
	        }
	  }
</script>