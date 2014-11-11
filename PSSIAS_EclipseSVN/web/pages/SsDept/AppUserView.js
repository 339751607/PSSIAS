Ext.ns('AppUserView');
/**
 * 员工列表
 * 
 * @return {}
 */
var AppUserView = function() {
	return this.getView();
};
/**
 * AppUserView.getView()
 * @return {}
 */
AppUserView.prototype.getView = function() {
	return new Ext.Panel({
		id : 'AppUserView',
		// region:'center',
		title : '用户信息',
		iconCls:'menu-appuser',
		autoScroll : true,
		items : [new Ext.FormPanel({
			height : 35,
			frame : true,
			id : 'AppUserSearchForm',
			layout : 'column',
			defaults : {
				xtype : 'label'
			},
			items : [{
						text : '查询条件:'
					}, {
						text : '用户名'
					}, {
						width : 80,
						xtype : 'textfield',
						name : 's_username'
					}, {
						text : '用户姓名'
					}, {
						width : 80,
						xtype : 'textfield',
						name : 's_fullname'
					},
					{
						xtype : 'button',
						text : '查询',
						iconCls : 'search',
						handler : function() {
							var appUserSearchForm = Ext.getCmp('AppUserSearchForm');
							var grid = Ext.getCmp('AppUserGrid');
							if (appUserSearchForm.getForm().isValid()) {
								appUserSearchForm.getForm().submit({
									waitMsg : '正在提交查询',
									url : '../SsUser/extjslist.do?start=0&limit=10',
									success : function(formPanel, action) {
										var result = Ext.util.JSON.decode(action.response.responseText);
										
										grid.getStore().loadData(result);
									}
								});
							}

						}
					}]
		}), this.setup()]
	});
	return
};
/**
 * 这个方法是AppUserGrid
 * @return {}
 */
AppUserView.prototype.setup = function() {
	var store = this.initData();
	var toolbar = this.initToolbar();
	// var topbar=this.initTopToolbar();
	store.load({
				params : {
					start : 0,
					limit : 10
				}
			});
	var sm = new Ext.grid.CheckboxSelectionModel();
	var cm = new Ext.grid.ColumnModel({
		columns : [sm, new Ext.grid.RowNumberer(), {
					header : "userid",
					dataIndex : 'userid',
					hidden : true
				},				
				{
					header : "用户名",
					dataIndex : 'username',
					width : 60
				},
				{
					header : "所属机构",
					dataIndex : 'deptname',
					width : 60
				},
				{
					header : "姓名",
					dataIndex : 'fullname',
					width : 60
				}, {
				
					header : "描述",
					dataIndex : 'description',
					width : 60
				},
				
				{
					header : "邮箱",
					dataIndex : 'emailaddress',
					width : 120
				},
				 {
					header : "有效期",
					dataIndex : 'expirationdate',
					width : 100
				}, {
					header : "状态",
					dataIndex : 'enabled',
					width : 50,
					renderer : function(value) {
						return value == '0' ? "禁用" : "可用";
					}
				}
				//, {
				//	header : '管理',
				//	dataIndex : 'userid',
				//	sortable:false,
				//	width : 100,
				//	renderer : function(value, metadata, record, rowIndex,
				//			colIndex) {
				//		var editId = record.data.userid;
				//		var editName = record.data.username;
				//		var str = '<button title="重置密码" value=" " class="btn-pass" onclick="AppUserView.update('
				//				+ editId + ')"></button>';
				//				
				//		 str+='&nbsp;&nbsp;&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="AppUserView.edit('
				//				+ editId + ',\'' + editName + '\')"></button>';
				//		return str;
				//	}
				//}
				],
		defaults : {
			sortable : true,
			menuDisabled : true,
			width : 100
		},
		listeners : {
			hiddenchange : function(cm, colIndex, hidden) {
				saveConfig(colIndex, hidden);
			}
		}
	});

	var grid = new Ext.grid.GridPanel({
				id : 'AppUserGrid',
				// title:'员工基本信息',
				//tbar : toolbar,   //注释掉用户的工具条： 隐掉添加，个人信息按钮
				store : store,
				autoHeight:true,
				shim : true,
				trackMouseOver : true,
				disableSelection : false,
				loadMask : true,
				cm : cm,
				sm : sm,
				// customize view config
				viewConfig : {
					forceFit : true,
					enableRowBody : false,
					showPreview : false
				},

				// paging bar on the bottom
				bbar : new Ext.PagingToolbar({
							pageSize : 10,
							store : store,
							displayInfo : true,
							displayMsg : '当前显示从{0}至{1}， 共{2}条记录',
							emptyMsg : "当前没有记录"
						})
			});

	// 为Grid增加双击事件,双击行可编辑
	//grid.addListener('rowdblclick', rowdblclickFn);
	//function rowdblclickFn(grid, rowindex, e) {
	//	grid.getSelectionModel().each(function(rec) {
		//            Ext.Msg.alert("操作信息", rec.data.userId);
		//			AppUserView.edit(rec.data.userId, rec.data.username);
		//		});
	//}

	return grid;
};


