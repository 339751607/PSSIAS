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
public class TempworklogDao extends BaseSpringJdbcDao<Tempworklog,Long>{
	
	public Class getEntityClass() {
		return Tempworklog.class;
	}
	
	public String getIdentifierPropertyName() {
		return "worklogid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" WORKLOGID as worklogid,"
				+" EMPCODE as empcode,"
				+" CPCODE as cpcode,"
				+" INDATE as indate,"
				+" LEFTDATE as leftdate,"
				+" EMPTYPE as emptype,"
				+" DEMO as demo"
				+" from T_EMPWORKLOG ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_EMPWORKLOG where WORKLOGID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		//return getSelectPrefix() + " where WORKLOGID=? ";
		
		String sql = "select  "
			+" WORKLOGID as worklogid,"
			+" EMPCODE as empcode,"
			+" CPCODE as cpcode,"
			+" b.deptname as cpname,"
			+" INDATE as indate,"
			+" LEFTDATE as leftdate,"
			+" EMPTYPE as emptype,"
			+" DEMO as demo"
			+" from T_EMPWORKLOG " 
			+ " t,ss_dept b where t.cpcode = b.deptid  and WORKLOGID=?  ";
		return sql;
	}
	
	public void save(Tempworklog entity) {
		String sql = "insert into T_EMPWORKLOG " 
			 + " (WORKLOGID,EMPCODE,CPCODE,INDATE,LEFTDATE,EMPTYPE,DEMO) " 
			 + " values "
			 + " (:worklogid,:empcode,:cpcode,:indate,:leftdate,:emptype,:demo)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_EMPWORKLOG",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tempworklog entity) {
		String sql = "update T_EMPWORKLOG set "
					+ " WORKLOGID=:worklogid,EMPCODE=:empcode,CPCODE=:cpcode,INDATE=:indate,LEFTDATE=:leftdate,EMPTYPE=:emptype,DEMO=:demo "
					+ " where WORKLOGID=:worklogid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select  "
				+" WORKLOGID as worklogid,"
				+" EMPCODE as empcode,"
				+" CPCODE as cpcode,"
				+" b.deptname as cpname,"
				+" INDATE as indate,"
				+" LEFTDATE as leftdate,"
				+" EMPTYPE as emptype,"
				+" DEMO as demo"
				+" from T_EMPWORKLOG " 
				+ " t,ss_dept b where t.cpcode = b.deptid  "
				+ "/~ and t.EMPCODE = '[empcode]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.INDATE = '[indate]' ~/"
				+ "/~ and t.LEFTDATE = '[leftdate]' ~/"
				+ "/~ and t.EMPTYPE = '[emptype]' ~/"
				+ "/~ and t.DEMO = '[demo]' ~/"
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
	
	
	private String createSql = "insert into T_EMPWORKLOG " 
		 + " (WORKLOGID,EMPCODE,CPCODE,INDATE,LEFTDATE,EMPTYPE,DEMO) " 
		 + " values "
		 + " (?,?,?,?,?,?,?)";
	private String updateSql = "update T_EMPWORKLOG set "
		+ " WORKLOGID=?,EMPCODE=?,CPCODE=?,INDATE=?,LEFTDATE=?,EMPTYPE=?,DEMO=? "
		+ " where WORKLOGID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tempworklog entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getWorklogid());
						ps.setString(2, entity.getEmpcode());
						ps.setString(3, entity.getCpcode());
						ps.setString(4, entity.getIndate());
						ps.setString(5, entity.getLeftdate());
						ps.setString(6, entity.getEmptype());
						ps.setString(7, entity.getDemo());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTempworklog(final Tempworklog entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getWorklogid());
				ps.setString(2, entity.getEmpcode());
				ps.setString(3, entity.getCpcode());
				ps.setString(4, entity.getIndate());
				ps.setString(5, entity.getLeftdate());
				ps.setString(6, entity.getEmptype());
				ps.setString(7, entity.getDemo());
			}
		});
	}

	
	public void updateTempworklog(final Tempworklog entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getWorklogid());
				ps.setString(2, entity.getEmpcode());
				ps.setString(3, entity.getCpcode());
				ps.setString(4, entity.getIndate());
				ps.setString(5, entity.getLeftdate());
				ps.setString(6, entity.getEmptype());
				ps.setString(7, entity.getDemo());
			}
		});
	}

	
	public void deleteTempworklog(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
