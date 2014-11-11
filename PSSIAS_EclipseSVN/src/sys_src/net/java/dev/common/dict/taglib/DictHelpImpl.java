package net.java.dev.common.dict.taglib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import net.java.dev.common.dict.ISelectOption;
import net.java.dev.common.dict.entity.SelectOption;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;



import com.dyneinfo.zazh.model.DictType;
import com.dyneinfo.zazh.model.DictItem;

public class DictHelpImpl extends JdbcDaoSupport implements InitializingBean {   
	  
	protected static Logger log = Logger.getLogger(DictHelpImpl.class);
	
	   




	/** 所有的行业类别列表,以系统语言类别为key，分类存放List */
	public static Hashtable adminMenus = new Hashtable();

	public static Locale[] SysLocales = new Locale[] { new Locale("zh", "CN")};

	/** 本系统支持的语言列表,以系统语言类别为key，分类存放List */
	public static Hashtable SysLanguageMap = new Hashtable();

	/** 所有的语言列表,以系统语言类别为key，分类存放List */
	public static Hashtable AllLanguageMap = new Hashtable();

	/** 所有的国家地区列表,以系统语言类别为key，分类存放List */
	public static Hashtable AllCountryMap = new Hashtable();

	/** 所有的属性字典列表,以属性名和系统语言为key，分类存放List */
	public static Hashtable DictMap = new Hashtable();
	
	
	
	


	/**
	 * 取得当前系统支持的语言列表 初始化时把语言列表整理成下拉菜单格式的列表放入内存
	 * 
	 * @param locale
	 * @return
	 */
	public static List getSysLanguageList(Locale locale) {
		if(locale == null){
			locale = Locale.getDefault();
			log.error("取当前系统支持的语言,没有传入正确的Locale ，使用系统缺省 "+locale);
		}
		List SysLanguageList = (List) SysLanguageMap.get(locale.toString());
		if (SysLanguageList == null) {
			SysLanguageList = new ArrayList();
			for (int i = 0; i < SysLocales.length; i++) {
				String languageLabel = SysLocales[i].getDisplayLanguage(locale);
				String languageValue = SysLocales[i].toString();
				if (languageLabel == null || "".equals(languageLabel))
					continue;
				ISelectOption vbean = new SelectOption(languageValue, languageLabel);
				SysLanguageList.add(vbean);
			}
			SysLanguageMap.put(locale.toString(), SysLanguageList);
			log.info("数据加载完成：将 [系统支持的语言列表]（" + locale + "） 到内存中");
		}
		return SysLanguageList;
	}

	/**
	 * 取得所有语言列表 初始化时把语言列表整理成下拉菜单格式的列表放入内存
	 * 
	 * @param locale
	 * @return
	 */
	public static List getAllLanguageList(Locale locale) {
		List AllLanguageList = (List) AllLanguageMap.get(locale.toString());
		if (AllLanguageList == null) {
			Locale[] locales = Locale.getAvailableLocales();
			AllLanguageList = new ArrayList();
			for (int i = 0; i < locales.length; i++) {
				String label = locales[i].getDisplayName(locale);
				String value = locales[i].toString();
				if(value.indexOf("_") < 1)
					continue;
				SelectOption vbean = new SelectOption(value, label);
				AllLanguageList.add(vbean);
			}
			AllLanguageMap.put(locale.toString(), AllLanguageList);
			log.info("数据加载完成：将 [所有语言列表]（" + locale + "） 载入到内存中");
		}
		return AllLanguageList;
	}
	
	/**
	 * 根据语言或国家代码 获得一个本地化对象
	 * @param language  语言或国家代码
	 * @return
	 */
	static public Locale getLocaleByLang(String language) {
		if (language == null || language.equals(""))
			return null;
		String[] subs = language.split("_");
		if (subs.length == 3)
			return new Locale(subs[0], subs[1], subs[2]);
		else if (subs.length == 2)
			return new Locale(subs[0], subs[1]);
		else
			return new Locale(language);
	}

