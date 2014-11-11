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
	<title><%=TbkPerson.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TbkPerson/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=TbkPerson.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.xm}"  name="s_xm"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKLX%>
		                  </td>
			              <td>
		                         <mytag:select  name="s_bklx"  
	         			             value="${pageRequest.filters.bklx}" dictName="DIC_ITEM_BKLX"/>
		                  </td>
		                  
		                   <td class="crosscolor_td">
			                   <!--    <%=TbkPerson.ALIAS_TBDW%> -->
		                  </td>
			              <td>
		                       <!--    <input value="${pageRequest.filters.tbdw}"  name="s_tbdw"  /> -->
		                  </td>
		                  
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKSJ%>
		                  </td>
			              <td colspan="3">	
			                       <input id="d31312" name="s_bksj_start"  value="${pageRequest.filters.bksj_start}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
			                                        到
			                       <input id="d31412" name="s_bksj_end"   value="${pageRequest.filters.bksj_end}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
			              	                          
		                  </td>
                   </tr>		       
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkPerson/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TbkPerson/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>