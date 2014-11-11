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
public class TpolicechepmddDao extends BaseSpringJdbcDao<Tpoliceche,Long>{
	
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
				+" DEADLINE as deadline,"
				+" CPCODE as cpcode,"
				+" XFSS as xfss,"
				+" XFSS_INPUT as xfssInput,"
				+" DPYZ as dpyz,"
				+" DPYZ_INPUT as dpyzInput,"
				+" FLFG as flfg,"
				+" FLFG_INPUT as flfgInput"
				+" from T_POLICE_CHECK ";
	}
	
	public String getSelectPrefix_ht() {
		return "select  "
				+" CHECKID as checkid,"
				+" t.DEPTID as deptid,"
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
				+" DEADLINE as deadline,"
				+" CPCODE as cpcode,"
				+" XFSS as xfss,"
				+" XFSS_INPUT as xfssInput,"
				+" DPYZ as dpyz,"
				+" DPYZ_INPUT as dpyzInput,"
				+" FLFG as flfg,"
				+" FLFG_INPUT as flfgInput"
				+" from ss_dept d ,T_POLICE_CHECK ";
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
			 + " (CHECKID,DEPTID,ACCEPTCHECKNAME,CHECKNAME1,CHECKNAMEPHONE,CHECKTIME,CHECKNAME2,ENTERING,VISITOR,DUTY,FINANCE,SPEECH,IMPLEMENT,IMPLEMENT_INPUT,VISITOR_INPUT,DUTY_INPUT,FINANCE_INPUT,SPEECH_INPUT,ENTERING_INPUT,SYSTEM_NORMAL_USE,SYSTEM_INPUT,INTRADAYNEWS,INTRADAYNEWS_INPUT,JDCMAINTAIN,JDCMAINTAIN_INPUT,UPLOADQUANTITYIS,UPLOADQUANTITYI_INPUT,UPLOADTIMELY,UPLOADTIMELY_INPUT,SAFETY,SAFETY_INPUT,PROTECTION,PROTECTION_INPUT,DISPOSE,EXAMINE,COMPANYINFO,REMARK,DEADLINE,CPCODE,XFSS,XFSS_INPUT,DPYZ,DPYZ_INPUT,FLFG,FLFG_INPUT) " 
			 + " values "
			 + " (:checkid,:deptid,:acceptcheckname,:checkname1,:checknamephone,:checktime,:checkname2,:entering,:visitor,:duty,:finance,:speech,:implement,:implementInput,:visitorInput,:dutyInput,:financeInput,:speechInput,:enteringInput,:systemNormalUse,:systemInput,:intradaynews,:intradaynewsInput,:jdcmaintain,:jdcmaintainInput,:uploadquantityis,:uploadquantityiInput,:uploadtimely,:uploadtimelyInput,:safety,:safetyInput,:protection,:protectionInput,:dispose,:examine,:companyinfo,:remark,:deadline,:cpcode,:xfss,:xfssInput,:dpyz,:dpyzInput,:flfg,:flfgInput)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tpoliceche entity) {
		String sql = "update T_POLICE_CHECK set "
					+ " CHECKID=:checkid,DEPTID=:deptid,ACCEPTCHECKNAME=:acceptcheckname,CHECKNAME1=:checkname1,CHECKNAMEPHONE=:checknamephone,CHECKTIME=:checktime,CHECKNAME2=:checkname2,ENTERING=:entering,VISITOR=:visitor,DUTY=:duty,FINANCE=:finance,SPEECH=:speech,IMPLEMENT=:implement,IMPLEMENT_INPUT=:implementInput,VISITOR_INPUT=:visitorInput,DUTY_INPUT=:dutyInput,FINANCE_INPUT=:financeInput,SPEECH_INPUT=:speechInput,ENTERING_INPUT=:enteringInput,SYSTEM_NORMAL_USE=:systemNormalUse,SYSTEM_INPUT=:systemInput,INTRADAYNEWS=:intradaynews,INTRADAYNEWS_INPUT=:intradaynewsInput,JDCMAINTAIN=:jdcmaintain,JDCMAINTAIN_INPUT=:jdcmaintainInput,UPLOADQUANTITYIS=:uploadquantityis,UPLOADQUANTITYI_INPUT=:uploadquantityiInput,UPLOADTIMELY=:uploadtimely,UPLOADTIMELY_INPUT=:uploadtimelyInput,SAFETY=:safety,SAFETY_INPUT=:safetyInput,PROTECTION=:protection,PROTECTION_INPUT=:protectionInput,DISPOSE=:dispose,EXAMINE=:examine,COMPANYINFO=:companyinfo,REMARK=:remark,DEADLINE=:deadline,CPCODE=:cpcode,XFSS=:xfss,XFSS_INPUT=:xfssInput,DPYZ=:dpyz,DPYZ_INPUT=:dpyzInput,FLFG=:flfg,FLFG_INPUT=:flfgInput "
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
//		String sql = getSelectPrefix() + " t where 1=1 "
//				+ "/~ and t.DEPTID = '[deptid]' ~/"
//				+ "/~ and t.ACCEPTCHECKNAME = '[acceptcheckname]' ~/"
//				+ "/~ and t.CHECKNAME1 = '[checkname1]' ~/"
//				+ "/~ and t.CHECKNAMEPHONE = '[checknamephone]' ~/"
//				+ "/~ and t.CHECKTIME = '[checktime]' ~/"
//				+ "/~ and t.CHECKNAME2 = '[checkname2]' ~/"
//				+ "/~ and t.ENTERING = '[entering]' ~/"
//				+ "/~ and t.VISITOR = '[visitor]' ~/"
//				+ "/~ and t.DUTY = '[duty]' ~/"
//				+ "/~ and t.FINANCE = '[finance]' ~/"
//				+ "/~ and t.SPEECH = '[speech]' ~/"
//				+ "/~ and t.IMPLEMENT = '[implement]' ~/"
//				+ "/~ and t.IMPLEMENT_INPUT = '[implementInput]' ~/"
//				+ "/~ and t.VISITOR_INPUT = '[visitorInput]' ~/"
//				+ "/~ and t.DUTY_INPUT = '[dutyInput]' ~/"
//				+ "/~ and t.FINANCE_INPUT = '[financeInput]' ~/"
//				+ "/~ and t.SPEECH_INPUT = '[speechInput]' ~/"
//				+ "/~ and t.ENTERING_INPUT = '[enteringInput]' ~/"
//				+ "/~ and t.SYSTEM_NORMAL_USE = '[systemNormalUse]' ~/"
//				+ "/~ and t.SYSTEM_INPUT = '[systemInput]' ~/"
//				+ "/~ and t.INTRADAYNEWS = '[intradaynews]' ~/"
//				+ "/~ and t.INTRADAYNEWS_INPUT = '[intradaynewsInput]' ~/"
//				+ "/~ and t.JDCMAINTAIN = '[jdcmaintain]' ~/"
//				+ "/~ and t.JDCMAINTAIN_INPUT = '[jdcmaintainInput]' ~/"
//				+ "/~ and t.UPLOADQUANTITYIS = '[uploadquantityis]' ~/"
//				+ "/~ and t.UPLOADQUANTITYI_INPUT = '[uploadquantityiInput]' ~/"
//				+ "/~ and t.UPLOADTIMELY = '[uploadtimely]' ~/"
//				+ "/~ and t.UPLOADTIMELY_INPUT = '[uploadtimelyInput]' ~/"
//				+ "/~ and t.SAFETY = '[safety]' ~/"
//				+ "/~ and t.SAFETY_INPUT = '[safetyInput]' ~/"
//				+ "/~ and t.PROTECTION = '[protection]' ~/"
//				+ "/~ and t.PROTECTION_INPUT = '[protectionInput]' ~/"
//				+ "/~ and t.DISPOSE = '[dispose]' ~/"
//				+ "/~ and t.EXAMINE = '[examine]' ~/"
//				+ "/~ and t.COMPANYINFO = '[companyinfo]' ~/"
//				+ "/~ and t.REMARK = '[remark]' ~/"
//				+ "/~ and t.DEADLINE = '[deadline]' ~/"
//				+ "/~ and t.CPCODE = '[cpcode]' ~/"
//				+ "/~ and t.XFSS = '[xfss]' ~/"
//				+ "/~ and t.XFSS_INPUT = '[xfssInput]' ~/"
//				+ "/~ and t.DPYZ = '[dpyz]' ~/"
//				+ "/~ and t.DPYZ_INPUT = '[dpyzInput]' ~/"
//				+ "/~ and t.FLFG = '[flfg]' ~/"
//				+ "/~ and t.FLFG_INPUT = '[flfgInput]' ~/"
//				+ "/~ order by [sortColumns] ~/";
//		return pageQuery(sql,pageRequest);
		String sql = getSelectPrefix() + " t where 1=1 "
		+ "/~ and t.DEPTID like '%[deptid]%' ~/"
		+ "/~ and t.cpcode = '[cpcode]' ~/"
		+ "/~ and t.checktime >= to_date('[s_checktimeBegin]','yyyy-MM-dd HH24:mi:ss') ~/"
		+ "/~ and t.checktime <=  to_date('[s_checktimeEnd]','yyyy-MM-dd HH24:mi:ss')~/"
		+ "/~ and t.DEADLINE >= to_date('[s_deadlineBegin]','yyyy-MM-dd HH24:mi:ss') ~/"
		+ "/~ and t.DEADLINE <=  to_date('[s_deadlineEnd]','yyyy-MM-dd HH24:mi:ss')~/"				
		+ "/~ and t.ACCEPTCHECKNAME like '%[acceptcheckname]%' ~/"
		+ "/~ and t.CHECKNAME1 like '%[checkname1]%' ~/"
		+ "/~ and t.CHECKNAME2 like '%[checkname2]%' ~/"
		+ "/~ and t.DISPOSE = '[dispose]' ~/"
		+ "/~ and t.EXAMINE = '[examine]' ~/"
		+ "/~ and t.COMPANYINFO like '%[companyinfo]%' ~/"
		+ "/~ order by [sortColumns] ~/";
      return pageQuery(sql,pageRequest);
	}
	
	
	public Page findByPageRequest_ht(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
//		String sql = getSelectPrefix() + " t where 1=1 "
//				+ "/~ and t.DEPTID = '[deptid]' ~/"
//				+ "/~ and t.ACCEPTCHECKNAME = '[acceptcheckname]' ~/"
//				+ "/~ and t.CHECKNAME1 = '[checkname1]' ~/"
//				+ "/~ and t.CHECKNAMEPHONE = '[checknamephone]' ~/"
//				+ "/~ and t.CHECKTIME = '[checktime]' ~/"
//				+ "/~ and t.CHECKNAME2 = '[checkname2]' ~/"
//				+ "/~ and t.ENTERING = '[entering]' ~/"
//				+ "/~ and t.VISITOR = '[visitor]' ~/"
//				+ "/~ and t.DUTY = '[duty]' ~/"
//				+ "/~ and t.FINANCE = '[finance]' ~/"
//				+ "/~ and t.SPEECH = '[speech]' ~/"
//				+ "/~ and t.IMPLEMENT = '[implement]' ~/"
//				+ "/~ and t.IMPLEMENT_INPUT = '[implementInput]' ~/"
//				+ "/~ and t.VISITOR_INPUT = '[visitorInput]' ~/"
//				+ "/~ and t.DUTY_INPUT = '[dutyInput]' ~/"
//				+ "/~ and t.FINANCE_INPUT = '[financeInput]' ~/"
//				+ "/~ and t.SPEECH_INPUT = '[speechInput]' ~/"
//				+ "/~ and t.ENTERING_INPUT = '[enteringInput]' ~/"
//				+ "/~ and t.SYSTEM_NORMAL_USE = '[systemNormalUse]' ~/"
//				+ "/~ and t.SYSTEM_INPUT = '[systemInput]' ~/"
//				+ "/~ and t.INTRADAYNEWS = '[intradaynews]' ~/"
//				+ "/~ and t.INTRADAYNEWS_INPUT = '[intradaynewsInput]' ~/"
//				+ "/~ and t.JDCMAINTAIN = '[jdcmaintain]' ~/"
//				+ "/~ and t.JDCMAINTAIN_INPUT = '[jdcmaintainInput]' ~/"
//				+ "/~ and t.UPLOADQUANTITYIS = '[uploadquantityis]' ~/"
//				+ "/~ and t.UPLOADQUANTITYI_INPUT = '[uploadquantityiInput]' ~/"
//				+ "/~ and t.UPLOADTIMELY = '[uploadtimely]' ~/"
//				+ "/~ and t.UPLOADTIMELY_INPUT = '[uploadtimelyInput]' ~/"
//				+ "/~ and t.SAFETY = '[safety]' ~/"
//				+ "/~ and t.SAFETY_INPUT = '[safetyInput]' ~/"
//				+ "/~ and t.PROTECTION = '[protection]' ~/"
//				+ "/~ and t.PROTECTION_INPUT = '[protectionInput]' ~/"
//				+ "/~ and t.DISPOSE = '[dispose]' ~/"
//				+ "/~ and t.EXAMINE = '[examine]' ~/"
//				+ "/~ and t.COMPANYINFO = '[companyinfo]' ~/"
//				+ "/~ and t.REMARK = '[remark]' ~/"
//				+ "/~ and t.DEADLINE = '[deadline]' ~/"
//				+ "/~ and t.CPCODE = '[cpcode]' ~/"
//				+ "/~ and t.XFSS = '[xfss]' ~/"
//				+ "/~ and t.XFSS_INPUT = '[xfssInput]' ~/"
//				+ "/~ and t.DPYZ = '[dpyz]' ~/"
//				+ "/~ and t.DPYZ_INPUT = '[dpyzInput]' ~/"
//				+ "/~ and t.FLFG = '[flfg]' ~/"
//				+ "/~ and t.FLFG_INPUT = '[flfgInput]' ~/"
//				+ "/~ order by [sortColumns] ~/";
//		return pageQuery(sql,pageRequest);
		String sql = getSelectPrefix_ht() + " t where 1=1 "
		+"and d.deptid=cpcode"
		+ "/~ and d.deptseq like '%[cpcode]%' ~/"
		//+ "/~ and t.cpcode = '[cpcode]' ~/"
		+ "/~ and t.checktime >= to_date('[s_checktimeBegin]','yyyy-MM-dd HH24:mi:ss') ~/"
		+ "/~ and t.checktime <=  to_date('[s_checktimeEnd]','yyyy-MM-dd HH24:mi:ss')~/"
		+ "/~ and t.DEADLINE >= to_date('[s_deadlineBegin]','yyyy-MM-dd HH24:mi:ss') ~/"
		+ "/~ and t.DEADLINE <=  to_date('[s_deadlineEnd]','yyyy-MM-dd HH24:mi:ss')~/"				
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
		 + " (CHECKID,DEPTID,ACCEPTCHECKNAME,CHECKNAME1,CHECKNAMEPHONE,CHECKTIME,CHECKNAME2,ENTERING,VISITOR,DUTY,FINANCE,SPEECH,IMPLEMENT,IMPLEMENT_INPUT,VISITOR_INPUT,DUTY_INPUT,FINANCE_INPUT,SPEECH_INPUT,ENTERING_INPUT,SYSTEM_NORMAL_USE,SYSTEM_INPUT,INTRADAYNEWS,INTRADAYNEWS_INPUT,JDCMAINTAIN,JDCMAINTAIN_INPUT,UPLOADQUANTITYIS,UPLOADQUANTITYI_INPUT,UPLOADTIMELY,UPLOADTIMELY_INPUT,SAFETY,SAFETY_INPUT,PROTECTION,PROTECTION_INPUT,DISPOSE,EXAMINE,COMPANYINFO,REMARK,DEADLINE,CPCODE,XFSS,XFSS_INPUT,DPYZ,DPYZ_INPUT,FLFG,FLFG_INPUT) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_POLICE_CHECK set "
		+ " CHECKID=?,DEPTID=?,ACCEPTCHECKNAME=?,CHECKNAME1=?,CHECKNAMEPHONE=?,CHECKTIME=?,CHECKNAME2=?,ENTERING=?,VISITOR=?,DUTY=?,FINANCE=?,SPEECH=?,IMPLEMENT=?,IMPLEMENT_INPUT=?,VISITOR_INPUT=?,DUTY_INPUT=?,FINANCE_INPUT=?,SPEECH_INPUT=?,ENTERING_INPUT=?,SYSTEM_NORMAL_USE=?,SYSTEM_INPUT=?,INTRADAYNEWS=?,INTRADAYNEWS_INPUT=?,JDCMAINTAIN=?,JDCMAINTAIN_INPUT=?,UPLOADQUANTITYIS=?,UPLOADQUANTITYI_INPUT=?,UPLOADTIMELY=?,UPLOADTIMELY_INPUT=?,SAFETY=?,SAFETY_INPUT=?,PROTECTION=?,PROTECTION_INPUT=?,DISPOSE=?,EXAMINE=?,COMPANYINFO=?,REMARK=?,DEADLINE=?,CPCODE=?,XFSS=?,XFSS_INPUT=?,DPYZ=?,DPYZ_INPUT=?,FLFG=?,FLFG_INPUT=? "
		+ " where CHECKID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
//	public void savePic(File file, final Tpoliceche entity) throws IOException {
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
//		getJdbcTemplate().execute(createSql,
//				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
//					protected void setValues(PreparedStatement ps,
//							LobCreator lobCreator) throws SQLException {
//						ps.setLong(1, entity.getCheckid());
//						ps.setString(2, entity.getDeptid());
//						ps.setString(3, entity.getAcceptcheckname());
//						ps.setString(4, entity.getCheckname1());
//						ps.setString(5, entity.getChecknamephone());
//						ps.setjava.util.Date(6, entity.getChecktime());
//						ps.setString(7, entity.getCheckname2());
//						ps.setString(8, entity.getEntering());
//						ps.setString(9, entity.getVisitor());
//						ps.setString(10, entity.getDuty());
//						ps.setString(11, entity.getFinance());
//						ps.setString(12, entity.getSpeech());
//						ps.setString(13, entity.getImplement());
//						ps.setString(14, entity.getImplementInput());
//						ps.setString(15, entity.getVisitorInput());
//						ps.setString(16, entity.getDutyInput());
//						ps.setString(17, entity.getFinanceInput());
//						ps.setString(18, entity.getSpeechInput());
//						ps.setString(19, entity.getEnteringInput());
//						ps.setString(20, entity.getSystemNormalUse());
//						ps.setString(21, entity.getSystemInput());
//						ps.setString(22, entity.getIntradaynews());
//						ps.setString(23, entity.getIntradaynewsInput());
//						ps.setString(24, entity.getJdcmaintain());
//						ps.setString(25, entity.getJdcmaintainInput());
//						ps.setString(26, entity.getUploadquantityis());
//						ps.setString(27, entity.getUploadquantityiInput());
//						ps.setString(28, entity.getUploadtimely());
//						ps.setString(29, entity.getUploadtimelyInput());
//						ps.setString(30, entity.getSafety());
//						ps.setString(31, entity.getSafetyInput());
//						ps.setString(32, entity.getProtection());
//						ps.setString(33, entity.getProtectionInput());
//						ps.setString(34, entity.getDispose());
//						ps.setString(35, entity.getExamine());
//						ps.setString(36, entity.getCompanyinfo());
//						ps.setString(37, entity.getRemark());
//						ps.setjava.util.Date(38, entity.getDeadline());
//						ps.setString(39, entity.getCpcode());
//						ps.setString(40, entity.getXfss());
//						ps.setString(41, entity.getXfssInput());
//						ps.setString(42, entity.getDpyz());
//						ps.setString(43, entity.getDpyzInput());
//						ps.setString(44, entity.getFlfg());
//						ps.setString(45, entity.getFlfgInput());
//						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
//					}
//				});
//		blobIs.close();
//	}
//	
//	
//	public void createTpoliceche(final Tpoliceche entity) {
//		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setLong(1, entity.getCheckid());
//				ps.setString(2, entity.getDeptid());
//				ps.setString(3, entity.getAcceptcheckname());
//				ps.setString(4, entity.getCheckname1());
//				ps.setString(5, entity.getChecknamephone());
//				ps.setjava.util.Date(6, entity.getChecktime());
//				ps.setString(7, entity.getCheckname2());
//				ps.setString(8, entity.getEntering());
//				ps.setString(9, entity.getVisitor());
//				ps.setString(10, entity.getDuty());
//				ps.setString(11, entity.getFinance());
//				ps.setString(12, entity.getSpeech());
//				ps.setString(13, entity.getImplement());
//				ps.setString(14, entity.getImplementInput());
//				ps.setString(15, entity.getVisitorInput());
//				ps.setString(16, entity.getDutyInput());
//				ps.setString(17, entity.getFinanceInput());
//				ps.setString(18, entity.getSpeechInput());
//				ps.setString(19, entity.getEnteringInput());
//				ps.setString(20, entity.getSystemNormalUse());
//				ps.setString(21, entity.getSystemInput());
//				ps.setString(22, entity.getIntradaynews());
//				ps.setString(23, entity.getIntradaynewsInput());
//				ps.setString(24, entity.getJdcmaintain());
//				ps.setString(25, entity.getJdcmaintainInput());
//				ps.setString(26, entity.getUploadquantityis());
//				ps.setString(27, entity.getUploadquantityiInput());
//				ps.setString(28, entity.getUploadtimely());
//				ps.setString(29, entity.getUploadtimelyInput());
//				ps.setString(30, entity.getSafety());
//				ps.setString(31, entity.getSafetyInput());
//				ps.setString(32, entity.getProtection());
//				ps.setString(33, entity.getProtectionInput());
//				ps.setString(34, entity.getDispose());
//				ps.setString(35, entity.getExamine());
//				ps.setString(36, entity.getCompanyinfo());
//				ps.setString(37, entity.getRemark());
//				ps.setjava.util.Date(38, entity.getDeadline());
//				ps.setString(39, entity.getCpcode());
//				ps.setString(40, entity.getXfss());
//				ps.setString(41, entity.getXfssInput());
//				ps.setString(42, entity.getDpyz());
//				ps.setString(43, entity.getDpyzInput());
//				ps.setString(44, entity.getFlfg());
//				ps.setString(45, entity.getFlfgInput());
//			}
//		});
//	}
//
//	
//	public void updateTpoliceche(final Tpoliceche entity) {
//		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setLong(1, entity.getCheckid());
//				ps.setString(2, entity.getDeptid());
//				ps.setString(3, entity.getAcceptcheckname());
//				ps.setString(4, entity.getCheckname1());
//				ps.setString(5, entity.getChecknamephone());
//				ps.setjava.util.Date(6, entity.getChecktime());
//				ps.setString(7, entity.getCheckname2());
//				ps.setString(8, entity.getEntering());
//				ps.setString(9, entity.getVisitor());
//				ps.setString(10, entity.getDuty());
//				ps.setString(11, entity.getFinance());
//				ps.setString(12, entity.getSpeech());
//				ps.setString(13, entity.getImplement());
//				ps.setString(14, entity.getImplementInput());
//				ps.setString(15, entity.getVisitorInput());
//				ps.setString(16, entity.getDutyInput());
//				ps.setString(17, entity.getFinanceInput());
//				ps.setString(18, entity.getSpeechInput());
//				ps.setString(19, entity.getEnteringInput());
//				ps.setString(20, entity.getSystemNormalUse());
//				ps.setString(21, entity.getSystemInput());
//				ps.setString(22, entity.getIntradaynews());
//				ps.setString(23, entity.getIntradaynewsInput());
//				ps.setString(24, entity.getJdcmaintain());
//				ps.setString(25, entity.getJdcmaintainInput());
//				ps.setString(26, entity.getUploadquantityis());
//				ps.setString(27, entity.getUploadquantityiInput());
//				ps.setString(28, entity.getUploadtimely());
//				ps.setString(29, entity.getUploadtimelyInput());
//				ps.setString(30, entity.getSafety());
//				ps.setString(31, entity.getSafetyInput());
//				ps.setString(32, entity.getProtection());
//				ps.setString(33, entity.getProtectionInput());
//				ps.setString(34, entity.getDispose());
//				ps.setString(35, entity.getExamine());
//				ps.setString(36, entity.getCompanyinfo());
//				ps.setString(37, entity.getRemark());
//				ps.setjava.util.Date(38, entity.getDeadline());
//				ps.setString(39, entity.getCpcode());
//				ps.setString(40, entity.getXfss());
//				ps.setString(41, entity.getXfssInput());
//				ps.setString(42, entity.getDpyz());
//				ps.setString(43, entity.getDpyzInput());
//				ps.setString(44, entity.getFlfg());
//				ps.setString(45, entity.getFlfgInput());
//			}
//		});
//	}

	
	public void deleteTpoliceche(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	public String count(String userid){
		//String sql = "select count(*) from ss_role_user where roleid='221' and userid= ?";
		String sql ="select count(*) from ss_role role, ss_role_user  ss where role.roleid=ss.roleid and role.roledesc = '民警检查' and ss.userid = ?";
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
