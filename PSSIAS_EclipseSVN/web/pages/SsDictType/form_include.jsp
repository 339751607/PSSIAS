<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>





		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsDictType.ALIAS_DICTTYPEID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTTYPEID}" key="dicttypeid" value="%{model.dicttypeid}" cssClass="required max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT><%=SsDictType.ALIAS_DICTTYPENAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_DICTTYPENAME}" key="dicttypename" value="%{model.dicttypename}" cssClass="required max-length-255" required="false" />
		                  </td>
                        
                   </tr>
		         
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_DICTFLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.dictflag}"   styleClass="required validate-selection"  name="dictflag"   notEmpty="false"  dictName="dictflag"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsDictType.ALIAS_QUERYSQL%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_QUERYSQL}" key="querysql" value="%{model.querysql}" cssClass="max-length-255" required="false" />
		                  </td>
                   </tr>
 
 
