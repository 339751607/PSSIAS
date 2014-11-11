<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ page import="com.dyneinfo.fjy.model.*"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String  picCount ="";
 if ( request.getAttribute("picCount") != null)
     picCount = (String)request.getAttribute("picCount");
String  empcode ="";
 if ( request.getAttribute("empcode") != null)
     empcode = (String)request.getAttribute("empcode");   
String  userid ="";
 if ( request.getAttribute("userid") != null)
     userid = (String)request.getAttribute("userid");       
%>
<html>

	<head>
		<%@ include file="/commons/meta.jsp"%>
		<script type='text/javascript' src='${ctx}/dwr/interface/menu.js'></script>
		<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
		<script type='text/javascript' src='${ctx}/dwr/util.js'></script>
		<base href="<%=basePath%>">
		<title><%=Temployee.TABLE_ALIAS%>编辑</title>
	</head>

	<body onload="quickSelectInit()">
		<%@ include file="/commons/messages.jsp"%>

		<s:form action="/pages/fjy/Temployee/updateAll.do" theme="simple"
			name="inputForm" method="post">
			<s:hidden id="empcode" name="empcode"></s:hidden>
			<s:hidden name="npcodehidden" value="%{#request.npcodehidden}"></s:hidden>
			<s:hidden name="nativeplacehidden"
				value="%{#request.nativeplacehidden}"></s:hidden>
			<table cellpadding="0" cellspacing="0" border="1" class="tb_all">
				<input type="hidden" name="returnUrl"
					value="!/pages/fjy/Temployee/queryList.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>" />
				<input type="hidden" name="editReturnUrl"
					value="!/pages/fjy/Temployee/editAll.do?empcode=<%=empcode%>&userid=<%=userid%>&" />
				<tr>
					<td colspan="5" class="tb_title">
						<%=Temployee.TABLE_ALIAS%>编辑
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Temployee.ALIAS_EMPNAME%>
					</td>
					<td>
						<s:property value="%{model.empname}" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Temployee.ALIAS_SEX%>
					</td>
					<td>
						<mytag:write property="%{model.sex}" name="sex" notEmpty="true"
							dictName="T_DIC_SEX" />
					</td>
					<td rowspan="16" width="18%" align="center">
						<%if(picCount != null && picCount.equals("1")) { %>
						<a
							onclick="javascript:uploadEmpPhoto('<s:property value="%{model.empcode}" />');return false;"
							href="#"> <img
								src='${ctx}/pages/fjy/Temployee/showPic.do?xh=<s:property value="%{model.empcode}" />'
								height="126" alt="" width="102" border="0" name="photo"> </a>
						<% } else {%>
						<a
							onclick="javascript:uploadEmpPhoto('<s:property value="%{model.empcode}" />');return false;"
							href="#"> <IMG src="${ctx}/images/spacer.gif" height="126"
								alt="" width="102" border="0" name="photo"> </a>
						<%} %>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Temployee.ALIAS_PERSONID%>
					</td>
					<td>
						<s:property value="%{model.personid}" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Temployee.ALIAS_BIRTH%>
					</td>
					<td>
						<s:property value="%{model.birth}" />

					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>
						<%=Temployee.ALIAS_NPCODE%>
					</td>
					<td colspan="3">
						<s:select name="prov2" id="prov2"
							value="#request.npcodeprovhidden"  cssClass="required" onchange="changeprov2();"
							list="provMap" listKey="key" headerValue="请选择..." headerKey=""
							listValue="value" theme="simple" label="省市" emptyOption="false"></s:select>
						<select id="npcode" name="npcode"></select>

					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_ADDRESS%>
					</td>
					<td colspan="3">
						<s:textfield label="%{@vs@ALIAS_ADDRESS}" size="60" key="address"
							value="%{model.address}" cssClass="max-length-100"
							required="false" />
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_PHONE%>
					</td>
					<td colspan="3">
						<s:textfield label="%{@vs@ALIAS_PHONE}" key="phone"
							value="%{model.phone}" cssClass="max-length-20 validate-number"
							required="false" />
					</td>

				</tr>				
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_FOLK%>
					</td>
					<td>
						<mytag:select property="%{model.folk}" name="folk"
							notEmpty="false" dictName="T_DIC_NATION" />
					</td>
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_ALIAS%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_ALIAS}" key="alias"
							value="%{model.alias}" cssClass="max-length-30" required="false" />
					</td>

				</tr>

				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_SCHOOLAGE%>
					</td>
					<td>
						<mytag:select property="%{model.schoolage}" name="schoolage"
							notEmpty="false" dictName="educations" />
					</td>
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_POLITYVISAGE%>
					</td>
					<td>
						<mytag:select property="%{model.polityvisage}" name="polityvisage"
							notEmpty="false" dictName="partyvisage" />
					</td>


				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_HYZH%>
					</td>
					<td>
						<mytag:select property="%{model.hyzh}" name="hyzh"
							notEmpty="false" dictName="T_DIC_HYZK" />
					</td>
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_STATURE%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_STATURE}" key="stature"
							value="%{model.stature}" cssClass="max-length-3 validate-digits"
							required="false" />
					</td>

				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_POSTURE%>
					</td>
					<td>
						<mytag:select property="%{model.posture}" name="posture"
							notEmpty="false" dictName="T_DIC_SHAPE" />
					</td>
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_WEIGHT%>
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_WEIGHT}" key="weight"
							value="%{model.weight}" cssClass="max-length-3 validate-digits"
							required="false" />
					</td>


				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_NATIVEPLACE%>
					</td>
					<td colspan="3">
						 <mytag:write property="%{model.nativeplace}"   name="nativeplace"  notEmpty="true"  dictName="T_DIC_XZQH"/>
					</td>
				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td">
						<%=Temployee.ALIAS_NPADDRESS%>
					</td>
					<td colspan="3">
						 <s:property value="%{model.npaddress}" />
					</td>
				</tr>


				<tr class="crosscolor_tr">
					<td>
						人员职务:
					</td>
					<td>
						<mytag:select property="%{model.position}" name="position"
							notEmpty="false" dictName="DICT_ITEM_EMP_POSI" />


					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT><%=Temployee.ALIAS_CYRJZT%>
					</td>
					<td>
						<mytag:select property="%{model.cyrjzt}"
							styleClass="required validate-selection" name="cyrjzt"
							notEmpty="false" dictName="cyryFlag" />
					</td>


				</tr>
				<tr class="crosscolor_tr">
					<td class="crosscolor_td" colspan="4" style="text-align: left;">
						<input type="checkbox" id="checkOpr" onclick="isDisplay();" />
						操作员信息
					</td>
				</tr>
				<tr id="show0a" style="display: none" class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>
						<%=User.ALIAS_USERNAME%>
					</td>
					<td>
						<s:hidden id="userid" name="userid"></s:hidden>
						<s:hidden id="username" name="username"></s:hidden>
						<s:textfield key="updateusername" value="%{model.username}"
							cssClass="required max-length-50" required="false" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT>
						<%=User.ALIAS_ENABLED%>
					</td>
					<td>
						<mytag:select property="%{model.enabled}"
							styleClass="required validate-selection" name="enabled"
							notEmpty="false" dictName="status" />

					</td>

				</tr>
				<tr id="show0b" style="display: none" class="crosscolor_tr">
					<td class="crosscolor_td">
						<FONT color="red">*</FONT> 注册密码
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password"
							value="%{model.password}" cssClass="required max-length-50"
							required="false" />
					</td>
					<td class="crosscolor_td">
						<FONT color="red">*</FONT> 再次输入密码
					</td>
					<td>
						<s:textfield label="%{@vs@ALIAS_PASSWORD}" key="password2"
							value="%{model.password}" cssClass="required max-length-50"
							required="false" />
					</td>
				</tr>
				<tr id="show0c" style="display: none" class="crosscolor_tr">
					<td>
						<FONT color="red">*</FONT>角色
					</td>
					<td colspan="3">
						<s:checkboxlist value="selectList" listKey="roleid"
							listValue="roledesc" list="rolemap" name="roles" />
					</td>
				</tr>



				<tr>
					<td colspan="5" class="tb_bottom">
						<input id="submitButton" name="submitButton" type="submit"
							value="保存" />
						<input type="button" value="返回"
							onclick="window.location='${ctx}/pages/fjy/Temployee/listAll.do?<mytag:params includes="ec*,s*" type="queryStringUtf"/>'" />
					</td>
				</tr>
			</table>
		</s:form>

		<script>

	new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
		var finalResult = result;

		//在这里添加自定义验证
		var flag= document.getElementById("checkOpr").checked;
		if(flag)  {
		if(result){
			if (!hasOneChecked("roles")){
	            alert('请在操作员信息中选择角色!');
	            return false;
			}
		}
		if(result){
			if(!isTrueName($F("updateusername")))
			{
				alert("操作员信息中用户名请以字母开头，长度在6-10之间！");
				return false;
				result = false;
			}
		}
		
		if(result){
			 var newpass = document.getElementById("password").value;
	         var sepass = document.getElementById("password2").value;
			if(newpass!=sepass)
		    {
		      alert('操作员信息中两次输入密码不一样');
		      return false;
		      result = false;
		    }
	    }
	    } 

		return disableSubmit(finalResult,'submitButton');
	}});
