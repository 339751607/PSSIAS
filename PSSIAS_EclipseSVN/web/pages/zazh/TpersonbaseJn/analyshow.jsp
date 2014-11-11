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
	<title>境内人员信息</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
<s:form action="/pages/zazh/TpersonbaseJn/analylist.do"  theme="simple" style="display: inline;" method="post">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							境内人员信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr" >
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJn.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td" width="25%">
			                      <%=TpersonbaseJn.ALIAS_SEX%>
		                  </td>
			              <td width="20%">
		                           <mytag:write  name="sex"  value="${model.sex}"  dictName="T_DIC_SEX"/>
		                           
		                  </td>
		                  <td rowspan="5" width="10%">
		                         
		                        <%
		                           String sql = request.getAttribute("sql") == null ? "" : request.getAttribute("sql").toString();
		                           String pathInfo = request.getAttribute("pathInfo") == null ? "" : request.getAttribute("pathInfo").toString();
		                           String imageInfo = "images/spacer.gif";
		                           if(pathInfo != null && !"".equals(pathInfo)){
		                        	   imageInfo = pathInfo + "?sql="+sql;
		                           }
		                         %>
						         <img src="${ctx}/<%=imageInfo %>"
							          onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							           width="130" height="170"  border="0" name="photo">
    
		                     </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write  name="nation"  value="${model.nation}"  dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_BDATE%>
		                  </td>
			              <td>
		                         <s:property value="%{model.bdate}" />
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <mytag:write  name="cardname"  value="${model.cardname}"  dictName="T_ID_NAME"/>
		                          
		                          <input type="hidden" id="cardname" name="cardname" value="<s:property value='%{model.cardname}' />" />
		                          
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cardcode}" />
		                            <input type="hidden"  id="cardcode" name="cardcode" value="<s:property value='%{model.cardcode}' />" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                          <mytag:write  name="xzqh"  value="${model.xzqh}"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr class="tb_bottom" class="crosscolor_tr">
                          <td  colspan="4">
                             业务查询时间段：
			                     从<%=request.getAttribute("s_starttime") %>
			                      到
			                      <%=request.getAttribute("s_endtime") %>
			                       <input type="hidden"  id="starttime" name="starttime" value="<%=request.getAttribute("s_starttime") %>" />
			                       <input type="hidden"  id="endtime" name="endtime" value="<%=request.getAttribute("s_endtime") %>" />
		                  </td>
			             <td >
			                  <input type="button"  value="图形模式"  
			                  onclick="window.location='${ctx}/pages/zazh/TpersonbaseJn/analyshowLine.do?id=<s:property value="%{model.id}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>	
			             </td>
                   </tr>
    
	</table>	
</s:form>
</div>
 <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">  	
 <tr>
	 <td >	
      <ec:table items='page.result' var="item" method="get"
		retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
		action="${ctx}/pages/zazh/TpersonbaseJn/analyshow.do" autoIncludeParameters="true">
		<ec:row>		
		<ec:column property="starttime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.starttime}" title="<%=TpersonlogJn.ALIAS_STARTTIME%>"/>
        <ec:column property="endtime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.endtime}" title="<%=TpersonlogJn.ALIAS_ENDTIME%>"/>
		<mytag:lookupcolumn property="persontype"  title="<%=TpersonlogJn.ALIAS_PERSONTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BUSINESSTYPE" />
        <mytag:lookupcolumn property="source"  title="<%=TpersonlogJn.ALIAS_SOURCE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ITEM_BUSSINESS" />
        <ec:column property="cpname"  title="<%=TpersonlogJn.ALIAS_CPNAME%>"/>
        <ec:column property="cpcode"  title="<%=TpersonlogJn.ALIAS_CPCODE%>"/>
			
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			 <a href="javascript:openDetail_JN('${ctx}','${item.sid}','${item.persontype}','${item.source}','${item.cpcode}','${item.cardname}','${item.cardno}');" />查看</a>
        </ec:column>
		</ec:row>
      </ec:table>
      </td>
         </tr>
           <tr>
			  <td  class="tb_bottom">
			           <input type="button" value="返回" 
			           onclick="window.location='${ctx}/pages/zazh/TpersonbaseJn/analylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>			                         
              </td>
          </tr>

	</table>	

</body>

</html>
