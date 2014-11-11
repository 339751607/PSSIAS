/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.dao;

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

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeehotelDao extends BaseSpringJdbcDao<Temployee,java.lang.String>{
	
	public Class getEntityClass() {
		return Temployee.class;
	}
	
	public String getIdentifierPropertyName() {
		return "empcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.EMPCODE as empcode,"
				+" t.EMPNAME as empname,"
				+" t.ALIAS as alias,"
				+" t.SEX as sex,"
				+" t.BIRTH as birth,"
				+" t.STATURE as stature,"
				+" t.WEIGHT as weight,"
				+" t.POSTURE as posture,"
				+" t.POLITYVISAGE as polityvisage,"
				+" t.FOLK as folk,"
				+" t.NATIVEPLACE as nativeplace,"
				+" t.ADDRESS as address,"
				+" t.NOWADRESS as nowadress,"
				+" t.PHONE as phone,"
				+" t.SCHOOLAGE as schoolage,"
				+" t.PERSONID as personid,"
				+" t.NPCODE as xzqh,"
				+" t.NPADDRESS as npaddress,"
				+" t.TEMPORARYCODE as temporarycode,"
				+" t.INSERTTIME as inserttime,"
				+" t.EDITTIME as edittime,"
				+" t.HYZH as hyzh,"
				+" t.CYRJZT as cyrjzt,"
				+" t.TRATIME as tratime,"
				+" t.INDBTIME as indbtime,"
				+" t.HOTELCODE as hotelcode,"
				+" t.STACODE as staCode,"
				+" t.BURCODE as burCode,"
				+" t.CITYCODE as citycode,"
				+" t.TRANSFLAG as transflag,"
				+" hotel.called as hotelname "
				+" from T_EMPLOYEE t, T_HOTEL hotel ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_EMPLOYEE where EMPCODE=? and t.HOTELCODE=hotel.code ";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where EMPCODE=? and t.HOTELCODE=hotel.code ";
	}
	
	public void save(Temployee entity) {
		String sql = "insert into T_EMPLOYEE " 
			 + " (EMPCODE,EMPNAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,ADDRESS,NOWADRESS,PHONE,SCHOOLAGE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,HYZH,CYRJZT,TRATIME,INDBTIME,HOTELCODE,STACODE,BURCODE,CITYCODE,TRANSFLAG) " 
			 + " values "
			 + " (:empcode,:empname,:alias,:sex,:birth,:stature,:weight,:posture,:polityvisage,:folk,:nativeplace,:address,:nowadress,:phone,:schoolage,:personid,:xzqh,:npaddress,:temporarycode,:inserttime,:edittime,:hyzh,:cyrjzt,:tratime,:indbtime,:hotelcode,:staCode,:burCode,:citycode,:transflag)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_EMPLOYEE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Temployee entity) {
		String sql = "update T_EMPLOYEE set "
					+ " EMPCODE=:empcode,EMPNAME=:empname,ALIAS=:alias,SEX=:sex,BIRTH=:birth,STATURE=:stature,WEIGHT=:weight,POSTURE=:posture,POLITYVISAGE=:polityvisage,FOLK=:folk,NATIVEPLACE=:nativeplace,ADDRESS=:address,NOWADRESS=:nowadress,PHONE=:phone,SCHOOLAGE=:schoolage,PERSONID=:personid,NPCODE=:xzqh,NPADDRESS=:npaddress,TEMPORARYCODE=:temporarycode,INSERTTIME=:inserttime,EDITTIME=:edittime,HYZH=:hyzh,CYRJZT=:cyrjzt,TRATIME=:tratime,INDBTIME=:indbtime,HOTELCODE=:hotelcode,STACODE=:staCode,BURCODE=:burCode,CITYCODE=:citycode,TRANSFLAG=:transflag "
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
		String sql = getSelectPrefix() + "  where 1=1 and t.HOTELCODE=hotel.code"
				+ "/~ and t.EMPNAME like '%[empname]%' ~/"
				+ "/~ and t.ALIAS = '[alias]' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.BIRTH >= '[bdate_BeginFormat]' ~/"
				+ "/~ and t.BIRTH <= '[bdate_EndFormat]' ~/"
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
				+ "/~ and t.PERSONID like '%[personid]%' ~/"
				+ "/~ and t.NPCODE like substr('[province]',0,2)||'%' ~/"
				+ "/~ and t.NPCODE = '[xzqh]' ~/"
				+ "/~ and t.NPADDRESS = '[npaddress]' ~/"
				+ "/~ and t.TEMPORARYCODE = '[temporarycode]' ~/"
				+ "/~ and t.INSERTTIME >= '[intime_BeginFormat]000000' ~/"
				+ "/~ and t.INSERTTIME <= '[intime_EndFormat]235959' ~/"
				+ "/~ and t.EDITTIME = '[edittime]' ~/"
				+ "/~ and t.HYZH = '[hyzh]' ~/"
				+ "/~ and t.CYRJZT = '[cyrjzt]' ~/"
				+ "/~ and t.TRATIME = '[tratime]' ~/"
				+ "/~ and t.INDBTIME = '[indbtime]' ~/"
				+ "/~ and t.HOTELCODE = '[hotelcode]' ~/"
				+ "/~ and t.STACODE = '[staCode]' ~/"
				+ "/~ and t.BURCODE = '[burCode]' ~/"
				+ "/~ and t.CITYCODE = '[citycode]' ~/"
				+ "/~ and t.TRANSFLAG = '[transflag]' ~/"
				+ "/~ and hotel.called like '%[hotelname]%' ~/"
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
		 + " (EMPCODE,EMPNAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,ADDRESS,NOWADRESS,PHONE,SCHOOLAGE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,HYZH,CYRJZT,TRATIME,INDBTIME,HOTELCODE,STACODE,BURCODE,CITYCODE,TRANSFLAG) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_EMPLOYEE set "
		+ " EMPCODE=?,EMPNAME=?,ALIAS=?,SEX=?,BIRTH=?,STATURE=?,WEIGHT=?,POSTURE=?,POLITYVISAGE=?,FOLK=?,NATIVEPLACE=?,ADDRESS=?,NOWADRESS=?,PHONE=?,SCHOOLAGE=?,PERSONID=?,NPCODE=?,NPADDRESS=?,TEMPORARYCODE=?,INSERTTIME=?,EDITTIME=?,HYZH=?,CYRJZT=?,TRATIME=?,INDBTIME=?,HOTELCODE=?,STACODE=?,BURCODE=?,CITYCODE=?,TRANSFLAG=? "
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
						ps.setString(17, entity.getXzqh());
						ps.setString(18, entity.getNpaddress());
						ps.setString(19, entity.getTemporarycode());
						ps.setString(20, entity.getInserttime());
						ps.setString(21, entity.getEdittime());
						ps.setString(22, entity.getHyzh());
						ps.setString(23, entity.getCyrjzt());
						ps.setString(24, entity.getTratime());
						ps.setString(25, entity.getIndbtime());
						ps.setString(26, entity.getHotelcode());
						ps.setString(27, entity.getStaCode());
						ps.setString(28, entity.getBurCode());
						ps.setString(29, entity.getCitycode());
						ps.setLong(30, entity.getTransflag());
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
				ps.setString(17, entity.getXzqh());
				ps.setString(18, entity.getNpaddress());
				ps.setString(19, entity.getTemporarycode());
				ps.setString(20, entity.getInserttime());
				ps.setString(21, entity.getEdittime());
				ps.setString(22, entity.getHyzh());
				ps.setString(23, entity.getCyrjzt());
				ps.setString(24, entity.getTratime());
				ps.setString(25, entity.getIndbtime());
				ps.setString(26, entity.getHotelcode());
				ps.setString(27, entity.getStaCode());
				ps.setString(28, entity.getBurCode());
				ps.setString(29, entity.getCitycode());
				ps.setLong(30, entity.getTransflag());
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
				ps.setString(17, entity.getXzqh());
				ps.setString(18, entity.getNpaddress());
				ps.setString(19, entity.getTemporarycode());
				ps.setString(20, entity.getInserttime());
				ps.setString(21, entity.getEdittime());
				ps.setString(22, entity.getHyzh());
				ps.setString(23, entity.getCyrjzt());
				ps.setString(24, entity.getTratime());
				ps.setString(25, entity.getIndbtime());
				ps.setString(26, entity.getHotelcode());
				ps.setString(27, entity.getStaCode());
				ps.setString(28, entity.getBurCode());
				ps.setString(29, entity.getCitycode());
				ps.setLong(30, entity.getTransflag());
			}
		});
	}

	
	public void deleteTemployee(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}

	public List getPic(String id) {
		String sql = "select empcode,pic from T_EMPPIC where empcode = ? ";
	       return getJdbcTemplate().query(sql, new String[] {id}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "pic");
		            results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        return results;
	           }
	           
	       });
	   }
	
	
	

}
