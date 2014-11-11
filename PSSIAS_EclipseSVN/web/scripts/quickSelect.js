<!--
/*************************************************************************************************************

                                      网页下拉框智能诱导输入使用说明(V5.0)
*-------------------------------------------------------------------------------------------------------------
*                                     〖功能简介〗
*    
*  1) 在填写表单时，对于下拉框有众多的条目时，选择一个目标条目往往要拉动下拉框的
*　滚动条寻找，即花时间又麻烦，本程序提供了诱导输入的功能。
*
*　2）用户只要输入下拉框选项每字的第一五笔或者拼音码，诱导框就会将最先匹配的n条记录
*  （这个参数可以配置，由MAX_MATCH_COUNT来指定）,显示在弹出框(窗口大小可以通过POPUP_WIDTH,
*   POPUP_HEIGHT参数设置)中，用户可用一般输入法选择记录的方法，将已匹配的条目选中：按空格，
*   选中头条按数字选中对应的条目,按回车关闭窗口,取消选择.
*  
*  3) 本诱导输入同时支持中英文诱导，中文的编码方式支持五笔和拼音。英文诱导，中文五笔诱导，中文拼音诱导
*  的诱导功能可以通过ACTIVE_EN_QUICK_SELECT，ACTIVE_WB_QUICK_SELECT，ACTIVE_PY_QUICK_SELECT参数激活或关闭
*  
*  4)支持ie5.0 ie5.5 ie6.0 ~...,在ie5.0上，诱导提示窗口在浏览器的状态栏中，在ie5.5以上版本上诱导窗口为一个浮动
*   窗口。
*
*  5)新版本特性：支持特殊字符的诱导，更改了不合法按键弹出窗口的问题，增加了delete键删除选项的功能(目前还不支持数据诱导)
*--------------------------------------------------------------------------------------------------------------
                                      〖配置描述〗
  
   1）在文档的<head></head>中引用该js文件（假设其放在/js/quickSelect.js）
          如<head><script language="javaScript" src="/js/quickSelect.js"></script></head>
          如果是加密版，调用如下：
          <head><script language="JScript.Encode" src="/js/quickSelect.js"></script></head>
          
   2）在文档加载时执行初始化函数<body onload="quickSelectInit();"></body>
*--------------------------------------------------------------------------------------------------------------
* 作者：陈雄华
* 版权所有  
* 时间：2004-01-21
* 版本：V6.0
*-------------------------------------------------------------------------------------------------------------
***************************************************************************************************************************/
var quickSelectDataStr="<bm>"+
	"<py>"+
		"<group bm=\"Z\">"+
"嵫锱鲻孳咨资粢姿滋淄谘孜缁耔梓紫秭笫籽滓子姊眦自恣渍字鬃棕踪腙宗偬总粽纵鄹鲰邹诹陬驺走奏揍菹租足镞族俎祖诅阻组躜钻纂缵攥嘴蕞醉最罪樽鳟尊遵撙作昨左佐唑做坐胙座怍祚阼阝辶訾妯肘帚荮酎胄咒籀皱宙昼骤纣绉珠茱株槠蛛铢朱邾侏猪橥洙潴诸诛逐躅竹竺筑舳瘃烛煮拄瞩嘱主麈渚翥著柱杼助蛀贮铸箸住伫疰炷注祝驻抓转专砖颛撰啭赚篆馔桩庄装妆撞僮壮状丬锥追骓赘惴坠缒缀肫窀谆准捉拙卓桌倬涿琢茁酌斫擢啄镯灼浞浊濯禚诼髭趑辎龇赀觜轴正蒸挣睁峥钲铮筝征徵狰争症怔整拯政帧郑证诤芝枝栀支指掷吱蜘只知卮肢胝脂汁祗之织埴职直植执絷摭跖踯值侄址芷枳酯轵止黹趾旨祉咫纸志栉桎贽挚鸷轾至致郅踬蛭置帜帙制智雉秩稚质豸膣觯炙痔痣忮滞治窒陟骘彘中盅忠钟舯锺螽衷终踵肿冢仲众舟周州洲诌碡阵痄诈摘斋宅窄砦债瘵寨占瞻毡詹旃沾谵盏搌斩辗崭展蘸栈战站湛绽璋樟蟑獐章彰鄣漳张嫜掌仉涨杖丈帐幛账嶂仗胀瘴障招昭啁钊着找爪沼赵棹照罩笊兆肇诏蜇遮磔哲蛰摺辄辙谪者赭锗褶蔗柘鹧这浙珍蓁斟真榛桢甄砧臻贞针箴侦胗浈祯枕轸畛稹疹诊缜圳震振赈镇朕鸩乍匝扎拶咂砸咱杂咋栽哉灾甾载崽仔宰再在簪糌趱昝瓒暂錾赞臧赃脏驵葬奘遭糟凿藻枣早澡蚤躁噪唣造皂灶燥责赜择啧帻则迮箦笮舴泽仄昃贼怎谮增罾憎缯赠锃甑综揸哳吒齄渣札铡闸炸砟眨柞榨蚱咤粥拽峙殖召栅粘轧椎兹卒攒种重曾喳"+
"</group>"+
		"<group bm=\"L\">"+
"剌鳓瘌倮瘰蠃裸珞荦摞雒漯洛泺骆骡咙笼胧癃窿垅垄拢陇搂耧蒌楼蝼喽髅偻娄嵝篓露镂瘘漏陋撸噜垆芦栌轳卢颅鸬舻胪鲈庐炉泸橹掳卤虏镥鲁璐麓辂辘路鹭赂簏鹿潞漉渌禄录逯戮绿氇榈闾驴捋吕铝稆侣旅膂褛履屡缕虑氯律率滤栾脔峦挛銮鸾孪娈滦卵乱掠略锊抡轮囵伦仑沦论罗萝椤螺逻锣镙箩脶猡砻亮谅冫撩撂聊鹩嘹僚獠疗燎寮寥辽缭蓼钌尥镣廖料咧裂鬣趔埒列烈捩劣躐猎冽洌琳林磷霖辚临瞵啉嶙邻鳞麟粼遴淋檩廪懔凛蔺躏赁膦吝拎玲聆菱苓柃棂酃零龄蛉囹铃伶令瓴翎鲮羚凌泠灵陵绫岭领呤另熘溜琉榴硫镏留遛刘瘤旒浏流鎏骝柳锍绺碌馏六陆鹨隆珑茏栊龙聋晾愣哩璃嫠藜蓠丽鹂厘喱蜊罹梨犁黧黎篱鲡狸离漓骊蠡缡理李醴逦里锂俚鲤鳢澧礼娌坜苈莉莅荔枥栎吏栗郦厉励砺砾历雳轹呖跞蛎唳詈利篥笠傈俪例俐猁疠疬痢立粝粒溧沥戾隶力俩联莲奁连蠊镰臁鲢廉怜涟濂帘裢琏蔹敛脸裣楝殓链恋炼潋练墚椋量踉粮凉梁粱良两魉辆冷垃拉喇蜡腊辣啦邋旯砬莱来崃铼徕涞赖赉睐籁癞濑蓝婪栏拦岚镧篮斓阑兰澜褴谰榄揽览罱懒漤缆烂滥啷琅榔螂锒稂狼廊阆郎朗蒗莨浪捞劳醪唠崂铹痨牢老栳铑佬潦姥耢落酪烙涝络肋勒叻仂鳐乐泐了擂檑雷累镭羸嫘缧耒蕾磊儡诔垒酹类泪嘞棱塄楞纶"+
"</group>"+
		"<group bm=\"P\">"+
"蟠蹒爿僻淠屁甓譬媲犏篇偏片翩蹁胼骈谝骗剽飘螵漂缥朴瓢嫖殍瞟票嘌撇氕瞥苤丿拼姘苹频颦贫嫔榀品聘牝乒俜娉坪萍枰平凭鲆瓶评冖坡攴钋泼颇皤鄱婆叵钷笸珀破粕剖掊裒扑噗铺仆璞莆葡菩蒲镤匍濮蹼圃镨氆普浦溥谱睥葩啪趴派杷筢爬帕怕琶拍排牌俳徘迫蒎哌湃攀潘盘磐盼畔判叛拚泮乓滂螃逄庞旁耪胖抛脬泡匏跑咆狍庖袍疱醅呸胚培裴赔锫陪配霈帔佩旆沛辔喷盆湓砰抨嘭烹怦澎彭堋蓬棚硼蟛篷膨朋鹏捧碰坯丕邳砒霹批披噼铍劈纰琵鼙枇毗蚍蜱啤罴郫貔脾疲陴皮圮匹擗仳庀痞癖疋屏魄埔曝刨瀑"+
"</group>"+
		"<group bm=\"X\">"+
"禊谖璇悬痃旋玄漩选癣楦碹眩镟铉炫泫渲绚靴薛踅学泶穴雪鳕谑埙薰醺曛勋熏獯窨荀峋循旬鲟恂洵浔询驯巡蕈殉徇汛训讯巽逊迅彐宣械榭榍躞卸獬蟹邂亵廨懈燮泄渫瀣泻谢屑绁馨薪芯昕锌欣鑫辛新歆忻心寻信衅囟星腥猩惺兴刑型形邢荥硎陉醒擤幸荇杏悻性姓芎兄凶胸匈汹雄熊髹咻休鸺修貅馐庥羞朽嗅岫锈秀溴袖绣顼墟需虚盱吁须胥徐栩醑糈许诩蓄酗勖煦叙旭序恤洫溆絮婿绪续蓿萱揎轩暄喧儇煊薤酰掀暹跹锨氙先仙鲜籼祆咸贤衔舷痫闲鹇涎弦娴嫌藓燹显跣蚬筅猃冼险现苋献县岘腺馅羡宪陷限线葙芗相厢镶香箱襄湘骧缃乡庠翔祥详想响饷享鲞飨项橡蟓像向象萧枵硝霄肖削逍哮哓销箫魈枭潇消宵骁绡崤淆晓筱小孝啸笑效楔些歇蝎鞋协撷携邪偕斜胁谐勰缬血写莶熹菥昔熙析皙樨西醯硒矽晰嘻曦蜥螅蟋唏吸锡牺稀僖鼷息舾翕希欷郗兮悉奚膝夕惜羲粞熄烯淅浠溪汐穸犀嬉檄觋袭席隰习媳喜葸蓰铣徙玺洗禧屣舄饩阋隙细瞎呷瑕柙匣硖霞辖暇黠峡侠狭狎遐下夏罅嘘厦戌纤校系挟戏虾行巷吓畜嚣"+
"</group>"+
		"<group bm=\"Y\">"+
"粤龠月刖悦阅瀹晕氲耘云芸昀郧匀纭殒狁陨允韫运蕴酝韵愠恽郓孕肀岳雩与揄欤虞禺愚蝓嵛竽舆舁臾余觎逾腴鱼狳馀愉渝渔窬谀隅予娱妤雨龉圉圄屿伛俣禹庾瘐宇窳语羽玉域芋蓣郁遇昱蜮喻峪钰毓御愈欲鹆狱饫阈煜燠誉浴寓裕谕聿熨鬻预鹬豫驭妪鸢箢眢鸳渊冤元鼋垣塬袁橼原援辕园螈员圆爰猿沅源媛缘远瑗垸苑愿掾怨院曰越樾跃钺榆印胤瑛璎英莺樱撄嘤罂婴鹦膺鹰应缨莹茔萤营蓥荧萦楹蝇迎赢嬴滢潆瀛盈郢影颖颍瘿硬映媵衤唷哟育墉拥镛佣臃鳙痈庸雍壅饔慵邕喁踊蛹咏俑泳永甬恿勇用呦幽优攸悠忧莜莸柚尤由蚰蝣邮铀鱿犹疣猷油游莠酉有友卣黝铕牖右蚴囿佑侑鼬釉宥诱又幼迂瘀淤纡瑜于盂萸茚依伊猗衣漪圯颐夷眙咦贻嶷移迤仪胰饴疑痍怡沂宜诒姨彝苡酏蚁钇倚舣旖已乙矣以埸懿薏艺翳殪挹抑轶弋呓易蜴邑峄镱镒佾亿劓役刈臆逸肄瘗疫癔亦弈奕裔意毅翊悒怿忆义益熠溢诣议谊译异羿翼翌驿缢绎堙茵荫因喑铟氤音洇阴姻垠鄞霪吟银狺夤淫寅蚓吲饮瘾尹引隐铱魇奄掩眼罨俨偃鼹衍兖演艳堰酽厌餍砚雁赝晏唁彦焰焱滟宴谳谚验鞅殃央鸯秧泱杨扬蛘佯徉疡羊烊炀洋阳氧仰痒养样怏恙漾讠要吆夭邀腰妖约幺瑶珧摇轺尧徭肴爻繇遥窑谣姚杳咬崾舀窈药耀曜钥鹞耶椰掖噎揶铘爷野冶也靥页业邺晔曳腋夜烨液谒一壹椅医揖咿噫黟厣垭桠压押雅鸦哑鸭呀丫琊芽牙睚蚜崖岈伢衙涯痖亚砑揠迓氩讶娅焉鄢燕菸咽崦殷胭恹阉烟湮淹嫣盐芫严檐研蜒岩筵延言颜闫阎炎沿妍琰郾叶遗俞圜屹涌"+
"</group>"+
		"<group bm=\"W\">"+
"午舞迕牾伍仵侮庑怃忤妩坞芴杌戊雾晤物勿务痦悟焐鋈寤误阢鹜骛婺五威巍委逶偎微危煨隈韦违圩桅囗围唯帏帷嵬惟闱为涠沩潍维玮苇韪伟伪艉鲔猥痿炜洧诿尾娓纬未蔚軎味畏胃喂魏位猬渭谓尉慰卫瘟温雯蚊璺文闻阌纹吻稳刎紊问汶嗡翁蓊蕹瓮亠莴挝蜗倭窝我斡卧硪握龌幄肟沃渥圬巫兀呜钨乌邬於污诬屋芜梧吾捂吴唔蜈鼯浯毋武鹉薇挖哇蛙洼娲娃瓦佤腽袜歪崴外豌蜿弯湾剜玩顽芄丸烷完纨琬菀碗挽晚畹皖脘惋宛婉绾腕尢汪王亡忘枉辋网罔魍往惘旺望妄葳萎无万涡"+
"</group>"+
		"<group bm=\"V\">"+
"0123456789０１２３４５６７８９~`!@#$%^*()_+{}[]:;&amp;&apos;&gt;&lt;&quot;|\/?., ～｀！＠＃＄％＾＆＊（）＿＋｛｝［］：；＂＇｜＼／？＞＜．， 《》"+
"</group>"+
		"<group bm=\"T\">"+
"投骰头钭透凸秃突荼菟酴图徒途涂屠土吐钍堍兔湍抟团疃彖推颓腿蜕煺褪退吞暾屯豚饨臀氽拖托乇脱坨橐酡砣跎鼍佗鸵沱陀驼椭妥庹柝唾箨偷掏饕涛滔绦萄桃啕鼗逃洮淘陶讨套忑忒铽特藤滕腾疼誊梯剔踢锑体荑醍题蹄啼鹈缇替嚏倜逖惕悌涕剃裼屉天添填田畋甜恬阗忝殄舔腆掭挑佻祧髫龆蜩笤鲦条迢窕眺跳粜萜帖贴铁餮厅听烃汀莛葶霆蜓廷停亭庭婷梃挺艇扌嗵通茼桐酮砼瞳同铜佟仝彤童潼桶捅筒统痛恸冂韬塌遢趿踏铊他溻它她鳎獭榻拓挞蹋闼胎苔台薹抬跆鲐炱邰泰酞太态钛肽汰坍摊贪瘫滩坛檀昙锬痰郯潭谭谈坦忐钽毯袒碳探叹炭耥趟镗铴羰瑭塘樘醣搪堂棠螳螗膛饧唐糖溏傥躺淌帑烫汤驮提钿塔倘"+
"</group>"+
		"<group bm=\"S\">"+
