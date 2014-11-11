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
	<title><%=Tcpinfo.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcpinfo/listnsjl.do"  name="form1" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      企业代码
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.cpaddress}"  size="60" name="s_cpaddress"  />
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_WORKAREA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.workarea}"  name="s_workarea"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fax}"  name="s_fax"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ENROLCAPITAL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enrolcapital}"  name="s_enrolcapital"  />
		                  </td>
                   </tr>-->
		           <tr class="crosscolor_tr">
                          <!--  <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POSTALCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.postalcode}"  name="s_postalcode"  />
		                  </td>-->
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_STARTDATE%>
		                  </td>
			              <td colspan="3" align="left"> 
			                 <table class="list">
			                   <tr>
			                     <td>
				                   <s:select name="dateSelect7" list="dateSelectMap"  onchange="dateselect(this,'s_startdateBegin','s_startdateEnd','yyyy-MM-dd');"  value="#request.dateSelect7" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                     </td>     
			                     <td>从</td>
			                     <td>
			                       <input id="d3137" name="s_startdateBegin"  value="${pageRequest.filters.startdateBegin}"   maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3147\')}'})"/> 
			                     </td>
			                     <td>到</td>
			                     <td>  
			                       <input id="d3147" name="s_startdateEnd"   value="${pageRequest.filters.startdateEnd}"  maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3137\')}'})"/>
		                         </td>
		                       </tr>
		                     </table>  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_economy" value="${pageRequest.filters.economy}"  notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpname}"  name="s_corpname"  />
		                  </td>
                         <!--  <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CORPCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.corpcode}"  name="s_corpcode"  />
		                  </td> -->
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policename}"  name="s_policename"  />
		                  </td>
                 
                        
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPNO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.scbackupno}"  name="s_scbackupno"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SCBACKUPUNIT%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_scbackupunit" value="${pageRequest.filters.scbackupunit}"  notEmpty="false"  dictName="ssfj"/>
		                  </td>
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_policeunit" value="${pageRequest.filters.policeunit}"  notEmpty="false"  dictName="ssfj"/>
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCEUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licenceunit}"  name="s_licenceunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretcode}"  name="s_bcretcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_BCRETUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bcretunit}"  name="s_bcretunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxcode}"  name="s_taxcode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_TAXUNIT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.taxunit}"  name="s_taxunit"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_LICENCE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.licence}"  name="s_licence"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_flag" value="${pageRequest.filters.flag}"  notEmpty="false"  dictName="shiFou"/>
		                  </td>
                   </tr>-->
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
			                      <%=Tcpinfo.ALIAS_FLAG%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_flag" value="${pageRequest.filters.flag}"  notEmpty="false"  dictName="shiFou"/>
		                  </td>
                      
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcpinfo/listnsjl.do'"/>
	                              
	                            
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcpinfo/listnsjl.do" autoIncludeParameters="true">
	<ec:row>
		
		                    <ec:column property="cpcode"  title="<%=Tcpinfo.ALIAS_CPCODE%>"/>
		                    <ec:column property="cpname"  title="<%=Tcpinfo.ALIAS_CPNAME%>"/>
		                    <ec:column property="cpaddress"  title="<%=Tcpinfo.ALIAS_CPADDRESS%>"/>
		                   
				            <ec:column property="startdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="<%=Tcpinfo.ALIAS_STARTDATE%>"/>
				            
		                    <ec:column property="corpname"  title="<%=Tcpinfo.ALIAS_CORPNAME%>"/>
		                    <ec:column property="policename"  title="<%=Tcpinfo.ALIAS_POLICENAME%>"/>
		                    
		<ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Tcpnsjl/list.do?cpcode=${item.cpcode}&cpname=${item.cpname}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">年审</a>
		
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
				input_txt.value = "!/jxy/Tcpinfo/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Tcpinfo/delete.do';
	            form.submit();
	        }
	  }
</script>
<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>
