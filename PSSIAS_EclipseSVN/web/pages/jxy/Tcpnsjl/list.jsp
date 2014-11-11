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
	<title><%=Tcpnsjl.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Tcpnsjl/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">企业年审记录</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_NAME%>
		                  </td>
			              <td colspan="3">
		                           <input type="hidden" value="${cpcode}"  name="cpcode"  />
		                          <input type="hidden" value="${cpname}"  name="cpname"  />
		                          ${cpname}
		                          
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHND%>
		                  </td>
			              <td colspan="3">
			              <input type="hidden" value="${shnd}" name="sh">
			                   <select name="shnd" >
			                   
                  <s:iterator var="counter" begin="2001" end="2030" > <option value="${counter}" ${shnd == counter?'selected':""}>${counter}</option> </s:iterator> 
                  </select>    
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_SHRJ%>
		                  </td>
			              <td colspan="3">
			               <input value="${shrj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'${date}'})"  name="shrj" id="shrj" class="required Wdate" />		                       
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                     <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=Tcpnsjl.ALIAS_NSYJ%>
		                  </td>
                    <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_CASEDESC}" rows="6" cols="66"
							key="nsyj" value="%{model.nsyj}" cssClass="required max-length-300"
							required="false"></s:textarea>
		                         
		                       
		                  </td>
                   
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_QSR%>
		                  </td>
			              <td>
			            
		                           <s:textfield label="%{@vs@ALIAS_QSR}" key="qsr" value="%{model.qsr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=Tcpnsjl.ALIAS_JBR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JBR}" key="jbr" value="%{model.jbr}"  cssClass="required validate-chinese" required="false" />
		                  </td>
                   </tr>
		       
		      
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit" id="submitButton"  value="保存" onclick="getReferenceForm(this).action='${ctx}/jxy/Tcpnsjl/list.do?static=upd'"/>
	                              <!-- <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpinfo/listnsjl.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>-->
	                               <input type="button" value="返回" onclick="window.location='${ctx}/jxy/Tcpinfo/listnsjl.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Tcpnsjl/list.do" autoIncludeParameters="true">
	<ec:row>
             <ec:column property="cpcode"  title="<%=Tcpnsjl.ALIAS_CPCODE%>"/>
             
              <ec:column property="name"  title="<%=Tcpnsjl.ALIAS_NAME%>"/>
             <ec:column property="shnd"  title="<%=Tcpnsjl.ALIAS_SHND%>"/>               
              <ec:column property="shrj"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date" title="<%=Tcpnsjl.ALIAS_SHRJ%>"/>
             <ec:column width="30%" property="nsyj"  title="<%=Tcpnsjl.ALIAS_NSYJ%>"/>
             <ec:column property="qsr"  title="<%=Tcpnsjl.ALIAS_QSR%>"/>
             <ec:column property="jbr"  title="<%=Tcpnsjl.ALIAS_JBR%>"/>
             <ec:column width="30px" property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/jxy/Tcpnsjl/list.do?cpcode=${item.cpcode}&shnd=${item.shnd}&static=show&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
			
		</ec:column>
	
	</ec:row>
</ec:table>

</body>

</html>


<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
</script>
