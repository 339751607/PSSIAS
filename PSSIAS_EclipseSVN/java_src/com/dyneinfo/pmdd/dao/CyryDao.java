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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import com.dyneinfo.zazh.model.SsUser;

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
public class CyryDao extends BaseSpringJdbcDao<Cyry,java.lang.String>{
	
	public Class getEntityClass() {
		return Cyry.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" XM as xm,"
				+" XB as xb,"
				+" DWBM as dwbm,"
				+" GMSFHM as gmsfhm,"
				+" DWNBM as dwnbm,"
				+" BIRTHDAY as birthday,"
				+" ZZ as zz,"
				+" HKSZD as hkszd,"
				+" WHCD as whcd,"
				+" GZLX as gzlx,"
				+" RZRQ as rzrq,"
				+" FLAG as flag,"
				+" LZRQ as lzrq,"
				+" TIB_FLOWGUID as tibFlowguid,"
				+" TIB_ROWGUID as tibRowguid,"
				+" ZZZH as zzzh,"
				+" ZZDZ as zzdz,"
				+" ZZMM as zzmm,"
				+" ZAPXZ_ID as zapxzId,"
				+" ZZJGBH as zzjgbh"
				+" from CYRYXXB ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from CYRYXXB where DWBM=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DWBM=? ";
	}
	
	public void save(Cyry entity) {
		String sql = "insert into CYRYXXB " 
			 + " (XM,XB,DWBM,GMSFHM,DWNBM,BIRTHDAY,ZZ,HKSZD,WHCD,GZLX,RZRQ,FLAG,LZRQ,TIB_FLOWGUID,TIB_ROWGUID,ZZZH,ZZDZ,ZZMM,ZAPXZ_ID,ZZJGBH) " 
			 + " values "
			 + " (:xm,:xb,:dwbm,:gmsfhm,:dwnbm,:birthday,:zz,:hkszd,:whcd,:gzlx,:rzrq,:flag,:lzrq,:tibFlowguid,:tibRowguid,:zzzh,:zzdz,:zzmm,:zapxzId,:zzjgbh)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_CYRYXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Cyry entity) {
		String sql = "update CYRYXXB set "
					+ " XM=:xm,XB=:xb,DWBM=:dwbm,GMSFHM=:gmsfhm,DWNBM=:dwnbm,BIRTHDAY=:birthday,ZZ=:zz,HKSZD=:hkszd,WHCD=:whcd,GZLX=:gzlx,RZRQ=:rzrq,FLAG=:flag,LZRQ=:lzrq,TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,ZZZH=:zzzh,ZZDZ=:zzdz,ZZMM=:zzmm,ZAPXZ_ID=:zapxzId,ZZJGBH=:zzjgbh "
					+ " where DWBM=:dwbm and DWNBM=:dwnbm";
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
				+ "/~ and t.DWBM = '[deptid]' ~/"
				+ "/~ and t.DWBM in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.XM = '[xm]' ~/"
				+ "/~ and t.XB = '[xb]' ~/"
				+ "/~ and t.GMSFHM = '[gmsfhm]' ~/"
				+ "/~ and t.BIRTHDAY >= '[birthdayBeginFormat]' ~/"
				+ "/~ and t.BIRTHDAY <= '[birthdayEndFormat]' ~/"
				+ "/~ and t.ZZ = '[zz]' ~/"
				+ "/~ and t.HKSZD = '[hkszd]' ~/"
				+ "/~ and t.WHCD = '[whcd]' ~/"
				+ "/~ and t.GZLX = '[gzlx]' ~/"
				+ "/~ and t.RZRQ >= '[rzrqBeginFormat]' ~/"
				+ "/~ and t.RZRQ <= '[rzrqEndFormat]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.LZRQ = '[lzrq]' ~/"
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.ZZZH = '[zzzh]' ~/"
				+ "/~ and t.ZZDZ = '[zzdz]' ~/"
				+ "/~ and t.ZZMM = '[zzmm]' ~/"
				+ "/~ and t.ZAPXZ_ID = '[zapxzId]' ~/"
				+ "/~ and t.ZZJGBH = '[zzjgbh]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public String getCurrentMax(String arg) throws DataAccessException {
		String currentPhase;
		String sql="select max(DWNBM) from CYRYXXB where DWBM="+arg;
		try {
			currentPhase = (String) this.getJdbcTemplate().queryForObject(sql, String.class);
		} catch (Exception e) {
			currentPhase = "";
			e.printStackTrace();
		}
		return currentPhase;
	}
	
	
	public Cyry getCyryById(String dwbm,String dwnbm) {
	    String sql =	getSelectPrefix() + " where DWBM=?  and DWNBM= ?";	
	    Cyry cyry = null;
		try {   
			cyry = (Cyry)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {dwbm,dwnbm});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return cyry;
	}
	
	public void removeRecorderById(String dwbm,String dwnbm) {
		String sql = " delete from  CYRYXXB  where DWBM =:dwbm and DWNBM  =:dwnbm ";
		Map namedParameters = new HashMap();
		namedParameters.put("dwbm", dwbm);
		namedParameters.put("dwnbm", dwnbm);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public List<Cyry> findCyryByDeptId(String deptid) {
		String sql = getSelectPrefix()+" where trim(DWBM)=? ";
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), deptid);
	}
}
