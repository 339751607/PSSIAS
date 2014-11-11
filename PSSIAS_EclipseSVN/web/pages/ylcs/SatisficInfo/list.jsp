<%@page import="com.dyneinfo.zazh.model.*" %>
<%@page import="java.util.*" %>
<%@page import="com.dyneinfo.ylcs.model.SatisficInfo" %>
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
	<title>上传情况统计</title>
	<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
	<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
	<script type="text/javascript">
		function resetForm(){
			resitData(document.forms.form1);
			document.getElementById("id_day").selectedIndex = 0;
		}
	</script>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/ylcs/SatisficInfo/list.do" name="form1"  theme="simple" style="display: inline;" method="post">
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
		                    			<%
		                    				String d = request.getParameter("s_day")==null?"1":request.getParameter("s_day");
		                    			 %>
		                    			
		                    			<td style="border: none;" ><select id="id_day"  name="s_day" >
		                    											<option value="1" selected>1</option>
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
		                    	        
		                    	         <script type="text/javascript">
										  <!--
											var s = document.getElementById("id_day");
											(s.selectedIndex) = <%=Integer.parseInt(d)-1%>;
										  //-->
										  </script>
		                    			<td style="border: none;">天以上</td>
		                    		</tr>
		                    	</table>
	         			    <input type="hidden" name="hidden_statisType" value="<%=request.getAttribute("statisType")%>"/> 
			                <input type="hidden" name="hidden_burcode" value="<%=request.getAttribute("burcode")%>"/>
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
			                       <input type="button"  value="统计"  onclick="checkData()" />
			                       <input style="margin-left: 20px" type="button" value="重置" onclick="resetForm()"/> <!--  resetForm(); -->
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>

<div class="eXtremeTable" >
	
<table id="ec_table"   border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >
    <thead>    
    
    <tr  >
     <td class="tableHeader" rowspan="2">所属区域</td>
    <%
       HashMap<String,String> nameMap = (HashMap<String,String>)request.getAttribute("nameMap");
       String businCodeInfo = "";
	   List businessDictList = request.getAttribute("businessDictList") == null? null : (List)request.getAttribute("businessDictList");
	   if(businessDictList!=null && businessDictList.size()>0){		   
		   for(int i=0; i < businessDictList.size(); i++){
			   DictItem item = (DictItem)businessDictList.get(i);
			   //businCodeInfo = businCodeInfo + item.getDictid() +",";*/
			 
	 %>
	    <td class="tableHeader" colspan="3">
	    		<table><tr align="center"><td colspan="3" ><%=item.getDictname() %></td></tr>
	    			   <tr><td border="1">营业数</td><td>上传数</td><td>未上传数</td></tr>
	    		</table>
	    </td>
	 <%
		   }
	   }
	%>	
    </tr>
    </thead>
    
    <tbody class="tableBody" >
    
    <%
    	List<ArrayList<String>> chongzuList = (List<ArrayList<String>>)request.getAttribute("deptList");
    	
    	for(int i=0; i<chongzuList.size(); i++){ 
    	
    %>
    
    
    <%/*
	   String[] codeArray = null; 
	   if(businCodeInfo!=null && !"".equals(businCodeInfo)){
		   businCodeInfo = businCodeInfo.substring(0,businCodeInfo.length()-1);
		   codeArray = businCodeInfo.split(",");
	   }
       int[] totalcountArray = new int[codeArray.length];
	   List deptList = request.getAttribute("deptList") == null? null : (List)request.getAttribute("deptList");
	   int total = 0;
	   if(deptList!=null && deptList.size()>0){		   
		   for(int i=0; i < deptList.size(); i++){
			   SatisficInfo satisfic = (SatisficInfo)deptList.get(i);					  
               String deptName = satisfic.getDeptName();
              // HashMap deptCountMap = (HashMap)deptMap.get("deptCountMap");
              */
               String rowColor= "odd";
               if(i%2!=0){
            	   rowColor = "even";
               }
           %>
           <tr class=<%=rowColor %> >
           <%
           		for(int j=0; j<chongzuList.get(i).size(); j++)
           		{
            %>
            	<%if(j==0){
            	
            	%>
            	<td><%=nameMap.get(chongzuList.get(i).get(j))%></td>
            	<%
            	
            	}else{ %>
           		 <td><%=chongzuList.get(i).get(j)%></td>
		  	<%
		  	 	}
		  	 	}
		  	 
	   }
	   
	   %>
	   <%
	   	   List<String> hejiList = (List<String>)request.getAttribute("hejiList");
	    %>
	    <tr class="odd"  >
	    	<%
	    		for(String tdStr : hejiList){
	    	 %>
            <td ><%=tdStr %></td>
             <%
				}
             %>
             
            </tr>
     </tbody>
</table>
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
function startSetValue(){
    var r =document.getElementById("hidden_statisType").value;
    setradio( r );
  //  var v =document.getElementById("hidden_burcode").value;
  //  setCombox("s_burcode" , v);
}
startSetValue();
</script>
</html>

