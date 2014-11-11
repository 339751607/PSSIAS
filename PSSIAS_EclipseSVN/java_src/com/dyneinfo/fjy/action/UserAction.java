package com.dyneinfo.fjy.action;
///*
// * Powered By [lishicheng]
// */
//
//package com.dyneinfo.fjy.action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import cn.org.rapid_framework.beanutils.BeanUtils;
//import com.opensymphony.xwork2.Preparable;
//import com.opensymphony.xwork2.ModelDriven;
//import org.apache.struts2.ServletActionContext;
//
//import org.security.userdetails.MyUserDetails;
//import org.springframework.security.Authentication;
//import org.springframework.security.context.SecurityContext;
//import org.springframework.security.context.SecurityContextHolder;
//
//import net.java.dev.common.util.DateUtil;
//import net.java.dev.common.util.SpringTagFunctions;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import javacommon.base.*;
//import javacommon.util.*;
//
//import cn.org.rapid_framework.util.*;
//import cn.org.rapid_framework.web.util.*;
//import cn.org.rapid_framework.page.*;
//import cn.org.rapid_framework.page.impl.*;
//
//import com.dyneinfo.fjy.model.*;
//import com.dyneinfo.fjy.dao.*;
//import com.dyneinfo.fjy.service.*;
//
///**
// * @author lisc email:lishicheng(a)gmail.com
// */
//
//
//public class UserAction extends BaseStruts2Action implements Preparable,ModelDriven{
//	//默认多列排序,example: username desc,createTime asc
//	protected static final String DEFAULT_SORT_COLUMNS = null; 
//	
//	//forward paths
//	protected static final String QUERY_JSP = "/pages/fjy/User/query.jsp";
//	protected static final String LIST_JSP= "/pages/fjy/User/list.jsp";
//	protected static final String CREATE_JSP = "/pages/fjy/User/create.jsp";
//	protected static final String EDIT_JSP = "/pages/fjy/User/edit.jsp";
//	protected static final String SHOW_JSP = "/pages/fjy/User/show.jsp";
//	//redirect paths,startWith: !
//	protected static final String LIST_ACTION = "!/pages/fjy/User/list.do";
//	
//	private UserManager userManager;
//	private SsUserManager ssUserManager;
//	
//	private User user;
//	Long id = null;
//	private String[] items;
//	private String returnUrl;  //返回列表，保留查询条件
//	private TreeMap<String, String> dateSelectMap;// //日期选择
//	
//	
//	private List <SsRole> rolemap;//存所有的选项 
//	private List  selectList = new ArrayList();  //存已选中的选项 
//	private String saveroleselected; //存更新后选中的选项（保存时调用） 
//
//	public void prepare() throws Exception {
//		if (isNullOrEmptyString(id)) {
//			user = new User();
//		} else {
//			user = (User)userManager.getById(id);
//		}
//	}
//	
//	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
//	public void setUserManager(UserManager manager) {
//		this.userManager = manager;
//	}	
//	
//	public void setSsUserManager(SsUserManager manager) {
//		this.ssUserManager = manager;
//	}	
//	
//	public Object getModel() {
//		return user;
//	}
//	
//	public void setUserid(Long val) {
//		this.id = val;
//	}
//
//	public void setItems(String[] items) {
//		this.items = items;
//	}
//	
//	public String getReturnUrl() {
//		return returnUrl;
//	}
//
//	public void setReturnUrl(String returnUrl) {
//		this.returnUrl = returnUrl;
//	}
//	public TreeMap<String, String> getDateSelectMap() {
//		return dateSelectMap;
//	}
//
//	public void setDateSelectMap(TreeMap<String, String> dateSelectMap) {
//		this.dateSelectMap = dateSelectMap;
//	}
//	
//	public List<SsRole> getRolemap() {
//		return rolemap;
//	}
//
//	public void setRolemap(List<SsRole> rolemap) {
//		this.rolemap = rolemap;
//	}
//
//	public List getSelectList() {
//		return selectList;
//	}
//
//	public void setSelectList(List selectList) {
//		this.selectList = selectList;
//	}
//
//	/** 进入查询页面 */
//	public String query() {
//		//日历快速选择用到
//		dateSelectMap  = DateUtil.getDateSelectData();
////		HttpServletRequest request = ServletActionContext.getRequest();
////		request.setAttribute("dateSelect","11");//选中本周
////		DateUtil tt = new DateUtil();     
////      pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
////      pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
//		return QUERY_JSP;
//	}
//	
//	/** 执行搜索 */
//	public String list() {
//		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
//		HttpServletRequest request = ServletActionContext.getRequest();
//		//pageRequest.getFilters().put("key",value);     //add custom filter
//		
//		String username = "";
//		String deptid = "00000000";
//		MyUserDetails userDetail = null;
//		userDetail = SpringTagFunctions.getUserDetails();
//		if (userDetail != null) {
//			username = userDetail.getUserName();
//			deptid = userDetail.getDeptID();
//		}
//		
//		if(!SpringTagFunctions.ifAnyGranted("ROLE_QUERY_ALL,ROLE_ADMIN")){
//			pageRequest.getFilters().put("deptid",deptid);
//			pageRequest.getFilters().put("deptLength",deptid.length());
//		}	
//		dateSelectMap  = DateUtil.getDateSelectData();
//		String dateSelect12 = "";
//		if (request.getParameter("dateSelect12") != null)
//		    dateSelect12 = request.getParameter("dateSelect12");
//			request.setAttribute("dateSelect12",dateSelect12);		        
//		
//		Page page = userManager.findByPageRequest(pageRequest);
//		savePage(page,pageRequest);
//		return LIST_JSP;
//	}
//	
//	/** 查看对象*/
//	public String show() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		return SHOW_JSP;
//	}
//	
//	/** 进入新增页面*/
//	public String create() {
//		 HttpServletRequest request = ServletActionContext.getRequest();
//		String session_deptid = "";
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Authentication auth = sc.getAuthentication();
//		MyUserDetails ud = null;
//		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
//			ud = (MyUserDetails) auth.getPrincipal();
//			if (ud != null) {
//				session_deptid = ud.getDeptID();
//			}
//		}
//		
//		String userid = "";
//		if (request.getParameter("userid") != null)
//			userid = request.getParameter("userid");
//		
//		if (userid != null && userid.length() > 0) {
//			 rolemap = ssUserManager.findUserNoExistRole(session_deptid,Long.parseLong(userid));
//			
//		} else {
//			 rolemap = ssUserManager.findDeptRole(session_deptid);
//		}
//		
//		 
//		return CREATE_JSP;
//	}
//	
//	/** 保存新增对象 */
//	public String save() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String session_deptid = "";
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Authentication auth = sc.getAuthentication();
//		MyUserDetails ud = null;
//		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
//			ud = (MyUserDetails) auth.getPrincipal();
//			if (ud != null) {
//				session_deptid = ud.getDeptID();
//			}
//		}
//
//		int usernameCount = ssUserManager.getCountUserName(user.getUsername());
//		if (usernameCount < 1) {
//			user.setDeptid(Long.parseLong(session_deptid));
//			Date date = new Date();
//			SimpleDateFormat format_shougourq = new SimpleDateFormat(
//					"yyyy-MM-dd HH:mm:ss");
//			String currDate = format_shougourq.format(date);
//			user.setCreatedateString(currDate);
//			userManager.save(user);
//
//			String[] selectRoles = request.getParameterValues("roles");// 选中角色
//			String InIds = "";
//			if (selectRoles != null) {
//				for (int i = 0; i < selectRoles.length; i++) {
//					String roleids = selectRoles[i];
//					InIds += roleids + ",";
//				}
//				if (InIds != null && InIds.length() > 0) {
//					InIds = InIds.substring(0, InIds.length() - 1);
//
//					List<SsRole> rolelist = ssUserManager
//							.findEnterpriseUserNoExistRole(session_deptid,InIds);
//					Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
//					for (SsRole role : roles) {
//						ssUserManager.insertRoleUser(role.getRoleid(), user.getUserid());
//					}
//				}
//			}
//		} else {
//			request.setAttribute("message", "用户名已存在！");
//			rolemap = ssUserManager.findDeptRole(session_deptid);
//			return CREATE_JSP;
//		}
//		return returnUrl;
//	}
//	
//	/**进入更新页面*/
//	public String edit() {
//		 HttpServletRequest request = ServletActionContext.getRequest();
//			String session_deptid = "";
//			SecurityContext sc = SecurityContextHolder.getContext();
//			Authentication auth = sc.getAuthentication();
//			MyUserDetails ud = null;
//			if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
//				ud = (MyUserDetails) auth.getPrincipal();
//				if (ud != null) {
//					session_deptid = ud.getDeptID();
//				}
//			}
//		
//		//所有旅馆角色
//		 rolemap = ssUserManager.findDeptRole(session_deptid);
//
//		
//		//已有角色
//     
//		List<SsRole>  rolelist = ssUserManager.findUserRole(user.getUserid());
//		if(rolelist != null) {
//			Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
//			for (SsRole role : roles) {
//				selectList.add(role.getRoleid());
//			}
//		}
//		
//		return EDIT_JSP;
//	}
//	
//	/**保存更新对象*/
//	public String update() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		
//		String username = "";
//		String session_deptid = "";
//		MyUserDetails userDetail = null;
//		userDetail = SpringTagFunctions.getUserDetails();
//		if (userDetail != null) {
//			username = userDetail.getUserName();
//			session_deptid = userDetail.getDeptID();
//		}
//		
//		
//		
//		userManager.update(this.user);
//		
//		
//		String[] selectRoles = request.getParameterValues("roles");// 选中角色
//		String InIds = "";
//		if (selectRoles != null) {
//			ssUserManager.removeroleUser(user.getUserid());
//			for (int i = 0; i < selectRoles.length; i++) {
//				String roleids = selectRoles[i];
//				InIds += roleids + ",";
//			}
//			if (InIds != null && InIds.length() > 0) {
//				InIds = InIds.substring(0, InIds.length() - 1);
//				List<SsRole> rolelist = ssUserManager
//						.findEnterpriseUserNoExistRole(session_deptid,InIds);
//				Set<SsRole> roles = new LinkedHashSet<SsRole>(rolelist);
//				for (SsRole role : roles) {
//					ssUserManager.insertRoleUser(role.getRoleid(), user.getUserid());
//				}
//			}
//		}
//		
//		return returnUrl;////LIST_ACTION;
//	}
//	
//	/**删除对象*/
//	public String delete() {
//		for(int i = 0; i < items.length; i++) {
//			Hashtable params = HttpUtils.parseQueryString(items[i]);
//			Long id = new Long((String)params.get("userid"));
//			userManager.removeById(id);
//		}
//		return returnUrl ;//LIST_ACTION;
//	}
//
//}
