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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.dao.TpersonlogJnDao.MapRowMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcarlogDao extends BaseSpringJdbcDao<Tcarlog,java.lang.Long>{
	
	public Class getEntityClass() {
		return Tcarlog.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" CARBASEID as carbaseid,"
				+" SOURCE as source,"
				+" SID as sid,"
				+" CARTYPE as cartype,"
				+" STARTTIME as starttime,"
				+" ENDTIME as endtime,"
				+" INSERTTIME as inserttime,"
				+" UPDATETIME as updatetime,"
				+" TABLEFORPIC as tableforpic,"
				+" FIELDFORPIC as fieldforpic,"
				+" CPCODE as cpcode,"
				+" KEYFORPIC as keyforpic,"
				+" CARID as carid"
				+" from T_CARLOG ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARLOG where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(Tcarlog entity) {
		String sql = "insert into T_CARLOG " 
			 + " (ID,CARBASEID,SOURCE,SID,CARTYPE,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,CPCODE,KEYFORPIC,CARID) " 
			 + " values "
			 + " (:id,:carbaseid,:source,:sid,:cartype,:starttime,:endtime,:inserttime,:updatetime,:tableforpic,:fieldforpic,:cpcode,:keyforpic,:carid)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CARLOG",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarlog entity) {
		String sql = "update T_CARLOG set "
					+ " ID=:id,CARBASEID=:carbaseid,SOURCE=:source,SID=:sid,CARTYPE=:cartype,STARTTIME=:starttime,ENDTIME=:endtime,INSERTTIME=:inserttime,UPDATETIME=:updatetime,TABLEFORPIC=:tableforpic,FIELDFORPIC=:fieldforpic,CPCODE=:cpcode,KEYFORPIC=:keyforpic,CARID=:carid "
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
				+ "/~ and t.CARBASEID = '[carbaseid]' ~/"
				+ "/~ and t.SOURCE in ([source]) ~/"
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
				+ "/~ and t.CARID = '[carid]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	public Page findLogsInfoByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql =  "select  "
			+" ID as id,"
			+" CARBASEID as carbaseid,"
			+" SOURCE as source,"
			+" SID as sid,"
			+" CARTYPE as cartype,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" INSERTTIME as inserttime,"
			+" UPDATETIME as updatetime,"
			+" TABLEFORPIC as tableforpic,"
			+" FIELDFORPIC as fieldforpic,"
			+" t.CPCODE as cpcode,"
			+" KEYFORPIC as keyforpic,"
			+" CARID as carid, "
			+" c.CPNAME as cpname"
			+" from T_CARLOG  t  , T_COMPANYINFO c "
			+" where t.cpcode = c.cpcode(+) "
			+" and t.SOURCE in (select code from SS_DATASOURCE where isvalid='1' ) "
			+ "/~ and t.CARBASEID = '[carbaseid]' ~/"
			+ "/~ and t.SID = '[sid]' ~/"
			+ "/~ and t.CARTYPE = '[cartype]' ~/"
			+ "/~ and t.STARTTIME >= '[starttime]' ~/"
			+ "/~ and t.STARTTIME <= '[endtime]' ~/"
			+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
			+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
			+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
			+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
			+ "/~ and t.CPCODE = '[cpcode]' ~/"
			+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
			+ "/~ and t.CARID = '[carid]' ~/"
			+ " order by t.STARTTIME DESC ";
		return pageQuery(sql,pageRequest);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql =  "select  "
			+" ID as id,"
			+" CARBASEID as carbaseid,"
			+" SOURCE as source,"
			+" SID as sid,"
			+" CARTYPE as cartype,"
			+" STARTTIME as starttime,"
			+" ENDTIME as endtime,"
			+" INSERTTIME as inserttime,"
			+" UPDATETIME as updatetime,"
			+" TABLEFORPIC as tableforpic,"
			+" FIELDFORPIC as fieldforpic,"
			+" t.CPCODE as cpcode,"
			+" KEYFORPIC as keyforpic,"
			+" CARID as carid, "
			+" c.CPNAME as cpname"
			+" from T_CARLOG  t  , T_COMPANYINFO c "
			+" where t.cpcode = c.cpcode(+) "
			+" /~ and t.SOURCE in ([source]) ~/ "
			+ "/~ and t.CARBASEID = '[carbaseid]' ~/"
			+ "/~ and t.SID = '[sid]' ~/"
			+ "/~ and t.CARTYPE = '[cartype]' ~/"
			+ "/~ and t.STARTTIME >= '[starttime]' ~/"
			+ "/~ and t.STARTTIME <= '[endtime]' ~/"
			+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
			+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
			+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
			+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
			+ "/~ and t.CPCODE = '[cpcode]' ~/"
			+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
			+ "/~ and t.CARID = '[carid]' ~/"
			+ " order by t.STARTTIME DESC ";
		return pageQuery(sql,pageRequest);
	}
	
	public List getLogCountByBusinessCode(String source , String carid ,  String starttime , String endtime) {
		
		String subSQL = " SELECT COUNT(*) FROM T_CARLOG p "
		+ " WHERE p.SOURCE in ( " + source + " ) AND p.CARID = ?  "
		+ " AND p.CARTYPE = d.dictid ";
		
		if(starttime !=null && !"".equals(starttime)){
		   subSQL = subSQL + " AND p.STARTTIME >= '"+starttime+"' " ;
		}
		if(endtime !=null && !"".equals(endtime)){
		   subSQL = subSQL + " AND p.STARTTIME <= '"+endtime+"' " ;
		}
		
		String sql = " SELECT d.dictid as code , d.dictname as name , (" + subSQL + ") as count FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE' "
	               + " ORDER BY d.dictid ";		
		
		String countsql = "Select count(*) FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE' ";
		int count = getJdbcTemplate().queryForInt(countsql);
		List mapList = null;
		if(count>=0){
		   mapList = getJdbcTemplate().query(sql, new Object[] { carid }, new MapRowMapper());
		}
		return mapList;
		
	}	
    protected class MapRowMapper implements RowMapper{
    	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    		// TODO Auto-generated method stub
    		HashMap map  = new HashMap();
    		map.put("code", rs.getString("code"));
    		map.put("name", rs.getString("name"));
    		map.put("count", rs.getInt("count"));
    		return map;
    	}
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
	
	
	private String createSql = "insert into T_CARLOG " 
		 + " (ID,CARBASEID,SOURCE,SID,CARTYPE,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,CPCODE,KEYFORPIC,CARID) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CARLOG set "
		+ " ID=?,CARBASEID=?,SOURCE=?,SID=?,CARTYPE=?,STARTTIME=?,ENDTIME=?,INSERTTIME=?,UPDATETIME=?,TABLEFORPIC=?,FIELDFORPIC=?,CPCODE=?,KEYFORPIC=?,CARID=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcarlog entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setLong(2, entity.getCarbaseid());
						ps.setString(3, entity.getSource());
						ps.setString(4, entity.getSid());
						ps.setString(5, entity.getCartype());
						ps.setString(6, entity.getStarttime());
						ps.setString(7, entity.getEndtime());
						ps.setDate(8, (java.sql.Date)entity.getInserttime());
						ps.setDate(9, (java.sql.Date)entity.getUpdatetime());
						ps.setString(10, entity.getTableforpic());
						ps.setString(11, entity.getFieldforpic());
						ps.setString(12, entity.getCpcode());
						ps.setString(13, entity.getKeyforpic());
						ps.setString(14, entity.getCarid());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcarlog(final Tcarlog entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getCarbaseid());
				ps.setString(3, entity.getSource());
				ps.setString(4, entity.getSid());
				ps.setString(5, entity.getCartype());
				ps.setString(6, entity.getStarttime());
				ps.setString(7, entity.getEndtime());
				ps.setDate(8, (java.sql.Date)entity.getInserttime());
				ps.setDate(9, (java.sql.Date)entity.getUpdatetime());
				ps.setString(10, entity.getTableforpic());
				ps.setString(11, entity.getFieldforpic());
				ps.setString(12, entity.getCpcode());
				ps.setString(13, entity.getKeyforpic());
				ps.setString(14, entity.getCarid());
			}
		});
	}

	
	public void updateTcarlog(final Tcarlog entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getCarbaseid());
				ps.setString(3, entity.getSource());
				ps.setString(4, entity.getSid());
				ps.setString(5, entity.getCartype());
				ps.setString(6, entity.getStarttime());
				ps.setString(7, entity.getEndtime());
				ps.setDate(8, (java.sql.Date)entity.getInserttime());
				ps.setDate(9, (java.sql.Date)entity.getUpdatetime());
				ps.setString(10, entity.getTableforpic());
				ps.setString(11, entity.getFieldforpic());
				ps.setString(12, entity.getCpcode());
				ps.setString(13, entity.getKeyforpic());
				ps.setString(14, entity.getCarid());
			}
		});
	}

	
	public void deleteTcarlog(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
