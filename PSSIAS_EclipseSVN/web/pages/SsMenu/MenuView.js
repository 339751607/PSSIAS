Ext.ns('MenuView');

var MenuView=function(){	
	return this.setup();
};

MenuView.prototype.setup=function(){	
	var selected;
	var store=this.initData();
    var sm=new Ext.grid.CheckboxSelectionModel();
    
    
        var cm = new Ext.grid.ColumnModel({
		 columns:[sm,new Ext.grid.RowNumberer(),{
	          header: "menuid",
	          dataIndex: 'menuid',
	          hidden: true
	      },{
	          header: "菜单名称",
	          dataIndex: 'menuname',
	          width: 60
	      },{
	          header: "菜单描述",
	          dataIndex: 'menudesc',
	          width: 60
	      },{
	          header: "是否子节点",
	          dataIndex: 'isleaf',
	          width: 60
	      },{
	          header: "菜单链接",
	          dataIndex: 'menuurl',
	          width: 60
	      },{
	          header: "显示顺序",
	          dataIndex: 'displayorder',
	          width: 60
	      }
      	],
	    defaults: {
	        sortable: true,
	        menuDisabled: true,
	        width: 100
	    },
	    listeners: {
	        hiddenchange: function(cm, colIndex, hidden) {
	            saveConfig(colIndex, hidden);
	        }
	    }
	});
    

	var grid = new Ext.grid.GridPanel({
	  id:'MenuGridView',
      autoHeight:true,
      title:'菜单基本信息',
      store: store,
      shim: true,
      trackMouseOver:true,
      disableSelection:false,
      loadMask: true,
      cm:cm,
      sm:sm,
      viewConfig: {
          forceFit:true,
          enableRowBody:false,
          showPreview:false  
      },
      // paging bar on the bottom
      bbar: new Ext.PagingToolbar({
          pageSize: 15,
          store: store,
          displayInfo: true,
          displayMsg: '当前显示从{0}至{1}， 共{2}条记录',
          emptyMsg: "当前没有记录"
      })
  });

  store.load({params:{start:0, limit:15}});
	
	
	
	var treePanel=new Ext.tree.TreePanel({
		region:'west',
		id:'treePanel',
		title:'菜单信息',
		autoScroll:true,
		collapsible : true,
		split : true,
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
		loader:new Ext.tree.TreeLoader({
		    url:'../SsMenu/treelist.do'
			}),
		root:new Ext.tree.AsyncTreeNode({
	        expanded: true
		    }),
		rootVisible: false,
		listeners: {
	        'click': MenuView.clickNode
	    }
	});
		
	//树的右键菜单的
	treePanel.on('contextmenu', contextmenu, treePanel);

	// 创建右键菜单
	var treeMenu = new Ext.menu.Menu( {
	        id : 'treeMenu',
	        items : [ 
	        	{
	                text : '新建菜单',
	                scope : this,
	                handler :createNode
	            },
	            {  
	                text : '修改菜单',  
	                scope : this,
	                handler : editNode  
	            },{  
	                text : '删除菜单',  
	                scope : this,
	                handler : deteleNode  
	            }
	            ]
	    });

	
	function contextmenu(node, e) {
		selected = new Ext.tree.TreeNode({
		    id:node.id,
		    text:node.text
		});
		 Ext.state.Manager.set("treestate", node.getPath());
		//if(selected.id>0){
		treeMenu.showAt(e.getXY());	
		//}
	}
	/**
	 * 菜单事件
	 */

	
	function createNode(){
		var nodeId = selected.id;
		var menuForm = Ext.getCmp('menuForm');
		if(menuForm==null){
			if(nodeId>0){
			    new MenuForm(nodeId);
			}else{
				new MenuForm(0);	
			}
		}
		
	}
	function deteleNode(){
		var depId = selected.id;
		var type = Ext.getCmp('treePanel');
		if(depId>0){
			Ext.Msg.confirm('删除操作','你确定删除菜单?',function(btn){
				if(btn=='yes'){
				Ext.Ajax.request({
					url:'../SsMenu/remove.do?menuId='+depId,
					method:'POST',
					success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
							     Ext.MessageBox.alert('警告',data.msg);
								 type.root.reload();
								 var users = Ext.getCmp('MenuGridView');
    	                         var store=users.getStore();
								 store.reload();
								 var treeState = Ext.state.Manager.get("treestate");
					             if (treeState)
					               treePanel.expandPath(treeState);
							}
							else{
								 Ext.MessageBox.alert('警告',data.msg);
							}
							
						},
					failure : function() 
					{
					   Ext.Msg.alert("错误","与后台联系的时候出现了问题");
				    }
				});
				}
			});
		}else{
		 Ext.Msg.alert('警告',"根菜单不能被删除");
	 }
	}
	function editNode(){
	var depId = selected.id;
	if(depId>0){	
		var menuForm = Ext.getCmp('menuForm');
		if(menuForm==null){
			new MenuForm();
			menuForm = Ext.getCmp('menuForm');
		}
		menuForm.form.load({
			url:'../SsMenu/detail.do',
			params:{depId:depId},
			method:'post',
			deferredRender :true,
			layoutOnTabChange :true,
	        success : function() {
	           // Ext.Msg.alert('编辑', '载入成功！');
	        },
	        failure : function() {
	           // Ext.Msg.alert('编辑', '载入失败');
	        }
		});
	}else{
		Ext.Msg.alert('警告',"根菜单不能修改！");
	}
		
}
	
	var panel=new Ext.Panel({
		id:'MenuView',
		//title:'菜单信息',
		closable:true,
		iconCls:'menu-department',
		layout : 'border',
		height:Ext.get("layout").getHeight(),
		items:[treePanel,{region:'center',width:'100%',items:[grid]}]		     
	});
	
	return panel;	

};

