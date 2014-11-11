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
	<title><%=TpersonbaseJn.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TpersonbaseJn/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TpersonbaseJn.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJn.ALIAS_NAME%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.name}" />
		                  </td>
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJn.ALIAS_SEX%>
		                  </td>
			              <td width="25%">
		                           <mytag:write  name="sex"  value="${model.sex}"  dictName="T_DIC_SEX"/>
		                           
		                  </td>
		                   <td rowspan="5"  width="10%" >
		                       
		                        <%
		                           String sql = request.getAttribute("sql") == null ? "" : request.getAttribute("sql").toString();
		                           String pathInfo = request.getAttribute("pathInfo") == null ? "" : request.getAttribute("pathInfo").toString();
		                           String imageInfo = "images/spacer.gif";
		                           if(pathInfo != null && !"".equals(pathInfo)){
		                        	   imageInfo = pathInfo + "?sql="+sql;
		                           }
		                         %>
						         <img src="${ctx}/<%=imageInfo %>"
							          onerror="this.src='${ctx}/images/spacer.gif'"  alt=""
							           width="130" height="170"  border="0" name="photo">
							   
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_NATION%>
		                  </td>
			              <td>
		                           <mytag:write  name="nation"  value="${model.nation}"  dictName="T_DIC_NATION"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_BDATE%>
		                  </td>
			              <td>
		                         <s:property value="%{model.bdate}" />
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDNAME%>
		                  </td>
			              <td>
		                           <mytag:write  name="cardname"  value="${model.cardname}"  dictName="T_ID_NAME"/>
		                          
		                          <input type="hidden" id="cardname" name="cardname" value="<s:property value='%{model.cardname}' />" />
		                          
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_CARDCODE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.cardcode}" />
		                            <input type="hidden"  id="cardcode" name="cardcode" value="<s:property value='%{model.cardcode}' />" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_XZQH%>
		                  </td>
			              <td>
		                          <mytag:write  name="xzqh"  value="${model.xzqh}"  dictName="T_DIC_XZQH"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <s:property value="%{model.address}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJn.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr >
						<td colspan="5" >
							<ul id="tabs">
							    <li><a>业务记录查询</a></li>
							</ul>
							<div id="content"> 
							    <div id="tab1">
							        <table border="0"  align="center"  cellPadding="0" cellSpacing="0" class="list1">
						        <tr>
						            <td >
										<c:forEach var="busObj" items="${businessCode}">
                                         
						                 <input name="businesscode" type="checkbox" value="${busObj.code}" />${busObj.called}
	                                    
						               </c:forEach>
						             </td>
						           <td>&nbsp;&nbsp;&nbsp;&nbsp;时间段</td> 
			                       <td> <input id="d31312" name="s_starttime"  value="${pageRequest.filters.starttime}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/></td>
			                       <td>到</td>
			                       <td><input id="d31412" name="s_endtime"   value="${pageRequest.filters.endtime}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/></td>
			              			<td>
						           <td  align="center" >						           
			                        <input type="button" id="btnSearch" name="btnSearch" value="查询" />
						           </td>
						        </tr>

						       <tr align="center">
						           <td colspan="5">							            
			                            <div id="divLog"><br></div>
			                            <br>
			                         
						           </td>
						        </tr>
						     </table>
							    </div>
							</div>
	                      </td>
	               </tr>
	               
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TpersonbaseJn/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <br>
	                      </td>
	               </tr>

	</table>	
</s:form>

</body>

</html>
<script>
    $(document).ready(function(){
    
      $("#btnSearch").click(function(){ 
          
          var codeArr = document.getElementsByName('businesscode');     
          
          var s_starttime = document.getElementById('s_starttime').value; 
          var s_endtime = document.getElementById('s_endtime').value; 
          if(s_starttime !=""){
              s_starttime = s_starttime.replace(/-/g,'');
              s_starttime = s_starttime + "0000";
          }
          if(s_endtime !=""){
              s_endtime = s_endtime.replace(/-/g,'');
              s_endtime = s_endtime + "2359";
          }

          var cardname = document.getElementById('cardname').value; 
          var cardcode = document.getElementById('cardcode').value; 
          
          var codeInfo = "" ;   
          var businesscode = "";       
          if(codeArr != null && codeArr.length > 0){             
             for(var i=0; i < codeArr.length; i++){             
                if(codeArr[i].checked){               
                  codeInfo = codeInfo + "" + codeArr[i].value + ",";                 
                }
             }
             if(codeInfo!=""){
                businesscode = codeInfo.substr(0,codeInfo.length-1);
             }else{
                alert("行业选项至少要选择一项！");
                return;
             }
          }else{
             alert("行业选项至少要选择一项！");
             return;
          }
          //锁定查询按钮
          $("#btnSearch").attr('disabled','true');
          
          var paramString = "s_source=" + businesscode
                      + "&s_starttime=" + s_starttime
                      + "&s_endtime=" + s_endtime
                      + "&s_cardname=" + cardname
                      + "&s_cardno=" + cardcode ; 
                      
          //alert(paramString);
          
          $.ajax({
			   type: "POST",
			   url: "${ctx}/pages/zazh/TpersonlogJn/getLogJnCount.do",
			   data: paramString,
			   success: function(msg){
			       //显示返回信息
			         //alert(msg);
	                 var dataObj = eval("("+msg+")");
					 var result = "<table border='0'>";
	                 
					 var rowid = 0;
					 var tr ="<tr>";
					 $.each(dataObj,function(idx,item){    
					    //{"count":0,"name":"旅馆","code":"001"}	
					    if(item.count > 0){						     
					         tr = tr + "<td><b>" + item.name+ "记录 : "
					              + " <a href=javascript:openBusinessInfo('"+item.code+"','"+paramString+"') >" 
					              + item.count + "</a> 条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>" ;	
					       	
					        rowid++	
					        if(rowid % 2 ==0){
						         tr = tr + "</tr>";
						    }
					    }	  
					 });
					 if(rowid <= 0){
					   tr = tr + "<td><b>没有查询到相关记录！</b></td></tr>"
					 }else if(rowid % 2 !=0){
					    tr = tr + "<td>&nbsp;</td></tr>"
					 }
					  result = result + tr + "</table>";		
	  
				      $("#divLog").html(result);				     
			   }
			});
           //恢复查询按钮
            $("#btnSearch").attr('disabled','');
          
      });
      
      
   });
   
   function openBusinessInfo(businesstype, paramString){
      //alert(businesstype + ":" + paramString);;
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();  
      var url=encodeURI("${ctx}/pages/zazh/TpersonlogJn/itemlist.do?today=" + todayStr
                             +"&s_persontype="+businesstype+"&"+paramString);        
      window.showModalDialog(url, "formDetail","dialogHeight:500px;dialogWidth:750px;scroll:yes;center:yes");

      
   }

</script>