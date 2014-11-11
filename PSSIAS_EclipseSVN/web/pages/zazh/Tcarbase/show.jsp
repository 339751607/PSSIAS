<%@page import="com.dyneinfo.zazh.model.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<base href="<%=basePath%>">
		<title>车辆信息</title>
	</head>

	<body>
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/pages/zazh/Tcarbase/list.do" method="get"
			theme="simple">
			<s:hidden name="id" id="id" value="%{model.id}" />
			<table width="100%" border="1" bordercolor="#7c8ca7" align="center"
				cellPadding="0" cellSpacing="0" class="tb_all">
				<tr>
					<td colspan="5" class="tb_title">
						车辆信息
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td" width="20%">
						<%=Tcarbase.ALIAS_CAROWNER%>
					</td>
					<td width="25%">
						<s:property value="%{model.carowner}" />
					</td>
					<td class="crosscolor_td" width="20%">
						<%=Tcarbase.ALIAS_CARID%>
					</td>
					<td width="25%">
						<s:property value="%{model.carid}" />
						<input type="hidden" id="carid" name="carid"
							value="<s:property value='%{model.carid}' />" />

					</td>
					<td rowspan="5" width="10%"">
						<%
	                           String sql = request.getAttribute("sql") == null ? "" : request.getAttribute("sql").toString();
	                           String pathInfo = request.getAttribute("pathInfo") == null ? "" : request.getAttribute("pathInfo").toString();
	                           String imageInfo = "images/noCar.gif";
	                           if(pathInfo != null && !"".equals(pathInfo)){
	                        	   imageInfo = pathInfo + "?sql="+sql;
	                           }
	                         %>
						<img src="${ctx}/<%=imageInfo%>"
							onerror="this.src='${ctx}/images/noCar.gif'" alt="" width="200"
							height="100" border="0" name="photo">

					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_CARTYPE%>
					</td>
					<td>
						<mytag:write name="cartype" value="${model.cartype}"
							dictName="cllx" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_COLOR%>
					</td>
					<td>
						<mytag:write name="color" value="${model.color}" dictName="csys" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_ENGINECODE%>
					</td>
					<td>
						<s:property value="%{model.enginecode}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_BODYCODE%>
					</td>
					<td>
						<s:property value="%{model.bodycode}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">

					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_BRAND%>
					</td>
					<td>
						<s:property value="%{model.brand}" />
					</td>
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_CARMODE%>
					</td>
					<td>
						<s:property value="%{model.carmode}" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Tcarbase.ALIAS_UPDATETIME%>
					</td>
					<td>
						<s:property value="%{model.updatetimeString}" />
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="5">
						<ul id="tabs">
							<li>
								<a>业务记录查询</a>
							</li>
						</ul>
						<div id="content">
							<div id="tab1">
								<table border="0" align="center" cellPadding="0" cellSpacing="0"
									class="list1">
									<tr>
										<td>
											<c:forEach var="busObj" items="${businessCode}">

												<input name="businesscode" type="checkbox"
													value="${busObj.code}" />${busObj.called}
	                                    
						               </c:forEach>
										</td>
										<td>
											&nbsp;&nbsp;&nbsp;&nbsp;时间段
										</td>
										<td>
											<input id="d31312" name="s_starttime"
												value="${pageRequest.filters.starttime}" maxlength="0"
												size="15" class="Wdate" type="text"
												onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})" />
										</td>
										<td>
											到
										</td>
										<td>
											<input id="d31412" name="s_endtime"
												value="${pageRequest.filters.endtime}" maxlength="0"
												size="15" class="Wdate" type="text"
												onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})" />
										</td>
										<td>
										<td align="center">
											<input type="button" id="btnSearch" name="btnSearch"
												value="查询" />
										</td>
									</tr>

									<tr align="center">
										<td colspan="5">
											<div id="divLog">
												<br>
											</div>
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
						<input type="button" value="返回"
							onclick="window.location='${ctx}/pages/zazh/Tcarbase/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
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

          var carid = document.getElementById('carid').value; 
          
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
                      + "&s_carid=" + carid ; 
                      
          //alert(paramString);
          
          $.ajax({
			   type: "POST",
			   url: "${ctx}/pages/zazh/Tcarlog/getLogJnCount.do",
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
      //alert(businesstype + ":" + paramString);;
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();     
      url=encodeURI("${ctx}/pages/zazh/Tcarlog/itemlist.do?today=" + todayStr
                             +"&s_cartype="+businesstype+"&"+paramString);       
      window.showModalDialog(url, "formDetail","dialogHeight:450px;dialogWidth:700px;scroll:yes;center:yes");

      
   }

</script>