"虽濉遂隋随绥髓碎岁穗燧邃谇隧祟荪狲飧孙榫损笋隼蓑桫梭睃嗦嗍唆羧娑琐索唢锁所睢甩帅蟀栓拴闩涮霜双孀爽水睡税说吮瞬顺舜蒴硕搠铄朔槊烁妁忄斯厮撕嘶蛳咝锶私澌司厶缌丝鸶死耜肆寺嗣兕四笥饲泗汜祀巳驷姒灬菘松崧嵩忪凇淞耸怂竦悚颂送宋讼诵搜螋嗖锼艘馊飕溲薮擞瞍嗾叟嗽苏酥稣俗素蔌速粟嗉簌僳觫夙愫塑涑溯宿谡诉肃缩酸狻蒜算荽眭摔埘莳拾时食鲥蚀炻实识豕史矢使屎驶始式示士螫世贳柿事拭誓逝势轼是嗜噬铈舐筮仕侍似弑释饰氏市恃室视试谥饣礻收熟手艏首守寿授售受狩瘦兽绶菽蔬枢梳殊摅抒输叔倏舒毹殳淑疏书姝纾赎秫孰塾薯暑曙署蜀黍鼠数属术述树束戍丨竖墅腧庶澍沭漱恕唰刷耍十陕擅蟮赡膳鳝疝善鄯剡汕讪骟嬗缮墒殇伤觞商熵垧上赏晌尚绱凵捎蛸稍筲艄烧芍苕韶少哨潲邵劭绍奢赊畲猞折蛇舌佘舍赦厍摄射歙麝慑滠涉社设谁莘砷申呻伸身深诜娠绅甚什神哂矧渖审谂婶椹蜃肾胂慎渗声生甥牲升笙胜绳省眚晟嵊剩圣蓍师失鲺狮施湿诗尸虱闪撒仨挲洒萨卅脎飒思噻腮鳃塞赛三叁毵散霰伞馓糁氵丧桑磉搡嗓颡彡搔臊鳋骚缫扫嫂埽梢瘙瑟啬铯穑色涩森僧莎杉砂铩杀煞痧沙鲨裟纱傻霎啥唼歃酾筛晒珊埏苫芟跚山钐舢膻删煽潸扇衫姗泷适衰石伺盛刹裳沈勺"+
"</group>"+
		"<group bm=\"R\">"+
"蠕铷儒濡襦孺如辱乳汝蓐入溽洳褥缛软朊阮蕤蕊瑞芮枘睿蚋锐闰润箬偌弱嚅髯蚺然燃苒冉染嚷穰瓤禳壤攘让荛桡饶娆扰绕若惹热壬仁任人荏稔忍韧葚轫仞饪衽认刃妊纫扔仍日戎茸蓉荣榕融蝾嵘肜狨熔溶容绒冗鞣揉蹂糅柔肉薷茹颥"+
"</group>"+
		"<group bm=\"Q\">"+
"蕖磲氍蠼衢朐鸲劬癯渠取娶龋趣去阒悛颧荃权醛辁蜷铨筌泉全痊拳诠犬畎绻券劝缺阙瘸悫却鹊榷确阕逡裙群匚蘧鞒荞桥樵翘瞧乔侨憔谯巧愀鞘撬峭俏窍诮切挈锲箧郄妾惬怯窃钦侵衾亲秦琴勤芩檎覃擒嗪螓噙锓禽溱寝揿吣沁青轻圊蜻氢倾鲭卿清檠擎晴黥氰情謦苘顷请磬罄箐庆琼跫蛩銎邛茕筇穹穷楸蚯秋丘邱鳅球求裘逑蝤虬囚赇俅鼽犰酋遒泅巯糗趋麴觑蛆蛐曲黢岖躯祛诎屈驱璩缲棋歧畦蜞蛴岐崎俟颀脐鳍麒旗淇祺祈祁骐骑起芑杞岂屺乞企启綮绮契葺碛砌器气憩迄弃汽汔泣讫葜掐髂恰洽芊牵扦岍钎铅千迁签仟愆佥悭搴褰骞谦阡鬈荨掮虔黔钱钳钤箝前潜遣肷谴缱茜芡堑椠倩欠慊歉枪抢跄蜣呛锖锵镪戗腔羌戕墙蔷樯嫱羟襁炝橇硗雀跷锹劁敲悄蕲欺萋栖槭桤戚欹妻七嘁蹊凄漆柒沏琪琦亓圻耆綦萁芪区嵌且芹圈浅强齐茄其奇炔乾"+
"</group>"+
		"<group bm=\"O\">"+
"怄噢喔瓯欧鸥殴沤讴耦藕呕偶澳"+
"</group>"+
		"<group bm=\"N\">"+
"能妮坭霓铌倪鲵猊怩泥尼拟你旎匿慝睨昵伲腻逆溺尿蔫拈年黏鲇鲶辇碾撵捻埝廿酿念娘茑嬲袅脲捏聂颞蘖孽嗫蹑啮镊镍臬涅陧您聍苎柠拧咛狞凝宁甯佞泞妞牛扭钮狃忸纽哝侬脓浓农廾耨奴孥驽胬弩怒钕女恧衄暖虐疟挪傩搦喏锘懦糯诺嫩嗯南那镎拿哪捺呐呢钠肭衲娜纳艿氖乃奶萘柰耐奈鼐囡楠喃男难赧蝻腩囊囔馕攮曩孬硇挠蛲呶铙猱努瑙垴脑恼闹淖讷馁内恁乜弄鸟"+
"</group>"+
		"<group bm=\"M\">"+
"酩命谬摸摹蘑模膜馍磨魔谟嫫耱末茉莫蓦殁墨默镆秣貘貊瘼沫漠寞陌哞眸蛑俦蝥鍪牟某毪拇牡亩姆母坶苜墓暮幕募慕木目睦钼牧穆仫沐冥袂谜妹媚闷扪钔门焖懑们蒙萌甍瞢檬礞盟虻艨朦蠓蜢锰艋猛懵勐梦孟眯咪蘼醚猕靡縻麋迷祢弥芈脒米敉弭嘧觅汨宓蜜密幂谧糸棉眠绵眄冕黾腼免勉沔湎渑娩缅面喵苗鹋描瞄藐杪眇秒邈渺淼缈庙妙缪咩蔑灭蠛篾玟珉苠岷民缗抿皿敏鳘悯闽闵泯愍茗瞑明暝螟鸣铭名溟寐呒抹蚂麻摩嬷妈蟆吗玛码犸马杩唛骂嘛么埋霾荬买麦卖迈劢脉颟鞔蔓瞒鳗馒蛮谩螨满墁曼幔镘慢熳漫缦芒茫硭盲氓邙忙莽蟒漭猫髦茆茅锚毛牦旄矛蟊昴峁铆卯泖瑁耄茂懋冒帽貌贸袤瞀麽玫莓枚梅楣酶霉嵋镅猸糜煤没湄眉鹛媒镁每美浼昧魅秘泌"+
"</group>"+
		"<group bm=\"K\">"+
"捆悃阃困扩蛞廓阔鲲壳可岢渴克锞氪刻恪溘客课骒缂肯龈啃垦恳裉坑铿崆箜倥空恐孔控芤抠眍口蔻扣叩筘寇堀枯刳哭骷窟苦酷库喾裤绔夸垮侉挎跨胯蒯块哙筷侩郐脍狯快髋宽款匡框哐筐诓狂诳夼圹矿眶旷贶邝况纩亏盔岿悝窥逵葵奎揆睽喹暌蝰魁馗夔隗跬聩蒉匮喟篑馈愦愧琨髡坤醌昆锟窠咔喀卡佧胩开揩锎垲蒈剀凯锴铠恺慨忾刊堪戡勘看龛坎莰砍侃瞰康慷糠抗亢炕伉闶钪尻考栲拷烤铐靠犒珂坷苛柯棵磕轲瞌颗嗑蝌髁钶稞科疴颏楷溃咳吭括傀咯咖扛"+
"</group>"+
		"<group bm=\"J\">"+
"蠲涓娟锩卷鄄隽倦俊狷桊眷绢撅噘珏蕨橛桷厥劂攫抉掘矍蹶噱崛镢倔爵獗觖爝决诀谲孓绝均菌钧筠麇军皲君捃峻竣浚郡骏镌旌惊精粳泾经井警景儆肼憬阱刭靓静境敬镜径胫獍痉靖竟竞净弪迳婧钅扃迥炯窘鬏赳揪啾鸠阄究纠玖韭久灸九酒柩桕厩救旧臼舅僦咎就鹫疚琚趄鞫鞠苴椐据拘掬雎锯锔俱狙疽裾居驹菊橘局莒榉龃踽咀矩举沮聚苣醵拒巨遽具瞿距踞钜榘犋倨飓惧炬窭讵剧屦捐鹃京鲛交郊浇骄娇姣嚼峤矫挢搅铰侥佼皎敫徼脚狡角饺湫缴绞酵醮轿较噍叫觉窖纟节揭接皆喈嗟秸街疖阶结颉截劫桔杰碣拮捷睫鲒桀竭羯洁讦孑婕解姐戒界蚧骱借介疥诫届禁巾筋斤金今津襟衿瑾堇槿紧锦仅馑廑谨尽卺进觐靳晋荩噤赆近烬浸劲妗缙菁荆兢茎睛晶腈鲸胶甲岬钾假胛瘕稼价架驾嫁戋鞯蒹菅歼搛监坚尖犍笺鲣间煎兼鹣渐溅湔肩艰奸缄缣茧戬枧检柬碱硷拣捡睑趼囝锏笕简俭剪翦减蹇謇裥谫荐槛楗鉴践踺贱见键毽箭僭牮件健舰剑腱饯涧谏建茳豇礓僵姜将浆江疆缰耩蒋桨奖讲匠糨酱洚犟降绛廴教蕉艽茭椒礁跤蛟僬焦鹪袷咭畸跻叽唧羁犄嵇稽积笄箕肌饥几齑迹激讥屐鸡姬绩缉畿吉藉蕺蒺楫极棘殛辑戢岌嵴籍笈佶集及脊急疾瘠诘汲即亟嫉级戟掎挤虮麂济己纪髻芰蓟荠霁技冀跽哜觊稷季伎偈鲚鲫祭剂悸洎寄寂计记既暨忌际骥妓继珈嘉葭枷跏镓笳佳痂浃家加袈迦恝荚戛颊郏蛱铗乩玑击圾基期芨赍机墼丌矶剞贾颈句夹芥剿"+
"</group>"+
		"<group bm=\"H\">"+
"焕漶涣浣宦逭幻荒肓慌璜黄磺蟥蝗簧篁皇遑徨鳇凰癀惶煌潢湟隍晃幌恍谎珲灰虺挥辉咴晖徽麾恢诙隳茴蛔回洄毁悔彗慧恚卉蕙荟惠晦蟪哕喙贿秽会烩汇浍讳诲缋绘荤昏阍婚魂馄浑混溷诨耠劐攉锪活夥钬伙火藿获或惑霍嚯蠖镬货祸虍豢桁衡恒薨轰哄訇烘蕻荭虹闳鸿洪黉泓宏弘讧喉骺篌侯猴瘊糇吼堠厚候后逅後鲎轷呼唿乎忽惚糊烀滹瑚觳壶葫胡鹕槲醐蝴囫猢狐斛煳湖弧琥虎唬浒瓠护互岵笏鹱怙冱沪户扈戽祜砉花哗化华划铧猾滑豁骅桦画话槐踝徊怀淮坏獾欢环鬟萑桓锾郇洹寰缳缓擐换患唤鲩奂痪哈铪嘿嗨还骸孩醢胲海氦亥害骇顸酣蚶鼾憨邗邯韩晗含焓汗涵寒函喊罕阚翰菡撼捍撖旱颔憾悍焊瀚汉珩杭航颃绗沆蒿薅嚆壕号蚝嗥嚎貉豪毫濠郝好耗昊颢皓灏浩嗬喝诃盍荷菏核翮曷蚵禾和何盒劾阖阂河涸赫壑褐鹤贺黑痕很狠恨哼亨蘅横桧合红呵夯"+
"</group>"+
		"<group bm=\"G\">"+
"帼虢馘椁果蜾猓裹孤姑鼓瞽古嘏蛊罟鹘钴牯鹄谷臌股汩诂故梏顾固崮锢牿鲴痼雇栝刮鸹瓜胍剐寡卦挂褂诖掴乖拐怪莞棺倌鳏关官冠观矜管馆鹳掼罐盥惯灌涫贯桄光咣胱犷逛瑰规圭硅归皈龟鲑闺妫匦轨晷簋鬼庋宄诡癸桂柜炅跪贵刿刽鳜磙辊鲧衮滚绲棍埚聒过蝈呙崞锅郭国稿缟锆告郜诰圪格哥歌搁戈仡鸽疙割袼纥塥革葛鬲嗝蛤骼镉搿颌膈阁隔舸个各哿硌虼铬给根跟哏艮茛亘耕更庚赓羹埂耿梗哽鲠绠工攻功共恭龚蚣供躬公肱觥宫弓珙巩汞拱贡鞲枸钩篝佝勾沟缑苟岣笱狗觏遘垢彀构购够诟媾毂鸪辜菰菇酤轱咕蛄呱骨箍估觚沽嘎伽胳旮尜噶钆尕尬垓赅该陔改丐概钙盖溉戤干坩甘苷杆柑酐矸尴竿肝疳泔赶橄感擀秆澉敢旰赣淦绀杠罡冈刚钢缸肛纲岗港筻戆槔篙皋睾高膏羔糕藁槁搞杲镐广"+
"</group>"+
		"<group bm=\"F\">"+
"祓袱弗艴绂绋甫抚拊辅黼俯父釜斧脯腑府腐滏赴副覆蝮咐赋赙馥复傅付阜腹鳆鲋负富讣附驸妇缚舫访纺放犭攵菲霏非蜚啡鲱扉妃飞绯腓肥淝匪榧斐翡篚悱诽芾吠镄肺狒痱废沸费芬酚吩氛分纷坟棼焚鼢汾粉奋偾份忿鲼愤粪瀵丰封葑枫砜蜂酆峰锋风疯烽沣逢冯缝唪讽奉俸凤佛否缶麸夫敷呋趺跗稃肤孵芙茯苻莩菔桴砩扶辐黻蚨蝠蜉幅罘幞氟符伏俘孚郛服匐凫怫浮涪福发罚筏伐垡乏阀砝法珐蕃藩幡帆番翻蘩樊矾蹯钒繁凡烦燔泛反返范梵畈贩犯饭坊芳枋钫方邡妨肪鲂房防仿彷拂"+
"</group>"+
		"<group bm=\"D\">"+
"哆咄多裰夺踱铎垛哚躲朵缍柁跺舵剁惰沲堕蹀蝶迭牒佚瓞鲽谍叠玎耵酊丁盯叮町钉仃疔顶鼎碇啶铤锭腚定订铥丢东鸫咚岽氡冬董硐懂动垌栋峒侗胨胴恫冻洞夂都蔸篼兜抖蚪斗陡豆逗痘窦读督嘟毒椟顿黩髑犊牍独渎堵睹赌笃肚芏杜蠹镀度渡妒端短椴锻簖段断煅缎堆碓镦敦憝兑队对怼墩礅吨趸盹砘囤钝盾遁炖沌掇捣蹈倒岛祷导焘纛到稻悼道盗锝德得地的底蹬噔簦灯登戥等磴瞪嶝镫凳邓堤嘀镝低氐羝滴荻觌迪敌笛籴狄涤翟嫡柢砥抵骶邸诋蒂棣碲睇第帝弟递谛娣缔绨嗲颠掂巅癫滇碘点踮典丶玷靛坫垫电簟佃甸店癜惦奠淀殿阽碉叼貂雕鲷凋刁掉吊铞铫钓调跌爹堞垤耋碟揲喋蹲耷搭嗒哒答褡鞑靼达打笪瘩怛沓妲大疸呔待歹傣逮玳甙戴埭带殆代贷黛岱袋骀迨怠绐聃耽殚担眈箪儋丹瘅郸掸赕胆萏旦啖氮但惮澹淡诞弹蛋卩当裆挡党谠荡菪档砀宕凼亻叨氘忉刀单呆"+
"</group>"+
		"<group bm=\"E\">"+
"屙婀莪蛾哦峨锇鹅俄额讹娥恶苊萼垩噩厄扼轭遏呃颚鹗鄂锷腭鳄饿愕阏谔诶蒽恩摁而鸸鲕儿珥耳铒尔迩饵洱二贰佴"+
"</group>"+
		"<group bm=\"C\">"+
