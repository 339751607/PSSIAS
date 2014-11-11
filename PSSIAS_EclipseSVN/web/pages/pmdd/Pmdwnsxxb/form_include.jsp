<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<!-- ONGL access static field: @package.class@field or @vs@field -->
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!-- 单位编码 -->
			                      <%=Pmdwnsxxb.ALIAS_DWMC%><FONT color="red">*</FONT>
		                  </td>
			              <td>
							<s:select name="dwbm" list="dwMap" headerKey="dwbm" headerValue="--请选择--" cssClass="required"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!-- 年审年度 -->
			                      <%=Pmdwnsxxb.ALIAS_NSND%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                        <s:textfield label="%{@vs@ALIAS_NSND}" key="nsnd" value="%{model.nsnd}"  cssClass="required diy-date-1900-2099" required="true" />格式: 2007
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!-- 年审日期 -->
			                      <%=Pmdwnsxxb.ALIAS_NSRQ%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			             		 <input value="${model.nsrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="nsrq" name="nsrq"  maxlength="0" class="required required Wdate" />
		                  </td>
                          <td class="crosscolor_td"><!--  年审结果 -->
			                      <%=Pmdwnsxxb.ALIAS_NSJG%><FONT color="red">*</FONT>
		                  </td>
			              <td >
			           		<s:radio   list="#{'1':'通过','0':'不通过'}"  name="nsjg" label="年审结果"  key="nsjg" value="1"  required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!--  年审意见 -->
			                      <%=Pmdwnsxxb.ALIAS_NSYJ%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
			                <s:textarea label="%{@vs@ALIAS_NSYJ}" rows="8" cols="80"
							key="nsyj" value="%{model.nsyj}" cssClass="required max-length-2048"
							required="false"></s:textarea>
		                  </td>
		                  </tr>
		                   <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!-- 年审意见签署人 -->
			                      <%=Pmdwnsxxb.ALIAS_NSYJQSR%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NSYJQSR}" key="nsyjqsr" value="%{model.nsyjqsr}"  cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"><!-- 年审意见经办人 -->
			                      <%=Pmdwnsxxb.ALIAS_NSYJJBR%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_NSYJJBR}" key="nsyjjbr" value="%{model.nsyjjbr}"  cssClass="required max-length-30" required="false" />
		                  </td>
                   </tr>
 
 
