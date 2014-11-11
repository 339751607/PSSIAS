<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String IDCardType = (String) DictHelpImpl.getInitData("IDCardType");
%>
<html>
<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<script src="authentication.js"  type="text/javascript" language="javascript"></script>

<head>
	<%@ include file="/commons/meta.jsp" %>
	<base href="<%=basePath%>">
	<link href="${ctx}/widgets/extremecomponents/extremecomponents.css" type="text/css" rel=stylesheet>
	<title><%=TfjycpCheck.TABLE_ALIAS%> 维护</title>
</head>
<style>
#overlay{
   background: #303030;
   opacity: 0.50;
   filter:Alpha(opacity=50);
   display: none;
   position: absolute;
   top: 0px;
   left: 0px;
   width: 100%;
   height: 100%;
   z-index: 100;
}
#tishi{
 margin-left:auto;
 margin-right:auto;
 border:1px solid #FFFFFF;
 font-size:12px;
 font-family: "宋体";
 color:#990000;

 width:270px;
 height:120px;
 position:absolute;
 z-index:110;
 display:none;
 background:#8E8986;
 left:35%;
 top:20%;
 opacity:0.85;
 filter:Alpha(opacity=100);
}

.b1,.b2,.div_title,.div_content{display:block;overflow:hidden;background:#309DE9;}
.b1,.b2{height:1px;}
.b2{margin:0 0px;}
.div_title{color:#fff;font-weight:bold;padding:2px; font-size:14px;height:23px;text-align:right; }
.div_content{padding-left:2px;padding-right:2px;}
.content{background:#fff;}

</style>

<body onload="quickSelectInit()">
<%@ include file="/commons/messages.jsp" %>
<div id="tishi">
<div style="width:270px">
<b class="b1"></b><b class="b2"></b>
<div class="div_title"><a href="javascript:;" id="cancel" title="关闭"><font color="#FFFFFF">关闭</font></a>&nbsp;</div>
<div class="div_content"><div class="content">
	<c:if test="${cs == null}">
	 <%
       if (IDCardType != null && IDCardType.equals("1")) {
	  %>	
		<IFRAME id="hsdk" height="100" width="260" name="result"   src="${ctx}/pages/fjy/TfjycpCheck/CVR_IDCard.html"
		align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
	  <%
	  	} else if (IDCardType != null && IDCardType.equals("2")) {
	  %>	
		<IFRAME id="hsdk" height="100" width="260" name="result"   src="${ctx}/pages/fjy/TfjycpCheck/WENT_IDCard.html"
		align="center" frameBorder="0" marginHeight="0" marginWidth="0"></IFRAME>
	  <%
	  	}
	  %>
	</c:if>
	<input type="hidden" name="idcard" id="idcard"><input type="hidden" name="jqueryUrl" value="${ctx}/pages/fjy/TfjycpCheck/">
</div></div>
<b class="b2"></b><b class="b1"></b>
</div>
</div>
<div id="overlay"><IFRAME width="1300px" height="1170px" style="position:absolute; top:0px; z-index:-1; border-style:none; border-width:0px; border:0px">
            </IFRAME></div>

<div class="queryPanel">
    <s:form action="/pages/fjy/TfjycpCheck/listUser.do"  theme="simple" style="display: inline;" method="post">
    <input type="hidden" name="t_checktype" value="2"/>
     <input type="hidden" name="t_emptype" value="02"/>
    <input type="hidden" id="loginway" value="0"/>
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4">企业维护信息查询</td>
		           </tr>
		            <tr class="crosscolor_tr">
		              <td class="crosscolor_td">
			                     维护人员
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.fullname}"  name="s_fullname"  />
		                  </td>
       		               <td class="crosscolor_td">
			                   维护内容
		                  </td>
			              <td >
		                           <input value="${pageRequest.filters.content}"   name="s_content"  />
		                  </td>
		                </tr>


		           <tr class="tr_tb">

		                  <td class="td_tb">
			                     维护日期
		                  </td>
		                  <td colspan="3" class="td_input">
				                   <s:select name="dateSelect2" list="dateSelectMap"  onchange="dateselect('dateSelect2','d3132','d3142','yyyy-MM-dd HH:mm');"  value="#request.dateSelect2" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d3132" name="s_checkdateBegin"  value="${pageRequest.filters.checkdateBegin}"   maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d3142\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d3142" name="s_checkdateEnd"   value="${pageRequest.filters.checkdateEnd}"  maxlength="0" size="18" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d3142\')}'})"/>
		                  </td>
                   </tr>

		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询"/>	
									<c:if test="${cs == null}">
			                       <input id="zg" type="button" value="新增" />
			                       </c:if>
			                       <c:if test="${cs!=null}">
			                       <input type="hidden" name="cs" value="${cs}">
			                       </c:if>
			                       <input type="button" value="清空" onclick="resitData(document.forms[0]);"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>


<!-- rowsDisplayed="20" -->
<ec:table items='page.result' var="item" method="get"
	retrieveRowsCallback="limit" 
	sortRowsCallback="limit" filterRowsCallback="limit"
	action="${ctx}/pages/fjy/TfjycpCheck/listUser.do" autoIncludeParameters="true">
	<ec:row>
		                      <ec:column property="deptname"  title="维护企业名称"/>
		                      <ec:column property="empname"  title="确认人"/>
		                      <ec:column property="fullname"  title="维护人员姓名"/>
		                      <ec:column property="checkdate"  parse="yyyyMMdd" format="yyyy-MM-dd" cell="date"  title="维护日期"/>
		<ec:column property="操作" title="操作" sortable="false" width="10%" viewsAllowed="html">
			<a href="${ctx}/pages/fjy/TfjycpCheck/userShow.do?id=${item.id}&t_checktype=2&<mytag:params includes="ec*,s*" type="queryStringUtf"/>">查看</a>&nbsp;&nbsp;&nbsp;
		</ec:column>
	</ec:row>
</ec:table>

</body>
<script>

</script>
</html>