"窜榱摧崔催隹璀萃啐毳脆瘁悴粹淬翠村皴存忖寸磋撮搓蹉鹾嵯矬痤脞厝措挫错锉础储处褚亍矗搐黜触憷怵绌揣搋踹嘬啜膪氚川穿巛椽遄传舡船喘舛串钏创疮窗幢床闯怆吹炊棰槌捶锤垂陲春椿蝽莼醇唇鹑淳纯蠢踔戳辍龊屮刺呲疵茈茨磁雌辞糍鹚慈瓷祠词此赐次璁聪苁葱枞囱匆从骢琮丛淙楱辏腠凑粗殂徂蔟醋酢蹙蹴簇促猝撺蹿镩汆篡爨碜趁榇龀秤称衬谶柽撑瞠蛏铛城埕枨酲成呈铖乘程惩塍澄裎诚承丞逞骋眵哧螭吃嗤笞魑鸱痴蚩媸坻墀茌持匙踟篪池迟弛驰耻豉齿侈褫赤敕翅叱傺斥彳饬瘛啻炽舂茺艟充忡憧冲虫崇宠铳抽瘳酬畴踌帱稠愁筹俦仇雠惆绸瞅丑臭樗初出橱厨躇蹰蜍锄刍雏滁除楮楚杵锸馇差叉茬茶楂查槎檫搽猹察镲衩岔汊诧姹钗柴侪豺虿瘥搀觇躔蟾蝉镡馋廛澶潺禅谗婵缠蒇铲产阐冁谄骣颤忏羼菖昌伥鲳猖阊娼场苌尝常长偿徜肠嫦敞氅惝昶畅唱倡鬯怅超抄吵钞怊焯绰朝嘲晁潮巢炒耖砗车扯尺坼撤掣彻澈琛郴抻嗔橙臣辰尘晨忱沉宸谌陈拆擦嚓礤猜裁材才财睬踩采彩菜蔡餐骖参蚕残惭黪惨璨掺粲灿孱苍伧舱仓沧藏操糙槽曹嘈螬艚漕草艹厕策侧册恻测刂岑涔噌层蹭杈碴插厂"+
"</group>"+
		"<group bm=\"B\">"+
"饼禀炳摒病疒玻菠播拨钵饽波博鹁勃礴搏踣钹铂箔帛舶脖膊亳渤泊驳跛簸檗擘卜啵逋晡钸醭不捕哺卟补埠布步钚簿瓿部怖彼舭匕妣碧芘荜蓖蔽薜毕毙毖哔畀跸髀铋筚箅篦币狴庇庳痹愎闭敝弊滗濞裨必辟璧壁襞避嬖弼陛婢鞭砭蝙笾鳊飚煸边编碥匾贬窆扁褊苄便变卞辨辩辫忭汴遍弁缏髟标杓飙彪镖镳膘飑瘭骠表裱婊鳔瘪鳖憋别蹩玢彬槟豳镔傧斌濒滨宾缤鬓殡摈髌膑兵并冰柄丙邴秉芭捌扒叭吧岜笆八疤粑巴茇菝拔跋魃靶把钯耙坝霸罢爸鲅灞掰白柏百摆捭佰伯呗败拜稗斑班搬扳般颁癍瘢坂板钣版舨阪扮拌伴瓣半办绊邦帮梆浜榜膀绑蒡棒磅蚌镑傍谤苞龅煲胞包褒炮剥孢薄雹葆保堡饱鸨宝褓抱报暴趵豹鲍爆宀勹埤萆杯碑悲背卑鹎陂北鞴蓓孛碚辈邶贝钡倍狈备惫悖焙褙被鐾臂贲奔锛苯本畚笨坌嘣崩绷甭甏泵蹦迸逼荸鼻比鄙吡秕笔俾"+
"</group>"+
		"<group bm=\"A\">"+
"吖啊锕腌阿嗄埃捱挨哎唉锿哀皑癌蔼霭嗳矮瑷艾砹碍暧嗌爱隘嫒鞍桉鹌氨庵安谙埯揞铵俺按暗黯岸胺犴案肮昂盎熬凹敖聱獒螯鳌遨嗷翱廒鏖拗袄媪鏊骜坳岙傲奥懊澳"+
"</group>"+
	"</py>"+
	"<wb>"+
		"<group bm=\"M\">"+
"嵫胄贮颛赚峥帧帜帙周崭帐幛账嶂赈崽赃帻则贼赠嵛屿峪罂婴鹦由邮贻嶷峄央鸯崾峋崖岈崦岩岫岘崤峡巍帏帷嵬幄骰崴网罔帖贴同彤冂髓岁炭兕崧嵩飕夙峙殳赎赡赊嵊山删冉嵘肉峭赇曲岖岐崎岂屺髂岍帕赔帔内岷幔峁帽嵋髅嵝赂嶙岭崃岚崂岢崆骷髋贶岿崛峻剀凯嵌髁迥飓峤骱巾赆岬贱见几岌嵴觊凰幌贿骺岵帼骸鹘崮刿崞屹骼岣购骨赋赙赅冈刚岗峰风凤幅幞朵剁峨幡帆凡贩岽峒髑赌嶝迪骶巅典雕崔嵯丹赕幢赐崇帱财册岑髀飚贬飑髌岸盎凹岜败贝崩"+
"</group>"+
		"<group bm=\"Q\">"+
"锱鲻鲰邹镞钻鳟鳓皱铢猪铸馔锥镯钲铮狰争觯炙钟锺詹獐钊锗针镇匀狁锃铡鱼狳馀钰狱饫眢鸳猿怨钺印迎镛鳙铀鱿犹铕猗饴钇镱镒刈逸铟银狺夤饮铱肴爻钥铘镟铉鳕獯旬鲟獬蟹邂锌鑫猩凶匈馐锈锨鲜猃馅镶饷象销枭勿锡希欷郗夕铣玺饩狭狎危鲔猥猬刎钨乌邬钭钍兔饨鸵外铽锑鲦铁铜狲飧锁铊鳎獭鲐钛锬钽镗铴饧铄锶饲锼馊稣觫狻鲥蚀铈弑饰氏饣狩鳝觞猞鲺狮铷锐鳃馓鳋铯色铩杀煞钐鸲劬铨然饶饪狨锲郄钦锓鲭卿鳅犰鳍钎铅钱钳钤欠锖锵镪锹鲆钋钷铺镤匍镨狍锫铍铌鲵猊鲇鲶袅镊镍狞钮狃钕锘馍镆钼镎钠馕铙猱馁钔锰猛猕免勉铭名犸鳗馒镘猫锚铆卯贸镅猸镁镂鲈镥鲁铝卵锊锣镙猡獠钌镣猎鳞铃鲮镏留遛锍馏鲡狸锂鲤鳢猁镰鲢链铼镧锒狼铹铑鳐乐镭鲲锞铿狯狂馈锟锩狷镢獗觖钧锎锴铠钪铐钶镌镜獍钅久灸锯锔狙钜鲛铰狡角饺鲒桀解金锦馑鲸钾鲣锏键饯饥急鲚鲫镓铗鳇昏馄锪钬镬訇猴忽猢狐斛鹱铧猾獾锾郇鲩奂猓铪狠钴锢鲴鳏馆盥犷逛龟鲑鳜鲧锅锆镉铬鲠觥钩句勾狗够觚鳆鲋负钆钙钢镐犭鲱镄狒鲼锋孵匐凫多铎锇锷鳄饿鲕儿铒尔迩饵钒犯饭钫鲂鲽钉铤锭铥兜独镀锻镦钝岛锝镫镝氐狄邸钿甸鲷鸟铞铫钓错锉触舛钏锤匆猝镩铛铖鸱饬铳锄刍雏锸馇猹镲刹钗镡馋铲鲳猖鬯钞饼钵饽钹铂钸钚猜铋狴鳊镖镳勺鳔镔锕锿铵犴钯鲅钣镑包饱鲍刨勹钡狈锛"+
"</group>"+
		"<group bm=\"U\">"+
"孳咨资粢姿恣总尊遵瘌瘃疰装妆壮状丬准症郑痔痣痄瘵站章彰鄣瘴着疹阅韵甑闸瘐阈瘿痈疣猷瘀痍瘗疫癔意毅翊益音瘾兖彦疡羊痒养恙冶痃癣丫痖阉颜闫阎辛新歆羞痫闲鹇冼羡翔鲞效痦羲阋闱痿瘟闻阌问头疼誊鹈剃阗童痛遂羧闼瘫痰羰闩朔槊凇竦送塑首瘦兽疝善鄯商韶闪闰飒瘙痧癯阒痊拳券阙瘸阕妾亲酋遒前歉羌羟瞥瓶剖普凄判叛旁疱疲痞癖逆凝疟瘼闹闷门闽闵瘰美癃瘘闾冫疗冽凛羚凌瘤六疠疬痢立凉冷阃阔辣癞阑兰阆痨况夔蠲卷桊眷决竣闶疴痉靖竟竞净阄疚疽交郊疖竭羯疥瘕间煎兼鹣剪翦减姜将浆桨奖酱疾瘠冀痂癀阍豢闳瘊冱痪馘阚阖阂痕痼关闺衮疙阁羹盖疳赣戆羔痱疯冯阏阀疔冻斗痘端兑道盗羝帝弟递癫癜奠凋瘁痤瘩疸瘅郸疮闯疵兹鹚慈瓷次凑痴瘛啻冲瘳差瘥单产阐冁阊病疒瓿部曾痹闭敝弊辨辩辫瘭瘪鳖憋蹩并冰癌疤癍瘢瓣半背北邶迸"+
"</group>"+
		"<group bm=\"I\">"+
"滋淄滓渍洙潴渚注涿浞浊濯汁滞治洲沾湛漳掌涨沼兆浙浈瀹澡泽渣渝渔誉浴渊沅源滢潆瀛泳油游淤漪沂溢洇淫演滟泱洋漾耀液漩泫渲学泶洵浔汛涯湮淹沿泄渫瀣泻兴汹溴洫溆涎湘肖削逍潇消淆小鋈淅浠溪汐洗涠沩潍洧渭温汶沃渥污浯涂湍沱洼湾汪涛滔鼗逃洮淘涕添汀潼濉娑溻汰滩潭堂棠溏淌烫涮水澌泗汜淞溲涑溯淑澍沭漱汕汤赏尚少潲滠涉深渖渗省湿濡汝溽洳润挲洒氵涩沙鲨裟潸渠染溶溱沁清泅淇汽汔泣洽潜雀淠漂泼婆濮浦溥漆柒沏派湃潘泮滂泡沛湓澎泥溺涅泞浓沤沫漠沐淖懑汨沔湎渑渺淼泯溟漯洛泺满漫漭泖没湄浼泷漏泸潞漉渌滤滦沦劣洌淋泠溜浏流鎏漓澧溧沥涟濂潋梁粱涞濑澜漤滥浪潦涝泐泪渴溘喾涓浚泾酒举沮浇湫觉洁津浸尖浅渐溅湔涧江洚激脊汲济洎浃漶涣浣潢湟辉洄汇溃浍浑混溷活鸿洪黉泓鲎滹湖浒沪滑淮洹海汗涵瀚汉沆濠灏浩河涸汩灌涫光滚涡沟沽滏尜溉泔澉淦港淝沸汾瀵沣浮涪沲洱法泛洞渎渡沌滴涤滇淀淬沓澹淡当党凼淳淙澄池涌滁汊澶潺尝常裳敞氅潮澈尘沈沉波渤泊不沧漕测涔滗濞泌汴濒滨澳灞浜瀑"+
"</group>"+
		"<group bm=\"Y\">"+
"谘诹族诅座诸诛主麈庄谆诼证诤衷州诌诈斋旃谵肇诏遮谪鹧这诊谮谀庾语谕膺鹰应赢嬴育庸雍壅饔永诱衣诒旖亦弈奕裔义诣议谊译谳谚讠谣夜谒谖旋玄谑询训讯讶言亵廨谢庥许诩序襄庠详享谐庑误席为诿谓文紊亠於诬庹弯亡忘望妄讨亭庭谇谭谈唐说讼诵谡诉识市试谥熟孰塾庶讪麝设谁诜谂施诗扇诠瓤让认谯诮请庆诎麒旗启綮弃讫谦谴敲翩谝评裒谱庞庖旆烹庀旎诺讴谬磨魔谟谋亩讷谜靡縻麋谧庙蠃麻摩蛮谩盲氓邙旄袤麽糜庐鹿旅膂率栾脔峦挛銮鸾孪娈论亮谅廖麟廪吝刘旒离戾廉恋良廓斓谰廊郎朗羸诔刻课库诓诳邝诀谲麇康亢颏旌扃就鹫讵京讦诫廑谨肩谫谏讲齑迹讥诘麂齐剂计记肓谎麾诙讳诲诨讧户扈戽话裹亥颃豪毫诃劾亨诂雇诖庋诡郭诰庚赓诟府腐讣该高膏访放扉诽废讽讹谔诶方邡房谍订读度敦憝底诋谛丶店调衰诞谠畜床鹑词卒谶诚充诧廛谗谄颤昶谌禀亳庇庳扁变卞遍斌哀广庵谙廒鏖谤褒"+
"</group>"+
		"<group bm=\"B\">"+
"孜子鄹陬阻阼阝坠职陟骘阵障陨隅院阴隐阳耶也逊陉险陷限阢隰隙隈卫陀陶粜隋随隧祟孙陕凵孺阮取娶阡聘陪陴聂颞陧聍陌勐孟陇陋聊辽聆陵陆隆联了孔隗聩孓阱聚阶孑卺降亟际隍隳孩函孤聒隔耿附陔堕耳防耵陡队阽聃耽卩陲屮聪承丞蚩耻出除陈陛阿隘阪孢陂"+
"</group>"+
		"<group bm=\"X\">"+
"缁纵组缵纣绉缒缀织旨纸彘终绽张缜纭缯综粥鬻缘缨颖颍幽幼纡疑彝肄缢绎引约幺绚绁绣绪续弦线缃乡飨绡缬细维纬纹毋彖纨绾绦缇统绥缌丝鸶缩绶纾缮绱绍绅绳缛弱缫纱绻绕纫绒顷缲绮缱纤缥辔纰纽母纳弥弭糸绵缅缈缪缗缦绿缕缭绫绺蠡缡练缆络缧缂绔纩绢绝经弪纠缴绞纟皆结缙缄缣疆缰强犟绛绩缉畿级纪继幻缋绘弘弧缳缓绗纶贯绲缟纥给绠弓红缑弗艴绂绋缚绀纲纺绯费纷缝缍缎缔绨绐弹绌纯弛绸缠绰匕毕毙毖弼编缏缤绊绑鸨绷比"+
"</group>"+
		"<group bm=\"D\">"+
"耔鬃奏左砖斫髭碡丈磔砧耘砸在臧仄砟郁原愿硬尤友右魇奄艳厌餍砚雁赝靥页厣碹压砑研硎雄髹咸厢硝戊硒矽袭硖夏威硪砣碗尢套髫厅砼碎泰太态碳耥爽硕厮耜肆寿戍耍奢厍砷蜃辱三磉砂厦磲戌犬确髯挈秦契碛砌牵鬈硗破戚欹耪匏裴砰硼碰砒碾耨恧耦耱万耐奈硇礞面码迈劢硭髦垄耧砻鹩尥鬣磷硫碌龙聋厘厉励砺砾历奁砬耢耒磊克刳夸夼矿盔奎髡厥劂砍磕鬏韭厩碣兢碱硷礓耩礁髻恝戛磺灰彗慧耠矶奇剞厚胡鹕瓠砉鬟耗古嘏故顾硅磙硌耕龚鸪辜尬矸尴感非蜚斐翡奋丰砜酆奉砩夺厄而鸸砝矾碇硐碓礅趸砘焘磴砥碲碘碉碟存磋厝耷达大石砀础春唇蠢磁蹙碜成盛舂厨虿耖砗辰礴布礤厕碴砭碥髟飙鬓砹碍厂鹌耙百邦帮磅碑悲碚辈奔夯泵"+
"</group>"+
		"<group bm=\"S\">"+
"梓棕醉樽酎株槠橥柱杼桩酌枝栀植枳酯栉桎栈樟杖棹柘榛桢甄枕酝札柞榨橼樾榆樱楹柚酉酏酽杨样要杳椰椅楦醺桠檐械榭榍醒杏朽栩醑酗酰相想橡枵楔杌析皙樨西醯檄柙桅梧酴酡椭柝枉桃梯醍梃桐酮桶榫桫梭榻酞檀樘醣栓松酥粟酸柿枢梳术述树椹枘梢森杉酾栅权醛榷桡榕桥樵檎覃楸棋杞枪樯橇剽飘朴瓢票榀枰栖槭桤杷攀醅配棚枇酿柠酩模木柰楠檬梦醚棉杪杩懋枚梅楣酶楼栌橹麓榈椤林檩柃棂榴柳栊李醴枥栎栗楝椋婪栏榄榔醪栳酪檑酹棱楞可枯酷框醌鄄橛桷栲柯棵柩桕椐橘榉醵校酵醮楷桔杰禁槿枧检槛楗椒楫极枷机桁槲醐桦槐桓椁醢酣杭核横贾梏栝棺桄桂柜桧棍格哥歌根梗枸构酤覆概杆柑酐橄杠槔槁榧酚棼焚枫桴柁樊梵枋酊丁顶栋椟杜椴柢棣榱村档椽棰椎槌椿醇枞楱醋酢榇柽枨酲酬樗橱楮楚杵楂查槎檫郴橙醭材槽杈标杓彬槟柄桉柏板梆榜棒杯本"+
"</group>"+
		"<group bm=\"H\">"+
