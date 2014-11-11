/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcarbaseDao extends BaseSpringJdbcDao<Tcarbase,Long>{
	
	public Class getEntityClass() {
		return Tcarbase.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" CAROWNER as carowner,"
				+" CARTYPE as cartype,"
				+" BRAND as brand,"
				+" CARMODE as carmode,"
				+" COLOR as color,"
				+" CARID as carid,"
				+" ENGINECODE as enginecode,"
				+" BODYCODE as bodycode,"
				+" UPDATETIME as updatetime"
				+" from T_CARBASE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARBASE where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(Tcarbase entity) {
		String sql = "insert into T_CARBASE " 
			 + " (ID,CAROWNER,CARTYPE,BRAND,CARMODE,COLOR,CARID,ENGINECODE,BODYCODE,UPDATETIME) " 
			 + " values "
			 + " (:id,:carowner,:cartype,:brand,:carmode,:color,:carid,:enginecode,:bodycode,:updatetime)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CARBASE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarbase entity) {
		String sql = "update T_CARBASE set "
					+ " ID=:id,CAROWNER=:carowner,CARTYPE=:cartype,BRAND=:brand,CARMODE=:carmode,COLOR=:color,CARID=:carid,ENGINECODE=:enginecode,BODYCODE=:bodycode,UPDATETIME=:updatetime "
					+ " where ID=:id";
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
				+ "/~ and t.CAROWNER like '%[carowner]%' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.BRAND = '[brand]' ~/"
				+ "/~ and t.CARMODE = '[carmode]' ~/"
				+ "/~ and t.COLOR = '[color]' ~/"
				+ "/~ and t.CARID like '%[carid]%' ~/"
				+ "/~ and t.ENGINECODE like '%[enginecode]%' ~/"
				+ "/~ and t.BODYCODE like '%[bodycode]%' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
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
	
	
	private String createSql = "insert into T_CARBASE " 
		 + " (ID,CAROWNER,CARTYPE,BRAND,CARMODE,COLOR,CARID,ENGINECODE,BODYCODE,UPDATETIME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CARBASE set "
		+ " ID=?,CAROWNER=?,CARTYPE=?,BRAND=?,CARMODE=?,COLOR=?,CARID=?,ENGINECODE=?,BODYCODE=?,UPDATETIME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcarbase entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getCarowner());
						ps.setString(3, entity.getCartype());
						ps.setString(4, entity.getBrand());
						ps.setString(5, entity.getCarmode());
						ps.setString(6, entity.getColor());
						ps.setString(7, entity.getCarid());
						ps.setString(8, entity.getEnginecode());
						ps.setString(9, entity.getBodycode());
						ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcarbase(final Tcarbase entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getCarowner());
				ps.setString(3, entity.getCartype());
				ps.setString(4, entity.getBrand());
				ps.setString(5, entity.getCarmode());
				ps.setString(6, entity.getColor());
				ps.setString(7, entity.getCarid());
				ps.setString(8, entity.getEnginecode());
				ps.setString(9, entity.getBodycode());
				ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void updateTcarbase(final Tcarbase entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getCarowner());
				ps.setString(3, entity.getCartype());
				ps.setString(4, entity.getBrand());
				ps.setString(5, entity.getCarmode());
				ps.setString(6, entity.getColor());
				ps.setString(7, entity.getCarid());
				ps.setString(8, entity.getEnginecode());
				ps.setString(9, entity.getBodycode());
				ps.setDate(10, (java.sql.Date)entity.getUpdatetime());
			}
		});
	}

	
	public void deleteTcarbase(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
