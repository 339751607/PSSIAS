<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/selectDept.jsp" %>
<html>
	<head>
	</head>
	<body>
	<!--  -->
		<select id="fjid" value="" onchange="getPcs('fjid','pcsid');getDeptByParentid('fjid','dept');" style="width: 150px">
			<option>请选择...</option>
		</select>
		<select id="pcsid" value="" onchange="getDeptByParentid('pcsid','dept');" style="width: 150px">
			<option>请选择...</option>
		</select>
		<select id="dept" value=""  style="width: 150px">
			<option>请选择...</option>
		</select>
		<input type="text"  name="sendunitid"  id="deptcode" onclick="setValue('','','','')"/>
		<input type="button" valur="提交"  onclick="submitValue('fjid','pcsid','dept','deptcode')"/>
	</body>

</html>

<script language="javascript">
	getFj('fjid')
	</script>
