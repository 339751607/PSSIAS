/**
 * [SsAuthority] author by $YourName$
 * @include "../../extclient/RowExpander.js"
 * @include "../../extclient/gridToExcel.js"
 * @include "../../extclient/SearchField.js"
 */
 
Ext.namespace('com.dyneinfo.hotel');
Ext.namespace('com.dyneinfo.zazh.ssauthority');

/**
 * 查询表单
 * @class com.dyneinfo.zazh.ssauthority.queryformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssauthority.queryformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        	,{xtype:'textfield',fieldLabel:'权限名称',minLength :2,maxLength : 25,name:'s_authorityname',width:288}
	        	,{xtype:'textfield',fieldLabel:'权限描述',minLength :2,maxLength : 100,name:'s_authoritydesc',width:288}
	        	,{xtype:'combo',mode : 'local',triggerAction : 'all',fieldLabel: '权限类型',store: new Ext.data.SimpleStore({fields: ['value','text'],data: [['URL','链接URL']]}),name: 's_authoritytypeText',hiddenName: 's_authoritytype',valueField: 'value',displayField: 'text',readOnly: true}
				,{xtype:'textfield',fieldLabel:'权限值',minLength :2,maxLength : 100,name:'s_authorityvalue',width:288}
	        	
	            ]
	    });
		com.dyneinfo.zazh.ssauthority.queryformpanel.superclass.initComponent.call(this);
	}
});

/**
 * 查询窗口
 * @class com.dyneinfo.zazh.ssauthority.querywin
 * @extends Ext.Window
 */
com.dyneinfo.zazh.ssauthority.querywin = Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        title:'高级查询',
	        width:455,
	        height:395,
	        modal:true,
	        closeAction:'hide',
	        layout:'fit'
	    });
		com.dyneinfo.zazh.ssauthority.querywin.superclass.initComponent.call(this);
	}
});

/**
 * 内容表单
 * @class com.dyneinfo.zazh.ssauthority.dtlformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssauthority.dtlformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        		,{xtype:'hidden',fieldLabel:'权限ID',name:'authorityid',width:288}
	        		,{xtype:'textfield',fieldLabel:'权限名称*',minLength :2,maxLength : 25,allowBlank: false,name:'authorityname',width:288}
	        		,{xtype:'textfield',fieldLabel:'权限描述',minLength :2,maxLength : 100,name:'authoritydesc',width:288}
					,{xtype:'combo',mode : 'local',triggerAction : 'all',allowBlank: false,emptyText: '请选择',fieldLabel: '权限类型*',store: new Ext.data.SimpleStore({fields: ['value','text'],data: [['URL','URL']]}),name: 'authoritytypeText',hiddenName: 'authoritytype',valueField: 'value',displayField: 'text',readOnly: true,width:288}
	        		,{xtype:'textfield',fieldLabel:'权限值*',minLength :2,maxLength : 100,allowBlank: false,name:'authorityvalue',width:288}
	        ]
	    });
	    com.dyneinfo.zazh.ssauthority.dtlformpanel .superclass.initComponent.call(this);
	}
	
});

/**
 * 表单窗口
 * @class com.dyneinfo.zazh.ssauthority.dtlwin
 * @extends Ext.Window
 */		
com.dyneinfo.zazh.ssauthority.dtlwin =  Ext.extend(Ext.Window,{
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
		com.dyneinfo.zazh.ssauthority.dtlwin.superclass.initComponent.call(this);
	}
});


/**
 * 主表格入口
 * @class com.dyneinfo.zazh.ssauthority
 * @extends Ext.grid.GridPanel
 */
