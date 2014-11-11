/**
 * [SsUser] author by $YourName$
 * @include "../../extclient/RowExpander.js"
 * @include "../../extclient/gridToExcel.js"
 * @include "../../extclient/SearchField.js"
 */
 
Ext.namespace('com.dyneinfo.hotel');
Ext.namespace('com.dyneinfo.zazh.ssuser');

/**
 * 查询表单
 * @class com.dyneinfo.zazh.ssuser.queryformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssuser.queryformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        	,{xtype:'textfield',fieldLabel:'用户名',name:'s_username',width:288}
	        	,{xtype:'textfield',fieldLabel:'密码',name:'s_password',width:288}
	        	,{xtype:'textfield',fieldLabel:'姓名',name:'s_fullname',width:288}
	        	,{xtype:'textfield',fieldLabel:'性别',name:'s_sex',width:288}
	        	,{xtype:'textfield',fieldLabel:'身份证号',name:'s_sfzh',width:288}
	        	,{xtype:'textfield',fieldLabel:'警号',name:'s_policeid',width:288}
	        	,{xtype:'textfield',fieldLabel:'家庭电话',name:'s_phone',width:288}
	        	,{xtype:'textfield',fieldLabel:'移动电话',name:'s_mobile',width:288}
	        	,{xtype:'textfield',fieldLabel:'传真',name:'s_fax',width:288}
	        	,{xtype:'textfield',fieldLabel:'家庭住址',name:'s_address',width:288}
	        	,{xtype:'textfield',fieldLabel:'邮编',name:'s_zip',width:288}
	        	,{xtype:'textfield',fieldLabel:'电子邮件',name:'s_emailaddress',width:288}
	        	,{xtype:'textfield',fieldLabel:'有效期',name:'s_expirationdate',width:288}
	        	,{xtype:'textfield',fieldLabel:'部门ID',name:'s_deptid',width:288}
	        	,{xtype:'textfield',fieldLabel:'状态',name:'s_enabled',width:288}
	        	,{xtype:'textfield',fieldLabel:'照片',name:'s_photo',width:288}
	            ]
	    });
		com.dyneinfo.zazh.ssuser.queryformpanel.superclass.initComponent.call(this);
	}
});

/**
 * 查询窗口
 * @class com.dyneinfo.zazh.ssuser.querywin
 * @extends Ext.Window
 */
com.dyneinfo.zazh.ssuser.querywin = Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        title:'高级查询',
	        width:455,
	        height:395,
	        modal:true,
	        closeAction:'hide',
	        layout:'fit'
	    });
		com.dyneinfo.zazh.ssuser.querywin.superclass.initComponent.call(this);
	}
});

/**
 * 内容表单
 * @class com.dyneinfo.zazh.ssuser.dtlformpanel
 * @extends Ext.form.FormPanel
 */
com.dyneinfo.zazh.ssuser.dtlformpanel = Ext.extend(Ext.form.FormPanel,{
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
	        		,{xtype:'hidden',fieldLabel:'用户ID',name:'userid',width:288}
	        		,{xtype:'textfield',fieldLabel:'用户名',name:'username',width:288}
	        		,{xtype:'textfield',fieldLabel:'密码',name:'password',width:288}
	        		,{xtype:'textfield',fieldLabel:'姓名',name:'fullname',width:288}
	        		,{xtype:'textfield',fieldLabel:'性别',name:'sex',width:288}
	        		,{xtype:'textfield',fieldLabel:'身份证号',name:'sfzh',width:288}
	        		,{xtype:'textfield',fieldLabel:'警号',name:'policeid',width:288}
	        		,{xtype:'textfield',fieldLabel:'家庭电话',name:'phone',width:288}
	        		,{xtype:'textfield',fieldLabel:'移动电话',name:'mobile',width:288}
	        		,{xtype:'textfield',fieldLabel:'传真',name:'fax',width:288}
	        		,{xtype:'textfield',fieldLabel:'家庭住址',name:'address',width:288}
	        		,{xtype:'textfield',fieldLabel:'邮编',name:'zip',width:288}
	        		,{xtype:'textfield',fieldLabel:'电子邮件',name:'emailaddress',width:288}
	        		,{xtype:'textfield',fieldLabel:'有效期',name:'expirationdate',width:288}
	        		,{xtype:'textfield',fieldLabel:'部门ID',name:'deptid',width:288}
	        		,{xtype:'textfield',fieldLabel:'状态',name:'enabled',width:288}
	        		,{xtype:'textfield',fieldLabel:'照片',name:'photo',width:288}
	        ]
	    });
	    com.dyneinfo.zazh.ssuser.dtlformpanel .superclass.initComponent.call(this);
	}
	
});

