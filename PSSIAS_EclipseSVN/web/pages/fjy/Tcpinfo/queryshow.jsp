<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
    <%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String s_mpcode = (String)DictHelpImpl.getInitData("mpcode");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("mpcode",s_mpcode);
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tcpinfo.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tcpinfo/queryList.do" method="get" theme="simple">
	<s:hidden name="cpcode" id="cpcode" value="%{model.cpcode}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="4" class="tb_title"> 
							<%=Tcpinfo.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		             <tr class="crosscolor_tr">
		                    <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cpname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                    <%=Tcpinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
			                <s:property value="%{model.cpcode}" />
		                  </td>
		             </tr>
   		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SSPCS%>
		                  </td>
			              <td colspan="3">
		                           <s:property value="%{model.deptname}" />
		                  </td>
                   </tr>

		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                       <%=Tcpinfo.ALIAS_CPSTATE%>
		                  </td>
			              <td>
						       <mytag:write property="%{model.cpstate}"   name="cpstate"  notEmpty="true"  dictName="T_DIC_CPSTATE"/>
		                 </td>
		                   <td class="crosscolor_td">
			                       <%=Tcpinfo.ALIAS_CPKIND%>
		                  </td>
			              <td>

		                 	 <mytag:write property="%{model.cpkind}"   name="cpkind"  notEmpty="true"  dictName="T_DIC_CPKIND"/>
		                  </td>
		             </tr>
		                                <tr class="crosscolor_tr">
						 <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_AREA%>
		                  </td>
			              <td>
		                 	<s:property value="%{model.area}" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_JYFW%>
		                  </td>
			              <td>
		                           <s:property value="%{model.jyfw}" />
		                  </td>
                   </tr>
           		  <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPADRESS%>
		                  </td>
			              <td colspan="3">
		                 	<s:property value="%{model.cpadress}" />
		                  </td>
                   </tr>
                   	<tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPTEL%>
		                  </td>
			              <td>
		                 	<s:property value="%{model.cptel}" />
		                  </td>
		                    <td class="crosscolor_td">
			               <%=Tcpinfo.ALIAS_KYSJ%>
		                  </td>
			              <td colspan="3">
		                  	<s:property value="%{model.kysj}" />
		                  </td>
    		           
                   </tr>
                    <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SFGSZZH%>
		                  </td>
			              <td >
						            <mytag:write property="%{model.sfgszzh}"   name="sfgszzh"  notEmpty="true"  dictName="shiFou"/>
		                  </td>

                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_GSZZH%>
		                  </td>
			              <td >
		                  	<s:property value="%{model.gszzh}" />
		                  </td>
                          
                   </tr>
                   <tr class="crosscolor_tr">            
		                 <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRNAME%>
		                  </td>
			              <td>
		                 	<s:property value="%{model.frname}" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRIDCODE%>
		                  </td>
			              <td>
		                  	<s:property value="%{model.fridcode}" />
		                  </td>
                   </tr>
                  <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRSEX%>
		                  </td>
			              <td >
						            <mytag:write property="%{model.frsex}"   name="frsex"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
		                    <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CYRS%>
		                  </td>
			              <td>
		                       <a color="red" href="#" onclick="window.location='${ctx}/pages/fjy/Temployee/queryList.do?s_cpcode=${model.cpcode}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>';return false"><FONT color="red"><s:property value="%{model.cyrs}" /></FONT></a>
		                  </td>
		            </tr>      

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZR%>
		                  </td>
			              <td>
								<s:property value="%{model.zafzr}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZRDH%>
		                  </td>
			              <td>
		                  	<s:property value="%{model.zafzrdh}" />
		                  </td>
                   </tr>
<c:choose>
  <c:when test="${deptid == mpcode}">
   	                      <tr class="crosscolor_tr">
                         <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SETUPFLAG%>
		                  </td>
			              <td>
						            <mytag:write property="%{model.setupflag}"   name="setupflag"  notEmpty="true"  dictName="shiFou"/>
		                  </td>
		                  	<td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_SFBAN%>
		                  </td>
			              <td>
						           <mytag:write property="%{model.sfban}"    name="sfban"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
		            </tr> 
   </c:when>
   <c:otherwise>
             <tr class="crosscolor_tr">
                  <td class="crosscolor_td">
	                      <%=Tcpinfo.ALIAS_SFBAN%>
                  </td>
	              <td colspan="3">
				           <mytag:write property="%{model.sfban}"    name="sfban"   notEmpty="false"  dictName="shiFou"/>
                  </td>
		    </tr> 
   </c:otherwise>
  
</c:choose> 
                    <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
                    	 <%=Tcpinfo.ALIAS_CREATEUSERID%>
                    </td>
                    <td>
                    	<s:property value="%{model.createuserid}" />
                    </td>
                    <td class="crosscolor_td">
                    	 <%=Tcpinfo.ALIAS_CREATEDEPTID%>
                    </td>
                    <td>
                    	<s:property value="%{model.createdeptid}" />
                    </td>
                    </tr>
                    <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
                    	 <%=Tcpinfo.ALIAS_CREATETIME%>
                    </td>
                    <td colspan="3">
                    	<s:property value="%{model.createtime}" />
                    </td>
  
                    </tr>
                   <tr>
						  <td colspan="4" class="tb_bottom">
						    <input type="button" value="变更日志" onclick="showLog();"/>
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tcpinfo/queryList.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	</table>	
</s:form>

</body>
<SCRIPT LANGUAGE="JavaScript">
function showLog(){

	  	 var left = "50", top = "50";
	    // if(arguments[3] != null) left = "dialogLeft:" + arguments[3] + "px;"
	    // if(arguments[4] != null) top = "dialogTop:" + arguments[4] + "px;"
	     window.showModalDialog('${ctx}/pages/fjy/TcpinfoLog/list.do?s_cpcode=${model.cpcode}',
									window,
									"dialogWidth:700px;" + "dialogHeight:550px;" 
									+ left + top 
									+ "directories:yes;help:no;status:no;resizable:no;scrollbars:yes;");									
}
									
</SCRIPT>
</html>