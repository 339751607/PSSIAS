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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TtztbFileManager extends BaseManager<TtztbFile,Long>{

	private TtztbFileDao ttztbFileDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setTtztbFileDao(TtztbFileDao dao) {
		this.ttztbFileDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.ttztbFileDao;
	}
	public Page findByPageRequest(PageRequest pr) {
		return ttztbFileDao.findByPageRequest(pr);
	}
	
	public void removetztbfile(TtztbFile entity){
		ttztbFileDao.removetztbfile(entity);
		
	}
	// 保存附件
	public void saveFile(File file, TtztbFile entity) throws IOException {
		ttztbFileDao.savePic(file, entity);
	}
	
	// 取得附件
	public List getFile( String FILEGROUP, String RELATION_ID,String sqlWhere) {
		return (List) ttztbFileDao.getPic(FILEGROUP, RELATION_ID,sqlWhere);
	}
	
	
	public Object getFileDownloadByte(String FILEID, String sqlWhere) {
		return (Object) ttztbFileDao.getFileDownloadByte(FILEID, sqlWhere);
	}
	
	public long  getSeq(){
		return (int)ttztbFileDao.getSeq();
	}
	
}
