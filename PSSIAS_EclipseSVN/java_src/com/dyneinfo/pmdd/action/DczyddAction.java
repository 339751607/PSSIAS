/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import net.java.dev.common.dict.ISelectOption;
import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.IDCard;
import net.java.dev.common.util.SpringTagFunctions;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;
import com.dyneinfo.pmdd.model.FileAttach;
import com.dyneinfo.pmdd.model.Dczydd;
import com.dyneinfo.pmdd.model.Pmdwxxb;
import com.dyneinfo.pmdd.service.DczyddManager;
import com.dyneinfo.pmdd.service.FileAttachPmddManager;
import com.dyneinfo.pmdd.service.PmdwxxbManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.commons.lang.StringUtils;
/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class DczyddAction extends BaseStruts2Action implements Preparable,
		ModelDriven {
	// 默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	// forward paths
	protected static final String QUERY_JSP = "/pages/pmdd/Dczydd/query.jsp";
	protected static final String LIST_JSP = "/pages/pmdd/Dczydd/list.jsp";
	protected static final String CREATE_JSP = "/pages/pmdd/Dczydd/create.jsp";
	protected static final String EDIT_JSP = "/pages/pmdd/Dczydd/edit.jsp";
	protected static final String SHOW_JSP = "/pages/pmdd/Dczydd/show.jsp";

	// redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/pmdd/Dczydd/list.do";

	protected static final String SHOW_PIC = "/pages/pic/pic.jsp";
	protected static final String UPDATEPHOTOSUCCESS = "/pages/pic/uploadFileSuccess.jsp";
	protected static final String UPDATEPHOTOFAILURE = "/pages/pic/uploadFileFailure.jsp";
	protected static final String UPDATEPHOTOERROR = "/pages/pic/updateFileError.jsp";

	protected static final String REDEEMLIST_ACTION = "!/pages/pmdd/Dczydd/redeemList.do";
	protected static final String REDEEMLIST_JSP = "/pages/pmdd/Dczydd/redeemList.jsp";
	protected static final String REDEEMEDIT_JSP = "/pages/pmdd/Dczydd/redeemedit.jsp";
	protected static final String REDEEM_SHOW_JSP="/pages/pmdd/Dczydd/redeemshow.jsp";

	// 后台查询
	protected static final String HTCXLIST_ACTION = "!/pages/pmdd/Dczydd/htcxList.do";
	protected static final String HTCXLIST_JSP = "/pages/pmdd/Dczydd/htcxList.jsp";
	protected static final String HTCXSHOW_JSP = "/pages/pmdd/Dczydd/htcxShow.jsp";
	
	
	//总合
	protected static final String ZHDCSHOW_JSP = "/pages/pmdd/Dczydd/zhdcshow.jsp";



	private String[][] ssfj;

	private DczyddManager dczyddManager;
	private FileAttachPmddManager fileAttachManager;
	private FileAttach fileAttach;
	private PmdwxxbManager pmdwxxbManager;

	private Dczydd dczydd;
	java.lang.String id = null;
	private String[] items;
	private String returnUrl; // 返回列表，保留查询条件
	private TreeMap<String, String> dateSelectMap;// //日期选择

	// 照片上传 start
	private List<File> upload = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();

	// 照片上传 end

	// 附件
	private List<File> affix = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();
	
	//身份证扫描
	private List<File> pic = new ArrayList<File>();
	private List<String> picFileNames = new ArrayList<String>();
	private List<String> picContentTypes = new ArrayList<String>();
	
	private long uplodsSize = 100 * 1024;
	private int affixsSize = 10 * 1024 * 1024;
	
	public String lrrq ="";
	public String ddrq ="";
	public String ddlx="";
	public String sex = "";
	public String hjd = "";

	// 附件 end

	public void prepare() throws Exception {
		
		if (isNullOrEmptyString(id)) {
			dczydd = new Dczydd();
		} else {
			dczydd = (Dczydd) dczyddManager.getById(id);
		}
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	
	public List<File> getUploads() {
		return upload;
	}

	public FileAttachPmddManager getFileAttachPmddManager() {
		return fileAttachManager;
	}

	public void setFileAttachPmddManager(FileAttachPmddManager fileAttachManager) {
		this.fileAttachManager = fileAttachManager;
	}

	public FileAttach getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(FileAttach fileAttach) {
		this.fileAttach = fileAttach;
	}

	public void setUploads(List<File> uploads) {
		this.upload = uploads;
	}

	public List<File> getAffixs() {
		return affix;
	}

	public void setAffixs(List<File> affixs) {
		this.affix = affixs;
	}

	public List<File> getPics() {
		return pic;
	}

	public void setPics(List<File> pics) {
		this.pic = pics;
	}
	public void setDczyddManager(DczyddManager manager) {
		this.dczyddManager = manager;
	}

	public void setPmdwxxbManager(PmdwxxbManager manager) {
		this.pmdwxxbManager = manager;
	}	

	public Object getModel() {
		return dczydd;
	}

	public void setDnumber(java.lang.String val) {
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
		// 日历快速选择用到
		dateSelectMap = DateUtil.getDateSelectData();
		// HttpServletRequest request = ServletActionContext.getRequest();
		// request.setAttribute("dateSelect","11");//选中本周
		// DateUtil tt = new DateUtil();
		// pageRequest.getFilters().put("s_inTime_start",tt.getMondayOFWeek());//页面
		// pageRequest.getFilters().put("s_inTime_end",tt.getCurrentWeekday());//
		return QUERY_JSP;
	}

	/** 执行搜索 */
	public String list() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		// pageRequest.getFilters().put("key",value); //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("deptid", deptid);
			pageRequest.getFilters().put("deptLength", deptid.length());
		}
		if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("chdeptid", deptid);
			pageRequest.getFilters().put("chdeptLength", deptid.length());
		}
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect13 = "";
		if (request.getParameter("dateSelect13") != null)
			dateSelect13 = request.getParameter("dateSelect13");
		request.setAttribute("dateSelect13", dateSelect13);
		String s_ddrqBeginFormat = DateUtil.parseString(request, "s_ddrqBegin",
				"yyyy-MM-dd", "yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request, "s_ddrqEnd",
				"yyyy-MM-dd", "yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat", s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat", s_ddrqEndFormat+"235959");
		String query = request.getParameter("query");
		Page page = dczyddManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		if (query != null && query.equals("true")) {
			return QUERY_JSP;
		}
		return LIST_JSP;
	}

	/** 查看对象 */
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}
		Pmdwxxb	pmdwxxb = null;
		String qylxdh = "";
		String dwdz = "";
		String TXXKZH = "";
	    int count = 	pmdwxxbManager.getFindCountById(deptid);  
	    //System.out.println("111111111111111111="+count);
	    if(count == 1)
			 pmdwxxb = (Pmdwxxb)pmdwxxbManager.getPmdwxxbById(deptid);
	    
	    if(pmdwxxb != null){
	    	qylxdh = pmdwxxb.getLxdh();
	    	dwdz = pmdwxxb.getDwdz();
	    	TXXKZH = pmdwxxb.getTxxkzh();
	    	deptname= pmdwxxb.getDwmc();
	    }
		
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		
		
		String  dnumber="",dwmc = "", htid = "", sqr = "", sex = "", hjd = "",dwzj="",yxzj="",zjhm="";
		String dz="",lxdh="",bsm="",ddlx="",pp="",gg="",zl="",wpxz="",wplyqksm="",wpcqzmcl="",sdr="";
		
		
		String sexName = "";
		String hjdName = "";
		String ddlxName = "";
		String yxzjName = "";
		
	
	
		
		
		if(dczydd != null){
			dnumber = dczydd.getDnumber();
			dwmc = dczydd.getDwmc();
			htid = dczydd.getHtid();
			sqr = dczydd.getSqr();
			sex = "9";
			hjd = "";
			dwzj = dczydd.getDwzj();// 当物证件
			yxzj = dczydd.getYxzj();
			zjhm = dczydd.getZjhm();
			
			if(zjhm != null && zjhm.length() > 17){
			    String zjhm14 = zjhm.substring(16, 17);
			
			if(Integer.parseInt(zjhm14)%2==0)
				sex = "2";
			else
				sex = "1";
			
			
			
			hjd= zjhm.substring(0,6);
			}
			dz = dczydd.getDz();
			lxdh = dczydd.getLxdh();
			//bsm = "";
			ddlx = dczydd.getDdlx();
			pp = dczydd.getWppp();
			gg = dczydd.getWpgg();
			zl = dczydd.getWpzl();
			wpxz = dczydd.getWpxz();
			wplyqksm = dczydd.getWplyqksm();
			wpcqzmcl = dczydd.getWpcqzmcl();
			sdr = dczydd.getSdr();
			
		
			
			
			List datas = DictHelpImpl.getDict("gender");
			if(sex != null && sex.length() > 0){
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(sex))
					sexName = bean.getName();

			}}
			
			
			if(hjd != null && hjd.length() > 0){
				 datas = DictHelpImpl.getDict("xzqh");
				for (int i = 0; i < datas.size(); i++) {
					ISelectOption bean = (ISelectOption) datas.get(i);
					if (bean.getValue() != null && bean.getValue().equals(hjd))
						hjdName = bean.getName();

				}
				}
			
			
			if(yxzj != null && yxzj.length() > 0){
			 datas = DictHelpImpl.getDict("T_ID_NAME");
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(yxzj))
					yxzjName = bean.getName();

			}
			}
			
			
			 datas = DictHelpImpl.getDict("ddlb");
			for (int i = 0; i < datas.size(); i++) {
				ISelectOption bean = (ISelectOption) datas.get(i);
				if (bean.getValue() != null && bean.getValue().equals(ddlx))
					ddlxName = bean.getName();

			}
			
		}
		
		request.setAttribute("sexName", sexName);
		request.setAttribute("hjdName", hjdName);
		request.setAttribute("ddlxName", ddlxName);
		request.setAttribute("yxzjName", yxzjName);
		request.setAttribute("dwmc", dwmc);
		request.setAttribute("htid", htid);
		request.setAttribute("sqr", sqr);
		request.setAttribute("dwzj", dwzj);
		request.setAttribute("zjhm", zjhm);
		request.setAttribute("dz", dz);
		request.setAttribute("lxdh", lxdh);
		request.setAttribute("bsm", bsm);
		request.setAttribute("pp", pp);
		request.setAttribute("gg", gg);
		request.setAttribute("zl", zl);
		request.setAttribute("wpxz", wpxz);
		request.setAttribute("wplyqksm", wplyqksm);
		request.setAttribute("wpcqzmcl", wpcqzmcl);
		request.setAttribute("dnumber", dnumber);
		request.setAttribute("ddrqFormat", ddrqFormat);
		request.setAttribute("sdr", sdr);
		request.setAttribute("deptname", deptname);
		
		request.setAttribute("qylxdh", qylxdh);
		request.setAttribute("dwdz", dwdz);
		request.setAttribute("TXXKZH", TXXKZH);
		
		//System.out.println(ddrqFormat+"------------------------------");
		
		
		
		
		return SHOW_JSP;
	}

	/** 进入新增页面 */
	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		String deptname = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
				deptname = ud.getDeptName();
			}
		}
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String currDate1 = format1.format(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format.format(date);
		String smycode = pmdwxxbManager.getsmycode(deptid);
		String typecode = pmdwxxbManager.gettypecode(deptid);
		request.setAttribute("smycode", smycode);
		request.setAttribute("typecode", typecode);
		dczydd.setLrrq(currDate1);
		dczydd.setDdrq(currDate);
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
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}
		dczydd.setSfsh("0");

		String new_IDCard = "";
		String old_IDCard = "";
		if (dczydd != null && dczydd.getZjhm() != null
				&& dczydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(dczydd.getZjhm());
			old_IDCard = dczydd.getZjhm();
		} else if (dczydd != null && dczydd.getZjhm() != null
				&& dczydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(dczydd.getZjhm());
			new_IDCard = dczydd.getZjhm();
		} else {
			new_IDCard = dczydd.getZjhm();
			old_IDCard = dczydd.getZjhm();
		}
		dczydd.setZjhm(new_IDCard.toUpperCase());

		String htid = "";
		if (dczydd != null && dczydd.getHtid() != null)
			htid = dczydd.getHtid();

		int count = dczyddManager.getFindCountById(htid);
		if (count > 0) {
			request.setAttribute("message", "档案编号已存在！");
			return CREATE_JSP;
		}

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoptime = new SimpleDateFormat(
				"yyyyMMddhhmmssSSS");
		String currDate = format.format(date);
		String strOPTIME = formatoptime.format(date);
		dczydd.setOptime(strOPTIME);
		dczydd.setLrrq(currDate);
		String start_char = "", str_emd_char = "";

		Dczydd dczydd2 = (Dczydd) dczyddManager.getMaxID(deptid, currDate);
		String maxID = "";
		start_char = deptid + currDate;
		String max_end_char = "0000";
		if (dczydd2 != null) {
			maxID = dczydd2.getDnumber();

		}
		if (maxID != null && maxID.length() > 0) {
			max_end_char = maxID.substring(start_char.length());
		}
		int i_max_end_char = Integer.parseInt(max_end_char);
		i_max_end_char = i_max_end_char + 1;
		Integer obj = new Integer(i_max_end_char);
		str_emd_char = net.java.dev.common.dict.taglib.Util.padString(obj
				.toString(), 4, "0", true);
		String ddrqFormat = DateUtil.parseString(request, "ddrq", "yyyy-MM-dd HH:mm:ss",
				"yyyyMMddHHmmss");
		dczydd.setDdrq(ddrqFormat);
		dczydd.setSqddje(0L);

		dczydd.setDnumber(start_char + str_emd_char);
		try {
			//判断申请人照片不能大于100KB
			if (upload != null && upload.size() > 0) {
				
				File uploadFile = upload.get(0);
				InputStream uploadIs =new FileInputStream(uploadFile);
				byte[] picBytes= (byte[])IOUtils.toByteArray(uploadIs);
				
				if (picBytes.length > uplodsSize) {
					request.setAttribute("message", "申请人照片不能大于" + uplodsSize
							/ 1024 + "KB");
					return UPDATEPHOTOERROR;
				}
			}
			//判断当物照片不能大于5M
			if (affix != null && affix.size() > 0) {
				if (affix.get(0).length() > affixsSize) {
					request.setAttribute("message", "当物照片不能大于" + affixsSize
							/ 1024 / 1024 + "M");
					return UPDATEPHOTOERROR;
				}
			}
		    
			File uploadFile = null;
			InputStream uploadIs = null;
			byte[] uploadBytes= null;
			if(upload != null && upload.size() > 0 ){
				uploadFile = upload.get(0);
				uploadIs = new FileInputStream(uploadFile);
			    uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
			}
			
			String photoBuffer = "";
			if (request.getParameter("photoBuffer") != null)
				photoBuffer = request.getParameter("photoBuffer");
			if (StringUtils.isNotEmpty(photoBuffer)) {
				 uploadBytes = (byte[])net.java.dev.common.util.PicDecode.decode(photoBuffer);
			}
			//当物照片
			File affixFile = null;
			InputStream affixIs = null;
			byte[] affixBytes= null;
			if(affix != null && affix.size() > 0 ){
				affixFile = affix.get(0);
				affixIs = new FileInputStream(affixFile);
				affixBytes =  (byte[])IOUtils.toByteArray(affixIs);
				
			}
			
			String affixfileid = "";
			if (request.getParameter("affixfileid") != null)
				affixfileid = request.getParameter("affixfileid");
			if (StringUtils.isNotEmpty(affixfileid)) {
				List list = (List) fileAttachManager.getFileContent(affixfileid, " and 1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						affixBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			//申请人扫描照片
			File picFile = null;
			InputStream picIs = null;
			byte[] picBytes= null;
			if(pic != null && pic.size() > 0 ){
				picFile = pic.get(0);
				picIs = new FileInputStream(picFile);
				picBytes =  (byte[])IOUtils.toByteArray(picIs);	
			}
			
			String picfileid = "";
			if (request.getParameter("picfileid") != null)
				picfileid = request.getParameter("picfileid");
			if (StringUtils.isNotEmpty(picfileid)) {
				List list = (List) fileAttachManager.getFileContent(picfileid, " and  1=1 ");
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						Map results = (HashMap) list.get(i);
						 picBytes = (byte[]) results.get("CONTENT");
					}
				}
			}
			
			//if (uploadBytes != null  && affixBytes != null && picBytes != null) {
				dczyddManager.savePic(uploadBytes, affixBytes,picBytes, dczydd);
			//} 
			if(picIs != null)
				picIs.close();
			if(uploadIs != null)
				uploadIs.close();
			if(affixIs != null)
				affixIs.close();
			

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		show();
		return SHOW_JSP;// //LIST_ACTION;
	}

	/** 进入更新页面 */
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil
				.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		return EDIT_JSP;
	}

	/** 保存更新对象 */
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrqFormat = DateUtil.parseString(request, "ddrq", "yyyy-MM-dd HH:mm:ss",
				"yyyyMMddHHmmss");
		dczydd.setDdrq(ddrqFormat);
		String lrrqFormat = DateUtil.parseString(request, "lrrq", "yyyy-MM-dd",
				"yyyyMMdd");
		dczydd.setLrrq(lrrqFormat);

		String new_IDCard = "";
		String old_IDCard = "";
		if (dczydd != null && dczydd.getZjhm() != null
				&& dczydd.getZjhm().length() == 15) {
			new_IDCard = IDCard.getNewIDCard(dczydd.getZjhm());
			old_IDCard = dczydd.getZjhm();
		} else if (dczydd != null && dczydd.getZjhm() != null
				&& dczydd.getZjhm().length() == 18) {
			old_IDCard = IDCard.getOldIDCard(dczydd.getZjhm());
			new_IDCard = dczydd.getZjhm();
		} else {
			new_IDCard = dczydd.getZjhm();
			old_IDCard = dczydd.getZjhm();
		}
		dczydd.setZjhm(new_IDCard.toUpperCase());

		dczyddManager.update(this.dczydd);
		return returnUrl;// //LIST_ACTION;
	}

	/** 删除对象 */
	public String delete() {
		for (int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.String id = new java.lang.String((String) params
					.get("dnumber"));
			dczyddManager.removeById(id);
		}
		return returnUrl;// LIST_ACTION;
	}

	// 显示图片
	public String showPicry() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) dczyddManager.getDDRYZP(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}

		request.setAttribute("list", list);
		return SHOW_PIC;

	}

	public String showPicrysm() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) dczyddManager.getDDRYSMZP(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}

		request.setAttribute("list", list);
		return SHOW_PIC;

	}
	
	
	public String showPicdw() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String xh = "";
		String FlAG = "";
		if (request.getParameter("xh") != null)
			xh = request.getParameter("xh");
		List list = (List) dczyddManager.getDWZP(xh);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				FlAG = (String) results.get("FlAG");
			}
		}

		request.setAttribute("list", list);
		return SHOW_PIC;

	}

	public String picEdit() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String dnumber = "";
		if (request.getParameter("dnumber") != null)
			dnumber = request.getParameter("dnumber");
		
		
		//当物照片
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		if(upload != null && upload.size() > 0 ){
			uploadFile = upload.get(0);
			uploadIs = new FileInputStream(uploadFile);
			uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
			
		}
		
		String uploadfileid = "";
		if (request.getParameter("uploadfileid") != null)
			uploadfileid = request.getParameter("uploadfileid");
		if (StringUtils.isNotEmpty(uploadfileid)) {
			List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map results = (HashMap) list.get(i);
					uploadBytes = (byte[]) results.get("CONTENT");
				}
			}
		}
		dczyddManager.updateRyPic(uploadBytes, dnumber);
		if(uploadIs != null)
			uploadIs.close();

