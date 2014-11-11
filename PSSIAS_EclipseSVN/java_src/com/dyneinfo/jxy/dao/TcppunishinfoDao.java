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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class TcppunishinfoDao extends BaseSpringJdbcDao<Tcppunishinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcppunishinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.CPCODE as cpcode,"
				+" t.PDATE as pdate,"
				+" t.PFILENO as pfileno,"
				+" t.AUTHUNIT as authunit,"
				+" t.AUTHPERSON as authperson,"
				+" t.EXECPERSON as execperson,"
				+" t.CAUSE as cause,"
				+" t.PTYPE as ptype,"
				+" t.RANGE as range,"
				+" t.PPERSON as pperson," +
						"cp.cpname as name"
				+" from T_CPPUNISHINFO t,t_companyinfo cp,ss_dept d" +
						" where cp.cpcode = t.cpcode and d.deptid = cp.cpcode ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPPUNISHINFO where CPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and t.CPCODE=? ";
	}
	
	public void save(Tcppunishinfo entity) {
		String sql = "insert into T_CPPUNISHINFO " 
			 + " (CPCODE,PDATE,PFILENO,AUTHUNIT,AUTHPERSON,EXECPERSON,CAUSE,PTYPE,RANGE,PPERSON) " 
			 + " values "
			 + " (:cpcode,:pdate,:pfileno,:authunit,:authperson,:execperson,:cause,:ptype,:range,:pperson)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CPPUNISHINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcppunishinfo entity) {
		System.out.println(entity+"**************");
		String sql = "update T_CPPUNISHINFO set "
					+ " PDATE=:pdate,AUTHUNIT=:authunit,AUTHPERSON=:authperson,EXECPERSON=:execperson,CAUSE=:cause,PTYPE=:ptype,RANGE=:range,PPERSON=:pperson "
					+ " where CPCODE=:cpcode and PFILENO=:pfileno";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " "
		+ "/~ and d.deptSeq like '[deptSeq]%' ~/"
				+ "/~ and cp.cpcode like '%[cpcode]%' ~/"
				+ "/~ and t.PDATE like '%[pdate]%' ~/"
				+ "/~ and t.AUTHUNIT like '%[authunit]%' ~/"
				+ "/~ and t.AUTHPERSON like '%[authperson]%' ~/"
				+ "/~ and t.EXECPERSON like '%[execperson]%' ~/"
				+ "/~ and t.CAUSE like '%[cause]%' ~/"
				+ "/~ and t.PTYPE like '%[ptype]%' ~/"
				+ "/~ and t.RANGE like '%[range]%' ~/"
				+ "/~ and t.PPERSON like '%[pperson]%' ~/"
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
	
	
	private String createSql = "insert into T_CPPUNISHINFO " 
		 + " (CPCODE,PDATE,PFILENO,AUTHUNIT,AUTHPERSON,EXECPERSON,CAUSE,PTYPE,RANGE,PPERSON) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CPPUNISHINFO set "
		+ " CPCODE=?,PDATE=?,PFILENO=?,AUTHUNIT=?,AUTHPERSON=?,EXECPERSON=?,CAUSE=?,PTYPE=?,RANGE=?,PPERSON=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcppunishinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getPdate());
						ps.setString(3, entity.getPfileno());
						ps.setString(4, entity.getAuthunit());
						ps.setString(5, entity.getAuthperson());
						ps.setString(6, entity.getExecperson());
						ps.setString(7, entity.getCause());
						ps.setString(8, entity.getPtype());
						ps.setString(9, entity.getRange());
						ps.setString(10, entity.getPperson());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcppunishinfo(final Tcppunishinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getPdate());
				ps.setString(3, entity.getPfileno());
				ps.setString(4, entity.getAuthunit());
				ps.setString(5, entity.getAuthperson());
				ps.setString(6, entity.getExecperson());
				ps.setString(7, entity.getCause());
				ps.setString(8, entity.getPtype());
				ps.setString(9, entity.getRange());
				ps.setString(10, entity.getPperson());
			}
		});
	}

	
	public void updateTcppunishinfo(final Tcppunishinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getPdate());
				ps.setString(3, entity.getPfileno());
				ps.setString(4, entity.getAuthunit());
				ps.setString(5, entity.getAuthperson());
				ps.setString(6, entity.getExecperson());
				ps.setString(7, entity.getCause());
				ps.setString(8, entity.getPtype());
				ps.setString(9, entity.getRange());
				ps.setString(10, entity.getPperson());
			}
		});
	}

	
	public void deleteTcppunishinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	public Tcppunishinfo finbyid(String cpcode,String pfileno){
		String sql = "select * from T_CPPUNISHINFO where cpcode = '"+cpcode+"' and pfileno= '"+pfileno+"'";
		List list = getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		return (Tcppunishinfo)CollectionHelper.findSingleObject(list);
	}
	public void deleteById1(String cpcode,String pfileno){
		String sql = "delete from T_CPPUNISHINFO where CPCODE= :cpcode and pfileno = :pfileno";
		Map namedParameters = new HashMap();
		namedParameters.put("cpcode", cpcode);
		namedParameters.put("pfileno", pfileno);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
		
		

	}
	public int Tcpnsjl(String cpcode ,String pfileno){
		String sql = "select count(*)  from T_CPPUNISHINFO where  pfileno = ?";
		int count = 0;
		try {   
			count = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {pfileno} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	
	

}
