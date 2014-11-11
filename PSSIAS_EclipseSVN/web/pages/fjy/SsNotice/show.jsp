<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
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
	<base href="<%=basePath%>">
	<title><%=SsNotice.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/SsNotice/reply.do" method="get" theme="simple">
	<s:hidden name="noticeid" id="noticeid" value="%{model.noticeid}"/>
	 <input type="hidden" name="returnUrl" value="!/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
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
							<div style="width:700px;height:150px; overflow:auto;">
		                        <s:property value="%{model.noticecontent}" />
							</div>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      有效期
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.starttimeString}"/>&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
		                           <s:property value="%{model.endtimeString}" />
		                  </td>
                   </tr>

                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <s:property value="%{model.sendunitname}" />
		                  </td>
                        <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			               <td >
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
			              <td colspan="3">
			                       <mytag:write property="%{model.isreply}"   name="isreply"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
                   </tr>
                      
                   <%
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							Map results = (HashMap) list.get(i);
							String FILEID = (String) results.get("FILEID");
							
				%>
				<tr class="crosscolor_tr">
					  <td class="crosscolor_td">
						图片
					</td>
					<td colspan="3">
						
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
					  <td class="crosscolor_td">
						附件
					</td>
					<td colspan="3"  >
						
						<a href="javascript:download('<%=FILEID%>');">下载</a>
					</td>
				</tr>

				<%
					     }
					 }
				%>
				
                   <tr>
						  <td colspan="4" class="tb_bottom">
						  <!--  
						 <authz:authorize  ifNotGranted="ROLE_ADMIN">
							  <c:if test="${model.isreply =='1'}"> 
							     <% if(fzFlag != null && fzFlag.equals("0")) { %>
							   	 <input id="submit" name="submit" type="submit" value="回执" />
							      <%} %>
							    </c:if>
	                     </authz:authorize >
	                     -->
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/SsNotice/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>


<script>
	

	
    function view(FILEID){
    	var url="";
    	url ="${ctx}/pages/zazh/FileAttach/pictShow.do?FILEID="+FILEID;
	    window.showModalDialog(url,
									window,
									"dialogWidth:800px;" + "dialogHeight:700px;" 
									+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");
    }

    function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/downloadDB.do?FILEID="+FILEID;
    	location.href = url;
    }
</script>