AppUserView.prototype.initData = function() {

  	var _jsonReader = new Ext.data.JsonReader( {
		root : 'result',
		totalProperty : 'totalCounts',
		id : 'userid',
		successProperty : '@success'
	}, [ {
		name : 'userid',
		mapping : 'userid',
		type : 'int'
	}, {
		name : 'username',
		mapping : 'username'
	}, {
		name : 'deptname',
		mapping : 'deptname'
	}, {
		name : 'fullname',
		mapping : 'fullname'
	}, {
		name : 'emailaddress',
		mapping : 'emailaddress'
	}, {
		name : 'deptid',
		mapping : 'deptid'
	}, {
		name : 'sex',
		mapping : 'sex',
		type : 'int'
	}, {
		name : 'sfzh',
		mapping : 'sfzh'
	}, {
		name : 'expirationdate',
		mapping : 'expirationdate'
	},{
       name : 'enabled',
       type : 'int'
	 },{
       name : 'description',
       mapping : 'description'
	 }]);

  var store = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : '../SsUser/extjslist.do'
			}),
			//
			reader : _jsonReader
		});

    store.setDefaultSort('userid', 'userid');  
  
    return store;
};



// 初始化操作菜单
AppUserView.prototype.initToolbar = function() {
	var toolbar = new Ext.Toolbar({
				width : '100%',
				height : 30,
				items : [{
							text : '添加',
							iconCls : 'add-user',
							handler : function() {
								//var tabs = Ext.getCmp('centerTabPanel');
								var addUser = Ext.getCmp('AppUserForm');
								if (addUser == null) {
								new AppUserForm('增加员工');
								Ext.Ajax.request({
									url:'../SsUser/getSessionUser.do',
									method:'post',
									success:function(response,options){
									var data = Ext.util.JSON.decode(response.responseText);
										var da=data.expdate;
										var d = new Date(Date.parse(da.replace(/-/g,"/")));
										Ext.getCmp('AppUserMustInfo').get('expirationdate').maxValue=d;
									},
									failure:function (){
										result=false;
									}
								});	
								//Ext.Msg.alert("操作信息", "用户44444444444除失败");
									//addUser = new AppUserForm('增加员工');
									//tabs.add(addUser);
									
                                   // this.formPanel.getForm().reset();
                                    
								} else {
								new AppUserForm('增加员工');
								Ext.Ajax.request({
									url:'../SsUser/getSessionUser.do',
									method:'post',
									success:function(response,options){
									var data = Ext.util.JSON.decode(response.responseText);
										var da=data.expdate;
										var d = new Date(Date.parse(da.replace(/-/g,"/")));
										Ext.getCmp('AppUserMustInfo').get('expirationdate').maxValue=d;
									},
									failure:function (){
										result=false;
									}
								});	
								
									//tabs.remove(addUser)
									// addUser.setTitle('增加员工');
									// addUser.form.reset();
									//addUser = new AppUserForm('增加员工');
									//tabs.add(addUser);
								}
								//tabs.activate(addUser);
							}
						},{
							text : '个人信息',
							iconCls : 'btn-edit',
							handler : function() {
							    Ext.Ajax.request({
								url:'../SsUser/getSessionUser.do',
								method:'post',
								success:function(response,options){
								var data = Ext.util.JSON.decode(response.responseText);
									AppUserView.edit(data.userid,data.username,data.expdate);
								},
								failure:function (){
									result=false;
								}
								});
							}
						}]
			});
	return toolbar;
};