"紫眦訾瞩卓桌龇赀觜睁止砦占瞻战贞眨虞龉卣眙眼眩睚虚盱些瞎龌凸龆眺瞳睃忐睢睡瞬瞍眭叔丨上睿氍龋瞧觑歧虔瞟频颦攴颇睥盼皮睨虐眸目睦眯眠眄瞄眇瞑瞒卢颅鸬卤虏虑瞵龄睐肯龈眍眶睽矍卡瞰瞌旧龃遽具瞿睫睛睑乩虍虎壑盯鼎督睹盹瞪睇点鹾眈龊雌此龀瞠眵齿瞅柴觇卜步睬餐粲彪龅"+
"</group>"+
		"<group bm=\"T\">"+
"秭笫自租纂籀竹竺筑舳箸篆筝征徵知智雉秩稚舯螽舟毡笊箴稹乍粤簪昝赞造迮箦笮舴怎齄竽禹毓御箢胤牖釉移迤舣劓役衍秧徉夭徭选熏循徇衙筵延衅囟秀徐先衔舷筅香箱向箫筱笑血午迕牾物务牺稀息舾悉徙委逶微艉魏稳我透秃徒颓乇箨往特甜舔笤条廷艇筒穗笋毯躺税私笥艘簌算矢舐筮释艏秫黍稍筲艄舌射身矧生甥牲升笙眚剩入箬穑歃筛舢衢筌穰壬稔乔箧箐筇秋鼽躯乞憩迄千迁签愆箝犏篇片丿牝鄱笸氆筢牌徘盘磐逄篷黏臬衄秣毪牡牧穆艨艋秒篾敏鳘雒么毛牦每笼篓舻簏氇稆律乱箩梨犁黧黎篱利篥笠适徕籁篮稂箜筘筷筐篑筠靠犒稞科径咎矩榘犋矫徼秸街筋稼犍笺笕简毽箭舰犄嵇稽积笄箕籍笈稷季系笳簧篁徨徽秽衡篌後乎笏徊鼾行航禾和很牯鹄牿刮鸹乖管簋稿告郜舸各躬篝笱箍馥复竿秆筻篙睾舫攵篚逢稃符躲舵鹅筏乏番翻繁彷牒丢冬夂篼犊牍笃短簖稻德得簦等敌笛籴第簟毳矬答笪待箪处舡船垂辞囱徂簇汆篡秤称乘程惩笞篪彳艟种重稠愁筹臭长徜彻箔舶簸簿舱艚策彼舭秘筚箅篦币笾秉矮岙奥笆稗般版舨备惫笨鼻秕笔"+
"</group>"+
		"<group bm=\"O\">"+
"籽粽烛炷灼黹糌糟凿灶燥炸煜燠熠焰焱烊炀业邺烨炫烟炎燮糈煊籼焐粞熄烯煨炜煺烷烃燧郯糖烁灬炻数剡熵烧糁煽燃熔糅糗炝粕粘糯焖迷米敉熳煤娄炉燎料粼遴熘粝粒炼粮烂烙类爝糠炕烤精粳炯炬烬糨焕煌烩火烘糇糊烀煳焓焊炔黼糕粉粪烽黻烦燔断煅炖灯粹炊糍粗炽焯炒炳灿糙煸粑炮爆焙"+
"</group>"+
		"<group bm=\"V\">"+
"姊妯帚嫜肀杂甾舁臾娱妤聿妪媛邕鼬姨姻尹鼹妖姚巡彐娅嫣妍寻姓旭絮婿娴嫌妩鼷嬉媳舄娓鼯退娲娃丸婉迢婷她帑孀妁姒叟肃始姝鼠恕嬗召邵劭娠婶如嫂姗群娆忍刃妊嫱媲嫖姘嫔娉妮娘妞奴孥驽胬弩怒女嫩嫫姆那娜奶努妹媚娩妙嬷妈媒录逯灵娌隶邋姥嫘垦恳馗娟君郡婧鸠九臼舅娇姣婕姐妗嫁奸建姬即嫉既暨妓毁婚好姑妫艮媾妇旮妃鼢婀娥发妨妒嫡娣妲逮刀巛媸姹婵娼嫦剿巢妣婢婊嫒媪剥"+
"</group>"+
		"<group bm=\"P\">"+
"字宗祖祚辶禊宙祝窀禚祗之祉窒冢宅窄寨褶祯鸩郓灾宰窬宇窳寓裕冤衤宥宜寅宴窑窈穴窨宣袖祆宪祥宵写寤穸禧窝突褪袜剜完宛裼祧窕邃它袒祀宋宿实室视礻守社神审襦褥塞赛衫裙禳衽容冗窍窃寝穹穷祛祺祈祁搴褰骞襁冖袍宁甯农寞衲冥袂祢宓蜜密幂寐裸窿禄褛寮寥礼帘裢裣褴牢客裉空寇窟裤宽窥窠军皲窘究裾窭窖襟衿蹇謇裥廴袷寄寂家宦逭祸宏祜豁寰害寒罕褐鹤寡褂官冠宄割袼宫祓袱富福裰额定窦祷窜褡裆宕褚穿窗祠衬裎褫宠初察衩禅宸补裨窆褊裱宾安案袄宝褓宀褙被"+
"</group>"+
		"<group bm=\"K\">"+
"踪足躜嘴唑蹒咒躅嘱啭啄吱只跖踯趾踬中盅忠踵啁郧咂咱咋躁噪唣啧哳吒咤喻员跃嘤郢唷哟喁踊咏呦咦呓邑喑吟吲唁吆咬噎咿噫勋哑呀咽躞兄咻嗅吁喧跹跣响哮哓啸叶嘻唏吸呷唯味遗喂吻嗡呜吴唔吐跎鼍唾哇饕啕踢蹄啼嚏跳听嗵虽嗦嗍唆唢趿踏蹋跆叹吮顺嘶咝嗣嗖嗾嗽嗉史嗜噬唰哨呻哂嘘噻嗓啥唼跚嚅嚷蹂嗪噙吣器遣跄呛跷蹁嘌品噗蹼嘁蹊啪趴哌跑咆呸喷嘭噼啤嗫蹑啮咛哝喏噢喔呕哞嗯哪呐呢喃囔呶咪嘧黾喵咩鸣呒吗唛骂嘛咙喽噜路鹭吕嘹咧躐啉躏呤另哩喱呖跞唳踉喇啦啷唠叻嘞啃口叩哭跨哙哐喹跬喟噘蹶噱咔喀嗑啾踽咀距踞鹃嚼噍叫喈嗟噤趼践踺跤咭跻叽唧戢跽哜跏咴哕喙嚯哄喉吼呼唿唬哗踝患唤哈嘿咳嗨喊吭嚆号嗥嚎嗬喝吓哼剐咣跪贵呙咯嗝跟哏哽咕呱咐嘎咖噶啡吠吩唪呋趺跗哆咄踱哚跺哦呃颚鹗鄂蹯蹀叮啶咚嘟吨蹈蹬噔嘀嗲踮叼吊跌喋啐蹲蹉嗒哒呔啖叨踹嘬啜川喘串吹踔呲蹴蹿呈逞哧吃嗤踟叱踌躇蹰躔唱吵嘲嗔踣跛啵哺卟嚓踩嘈噌蹭喳哔跸别呵吖啊嗄哎唉呆嗳嗌嗷嚣叭吧跋呗趵嘣蹦鄙吡"+
"</group>"+
		"<group bm=\"E\">"+
"腙胙肘逐助肫肢胝脂豸膣肿胀胗朕月刖孕脏腴爰盈媵臃用有胰臆腰繇遥舀鹞腋悬胭腥胸貅须燹县腺胁奚膝肟腿豚脱妥腽脘腕滕腾腆胎肽膛甩舜豕受腧膳胂胜乳朊脎腮彡臊膻朐肜脐肷腔胼胖脬胚膨朋鹏貔脾腻脲脓膜貘貊肭乃鼐腩脑朦脒觅腼脉貌胧胪脶膦臁脸腊肋胯脍爵胩肼胫且雎脚腈胶胛腱肌及虢胲貉臌股胍胱膈肱脯腑腹胳尕戤肝肛腓肥肺肤孚郛服腭肪腚胨胴肚貂脆脞胆膪腠塍豺肠脖膊采彩膘豳膑腌爱胺肮膀胞豹"+
"</group>"+
		"<group bm=\"W\">"+
"偬俎作佐做坐侏住伫僮追倬值侄仲众债仉仗侦龠仔舆余觎逾伛俣愈欲鹆佣俑优攸悠佑侑依伊仪倚佾亿俨偃佯仰爷伢信休鸺修叙儇仙像偕斜伍仵侮僖翕兮侠偎伟伪位璺翁瓮倭途氽佗佤偷体倜佻停佟仝隼他贪傥耸怂颂俗僳食使仕侍似售倏舒毹俞伤畲佘舍歙伸什儒偌仨伞僧傻全仁任人仞仍侨俏侵衾禽倾俅俟企仟佥倩戗劁僻偏贫俜凭仆俳佩盆仳倪你伲念您佞侬傩偶命侔仫拿恁们倮偻侣伦仑僚邻赁伶令瓴翎领俚傈俪例俐俩敛佬仂儡倥侉侩郐隽倦俊倔佧龛侃伉儆僦俱倨侥佼借介今仅假价俭僭牮件健剑僵僬焦鹪佶集伎偈祭佳会伙货侯候化华含颔何盒谷倌傀癸刽仡鸽颌合个供公佝估俯父釜斧傅付阜伽分偾份忿俸佛伏俘俄佴伐垡仿佚仃侗段倒登凳低佃爹催隹傣代贷黛岱袋儋但亻储传创伺从丛促爨侈傺俦仇雠岔侪伥倘偿倡伧仓侧便傧俺傲八爸佰伯颁伴傍煲保堡倍坌俾"+
"</group>"+
		"<group bm=\"C\">"+
"驺骤驻骓允驵蚤予预鹬豫驭甬恿勇又矣驿验驯熊骧骁鹜骛婺驼通台炱邰双厶驷驶骟圣叁毵桑颡骚劝逡柔巯驱骐骑骈骗能蝥鍪牟难骆马矛蟊瞀骡驴骝骊垒骒骏刭迳驹骄劲艰鸡骥戏骅欢骇观矜颈驸驮叠对怼邓皴骀迨怠骢骋驰叉骣驳骖参弁骠巴畚"+
"</group>"+
		"<group bm=\"F\">"+
"走煮翥专趑支埴直址志赵者赭真圳震云韫运栽哉载趱增雩雨域元鼋垣塬袁远垸越墉圯埸懿堙垠霪堰壹雪埙垭盐馨幸墟需献霄孝协坞雾熹喜霞韦违圩未雯斡圬土堍坨顽替填霆韬索塌坍坛坦趟塘霜寺埘示士螫十墒垧赦声霰丧埽啬霎埏趣去悫却壤韧颥謦磬罄求裘逑趋麴起墙坪坡亓圻耆培霈彭堋坯霹鼙圮坭霓辇埝无坶南赧垴埋霾卖墁耄霉垅露垆趔埒霖酃零嫠坜雳墚垃老雷塄壳坑堀垮块款圹亏逵坤均垲刊堪坎考坷井境赳救趄颉截劫进教吉戟霁嘉恚卉魂霍击圾赍堠觳壶坏顸邗韩翰壕郝盍赫鼓瞽卦规圭埚过圪塥埂觏遘垢彀毂赴垓干坩乾赶霏坟封夫垛二坊动垌都堵堆墩地堤觌颠坫堞垤耋寸塔戴埭亍矗趁城埕坻墀赤翅场超朝坼博鹁勃埔埠裁才埃霭埯坳坝霸坂雹埤孛贲甏"+
"</group>"+
		"<group bm=\"R\">"+
"揍攥撙朱邾拄抓撰撞捉拙擢挣拯指掷卮执絷摭贽挚鸷制质摘搌招找爪蜇哲蛰摺振氲扎拶皂择揸岳揄援掾撄拥挹抑氤掩扬氧邀摇掖揶拽揖踅押揠氩殷卸欣擤揎掀氙魈撷携舞罅挝握捂投抟推拖托挖挽皖魍掏掭挑挺扌捅损所拓挞抬摊探搪拴搠撕搜擞摔拾拭誓逝势手授摅抒擅捎折摄失撒搡搔扫泉缺攘扰热扔揉撬擒揿氢氰丘邱颀气掐扦掮抢撇氕拼乒皤掊扑爬拍排迫拚乓抛抨捧批披郫擗拟拈年撵捻捏拧牛扭挪搦摸拇捺氖攮挠扪描抿摞抹魅拢搂撸掳捋氯掠抡撩撂捩拎魉捆扩拉拦揽捞擂氪控抠扣挎揆魁撅攫抉掘捃揩看抗拷揪据拘掬拒捐挢搅皎敫揭接拮捷斤近搛拣捡掎挤技挟皇遑挥攉后逅护擐换氦撼捍撖皓括瓜挂掴拐掼罐皈鬼搁搿拱抚拊擀扛缸皋搞氛缶扶氟扼摁反返迭瓞氡抖盾遁掇捣的提抵掂垫掉揲摧撮搓措挫搭打担掸氮挡氘搐揣搋氚捶撺攒撑魑持斥抽搽搀抄扯撤掣抻摒播拨搏帛魄捕拆擦掺操插拂摈兵捱挨皑氨揞按翱拗捌扒拔魃把掰白摆捭拜搬扳扮拌抱报卑鹎"+
"</group>"+
		"<group bm=\"A\">"+
"菹蕞荮茱著茁蒸芝芷蘸蔗蓁斟芸蕴匝葬藻赜芋蓣鸢苑英莺莹茔萤营蓥荧萦莜莸莠萸茚颐苡薏艺翳弋茵荫鄞鞅尧药医靴薛薰荀蕈雅鸦芽牙迓燕菸芫郾薪芯荥荇芎蓄蓿萱薤藓苋葙芗项萧鞋邪莶芴菥昔熙觋葸蓰匣苇蔚蓊蕹莴卧巫芜薇荼菟芄菀葳萎萄忒藤荑萜莛葶茼荪蓑苔薹蒴斯菘薮苏蔌蒜荽莳式世贳菽蔬薯芍苕莘甚蓍蓐蕤蕊芮萨散莎苫芟蕖颧荃鹊匚苒荛若惹荏葚戎茸蓉荣鞣薷茹蘧鞒荞翘巧鞘切勤芩檠擎苘跫蛩銎邛茕芑葺葜芊荨茜芡蔷蕲苤苹萍叵莆葡菩蒲欺萋七綦萁芪葩蒎蓬匹匿慝蔫廿茑蘖孽苎廾区瓯欧鸥殴藕摹蘑茉莫蓦某苜墓暮幕募慕艿萘蒙萌甍瞢蘼苗鹋藐蔑苠茗荦荬颟鞔蔓芒茫莽茆茅茂莓蒌芦萝蓼蔺菱苓茏藜蓠苈莉莅荔莲蔹莱蓝蒗莨劳落勒蕾恐芤蔻苦蒯匡葵蒉匮蕨菌蒈戡勘莰苛警敬鞫鞠苴菊芹莒苣巨节戒堇觐靳荩菁荆茎鞯蒹菅茧荐茳蒋匠蕉艽茭藉蕺蒺芰蓟荠葭茄荚荒黄茴蕙荟荤劐藿获或惑其基期芨薨蕻荭葫花划萑邯菡巷蒿薅荷菏蘅莞鹳匦戈革葛茛工攻功共恭巩汞贡鞲苟菰菇芥甘苷藁菲匪芾芬葑芙茯苻莩菔莪苊萼蒽贰蕃藩蘩范芳东鸫董蔸芏荻蒂萃鞑靼甙萏荡菪莼茈茨苁葱蔟茌茺茬茶蒇菖苌臣菠菜蔡苍藏草艹芘荜蓖蔽薜鞭匾苄蔼艾鞍芭茇菝靶蒡苞薄葆萆鞴蓓苯荸"+
"</group>"+
		"<group bm=\"J\">"+
