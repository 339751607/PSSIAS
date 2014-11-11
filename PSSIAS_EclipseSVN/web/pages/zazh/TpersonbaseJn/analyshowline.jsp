<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//String strXML = request.getAttribute("strXML")==null?"":request.getAttribute("strXML").toString();
%>
<html>
<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title>境内人员轨迹</title>

</head>
<body onload="quickSelectInit();">
	<s:form action="/pages/zazh/TpersonbaseJn/analylist.do"  theme="simple" style="display: inline;" method="post">
		<s:hidden name="id" id="id" value="%{model.id}"/>
		<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
		               <tr>
					          <td colspan="5" class="tb_title"> 
								境内人员信息
					          </td>
			           </tr>
			           <tr class="crosscolor_tr">
	                          <td class="crosscolor_td"  width="20%">
				                      <%=TpersonbaseJn.ALIAS_NAME%>
			                  </td>
				              <td width="25%">
			                           <s:property value="%{model.name}" />
			                  </td>
	                          <td class="crosscolor_td"  width="20%">
				                      <%=TpersonbaseJn.ALIAS_SEX%>
			                  </td>
				              <td width="25%">
			                           <mytag:write  name="sex"  value="${model.sex}"  dictName="T_DIC_SEX"/>
			                           
			                  </td>
			                  <td rowspan="5"  width="10%">
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
	                   <tr class="tb_bottom"  class="crosscolor_tr">
	                          <td  colspan="2">
	                         <ul id="tabs">
							    <li><a>人员行为轨迹图</a></li>
			                 </ul>
			                  </td>
			                 <td   colspan="2">
			                     业务查询时间段：
                                    从 <%=request.getAttribute("s_starttime") %>
			                      到
			                      <%=request.getAttribute("s_endtime") %>
			                  </td>
				             <td  >
				                   
				                   <input type="hidden"  id="starttime" name="starttime" value="<%=request.getAttribute("s_starttime") %>" />
				                   <input type="hidden"  id="endtime" name="endtime" value="<%=request.getAttribute("s_endtime") %>" />

				                   <input type="button"  value="列表模式"  
				                       onclick="window.location='${ctx}/pages/zazh/TpersonbaseJn/analyshow.do?id=<s:property value="%{model.id}" />&<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>	
				
				             </td>
	                   </tr>	    
		</table>	
	</s:form>
	</div>
<table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
   <tr >
   <td>
   <div id="chartContainer1" style="background:#FFF;">
     <table border="0" align="center"  cellPadding="0" cellSpacing="0" >
       ${trackInfo}
      <!--
      <tr align="center">
          <td  >     
               住宿
             <br>    
             <img src="${ctx}/images/track/02.png"  alt="住宿"
							           width="30" height="30"  border="0" name="photo">  
			<br>
			2013-09-20   
           </td>
           <td align="center">    
             <img src="${ctx}/images/track/right.png"
							           border="0" name="photo">		       
           </td>
           <td>
               购油
             <br> 
             <img src="${ctx}/images/track/05.png"  alt="购油"
							            width="30" height="30"  border="0" name="photo">   
			<br>
			2013-12-20        
           </td>
           <td >    
                          <img src="${ctx}/images/track/right.png"
							           border="0" name="photo">				       
           </td>          
            <td>
               典当
             <br>
             <img src="${ctx}/images/track/04.png"  alt="典当"
							           width="30" height="30"  border="0" name="photo">    
		     <br>
			2014-01-20 							                 
           </td>
           <td >    
                        <img src="${ctx}/images/track/right.png"
							           border="0" name="photo">		    
           </td> 
            <td>
              修车
             <br>
             <img src="${ctx}/images/track/03.png"  alt="修车"
							           width="30" height="30"  border="0" name="photo">  
		      <br>
			2014-03-20 				                 
           </td>
           <td>    
                         <img src="${ctx}/images/track/right.png"
							           border="0" name="photo">			       
           </td> 
            <td>
              从业
            <br>
             <img src="${ctx}/images/track/01.png"  alt="从业"
							           width="30" height="30"  border="0" name="photo">  	
			 <br>
			2014-03-20		                 
           </td>          
           
      </tr>
      <tr>
         <td  height="20"></td>
         <td colspan="7">           
         </td>
         <td>
          <img src="${ctx}/images/track/down.png"  alt=""
							          border="0" name="photo">
         </td>
      </tr>
      <tr align="center">
           <td >    
             	       
           </td> 
            <td>
              			                 
           </td>
          <td  > 
             废品出售
             <br> 
             <img src="${ctx}/images/track/06.png"  alt="废品出售"
							           width="30" height="30"  border="0" name="photo">     
			 <br>
			2014-10-01
           </td>
           <td >    
             <img src="${ctx}/images/track/left.png"
							             border="0" name="photo">		       
           </td>
           <td>
             <img src="${ctx}/images/track/05.png"  alt="购油"
							           width="30" height="30"  border="0" name="photo">          
           </td>
           <td >    
             <img src="${ctx}/images/track/left.png"
							             border="0" name="photo">		       
           </td>          
            <td>
             <img src="${ctx}/images/track/04.png"  alt="典当"
							           width="30" height="30"  border="0" name="photo">    							                 
           </td>
           <td >    
             <img src="${ctx}/images/track/left.png"
							             border="0" name="photo">		       
           </td> 
            <td>
               修车
             <br>
             <img src="${ctx}/images/track/03.png"  alt="修车"
							           width="30" height="30"  border="0" name="photo"> 
            <br>
			2014-03-20			                 
           </td>

      </tr>
      --> 
   </table>
   </div>
    </td>
  </tr>
  <tr>
      <td  class="tb_bottom">
           	<s:hidden name="id" id="id" value="%{model.id}"/>
             <input type="button" value="返回" 
          onclick="window.location='${ctx}/pages/zazh/TpersonbaseJn/analylist.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>			                         
      </td>
    </tr>
   </table>
</body>
</html>
