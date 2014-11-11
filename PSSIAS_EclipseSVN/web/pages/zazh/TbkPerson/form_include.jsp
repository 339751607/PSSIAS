<%@page import="com.dyneinfo.zazh.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String picCount = "";
 if(request.getAttribute("picCount") != null)
       picCount= (String)request.getAttribute("picCount");

%>
	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
						
				   <tr class="tb_title">
                          <td class="crosscolor_td"  colspan="5">
			                 <div align="left"> 
			                   <b>人员信息<b>
			                 </div> 
		                  </td>                
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td"  width="20%">
			                      <%=TbkPerson.ALIAS_XM%>
		                  </td>
			              <td  width="25%">
		                           <s:textfield label="%{@vs@ALIAS_XM}" key="xm" value="%{model.xm}"  cssClass="required max-length-30" />
		                          <FONT color="red">*</FONT>
		                  </td>
		                  <td class="crosscolor_td"  width="20%">
			                      <%=TbkPerson.ALIAS_SFZH%>
		                  </td>
			              <td  width="25%">
		                           <s:textfield label="%{@vs@ALIAS_SFZH}" key="sfzh" value="%{model.sfzh}"  cssClass="required validate-id-number max-length-18" 
		                            onblur="javascript: showBirthday();" size="25"  />
		                            <FONT color="red">*</FONT>
		                  </td>
		                  <td rowspan="7" width="10%">
		                          <%if(picCount != null && picCount.equals("1")) { %>
						             <img src='${ctx}/pages/zazh/TbkPerson/showPic.do?bkid=<s:property value="%{model.id}" />' height="150" alt="照片" width="120" border="0" name="photo"> 	
						           <% } else {%>
						           <IMG src="${ctx}/images/spacer.gif" height="150" alt="照片" width="120" border="0" name="photo">
						           <%} %>
		                           <s:file name="file" style="WIDTH:130px;cursor:hand"  UNSELECTABLE="on"  id="file"
							cssClass="validate-file-png-jpg-gif-bmp" label="图片"></s:file>
		                      
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HM1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM1}" key="hm1" value="%{model.hm1}"  cssClass="max-length-30" required="false" />
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HM2%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HM2}" key="hm2" value="%{model.hm2}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">

                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XB%>
		                  </td>
			              <td>
		                  <mytag:select  name="xb"  value="${model.xb}"  notEmpty="false"  dictName="T_DIC_SEX"  />
		                  
		                  
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BDATE%>
		                  </td>
			              <td>			                          
		                          <input id="d31312" name="bdate"  value="<s:property value='%{model.bdate}' />"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			              </td>
                   </tr>
		           <tr class="crosscolor_tr">                          
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_JG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_JG}" key="jg" value="%{model.jg}"  cssClass="max-length-40" required="false" />
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_HJD%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_HJD}" key="hjd" value="%{model.hjd}"  cssClass="max-length-40" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ZZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_ZZ}" key="zz" value="%{model.zz}"  cssClass="max-length-50" size="50" required="false" />
		                  </td>
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TX%>
		                  </td>
			              <td>
		                           <mytag:select  name="tx"  value="${model.tx}"  notEmpty="false"  dictName="DIC_TEM_SHAPE"  />
		                  
		                  </td>
		                   <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_SG%>(cm)
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_SG}" key="sg" value="%{model.sg}"  cssClass="max-length-3" required="false" />
		                  </td>            
                   </tr>
                   <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TSTZ%>
		                  </td>
			              <td colspan="3">
		                           <s:textfield label="%{@vs@ALIAS_TSTZ}" key="tstz" value="%{model.tstz}"  cssClass="max-length-90" size="50" required="false" />
		                  </td>
                   </tr>
                     <tr>
						<td colspan="5" class="tb_title"> 
						        <div align="left">
									要求布控单位
								</div>
					    </td>
				   </tr>
				   <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LADW%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LADW}" key="ladw" value="%{model.ladw}"  cssClass="max-length-40" required="false" />
		                  </td>
                            <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_PZR%>
		                  </td>
			              <td colspan="2">
		                           <s:textfield label="%{@vs@ALIAS_PZR}" key="pzr" value="%{model.pzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                        
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LXR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_LXR}" key="lxr" value="%{model.lxr}"  cssClass="max-length-30" required="false" />
		                  </td>
                         <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LXDH%>
		                  </td>
			              <td  colspan="2">
		                           <s:textfield label="%{@vs@ALIAS_LXDH}" key="lxdh" value="%{model.lxdh}"  cssClass="max-length-14" required="false" />
		                  </td>                          
                   </tr>
                   <tr>
						<td colspan="5" class="tb_title"> 
						       <div align="left">
									案件信息
								</div>
					    </td>
				   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_XH%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_XH}" key="xh" value="%{model.xh}"  cssClass="required max-length-20" required="true" />
		                           <FONT color="red">*</FONT>
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_AB%>
		                  </td>
			              <td  colspan="2">
		                         <mytag:select  name="ab"  value="${model.ab}"  notEmpty="false"  dictName="DIC_ITEM_AJLX"  />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                         
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_LASJ%>
		                  </td>
			              <td>
		                           <input id="d31315" name="lasj"  value="<s:property value='%{model.lasj}' />"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
		                  </td>

                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ZTSJ%>
		                  </td>
			              <td  colspan="2">
		                           <input id="d31316" name="ztsj"  value="<s:property value='%{model.ztsj}' />"   maxlength="0" size="15" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
		                 
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF1}" key="taf1" value="%{model.taf1}"  cssClass="max-length-30" required="false" />
		                  </td>

                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF2%>
		                  </td>		          
			              <td  colspan="2">
		                           <s:textfield label="%{@vs@ALIAS_TAF2}" key="taf2" value="%{model.taf2}"  cssClass="max-length-30" required="false" />
		                  </td>
		           </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF3%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TAF3}" key="taf3" value="%{model.taf3}"  cssClass="max-length-30" required="false" />
		                  </td>
                   
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TAF4%>
		                  </td>
			              <td  colspan="2">
		                           <s:textfield label="%{@vs@ALIAS_TAF4}" key="taf4" value="%{model.taf4}"  cssClass="max-length-30" required="false" />
		                  </td>
		          </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH1%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_TJH1}" key="tjh1" value="%{model.tjh1}"  cssClass="max-length-20" required="false" />
		                  </td>
                   
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH2%>
		                  </td>
			              <td  colspan="2">
		                           <s:textfield label="%{@vs@ALIAS_TJH2}" key="tjh2" value="%{model.tjh2}"  cssClass="max-length-20" required="false" />
		                  </td>
		          </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_TJH3%>
		                  </td>
			              <td >
		                           <s:textfield label="%{@vs@ALIAS_TJH3}" key="tjh3" value="%{model.tjh3}"  cssClass="max-length-20" required="false" />
		                  </td>
		                  
		                  <td class="crosscolor_td">
			                    <!--   <%=TbkPerson.ALIAS_PZR%> -->
		                  </td>
			              <td  colspan="2">
			                    <!-- 
		                           <s:textfield label="%{@vs@ALIAS_PZR}" key="pzr" value="%{model.pzr}"  cssClass="max-length-30" required="false" />
		                         -->
		                  </td>
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_JYAQ%>
		                  </td>
			              <td colspan="4">
		                         <s:textarea label="%{@vs@ALIAS_JYAQ}" key="jyaq"  cssClass="required max-length-255" required="false"
									value="%{model.jyaq}" rows="6" cols="60"></s:textarea><FONT color="red">*</FONT>
		                  </td>
                          
                   </tr>
                   <tr>
						<td colspan="5" class="tb_title"> 
						        <div align="left">
									布控信息
								</div>
					    </td>
				   </tr>
		           <tr class="crosscolor_tr">
		           		   </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKPZR%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_BKPZR}" key="bkpzr" value="%{model.bkpzr}"  cssClass="max-length-30" required="false" />
		                  </td>
                         
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKLX%>
		                  </td>
			              <td  colspan="2">
		                  <mytag:select  name="bklx"  value="${model.bklx}"  notEmpty="false"  dictName="DIC_ITEM_BKLX"  />
		                  
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
		                  <td class="crosscolor_td">
                          
			                      <%=TbkPerson.ALIAS_TBDW%>
		                  </td>
			              <td>
			                       <s:property value="#request.deptname"/>		                          
		                  </td>
		                  <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CZR%>
		                  </td>
			              <td  colspan="2">		                           
		                   <s:property value="#request.userxm"/>
		                  </td>
                         
                   </tr>
                    <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_BKSJ%>
		                  </td>
			              <td  colspan="2">		                           
		                   <input id="d31317" name="bksj"  value="<s:property value='%{model.bksj}' />"   maxlength="0" size="20" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>
		                 
		                  </td>
		                  <td class="crosscolor_td">
                          
		                  </td>
			              <td>
			                                               
		                  </td>
		                  
                         
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_ALARM_TEL%><br>
		                  </td>
			              <td colspan="4">
		                           <s:textarea label="%{@vs@ALIAS_ALARM_TEL}" key="alarmTel"  cssClass="required max-length-80" required="false"
									value="%{model.alarmTel}" rows="3" cols="50"></s:textarea><FONT color="red">*(多个电话用“/”分割）</FONT>
                          
                           
                          </td>
                          
                   </tr>
                   
                   <!--  
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELFLAG%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELFLAG}" key="cancelflag" value="%{model.cancelflag}"  cssClass="max-length-1" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELTIME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELTIME}" key="canceltime" value="%{model.canceltime}"  cssClass="max-length-12" required="false" />
		                  </td>
                   </tr>
		           <tr class="crosscolor_tr">
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELCAUSE%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELCAUSE}" key="cancelcause" value="%{model.cancelcause}"  cssClass="max-length-200" required="false" />
		                  </td>
                          <td class="crosscolor_td">
			                      <%=TbkPerson.ALIAS_CANCELNAME%>
		                  </td>
			              <td>
		                           <s:textfield label="%{@vs@ALIAS_CANCELNAME}" key="cancelname" value="%{model.cancelname}"  cssClass="max-length-30" required="false" />
		                  </td>
                   </tr>
                   -->
                    <inptu type="hidden"  id="cancelflag"  name="cancelflag" value="<s:property value='%{model.cancelflag}' />"  />
  <script>
