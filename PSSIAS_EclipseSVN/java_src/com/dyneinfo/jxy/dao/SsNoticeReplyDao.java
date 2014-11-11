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
public class SsNoticeReplyDao extends BaseSpringJdbcDao<SsNoticeReply,java.lang.String>{
	
	public Class getEntityClass() {
		return SsNoticeReply.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" NOTICEID as noticeid,"
				+" DEPTID as deptid,"
				+" REPLYDATE as replydate"
				+" from SS_NOTICE_REPLY ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_NOTICE_REPLY where NOTICEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where NOTICEID=? ";
	}
	
	public void save(SsNoticeReply entity) {
		String sql = "insert into SS_NOTICE_REPLY " 
			 + " (NOTICEID,DEPTID,REPLYDATE) " 
			 + " values "
			 + " (:noticeid,:deptid,:replydate)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_SS_NOTICE_REPLY",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsNoticeReply entity) {
		String sql = "update SS_NOTICE_REPLY set "
					+ " NOTICEID=:noticeid,DEPTID=:deptid,REPLYDATE=:replydate "
					+ " where NOTICEID=:noticeid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select t.REPLYDATE as replydate,s.NOTICETITLE as noticetitle,d.DEPTNAME as deptname from SS_NOTICE_REPLY t ,ss_dept d,ss_notice s where t.deptid=d.deptid and t.noticeid=s.noticeid"
				+ "/~ and d.DEPTNAME like '%[deptname]%' ~/"
				+ "/~ and t.NOTICEID = '[noticeid]' ~/"
				+ "/~ and t.REPLYDATE >= '[replydateBeginFormat]' ~/"
				+ "/~ and t.REPLYDATE <= '[replydateEndFormat]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	public SsNoticeReply getById(String noticeid,String deptid) {
		String sql=getSelectPrefix()+" where t.noticeid ? and t.DEPTID ?";
		
		return (SsNoticeReply)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {noticeid,deptid});
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
	
	
	private String createSql = "insert into SS_NOTICE_REPLY " 
		 + " (NOTICEID,DEPTID,REPLYDATE) " 
		 + " values "
		 + " (?,?,?)";
	private String updateSql = "update SS_NOTICE_REPLY set "
		+ " NOTICEID=?,DEPTID=?,REPLYDATE=? "
		+ " where NOTICEID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final SsNoticeReply entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getNoticeid());
						ps.setString(2, entity.getDeptid());
						ps.setString(3, entity.getReplydate());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createSsNoticeReply(final SsNoticeReply entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getNoticeid());
				ps.setString(2, entity.getDeptid());
				ps.setString(3, entity.getReplydate());
			}
		});
	}

	
	public void updateSsNoticeReply(final SsNoticeReply entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getNoticeid());
				ps.setString(2, entity.getDeptid());
				ps.setString(3, entity.getReplydate());
			}
		});
	}

	
	public void deleteSsNoticeReply(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
