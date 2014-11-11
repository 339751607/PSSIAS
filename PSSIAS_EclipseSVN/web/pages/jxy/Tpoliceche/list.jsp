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
	<title><%=Tpoliceche.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tpoliceche/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tpoliceche.TABLE_ALIAS%>查询</td>
		           </tr>
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checkname1}"  name="s_checkname1"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKNAME2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.checkname2}"  name="s_checkname2"  />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_CHECKTIME%>
		                  </td>
			              <td align="left" style="margin:0,0,0,10px">
			              	<table class="list">
			               <tr>
			              <td>
		                           <s:select name="dateSelect4" list="dateSelectMap"  onchange="dateselect(this,'s_checktimeBegin','s_checktimeEnd','yyyy-MM-dd');"  value="#request.dateSelect4" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                          <input id="d3134" name="s_checktimeBegin"  value="${pageRequest.filters.checktimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',maxDate:'#F{$dp.$D(\'d3144\')}'})"/>
			               <td>到</td>
			               <td>
			                        <input id="d3144" name="s_checktimeEnd"   value="${pageRequest.filters.checktimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',minDate:'#F{$dp.$D(\'d3134\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
		                        
                         <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DISPOSE%>
		                  </td>
			              <td>
		                          
		                           <mytag:select value="${pageRequest.filters.dispose}"     name="s_dispose"   notEmpty="false"  dictName="qlyj"/>
		                  
		                  </td>
		                  
                   </tr>
		        
		 
		        
		       
		         
		         
		     
		     
		      
		        
		
		     
		      
		           <tr class="crosscolor_tr">
		           <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_DEADLINE%>
		                  </td>
			              <td align="left" style="margin:0,0,0,10px" >
			          	   <table class="list">
			               <tr>
			              <td>
		                           <s:select name="dateSelect36" list="dateSelectMap"  onchange="dateselect(this,'s_deadlineBegin','s_deadlineEnd','yyyy-MM-dd');"  value="#request.dateSelect36" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                 <input id="d31336" name="s_deadlineBegin"  value="${pageRequest.filters.deadlineBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',maxDate:'#F{$dp.$D(\'d31436\')}'})"/>
			               </td>
			               <td>到</td>
			               <td>
			                        <input id="d31436" name="s_deadlineEnd"   value="${pageRequest.filters.deadlineEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=Tpoliceche.FORMAT_DEADLINE%>',minDate:'#F{$dp.$D(\'d31336\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  </td>
                          
                          
                          <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_EXAMINE%>
		                  </td>
			              <td>
		                           
		                            <mytag:select value="${pageRequest.filters.examine}"    name="s_examine"   notEmpty="false"  dictName="jxfs"/>
		                   
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                        
		              <td class="crosscolor_td">
			                      <%=Tpoliceche.ALIAS_ACCEPTCHECKNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.acceptcheckname}"  name="s_acceptcheckname"  />
		                  </td>
		                  <td></td><td></td>
                         
                   </tr>
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tpoliceche/list.do'"/>
			                       <!--  -->
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/jxy/Tpoliceche/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tpoliceche/list.do" autoIncludeParameters="true">
	<ec:row>
		
		                    <ec:column property="deptid"  title="<%=Tpoliceche.ALIAS_COMPANYINFO%>"/>
		                    <ec:column property="acceptcheckname"  title="<%=Tpoliceche.ALIAS_ACCEPTCHECKNAME%>"/>
		                    <ec:column property="checkname1"  title="<%=Tpoliceche.ALIAS_CHECKNAME1%>"/>	                    
		                    <ec:column property="checktime" value="${item.checktimeString}" title="<%=Tpoliceche.ALIAS_CHECKTIME%>"/>
		                    <ec:column property="checkname2"  title="<%=Tpoliceche.ALIAS_CHECKNAME2%>"/>       
		                    <mytag:lookupcolumn property="dispose"  title="<%=Tpoliceche.ALIAS_DISPOSE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="qlyj" />     
		                    <mytag:lookupcolumn property="examine"  title="<%=Tpoliceche.ALIAS_EXAMINE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="jxfs" />     
		                    <ec:column property="deadline" value="${item.deadlineString}" title="<%=Tpoliceche.ALIAS_DEADLINE%>"/>
		<ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Tpoliceche/show.do?checkid=${item.checkid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			
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
				input_txt.value = "!/jxy/Tpoliceche/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tpoliceche/delete.do';
	            form.submit();
	        }
	  }
</script>
