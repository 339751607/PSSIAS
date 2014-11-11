<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String s_groupType = (String)request.getAttribute("s_groupType");
String strXML = (String)request.getAttribute("strXML");
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<script type="text/javascript" src="<%=request.getContextPath() %>/FusionCharts/FusionCharts.js"></script>
	<title><%=StaCl.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit();" >
<%@ include file="/commons/messages.jsp" %>

<div class="queryPanel">
    <s:form action="/pages/pmdd/StaCl/dclist.do" name="inputForm" theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">动产质押统计</td>
		           </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      部门
		                  </td>
			              <td>
			              
			                        <input  type="text"  size="20" value="${pageRequest.filters.rowname}"  name="s_rowname"  />
		                            <input  type="hidden"  value="${pageRequest.filters.deptseq}"  name="s_deptseq"  />
		                            <input name="selectDeptButton"  onclick="javascript:selectDept(inputForm,'s_rowname','s_deptseq')"   value="选择" type="button" > 
		                          
		                 
		                          
		                  </td>
		                   <td class="crosscolor_td">
			                     典当日期
		                  </td>
			              <td>
			              <table class="list">
			              	<tr>
			              		<td>
			              			<s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect(this,'s_starttimeBegin','s_starttimeEnd','yyyy-MM-dd');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			              		</td>
			              		<td>从</td>
			              		<td>
			              			<input id="d3132" name="s_starttimeBegin"  value="${pageRequest.filters.starttimeBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'d3142\')}'})"/>
			              		</td>
			              		<td>到</td>
			              		<td>
			              			<input id="d3142" name="s_starttimeEnd"   value="${pageRequest.filters.starttimeEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
			              		</td>
			              	</tr>
			              </table>
		                  </td>
                   </tr>
		         <tr class="crosscolor_tr">
						
						 <td class="crosscolor_td">
							显示方式
						</td>
						<td  colspan="3">
							<table style="border: none;">
								<tr style="border: none;">
									<td style="border: none;">
										<input name="s_groupType" type="radio" value="0" <%if(s_groupType != null && s_groupType.equals("0")){%> checked <%}%> >
										数据
									</td>
									<td style="border: none;">
										<input type="radio" name="s_groupType" value="1" <%if(s_groupType != null && s_groupType.equals("1")){%> checked <%}%>>
										饼图
									</td>
									<td style="border: none;">
										<input type="radio" name="s_groupType" value="2" <%if(s_groupType != null && s_groupType.equals("2")){%> checked <%}%>>
										柱图
									</td>
								</tr>
							</table>
						</td>
					</tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/pmdd/StaCl/dclist.do'"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<c:if test="${requestScope.s_groupType == '1'}">
   <div class="gen-chart-render">
		<div id='basicChartDiv' align='center'>
			没有数据!
		</div>
	<script type='text/javascript'>
		<%=strXML%>
    </script>
    </div>
</c:if> 
<c:if test="${requestScope.s_groupType == '2'}">
   <div class="gen-chart-render">
		
		<div id='basicChartDiv' align='center'>
			没有数据!
		</div>
	<script type='text/javascript'>
		    <%=strXML%>
    </script>
    </div>
</c:if> 
<c:if test="${requestScope.s_groupType == '0'}">
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/pmdd/StaCl/dclist.do" autoIncludeParameters="true">
	<ec:row>
		
		                    <ec:column property="rowname"  title="部门名"/>
		                    <ec:column property="twoZl"  title="赎回数"/>
		                     <ec:column property="sumZl"  title="总数"/>
		                     
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<c:if test="${item.isLeaf == 'N'}">
			<a href="${ctx}/pages/pmdd/StaCl/dclist.do?s_deptseq=${item.deptseq}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			</c:if> 
			<c:if test="${item.isLeaf == 'Y'}">
			&nbsp;&nbsp;&nbsp;
			</c:if> 
		</ec:column>
		
	</ec:row>
</ec:table>
</c:if>
</body>

</html>


<script>
 function selectDept(frm,displayName,hiddenName) {
	           window.showModalDialog('${ctx}/pages/SsDept/selectDept.do?idValueIsSeq=true&formName=' + frm.name + '&inputName='+displayName+'&hiddenName='+hiddenName+'&rootID=false&maxPatiNum=1&hiddenType=ID_SPLIT',frm,'dialogHeight:500px;dialogWidth:560px;center:yes');
       }
</script>