	/**
	 * 取得所有国家地区列表 初始化时把国家列表整理成下拉菜单格式的列表放入内存
	 * 
	 * @param locale
	 * @return
	 */
	public static List getAllCountryList(Locale locale) {
		if(locale == null)
			locale = getLocaleByLang("zh_CN");
		List AllCountryList = (List) AllCountryMap.get(locale.toString());
		if (AllCountryList == null) {
			Locale[] locales = Locale.getAvailableLocales();
			//java.util.Arrays.(locales);
			AllCountryList = new ArrayList();
			for (int i = 0; i < locales.length; i++) {
				String label = locales[i].getDisplayCountry(locale);
				String value = locales[i].toString();
				if(label == null || label.equals(""))
					continue;
				if(value == null || value.equals("") || value.length() > 6)
					continue;
				SelectOption vbean = new SelectOption(value, label);
				AllCountryList.add(vbean);
			}
			
			AllCountryMap.put(locale.toString(), AllCountryList);
			log.info("数据加载完成：将 [所有国家地区列表]（" + locale + "） 载入到内存中");
		}
		return AllCountryList;
	}

	/**
	 * 加载数据库中的属性字典数据到内存 
	 */
	public  void loadDicts(){
		try {
			List catList = getSsDictType();
			if (catList != null) {
				for (int i = 0; i < catList.size(); i++) {
					DictType ssDictType = (DictType) catList.get(i);
					loadDictByCat(ssDictType);
					
				}
				// 导入民族数据
				List nationList = getNation(" where 1 = 1 ");
				StringBuffer ids = new StringBuffer(200);
				if (nationList != null) {
					for (int i = 0; i < nationList.size(); i++) {
						Map results = (HashMap) nationList.get(i);

						String CODE = (String) results.get("CODE");
						String CODE2 = (String) results.get("CODE2");
						String CALLED = (String) results.get("CALLED");
						ids.append("\"");
						ids.append(CALLED);
						ids.append("----");
						ids.append(CODE);
						ids.append("----");
						ids.append(CODE2);
						ids.append("\"");
						if (i != nationList.size() - 1)
							ids.append(",");
					}
				}
				DictMap.remove("nationData");
				DictMap.put("nationData", ids.toString());
			}
			
			loadOtherDict();
		} catch (Exception e) {
			log.error("加载属性字典表出错：" + e, e);
		}
	}
	
	private void loadOtherDict() throws Exception {
		// 导入配置信息
		List appList = getAppConfig();
		if (appList != null && appList.size() > 0) {
			for (int i = 0; i < appList.size(); i++) {
				Map results = (HashMap) appList.get(i);
				String key = (String) results.get("key");
				String code = (String) results.get("code");
				String default_value = (String) results.get("name");
				String value = (String) code == null ? default_value
						: code;
				System.out.println(key+":"+value);
				DictMap.put(key, value);
			}
		}
	}
	
