<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<script type="text/javascript" src="jscharts.js"></script>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=SsDatasource.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>

<div id="graph2">Loading...</div>
<script type="text/javascript">
	
	var myData = new Array(['Asia', 437, 520], ['Europe', 322, 390], ['North America', 233, 286], ['Latin America', 110, 162], ['Africa', 34, 49], ['Middle East', 20, 31], ['Aus/Oceania', 19, 22]);
	var myChart = new JSChart('graph2', 'bar');
	myChart.setDataArray(myData);
	myChart.setTitle('Internet usage by World Region (millions of users)');
	myChart.setTitleColor('#8E8E8E');
	myChart.setAxisNameX('');
	myChart.setAxisNameY('');
	myChart.setAxisNameFontSize(16);
	myChart.setAxisNameColor('#999');
	myChart.setAxisValuesAngle(30);
	myChart.setAxisValuesColor('#777');
	myChart.setAxisColor('#B5B5B5');
	//myChart.setAxisWidth(1);
	myChart.setBarValuesColor('#2F6D99');
	myChart.setAxisPaddingTop(60);
	myChart.setAxisPaddingBottom(60);
	myChart.setAxisPaddingLeft(45);
	myChart.setTitleFontSize(11);
	myChart.setBarColor('#2D6B96', 1);
	myChart.setBarColor('#9CCEF0', 2);
//	myChart.setBarBorderWidth(2);
	myChart.setBarSpacingRatio(50);
	//myChart.setBarOpacity(0.9);
	//myChart.setFlagRadius(6);
	myChart.setTooltip(['North America', 'Click me', 1], callback);
	myChart.setTooltipPosition('nw');
	myChart.setTooltipOffset(3);
	myChart.setLegendShow(true);
	myChart.setLegendPosition('right top');
	myChart.setLegendForBar(1, '2005');
	myChart.setLegendForBar(2, '2010');
	myChart.setSize(616, 321);
	//myChart.setGridColor('#C6C6C6');
	myChart.draw();
	
	function callback() {
		alert('User click');
	}
	
</script>
<div class="queryPanel">
    <s:form action="/pages/zazh/SsDatasource/list.do"  theme="simple" style="display: inline;" method="post">
	    <table width="100%" border="1" bordercolor="#7c8ca7" align="center"  cellPadding="0" cellSpacing="0" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">行业数据源查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CODE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.code}"  name="s_code"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_CALLED%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.called}"  name="s_called"  />
		                  </td>
                   </tr>
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsDriverclassname}"  name="s_dbsDriverclassname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_URL%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsUrl}"  name="s_dbsUrl"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_USERNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsUsername}"  name="s_dbsUsername"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_PASSWORD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsPassword}"  name="s_dbsPassword"  />
		                  </td>
                   </tr>
                   -->
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_DBS_NAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.dbsName}"  name="s_dbsName"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_ISVALID%>
		                  </td>
			              <td>
		                           <mytag:select  name="s_isvalid"  value="${pageRequest.filters.isvalid}"  notEmpty="false"  dictName="T_DICT_VALID"/>
		                  </td>
                   </tr>
                   <!-- 
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND1%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.extend1}"  name="s_extend1"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDatasource.ALIAS_EXTEND2%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.extend2}"  name="s_extend2"  />
		                  </td>
                   </tr>
                    -->
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/SsDatasource/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/zazh/SsDatasource/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
	                               <input type="button"  value="删除" onclick="doDel();"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>



<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/zazh/SsDatasource/list.do" autoIncludeParameters="true">
	<ec:row>
		<ec:column property="选择" title="<input type='checkbox' onclick=\"setAllCheckboxState('items',this.checked)\" >" sortable="false" width="3%" viewsAllowed="html">
			<input type="checkbox" name="items" value="id=${item.id}&"/>
		</ec:column>
		                    <ec:column property="code"  title="<%=SsDatasource.ALIAS_CODE%>"/>
		                    <ec:column property="called"  title="<%=SsDatasource.ALIAS_CALLED%>"/>
		                    <ec:column property="dbsDriverclassname"  title="<%=SsDatasource.ALIAS_DBS_DRIVERCLASSNAME%>"/>
		                    <ec:column property="dbsUrl"  title="<%=SsDatasource.ALIAS_DBS_URL%>"/>
		                    <ec:column property="dbsUsername"  title="<%=SsDatasource.ALIAS_DBS_USERNAME%>"/>
		                    <ec:column property="dbsPassword"  title="<%=SsDatasource.ALIAS_DBS_PASSWORD%>"/>
		                    <ec:column property="dbsName"  title="<%=SsDatasource.ALIAS_DBS_NAME%>"/>		                 
		                    <mytag:lookupcolumn property="isvalid"  title="<%=SsDatasource.ALIAS_ISVALID%>"	cell="net.java.dev.ec.table.view.LookUpCell" dictType="T_DICT_VALID" />
		                   	                    
		<ec:column property="操作" title="操作" sortable="false" viewsAllowed="html">
			<a href="${ctx}/pages/zazh/SsDatasource/show.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/pages/zazh/SsDatasource/edit.do?id=${item.id}&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">修改</a>
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
				input_txt.value = "!/pages/zazh/SsDatasource/list.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>";
				form.appendChild(input_txt);
		        form.action = '${ctx}/pages/zazh/SsDatasource/delete.do';
	            form.submit();
	        }
	  }
</script>