/**
 * 表单窗口
 * @class com.dyneinfo.zazh.ssuser.dtlwin
 * @extends Ext.Window
 */		
com.dyneinfo.zazh.ssuser.dtlwin =  Ext.extend(Ext.Window,{
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
		com.dyneinfo.zazh.ssuser.dtlwin.superclass.initComponent.call(this);
	}
});


/**
 * 主表格入口
 * @class com.dyneinfo.zazh.ssuser
 * @extends Ext.grid.GridPanel
 */
com.dyneinfo.zazh.ssuserGrid = Ext.extend(Ext.grid.GridPanel,{
    initComponent:function() {
    	this.pageSize=10;
    	this.ds = new Ext.data.Store({
	        url:'../SsUser/extlist.do',
	        reader:new Ext.data.JsonReader({
	            root:'list',
	            totalProperty:'totalSize',
	            id:'id'
		        }
		        ,['userid','username','password','fullname','sex','sfzh','policeid','phone','mobile','fax','address','zip','emailaddress','expirationdate','deptid','enabled','photo',]
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
	        ,{header:'用户名',width:100,sortable:true,dataIndex:'username'}
	        ,{header:'密码',width:100,sortable:true,dataIndex:'password'}
	        ,{header:'姓名',width:100,sortable:true,dataIndex:'fullname'}
	        ,{header:'性别',width:100,sortable:true,dataIndex:'sex'}
	        ,{header:'身份证号',width:100,sortable:true,dataIndex:'sfzh'}
	        ,{header:'警号',width:100,sortable:true,dataIndex:'policeid'}
	        ,{header:'家庭电话',width:100,sortable:true,dataIndex:'phone'}
	        ,{header:'移动电话',width:100,sortable:true,dataIndex:'mobile'}
	        ,{header:'传真',width:100,sortable:true,dataIndex:'fax'}
	        ,{header:'家庭住址',width:100,sortable:true,dataIndex:'address'}
	        ,{header:'邮编',width:100,sortable:true,dataIndex:'zip'}
	        ,{header:'电子邮件',width:100,sortable:true,dataIndex:'emailaddress'}
	        ,{header:'有效期',width:100,sortable:true,dataIndex:'expirationdate'}
	        ,{header:'部门ID',width:100,sortable:true,dataIndex:'deptid'}
	        ,{header:'状态',width:100,sortable:true,dataIndex:'enabled'}
	        ,{header:'照片',width:100,sortable:true,dataIndex:'photo'}
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
	        	{text:'新增',cls:'x-btn-text-icon',iconCls:'addicon',handler:this.addSsUser,scope:this},'-'
	        	,{text:'修改',cls:'x-btn-text-icon',iconCls:'editicon',handler:this.editSsUser,scope:this},'-'
	        	,{text:'删除',cls:'x-btn-text-icon',iconCls:'deleteicon',handler:this.deleteSsUser,scope:this},'-'
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
        			data: [['用户名', 'username'],['密码', 'password'],['姓名', 'fullname'],['性别', 'sex'],['身份证号', 'sfzh'],['警号', 'policeid'],['家庭电话', 'phone'],['移动电话', 'mobile'],['传真', 'fax'],['家庭住址', 'address'],['邮编', 'zip'],['电子邮件', 'emailaddress'],['有效期', 'expirationdate'],['部门ID', 'deptid'],['状态', 'enabled'],['照片', 'photo']]
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
        com.dyneinfo.zazh.ssuserGrid.superclass.initComponent.call(this);
        //加载数据
        this.store.load({params:{start:0}});
        
 		//扩展类的详细弹出窗口
 		this.dtlformpanel = new com.dyneinfo.zazh.ssuser.dtlformpanel();
 		this.dtlwin =  new com.dyneinfo.zazh.ssuser.dtlwin({items:this.dtlformpanel,buttons:[{
	            text:'保存',
	            handler:this.saveSsUser,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.dtlwin.hide();},
	            scope:this
	        }]});
	    
	    //扩展类的查询弹出窗口
	    this.queryformpanel = new com.dyneinfo.zazh.ssuser.queryformpanel();
	    this.querywin =  new com.dyneinfo.zazh.ssuser.querywin({items:this.queryformpanel,buttons:[{
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
				        this.dtlwin.setTitle('修改SsUser');
				        this.dtlwin.show();
				        this.dtlformpanel.form.reset();
				        this.dtlformpanel.form.loadRecord(record);
				        this.dtlformpanel.url = '../SsUser/extupdate.do';
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
						url:'../SsUser/extdelete.do?ids='+record.data.userid,
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
        this.dtlwin.setTitle('修改SsUser');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
        this.dtlformpanel.form.loadRecord(record);
        this.dtlformpanel.url = '../SsUser/extupdate.do';
    }
    
    //新建窗口
    ,addSsUser : function(){
        this.dtlwin.setTitle('新建SsUser');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
	    this.dtlformpanel.url = '../SsUser/extsave.do';
	}
	
	//编辑操作
    ,editSsUser:function(){
    	var records = this.getSelectionModel().getSelections();//单选
    	
	   if (records.length!=1) {
			Ext.Msg.alert("提示", "请先选择要修改的记录");
			return;
		}
	    this.dtlwin.setTitle('修改SsUser');
	    this.dtlwin.show();
	    this.dtlformpanel.form.reset();
	    this.dtlformpanel.form.loadRecord(records[0]);
	    this.dtlformpanel.url = '../SsUser/extupdate.do';

    }
    
    //删除操作
    ,deleteSsUser:function(){
    	var records = this.getSelectionModel().getSelections();
		if (!records||records.length == 0) {
			Ext.Msg.alert("提示", "请先选择要删除的�记录");
			return;
		}
		Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
			if (btn == 'yes'){
				Ext.Ajax.request({
					url:'../SsUser/extdelete.do?ids='+this.getRecordArrayUtils(records, 'userid'),
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
    ,saveSsUser:function(){
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
    	this.getStore().baseParams['s_username'] = this.queryformpanel.form.findField('s_username').getRawValue();
    	this.getStore().baseParams['s_password'] = this.queryformpanel.form.findField('s_password').getRawValue();
    	this.getStore().baseParams['s_fullname'] = this.queryformpanel.form.findField('s_fullname').getRawValue();
    	this.getStore().baseParams['s_sex'] = this.queryformpanel.form.findField('s_sex').getRawValue();
    	this.getStore().baseParams['s_sfzh'] = this.queryformpanel.form.findField('s_sfzh').getRawValue();
    	this.getStore().baseParams['s_policeid'] = this.queryformpanel.form.findField('s_policeid').getRawValue();
    	this.getStore().baseParams['s_phone'] = this.queryformpanel.form.findField('s_phone').getRawValue();
    	this.getStore().baseParams['s_mobile'] = this.queryformpanel.form.findField('s_mobile').getRawValue();
    	this.getStore().baseParams['s_fax'] = this.queryformpanel.form.findField('s_fax').getRawValue();
    	this.getStore().baseParams['s_address'] = this.queryformpanel.form.findField('s_address').getRawValue();
    	this.getStore().baseParams['s_zip'] = this.queryformpanel.form.findField('s_zip').getRawValue();
    	this.getStore().baseParams['s_emailaddress'] = this.queryformpanel.form.findField('s_emailaddress').getRawValue();
    	this.getStore().baseParams['s_expirationdate'] = this.queryformpanel.form.findField('s_expirationdate').getRawValue();
    	this.getStore().baseParams['s_deptid'] = this.queryformpanel.form.findField('s_deptid').getRawValue();
    	this.getStore().baseParams['s_enabled'] = this.queryformpanel.form.findField('s_enabled').getRawValue();
    	this.getStore().baseParams['s_photo'] = this.queryformpanel.form.findField('s_photo').getRawValue();
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
Ext.reg('ssuser', com.dyneinfo.zazh.ssuserGrid);


