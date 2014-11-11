<?php $this->_extends('_layouts/input_layout'); ?>

<?php $this->_block('title'); ?>
鍙戦偖浠�
<?php $this->_endblock(); ?>

<?php $this->_block('save'); ?>
<table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td class="STYLE1"><div align="center">
                         <a href="javascript:formSubmit(1)" ><img src="/govoa/tab/images/email_go.png" width="16" height="14" />鍙戦��/a>
                        </div></td>
                    </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td class="STYLE1"><div align="center">
                        <a href="javascript:formSubmit(2)"><img src="/govoa/image/unRd2.gif" width="16" height="14" />瀛樿崏鎼�/a>
                        </div></td>
                    </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td class="STYLE1"><div align="center"><a href="javascript:history.go(-1)"><img src="/govoa/tab/images/cancel.gif" width="44" height="16" border="0" /></a></div></td>
                    </tr>
                </table></td>
              </tr>
            </table>
<?php $this->_endblock() ?>

<?php $this->_block('contents'); ?>
<link rel="stylesheet" type="text/css"	href="/govoa/js/extjs/resources/css/ext-all.css" />
<script type="text/javascript" src="/govoa/js/extjs/ext-base.js"></script>
<script type="text/javascript" src="/govoa/js/extjs/ext-all-debug.js"></script>

<script type="text/javascript" src="/govoa/js/TreeCheckNodeUI.js"></script>
<script type="text/javascript" src="/govoa/js/seluser.js"></script>

<script type="text/javascript" src="/govoa/fckeditor/fckeditor.js"></script>
	
	<script type="text/javascript">
	var selectUserWindow=null;
	function showSelectUserPanel()
	{
		if(selectUserWindow==null)
		{	
		var sp= new StaffSelectPanel({
			serviceUrl:'/govoa/showdepttree/user',					
			checkModel: 'cascade',//,   // 'multiple':澶氶�� 'single':鍗曢�� 'cascade':绾ц仈澶氶��  
    		//onlyLeafCheckable: false,//鍙厑璁搁�夋嫨鍙跺瓙(鍛樺伐)  
    		isCheckable :function(n, a, targetNode, bulkRender)
    		{   
    			return true;
    		}
			//initSelectNodes:'10,12,13'//鍒濆鍖栬閫変腑鐨勫憳宸�
			//setSelectNodes(stirng||array)//璁剧疆琚�変腑鐨勫憳宸�
		});
	 			  
		selectUserWindow = new Ext.Window(	{
			xtype:"panel",
			title:"閫夋嫨鐢ㄦ埛",
			layout:'fit',
			height:400,
			closeAction:'hide',
			width:400,	
			staffSelectPanel:sp,
			buttons:[{
				text:"纭畾",
				handler:function(){
					
					
					var textArray=[];
					var idArray=[];
					sp.eachSelectNodes(function(key,node){
						if(node.attributes.leaf)
						{
							textArray[textArray.length]=node.attributes.text;
							idArray[idArray.length]=node.attributes.id;
						}
					});
					var txts= textArray.join(",");
					var ids=idArray.join(",");
					setSelectUsers(txts,ids);
					selectUserWindow.hide();
				}
			}/*
			,
			         {
			text:"璁惧��",
			handler:function(){
				sp.setSelectNodes("10,12,13");
			}},{
			text:"鑷畾涔夊惊鐜樉绀洪�変腑鐨勮妭鐐�",
			handler:function(){
				sp.eachSelectNodes(function(key,node){
					alert(key+"_"+ node.attributes.text);
				});
			}},
			{
			text:"鍙栧浘鏍囩殑鏍峰紡",
			handler:function(){
				// 	鑾峰彇鎵�鏈夐�変腑鐨勮妭鐐圭殑鎸囧畾鐨勫睘鎬х殑鍊�
				alert(sp.getSelectNodesAttributes('iconCls'));
				
			}}*/],
			items:[sp]
		});
		selectUserWindow.show();
		}
		else
		{
			selectUserWindow.staffSelectPanel.eachSelectNodes(function(key,node){
					node.ui.toggleCheck(false);
					node.attributes.checked = false;
				});
			selectUserWindow.show();
		}
	}
	

</script>
<script>
	function setSelectUsers(text,value)
	{
		document.getElementById("jieshouren").value = text;
		document.getElementById("jieshourenid").value = value;
		//alert(text);
	}
		function formSubmit(fs)
	{
			document.getElementById("shifouyifasong").value = fs;
			document.form1.submit();
		
		}

	function chkInput()
	{
		if(document.getElementById("jieshouren").value == "")
		{
			alert("璇疯緭鍏ユ敹浠朵汉濮撳悕");
			return false;
			}
		
		return true;
	}
</script>
<style type="text/css">
<!--
.staffs {
        background: url(/govoa/image/staff.gif) left top no-repeat !important;
} 
.dept {
        background: url(/govoa/image/dept.gif) left top no-repeat !important;
} 
-->
</style>

<body>
<form action="" method="post" enctype="multipart/form-data" name="form1" id="form1" >
  <table width="99.2%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" style="margin-left:3px;">
    <tr>
      <td width="15%" align="right" height="28" bgcolor="#DAEFFC">鏍囬锛�/td>
      <td height="20" bgcolor="#FFFFFF"><input name="youjianbiaoti" type="text" id="youjianbiaoti" size="80" />
      									<input name="shifouyifasong" id="shifouyifasong" type="hidden" value="" />
      </td>
    </tr>
    <tr>
      <td align="right" height="28" bgcolor="#DAEFFC">鏀朵欢浜猴細</td>
      <td height="20" bgcolor="#FFFFFF"><input name="jieshouren" type="text" id="jieshouren" size="80" /><a href="javascript:showSelectUserPanel()">閫夋嫨</a>
      								<input name="jieshourenid" type="hidden" value="" />
      								<input name="hidUploadFiles" type="hidden" value="" id="hidUploadFiles" />
      								
      </td>
    </tr>
    <tr>
      <td align="right" height="28" bgcolor="#DAEFFC">涓婁紶闄勪欢锛�&nbsp;</td>
      <td height="20" bgcolor="#FFFFFF"><div class=tuxia>
<iframe marginwidth=0 marginheight=0 bgcolor="#FF0066" src="/govoa/fujian.htm" frameborder=0 width=680  height=140 scrolling="auto"></iframe>
</div ></td>
    </tr>
    <tr>
      <td bgcolor="#DAEFFC">&nbsp;</td>
      <td bgcolor="#FFFFFF">
      <script type="text/javascript">

	

		//alert(1111);

		sToolbar	= "Basic"
		var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
		oFCKeditor.BasePath	= "/govoa/fckeditor/" ;
		
		//if ( sToolbar != null )
		oFCKeditor.ToolbarSet = sToolbar ;
		
		oFCKeditor.Value = '' ;
		oFCKeditor.Create() ;
		</script>
      
      </td>
    </tr>
  </table>
</form>
</body>

<?php $this->_endblock(); ?>
<?php

?>