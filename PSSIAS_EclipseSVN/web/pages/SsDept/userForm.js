var userForm = function(_title,_userId) {
	//var fp = this.setup(_title,_userId);
	var window = new Ext.Window( {
		id : 'userFormWin',
		title : '用户信息',
		width : 815,
		height : '100%',
		//autoHeight : true,
		modal : true,
		plain : true,
		bodyStyle : 'padding:5px;',
		buttonAlign : 'center',
		items : [this.setup(_title,_userId) ]
	});
	window.show();
};


 

userForm.prototype.setup = function(_title,userId) {
	var _url = '../SsDept/getTrees.do';
	var depSelector = new TreeSelector4User('depTreeSelector', _url, '所属部门','deptid');//使用ss_dept用这个
	//var depSelector = new TreeSelector4Hotel('depTreeSelector', _url, '所属部门','deptid');
	var footToolbar = this.initFooterToolbar(userId);
	var userform = new Ext.form.FormPanel({
				id : 'userForm',
				//title : _title,
				closable : true,
				iconCls:'menu-customer',
				border : false, // 不要边框
				fileUpload : true, // 允许上传
				bodyStyle : "margin-top:0px;margin-left: 0%; background-color: transparent;",
				labelAlign : "right",
				layout : 'table',
				height : 425,
				autoScroll:true,
				tbar : footToolbar,
				defaultType : "textfield",
				layoutConfig:{columns:3},
				url :   '../SsUser/extjssave.do',
				reader : new Ext.data.JsonReader({
							root : 'data'
						}, [{
									name : 'userid',
									mapping : 'userid'
								}, {
									name : 'username',
									mapping : 'username'
								}, {
									name : 'password',
									mapping : 'password'
								}, {
									name : 'fullname',
									mapping : 'fullname'
								}, {
									name : 'emailaddress',
									mapping : 'emailaddress'
								}, 
								{
									name : 'description',
									mapping : 'description'
								},
								 {
									name : 'expirationdate',
									mapping : 'expirationdate'
								}, {
									name : 'ssUserenabled',
									mapping : 'enabled'
								},

								{
									name : 'ssUserSex',
									mapping : 'sex'
								}, {
									name : 'sfzh',
									mapping : 'sfzh'
								}, {
									name : 'phone',
									mapping : 'phone'
								}, {
									name : 'mobile',
									mapping : 'mobile'
								}, {
									name : 'fax',
									mapping : 'fax'
								}, {
									name : 'address',
									mapping : 'address'
								}, {
									name : 'zip',
									mapping : 'zip'
								},
								{
									name : 'photo',
									mapping : 'photo'
								}]),
				items : [{
					id:'displayUserPhoto',
					xtype : "panel",
					width : 220,
					rowspan:2,
					height : 395,
					title : "个人照片",
					html : '<img src="../../images/default_image_male.jpg"/>',
					tbar : new Ext.Toolbar({
								width : '100%',
								height : 25,
								items : [{
											text : '上传',
											iconCls : 'btn-upload',
											handler : function() {
												var photo = Ext.getCmp('photo');
												var dialog = createUploadDialog({
																file_cat : 'system/appUser',
																callback : uploadUserPhoto,
																permitted_extensions:['jpg']
															});
												if(photo.value != '' && photo.value !=null && photo.value !='undefined'){
													var msg = '再次上传需要先删除原有图片,';
													Ext.Msg.confirm('信息确认', msg+'是否删除？', function(btn) {
														if (btn == 'yes') {
															//删除图片
															Ext.Ajax.request({
																url:'../FileAttach/deleteUserPhoto.do',
																method:'post',
																params:{filePath:photo.value},
																success:function(response){
																var data = Ext.util.JSON.decode(response.responseText);
							                                    if (data.success == true){
																	if(userId != '' && userId !=null && userId !='undefined'){
																		Ext.Ajax.request({
																			url:  '../SsUser/photo.do',
																			method:'post',
																			params:{userId:userId},
																			success:function(){
																				photo.setValue('');
																				var ssUserSex = Ext.getCmp('ssUserSex');
																				var display = Ext.getCmp('displayUserPhoto');
																				if(ssUserSex.value ==1){
																					display.body.update('<img src="../../images/default_image_male.jpg" />');
																				}else{
																					display.body.update('<img src="../../images/default_image_female.jpg" />');
																				}
																				dialog.show('queryBtn');
																			}
																		});
																	}else{
																		photo.setValue('');
																		var ssUserSex = Ext.getCmp('ssUserSex');
																		var display = Ext.getCmp('displayUserPhoto');
																		if(ssUserSex.value ==1){
																			display.body.update('<img src="../../images/default_image_male.jpg" />');
																		}else{
																			display.body.update('<img src="../../images/default_image_female.jpg" />');
																		}
																		dialog.show('queryBtn');
																	}
																}
															  }
															});
														}
													})
												}else{
													dialog.show('queryBtn');
												}
											}
										}, {
											text : '删除',
											iconCls : 'btn-delete',
											handler : function() {
												var photo = Ext.getCmp('photo');
												if(photo.value != null && photo.value !='' && photo.value !='undefined'){
													var msg = '照片一旦删除将不可恢复,';
													Ext.Msg.confirm('确认信息',msg+'是否删除?',function(btn){
														if(btn == 'yes'){
															Ext.Ajax.request({
															    url:'../FileAttach/deleteUserPhoto.do',
																method:'post',
																params:{filePath:photo.value},
																success:function(response){
																var data = Ext.util.JSON.decode(response.responseText);
							                                    if (data.success == true){
																	if(userId != '' && userId !=null && userId !='undefined'){
																			Ext.Ajax.request({
																			url: '../SsUser/photo.do',
																			method:'post',
																			params:{userId:userId},
																			success:function(){
																					photo.setValue('');
																					var ssUserSex = Ext.getCmp('ssUserSex');
																					var display = Ext.getCmp('displayUserPhoto');
																					if(ssUserSex.value ==1){
																						display.body.update('<img src="../../images/default_image_male.jpg" />');
																					}else{
																						display.body.update('<img src="../../images/default_image_female.jpg" />');
																					}
																				}
																			});
																	}else{
																		photo.setValue('');
																		var ssUserSex = Ext.getCmp('ssUserSex');
																		var display = Ext.getCmp('displayUserPhoto');
																		if(ssUserSex.value ==1){
																			display.body.update('<img src="../../images/default_image_male.jpg" />');
																		}else{
																			display.body.update('<img src="../../images/default_image_female.jpg" />');
																		}
																	}
																  }
																}
															});
														}
													});
												}// end if
												else{
													Ext.Msg.alert('提示信息','您还未增加照片.');
												}
												
											}
										}]
							})
				}, {
					xtype : "panel",
					id:'AppUserMustInfo',
					width : 295,
					height : 240,
					title : "基本信息(必填)",
					layout : 'form',
					defaultType : "textfield",
					defaults : {
						width : 230
					},
					labelWidth : 55,
					labelAlign : "right",
					hideLabels : false,
					items : [{
								xtype : 'hidden',
								fieldLabel : '用户ID',
								name : 'userid',
								id : 'userid'
							}, {
								fieldLabel : '用户名',
								name : 'username',
								id : 'username',
								allowBlank: false,
								minLength : 4,
								maxLength : 25
							}, {
								fieldLabel : '密码',
								name : 'password',
								id : 'password',
								inputType : "password",// 密码框 
								allowBlank: false,
								minLength : 6,
								maxLength : 25
							}, {
								fieldLabel : '姓名',
								name : 'fullname',
								id : 'fullname',
								allowBlank: false,
								minLength : 1,
								maxLength : 25
							}, {
								fieldLabel : 'E-mail',
								name : 'emailaddress',
								id : 'emailaddress',
								vtype : 'email',
								vtypeText : '邮箱格式不正确!',
								minLength : 1,
								maxLength : 100
							}, {
								fieldLabel : '描述',
								name : 'description',
								id : 'description',
								minLength : 1,
								maxLength : 100
							},

							depSelector,// 所属部门
							{
								fieldLabel : '有效期',
								xtype : 'datefield',
								readOnly : true,
								format : 'Y-m-d',
								name : 'expirationdate',
								id : 'expirationdate',
								allowBlank: false,
								minValue : new Date(),//允许选择的最小日期    
				                maxValue :'12/31/2099',//允许选择的最大日期      
								length : 80
							}, {
								fieldLabel : '状态',
								id : 'ssUserenabled',
								hiddenName : 'enabled',
								xtype : 'combo',
								mode : 'local',
								editable : false,
								allowBlank: false,
								triggerAction : 'all',
								store : [['1', '可用'], ['0', '禁用']],
								value : 1
							}, {
								xtype : 'hidden',
								name : 'deptid',
								id : 'deptid',
								allowBlank: false
							}]
				}, {
					xtype : "panel",
					width : 265,
					height : 240,
					title : "扩展信息(选填)",
					layout : 'form',
					defaultType : 'textfield',
					labelWidth : 55,
					defaults : {
						width : 163
					},
					hideLabel : false,
					items : [{
								fieldLabel : '性别',
								xtype : 'combo',
								hiddenName : 'sex',
								id : 'ssUserSex',
								mode : 'local',
								editable : false,
								triggerAction : 'all',
								store : [['1', '男'], ['0','女']],
								value : '1',
								listeners:{
									select:function(combo, record,index){
										  var photo = Ext.getCmp('photo');
										  if(photo.value =='' || photo.value == 'undefined' || photo.value ==null){
											  var display = Ext.getCmp('displayUserPhoto');
										      if(combo.value == '0'){
										      	display.body.update('<img src="../../images/default_image_female.jpg" />');
										      }else{
										      	display.body.update('<img src="../../images/default_image_male.jpg" />');
										      }
										  }
									}
								}
							}, {
								fieldLabel : '身份证号',
								name : 'sfzh',
								id : 'sfzh',
								maxLength : 18
							}, {
								fieldLabel : '家庭电话',
								xtype : 'numberfield',
								name : 'phone',
								id : 'phone',
								maxLength : 15
							}, {
								fieldLabel : '移动电话',
								xtype : 'numberfield',
								name : 'mobile',
								id : 'mobile',
								maxLength : 15
							}, {
								fieldLabel : '传真',
								xtype : 'numberfield',
								name : 'fax',
								id : 'fax',
								maxLength : 15
							}, {
								fieldLabel : '家庭住址',
								name : 'address',
								id : 'address',
								maxLength : 32
							}, {
								fieldLabel : '邮编',
								xtype : 'numberfield',
								name : 'zip',
								id : 'zip',
								maxLength : 16
							},{
								filedLabel:'照片',
								xtype:'hidden',
								id:'photo',
								name:'photo'
							}]
				}, {
				id:'userroleid',
			xtype : "panel",
			title:'用户角色',
			width : 560,
			height : '100%',
			colspan : 2,
			items : [{
				xtype : 'itemselector',
				id:'AppUserRoles',
				name : 'AppUserRoles',
				toLegend : '已选栏',
                fromLegend : '可选栏',
				fromLegend : '',
				imagePath : '../../widgets/ux/images/',
				multiselects : [{
							id:'chooseRoles',
							title:'可选角色',
							width : 247,
							height : 110,
							//SimpleStore 有可能 在Ext 3.0 以后的版本 换成 ArrayStore,更新版本时请注意
							store : new Ext.data.SimpleStore({
								autoLoad :true,
								baseParams :{userId:userId},
								url:'../SsUser/chooseRoles.do',
								fields:['roleId','roleName']
							}),
							displayField : 'roleName',
							valueField : 'roleId'
						}, {
							id:'selectedRoles',
							name:'selectedRoles',
							title:'已有角色',
							width : 247,
							height : 110,
							store : new Ext.data.SimpleStore({
								autoLoad :true,
								baseParams :{userId:userId},
								url:'../SsUser/selectedRoles.do',
								fields:['roleId','roleName']
							}),
							tbar : [{
								text : '清除所选',
								handler : function() {
									Ext.getCmp('AppUserForm').getForm().findField('AppUserRoles').reset();
								}
							}],
							displayField : 'roleName',
							valueField : 'roleId'
						}]

			}]

		}]
	});
	return userform;
};
// 初始化操作菜单
userForm.prototype.initFooterToolbar = function(userId) {

	var toolbar = new Ext.Toolbar({
				id:'AppUserFormToolbar',
				width : '100%',
				height : 25,
				items : [{
					text : '保存',
					iconCls:'btn-save',
					handler : function() {
						var userform = Ext.getCmp('userForm');
						if (userform.getForm().isValid()) {
						userform.getForm().submit({
									waitMsg : '正在提交用户信息',
									success : function(userform, action) {
										Ext.MessageBox.alert('警告',action.result.msg);
										var userwin = Ext.getCmp('userFormWin');
										userwin.close();
										var userview = Ext.getCmp('AppUserGrid');
										if (userview != null) {//假如员工列表不为空,则重载数据
											userview.getStore().reload({
														start : 0,
														limit : 25
													});
										}
									},
									failure:function(form,action){
									
									  Ext.MessageBox.alert('警告','保存失败！');
									
	                                }
									
								});
						  }
					}

				}, {
					text : '取消',
					iconCls:'reset',
					handler : function() {
						var userFormWins = Ext.getCmp('userFormWin');
					    userFormWins.close();
						
					}
				},{
					text: '修改密码',
					id:'resetPassword',
					iconCls:'btn-password',
					hidden:true,
					handler : function(){
						new resetPassword(userId);
					}
				}]
			});
	return toolbar;
};
/**
 * 上传照片
 * @param {} data
 */