//		int i = 0;
//		for (File u : uploads) {
//			Integer obj = new Integer(i);
//			String str_ojb = obj.toString();
//			if(u.length( )> uplodsSize){
//				request.setAttribute("message", "申请人照片不能大于"+uplodsSize/1024+"KB"); 
//				return	UPDATEPHOTOFAILURE ;
//			}
//			dczyddManager.updateRyPic(u, dnumber);
//			i++;
//		}
		return UPDATEPHOTOSUCCESS;
	}
	
	
	public String picEditSm() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String dnumber = "";
		if (request.getParameter("dnumber") != null)
			dnumber = request.getParameter("dnumber");
		
		
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		if(upload != null && upload.size() > 0 ){
			uploadFile = upload.get(0);
			uploadIs = new FileInputStream(uploadFile);
			uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
			
		}
		
		String uploadfileid = "";
		if (request.getParameter("uploadfileid") != null)
			uploadfileid = request.getParameter("uploadfileid");
		if (StringUtils.isNotEmpty(uploadfileid)) {
			List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map results = (HashMap) list.get(i);
					uploadBytes = (byte[]) results.get("CONTENT");
				}
			}
		}
	
		dczyddManager.updateRyPicSm(uploadBytes, dnumber);
		if(uploadIs != null)
			uploadIs.close();
