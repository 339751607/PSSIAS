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
import org.springframework.dao.EmptyResultDataAccessException;


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
public class TelxsDao extends BaseSpringJdbcDao<Telxs,java.lang.String>{
	
	public Class getEntityClass() {
		return Telxs.class;
	}
	
	public String getIdentifierPropertyName() {
		return "telinfoid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" TELINFOID as telinfoid,"
				+" GMRXM as gmrxm,"
				+" GMRXB as gmrxb,"
				+" GMRSFZH as gmrsfzh,"
				+" GMRLXDH as gmrlxdh,"
				+" GMRJTZZ as gmrjtzz,"
				+" JBR as jbr,"
				+" BZ as bz"
				+" from T_TELXS ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_TELXS where TELINFOID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where TELINFOID=? ";
	}
	
	public void save(Telxs entity) {
		String sql = "insert into T_TELXS " 
			 + " (TELINFOID,GMRXM,GMRXB,GMRSFZH,GMRLXDH,GMRJTZZ,JBR,BZ) " 
			 + " values "
			 + " (:telinfoid,:gmrxm,:gmrxb,:gmrsfzh,:gmrlxdh,:gmrjtzz,:jbr,:bz)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"T_TELXS_XH",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Telxs entity) {
		String sql = "update T_TELXS set "
					+ " TELINFOID=:telinfoid,GMRXM=:gmrxm,GMRXB=:gmrxb,GMRSFZH=:gmrsfzh,GMRLXDH=:gmrlxdh,GMRJTZZ=:gmrjtzz,JBR=:jbr,BZ=:bz "
					+ " where TELINFOID=:telinfoid";
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
				+ "/~ and t.GMRXM = '[gmrxm]' ~/"
				+ "/~ and t.GMRXB = '[gmrxb]' ~/"
				+ "/~ and t.GMRSFZH = '[gmrsfzh]' ~/"
				+ "/~ and t.GMRLXDH = '[gmrlxdh]' ~/"
				+ "/~ and t.GMRJTZZ = '[gmrjtzz]' ~/"
				+ "/~ and t.JBR = '[jbr]' ~/"
				+ "/~ and t.BZ = '[bz]' ~/"
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
	
	
	public int getCountT_ESDNXS(String deptid) {
		String sql = "select count(TELINFOID) from T_TELXS  where TELINFOID=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {deptid} );  	 
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	

}
