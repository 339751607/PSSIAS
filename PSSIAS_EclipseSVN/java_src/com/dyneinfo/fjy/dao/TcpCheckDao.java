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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;


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
public class TcpCheckDao extends BaseSpringJdbcDao<TcpCheck,java.lang.Long>{
	
	public Class getEntityClass() {
		return TcpCheck.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.ID as id,"
				+" t.DEPTID as deptid,"
				+" t.IDCARD as idcard,"
				+" t.CHECKTIME as checktime,"
				+" b.deptname as deptname, "
				+" t.DEMO as demo"
				+" from T_CP_CHECK ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CP_CHECK where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " t,ss_dept b where t.deptid = b.deptid and ID=? ";
	}
	
	public void save(TcpCheck entity) {
		String sql = "insert into T_CP_CHECK " 
			 + " (ID,DEPTID,IDCARD,CHECKTIME,DEMO) " 
			 + " values "
			 + " (:id,:deptid,:idcard,:checktime,:demo)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CP_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	

	
	public void saveTcpCheckInfo(TcpCheckInfo entity) {
		String sql = "insert into T_CP_CHECK_INFO " 
			 + " (ID,CHECKID,ITEM,DETAIL) " 
			 + " values "
			 + " (:id,:checkid,:item,:detail)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CP_CHECK_INFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	
	public void update(TcpCheck entity) {
		String sql = "update T_CP_CHECK set "
					+ " ID=:id,DEPTID=:deptid,IDCARD=:idcard,CHECKTIME=:checktime,DEMO=:demo "
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
		String sql = getSelectPrefix() + "  t,ss_dept b where t.deptid = b.deptid  "
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and t.IDCARD = '[idcard]' ~/"
				+ "/~ and t.CHECKTIME >= '[checktimeBeginFormat]' ~/"
				+ "/~ and t.CHECKTIME <= '[checktimeEndFormat]' ~/"
				+ "/~ and b.DEPTSEQ like {deptSeq}||'%' ~/"
				+ "/~ and t.DEMO = '[demo]' ~/"
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
	
	
	public Long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_T_CP_CHECK");
		Long id = seq.nextLongValue();
        return id;
	}

//	public int getCountByIdcard(String idcard) {
//		String sql = "select count(*) from T_CP_CHECK  where IDCARD=?  ";
//		int  totalCount = 0;
//		try {   
//			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {idcard} );  	 
//		} catch (EmptyResultDataAccessException ex) {   
//			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
//			       }   
//		return totalCount;
//	}
	
	

}