//		int i = 0;
//		for (File u : uploads) {
//			Integer obj = new Integer(i);
//			String str_ojb = obj.toString();
//			if(u.length( )> uplodsSize){
//				request.setAttribute("message", "申请人照片不能大于"+uplodsSize/1024+"KB"); 
//				return	UPDATEPHOTOFAILURE ;
//			}
//			dczyddManager.updateRyPicSm(u, dnumber);
//			i++;
//		}
		return UPDATEPHOTOSUCCESS;
	}

	public String picEditdw() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = "";
		if (request.getParameter("dnumber") != null)
			dnumber = request.getParameter("dnumber");
		
		
		File uploadFile = null;
		InputStream uploadIs = null;
		byte[] uploadBytes= null;
		if(upload != null && upload.size() > 0 ){
			uploadFile = upload.get(0);
			uploadIs = new FileInputStream(uploadFile);
			uploadBytes =  (byte[])IOUtils.toByteArray(uploadIs);
			
		}
		
		String uploadfileid = "";
		if (request.getParameter("uploadfileid") != null)
			uploadfileid = request.getParameter("uploadfileid");
		if (StringUtils.isNotEmpty(uploadfileid)) {
			List list = (List) fileAttachManager.getFileContent(uploadfileid, " and 1=1 ");
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map results = (HashMap) list.get(i);
					uploadBytes = (byte[]) results.get("CONTENT");
				}
			}
		}
		dczyddManager.updateDwPic(uploadBytes, dnumber);
		if(uploadIs != null)
			uploadIs.close();
