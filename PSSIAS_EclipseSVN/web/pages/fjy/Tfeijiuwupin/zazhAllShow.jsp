<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.dyneinfo.fjy.model.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Blob,java.util.*"%>
<%@ include file="/commons/taglibs.jsp" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String  picCount ="";
 if ( request.getAttribute("picCount") != null)
     picCount = (String)request.getAttribute("picCount");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<title><%=Tfeijiuwupin.TABLE_ALIAS%>信息</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>

<s:form action="/pages/fjy/Tfeijiuwupin/queryList.do" method="get" theme="simple">
	<s:hidden name="wupinxh" id="wupinxh" value="%{model.wupinxh}"/>
	<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
				          <td colspan="5" class="tb_title"> 
							<%=Tfeijiuwupin.TABLE_ALIAS%>信息
				          </td>
		           </tr>
		          <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     企业名称
		                  </td>
			              <td  colspan="3">
		                           <s:property value="%{model.deptname}" />
		                  </td>
	<td rowspan="6" width="20%" align="center" >
						      <%if(picCount != null && picCount.equals("1")) { %>
					            <img src='${ctx}/pages/fjy/Tfeijiuwupin/showPic.do?idcard=${model.chushourensfzh}'  height="126" alt="" width="102" border="0" name="photo">	
					           <% } else {%>
					              <IMG src="${ctx}/images/spacer.gif" height="126" alt="" width="102" border="0" name="photo"> 
					           <%} %>
					       </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                   收购人员
		                  </td>
			              <td >
			               <s:property value="%{model.empname}" /> 		
			              </td>
			               <td class="crosscolor_td">
			                  物品类别
		                  </td>
			              <td>
						           <mytag:write property="%{model.wupinlb}"     name="wupinlb"   notEmpty="false"  dictName="T_DIC_WUPINLB"/>
		                  </td>

                   </tr>
 					<tr class="crosscolor_tr">

			              <td class="crosscolor_td">
			                       <%=Tfeijiuwupin.ALIAS_WPZL%>
		                  </td>
			              <td>
	                               <s:property value="%{model.wpzl}" /> 		 </td>
		                  <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPSL%>
		                  </td>
			              <td>
	                                <s:property value="%{model.sgwpsl}" /> 		   </td>
                   </tr>

                   <tr class="crosscolor_tr">
                            <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_SGWPGG%>
		                  </td>
			              <td>
		                          <s:property value="%{model.sgwpgg}" /> 	    </td>
                           <td class="crosscolor_td">
			                      <%=Tfeijiuwupin.ALIAS_WPDX%>
		                  </td>
			              <td>
		                         <s:property value="%{model.wpdx}" /> 	      </td>

			              
                   </tr>



		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <%=Tfeijiuwupin.ALIAS_CHUSHOURY%>
		                  </td>
			              <td>
			              <s:property value="%{model.csrxm}" />
	                              
		                  </td>
                          <td class="crosscolor_td">
			                  <%=Tfeijiuwupin.ALIAS_CHUSHOURENXB%>
		                  </td>
			              <td>
			               <mytag:write property="%{model.csrxb}"   name="wpys"  notEmpty="true"  dictName="T_DIC_SEX"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                 <%=Tfeijiuwupin.ALIAS_CHUSHOURENSFZH%>
		                  </td>
			              <td>
			              <s:property value="%{model.chushourensfzh}" />
		                  </td>
	 					<td class="crosscolor_td">
<!--			                      Tfeijiuwupin.ALIAS_CHUSHOURENLXDH%>-->
		                  </td>
			              <td >
<!--			               <s:property value="%{model.chushourenlxdh}" />-->
		                  </td>
                   </tr>
                     <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <%=Tcsrxx.ALIAS_NPCODE%>
		                  </td>
			               <td colspan="4">
			                <mytag:write property="%{model.npcode}"   name="npcode"  notEmpty="true"  dictName="T_DIC_XZQH"/>
		             </td>
		          </tr> 
		           <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                   <%=Tcsrxx.ALIAS_NPADDRESS%>
		                  </td>
			              <td colspan="4">
			              <s:property value="%{model.npaddress}" />
		                  </td>
                   </tr>
                   <tr class="crosscolor_tr">     
                          <td class="crosscolor_td">
			                   <%=Tcsrxx.ALLAS_HJDDRESS%>
		                  </td>
			              <td colspan="4">
			              <s:property value="%{model.hjaddress}" />
		                  </td>
                   </tr>
<!--		           <tr class="crosscolor_tr">     -->
<!--                          <td class="crosscolor_td">-->
<!--			                   <%=Tcsrxx.ALIAS_PRADDRESS%>-->
<!--		                  </td>-->
<!--			              <td colspan="4">-->
<!--			              <s:property value="%{model.praddress}" />-->
<!--		                  </td>-->
<!--                   </tr>-->
                   <tr class="crosscolor_tr">


		                   <td class="crosscolor_td">
			                   收购时间
		                  </td>
			               <td colspan="4">
			               <s:property value="%{model.shougourq}" />
		                  </td>
		             </tr>
		             <tr class="crosscolor_tr">

			              <td class="crosscolor_td">
		               		  废钢铁重量
		                  </td>

			              <td width="25%">
			              		 <s:property value="%{model.zlone}" />
		                  </td>
		                     <td class="crosscolor_td">
		               		 废合金钢重量
		                  </td>
			              <td width="25%">
			              		 <s:property value="%{model.zltwo}" />
		                  </td>
                   </tr>

                   <tr class="crosscolor_tr">

			              <td class="crosscolor_td">
		               		  废有色金属重量
		                  </td>

			              <td width="25%">
			              		 <s:property value="%{model.zlthree}" />
		                  </td>
		                    <td class="crosscolor_td">
		               		 废稀有金属重量
		                  </td>

			              <td width="25%">
			              		 <s:property value="%{model.zlfour}" />
		                  </td>
                   </tr><%--
                   <tr>
						  <td colspan="5" class="tb_bottom">
						           <input type="button" value="返回" onclick="window.location='${ctx}/pages/fjy/Tfeijiuwupin/queryList.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                      </td>
	               </tr>
	--%></table>	
</s:form>

<script>
	
	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;
		
		//在这里添加自定义验证
		
		return disableSubmit(finalResult,'submitButton');
	}});
	

</script>

</body>

</html>