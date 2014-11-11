<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
List list = (List) request.getAttribute("listpic");
List listfile = (List) request.getAttribute("listfile");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=SsNotice.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/jxy/SsNotice/list.do" method="get" theme="simple">
	<s:hidden name="noticeid" id="noticeid" value="%{model.noticeid}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
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
			                      <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.starttimeString}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.endtimeString}" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                        <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_PARTICIPANTS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.participantsName}" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                        <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			               <td colspan="3">
		                           <s:property value="%{model.issuescopeName}" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.authorname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sendunitname}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          
		                  <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.state}"   name="state"  notEmpty="true"  dictName="NOTICE_STATE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.createtimeString}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td>
			                       <mytag:write property="%{model.isreply}"   name="isreply"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
		                  <td></td>
		                  <td></td>
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
					<td colspan="3" >
						
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
							String FILENAME = (String) results.get("FILENAME");
				%>


				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						附件
					</td>
					<td colspan="3" >
						
						<a href="javascript:download('<%=FILEID%>');"><%=FILENAME %></a>
					</td>
					
				</tr>

				<%
					     }
					 }
				%>
				
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/jxy/SsNotice/htadlist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>


<script>
	

	
    function view(FILEID){
    	var url="";
    	url ="${ctx}/jxy/FileAttach/pictShow.do?FILEID="+FILEID;
    	newwin = window.open(url,
						"popupnav",
						"resizable=yes,status=yes,menubar=no,scrollbars=yes");
    }

    function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/jxyDownloadDB.do?FILEID="+FILEID;
    	location.href = url;
    }
</script>
