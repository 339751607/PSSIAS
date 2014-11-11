/**下拉树工具类
 * 用法: new TreeSelector(_id,_url,_label,_field); 返回类型为Ext.form.ComboBox
 * @param {} _id:下拉树的ID
 * @param {} _url:读取下拉树JSON数据的URL,JSON数据的格式是Ext.tree.TreeLoader能接收的数据格式
 * @param {} _label:是该下拉树的fieldLabel
 * @param {} _field:修改域的ID,根据此ID把其树结点的id的值赋给该域
 * @return {} Ext.form.ComboBox
 */

var TreeSelector4User = function(_id,_url,_label,_field) {

	var config={
		id:_id,
		store : new Ext.data.SimpleStore({
					fields : [],
					data : [[]]
				}),
		editable : false,
		mode : 'local',
		fieldLabel:_label,
		allowBlank: false,
		emptyText : "请选择",
		triggerAction : 'all',
		maxHeight : 200,
		tpl : "<tpl for='.'><div style='height:200px'><div id='tree'></div></div></tpl>",
		selectedClass : '',
		onSelect : Ext.emptyFn
	};
	var comboxWithTree = new Ext.form.ComboBox(config);
	
	        // 创建一个简写
    var Tree = Ext.tree;
    // 定义根节点的Loader
    var treeloader = new Tree.TreeLoader({
            // dataUrl : 'tree.jsp'//这里可以不需要指定URL，在加载前事件响应里面设置

            });

	var tree = new Ext.tree.TreePanel({
		id:'selectTree',
		height:200,
		autoScroll: true,
		split: true,
		//loader: new Ext.tree.TreeLoader({url:_url}),
	   // root: new Ext.tree.AsyncTreeNode({expanded: true}),
	    loader : treeloader,
	    rootVisible: false
	});
	var rootnode = new Tree.AsyncTreeNode({
                id : '0',
                text : '组织结构',
                draggable : false,// 根节点不容许拖动
                expanded : true
            });
    // 为tree设置根节点
    tree.setRootNode(rootnode);
    // 响应加载前事件，传递node参数
    tree.on('beforeload', function(node) {
                tree.loader.dataUrl = '../SsDept/getTrees.do?parentId=' + node.id; // 定义子节点的Loader
            });
    rootnode.expand(false,false);  
	tree.on('click', function(node) {
				var editField = Ext.getCmp(_field);//根据要修改的域的ID取得该域
				if(node.id!=null&&node.id!=''){
					comboxWithTree.setValue(node.text);
					comboxWithTree.id=node.id;
					comboxWithTree.collapse();
					editField.setValue(node.id); //把树结点的值赋给要修改的域
				}
	});
	comboxWithTree.on('expand', function() {
				tree.render('tree');
	});
	return comboxWithTree
};
