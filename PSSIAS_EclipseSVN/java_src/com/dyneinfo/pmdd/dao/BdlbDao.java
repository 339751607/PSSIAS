/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class BdlbDao extends BaseSpringJdbcDao<Bdlb,java.lang.String>{
	
	public Class getEntityClass() {
		return Bdlb.class;
	}
	
	public String getIdentifierPropertyName() {
		return "mc";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" TIB_FLOWGUID as tibFlowguid,"
				+" TIB_ROWGUID as tibRowguid,"
				+" MC as mc,"
				+" DM as dm"
				+" from BDLB ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from BDLB where MC=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where MC=? ";
	}
	
	public void save(Bdlb entity) {
		String sql = "insert into BDLB " 
			 + " (TIB_FLOWGUID,TIB_ROWGUID,MC,DM) " 
			 + " values "
			 + " (:tibFlowguid,:tibRowguid,:mc,:dm)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_BDLB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Bdlb entity) {
		String sql = "update BDLB set "
					+ " TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,MC=:mc,DM=:dm "
					+ " where MC=:mc";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.DM = '[dm]' ~/"
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
	
	
	private String createSql = "insert into BDLB " 
		 + " (TIB_FLOWGUID,TIB_ROWGUID,MC,DM) " 
		 + " values "
		 + " (?,?,?,?)";
	private String updateSql = "update BDLB set "
		+ " TIB_FLOWGUID=?,TIB_ROWGUID=?,MC=?,DM=? "
		+ " where MC=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Bdlb entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getTibFlowguid());
						ps.setString(2, entity.getTibRowguid());
						ps.setString(3, entity.getMc());
						ps.setString(4, entity.getDm());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createBdlb(final Bdlb entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getMc());
				ps.setString(4, entity.getDm());
			}
		});
	}

	
	public void updateBdlb(final Bdlb entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getMc());
				ps.setString(4, entity.getDm());
			}
		});
	}

	
	public void deleteBdlb(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
