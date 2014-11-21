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
	<title>企业编号选择</title>
	<base target="_self"/>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>


<div class="queryPanel">
    <s:form action="/pages/jxy/Tcompanyinfo/list1.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=Tcompanyinfo.TABLE_ALIAS%></td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_CPADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.cpaddress}"  name="s_cpaddress"  />
		                  </td>
                   </tr>
		      
		           <tr class="crosscolor_tr">
                        
                         
		                 
		                   <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_ECONOMY%>
		                  </td>
			              <td>
		                           
		                           <mytag:select  name="s_economy" value="${pageRequest.filters.economy}"  notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                   </tr>
		          
		          
		         
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcompanyinfo.ALIAS_POLICEUNIT%>
		                  </td>
			              <td>
		                          
		                           <mytag:select name="s_policeunit" value="${pageRequest.filters.policeunit}" notEmpty="false" dictName="ssfj"></mytag:select>
		                  </td>                       
                   </tr>
	           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/jxy/Tcompanyinfo/list1.do'"/>
	                              <input type="button"  value="选择" onclick="doAddRight()"/>
	                               
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/jxy/Tcompanyinfo/list1.do" autoIncludeParameters="true">
	<ec:row >
		<ec:column property="选择" title="<input type='radio' onclick=\"setAllCheckboxState('items',this.radio)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="radio" name="items" value="${item.cpcode}"/>
		</ec:column>			
		                    <ec:column property="cpname"  title="<%=Tcompanyinfo.ALIAS_CPNAME%>"/>
		                    <ec:column property="cpaddress"  title="<%=Tcompanyinfo.ALIAS_CPADDRESS%>"/>		                    
		                    <ec:column property="corpname"  title="<%=Tcompanyinfo.ALIAS_CORPNAME%>"/>
		                    <ec:column property="policename"  title="<%=Tcompanyinfo.ALIAS_POLICENAME%>"/>		                   	                    
		
	</ec:row>
</ec:table>


</body>

</html>
<script>
	  function doAddRight() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
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
	      		
	      caller.document.getElementById("cpcode").value = opts1;
	      
		   window.close();
    
	  }
</script>