com.dyneinfo.zazh.ssauthorityGrid = Ext.extend(Ext.grid.GridPanel,{
    initComponent:function() {
    	this.pageSize=15;
    	this.ds = new Ext.data.Store({
	        url:'../SsAuthority/extlist.do',
	        reader:new Ext.data.JsonReader({
	            root:'list',
	            totalProperty:'totalSize',
	            id:'id'
		        }
		        ,['authorityid','authorityname','authoritydesc','authoritytype','authorityvalue',]
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
		    this.sm
	        ,{header:'权限名称',width:100,sortable:true,dataIndex:'authorityname'}
	        ,{header:'权限描述',width:100,sortable:true,dataIndex:'authoritydesc'}
	        ,{header:'权限类型',width:100,sortable:true,dataIndex:'authoritytype'}
	        ,{header:'权限值',width:100,sortable:true,dataIndex:'authorityvalue'}
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
	        	{text:'新增',cls:'x-btn-text-icon',iconCls:'addicon',handler:this.addSsAuthority,scope:this},'-'
	        	,{text:'修改',cls:'x-btn-text-icon',iconCls:'editicon',handler:this.editSsAuthority,scope:this},'-'
	        	,{text:'删除',cls:'x-btn-text-icon',iconCls:'deleteicon',handler:this.deleteSsAuthority,scope:this},'-'
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
        			data: [['权限名称', 'authorityname'],['权限描述', 'authoritydesc'],['权限类型', 'authoritytype'],['权限值', 'authorityvalue']]
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
        com.dyneinfo.zazh.ssauthorityGrid.superclass.initComponent.call(this);
        //加载数据
        this.store.load({params:{start:0}});
        
 		//扩展类的详细弹出窗口
 		this.dtlformpanel = new com.dyneinfo.zazh.ssauthority.dtlformpanel();
 		this.dtlwin =  new com.dyneinfo.zazh.ssauthority.dtlwin({items:this.dtlformpanel,buttons:[{
	            text:'保存',
	            handler:this.saveSsAuthority,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.dtlwin.hide();},
	            scope:this
	        }]});
	    
	    //扩展类的查询弹出窗口
	    this.queryformpanel = new com.dyneinfo.zazh.ssauthority.queryformpanel();
	    this.querywin =  new com.dyneinfo.zazh.ssauthority.querywin({items:this.queryformpanel,buttons:[{
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
				        this.dtlwin.setTitle('修改SsAuthority');
				        this.dtlwin.show();
				        this.dtlformpanel.form.reset();
				        this.dtlformpanel.form.loadRecord(record);
				        this.dtlformpanel.url = '../SsAuthority/extupdate.do';
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
						url:'../SsAuthority/extdelete.do?ids='+record.data.authorityid,
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
        this.dtlwin.setTitle('修改SsAuthority');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
        this.dtlformpanel.form.loadRecord(record);
        this.dtlformpanel.url = '../SsAuthority/extupdate.do';
    }
    
    //新建窗口
    ,addSsAuthority : function(){
        this.dtlwin.setTitle('新建SsAuthority');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
	    this.dtlformpanel.url = '../SsAuthority/extsave.do';
	}
	
	//编辑操作
    ,editSsAuthority:function(){
    	var records = this.getSelectionModel().getSelections();//单选
    	
	   if (records.length!=1) {
			Ext.Msg.alert("提示", "请先选择要修改的记录");
			return;
		}
	    this.dtlwin.setTitle('修改SsAuthority');
	    this.dtlwin.show();
	    this.dtlformpanel.form.reset();
	    this.dtlformpanel.form.loadRecord(records[0]);
	    this.dtlformpanel.url = '../SsAuthority/extupdate.do';

    }
    
    //删除操作
    ,deleteSsAuthority:function(){
    	var records = this.getSelectionModel().getSelections();
		if (!records||records.length == 0) {
			Ext.Msg.alert("提示", "请先选择要删除的�记录");
			return;
		}
		Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
			if (btn == 'yes'){
				Ext.Ajax.request({
					url:'../SsAuthority/extdelete.do?ids='+this.getRecordArrayUtils(records, 'authorityid'),
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
    ,saveSsAuthority:function(){
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
    	this.getStore().baseParams['s_authorityname'] = this.queryformpanel.form.findField('s_authorityname').getRawValue();
    	this.getStore().baseParams['s_authoritydesc'] = this.queryformpanel.form.findField('s_authoritydesc').getRawValue();
    	this.getStore().baseParams['s_authoritytype'] = this.queryformpanel.form.findField('s_authoritytype').getRawValue();
    	this.getStore().baseParams['s_authorityvalue'] = this.queryformpanel.form.findField('s_authorityvalue').getRawValue();
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
Ext.reg('ssauthority', com.dyneinfo.zazh.ssauthorityGrid);


