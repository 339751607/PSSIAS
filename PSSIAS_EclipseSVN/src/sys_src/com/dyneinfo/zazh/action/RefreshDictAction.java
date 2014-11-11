package com.dyneinfo.zazh.action;
//package com.dyneinfo.zazh.action;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javacommon.base.BaseStruts2Action;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import net.java.dev.common.dict.taglib.DictHelpImpl;
//
//import org.apache.struts2.ServletActionContext;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import org.security.userdetails.MyUserDetails;
//import org.springframework.security.Authentication;
//import org.springframework.security.context.SecurityContext;
//import org.springframework.security.context.SecurityContextHolder;
//import org.springframework.security.userdetails.UserDetails;
//
//import com.opensymphony.xwork2.Preparable;
//import com.dyneinfo.zazh.dao.SsDictTypeDao;
//import com.dyneinfo.zazh.model.SsDictType;
//
//public class RefreshDictAction extends BaseStruts2Action implements Preparable {
//
//	protected static final String REFRESHDICT_JSP = "/hotel/RefreshDict/refreshDict.jsp";
//
//	public void prepare() throws Exception {
//
//	}
//
//	private SsDictTypeDao ssDictTypeDao;
//
//	public String refresh() {
//
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Authentication auth = sc.getAuthentication();
//		MyUserDetails ud = null;
//
//		String userid = "";
//		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
//			ud = (MyUserDetails) auth.getPrincipal();
//			if (ud != null) {
//				userid = ud.getUsername();
//			}
//		}
//
//		try {
//			ApplicationContext ctx = WebApplicationContextUtils
//					.getWebApplicationContext(ServletActionContext
//							.getServletContext());
//			DictHelpImpl beanRep = (DictHelpImpl) ctx.getBean("DictHelpImpl");
//
//			List catList = ssDictTypeDao.findAll();
//			if (catList != null) {
//				for (int i = 0; i < catList.size(); i++) {
//
//					SsDictType ssDictType = (SsDictType) catList.get(i);
//					if (ssDictType == null) {
//						System.out.println("数据字典类型为空，没有字典项");
//					} else {
//						beanRep.reloadDict(ssDictType);
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return REFRESHDICT_JSP;
//	}
//
//	public SsDictTypeDao getSsDictTypeDao() {
//		return ssDictTypeDao;
//	}
//
//	public void setSsDictTypeDao(SsDictTypeDao ssDictTypeDao) {
//		this.ssDictTypeDao = ssDictTypeDao;
//	}
//
//}