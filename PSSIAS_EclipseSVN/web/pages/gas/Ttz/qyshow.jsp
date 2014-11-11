<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
List listfile = (List) request.getAttribute("listfile");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Ttz.TABLE_ALIAS%>详细</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/gas/Ttz/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Ttz.TABLE_ALIAS%>详细
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSDW%>
		                  </td>
						<td colspan ="3">
		                           <s:property value="%{model.fsdw}" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_BT%>
		                  </td>
			              <td colspan ="3">
		                           <s:property value="%{model.bt}" />
		                  </td>
					</tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_NR%>
		                  </td>
			              <td colspan ="3">
		                           <s:property value="%{model.nr}" />
		                  </td>
                   </tr>
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
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_HZFLAG%>
		                  </td>
			              <td>
		                            <mytag:write property="%{hzflag}"  name="hzflag"   notEmpty="true"  dictName="shiFou"/>
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_RQ%>
		                  </td>
			              <td>
		                           <s:property value="%{model.rq}" />
		                           <s:date name="sysTime" format="yyyy-MM-dd EE" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		            	<td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSR%>
		                  </td>
			              <td colspan ="3">
		                           <s:property value="%{model.fsr}" />
		                  </td>
		           </tr>
					<c:if test='${model.hzflag ==1}'>
							<tr>
							  <td colspan="4" class="tb_bottom">
							           <input type="button" value="回执" onclick="javascript:openhzxx(${model.id});"/>
		                      </td>
							</tr>
					</c:if>
						
                   <tr>
						  <td colspan="4" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/gas/Ttz/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>

</html>
<script>

function openhzxx(id)
{
  var sReturn = window.showModalDialog("${ctx}/pages/gas/Ttzhz/list.do?tzhzid="+id,"prompt_mes_pop","dialogHeight:350px;dialogWidth:1050px;scroll:on;center:yes");
 	  if (typeof(sReturn) != "undefined")
       {
       if (sReturn=="1")
       {
		window.location.reload();
       }
      }
}
 function download(FILEID){
		olddoc = document;
    	var url="";
    	url =  "${ctx}/filedownload/downloadDBgas.do?FILEID="+FILEID;
    	location.href = url;
    }
</script>