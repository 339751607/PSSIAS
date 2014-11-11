<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
List list = (List) request.getAttribute("listpic");
List listfile = (List) request.getAttribute("listfile");
String fzFlag = "";
    if(request.getAttribute("fzFlag") != null) 
       fzFlag = (String)request.getAttribute("fzFlag");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self"/> 
	<title><%=SsNotice.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/SsNotice/replypop.do" method="get" theme="simple">
	<s:hidden name="noticeid" id="noticeid" value="%{model.noticeid}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=SsNotice.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.noticetitle}" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			             <td colspan="3">
		                           <s:property value="%{model.noticecontent}" />
		                  </td>
                   </tr>
		             <tr class="crosscolor_tr">

		                  <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td  colspan="3">
		                           <s:property value="%{model.sendunitname}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">
                          
		                
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			               <td colspan="3">
		                           <s:property value="%{model.createtimeString}" />
		                  </td>
                   </tr>
                   <%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Map results = (HashMap) list.get(i);
							String FILEID = (String) results.get("FILEID");
							
				%>
				<tr class="crosscolor_tr">
					<td>
						图片
					</td>
					<td colspan="3" align="right" >
						
						<a href="javascript:view('<%=FILEID%>');">查看</a>
					</td>
				</tr>
				<%
					    }
					}
				%>

				<%
					if (listfile != null) {
						for (int i = 0; i < listfile.size(); i++) {
							Map results = (HashMap) listfile.get(i);
							String FILEID = (String) results.get("FILEID");
				%>


				<tr class="crosscolor_tr">
					<td>
						附件
					</td>
					<td colspan="3" align="right" >
						
						<a href="javascript:download('<%=FILEID%>');">下载</a>
					</td>
				</tr>

				<%
					     }
					 }
				%>
				
                   <tr>
						  <td colspan="4" class="tb_bottom">
					     <authz:authorize  ifNotGranted="ROLE_ADMIN">
							  <c:if test="${model.isreply =='1'}"> 
							     <% if(fzFlag != null && fzFlag.equals("0")) { %>
							    <input id="submit" name="submit" type="submit" value="回执" />
							      <%} %>
							    </c:if>
	                     </authz:authorize >
						  <a href="${ctx}/pages/fjy/SsNotice/listPop.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>">返 回</a>
						     
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>

<script>
	

	
    function view(FILEID){
    	var url="";
    	url ="${ctx}/pages/fjy/FileAttach/pictShow.do?FILEID="+FILEID;
    	newwin = window.open(url,
						"popupnav",
						"resizable=yes,status=yes,menubar=no,scrollbars=yes");
    }

    function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/downloadDB.do?FILEID="+FILEID;
    	location.href = url;
    }
</script>