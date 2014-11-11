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
public class QuestionDao extends BaseSpringJdbcDao<Question,Long>{
	
	public Class getEntityClass() {
		return Question.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" XH as xh,"
				+" t.USERNAME as username,"
				+" WTSJ as wtsj,"
				+" COMPUTERIP as computerip,"
				+" USERTEL as usertel,"
				+" WTFL as wtfl,"
				+" WTNR as wtnr,"
				+" JDSJ as jdsj,"
				+" JDNR as jdnr,"
				+" JDR as jdr,"
				+" JDBZ as jdbz,"
				+" FLAG as flag,"
				+" NOTE as note,"
				+" b.DEPTID as deptid,"
				+" b.DEPTNAME as deptname "
				+" from T_QUESTION t,ss_dept b,SS_user c  where c.deptid = b.deptid and t.USERNAME  = c.username ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_QUESTION where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and  XH=? ";
	}
	
	public void save(Question entity) {
		String sql = "insert into T_QUESTION " 
			 + " (XH,USERNAME,WTSJ,COMPUTERIP,USERTEL,WTFL,WTNR,JDSJ,JDNR,JDR,JDBZ,FLAG,NOTE) " 
			 + " values "
			 + " (:xh,:username,:wtsj,:computerip,:usertel,:wtfl,:wtnr,:jdsj,:jdnr,:jdr,:jdbz,:flag,:note)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_QUESTION",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Question entity) {
		String sql = "update T_QUESTION set "
					+ " XH=:xh,USERNAME=:username,WTSJ=:wtsj,COMPUTERIP=:computerip,USERTEL=:usertel,WTFL=:wtfl,WTNR=:wtnr,JDSJ=:jdsj,JDNR=:jdnr,JDR=:jdr,JDBZ=:jdbz,FLAG=:flag,NOTE=:note "
					+ " where XH=:xh";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "   "
				+ "/~ and t.USERNAME = '[username]' ~/"
				+ "/~ and t.WTSJ >= '[wtsjBeginFormat]' ~/"
				+ "/~ and t.WTSJ <= '[wtsjEndFormat]' ~/"
				+ "/~ and t.COMPUTERIP = '[computerip]' ~/"
				+ "/~ and t.USERTEL = '[usertel]' ~/"
				+ "/~ and t.WTFL = '[wtfl]' ~/"
				+ "/~ and t.WTNR = '[wtnr]' ~/"
				+ "/~ and t.JDSJ = '[jdsj]' ~/"
				+ "/~ and t.JDNR = '[jdnr]' ~/"
				+ "/~ and t.JDR = '[jdr]' ~/"
				+ "/~ and t.JDBZ = '[jdbz]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.NOTE = '[note]' ~/"
				+ "/~ and b.deptid = '[deptid]' ~/"
				+ "/~ and b.DEPTSEQ like {deptSeq}||'%' ~/"
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
	
	
	private String createSql = "insert into T_QUESTION " 
		 + " (XH,USERNAME,WTSJ,COMPUTERIP,USERTEL,WTFL,WTNR,JDSJ,JDNR,JDR,JDBZ,FLAG,NOTE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_QUESTION set "
		+ " XH=?,USERNAME=?,WTSJ=?,COMPUTERIP=?,USERTEL=?,WTFL=?,WTNR=?,JDSJ=?,JDNR=?,JDR=?,JDBZ=?,FLAG=?,NOTE=? "
		+ " where XH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Question entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getXh());
						ps.setString(2, entity.getUsername());
						ps.setString(3, entity.getWtsj());
						ps.setString(4, entity.getComputerip());
						ps.setString(5, entity.getUsertel());
						ps.setString(6, entity.getWtfl());
						ps.setString(7, entity.getWtnr());
						ps.setString(8, entity.getJdsj());
						ps.setString(9, entity.getJdnr());
						ps.setString(10, entity.getJdr());
						ps.setString(11, entity.getJdbz());
						ps.setString(12, entity.getFlag());
						ps.setString(13, entity.getNote());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createQuestion(final Question entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getXh());
				ps.setString(2, entity.getUsername());
				ps.setString(3, entity.getWtsj());
				ps.setString(4, entity.getComputerip());
				ps.setString(5, entity.getUsertel());
				ps.setString(6, entity.getWtfl());
				ps.setString(7, entity.getWtnr());
				ps.setString(8, entity.getJdsj());
				ps.setString(9, entity.getJdnr());
				ps.setString(10, entity.getJdr());
				ps.setString(11, entity.getJdbz());
				ps.setString(12, entity.getFlag());
				ps.setString(13, entity.getNote());
			}
		});
	}

	
	public void updateQuestion(final Question entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getXh());
				ps.setString(2, entity.getUsername());
				ps.setString(3, entity.getWtsj());
				ps.setString(4, entity.getComputerip());
				ps.setString(5, entity.getUsertel());
				ps.setString(6, entity.getWtfl());
				ps.setString(7, entity.getWtnr());
				ps.setString(8, entity.getJdsj());
				ps.setString(9, entity.getJdnr());
				ps.setString(10, entity.getJdr());
				ps.setString(11, entity.getJdbz());
				ps.setString(12, entity.getFlag());
				ps.setString(13, entity.getNote());
			}
		});
	}

	
	public void deleteQuestion(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
