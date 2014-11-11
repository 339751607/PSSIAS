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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
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
public class TemployeegasDao extends BaseSpringJdbcDao<Temployee,java.lang.String>{
	
	public Class getEntityClass() {
		return Temployee.class;
	}
	
	public String getIdentifierPropertyName() {
		return "empcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.EMPCODE as empcode,"
				+" EMPNAME as empname,"
				+" ALIAS as alias,"
				+" SEX as sex,"
				+" to_char(to_date(BIRTH,'yyyy-MM-dd'),'yyyy-MM-dd') as birth,"
				+" STATURE as stature,"
				+" WEIGHT as weight,"
				+" POSTURE as posture,"
				+" POLITYVISAGE as polityvisage,"
				+" FOLK as folk,"
				+" NATIVEPLACE as nativeplace,"
				+" t.ADDRESS as address,"
				+" NOWADRESS as nowadress,"
				+" t.PHONE as phone,"
				+" SCHOOLAGE as schoolage,"
				+" PERSONID as personid,"
				+" NPCODE as npcode,"
				+" NPADDRESS as npaddress,"
				+" TEMPORARYCODE as temporarycode,"
				+" INSERTTIME as inserttime,"
				+" EDITTIME as edittime,"
				+" HYZH as hyzh,"
				+" CYRJZT as cyrjzt,"
				+" TRATIME as tratime,"
				+" t.CPCODE as cpcode,"
				+" a.STACODE as stacode,"
				+" a.BURCODE as burcode,"
				+" to_char(to_date(b.indate,'yyyy-MM-dd'),'yyyy-MM-dd') as indate,"
				+" a.cpname as cpname,"
				+" to_char(to_date(b.leftdate,'yyyy-MM-dd'),'yyyy-MM-dd') as leftdate,"
				+" b.empduty as empduty"
				+" from T_EMPWORKLOG b,T_COMPANYINFO a ,T_EMPLOYEE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_EMPLOYEE where EMPCODE=?";
	}
	
	
	public String getCurrentMax(String prefixID) throws DataAccessException {
		 String currentPhase = "";
		 
		if(prefixID == null || "".equals(prefixID)){
			return currentPhase;
		}		   
		
		String sql = "select  max(id) as ID  from T_EMPLOYEE  where  substr(ID,0," + prefixID.length() + ") = ? ";
		Object[] obj = { prefixID };
		try {
			currentPhase = (String) this.getJdbcTemplate().queryForObject(sql, obj, String.class);
		} catch (Exception e) {
			currentPhase = "";
			e.printStackTrace();
		}
		return currentPhase;
}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + "t where t.empcode= b.empcode(+) and a.cpcode(+)= t.cpcode and t.cpcode= b.cpcode(+) and t.EMPCODE=? ";
	}
	
	public void save(Temployee entity) {
		String sql = "insert into T_EMPLOYEE " 
			 + " (EMPCODE,EMPNAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,ADDRESS,NOWADRESS,PHONE,SCHOOLAGE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,HYZH,CYRJZT,TRATIME,CPCODE,STACODE,BURCODE) " 
			 + " values "
			 + " (:empcode,:empname,:alias,:sex,:birth,:stature,:weight,:posture,:polityvisage,:folk,:nativeplace,:address,:nowadress,:phone,:schoolage,:personid,:npcode,:npaddress,:temporarycode,:inserttime,:edittime,:hyzh,:cyrjzt,:tratime,:cpcode,:stacode,:burcode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_EMPLOYEE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	
	//从业人员基本信息 取得照片
	public List getPic(String ID) {
		String sql = "select empcode as id, PICLEN, picture from T_EMP_PIC where empcode = ? ";
	       return getJdbcTemplate().query(sql, new String[] {ID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	    Long LENGTH = rs.getLong(2);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "picture");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", LENGTH);
			        return results;
	           }
	           
	       });
	   }
	
	
	public void update(Temployee entity) {
		String sql = "update T_EMPLOYEE set "
					+ " EMPCODE=:empcode,EMPNAME=:empname,ALIAS=:alias,SEX=:sex,BIRTH=:birth,STATURE=:stature,WEIGHT=:weight,POSTURE=:posture,POLITYVISAGE=:polityvisage,FOLK=:folk,NATIVEPLACE=:nativeplace,ADDRESS=:address,NOWADRESS=:nowadress,PHONE=:phone,SCHOOLAGE=:schoolage,PERSONID=:personid,NPCODE=:npcode,NPADDRESS=:npaddress,TEMPORARYCODE=:temporarycode,INSERTTIME=:inserttime,EDITTIME=:edittime,HYZH=:hyzh,CYRJZT=:cyrjzt,TRATIME=:tratime,CPCODE=:cpcode,STACODE=:stacode,BURCODE=:burcode "
					+ " where EMPCODE=:empcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where t.empcode= b.empcode and a.cpcode= t.cpcode and t.cpcode= b.cpcode "
				+ "/~ and t.EMPNAME = '[empname]' ~/"
				+ "/~ and t.ALIAS = '[alias]' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.BIRTH = '[birth]' ~/"
				+ "/~ and t.STATURE = '[stature]' ~/"
				+ "/~ and t.WEIGHT = '[weight]' ~/"
				+ "/~ and t.POSTURE = '[posture]' ~/"
				+ "/~ and t.POLITYVISAGE = '[polityvisage]' ~/"
				+ "/~ and t.FOLK = '[folk]' ~/"
				+ "/~ and t.NATIVEPLACE = '[nativeplace]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.NOWADRESS = '[nowadress]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.SCHOOLAGE = '[schoolage]' ~/"
				+ "/~ and t.PERSONID = '[personid]' ~/"
				+ "/~ and t.NPCODE = '[npcode]' ~/"
				+ "/~ and t.NPADDRESS = '[npaddress]' ~/"
				+ "/~ and t.TEMPORARYCODE = '[temporarycode]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
				+ "/~ and t.EDITTIME = '[edittime]' ~/"
				+ "/~ and t.HYZH = '[hyzh]' ~/"
				+ "/~ and t.CYRJZT = '[cyrjzt]' ~/"
				+ "/~ and b.INDATE >= '[indateBeginFormat]' ~/"
				+ "/~ and b.INDATE <= '[indateEndFormat]' ~/"
				+ "/~ and t.TRATIME = '[tratime]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.STACODE = '[stacode]' ~/"
				+ "/~ and t.BURCODE = '[burcode]' ~/"
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
	
	
	private String createSql = "insert into T_EMPLOYEE " 
		 + " (EMPCODE,EMPNAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,ADDRESS,NOWADRESS,PHONE,SCHOOLAGE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,HYZH,CYRJZT,TRATIME,CPCODE,STACODE,BURCODE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_EMPLOYEE set "
		+ " EMPCODE=?,EMPNAME=?,ALIAS=?,SEX=?,BIRTH=?,STATURE=?,WEIGHT=?,POSTURE=?,POLITYVISAGE=?,FOLK=?,NATIVEPLACE=?,ADDRESS=?,NOWADRESS=?,PHONE=?,SCHOOLAGE=?,PERSONID=?,NPCODE=?,NPADDRESS=?,TEMPORARYCODE=?,INSERTTIME=?,EDITTIME=?,HYZH=?,CYRJZT=?,TRATIME=?,CPCODE=?,STACODE=?,BURCODE=? "
		+ " where EMPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Temployee entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getEmpcode());
						ps.setString(2, entity.getEmpname());
						ps.setString(3, entity.getAlias());
						ps.setString(4, entity.getSex());
						ps.setString(5, entity.getBirth());
						ps.setString(6, entity.getStature());
						ps.setString(7, entity.getWeight());
						ps.setString(8, entity.getPosture());
						ps.setString(9, entity.getPolityvisage());
						ps.setString(10, entity.getFolk());
						ps.setString(11, entity.getNativeplace());
						ps.setString(12, entity.getAddress());
						ps.setString(13, entity.getNowadress());
						ps.setString(14, entity.getPhone());
						ps.setString(15, entity.getSchoolage());
						ps.setString(16, entity.getPersonid());
						ps.setString(17, entity.getNpcode());
						ps.setString(18, entity.getNpaddress());
						ps.setString(19, entity.getTemporarycode());
						ps.setString(20, entity.getInserttime());
						ps.setString(21, entity.getEdittime());
						ps.setString(22, entity.getHyzh());
						ps.setString(23, entity.getCyrjzt());
						ps.setString(24, entity.getTratime());
						ps.setString(25, entity.getCpcode());
						ps.setString(26, entity.getStacode());
						ps.setString(27, entity.getBurcode());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTemployee(final Temployee entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEmpcode());
				ps.setString(2, entity.getEmpname());
				ps.setString(3, entity.getAlias());
				ps.setString(4, entity.getSex());
				ps.setString(5, entity.getBirth());
				ps.setString(6, entity.getStature());
				ps.setString(7, entity.getWeight());
				ps.setString(8, entity.getPosture());
				ps.setString(9, entity.getPolityvisage());
				ps.setString(10, entity.getFolk());
				ps.setString(11, entity.getNativeplace());
				ps.setString(12, entity.getAddress());
				ps.setString(13, entity.getNowadress());
				ps.setString(14, entity.getPhone());
				ps.setString(15, entity.getSchoolage());
				ps.setString(16, entity.getPersonid());
				ps.setString(17, entity.getNpcode());
				ps.setString(18, entity.getNpaddress());
				ps.setString(19, entity.getTemporarycode());
				ps.setString(20, entity.getInserttime());
				ps.setString(21, entity.getEdittime());
				ps.setString(22, entity.getHyzh());
				ps.setString(23, entity.getCyrjzt());
				ps.setString(24, entity.getTratime());
				ps.setString(25, entity.getCpcode());
				ps.setString(26, entity.getStacode());
				ps.setString(27, entity.getBurcode());
			}
		});
	}

	
	public void updateTemployee(final Temployee entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEmpcode());
				ps.setString(2, entity.getEmpname());
				ps.setString(3, entity.getAlias());
				ps.setString(4, entity.getSex());
				ps.setString(5, entity.getBirth());
				ps.setString(6, entity.getStature());
				ps.setString(7, entity.getWeight());
				ps.setString(8, entity.getPosture());
				ps.setString(9, entity.getPolityvisage());
				ps.setString(10, entity.getFolk());
				ps.setString(11, entity.getNativeplace());
				ps.setString(12, entity.getAddress());
				ps.setString(13, entity.getNowadress());
				ps.setString(14, entity.getPhone());
				ps.setString(15, entity.getSchoolage());
				ps.setString(16, entity.getPersonid());
				ps.setString(17, entity.getNpcode());
				ps.setString(18, entity.getNpaddress());
				ps.setString(19, entity.getTemporarycode());
				ps.setString(20, entity.getInserttime());
				ps.setString(21, entity.getEdittime());
				ps.setString(22, entity.getHyzh());
				ps.setString(23, entity.getCyrjzt());
				ps.setString(24, entity.getTratime());
				ps.setString(25, entity.getCpcode());
				ps.setString(26, entity.getStacode());
				ps.setString(27, entity.getBurcode());
			}
		});
	}

	
	public void deleteTemployee(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
