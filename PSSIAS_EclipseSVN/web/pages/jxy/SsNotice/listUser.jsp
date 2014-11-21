<%@page import="com.dyneinfo.jxy.model.*" %>
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
	<title><%=SsNotice.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit();">
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/jxy/SsNotice/listUser.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=SsNotice.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.noticetitle}"  name="s_noticetitle"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.authorid}"  name="s_authorid"  />
		                  </td>
                         
                   </tr>
                  

                        
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td align="left">
			              <table class="list">
			              <tr>
			              <td>
		                    <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              </td>
			              <td>从</td>
			              <td>
			              <input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/>
			              </td>
			              <td>到</td>
			              <td>
			              <input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
			              </td>
			              </tr>
			              </table>
		                  </td>
		                                            <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.sendunitid}"  name="s_sendunitid"  />
		                  </td>
		                 </tr> 
		                  
		                  
		           
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			               <td colspan="3" align="left">
			               <table class="list">
			               <tr>
			              <td>
		                           <s:select name="dateSelect3" list="dateSelectMap"  onchange="dateselect(this,'s_endtimeBegin','s_endtimeEnd','yyyy-MM-dd');"  value="#request.dateSelect3" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			               </td>
			               <td>从</td>
			               <td>
			                  <input id="d3133" name="s_endtimeBegin"  value="${pageRequest.filters.endtimeBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3143\')}'})"/>
			               </td>
			               <td>到</td>
			               <td>
			                  <input id="d3143" name="s_endtimeEnd"   value="${pageRequest.filters.endtimeEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3133\')}'})"/>
			               </td>
			              </tr>
			              </table>
		                  
		                  </td>
                   </tr>
		          
		          
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/SsNotice/listUser.do'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/SsNotice/listUser.do" autoIncludeParameters="true">
	<ec:row>
		                    <ec:column width="250px" property="noticetitle"  title="<%=SsNotice.ALIAS_NOTICETITLE%>"/>
		                    <ec:column property="starttime" value="${item.starttimeString}" title="<%=SsNotice.ALIAS_STARTTIME%>"/>
		                    <ec:column property="endtime" value="${item.endtimeString}" title="<%=SsNotice.ALIAS_ENDTIME%>"/>
		                    <ec:column property="authorname"  title="<%=SsNotice.ALIAS_AUTHORID%>"/>
		                    <ec:column property="sendunitname"  title="<%=SsNotice.ALIAS_SENDUNITID%>"/>
		                   
		<ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/jxy/SsNotice/showUser.do?noticeid=${item.noticeid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			
		</ec:column>
	</ec:row>
</ec:table>
</body>
        </script>
</html>