//		int i = 0;
//		for (File u : uploads) {
//			Integer obj = new Integer(i);
//			String str_ojb = obj.toString();
//			if(u.length( )> affixsSize){
//				request.setAttribute("message", "当物照片不能大于"+affixsSize/1024/1024+"M"); 
//				return	UPDATEPHOTOFAILURE ;
//			}
//			dczyddManager.updateDwPic(u, dnumber);
//			i++;
//		}
		return UPDATEPHOTOSUCCESS;
	}

	/** 执行搜索 */
	public String redeemList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		// pageRequest.getFilters().put("key",value); //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}
		if (!SpringTagFunctions
				.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("deptid", deptid);
			pageRequest.getFilters().put("deptLength", deptid.length());
		}
		if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("chdeptid", deptid);
			pageRequest.getFilters().put("chdeptLength", deptid.length());
		}
		 pageRequest.getFilters().put("ddlx","2");
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect13 = "";
		if (request.getParameter("dateSelect13") != null)
			dateSelect13 = request.getParameter("dateSelect13");
		request.setAttribute("dateSelect13", dateSelect13);
		String s_ddrqBeginFormat = DateUtil.parseString(request, "s_ddrqBegin",
				"yyyy-MM-dd", "yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request, "s_ddrqEnd",
				"yyyy-MM-dd", "yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat", s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat", s_ddrqEndFormat+"235959");

		Page page = dczyddManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		return REDEEMLIST_JSP;
	}

	/** 进入更新页面 */
	public String redeemEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil.parseString(ddrq,"yyyyMMddHHmmss","yyyy-MM-dd HH:mm:ss");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil
				.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		return REDEEMEDIT_JSP;
	}

	/** 查看赎回信息 */
	public String redeemShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil
				.parseString(ddrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil
				.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		return REDEEM_SHOW_JSP;
	}
	/** 后台查询 */
	public String htcxList() {
		PageRequest<Map> pageRequest = newPageRequest(DEFAULT_SORT_COLUMNS);
		HttpServletRequest request = ServletActionContext.getRequest();
		// pageRequest.getFilters().put("key",value); //add custom filter

		SecurityContext sc = SecurityContextHolder.getContext();
		Authentication auth = sc.getAuthentication();
		MyUserDetails ud = null;
		String username = "";
		String deptid = "";
		if ((auth != null) && auth.getPrincipal() instanceof MyUserDetails) {
			ud = (MyUserDetails) auth.getPrincipal();
			if (ud != null) {
				username = ud.getUserName();
				deptid = ud.getDeptID();
			}
		}
		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN,ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("deptid", deptid);
			pageRequest.getFilters().put("deptLength", deptid.length());
		}
		if (SpringTagFunctions.ifAnyGranted("ROLE_QUERY_CHILD_ORG")) {
			pageRequest.getFilters().put("chdeptid", deptid);
		}
		if(SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN")){
			pageRequest.getFilters().put("chdeptid", deptid);
		}
		// pageRequest.getFilters().put("ddlx","2");
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect13 = "";
		if (request.getParameter("dateSelect13") != null)
			dateSelect13 = request.getParameter("dateSelect13");
		request.setAttribute("dateSelect13", dateSelect13);
		String s_ddrqBeginFormat = DateUtil.parseString(request, "s_ddrqBegin",
				"yyyy-MM-dd", "yyyyMMdd");
		String s_ddrqEndFormat = DateUtil.parseString(request, "s_ddrqEnd",
				"yyyy-MM-dd", "yyyyMMdd");
		pageRequest.getFilters().put("ddrqBeginFormat", s_ddrqBeginFormat+"000000");
		pageRequest.getFilters().put("ddrqEndFormat", s_ddrqEndFormat+"235959");

		Page page = dczyddManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		return HTCXLIST_JSP;
	}

	/** 进入后台查询查看页面 */
	public String zhdcshow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(dczydd==null){
			dczydd = new Dczydd();
		}else{
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil
				.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil
				.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		}
		return ZHDCSHOW_JSP;
	}

	/**查询动产**/
	public String htcxShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(dczydd==null){
			dczydd = new Dczydd();
		}else{
		String ddrq = dczydd.getDdrq();
		String ddrqFormat = DateUtil
				.parseString(ddrq, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		dczydd.setDdrq(ddrqFormat);
		String lrrq = dczydd.getLrrq();
		String lrrqFormat = DateUtil
				.parseString(lrrq, "yyyyMMdd", "yyyy-MM-dd");
		dczydd.setLrrq(lrrqFormat);
		}
		return HTCXSHOW_JSP;
	}
	
	public String[][] getSsfj() {
		return ssfj;
	}

	public void setSsfj(String[][] ssfj) {
		this.ssfj = ssfj;
	}
	public List<String> getUploadFileName() {
		return this.uploadFileNames;
	}

	public void setUploadFileName(List<String> uploadFileNames) {
		this.uploadFileNames = uploadFileNames;
	}

	public List<String> getUploadContentType() {
		return this.uploadContentTypes;
	}

	public void setUploadContentType(List<String> contentTypes) {
		this.uploadContentTypes = contentTypes;
	}



	public List<String> getAffixFileName() {
		return this.affixFileNames;
	}

	public void setAffixFileName(List<String> affixFileNames) {
		this.affixFileNames = affixFileNames;
	}

	public List<String> getAffixContentType() {
		return this.affixContentTypes;
	}

	public void setAffixContentType(List<String> contentTypes) {
		this.affixContentTypes = contentTypes;
	}

	
	public List<String> getPicFileName() {
		return this.picFileNames;
	}

	public void setPicFileName(List<String> picFileNames) {
		this.picFileNames = picFileNames;
	}

	public List<String> getPicContentType() {
		return this.picContentTypes;
	}

	public void setPicContentType(List<String> picContentTypes) {
		this.picContentTypes = picContentTypes;
	}

	

	public String findshow(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String zjhm = request.getParameter("zjhm");
		String dnumber = request.getParameter("dnumber");
		String yxzj = request.getParameter("yxzj");
		int num = this.dczyddManager.getPmdwxxbById(zjhm, dnumber, yxzj).size();
		String jsp = "";
		if( num >0){
			jsp ="!/pages/pmdd/Dczydd/zhdcshow.do?dnumber="+dnumber;
			return jsp;
		}else{
			int a = this.dczyddManager.getfcdyddById(zjhm, dnumber, yxzj).size();
			if(a>0){
				jsp = "!/pages/pmdd/Fcdydd/zhfcshow.do?dnumber="+dnumber;
			}else{
				jsp= "!/pages/pmdd/Clzydd/zhclshow.do?dnumber="+dnumber;
			}
		}
		return jsp;
	}
	
	public String findclddxx(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String dnumber = request.getParameter("dnumber");
		return  "!/pages/pmdd/Clzydd/zhclshow.do?dnumber="+dnumber;
	}
}
