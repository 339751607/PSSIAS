var MenuForm=function(nodeId){
	var formPanel=this.initUI(nodeId);	
	var window = new Ext.Window({
        title: '菜单信息',
        width: 450,
        height:400,
        layout: 'fit',
        plain:true,
        bodyStyle:'padding:5px;',
        buttonAlign:'center',
        items: formPanel,
        buttons: [{
            text: '保存',
            iconCls:'btn-save',
            handler:function(){
        	   var tree1 = Ext.getCmp('treePanel');
        	   if(formPanel.getForm().isValid()){
            		formPanel.getForm().submit({
            			waitMsg:'正在提交菜单信息',
			            success: function(formPanel, o){
            				Ext.Msg.alert('操作信息','保存成功！')
            				var treeState = Ext.state.Manager.get("treestate");
            				window.close();            				
            				tree1.root.reload();
            				if (treeState)
            				tree1.expandPath(treeState);
            			}
            		});
            	}
            }
            
        },{
            text: '取消',
            handler:function(){
        	window.close();
        }
        }]
    });
    window.show();
};

MenuForm.prototype.initUI=function(nodeId){
var formPanel = new Ext.form.FormPanel({

	        id:'menuForm',
	        baseCls: 'x-plain',
	        layout:'absolute',
	        defaultType: 'textfield',
	        url:'../SsMenu/add.do',      
	        defaultType: 'textfield',
	        reader: new Ext.data.JsonReader(
		        	{
		        	root:'data'
		        	},
		        	[
		        		 {name:'menuid',mapping:'menuid'}
		        		,{name:'menuname',mapping:'menuname'}
		        		,{name:'menudesc',mapping:'menudesc'}
		        		,{name:'isleaf',mapping:'isleaf'}
		        		,{name:'menuurl',mapping:'menuurl'}
		        		,{name:'parentid',mapping:'parentid'}
		        		,{name:'imagepath',mapping:'imagepath'}
		        		,{name:'displayorder',mapping:'displayorder'}
		        	]
		        	),
	        
	        defaults: {
	            anchor: '95%,95%',
	            allowBlank: false,
	            selectOnFocus: true,
	            msgTarget: 'side'
	        },
	        items:[{
		        	xtype:'hidden'
		        	,name:'menuid'
		        	,id:'menuid'
		        },{
	            	xtype:'hidden',
	            	name:'parentid',
	            	id:'parentid',
	            	value:nodeId
	            },
	            {
	            	x:0,
	            	y:5,
	            	xtype:'label',
	            	text:'菜单名'
	            },
	            {
	            	x:0,
	            	y:25,
	            	name:'menuname',
	            	blankText: '菜单名为必填!',
	            	id:'menuname'
	            }
	            ,
	            {
	            	x:0,
	            	y:55,
	            	allowBlank: true,
	            	xtype:'label',
	            	text:'菜单描述'
	            },
	            
	            {
	            	x:0,
	            	y:75,
	            	xtype:'textarea',
	            	name:'menudesc',
	            	blankText: '菜单描述为必填!',
	            	id:'menudesc'
	            },{
	            	x:0,
	            	y:145,
	            	xtype:'label',
	            	text:'是否子节点'
	            },{
	                    x:0,
	            	    y:170,
						hiddenName : 'isleaf',
						id : 'isContract',
						xtype : 'combo',
						mode : 'local',
						editable : true,
						triggerAction : 'all',
						store : [['N', '否'], ['Y', '是']],
						value : 'N'
					},{
	            	x:0,
	            	y:195,
	            	xtype:'label',
	            	text:'菜单链接'
	            },
	            {
	            	x:0,
	            	y:220,
	            	name:'menuurl',
	            	allowBlank: true,
	            	blankText: '菜单链接为必填!',
	            	id:'menuurl'
	            },{
	            	x:0,
	            	y:245,
	            	xtype:'label',
	            	text:'显示顺序'
	            },
	            {
	            	x:0,
	            	y:270,
	            	xtype : 'numberfield',
	            	name:'displayorder',
	            	blankText: '显示顺序为必填!',
	            	id:'displayorder'
	            }
	            
	            ]
	    });
	    return formPanel;
};

					