AppUserView.update = function(userId) {
	Ext.Msg.confirm('重置密码操作', '你确定要重置该用户密码吗?', function(btn) {
				if (btn == 'yes') {
				    
				    
							Ext.Ajax.request({
						url:'../SsUser/extjspassword.do',
						method:'POST',
						params : {
									userId : userId
								},
						success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
								//grid.getStore().remove(record);
								//grid.getView().refresh();
									//Ext.MessageBox.alert('警告success',data.msg);
									// this.getStore().reload();
								Ext.Msg.alert("操作信息", "密码重置成功,重置后的密码为123456");
								var users = Ext.getCmp('AppUserGrid');
    	                        var ds=users.getStore().reload();
									
							}
							else{
								Ext.MessageBox.alert('警告',data.msg);
							}
							
						},failure : function() {
									Ext.Msg.alert("操作信息", "密码重置失败");
									//grid.getStore().reload();
						}
					});
					//grid.getStore().reload();
				}
			});

}


/**
 * 用户删除
 * 
 * @param {}
 *            userId
 */
AppUserView.remove = function(userId) {
	Ext.Msg.confirm('删除操作', '你确定要删除该用户吗?', function(btn) {
				if (btn == 'yes') {
				    
				    
							Ext.Ajax.request({
						url:'../SsUser/extjsremove.do',
						method:'POST',
						params : {
									userId : userId
								},
						success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
								//grid.getStore().remove(record);
								//grid.getView().refresh();
									//Ext.MessageBox.alert('警告success',data.msg);
									// this.getStore().reload();
								Ext.Msg.alert("操作信息", "用户删除成功");
								var users = Ext.getCmp('AppUserGrid');
    	                        var ds=users.getStore().reload();
									
							}
							else{
								Ext.MessageBox.alert('警告',data.msg);
							}
							
						},failure : function() {
									Ext.Msg.alert("操作信息", "用户删除失败");
									//grid.getStore().reload();
						}
					});
					//grid.getStore().reload();
				}
			});

}
/**
 * 用户编辑
 * 
 * @param {}
 *            userId
 */
AppUserView.edit = function(userId, username,expdate) {
	// 只允许有一个编辑窗口
	//var tabs = Ext.getCmp('centerTabPanel');
	var edit = Ext.getCmp('AppUserForm');
	if (edit == null) {
		new AppUserForm(username + '-详细信息', userId);
		edit = Ext.getCmp('AppUserForm');
		//tabs.add(edit);
	} 
	//tabs.activate(edit);
	// 不可显示密码,不能修改账号
	var appUserMustInfo = Ext.getCmp('AppUserMustInfo');
	appUserMustInfo.remove('password');
	Ext.getCmp('username').getEl().dom.readOnly = true;
	//如果是修改本账户信息不能修改有效期
	if(expdate != null){
		var d = new Date(Date.parse(expdate.replace(/-/g,"/")));
		Ext.getCmp('AppUserMustInfo').remove('expirationdate');
	}else{
 		 Ext.Ajax.request({
			url:'../SsUser/getSessionUser.do',
			method:'post',
			success:function(response,options){
			var data = Ext.util.JSON.decode(response.responseText);
				var da=data.expdate;
				var d = new Date(Date.parse(da.replace(/-/g,"/")));
				Ext.getCmp('AppUserMustInfo').get('expirationdate').maxValue=d;
			},
			failure:function (){
				result=false;
			}
		});	
	}
	appUserMustInfo.doLayout(true);
	
	
	
	// 显示修改密码按钮
	var appUserFormToolbar = Ext.getCmp('AppUserFormToolbar');
	Ext.getCmp('resetPassword').show();
	appUserFormToolbar.doLayout(true);
	
	//Ext.Msg.alert('编辑', '载入'+userId);
	// 往编辑窗口中填充新闻数据
	edit.form.load({
				url : '../../pages/SsUser/get.do',
				params : {
					userId : userId
				},
				method : 'post',
				waitMsg : '正在载入数据...',
				success : function(edit, o) {
					// 载入照片
					var photo = Ext.getCmp('photo');
					var display = Ext.getCmp('displayUserPhoto');
					var appUserTitle = Ext.getCmp('ssUserSex');
					if (photo.value != '' && photo.value !=null && photo.value !='undefined') {
						display.body.update('<img src="../../userFiles/' + photo.value + '" width="100%" height="100%"/>');
					}else if(appUserTitle.value == '0'){
						display.body.update('<img src="../../images/default_image_female.jpg" />');
					}
					var user = Ext.util.JSON.decode(o.response.responseText).data[0];
					
					//Ext.Msg.alert('编辑', o.response.responseText);
					// 载入入职时间(DateUtil.js 已经换成 date.js 方法改为改下)
					//var accessionTime = Date.parseString(user.createdate,'yyyy-MM-dd');
					//var createdate = getDateFromFormat(user.createdate,'yyyy-MM-dd HH:mm:ss');
					//Ext.getCmp('ssUser.createdate').setValue(new Date(accessionTime));
					// 载入部门信息
					Ext.getCmp('deptid').setValue(user.dept.deptid);
					Ext.getCmp('depTreeSelector').setValue(user.dept.deptname);
				},
				failure : function() {
					Ext.Msg.alert('编辑', '载入失败');
				}
			});
}
/**
 * 个人信息修改
 * 
 * @param {}
 *            userId
 */
