/*
-------------------------------------------------------------------------------
文件名称：dateSelect.js
说    明：JavaScript脚本，处理一些和日期有关的动作
版    本：1.0
修改纪录:

   var minTxt,maxTxt,paraCurrDate;
   minTxt = document.getElementById("START");
   maxTxt = document.getElementById("END");
   paraCurrDate = new Date(); 
  // var d2 = new Date(2006, 6, 7);
   
---------------------------------------------------------------------------
时间        修改人      说明
-------------------------------------------------------------------------------     
*/





var http_request = "";
if(window.XMLHttpRequest){
  try{http_request = new XMLHttpRequest();} catch (e){;}  
}else if(window.ActiveXObject){ 
  try{ http_request = new ActiveXObject("Msxml2.XMLHTTP");} catch (e){ ; }
  if( http_request == null){
    try { http_request = new ActiveXObject("Microsoft.XMLHTTP");}   catch (e){;}
  }
}
http_request.open('HEAD', '.', false);
http_request.send(null);
var paraCurrDate = new Date(http_request.getResponseHeader('Date'));


	function SetDateNull(minTxt,maxTxt)
	{
       minTxt.value="";
       maxTxt.value="";
	}
    function setToday(minTxt,maxTxt,format){
       var now= paraCurrDate; 
       minTxt.value=getFormatMinDate(now,format);
       maxTxt.value=getFormatMaxDate(now,format);
    }
    
    function setCurrWeek(minTxt,maxTxt,format){
       minTxt.value=getFormatMinDate(showWeekFirstDay(),format);
       maxTxt.value=getFormatMaxDate(showWeekLastDay(),format);
    }
    
    function setPrevWeek(minTxt,maxTxt,format){
       minTxt.value=getFormatMinDate(showPreviousFirstWeekDay(),format);
       maxTxt.value=getFormatMaxDate(showPreviousLastWeekDay(),format);
    }
    
    function setCurrMonth(minTxt,maxTxt,format){
       minTxt.value=getFormatMinDate(showMonthFirstDay(),format);
       maxTxt.value=getFormatMaxDate(showMonthLastDay(),format);
    }
    
    function setPrevMonth(minTxt,maxTxt,format){
       minTxt.value=getFormatMinDate(showPreviousFirstDay(),format);
       maxTxt.value=getFormatMaxDate(showPreviousLastDay(),format);
    }
	
    function setFirstHalfYear(minTxt,maxTxt,format){
	    var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),0,1);
		var max=new Date(Nowdate.getYear(),5,30);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setSecondHalfYear(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),6,1);
		var max=new Date(Nowdate.getYear(),11,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setSpringDate(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),0,1);
		var max=new Date(Nowdate.getYear(),2,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setSummerDate(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),3,1);
		var max=new Date(Nowdate.getYear(),5,30);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setAutumnDate(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),6,1);
		var max=new Date(Nowdate.getYear(),8,30);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setWinterDate(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),9,1);
		var max=new Date(Nowdate.getYear(),11,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setCurrYear(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date(Nowdate.getYear(),0,1);
		var max=new Date(Nowdate.getYear(),11,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setPrevYear(minTxt,maxTxt,format){
        var Nowdate= paraCurrDate;
		var min=new Date((Nowdate.getYear()-1),0,1);
		var max=new Date((Nowdate.getYear()-1),11,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
    function setPrev2Year(minTxt,maxTxt,format){
    	var Nowdate= paraCurrDate;
		var min=new Date((Nowdate.getYear()-2),0,1);
		var max=new Date((Nowdate.getYear()-2),11,31);
		minTxt.value=getFormatMinDate(min,format);
        maxTxt.value=getFormatMaxDate(max,format);
    }
     function setEmpty(minTxt,maxTxt,format){
    	
	    minTxt.value="";
	    maxTxt.value="";
    }
	//今天
     function showToDay()
	{
	   //var Nowdate=new Date();
	   //M=Number(Nowdate.getMonth())+1
	   //return Nowdate.getYear()+"-"+M+"-"+Nowdate.getDate();
    	var now= paraCurrDate; 
        return now;
	}	
	
	//本周第一天
     function getFirstDateOfWeek()
	{
	
	   var Nowdate= paraCurrDate;
	   var WeekFirstDay=new Date(Nowdate-(Nowdate.getDay()-1)*86400000);
	   
	   return WeekFirstDay;
	}
	
	//本周最后一天
	function getLastDateOfWeek()
	{
		var Nowdate= paraCurrDate;
		var WeekFirstDay=new Date(Nowdate-(Nowdate.getDay()-1)*86400000);
		var WeekLastDay=new Date((WeekFirstDay/1000+6*86400)*1000);
		return WeekLastDay;
	}
	
	
	//得到每周的第一天(周一)
	function showWeekFirstDay(){
	// var firstDateOfWeek;
	// var Nowdate= paraCurrDate;
	// Nowdate.setDate(Nowdate.getDate() + 1 - Nowdate.getDay()); 
	// firstDateOfWeek = Nowdate;
	// return firstDateOfWeek; 
		
		 var Nowdate= paraCurrDate;
		   var WeekFirstDay=new Date(Nowdate-(Nowdate.getDay()-1)*86400000);
		   return WeekFirstDay;
	}
	//得到每周的最后一天(周日)
	function showWeekLastDay(){
	// var lastDateOfWeek;
	// var Nowdate= paraCurrDate;
	// Nowdate.setDate(Nowdate.getDate() +7 - Nowdate.getDay());
	// lastDateOfWeek = Nowdate;
	// return lastDateOfWeek; 
		var Nowdate= paraCurrDate;
		var WeekFirstDay=new Date(Nowdate-(Nowdate.getDay()-1)*86400000);
		var WeekLastDay=new Date((WeekFirstDay/1000+6*86400)*1000);
		return WeekLastDay;
	}
	
	
   //上周第一天
	function showPreviousFirstWeekDay()
	{
		var WeekFirstDay=showWeekFirstDay()
		return new Date(WeekFirstDay-86400000*7)
	}
	//上周最后一天
	function showPreviousLastWeekDay()
	{
		var WeekFirstDay=showWeekFirstDay()
		return new Date(WeekFirstDay-86400000)
	}
		
	//本月第一天
	function showMonthFirstDay()
	{
		var Nowdate= paraCurrDate;
		var MonthFirstDay=new Date(Nowdate.getYear(),Nowdate.getMonth(),1);
		return MonthFirstDay;
	}
	//本月最后一天
	function showMonthLastDay()
	{
		var Nowdate= paraCurrDate;
		var MonthNextFirstDay=new Date(Nowdate.getYear(),Nowdate.getMonth()+1,1);
		var MonthLastDay=new Date(MonthNextFirstDay-86400000);
		return MonthLastDay;
	}
	
	//上月第一天
	function showPreviousFirstDay()
	{
		var MonthFirstDay=showMonthFirstDay()
		return new Date(MonthFirstDay.getYear(),MonthFirstDay.getMonth()-1,1)
	}
	//上月最后一天
	function showPreviousLastDay()
	{
		var MonthFirstDay=showMonthFirstDay();
		return new Date(MonthFirstDay-86400000);
	}
	
	
    
    
    MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; 
    
    
	
	//上一天
	function showPreviousDay()
	{
		var MonthFirstDay=paraCurrDate;
		return new Date(MonthFirstDay-86400000);
	}
	//下一天
	function showNextDay()
	{
		var MonthFirstDay=paraCurrDate;
		return new Date((MonthFirstDay/1000+86400)*1000);
	}
	//下周第一天
	function showNextFirstWeekDay()
	{
		var MonthFirstDay=showWeekLastDay()
		return new Date((MonthFirstDay/1000+86400)*1000)
	}
	//下周最后一天
	function showNextLastWeekDay()
	{
		var MonthFirstDay=showWeekLastDay()
		return new Date((MonthFirstDay/1000+7*86400)*1000)
	}
	//下月第一天
	function showNextFirstDay()
	{
		var MonthFirstDay=showMonthFirstDay()
		return new Date(MonthFirstDay.getYear(),MonthFirstDay.getMonth()+1,1)
	}
	//下月最后一天
	function showNextLastDay()
	{
		var MonthFirstDay=showMonthFirstDay()
		return new Date(new Date(MonthFirstDay.getYear(),MonthFirstDay.getMonth()+2,1)-86400000)
	}
	
	function Date.prototype.toString(){
		return this.getFullYear()+"-"+(this.getMonth()+1)+"-"+this.getDate();
	}
  
  function getFormatMinDate(date_obj,date_templet){

		  var year,month,day,hour,minutes,seconds,short_year,full_month,full_day,full_day,full_hour,full_minutes,full_seconds;
		  if(!date_templet)date_templet = "yyyy-MM-dd HH:mm:ss";
		  year = date_obj.getFullYear().toString();
		  short_year = year.substring(2,4);
		  month = (date_obj.getMonth()+1).toString();
		  month.length == 1 ? full_month = "0"+month : full_month = month;
		  day = date_obj.getDate().toString();
		  day.length == 1 ? full_day = "0"+day : full_day = day;
		  hour = date_obj.getHours().toString();
		  hour.length == 1 ? full_hour = "0"+hour : full_hour = hour;
		  minutes = date_obj.getMinutes().toString();
		  minutes.length == 1 ? full_minutes = "0"+minutes : full_minutes = minutes;
		  seconds = date_obj.getSeconds().toString();
		  seconds.length == 1 ? full_seconds = "0"+seconds : full_seconds = seconds;
		  return date_templet.replace("yyyy",year).replace("MM",full_month).replace("dd",full_day).replace("yy",short_year).replace("M",month).replace("d",day).replace("HH","00").replace("mm","00").replace("ss","00").replace("H","0").replace("m","0").replace("s","0");
}

 function getFormatMaxDate(date_obj,date_templet){

		  var year,month,day,hour,minutes,seconds,short_year,full_month,full_day,full_day,full_hour,full_minutes,full_seconds;
		  if(!date_templet)date_templet = "yyyy-MM-dd HH:mm:ss";
		  year = date_obj.getFullYear().toString();
		  short_year = year.substring(2,4);
		  month = (date_obj.getMonth()+1).toString();
		  month.length == 1 ? full_month = "0"+month : full_month = month;
		  day = date_obj.getDate().toString();
		  day.length == 1 ? full_day = "0"+day : full_day = day;
		  hour = date_obj.getHours().toString();
		  hour.length == 1 ? full_hour = "0"+hour : full_hour = hour;
		  minutes = date_obj.getMinutes().toString();
		  minutes.length == 1 ? full_minutes = "0"+minutes : full_minutes = minutes;
		  seconds = date_obj.getSeconds().toString();
		  seconds.length == 1 ? full_seconds = "0"+seconds : full_seconds = seconds;
		  return date_templet.replace("yyyy",year).replace("MM",full_month).replace("dd",full_day).replace("yy",short_year).replace("M",month).replace("d",day).replace("HH","23").replace("mm","59").replace("ss","59").replace("H",hour).replace("m",minutes).replace("s",seconds);
}

	
	function dateselect(obj,START,END,format){
	    var minTxt,maxTxt,paraCurrDate;
        minTxt = document.getElementById(START);
        maxTxt = document.getElementById(END);
	    if(obj.value=="10") { 
		   setToday(minTxt,maxTxt,format);
		} else if(obj.value=="11") { 
		   setCurrWeek(minTxt,maxTxt,format);
		} else if(obj.value=="12") { 
		   setPrevWeek(minTxt,maxTxt,format);
		} else if(obj.value=="13") { 
		    setCurrMonth(minTxt,maxTxt,format);
		} else if(obj.value=="14") { 
		    setPrevMonth(minTxt,maxTxt,format); 
		} else if(obj.value=="15") { 
		    setSpringDate(minTxt,maxTxt,format);
		} else if(obj.value=="16") { 
		    setSummerDate(minTxt,maxTxt,format);
		} else if(obj.value=="17") { 
		    setAutumnDate(minTxt,maxTxt,format); 
		} else if(obj.value=="18") { 
		    setWinterDate(minTxt,maxTxt,format);
		} else if(obj.value=="19") { 
		    setFirstHalfYear(minTxt,maxTxt,format);
		} else if(obj.value=="20") { 
		    setSecondHalfYear(minTxt,maxTxt,format);
		} else if(obj.value=="21") { 
		    setCurrYear(minTxt,maxTxt,format);
		} else if(obj.value=="22") { 
		    setPrevYear(minTxt,maxTxt,format);
		} else if(obj.value=="23") { 
		    setPrev2Year(minTxt,maxTxt,format);
		} else  { 
		    setEmpty(minTxt,maxTxt,format); 
		}
	}


/*
功能：验证身份证号码是否有效
提示信息：未输入或输入身份证号不正确！
使用：f_check_IDno(obj)
返回：bool
*/
function f_check_IDno(strIDno)
{ 
	var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
 
	var iSum = 0;
	var info = "";

	var idCardLength = strIDno.length;  
	if(!/^\d{17}(\d|x)$/i.test(strIDno)&&!/^\d{15}$/i.test(strIDno)) 
	{
		alert("非法身份证号");
		return false;
	}
 
	//在后面的运算中x相当于数字10,所以转换成a
	strIDno = strIDno.replace(/x$/i,"a");

	if(aCity[parseInt(strIDno.substr(0,2))]==null)
	{
		alert("身份证非法地区");
		return false;
	}
	
	if (idCardLength==18)
	{
		sBirthday=strIDno.substr(6,4)+"-"+Number(strIDno.substr(10,2))+"-"+Number(strIDno.substr(12,2));
		var d = new Date(sBirthday.replace(/-/g,"/"))
		if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))
		{		
			alert("身份证非法生日");
			return false;
		}

		for(var i = 17;i>=0;i --)
			iSum += (Math.pow(2,i) % 11) * parseInt(strIDno.charAt(17 - i),11);

		if(iSum%11!=1)
		{
			alert("非法身份证号");
			return false;
		}
	}
	else if (idCardLength==15)
	{
		sBirthday = "19" + strIDno.substr(6,2) + "-" + Number(strIDno.substr(8,2)) + "-" + Number(strIDno.substr(10,2));
		var d = new Date(sBirthday.replace(/-/g,"/"))
		var dd = d.getFullYear().toString() + "-" + (d.getMonth()+1) + "-" + d.getDate();   
		if(sBirthday != dd)
		{
			alert("身份证非法生日");
			return false;
		}
	/*	if(confirm("是否将身份证15位升18位？")==false){
	      return ;
	    }   
	    else {
	      obj.value =  chg_sfzh(obj.value,19);
	    }*/
	}
	return true; 
}