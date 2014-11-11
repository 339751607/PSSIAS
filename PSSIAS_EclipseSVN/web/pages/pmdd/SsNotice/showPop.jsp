<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
List list = (List) request.getAttribute("listpic");
List listfile = (List) request.getAttribute("listfile");
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base target="_self"/> 
	<title><%=SsNotice.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/pmdd/SsNotice/listPop.do" method="get" theme="simple">
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
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			               <td colspan="3">
		                           <s:property value="%{model.createtimeString}" />
		                  </td>
                   </tr>

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
						  <a href="${ctx}/pages/pmdd/SsNotice/listPop.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>">返 回</a>
				      <c:if test="${model.isreply == '1'}">
                    	<a href="${ctx}/pages/pmdd/SsNoticeReply/save.do?nid=${model.noticeid}&pop=true<mytag:params includes="ec*,s*" type="queryStringUtf"/>">回 执</a>
                    	</c:if>
                     </td>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>

<script>

    function view(FILEID){
    	var url="";
    	url ="${ctx}/pages/FileAttach/pictShow.do?FILEID="+FILEID;
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