AppUserView.editUser = function(username,userId) {
	// 只允许有一个编辑窗口
	//var tabs = Ext.getCmp('centerTabPanel');
	var edit = Ext.getCmp('AppUserForm');
	if (edit == null) {
		new AppUserForm(username + '-详细信息', userId);
		edit = Ext.getCmp('AppUserForm');
		//tabs.add(edit);
	} 
	//tabs.activate(edit);
	// 不可显示密码,不能修改账号
	var appUserMustInfo = Ext.getCmp('AppUserMustInfo');
	appUserMustInfo.remove('password');
	Ext.getCmp('username').getEl().dom.readOnly = true;
	appUserMustInfo.doLayout(true);
	// 显示修改密码按钮
	var appUserFormToolbar = Ext.getCmp('AppUserFormToolbar');
	Ext.getCmp('resetPassword').show();
	appUserFormToolbar.doLayout(true);
	
	//Ext.Msg.alert('编辑', '载入'+userId);
	// 往编辑窗口中填充新闻数据
	edit.form.load({
				url : '../../pages/SsUser/get.do',
				params : {
					userId : userId
				},
				method : 'post',
				waitMsg : '正在载入数据...',
				success : function(edit, o) {
					// 载入照片
					var photo = Ext.getCmp('photo');
					var display = Ext.getCmp('displayUserPhoto');
					var appUserTitle = Ext.getCmp('ssUserSex');
					if (photo.value != '' && photo.value !=null && photo.value !='undefined') {
						display.body.update('<img src="../../userFiles/' + photo.value + '" width="100%" height="100%"/>');
					}else if(appUserTitle.value == '0'){
						display.body.update('<img src="../../images/default_image_female.jpg" />');
					}
					var user = Ext.util.JSON.decode(o.response.responseText).data[0];
					
					//Ext.Msg.alert('编辑', o.response.responseText);
					// 载入入职时间(DateUtil.js 已经换成 date.js 方法改为改下)
					//var accessionTime = Date.parseString(user.createdate,'yyyy-MM-dd');
					//var createdate = getDateFromFormat(user.createdate,'yyyy-MM-dd HH:mm:ss');
					//Ext.getCmp('ssUser.createdate').setValue(new Date(accessionTime));
					// 载入部门信息
					Ext.getCmp('deptid').setValue(user.dept.deptid);
					Ext.getCmp('depTreeSelector').setValue(user.dept.deptname);
				},
				failure : function() {
					Ext.Msg.alert('编辑', '载入失败');
				}
			});
}


