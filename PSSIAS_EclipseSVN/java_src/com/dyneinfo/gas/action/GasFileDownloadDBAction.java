package com.dyneinfo.gas.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dyneinfo.gas.service.GasFileAttachManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class GasFileDownloadDBAction extends ActionSupport {
	private static final long serialVersionUID = 6329383258366253255L;

	private GasFileAttachManager gasFileAttachManager;

	InputStream inputStream;
	String fileName = "";
	String contentType = "";
	String contentTypeName = "";


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
		List list = (List) this.gasFileAttachManager.getFile(FILEID,"");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map results = (HashMap) list.get(i);
				String v_szfileName = (String) results.get("FILENAME");
				fileName = v_szfileName;
			}
		}
		byte[] bytes = (byte[]) this.gasFileAttachManager.getFileDownloadByte(FILEID,"");
		inputStream = new ByteArrayInputStream(bytes);
		return SUCCESS;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public void setGasFileAttachManager(GasFileAttachManager gasFileAttachManager) {
		this.gasFileAttachManager = gasFileAttachManager;
	}

}
