myinit();
Ext.onReady(function() {
	Ext.QuickTips.init();
	var newFormWin;
	var form1;
	var _jsonReader = new Ext.data.JsonReader( {
		root : 'list',
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
		name : 'password',
		mapping : 'password'
	}]);
	// Store
		var ds = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : '../SsDept/LevelAjaxJsonData.do'
			}),
			//
			reader : _jsonReader
		});
		ds.setDefaultSort('userid', 'desc');

		// ColumnModels
		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
			id : 'userid',
			header : '序号',
			dataIndex : 'userid',
			width : 40
		}, {
			header : "级别名称",
			dataIndex : 'username',
			width : 50,
			sortable : true,
			locked : false
		}, {
			header : "描述",
			dataIndex : 'password',
			width : 100
		}]);
		// by default columns are sortable
		cm.defaultSortable = true;

		var grid = new Ext.grid.GridPanel( {
			// var grid = new Ext.grid.EditorGridPanel( {
			collapsible : true,// 是否可以展开
			animCollapse : false,// 展开时是否有动画效果
			clicksToEdit : 4,
			title : '级别管理',
			iconCls : 'icon-grid',
			store : ds,
			cm : cm,
			renderTo : 'topic-grid',

			viewConfig : {
				forceFit : true
			},
			/*
			 * // 添加内陷的按钮 buttons : [ { text : '保存' }, { text : '取消' }],
			 * buttonAlign : 'center',// 按钮对齐
			 * 
			 */
			// 添加分页工具栏
			bbar : new Ext.PagingToolbar( {
				pageSize : 30,
				store : ds,
				displayInfo : true,
				displayMsg : '显示 {0}-{1}条 / 共 {2} 条',
				emptyMsg : "无数据。",
				items : ['-', {
					pressed : true,
					enableToggle : true,
					text : '按钮',
					cls : 'x-btn-text-icon details',
					toggleHandler : ptb_bt1
				}]
			}),
			// 添加内陷的工具条
			tbar : [ {
				id : 'New1',
				text : ' 新建  ',
				tooltip : '新建一个表单',
				iconCls : 'add',
				handler : function() {
					ptb_bt1();
				}
			}, '-', {
				text : '修改',
				tooltip : '修改',
				iconCls : 'edit',
				handler : function() {
					ptb_bt2();
				}
			}, '-', {
				text : '删除',
				tooltip : '删除被选择的内容',
				iconCls : 'remove',
				handler : function() {
					ptb_bt3();
				}
			}],
			width : 700,
			height : 400,
			frame : true,
			loadMask : true,// 载入遮罩动画
			autoShow : true
		});

		ds.load( {
			params : {
				start : 0,
				limit : 30,
				forumId : 4
			}
		});
		grid.render();
		grid.on("rowdblclick", function(grid) {
			loadFormData(grid);
		});
		// 载入被选择的数据行的表单数据
		var loadFormData = function(grid) {
			var _record = grid.getSelectionModel().getSelected();
			if (!_record) {
				Ext.example.msg('修改操作', '请选择要修改的一项！');
			} else {
				myFormWin();
				form1.form.load( {
					url : '../SsDept/LoadLevel.do?ssUser.userid='
							+ _record.get('userid'),
					waitMsg : '正在载入数据...',

					failure : function() {
						Ext.example.msg('编辑', '载入失败');
					},
					success : function() {
						Ext.example.msg('编辑', '载入成功！');
					}
				});
			}
		}
		// 分页工具栏按钮--新建事件
		var ptb_bt1 = function() {
			myFormWin();
		};
		// 修改事件
		var ptb_bt2 = function() {

			loadFormData(grid);

		};
		// 删除事件
		var ptb_bt3 = function() {

			var _record = grid.getSelectionModel().getSelected();
			if (_record) {
				Ext.MessageBox.confirm('确认删除', '你确认要删除这条数据吗？', function(btn) {
					if (btn == "yes") {
						var m = grid.getSelections();
						var jsonData = "";
						for (var i = 0, len = m.length;i < len; i++) {
							var ss = m[i].get("userid");
							if (i == 0) {
								jsonData = jsonData + ss;
							} else {
								jsonData = jsonData + "," + ss;
							}
							ds.remove(m[i]);
						}
						ds.load( {
							params : {
								start : 0,
								limit : 30,
								delData : jsonData
							}
						});

						// Ext.example.msg('---删除操作---', '你删除的数据是');
					}
				});
			} else {
				Ext.example.msg('删除操作', '请选择要删除的数据项！');
			}
		};

		// form_win

		var myFormWin = function() {
			// create the window on the first click and reuse on subsequent
			// clicks

			if (!newFormWin) {
				newFormWin = new Ext.Window( {
					el : 'topic-win',
					layout : 'fit',
					width : 400,
					height : 300,
					closeAction : 'hide',
					plain : true,
					title : '窗口',
					items : form1

				});
			}
			newFormWin.show('New1');
		}
		var _jsonFormReader = new Ext.data.JsonReader( {
			root : 'list',
			totalProperty : 'totalCount',
			id : 'userid',
			successProperty : '@success'
		}, [ {
			name : 'ssUser.userid',
			mapping : 'userid',
			type : 'int'
		}, {
			name : 'ssUser.username',
			mapping : 'username'
		}, {
			name : 'ssUser.password',
			mapping : 'password'
		}]);

		// {success:false,errors:{CompanyID:"公司代碼不存在", CompanyName:"公司名稱重複"}}
		form1 = new Ext.FormPanel( {
			// collapsible : true,// 是否可以展开
			labelWidth : 75, // label settings here cascade unless overridden
			url : '../SsDept/AddLevel.do',
			frame : true,
			title : '添加级别',
			bodyStyle : 'padding:5px 5px 0',
			width : 350,
			waitMsgTarget : true,
			reader : _jsonFormReader,
			defaults : {
				width : 230
			},
			defaultType : 'textfield',
			items : [ {
				fieldLabel : '级别ID',
				name : 'ssUser.userid',
				allowBlank : false
			}, {
				fieldLabel : '级别名称',
				name : 'ssUser.username',
				allowBlank : false
			}, new Ext.form.TextArea( {
				fieldLabel : '描述',
				name : 'ssUser.password',
				growMin : 234
			})],

			buttons : [ {
				text : '保存',
				disabled : false,
				handler : function() {
					if (form1.form.isValid()) {
						form1.form.submit( {
							url : '../SsDept/AddLevel.do',
							success : function(from, action) {
								Ext.example.msg('保存成功', '添加级别成功！');
								ds.load( {
									params : {
										start : 0,
										limit : 30,
										forumId : 4
									}
								});
							},
							failure : function(form, action) {
								Ext.example.msg('保存失败', '添加级别失败！');
							},
							waitMsg : '正在保存数据，稍后...'
						});
						dialog.hide();
					} else {
						Ext.Msg.alert('信息', '请填写完成再提交!');
					}
				}
			}, {
				text : '取消',
				handler : function() {
					newFormWin.hide();
				}
			}]
		});
	});
