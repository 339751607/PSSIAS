
Ext.ns('treeDept');
Ext.BLANK_IMAGE_URL = "../../widgets/ext-3.0.0/resources/images/default/s.gif";
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'qtip'; 
Ext.onReady(function(){



    Ext.QuickTips.init();

    // Album toolbar
    var selected;


    //grid end
    
        // 创建一个简写

    var Tree = Ext.tree;

    // 定义根节点的Loader

    var treeloader = new Tree.TreeLoader({

            // dataUrl : 'tree.jsp'//这里可以不需要指定URL，在加载前事件响应里面设置

            });
 

	var treePanel=new Ext.tree.TreePanel({
		region:'west',
		id:'treePanel',
		title:'角色信息',
		collapsible : true,
		split : true,
		autoScroll:true,//自动出现滚动条
		containerScroll: true,
		height:800,
		width:200,
		tbar:new Ext.Toolbar({items:[{
			xtype:'button',
			iconCls:'btn-refresh',
			text:'刷新',
			handler:function(){
				treePanel.root.reload();
			}
		},
		{
			xtype:'button',
			text:'展开',
			iconCls:'btn-expand',
			handler:function(){
				treePanel.expandAll();
			}
		},
		{
			xtype:'button',
			text:'收起',
			iconCls:'btn-collapse',
			handler:function(){
				treePanel.collapseAll();
			}
		}
		]}),
		loader : treeloader,
		rootVisible: true,
		listeners: {
	        'click': treeDept.clickNode
	    }
	});
	
	// 异步加载根节点

    var rootnode = new Tree.AsyncTreeNode({

                id : '0',

                text : '角色信息',

                draggable : false,// 根节点不容许拖动

                expanded : true

            });

 
    // 为tree设置根节点

    treePanel.setRootNode(rootnode);

    // 响应加载前事件，传递node参数

    treePanel.on('beforeload', function(node) {
				
                treePanel.loader.dataUrl = '../SsRole/getTrees.do'; // 定义子节点的Loader

            });
     rootnode.expand(false,false);       

	//状态管理器
	treePanel.on('expandnode', function (node){
	       Ext.state.Manager.set("treestate", node.getPath());
    });


	var  p = new App.RoleGrid();
  	var layout=new Ext.Panel({
		id:'treeDept',
		//title:'部门信息',
		closable:true,
		iconCls:'menu-department',
		layout : 'border',
		height:Ext.get("layout").getHeight(),
		items:[treePanel,{region:'center',width:'100%',items:[p]}]		     
	});

		           
    layout.render('layout');

});
	
var nodeId=0;
treeDept.clickNode=function(node){
    if (node != null) {
    	var roles = Ext.getCmp('role');
    	var ds=roles.getStore();
    	ds.url='../SsRole/findRolesByBussiness.do';
    	ds.baseParams={roleId:node.id};
    	ds.params={start:0,limit:15};
    	ds.reload({params:{start:0,limit:15}});
    	setNodeID(node.id);
    }
};	

function setNodeID(nodeId){
	this.nodeId=nodeId;
}
function getNodeID(){
	return this.nodeId;
}

