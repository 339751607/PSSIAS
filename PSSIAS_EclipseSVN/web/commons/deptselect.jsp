<%@ page contentType="text/html;charset=UTF-8"%>

<script src="<c:url value="/scripts/jquery.js"/>" type="text/javascript"></script>
<script language="javascript">     
             var j$ = jQuery.noConflict();     
    </script>
    <%@ page import="net.java.dev.common.dict.taglib.DictHelpImpl"%>
<%
String prcode = (String)DictHelpImpl.getInitData("prcode");
String mpcode = (String)DictHelpImpl.getInitData("mpcode");
 %>
<html>
	<head>
	</head>
	<body>
		<tr class="crosscolor_tr">
			<td class="crosscolor_td">
				所属市局
			</td>
			<td id="id0">
					<select id="root" value="<%=mpcode%>" onchange="selectDept('root','parent1');setDeptValue(this)" style="width: 150px">
					<option value="">
						全部
					</option>
				</select>
			</td>
			<td class="crosscolor_td">
				所属分局
			</td>
			<td id="id1">
				<select id="parent1"  onchange="selectDept('parent1','parent2');setDeptValue(this)" style="width: 150px">
					<option value="">
						全部
					</option>
				</select>
			</td>
			<td>
		</tr>
		<tr class="crosscolor_tr">
			<td class="crosscolor_td">
				所属派出所
			</td>
			<td id="id2">
				<select id="parent2"  onchange="selectDept('parent2','dept');setDeptValue(this)" style="width: 150px">
					<option value="">
						全部
					</option>
				</select>
			</td>
			<td class="crosscolor_td">
				所属企业
			</td>
			<td id="id3">
				<select id="dept" onchange="setDeptValue(this)" style="width: 150px">
					<option value="">
						全部
					</option>
				</select>
			</td>
			<input type="hidden"  name="s_deptseq"  id="deptcode" value="${deptid}" />
		</tr>
	</body>
<script language="javascript">
	var prcode="<%=prcode%>";
	var mpcode="<%=mpcode%>";
var deptname=document.getElementById("deptname");
var deptcode=document.getElementById("deptcode");
deptcode.value="."+deptcode.value+".";
var deptseq='${deptseq}';
var deptname='${deptname}';
var seqs;
if(deptseq!=null){
	seqs=deptseq.replace("\.1000\."+prcode+"\.","").split("\.");
}
if(seqs.length==2){
	j$("#id0").html("<select id='root' value='"+mpcode+"'  style='width: 150px'><option value='"+seqs[0]+"'>市公安局</option></select>");
	selectDept('root','parent1');

}
if(seqs.length==3){
	j$("#id0").html("<select id='root'  disabled=\"disabled\"  style='width: 150px'><option value='"+seqs[0]+"'>市公安局</option></select>");
	j$("#id1").html("<select  id=\"parent1\"    disabled=\"disabled\" style='width: 150px'><option value='"+seqs[1]+"'>"+deptname+"</option></select>");
	selectDept('parent1','parent2');
}
if(seqs.length==4){
	j$("#id0").html("<select id='root'  disabled=\"disabled\" style='width: 150px'><option value='"+seqs[0]+"'>市公安局</option></select>");
	j$("#id1").html("<select  id=\"parent1\"  disabled=\"disabled\" style='width: 150px'><option value='"+seqs[1]+"'>请选择...</option></select>");
	j$("#id2").html("<select  id=\"parent2\"    disabled=\"disabled\" style='width: 150px'><option value='"+seqs[2]+"'>"+deptname+"</option></select>");
	selectDept('root','parent1');
	selectDept('parent2','dept');
}
if(seqs.length==5){
	j$("#id0").html("<select id='root'  disabled=\"disabled\" style='width: 150px'><option value='"+seqs[0]+"'>市公安局</option></select>");
	j$("#id1").html("<select  id=\"parent1\"   disabled=\"disabled\" style='width: 150px'><option value='"+seqs[1]+"'>请选择...</option></select>");
	j$("#id2").html("<select  id=\"parent2\"   disabled=\"disabled\" style='width: 150px'><option value='"+seqs[2]+"'>请选择...</option></select>");
	j$("#id3").html("<select  id=\"dept\"   disabled=\"disabled\" style='width: 150px'><option value='"+seqs[3]+"'>"+deptname+"</option></select>");
	selectDept('root','parent1');
	selectDept('parent2','dept');
}

function selectDept(parentid,deptid){
		var parent=document.getElementById(parentid);
		var dept=document.getElementById(deptid);
		var url="${ctx}/pages/SelectDept/list.do?ajax=true&parentId="+parent.value;
		if(deptid=="dept"){
			url=url+"&depttypeid='E02'";
		}
		j$.post(url, function(data) {
			j$("#"+deptid).html("<option value=''>全部</option>");
			j$("#dept").html("<option value=''>全部</option>");
			j$("#"+deptid).append(data);
		});
}
function setDeptValue(obj){

	if(obj.options[obj.selectedIndex].value!=""){
		deptcode.value="."+obj.options[obj.selectedIndex].value+".";
	}else{
		if(obj.id=="parent2"){
			deptcode.value="."+document.getElementById("parent1").value+".";
		}
		if(obj.id=="parent1"){
			deptcode.value="."+document.getElementById("root").value+".";
		}
		if(obj.id=="dept"){
			deptcode.value="."+document.getElementById("parent2").value+".";
		}
	}
}

</script>
</html>

