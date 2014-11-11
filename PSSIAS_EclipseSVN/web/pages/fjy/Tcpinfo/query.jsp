<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String s_mpcode = (String)DictHelpImpl.getInitData("mpcode");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("mpcode",s_mpcode);
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Tcpinfo/queryList.do" name="form0" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcpinfo.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname" />
		                  </td>

                   </tr>
                   <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.frname}"  name="s_frname"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRIDCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fridcode}"  name="s_fridcode"  />
		                  </td></tr>
		           <tr class="crosscolor_tr">
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPKIND%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cpkind"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>

                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_AREA%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.area}"  name="s_area"  />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                      <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADRESS%>
		                  </td>
			              <td colspan="3">
		                           <input value="${pageRequest.filters.cpadress}"  name="s_cpadress" size="40" />
		                  </td>
		                  </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPTEL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cptel}"  name="s_cptel"  />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRSEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_frsex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPSTATE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_cpstate"   notEmpty="false"  dictName="T_DIC_CPSTATE"/>
		                  </td>
		                                       <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_JYFW%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.jyfw}"  name="s_jyfw"  />
		                  </td>
                   </tr>
                   

		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Tcpinfo.ALIAS_KYSJ%>
		                  </td>
			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect14" list="dateSelectMap"  onchange="dateselect('dateSelect14','d31314','d31414','yyyy-MM-dd');"  value="#request.dateSelect14" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31314" name="s_kysjBegin"  value="${pageRequest.filters.kysjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31414\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31414" name="s_kysjEnd"   value="${pageRequest.filters.kysjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31314\')}'})"/>
		                  </td>
 
                   </tr>
                    <tr class="tr_tb">
                          <td class="td_tb">
			                      状态改变时间
		                  </td>
			              <td colspan="3" class="td_input">
				                   <s:select name="dateSelect15" list="dateSelectMap"  onchange="dateselect('dateSelect15','d31318','d31418','yyyy-MM-dd');"  value="#request.dateSelect15" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31318" name="s_stategbsjBegin"  value="${pageRequest.filters.stategbsjBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31418\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31418" name="s_stategbsjEnd"   value="${pageRequest.filters.stategbsjEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31318\')}'})"/>
		                  </td>
 
                   </tr>
		           <tr class="crosscolor_tr">
		            	 <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SFGSZZH%>
		                  </td>
		           			<td>
			              	  <mytag:select property="%{model.sfgszzh}"   onchange="createGszzh(this)" name="s_sfgszzh"  notEmpty="false"  dictName="shiFou"/>
		                           
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_GSZZH%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.gszzh}"  name="s_gszzh" id="gszzh" size="40"/>
		                           
		                  </td>
 		
                   </tr>
                    <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
	      					<%=Tcpinfo.ALIAS_SFBAN%>
         				</td>
   				      <td colspan="3">
		         		 <mytag:select property="%{model.sfban}"   styleClass="required"   name="s_sfban"   notEmpty="false"  dictName="shiFou"/>
          			 </td>
        
                   </tr>
                   			<c:if test="${deptid == mpcode}">
				           	 	 <tr class="crosscolor_tr">
				           	 	  <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SETUPFLAG%>
				                  </td>
					              <td colspan="3">
								              <mytag:select  name="s_setupflag"   notEmpty="false"  dictName="shiFou"/>
				                  </td>
				                  </tr>
				           	 </c:if>
                   <tr class="crosscolor_tr">
			        <td class="crosscolor_td">
			             	 所属分局
		           </td>
			        <td>     	
					<select id="fjid" value="" onchange="getPcs('fjid','pcsid');" >
						<option>请选择...</option>
					</select>
					</td>
					
					<td class="crosscolor_td">
			             	所属派出所
		           </td>
					<td><select id="pcsid" value="">
						<option>请选择...</option>
					</select>

					<input type="hidden" name="s_sspcs" id="sspcs" />
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                     
	                               <input type="button"  value="查询" onclick="query();"/>
	                               <input type="button" value="清空" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>
<script language="javascript">
function query(){
	submitValue('fjid','pcsid','','sspcs')
	document.forms[0].action='${ctx}/pages/fjy/Tcpinfo/queryList.do'
	document.forms[0].submit();
}

getFj('fjid');
function createGszzh(obj){
	
		if(obj.value=="1"){
			document.getElementById("gszzh").readOnly=false;

		}
		else{
		document.getElementById("gszzh").value="";
		document.getElementById("gszzh").readOnly=true;

		}
		
}
</script>
</html>