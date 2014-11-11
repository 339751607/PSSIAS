<%@page import="com.dyneinfo.gas.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->

		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBR%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield  style="width:600px ;" label="%{@vs@ALIAS_FBR}" key="fbr" value="%{model.fbr}"  cssClass=" required max-length-50" required="false" />
		                 	<FONT color="red">*</FONT>
		                  </td>
                          
                   </tr>
		           <tr class="crosscolor_tr">
		           		<td class="crosscolor_td">
			                      <%=Txctb.ALIAS_CZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield style="width:600px ;" label="%{@vs@ALIAS_CZ}" key="cz" value="%{model.cz}"  cssClass="max-length-100" required="false" />
		                  </td>
		            </tr>
		           <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_BT%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield style="width:600px ;"  label="%{@vs@ALIAS_BT}" key="bt" value="%{model.bt}"  cssClass=" required max-length-100" required="false" />
		                 	<FONT color="red">*</FONT>
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_NR%>
		                  </td>
			              <td  colspan="3">
			             	 <s:textarea label="nr" name="nr" cols="73" rows="8"  cssClass="required max-length-2000" required="false"/>
		                  <FONT color="red">*</FONT>
		                  </td>
                   </tr>
					
                  <tr class="crosscolor_tr">
                    <td class="crosscolor_td">
			                     照片
		                  </td>
					<TD colspan="3">
					<input type='file' size='55' name='upload' id="zp1" onchange="changesize(this)" title="单个文件小于5M，所有文件累加大小小于20M" class=" validate-file-png-jpg-jpeg-gif-bmp"
											style='BORDER-TOP: 1px solid #484848;  width:588px;BORDER-LEFT: 1px solid #484848; BORDER-RIGHT: 1px solid #484848; BORDER-BOTTOM: 1px solid #484848;'
											style='400'> 
					<input type="button" onclick="addpic()" value="增加">
					</TD>
					
				</tr>
				<tr>
				<td colspan="4">
				<div id="PicTable"></div>
				</td>
				</tr>
				<tr class="crosscolor_tr">
				 <td class="crosscolor_td">
			                     附件
		                  </td>
					<TD colspan="3">
					<img src="#" id="fileChecker"  style="display:none" alt="test" height="18"/> 
							<input type='file' size='55' id="affix" name='affix'  onchange="changesize(this)" 
											style='BORDER-TOP: 1px solid #484848; width:588px;BORDER-LEFT: 1px solid #484848; BORDER-RIGHT: 1px solid #484848; BORDER-BOTTOM: 1px solid #484848;'
											style='400'>
					</TD>

				</tr>
		           <tr class="crosscolor_tr">
						  <td class="crosscolor_td">
			                      <%=Txctb.ALIAS_FBSJ%>
		                  </td>
			              <td colspan="3">
			              <input type="hidden" id="zpl1"  value="0"/> 
			              <input type="hidden" id="zpl2"  value="0"/> 
			              <input type="hidden" id="zpl3" value="0"/> 
			              <input type="hidden" id="fj"  value="0"/> 
		                           <s:textfield label="%{@vs@ALIAS_FBSJ}" key="fbsj" value="%{model.fbsj}" readOnly ="true" cssClass="max-length-18" required="false" />
		                  </td>
		             </tr> 	
 <script type="text/javascript">
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
           if(filePicker.id =="zp1"){
            document.getElementById("zpl1").value="1"
           }else if(filePicker.id =="zp2"){
            document.getElementById("zpl2").value="1"
           }else if(filePicker.id =="zp3"){
            document.getElementById("zpl3").value="1"
           }else{
            document.getElementById("fj").value="1"
           }
         }else{
           if(filePicker.id =="zp1"){
            document.getElementById("zpl1").value="0"
           }else if(filePicker.id =="zp2"){
            document.getElementById("zpl2").value="0"
           }else if(filePicker.id =="zp3"){
            document.getElementById("zpl3").value="0"
           }else{
            document.getElementById("fj").value="0"
           }
         }
   }
	
    //添加附件
	var i=2;
	function addpic()
	{
	 if(i<4){
		  var pctb="<table border='0' id='pctb"+i+"' cellspacing='1' cellpadding='5' style='width:100%;margin:0px 0px 1px 0px;' align='center' bgcolor='#3A6EA5'><tr class='crosscolor_tr'  ><td width ='148px' class='crosscolor_td'>照片</td><td  ><input type='file' size='55' name='upload' id='zp"+i+"' onchange='changesize(this)' class='validate-file-png-jpg-jpeg-gif-bmp' style='width:500px;BORDER-TOP: 1px solid #484848 ;BORDER-LEFT:1px solid #484848 ;BORDER-RIGHT: 1px solid #484848 ;BORDER-BOTTOM: 1px solid #484848 ;' style='400'>&nbsp;&nbsp;<input type='button' value='删除图片' style=' BORDER-TOP: 1px solid #484848 ;BORDER-LEFT:1px solid #484848;BORDER-RIGHT:1px solid #484848 ;BORDER-BOTTOM:1px solid #484848;' onclick=delelteTB('pctb"+i+"','PicTable')></td></tr></table>";
		  PicTable.insertAdjacentHTML("BeforeEnd",pctb);
		  i++;
	 }else{
	   alert("上传文件个数最多三个");
	   return false;
	 }
	}
	
	//删除附件
	function delelteTB(tbid,Tableobj)
	{
	  var obj = document.getElementById(tbid);
	   if(Tableobj=="PicTable"){
	     PicTable.removeChild(obj);
	     i--;
	   }
	   if(Tableobj=="FileTable"){
	     FileTable.removeChild(obj);
	     k--;
	  }
	 
	} 
	
</script>
