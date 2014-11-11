package com.dyneinfo.dwr.dao.impl;

import java.io.Serializable;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class PhotoQuartzDelImpl extends JdbcDaoSupport  implements Serializable  {
	
	private static final long serialVersionUID = 122323233244334322L; 
	
    public boolean deleteTempPhoto() {
    	boolean result = false;
		int i = 0;
		i = getJdbcTemplate()
            .update("delete from FILE_ATTACH where FILEGROUP = 'temp_photo' and CREATETIME < (sysdate-1/12) ");
		if (i > 0) {
			result = true;
		}
		return result;
      
    }

}