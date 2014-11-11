Ext.ns('AppUserViewHotel');
/**
 * 员工列表
 * 
 * @return {}
 */
var AppUserViewHotel = function() {
	return this.getView();
};
/**
 * AppUserViewzazh.getView()
 * @return {}
 */
AppUserViewzazh.prototype.getView = function() {
	return new Ext.Panel({
		id : 'AppUserViewHotel',
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
									url : '../SsUser/extjslist4zazh.do?start=0&limit=10',
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
AppUserViewzazh.prototype.setup = function() {
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
				}, {
					header : "用户名",
					dataIndex : 'username',
					width : 60
				}, {
					header : "姓名",
					dataIndex : 'fullname',
					width : 60
				}, {
					header : "邮箱",
					dataIndex : 'emailaddress',
					width : 120
				},
				 {
					header : "日期",
					dataIndex : 'createdate',
					width : 100
				}, {
					header : "状态",
					dataIndex : 'enabled',
					width : 50,
					renderer : function(value) {
						return value == '0' ? "禁用" : "激活";
					}
				}, {
					header : '管理',
					dataIndex : 'userid',
					sortable:false,
					width : 100,
					renderer : function(value, metadata, record, rowIndex,
							colIndex) {
						var editId = record.data.userid;
						var editName = record.data.username;
							
						var str = '<button title="删除" value=" " class="btn-del" onclick="AppUserViewzazh.remove('
								+ editId + ')"></button>';
								
						 str+='&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="AppUserViewzazh.edit('
								+ editId + ',\'' + editName + '\')"></button>';
						return str;
					}
				}],
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
				tbar : toolbar,
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
							pageSize : 25,
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
		//			AppUserViewzazh.edit(rec.data.userId, rec.data.username);
		//		});
	//}

	return grid;
};


AppUserViewzazh.prototype.initData = function() {

  	var _jsonReader = new Ext.data.JsonReader( {
		root : 'result',
		totalProperty : 'totalCount',
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
		name : 'createdate',
		mapping : 'createdate'
	},{
       name : 'enabled',
       type : 'int'
	 }]);

  var store = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : '../SsUser/extjslist4zazh.do'
			}),
			//
			reader : _jsonReader
		});

    store.setDefaultSort('userid', 'userid');  
  
    return store;
};



// 初始化操作菜单
AppUserViewzazh.prototype.initToolbar = function() {
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
								//Ext.Msg.alert("操作信息", "用户3333333333除失败");
								 new AppUserForm('增加员工');
								//Ext.Msg.alert("操作信息", "用户44444444444除失败");
									//addUser = new AppUserForm('增加员工');
									//tabs.add(addUser);
									
                                   // this.formPanel.getForm().reset();
                                    
								} else {
								new AppUserForm('增加员工');
									//tabs.remove(addUser)
									// addUser.setTitle('增加员工');
									// addUser.form.reset();
									//addUser = new AppUserForm('增加员工');
									//tabs.add(addUser);
								}
								//tabs.activate(addUser);
							}
						}]
			});
	return toolbar;
};


/**
 * 用户删除
 * 
 * @param {}
 *            userId
 */
AppUserViewzazh.remove = function(userId) {
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
AppUserViewzazh.edit = function(userId, username) {
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
				url : '../../pages/SsUser/get4zazh.do',
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