	public List getAppConfig() {
		String sql = " select t.key,t.name,t.code from T_CONFIG t  ";
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String key = rs.getString(1);
	        	    String name = rs.getString(2);
	        	    String code = rs.getString(3);
			        results.put("key", key);
			        results.put("name", name);
			        results.put("code", code);
			        return results;
	           }
	           
	       });
	   }

	/**
	 * 按属性字典类别从数据库载入数据到内存
	 * @param cat
	 * @throws HibernateException
	 * @throws BusinessException
	 */
	private  void loadDictByCat(DictType ssDictType) throws Exception{
		for(int i=0;i<DictHelpImpl.SysLocales.length;i++){
			loadDictByCatLang( ssDictType,SysLocales[i].toString());
		}

	}
	private  void loadDictByCatLang(DictType ssDictType,String language) throws Exception{
		//DictMap.put(catDicts.getName() + language, new ArrayList());
		String sql = "";
		String dicttypeid = "";
		String dicttypename = "";
		Long dictlevel ;
		String parentid = "";
		String seqno = "";
		String dictflag = "";
		String querysql = "";

		if (ssDictType != null) {
			dicttypeid = ssDictType.getDicttypeid();
			dicttypename = ssDictType.getDicttypename();
			dictlevel = ssDictType.getDictlevel();
			parentid = ssDictType.getParentid();
			seqno = ssDictType.getSeqno();
			dictflag = ssDictType.getDictflag();
			querysql = ssDictType.getQuerysql();
		}
				
		
		
	  String	querysql_item = "select  "
			+" DICTID as dictid,"
			+" DICTNAME as dictname"
		
			+" from SS_DICT_ITEM where STATUS = '1' ";
		
	   if(ssDictType != null && dictflag !=null && dictflag.equals("0"))
         	sql = querysql_item + " and   dicttypeid = '"+dicttypeid+ "' order by sortno ";
	   else
		    sql = querysql;
		List list = getDictItem(sql);
		

		DictMap.put(dicttypeid + language, list);
		//log.info("载入属性字典表：" + tdicList.getTableName() + language);
		
		
	}	
	
	/**
	 * 按属性字典名和语言种类 取得字典所有选项
	 * @param catName  属性字典名，在dictName.jsp中注册
	 * @param language
	 * @return
	 */
	public static List getDict(String catName, String language) {
		log.debug("getDict("+catName+" , "+language+")");
		String dictName = catName + language;
		Enumeration enu = DictMap.keys();
		boolean hasName = false;
		while(enu.hasMoreElements()){
			if(enu.nextElement().equals(dictName))
				hasName = true;
		}
		if(hasName == false){
			log.error("系统中未找到名为 "+catName+"("+language+") 的属性字典");
			return new ArrayList();
			//throw new SystemException("系统中未找到名为 "+catName+"("+language+") 的属性字典");
		}
		List list = (List) DictMap.get(dictName);
		return list;
	}
	
	/**
	 * 按属性字典名取得字典所有选项(所有语言种类)
	 * @param catName  属性字典名，在dictName.jsp中注册
	 * @param language
	 * @return
	 */
	public static List getDict(String catName) {
		//System.out.println("=   getDict 加载 系统数据字典");
		
		log.debug("getDict("+catName+")");
		List allLanguageList = new java.util.LinkedList();
		for (int i = 0; i < SysLocales.length; i++) {
			String dictName = catName + SysLocales[i].toString();
			List list = (List) DictMap.get(dictName);
			if(list != null)
				allLanguageList.addAll(list);
			//System.out.println("list ="+list);
		}
		return allLanguageList;
	}

	/**
	 * 重新加载属性字典，刷新内存中数据
	 * @param catName
	 * @param language
	 * @throws BusinessException 
	 * @throws HibernateException 
	 */
	 public void reloadDict(DictType ssDictType) throws Exception {

		for(int i=0;i<DictHelpImpl.SysLocales.length;i++){	
		if (DictMap.get(ssDictType.getDicttypeid() + SysLocales[i].toString()) != null)
			DictMap.remove(ssDictType.getDicttypeid() + SysLocales[i].toString());
		}
		loadDictByCat(ssDictType);
		// 导入民族数据
		List nationList = getNation(" where 1 = 1 ");
		StringBuffer ids = new StringBuffer(200);
		if (nationList != null) {
			for (int i = 0; i < nationList.size(); i++) {
				Map results = (HashMap) nationList.get(i);

				String CODE = (String) results.get("CODE");
				String CODE2 = (String) results.get("CODE2");
				String CALLED = (String) results.get("CALLED");
				ids.append("\"");
				ids.append(CALLED);
				ids.append("----");
				ids.append(CODE);
				ids.append("----");
				ids.append(CODE2);
				ids.append("\"");
				if (i != nationList.size() - 1)
					ids.append(",");
			}
		}
		DictMap.remove("nationData");
		DictMap.put("nationData", ids.toString());
	}
	 
	 
	 
