<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx}/dwr/util.js'></script>

	<s:hidden id="id" name="id" />
				 <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                    所属分局名称
		                  </td>
			              <td>
			              <s:select name="burcode" id="country"   cssStyle="width:155px" onchange="queryProvince();"	list="provMap" listKey="key" 	listValue="value" theme="simple" label="加油站" emptyOption="false"></s:select>
		                  </td>
                          <td class="crosscolor_td">
			                      所属派出所名称
		                  </td>
			              <td id="pcstd">
							<select id="province" name="stacode" onchange="queryCity();"  style="width:155px" ></select>
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      加油站名称
		                  </td>
			              <td colspan="3">
			              <select id="city" name="prov" id="prov"  onchange="changeprov();"  style="width:155px">
							<option value="">
								请选择...
							</option>
						</select>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_FSDW%>
		                  </td>
			              <td colspan="3">
		                           <input style="width:600px ;" readonly="true"  value="${pageRequest.filters.nativeplace}"  id = "s_nativeplace" name="s_nativeplace"  />
		                           <input type = "hidden" style="width:600px ;" value="${pageRequest.filters.fsdw}"  id="fsdw" name="fsdw"  />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                       <FONT color="red">*</FONT> <%=Ttz.ALIAS_BT%>
		                  </td>
			              <td colspan="3">
			              	  <s:textfield  style="width:600px ;" label="%{@vs@ALIAS_BT}" key="bt" value="%{model.bt}"  cssClass="required max-length-100" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
		           		 <td class="crosscolor_td">
			                       <FONT color="red">*</FONT> <%=Ttz.ALIAS_NR%>
		                  </td>
			              <td colspan="3">
			              		<s:textarea label="nr" name="nr" cols="73" rows="8"  cssClass="required max-length-2000" required="false"/>
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
					 <td class="crosscolor_td">
				                     附件
			                  </td>
						<TD colspan="3">
								<input type='file' size='55' name='affix'  onchange="changesize(this)"  title="单个文件不能大于5M！"
												style='BORDER-TOP: 1px solid #484848; width:600px;BORDER-LEFT: 1px solid #484848; BORDER-RIGHT: 1px solid #484848; BORDER-BOTTOM: 1px solid #484848;'
												style='400'>
						</TD>

					</tr>
					
					 <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
			                    <FONT color="red">*</FONT>   <%=Ttz.ALIAS_HZFLAG%>
		                  </td>
			              <td>
						           <mytag:select property="%{model.hzflag}"   styleClass="required validate-selection select"  name="hzflag"   notEmpty="false"  dictName="shiFou"/>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=Ttz.ALIAS_RQ%>
		                  </td>
			              <td >
		                           <input value="${model.rq}"  id="rq" name="rq"  maxlength="0" readonly="true" />
		                           <input type="hidden" id="filexx" value="0" />
		                  </td>

                   </tr>
                   
				
		           <tr class="crosscolor_tr">
                            <td class="crosscolor_td">
			                      <FONT color="red">*</FONT>  <%=Ttz.ALIAS_FSR%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield  style="width:600px ;" label="%{@vs@ALIAS_FSR}" key="fsr" value="%{model.fsr}"  cssClass="required max-length-100" required="false" />
		                  </td>
                   </tr>
                   
  <script>
   
   	function changesize(filePicker) {
         var filespec =filePicker.value;
         var fso, f, s = new Array();
         var maxsize= 5*1024*1024;
         try {
             fso = new ActiveXObject("Scripting.FileSystemObject");
             f = fso.GetFile(filespec); // filespec 是指定文件的路径（绝对和或相对的），必选项。
         }
         catch (err) {
             alert('浏览器安全设置出错！');
             return;
         }
         if(f.Size >maxsize){
           alert("选择的文件太大，请重新选择！");
           document.getElementById("filexx").value="1"
         }else{
           document.getElementById("filexx").value="0"
         }
   }
                   
  function changeprov()
	{
		var provinceId = $("prov").value;
		var provincename = $("prov").options[$("prov").options.selectedIndex].text;
		var nativeplace = $("s_nativeplace").value;
		var xzqh = $("fsdw").value;
		if(nativeplace==""){
			$("s_nativeplace").value = provincename;
			$("fsdw").value = provinceId;
		}else{
			$("s_nativeplace").value = nativeplace+","+provincename;
			$("fsdw").value = xzqh+","+provinceId;
		}
	}
	</script>
