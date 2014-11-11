<%@page import="com.dyneinfo.pmdd.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="optime" name="optime" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_XZQHMC%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XZQHMC}" key="xzqhmc" value="%{model.xzqhmc}"  cssClass="required max-length-32" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_XZQHDM%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XZQHDM}" key="xzqhdm" value="%{model.xzqhdm}"  cssClass="validate-number required max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWMC%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                       <s:textfield label="%{@vs@ALIAS_DWMC}" key="dwmc" size="80" value="%{model.dwmc}"  cssClass="required max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_DWDZ%><FONT color="red">*</FONT>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_DWDZ}" key="dwdz" size="80" value="%{model.dwdz}"  cssClass="required max-length-120" required="false" />
		                  </td>

                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_LXDH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-16" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_CZ%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CZ}" key="cz" value="%{model.cz}"  cssClass="max-length-16" required="false" />
		                  </td>                         
                   </tr>
		           <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YZBM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YZBM}" key="yzbm" value="%{model.yzbm}"  cssClass="validate-number max-length-6" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_KYRQ%><FONT color="red">*</FONT>
		                  </td>
			              <td>
		                  		<input value="${model.kyrq}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="kyrq" name="kyrq"  maxlength="0" class="required required Wdate" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FRXM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FRXM}" key="frxm" value="%{model.frxm}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZGBM%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZGBM}" key="zgbm" value="%{model.zgbm}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_FZR}" key="fzr" value="%{model.fzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZAFZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZAFZR}" key="zafzr" value="%{model.zafzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_BABDH%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_BABDH}" key="babdh" value="%{model.babdh}"  cssClass="max-length-16" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">    
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_JYFW%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_JYFW}" key="jyfw" size="80" value="%{model.jyfw}"  cssClass="max-length-160" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZCZB%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZCZB}" key="zczb" value="%{model.zczb}"  cssClass="max-length-8" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_ZDMJ%>（平方米）
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_ZDMJ}" key="zdmj" value="%{model.zdmj}"  cssClass="validate-number max-length-8" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_TXXKZH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TXXKZH}" key="txxkzh" value="%{model.txxkzh}"  cssClass="validate-number max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_TXXKZFZDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TXXKZFZDW}" key="txxkzfzdw" value="%{model.txxkzfzdw}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YYZZBH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YYZZBH}" key="yyzzbh" value="%{model.yyzzbh}"  cssClass="max-length-20" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_YYZZFZDW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_YYZZFZDW}" key="yyzzfzdw" value="%{model.yyzzfzdw}"  cssClass="max-length-60" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_FJDM%><FONT color="red">*</FONT>
		                  </td>
			              <td>
			             		 <mytag:select property="%{model.fjdm}"   onchange="getPcs()"  styleClass="required validate-selection"  name="fjdm"   notEmpty="false"  dictName="ssfj"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Pmdwxxb.ALIAS_PCSDM%>
		                  </td>
		                 
		                  <td id="pcstd">
							<select style="width: 150px;"  name="pcsdm" id="pcsdm" class=" max-length-12">
								<option value="">请选择...</option>
							</select>
		                  </td>
                   </tr>
<script language="javascript">
getPcs();
function getPcs(){
	var fjbm=document.getElementById("fjdm").value;
	var pcsbm='${model.pcsdm}';
	var url="${ctx}/pages/pmdd/Dictitem/deptList.do?s_sfsh=0&s_fjbm="+fjbm+"&ajax=true&pcsbm="+pcsbm;
	$.post(url, function(data) {
		$("#pcstd").html("<select  name='pcsdm'  id='pcsdm' class=' validate-selection max-length-12'><option value=''>请选择...</option></select>");
		$("#pcsdm").append(data);
	});
}
</script>