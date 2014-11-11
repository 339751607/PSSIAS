/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonbaseJwDao extends BaseSpringJdbcDao<TpersonbaseJw,Long>{
	
	public Class getEntityClass() {
		return TpersonbaseJw.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" SURNAME as surname,"
				+" NAME as name,"
				+" CH_NAME as chName,"
				+" SEX as sex,"
				+" BDATE as bdate,"
				+" NATIONALITY as nationality,"
				+" PASS_T as passT,"
				+" PASS_NO as passNo,"
				+" VISA_T as visaT,"
				+" VISA_NO as visaNo,"
				+" STAY_DATE as stayDate,"
				+" QF_UNIT as qfUnit,"
				+" IN_DATE as inDate,"
				+" IN_PORT as inPort,"
				+" UPDATETIME as updatetime"
				+" from T_PERSONBASE_JW ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_PERSONBASE_JW where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TpersonbaseJw entity) {
		String sql = "insert into T_PERSONBASE_JW " 
			 + " (ID,SURNAME,NAME,CH_NAME,SEX,BDATE,NATIONALITY,PASS_T,PASS_NO,VISA_T,VISA_NO,STAY_DATE,QF_UNIT,IN_DATE,IN_PORT,UPDATETIME) " 
			 + " values "
			 + " (:id,:surname,:name,:chName,:sex,:bdate,:nationality,:passT,:passNo,:visaT,:visaNo,:stayDate,:qfUnit,:inDate,:inPort,:updatetime)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_PERSONBASE_JW",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpersonbaseJw entity) {
		String sql = "update T_PERSONBASE_JW set "
					+ " ID=:id,SURNAME=:surname,NAME=:name,CH_NAME=:chName,SEX=:sex,BDATE=:bdate,NATIONALITY=:nationality,PASS_T=:passT,PASS_NO=:passNo,VISA_T=:visaT,VISA_NO=:visaNo,STAY_DATE=:stayDate,QF_UNIT=:qfUnit,IN_DATE=:inDate,IN_PORT=:inPort,UPDATETIME=:updatetime "
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
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.SURNAME like '%[surname]%' ~/"
				+ "/~ and t.NAME like '%[name]%' ~/"
				+ "/~ and t.CH_NAME like '%[chName]%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.BDATE like '%[bdate]%' ~/"
				+ "/~ and t.NATIONALITY = '[nationality]' ~/"
				+ "/~ and t.PASS_T = '[passT]' ~/"
				+ "/~ and t.PASS_NO like  '%[passNo]%' ~/"
				+ "/~ and t.VISA_T = '[visaT]' ~/"
				+ "/~ and t.VISA_NO like '%[visaNo]%' ~/"
				+ "/~ and t.STAY_DATE = '[stayDate]' ~/"
				+ "/~ and t.QF_UNIT = '[qfUnit]' ~/"
				+ "/~ and t.IN_DATE = '[inDate]' ~/"
				+ "/~ and t.IN_PORT = '[inPort]' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
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
	
	
	private String createSql = "insert into T_PERSONBASE_JW " 
		 + " (ID,SURNAME,NAME,CH_NAME,SEX,BDATE,NATIONALITY,PASS_T,PASS_NO,VISA_T,VISA_NO,STAY_DATE,QF_UNIT,IN_DATE,IN_PORT,UPDATETIME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_PERSONBASE_JW set "
		+ " ID=?,SURNAME=?,NAME=?,CH_NAME=?,SEX=?,BDATE=?,NATIONALITY=?,PASS_T=?,PASS_NO=?,VISA_T=?,VISA_NO=?,STAY_DATE=?,QF_UNIT=?,IN_DATE=?,IN_PORT=?,UPDATETIME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpersonbaseJw entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getSurname());
						ps.setString(3, entity.getName());
						ps.setString(4, entity.getChName());
						ps.setString(5, entity.getSex());
						ps.setString(6, entity.getBdate());
						ps.setString(7, entity.getNationality());
						ps.setString(8, entity.getPassT());
						ps.setString(9, entity.getPassNo());
						ps.setString(10, entity.getVisaT());
						ps.setString(11, entity.getVisaNo());
						ps.setString(12, entity.getStayDate());
						ps.setString(13, entity.getQfUnit());
						ps.setString(14, entity.getInDate());
						ps.setString(15, entity.getInPort());
						ps.setDate(16, (java.sql.Date)entity.getUpdatetime());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpersonbaseJw(final TpersonbaseJw entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getSurname());
				ps.setString(3, entity.getName());
				ps.setString(4, entity.getChName());
				ps.setString(5, entity.getSex());
				ps.setString(6, entity.getBdate());
				ps.setString(7, entity.getNationality());
				ps.setString(8, entity.getPassT());
				ps.setString(9, entity.getPassNo());
				ps.setString(10, entity.getVisaT());
				ps.setString(11, entity.getVisaNo());
				ps.setString(12, entity.getStayDate());
				ps.setString(13, entity.getQfUnit());
				ps.setString(14, entity.getInDate());
				ps.setString(15, entity.getInPort());
				ps.setDate(16, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void updateTpersonbaseJw(final TpersonbaseJw entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getSurname());
				ps.setString(3, entity.getName());
				ps.setString(4, entity.getChName());
				ps.setString(5, entity.getSex());
				ps.setString(6, entity.getBdate());
				ps.setString(7, entity.getNationality());
				ps.setString(8, entity.getPassT());
				ps.setString(9, entity.getPassNo());
				ps.setString(10, entity.getVisaT());
				ps.setString(11, entity.getVisaNo());
				ps.setString(12, entity.getStayDate());
				ps.setString(13, entity.getQfUnit());
				ps.setString(14, entity.getInDate());
				ps.setString(15, entity.getInPort());
				ps.setDate(16, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void deleteTpersonbaseJw(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
