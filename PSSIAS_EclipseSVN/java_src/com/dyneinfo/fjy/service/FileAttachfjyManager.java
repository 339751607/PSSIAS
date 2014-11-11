/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.service;

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

import com.dyneinfo.fjy.dao.FileAttachfjyDao;
import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class FileAttachfjyManager extends BaseManager<FileAttach, Long> {


	private FileAttachfjyDao fileAttachfjyDao;

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */

	public EntityDao getEntityDao() {
		return this.fileAttachfjyDao;
	}

	public FileAttachfjyDao getFileAttachfjyDao() {
		return fileAttachfjyDao;
	}

	public void setFileAttachfjyDao(FileAttachfjyDao fileAttachfjyDao) {
		this.fileAttachfjyDao = fileAttachfjyDao;
	}

	public Page findByPageRequest(PageRequest pr) {
		return fileAttachfjyDao.findByPageRequest(pr);
	}

	public void removebyPath(String ABSOLUTEPATH) {
		fileAttachfjyDao.removebyPath(ABSOLUTEPATH);
	}

	public void removebyFileID(java.lang.String FILEID, String sqlWhere) {
		fileAttachfjyDao.removebyFileID(FILEID, sqlWhere);
	}
	

	// 保存图片
	public void savePic(File file, FileAttach entity) throws IOException {
		fileAttachfjyDao.savePic(file, entity);
	}
	public void saveWebcamFile(byte[] blobBytes, final FileAttach entity) throws IOException {
		fileAttachfjyDao.saveWebcamFile(blobBytes, entity);
	}

	// 修改图片
	public void updatePic(File file, FileAttach entity) throws IOException {
		fileAttachfjyDao.updatePic(file, entity);
	}

	// 修改图片
	public void updatePic(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachfjyDao.updatePic(file, FILENAME, CONTENTTYPE, FILESIZE, FILEEXT,
				FILEID, sqlWhere);
	}

	// 取得照片
	public List getPic(String FILE_SAVE, String FILEGROUP, String RELATION_ID,
			String sqlWhere) {
		return (List) fileAttachfjyDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,
				sqlWhere);
	}

	public List getPicContent(String FILEID, String sqlWhere) {
		return (List) fileAttachfjyDao.getPicContent(FILEID, sqlWhere);
	}

	// 保存附件
	public void saveFile(File file, FileAttach entity) throws IOException {
		fileAttachfjyDao.savePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, FileAttach entity) throws IOException {
		fileAttachfjyDao.updatePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachfjyDao.updateFile(file, FILENAME, CONTENTTYPE, FILESIZE,
				FILEEXT, FILEID, sqlWhere);
	}

	// 取得附件
	public List getFile(String FILE_SAVE, String FILEGROUP, String RELATION_ID,String sqlWhere) {
		return (List) fileAttachfjyDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,sqlWhere);
	}

	// 取得附件
	public List getFileContent(final String FILEID, String sqlWhere) {
		return (List) fileAttachfjyDao.getFileContent(FILEID, sqlWhere);
	}

	public List getFile(String FILEID, String sqlWhere) {
		return (List) fileAttachfjyDao.getFile(FILEID, sqlWhere);
	}

	public Object getFileDownloadByte(String FILEID, String sqlWhere) {
		return (Object) fileAttachfjyDao.getFileDownloadByte(FILEID, sqlWhere);
	}
	public long  getSeq(){
		return (int)fileAttachfjyDao.getSeq();
	}


}
