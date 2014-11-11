function resitData(form){
	for (var i = 0; i < form.elements.length; i++) {
		if(form.elements.elements[i].type!="checkbox"&&form.elements.elements[i].type!="hidden"&&form.elements.elements[i].type!="button"&&form.elements.elements[i].type!="submit"){
			if(form.elements.elements[i].name!="dic_date"){
				form.elements.elements[i].value="";
			}
		}
	}
}
