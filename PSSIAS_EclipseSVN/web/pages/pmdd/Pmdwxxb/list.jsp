<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String v_szqyjs = "0";
String v_szqyxzjs = "0";
if (request.getAttribute("qyjs") != null) {
		v_szqyjs = (String)request.getAttribute("qyjs");
	}
if (request.getAttribute("qyxzjs") != null) {
		v_szqyxzjs = (String)request.getAttribute("qyxzjs");
	}
int qyjs=Integer.parseInt(v_szqyjs);
int qyxzjs=Integer.parseInt(v_szqyxzjs);
Integer count=(Integer) request.getAttribute("count");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Pmdwxxb.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/Pmdwxxb/list.do"   name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Pmdwxxb.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWMC%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwmc}"  name="s_dwmc"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWBM%>
		                  </td>
			              <td>
		                       <input value="${pageRequest.filters.dwbm}"  name="s_dwbm"  />
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
		             <!--  	<td class="crosscolor_td">
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
		                  </td>-->
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
			                      <%=Pmdwxxb.ALIAS_FRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.frxm}"  name="s_frxm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FZR%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fzr}"  name="s_fzr"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWDZ%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dwdz}"  name="s_dwdz"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_KYRQ%>
		                  </td>
			              <td>
			              	<table class="list">
			              		<tr>
			              			<td>
			              				<s:select name="dateSelect13" list="dateSelectMap"  onchange="dateselect(this,'s_kyrqBegin','s_kyrqEnd','yyyy-MM-dd');"  value="#request.dateSelect13" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              			</td>
			              			<td>从</td>
			              			<td>
			              				<input id="d31313" name="s_kyrqBegin"  value=" ${pageRequest.filters.kyrqBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31413\')}'})"/>
			              			</td>
			              			<td>到</td>
			              			<td>
			              				<input id="d31413" name="s_kyrqEnd"   value="${pageRequest.filters.kyrqEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31313\')}'})"/>
			              			</td>
			              		</tr>
			              	</table>
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwxxb/list.do'"/>
			                       <input type="button" value="清空" onclick="resitData(document.forms.form1);"/>
	                               <input type="submit"  value="新增" onclick="if(xzjs())getReferenceForm(this).action='${ctx}/pages/pmdd/Pmdwxxb/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                              <!-- <input type="button"  value="删除" onclick="doDel();"/> --> 

			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Pmdwxxb/list.do" autoIncludeParameters="true">
	<ec:row>
							<ec:column property="dwbm"  title="<%=Pmdwxxb.ALIAS_DWBM%>"/>
		                     <ec:column property="dwmc"  title="<%=Pmdwxxb.ALIAS_DWMC%>"/>
		                    <ec:column property="dwdz"  title="<%=Pmdwxxb.ALIAS_DWDZ%>"/>
		                    <ec:column property="lxdh"  title="<%=Pmdwxxb.ALIAS_LXDH%>"/>
		                     <ec:column property="kyrq"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Pmdwxxb.ALIAS_KYRQ%>"/>
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/pmdd/Pmdwxxb/cariscode.do?cpcode=${item.dwbm}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">企业授权</a>&nbsp;&nbsp;&nbsp;		
			<a href="${ctx}/pages/pmdd/Pmdwxxb/show.do?id=${item.dwbm}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/pmdd/Pmdwxxb/edit.do?id=${item.dwbm}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
		</ec:column>
	</ec:row>
</ec:table>
<script>

	//	getPcs();
		//function getPcs(){
			//var fjbm=form1.s_fjdm.value;
			//var pcsbm='${pageRequest.filters.pcsdm}';
			//var url="${ctx}/pages/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
			//$.post(url, function(data) {
				//$("#pcstd").html("<select name='s_pcsdm' id='pcsdm'><option value=''>请选择...</option></select>");
				//$("#pcsdm").append(data);
			//});
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
				input_txt.value = "!/pages/pmdd/Pmdwxxb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/pmdd/Pmdwxxb/delete.do';
	            form.submit();
	        }
	  }
	  function xzjs(){
	  if(<%=qyjs%>>=<%=count%>)
	  	{
	  		alert("企业数量已经到达注册上限，不能继续添加。请与管理员联系！");
	  		return false;
	  	}
	  	return true;
	  }
</script>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
</body>

</html>


