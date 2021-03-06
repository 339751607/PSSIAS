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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
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
public class TpoliceCheckpmddDao extends BaseSpringJdbcDao<TpoliceCheck,Long>{
	
	public Class getEntityClass() {
		return TpoliceCheck.class;
	}
	
	public String getIdentifierPropertyName() {
		return "checkid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CHECKID as checkid,"
				+" DEPTID as deptid,"
				+" ACCEPTCHECKNAME as acceptcheckname,"
				+" CHECKNAME as checkname,"
				+" CHECKNAMEPHONE as checknamephone,"
				+" CHECKTIME as checktime"
				+" from T_POLICE_CHECK ";
	}
	
	

	
	public TpoliceCheck getTpoliceCheckById(java.lang.Long checkid) {
		String sql =	"select  "
			+" a.CHECKID as checkid,"
			+" a.DEPTID as deptid,"
			+" a.ACCEPTCHECKNAME as acceptcheckname,"
			+" a.CHECKNAME as checkname,"
			+" a.CHECKNAMEPHONE as checknamephone,"
			+" a.CHECKTIME as checktime,"
			+" b.deptname as deptname "
			+" from T_POLICE_CHECK a,ss_dept b  " 
			+" where a.deptid = b.deptid  " +
			"  and a.CHECKID = ? ";

			TpoliceCheck policeCheck = null;
		try {   
			policeCheck = (TpoliceCheck)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {checkid});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return policeCheck;
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_POLICE_CHECK where CHECKID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where CHECKID=? ";
	}
	
	public void save(TpoliceCheck entity) {
		String sql = "insert into T_POLICE_CHECK " 
			 + " (CHECKID,DEPTID,ACCEPTCHECKNAME,CHECKNAME,CHECKNAMEPHONE,CHECKTIME) " 
			 + " values "
			 + " (:checkid,:deptid,:acceptcheckname,:checkname,:checknamephone,:checktime)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	
	
	public void saveTpoliceCheckinfo(TpoliceCheckinfo entity) {
		String sql = "insert into T_POLICE_CHECKINFO " 
			 + " (CHECKINFOID,CHECKID,ITEM,DETAIL) " 
			 + " values "
			 + " (:checkinfoid,:checkid,:item,:detail)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECKINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	
	public void saveTpoliceCheck(TpoliceCheck entity) {
		String sql = "insert into T_POLICE_CHECK " 
			 + " (CHECKID,DEPTID,ACCEPTCHECKNAME,CHECKNAME,CHECKNAMEPHONE,CHECKTIME) " 
			 + " values "
			 + " (:checkid,:deptid,:acceptcheckname,:checkname,:checknamephone,:checktime)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_T_POLICE_CHECK");
		Long id = seq.nextLongValue();
        return id;
	}
	
	public long  getSeqCheckinfo(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_T_POLICE_CHECKINFO");
		Long id = seq.nextLongValue();
        return id;
	}

	
	
	public void update(TpoliceCheck entity) {
		String sql = "update T_POLICE_CHECK set "
					+ " CHECKID=:checkid,DEPTID=:deptid,ACCEPTCHECKNAME=:acceptcheckname,CHECKNAME=:checkname,CHECKNAMEPHONE=:checknamephone,CHECKTIME=:checktime "
					+ " where CHECKID=:checkid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		
		String querySql =	"select  "
			+" a.CHECKID as checkid,"
			+" a.DEPTID as deptid,"
			+" a.ACCEPTCHECKNAME as acceptcheckname,"
			+" a.CHECKNAME1 as checkname,"
			+" a.CHECKNAMEPHONE as checknamephone,"
			+" a.CHECKTIME as checktime,"
			+" b.deptname as deptname "
			+" from T_POLICE_CHECK a,ss_dept b " +
			" where a.deptid = b.deptid  ";
		

		String sql = querySql + "  "
		+ "/~ and a.DEPTID = '[deptid]' ~/"
		+ "/~ and b.DEPTSEQ like {deptSeq}||'%' ~/"
		+ "/~ and a.CHECKNAME1 like '%[checkname]%' ~/"
		+ "/~ and a.acceptcheckname like '%[acceptcheckname]%' ~/"
		+ "/~ and a.CHECKNAMEPHONE = '[checknamephone]' ~/"
		+ "/~ and b.deptname like '%[deptname]%' ~/"
		+ "/~ and a.CHECKTIME >= to_date('[checktimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/"
		+ "/~ and a.CHECKTIME <= to_date('[checktimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/"
		+ " order by a.checktime desc ";
		return pageQuery(sql,pageRequest);
	}

}
