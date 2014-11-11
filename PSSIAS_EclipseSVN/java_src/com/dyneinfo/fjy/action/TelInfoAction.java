/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.fjy.model.TelInfo;
import com.dyneinfo.fjy.service.TelInfoManager;
import com.dyneinfo.zazh.model.DoubleselectCity;
import com.dyneinfo.zazh.model.DoubleselectProv;
import com.dyneinfo.zazh.service.SsCommonManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TelInfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String CREATE_JSP = "/pages/fjy/TelInfo/create.jsp";


	
	
	private TelInfoManager telInfoManager;
	private SsCommonManager ssCommonManager;
	
	TreeMap<String,String> jbrMap ;
	
	
	private TelInfo telInfo;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	
	//手机型号 双选框
	private List<DoubleselectProv> provList;
	private Map<String, List<DoubleselectCity>> cityMap;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			telInfo = new TelInfo();
		} else {
			telInfo = (TelInfo)telInfoManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTelInfoManager(TelInfoManager manager) {
		this.telInfoManager = manager;
	}	
	
	public Object getModel() {
		return telInfo;
	}
	
	public void setTelinfoid(java.lang.String val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public TreeMap<String, String> getDateSelectMap() {
		return dateSelectMap;
	}

	public void setDateSelectMap(TreeMap<String, String> dateSelectMap) {
		this.dateSelectMap = dateSelectMap;
	}

	
	

	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 手机品牌型号联动选择框
		String deptID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		 getMobilePPXH();
		String s_telpp = "",s_telxh="";
		if (request.getParameter("s_telpp") != null)
			s_telpp = request.getParameter("s_telpp");
		request.setAttribute("defaultItem",s_telpp);
		if (request.getParameter("s_telxh") != null)
			s_telxh = request.getParameter("s_telxh");
		request.setAttribute("doubleDefaultItem",s_telxh);
		
		String sql = "select  EMPCODE,EMPNAME  from T_EMPLOYEE where cyrjzt != '2' and CPCODE ='"+deptID+"'";
		jbrMap = new TreeMap();
		List staList = ssCommonManager.getSjpp(sql);
		if (staList != null) {
			for (int j = 0; j < staList.size(); j++) {
				Map staResults = (HashMap) staList.get(j);
				String staCODE = (String) staResults.get("CODE");
				String staCALLED = (String) staResults.get("CALLED");
				jbrMap.put(staCODE, staCALLED);
			}
		}
		
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String gjsjFormat = DateUtil.parseString(request,"gjsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		telInfo.setGjsj(gjsjFormat);
		
		
		String deptID = "";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			deptID = userDetail.getDeptID();
		}
		Date date = new Date();
		SimpleDateFormat format_inserttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_inserttime = format_inserttime.format(date);
		telInfo.setCpcode(deptID);
		telInfo.setSgsjString(str_inserttime);
		
		telInfoManager.save(telInfo);
		return returnUrl;////LIST_ACTION;
	}
	
	
	
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String gjsjFormat = DateUtil.parseString(request,"gjsj","yyyy-MM-dd HH:mm:ss","yyyyMMddHHmmss");
		telInfo.setGjsj(gjsjFormat);
		telInfoManager.update(this.telInfo);
		return returnUrl;////LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("telinfoid"));
			telInfoManager.removeById(id);
			telInfoManager.removeTelxs(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public List<DoubleselectProv> getProvList() {
		return provList;
	}

	public void setProvList(List<DoubleselectProv> provList) {
		this.provList = provList;
	}

	public Map<String, List<DoubleselectCity>> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, List<DoubleselectCity>> cityMap) {
		this.cityMap = cityMap;
	}

	public SsCommonManager getSsCommonManager() {
		return ssCommonManager;
	}

	public void setSsCommonManager(SsCommonManager ssCommonManager) {
		this.ssCommonManager = ssCommonManager;
	}
	
	public void getMobilePPXH() {
		// 手机品牌型号联动选择框
		String sql = "select  CODE,CALLED  from T_DIC_SJPP";
		List list = (List) ssCommonManager.getSjpp(sql);
		provList = new ArrayList<DoubleselectProv>();
		cityMap = new HashMap<String, List<DoubleselectCity>>();
		DoubleselectProv doubleselectProv;
		DoubleselectCity city;

		doubleselectProv = new DoubleselectProv();
		doubleselectProv.setId("");
		doubleselectProv.setName("请选择...");
		provList.add(doubleselectProv);

		List<DoubleselectCity> cityList_start = new ArrayList<DoubleselectCity>();
		city = new DoubleselectCity();
		city.setId("");
		city.setName("请选择...");
		city.setDoubleselectProvId("");
		cityList_start.add(city);
		cityMap.put("", cityList_start);

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String CODE = (String) results.get("CODE");
				String CALLED = (String) results.get("CALLED");

				doubleselectProv = new DoubleselectProv();
				doubleselectProv.setId(CODE);
				doubleselectProv.setName(CALLED);
				provList.add(doubleselectProv);
				// 手机型号代码数据
				List staList = (List) ssCommonManager
						.getSjxh(" where  PPCODE= '" + CODE + "'");
				List<DoubleselectCity> cityList = new ArrayList<DoubleselectCity>();
				city = new DoubleselectCity();
				city.setId("");
				city.setName("请选择...");
				city.setDoubleselectProvId(CODE);
				cityList.add(city);
				if (staList != null) {
					for (int j = 0; j < staList.size(); j++) {
						Map staResults = (HashMap) staList.get(j);
						String staCODE = (String) staResults.get("CODE");
						String staCALLED = (String) staResults.get("CALLED");
						city = new DoubleselectCity();
						city.setId(staCODE);
						city.setName(staCALLED);
						city.setDoubleselectProvId(CODE);
						cityList.add(city);
					}
				}
				cityMap.put(CODE, cityList);
			}
		}
		// //手机品牌型号联动选择框 结束
	}

	public TreeMap<String, String> getJbrMap() {
		return jbrMap;
	}

	public void setJbrMap(TreeMap<String, String> jbrMap) {
		this.jbrMap = jbrMap;
	}
	

}
