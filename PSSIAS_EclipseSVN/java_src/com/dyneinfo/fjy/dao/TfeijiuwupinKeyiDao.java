/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TfeijiuwupinKeyiDao extends BaseSpringJdbcDao<TfeijiuwupinKeyi,Long>{
	
	public Class getEntityClass() {
		return TfeijiuwupinKeyi.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" WUPINXH as wupinxh,"
				+" KEYIYUANYIN as keyiyuanyin,"
				+" XH as xh"
				+" from T_FEIJIUWUPIN_KEYI ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_FEIJIUWUPIN_KEYI where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where XH=? ";
	}
	
	public void save(TfeijiuwupinKeyi entity) {
		String sql = "insert into T_FEIJIUWUPIN_KEYI " 
			 + " (WUPINXH,KEYIYUANYIN,XH) " 
			 + " values "
			 + " (:wupinxh,:keyiyuanyin,:xh)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_FEIJIUWUPIN_KEYI",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TfeijiuwupinKeyi entity) {
		String sql = "update T_FEIJIUWUPIN_KEYI set "
					+ " WUPINXH=:wupinxh,KEYIYUANYIN=:keyiyuanyin,XH=:xh "
					+ " where XH=:xh";
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
				+ "/~ and t.WUPINXH = '[wupinxh]' ~/"
				+ "/~ and t.KEYIYUANYIN = '[keyiyuanyin]' ~/"
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
	
	
	private String createSql = "insert into T_FEIJIUWUPIN_KEYI " 
		 + " (WUPINXH,KEYIYUANYIN,XH) " 
		 + " values "
		 + " (?,?,?)";
	private String updateSql = "update T_FEIJIUWUPIN_KEYI set "
		+ " WUPINXH=?,KEYIYUANYIN=?,XH=? "
		+ " where XH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TfeijiuwupinKeyi entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getWupinxh());
						ps.setString(2, entity.getKeyiyuanyin());
						ps.setLong(3, entity.getXh());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTfeijiuwupinKeyi(final TfeijiuwupinKeyi entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getWupinxh());
				ps.setString(2, entity.getKeyiyuanyin());
				ps.setLong(3, entity.getXh());
			}
		});
	}

	
	public void updateTfeijiuwupinKeyi(final TfeijiuwupinKeyi entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getWupinxh());
				ps.setString(2, entity.getKeyiyuanyin());
				ps.setLong(3, entity.getXh());
			}
		});
	}

	
	public void deleteTfeijiuwupinKeyi(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
