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
	<title>报警信息统计</title>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/zazh/TalarmPerson/statisAlarmList.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	              <tr>
			          <td class="tb_title" colspan="2" >报警信息统计</td>
		           </tr>
		           <tr class="crosscolor_tr">
                           <td class="crosscolor_td">
			               统计范围  
		                  </td>	
		                    <td class="crosscolor_td">
		                    	<table style="border: none;">
		                    		<tr style="border: none;">
		                    			<td style="border: none;"><input type="radio" name="s_statisType" value="0" onClick="radioClick(0)"  checked></td>
		                    			<td style="border: none;">统计分局</td>
		                    			<td style="border: none;"><input type="radio" name="s_statisType" onClick="radioClick(1)"  value="1"></td>
		                    			<td style="border: none;">统计派出所</td>
		                    			<td style="border: none;"><mytag:select  name="s_burcode" value="${pageRequest.filters.burcode}" dictName="ssfj"/></td>
		                    		</tr>
		                    	</table>
	         			    
	         			    <input type="hidden" name="hidden_statisType" value="<%=request.getAttribute("statisType")%>"/> 
			                <input type="hidden" name="hidden_burcode" value="<%=request.getAttribute("burcode")%>"/>
			                 <input type="hidden" name="hidden_status" value="<%=request.getAttribute("status")%>"/>
		                  </td>		            
                   </tr>
                    <tr class="crosscolor_tr">
                           <td class="crosscolor_td">		                
			     	        报警日期      
		                  </td>	
		                  <td class="crosscolor_td">	
		                  	<table class="list">
		                  		<tr>
		                  			<td>
		                  				<input id="d31312" name="s_starttime"  value="${pageRequest.filters.starttime}"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d31412\')}'})"/>
		                  			</td>
		                  			<td>到</td>
		                  			<td>
		                  				<input id="d31412" name="s_endtime"   value="${pageRequest.filters.endtime}"  maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
		                  			</td>
		                  		</tr>
		                  	</table>	    
                          </td>			            
                   </tr> 
                   <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="button"  value="统计" onclick="checkData()"/>
	                               <!--  
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/Tcompany/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			                       -->
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>
<script type="text/javascript">

function checkData(){    
     if(getradio()=="1"){
        var burcode = document.getElementById("s_burcode").value;
        if(burcode == "" ){
           alert("请选择相应的分局进行统计！");
           return false;
        }
     }
     document.forms[0].submit();
}
function radioClick(value){

     if(value=="0"){
       setCombox("")
     }
}  
function getradio()
{  
	var robj=document.getElementsByName("s_statisType");
	for(i=0;i<robj.length;i++){
		if(robj[i].checked){
		   return robj[i].value;
		}
	}
}
function setradio(v)
{  
	var robj=document.getElementsByName("s_statisType");
	for(i=0;i<robj.length;i++){
		if(robj[i].value == v){
		   robj[i].checked=true;
		}
	}
}
function setCombox(com, v){
    var m =document.getElementById(com); 
    for(i=0;i<=m.options.length;i++){  
		  if(m.options[i].value== v )
		  {      
		   m.options[i].selected=true;   
		   break;
		  }
	 }
}

</script>
</html>