function uploadUserPhoto(data){
	var photo = Ext.getCmp('photo');
	var display = Ext.getCmp('displayUserPhoto');
	if(data == "")
	{
	   alert("请先上传文件！");
	} else {
	    photo.setValue(data[0].filepath);
	    display.body.update('<img src="../../userFiles/'+data[0].filepath+'"  width="100%" height="100%"/>');
	}
};


















/**
 * 修改密码
 */
function resetPassword(userId){
	var formPanel = new Ext.FormPanel({
				url :  '../SsUser/resetPassword.do',
				layout : 'form',
				id:'setPasswordForm',
				frame : true,
				defaults : {
					widht : 400,
					anchor : '100%,100%'
				},
	        	defaultType : 'textfield',
				items : [{
							name : 'appUserUserId',
							id : 'appUserUserId',
							xtype:'hidden',
							value : userId
						}, {
							fieldLabel : '旧密码',
							name : 'oldPassword',
							id : 'oldPassword',
							inputType : 'password'
						}, {
							fieldLabel : '新密码',
							name : 'newPassword',
							id : 'newPassword',
							inputType : 'password'
						}, {
							fieldLabel : '再输入',
							name : 'againPassword',
							id : 'againPassword',
							inputType : 'password'
						}]
			});
			
	var setPassword = new Ext.Window({
		title:'修改密码',
		width : 300,
		height : 175,
		modal: true,
		layout : 'anchor',
		bodyStyle : 'padding:5px;',
		buttonAlign : 'center',
		items:[formPanel],
		buttons : [{
					text : '保存',
					handler : function() {
						var fp=Ext.getCmp('setPasswordForm');
						if (fp.getForm().isValid()) {
							fp.getForm().submit({
										method: 'post',
										waitMsg : '正在提交数据...',
										success : function(fp,action) {
											Ext.Msg.alert('操作信息', '密码修改成功！');
											setPassword.close();
										},
										failure : function(fp,action) {
											Ext.Msg.alert('错误提示',action.result.msg);
											Ext.getCmp('setPasswordForm').getForm().reset();
										}
							});
						}
					}
				}, {
					text : '取消',
					handler : function() {
						setPassword.close();
					}
				}]
			});
	setPassword.show();

}


/**
 * 创建上传的对话框
 * @param {} config
 * @return {}
 */
createUploadDialog=function(config){
	var defaultConfig={
		file_cat:'others',
		url:'../FileAttach/upload.do',
		reset_on_hide: false,
		upload_autostart:false,
		modal : true
	};
	Ext.apply(defaultConfig,config);			
	var	dialog = new Ext.ux.UploadDialog.Dialog(defaultConfig);
	return dialog;
};