"最昨蟠蛛蛀蜘蛭蟑昭照晕昀早昃蚱禺愚蝓遇昱蜮螈曰蝇影映蛹蚰蝣蚴蚁易蜴蚓晏蛘曜野晔曳曛蚜蜒昕星勖煦暄暹贤显蚬蟓晓歇蝎晤晰曦蜥螅蟋暇韪蚊蜗蜈蜕暾蛙蜿晚旺剔题蜩蜓遢昙螳螗帅蟀蛳螋时是暑曙竖墅蟮晌蛸蛇申肾晟师蠕蚋晒蠼蜷蚺日蝾螓蜻晴蚯蝤虬蛆蛐蜞蛴蜣螵螃蟛蚍蜱昵暖蛑蝻曩蛲盟虻蠓蜢冕蠛明暝螟蚂蟆螨曼蟒昴冒昧蝼螺临蛉晾蜊里蛎蠊量蛞蜡旯览螂旷暌蝰昆颗蝌景蚧紧晶监坚鉴蛟虮蛱蟥蝗晃晖蛔晦蟪夥蠖虹蝴果蜾虾蚶晗旱蚝昊颢曷蚵蛊归晷炅蝈蛤虼蚣蛄蝮旰杲蜂蚨蝠蜉蛾遏蝶蚪戥电旦蝽蛏螭匙虫蜍蟾蝉昌畅晁晨晡螬刂蝙暧暗昂蚌暴曝"+
"</group>"+
		"<group bm=\"L\">"+
"罪转辎轴轵轾置斩辗罩辄辙轸畛暂錾罾圉圄辕园圆黝囿轶因罨轺黟鸭轩勰辖黠囗围畏胃图团疃畹辋逖田畋四轼输署蜀软思辁畎轫轻圊黥囚黢畦黔堑椠圃畔毗罴嬲墨默囡男邈皿轳辂辘略轮囵罗逻辚囹罹轹詈力连辆困罱累轲圈轿较界甲架驾囝畸羁辑加袈迦回轰轷囫圜贺黑罟固轨辊国哿轱辅轧罡辐罘轭恩罚畈町黩囤黜遄辍辏畴车黪畀边黯罢办"+
"</group>"+
		"<group bm=\"N\">"+
"怍爿昼惴怔咫忮展悦愠恽奘憎愉羽熨慵忧怡已乙以悒怿忆异羿翼翌怏恂巽迅恹懈屑忻心惺悻性胥恤怃忤悟惜犀习屣遐惟尾尉慰屋屠臀惋惘惕悌屉恬恸忄司巳忪悚愫屎恃收疏书属刷慑慎尸虱悛憔愀惬怯情屈恰悭慊戕悄屁甓譬怕怦劈疋怄怩尼尿忸懦恼懵乜民悯愍买慢忙眉鹛戮履屡懔鹨愣怜悃懒恪快悝愦愧恺慨忾慷尻惊憬居局惧剧屦届尽屐己悸忌慌惶恍恢悔恒惚怙怀憨憾悍恨怪惯改敢飞悱愤怫惰屙愕懂恫导悼翟惦殿刁悴翠忖怛惮蛋忉憷怵怆戳迟忡憧惆丑忏羼惝怅怊尺忱屏檗擘怖惭惨孱恻层愎必辟璧壁襞避嬖忭懊悖鐾臂"+
"</group>"+
"<group bm=\"G\">"+
"剌珠赘琢正整政至致郅盏璋珍臻殒再瓒遭枣责与欤玉瑗瑛璎迂瑜于盂夷殪殃瑶珧一璇殉琊亚焉鄢严琰刑型形邢顼现瑕下五玮軎兀吾武鹉吞屯橐瓦歪豌玩琬王忑天忝殄餮琐瑭死素速事殖殊束殇瑞卅瑟珊融琴青琼球璩殍平珀璞妻琪琦琶丕邳琵末殁囊孬瑙芈灭玟珉珞玛麦瑁玫弄璐裂列烈琳玲琉珑璃丽鹂理逦吏郦琏殓两来赖赉琅琨珏开珂靓静玖琚瑾晋戋歼戬柬豇棘殛珈颊郏璜珲虺惠玑墼丌瑚琥互画环还珩翮瑰鬲亘更珙甫副夹丐否麸敷恶垩噩珥珐玎豆逗毒顿蠹纛到玷靛璀歹玳带殆殚刺璁琮殂豉敕琛玻逋蚕残璨曹碧表玢殡丙邴瑷熬敖聱獒螯鳌遨鏊骜斑班甭逼"+
"</group>"+
	"</wb>"+
"</bm>";

//将编码库装入xml数据库中
////////////////////////////////////////////////////////////////////////////////
//授权的网址列表
var LICENSE_ADDRESS = new Array("http://localhost","http://192.168.0.86","file:///");
////////////////////////////////////////////////////////////////////////////////
var pbXMLDoc_quickSelectCodeLib = new ActiveXObject("Microsoft.XMLDOM");
    pbXMLDoc_quickSelectCodeLib.async = false;
    pbXMLDoc_quickSelectCodeLib.loadXML(quickSelectDataStr);
//////////////////////////////////////////////////////////////
//----------------可配置的参数---------------------------------------------------
var MAX_MATCH_COUNT           = 100;                //最大匹配数条目
var POPUP_WIDTH               = 300;              //诱导提示框的宽度　
var POPUP_HEIGHT              = 300;              //诱导提示框的高度　　　　　
var MAX_CODE_LENGTH           = 15;               //输入编码串的最大长度
var POPUP_WINDOW_COLOR        = "#ADE3F3";           //诱导窗口的背景色
var POPUP_WINDOW_BORDER_COLOR = "#002935";          //诱导窗口的边框色
var ACTIVE_EN_QUICK_SELECT    = true;             //英文诱导开关：true 激活　，false 屏蔽
var ACTIVE_PY_QUICK_SELECT    = true;             //拼音诱导开关：true 激活　，false 屏蔽
var ACTIVE_WB_QUICK_SELECT    = true;             //五笔诱导开关：true 激活　，false 屏蔽
var LIST_MOUSEOVER_BGCOLOR    = "#FFE3D0";        //鼠标移过的背景颜色
var LIST_MOUSEOVER_FGCOLOR    = "blue";        //鼠标移过的背景颜色
var HREF_STYLE        = "text-decoration: none";                          //链接的样式

var LIST_FORMAT_TYPE          = 3;                //显示的样式，1:基本样式,2:每选项一行样式，3:表格样式
var FEEDBACK_STEP             = 100 ;              //反向搜索的步长
var MAX_MATCH_ARRAY_LENGTH    = 200 ;             //最大匹配数组的长度，如果下拉框的选项个数大于这个数则                                               //匹配项目的数组设为这个值，则非下拉框的选项数值
//--------------------------------------------------------------------------------
//全局参数
var pbStr_specialChars             = "~`!@#$%^*()_+{}[]:;&'<>\"|\/?., "; //特殊字符的字串
var pbStr_code                     = "";                         //编码串存放器
var pbObj_currSelectElement        = null;                       //当前的下拉框组件（select）对象
var pbArr_matchItem                = new Array(MAX_MATCH_COUNT); //存放匹项目的数组,保存select组件所有匹配的项的索引
var pbInt_focusMatchItemIndex      = 0;                          //在显示窗口中用户将光标停放的匹配项在pbArr_matchItem中的索引
var pbInt_matchItemCurrPage        = 1;                          //当前所在的页

var pbStr_mouseOutBgColor;                                       //保存鼠标移出的背景颜色
var pbStr_mouseOutFgColor;                                        //保存鼠标移出的前景颜色

var pbArr_matchStackPointer_en_0   = new Array(MAX_CODE_LENGTH); //每个码对应匹配数组的堆栈指针：英文匹配堆栈指针
var pbArr_matchStackPointer_py_0   = new Array(MAX_CODE_LENGTH); //拼音匹配堆栈指针
var pbArr_matchStackPointer_wb_0   = new Array(MAX_CODE_LENGTH); //五笔匹配堆栈指针
var pbArr_matchStackPointer_en_1   = new Array(MAX_CODE_LENGTH); //每个码对应匹配数组的堆栈指针：英文匹配堆栈指针
var pbArr_matchStackPointer_py_1   = new Array(MAX_CODE_LENGTH); //拼音匹配堆栈指针
var pbArr_matchStackPointer_wb_1   = new Array(MAX_CODE_LENGTH); //五笔匹配堆栈指针

var pbArr_searchMaxIndex           = 0 ;//码搜索指向下拉框选项数组(options)的索引

var pbArr2_MatchItem_en            = new Array(MAX_CODE_LENGTH);  //存放拼英文匹配的二维数组（x,y），其第n列为匹配拼音编码串前n个编码串的匹配数组
var pbArr2_MatchItem_py            = new Array(MAX_CODE_LENGTH);  //存放拼音码匹配的二维数组（x,y），其第n列为匹配拼音编码串前n个编码串的匹配数组
var pbArr2_MatchItem_wb            = new Array(MAX_CODE_LENGTH);  //存放五笔码匹配的二维数组（x,y）x=MAX_CODE_LENGTH,y=下拉框选项的长度，其第n列为匹配五笔编码串前n个编码串的匹配数组
var pbBoo_isBackspace              = false;                      //是否是按backSpace键
var pbPopup_matchShow              = null;                       //显示匹配条目的popub窗口
var pbInt_corrX,pbInt_corrY;                                     //窗口的左上角的坐标
var pbBoo_selectItemChange         = false;                      //判断是否通过诱导输入更改了下拉框的选项

var pbStr_windowStatusMatchItem    = "";                         //如果是ie5.0则将当前页的匹配字串放在这个全局的变量中
var pbInt_currBeginIndex           = 0;                          //pbStr_windowStatusMatchItem开始显示的索引，主要是为了，window Status栏显示不下时，可以前后移动

var pbBoo_ieVersion = navigator.appVersion.substr(navigator.appVersion.indexOf("MSIE")+5,3); //ie的版本号
var pbBoo_supportPopup = pbBoo_ieVersion >=5.5 ? true:false;
if(pbBoo_supportPopup) pbPopup_matchShow = window.createPopup();//弹出的窗口对象
else top.status = "诱导输入准备就绪...";
//////////////////////////////////////////////////////////////////


/*主函数
用这个函数接管select组件的onKeyDown事件
* obj select 组件对象引用
*/
function mySelectKeyDown()
{
	/*if(!isValidUser())
	{
	  alert("本软件版权所有，如果您喜欢这个软件，请购买注册的版本。联系人：陈雄华：13358376155");
	  return false;
	}*/

	var obj = window.event.srcElement;
	var lo_keyCode; //按键的代码
	var lo_isValidCommonKey = isValidCommonKey();
	var lo_isValidSpecialKey = isValidSpecialKey();
	var specialChar = "";

	//如果是特殊按键，则会暂时更改诱导的开关，为了恢复原值，暂时保存原设置
	var temp_ACTIVE_WB_QUICK_SELECT = ACTIVE_WB_QUICK_SELECT
	var temp_ACTIVE_PY_QUICK_SELECT = ACTIVE_PY_QUICK_SELECT;
	var temp_ACTIVE_EN_QUICK_SELECT = ACTIVE_EN_QUICK_SELECT;

	window.event.returnValue = false;//取消事件默认的操作
	if (!lo_isValidCommonKey && !lo_isValidSpecialKey) //如果是不合法的按键直接返回
	{
	  window.event.cancelBubble = false;
	  return;
	}
	else //是合法案件
	{
	  if (lo_isValidSpecialKey) //因为特殊字符的编码放在拼音编码库中，所以必须暂时激活拼音编码库
	  {
	    ACTIVE_WB_QUICK_SELECT = false;
	    ACTIVE_PY_QUICK_SELECT = true;
	    ACTIVE_EN_QUICK_SELECT = false;
	    lo_keyCode = 86; //"V",对应特殊字符的编码		
	  }
	  else //一般的编码
	  {
	    lo_keyCode = event.keyCode;
	  }
	  //取消事件上传
	  window.event.cancelBubble = true;
	  if (obj != pbObj_currSelectElement) //组件已经改变,重新初始化环境变更
	  {	    	    
		pbStr_code = "";
	    pbObj_currSelectElement = obj;
		var corr=getPopupCorr(pbObj_currSelectElement);
		pbInt_corrX = corr.X;
		pbInt_corrY = corr.Y;
	    initCurrMatchEnv(pbStr_code,false);  
	  }
	  if (lo_keyCode == 9) //按tab键,关闭窗口并清理现场
	  {
	    pbStr_code = "";
	    myHidePopupWindow()
		window.event.returnValue = true;
	    return;
	  }
	  else if (lo_keyCode == 46) //按delete 清除下拉框的选项
	  {
	    obj.selectedIndex = -1;
	    pbStr_code = "";
	    myHidePopupWindow()
	    return;
	  }
	  else if(lo_keyCode >= 33 && lo_keyCode <= 36)//翻页键
	  {
		  if(pbBoo_supportPopup && !pbPopup_matchShow.isOpen) return;//窗口关闭时，直接返回
		  var loInt_totalPageCount = getPageCount();
		  switch(lo_keyCode)
		  {
		     case 33://pageUP
			    if(pbInt_matchItemCurrPage > 1)
				   pbInt_matchItemCurrPage--;
			 break;
			 case 34://pageDown
			 	if(pbInt_matchItemCurrPage < loInt_totalPageCount)
                   pbInt_matchItemCurrPage++;
			 break;
			 case 35://end
			 	if(pbInt_matchItemCurrPage != loInt_totalPageCount)
				   pbInt_matchItemCurrPage = loInt_totalPageCount ;	
			 break;
			 case 36://home
			 	if(pbInt_matchItemCurrPage > 1)
                   pbInt_matchItemCurrPage = 1;		 
			 break;
		  }	
		  pbInt_focusMatchItemIndex = (pbInt_matchItemCurrPage -1)* 10;
		  pbInt_currBeginIndex = 0;
          quickSelectItem("",pbStr_code,getMatchItemStr(pbInt_matchItemCurrPage),pbInt_corrX,pbInt_corrY);		   
		  return;
	  }
	  else if(lo_keyCode >= 37 && lo_keyCode <= 40)//箭头键
	  {
	      if(!pbBoo_supportPopup)
		  {
		     if(pbStr_windowStatusMatchItem.length == 0) return;
		     if(lo_keyCode == 37 || lo_keyCode == 38)//向前移
			 {
			    if( pbInt_currBeginIndex + 1 < pbStr_windowStatusMatchItem.length)
				{
				  pbInt_currBeginIndex++;
				}                 
			 }
			 else//向后移
			 {
			    if( pbInt_currBeginIndex  > 0)
				{
				  pbInt_currBeginIndex--;
				}  			 
			 }
			 quickSelectItem("",pbStr_code,pbStr_windowStatusMatchItem,pbInt_corrX,pbInt_corrY);
		  }
		  else
		  {
			  if(!pbPopup_matchShow.isOpen) return;//窗口关闭时，直接返回
			  if(lo_keyCode == 37 || lo_keyCode == 38)//向上
			  {
				 if(pbInt_focusMatchItemIndex % 10 == 0 && pbInt_matchItemCurrPage > 1)//移到上一页面
				 {
					pbInt_focusMatchItemIndex--
					fireKeyDownEvent(33);
				 }
				 else if(pbInt_focusMatchItemIndex % 10 > 0)//当页面上移一条
				 {
					pbInt_focusMatchItemIndex--;
					setFocusMatchItem( pbInt_focusMatchItemIndex % 10 );
				 }
			  }
			  else//向下
			  {
				 if(pbInt_focusMatchItemIndex % 10 == 9 && pbInt_matchItemCurrPage < getPageCount())//移到下一页面
				 {
					pbInt_focusMatchItemIndex++;
					fireKeyDownEvent(34);
				 }
				 else if(pbInt_focusMatchItemIndex % 10 < 9)//当页面下移一条
				 {
					if(pbInt_focusMatchItemIndex +1 < getMatchItemCount())
					{
					   pbInt_focusMatchItemIndex++;
					   setFocusMatchItem( pbInt_focusMatchItemIndex % 10 );
					}
				 }			 		  
			  }		  
		  }
		  return;
	  }
	  else
	  { // 是合法的按键

	    pbBoo_selectItemChange = false;
	    if (lo_keyCode == 32 || (lo_keyCode >= 48 && lo_keyCode <= 57) ||
	        (lo_keyCode >= 96 && lo_keyCode <= 105) || lo_keyCode == 13) //是选择键
	    {
	      if (lo_keyCode == 32 || lo_keyCode == 13)     //空白键或回车键
	      {
	        if (obj.selectedIndex != pbArr_matchItem[pbInt_focusMatchItemIndex]) //选项发生改变
	        {
	          pbBoo_selectItemChange = true;
	        }
	        if (getMatchItemCount() != 0)
	        {
	          obj.selectedIndex = pbArr_matchItem[pbInt_focusMatchItemIndex];
	        }
	      }
	      else
	      { //数字键
	        var lo_matchItemCount = getMatchItemCount();
	        var lo_selectIndex;
	        if (lo_keyCode >= 48 && lo_keyCode <= 57) //大键盘数字
	        {
	           lo_selectIndex = lo_keyCode == 48 ? 9:lo_keyCode - 49;	           	           
	           
	        }
	        else //小键盘数字
	        {
	          lo_selectIndex = lo_keyCode == 96 ? 9:lo_keyCode - 97;
	        }
	        lo_selectIndex += 10*(pbInt_matchItemCurrPage -1) ;//当前页对应的匹配数据索引
	        if (lo_matchItemCount != 0 && lo_selectIndex + 1 <= lo_matchItemCount) //是有效数字
	        {
	          if (obj.selectedIndex != pbArr_matchItem[lo_selectIndex]) //选项发生改变
	          {
	            pbBoo_selectItemChange = true;
	          }
	          obj.selectedIndex = pbArr_matchItem[lo_selectIndex];
	        }
	      }
	      pbStr_code = "";
	      myHidePopupWindow();
	      if (pbBoo_selectItemChange)
	      {
	        obj.fireEvent("onchange");
	      }
	      return;
	    }
	    else if (lo_keyCode == 8) //返回键:调整输入的编码串
	    {
	      if (pbStr_code.length > 0)
	      {
		      pbBoo_isBackspace = true;
		      window.event.returnValue = false; //屏蔽返回键，这样在多页面之间链接时就不会返回到前一个页面	        	        
	      }
	      else
	        return ;
	    }
	    else //字母键:调整输入的编码串
	    {

	      pbBoo_isBackspace = false;
	      if (pbStr_code.length == MAX_CODE_LENGTH)
	      {
	        return; //原编码串已经达到最大长度
	      }
	      if (lo_isValidSpecialKey) //是特殊的符号，对其进行转义变换
	      {
	        pbStr_code += keyCodeToChar();
	      }
	      else
	      {

	        pbStr_code += String.fromCharCode(lo_keyCode).toLowerCase();
	      }
	    }
	  }

	  selectCodeMatch(obj, pbStr_code);
	  //恢复现场
	  if (lo_isValidSpecialKey) //因为特殊字符的编码放在五笔编码库中，所以必须暂时激活五笔编码库
	  {
	    ACTIVE_WB_QUICK_SELECT = temp_ACTIVE_WB_QUICK_SELECT;
	    ACTIVE_PY_QUICK_SELECT = temp_ACTIVE_PY_QUICK_SELECT;
	    ACTIVE_EN_QUICK_SELECT = temp_ACTIVE_EN_QUICK_SELECT;
	  }	  
	}
}
/**
*功能：
*    验证是否是合法用户
*返回参数：
*   true 是  ，false 否
*/
function isValidUser()
{
	var userHost = window.location.href;
	for(var i = 0 ; i < LICENSE_ADDRESS.length ; i++)
	{
	  if(userHost.indexOf(LICENSE_ADDRESS[i]) > -1)
	  {
	    return true;
	  }
	}
	return false;
}
/**
*功能：
*    清理前次匹配的所有匹配项
*参数：
*   paArr 需要清除的数组
*/
function clearArr(paArr)
{
   for(var i=0 ; i< paArr.length ;i++)
      paArr[i] = null;
}

