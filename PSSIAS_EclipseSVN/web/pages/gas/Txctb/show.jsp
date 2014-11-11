<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
List listfile = (List) request.getAttribute("listfile");
List listpic = (List) request.getAttribute("listpic");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Txctb.TABLE_ALIAS%>详情</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Txctb/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center" 	cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Txctb.TABLE_ALIAS%>详情
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_BT%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bt}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBR%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fbr}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBSJ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.fbsj}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_CZ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cz}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="&nbsp;&nbsp;&nbsp;">
			                      <%=Txctb.ALIAS_NR%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.nr}" />
		                  </td>
                   </tr>
                   
                    <%
							if (listpic != null) {
						%>		
								
				          <tr class="crosscolor_tr">
				          <td>照片</td>
				           <td align="left" colspan="3">&nbsp;&nbsp;&nbsp;
				          <%
								for (int j = 0; j < listpic.size(); j++) {
									Map results = (HashMap) listpic.get(j);
									String PICID = (String) results.get("ID");
						%>
			                   <img src='${ctx}/pages/gas/Txctb/showPic.do?xh=<%=PICID %>' height="180" alt="" width="150"  border="0" name="photo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<%
							     }
				          %>
			                   </td>
				          
	                   		</tr>
	                   		<%
							 }
						%>
						
                   <%
							if (listfile != null) {
								for (int i = 0; i < listfile.size(); i++) {
									Map results = (HashMap) listfile.get(i);
									String FILEID = (String) results.get("FILEID");
									String FILENAME =(String)results.get("FILENAME");
						%>
		
		
						<tr class="crosscolor_tr">
							  <td class="crosscolor_td">
								附件
							</td>
							<td colspan="3"  >
								
								<a href="javascript:download('<%=FILEID%>');"><%=FILENAME %></a>
							</td>
						</tr>
		
						<%
							     }
							 }
						%>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Txctb/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>
</body>
</html>
<script>
 function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/downloadDBgas.do?FILEID="+FILEID;
    	location.href = url;
    }
</script>