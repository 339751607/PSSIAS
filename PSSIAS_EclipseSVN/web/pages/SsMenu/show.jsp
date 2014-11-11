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
	<title><%=SsMenu.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/SsMenu/list.do" method="get" theme="simple">
	<s:hidden name="menuid" id="menuid" value="%{model.menuid}"/>

	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	     <tr>
				  <td colspan="4" class="tb_title"> 
							<%=SsMenu.TABLE_ALIAS%>信息
				  </td>
		</tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENUNAME%></td>	
			<td><s:property value="%{model.menuname}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENUDESC%></td>	
			<td><s:property value="%{model.menudesc}" /></td>
        </tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENULABEL%></td>	
			<td><s:property value="%{model.menulabel}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsMenu.ALIAS_ISLEAF%></td>	
			<td><s:property value="%{model.isleaf}" /></td>
        </tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENUURL%></td>	
			<td><s:property value="%{model.menuurl}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENULEVEL%></td>	
			<td><s:property value="%{model.menulevel}" /></td>
        </tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_ROOTID%></td>	
			<td><s:property value="%{model.rootid}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsMenu.ALIAS_PARENTID%></td>	
			<td><s:property value="%{model.parentid}" /></td>
        </tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_IMAGEPATH%></td>	
			<td><s:property value="%{model.imagepath}" /></td>
        
	    
			<td class="crosscolor_td"><%=SsMenu.ALIAS_MENUSEQ%></td>	
			<td><s:property value="%{model.menuseq}" /></td>
        </tr>
	    <tr class="crosscolor_tr">
			<td class="crosscolor_td"><%=SsMenu.ALIAS_DISPLAYORDER%></td>	
			<td><s:property value="%{model.displayorder}" /></td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
             </tr>
        
        <tr>
						<td colspan="4" class="tb_bottom">
							<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/SsMenu/list.do'"/>
	                        <input type="button" value="后退" onclick="history.back();"/>
	
						</td>
	     </tr>
	</table>
</s:form>

</body>

</html>