//
//	/**
//	 * 翻译属性字典名，传入属性项的值 返回属性项名称
//	 * @param id
//	 * @return
//	 * @throws NumberFormatException
//	 * @throws BusinessException
//	 */
//	static public String getDictName(Long id) throws NumberFormatException {
//		Collection co = DictMap.values();
//		List[] allList = (List[]) co.toArray(new List[0]);
//		if (allList != null) {
//			for (int i = 0; i < allList.length; i++) {
//				for (int j = 0; j < allList[i].size(); j++) {
//					Dict dict = (Dict) allList[i].get(j);
//					if (dict.getId().equals(id))
//						return dict.getName();
//				}
//			}
//		}
//		return null;
//	}
	 
	 
	  //原来为afterPropertiesSet
	public void initLoad()  {
		//System.out.println("=   afterPropertiesSet 加载 系统数据字典");
		for (int i = 0; i <SysLocales.length; i++) {
			getAllCountryList(DictHelpImpl.SysLocales[i]);
			getAllLanguageList(DictHelpImpl.SysLocales[i]);
			getSysLanguageList(DictHelpImpl.SysLocales[i]);
		}
		loadDicts();
		loadLocalXzqh();
		}
	
	
	public List<DictType> getSsDictType() {
		String sql =  "select  "
		+" DICTTYPEID as dicttypeid,"
		+" DICTTYPENAME as dicttypename,"
		+" DICTLEVEL as dictlevel,"
		+" PARENTID as parentid,"
		+" SEQNO as seqno,"
		+" DICTFLAG as dictflag,"
		+" QUERYSQL as querysql"
		+" from SS_DICT_TYPE ";
		List dictTypeList = getJdbcTemplate().query(sql, new DictTypeMapper());
		return dictTypeList;
	}

	protected class DictTypeMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DictType ssDictType = new DictType();
			ssDictType.setDicttypeid(rs.getString(1));
			ssDictType.setDicttypename(rs.getString(2));
			ssDictType.setDictlevel(rs.getLong(3));
			ssDictType.setParentid(rs.getString(4));
			ssDictType.setSeqno(rs.getString(5));
			ssDictType.setDictflag(rs.getString(6));
			ssDictType.setQuerysql(rs.getString(7));
			return ssDictType;

		}
	}
	
	
	public    List<DictItem> getDictItem(String sql) {
		
		List dictItemList = getJdbcTemplate().query(sql, new DictItemMapper());
		return dictItemList;
	}

	protected  class DictItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DictItem dictItem = new DictItem();
			dictItem.setDictid(rs.getString(1));
			dictItem.setDictname(rs.getString(2));
			
			return dictItem;

		}
	}
	
	

	
	public List getNation(String sqlwhere) {
		String sql = "select CODE,CALLED from T_DIC_NATION  ";
		if (sqlwhere != null && sqlwhere.length() > 0 )
			sql = sql +sqlwhere;
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String CODE = rs.getString(1);
	        	    //String CODE2 = rs.getString(2);
	        	    String CALLED = rs.getString(2);
			        results.put("CODE", CODE);
			        //results.put("I_CODE", CODE2);
			        results.put("CALLED", CALLED);
			        return results;
	           }
	           
	       });
	   }
	
	/**
	 * 按初始属性名 取得值
	 * @param catName  
	
	 * @return
	 */
	public static String getInitData(String Name) {
		
		
		Enumeration enu = DictMap.keys();
		boolean hasName = false;
		while(enu.hasMoreElements()){
			if(enu.nextElement().equals(Name))
				hasName = true;
		}
		if(hasName == false){
			log.error("系统中未找到名为 "+Name+" 的初始属性名");
			return "";
		}
	   String initDataValue = (String) DictMap.get(Name);
	   return initDataValue;
	}
	
	public void loadLocalXzqh(){
		String Local_xzqh_sql = ""
			+ "select CODE, CALLED "
			+ "  from T_DIC_XZQH d "
			+ " where d.code like "
			+ "       substr((select deptid from SS_DEPT where deptid like '____00000000'), "
			+ "              1, "
			+ "              4) || '%' order by code asc";
		List Local_xzqh = getDictItem(Local_xzqh_sql);
		DictMap.put("DIC_ITEM_LOCAL_XZQH" + SysLocales[0].toString(), Local_xzqh);
	}
	


}