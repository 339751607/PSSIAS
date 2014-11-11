Ext.onReady(function() {

    Ext.QuickTips.init();// 浮动信息提示

    Ext.BLANK_IMAGE_URL = "../../widgets/ext-3.0.0/resources/images/default/s.gif";// 替换图片文件地址为本地

    // 创建一个简写

    var Tree = Ext.tree;

    // 定义根节点的Loader

    var treeloader = new Tree.TreeLoader({

            // dataUrl : 'tree.jsp'//这里可以不需要指定URL，在加载前事件响应里面设置

            });

 

    // 添加一个树形面板

    var treepanel = new Tree.TreePanel({

        // renderTo:"tree_div",//如果使用renderTo，则不能使用setRootNode()方法，需要在TreePanel中设置root属性。

        el : 'tree-panel',// 将树形添加到一个指定的div中,非常重要！

        region : 'west',

        title : '功能菜单',

        width : 200,

        minSize : 180,

        maxSize : 250,

        split : true,

        autoHeight : false,

        frame : true,// 美化界面

        // width : 200,//面板宽度

        // title : '可编辑和拖动的异步树',//标题

        // autoScroll : true, // 自动滚动

        enableDD : true,// 是否支持拖拽效果

        containerScroll : true,// 是否支持滚动条

        rootVisible : true, // 是否隐藏根节点,很多情况下，我们选择隐藏根节点增加美观性

        border : true, // 边框

        animate : true, // 动画效果

        loader : treeloader

            // 树加载

        });

    // 异步加载根节点

    var rootnode = new Tree.AsyncTreeNode({

                id : '0',

                text : '家电品牌总类',

                draggable : false,// 根节点不容许拖动

                expanded : true

            });

 

    // 为tree设置根节点

    treepanel.setRootNode(rootnode);

 

    // 响应加载前事件，传递node参数

    treepanel.on('beforeload', function(node) {

                treepanel.loader.dataUrl = '../SsDept/getTrees.do?parentId=' + node.id; // 定义子节点的Loader

            });

    // 渲染树形

    treepanel.render();

    // 展开节点,第一个参数表示是否级联展开子节点

   // rootnode.expand(true);
    rootnode.expand(false,false); 
    

 

    // 设置树的点击事件

    function treeClick(node, e) {

        if (node.isLeaf()) {

            e.stopEvent();

            var n = contentPanel.getComponent(node.id);

            if (!n) {

                var n = contentPanel.add({

                            'id' : node.id,

                            'title' : node.text,

                            closable : true,

                            autoLoad : {

                                url : 'tabFrame.jsp?url=grid.html',

                                scripts : true

                            } // 通过autoLoad属性载入目标页,如果要用到脚本,必须加上scripts属性

                        });

            }

            contentPanel.setActiveTab(n);

        }

    }

    // 增加鼠标单击事件

    treepanel.on('click', treeClick);
    

   

 

    // 定义右键菜单

    var rightClick = new Ext.menu.Menu({

                id : 'rightClickCont',

                items : [{

                            id : 'rMenu1',

                            text : '添加节点',

                            // 增加菜单点击事件

                            handler : function() {

                                alert('添加节点的实现！');

                            }

                        }, {

                            id : 'rMenu2',

                            text : '编辑节点'

                        }, {

                            id : 'rMenu3',

                            text : '删除节点'

                        }]

            });

    // 增加右键点击事件

    treepanel.on('contextmenu', function(node, event) {// 声明菜单类型

                event.preventDefault();// 阻止浏览器默认右键菜单显示

                rightClick.showAt(event.getXY());// 取得鼠标点击坐标，展示菜单

            });

 

    /*

     * 设置tree的节点放置函数此函数有一个很重要的参数对象e e对象有三个重要的属性，分别为dropNode,target,point

     * 1.dropNode为在拖动时鼠标抓住的节点 2.target为将要放置在某处的节点

     * 3.point为被放置的状态，分别有append表示添加，above节点的上方，below节点的下方。

     * 

     */

    treepanel.on('nodedrop', function(e) {

 

                if (e.point == 'append') {

                    alert('当前"' + e.dropNode.text + '"划到"' + e.target.text

                            + '"里面！');

                } else if (e.point == 'above') {

                    alert('当前"' + e.dropNode.text + '"放在了"' + e.target.text

                            + '"上面！');

                } else if (e.point == 'below') {

                    alert('当前"' + e.dropNode.text + '"放在了"' + e.target.text

                            + '"下面！');

                }

            });

 

    // 在原有的树形添加一个TreeEditor

    var treeEditer = new Tree.TreeEditor(treepanel, {

                allowBlank : false

            });

    /*

     * 为创建的treeEditer添加事件 有两个事件最为常用，一个为beforestartedit另一个为complete

     * 从名字就可以看出，beforestartedit事件是在编辑前的事件，因此可以通过它来判断那些节点可以编辑那些不可以。

     * complete为编辑之后的事件，在这里面可以添加很多事件，比如添加一个Ext.Ajax向后台传送修改的值等等。

     */

    treeEditer.on("beforestartedit", function(treeEditer) {

                var tempNode = treeEditer.editNode;// 将要编辑的节点

                if (tempNode.isLeaf()) {// 这里设定叶子节点才容许编辑

                    return true;

                } else {

                    return false;

                }

            });

 

    treeEditer.on("complete", function(treeEditer) {

                alert("被修改为" + treeEditer.editNode.text);

            });

 

    // （1）通过TabPanel控件的html属性配合<iframe>实现。该方法是利用

    // html属性中包含<iframe>的语法来调用另一个页面，具体见代码。

    // （2）通过TabPanel控件的autoLoad属性实现。该方法是利用autoLoad属性，它有很多参数，

    // 其中有两个比较重要，url表示要载入的文件，scripts表示载入的文件是否含有脚本，该属性相当重要，

    // 如果在新的页面中要创建Ext控件，必须指定该参数。该方法实现较前一个复杂，因为引入的文件不是一个完整的html文件，

    // 有可能只是内容的一部分，但是资源占用较少，而且载入速度较快（它有一个载入指示）

 

    // 添加第一个节点(html)

    treepanel.root.appendChild(new Ext.tree.TreeNode({

        id : 'htmlPanel',

        text : '通过html打开',

        listeners : {

            'click' : function(node, event) {

                event.stopEvent();

                var n = contentPanel.getComponent(node.id);

                if (!n) { // 判断是否已经打开该面板

                    n = contentPanel.add({

                        'id' : node.id,

                        'title' : node.text,

                        closable : true, // 通过html载入目标页

                        html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="grid.html"></iframe>'

                    });

                }

                contentPanel.setActiveTab(n);

            }

        }

    }));

 

    // 添加第二个节点(autoLoad)

    treepanel.root.appendChild(new Ext.tree.TreeNode({

                id : 'autoLoadPanel',

                text : '通过autoLoad打开',

                listeners : {

                    'click' : function(node, event) {

                        event.stopEvent();

                        var n = contentPanel.getComponent(node.id);

                        if (!n) { // //判断是否已经打开该面板

                            n = contentPanel.add({

                                        'id' : node.id,

                                        'title' : node.text,

                                        closable : true,

                                        autoLoad : {

                                            url : 'tabFrame.jsp?url=grid.html',

                                            scripts : true

                                        } // 通过autoLoad属性载入目标页,如果要用到脚本,必须加上scripts属性

                                    });

                        }

                        contentPanel.setActiveTab(n);

                    }

                }

            }));

 

    // 右边具体功能面板区

    var contentPanel = new Ext.TabPanel({

        region : 'center',

        enableTabScroll : true,

        activeTab : 0,

        items : [{

            id : 'homePage',

            title : '首页',

            autoScroll : true,

            html : '<div style="position:absolute;color:#ff0000;top:40%;left:40%;">Tree控件和TabPanel控件结合功能演示</div>'

        }]

    });

 

    new Ext.Viewport({

                layout : 'border', // 使用border布局

                defaults : {

                    activeItem : 0

                },

                items : [treepanel, contentPanel]

            });

 

});

