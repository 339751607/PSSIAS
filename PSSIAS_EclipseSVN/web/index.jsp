<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<script language="JavaScript">
<!--
function MachakFull(Ie,other){
       x=screen.availWidth-10;
       y=screen.height-55;
       target = parseFloat(navigator.appVersion.substring(navigator.appVersion.indexOf(".")-1,navigator.appVersion.length));      
       if((navigator.appVersion.indexOf("Mac")!=-1) &&(navigator.userAgent.indexOf("MSIE")!=-1) &&(parseInt(navigator.appVersion)==4))
               window.open(other,"sub","scrollbars=yes");
       if (target >= 4){
           if (navigator.appName=="Netscape"){
               var MachakFull=window.open(other,"MachakFull","scrollbars=yes","width="+x+",height="+y+",top=0,left=0,location=no");
                MachakFull.moveTo(0,0);
                MachakFull.resizeTo(x,y);}
       if (navigator.appName=="Microsoft Internet Explorer")
    	   <%--
             if(navigator.userAgent.indexOf("MSIE 8.0;") > -1){
               // var lovechild= window.open(Ie,"lovechild","fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width="   +   x   +   ",height="   +   y   +   ",top=0,left=0",true);   
               window.open(Ie,"fullscreen","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width="+(screen.width)+",height="+(screen.height)+",top="+((screen.height-screen.height)/2)+",left="+((screen.width-screen.width)/2))
             }
             else if(navigator.userAgent.indexOf("MSIE 7.0;") > -1){
               //var lovechild= window.open(Ie,"lovechild","fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width="   +   x   +   ",height="   +   y   +   ",top=0,left=0",true);   
               window.open(Ie,"fullscreen","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width="+(screen.width)+",height="+(screen.height)+",top="+((screen.height-screen.height)/2)+",left="+((screen.width-screen.width)/2))   
               }
               else if(navigator.userAgent.indexOf("MSIE 6.0;") > -1){
               //var lovechild= window.open(Ie,"lovechild","fullscreen=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=0,resizable=0,width="   +   x   +   ",height="   +   y   +   ",top=0,left=0",true);   
               window.open(Ie,"fullscreen","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width="+(screen.width)+",height="+(screen.height)+",top="+((screen.height-screen.height)/2)+",left="+((screen.width-screen.width)/2))   
               }
               else {
               --%>
                   window.location.href="${ctx}/login.jsp";		
              // }
      }
      else window.open(other,"sub","scrollbars=yes");
}
function replace_window(){
       MachakFull("login.jsp?popFlag=1","")
}
function closeWindow() {   
    window.opener = null;   
    window.open('', '_self', '');   
    window.close();   
}  
//-->
</script>
</head> 
<body onload="replace_window();">

</body>
</html>

