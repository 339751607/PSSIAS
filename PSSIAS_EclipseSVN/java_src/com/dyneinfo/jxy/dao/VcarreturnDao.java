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
public class VcarreturnDao extends BaseSpringJdbcDao<Vcarreturn,java.lang.String>{
	
	public Class getEntityClass() {
		return Vcarreturn.class;
	}
	
	public String getIdentifierPropertyName() {
		return "enrolid";
	}
	
	public String getSelectPrefix() {
		return "select " +
		"enrolid,"+
		"cpcode," +
		"cpname," +
		"station," +
		"carowner," +
		"cartype," +
		"carid," +
		"enginecode," +
		"bodycode," +
		"deliname," +
		"recename," +
		"totime," +
		"recetime," +
		"carpicture" +
		" from v_carreturn ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARRETURN where ENROLID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where enrolid=? ";
	}
	
	public void save(Vcarreturn entity) {
		String sql = "insert into T_CARRETURN " 
			 + " (ENROLID,DELINAME,DELICREDTYPE,DELICREDCODE,RECETIME,RECENAME,TAKEOFFNAME,TOCREDTYPE,TOCREDCODE,TOTIME,FLAG,ENROLTIME,OPERATOR,DELITELEPHONE,SERVERITEM,DEMO,TOMOBILE) " 
			 + " values "
			 + " (:enrolid,:deliname,:delicredtype,:delicredcode,:recetime,:recename,:takeoffname,:tocredtype,:tocredcode,:totime,:flag,:enroltime,:operator,:delitelephone,:serveritem,:demo,:tomobile)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CARRETURN",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Vcarreturn entity) {
		String sql = "update T_CARRETURN set "
					+ " ENROLID=:enrolid,DELINAME=:deliname,DELICREDTYPE=:delicredtype,DELICREDCODE=:delicredcode,RECETIME=:recetime,RECENAME=:recename,TAKEOFFNAME=:takeoffname,TOCREDTYPE=:tocredtype,TOCREDCODE=:tocredcode,TOTIME=:totime,FLAG=:flag,ENROLTIME=:enroltime,OPERATOR=:operator,DELITELEPHONE=:delitelephone,SERVERITEM=:serveritem,DEMO=:demo,TOMOBILE=:tomobile "
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
		
	
		String hsql="select " +
				"enrolid,"+
				"cpcode," +
				"cpname," +
				"station," +
				"carowner," +
				"cartype," +
				"carid," +
				"enginecode," +
				"bodycode," +
				"deliname," +
				"recename," +
				"totime," +
				"recetime," +
				"carpicture" +
				" from v_carreturn ";
		String sql = hsql + " t ,ss_dept d where 1=1 and d.deptid=t.cpcode "
				+ "/~ and d.deptSeq like '[deptSeq]%' ~/"
				+ "/~ and t.cpcode = '[cpcode]' ~/"
				+ "/~ and t.color  like '%[color]%' ~/"
				+ "/~ and t.cpname like '%[cpname]%' ~/"
				+ "/~ and t.carowner like '%[carowner]%' ~/"
				+ "/~ and t.carid like '%[carid]%' ~/"
				+ "/~ and t.enginecode like '%[enginecode]%' ~/"	
				+ "/~ and t.SERVERITEM like '%[serveritem]%' ~/"
				+ "/~ and t.recename like '%[recename]%' ~/"
				+ "/~ and t.brand like '%[brand]%' ~/"
//				+ "/~ and t.totime >= to_date('[birthBeginFormat] 00:00:00','yyyy-MM-dd HH24:mi:ss') ~/"
////				+ "/~ and t.totime <= to_date('[birthEndFormat] 23:59:59','yyyy-MM-dd HH24:mi:ss')~/"
////				+ "/~ and t.recetime >= to_date('[indateBeginFormat] 00:00:00','yyyy-MM-dd HH24:mi:ss')' ~/"
////				+ "/~ and t.recetime <= to_date('[indateEndFormat] 23:59:59','yyyy-MM-dd HH24:mi:ss')' ~/"		
				+ "/~ and t.totime >= '[birthBeginFormat]' ~/"
				+ "/~ and t.totime <= '[birthEndFormat]' ~/"
				+ "/~ and t.recetime >= '[indateBeginFormat]' ~/"
				+ "/~ and t.recetime <= '[indateEndFormat]' ~/"			
				+ "/~ and t.bodycode = '[bodycode]' ~/"
				+ "/~ and t.deliname = '[deliname]' ~/"
				+ "/~ and t.cartyp = '[cartype]' ~/"	
				
				+ "/~ and t.totime = '[totime]' ~/"
				+ "/~ and t.recetime = '[recetime]' ~/"
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
	
	
	private String createSql = "insert into T_CARRETURN " 
		 + " (ENROLID,DELINAME,DELICREDTYPE,DELICREDCODE,RECETIME,RECENAME,TAKEOFFNAME,TOCREDTYPE,TOCREDCODE,TOTIME,FLAG,ENROLTIME,OPERATOR,DELITELEPHONE,SERVERITEM,DEMO,TOMOBILE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CARRETURN set "
		+ " ENROLID=?,DELINAME=?,DELICREDTYPE=?,DELICREDCODE=?,RECETIME=?,RECENAME=?,TAKEOFFNAME=?,TOCREDTYPE=?,TOCREDCODE=?,TOTIME=?,FLAG=?,ENROLTIME=?,OPERATOR=?,DELITELEPHONE=?,SERVERITEM=?,DEMO=?,TOMOBILE=? "
		+ " where ENROLID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
//	public void savePic(File file, final Vcarreturn entity) throws IOException {
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
//		getJdbcTemplate().execute(createSql,
//				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
//					protected void setValues(PreparedStatement ps,
//							LobCreator lobCreator) throws SQLException {
//						ps.setString(1, entity.getEnrolid());
//						ps.setString(2, entity.getDeliname());
//						ps.setString(3, entity.getDelicredtype());
//						ps.setString(4, entity.getDelicredcode());
//						ps.setString(5, entity.getRecetime());
//						ps.setString(6, entity.getRecename());
//						ps.setString(7, entity.getTakeoffname());
//						ps.setString(8, entity.getTocredtype());
//						ps.setString(9, entity.getTocredcode());
//						ps.setString(10, entity.getTotime());
//						ps.setString(11, entity.getFlag());
//						ps.setString(12, entity.getEnroltime());
//						ps.setString(13, entity.getOperator());
//						ps.setString(14, entity.getDelitelephone());
//						ps.setString(15, entity.getServeritem());
//						ps.setString(16, entity.getDemo());
//						ps.setString(17, entity.getTomobile());
//						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
//					}
//				});
//		blobIs.close();
//	}
	
	
//	public void createVcarreturn(final Vcarreturn entity) {
//		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, entity.getEnrolid());
//				ps.setString(2, entity.getDeliname());
//				ps.setString(3, entity.getDelicredtype());
//				ps.setString(4, entity.getDelicredcode());
//				ps.setString(5, entity.getRecetime());
//				ps.setString(6, entity.getRecename());
//				ps.setString(7, entity.getTakeoffname());
//				ps.setString(8, entity.getTocredtype());
//				ps.setString(9, entity.getTocredcode());
//				ps.setString(10, entity.getTotime());
//				ps.setString(11, entity.getFlag());
//				ps.setString(12, entity.getEnroltime());
//				ps.setString(13, entity.getOperator());
//				ps.setString(14, entity.getDelitelephone());
//				ps.setString(15, entity.getServeritem());
//				ps.setString(16, entity.getDemo());
//				ps.setString(17, entity.getTomobile());
//			}
//		});
//	}

	
//	public void updateVcarreturn(final Vcarreturn entity) {
//		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, entity.getEnrolid());
//				ps.setString(2, entity.getDeliname());
//				ps.setString(3, entity.getDelicredtype());
//				ps.setString(4, entity.getDelicredcode());
//				ps.setString(5, entity.getRecetime());
//				ps.setString(6, entity.getRecename());
//				ps.setString(7, entity.getTakeoffname());
//				ps.setString(8, entity.getTocredtype());
//				ps.setString(9, entity.getTocredcode());
//				ps.setString(10, entity.getTotime());
//				ps.setString(11, entity.getFlag());
//				ps.setString(12, entity.getEnroltime());
//				ps.setString(13, entity.getOperator());
//				ps.setString(14, entity.getDelitelephone());
//				ps.setString(15, entity.getServeritem());
//				ps.setString(16, entity.getDemo());
//				ps.setString(17, entity.getTomobile());
//			}
//		});
//	}

	
	public void deleteVcarreturn(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	
	

}
