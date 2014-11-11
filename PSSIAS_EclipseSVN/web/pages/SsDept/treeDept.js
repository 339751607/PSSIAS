/*!
 * Ext JS Library 3.0.3
 * Copyright(c) 2006-2009 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
 
Ext.ns('treeDept');
Ext.BLANK_IMAGE_URL = "../../widgets/ext-3.0.0/resources/images/default/s.gif";
Ext.QuickTips.init();
Ext.form.Field.prototype.msgTarget = 'qtip'; 
Ext.onReady(function(){



    Ext.QuickTips.init();

    // Album toolbar
    var selected;
    var sm=new Ext.grid.CheckboxSelectionModel();
    
        var cm = new Ext.grid.ColumnModel({
		 columns:[sm,new Ext.grid.RowNumberer(),{
	          header: "userid",
	          dataIndex: 'userid',
	          hidden: true
	      },{
	          header: "用户名",
	          dataIndex: 'username',
	          width: 60
	      },{
	          header: "姓名",
	          dataIndex: 'fullname',
	          width: 60
	      },{
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
		  },{
	      	header:'管理',
	      	dataIndex:'userId',
	      	width:50,
	      	renderer:function(value,metadata,record,rowIndex,colIndex){
	      		var editId=record.data.userid;
	      		var editName=record.data.username;
	      		var str='<button title="删除" value=" " class="btn-del" onclick="treeDept.remove('+editId+')">&nbsp;</button>';
	      		    str+='&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="AppUserView.edit('+editId+',\''+editName+'\')">&nbsp;</button>';
	      		return str;
	      	}
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
	}, , {
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
	// Store
		var ds = new Ext.data.Store( {
			proxy : new Ext.data.HttpProxy( {
				url : '../SsDept/findUserByDepartment.do'
			}),
			//
			reader : _jsonReader
		});
		ds.setDefaultSort('userid', 'desc');

		
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
      sm:sm,
      viewConfig: {
          forceFit:true,
          enableRowBody:false,
          showPreview:false  
      },
      // paging bar on the bottom
      bbar: new Ext.PagingToolbar({
          pageSize: 15,
          store: ds,
          displayInfo: true,
          displayMsg: '当前显示从{0}至{1}， 共{2}条记录',
          emptyMsg: "当前没有记录"
      })
  });

  ds.load({params:{start:0, limit:15}});
    
    
    


   
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
		title:'部门信息',
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
		loader : treeloader,
		rootVisible: true,
		listeners: {
	        'click': treeDept.clickNode
	    }
	});
	
	// 异步加载根节点

    var rootnode = new Tree.AsyncTreeNode({

                id : '0',

                text : '组织结构',

                draggable : false,// 根节点不容许拖动

                expanded : true

            });

 

    // 为tree设置根节点

    treePanel.setRootNode(rootnode);

 

    // 响应加载前事件，传递node参数

    treePanel.on('beforeload', function(node) {

                treePanel.loader.dataUrl = '../SsDept/getTrees.do?parentId=' + node.id; // 定义子节点的Loader

            });
     rootnode.expand(false,false);       
		
	//树的右键菜单的
	treePanel.on('contextmenu', contextmenu, treePanel);
	
	//状态管理器
	treePanel.on('expandnode', function (node){
	       Ext.state.Manager.set("treestate", node.getPath());
    });

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
		
		var departmentForm = Ext.getCmp('departmentForm');
		if(departmentForm==null){
			if(nodeId>0){
			    new DepartmentForm(nodeId);
			}else{
				new DepartmentForm(0);	
			}
		}
		
	           //alert(treeState);
	}
	function deteleNode(){
		var depId = selected.id;
		var type = Ext.getCmp('treePanel');
		if(depId>0){
			Ext.Msg.confirm('删除操作','你确定删除部门?',function(btn){
				if(btn=='yes'){
				Ext.Ajax.request({
					url:'../SsDept/remove.do?depId='+depId,
					method:'POST',
					success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
							     Ext.MessageBox.alert('警告',data.msg);
								 type.root.reload();
								//var users = Ext.getCmp('UserView');
    	                        // var ds=users.getStore();
								// ds.reload();
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
		 Ext.Msg.alert('警告',"组织机构不能被删除");
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
			url:'../SsDept/detail.do',
			params:{depId:depId},
			method:'post',
			deferredRender :true,
			layoutOnTabChange :true,
	        success : function() {
	        },
	        failure : function() {
	           // Ext.Msg.alert('编辑', '载入失败');
	        }
		});
		//var treeState = Ext.state.Manager.get("treestate");
	            //  if (treeState)
	             // treePanel.expandPath(treeState);
	}else{
		Ext.Msg.alert('警告',"总公司不能修改！");
	}
		
}



    // Set up images view




    
  	var layout=new Ext.Panel({
		id:'treeDept',
		//title:'部门信息',
		closable:true,
		iconCls:'menu-department',
		layout : 'border',
		height:Ext.get("layout").getHeight(),
		items:[treePanel,{region:'center',width:'100%',items:[grid]}]		     
	});
    






    layout.render('layout');





});



/**
 * 用户删除
 * 
 * @param {}
 *            userId
 */
treeDept.remove = function(userId) {
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
								var users = Ext.getCmp('UserView');
    	                        var ds=users.getStore().reload();
								//this.grid.getStore().reload();
									
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





treeDept.clickNode=function(node){
    if (node != null) {
    	var users = Ext.getCmp('UserView');
    	var ds=users.getStore();
    	ds.url='../SsDept/findUserByDepartment.do';
    	ds.baseParams={depId:node.id};
    	ds.params={start:0,limit:15};
    	ds.reload({params:{start:0,limit:15}});
    }
   
};
