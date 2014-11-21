
package com.dyneinfo.zazh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javacommon.base.BaseManager;
import javacommon.base.CustomerContextHolder;
import javacommon.base.EntityDao;

import org.springframework.stereotype.Component;

import com.dyneinfo.zazh.dao.AsecurityMenuDao;
import com.dyneinfo.zazh.model.AsecurityMenu;
import com.dyneinfo.zazh.model.MainMenuItemExt;
import com.dyneinfo.zazh.model.menuViewSpring;




@Component
public class AsecurityMenuManager extends BaseManager<AsecurityMenu,java.math.BigDecimal>{

	private AsecurityMenuDao asecurityMenuDao;
	/**通过spring注入AsecurityMenuDao*/
	public void setAsecurityMenuDao(AsecurityMenuDao dao) {
		this.asecurityMenuDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.asecurityMenuDao;
	}
	
	 public List getUserMenusList(String userName) {
			
			return asecurityMenuDao.getUserMenusList(userName);
		}
	public AsecurityMenuDao getAsecurityMenuDao() {
		return asecurityMenuDao;
	}
	 
	public String queryDataAuthoritySwitchStatus(){
		return asecurityMenuDao.queryDataAuthoritySwitchStatus();
	}
	
	public List getQuery(String sql){
		return asecurityMenuDao.getQuery(sql);
	}

	
}