</script>

		<SCRIPT LANGUAGE="JavaScript">
<!-- Begin  -->  	
  	//提取身份信息
  	
  	
    function isTrueName(s) {
		var patrn = /^[a-zA-Z][a-zA-Z0-9_]{5,10}$/;
		if (!patrn.exec(s))
			return false
		return true
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
	
	
	function chg_sfzh(sfzh,year)
{
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
	

	function sfzhSetxzqh2(provinceId,xzqhValue)
	{
	    DWRUtil.setValue('nativeplacehidden',xzqhValue);
		menu.queryXzqhById(provinceId,cityCallback);	
	}


  

	

	
	function changeprov2()
	{
	  queryCity2();
	}
	
	//查询所属城市
	function queryCity2()
	{
		var provinceId = $("prov2").value;
		provinceId = provinceId.substr(0,2);
		menu.queryXzqhById(provinceId,cityCallback2);
	}
	
		//查询所属城市回调函数
	function cityCallback2(citys)
	{
      //每次获得新的数据的时候先把每三个下拉框架的长度清0
	   DWRUtil.removeAllOptions("npcode");
        try{
           // DWRUtil.addOptions("xzqh",{'':'请选择...'});  
            DWRUtil.addOptions("npcode",citys,"id","cityName");//将option对象添加到第三个下拉框中
           
            DWRUtil.setValue('npcode',$F("npcodehidden")); 
        }catch(e){
        }
     
	}

    queryCity2();
    
    	//格式日期
	function DateFormat(obj) {
	    var bdate;
		bdate = obj.value;
		if(bdate != "" && 8 == bdate.length){
		   obj.value = bdate.charAt(0) + bdate.charAt(1) + bdate.charAt(2)
					+ bdate.charAt(3) + '-' + bdate.charAt(4) + bdate.charAt(5)
					+ '-' + bdate.charAt(6) + bdate.charAt(7);
		}
	
	}
	
	
	function uploadEmpPhoto(ID) {
        var frm = document.forms("form1");
		var returnvalue = window.showModalDialog("${ctx}/pages/fjy/Temployee/uploadPhoto.jsp?xh="+ID,"childWIn","dialogHeight:150px;dialogWidth:400px;scroll:off;center:yes");
		if (returnvalue == "yes"){
		    changesrc();
	      }      
	}
	

    rnd.today=new Date();  
    rnd.seed=rnd.today.getTime(); 
    
    function rnd() {  
	　　　  rnd.seed = (rnd.seed*9301+49297) % 233280;  
	　　　　return rnd.seed/(233280.0);  
    };  
    function rand(number) {  
　　　　	return Math.ceil(rnd()*number);  
    };  
    
   function changesrc(){
	    var pic=document.getElementById('photo');
	    pic.src='${ctx}/pages/fjy/Temployee/showPic.do?xh=<s:property value="%{model.empcode}" />&rand='+rand(1000);
   }  
   
   
   function isDisplay() {	
      var flag= document.getElementById("checkOpr").checked;   
	   document.getElementById("show0a").style.display = flag?"":"none";
	   document.getElementById("show0b").style.display = flag?"":"none";
	   document.getElementById("show0c").style.display = flag?"":"none";	    	   
	}
  isDisplay();
<!-- End -->
</SCRIPT>

	</body>

</html>