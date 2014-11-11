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
	<title>上传情况统计</title>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/ylcs/SatisficInfo/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	              <tr>
			          <td class="tb_title" colspan="2" >上传情况统计</td>
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
		                    			<td style="border: none;" >上传</td>
		                    			<td style="border: none;" ><select name="s_day" >
		                    											<option value="1">1</option>
		                    											<option value="2">2</option>
		                    											<option value="3">3</option>
		                    											<option value="4">4</option>
		                    											<option value="5">5</option>
		                    											<option value="6">6</option>
		                    											<option value="7">7</option>
		                    											<option value="8">8</option>
		                    											<option value="9">9</option>
		                    											<option value="10">10</option>
		                    											<option value="11">11</option>
		                    											<option value="12">12</option>
		                    											<option value="13">13</option>
		                    											<option value="14">14</option>
		                    											<option value="15">15</option>
		                    											<option value="16">16</option>
		                    											<option value="17">17</option>
		                    											<option value="18">18</option>
		                    											<option value="19">19</option>
		                    											<option value="20">20</option>
		                    											<option value="21">21</option>
		                    											<option value="22">22</option>
		                    											<option value="23">23</option>
		                    											<option value="24">24</option>
		                    											<option value="25">25</option>
		                    											<option value="26">26</option>
		                    											<option value="27">27</option>
		                    											<option value="28">28</option>
		                    											<option value="29">29</option>
		                    											<option value="30">30</option>
		                    											<option value="31">31</option>
		                    									 </select> 
		                    	        </td>
		                    			<td style="border: none;">天以上</td>
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
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="resitData(document.forms.form1)"/>
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