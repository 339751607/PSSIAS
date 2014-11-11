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
	<title>车辆处警</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/zazh/TalarmCar/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">车辆处警</td>
		           </tr>
		           <tr class="crosscolor_tr">                        
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>                        
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_CARID%>
		                  </td>
			              <td>
			                      <mytag:select  name="s_prefix"  
	         			             value="${pageRequest.filters.prefix}" dictName="cpht"/>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
		               </tr>
		               <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>

                          <td class="crosscolor_td">
			                      <%=TalarmCar.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>                   
                   </tr>	
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_BKTYPE%>
		                  </td>
			              <td>
		                            <mytag:select  name="s_bktype"  
	         			             value="${pageRequest.filters.bktype}" dictName="DIC_ITEM_BKLX"/>	
	         			             
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TalarmPerson.ALIAS_ALARMTYPE%>
		                  </td>
			              <td>
			                      <mytag:select  name="s_alarmtype"  
	         			             value="${pageRequest.filters.alarmtype}" dictName="DIC_ITEM_ALARMTYPE"/>	                     
		                  </td>
                   </tr>	      
                    <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      处警状态
		                  </td>
			              <td>
		                            <mytag:select  name="s_clflag"  
	         			             value="${pageRequest.filters.clflag}" dictName="DIC_ITEM_CLFLAG"/>	         			             
		                  </td>
                          <td class="crosscolor_td">
			                    
		                  </td>
			              <td>
			                                         
		                  </td>
                   </tr>     
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmCar/list.do'"/>
	                               <!-- 
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/TalarmCar/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
	                                -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/TalarmCar/list.do" autoIncludeParameters="true">
	<ec:row>
	          <ec:column property="carowner"  title="<%=TalarmCar.ALIAS_CAROWNER%>"/>
              <ec:column property="carid"  title="<%=TalarmCar.ALIAS_CARID%>"/>
              <ec:column property="enginecode"  title="<%=TalarmCar.ALIAS_ENGINECODE%>"/>
              <ec:column property="bodycode"  title="<%=TalarmCar.ALIAS_BODYCODE%>"/>
              <mytag:lookupcolumn property="cartype"  title="<%=TalarmCar.ALIAS_CARTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cllx" />
              <ec:column property="brand"  title="<%=TalarmCar.ALIAS_BRAND%>"/>
              <mytag:lookupcolumn property="color"  title="<%=TalarmCar.ALIAS_COLOR%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="csys" />
              <mytag:lookupcolumn property="bktype"  title="<%=TalarmCar.ALIAS_BKTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_BKLX" />
              <mytag:lookupcolumn property="alarmsource"  title="<%=TalarmCar.ALIAS_ALARMSOURCE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_ITEM_BUSSINESS" />
              <mytag:lookupcolumn property="alarmtype"  title="<%=TalarmCar.ALIAS_ALARMTYPE%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="DIC_ITEM_ALARMTYPE" />
              <ec:column property="alarmtime"  parse="yyyyMMddHHmm" format="yyyy-MM-dd HH:mm" cell="date" value="${item.alarmtime}" title="<%=TalarmCar.ALIAS_ALARMTIME%>"/>
		      <mytag:lookupcolumn property="clflag"  title="<%=TalarmCar.ALIAS_CLFLAG%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="cjbz" />
           
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
	    	<a href="${ctx}/pages/zazh/TalarmCar/alarmshow.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">处警</a> &nbsp;&nbsp;
            <a href="${ctx}/pages/zazh/TalarmCar/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
		</ec:column>
	</ec:row>
</ec:table>

</body>

</html>


