<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.extremecomponents.org" prefix="ec" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="mytag"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<link href="<c:url value="/styles/global.css"/>" type="text/css" rel="stylesheet">
	<script src="<c:url value="/scripts/application.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/scripts/checkBox.js"/>" type="text/javascript"></script>
	<base target="_self"/>
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title>出售人选择</title>
</head>

<body  >


<div class="queryPanel">
    <s:form action="/pages/fjy/Tcsrxx/listSelect.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	              
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcsrxx.ALIAS_IDCARD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.idcard}"  name="s_idcard"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcsrxx.ALIAS_CSRXM%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.csrxm}"  name="s_csrxm"  />
		                  </td>
                   </tr>
		           
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/Tcsrxx/listSelect.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get" 
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/Tcsrxx/listSelect.do" autoIncludeParameters="true">
	<ec:row onclick="this.childNodes[0].childNodes[0].checked=true;doSelect();">
		<ec:column property="选择" title="<input type='hidden'  >" sortable="false" width="3%" viewsAllowed="html">
			<input type="radio" style="width:20px;border:0;" name="items" value="${item.idcard}----${item.csrxm}----${item.csrdh}----${item.npaddress}----${item.praddress}----${item.hjaddress}"/>
		</ec:column>
		                    <ec:column property="idcard"  title="<%=Tcsrxx.ALIAS_IDCARD%>"/>
		                    <ec:column property="csrxm"  title="<%=Tcsrxx.ALIAS_CSRXM%>"/>
<!--		                     column property="csrdh"  title=" Tcsrxx.ALIAS_CSRDH%>"/>-->
	</ec:row>
</ec:table>

</body>

</html>
<script>
  
  

	  function doSelect() {  
             
            if(checkBoxSelectCount("items") < 1){
	           alert("必须选择一行！");
	           return false;
	        }else if(checkBoxSelectCount("items") > 1){
	           alert("只能选择一行, 不允许多选！");
	           return false;
	        }
          
	        var opts =  document.getElementsByName("items");
	        var  chushoury = ""; 
	        var  chushourensfzh = ""; 
	        var  chushourenlxdh = "";
	        var npaddress="";
	        var praddress="";
	        var hjaddress="";
	        for(i=0;i<opts.length;i++){
	            if(opts[i].checked==true){
	                var itemValue = opts[i].value;
	               
	                chushourensfzh = itemValue.split('----')[0];
	                 chushoury = itemValue.split('----')[1];
	                chushourenlxdh = itemValue.split('----')[2];
	                 npaddress = itemValue.split('----')[3];
	                 praddress = itemValue.split('----')[4];
	                 hjaddress=itemValue.split('----')[5];
	            }
	        }
	      var caller = window.dialogArguments; 		
	      caller.document.getElementById("csrxm").value = chushoury;
	      caller.document.getElementById("chushourensfzh").value = chushourensfzh;
	   //   caller.document.getElementById("chushourenlxdh").value = chushourenlxdh;
	      caller.document.getElementById("npaddress").value = npaddress;
	     //  caller.document.getElementById("praddress").value = praddress;
	       caller.document.getElementById("hjaddress").value = hjaddress;
	      caller.document.getElementById("chushourensfzh").focus(); 
		  caller.location="javascript:showBirthday()";

		   //caller.document.showBirthday();
	       //caller.document.getElementById("chushoury").focus();
		   window.close();
    
	  }
</script>

