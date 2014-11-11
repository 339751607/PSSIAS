/**
 * [SsMenu] author by $YourName$
 * @include "../../extclient/RowExpander.js"
 * @include "../../extclient/gridToExcel.js"
 * @include "../../extclient/SearchField.js"
 */
 
Ext.namespace('com.dyneinfo.hotel');
Ext.namespace('com.dyneinfo.zazh.ssmenu');

/**
 * 查询表单
 * @class com.dyneinfo.zazh.ssmenu.queryformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssmenu.queryformpanel = Ext.extend(Ext.form.FormPanel,{
	initComponent:function() {
		Ext.apply(this,{
	        labelAlign:'right',
	        labelWidth:80,
	        defaultType:'textfield',
	        bodyStyle:'padding:20px;',
	        defaults:{width:290},
	        items:[{
	            xtype:'panel',
	            html:'请在下面输入查询条件：',
	            width:370,
	            border:false,
	            style:'padding:10 0 0 3;margin:0 0 20 10;border-bottom:1px solid #ccc;font-size:14px;font-weight:bold;'
	        	}
	        	,{
	            xtype:'panel',
	            layout:'column',
	            width:400,
	            border:false,
	            defaults:{border:false}
	        	}
	        	,{xtype:'textfield',fieldLabel:'菜单名称',name:'s_menuname',width:288}
	        	,{xtype:'textfield',fieldLabel:'菜单描述',name:'s_menudesc',width:288}
	        	,{xtype:'textfield',fieldLabel:'菜单显示',name:'s_menulabel',width:288}
	        	,{xtype:'textfield',fieldLabel:'是否子节点',name:'s_isleaf',width:288}
	        	,{xtype:'textfield',fieldLabel:'菜单链接',name:'s_menuurl',width:288}
	        	,{xtype:'textfield',fieldLabel:'菜单层数',name:'s_menulevel',width:288}
	        	,{xtype:'textfield',fieldLabel:'ROOTID',name:'s_rootid',width:288}
	        	,{xtype:'textfield',fieldLabel:'父菜单ID',name:'s_parentid',width:288}
	        	,{xtype:'textfield',fieldLabel:'图片路径',name:'s_imagepath',width:288}
	        	,{xtype:'textfield',fieldLabel:'层级关系',name:'s_menuseq',width:288}
	        	,{xtype:'textfield',fieldLabel:'显示顺序',name:'s_displayorder',width:288}
	            ]
	    });
		com.dyneinfo.zazh.ssmenu.queryformpanel.superclass.initComponent.call(this);
	}
});

/**
 * 查询窗口
 * @class com.dyneinfo.zazh.ssmenu.querywin
 * @extends Ext.Window
 */
com.dyneinfo.zazh.ssmenu.querywin = Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        title:'高级查询',
	        width:455,
	        height:395,
	        modal:true,
	        closeAction:'hide',
	        layout:'fit'
	    });
		com.dyneinfo.zazh.ssmenu.querywin.superclass.initComponent.call(this);
	}
});

/**
 * 内容表单
 * @class com.dyneinfo.zazh.ssmenu.dtlformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssmenu.dtlformpanel = Ext.extend(Ext.form.FormPanel,{
	initComponent:function() {
		Ext.apply(this,{
	        labelWidth:100,
	        labelAlign:'right',
	        frame:true,
//	        bodyStyle:'padding:10px',
	        autoScroll:true,//滚动条
			items:[{
		            xtype:'panel',
		            layout:'column',
		            width:400,
		            border:false,
		            defaults:{border:false}
		        	}
	        		,{xtype:'hidden',fieldLabel:'菜单ID',name:'menuid',width:288}
	        		,{xtype:'textfield',fieldLabel:'菜单名称',name:'menuname',width:288}
	        		,{xtype:'textfield',fieldLabel:'菜单描述',name:'menudesc',width:288}
	        		,{xtype:'textfield',fieldLabel:'菜单显示',name:'menulabel',width:288}
	        		,{xtype:'textfield',fieldLabel:'是否子节点',name:'isleaf',width:288}
	        		,{xtype:'textfield',fieldLabel:'菜单链接',name:'menuurl',width:288}
	        		,{xtype:'textfield',fieldLabel:'菜单层数',name:'menulevel',width:288}
	        		,{xtype:'textfield',fieldLabel:'ROOTID',name:'rootid',width:288}
	        		,{xtype:'textfield',fieldLabel:'父菜单ID',name:'parentid',width:288}
	        		,{xtype:'textfield',fieldLabel:'图片路径',name:'imagepath',width:288}
	        		,{xtype:'textfield',fieldLabel:'层级关系',name:'menuseq',width:288}
	        		,{xtype:'textfield',fieldLabel:'显示顺序',name:'displayorder',width:288}
	        ]
	    });
	    com.dyneinfo.zazh.ssmenu.dtlformpanel .superclass.initComponent.call(this);
	}
	
});

/**
 * 表单窗口
 * @class com.dyneinfo.zazh.ssmenu.dtlwin
 * @extends Ext.Window
 */		
