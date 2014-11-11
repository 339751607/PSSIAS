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
	<title><%=User.TABLE_ALIAS%>查询</title>
</head>

<body>
<%@ include file="/commons/messages.jsp" %>
<div class="queryPanel">
    <s:form action="/pages/fjy/User/list.do"  theme="simple" style="display: inline;" method="post">
	    <table cellpadding="0" cellspacing="0" border="1" class="tb_all">
	               <tr>
			              <td class="tb_title" colspan="4"><%=User.TABLE_ALIAS%>查询</td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_USERNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.username}"  name="s_username"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PASSWORD%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.password}"  name="s_password"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fullname}"  name="s_fullname"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_SEX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sex}"  name="s_sex"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.sfzh}"  name="s_sfzh"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_POLICEID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.policeid}"  name="s_policeid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.phone}"  name="s_phone"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_MOBILE%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.mobile}"  name="s_mobile"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.fax}"  name="s_fax"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.address}"  name="s_address"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ZIP%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.zip}"  name="s_zip"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_EMAILADDRESS%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.emailaddress}"  name="s_emailaddress"  />
		                  </td>
                   </tr>
		           <tr class="tr_tb">
                          <td class="td_tb">
			                      <%=User.ALIAS_CREATEDATE%>
		                  </td>
			              <td class="td_input">
		                           <s:select name="dateSelect12" list="dateSelectMap"  onchange="dateselect(this,'s_createdateBegin','s_createdateEnd','yyyy-MM-dd');"  value="#request.dateSelect12" listKey="key"   listValue="value" theme="simple" label=""  emptyOption="false" ></s:select>
			                          从<input id="d31312" name="s_createdateBegin"  value="${pageRequest.filters.createdateBegin}"   maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=User.FORMAT_CREATEDATE%>',maxDate:'#F{$dp.$D(\'d31412\')}'})"/> &nbsp;到&nbsp;
			                        <input id="d31412" name="s_createdateEnd"   value="${pageRequest.filters.createdateEnd}"  maxlength="0" size="12" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'<%=User.FORMAT_CREATEDATE%>',minDate:'#F{$dp.$D(\'d31312\')}'})"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_DEPTID%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.deptid}"  name="s_deptid"  />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ENABLED%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.enabled}"  name="s_enabled"  />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHOTO%>
		                  </td>
			              <td>
		                           <input value="${pageRequest.filters.photo}"  name="s_photo"  />
		                  </td>
                   </tr>
		           <tr>
			              <td class="tb_bottom" colspan="4">
			                       <input type="submit"  value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/User/list.do'"/>
	                               <input type="submit"  value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/fjy/User/create.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'"/>
			              </td>
		           </tr>
	    </table>
    </s:form>
</div>
			
</body>

</html>