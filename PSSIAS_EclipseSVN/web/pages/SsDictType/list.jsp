<%@page import="com.dyneinfo.zazh.model.*" %>
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
	<title><%=SsDictType.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form  name="queryForm" action="/pages/SsDictType/list.do"  theme="simple" style="display: inline;" method="post">
	     <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsDictType.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTTYPEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dicttypeid}"  name="s_dicttypeid"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTTYPENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dicttypename}"  name="s_dicttypename"  />
		                  </td>
                          
                   </tr>
		          
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTFLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_dictflag"  value="${pageRequest.filters.dictflag}"  notEmpty="false"  dictName="dictflag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_QUERYSQL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.querysql}"  name="s_querysql"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictType/list.do'"/>
	                               <input type="button" value="重置" onclick="resitData(document.forms.queryForm)"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/SsDictType/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/SsDictType/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' class='formRadio' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items"  class="formRadio" value="dicttypeid=${item.dicttypeid}&"/>
		</ec:column>
		                    <ec:column property="dicttypeid"  title="<%=SsDictType.ALIAS_DICTTYPEID%>"/>
		                    <ec:column property="dicttypename"  title="<%=SsDictType.ALIAS_DICTTYPENAME%>"/>                  
				            <mytag:lookupcolumn property="dictflag"  title="<%=SsDictType.ALIAS_DICTFLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="dictflag" />
		                   
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/SsDictType/show.do?dicttypeid=${item.dicttypeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/SsDictType/edit.do?dicttypeid=${item.dicttypeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>&nbsp;&nbsp;&nbsp;
			<a onclick="javascript:ShowDetail('${item.dicttypeid}');return false;"  href="#">字典项</a>
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
				input_txt.value = "!/pages/SsDictType/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/SsDictType/delete.do';
	            form.submit();
	        }
	  }
	   function ShowDetail(ID) {
		var returnvalue = window.showModalDialog("${ctx}/pages/SsDictItem/masterDetail.do?id="+ID,"childWIn","dialogHeight:450px;dialogWidth:600px;scroll:off;center:yes");
		 }
</script>