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
import org.springframework.dao.EmptyResultDataAccessException;
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
public class TcpcaseinfoDao extends BaseSpringJdbcDao<Tcpcaseinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcpcaseinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "cpcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.CPCODE as cpcode,"
				+" t.CASECODE as casecode,"
				+" t.HAPPENTIME as happentime,"
				+" t.CASEFLAG as caseflag,"
				+" t.CASETYPE as casetype,"
				+" t.CASEDESC as casedesc," +
				"cp.cpname as name"
				+" from  t_Companyinfo cp," 
				+" t_Cpcaseinfo t,ss_dept d " 
				+" where cp.cpcode = t.cpcode and d.deptid=t.cpcode";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPCASEINFO where CPCODE=? and CASECODE = ?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " CPCODE=? ";
	}
	
	public void save(Tcpcaseinfo entity) {
		String sql = "insert into T_CPCASEINFO " 
			 + " (CPCODE,CASECODE,HAPPENTIME,CASEFLAG,CASETYPE,CASEDESC) " 
			 + " values "
			 + " (:cpcode,:casecode,:happentime,:caseflag,:casetype,:casedesc)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CPCASEINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcpcaseinfo entity) {
		String sql = "update T_CPCASEINFO set "
					+ " HAPPENTIME=:happentime,CASEFLAG=:caseflag,CASETYPE=:casetype,CASEDESC=:casedesc "
					+ " where CPCODE=:cpcode and CASECODE=:casecode";
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
		+ "/~ and d.DEPTSEQ like '[deptSeq]%' ~/"
				+ "/~ and t.CPCODE like '%[cpcode]%' ~/"
				+ "/~ and t.CASECODE like '%[casecode]%' ~/"
				+ "/~ and t.HAPPENTIME like '%[happentime]%' ~/"
				+ "/~ and t.CASEFLAG like '%[caseflag]%' ~/"
				+ "/~ and t.CASETYPE like '%[casetype]%' ~/"
				+ "/~ and t.CASEDESC like '%[casedesc]%' ~/"
				
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
	
	
	private String createSql = "insert into T_CPCASEINFO " 
		 + " (CPCODE,CASECODE,HAPPENTIME,CASEFLAG,CASETYPE,CASEDESC,ID,FLAGPACK) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CPCASEINFO set "
		+ " CPCODE=?,CASECODE=?,HAPPENTIME=?,CASEFLAG=?,CASETYPE=?,CASEDESC=?,ID=?,FLAGPACK=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcpcaseinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getCasecode());
						ps.setString(3, entity.getHappentime());
						ps.setString(4, entity.getCaseflag());
						ps.setString(5, entity.getCasetype());
						ps.setString(6, entity.getCasedesc());
						ps.setString(7, entity.getId());
						ps.setString(8, entity.getFlagpack());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpcaseinfo(final Tcpcaseinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCasecode());
				ps.setString(3, entity.getHappentime());
				ps.setString(4, entity.getCaseflag());
				ps.setString(5, entity.getCasetype());
				ps.setString(6, entity.getCasedesc());
				ps.setString(7, entity.getId());
				ps.setString(8, entity.getFlagpack());
			}
		});
	}

	
	public void updateTcpcaseinfo(final Tcpcaseinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCasecode());
				ps.setString(3, entity.getHappentime());
				ps.setString(4, entity.getCaseflag());
				ps.setString(5, entity.getCasetype());
				ps.setString(6, entity.getCasedesc());
				ps.setString(7, entity.getId());
				ps.setString(8, entity.getFlagpack());
			}
		});
	}

	
	public void deleteTcpcaseinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public Tcpcaseinfo getById(String cpcode,String casecode ){
		String sql = getSelectPrefix()+" and t.CPCODE='"+cpcode+"' and t.CASECODE = '"+casecode+"' ";
		Tcpcaseinfo tcpinfo = null;
		tcpinfo = (Tcpcaseinfo)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		
		
		return tcpinfo;
	}
	public void deleteById1(String cpcode,String casecode){
		String sql = "delete from T_CPCASEINFO where CPCODE= :cpcode and CASECODE = :casecode";
		Map namedParameters = new HashMap();
		namedParameters.put("cpcode", cpcode);
		namedParameters.put("casecode", casecode);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
		
		

	}
	public int Tcpnsjl(String cpcode ,String casecode){
		String sql = "select count(*)  from T_CPCASEINFO where   CASECODE = ?";
		int count = 0;
		try {   
			count = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {casecode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	
	
	

}