com.dyneinfo.zazh.ssmenu.dtlwin =  Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        width:535,
	        height:400,
	        layout:'fit',
	        border:false,
	        closeAction:'hide',
	        modal:true,
	        maximizable:true,
	        constrain: true,
	        collapsible:true
	    });
		com.dyneinfo.zazh.ssmenu.dtlwin.superclass.initComponent.call(this);
	}
});


/**
 * 主表格入口
 * @class com.dyneinfo.zazh.ssmenu
 * @extends Ext.grid.GridPanel
 */
com.dyneinfo.zazh.ssmenuGrid = Ext.extend(Ext.grid.GridPanel,{
    initComponent:function() {
    	this.pageSize=10;
    	this.ds = new Ext.data.Store({
	        url:'../SsMenu/extlist.do',
	        reader:new Ext.data.JsonReader({
	            root:'list',
	            totalProperty:'totalSize',
	            id:'id'
		        }
		        ,['menuid','menuname','menudesc','menulabel','isleaf','menuurl','menulevel','rootid','parentid','imagepath','menuseq','displayorder',]
	        ),
	        baseParams:{
	            limit:this.pageSize
	        },
	        remoteSort:true
	    });
	    
	    //行扩展
	    this.expander = new Ext.grid.RowExpander({
	        tpl : new Ext.Template(
	            '<p style="margin-left:70px"><b>字典内容:</b> {kvalue}</p><br>'
	        )
	    });
	    
	    this.sm = new Ext.grid.CheckboxSelectionModel();
		this.cm = new Ext.grid.ColumnModel([
		    new Ext.grid.RowNumberer(),
		    this.sm,
		    this.expander
	        ,{header:'菜单名称',width:100,sortable:true,dataIndex:'menuname'}
	        ,{header:'菜单描述',width:100,sortable:true,dataIndex:'menudesc'}
	        ,{header:'菜单显示',width:100,sortable:true,dataIndex:'menulabel'}
	        ,{header:'是否子节点',width:100,sortable:true,dataIndex:'isleaf'}
	        ,{header:'菜单链接',width:100,sortable:true,dataIndex:'menuurl'}
	        ,{header:'菜单层数',width:100,sortable:true,dataIndex:'menulevel'}
	        ,{header:'ROOTID',width:100,sortable:true,dataIndex:'rootid'}
	        ,{header:'父菜单ID',width:100,sortable:true,dataIndex:'parentid'}
	        ,{header:'图片路径',width:100,sortable:true,dataIndex:'imagepath'}
	        ,{header:'层级关系',width:100,sortable:true,dataIndex:'menuseq'}
	        ,{header:'显示顺序',width:100,sortable:true,dataIndex:'displayorder'}
		]);
		
		/**
		 * 扩展类的构建开始
		 */
		Ext.apply(this,{
			store:this.ds
	        ,sm:this.sm
	        ,cm: this.cm
			,plugins:this.expander
			,collapsible: true
			,viewConfig:{forceFit:true}
	        ,bbar:new Ext.PagingToolbar({
	            pageSize:this.pageSize,
	            store:this.ds,
	            displayInfo:true
	        })
	        , tbar:[
	        	{text:'新增',cls:'x-btn-text-icon',iconCls:'addicon',handler:this.addSsMenu,scope:this},'-'
	        	,{text:'修改',cls:'x-btn-text-icon',iconCls:'editicon',handler:this.editSsMenu,scope:this},'-'
	        	,{text:'删除',cls:'x-btn-text-icon',iconCls:'deleteicon',handler:this.deleteSsMenu,scope:this},'-'
	        	,{text:'查询',id:'btn-query',cls:'x-btn-text-icon',iconCls:'queryicon',handler:this.buildQueryWin,scope:this}
	        	,'->'
	        	,'搜索范围：'
				,{xtype:'combo',
	            fieldLabel:'搜索范围',
	            emptyText:'请选择...',
	            name:'field_type',
	            hiddenName:'field_type',
	            store:new Ext.data.ArrayStore({
        			fields: ['name','code'],
        			data: [['菜单名称', 'menuname'],['菜单描述', 'menudesc'],['菜单显示', 'menulabel'],['是否子节点', 'isleaf'],['菜单链接', 'menuurl'],['菜单层数', 'menulevel'],['ROOTID', 'rootid'],['父菜单ID', 'parentid'],['图片路径', 'imagepath'],['层级关系', 'menuseq'],['显示顺序', 'displayorder']]
        		}),
	            displayField:'name',
	            valueField:'code',
	            forceSelection: false,
	            selectOnFocus: true,
	            editable: false,
	            triggerAction: 'all',
	            allowBlank:true,
	            mode: 'local',
	            width:120
	            ,listeners: {          
          			select:{fn:function(object,record,index){
          				this.getTopToolbar().items.get("searchfld").getStore().baseParams['field_type'] = object.getValue();
          			},scope:this}
          		}    
	        	},{xtype:"searchfield",itemId:"searchfld",width: 130,store:this.ds}
	        ]
		});
		//调用父类构建函数
        com.dyneinfo.zazh.ssmenuGrid.superclass.initComponent.call(this);
        //加载数据
        this.store.load({params:{start:0}});
        
 		//扩展类的详细弹出窗口
 		this.dtlformpanel = new com.dyneinfo.zazh.ssmenu.dtlformpanel();
 		this.dtlwin =  new com.dyneinfo.zazh.ssmenu.dtlwin({items:this.dtlformpanel,buttons:[{
	            text:'保存',
	            handler:this.saveSsMenu,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.dtlwin.hide();},
	            scope:this
	        }]});
	    
	    //扩展类的查询弹出窗口
	    this.queryformpanel = new com.dyneinfo.zazh.ssmenu.queryformpanel();
	    this.querywin =  new com.dyneinfo.zazh.ssmenu.querywin({items:this.queryformpanel,buttons:[{
	            text:'确定',
	            handler:this.queryOrder,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.querywin.hide();},
	            scope:this
	        }]});
	    //双击操作
 		this.on({"dblclick":this.dblclick});
 		//右键菜单监听
 		this.addListener('rowcontextmenu', this.onMessageContextMenu);
    }
    
   /**
    * 构建函数结束
    */

	//右键菜单
    ,onMessageContextMenu : function (grid, rowIndex, e) {
		e.stopEvent();
		var coords = e.getXY();
		var record = grid.getStore().getAt(rowIndex);
		var messageContextMenu = new Ext.menu.Menu({
			id: 'messageContextMenu',
			items: [{icon:'../../images/edit.gif',text: '编辑',handler: rgtEdit,scope: this},
	        		{id: 'delete',icon:'../../images/delete.gif',handler: rgtDelete,text: '删除'
	        }]
	    });
	    //右键编辑
	    function rgtEdit() {
	            		messageContextMenu.hide();
				        this.dtlwin.setTitle('修改SsMenu');
				        this.dtlwin.show();
				        this.dtlformpanel.form.reset();
				        this.dtlformpanel.form.loadRecord(record);
				        this.dtlformpanel.url = '../SsMenu/extupdate.do';
	    };
	    //右键删除
		function rgtDelete() {
			messageContextMenu.hide();
			if (!record||record.length == 0) {
				Ext.Msg.alert("提示", "请先选择要删除的�记录");
				return;
			}
			Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
				if (btn == 'yes'){
						Ext.Ajax.request({
						url:'../SsMenu/extdelete.do?ids='+record.data.menuid,
						method:'POST',
						success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
								grid.getStore().remove(record);
								grid.getView().refresh();
							}
							else{
								Ext.MessageBox.alert('警告',data.msg);
							}
							 grid.getStore().reload();
						},
						scope:this
					});
				}},this);
		};
		messageContextMenu.showAt([coords[0], coords[1]]);
		e.preventDefault();//to disable the standard browser context menu
	}
	
	//双击事件
    ,dblclick :function(){
	    	var sm = this.getSelectionModel();
	   		var record=null;
			try{
				record=sm.getSelected();
				if(record==null){
					return;
				}
			}
			catch(e){
				try{
					record=sm.selection.record();
				}
				catch(ex){}
			}
	    	this.showWinForm(record);
	}
	//双击打开窗口
    ,showWinForm:function(record){
        this.dtlwin.setTitle('修改SsMenu');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
        this.dtlformpanel.form.loadRecord(record);
        this.dtlformpanel.url = '../SsMenu/extupdate.do';
    }
    
    //新建窗口
    ,addSsMenu : function(){
        this.dtlwin.setTitle('新建SsMenu');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
	    this.dtlformpanel.url = '../SsMenu/extsave.do';
	}
	
	//编辑操作
    ,editSsMenu:function(){
    	var records = this.getSelectionModel().getSelections();//单选
    	
	   if (records.length!=1) {
			Ext.Msg.alert("提示", "请先选择要修改的记录");
			return;
		}
	    this.dtlwin.setTitle('修改SsMenu');
	    this.dtlwin.show();
	    this.dtlformpanel.form.reset();
	    this.dtlformpanel.form.loadRecord(records[0]);
	    this.dtlformpanel.url = '../SsMenu/extupdate.do';

    }
    
    //删除操作
    ,deleteSsMenu:function(){
    	var records = this.getSelectionModel().getSelections();
		if (!records||records.length == 0) {
			Ext.Msg.alert("提示", "请先选择要删除的�记录");
			return;
		}
		Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
			if (btn == 'yes'){
				Ext.Ajax.request({
					url:'../SsMenu/extdelete.do?ids='+this.getRecordArrayUtils(records, 'menuid'),
		            method:'POST',
		            success:function(response){
		                var data = Ext.util.JSON.decode(response.responseText);
		                if (data.success == true){
			                for(var i = 0; i < records.length; i++) {
							 	this.getStore().remove(records[i]);
			                    this.getView().refresh();
							 }
							 this.getStore().reload();
		                }
		                else{
		                    Ext.MessageBox.alert('警告',data.msg);
		                }
		            },
		            scope:this
		        });
			}
		},this);
    }
    
    //保存操作
    ,saveSsMenu:function(){
		if (this.dtlformpanel.form.isValid() == false){
	        return;
	    }
	    this.dtlformpanel.form.submit({
	        url:this.dtlformpanel.url,
	        success:function(form,action){
	        	Ext.MessageBox.alert('警告',action.result.msg);
	            this.dtlwin.hide();
	          	this.getStore().reload();
	        },
	        scope:this,
	        failure:function(form,action){
	            Ext.MessageBox.alert('警告',action.result.msg);
	        }
	    })
	
    }
    //新建查询窗口
    ,buildQueryWin: function(){
    	this.querywin.setTitle('查询');
        this.querywin.show();
        this.getTopToolbar().items.get("searchfld").setValue("");
        this.getTopToolbar().items.get("searchfld").getStore().baseParams['field_type']=null;
    }
    //查询操作
    ,queryOrder:function(){
    	this.getStore().baseParams['s_menuname'] = this.queryformpanel.form.findField('s_menuname').getRawValue();
    	this.getStore().baseParams['s_menudesc'] = this.queryformpanel.form.findField('s_menudesc').getRawValue();
    	this.getStore().baseParams['s_menulabel'] = this.queryformpanel.form.findField('s_menulabel').getRawValue();
    	this.getStore().baseParams['s_isleaf'] = this.queryformpanel.form.findField('s_isleaf').getRawValue();
    	this.getStore().baseParams['s_menuurl'] = this.queryformpanel.form.findField('s_menuurl').getRawValue();
    	this.getStore().baseParams['s_menulevel'] = this.queryformpanel.form.findField('s_menulevel').getRawValue();
    	this.getStore().baseParams['s_rootid'] = this.queryformpanel.form.findField('s_rootid').getRawValue();
    	this.getStore().baseParams['s_parentid'] = this.queryformpanel.form.findField('s_parentid').getRawValue();
    	this.getStore().baseParams['s_imagepath'] = this.queryformpanel.form.findField('s_imagepath').getRawValue();
    	this.getStore().baseParams['s_menuseq'] = this.queryformpanel.form.findField('s_menuseq').getRawValue();
    	this.getStore().baseParams['s_displayorder'] = this.queryformpanel.form.findField('s_displayorder').getRawValue();
		this.getStore().load();
		this.querywin.hide();
    }
    //工具类
    ,getRecordArrayUtils : function(records,field) {
		var result = [];
		for(var i = 0; i < records.length; i++) {
			result.push(records[i].get(field));
		}
		return result;
	}

});
 
/**
 * 注册主表格的xtype
 */
Ext.reg('ssmenu', com.dyneinfo.zazh.ssmenuGrid);