MenuView.prototype.initData=function(){

  	var _jsonReader = new Ext.data.JsonReader( {
		root : 'list',
		totalProperty : 'totalCount',
		id : 'userid',
		successProperty : '@success'
	}, [ {
		name : 'menuid',
		mapping : 'menuid',
		type : 'int'
	}, {
		name : 'menuname',
		mapping : 'menuname'
	}, {
		name : 'menudesc',
		mapping : 'menudesc'
	}, {
		name : 'isleaf',
		mapping : 'isleaf'
	}, {
		name : 'menuurl',
		mapping : 'menuurl'
	}, {
		name : 'displayorder',
		mapping : 'displayorder'
	}]);

  var store = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : '../SsMenu/findMenuBySeq.do'
			}),
			//
			reader : _jsonReader
		});

    //store.setDefaultSort('menulevel', 'asc');  
   // store.setDefaultSort('displayorder', 'asc');  
    return store;
};




/**
 * 初始化
 * @return {}
 */

/**
 * 用户删除
 * @param {} userId
 */
MenuView.remove=function(userId){
	Ext.Msg.confirm('删除操作','你确定要删除该用户吗?',function(btn){
		if(btn=='yes'){
			Ext.Ajax.request({
				url: '../SsMenu/extlist.do',
				method:'post',
				params:{userId:userId},
				success:function(){
					Ext.Msg.alert("信息","删除成功"),
					MenuGridView.grid.getStore().reload();
				},
				failure:function(){
					Ext.Msg.alert("信息","删除失败");
					MenuGridView.grid.getStore().reload();
				}
			});
		}
	});
	
}


MenuView.clickNode=function(node){
    if (node != null) {
    	var users = Ext.getCmp('MenuGridView');
    	var store=users.getStore();
    	store.url='../SsMenu/findMenuBySeq.do';
    	store.baseParams={menuId:node.id};
    	store.params={start:0,limit:15};
    	store.reload({params:{start:0,limit:15}});
    }
   
};
