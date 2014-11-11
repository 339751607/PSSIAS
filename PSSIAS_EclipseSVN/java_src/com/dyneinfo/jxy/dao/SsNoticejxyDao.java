/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;
import net.java.dev.common.util.SpringTagFunctions;

import org.apache.commons.lang.StringUtils;
import org.security.userdetails.MyUserDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.model.SsNotice;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsNoticejxyDao extends BaseSpringJdbcDao<SsNotice,java.lang.Long>{
	
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
		String sql = query + " t,ss_dept b ,SS_user c  where t.authorid = c.username and t.sendunitid = b.deptid  "
		
				+ "/~ and t.NOTICETITLE like '%[noticetitle]%' ~/"
				+ "/~ and t.NOTICECONTENT = '[noticecontent]' ~/"
				+ "/~ and t.STARTTIME >= to_date('[starttimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.STARTTIME <= to_date('[starttimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/"
				+ "/~ and t.ENDTIME >=   to_date('[endtimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/" 
				+ "/~ and t.ENDTIME <=   to_date('[endtimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/" 
				+ "/~ and t.STATE = '[state]' ~/"
				+ "/~ and c.fullname like '%[authorid]%' ~/"
				+ "/~ and b.deptname like '%[sendunitid]%' ~/"
				+ "/~ and t.CREATETIME = '[createtime]' ~/"
				+ "/~ and t.ISREPLY = '[isreply]' ~/"
				+ "/~ and t.ISSUESCOPE = '[issuescope]' ~/"
				+ "/~ and t.PARTICIPANTS = '[participants]' ~/"
				+ "/~ and t.SORTNO = '[sortno]' ~/"
				+ "/~ and t.DEPTTYPEID = '[depttypeid]' ~/"
				+ "/~ order by [sortColumns] ~/";
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
			String sql = query + " t,ss_dept b ,SS_user c  " +
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
	}
	public String getSqlbyUser(MyUserDetails userDetail,String arg){
		String username = "";
		String deptid = "";
		String deptSeq = "";
		userDetail = SpringTagFunctions.getUserDetails();
		if (userDetail != null) {
			username = userDetail.getUsername();
			deptid = userDetail.getDeptID();
			deptSeq = userDetail.getDeptSeq();
		}
		
		String sql = "select  "
			+" distinct  t.NOTICEID as noticeid,"
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
			+" c.fullname as authorname,"
			+" b.deptname as sendunitname "
			+" from SS_NOTICE t,ss_dept b ,SS_user c,SS_NOTICE_ATTEND d "
			+"   where t.authorid = c.username " +
		    " and t.sendunitid = b.deptid and STATE = 1  and d.NOTICEID = t.NOTICEID " +
		    " and t.STARTTIME <= sysdate and t.ENDTIME >= sysdate  ";
			StringBuffer sb = new StringBuffer(sql);
			if(arg!=null){
				sb.append(" and t.NOTICEID not in (select NOTICEID from ss_notice_reply where DEPTID = '"+deptid+"')");
			}
		    if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(deptSeq)){
		    	sb.append(" and ( ");
		    	sb.append(" ( d.isdept = 0 and d.userid = '"+username+"') ");
		    	StringBuffer buff = new StringBuffer(deptSeq.replace(".", "','"));
				buff.deleteCharAt(0);
				buff.deleteCharAt(0);
				buff.deleteCharAt(buff.length() - 1);
				buff.deleteCharAt(buff.length() - 1);
	            sb.append((new StringBuilder(" or (d.DEPTID  in (")).append(buff.toString()).append(") and d.isdept = 1 )").toString());
	            sb.append(" ) ");
		    }
           
            return sb.toString();
		
	}
	public List getByNoticeByUser(MyUserDetails userDetail) {
		String sql=this.getSqlbyUser(userDetail,"");
        return getSimpleJdbcTemplate().queryForList(sql.toString());
	}
	public  Page findByPageRequestUser(MyUserDetails userDetail,PageRequest<Map> pageRequest,String arg) {
		String sql=this.getSqlbyUser(userDetail,arg);
		sql=sql
		+ "/~ and t.NOTICETITLE like '%[noticetitle]%' ~/"
		+ "/~ and t.NOTICECONTENT = '[noticecontent]' ~/"
		+ "/~ and t.STARTTIME >= to_date('[starttimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/"
		+ "/~ and t.STARTTIME <= to_date('[starttimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/"
		+ "/~ and t.ENDTIME >=   to_date('[endtimeBegin] 00:00:00','yyyy-MM-dd HH24:mi:ss')  ~/" 
		+ "/~ and t.ENDTIME <=   to_date('[endtimeEnd] 23:59:59','yyyy-MM-dd HH24:mi:ss')  ~/" 
		+ "/~ and t.STATE = '[state]' ~/"
		+ "/~ and c.fullname like '%[authorid]%' ~/"
		+ "/~ and b.deptname like '%[sendunitid]%' ~/"
		+ "/~ and t.CREATETIME = '[createtime]' ~/"
		+ "/~ and t.ISREPLY = '[isreply]' ~/"
		+ "/~ and t.ISSUESCOPE = '[issuescope]' ~/"
		+ "/~ and t.PARTICIPANTS = '[participants]' ~/"
		+ "/~ and t.SORTNO = '[sortno]' ~/"
		+ "/~ and t.DEPTTYPEID = '[depttypeid]' ~/"
		+" order by SORTNO ";
		
		return pageQuery(sql,pageRequest);
	}
	public int getNoticeReplyById(String noticeId,String deptId) {

		//select NOTICEID from ss_notice_reply where DEPTID = '"+deptid+"'
		String sql = " select count(*) from ss_notice_reply where noticeId= ? and  DEPTID = ?";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {noticeId,deptId} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	//通知 参与人员
	public List getNotice_participants(Long noticeID) {
		String sql = "select USERNAME,FULLNAME from SS_USER where  USERNAME in (select USERID from SS_NOTICE_ATTEND where ISDEPT = 0 and  NOTICEID = ? )";
		return getJdbcTemplate().query(sql, new Object[] { noticeID },new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String USERNAME = rs.getString(1);
				String FULLNAME = rs.getString(2);

				results.put("USERNAME", USERNAME);
				results.put("FULLNAME", FULLNAME);
				return results;
			}

		});
	}
	
	//发布范围（单位） 
	public List getNotice_issuescope(Long noticeID) {
		String sql = "select DEPTID,DEPTNAME from SS_DEPT where  DEPTID in (select DEPTID from SS_NOTICE_ATTEND where ISDEPT = 1 and  NOTICEID = ? )";
		return getJdbcTemplate().query(sql,new Object[] { noticeID }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String DEPTID = rs.getString(1);
				String DEPTNAME = rs.getString(2);

				results.put("DEPTID", DEPTID);
				results.put("DEPTNAME", DEPTNAME);
				return results;
			}

		});
	}
}
