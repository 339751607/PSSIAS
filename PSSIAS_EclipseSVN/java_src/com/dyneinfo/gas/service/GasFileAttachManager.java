/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.service;

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

import com.dyneinfo.gas.model.FileAttach;
import com.dyneinfo.gas.dao.GasFileAttachDao;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class GasFileAttachManager extends BaseManager<FileAttach, Long> {


	private GasFileAttachDao gasFileAttachDao;

	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性 */

	public EntityDao getEntityDao() {
		return this.gasFileAttachDao;
	}

	public List getFile(String FILEID, String sqlWhere) {
		return (List) gasFileAttachDao.getFile(FILEID, sqlWhere);
	}

	public Object getFileDownloadByte(String FILEID, String sqlWhere) {
		return (Object) gasFileAttachDao.getFileDownloadByte(FILEID, sqlWhere);
	}
	public long  getSeq(){
		return (int)gasFileAttachDao.getSeq();
	}

	public void setGasfileAttachDao(GasFileAttachDao gasfileAttachDao) {
		this.gasFileAttachDao = gasfileAttachDao;
	}

	public void setGasFileAttachDao(GasFileAttachDao gasFileAttachDao) {
		this.gasFileAttachDao = gasFileAttachDao;
	}


}
