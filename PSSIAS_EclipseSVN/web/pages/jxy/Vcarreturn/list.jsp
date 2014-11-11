<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String webContext = request.getContextPath();
%>
<html>
<script src="<%=webContext%>/extclient/serviceItems.js"></script>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=Vcarreturn.TABLE_ALIAS%> 维护</title>
	<style type="text/css">
		div{
			vertical-align:middle;
		}
		span{
			vertical-align: bottom;
		}
		.crosscolor_tr input {
			float: left;
			margin: 0 0 0 0px;
			height: 20px;		
		
	</style>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/jxy/Vcarreturn/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	      <input type="hidden"  id="serveritem" name="serveritem" value="" />	
	               <tr>
			              <td class="tb_title" colspan="4"><%=Vcarreturn.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_CPCODE%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpcode}"  name="s_cpcode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_CPNAME%>
		                  </td>
			              <td class="crosscolor_td2">
		                           <input value="${pageRequest.filters.cpname}"  name="s_cpname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_CAROWNER%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carowner}"  name="s_carowner"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_CARTYPE%>
		                  </td>
			              <td>
			              <mytag:select value="${pageRequest.filters.cartype}" name="s_cartype" notEmpty="false" dictName="cllx"></mytag:select>
		                           
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
		                 <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_TOTIME%>
		                  </td>
			              <td > 
			                <table class="list">
			                 <tr>
			                   <td><input id="d3135" name="s_birthBegin"  value="${pageRequest.filters.birthBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/> 
			                   </td>
			                   <td>到</td>
			                   <td>
			                   <input id="d3145" name="s_birthEnd"   value="${pageRequest.filters.birthEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                       </td>
		                     </tr>
		                    </table>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_CARID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.carid}"  name="s_carid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_RECETIME%>
		                  </td>
			              <td >
				            <table class="list" >
			                 <tr>
			                    <td><input id="d31310" name="s_indateBegin"  value="${pageRequest.filters.indateBegin}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d31410\')}'})"/> 
			                    </td>   
			                    <td>到</td>
			                    <td><input id="d31410" name="s_indateEnd"   value="${pageRequest.filters.indateEnd}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d31310\')}'})"/>
		                        </td>
		                     </tr>
		                    </table>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_ENGINECODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enginecode}"  name="s_enginecode"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_BODYCODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.bodycode}"  name="s_bodycode"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_DELINAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deliname}"  name="s_deliname"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Vcarreturn.ALIAS_RECENAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.recename}"  name="s_recename"  />
		                  </td>
		                    <td class="crosscolor_td">
			                    车辆颜色
		                  </td>
			              <td>
	                          <mytag:select  name="s_color" value="${pageRequest.filters.color}"  notEmpty="false"  dictName="csys"/>
		                  </td>
                         
                   </tr>
                      <tr class="crosscolor_tr">
		     
		                   <td class="crosscolor_td">
			                   <%=Tcarinfo.ALIAS_BRAND%>
		                  </td>
			              <td>
			                <input value="${pageRequest.filters.brand}"  name="s_brand"  />
			                
		                  </td>
		                  <td></td>
		                  <td><br></td>
		           		  
		            </tr>
		             <tr class="crosscolor_tr">
		            <td class="crosscolor_td">
			                   服务项目
		                  </td>
		            <td colspan="3">
						
						<div id="addrinfo"><input name="input" id="test" value="选择" type="button" onclick="zzjs_net('popupAddr')" /></div><div id="result"></div>
					</td>
		            </tr>
		          
		           <tr>
                   
		     
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/jxy/Vcarreturn/list.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/jxy/Vcarreturn/list.do" autoIncludeParameters="true">
		<ec:exportXls fileName="empxx.xls" tooltip="输出Excel文件"/> 
	<ec:row>
	
		
		                    <ec:column property="cpcode"  title="<%=Vcarreturn.ALIAS_CPCODE%>"/>
		                    <ec:column property="cpname"  title="<%=Vcarreturn.ALIAS_CPNAME%>"/>
		                    <ec:column property="station"  title="<%=Vcarreturn.ALIAS_STATION%>"/>
		                    <ec:column property="carowner"  title="<%=Vcarreturn.ALIAS_CAROWNER%>"/>
		                    <ec:column property="cartype"  title="<%=Vcarreturn.ALIAS_CARTYPE%>"/>
		                    <ec:column property="carid"  title="<%=Vcarreturn.ALIAS_CARID%>"/>
		                    <ec:column property="enginecode"  title="<%=Vcarreturn.ALIAS_ENGINECODE%>"/>
		                    <ec:column property="bodycode"  title="<%=Vcarreturn.ALIAS_BODYCODE%>"/>
		                    <ec:column property="deliname"  title="<%=Vcarreturn.ALIAS_DELINAME%>"/>
		                    <ec:column property="recename"  title="<%=Vcarreturn.ALIAS_RECENAME%>"/>
		                    
		                  <ec:column property="totime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd HH:mm" cell="date" title="<%=Vcarreturn.ALIAS_TOTIME%>"/>
		                  <ec:column property="recetime"  parse="yyyyMMddhhmm" format="yyyy-MM-dd HH:mm" cell="date" title="<%=Vcarreturn.ALIAS_RECETIME%>"/>
		                  <ec:column property="操作" title="操作" sortable="false" viewsAllowed="html" width="30">
							<a href="${ctx}/jxy/Tcarinfo/showjsp.do?pid=${item.enrolid}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>
			
						</ec:column> 
		                   
	</ec:row>
</ec:table>

</body>

</html>


<script>
	  function doDel() {
		    var form = document.forms.ec;
			if(!form) return;
			if (!hasOneChecked('items')){
               alert('请选择要操作的对象!');
               return;
             }
	        if (confirm('确定执行[删除]操作?')){
				var input_txt = document.createElement("input");
				input_txt.type = "hidden";
				input_txt.name = "returnUrl";
				input_txt.value = "!/jxy/Vcarreturn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/jxy/Vcarreturn/delete.do';
	            form.submit();
	        }
	  }
</script>
<script type="text/javascript">

//工作地点键值匹配数组
<%=request.getAttribute("data")%>
<%=request.getAttribute("dataTwo")%>

</script>
