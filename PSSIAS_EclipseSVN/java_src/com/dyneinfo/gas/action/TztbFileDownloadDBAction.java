package com.dyneinfo.gas.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dyneinfo.gas.service.TtztbFileManager;
import com.dyneinfo.gas.service.GasFileAttachManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class TztbFileDownloadDBAction extends ActionSupport {
	private static final long serialVersionUID = 6329383258366253255L;

	private GasFileAttachManager fileAttachManager;
	
	private TtztbFileManager ttztbFileManager;

	InputStream inputStream;
	String fileName = "";
	String contentType = "";
	String contentTypeName = "";

	public void setFileAttachManager(GasFileAttachManager manager) {
		this.fileAttachManager = manager;
	}

	public InputStream getInputStream() throws Exception {

		System.out.println("getInputStream=");
		return inputStream;

	}

	/** 提供转换编码后的供下载用的文件名 */

	public String getDownloadFileName() {

		String downFileName = fileName;

		try {
			downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("downFileName=" + downFileName);

		return downFileName;

	}

	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		String FILEID = "";
		if (request.getParameter("FILEID") != null)
			FILEID = request.getParameter("FILEID");
		List list = (List) this.fileAttachManager.getFile(FILEID,"");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String v_szfileName = (String) results.get("FILENAME");
				contentType = (String) results.get("CONTENTTYPE");
				String v_sz_FILEEXT = (String) results.get("FILEEXT");
				setContentTypeName(contentType);
				fileName = v_szfileName +"."+v_sz_FILEEXT;
				System.out.println("fileName=" + fileName);
				System.out.println("contentType=" + contentType);
			}
		}
		byte[] bytes = (byte[]) this.fileAttachManager.getFileDownloadByte(FILEID,"");
		inputStream = new ByteArrayInputStream(bytes);
		return SUCCESS;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public void setTtztbFileManager(TtztbFileManager ttztbFileManager) {
		this.ttztbFileManager = ttztbFileManager;
	}

}
