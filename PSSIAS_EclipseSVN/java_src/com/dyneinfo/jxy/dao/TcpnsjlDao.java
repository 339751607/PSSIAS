/*
z * Powered By [lishicheng]
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
public class TcpnsjlDao extends BaseSpringJdbcDao<Tcpnsjl,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcpnsjl.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.CPCODE as cpcode,"
				+" t.SHND as shnd,"
				+" t.SHRJ as shrj,"
				+" t.NSYJ as nsyj,"
				+" t.QSR as qsr,"
				+" t.JBR as jbr," +
				"	cp.cpname as name "
				+" from T_CPNSJL t,t_companyinfo cp,ss_dept d" +
						" where t.cpcode = cp.cpcode and d.deptid=cp.cpcode";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPNSJL where CPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and t.CPCODE=? ";
	}
	
	public void save(Tcpnsjl entity) {
		String sql = "insert into T_CPNSJL " 
			 + " (CPCODE,SHND,SHRJ,NSYJ,QSR,JBR) " 
			 + " values "
			 + " (:cpcode,:shnd,:shrj,:nsyj,:qsr,:jbr)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CPNSJL",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcpnsjl entity) {
		String sql = "update T_CPNSJL set "
					+ " CPCODE=:cpcode,SHND=:shnd,SHRJ=:shrj,NSYJ=:nsyj,QSR=:qsr,JBR=:jbr "
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
		+ "/~ and t.cpcode like '[cpcode]' ~/"
				+ "/~ and t.SHRJ like '%[shrj]%' ~/"
				+ "/~ and t.NSYJ like '%[nsyj]%' ~/"
				+ "/~ and t.QSR like '%[qsr]%' ~/"
				+ "/~ and t.JBR like '%[jbr]%' ~/"
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
	
	
	private String createSql = "insert into T_CPNSJL " 
		 + " (CPCODE,SHND,SHRJ,NSYJ,QSR,JBR) " 
		 + " values "
		 + " (?,?,?,?,?,?)";
	private String updateSql = "update T_CPNSJL set "
		+ " CPCODE=?,SHND=?,SHRJ=?,NSYJ=?,QSR=?,JBR=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcpnsjl entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getShnd());
						ps.setString(3, entity.getShrj());
						ps.setString(4, entity.getNsyj());
						ps.setString(5, entity.getQsr());
						ps.setString(6, entity.getJbr());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpnsjl(final Tcpnsjl entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getShnd());
				ps.setString(3, entity.getShrj());
				ps.setString(4, entity.getNsyj());
				ps.setString(5, entity.getQsr());
				ps.setString(6, entity.getJbr());
			}
		});
	}

	
	public void updateTcpnsjl(final Tcpnsjl entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getShnd());
				ps.setString(3, entity.getShrj());
				ps.setString(4, entity.getNsyj());
				ps.setString(5, entity.getQsr());
				ps.setString(6, entity.getJbr());
			}
		});
	}

	
	public void deleteTcpnsjl(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	public Tcpnsjl getbyid(String cpcode,String shnd){
		String sql = getSelectPrefix() + " and t.CPCODE='"+cpcode+"' and t.shnd='"+shnd+"' ";	
		List list = getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
		return (Tcpnsjl)CollectionHelper.findSingleObject(list);
		
	}
	public int Tcpnsjl(String shnr ,String cpcode){
		String sql = "select count(*)  from T_CPNSJL where shnd = ? and cpcode = ?";
		int count = 0;
		try {   
			count = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {shnr,cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	public int Tcpnsjlbyid(String cpcode){
		String sql = "select count(*)  from T_CPNSJL where  cpcode = ?";
		int count = 0;
		try {   
			count = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return count;
	}
	public void edit(Tcpnsjl entity){
		String sql = "update T_CPNSJL set shnd=:shnd,shrj=:shrj,nsyj=:nsyj,qsr=:qsr,jbr=:jbr where cpcode=:cpcode and shnd=:shnd";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));


	}
	public String find(String cpcode){
		String sql = "select cpname from t_companyinfo where cpcode = '"+cpcode+"'";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		return fjmc;
	}
	
	
	

}
