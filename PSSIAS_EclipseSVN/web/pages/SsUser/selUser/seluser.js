

StaffSelectPanel = function() {

	StaffSelectPanel.superclass.constructor.apply(this, arguments);
	
	this.selectNodes = [];

	if (!Ext.isEmpty(this.initSelectNodes)) {
		if (typeof this.initSelectNodes == "string") {
			this.selectNodes = this.initSelectNodes.split(",");
		} else if (typeof this.initSelectNodes == "array") {
			this.selectNodes = this.initSelectNodes;
		}
	}
	this.loader = new Ext.tree.TreeLoader( {
		dataUrl : this.serviceUrl,
		baseAttrs : {
			uiProvider : Ext.tree.TreeCheckNodeUI
		} // 添加 uiProvider 属性
	});
	
	

};

Ext.extend(StaffSelectPanel, Ext.tree.TreePanel, {
	/* 以上为扩展属性 */
	animate : false,
	rootVisible : true,
	autoScroll : true,
	root : new Ext.tree.AsyncTreeNode( {
		id : '-1',
		expanded : true,// 展开
		text : '所有部门'
	}),
	listeners : {
		"expandnode" : function(node) {
			var selectln = 0;
			var childln = node.childNodes.length;			
			for (var i = 0;i < childln; i++) {
				selectln = this.selectNodes.length;
				if (selectln > 0) {
					var tmpNode = node.childNodes[i];
					for (var j = 0;j < selectln; j++) {
						if (tmpNode.id == this.selectNodes[j]) {
							tmpNode.ui.toggleCheck(true);
							tmpNode.attributes.checked = true;
							this.selectNodes.splice(j,1);
							break;
						};
					}
				}
			}

		},
		"check":function(node,checked){
			this.lastSelectNode=node;
		}
	},
	/*************************************** 下面是对外的接口 *********************/
	
	// 获取选中的节点的文本
	getSelectNodesText : function() {	
		return this.getSelectNodesAttributes("text");
	},
	
	//获取最后一个被选择的节点
	getLastSelectNode:function()
	{
		return  this.lastSelectNode;
	},
	// 获取所有选中的节点的指定的属性的值
	getSelectNodesAttributes : function(attributesName) {
		var tArray = [];
		var selectNodes = this.getChecked();
		var ln =selectNodes.length;
		for(var i=0;i<ln;i++)
		{			
			eval("tArray[tArray.length]=selectNodes[i].attributes."+attributesName);
		}
		return tArray;
	},
	
	// 获取选中的节点的keys
	getSelectNodesKeys : function() {
		var array = [];
		var selectNodes = this.getChecked();
		var ln =selectNodes.length;
		for(var i=0;i<ln;i++)
		{
			array[array.length] = selectNodes[i].id;
		}
		return array;
	},
	
	/*查找子节点 	
	 * Node:开始查找的节点 
	 * key: 节点attributes属性, 
	 * value: key属性所对应的值 
	 * deep: 是否递归
	 */
	findChildrenNode:function(node, key, value, deep) {

		var nodes = node.childNodes;

		for (var i = 0;i < nodes.length; i++) {

			if (nodes[i].attributes[key] == value) {
				return nodes[i];
			} else {
				if (deep && nodes[i].hasChildNodes()) {
					if (node = this.findChildrenNode(nodes[i], key, value, deep)) {
						return node;
					}
				}
			}
		}
		return null;
	},
	
	/*查找节点
	 * key: 节点attributes属性, 
	 * value: key属性所对应的值 
	 * deep: 是否递归
	 */
	findNode:function( key, value, deep)
	{
		return this.findChildrenNode(this.getRootNode(), key, value, deep);
	},
	
	/*
	 * 获取当先选择的所有节点
	 * 返回的是所有被选中的节点的集合 :Ext.util.MixedCollection
	 */
	getSelectNodes:function()
	{
		return this.getChecked();
	},
	

	/*设置选择的节点
	 * nodes:string 或者 array例如:"1,2,3",[1,2,3,4]
	 */ 
	setSelectNodes : function(nodes) {
		var selectNodes=[];
		if (!Ext.isEmpty(nodes)) {
			if (typeof nodes == "string") {
				selectNodes = nodes.split(",");
			} else if (typeof nodes == "array") {
				selectNodes = nodes;
			}			
			var ln= selectNodes.length;
			for(var i=0;i<ln;i++)
			{
				var node = this.findNode('id',selectNodes[i],true);
				if(node)
				{
					node.ui.toggleCheck(true);
					node.attributes.checked = true;
				}
			}
			//this.collapse();//收起来所有的节点,为了展开的时候能够触发展开事件,
		}
	},
	
	/*循环所有选中的节点
	 * fn参数是一个方法:执行的过程中这个方法会收到两个参数(key,node)
	 */
	eachSelectNodes:function(fn)
	{
		if(typeof fn =="undefind")
		{
			return;
		}else if(typeof fn =="function")
		{
			var selectNodes = this.getChecked();
			var ln= selectNodes.length;
			for(var i=0;i<ln;i++)
			{
				fn(selectNodes[i].id,selectNodes[i])			
			}
		}
	}
	
});
/*
 * 
 * var tree = new Ext.tree.TreePanel({ checkModel: 'single', //对树的级联多选
 * onlyLeafCheckable: true,//对树所有结点都可选 animate: false, rootVisible: false,
 * autoScroll:true, loader: new Ext.tree.TreeLoader( { dataUrl :
 * "/govoa/showdepttree/", baseAttrs: { uiProvider: Ext.tree.TreeCheckNodeUI }
 * //添加 uiProvider 属性 }), root: new Ext.tree.AsyncTreeNode({ id:'-1' }) });
 * tree.on("check",function(node,checked){alert(node.text+" = "+checked)});
 * //注册"check"事件
 */