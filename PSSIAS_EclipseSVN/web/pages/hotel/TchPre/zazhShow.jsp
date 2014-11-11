<%@page import="com.dyneinfo.hotel.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
boolean existCar = (Boolean)request.getAttribute("existCar");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
		<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<base href="<%=basePath%>">
	<base target="_self"/> 
	<title><%=TchPre.TABLE_ALIAS%></title>
<script type="text/javascript">
   function openNewWindow(enrolid){
      var url=encodeURI("${ctx}/pages/hotel/Tcarinfo/show.do?enrolid=" + enrolid);        
      window.showModalDialog(url, "formDetail","dialogHeight:200px;dialogWidth:750px;scroll:yes;center:yes");
   }
</script>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/hotel/TchPre/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TchPre.TABLE_ALIAS%>
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_SEX%>
		                  </td>
			              <td>
		                            <mytag:write property="%{model.sex}" dictName="T_DIC_SEX"/>
		                  </td>
		                  <td rowspan="7" align="center" width="15%">
		                  <img
							src='${ctx}/pages/hotel/TchPre/showPic.do?id=<s:property value="%{model.id}" />'
							onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							width="130" height="170"  border="0" name="photo">
		                  </td>		
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.nation}" dictName="DIC_ITEM_HOTEL_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ID_NAME%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.idName}" dictName="T_ID_NAME"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ID_CODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.idCode}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_XZQH%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.xzqh}" dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		  <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_HOTELNAME%>
		                  </td>
			              <td>
			              		 <s:property value="%{model.hotelname}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_NO_ROOM%>
		                  </td>
			              <td>
		                           <s:property value="%{model.noRoom}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_IN_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inTime}" />
		                  </td>		           
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_OUT_TIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.outTime}" />
		                  </td>

                   </tr>

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_BUR_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.burCode}"  dictName="ssfj" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TchPre.ALIAS_STA_CODE%>
		                  </td>
			              <td>
		                           <mytag:write property="%{model.staCode}"  dictName="teHangDwbm"/>
		                  </td>
                   </tr>
	               <tr>
						  <td colspan="5" class="tb_bottom" style="text-align: right;">
						  <%
						  		if(existCar){
						  			%>
						           <input type="button" value="车辆信息" onclick='javascript:openNewWindow("${model.id}")'/>
						  			<%
						  		}
						  %>
	                      </td>
		           </tr>
                   <tr>
				          <td colspan="5" class="tb_title"> 
							同住人信息
				          </td>
	               </tr>
	</table>	
</s:form>
					<ec:table items='page.result' var="item" method="get"
						retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
						action="${ctx}/pages/hotel/TchPre/zazhShow.do" autoIncludeParameters="true" sortable="false">
						<ec:row>
							                    <ec:column property="name"  title="<%=TchPre.ALIAS_NAME%>"/>
							                    <ec:column property="bdate"  title="<%=TchPre.ALIAS_BDATE%>" parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"/>		                    
							                    <mytag:lookupcolumn property="idName"  title="<%=TchPre.ALIAS_ID_NAME%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ID_NAME" />
							                    <ec:column property="idCode"  title="<%=TchPre.ALIAS_ID_CODE%>"/>
												<ec:column property="hotelname" title="<%=TchPre.ALIAS_HOTELNAME%>">
													<a href="${ctx}/pages/hotel/Thotel/show.do?code=${item.hotelid}" >${item.hotelname}</a>
												</ec:column>
							                    <ec:column property="noRoom"  title="<%=TchPre.ALIAS_NO_ROOM%>"/>
							                    <ec:column property="inTime"  title="<%=TchPre.ALIAS_IN_TIME%>" parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date"/>
							                    
							<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
								<a href="${ctx}/pages/hotel/TchPre/zazhShow.do?id=${item.id}&roommates=${model.roommates}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
							</ec:column>
						</ec:row>
					</ec:table>
                   
</body>

</html>
