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
public class ThotelBsQaDao extends BaseSpringJdbcDao<ThotelBsQa,Long>{
	
	public Class getEntityClass() {
		return ThotelBsQa.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" T.XH as xh,"
				+" T.CODE as code,"
				+" T.USERNAME as username,"
				+" T.WTSJ as wtsj,"
				+" T.COMPUTERIP as computerip,"
				+" T.USERTEL as usertel,"
				+" T.WTNR as wtnr,"
				+" T.WTFL as wtfl,"
				+" T.JDSJ as jdsj,"
				+" T.JDNR as jdnr,"
				+" T.JDR as jdr,"
				+" T.JDBZ as jdbz,"
				+" T.FLAG as flag,"
				+" T.NOTE as note,"
				+" D.DEPTNAME as dwmc"
				+" from T_HOTEL_BS_QA T,ss_dept D";
	}
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_HOTEL_BS_QA where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where  T.XH=? and T.CODE=D.DEPTID ";
	}
	
	public void save(ThotelBsQa entity) {
		String sql = "insert into T_HOTEL_BS_QA " 
			 + " (XH,CODE,USERNAME,WTSJ,COMPUTERIP,USERTEL,WTNR,WTFL,JDSJ,JDNR,JDR,JDBZ,FLAG,NOTE) " 
			 + " values "
			 + " (:xh,:code,:username,:wtsj,:computerip,:usertel,:wtnr,:wtfl,:jdsj,:jdnr,:jdr,:jdbz,:flag,:note)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_HOTEL_BS_QA",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(ThotelBsQa entity) {
		String sql = "update T_HOTEL_BS_QA set "
					+ " XH=:xh,CODE=:code,USERNAME=:username,WTSJ=:wtsj,COMPUTERIP=:computerip,USERTEL=:usertel,WTNR=:wtnr,WTFL=:wtfl,JDSJ=:jdsj,JDNR=:jdnr,JDR=:jdr,JDBZ=:jdbz,FLAG=:flag,NOTE=:note "
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
		String sql = getSelectPrefix() + " where T.CODE=D.DEPTID "
				+ "/~ and t.CODE = '[code]' ~/"
				+ "/~ and t.USERNAME = '[username]' ~/"
				+ "/~ and t.WTSJ >= '[wtsjBeginFormat]' ~/"
				+ "/~ and t.WTSJ <= '[wtsjEndFormat]' ~/"
				+ "/~ and t.COMPUTERIP = '[computerip]' ~/"
				+ "/~ and t.USERTEL = '[usertel]' ~/"
				+ "/~ and t.WTNR = '[wtnr]' ~/"
				+ "/~ and t.WTFL = '[wtfl]' ~/"
				+ "/~ and t.JDSJ >= '[jdsjBeginFormat]' ~/"
				+ "/~ and t.JDSJ <= '[jdsjEndFormat]' ~/"
				+ "/~ and t.JDNR = '[jdnr]' ~/"
				+ "/~ and t.JDR = '[jdr]' ~/"
				+ "/~ and t.JDBZ = '[jdbz]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.NOTE = '[note]' ~/"
				+ " order by xh desc ";
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
	
	
	private String createSql = "insert into T_HOTEL_BS_QA " 
		 + " (XH,CODE,USERNAME,WTSJ,COMPUTERIP,USERTEL,WTNR,WTFL,JDSJ,JDNR,JDR,JDBZ,FLAG,NOTE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_HOTEL_BS_QA set "
		+ " XH=?,CODE=?,USERNAME=?,WTSJ=?,COMPUTERIP=?,USERTEL=?,WTNR=?,WTFL=?,JDSJ=?,JDNR=?,JDR=?,JDBZ=?,FLAG=?,NOTE=? "
		+ " where XH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final ThotelBsQa entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getXh());
						ps.setString(2, entity.getCode());
						ps.setString(3, entity.getUsername());
						ps.setString(4, entity.getWtsj());
						ps.setString(5, entity.getComputerip());
						ps.setString(6, entity.getUsertel());
						ps.setString(7, entity.getWtnr());
						ps.setString(8, entity.getWtfl());
						ps.setString(9, entity.getJdsj());
						ps.setString(10, entity.getJdnr());
						ps.setString(11, entity.getJdr());
						ps.setString(12, entity.getJdbz());
						ps.setString(13, entity.getFlag());
						ps.setString(14, entity.getNote());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createThotelBsQa(final ThotelBsQa entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getXh());
				ps.setString(2, entity.getCode());
				ps.setString(3, entity.getUsername());
				ps.setString(4, entity.getWtsj());
				ps.setString(5, entity.getComputerip());
				ps.setString(6, entity.getUsertel());
				ps.setString(7, entity.getWtnr());
				ps.setString(8, entity.getWtfl());
				ps.setString(9, entity.getJdsj());
				ps.setString(10, entity.getJdnr());
				ps.setString(11, entity.getJdr());
				ps.setString(12, entity.getJdbz());
				ps.setString(13, entity.getFlag());
				ps.setString(14, entity.getNote());
			}
		});
	}

	
	public void updateThotelBsQa(final ThotelBsQa entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getXh());
				ps.setString(2, entity.getCode());
				ps.setString(3, entity.getUsername());
				ps.setString(4, entity.getWtsj());
				ps.setString(5, entity.getComputerip());
				ps.setString(6, entity.getUsertel());
				ps.setString(7, entity.getWtnr());
				ps.setString(8, entity.getWtfl());
				ps.setString(9, entity.getJdsj());
				ps.setString(10, entity.getJdnr());
				ps.setString(11, entity.getJdr());
				ps.setString(12, entity.getJdbz());
				ps.setString(13, entity.getFlag());
				ps.setString(14, entity.getNote());
			}
		});
	}

	
	public void deleteThotelBsQa(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
