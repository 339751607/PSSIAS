/**
 * [SsDept] author by $YourName$
 * @include "../../extclient/RowExpander.js"
 * @include "../../extclient/gridToExcel.js"
 * @include "../../extclient/SearchField.js"
 */
 
Ext.namespace('com.dyneinfo.hotel');
Ext.namespace('com.dyneinfo.zazh.ssdept');

/**
 * 查询表单
 * @class com.dyneinfo.zazh.ssdept.queryformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssdept.queryformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        	,{xtype:'textfield',fieldLabel:'部门名称',name:'s_deptname',width:288}
	        	,{xtype:'textfield',fieldLabel:'部门描述',name:'s_deptdesc',width:288}
	        	,{xtype:'textfield',fieldLabel:'部门代码',name:'s_deptcode',width:288}
	        	,{xtype:'textfield',fieldLabel:'SEQ',name:'s_deptseq',width:288}
	        	,{xtype:'textfield',fieldLabel:'显示顺序',name:'s_displayorder',width:288}
	        	,{xtype:'textfield',fieldLabel:'父部门',name:'s_parentid',width:288}
	            ]
	    });
		com.dyneinfo.zazh.ssdept.queryformpanel.superclass.initComponent.call(this);
	}
});

/**
 * 查询窗口
 * @class com.dyneinfo.zazh.ssdept.querywin
 * @extends Ext.Window
 */
com.dyneinfo.zazh.ssdept.querywin = Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        title:'高级查询',
	        width:455,
	        height:395,
	        modal:true,
	        closeAction:'hide',
	        layout:'fit'
	    });
		com.dyneinfo.zazh.ssdept.querywin.superclass.initComponent.call(this);
	}
});

/**
 * 内容表单
 * @class com.dyneinfo.zazh.ssdept.dtlformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssdept.dtlformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        		,{xtype:'hidden',fieldLabel:'部门ID',name:'deptid',width:288}
	        		,{xtype:'textfield',fieldLabel:'部门名称',name:'deptname',width:288}
	        		,{xtype:'textfield',fieldLabel:'部门描述',name:'deptdesc',width:288}
	        		,{xtype:'textfield',fieldLabel:'部门代码',name:'deptcode',width:288}
	        		,{xtype:'textfield',fieldLabel:'SEQ',name:'deptseq',width:288}
	        		,{xtype:'textfield',fieldLabel:'显示顺序',name:'displayorder',width:288}
	        		,{xtype:'textfield',fieldLabel:'父部门',name:'parentid',width:288}
	        ]
	    });
	    com.dyneinfo.zazh.ssdept.dtlformpanel .superclass.initComponent.call(this);
	}
	
});

/**
 * 表单窗口
 * @class com.dyneinfo.zazh.ssdept.dtlwin
 * @extends Ext.Window
 */		
com.dyneinfo.zazh.ssdept.dtlwin =  Ext.extend(Ext.Window,{
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
		com.dyneinfo.zazh.ssdept.dtlwin.superclass.initComponent.call(this);
	}
});


/**
 * 主表格入口
 * @class com.dyneinfo.zazh.ssdept
 * @extends Ext.grid.GridPanel
 */
