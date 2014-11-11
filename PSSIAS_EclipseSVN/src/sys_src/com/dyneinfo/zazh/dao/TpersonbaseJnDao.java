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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonbaseJnDao extends BaseSpringJdbcDao<TpersonbaseJn,Long>{
	
	public Class getEntityClass() {
		return TpersonbaseJn.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" NAME as name,"
				+" SEX as sex,"
				+" NATION as nation,"
				+" BDATE as bdate,"
				+" CARDNAME as cardname,"
				+" CARDCODE as cardcode,"
				+" XZQH as xzqh,"
				+" ADDRESS as address,"
				+" UPDATETIME as updatetime"
				+" from T_PERSONBASE_JN ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_PERSONBASE_JN where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TpersonbaseJn entity) {
		String sql = "insert into T_PERSONBASE_JN " 
			 + " (ID,NAME,SEX,NATION,BDATE,CARDNAME,CARDCODE,XZQH,ADDRESS,UPDATETIME) " 
			 + " values "
			 + " (:id,:name,:sex,:nation,:bdate,:cardname,:cardcode,:xzqh,:address,:updatetime)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_PERSONBASE_JN",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpersonbaseJn entity) {
		String sql = "update T_PERSONBASE_JN set "
					+ " ID=:id,NAME=:name,SEX=:sex,NATION=:nation,BDATE=:bdate,CARDNAME=:cardname,CARDCODE=:cardcode,XZQH=:xzqh,ADDRESS=:address,UPDATETIME=:updatetime "
					+ " where ID=:id";
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
				+ "/~ and t.NAME like '%[name]%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.NATION = '[nation]' ~/"
				+ "/~ and t.BDATE like '[bdate]%' ~/"
				+ "/~ and t.CARDNAME = '[cardname]' ~/"
				+ "/~ and t.CARDCODE like '[cardcode]%' ~/"
				+ "/~ and t.XZQH = '[xzqh]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
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
	
	
	private String createSql = "insert into T_PERSONBASE_JN " 
		 + " (ID,NAME,SEX,NATION,BDATE,CARDNAME,CARDCODE,XZQH,ADDRESS,UPDATETIME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_PERSONBASE_JN set "
		+ " ID=?,NAME=?,SEX=?,NATION=?,BDATE=?,CARDNAME=?,CARDCODE=?,XZQH=?,ADDRESS=?,UPDATETIME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpersonbaseJn entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getName());
						ps.setString(3, entity.getSex());
						ps.setString(4, entity.getNation());
						ps.setString(5, entity.getBdate());
						ps.setString(6, entity.getCardname());
						ps.setString(7, entity.getCardcode());
						ps.setString(8, entity.getXzqh());
						ps.setString(9, entity.getAddress());
						ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpersonbaseJn(final TpersonbaseJn entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getCardname());
				ps.setString(7, entity.getCardcode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void updateTpersonbaseJn(final TpersonbaseJn entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getCardname());
				ps.setString(7, entity.getCardcode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void deleteTpersonbaseJn(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
