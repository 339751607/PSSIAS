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
public class TcarcaseinfoDao extends BaseSpringJdbcDao<Tcarcaseinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcarcaseinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ENROLID as enrolid,"
				+" CREDID as credid,"
				+" CREDUNIT as credunit,"
				+" PARTI as parti,"
				+" PARTII as partii,"
				+" PARTIII as partiii,"
				+" REPORTER as reporter,"
				+" REPTIME as reptime,"
				+" DEMO as demo,"
				+" FLAG as flag,"
				+" ENROLTIME as enroltime,"
				+" OPERATOR as operator"
				+" from T_CARCASEINFO ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARCASEINFO where ENROLID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ENROLID=? ";
	}
	
	public void save(Tcarcaseinfo entity) {
		String sql = "insert into T_CARCASEINFO " 
			 + " (ENROLID,CREDID,CREDUNIT,PARTI,PARTII,PARTIII,REPORTER,REPTIME,DEMO,FLAG,ENROLTIME,OPERATOR) " 
			 + " values "
			 + " (:enrolid,:credid,:credunit,:parti,:partii,:partiii,:reporter,:reptime,:demo,:flag,:enroltime,:operator)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_CARCASEINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarcaseinfo entity) {
		String sql = "update T_CARCASEINFO set "
					+ " ENROLID=:enrolid,CREDID=:credid,CREDUNIT=:credunit,PARTI=:parti,PARTII=:partii,PARTIII=:partiii,REPORTER=:reporter,REPTIME=:reptime,DEMO=:demo,FLAG=:flag,ENROLTIME=:enroltime,OPERATOR=:operator "
					+ " where ENROLID=:enrolid";
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
				+ "/~ and t.CREDUNIT = '[credunit]' ~/"
				+ "/~ and t.PARTI = '[parti]' ~/"
				+ "/~ and t.PARTII = '[partii]' ~/"
				+ "/~ and t.PARTIII = '[partiii]' ~/"
				+ "/~ and t.REPORTER = '[reporter]' ~/"
				+ "/~ and t.REPTIME = '[reptime]' ~/"
				+ "/~ and t.DEMO = '[demo]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.ENROLTIME = '[enroltime]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
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
	
	
	private String createSql = "insert into T_CARCASEINFO " 
		 + " (ENROLID,CREDID,CREDUNIT,PARTI,PARTII,PARTIII,REPORTER,REPTIME,DEMO,FLAG,ENROLTIME,OPERATOR) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CARCASEINFO set "
		+ " ENROLID=?,CREDID=?,CREDUNIT=?,PARTI=?,PARTII=?,PARTIII=?,REPORTER=?,REPTIME=?,DEMO=?,FLAG=?,ENROLTIME=?,OPERATOR=? "
		+ " where ENROLID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcarcaseinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getEnrolid());
						ps.setString(2, entity.getCredid());
						ps.setString(3, entity.getCredunit());
						ps.setString(4, entity.getParti());
						ps.setString(5, entity.getPartii());
						ps.setString(6, entity.getPartiii());
						ps.setString(7, entity.getReporter());
						ps.setString(8, entity.getReptime());
						ps.setString(9, entity.getDemo());
						ps.setString(10, entity.getFlag());
						ps.setString(11, entity.getEnroltime());
						ps.setString(12, entity.getOperator());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcarcaseinfo(final Tcarcaseinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEnrolid());
				ps.setString(2, entity.getCredid());
				ps.setString(3, entity.getCredunit());
				ps.setString(4, entity.getParti());
				ps.setString(5, entity.getPartii());
				ps.setString(6, entity.getPartiii());
				ps.setString(7, entity.getReporter());
				ps.setString(8, entity.getReptime());
				ps.setString(9, entity.getDemo());
				ps.setString(10, entity.getFlag());
				ps.setString(11, entity.getEnroltime());
				ps.setString(12, entity.getOperator());
			}
		});
	}

	
	public void updateTcarcaseinfo(final Tcarcaseinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEnrolid());
				ps.setString(2, entity.getCredid());
				ps.setString(3, entity.getCredunit());
				ps.setString(4, entity.getParti());
				ps.setString(5, entity.getPartii());
				ps.setString(6, entity.getPartiii());
				ps.setString(7, entity.getReporter());
				ps.setString(8, entity.getReptime());
				ps.setString(9, entity.getDemo());
				ps.setString(10, entity.getFlag());
				ps.setString(11, entity.getEnroltime());
				ps.setString(12, entity.getOperator());
			}
		});
	}

	
	public void deleteTcarcaseinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
