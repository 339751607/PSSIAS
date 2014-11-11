/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.gas.model.FileAttach;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class GasFileAttachDao extends BaseSpringJdbcDao<FileAttach, Long> {

	public Class getEntityClass() {
		return FileAttach.class;
	}

	public String getIdentifierPropertyName() {
		return "fileid";
	}

	public List getFile(String FILEID,String sqlWhere) {
		String sql = "select FILEID,FILENAME from T_TZTB_FILE  where ID = ? ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
	       return getJdbcTemplate().query(sql, new String[] {FILEID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      
	        	    String FILEID = rs.getString("FILEID");
					String FILENAME = rs.getString("FILENAME");
	        	  
					results.put("FILEID", FILEID);
					results.put("FILENAME", FILENAME);
			        
			        return results;
	           }
	           
	       });
	   }
	
	
	
    public Object getFileDownloadByte(final String FILEID,String sqlWhere) {
    	String sql = "select FILECONTENT from T_TZTB_FILE where ID =? ";
    	if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return this.getJdbcTemplate().execute(sql,
				new PreparedStatementCallback() {
					public Object doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, FILEID);
						ResultSet rs = ps.executeQuery();
						if (rs.next()) {
							InputStream inputStream = rs.getBinaryStream("FILECONTENT");
							try {
								return IOUtils.toByteArray(inputStream);
							} catch (IOException e) {
							}
						}
						return null;
					}
				});
	}
    
    
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_FILE_ATTACH");
		Long id = seq.nextLongValue();
        return id;
	}

	@Override
	public String getDeleteByIdSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindByIdSql() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FileAttach> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(FileAttach entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(FileAttach entity) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
