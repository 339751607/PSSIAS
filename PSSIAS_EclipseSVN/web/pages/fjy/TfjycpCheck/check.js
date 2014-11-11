	j$(document).ready(function(){
		
		j$("#but").click(function(){
		if(isnull()&&isRepeat()){
			var item=document.getElementById("item");
 			var strsel = item.options[item.selectedIndex].text;
			var content=document.getElementById("content").value;
			var j$table=j$("#tab tr");
			var len=j$table.length;
			var cs="odd";
			if(len%2 == 0){
				cs="even";
			}
			j$("#tab").append("<tr  id="+(len)+" ><td align=\'center\'><input type=\"hidden\" name=\"items\" value="+item.value+">"+strsel+"</td><td align=\'center\'><input type=\"hidden\" name=\"contents\" value="+content+">"+content+"</td><td align=\'center\'><a href='javascript:deltr("+(len)+")' >删除</a></td></tr>");			
		}
		})	
		
		
	})
	
	function deltr(index)
	{
		j$table=j$("#tab tr");
		j$("tr[id=\'"+index+"\']").remove();
	}

	function isnull(){
		if(document.getElementById("item").value==""){
		alert("请选择检查项目");
		return false;
		}else if(document.getElementById("content").value==""){
		alert("请填写检查结果");
		return false;
		}
		else{
		return true;
		}
	}
	function isRepeat(){
		var items=document.getElementsByName("items");
		var item=document.getElementById("item").value;
		
		for(var i=0;i<items.length;i++){
			if(item==items[i].value){
				alert("检查项目已存在");
				return false;
			}
		}
		return true;
	}