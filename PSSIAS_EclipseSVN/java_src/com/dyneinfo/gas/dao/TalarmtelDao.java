/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.dao;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TalarmtelDao extends BaseSpringJdbcDao<Talarmtel,java.lang.String>{
	
	public Class getEntityClass() {
		return Talarmtel.class;
	}
	
	public String getIdentifierPropertyName() {
		return "deptcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DEPTCODE as deptcode,"
				+" DEPTNAME as deptname,"
				+" ALARMALL as alarmall,"
				+" ALARMTEL as alarmtel,"
				+" DEPTCODE as exitend1,"
				+" EXITEND2 as exitend2,"
				+" EXITEND3 as exitend3"
				+" from T_ALARMTEL ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_ALARMTEL where DEPTCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DEPTCODE=? ";
	}
	
	public void save(Talarmtel entity) {
		String sql = "insert into T_ALARMTEL " 
			 + " (DEPTCODE,DEPTNAME,ALARMALL,ALARMTEL,EXITEND1,EXITEND2,EXITEND3) " 
			 + " values "
			 + " (:exitend1,:deptname,:alarmall,:alarmtel,:exitend1,:exitend2,:exitend3)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_ALARMTEL",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Talarmtel entity) {
		String sql = "update T_ALARMTEL set "
					+ " DEPTCODE=:exitend1,DEPTNAME=:deptname,ALARMALL=:alarmall,ALARMTEL=:alarmtel,EXITEND1=:exitend1,EXITEND2=:exitend2,EXITEND3=:exitend3 "
					+ " where DEPTCODE=:deptcode";
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
				+ "/~ and t.DEPTCODE = '[deptcode]' ~/"
				+ "/~ and t.DEPTNAME = '[deptname]' ~/"
				+ "/~ and t.ALARMALL = '[alarmall]' ~/"
				+ "/~ and t.ALARMTEL like '%[alarmtel]%' ~/"
				+ "/~ and t.EXITEND1 = '[exitend1]' ~/"
				+ "/~ and t.EXITEND2 = '[exitend2]' ~/"
				+ "/~ and t.EXITEND3 = '[exitend3]' ~/"
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
	
	
	private String createSql = "insert into T_ALARMTEL " 
		 + " (DEPTCODE,DEPTNAME,ALARMALL,ALARMTEL,EXITEND1,EXITEND2,EXITEND3) " 
		 + " values "
		 + " (?,?,?,?,?,?,?)";
	private String updateSql = "update T_ALARMTEL set "
		+ " DEPTCODE=?,DEPTNAME=?,ALARMALL=?,ALARMTEL=?,EXITEND1=?,EXITEND2=?,EXITEND3=? "
		+ " where DEPTCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Talarmtel entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getDeptcode());
						ps.setString(2, entity.getDeptname());
						ps.setString(3, entity.getAlarmall());
						ps.setString(4, entity.getAlarmtel());
						ps.setString(5, entity.getExitend1());
						ps.setString(6, entity.getExitend2());
						ps.setString(7, entity.getExitend3());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTalarmtel(final Talarmtel entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDeptcode());
				ps.setString(2, entity.getDeptname());
				ps.setString(3, entity.getAlarmall());
				ps.setString(4, entity.getAlarmtel());
				ps.setString(5, entity.getExitend1());
				ps.setString(6, entity.getExitend2());
				ps.setString(7, entity.getExitend3());
			}
		});
	}

	
	public void updateTalarmtel(final Talarmtel entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDeptcode());
				ps.setString(2, entity.getDeptname());
				ps.setString(3, entity.getAlarmall());
				ps.setString(4, entity.getAlarmtel());
				ps.setString(5, entity.getExitend1());
				ps.setString(6, entity.getExitend2());
				ps.setString(7, entity.getExitend3());
			}
		});
	}

	
	public void deleteTalarmtel(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