/**
*功能：
*    初始化现场，
*    如果是返回键仅清除当前码对应的栈信息
*参数说明：
*    paStr_code :返回时，按返回键时，未截除编码的编码串
*    paBoo_isBack
*/
function initCurrMatchEnv(paStr_code,paBoo_isBack)
{
   if(paBoo_isBack)//是返回按键
   {
	   var len = paStr_code.length;
	   appendDebug("<font color='pink'>删除第"+len+"码匹配索引项数组</font>");
	   if(len > 0)
	   {     
	     pbArr_matchStackPointer_en_0[len-1] = -1;
	     pbArr_matchStackPointer_py_0[len-1] = -1;
	     pbArr_matchStackPointer_wb_0[len-1] = -1; 
	     pbArr_matchStackPointer_en_1[len-1] = -1;
	     pbArr_matchStackPointer_py_1[len-1] = -1;
	     pbArr_matchStackPointer_wb_1[len-1] = -1;
	   }
	   if(len == 1)//必须关闭窗口
	   {
		    pbStr_code = "";
		    pbArr_searchMaxIndex = 0;  	     
	   }	   
	   appendDebug("<font color='green'>删除的第"+len+"码匹配索引项数组为"+pbArr2_MatchItem_py[len-1]+"</font>");   
   }
   else//清除所有现场
   {
	    for(var i = 0 ; i < MAX_CODE_LENGTH ; i++)
	    {
	       pbArr_matchStackPointer_en_0[i] = -1;
	       pbArr_matchStackPointer_py_0[i] = -1;
	       pbArr_matchStackPointer_wb_0[i] = -1;	       
	       pbArr_matchStackPointer_en_1[i] = -1;
	       pbArr_matchStackPointer_py_1[i] = -1;
	       pbArr_matchStackPointer_wb_1[i] = -1;
	       pbArr_searchMaxIndex            = 0 ; 
	    }
	    paStr_code = "";  
   }
   
   //清除匹配数组信息
   for(var i = 0; i < MAX_MATCH_COUNT ; i++)
   {
      pbInt_focusMatchItemIndex = 0;
      pbInt_matchItemCurrPage   = 1;
      pbArr_matchItem[i] = null;
   }     
}

/**
*功能：
*    测试是否是选项按键
*参数：
*    keyCode 按键的值
*返回：
*    true :是 ，false 不是
*/
function isSelectMatchItemKey(keyCode)
{
   if(keyCode == 32) return true;//blank key
   else if(keyCode == 13) return true;//enter key
   else
   {
      var temp = -1;
      if(keyCode>=49&&keyCode<=57)//大键盘数字键
        temp = keyCode - 48 ;
      else if (keyCode>=97&&keyCode<=105)//小键盘数字键
        temp = keyCode - 96;
      if(temp > getMatchItemCount()) 
      	return false;
      else 
        return true;
   }
}
/**
*功能：
*   检测输入的按键是否合法,如果合法，设置全局变量lo_keyCode
*输入参数 ：
*  eventObj 事件对象
*返回值 ：
*  true 是合法的键,合法键包括
* 合法的按键：
*  8:  backspace
*  9:  tab 
*  13: enter
*  32: blank
*  46: delete
*  翻页键
*  33：pageUp
*  34：PageDown
*  35：end
*  36：home
*  箭头键
*  37：←
*  38：↑
*  39：→
*  40：↓
*
*  1~9: 48~57 ,96~105
*  a~z :65~90

*  false 是非法的按键
*/
function isValidCommonKey()
{
   if(event.ctrlKey || event.altKey || event.shiftKey)
   {
      return false;
   }else
   {
      var keyCode = event.keyCode;
      var isValid = false;
         //数字，字母
         if((keyCode >= 48 && keyCode <= 57) || (keyCode >= 96 && keyCode <= 105) || (keyCode >= 65 && keyCode <= 90))
         {
             isValid = true; 
         }
		 else if(keyCode >= 33 && keyCode <= 40)//是翻页键或箭头键
		 {
		     isValid = true;   
		 }
		 else//是否是控制键
		 {
			 var bArr = new Array(8,9,13,32,46);
			 var bArrStr = ","+bArr.join(",")+",";
			 if(bArrStr.indexOf("," + keyCode + ",") != -1)
				isValid = true;  		 
		 }
      return isValid ;      
   }
}

/**
*功能：
*   检测输入的按键是特殊的字符
*输入参数 ：
*  特殊符号：
*  107,106,110,111,
*  shift + 48~57
*  shift + 186,188,190,191,192,220,221,222,219,
*/
function isValidSpecialKey()
{
      var isSepcChar = false;
      var keyCode = event.keyCode;
      
			//是否是不需shift键决定的特殊符号
			var cArr = new Array(107,106,110,111);
			var cArrStr = ","+cArr.join(",")+",";
			if(cArrStr.indexOf("," + keyCode + ",") != -1)
				isSepcChar = true; 
      
      if(event.shiftKey)//是否是需用shift键决定的特殊符号
      {
         if(keyCode >= 48 && keyCode <= 57)//是特殊符号的一部分
            isSepcChar = true;
         else
         {
            var aArr = new Array(186,188,190,191,192,220,221,222,219,32);
            var aArrStr = ","+aArr.join(",")+",";
            if(aArrStr.indexOf("," + keyCode + ",") != -1)
               isSepcChar = true;
         }         
      }
      
      return isSepcChar ;
}
/**
*功能：
*   将按键转换为对应的字符
*/
function keyCodeToChar()
{   
      var shift_specArr = new Array(")","!","@","#","$","%","^","&","*","(",":","+","<","_",">","?","~","{","|","}","\"");
      var specArr = new Array(";","=",",","-",".","/","`","[","\\","]","'");
      var index = 0 ;
      var keyCode = event.keyCode ;
     if( keyCode == 32 ) return " "; 
     if(keyCode >= 48 && keyCode <= 57)
         index = keyCode - 48 ;
     else if(keyCode >= 186 && keyCode <= 192)
         index = 10 + keyCode - 186 ;
      else if(keyCode >= 219 && keyCode <= 222)
         index = 17 + keyCode -219;
     if(event.shiftKey)//上键         
        return shift_specArr[index];
     else
     {
        index -= 10;
        return specArr[index];
     }
}
/**
*功能:
*   将匹配编码串的记录选中
*输入参数：
*   obj 　 select组件对象引用
*   pbStr_code 　匹配码串，和组件的五笔码和拼音码匹配
*/
function selectCodeMatch(paObj_selectElement)
{
   var loInt_codeLen     = pbStr_code.length;
   var loInt_optionsLen  = paObj_selectElement.options.length;
   var loInt_totalMatchCount   = 0; //所有编辑匹配的总数
   //搜索select的options数组的最大的长度
   var loInt_toOptionsLen  ;
   var loBoo_isFirstMove = true;//是否是第一次前馈
   
   if(!pbBoo_isBackspace)
   {
	      var debugCount = 0;
	      appendDebug("------------------------------------------------------------");
	      appendDebug("<font color='blue' >编码串为:"+pbStr_code+"</font>");
	      if(loInt_codeLen == 1)//编码长度为1
	      {
	         while(loInt_totalMatchCount < MAX_MATCH_COUNT && pbArr_searchMaxIndex < loInt_optionsLen)
	         {
	            loInt_toOptionsLen = pbArr_searchMaxIndex + FEEDBACK_STEP < loInt_optionsLen ? pbArr_searchMaxIndex + FEEDBACK_STEP :loInt_optionsLen;
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),0,pbArr_searchMaxIndex,loInt_toOptionsLen);
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),1,pbArr_searchMaxIndex,loInt_toOptionsLen);
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),2,pbArr_searchMaxIndex,loInt_toOptionsLen);	            
	            loInt_totalMatchCount   = getTotalMatchCount(loInt_codeLen);
	            pbArr_searchMaxIndex = loInt_toOptionsLen;         
	         }
	      }
	      else//编码长度大于1
	      {
	         loInt_totalMatchCount = 0 ;	         
	         if(getTotalMatchCount(loInt_codeLen - 1) > 0)//如果第i-1匹配数组有匹配项
	         {
	            //全量前馈第loInt_codeLen - 1 匹配数组到第loInt_codeLen匹配数组到
	            appendDebug("<font color='purple'>从"+(loInt_codeLen-1)+"全量前馈到"+loInt_codeLen+"</font>");
	            moveMatchItemForward(paObj_selectElement,pbStr_code,loInt_codeLen-1,1,true);
	            loBoo_isFirstMove = false;
	         }	
	         loInt_totalMatchCount = getTotalMatchCount(loInt_codeLen);
	         appendDebug("<font color='purple'>第"+loInt_codeLen+"码匹配数组为："+pbArr2_MatchItem_py[loInt_codeLen-1]+"</font>");        	         
	         while(loInt_totalMatchCount < MAX_MATCH_COUNT && pbArr_searchMaxIndex < loInt_optionsLen)
	         {	         
	            loInt_toOptionsLen = pbArr_searchMaxIndex + FEEDBACK_STEP < loInt_optionsLen ? pbArr_searchMaxIndex + FEEDBACK_STEP :loInt_optionsLen;
	            appendDebug("<font color='purple'>第"+(loInt_codeLen-1)+"码匹配前馈不足，新增搜索步长，增加第1码匹配数组的匹配数</font>");
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),0,pbArr_searchMaxIndex,loInt_toOptionsLen);
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),1,pbArr_searchMaxIndex,loInt_toOptionsLen);
	            getNewMatchBM(paObj_selectElement,pbStr_code.substr(0,1),2,pbArr_searchMaxIndex,loInt_toOptionsLen);
	            appendDebug("pbArr_matchStackPointer_py_1[0]:"+pbArr_matchStackPointer_py_1[0]+" pbArr_matchStackPointer_py_0[0]"+ pbArr_matchStackPointer_py_0[0]);	            	            
	            if(pbArr_matchStackPointer_en_1[0] > pbArr_matchStackPointer_en_0[0] ||
	               pbArr_matchStackPointer_py_1[0] > pbArr_matchStackPointer_py_0[0] ||
	               pbArr_matchStackPointer_wb_1[0] > pbArr_matchStackPointer_wb_0[0]
	              )//第1码匹配数组有新增匹配项，则前馈:第一次全量前馈，以后增量前馈
	            {	               
	               appendDebug("<font color='purple'>有新增，匹配，前馈类型为"+(loBoo_isFirstMove?"全量":"增量")+"码长为"+loInt_codeLen+"</font>");
	               moveMatchItemForward(paObj_selectElement,pbStr_code,1,loInt_codeLen - 1,loBoo_isFirstMove);
	               loBoo_isFirstMove = false;
	               loInt_totalMatchCount = getTotalMatchCount(loInt_codeLen);
	            }	          
	            pbArr_searchMaxIndex  = loInt_toOptionsLen;               
	         }
	      }
   }
   else//是按返回键
   {      
      appendDebug("<font color='pink'>码串为"+pbStr_code+"条件boolean值为："+(pbStr_code != null && pbStr_code.length > 0)+"</font>");
      if(pbStr_code != null && pbStr_code.length > 1)
      {
        initCurrMatchEnv(pbStr_code,true);//删除返回键对应编码的匹配数组信息
        appendDebug("<font color='pink'>调整前的编码串为"+pbStr_code+"</font>");
        pbStr_code = pbStr_code.substr(0, pbStr_code.length - 1);  
        appendDebug("<font color='pink'>调整后的编码串为"+pbStr_code+"</font>");
        loInt_codeLen =  pbStr_code.length;  
        loInt_totalMatchCount = 1;//设一个大于0的值，这样才可以进入显示例程 
        pbBoo_isBackspace = false;
      }
      else//关闭诱导窗
      {         
         myHidePopupWindow();
         return;
      }      
   }	
	////////////////////////////////////////////////////////////////////////////////////////////////
	fillMatchItemArr(loInt_codeLen);
	var selectName = "";

	if(loInt_totalMatchCount > 0 )//有匹配的，把匹配的条目显示出来
	{
		 quickSelectItem(selectName,pbStr_code,getMatchItemStr(1),pbInt_corrX,pbInt_corrY);
	}else
	{
	  var corr=getPopupCorr(paObj_selectElement);
		quickSelectItem(selectName,pbStr_code,"没有匹配项",pbInt_corrX,pbInt_corrY);
	}
}
/**
*功能：
*    获取和当前步长区间编码串的第一码匹配的选项
*输入参数：
*    paObj_selectElement select组件引用]
*    paChar_code  编码串的第一个码
*    paInt_bmType 编码类型1：拼音 2:五笔
*    paInt_beginIndex 开始的索引
*    paInt_endIndex   结束的索引（不包含）
*返回：
＊　当前编码匹配的所有选项数组（数组中记录的只是option在select中的index）
*/
function getNewMatchBM(paObj_selectElement,paChar_code,paInt_bmType,paInt_beginIndex,paInt_endIndex)
{        
  var loInt_selectOptionLen      = paObj_selectElement.options.length;
  var pbArr_matchStackPointer_en_0 = pbArr_matchStackPointer_en_1;//保存上次搜索的匹配数组堆栈指针：英文
  var pbArr_matchStackPointer_py_0 = pbArr_matchStackPointer_py_1;//拼音
  var pbArr_matchStackPointer_wb_0 = pbArr_matchStackPointer_wb_1;//中文
  var loStr_tempText = null;  //选项字符串的字符
   
	var loStr_matchCodeCn;   //对应编码字库中的字符串
	
	paChar_code = paChar_code.toUpperCase();
	
	
  if(ACTIVE_EN_QUICK_SELECT && paInt_bmType == 0 )//英文
  {
		 if(pbArr_searchMaxIndex < loInt_selectOptionLen)
		 {
				for(var i = paInt_beginIndex ;i < paInt_endIndex ; i++)//增加第1码的匹配索引数组
				{
					  loStr_tempText = paObj_selectElement.options[i].text;//选项文字
					 	if(loStr_tempText != null && loStr_tempText.length > 0)
						{	             
							 if(loStr_tempText.substr(0,1).toUpperCase() == paChar_code)
							 {
								 if(pbArr_matchStackPointer_en_1[0] == -1)//第1码匹配数组未初始化
								 {
									pbArr2_MatchItem_en[0] = new Array(MAX_MATCH_ARRAY_LENGTH);
								 }
								 pbArr2_MatchItem_en[0][++pbArr_matchStackPointer_en_1[0]] = i;//匹配选项索引进数组 				  		 
							 }
						}

				}
		 }			
	}
	else if(ACTIVE_PY_QUICK_SELECT && paInt_bmType == 1)//拼音
	{        
      if(pbArr_searchMaxIndex < loInt_selectOptionLen)
			{
		    loStr_matchCodeCn = getMatchCodeCnStr(paChar_code,paInt_bmType);
				for(var i = paInt_beginIndex ;i < paInt_endIndex ; i++)//增加第1码的匹配索引数组
				{
					 loStr_tempText=paObj_selectElement.options[i].text;//选项文字
					 if(isContain(loStr_matchCodeCn,loStr_tempText,0,1))//选项text的第1个汉字包含在loStr_matchCodeCn中
					 {		 	      
							if(pbArr_matchStackPointer_py_1[0] == -1)//第1码匹配数组未初始化
							{
							   pbArr2_MatchItem_py[0] = new Array(MAX_MATCH_ARRAY_LENGTH);
							}		
				  		pbArr2_MatchItem_py[0][++pbArr_matchStackPointer_py_1[0]] = i;//匹配选项索引进数组    		    		
					 }
				}			
			}
	}
	else if(ACTIVE_WB_QUICK_SELECT && paInt_bmType == 2)//五笔
	{	      
	    if(pbArr_searchMaxIndex < loInt_selectOptionLen)
			{
				loStr_matchCodeCn = getMatchCodeCnStr(paChar_code,paInt_bmType);
				for(var i = paInt_beginIndex ;i < paInt_endIndex ; i++)//增加第1码的匹配索引数组
				{
					 loStr_tempText=paObj_selectElement.options[i].text;//选项文字
					 if(isContain(loStr_matchCodeCn,loStr_tempText,0,1))//选项text的第1个汉字包含在loStr_matchCodeCn中
					 {		 	      
							if(pbArr_matchStackPointer_wb_1[0] == -1)//第1码匹配数组未初始化
							{
							   pbArr2_MatchItem_wb[0] = new Array(MAX_MATCH_ARRAY_LENGTH);
							}		
				  		pbArr2_MatchItem_wb[0][++pbArr_matchStackPointer_wb_1[0]] = i;//匹配选项索引进数组    		    		
					 }
				}			
		  }
	}
}

