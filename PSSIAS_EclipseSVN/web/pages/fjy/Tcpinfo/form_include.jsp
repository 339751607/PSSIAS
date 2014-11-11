<%@page import="com.dyneinfo.fjy.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="cpcode" name="cpcode" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPCODE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPCODE}" key="cpcode" value="%{model.cpcode}"  cssClass="required validate-number max-length-13" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CPNAME}" key="cpname"  value="%{model.cpname}"  cssClass="required max-length-100" required="false" />
		                  </td>
		                  
		           </tr>
		           <tr class="crosscolor_tr">        
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPADRESS%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_CPADRESS}" size="80" key="cpadress" value="%{model.cpadress}"  cssClass="required max-length-200" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_CPTEL%>
		                  </td>
			              <td>
		                             <s:textfield label="%{@vs@ALIAS_CPTEL}" key="cptel" value="%{model.cptel}"  cssClass="required max-length-100" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_AREA%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_AREA}" key="area" value="%{model.area}"  cssClass="max-length-3 validate-digits" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPKIND%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cpkind}"    name="cpkind"   notEmpty="false"  dictName="T_DIC_CPKIND"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRNAME%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_FRNAME}" key="frname" value="%{model.frname}"  cssClass="max-length-30 validate-chinese" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRSEX%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.frsex}"    name="frsex"   notEmpty="false"  dictName="T_DIC_SEX"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_FRIDCODE%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_FRIDCODE}" key="fridcode" value="%{model.fridcode}"  cssClass="max-length-18 validate-id-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPTYPE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cptype}"     name="cptype"   notEmpty="false"  dictName="T_DIC_CPTYPE"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CPSTATE%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.cpstate}"     name="cpstate"   notEmpty="false"  dictName="T_DIC_CPSTATE"/>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=Tcpinfo.ALIAS_SSPCS%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SSPCS}" key="sspcs" value="%{model.sspcs}"  cssClass="required  max-length-12" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_JYFW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JYFW}" key="jyfw" value="%{model.jyfw}"  cssClass="max-length-50" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAFZR}" key="zafzr" value="%{model.zafzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZAFZRDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAFZRDH}" key="zafzrdh" value="%{model.zafzrdh}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			               <FONT color="red">*</FONT>       <%=Tcpinfo.ALIAS_KYSJ%>
		                  </td>
			              <td>
						       <input value="${model.kysj}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="kysj" name="kysj"  maxlength="0" class="required Wdate" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_CYRS%>
		                  </td>
			              <td>
	                               <s:textfield label="%{@vs@ALIAS_CYRS}" key="cyrs" value="%{model.cyrs}"  cssClass="validate-integer max-value-2147483647 validate-number" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_GSZZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_GSZZH}" key="gszzh" value="%{model.gszzh}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Tcpinfo.ALIAS_ZCRQ%>
		                  </td>
			              <td>
						           <input value="${model.zcrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="zcrq" name="zcrq"  maxlength="0" class="required Wdate" />
		                  </td>
                   </tr>
 
 
