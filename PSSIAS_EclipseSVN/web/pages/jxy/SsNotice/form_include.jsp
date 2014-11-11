<%@page import="com.dyneinfo.jxy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="noticeid" name="noticeid" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT> <%=SsNotice.ALIAS_NOTICETITLE%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NOTICETITLE}" size="70"  key="noticetitle" value="%{model.noticetitle}"  cssClass="required max-length-256" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_NOTICECONTENT%>
		                  </td>
			               <td colspan="3">
		                           <s:textarea label="%{@vs@ALIAS_NOTICECONTENT}" rows="6" cols="55"
							key="noticecontent" value="%{model.noticecontent}" cssClass="max-length-3000"
							required="false"></s:textarea>
		                         
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_STARTTIME%>
		                  </td>
			              <td>
		                           <input value="${model.starttimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_STARTTIME%>'})" id="starttimeString" name="starttimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                     <FONT color="red">*</FONT>  <%=SsNotice.ALIAS_ENDTIME%>
		                  </td>
			              <td>
		                           <input value="${model.endtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_ENDTIME%>'})" id="endtimeString" name="endtimeString"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_PARTICIPANTS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_PARTICIPANTS}" size="80" key="participants" value="%{model.participants}"  cssClass="max-length-2000" required="false" />
		                  </td>
                         
                   </tr>
                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISSUESCOPE%>
		                  </td>
			             <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ISSUESCOPE}" size="80" key="issuescope" value="%{model.issuescope}"  cssClass="max-length-2000" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_AUTHORID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_AUTHORID}" key="authorid" value="%{model.authorid}"  cssClass=" " required="false" />
		                  </td>
                           <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SENDUNITID%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SENDUNITID}" key="sendunitid" value="%{model.sendunitid}"  cssClass=" " required="false" />
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
                         
		                  <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_STATE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.state}"   styleClass="required validate-selection"  name="state"   notEmpty="false"  dictName="NOTICE_STATE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_CREATETIME%>
		                  </td>
			              <td>
		                           <input value="${model.createtimeString}" onclick="WdatePicker({dateFmt:'<%=SsNotice.FORMAT_CREATETIME%>'})" id="createtimeString" name="createtimeString"  maxlength="0" class="Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_ISREPLY%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.isreply}"   styleClass="required validate-selection"  name="isreply"   notEmpty="false"  dictName="NOTICE_ISREPLY"/>
		                  </td>
                        
                         
                          <td class="crosscolor_td">
			                      <%=SsNotice.ALIAS_SORTNO%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SORTNO}" key="sortno" value="%{model.sortno}"  cssClass="validate-number " required="false" />
		                  </td>
                   </tr>
 
 