/**
*功能：
*    将匹配项前馈
*参数：
*    paObj_selectElement : select组件引用
*    paStr_code          :当前编码串
*    paInt_beginPos      :开始前馈的编码位置，第1码为1，第2码为2，以此类推
*    paInt_moveLen       :前移的步度
*    paBoo_isFirstMove   :是否是第一次前馈
*/
function moveMatchItemForward(paObj_selectElement,paStr_code,paInt_beginPos,paInt_moveLen,paBoo_isFirstMove)
{
  var loInt_selectOptionLen = paObj_selectElement.options.length;
  var loInt_codeLen = paStr_code.length;
  var loStr_tempText = null;  //选项字符串的字符
   
	var loChar_key ;         //编码串的字符	
	var loStr_matchCodeCn;   //对应编码字库中的字符串	
	
  if(ACTIVE_EN_QUICK_SELECT)//英文诱导激活
  {			
      //前馈到loInt_codeLen码的匹配数组				
			appendDebug("<font color='#0000CC' style='font-weight:bold'>英文诱导</font>前馈到"+loInt_codeLen+"码的匹配数组,paInt_beginPos :"+paInt_beginPos+" paInt_moveLen:"+paInt_moveLen);
			for(var i = paInt_beginPos - 1 ; i < paInt_beginPos + paInt_moveLen -1 ; i++)
			{
	       appendDebug("前馈到"+(i+1)+"码的匹配数组到"+(i+2));
	       var k ;
	       if( paBoo_isFirstMove && i+ 2 == paInt_beginPos + paInt_moveLen )//所有前馈
	       {			
	          k = 0;	                 
	       }
	       else//增量前馈
	       {				       
	          k = pbArr_matchStackPointer_en_0[i]+1 ;	
	       }				       
	       for(var j = k ; j <= pbArr_matchStackPointer_en_1[i] ; j++)
	       {
	          loStr_tempText = paObj_selectElement.options[pbArr2_MatchItem_en[i][j]].text;
	          if(loStr_tempText != null && loStr_tempText.length >= loInt_codeLen)
	          {	             
				 if(loStr_tempText.substr(0,loInt_codeLen).toLowerCase() == paStr_code)
				 {
					 if(pbArr_matchStackPointer_en_1[i+1] == -1)//第i+1码匹配数组未初始化
					 {
						pbArr2_MatchItem_en[i+1] = new Array(MAX_MATCH_ARRAY_LENGTH);
					 }	             
			         pbArr2_MatchItem_en[i+1][++pbArr_matchStackPointer_en_1[i+1]] = pbArr2_MatchItem_en[i][j];					  		 
				 }          
	          }
	       }
	       appendDebug((i+2)+"码的匹配数组为"+pbArr2_MatchItem_en[i+1]);			       			   
			}//for	
	}
	if(ACTIVE_PY_QUICK_SELECT)//拼音诱导激活
	{			  			
			//前馈到loInt_codeLen码的匹配数组				
			appendDebug("<font color='#0000CC' style='font-weight:bold'>拼音诱导：</font>将第"+paInt_beginPos+"码的匹配数组前馈"+paInt_moveLen+"步");
			for(var i = paInt_beginPos - 1 ; i < paInt_beginPos + paInt_moveLen -1 ; i++)
			{			    			   			   	       
	       var k ;
	       if( paBoo_isFirstMove && i+ 2 == paInt_beginPos + paInt_moveLen )//所有前馈
	       {			
	          k = 0;
	          loChar_key = paStr_code.substr(paStr_code.length -1,1).toUpperCase();	                 
	       }
	       else//增量前馈
	       {				       
	          k = pbArr_matchStackPointer_py_0[i]+1 ;
	          loChar_key = paStr_code.substr(i+1,1).toUpperCase();
	       }	                         	       
	       loStr_matchCodeCn = getMatchCodeCnStr(loChar_key,1);
	       
	       appendDebug("从第"+(i+1)+"码匹配数组"+(k==0?"全量":"增量")+"前馈到第"+(i+2)+"码匹配数组,索引开始于:"+k);	       
	       for(var j = k ; j <= pbArr_matchStackPointer_py_1[i] ; j++)
	       {	          
	          loStr_tempText = paObj_selectElement.options[pbArr2_MatchItem_py[i][j]].text;
	          appendDebug(loStr_tempText+"匹配否:"+isContain(loStr_matchCodeCn,loStr_tempText,i+1,1));
	          if(isContain(loStr_matchCodeCn,loStr_tempText,i+1,1))
	          {
				if(pbArr_matchStackPointer_py_1[i+1] == -1)//第1码匹配数组未初始化
				{
				  pbArr2_MatchItem_py[i+1] = new Array(MAX_MATCH_ARRAY_LENGTH);
				}			             
				pbArr2_MatchItem_py[i+1][++pbArr_matchStackPointer_py_1[i+1]] = pbArr2_MatchItem_py[i][j];
	          }
	       }	
	       appendDebug("第"+(i+1)+"码的匹配数组为"+pbArr2_MatchItem_py[i]);			 
			   appendDebug("第"+(i+2)+"码的匹配数组为"+pbArr2_MatchItem_py[i+1]);	       		       
			}//for		
	}
	if(ACTIVE_WB_QUICK_SELECT)//五笔诱导激活
	{			         			
			//前馈到loInt_codeLen码的匹配数组				
			appendDebug("<font color='#0000CC' style='font-weight:bold'>拼音诱导</font>前馈到"+loInt_codeLen+"码的匹配数组,paInt_beginPos :"+paInt_beginPos+" paInt_moveLen:"+paInt_moveLen);
			for(var i = paInt_beginPos - 1 ; i < paInt_beginPos + paInt_moveLen -1 ; i++)
			{			    
			   appendDebug("前馈到"+(i+1)+"码的匹配数组到"+(i+2));
	       var k ;
	       if( paBoo_isFirstMove && i+ 2 == paInt_beginPos + paInt_moveLen )//所有前馈
	       {			
	          k = 0;
	          loChar_key = paStr_code.substr(paStr_code.length -1,1).toUpperCase();	                 
	       }
	       else//增量前馈
	       {				       
	          k = pbArr_matchStackPointer_wb_0[i]+1 ;
	          loChar_key = paStr_code.substr(i+1,1).toUpperCase();	
	       }
	       loStr_matchCodeCn = getMatchCodeCnStr(loChar_key,2);
	       
	       appendDebug("pbArr_matchStackPointer_wb_0["+i+"]"+pbArr_matchStackPointer_wb_0[i]+"pbArr_matchStackPointer_wb_1["+i+"]"+pbArr_matchStackPointer_wb_1[i]);	       
	       for(var j = k ; j <= pbArr_matchStackPointer_wb_1[i] ; j++)
	       {
	          loStr_tempText = paObj_selectElement.options[pbArr2_MatchItem_wb[i][j]].text;
	          if(isContain(loStr_matchCodeCn,loStr_tempText,i+1,1))
	          {
				if(pbArr_matchStackPointer_wb_1[i+1] == -1)//第1码匹配数组未初始化
				{
				  pbArr2_MatchItem_wb[i+1] = new Array(MAX_MATCH_ARRAY_LENGTH);
				}			             
				pbArr2_MatchItem_wb[i+1][++pbArr_matchStackPointer_wb_1[i+1]] = pbArr2_MatchItem_wb[i][j];
	          }
	       }				 
			   appendDebug((i+2)+"码的匹配数组为"+pbArr2_MatchItem_wb[i+1]);	       		       
			}//for			  				
	}
  //更新栈指针
  pbArr_matchStackPointer_en_0 = cloneArray(pbArr_matchStackPointer_en_1);//保存上次搜索的匹配数组堆栈指针：英文
  pbArr_matchStackPointer_py_0 = cloneArray(pbArr_matchStackPointer_py_1);//拼音
  pbArr_matchStackPointer_wb_0 = cloneArray(pbArr_matchStackPointer_wb_1);//中文		
}
/**
*功能：
*    克隆一个数组
*参数：
*    paArr:需要克隆的数组对象
*返回：
*    克隆表码数组对象
*/
function cloneArray(paArr)
{
  if(paArr == null) return null;
  var loArr_new = new Array(paArr.length);
  for(var i = 0 ; i< paArr.length ; i++)
    loArr_new[i] = paArr[i]; 
  return loArr_new;
}
/**
*功能：
*    到xml的编码库中搜索，得到编码匹配的中文字串
*参数：
*    paChar_key:按键编码
*    paInt_codeType：编码类型 1 拼音 2 五笔
*返回：
*    编码匹配的所有汉字串
*/
function getMatchCodeCnStr(paChar_key,paInt_codeType)
{
	var loChar_key ;
	var loNode_xmlNode ;     //xml字库中匹配的结点	
	if(paChar_key != null && paChar_key.length == 1)
	{
		//如果是特殊符号，转换编号为V,否则变为大写 
		if(pbStr_specialChars.indexOf(paChar_key) != -1)
		{
		   loChar_key =  "V";
		}
		else
		{
		  loChar_key = paChar_key.toUpperCase();
		} 
		//在xml字库中搜索所有编码匹配的汉字
		if(paInt_codeType == 1)//拼音
		{
		   loNode_xmlNode = pbXMLDoc_quickSelectCodeLib.selectSingleNode("bm/py/group[@bm = '"+loChar_key+"']");
		}
		else if(paInt_codeType == 2)
		{
		   loNode_xmlNode = pbXMLDoc_quickSelectCodeLib.selectSingleNode("bm/wb/group[@bm = '"+loChar_key+"']");
		}
		else
		{
		   alert("编码类型错误，异常发生在：getMatchCodeCnStr(paChar_key,paInt_codeType),编码类型为："+paInt_codeType);
		}
		if(loNode_xmlNode == null)
		{
		   return "";
		}else
		{
		   return loNode_xmlNode.text;
		} 		
	}
	else
	{
	   alert("异常发生在:toValidCode(paChar_key),参数为："+paChar_key+",参数必须为字符");
	}   
}
/**
*功能：
*    将匹配的项目填到全局匹配索引数组pbArr_matchItem中
*参数：
*    paInt_codeLen:编码长度
*/
function fillMatchItemArr(paInt_codeLen)
{
    pbArr_matchItem = new Array(MAX_MATCH_COUNT);
    pbInt_focusMatchItemIndex = 0;
    pbInt_matchItemCurrPage   = 1;
    appendDebug("<font color='#aaaaaa'>取码长为"+paInt_codeLen+"的匹配项</font>");
    var loInt_matchCount = 0;
    for (var i = 0 ; ACTIVE_EN_QUICK_SELECT && i <= pbArr_matchStackPointer_en_1[paInt_codeLen - 1] ; i++)//英文(paInt_codeLen-1)码串匹配索引数组
    {
       if(loInt_matchCount >= MAX_MATCH_COUNT) break ;      
       if(!isArrContainItem(pbArr_matchItem,pbArr2_MatchItem_en[paInt_codeLen - 1][i]))
          pbArr_matchItem[loInt_matchCount++] = pbArr2_MatchItem_en[paInt_codeLen - 1][i];
       else
          continue;
    }
    appendDebug("<font color='#aaaaaa'>取码长为"+paInt_codeLen +"的匹配项为"+pbArr_matchStackPointer_py_1[paInt_codeLen - 1]+"的匹配项</font>");
    for (var i = 0 ; ACTIVE_PY_QUICK_SELECT && i <= pbArr_matchStackPointer_py_1[paInt_codeLen - 1] ; i++)//拼音(paInt_codeLen-1)码串匹配索引数组
    {
       if(loInt_matchCount >= MAX_MATCH_COUNT) break ; 
       if(!isArrContainItem(pbArr_matchItem,pbArr2_MatchItem_py[paInt_codeLen - 1][i]))
          pbArr_matchItem[loInt_matchCount++] = pbArr2_MatchItem_py[paInt_codeLen - 1][i];
       else
          continue;
    } 
    for (var i = 0 ; ACTIVE_WB_QUICK_SELECT && i <= pbArr_matchStackPointer_wb_1[paInt_codeLen - 1] ; i++)//五笔(paInt_codeLen-1)码串匹配索引数组
    {
       if(loInt_matchCount >= MAX_MATCH_COUNT) break ;
       if(!isArrContainItem(pbArr_matchItem,pbArr2_MatchItem_wb[paInt_codeLen - 1][i]))
          pbArr_matchItem[loInt_matchCount++] = pbArr2_MatchItem_wb[paInt_codeLen - 1][i];
       else
          continue;
    } 
    appendDebug("<font color='red'>获取第"+paInt_codeLen+"码的匹配数组为："+pbArr_matchItem+"</font>");   
}
/**
*功能：
*    判断一个数组是否包含一个特定的元素对象
*参数：
*    paArr:对象数组
*    paObj_item:元素对象，可以是基本数据类型或对象
*/
function isArrContainItem(paArr,paObj_item)
{
   if(paArr == null)
   {
      return false;
   }
   else
   {
      for(var i = 0 ; i < paArr.length ; i++)
      {
         if(paArr[i] == paObj_item)
           return true;
      }
      return false;
   }
}
/**
*功能：
*     判断字符串1是否包含字符串2前指定部分的内容
*参数：
*    paStr_1:字符串1
*    paStr_2:字符串2，应保证paStr_2的长度大于paInt_len
*    paInt_beginIndex：paStr_2开始的索引
*    paInt_len:        paStr_2从paInt_beginIndex开始的长度
*返回：
*     true 包括
*     false 不包括
*/
function isContain(paStr_1,paStr_2,paInt_beginIndex,paInt_len)
{
	 if(paStr_1 == null || paStr_1.length < paInt_len)
	 {
	    return false;
	 }
	 if(paStr_2 == null || paStr_2.length < paInt_beginIndex + 1 )
	 {
	   return false;
	 }
	 paStr_1 = paStr_1.toLowerCase();
	 paStr_2 = paStr_2.toLowerCase();
	 if (paStr_1.indexOf(paStr_2.substr(paInt_beginIndex,paInt_len)) > -1)
	 {
	   return true;
	 }
	 else
	 {
	   return false;
	 }

}
/**
*功能：
*     得到当前所有匹配项目的数目总和
*参数：
*    paInt_codeLen:码串的长度
*返回：
*     true 包括
*     false 不包括
*/
function getTotalMatchCount(paInt_codeLen)
{
    var tempTotalMatchCount = 0 ;
    if(pbArr_matchStackPointer_en_1[paInt_codeLen - 1] > -1)//英文(paInt_codeLen-1)码串匹配索引数组
       tempTotalMatchCount += pbArr_matchStackPointer_en_1[paInt_codeLen - 1] + 1;
    if(pbArr_matchStackPointer_py_1[paInt_codeLen - 1] > -1)//拼音(paInt_codeLen-1)码串匹配索引数组
       tempTotalMatchCount += pbArr_matchStackPointer_py_1[paInt_codeLen - 1] + 1;
    if(pbArr_matchStackPointer_wb_1[paInt_codeLen - 1] > -1)//五笔(paInt_codeLen-1)码串匹配索引数组
       tempTotalMatchCount += pbArr_matchStackPointer_wb_1[paInt_codeLen - 1] + 1;           
    return tempTotalMatchCount;       
}
/**
*功能：
*     弹出窗口
*输入参数：
*     selectName    下拉框名字
*     inputKeyStr   按键字母串
*     matchContent  匹配的项目(0到多条)
*     _x _y 窗口的  x,y坐标
*/
function quickSelectItem(selectName,inputKeyStr,matchContent,_x,_y)
{  
    document.all("SelectInputName").innerText = selectName;
	document.all("quickSelectInput").innerHTML = inputKeyStr+"<font color=red>|</font>";
	document.all("quickSelectMatch").innerHTML = matchContent;
	document.all("quickSelectPageSwitch").innerHTML = getPageSwitchStr();	

    if(pbBoo_supportPopup)
    {

	   pbPopup_matchShow.document.body.innerHTML = quickSelect.innerHTML; 
       pbPopup_matchShow.show(_x, _y, POPUP_WIDTH, POPUP_HEIGHT); 
	   setFocusMatchItem(0);
    }else//ie 5.0
    {
       top.status = inputKeyStr + ":" + matchContent.substr(pbInt_currBeginIndex);
    }    
}

