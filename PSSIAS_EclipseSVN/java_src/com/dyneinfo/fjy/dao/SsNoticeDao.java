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
import org.springframework.jdbc.core.RowMapper;
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

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class SsNoticeDao extends BaseSpringJdbcDao<SsNotice,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsNotice.class;
	}
	
	public String getIdentifierPropertyName() {
		return "noticeid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" NOTICEID as noticeid,"
				+" NOTICETITLE as noticetitle,"
				+" NOTICECONTENT as noticecontent,"
				+" STARTTIME as starttime,"
				+" ENDTIME as endtime,"
				+" STATE as state,"
				+" AUTHORID as authorid,"
				+" SENDUNITID as sendunitid,"
				+" CREATETIME as createtime,"
				+" ISREPLY as isreply,"
				+" ISSUESCOPE as issuescope,"
				+" PARTICIPANTS as participants,"
				+" SORTNO as sortno,"
				+" DEPTTYPEID as depttypeid "
				+" from SS_NOTICE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_NOTICE where NOTICEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where NOTICEID=? ";
	}
	
	public void save(SsNotice entity) {
		String sql = "insert into SS_NOTICE " 
			 + " (NOTICEID,NOTICETITLE,NOTICECONTENT,STARTTIME,ENDTIME,STATE,AUTHORID,SENDUNITID,CREATETIME,ISREPLY,ISSUESCOPE,PARTICIPANTS,SORTNO,DEPTTYPEID) " 
			 + " values "
			 + " (:noticeid,:noticetitle,:noticecontent,:starttime,:endtime,:state,:authorid,:sendunitid,:createtime,:isreply,:issuescope,:participants,:sortno,:depttypeid)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_NOTICE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsNotice entity) {
		String sql = "update SS_NOTICE set "
					+ " NOTICEID=:noticeid,NOTICETITLE=:noticetitle,NOTICECONTENT=:noticecontent,STARTTIME=:starttime,ENDTIME=:endtime,STATE=:state,AUTHORID=:authorid,SENDUNITID=:sendunitid,CREATETIME=:createtime,ISREPLY=:isreply,ISSUESCOPE=:issuescope,PARTICIPANTS=:participants,SORTNO=:sortno,DEPTTYPEID=:depttypeid "
					+ " where NOTICEID=:noticeid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		String query = "select  "
		+" NOTICEID as noticeid,"
		+" NOTICETITLE as noticetitle,"
		+" NOTICECONTENT as noticecontent,"
		+" STARTTIME as starttime,"
		+" ENDTIME as endtime,"
		+" STATE as state,"
		+" AUTHORID as authorid,"
		+" SENDUNITID as sendunitid,"
		+" CREATETIME as createtime,"
		+" ISREPLY as isreply,"
		+" ISSUESCOPE as issuescope,"
		+" PARTICIPANTS as participants,"
		+" SORTNO as sortno,"
		+" t.DEPTTYPEID as depttypeid,"
		+" c.fullname as authorname,"
		+" b.deptname as sendunitname "
		+" from SS_NOTICE ";
		String sql = query + " t,SS_dept b ,SS_user c  where t.authorid = c.username and t.sendunitid = b.deptid  "
				+ "/~ and t.NOTICETITLE like '%[noticetitle]%' ~/"
				+ "/~ and t.NOTICECONTENT = '[noticecontent]' ~/"
				+ "/~ and t.STARTTIME >= to_date('[starttimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.STARTTIME <= to_date('[starttimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.ENDTIME >=   to_date('[endtimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/" 
				+ "/~ and t.ENDTIME <=   to_date('[endtimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/" 
				+ "/~ and t.STATE = '[state]' ~/"
				
				+ "/~ and b.deptname like '%[sendunitid]%' ~/"
				+ "/~ and t.CREATETIME = '[createtime]' ~/"
				+ "/~ and t.ISREPLY = '[isreply]' ~/"
				+ "/~ and t.ISSUESCOPE = '[issuescope]' ~/"
				+ "/~ and t.PARTICIPANTS = '[participants]' ~/"
				+ "/~ and t.SORTNO = '[sortno]' ~/"
				+ "/~ and t.DEPTTYPEID = '[depttypeid]' ~/"
				+ "/~  and ( state=1 or (state=0 and t.authorid='[authorid]')) ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  createtime desc ";
		return pageQuery(sql,pageRequest);
	}
	
	
	
	public Page findByPageRequest(PageRequest<Map> pageRequest,String sql) {
		
		return pageQuery(sql,pageRequest);
	}
	
	
	public SsNotice getSsNoticeById(java.lang.Long noticeid) {
		String query = "select  "
			+" NOTICEID as noticeid,"
			+" NOTICETITLE as noticetitle,"
			+" NOTICECONTENT as noticecontent,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" STATE as state,"
			+" AUTHORID as authorid,"
			+" SENDUNITID as sendunitid,"
			+" CREATETIME as createtime,"
			+" ISREPLY as isreply,"
			+" ISSUESCOPE as issuescope,"
			+" PARTICIPANTS as participants,"
			+" SORTNO as sortno,"
			+" t.DEPTTYPEID as depttypeid,"
			+" c.fullname as authorname,"
			+" b.deptname as sendunitname "
			+" from SS_NOTICE ";
			String sql = query + " t,SS_dept b ,SS_user c  " +
					" where t.authorid = c.username and t.sendunitid = b.deptid  and NOTICEID = ? ";
	    SsNotice ssNotice = null;
		try {   
			ssNotice = (SsNotice)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {noticeid});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return ssNotice;
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
	
	//发布范围（单位） 
	public void deleteNOTICE_attend(Long noticeid) {
		//System.out.println("noticeid======="+noticeid);
		getJdbcTemplate().update(" delete from FILE_ATTACH where FILE_SAVE = 'D' and " +
				" (FILEGROUP = 'SS_NOTICE_PIC' or FILEGROUP = 'SS_NOTICE_FILE' ) and RELATION_ID = '"+noticeid+"'  ");
		getJdbcTemplate().update(" delete from SS_NOTICE_ATTEND where NOTICEID = ?  ", new Object[] { noticeid });
		getJdbcTemplate().update(" delete from SS_NOTICE where NOTICEID = ?  ", new Object[] { noticeid });
		getJdbcTemplate().update(" delete from SS_NOTICE_REPLY where NOTICEID = ?  ", new Object[] { noticeid });
	}
	
	
	public void insertNoticeReply(String noticeid ,String deptid,String replydate,String flag) {
		String sql = "INSERT INTO SS_NOTICE_REPLY (NOTICEID,DEPTID,REPLYDATE,FLAG) VALUES(:noticeid, :deptid,:replydate,:flag)";
		Map namedParameters = new HashMap();
		namedParameters.put("noticeid", noticeid);
		namedParameters.put("deptid", deptid);
		namedParameters.put("replydate", replydate);
		namedParameters.put("flag", flag);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	
	public int getCountByKey(String noticeid,String deptid,String flag) {
		String sql = "select count(*)  from SS_NOTICE_REPLY  where NOTICEID=?  and DEPTID=? and flag=?";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {noticeid,deptid,flag} );   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	public int getTzReplyHotelCount(String noticeid) {
		String sql = "select count(t.deptid) from SS_NOTICE_REPLY t where t.noticeid = ? and flag=0";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {noticeid} );   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	public List getDeptSeq( String noticeid) {
		String sql = "select deptseq from ss_dept where deptid in(select deptid from ss_notice_attend t  where  t.isdept =1 and t.noticeid = '"+noticeid+"')  ";
		
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String deptseq = rs.getString(1);
			        results.put("deptseq", deptseq);
			        return results;
	           }
	           
	       });
	   }
	
	
	public int getTzNoReplyHotelCount(String sqlWhere,String noticeid) {
		
		String sql = " select count(deptid) from ss_dept where  DEPTTYPEID != '0' and ("+sqlWhere+") and deptid not in(select deptid from SS_NOTICE_REPLY where noticeid = '"+noticeid+"' ) ";
		
		
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql);   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	public Page findByPageRequestReplyNotice(PageRequest<Map> pageRequest,String id) {
		String query = "select  "
		+" a.deptid as noticeid,"
		+" a.deptname as noticetitle, "
		+" b.REPLYDATE as noticecontent "
		+"  from SS_DEPT a,SS_NOTICE_REPLY b  " +
		" where  a.deptid = b.deptid and  b.noticeid = '"+id+"'";
	
		return pageQuery(query,pageRequest);
	}

	public Page findByPageRequesttzNoReply(PageRequest<Map> pageRequest) {
		String query = "select  "
		+" deptid as noticeid,"
		+" deptname as noticetitle "
		+" from SS_DEPT  where DEPTTYPEID != '0' and "  +
				"/~ ([sqlWhere]) ~/" +
				"/~ and deptid not in(select deptid from SS_NOTICE_REPLY where noticeid = '[noticeid]' )~/"; 
	
		return pageQuery(query,pageRequest);
	}
	
	public int getNoticeNumber(String sql){
//		String sql = " select count(*) "
//					+"	from (select c.*, d.deptid "
//					+"from ss_notice c, "
//					+"(select b.noticeid, a.deptid "
//					+"from ss_dept a, ss_notice_attend b "
//					+"where a.deptid = '"+deptid+"' "
//					+"and a.deptseq like '%.' ||'"+deptid+"' || '.%') d "
//					+"where c.noticeid = d.noticeid and c.STATE = 1) e "
//					+"where not exists (select * "
//					+"from ss_notice_reply f "
//					+"where e.noticeid = f.noticeid "
//					+"and e.deptid = f.deptid) "
//					+"and (sysdate between e.starttime and e.endtime) ";
		int  noticeCount = 0;
		try {   
			noticeCount = getSimpleJdbcTemplate().queryForInt(sql);   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger   
			                   .error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			       }   
		return noticeCount;
	}

}
