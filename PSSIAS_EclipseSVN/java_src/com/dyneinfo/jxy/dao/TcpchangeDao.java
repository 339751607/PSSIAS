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
public class TcpchangeDao extends BaseSpringJdbcDao<Tcpchange,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcpchange.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.CPCODE as cpcode,"
				+" t.CHANGEDATE as changedate,"
				+" t.CHANGECODE as changecode,"
				+" t.BEFORECONTEN as beforeconten,"
				+" t.AFTERCONTENT as aftercontent," +
						"cp.cpname as name"
				
				+" from T_CPCHANGE t, "
				+" t_companyinfo cp,ss_dept d"
				+"  where t.cpcode=cp.cpcode and d.deptid=cp.cpcode";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPCHANGE where CPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and t.CPCODE=? ";
	}
	
	public void save(Tcpchange entity) {
		String sql = "insert into T_CPCHANGE " 
			 + " (CPCODE,CHANGEDATE,CHANGECODE,BEFORECONTEN,AFTERCONTENT) " 
			 + " values "
			 + " (:cpcode,:changedate,:changecode,:beforeconten,:aftercontent)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CPCHANGE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcpchange entity) {
		String sql = "update T_CPCHANGE set "
					+ " CPCODE=:cpcode,CHANGEDATE=:changedate,CHANGECODE=:changecode,BEFORECONTEN=:beforeconten,AFTERCONTENT=:aftercontent "
					+ " where CPCODE=:cpcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "  "
		+ "/~ and d.deptSeq like '[deptSeq]%' ~/"
		+ "/~ and t.cpcode like '%[cpcode]%' ~/"
				+ "/~ and t.CHANGEDATE like '%[changedate]%' ~/"
				+ "/~ and t.BEFORECONTEN like '%[beforeconten]%' ~/"
				+ "/~ and t.AFTERCONTENT like '%[aftercontent]%' ~/"
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
	
	
	private String createSql = "insert into T_CPCHANGE " 
		 + " (CPCODE,CHANGEDATE,CHANGECODE,BEFORECONTEN,AFTERCONTENT) " 
		 + " values "
		 + " (?,?,?,?,?)";
	private String updateSql = "update T_CPCHANGE set "
		+ " CPCODE=?,CHANGEDATE=?,CHANGECODE=?,BEFORECONTEN=?,AFTERCONTENT=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();		
	public void savePic(File file, final Tcpchange entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getChangedate());
						ps.setString(3, entity.getChangecode());
						ps.setString(4, entity.getBeforeconten());
						ps.setString(5, entity.getAftercontent());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpchange(final Tcpchange entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getChangedate());
				ps.setString(3, entity.getChangecode());
				ps.setString(4, entity.getBeforeconten());
				ps.setString(5, entity.getAftercontent());
			}
		});
	}

	
	public void updateTcpchange(final Tcpchange entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getChangedate());
				ps.setString(3, entity.getChangecode());
				ps.setString(4, entity.getBeforeconten());
				ps.setString(5, entity.getAftercontent());
			}
		});
	}

	
	public void deleteTcpchange(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
