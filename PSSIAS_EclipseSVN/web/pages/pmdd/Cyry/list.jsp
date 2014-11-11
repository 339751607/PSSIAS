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
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Cyry.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
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
				                   <mytag:select  name="s_xb" value="${pageRequest.filters.xb}"  notEmpty="false"  dictName="gender"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_GMSFHM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gmsfhm}"  name="s_gmsfhm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_BIRTHDAY%>
		                  </td>
			              <td>
			              	<table class="list">
			              		<tr>
			              			<td>从</td>
			              			<td>
			              				<input id="d3135" name="s_birthdayBegin"  value="${pageRequest.filters.birthdayBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-01',maxDate:'#F{$dp.$D(\'d3145\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d3145" name="s_birthdayEnd"   value="${pageRequest.filters.birthdayEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',startDate:'1980-05-02',minDate:'#F{$dp.$D(\'d3135\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>
		                  </td>
                   </tr>

		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Cyry.ALIAS_RZRQ%>
		                  </td>
			              <td colspan="3">
			              		<table class="list">
			              		<tr>
			              			<td>
			              				 <s:select name="dateSelect10" list="dateSelectMap"  onchange="dateselect(this,'s_rzrqBegin','s_rzrqEnd','yyyy-MM-dd');"  value="#request.dateSelect10" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d31310" name="s_rzrqBegin"  value="${pageRequest.filters.rzrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d31410" name="s_rzrqEnd"   value="${pageRequest.filters.rzrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>			                        
		                  </td>
                          
                   </tr>
		         
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Cyry/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Cyry/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                             <!--  <input type="button"  value="删除" onclick="doDel();"/> -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/Cyry/list.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column property="xm"  title="<%=Cyry.ALIAS_XM%>"/>
				            <mytag:lookupcolumn property="xb"  title="<%=Cyry.ALIAS_XB%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="gender" />
		                  
		                    <ec:column property="gmsfhm"  title="<%=Cyry.ALIAS_GMSFHM%>"/>
		                   
				            <ec:column property="birthday"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Cyry.ALIAS_BIRTHDAY%>"/>
		                  
		                    <ec:column property="hkszd"  title="<%=Cyry.ALIAS_HKSZD%>"/>
				            <mytag:lookupcolumn property="whcd"  title="<%=Cyry.ALIAS_WHCD%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="educations" />
				            <ec:column property="rzrq"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Cyry.ALIAS_RZRQ%>"/>
				            <mytag:lookupcolumn property="flag"  title="<%=Cyry.ALIAS_FLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cyryFlag" />
				           
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Cyry/show.do?dwbm=${item.dwbm}&dwnbm=${item.dwnbm}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/pmdd/Cyry/edit.do?dwbm=${item.dwbm}&dwnbm=${item.dwnbm}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/pmdd/Cyry/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Cyry/delete.do';
	            form.submit();
	        }
	  }
</script>