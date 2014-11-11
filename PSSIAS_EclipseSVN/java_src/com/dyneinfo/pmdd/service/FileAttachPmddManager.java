/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class FileAttachPmddManager extends BaseManager<FileAttach, Long> {


	private FileAttachPmddDao fileAttachDao;

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setFileAttachPmddDao(FileAttachPmddDao dao) {
		this.fileAttachDao = dao;
	}

	public EntityDao getEntityDao() {
		return this.fileAttachDao;
	}

	public Page findByPageRequest(PageRequest pr) {
		return fileAttachDao.findByPageRequest(pr);
	}

	public void removebyPath(String ABSOLUTEPATH) {
		fileAttachDao.removebyPath(ABSOLUTEPATH);
	}

	public void removebyFileID(java.lang.String FILEID, String sqlWhere) {
		fileAttachDao.removebyFileID(FILEID, sqlWhere);
	}
	

	// 保存图片
	public void savePic(File file, FileAttach entity) throws IOException {
		fileAttachDao.savePic(file, entity);
	}
	public void saveWebcamFile(byte[] blobBytes, final FileAttach entity) throws IOException {
		fileAttachDao.saveWebcamFile(blobBytes, entity);
	}

	// 修改图片
	public void updatePic(File file, FileAttach entity) throws IOException {
		fileAttachDao.updatePic(file, entity);
	}

	// 修改图片
	public void updatePic(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachDao.updatePic(file, FILENAME, CONTENTTYPE, FILESIZE, FILEEXT,
				FILEID, sqlWhere);
	}

	// 取得照片
	public List getPic(String FILE_SAVE, String FILEGROUP, String RELATION_ID,
			String sqlWhere) {
		return (List) fileAttachDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,
				sqlWhere);
	}

	public List getPicContent(String FILEID, String sqlWhere) {
		return (List) fileAttachDao.getPicContent(FILEID, sqlWhere);
	}

	// 保存附件
	public void saveFile(File file, FileAttach entity) throws IOException {
		fileAttachDao.savePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, FileAttach entity) throws IOException {
		fileAttachDao.updatePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachDao.updateFile(file, FILENAME, CONTENTTYPE, FILESIZE,
				FILEEXT, FILEID, sqlWhere);
	}

	// 取得附件
	public List getFile(String FILE_SAVE, String FILEGROUP, String RELATION_ID,String sqlWhere) {
		return (List) fileAttachDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,sqlWhere);
	}

	// 取得附件
	public List getFileContent(final String FILEID, String sqlWhere) {
		return (List) fileAttachDao.getFileContent(FILEID, sqlWhere);
	}

	public List getFile(String FILEID, String sqlWhere) {
		return (List) fileAttachDao.getFile(FILEID, sqlWhere);
	}

	public Object getFileDownloadByte(String FILEID, String sqlWhere) {
		return (Object) fileAttachDao.getFileDownloadByte(FILEID, sqlWhere);
	}
	public long  getSeq(){
		return (int)fileAttachDao.getSeq();
	}


}
