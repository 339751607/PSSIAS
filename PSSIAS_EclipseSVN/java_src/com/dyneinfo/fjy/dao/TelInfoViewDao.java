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
public class TelInfoViewDao extends BaseSpringJdbcDao<TelInfoView,java.lang.String>{
	
	public Class getEntityClass() {
		return TelInfoView.class;
	}
	
	public String getIdentifierPropertyName() {
		return "telinfoid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" TELINFOID as telinfoid,"
				+" TELPP as telpp,"
				+" TELXH as telxh,"
				+" TELYS as telys,"
				+" JXXLH as jxxlh,"
				+" SJLB as sjlb,"
				+" BZ as bz,"
				+" CPCODE as cpcode,"
				+" CHUSHOURY as chushoury,"
				+" CHUSHOURENXB as chushourenxb,"
				+" CHUSHOURENSFZH as chushourensfzh,"
				+" BEIZHU as beizhu,"
				+" CHUSHOURENLXDH as chushourenlxdh,"
				+" SGSJ as sgsj,"
				+" DQSJH as dqsjh,"
				+" CSRJTZZ as csrjtzz,"
				+" CSRDH as csrdh,"
				+" GJSJ as gjsj,"
				+" JBR as jbr,"
				+" DEPTNAME as deptname,"
				+" FULLNAME as fullname"
				+" from V_TELINFO ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from V_TELINFO where TELINFOID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where TELINFOID=? ";
	}
	
	public void save(TelInfoView entity) {
		String sql = "insert into V_TELINFO " 
			 + " (TELINFOID,TELPP,TELXH,TELYS,JXXLH,SJLB,BZ,CPCODE,CHUSHOURY,CHUSHOURENXB,CHUSHOURENSFZH,BEIZHU,CHUSHOURENLXDH,SGSJ,DQSJH,CSRJTZZ,CSRDH,GJSJ,JBR,DEPTNAME,FULLNAME) " 
			 + " values "
			 + " (:telinfoid,:telpp,:telxh,:telys,:jxxlh,:sjlb,:bz,:cpcode,:chushoury,:chushourenxb,:chushourensfzh,:beizhu,:chushourenlxdh,:sgsj,:dqsjh,:csrjtzz,:csrdh,:gjsj,:jbr,:deptname,:fullname)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_V_TELINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TelInfoView entity) {
		String sql = "update V_TELINFO set "
					+ " TELINFOID=:telinfoid,TELPP=:telpp,TELXH=:telxh,TELYS=:telys,JXXLH=:jxxlh,SJLB=:sjlb,BZ=:bz,CPCODE=:cpcode,CHUSHOURY=:chushoury,CHUSHOURENXB=:chushourenxb,CHUSHOURENSFZH=:chushourensfzh,BEIZHU=:beizhu,CHUSHOURENLXDH=:chushourenlxdh,SGSJ=:sgsj,DQSJH=:dqsjh,CSRJTZZ=:csrjtzz,CSRDH=:csrdh,GJSJ=:gjsj,JBR=:jbr,DEPTNAME=:deptname,FULLNAME=:fullname "
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
				+ "/~ and t.TELPP = '[telpp]' ~/"
				+ "/~ and t.TELXH = '[telxh]' ~/"
				+ "/~ and t.TELYS = '[telys]' ~/"
				+ "/~ and t.JXXLH like  '%'||{jxxlh}||'%'  ~/"
				+ "/~ and t.SJLB = '[sjlb]' ~/"
				+ "/~ and t.BZ = '[bz]' ~/"
				+ "/~ and t.CHUSHOURY = '[chushoury]' ~/"
				+ "/~ and t.CHUSHOURENXB = '[chushourenxb]' ~/"
				+ "/~ and t.CHUSHOURENSFZH = '[chushourensfzh]' ~/"
				+ "/~ and t.BEIZHU = '[beizhu]' ~/"
				+ "/~ and t.CHUSHOURENLXDH = '[chushourenlxdh]' ~/"
				+ "/~ and t.SGSJ >= to_date('[sgsjBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.SGSJ <= to_date('[sgsjEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.DQSJH = '[dqsjh]' ~/"
				+ "/~ and t.CSRJTZZ = '[csrjtzz]' ~/"
				+ "/~ and t.CSRDH = '[csrdh]' ~/"
				+ "/~ and t.GJSJ = '[gjsj]' ~/"
				+ "/~ and t.JBR = '[jbr]' ~/"
				+ "/~ and t.DEPTNAME = '[deptname]' ~/"
				+ "/~ and t.cpcode = '[cpcode]' ~/"
				+ "/~ and t.FULLNAME = '[fullname]' ~/"
				+ "/~ and t.DEPTSEQ like {deptSeq}||'%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	

	
	
	

}
