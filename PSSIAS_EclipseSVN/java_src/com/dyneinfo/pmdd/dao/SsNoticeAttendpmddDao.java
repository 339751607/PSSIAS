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
public class SsNoticeAttendpmddDao extends BaseSpringJdbcDao<SsNoticeAttend,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsNoticeAttend.class;
	}
	
	public String getIdentifierPropertyName() {
		return "attendid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ATTENDID as attendid,"
				+" NOTICEID as noticeid,"
				+" USERID as userid,"
				+" DEPTID as deptid,"
				+" ISDEPT as isdept"
				+" from SS_NOTICE_ATTEND ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_NOTICE_ATTEND where ATTENDID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ATTENDID=? ";
	}
	
	public void save(SsNoticeAttend entity) {
		String sql = "insert into SS_NOTICE_ATTEND " 
			 + " (ATTENDID,NOTICEID,USERID,DEPTID,ISDEPT) " 
			 + " values "
			 + " (:attendid,:noticeid,:userid,:deptid,:isdept)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_NOTICE_ATTEND",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsNoticeAttend entity) {
		String sql = "update SS_NOTICE_ATTEND set "
					+ " ATTENDID=:attendid,NOTICEID=:noticeid,USERID=:userid,DEPTID=:deptid,ISDEPT=:isdept "
					+ " where ATTENDID=:attendid";
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
				+ "/~ and t.NOTICEID = '[noticeid]' ~/"
				+ "/~ and t.USERID = '[userid]' ~/"
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and t.ISDEPT = '[isdept]' ~/"
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
	//通知 参与人员
	public void deleteParticipants(Long noticeid) {
		getJdbcTemplate().update(" delete from SS_NOTICE_ATTEND where NOTICEID =? and  ISDEPT =  0 ", new Object[] { noticeid });
	}
	//发布范围（单位） 
	public void deleteIssuescope(Long noticeid) {
		getJdbcTemplate().update(" delete from SS_NOTICE_ATTEND where NOTICEID =? and  ISDEPT =  1 ", new Object[] { noticeid });
	}
	
	
	
	

}
