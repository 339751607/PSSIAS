/*!
 * Ext JS Library 3.0.3
 * Copyright(c) 2006-2009 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){



    Ext.QuickTips.init();

    // Album toolbar

   


   

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


    
    
	var grid = new Ext.grid.GridPanel({
	  id:'UserView',
      autoHeight:true,
      title:'员工基本信息',
      store: ds,
      shim: true,
      trackMouseOver:true,
      disableSelection:false,
      loadMask: true,
      cm:cm,
      viewConfig: {
          forceFit:true
      }
  });

  ds.load({params:{start:0, limit:25}});
   
    //grid end
 

	var treePanel=new Ext.tree.TreePanel({
		region:'west',
		id:'treePanel',
		title:'部门信息显示',
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
		    url:'../SsDept/treelist.do'
			}),
		root:new Ext.tree.AsyncTreeNode({
	        expanded: true
		    }),
		rootVisible: false
	});
		
	//树的右键菜单的
	treePanel.on('contextmenu', contextmenu, treePanel);

	// 创建右键菜单
	var treeMenu = new Ext.menu.Menu( {
	        id : 'treeMenu',
	        items : [ 
	        	{
	                text : '新建部门',
	                scope : this,
	                handler :createNode
	            },
	            {  
	                text : '修改部门信息',  
	                scope : this,
	                handler : editNode  
	            },{  
	                text : '删除部门',  
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
		//if(selected.id>0){
		treeMenu.showAt(e.getXY());	
		//}
	}
	/**
	 * 菜单事件
	 */

	
	function createNode(){
		var nodeId = selected.id;
		var departmentForm = Ext.getCmp('departmentForm');
		if(departmentForm==null){
			if(nodeId>0){
			    new DepartmentForm(nodeId);
			}else{
				new DepartmentForm(0);	
			}
		}
		
	}
	function deteleNode(){
		var depId = selected.id;
		var type = Ext.getCmp('treePanel');
		if(depId>0){
			Ext.Msg.confirm('删除操作','你确定删除部门?',function(btn){
				if(btn=='yes'){
				Ext.Ajax.request({
					url:__ctxPath+'/system/removeDepartment.do?depId='+depId,
					success:function(){
						Ext.Msg.alert('操作信息','删除成功!');
						type.root.reload();
					}
				});
				}
			});
		}else{
		 Ext.Msg.alert('警告',"总公司不能被删除");
	 }
	}
	function editNode(){
	var depId = selected.id;
	if(depId>0){	
		var departmentForm = Ext.getCmp('departmentForm');
		if(departmentForm==null){
			new DepartmentForm();
			departmentForm = Ext.getCmp('departmentForm');
		}
		departmentForm.form.load({
			url:'../SsDept/treelist.do',
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
		Ext.Msg.alert('警告',"总公司不能修改！");
	}
		
}



    // Set up images view




    
  	var layout=new Ext.Panel({
		id:'DepartmentView',
		title:'部门信息',
		closable:true,
		iconCls:'menu-department',
		layout : 'border',
		height:800,
		items:[treePanel,{region:'center',width:'100%',items:[grid]}]		     
	});
    






    layout.render('layout');





});












function shortName(name){
    if(name.length > 15){
        return name.substr(0, 12) + '...';
    }
    return name;
};

