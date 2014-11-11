/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;



import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.dao.TpersonlogJnDao.MapRowMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsDatasourceDao extends BaseSpringJdbcDao<SsDatasource,Long>{
	
	public Class getEntityClass() {
		return SsDatasource.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" CODE as code,"
				+" CALLED as called,"
				+" DBS_DRIVERCLASSNAME as dbsDriverclassname,"
				+" DBS_URL as dbsUrl,"
				+" DBS_USERNAME as dbsUsername,"
				+" DBS_PASSWORD as dbsPassword,"
				+" DBS_NAME as dbsName,"
				+" ISVALID as isvalid,"
				+" EXTEND1 as extend1,"
				+" EXTEND2 as extend2"
				+" from SS_DATASOURCE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_DATASOURCE where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(SsDatasource entity) {
		String sql = "insert into SS_DATASOURCE " 
			 + " (ID,CODE,CALLED,DBS_DRIVERCLASSNAME,DBS_URL,DBS_USERNAME,DBS_PASSWORD,DBS_NAME,ISVALID,EXTEND1,EXTEND2) " 
			 + " values "
			 + " (:id,:code,:called,:dbsDriverclassname,:dbsUrl,:dbsUsername,:dbsPassword,:dbsName,:isvalid,:extend1,:extend2)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_DATASOURCE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsDatasource entity) {
		String sql = "update SS_DATASOURCE set "
					+ " ID=:id,CODE=:code,CALLED=:called,DBS_DRIVERCLASSNAME=:dbsDriverclassname,DBS_URL=:dbsUrl,DBS_USERNAME=:dbsUsername,DBS_PASSWORD=:dbsPassword,DBS_NAME=:dbsName,ISVALID=:isvalid,EXTEND1=:extend1,EXTEND2=:extend2 "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	public SsDatasource getDataSouceByBusinessCode(String businessCode) {

		String sql = getSelectPrefix() + " WHERE code = '"+ businessCode+"' " ;
		String sqlcount =  " select count(*) from SS_DATASOURCE  WHERE code = '"+ businessCode+"' " ;
		int count = getSimpleJdbcTemplate().queryForInt(sqlcount);
		if(count >0){
		   return (SsDatasource)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		}else{
			return null;
		}
	}
	public Number getCountForSQL(String sql) {
		
		int count = getSimpleJdbcTemplate().queryForInt(sql);
		
		return count;
	}
	public List getLogInfoForMap(String sql ) {
		
		List mapList = getJdbcTemplate().query(sql, new MapRowMapper());
		
		return mapList;
		
	}	
    protected class MapRowMapper implements RowMapper{
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    		// TODO Auto-generated method stub
    		HashMap map  = new HashMap();
    		map.put("code", rs.getString("code"));
    		map.put("called", rs.getString("called"));
    		map.put("incount", rs.getInt("incount"));
    		map.put("incount1", rs.getInt("incount1"));
    		return map;
    	}
    }
    
	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.CODE = '[code]' ~/"
				+ "/~ and t.CALLED = '[called]' ~/"
				+ "/~ and t.DBS_DRIVERCLASSNAME = '[dbsDriverclassname]' ~/"
				+ "/~ and t.DBS_URL = '[dbsUrl]' ~/"
				+ "/~ and t.DBS_USERNAME = '[dbsUsername]' ~/"
				+ "/~ and t.DBS_PASSWORD = '[dbsPassword]' ~/"
				+ "/~ and t.DBS_NAME = '[dbsName]' ~/"
				+ "/~ and t.ISVALID = '[isvalid]' ~/"
				+ "/~ and t.CODE != '[not_code]' ~/"
				+ "/~ and t.EXTEND1 = '[extend1]' ~/"
				+ "/~ and t.EXTEND2 = '[extend2]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public String getCurrentMax(String sql,String arg) throws DataAccessException {
		String currentMaxID = "";
		//String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj ={arg}; 
		try {
			currentMaxID = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}
	
	
	private String createSql = "insert into SS_DATASOURCE " 
		 + " (ID,CODE,CALLED,DBS_DRIVERCLASSNAME,DBS_URL,DBS_USERNAME,DBS_PASSWORD,DBS_NAME,ISVALID,EXTEND1,EXTEND2) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update SS_DATASOURCE set "
		+ " ID=?,CODE=?,CALLED=?,DBS_DRIVERCLASSNAME=?,DBS_URL=?,DBS_USERNAME=?,DBS_PASSWORD=?,DBS_NAME=?,ISVALID=?,EXTEND1=?,EXTEND2=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final SsDatasource entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getCode());
						ps.setString(3, entity.getCalled());
						ps.setString(4, entity.getDbsDriverclassname());
						ps.setString(5, entity.getDbsUrl());
						ps.setString(6, entity.getDbsUsername());
						ps.setString(7, entity.getDbsPassword());
						ps.setString(8, entity.getDbsName());
						ps.setString(9, entity.getIsvalid());
						ps.setString(10, entity.getExtend1());
						ps.setString(11, entity.getExtend2());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createSsDatasource(final SsDatasource entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getCode());
				ps.setString(3, entity.getCalled());
				ps.setString(4, entity.getDbsDriverclassname());
				ps.setString(5, entity.getDbsUrl());
				ps.setString(6, entity.getDbsUsername());
				ps.setString(7, entity.getDbsPassword());
				ps.setString(8, entity.getDbsName());
				ps.setString(9, entity.getIsvalid());
				ps.setString(10, entity.getExtend1());
				ps.setString(11, entity.getExtend2());
			}
		});
	}

	
	public void updateSsDatasource(final SsDatasource entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getCode());
				ps.setString(3, entity.getCalled());
				ps.setString(4, entity.getDbsDriverclassname());
				ps.setString(5, entity.getDbsUrl());
				ps.setString(6, entity.getDbsUsername());
				ps.setString(7, entity.getDbsPassword());
				ps.setString(8, entity.getDbsName());
				ps.setString(9, entity.getIsvalid());
				ps.setString(10, entity.getExtend1());
				ps.setString(11, entity.getExtend2());
			}
		});
	}

	
	public void deleteSsDatasource(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
