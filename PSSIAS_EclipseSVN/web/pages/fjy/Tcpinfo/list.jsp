<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

Integer qyjs=(Integer) request.getAttribute("qyjs");

Integer count=(Integer) request.getAttribute("count");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Tcpinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Tcpinfo/list.do" name="inputForm"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                     企业编码
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                   </tr>
		           
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cptype" value="${pageRequest.filters.cptype}"  notEmpty="false"  dictName="T_DIC_CPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPSTATE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cpstate" value="${pageRequest.filters.cpstate}"  notEmpty="false"  dictName="T_DIC_CPSTATE"/>
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tcpinfo.ALIAS_SSPCS%>
		                  </td>
		                  <td>
			              <select id="fjid" value="" onchange="getPcs('fjid','pcsid');" style="width: 150px">
						<option>请选择...</option>
					</select>&nbsp;&nbsp;
					<select id="pcsid" value="${pageRequest.filters.cpstate}" style="width: 150px">
						<option>请选择...</option>
					</select>

					<input type="hidden" name="s_sspcs" id="deptSeq" />
			              
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_GSZZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.gszzh}"  name="s_gszzh"  />
		                  </td>
                   </tr>
		          
		        
		           <tr class="tr_tb">
                         
                          <td class="td_tb">
			                      <%=Tcpinfo.ALIAS_ZCRQ%>
		                  </td>
			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect17" list="dateSelectMap"  onchange="dateselect('list_dateSelect17','d31317','d31417','yyyy-MM-dd');"  value="#request.dateSelect17" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31317" name="s_zcrqBegin"  value="${pageRequest.filters.zcrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31417\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31417" name="s_zcrqEnd"   value="${pageRequest.filters.zcrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31317\')}'})"/>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="query();"/>
	                               <input type="submit"  value="新增" onclick="if(xzjs())getReferenceForm(this).action='${ctx}/pages/fjy/Tcpinfo/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tcpinfo/list.do" autoIncludeParameters="true">
	<ec:row>
		
			<%--<ec:column property="cpcode"  title="<%=Tcpinfo.ALIAS_CPCODE%>"/>
		                    --%><ec:column property="cpname"  title="<%=Tcpinfo.ALIAS_CPNAME%>"/>  
		                    <ec:column property="cptel"  title="<%=Tcpinfo.ALIAS_CPTEL%>"/>		                  
				            <ec:column property="frname"  title="<%=Tcpinfo.ALIAS_FRNAME%>"/>
				            <mytag:lookupcolumn property="cpstate"  title="<%=Tcpinfo.ALIAS_CPSTATE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DIC_CPSTATE" />
		                    <ec:column property="deptname"  title="<%=Tcpinfo.ALIAS_SSPCS%>"/>		                    
		                    <ec:column property="zafzr"  title="<%=Tcpinfo.ALIAS_ZAFZR%>"/>		                 
				            <ec:column property="kysj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Tcpinfo.ALIAS_KYSJ%>"/>		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
	<a href="${ctx}/pages/fjy/Tcpinfo/cariscode.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">企业授权</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tcpinfo/show.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/fjy/Tcpinfo/edit.do?cpcode=${item.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


<script>
function xzjs(){
	  if(<%=qyjs%>>=<%=count%>)
	  	{
	 
	  		alert("企业数量已经到达注册上限，不能继续添加。请与管理员联系！");
	  		return false;
	  	}
	  	return true;
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
				input_txt.value = "!/pages/fjy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/fjy/Tcpinfo/delete.do';
	            form.submit();
	        }
	  }
	  function query(){
	submitValue('fjid','pcsid','','deptSeq');
	document.forms[0].action='${ctx}/pages/fjy/Tcpinfo/list.do'
	document.forms[0].submit();
}
getFj('fjid');


</script>