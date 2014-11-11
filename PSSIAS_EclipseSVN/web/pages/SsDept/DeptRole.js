var DeptRoleForm = function(_title,_deptId) {
	//var fp = this.setup(_title,_deptId);
	var window = new Ext.Window( {
		id : 'deptRoleFormWin',
		title : '部门角色信息',
		width : 550,
		height : 490,
		//autoHeight : true,
		modal : true,
		plain : true,
		bodyStyle : 'padding:5px;',
		buttonAlign : 'center',
		items : [this.setup(_title,_deptId) ]
	});
	
	window.show();
};


DeptRoleForm.prototype.setup = function(_title,deptId) {
	var footToolbar = this.initFooterToolbar(deptId);
	var userform = new Ext.form.FormPanel({
				id : 'deptRoleForm',
				//title : _title,
				closable : true,
				iconCls:'menu-customer',
				border : false, // 不要边框
				fileUpload : true, // 允许上传
				autoScroll : true,
				bodyStyle : "margin-top:5px;margin-left: 4%; background-color: transparent;",
				labelAlign : "right",
				layout : 'table',
				autoScroll : true,
				tbar : footToolbar,
				defaultType : "textfield",
				url :   '../SsDept/saveDeptRole.do?deptId='+deptId,
				items : [{
				id:'userroleid',
			xtype : "panel",
			title:'部门角色',
			width : 560,
			height : 320,
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
							height : 310,
							//SimpleStore 有可能 在Ext 3.0 以后的版本 换成 ArrayStore,更新版本时请注意
							store : new Ext.data.SimpleStore({
								autoLoad :true,
								baseParams :{deptId:deptId},
								url:'../SsDept/chooseRoles.do',
								fields:['roleId','roleName']
							}),
							displayField : 'roleName',
							valueField : 'roleId'
						}, {
							id:'selectedRoles',
							name:'selectedRoles',
							title:'已有角色',
							width : 247,
							height : 310,
							store : new Ext.data.SimpleStore({
								autoLoad :true,
								baseParams :{deptId:deptId},
								url:'../SsDept/selectedRoles.do',
								fields:['roleId','roleName']
							}),
							tbar : [{
								text : '清除所选',
								handler : function() {
									Ext.getCmp('DeptRoleForm').getForm().findField('AppUserRoles').reset();
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
DeptRoleForm.prototype.initFooterToolbar = function(deptId) {

	var toolbar = new Ext.Toolbar({
				id:'DeptRoleFormToolbar',
				width : '100%',
				height : 25,
				items : [{
					text : '保存',
					iconCls:'btn-save',
					handler : function() {
						var userform = Ext.getCmp('deptRoleForm');
						
						userform.getForm().submit({
									waitMsg : '正在提交用户信息',
									success : function(userform, action) {
										Ext.MessageBox.alert('警告',action.result.msg);
										
									
									},
									failure:function(form,action){
									
									  Ext.MessageBox.alert('警告','保存失败！');
									
	                                }
									
								});
							
					}

				}, {
					text : '取消',
					iconCls:'reset',
					handler : function() {
						var deptRoleFormWins = Ext.getCmp('deptRoleFormWin');
					    deptRoleFormWins.close();
						
					}
				}]
			});
	return toolbar;
};























