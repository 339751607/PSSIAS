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
	<title><%=Pmdwnsxxb.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Pmdwnsxxb/list.do" name="form1"  theme="simple" style="display: inline;" method="post">
        <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr >
			              <td class="tb_title" colspan="4"><%=Pmdwnsxxb.TABLE_ALIAS%>查询</td>
			             <!--   <td class="tb_title" width="5%"><font><a href="#">高级</a></font></td>-->
		           </tr>
		           <tr class="crosscolor_tr">
		                <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwmc}"  name="s_dwmc"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSND%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.nsnd}"  name="s_nsnd"  />
		                  </td>
                   </tr>
                   	<tr class="crosscolor_tr">
		             	<!--  <td class="crosscolor_td">
			                    <%=Pmdwxxb.ALIAS_FJDM%>
		                  </td>
			              <td>
			               <mytag:select  value="${pageRequest.filters.fjdm}"  name="s_fjdm"  onchange="getPcs()"  notEmpty="false"  dictName="ssfj"/>   
		                  </td>
		                  <td class="crosscolor_td">
				                    <%=Pmdwxxb.ALIAS_PCSDM%>
		                  </td>
			              <td id="pcstd">
							<select name="s_pcsdm" id="pcsdm">
								<option value="">请选择...</option>
							</select>
		                  </td>
		                  -->
		                   <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td colspan="3">
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
                   </tr>                   
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwnsxxb.ALIAS_NSJG%>
		                  </td>
			              <td>
			              <mytag:select  value="${pageRequest.filters.nsjg}"  name="s_nsjg"   notEmpty="false"  dictName="nsjglb"/>
		                  </td>
                   </tr>
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
		                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwnsxxb/list.do'"/>
		                        <input type="button" value="重置" onclick="resitData(document.forms.form1);"/>
                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwnsxxb/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Pmdwnsxxb/list.do" autoIncludeParameters="true">
	<ec:row>
						 	 <ec:column property="dwmc"  title="<%=Pmdwnsxxb.ALIAS_DWMC%>"/>
						    <ec:column property="dwbm"  title="<%=Pmdwnsxxb.ALIAS_DWBM%>"/>
		                    <ec:column property="nsnd"  title="<%=Pmdwnsxxb.ALIAS_NSND%>"/>
		                     <ec:column property="nsrq"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Pmdwnsxxb.ALIAS_NSRQ%>"/>
		                    <mytag:lookupcolumn property="nsjg"  title="<%=Pmdwnsxxb.ALIAS_NSJG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="nsjglb" />
		                    <ec:column property="nsyj" width="20%" title="<%=Pmdwnsxxb.ALIAS_NSYJ%>"/>
		                    <ec:column property="nsyjqsr"  title="<%=Pmdwnsxxb.ALIAS_NSYJQSR%>"/>
		                    <ec:column property="nsyjjbr"  title="<%=Pmdwnsxxb.ALIAS_NSYJJBR%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Pmdwnsxxb/show.do?dwbm=${item.dwbm}&nsnd=${item.nsnd}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>
<script language="javascript">
//getPcs();
//function getPcs(){
//	var fjbm=form1.s_fjdm.value;
//	var pcsbm='${pageRequest.filters.pcsdm}';
//	var url="${ctx}/pages/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
//	$.post(url, function(data) {
//		$("#pcstd").html("<select name='s_pcsdm' id='pcsdm'><option value=''>请选择...</option></select>");
//		$("#pcsdm").append(data);
//	});
//}
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
				input_txt.value = "!/pages/pmdd/Pmdwnsxxb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Pmdwnsxxb/delete.do';
	            form.submit();
	        }
	  }
</script>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
</body>

</html>