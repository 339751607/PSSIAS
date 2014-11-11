<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Temployee.TABLE_ALIAS%>查询</title>
</head>

<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/Temployee/list.do"  theme="simple" style="display: inline;" method="post">
    <s:hidden key="npcodehidden"  />
<s:hidden key="nativeplacehidden"  />
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Temployee.TABLE_ALIAS%>信息查询</td>
		           </tr>
		 		      <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_EMPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.empname}"  name="s_empname"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SEX%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_sex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=Temployee.ALIAS_PERSONID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.personid}"  name="s_personid"  />
		                  </td>
                          <td class="td_tb">
			                      <%=Temployee.ALIAS_BIRTH%>
		                  </td>
			              <td class="td_input">
				                  
			                          从<input id="d3133" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3143" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"  />
		                  </td>
                   </tr>       
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_FOLK%>
		                  </td>
			              <td colspan="3">
				                <mytag:select  name="s_folk"   notEmpty="false"  dictName="T_DIC_NATION" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_SCHOOLAGE%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_schoolage"   notEmpty="false"  dictName="educations" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_HYZH%>
		                  </td>
			              <td>
				                   <mytag:select  name="s_hyzh"   notEmpty="false"  dictName="T_DIC_HYZK"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_STATURE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.stature}"  name="s_stature"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_WEIGHT%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.weight}"  name="s_weight"  />
		                  </td>
                   </tr>

					 <tr class="crosscolor_tr">
		 		 	 <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_NATIVEPLACE%>
		            </td>
		            <td colspan="3">
		 		   <%@ include file="/commons/xzqhselect.jsp" %>   
					</td>

		            <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <%=Temployee.ALIAS_NPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.npaddress}"  name="s_npaddress"  width="50"/>
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_ADDRESS%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.address}"  width="50" name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Temployee.ALIAS_CYRJZT%>
		                  </td>
			              <td>
				                    <mytag:select  name="s_cyrjzt"   notEmpty="false"  dictName="cyryFlag"/>
		                  </td>
                   </tr>
                   		         
		 		    <tr class="crosscolor_tr">
			        <td class="crosscolor_td">
			            所属分局  
		           </td>
		            <td >
		            	<select id="fjid" value="" onchange="getPcs('fjid','pcsid');getDeptByParentid('fjid','dept');">
						<option>请选择...</option></select>
		            </td>
		            <td class="crosscolor_td">
			            所属派出所
		           </td>
			        <td>
					<select id="pcsid" value="" onchange="getDeptByParentid('pcsid','dept');" >
						<option>请选择...</option>
					</select>&nbsp;&nbsp;
					</td>
		           </tr>
		          <tr class="crosscolor_tr">
		 		     <td class="crosscolor_td">
			                     所属企业
		                  </td>
		                  <td colspan="3">
		 		    	<select id="dept" value="" onchange="getParentid('dept','pcsid');">
						<option>请选择...</option>
					</select>
					<input type="hidden" name="dept_seq" id="deptseq" />
					<input type="hidden" name="xx" value="dd">
		          	</td>
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
	submitValue('fjid','pcsid','dept','deptseq')
	document.forms[0].action='${ctx}/pages/fjy/Temployee/queryList.do'
	document.forms[0].submit();
}

getFj('fjid')
</script>
</html>