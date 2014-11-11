var DepartmentForm=function(nodeId){
	var formPanel=this.initUI(nodeId);	
	var window = new Ext.Window({
        title: '部门信息',
        width: 400,
        height:350,
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
            			waitMsg:'正在提交部门信息',
			            success: function(formPanel, o){
            				Ext.Msg.alert('操作信息','部门保存成功！')
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
	        url:'../SsDept/add.do',      
	        defaultType: 'textfield',
	        reader: new Ext.data.JsonReader(
		        	{
		        	root:'data'
		        	},
		        	[
		        		 {name:'deptid',mapping:'deptid'}
		        		,{name:'deptname',mapping:'deptname'}
		        		,{name:'deptdesc',mapping:'deptdesc'}
		        		,{name:'deptcode',mapping:'deptcode'}
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
		        	,name:'deptid'
		        	,id:'deptid'
		        },{
	            	xtype:'hidden',
	            	name:'parentid',
	            	id:'parentid',
	            	value:nodeId
	            },
	            {
	            	xtype:'hidden',
	            	name:'deptseq',
	            	id:'deptseq'
	            },
	            {
	            	x:0,
	            	y:5,
	            	xtype:'label',
	            	text:'部门名'
	            },
	            {
	            	x:0,
	            	y:25,
	            	name:'deptname',
	            	blankText: '部门名为必填!',
	            	id:'deptname'
	            }
	            ,
	            {
	            	x:0,
	            	y:55,
	            	allowBlank: true,
	            	xtype:'label',
	            	text:'部门描述'
	            },
	            {
	            	x:0,
	            	y:75,
	            	xtype:'textarea',
	            	name:'deptdesc',
	            	blankText: '部门描述为必填!',
	            	id:'deptdesc'
	            },
	            {
	            	x:0,
	            	y:140,
	            	xtype:'label',
	            	text:'部门代码'
	            },
	            {
	            	x:0,
	            	y:160,
	            	allowBlank: true,
	            	name:'deptcode',
	            	id:'deptcode'
	            }
	            ]
	    });
	    return formPanel;
};

					
