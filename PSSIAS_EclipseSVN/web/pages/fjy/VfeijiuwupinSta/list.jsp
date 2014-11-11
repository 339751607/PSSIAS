<%@page import="com.dyneinfo.fjy.model.*" %>
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
	<title><%=VfeijiuwupinSta.TABLE_ALIAS%> 维护</title>
</head>

<body onload="quickSelectInit()" >
<%@ include file="/commons/messages.jsp" %>
<%@ include file="/commons/selectDept.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/VfeijiuwupinSta/list.do"   name="inputForm"  theme="simple" style="display: inline;" method="post">
           <input type="hidden" name="tx" value=""/>
            <input type="hidden" name="pagenamber" value=""/>
           
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=VfeijiuwupinSta.TABLE_ALIAS%></td>
		           </tr>
		            <tr class="crosscolor_tr">
	 					 <td class="crosscolor_td">
                          	所属公安机关
                          	</td>
                          	<td>
							<select id="fjid" onchange="getPcs('fjid','pcsid');">
								<option>请选择...</option>
							</select>
							<select id="pcsid"  >
								<option>请选择...</option>
							</select>
							
							<input type="hidden" name="s_deptseq" id="s_deptseq" value="${deptseq}" size="60"/>
							</td>
                   </tr>
                    <tr class="tr_tb">
                         <td class="td_tb">
                          		出售日期  
                          	</td>
			               <td colspan="2" class="td_input"> 	
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('list_dateSelect2','d3132','d3142','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                         <input id="d3132" name="s_shougourqBegin"  value="${pageRequest.filters.shougourqBegin}"   maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_shougourqEnd"   value="${pageRequest.filters.shougourqEnd}"  maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3132\')}'})"/>
		                  </td>
                          
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="button"  value="图表" onclick="query();"/>
			                        <input type='button' value='柱状图' onClick="queryTx('btnColumn');" name='btnColumn' />
			                        <input type='button' value='折线图' onClick="queryTx('btnLine');" name='btnLine' />
			                        <input type='button' value='饼状图' onClick="queryTx('btnPie');" name='btnPie' />
			                       <input type="button" value="清空" onclick="resitData(document.forms[0]);"/>
	                              
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
<div id="listis">
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/VfeijiuwupinSta/list.do" autoIncludeParameters="true">
	<ec:row>
          <ec:column property="deptname"  title="名称"/>
          <ec:column property="onezl"  title="废钢铁"/>
          <ec:column property="twozl"  title="废合金钢"/>
          <ec:column property="threezl"  title="废有色金属"/>
          <ec:column property="fourzl"  title="废稀贵金属"/>
          <ec:column property="sumzl"  title="重量合计(公斤)"/>
          <ec:column property="ywl"  title="业务量合计">
<c:choose>
   <c:when test="${item.ywl != '0'}">
   	<a href="#" onclick="queryList('${item.deptseq}');return false;"><font color="red">${item.ywl}</font></a>
   </c:when>
   <c:otherwise>
   ${item.ywl}
   </c:otherwise>
</c:choose>

        	
          </ec:column>
	</ec:row>
</ec:table>
</div>
</body>

</html>


<script>

function query(){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/VfeijiuwupinSta/list.do'
	document.forms[0].submit();
	
}
function queryTx(tx){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].tx.value=tx;
	document.forms[0].pagenamber.value=document.forms.ec.ec_p.value;
	document.forms[0].action='${ctx}/pages/fjy/VfeijiuwupinSta/list.do'
	document.forms[0].submit();
	
}

function queryList(deptseq){
	var url="${ctx}/pages/fjy/Tfeijiuwupin/queryList.do?s_deptSeq="+deptseq+"&fh=tj"
	document.forms[0].action=url;
	document.forms[0].submit();
}
setValueSelect('fjid','pcsid','','s_deptseq')
function getXML(xmlData){
	submitThisValue('fjid','pcsid','','s_deptseq')
	document.forms[0].action='${ctx}/pages/fjy/VfeijiuwupinSta/listBB.do'
	document.forms[0].submit();
}
</script>