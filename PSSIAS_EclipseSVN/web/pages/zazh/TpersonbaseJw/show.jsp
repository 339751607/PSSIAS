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
	<title><%=TpersonbaseJw.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/zazh/TpersonbaseJw/list.do" method="get" theme="simple">
	<s:hidden name="id" id="id" value="%{model.id}"/>
	<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=TpersonbaseJw.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td" width="20%" >
			                      <%=TpersonbaseJw.ALIAS_SURNAME%>
		                  </td>
			              <td width="25%" >
		                           <s:property value="%{model.surname}" />
		                  </td>
                          <td class="crosscolor_td" width="20%">
			                      <%=TpersonbaseJw.ALIAS_NAME%>
		                  </td>
			              <td width="25%">
		                           <s:property value="%{model.name}" />
		                  </td>
		                   <td rowspan="8"  width="10%">
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
			                      <%=TpersonbaseJw.ALIAS_CH_NAME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.chName}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_SEX%>
		                  </td>
			              <td>
		                       <mytag:write  name="sex"  value="${model.sex}"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_BDATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.bdate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_NATIONALITY%>
		                  </td>
			              <td>
		                           <mytag:write  name="nationality"  value="${model.nationality}"  dictName="DIC_ITEM_COUNTRY"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_T%>
		                  </td>
			              <td>
		                           <mytag:write  name="passT"  value="${model.passT}"  dictName="DIC_ITEM_PASSPORT"/>
		                            <input type="hidden" id="s_passT" name="s_passT" value="<s:property value='%{model.passT}' />" />
		                         
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_PASS_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.passNo}" />
		                           <input type="hidden"  id="s_passNo" name="s_passNo" value="<s:property value='%{model.passNo}' />" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_T%>
		                  </td>
			              <td>
			                   <mytag:write  name="visaT"  value="${model.visaT}"  dictName="DIC_ITEM_VISA"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_VISA_NO%>
		                  </td>
			              <td>
		                           <s:property value="%{model.visaNo}" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_STAY_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.stayDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_QF_UNIT%>
		                  </td>
			              <td>
		                           <mytag:write  name="qfUnit"  value="${model.qfUnit}"  dictName="DIC_ITEM_VISADEP"/>		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_DATE%>
		                  </td>
			              <td>
		                           <s:property value="%{model.inDate}" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_IN_PORT%>
		                  </td>
			              <td>
		                           <mytag:write  name="inPort"  value="${model.inPort}"  dictName="DIC_ITEM_PORT"/>
		                           
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TpersonbaseJw.ALIAS_UPDATETIME%>
		                  </td>
			              <td>
		                           <s:property value="%{model.updatetimeString}" />
		                  </td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                   </tr>
                   <tr>
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
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/zazh/TpersonbaseJw/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
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
          
          var s_passT = document.getElementById('s_passT').value; 
          var s_passNo = document.getElementById('s_passNo').value; 
          
          var codeInfo = "" ;   
          var businesscode = "";       
          if(codeArr != null && codeArr.length > 0){             
             for(var i=0; i < codeArr.length; i++){             
                if(codeArr[i].checked){               
                  codeInfo = codeInfo + codeArr[i].value + ",";                 
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
	                      + "&s_passT=" + s_passT
	                      + "&s_passNo=" + s_passNo ; 
                      
         // alert(paramString);
          
          $.ajax({
			   type: "POST",
			   url: "${ctx}/pages/zazh/TpersonlogJw/getLogJnCount.do",
			   data: paramString,
			   success: function(msg){
			       //显示返回信息
	                 var dataObj = eval("("+msg+")");
					 var result = "<table border='0'>";	                 
					 
					 var rowid = 0;
					 var tr ="<tr>";
					 $.each(dataObj,function(idx,item){    
					   if(item.count > 0){						     
					         tr = tr + "<td>" + item.name+ "记录 : "
					              + " <a href=javascript:openBusinessInfo('"+item.code+"','"+paramString+"') >" 
					              + item.count + "</a> 条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" ;	
					       	
					        rowid++	
					        if(rowid % 2 ==0){
						         tr = tr + "</tr>";
						    }
					    }	 		  
					 });
					  if(rowid <= 0){
					   tr = tr + "<td>没有查询到相关记录！</td></tr>"
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
     // alert(business + ":" + paramString);
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();    
      var url = encodeURI("${ctx}/pages/zazh/TpersonlogJw/itemlist.do?today=" + todayStr
                             +"&s_persontype="+businesstype+"&"+paramString);
                               
      window.showModalDialog(url, "formDetail","dialogHeight:450px;dialogWidth:700px;scroll:yes;center:yes");

      
   }

</script>