/**
*功能：
*     获取匹配结果显示串,用于浮动窗口的显示
*参数：
*     paInt_page：页码，第一页为1，第二页为2...
*返回：
*     匹配结果显示串
*/
function getMatchItemStr(paInt_page)
{
  var tempStr = "";
  var loInt_beginIndex = (paInt_page -1) * 10 ;
  var loInt_label = 0;
  if(pbBoo_supportPopup)//支持popup 窗口
  {
	if(LIST_FORMAT_TYPE == 1)//基本样式
		{
		   for(var i = 0;i < 10;i++)
		   {
			  loInt_label = i+1 < 10 ? i+1:0 ;
			  if(pbArr_matchItem[loInt_beginIndex+i] == null)
				break;
			  tempStr += "<font id=qsMatchItem_"+loInt_label+"  onMouseOver='parent.selectItemMouseOver(this,2)' onMouseOut='parent.selectItemMouseOut(this,2)' onclick=\"parent.fireKeyDownEvent("+ (new String(loInt_label)).charCodeAt(0)+")\" style='font-size:14px'>" +
						 loInt_label +":"+pbObj_currSelectElement.options[pbArr_matchItem[loInt_beginIndex+i]].text+"</font>,";
		   }	   
		   if(tempStr.length>0) tempStr=tempStr.substring(0,tempStr.length-1);
		}
		else if(LIST_FORMAT_TYPE == 2)//列表样式
		{
		   for(var i= 0;i< 10;i++)
		   {
			  loInt_label = i+1 < 10 ? i+1:0 ;
			  if(pbArr_matchItem[loInt_beginIndex+i] == null)
				 break;
			  tempStr += "<div id=qsMatchItem_"+loInt_label+"  onMouseOver='parent.selectItemMouseOver(this,2)' onMouseOut='parent.selectItemMouseOut(this,2)' onclick=\"parent.fireKeyDownEvent("+(new String(loInt_label)).charCodeAt(0)+")\" style='font-size:14px'>" +
						 loInt_label+":"+pbObj_currSelectElement.options[pbArr_matchItem[loInt_beginIndex+i]].text+"</div>";
		   }  
		}
		else if(LIST_FORMAT_TYPE == 3)//表样式
		{
		   tempStr += "<div align='center'><table borderColor=#003333 cellSpacing=2 borderColorDark=#ffffff " +
					"cellPadding=0 width="+(POPUP_WIDTH-30)+"px borderColorLight=#002222 border=1 style='font-size:14px' >";
		   for(var i= 0; i < 10 ; i++)
		   {
			  loInt_label = i+1 < 10 ? i+1:0 ;
			  if(pbArr_matchItem[loInt_beginIndex+i] == null)
				 break;
			  tempStr += "<tr id=qsMatchItem_"+loInt_label+"  onMouseOver='parent.selectItemMouseOver(this,3)' onMouseOut='parent.selectItemMouseOut(this,3)' onclick=\"parent.fireKeyDownEvent("+ (new String(loInt_label)).charCodeAt(0)+")\" ><td align='center'>"+loInt_label+"</td>"+
						 "<td align = 'left'>"+pbObj_currSelectElement.options[pbArr_matchItem[loInt_beginIndex+i]].text+"</td>"+
						 "</tr>";
		   } 
		   tempStr += "</table></div>" ; 
		}
		else
		{
		   alert("样式类型LIST_FORMAT_TYPE设置不合法，请检查。");
		}      
	}
	else//不支持popup窗口，ie5.0
	{
	   for(var i= 0;i< 10;i++)
	   {
		  loInt_label = i+1 < 10 ? i+1:0 ;
		  if(pbArr_matchItem[loInt_beginIndex+i] == null)
			 break;
		  tempStr += ""+loInt_label+":"+pbObj_currSelectElement.options[pbArr_matchItem[loInt_beginIndex+i]].text+",";
	   }
	   if(tempStr.length > 0 )
    	  tempStr = tempStr.substr(0,tempStr.length -1);
	}
    pbStr_windowStatusMatchItem = tempStr;
	return tempStr;
}
/**
*功能：
*    显示特定的匹配页面
*参数：
* paInt_page 需要到达的页面，第1页为1，第2页为2。。。
*/
function qsGotoPage(paInt_page)
{
   var loInt_totalPage = getPageCount();
   pbInt_matchItemCurrPage = paInt_page;
   quickSelectItem("",pbStr_code,getMatchItemStr(paInt_page),pbInt_corrX,pbInt_corrY);
}
/**
*功能：
*    获取页切换的代码
*返回：
*   页切换的代码
*/
function getPageSwitchStr()
{
   var loInt_totalPageCount = getPageCount();
   var loStr_pageSwitch = "";
   if(loInt_totalPageCount<2)
   {
      loStr_pageSwitch += "<font style=\"font-family: Webdings\">978:</font>(1/1)";
   }
   else
   {
      loStr_pageSwitch += "<font style=\"font-family: Webdings\">" ;
	  if(pbInt_matchItemCurrPage == 1)//首页
	  {
         loStr_pageSwitch += "97"+
		                     "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(34)\" >8</a>"+
							 "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(35)\" >:</a>";		                     
	  }
	  else if(pbInt_matchItemCurrPage == loInt_totalPageCount)//末页
	  {
         loStr_pageSwitch += "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(36)\" >9</a>"+
							 "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(33)\" >7</a>"+
							 "8:";
	  }
	  else//中间页
	  {
         loStr_pageSwitch += "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(36)\" >9</a>"+
							 "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(33)\" >7</a>"+
							 "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(34)\" >8</a>"+
							 "<a style=\""+HREF_STYLE+"\" href='javascript:void(null)'  onclick=\"parent.fireKeyDownEvent(35)\" >:</a>";
	  }
	  loStr_pageSwitch += "</font>("+ pbInt_matchItemCurrPage +"/"+ loInt_totalPageCount +")";
   }
   return loStr_pageSwitch;
}

/**
*功能：
*     设置激活的行
*参数：
*     paInt_focusItemIndex：要激活的行 0~9
*/
function setFocusMatchItem(paInt_focusItemIndex)
{
   var loInt_focusItemIndex = paInt_focusItemIndex == 9 ? 0: paInt_focusItemIndex + 1;
   for(var i = 0 ; i < 10 ; i++ )
   {
	  if(pbPopup_matchShow.document.all("qsMatchItem_"+i)) 
	     pbPopup_matchShow.document.all("qsMatchItem_"+i).fireEvent("onmouseout");
   }
   if(pbPopup_matchShow.document.all("qsMatchItem_"+loInt_focusItemIndex))
      pbPopup_matchShow.document.all("qsMatchItem_"+loInt_focusItemIndex).fireEvent("onmouseover");
}
/**
*功能：
*     触发一个按键动作
*参数：
*     keyCode：按键的键值
*/
function fireKeyDownEvent(keyCode)
{
  var loObj_event = document.createEventObject();
  loObj_event.keyCode = keyCode;
  pbObj_currSelectElement.fireEvent("onkeydown",loObj_event);
}
/**
*功能：
*     获取匹配项的个数
*返回：
*     匹配项个数
*/
function getMatchItemCount()
{
	var tempMatchCount=0;
	for(var i=0;i<MAX_MATCH_COUNT;i++)
	{
	   if(pbArr_matchItem[i]==null)
	     break;
	   else 
	     tempMatchCount++;
	}
	return tempMatchCount;
}
/**
*功能：
*     获取匹配的页数
*返回：
*     匹配页数
*/
function getPageCount()
{
   return Math.ceil(getMatchItemCount()/10);
}

/**
* 功能：
*     获取字串某一索引的字符
* 输入参数：
*     str  源字串
*     index 索引，以0开始
* 返回：
*     当字串为空或者位置超过了字串的长，返回""
*     否则返回特定位置的字符，第1位为1，...
*/
function getChar(str ,index)
{
   if(str == "" || index +1 > str.length) return "";
   return str.substr(index,1);
}

//得到字符串字节长度
function getRealLen(str)
{
   if(str == null | str == "") return 0;
   var bityLen = 0;
   var strLen  = str.length;
   for (var i = 0 ; i < strLen ; i++)
   {
       if(str.charCodeAt(i) > 255)
	       bityLen += 2;
	   else
	       bityLen++ ;
   }
   return bityLen;
}

/**
*功能：
*     获取浮动窗口左上角的x y 坐标
*返回：
*    坐标对象
*/
function getPopupCorr(obj)
{
   var MY_OFFSET_TOP=150;
   var MY_OFFSET_LEFT=150;//由于显示窗口的坐标是以screen的原点为基准的，我们以下计算的都只是以当前的窗口这基准，
   //如果是窗口嵌套的情况这个偏差的数字会更大些。
   
   var MARGIN_VERTICAL=2;
   var MARGIN_HORIZONTAL=2;
   var wW = screen.width;
   var wH = screen.height;  
   var eX = event.screenX - event.offsetX;// select 左上角组件对应screen坐标系的横轴坐标
   var eY = event.screenY - event.offsetY;// select 左上角组件对应screen坐标系的纵轴坐标
   var sH = obj.offsetHeight;
   var sW = obj.offsetWidth;
   
   
   //确定y 
   if(eY + sH + MARGIN_VERTICAL + POPUP_HEIGHT > wH) //超出下边
   {
      y=eY - MARGIN_VERTICAL - POPUP_HEIGHT ;
   }else
   {
     y=eY + sH + MARGIN_VERTICAL ;
   }
   //确定x
      if(eX + sW + MARGIN_HORIZONTAL + POPUP_WIDTH > wW)//超过右边
   {
	  x=eX - POPUP_WIDTH -MARGIN_HORIZONTAL;
   }else
   {
     x=eX + sH + MARGIN_HORIZONTAL;
   }
   var corr = new Object();
   corr.X=x ;
   corr.Y=y ;
   return corr;
}
function myHidePopupWindow()
{
  //清除现场
  initCurrMatchEnv(pbStr_code,pbBoo_isBackspace);
  pbBoo_isBackspace = false;
  if(pbBoo_supportPopup) 
     pbPopup_matchShow.hide();
  else
     top.status = "";
}
/**初始化代码段
*初始化一个层，用于浮动窗口的显示
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var divStr="";
divStr+="<DIV ID=\"quickSelect\" STYLE=\"display:none;overflow:scroll\">";
divStr+="<div style=\"position: absolute; top:0; left:0; width:100%; height:100%; border:1px solid "+POPUP_WINDOW_BORDER_COLOR+";  filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr= " + POPUP_WINDOW_COLOR + ", EndColorStr=#FFFFFF); padding:10px\" >";
 divStr+="<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
  divStr+="<tr align=\"15\">";
    divStr+="<td id=\"SelectInputName\" align=\"left\" style=\"font-size:12px;color:blue\" width=\"30%\" >name</td>";
    divStr+="<td id=\"quickSelectInput\" align=\"left\" style=\"font-size:14px\" width=\"70%\">code</td>";
  divStr+="</tr>";
  divStr+="<tr><td height=\"2\" align=\"center\" colspan=\"2\"><hr size=\"1\" style=\"border:1px solid black;\"></td></tr>";
  divStr+="<tr><td id=\"quickSelectMatch\"　align=\"left\" colspan=\"2\" style=\"font-size:14px\">dfasdf</td></tr>";
  divStr+="<tr><td id=\"quickSelectPageSwitch\"　 colspan=\"2\" style=\"font-size:14px\" align=\"right\"></td></tr>";
divStr+="</table></div></DIV>";
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
*功能：
*    初始化浮动窗口
*/
function quickSelectInit()
{
	
   var selectArr = document.all.tags("select");
   for(var i = 0 ; selectArr != null && i < selectArr.length ; i++) //接管所有下拉框组件的按键事件 
      selectArr[i].onkeydown = mySelectKeyDown;
   tempInfoSpan=document.createElement("span");
   tempInfoSpan.id="quickText_001";

   tempInfoSpan.innerHTML=divStr;
   document.body.appendChild(tempInfoSpan);

}

/**
*功能：
*     用户移动鼠标时改变颜色
*参数：
*    paObj：产生鼠标移动信息的对象
*    paInt_listFormatType：显示的格式类型，1:基本样式,2:每选项一行样式，3:表格样式
*/
function selectItemMouseOver(paObj,paInt_listFormatType) {
	var loInt_currFocusIndex = pbInt_focusMatchItemIndex % 10 == 9 ? 0: pbInt_focusMatchItemIndex % 10 + 1;
	var tempMatchItemObj = pbPopup_matchShow.document.all("qsMatchItem_"+loInt_currFocusIndex);
    if(tempMatchItemObj && tempMatchItemObj != paObj)
    {
	   tempMatchItemObj.fireEvent("onmouseout"); 
    }
    pbStr_mouseOutBgColor = paObj.style.backgroundColor;	
    paObj.style.backgroundColor = LIST_MOUSEOVER_BGCOLOR;	
    switch(paInt_listFormatType)
    {
       case 1:        
       case 2:
			    pbStr_mouseOutFgColor = paObj.style.color;
			    paObj.style.color = LIST_MOUSEOVER_FGCOLOR; 
       break;
       case 3:
 			    pbStr_mouseOutFgColor = paObj.cells[0].style.color;
			    paObj.cells[0].style.color = LIST_MOUSEOVER_FGCOLOR;  
			    paObj.cells[1].style.color = LIST_MOUSEOVER_FGCOLOR;      
       break;       
    }	
}
/**
*功能：
*     用户移动鼠标时改变颜色
*参数：
*    paObj：产生鼠标移动信息的对象
*    paInt_listFormatType：显示的格式类型，1:基本样式,2:每选项一行样式，3:表格样式
*/
function selectItemMouseOut(paObj,paInt_listFormatType) {
    paObj.style.backgroundColor=pbStr_mouseOutBgColor;   
    switch(paInt_listFormatType)
    {
       case 1:        
       case 2:
			   paObj.style.color = pbStr_mouseOutFgColor;       
       break;
       case 3:
          paObj.cells[0].style.color = pbStr_mouseOutFgColor;
          paObj.cells[1].style.color = pbStr_mouseOutFgColor;
       break;       
    }    
}

/*调试程序*/
function addDebug(info)
{
   //document.all("debugInfo").innerHTML = "<br>"+info;
}
function appendDebug(info)
{
  //document.all("debugInfo").innerHTML += "<br>"+info;
}
-->