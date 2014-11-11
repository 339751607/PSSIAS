/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.action;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.model.VfeijiuwupinSta;
import com.dyneinfo.fjy.service.VemployeeStaManager;
import com.dyneinfo.fjy.service.VfeijiuwupinStaManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class VfeijiuwupinStaAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/fjy/VfeijiuwupinSta/query.jsp";
	protected static final String LIST_JSP= "/pages/fjy/VfeijiuwupinSta/list.jsp";
	protected static final String LISTXML_JSP= "/FusionCharts/text.jsp";
	protected static final String TXLIST_JSP= "/pages/fjy/VfeijiuwupinSta/txlist.jsp";
	protected static final String CREATE_JSP = "/pages/fjy/VfeijiuwupinSta/create.jsp";
	protected static final String EDIT_JSP = "/pages/fjy/VfeijiuwupinSta/edit.jsp";
	protected static final String SHOW_JSP = "/pages/fjy/VfeijiuwupinSta/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/fjy/VfeijiuwupinSta/list.do";
	
	private VfeijiuwupinStaManager vfeijiuwupinStaManager;
	
	private VfeijiuwupinSta vfeijiuwupinSta;
	Long id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择
	private VemployeeStaManager vemployeeStaManager;
	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			vfeijiuwupinSta = new VfeijiuwupinSta();
		} else {
			vfeijiuwupinSta = (VfeijiuwupinSta)vfeijiuwupinStaManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setVfeijiuwupinStaManager(VfeijiuwupinStaManager manager) {
		this.vfeijiuwupinStaManager = manager;
	}	
	
	public Object getModel() {
		return vfeijiuwupinSta;
	}
	
	public void setDeptid(Long val) {
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

	/** 进入查询页面 */
	public String query() {
		//日历快速选择用到
		dateSelectMap  = DateUtil.getDateSelectData();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("dateSelect","11");//选中本周
//		DateUtil tt = new DateUtil();     
//      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
//      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
		return QUERY_JSP;
	}
	
	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		//pageRequest.getFilters().put("key",value);     //add custom filter
		
		String username = "";
		String deptid = "";
		String deptseq="";
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
			deptseq=userDetail.getDeptSeq();
		}
		
		dateSelectMap = DateUtil.getDateSelectData();

		
		String bDate = DateUtil.parseString(request,
				"s_shougourqBegin", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmSS");
		String eDate = DateUtil.parseString(request,
				"s_shougourqEnd", "yyyy-MM-dd HH:mm", "yyyyMMddHHmmSS");

		String s_deptseq=request.getParameter("s_deptseq")!=null?request.getParameter("s_deptseq"):deptseq;
		String[] ss  = s_deptseq.split("\\.");
		if(ss!= null && ss.length >=3){
		if( ss[1].equals(ss[2])){
			s_deptseq = s_deptseq.substring(5, s_deptseq.length());
		} }
		request.setAttribute("deptseq", s_deptseq);
		
		
		String s_deptlevel="";
		
		int dep_level_int=2;
		s_deptlevel = vemployeeStaManager.getDeptLevelBySeq(s_deptseq);
		if(s_deptlevel != null && s_deptlevel.length() > 0){
			dep_level_int = Integer.parseInt(s_deptlevel);
			dep_level_int = dep_level_int+1;
//			if(dep_level_int > 6)
//				dep_level_int = 6;
		}
		
		int pageSize = pageRequest.getPageSize();
		int pageNumber = pageRequest.getPageNumber();
		
		String sql="{call pr_feijiuwupin_sta('"+s_deptseq+"','"+bDate+"','"+eDate+"','"+dep_level_int+"',?)}";
		List list=(List)vfeijiuwupinStaManager.getXML(sql);
		
		
		if(request.getParameter("tx")!=null&&!request.getParameter("tx").equals("")){
			request.setAttribute("tx", request.getParameter("tx"));
			int pagNumber=request.getParameter("pagenamber")!=null?(Integer.valueOf(request.getParameter("pagenamber"))):0;
			if(list.size()>20)request.setAttribute("scro", "scro");
			request.setAttribute("strXML", getXml(list,pagNumber));
			request.setAttribute("pagenamber",pagNumber);
			return TXLIST_JSP;
		}
		

		Page page=new Page(pageNumber, pageSize, list.size());
		page.setResult(list);
		savePage(page,pageRequest);
		return LIST_JSP;
	}

	public String getXml(List list,int pageNumber){
		StringBuffer strXML=new StringBuffer();
		if(!list.isEmpty()&&list.size()>0){
			strXML.append("<graph caption='废旧物品出售信息统计' showNames='1' baseFontSize='12' showAlternateHGridColor='true' xAxisName='所属单位' yAxisName='斤数' numberSuffix='公斤' >"); 
			//String[] s=new String[]{"AFD8F8","F6BD0F","8BBA00","FF0099","0099FF"};
			
			int i=0;
			for(;i<list.size();i++){
				Map map=(Map)list.get(i);
				strXML.append("<set name='");
				strXML.append(map.get("deptname"));
				strXML.append("' value='");
				strXML.append(map.get("sumzl"));
//				strXML.append("' color='");
				
//				if(h>=5){
//					h=0;
//				}
//				strXML.append(s[h]);
//				h++;
				strXML.append("'/>");
			}
			
			strXML.append("</graph>");
		}


		return strXML.toString();
	}

	public void setVemployeeStaManager(VemployeeStaManager vemployeeStaManager) {
		this.vemployeeStaManager = vemployeeStaManager;
	}

}