com.dyneinfo.zazh.ssdeptGrid = Ext.extend(Ext.grid.GridPanel,{
    initComponent:function() {
    	this.pageSize=10;
    	this.ds = new Ext.data.Store({
	        url:'../SsDept/extlist.do',
	        reader:new Ext.data.JsonReader({
	            root:'list',
	            totalProperty:'totalSize',
	            id:'id'
		        }
		        ,['deptid','deptname','deptdesc','deptcode','deptseq','displayorder','parentid',]
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
	        ,{header:'部门名称',width:100,sortable:true,dataIndex:'deptname'}
	        ,{header:'部门描述',width:100,sortable:true,dataIndex:'deptdesc'}
	        ,{header:'部门代码',width:100,sortable:true,dataIndex:'deptcode'}
	        ,{header:'SEQ',width:100,sortable:true,dataIndex:'deptseq'}
	        ,{header:'显示顺序',width:100,sortable:true,dataIndex:'displayorder'}
	        ,{header:'父部门',width:100,sortable:true,dataIndex:'parentid'}
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
	        	{text:'新增',cls:'x-btn-text-icon',iconCls:'addicon',handler:this.addSsDept,scope:this},'-'
	        	,{text:'修改',cls:'x-btn-text-icon',iconCls:'editicon',handler:this.editSsDept,scope:this},'-'
	        	,{text:'删除',cls:'x-btn-text-icon',iconCls:'deleteicon',handler:this.deleteSsDept,scope:this},'-'
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
        			data: [['部门名称', 'deptname'],['部门描述', 'deptdesc'],['部门代码', 'deptcode'],['SEQ', 'deptseq'],['显示顺序', 'displayorder'],['父部门', 'parentid']]
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
        com.dyneinfo.zazh.ssdeptGrid.superclass.initComponent.call(this);
        //加载数据
        this.store.load({params:{start:0}});
        
 		//扩展类的详细弹出窗口
 		this.dtlformpanel = new com.dyneinfo.zazh.ssdept.dtlformpanel();
 		this.dtlwin =  new com.dyneinfo.zazh.ssdept.dtlwin({items:this.dtlformpanel,buttons:[{
	            text:'保存',
	            handler:this.saveSsDept,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.dtlwin.hide();},
	            scope:this
	        }]});
	    
	    //扩展类的查询弹出窗口
	    this.queryformpanel = new com.dyneinfo.zazh.ssdept.queryformpanel();
	    this.querywin =  new com.dyneinfo.zazh.ssdept.querywin({items:this.queryformpanel,buttons:[{
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
				        this.dtlwin.setTitle('修改SsDept');
				        this.dtlwin.show();
				        this.dtlformpanel.form.reset();
				        this.dtlformpanel.form.loadRecord(record);
				        this.dtlformpanel.url = '../SsDept/extupdate.do';
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
						url:'../SsDept/extdelete.do?ids='+record.data.deptid,
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
        this.dtlwin.setTitle('修改SsDept');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
        this.dtlformpanel.form.loadRecord(record);
        this.dtlformpanel.url = '../SsDept/extupdate.do';
    }
    
    //新建窗口
    ,addSsDept : function(){
        this.dtlwin.setTitle('新建SsDept');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
	    this.dtlformpanel.url = '../SsDept/extsave.do';
	}
	
	//编辑操作
    ,editSsDept:function(){
    	var records = this.getSelectionModel().getSelections();//单选
    	
	   if (records.length!=1) {
			Ext.Msg.alert("提示", "请先选择要修改的记录");
			return;
		}
	    this.dtlwin.setTitle('修改SsDept');
	    this.dtlwin.show();
	    this.dtlformpanel.form.reset();
	    this.dtlformpanel.form.loadRecord(records[0]);
	    this.dtlformpanel.url = '../SsDept/extupdate.do';

    }
    
    //删除操作
    ,deleteSsDept:function(){
    	var records = this.getSelectionModel().getSelections();
		if (!records||records.length == 0) {
			Ext.Msg.alert("提示", "请先选择要删除的�记录");
			return;
		}
		Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
			if (btn == 'yes'){
				Ext.Ajax.request({
					url:'../SsDept/extdelete.do?ids='+this.getRecordArrayUtils(records, 'deptid'),
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
    ,saveSsDept:function(){
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
    	this.getStore().baseParams['s_deptname'] = this.queryformpanel.form.findField('s_deptname').getRawValue();
    	this.getStore().baseParams['s_deptdesc'] = this.queryformpanel.form.findField('s_deptdesc').getRawValue();
    	this.getStore().baseParams['s_deptcode'] = this.queryformpanel.form.findField('s_deptcode').getRawValue();
    	this.getStore().baseParams['s_deptseq'] = this.queryformpanel.form.findField('s_deptseq').getRawValue();
    	this.getStore().baseParams['s_displayorder'] = this.queryformpanel.form.findField('s_displayorder').getRawValue();
    	this.getStore().baseParams['s_parentid'] = this.queryformpanel.form.findField('s_parentid').getRawValue();
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
Ext.reg('ssdept', com.dyneinfo.zazh.ssdeptGrid);


