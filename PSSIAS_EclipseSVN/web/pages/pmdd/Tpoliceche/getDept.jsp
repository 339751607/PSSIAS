<%@page import="com.dyneinfo.pmdd.model.*" %>
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
	<title>用户登录</title>
	<base target="_self"/>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>


<div class="queryPanel">
    <s:form action="/pages/pmdd/Tpoliceche/getDept.do?flag=1"  theme="simple" style="display: inline;" method="post"  id="query" name="query" >
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">用户登录
			              <input type="hidden" value="<%=request.getParameter("flag")%>" id="sFlag" name="sFlag"/>
			              </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">用户名</td>
			              <td>
		                           <input value=""  name="s_username"  />
		                  </td>
                          <td class="crosscolor_td">密码</td>
			              <td>
		                           <input value=""  name="password"  type="password"/>
		                  </td>
                   </tr>
	           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="button"  value="登录" onclick="checkItem()"/>
	                              <input type="button"  value="取消" onclick="window.close()"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<div style="display:none">
<ec:table items='page.result' var="item" method="get" 
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/Tpoliceche/getDept.do" autoIncludeParameters="true">
	<ec:row >
		<ec:column property="选择" title="<input type='radio' onclick=\"setAllCheckboxState('items',this.radio)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="radio" name="items" value="${item.deptname}/${item.fullname}" checked="true"/>
		</ec:column>			
		                    <ec:column property="username"  title="<%=SsUser.ALIAS_USERNAME%>"/>
		                    <ec:column property="fullname"  title="<%=SsUser.ALIAS_FULLNAME%>"/>
		                    <ec:column property="sfzh"  title="<%=SsUser.ALIAS_SFZH%>"/>
		                    <ec:column property="deptname"  title="所属单位"/>
	</ec:row>
</ec:table>
</div>

</body>

</html>
<script>
	  function doAddRight() {
		    var form = document.forms.ec;
			if(!form) return;
			//alert("dddd"+document.getElementById("type1").value);
			if (!hasOneChecked('items')){
				if(document.getElementById("sFlag").value == '1')
               		alert("用户名或密码有误,请重新输入!");
               return;
             }
          
	        var opts =     document.getElementsByName("items");
	    //  var opts = document.getElementById("items");

	      for(i=0;i<opts.length;i++){
	    	  if(opts[i].checked){	 
	    		  var opts1 = opts[i].value;
	    	  }
	    	 
	    	  
	      }

	      var caller = window.dialogArguments; 
	      		
	      caller.document.getElementById("deptid").value = opts1.split("/")[0];
	      caller.document.getElementById("checkname1").value = opts1.split("/")[1]; 
	      
	      
		   window.close();
    
	  }
	  
	  function checkItem(){

	      		
	      if(document.getElementById("s_username").value==""){
	      	alert("请输入用户名!");
	      	document.getElementById("s_username").focus();
	      	return;
	      }
	      
	      if(document.getElementById("password").value==""){
	      	alert("请输入密码!");
	      	document.getElementById("password").focus();
	      	return;
	      }
	      document.query.submit();
	      
	      
	     
	  }
	  
	  doAddRight();
</script>


