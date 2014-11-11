/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class tpoliCkDao extends BaseSpringJdbcDao<tpoliCk,java.lang.String>{
	
	public Class getEntityClass() {
		return tpoliCk.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		
		
		
		return "select  "
		+" t.CHECKID as checkid,"
		+" t.DEPTID as deptid,"
		+" t.ACCEPTCHECKNAME as acceptcheckname,"
		+" t.CHECKNAME1 as checkname1,"
		+" t.CHECKNAMEPHONE as checknamephone,"
		+" t.CHECKTIME as checktime,"
		+" t.CHECKNAME2 as checkname2,"
		+" t.ENTERING as entering,"
		+" t.VISITOR as visitor,"
		+" t.DUTY as duty,"
		+" t.FINANCE as finance,"
		+" t.SPEECH as speech,"
		+" t.IMPLEMENT as implement,"
		+" t.IMPLEMENT_INPUT as implementInput,"
		+" t.VISITOR_INPUT as visitorInput,"
		+" t.DUTY_INPUT as dutyInput,"
		+" t.FINANCE_INPUT as financeInput,"
		+" t.SPEECH_INPUT as speechInput,"
		+" t.ENTERING_INPUT as enteringInput,"
		+" t.SYSTEM_NORMAL_USE as systemNormalUse,"
		+" t.SYSTEM_INPUT as systemInput,"
		+" t.INTRADAYNEWS as intradaynews,"
		+" t.INTRADAYNEWS_INPUT as intradaynewsInput,"
		+" t.JDCMAINTAIN as jdcmaintain,"
		+" t.JDCMAINTAIN_INPUT as jdcmaintainInput,"
		+" t.UPLOADQUANTITYIS as uploadquantityis,"
		+" t.UPLOADQUANTITYI_INPUT as uploadquantityiInput,"
		+" t.UPLOADTIMELY as uploadtimely,"
		+" t.UPLOADTIMELY_INPUT as uploadtimelyInput,"
		+" t.SAFETY as safety,"
		+" t.SAFETY_INPUT as safetyInput,"
		+" t.PROTECTION as protection,"
		+" t.PROTECTION_INPUT as protectionInput,"
		+" t.DISPOSE as dispose,"
		+" t.EXAMINE as examine,"
		+" t.COMPANYINFO as companyinfo,"
		+" t.REMARK as remark,"
		+" t.DEADLINE as deadline"
		+" from T_POLICE_CHECK t ,ss_dept ss";
}
		
		
		
		
		
		
		

	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_POLICECHECK where USERNAME=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where USERNAME=? ";
	}
	
	public void save(tpoliCk entity) {
		String sql = "insert into T_POLICECHECK " 
			 + " (USERNAME,CHECKDATE,CHECKUSER,CHECKREMARK,CPCODE) " 
			 + " values "
			 + " (:username,:checkdate,:checkuser,:checkremark,:cpcode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_POLICECHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(tpoliCk entity) {
		String sql = "update T_POLICECHECK set "
					+ " USERNAME=:username,CHECKDATE=:checkdate,CHECKUSER=:checkuser,CHECKREMARK=:checkremark,CPCODE=:cpcode "
					+ " where USERNAME=:username";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		
		
		String sql = getSelectPrefix() + "  where 1=1 and t.cpcode = ss.deptid "
				+ "/~ and ss.deptSeq like '[deptSeq]%' ~/"
				+ "/~ and t.DEPTID = '[deptid]' ~/"
				+ "/~ and ss.deptseq like '[deptseq]%' ~/"
				+ "/~ and t.ACCEPTCHECKNAME like '%[acceptcheckname]%' ~/"
				+ "/~ and t.CHECKNAME1 like '%[checkname1]%' ~/"
				+ "/~ and t.CHECKNAME2 like '%[checkname2]%' ~/"
				+ "/~ and t.checktime >= to_date('[s_checktimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss') ~/"
				+ "/~ and t.checktime <=  to_date('[s_checktimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')~/"
				+ "/~ and t.DEADLINE >= to_date('[s_deadlineBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss') ~/"
				+ "/~ and t.DEADLINE <=  to_date('[s_deadlineEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')~/"
			
				+ "/~ and t.DISPOSE = '[dispose]' ~/"
				+ "/~ and t.EXAMINE = '[examine]' ~/"
				+ "/~ and t.COMPANYINFO like '%[companyinfo]%' ~/"
				
				
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
	
	
	private String createSql = "insert into T_POLICECHECK " 
		 + " (USERNAME,CHECKDATE,CHECKUSER,CHECKREMARK,CPCODE) " 
		 + " values "
		 + " (?,?,?,?,?)";
	private String updateSql = "update T_POLICECHECK set "
		+ " USERNAME=?,CHECKDATE=?,CHECKUSER=?,CHECKREMARK=?,CPCODE=? "
		+ " where USERNAME=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	
	
	public void deletetpoliCk(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
