<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="userid" name="userid" />

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_USERNAME%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_USERNAME}" key="username" value="%{model.username}"  cssClass="required max-length-50" required="false" />
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                  <FONT color="red">*</FONT>  注册密码
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password" value="%{model.password}"  cssClass="required max-length-50" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  再次输入密码
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password2" value="%{model.password2}"  cssClass="required max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                   <FONT color="red">*</FONT>   <%=User.ALIAS_FULLNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FULLNAME}" key="fullname" value="%{model.fullname}"  cssClass="required max-length-128" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SEX%>
		                  </td>
			              <td>
		                         
		                            <mytag:select property="%{model.sex}"
							styleClass="required validate-selection" name="sex"
							notEmpty="false" dictName="T_DIC_SEX" />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_SFZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}"  cssClass="required max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=User.ALIAS_ENABLED%>
		                  </td>
			              <td>
		                           <mytag:select property="%{model.enabled}"
							styleClass="required validate-selection" name="enabled"
							notEmpty="false" dictName="status" />
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_PHONE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_PHONE}" key="phone" value="%{model.phone}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_MOBILE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_MOBILE}" key="mobile" value="%{model.mobile}"  cssClass="max-length-32" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_FAX%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FAX}" key="fax" value="%{model.fax}"  cssClass="max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ZIP%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZIP}" key="zip" value="%{model.zip}"  cssClass="max-length-32" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          
                          <td class="crosscolor_td">
			                      <%=User.ALIAS_ADDRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ADDRESS}" size="75" key="address" value="%{model.address}"  cssClass="max-length-64" required="false" />
		                  </td>
                   </tr>
					<tr class="crosscolor_tr">
						<td>
							<FONT color="red">*</FONT>角色
						</td>
						<td colspan="3">
							<s:checkboxlist value="selectList" listKey="roleid"
								listValue="roledesc" list="rolemap" name="roles" />
						</td>
					</tr>






