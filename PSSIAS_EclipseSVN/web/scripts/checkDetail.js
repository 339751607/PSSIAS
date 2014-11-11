   function openDetail_JN(project,id,persontype,source,cpcode, idName, idCode){
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();
      var url = "";

      if(source == "001"){  //旅馆业中分从业人员和住宿旅客
	      if(persontype =='01'){ // 从业
	         url=encodeURI(project + "/pages/hotel/Temployee/zazhShow.do?empcode=" + id + "&today=" + todayStr);   
	      }
	      if(persontype =='02'){ // 住宿
              url=encodeURI(project + "/pages/hotel/TchPre/zazhShow.do?id=" + id + "&today=" + todayStr);   
          }
      }
      
      if(source == "002"){  //废旧业中分从业人员和出售的客户
	      if(persontype =='01'){ // 从业
	         //alert("废旧从业人员未配置详细页面！");
	         url=encodeURI(project + "/pages/fjy/Temployee/zazhShow.do?empcode=" + id + "&today=" + todayStr);   
          
	      }
	      if(persontype =='06'){ // 废品出售人
              //alert("废品出售未配置详细页面！");
              url=encodeURI(project + "/pages/fjy/Tfeijiuwupin/zazhShow.do?wupinxh=" + id + "&today=" + todayStr);
          }
      }
      if(source == "003"){  //典当业中分从业人员和典当的客户
	      if(persontype =='01'){ // 从业
	         url=encodeURI(project + "/pages/pmdd/Temployee/zazhshow.do?empcode="+ id + "&today=" + todayStr);
	      }
	      if(persontype =='04'){ // 典当
            url=encodeURI(project + "/pages/pmdd/Dczydd/findshow.do?dnumber=" + id 
                       + "&zjhm="+idCode+"&yxzj="+idName+"&today=" + todayStr);
          }
      }
      if(source == "004"){  //散装汽油中分从业人员和典当的客户
	      if(persontype =='01'){ // 从业
	         //alert("散装汽油从业人员未配置详细页面！");	         
	         url=encodeURI(project + "/pages/gas/Temployeegas/zazhShow.do?empcode=" + id + "&today=" + todayStr); 
          }
	      if(persontype =='05'){ // 散装汽油购油人
             //alert("购油人详细页面！");
             url=encodeURI(project + "/pages/gas/Tbuylog/zazhShow.do?id=" + id + "&today=" + todayStr); 
          }
      }
      if(source == "005"){  //机修业中分从业人员和送修的客户
	      if(persontype =='01'){ // 从业
	         url=encodeURI(project + "/jxy/Temployee/zazhShow.do?cpempcode=" + id + "&cpcode=" + cpcode + "&today=" + todayStr);   
	      }
	      if(persontype =='03'){ // 送修客人
             url=encodeURI(project + "/jxy/Tcarinfo/zazhShow.do?enrolid=" + id + "&today=" + todayStr);   
          }
      }
      
      if(url == ""){
         alert("未配置相应查询页面！");
         return false;
      } 
      
      window.showModalDialog(url, "info","dialogHeight:500px;dialogWidth:750px;scroll:yes;center:yes");
   }
   
   function openDetail_JW(project, id,persontype,source,cpcode){
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();
      var url = "";
      if(source == "001"){  //旅馆业中分从业人员和住宿旅客
	      if(persontype =='01'){ // 从业
	         alert("旅馆业从业人员未配置详细页面！");
	         //url=encodeURI(project + "/pages/hotel/Temployee/zazhShow.do?empcode==" + id + "&today=" + todayStr);   
	      }
	      if(persontype =='02'){ // 住宿
             url=encodeURI(project + "/pages/hotel/TjwPre/zazhShow.do?id=" + id + "&today=" + todayStr);   
          }
      }
      if(source == "002"){  //废旧业中分从业人员和出售的客户
	      if(persontype =='01'){ // 从业
	         alert("废旧从业人员未配置详细页面！");
	      }
	      if(persontype =='06'){ // 废品出售人
              alert("废品出售未配置详细页面！");
          }
      }
      if(source == "003"){  //典当业中分从业人员和典当的客户
	      if(persontype =='01'){ // 从业
	         alert("典当从业人员未配置详细页面！");
	      }
	      if(persontype =='04'){ // 典当
             alert("典当人未配置详细页面！");
          }
      }
      if(source == "004"){  //典当业中分从业人员和典当的客户
	      if(persontype =='01'){ // 从业
	         alert("散装汽油从业人员未配置详细页面！");
	      }
	      if(persontype =='05'){ // 典当
             alert("散装汽油购油人未配置详细页面！");
          }
      }
      if(source == "005"){  //机修业中分从业人员和送修的客户
	      if(persontype =='01'){ // 从业
	         //alert("机修业未配置从业查询页面！");
	         url=encodeURI(project + "/jxy/Temployee/show.do?cpempcode=" + id + "&today=" + todayStr);   
	      }
	      if(persontype =='03'){ // 送修客人
             alert("机修业未配置送修客人查询页面！");
          }
      }

      if(url == ""){
         alert("未配置相应查询页面！");
         return false;
      } 
      window.showModalDialog(url, "info","dialogHeight:500px;dialogWidth:750px;scroll:yes;center:yes");
      
   }
   
   function openDetail_Car(project, id, persontype , source ){
      var todayStr="";
      var now=new Date();     
      todayStr=now.getTime();
      var url = "";
      if(source == "001"){  //旅馆业中住宿旅客
	      if(persontype =='02'){ // 带车住宿
             url=encodeURI(project + "/pages/hotel/TchPre/zazhShow.do?id=" + id + "&today=" + todayStr);   
          }
      }
      if(source == "003"){  //典当业中典当的客户
	      if(persontype =='04'){ // 典当
              url=encodeURI(project +"/pages/pmdd/Dczydd/findclddxx.do?dnumber=" + id +"&today=" + todayStr);
          }         
      }
      if(source == "005"){  //机修业中分从业人员和送修的客户
	      if(persontype =='03'){ // 送修客人
             url=encodeURI(project + "/jxy/Tcarinfo/zazhShow.do?enrolid=" + id + "&today=" + todayStr);
          }
      }
      if(url == ""){
         alert("未配置相应查询页面！");
         return false;
      } 
      window.showModalDialog(url, "info","dialogHeight:500px;dialogWidth:750px;scroll:yes;center:yes");
      
   }
   