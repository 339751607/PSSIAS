/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.service;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;
import com.dyneinfo.zazh.model.FileAttach;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class FileAttachjxyManager extends BaseManager<FileAttach, Long> {


	private FileAttachjxyDao fileAttachjxyDao;

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */
	public void setFileAttachjxyDao(FileAttachjxyDao dao) {
		this.fileAttachjxyDao = dao;
	}

	public EntityDao getEntityDao() {
		return this.fileAttachjxyDao;
	}

	public Page findByPageRequest(PageRequest pr) {
		return fileAttachjxyDao.findByPageRequest(pr);
	}

	public void removebyPath(String ABSOLUTEPATH) {
		fileAttachjxyDao.removebyPath(ABSOLUTEPATH);
	}

	public void removebyFileID(java.lang.String FILEID, String sqlWhere) {
		fileAttachjxyDao.removebyFileID(FILEID, sqlWhere);
	}

	// 保存图片
	public void savePic(File file, FileAttach entity) throws IOException {
		fileAttachjxyDao.savePic(file, entity);
	}

	// 修改图片
	public void updatePic(File file, FileAttach entity) throws IOException {
		fileAttachjxyDao.updatePic(file, entity);
	}

	// 修改图片
	public void updatePic(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachjxyDao.updatePic(file, FILENAME, CONTENTTYPE, FILESIZE, FILEEXT,
				FILEID, sqlWhere);
	}

	// 取得照片
	public List getPic(String FILE_SAVE, String FILEGROUP, String RELATION_ID,
			String sqlWhere) {
		return (List) fileAttachjxyDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,
				sqlWhere);
	}

	public List getPicContent(String FILEID, String sqlWhere) {
		return (List) fileAttachjxyDao.getPicContent(FILEID, sqlWhere);
	}

	// 保存附件
	public void saveFile(File file, FileAttach entity) throws IOException {
		fileAttachjxyDao.savePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, FileAttach entity) throws IOException {
		fileAttachjxyDao.updatePic(file, entity);
	}

	// 修改附件
	public void updateFile(File file, String FILENAME, String CONTENTTYPE,
			Long FILESIZE, String FILEEXT, String FILEID, String sqlWhere)
			throws IOException {
		fileAttachjxyDao.updateFile(file, FILENAME, CONTENTTYPE, FILESIZE,
				FILEEXT, FILEID, sqlWhere);
	}

	// 取得附件
	public List getFile(String FILE_SAVE, String FILEGROUP, String RELATION_ID,String sqlWhere) {
		return (List) fileAttachjxyDao.getPic(FILE_SAVE, FILEGROUP, RELATION_ID,sqlWhere);
	}

	// 取得附件
	public List getFileContent(final String FILEID, String sqlWhere) {
		return (List) fileAttachjxyDao.getFileContent(FILEID, sqlWhere);
	}

	public List getFile(String FILEID, String sqlWhere) {
		return (List) fileAttachjxyDao.getFile(FILEID, sqlWhere);
	}

	public Object getFileDownloadByte(String FILEID, String sqlWhere) {
		return (Object) fileAttachjxyDao.getFileDownloadByte(FILEID, sqlWhere);
	}
	public long  getSeq(){
		return (int)fileAttachjxyDao.getSeq();
	}


}
