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
public class TcarinfohotelDao extends BaseSpringJdbcDao<Tcarinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcarinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "enrolid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ENROLID as enrolid,"
				+" CAROWNER as carowner,"
				+" CARTYPE as cartype,"
				+" BRAND as brand,"
				+" COLOR as color,"
				+" CARID as carid,"
				+" ENGINECODE as enginecode,"
				+" BODYCODE as bodycode,"
				+" ENROLTIME as enroltime,"
				+" OPERATOR as operator,"
				+" CPCODE as cpcode,"
				+" FLAG as flag,"
				+" hotel.called hotelname"
				+" from T_HOTEL hotel, T_CARINFO t";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARINFO t where hotel.code=t.CPCODE and ENROLID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where hotel.code=t.CPCODE and ENROLID=? ";
	}
	
	public void save(Tcarinfo entity) {
		String sql = "insert into T_CARINFO " 
			 + " (ENROLID,CAROWNER,CARTYPE,BRAND,COLOR,CARID,ENGINECODE,BODYCODE,ENROLTIME,OPERATOR,CPCODE,FLAG,CARPICTURE) " 
			 + " values "
			 + " (:enrolid,:carowner,:cartype,:brand,:color,:carid,:enginecode,:bodycode,:enroltime,:operator,:cpcode,:flag,:carpicture)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CARINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarinfo entity) {
		String sql = "update T_CARINFO set "
					+ " ENROLID=:enrolid,CAROWNER=:carowner,CARTYPE=:cartype,BRAND=:brand,COLOR=:color,CARID=:carid,ENGINECODE=:enginecode,BODYCODE=:bodycode,ENROLTIME=:enroltime,OPERATOR=:operator,CPCODE=:cpcode,FLAG=:flag,CARPICTURE=:carpicture "
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
		String sql = getSelectPrefix() + " where hotel.code=t.CPCODE "
				+ "/~ and t.CAROWNER = '[carowner]' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.BRAND = '[brand]' ~/"
				+ "/~ and t.COLOR = '[color]' ~/"
				+ "/~ and t.CARID = '[carid]' ~/"
				+ "/~ and t.ENGINECODE = '[enginecode]' ~/"
				+ "/~ and t.BODYCODE = '[bodycode]' ~/"
				+ "/~ and t.ENROLTIME = '[enroltime]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.CARPICTURE = '[carpicture]' ~/"
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
	
	
	private String createSql = "insert into T_CARINFO " 
		 + " (ENROLID,CAROWNER,CARTYPE,BRAND,COLOR,CARID,ENGINECODE,BODYCODE,ENROLTIME,OPERATOR,CPCODE,FLAG,CARPICTURE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CARINFO set "
		+ " ENROLID=?,CAROWNER=?,CARTYPE=?,BRAND=?,COLOR=?,CARID=?,ENGINECODE=?,BODYCODE=?,ENROLTIME=?,OPERATOR=?,CPCODE=?,FLAG=?,CARPICTURE=? "
		+ " where ENROLID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcarinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getEnrolid());
						ps.setString(2, entity.getCarowner());
						ps.setString(3, entity.getCartype());
						ps.setString(4, entity.getBrand());
						ps.setString(5, entity.getColor());
						ps.setString(6, entity.getCarid());
						ps.setString(7, entity.getEnginecode());
						ps.setString(8, entity.getBodycode());
						ps.setString(9, entity.getEnroltime());
						ps.setString(10, entity.getOperator());
						ps.setString(11, entity.getCpcode());
						ps.setString(12, entity.getFlag());
						ps.setBlob(13, entity.getCarpicture());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcarinfo(final Tcarinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEnrolid());
				ps.setString(2, entity.getCarowner());
				ps.setString(3, entity.getCartype());
				ps.setString(4, entity.getBrand());
				ps.setString(5, entity.getColor());
				ps.setString(6, entity.getCarid());
				ps.setString(7, entity.getEnginecode());
				ps.setString(8, entity.getBodycode());
				ps.setString(9, entity.getEnroltime());
				ps.setString(10, entity.getOperator());
				ps.setString(11, entity.getCpcode());
				ps.setString(12, entity.getFlag());
				ps.setBlob(13, entity.getCarpicture());
			}
		});
	}

	
	public void updateTcarinfo(final Tcarinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getEnrolid());
				ps.setString(2, entity.getCarowner());
				ps.setString(3, entity.getCartype());
				ps.setString(4, entity.getBrand());
				ps.setString(5, entity.getColor());
				ps.setString(6, entity.getCarid());
				ps.setString(7, entity.getEnginecode());
				ps.setString(8, entity.getBodycode());
				ps.setString(9, entity.getEnroltime());
				ps.setString(10, entity.getOperator());
				ps.setString(11, entity.getCpcode());
				ps.setString(12, entity.getFlag());
				ps.setBlob(13, entity.getCarpicture());
			}
		});
	}

	
	public void deleteTcarinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}

	// 取得照片
	public List getPic(String ENROLID) {
		String sql = "select ENROLID,CARPICTURE from T_CARINFO where ENROLID = ? ";
	       return getJdbcTemplate().query(sql, new String[] {ENROLID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    String ID = rs.getString(1);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "CARPICTURE");
		           // System.out.println("blobBytes="+blobBytes);
		            results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        return results;
	           }
	           
	       });
	   }

	public List getPicture(String sql) {
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, 1);
		            results.put("PICTURE", blobBytes);
			        return results;
	           }
	           
	       });
	}

	
	
	

}
