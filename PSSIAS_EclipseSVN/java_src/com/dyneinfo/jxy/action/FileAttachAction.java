/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.action;

import static javacommon.util.extjs.Struts2JsonHelper.configJson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javacommon.base.BaseStruts2Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.SpringTagFunctions;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.security.userdetails.MyUserDetails;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.dyneinfo.zazh.model.FileAttach;
import com.dyneinfo.zazh.service.FileAttachManager;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

public class FileAttachAction extends BaseStruts2Action implements Preparable,
		ModelDriven {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	//forward paths
	protected static final String QUERY_JSP = "/pages/jxy/FileAttach/query.jsp";
	protected static final String LIST_JSP = "/pages/jxy/FileAttach/list.jsp";
	protected static final String CREATE_JSP = "/pages/jxy/FileAttach/create.jsp";
	protected static final String EDIT_JSP = "/pages/jxy/FileAttach/edit.jsp";
	protected static final String SHOW_JSP = "/pages/jxy/FileAttach/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/jxy/FileAttach/list.do";
	protected static final String JSON_JSP = "/commons/jsonStruts.jsp";
	protected static final String SHOW_PIC = "/pages/jxy/FileAttach/showPict.jsp";

	private FileAttachManager fileAttachManager;

	private FileAttach fileAttach;
	Long id = null;
	private String[] items;
	private String returnUrl; //返回列表，保留查询条件 
	private String deleteReturnUrl;
	private TreeMap<String, String> dateSelectMap;// //日期选择

	private static final int BUFFER_SIZE = 16 * 1024;

	//照片上传 start
	private List<File> uploads = new ArrayList<File>();
	private List<String> uploadFileNames = new ArrayList<String>();
	private List<String> uploadContentTypes = new ArrayList<String>();

	public List<File> getUpload() {
		return this.uploads;
	}

	public void setUpload(List<File> uploads) {
		this.uploads = uploads;
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

	//照片上传 end

	//附件
	private List<File> affixs = new ArrayList<File>();
	private List<String> affixFileNames = new ArrayList<String>();
	private List<String> affixContentTypes = new ArrayList<String>();

	public List<File> getAffix() {
		return this.affixs;
	}

	public void setAffix(List<File> affixs) {
		this.affixs = affixs;
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

	//附件 end

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			fileAttach = new FileAttach();
		} else {
			fileAttach = (FileAttach) fileAttachManager.getById(id);
		}
	}

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setFileAttachManager(FileAttachManager manager) {
		this.fileAttachManager = manager;
	}

	public Object getModel() {
		return fileAttach;
	}

	public void setFileid(Long val) {
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
		dateSelectMap = DateUtil.getDateSelectData();
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
		MyUserDetails userDetail = null;
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUserName();
			deptid = userDetail.getDeptID();
		}

		if (!SpringTagFunctions.ifAnyGranted("ROLE_HT_ADMIN,ROLE_ADMIN")) {
			pageRequest.getFilters().put("deptid", deptid);
			pageRequest.getFilters().put("deptLength", deptid.length());
		}
		dateSelectMap = DateUtil.getDateSelectData();
		String dateSelect11 = "";
		if (request.getParameter("dateSelect11") != null)
			dateSelect11 = request.getParameter("dateSelect11");
		request.setAttribute("dateSelect11", dateSelect11);

		Page page = fileAttachManager.findByPageRequest(pageRequest);
		savePage(page, pageRequest);
		return LIST_JSP;
	}

	/** 查看对象*/
	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return SHOW_JSP;
	}

	/** 进入新增页面*/
	public String create() {
		return CREATE_JSP;
	}

	/** 保存新增对象 */
	public String save() {
		HttpServletRequest request = ServletActionContext.getRequest();
		fileAttachManager.save(fileAttach);
		return returnUrl;////LIST_ACTION;
	}

	/**进入更新页面*/
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return EDIT_JSP;
	}

	/**保存更新对象*/
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		fileAttachManager.update(this.fileAttach);
		return returnUrl;////LIST_ACTION;
	}

	/**删除对象*/
	public String delete() {
		for (int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String) params.get("fileid"));
			fileAttachManager.removeById(id);
		}
		return returnUrl;//LIST_ACTION;
	}

	public String deleteUserPhoto() {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String filePath = (String) getRequest().getParameter("filePath");
			fileAttachManager.removebyPath(filePath);
			result.put("success", true);
			result.put("msg", "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("failure", true);
			result.put("msg", e.getMessage());
		}
		JsonConfig jsonConfig = configJson("yyyy-MM-dd HH:mm:ss");
		setJsonString(JSONObject.fromObject(result, jsonConfig).toString());
		return JSON_JSP;
	}

	private static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getNameWithoutExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	public void upload() throws Exception {

		Enumeration<String> keys = getRequest().getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = getRequest().getParameter(key);
			System.out.println(key + " value=" + value);

		}

		String typeStr = getRequest().getParameter("file_cat");
		if (typeStr == null || (typeStr != null && typeStr.length() < 1))
			typeStr = "others";

		String baseDir = "/UserFiles";

		String currentPath = baseDir + "/" + typeStr;
		String currentDirPath = ServletActionContext.getServletContext()
				.getRealPath(currentPath);
		currentPath = getRequest().getContextPath() + currentPath;
		File baseFile = new File(currentDirPath);
		if (!baseFile.exists()) {
			baseFile.mkdirs();
		}

		if (uploads != null) {
			
			int i = 0;
			for (File u : uploads) {

			
				String dstFileNames = (String) uploadFileNames.get(i); 

				String fileName = dstFileNames;
				String newName = "";
				String fileUrl = "";
				String fileallUrl = "";

				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				File pathToSave = new File(currentDirPath, fileName);
				fileUrl = typeStr + "/" + fileName;
				fileallUrl = currentDirPath + "/" + fileName;

				int counter = 1;
				while (pathToSave.exists()) {
					newName = nameWithoutExt + "(" + counter + ")" + "." + ext;
					fileUrl = typeStr + "/" + newName;
					fileallUrl = currentDirPath + "/" + newName;
					pathToSave = new File(currentDirPath, newName);
					counter++;
				}
				copy(u, pathToSave);

				String userName = "Unkown";

				MyUserDetails userDetail = null;
				userDetail = SpringTagFunctions.getUserDetails();
				if (userDetail != null) {
					userName = userDetail.getUsername();
				}
				if (userName == null)
					userName = "Unkown";
				FileAttach fileAttachtmp = new FileAttach();
				SimpleDateFormat dirSdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String createtimeString = dirSdf.format(new Date());
				fileAttachtmp.setCreatetimeString(createtimeString);
				fileAttachtmp.setContenttype(uploadContentTypes.get(i));
				fileAttachtmp.setAbsolutepath(fileUrl);
				fileAttachtmp.setCreator(userName);
				fileAttachtmp.setFileext(ext);
				fileAttachtmp.setFilename(nameWithoutExt);
				fileAttachtmp.setFilepath(fileallUrl);
				fileAttachtmp.setFileSave("F");
				fileAttachtmp.setNote(typeStr);
				fileAttachtmp.setFilegroup("SS_USER");
				fileAttachtmp.setRelationId("userPhoto_empty");
				if (uploadContentTypes.get(i) != null)
					fileAttachtmp.setFilesize(uploadContentTypes.get(i).length());
				fileAttachtmp.setNote("员工图片");
				try {
					fileAttachManager.save(fileAttachtmp);

				} catch (Exception e) {
					e.printStackTrace();
				}

				StringBuffer sb = new StringBuffer("{success:true");
				sb.append(",fileId:").append(fileAttachtmp.getFileid()).append(
						",fileName:'").append(fileAttachtmp.getFilename())
						.append("',filePath:'").append(
								fileAttachtmp.getAbsolutepath()).append(
								(new StringBuilder("',message:'文件上传成功.("))
										.append(u.length()).append(
												" bytes)'").toString());
				sb.append("}");
				ServletActionContext.getResponse()
						.setCharacterEncoding("UTF-8");
				ServletActionContext.getResponse().setContentType(
						"text/plain;charset=UTF-8");
				ServletActionContext.getResponse().getWriter().write(
						sb.toString());

			}
		}
	}
	
	
	
	
	public String pictShow() {
	      HttpServletRequest request = ServletActionContext.getRequest();
	      String FILEID = "";
			if (request.getParameter("FILEID") != null)
				FILEID = request.getParameter("FILEID");
		    List   list =	(List)fileAttachManager.getPicContent(FILEID,"");
		    request.setAttribute("list", list);   
			return SHOW_PIC;
		}
	
	
	public void editFile() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		if (affixs != null) {
			int j = 0;
			for (; j < affixs.size(); j++) {
				String fileName  = affixFileNames.get(j);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				String ContentType = affixContentTypes.get(j);
				long fileSize = affixs.get(j).length(); 
				fileAttachManager.updateFile(affixs.get(j), fileName, ContentType, fileSize, ext, FILEID,"");
				
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		try {
			response.setContentType("text/html;charset=GBK");
			response.getWriter().print(
					"<script>alert(\" 修改成功！ \");window.close();</script>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void editPict() throws IOException {
	      HttpServletRequest request = ServletActionContext.getRequest();
			
	      String FILEID = "";
			if (request.getParameter("FILEID") != null)
				FILEID = request.getParameter("FILEID");
			//System.out.println("FILEID============"+FILEID);
		    int i = 0;
			for (File u : uploads) {
				Integer obj = new Integer(i);
				String str_ojb = obj.toString();
				String fileName  = uploadFileNames.get(i);
				String nameWithoutExt = getNameWithoutExtension(fileName);
				String ext = getExtension(fileName);
				String ContentType = uploadContentTypes.get(i);
				long fileSize = uploads.get(i).length(); 
				fileAttachManager.updateFile(uploads.get(i), nameWithoutExt, ContentType, fileSize, ext, FILEID,"");
				
				i++;
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=GBK");
			try{
				response.setContentType("text/html;charset=GBK");
				response.getWriter().print(
								"<script>alert(\" 修改成功！ \");window.close();</script>");
			} catch(Exception ex){
				
			}
		}
	
	public String deletePict() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		fileAttachManager.removebyFileID(FILEID,"");
		return deleteReturnUrl;
	}

	public String deleteFile() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		fileAttachManager.removebyFileID(FILEID,"");
		return deleteReturnUrl;
	}

	public String getDeleteReturnUrl() {
		return deleteReturnUrl;
	}

	public void setDeleteReturnUrl(String deleteReturnUrl) {
		this.deleteReturnUrl = deleteReturnUrl;
	}


}