//提取身份信息
    function showBirthday() {

        var birthdayValue,xzqhs,val,provId;
        
		val = document.getElementById("sfzh").value;

		if (15 == val.length) {//15位身份证号码   

			birthdayValue = val.charAt(6) + val.charAt(7);
			if (parseInt(birthdayValue) < 10) {
				birthdayValue = '20' + birthdayValue;
				document.getElementById("sfzh").value =  chg_sfzh(val,20);
			} else {
				birthdayValue = '19' + birthdayValue;
				document.getElementById("sfzh").value =  chg_sfzh(val,19);
			}
			
			
			birthdayValue = birthdayValue + '-' + val.charAt(8) + val.charAt(9)
					+ '-' + val.charAt(10) + val.charAt(11);
			
			if (parseInt(val.charAt(14) / 2) * 2 != val.charAt(14))
				document.getElementById("xb").value = '1';
			else
				document.getElementById("xb").value = '2';
				
			document.getElementById("bdate").value = birthdayValue;
			
			
		}
		if (18 == val.length) {//18位身份证号码   
			birthdayValue = val.charAt(6) + val.charAt(7) + val.charAt(8)
					+ val.charAt(9) + '-' + val.charAt(10) + val.charAt(11)
					+ '-' + val.charAt(12) + val.charAt(13);
		
			if (parseInt(val.charAt(16) / 2) * 2 != val.charAt(16))
				document.getElementById("xb").value = '1';
			else
				document.getElementById("xb").value = '2';
				
			if (val.charAt(17) != IDCard(val)) {
				document.getElementById("sfzh").style.backgroundColor = '#ffc8c8';
				document.getElementById("sfzh").value= val.toUpperCase();
			} else {
				document.getElementById("sfzh").style.backgroundColor = 'white';
			}
			document.getElementById("bdate").value = birthdayValue;
			
			
		}
		
	}
	//   18位身份证号最后一位校验   
	function IDCard(Num) {
		if (Num.length != 18)
			return false;
		var x = 0;
		var y = '';

		for (i = 18; i >= 2; i--)
			x = x + (square(2, (i - 1)) % 11)
					* parseInt(Num.charAt(19 - i - 1));
		x %= 11;
		y = 12 - x;
		if (x == 0)
			y = '1';
		if (x == 1)
			y = '0';
		if (x == 2)
			y = 'X';
		return y;
	}
	//   求得x的y次方   
	function square(x, y) {
		var i = 1;
		for (j = 1; j <= y; j++)
			i *= x;
		return i;
	}
	function chg_sfzh(sfzh,year){
		var tab1 = new Array(18);
		var tab2 = new Array(11);
		tab1[0] = 7;
		tab1[1] = 9;
		tab1[2] = 10;
		tab1[3] = 5;
		tab1[4] = 8;
		tab1[5] = 4;
		tab1[6] = 2;
		tab1[7] = 1;
		tab1[8] = 6;
		tab1[9] = 3;
		tab1[10] = 7;
		tab1[11] = 9;
		tab1[12] = 10;
		tab1[13] = 5;
		tab1[14] = 8;
		tab1[15] = 4;
		tab1[16] = 2;
		tab1[17] = 1;
		tab2[0] = '1';
		tab2[1] = '0';
		tab2[2] = 'X';
		tab2[3] = '9';
		tab2[4] = '8';
		tab2[5] = '7';
		tab2[6] = '6';
		tab2[7] = '5';
		tab2[8] = '4';
		tab2[9] = '3';
		tab2[10] = '2';
		
		var i,j;
		var sj =  new Array(18);
		var new_sfzh = new Array(18);
		
		for (i=0,j=0;i<15;i++)
		{
			if (i==6) {sj[j++]=Math.ceil(year/10-1);sj[j++]=year%10;}
			sj[j++]=sfzh.substr(i,1)-'0';
		}
		
		for (i=0;i<17;i++) 
		    new_sfzh[i]=sj[i];
		for (i=0;i<17;i++) 
		    sj[i]*=tab1[i];
		for (i=0,j=0;i<17;i++) j+=sj[i];
		    new_sfzh[17]=tab2[j%11];
		var sfz;
		sfz='';
		for (i=0,j=0;i<=17;i++) sfz=sfz+new_sfzh[i];
		return sfz;
	}
</script>