App.RoleGrid = Ext.extend(Ext.lingo.JsonGrid, {
    id: 'role',
    urlPagedQuery: "../SsRole/findRolesByBussiness.do",
    urlLoadData: "../SsRole/loadData.do",
    urlSave: "../SsRole/extjssave.do",
    urlRemove: "../SsRole/remove.do",
    dlgWidth: 500,
    dlgHeight: 240,
    formConfig: [
        {fieldLabel: '编号',    name: 'id',xtype:'hidden',mapping: 'roleid',readOnly: true,hideGrid: true},
        {fieldLabel: '父亲节点',    name: 'parentid',xtype:'hidden',mapping: 'parentid',readOnly: true,hideGrid: true},
        //{fieldLabel: 'seq',    name: 'roleseq',xtype:'hidden',mapping: 'roleseq',readOnly: true,hideGrid: true},
        {fieldLabel: '等级',    name: 'rolelevel',xtype:'hidden',mapping: 'rolelevel',readOnly: true,hideGrid: true},
        {fieldLabel: '行业',    name: 'businesscode',xtype:'hidden',mapping: 'roleid',readOnly: true,hideGrid: true},
        {fieldLabel: '角色名称*', name: 'rolename',minLength :6,maxLength : 25,allowBlank: false,regex : /^(ROLE_)[a-zA-Z0-9_]+$/,regexText:'请以ROLE_开头,以字母数字结尾!'},
        {fieldLabel: '角色描述*', name: 'roledesc',minLength :2,maxLength : 100,allowBlank: false}
       
    ],
    buildToolbar: function() {
        //
        var checkItems = new Array();
        for (var i = 0; i < this.formConfig.length; i++) {
            var meta = this.formConfig[i];
            if (meta.showInGrid === false) {
                continue;
            }
            var item = new Ext.menu.CheckItem({
                text         : meta.fieldLabel,
                value        : meta.name,
                checked      : true,
                group        : "filter",
                checkHandler : this.onItemCheck.createDelegate(this)
            });
            checkItems[checkItems.length] = item;
        }

        this.filterButton = new Ext.Toolbar.MenuButton({
            iconCls  : "refresh",
            text     : this.formConfig[0].fieldLabel,
            tooltip  : "选择搜索的字段",
            menu     : checkItems,
            minWidth : 105
        });
        // 输入框
        this.filter = new Ext.form.TextField({
            'name': 'filter'
        });

        this.tbar = new Ext.Toolbar([{
            id      : 'add',
            text    : '新增',
            iconCls : 'add',
            tooltip : '新增',
            handler : this.add.createDelegate(this)
        }, {
            id      : 'edit',
            text    : '修改',
            iconCls : 'edit',
            tooltip : '修改',
            handler : this.edit.createDelegate(this)
        }, {
            id      : 'del',
            text    : '删除',
            iconCls : 'delete',
            tooltip : '删除',
            handler : this.del.createDelegate(this)
        }, {
            id      : 'selectResc',
            text    : '配置权限',
            iconCls : 'config',
            handler : this.selectResc.createDelegate(this)
        }, {
            id      : 'selectMenu',
            text    : '配置菜单',
            iconCls : 'cog',
            handler : this.selectMenu.createDelegate(this)
        }]);

        // 把分页工具条，放在页脚
        var paging = new Ext.PagingToolbar({
            pageSize: this.pageSize,
            store: this.store,
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录",
            plugins: [new Ext.ux.PageSizePlugin()]
        });

        this.store.load({
            params:{start:0, limit:paging.pageSize}
        });
        this.bbar = paging;
    },
     // 弹出添加对话框，添加一条新记录
    add : function() {
        if (!this.dialog) {
            this.createDialog();
        }
        this.formPanel.getForm().reset();
        this.dialog.show(Ext.get("add"));

    },
    renderResource: function(value, p, record) {
        if(record.data['authorized'] == true) {
            return String.format("<b><font color=green>已分配</font></b>");
        } else {
            return String.format("<b><font color=red>未分配</font></b>");
        }
    },
    renderNamePlain: function(value) {
        return String.format('{0}', value);
    },
    selectResc: function() {
        if (this.getSelectionModel().getSelections().length <= 0){
            Ext.MessageBox.alert('提示', '请选择需要配置的角色！');
            return;
        }
        if (this.getSelectionModel().getSelections().length > 1){
            Ext.MessageBox.alert('提示', '不能选择多行！');
            return;
        }

        if (!this.selectRescWin) {
            var r = Ext.data.Record.create([
                {name: "id",               mapping: "authorityid",         type: "int"},
                {name: "authoritytype",    mapping: "authoritytype",    type: "string"},
                {name: "authorityname",    mapping: "authorityname",       type: "string"},
                {name: "authorityvalue",   mapping: "authorityvalue",  type: "string"},
                {name: "authoritydesc",    mapping: "authoritydesc",      type: "string"},
                {name: "authorized",       mapping: "authorized", type: "boolean"}
            ]);
            var ds = new Ext.data.Store({
                proxy: new Ext.data.HttpProxy({url:'../SsRole/getRescs.do'}),
                reader: new Ext.data.JsonReader({
                    root: '',
                    totalProperty: 'totalCount'
                }, r),
                remoteSort: false
            });
            var cm = new Ext.grid.ColumnModel([{
                // 设置了id值，我们就可以应用自定义样式 (比如 .x-grid-col-topic b { color:#333 })
                id        : 'id',
                header    : "编号",
                dataIndex : "id",
                width     : 80,
                sortable  : true,
                renderer  : this.renderNamePlain,
                css       : 'white-space:normal;'
            }, {
                id        : 'authorityname',
                header    : "权限名称",
                dataIndex : "authorityname",
                sortable  : true,
                width     : 150 ,
                css       : 'white-space:normal;'
            }, {
                id        : 'authoritytype',
                header    : "权限类型",
                dataIndex : "authoritytype",
                sortable  : true,
                width     : 80
            }, {
                id        : 'authorityvalue',
                header    : "权限值",
                dataIndex : "authorityvalue",
                sortable  : true,
                width     : 150
            }, {
                id        : 'authoritydesc',
                header    : "权限描述",
                dataIndex : "authoritydesc",
                sortable  : true,
                width     : 80
            }, {
                id        : 'authorized',
                header    : "是否授权",
                dataIndex : "authorized",
                sortable  : true,
                width     : 80,
                renderer  : this.renderResource
            }]);
            var roleGrid = this;
            var grid = new Ext.grid.GridPanel( {
                ds: ds,
                cm: cm,
                selModel: new Ext.grid.RowSelectionModel({singleSelect:true}),
                enableColLock:false,
                loadMask: false,
                viewConfig: {
                    forceFit: true
                },
                bbar: new Ext.Toolbar([{
                    pressed: true,
                    enableToggle:true,
                    text: '授权',
                    toggleHandler: function(){
                        //授权事件
                       // var mResc = grid.getSelections();
                        //var mRole = roleGrid.getSelections();
                        var mResc = grid.getSelectionModel().getSelections();
                        var mRole = roleGrid.getSelectionModel().getSelections();
                        
                        //var records = this.getSelectionModel().getSelections();//单选
                        //this.getRecordArrayUtils(records, 'id')
                        if (mResc.length <= 0) {
                            Ext.MessageBox.alert('提示', '请选择至少一个资源操作！');
                            return;
                        }else if(mRole.length == 1) {
                            //roleId = mRole[0].get('id');
                            //authId = mResc[0].get('id');
                           var  roleId = this.getRecordArrayUtils(mRole, 'id'); 
                           var   authId = this.getRecordArrayUtils(mResc, 'id');
                            Ext.Ajax.request({
                                url: '../SsRole/authResc.do',
                                success: function() {
                                    Ext.MessageBox.alert('提示', '授权成功！');
                                    ds.reload();
                                },
                                params: 'auth=true&roleId=' + roleId + '&authId=' + authId
                            });
                        }else{
                            for(var i = 0, len = mRole.length; i < len; i++){
                                roleId = this.getRecordArrayUtils(mRole, 'id'); 
                                authId = this.getRecordArrayUtils(mResc, 'id');
                                Ext.Ajax.request({
                                    url: '../SsRole/authResc.do',
                                    success: function() {
                                        Ext.MessageBox.alert('提示', '授权成功！');
                                        ds.reload();
                                    },
                                    params: 'auth=true&roleId=' + roleId + '&authId=' + authId
                                });
                            }
                        }
                    },
			     //工具类
	 getRecordArrayUtils : function(records,field) {
			var result = [];
					for(var i = 0; i < records.length; i++) {
						result.push(records[i].get(field));
					}
					return result;
				}
                }, '-', {
                    pressed: true,
                    enableToggle:true,
                    text: '取消授权',
                    toggleHandler: function(){
                        //授权事件
                        var mResc = grid.getSelectionModel().getSelections();
                        var mRole = roleGrid.getSelectionModel().getSelections();
                        
                        //var records = this.getSelectionModel().getSelections();//单选
                        //this.getRecordArrayUtils(records, 'id')
                        
                        if(mResc.length<=0){
                            Ext.MessageBox.alert('提示', '请选择至少一个权限操作！');
                            return;
                        }else if(mRole.length==1){
                            // roleId = mRole[0].get('id');
                            //authId = mResc[0].get('id');
                           var  roleId = this.getRecordArrayUtils(mRole, 'id'); 
                           var  authId = this.getRecordArrayUtils(mResc, 'id');
                            
                            Ext.Ajax.request({
                                url: '../SsRole/authResc.do',
                                success: function() {
                                    Ext.MessageBox.alert('提示', '取消授权成功！');
                                    ds.reload();
                                },
                                params: 'auth=false&roleId=' + roleId + '&authId=' + authId
                            });
                        }else{
                            for(var i = 0, len = mResc.length; i < len; i++){
                             var   roleId = this.getRecordArrayUtils(mRole, 'id'); 
                              var  authId = this.getRecordArrayUtils(mResc, 'id');
                                Ext.Ajax.request({
                                    url: '../SsRole/authResc.do',
                                    success: function() {
                                        Ext.MessageBox.alert('提示', '取消授权成功！');
                                        ds.reload();
                                    },
                                    params: 'auth=false&roleId=' + roleId + '&authId=' + authId
                                });
                            }
                        }
                    },
			     //工具类
	 getRecordArrayUtils : function(records,field) {
			var result = [];
					for(var i = 0; i < records.length; i++) {
						result.push(records[i].get(field));
					}
					return result;
				}
                }])
            });
            this.rescGrid = grid;
            this.selectRescWin = new Ext.Window({
                layout: 'fit',
                height: 400,
                width: 500,
                closeAction: 'hide',
                items: [grid]
            });
        }
          var records = this.getSelectionModel().getSelections();//单选
                       
        
        this.selectRescWin.show();
        this.rescGrid.getStore().baseParams.roleId =  this.getRecordArrayUtils(records, 'id');
        this.rescGrid.getStore().reload();
    },selectMenu: function() {  //配置菜单部分
        if (this.getSelectionModel().getSelections().length <= 0){
            Ext.MessageBox.alert('提示', '请选择需要配置的角色！');
            return;
        }
        if (this.getSelectionModel().getSelections().length > 1){
            Ext.MessageBox.alert('提示', '不能选择多行！');
            return;
        }

        var roleId = this.getSelectionModel().getSelections()[0].get("id");

        //if (!this.selectMenuWin) {
            var menuTree = new Ext.tree.TreePanel({
                autoScroll: true,
                animate : true,
                loader  : new Ext.tree.CustomUITreeLoader({
                    dataUrl : '../SsRole/getMenus.do',
                    baseAttr : {
                        uiProvider : Ext.tree.CheckboxNodeUI
                    }
                }),
                enableDD        : false,
                containerScroll : true,
                rootUIProvider  : Ext.tree.CheckboxNodeUI,
                selModel        : new Ext.tree.CheckNodeMultiSelectionModel(),
                rootVisible     : false
            });
            menuTree.getLoader().on('load', function(o, node) {
                if (node.isRoot) {
                    menuTree.expandAll();
                }
            });
            // 设置根节点
            var root = new Ext.tree.AsyncTreeNode({
                text       : 'root',
                draggable  : false//,
                //uiProvider : Ext.tree.CheckboxNodeUI
            });
            menuTree.setRootNode(root);

            this.menuTree = menuTree;
            this.selectMenuWin = new Ext.Window({
                layout: 'fit',
                height: 300,
                width: 400,
                modal : true,
                items: [menuTree],
                buttons : [
						{
							text : '保存',
							iconCls:'btn-save',
							handler : function() {
							  //  alert("roleid 22 = "+roleId);
								Ext.Ajax.request({
									url: '../SsRole/selectMenu.do',
                                    method:'POST',
                                    params:{roleId:roleId,ids:menuTree.getChecked().join(",") },
									success : function(response, options) {
										menuTree.getLoader().load(menuTree.getRootNode());
										
									},
									failure : function(response, options) {
										Ext.Msg.alert('操作信息','授权出错，请联系管理员！');
									},
									scope : this
								});
							}
						}
				]
            });
            this.menuTree.getLoader().baseParams.roleId = roleId;
       // } else {
       //     this.menuTree.getLoader().baseParams.roleId = roleId;
       //     this.menuTree.getLoader().load(this.menuTree.getRootNode());
       // }
        // Ext.MessageBox.alert('提示', roleId);
        this.selectMenuWin.show();

    }
});
