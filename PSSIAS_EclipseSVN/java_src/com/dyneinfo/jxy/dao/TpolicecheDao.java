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
import org.springframework.dao.EmptyResultDataAccessException;
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
public class TpolicecheDao extends BaseSpringJdbcDao<Tpoliceche,Long>{
	
	public Class getEntityClass() {
		return Tpoliceche.class;
	}
	
	public String getIdentifierPropertyName() {
		return "checkid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CHECKID as checkid,"
				+" DEPTID as deptid,"
				+" ACCEPTCHECKNAME as acceptcheckname,"
				+" CHECKNAME1 as checkname1,"
				+" CHECKNAMEPHONE as checknamephone,"
				+" CHECKTIME as checktime,"
				+" CHECKNAME2 as checkname2,"
				+" ENTERING as entering,"
				+" VISITOR as visitor,"
				+" DUTY as duty,"
				+" FINANCE as finance,"
				+" SPEECH as speech,"
				+" IMPLEMENT as implement,"
				+" IMPLEMENT_INPUT as implementInput,"
				+" VISITOR_INPUT as visitorInput,"
				+" DUTY_INPUT as dutyInput,"
				+" FINANCE_INPUT as financeInput,"
				+" SPEECH_INPUT as speechInput,"
				+" ENTERING_INPUT as enteringInput,"
				+" SYSTEM_NORMAL_USE as systemNormalUse,"
				+" SYSTEM_INPUT as systemInput,"
				+" INTRADAYNEWS as intradaynews,"
				+" INTRADAYNEWS_INPUT as intradaynewsInput,"
				+" JDCMAINTAIN as jdcmaintain,"
				+" JDCMAINTAIN_INPUT as jdcmaintainInput,"
				+" UPLOADQUANTITYIS as uploadquantityis,"
				+" UPLOADQUANTITYI_INPUT as uploadquantityiInput,"
				+" UPLOADTIMELY as uploadtimely,"
				+" UPLOADTIMELY_INPUT as uploadtimelyInput,"
				+" SAFETY as safety,"
				+" SAFETY_INPUT as safetyInput,"
				+" PROTECTION as protection,"
				+" PROTECTION_INPUT as protectionInput,"
				+" DISPOSE as dispose,"
				+" EXAMINE as examine,"
				+" COMPANYINFO as companyinfo,"
				+" REMARK as remark,"
				+" DEADLINE as deadline"
				+" from T_POLICE_CHECK ";
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
	
	public void save(Tpoliceche entity) {
		String sql = "insert into T_POLICE_CHECK " 
			 + " (CHECKID,cpcode,DEPTID,ACCEPTCHECKNAME,CHECKNAME1,CHECKNAMEPHONE,CHECKTIME,CHECKNAME2,ENTERING,VISITOR,DUTY,FINANCE,SPEECH,IMPLEMENT,IMPLEMENT_INPUT,VISITOR_INPUT,DUTY_INPUT,FINANCE_INPUT,SPEECH_INPUT,ENTERING_INPUT,SYSTEM_NORMAL_USE,SYSTEM_INPUT,INTRADAYNEWS,INTRADAYNEWS_INPUT,JDCMAINTAIN,JDCMAINTAIN_INPUT,UPLOADQUANTITYIS,UPLOADQUANTITYI_INPUT,UPLOADTIMELY,UPLOADTIMELY_INPUT,SAFETY,SAFETY_INPUT,PROTECTION,PROTECTION_INPUT,DISPOSE,EXAMINE,COMPANYINFO,REMARK,DEADLINE) " 
			 + " values "
			 + " (:checkid,:cpcode,:deptid,:acceptcheckname,:checkname1,:checknamephone,:checktime,:checkname2,:entering,:visitor,:duty,:finance,:speech,:implement,:implementInput,:visitorInput,:dutyInput,:financeInput,:speechInput,:enteringInput,:systemNormalUse,:systemInput,:intradaynews,:intradaynewsInput,:jdcmaintain,:jdcmaintainInput,:uploadquantityis,:uploadquantityiInput,:uploadtimely,:uploadtimelyInput,:safety,:safetyInput,:protection,:protectionInput,:dispose,:examine,:companyinfo,:remark,:deadline)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tpoliceche entity) {
		String sql = "update T_POLICE_CHECK set "
					+ " CHECKID=:checkid,DEPTID=:deptid,ACCEPTCHECKNAME=:acceptcheckname,CHECKNAME1=:checkname1,CHECKNAMEPHONE=:checknamephone,CHECKTIME=:checktime,CHECKNAME2=:checkname2,ENTERING=:entering,VISITOR=:visitor,DUTY=:duty,FINANCE=:finance,SPEECH=:speech,IMPLEMENT=:implement,IMPLEMENT_INPUT=:implementInput,VISITOR_INPUT=:visitorInput,DUTY_INPUT=:dutyInput,FINANCE_INPUT=:financeInput,SPEECH_INPUT=:speechInput,ENTERING_INPUT=:enteringInput,SYSTEM_NORMAL_USE=:systemNormalUse,SYSTEM_INPUT=:systemInput,INTRADAYNEWS=:intradaynews,INTRADAYNEWS_INPUT=:intradaynewsInput,JDCMAINTAIN=:jdcmaintain,JDCMAINTAIN_INPUT=:jdcmaintainInput,UPLOADQUANTITYIS=:uploadquantityis,UPLOADQUANTITYI_INPUT=:uploadquantityiInput,UPLOADTIMELY=:uploadtimely,UPLOADTIMELY_INPUT=:uploadtimelyInput,SAFETY=:safety,SAFETY_INPUT=:safetyInput,PROTECTION=:protection,PROTECTION_INPUT=:protectionInput,DISPOSE=:dispose,EXAMINE=:examine,COMPANYINFO=:companyinfo,REMARK=:remark,DEADLINE=:deadline "
					+ " where CHECKID=:checkid";
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
				+ "/~ and t.DEPTID like '%[deptid]%' ~/"
				+ "/~ and t.cpcode = '[cpcode]' ~/"
				+ "/~ and t.checktime >= to_date('[s_checktimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss') ~/"
				+ "/~ and t.checktime <=  to_date('[s_checktimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')~/"
				+ "/~ and t.DEADLINE >= to_date('[s_deadlineBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss') ~/"
				+ "/~ and t.DEADLINE <=  to_date('[s_deadlineEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')~/"				
				+ "/~ and t.ACCEPTCHECKNAME like '%[acceptcheckname]%' ~/"
				+ "/~ and t.CHECKNAME1 like '%[checkname1]%' ~/"
				+ "/~ and t.CHECKNAME2 like '%[checkname2]%' ~/"
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
	
	
	private String createSql = "insert into T_POLICE_CHECK " 
		 + " (CHECKID,DEPTID,ACCEPTCHECKNAME,CHECKNAME1,CHECKNAMEPHONE,CHECKTIME,CHECKNAME2,ENTERING,VISITOR,DUTY,FINANCE,SPEECH,IMPLEMENT,IMPLEMENT_INPUT,VISITOR_INPUT,DUTY_INPUT,FINANCE_INPUT,SPEECH_INPUT,ENTERING_INPUT,SYSTEM_NORMAL_USE,SYSTEM_INPUT,INTRADAYNEWS,INTRADAYNEWS_INPUT,JDCMAINTAIN,JDCMAINTAIN_INPUT,UPLOADQUANTITYIS,UPLOADQUANTITYI_INPUT,UPLOADTIMELY,UPLOADTIMELY_INPUT,SAFETY,SAFETY_INPUT,PROTECTION,PROTECTION_INPUT,DISPOSE,EXAMINE,COMPANYINFO,REMARK,DEADLINE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_POLICE_CHECK set "
		+ " CHECKID=?,DEPTID=?,ACCEPTCHECKNAME=?,CHECKNAME1=?,CHECKNAMEPHONE=?,CHECKTIME=?,CHECKNAME2=?,ENTERING=?,VISITOR=?,DUTY=?,FINANCE=?,SPEECH=?,IMPLEMENT=?,IMPLEMENT_INPUT=?,VISITOR_INPUT=?,DUTY_INPUT=?,FINANCE_INPUT=?,SPEECH_INPUT=?,ENTERING_INPUT=?,SYSTEM_NORMAL_USE=?,SYSTEM_INPUT=?,INTRADAYNEWS=?,INTRADAYNEWS_INPUT=?,JDCMAINTAIN=?,JDCMAINTAIN_INPUT=?,UPLOADQUANTITYIS=?,UPLOADQUANTITYI_INPUT=?,UPLOADTIMELY=?,UPLOADTIMELY_INPUT=?,SAFETY=?,SAFETY_INPUT=?,PROTECTION=?,PROTECTION_INPUT=?,DISPOSE=?,EXAMINE=?,COMPANYINFO=?,REMARK=?,DEADLINE=? "
		+ " where CHECKID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
public String count(String userid){
//String sql = "select count(*) from ss_role_user where roleid='221' and userid= ?";
String sql ="select count(*) from ss_role role, ss_role_user  ss where role.roleid=ss.roleid and  role.roledesc = '民警检查' and ss.userid = ?";
Object[] obj ={userid};
String currentMaxID = null;
try {
 currentMaxID = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class);
} catch (EmptyResultDataAccessException ex) {
	logger
			.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
}
return currentMaxID;
}
public String username(String userid){
	String sql = "select userid from ss_user where  username= ?";
	Object[] obj ={userid};
	String currentMaxID = null;
	try {
	 currentMaxID = (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class);
	} catch (EmptyResultDataAccessException ex) {
		logger
				.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
	}
	return currentMaxID;
	}
	
	

}
