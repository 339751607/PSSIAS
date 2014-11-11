/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import net.java.dev.common.util.DateUtil;
import org.apache.struts2.ServletActionContext;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */


public class TbkCarAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/zazh/TbkCar/query.jsp";
	protected static final String LIST_JSP= "/pages/zazh/TbkCar/list.jsp";
	protected static final String CREATE_JSP = "/pages/zazh/TbkCar/create.jsp";
	protected static final String EDIT_JSP = "/pages/zazh/TbkCar/edit.jsp";
	protected static final String SHOW_JSP = "/pages/zazh/TbkCar/show.jsp";
	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/zazh/TbkCar/list.do";
	protected static final String CANCEL_JSP = "/pages/zazh/TbkCar/cancel.jsp";
	
	private TbkCarManager tbkCarManager;
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	private long FilemaxSize = 1 * 1024 * 1024; //照片字节
	
	private TbkCar tbkCar;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl;  //返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tbkCar = new TbkCar();
		} else {
			tbkCar = (TbkCar)tbkCarManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setTbkCarManager(TbkCarManager manager) {
		this.tbkCarManager = manager;
	}	
	
	public Object getModel() {
		return tbkCar;
	}
	
	public void setId(java.lang.String val) {
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
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				deptid = ud.getDeptID();
			}
		}	
		dateSelectMap  = DateUtil.getDateSelectData();
		//限定获取数据的范围		
		pageRequest.getFilters().put("deptseq", deptid);
		
		Page page = tbkCarManager.findByPageRequest(pageRequest);
		savePage(page,pageRequest);
		return LIST_JSP;
	}
	
	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		tbkCar.setBksj(DateUtil.parseString(tbkCar.getBksj(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		tbkCar.setCanceltime(DateUtil.parseString(tbkCar.getCanceltime(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm"));
		
        int idCount = tbkCarManager.getPicIDIsExist(tbkCar.getId());		
		if (idCount > 0){
			request.setAttribute("picCount", "1");
		}
		
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		String deptname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}	
		request.setAttribute("userxm", userxm);
		request.setAttribute("deptname", deptname);
		this.tbkCar.setBkdw(deptid);
		
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();				
			}
		}
		//构建ID  12位布控单位代码+9位流水号
		long seq = tbkCarManager.getSeq().longValue();
		String strSeq = "000000000" + seq;
		strSeq = strSeq.substring(strSeq.length()-9);
		
		String id = deptid + strSeq;
		tbkCar.setId(id);

		tbkCar.setCarcode(tbkCar.getPrefix()+tbkCar.getCarcode());
		
		tbkCar.setBkdw(deptid);
		tbkCar.setOperator(userxm);
		tbkCar.setBksj(DateUtil.getNowTime("yyyyMMddHHmm"));
		tbkCar.setCancelflag("0");
		if (file != null){
			try {				 
				if ( file.length() < FilemaxSize) {
					if (id != null && id.length() > 0) {
						
						int idCount = tbkCarManager.getPicIDIsExist(id);
						
						if (idCount > 0)						
							tbkCarManager.updatePicSingle(file, id);						
						else
							tbkCarManager.savePicSingle(file, id);
						
					}
					String message = "车辆布控成功！";
					tbkCarManager.save(tbkCar);
					request.setAttribute("message",message);
					
				} else {
					request.setAttribute("message", "上传照片不能大于1M!");
					return CREATE_JSP;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "上传照片保存失败，车辆布控新增失败!");
				return CREATE_JSP;
			}
		}else{
			tbkCarManager.update(this.tbkCar);
		}
		return returnUrl;////LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		String deptname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}	
		request.setAttribute("userxm", userxm);
		request.setAttribute("deptname", deptname);
		
		String carcode = tbkCar.getCarcode();
		if(carcode !=null && !"".equals(carcode)){
			String prefix = carcode.substring(0,1);
			tbkCar.setPrefix(prefix);
			tbkCar.setCarcode(carcode.substring(1));
		}
		
        int idCount = tbkCarManager.getPicIDIsExist(tbkCar.getId());		
		if (idCount > 0){
			request.setAttribute("picCount", "1");
		}
		
		return EDIT_JSP;
	}
	// 显示图片
	public String showPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bkid = "";
		
		if (request.getParameter("bkid") != null)
			bkid = request.getParameter("bkid");
		
		List list = (List) tbkCarManager.getPic(bkid);
		request.setAttribute("list", list);
		
		return SHOW_PIC;
	}
	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();					
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();				
			}
		}
	
		tbkCar.setBkdw(deptid);
		tbkCar.setOperator(username); 
			
		tbkCar.setCarcode(tbkCar.getPrefix() + tbkCar.getCarcode());
		if (file != null){
			try {
				if (file != null && file.length() < FilemaxSize) {
					if (id != null && id.length() > 0) {
						
						int idCount = tbkCarManager.getPicIDIsExist(id);
						
						if (idCount > 0)						
							tbkCarManager.updatePicSingle(file, id);						
						else
							tbkCarManager.savePicSingle(file, id);
						
					}
					String message = "人员布控成功！";
					tbkCarManager.update(this.tbkCar);
					request.setAttribute("message",message);
					
				} else {
					request.setAttribute("message", "上传照片不能大于1M!");
					return EDIT_JSP;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", "上传照片保存失败，人员布控修改失败!");
				return EDIT_JSP;
			}
		}else{
			tbkCarManager.update(this.tbkCar);
		}
		
		return returnUrl;////LIST_ACTION;
	}
	public String cancel() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();					
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();				
			}
		}	

		tbkCar.setCancelname(userxm); 
		
        request.setAttribute("nowtime", DateUtil.getNowTime("yyyy-MM-dd HH:mm:ss"));
		return CANCEL_JSP;
	}
	
	/**保存更新对象*/
	public String saveCancel() {
		
		HttpServletRequest request = ServletActionContext.getRequest();		

		SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String userxm = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUsername();					
				userxm = ud.getUserXm();
				deptid = ud.getDeptID();				
			}
		}	

		tbkCar.setCancelname(userxm); 
		tbkCar.setCanceltime(DateUtil.getNowTime("yyyyMMddHHmm"));
		
		tbkCarManager.update(this.tbkCar);
		return returnUrl;////LIST_ACTION;
	}	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String)params.get("id"));
			tbkCarManager.removeById(id);
		}
		return returnUrl ;//LIST_ACTION;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
