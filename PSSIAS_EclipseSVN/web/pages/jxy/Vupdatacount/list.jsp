<%@page import="com.dyneinfo.jxy.model.*" %>
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
	<title><%=Vupdatacount.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Vupdatacount/list.do"  theme="simple" name="form1" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Vupdatacount.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Vupdatacount.ALIAS_CORPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                         
                   </tr>
		         
		           
		        <tr class="crosscolor_tr">
                         
		                  
		                   <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td >
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(form1,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
		                  <td class="crosscolor_td">
			                      上传时间
		                  </td>
			             
			              
			              <td> 
			                 <table class="list">
			                   <tr>
			                     <td>
			                       <input id="d31310" name="s_birthBegin"  value="${pageRequest.filters.indateBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31410\')}'})"/> 
			                     </td>
			                     <td>到</td>
			                     <td>  
			                       <input id="d31410" name="s_birthEnd"   value="${pageRequest.filters.indateEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                         </td>
		                       </tr>
		                     </table>    
		                  </td>
		                   
		                          
		                 
		                
		                  </tr>
		                  <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
		                  	数据类型
		                  </td>
		                  <td>
		                  <select name="datatype">
		                  <option value="0" > 全部</option>
		                  	<option value="1" ${pageRequest.filters.datatype == 1?"selected":"" }>车辆信息</option>
		                  	<option value="2" ${pageRequest.filters.datatype == 2?"selected":"" }>从业人员</option>
		                  </select>
		                  </td>
		                  <td class="crosscolor_td">
		                  	查询类型
		                  </td>
		                  <td > 
			                 <table style="border: none;">
			                   <tr>
		                           <td><input type="radio" name="count" value="0" ${pageRequest.filters.count1 == 0?"checked":"" }/></td>
		                           <td> 未上传数据</td>
		                           <td><input type="radio" name="count" value="1" ${pageRequest.filters.count1 == 1?"checked":"" }/></td>
		                           <td>已上传数据</td>
		                       </tr>
		                     </table>     
		                  </td>
		                  </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Vupdatacount/list.do'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Vupdatacount/list.do" autoIncludeParameters="true">
		<ec:exportXls fileName="empxx.xls" tooltip="输出Excel文件"/> 
	<ec:row>
		
							
		                    <ec:column property="cpname"  title="<%=Vupdatacount.ALIAS_CPNAME%>"/>
		                    
		                    <ec:column property="startdate"  title="<%=Vupdatacount.ALIAS_STARTDATE%>"/>
		                    
		                    <ec:column property="corpname"  title="<%=Vupdatacount.ALIAS_CORPNAME%>"/>
		                    <ec:column property="policename"  title="<%=Vupdatacount.ALIAS_POLICENAME%>"/>
		                   
		                    <ec:column property="count"  title="<%=Vupdatacount.ALIAS_COUNT%>"/>
		
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
				input_txt.value = "!/jxy/Vupdatacount/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Vupdatacount/delete.do';
	            form.submit();
	        }
	  }
</script>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
