var DepartmentForm=function(nodeId){
	var formPanel=this.initUI(nodeId);	
	var window = new Ext.Window({
        title: '角色信息',
        width: 400,
        height:250,
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
            			waitMsg:'正在提交角色信息',
			            success: function(formPanel, o){
            				Ext.Msg.alert('操作信息','角色保存成功！')
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

DepartmentForm.prototype.initUI=function(nodeId){
var formPanel = new Ext.form.FormPanel({

	        id:'departmentForm',
	        baseCls: 'x-plain',
	        layout:'absolute',
	        defaultType: 'textfield',
	        url:'../SsRole/extsave.do',      
	        defaultType: 'textfield',
	        reader: new Ext.data.JsonReader(
		        	{
		        	root:'data'
		        	},
		        	[
		        		 {name:'roleid',mapping:'roleid'}
		        		,{name:'rolename',mapping:'rolename'}
		        		,{name:'roledesc',mapping:'roledesc'}
		        		,{name:'parentid',mapping:'parentid'}
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
		        	,name:'roleid'
		        	,id:'roleid'
		        },{
	            	xtype:'hidden',
	            	name:'parentid',
	            	id:'parentid',
	            	value:nodeId
	            },
	            {
	            	xtype:'hidden',
	            	name:'roleseq',
	            	id:'roleseq'
	            },
	            {
	            	x:0,
	            	y:5,
	            	xtype:'label',
	            	text:'角色名'
	            },
	            {
	            	x:85,
	            	y:5,
	            	name:'rolename',
	            	blankText: '角色名名为必填!',
	            	id:'rolename'
	            }
	            ,
	            {
	            	x:0,
	            	y:55,
	            	allowBlank: true,
	            	xtype:'label',
	            	text:'角色描述'
	            },
	            {
	            	x:85,
	            	y:55,
	            	xtype:'textarea',
	            	name:'roledesc',
	            	blankText: '角色描述为必填!',
	            	id:'roledesc'
	            }
	            ]
	    });
	    return formPanel;
};

					
