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
import com.dyneinfo.zazh.dao.TcompanyDao.MapRowMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonlogJnDao extends BaseSpringJdbcDao<TpersonlogJn,Long>{
	
	public Class getEntityClass() {
		return TpersonlogJn.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" PERSONID as personid,"
				+" CARDNAME as cardname,"
				+" CARDNO as cardno,"
				+" SOURCE as source,"
				+" SID as sid,"
				+" PERSONTYPE as persontype,"
				+" EMPSTATUS as empstatus,"
				+" STARTTIME as starttime,"
				+" ENDTIME as endtime,"
				+" INSERTTIME as inserttime,"
				+" UPDATETIME as updatetime,"
				+" TABLEFORPIC as tableforpic,"
				+" FIELDFORPIC as fieldforpic,"
				+" KEYFORPIC as keyforpic,"				
				+" CPCODE as cpcode"
				+" from T_PERSONLOG_JN ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_PERSONLOG_JN where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TpersonlogJn entity) {
		String sql = "insert into T_PERSONLOG_JN " 
			 + " (ID,PERSONID,CARDNAME,CARDNO,SOURCE,SID,PERSONTYPE,EMPSTATUS,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,KEYFORPIC,CPCODE) " 
			 + " values "
			 + " (:id,:personid,:cardname,:cardno,:source,:sid,:persontype,:empstatus,:starttime,:endtime,:inserttime,:updatetime,:tableforpic,:fieldforpic,:keyforpic,:cpcode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_PERSONLOG_JN",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpersonlogJn entity) {
		String sql = "update T_PERSONLOG_JN set "
					+ " ID=:id,PERSONID=:personid,CARDNAME=:cardname,CARDNO=:cardno,SOURCE=:source,SID=:sid,PERSONTYPE=:persontype,EMPSTATUS=:empstatus,STARTTIME=:starttime,ENDTIME=:endtime,INSERTTIME=:inserttime,UPDATETIME=:updatetime,TABLEFORPIC=:tableforpic,FIELDFORPIC=:fieldforpic," 
					+ " KEYFORPIC:=keyforpic , CPCODE=:cpcode "
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
				+ "/~ and t.PERSONID = '[personid]' ~/"
				+ "/~ and t.CARDNAME = '[cardname]' ~/"
				+ "/~ and t.CARDNO = '[cardno]' ~/"
				+ "/~ and t.SOURCE in ([source]) ~/"
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.PERSONTYPE = '[persontype]' ~/"
				+ "/~ and t.EMPSTATUS = '[empstatus]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"			
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public Page findLogsInfoByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select  "
				+" ID as id,"
				+" PERSONID as personid,"
				+" CARDNAME as cardname,"
				+" CARDNO as cardno,"
				+" SOURCE as source,"
				+" SID as sid,"
				+" PERSONTYPE as persontype,"
				+" EMPSTATUS as empstatus,"
				+" STARTTIME as starttime,"
				+" ENDTIME as endtime,"
				+" INSERTTIME as inserttime,"
				+" UPDATETIME as updatetime,"
				+" TABLEFORPIC as tableforpic,"
				+" FIELDFORPIC as fieldforpic,"
				+" KEYFORPIC as keyforpic,"		
				+" t.CPCODE as cpcode,"
				+" c.CPNAME as cpname"
				+" from T_PERSONLOG_JN  t , T_COMPANYINFO c " 
				+" where t.cpcode = c.cpcode(+) "
				+" and t.SOURCE in (select code from SS_DATASOURCE where isvalid='1' ) "
				+ "/~ and t.PERSONID = '[personid]' ~/"
				+ "/~ and t.CARDNAME = '[cardname]' ~/"
				+ "/~ and t.CARDNO = '[cardno]' ~/"				
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.PERSONTYPE = '[persontype]' ~/"
				+ "/~ and t.EMPSTATUS = '[empstatus]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"			
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ " order by t.STARTTIME desc  ";
		return pageQuery(sql,pageRequest);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select  "
				+" ID as id,"
				+" PERSONID as personid,"
				+" CARDNAME as cardname,"
				+" CARDNO as cardno,"
				+" SOURCE as source,"
				+" SID as sid,"
				+" PERSONTYPE as persontype,"
				+" EMPSTATUS as empstatus,"
				+" STARTTIME as starttime,"
				+" ENDTIME as endtime,"
				+" INSERTTIME as inserttime,"
				+" UPDATETIME as updatetime,"
				+" TABLEFORPIC as tableforpic,"
				+" FIELDFORPIC as fieldforpic,"
				+" KEYFORPIC as keyforpic,"		
				+" t.CPCODE as cpcode,"
				+" c.CPNAME as cpname"
				+" from T_PERSONLOG_JN  t , T_COMPANYINFO c " 
				+" where t.cpcode = c.cpcode(+) "
				+" /~ and t.SOURCE in ([source]) ~/ "
				+ "/~ and t.PERSONID = '[personid]' ~/"
				+ "/~ and t.CARDNAME = '[cardname]' ~/"
				+ "/~ and t.CARDNO = '[cardno]' ~/"				
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.PERSONTYPE = '[persontype]' ~/"
				+ "/~ and t.EMPSTATUS = '[empstatus]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"			
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.KEYFORPIC = '[keyforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ " order by t.STARTTIME desc  ";
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
	
	
	private String createSql = "insert into T_PERSONLOG_JN " 
		 + " (ID,PERSONID,CARDNAME,CARDNO,SOURCE,SID,PERSONTYPE,EMPSTATUS,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,KEYFORPIC,CPCODE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_PERSONLOG_JN set "
		+ " ID=?,PERSONID=?,CARDNAME=?,CARDNO=?,SOURCE=?,SID=?,PERSONTYPE=?,EMPSTATUS=?,STARTTIME=?,ENDTIME=?,INSERTTIME=?,UPDATETIME=?,TABLEFORPIC=?,FIELDFORPIC=?,KEYFORPIC=?, CPCODE=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpersonlogJn entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setLong(2, entity.getPersonid());
						ps.setString(3, entity.getCardname());
						ps.setString(4, entity.getCardno());
						ps.setString(5, entity.getSource());
						ps.setString(6, entity.getSid());
						ps.setString(7, entity.getPersontype());
						ps.setString(8, entity.getEmpstatus());
						ps.setString(9, entity.getStarttime());
						ps.setString(10, entity.getEndtime());
						ps.setDate(11, (java.sql.Date)entity.getInserttime());
						ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
						ps.setString(13, entity.getTableforpic());
						ps.setString(14, entity.getFieldforpic());
						ps.setString(15, entity.getKeyforpic());
						ps.setString(16, entity.getCpcode());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpersonlogJn(final TpersonlogJn entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getPersonid());
				ps.setString(3, entity.getCardname());
				ps.setString(4, entity.getCardno());
				ps.setString(5, entity.getSource());
				ps.setString(6, entity.getSid());
				ps.setString(7, entity.getPersontype());
				ps.setString(8, entity.getEmpstatus());
				ps.setString(9, entity.getStarttime());
				ps.setString(10, entity.getEndtime());
				ps.setDate(11, (java.sql.Date)entity.getInserttime());
				ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
				ps.setString(13, entity.getTableforpic());
				ps.setString(14, entity.getFieldforpic());
				ps.setString(15, entity.getKeyforpic());
				ps.setString(16, entity.getCpcode());
			}
		});
	}

	
	public void updateTpersonlogJn(final TpersonlogJn entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getPersonid());
				ps.setString(3, entity.getCardname());
				ps.setString(4, entity.getCardno());
				ps.setString(5, entity.getSource());
				ps.setString(6, entity.getSid());
				ps.setString(7, entity.getPersontype());
				ps.setString(8, entity.getEmpstatus());
				ps.setString(9, entity.getStarttime());
				ps.setString(10, entity.getEndtime());
				ps.setDate(11, (java.sql.Date)entity.getInserttime());
				ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
				ps.setString(13, entity.getTableforpic());
				ps.setString(14, entity.getFieldforpic());
				ps.setString(15, entity.getKeyforpic());
				ps.setString(16, entity.getCpcode());
			}
		});
	}

	
	public void deleteTpersonlogJn(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	public List getLogJnInfoIdCode(String source , String idName , String idCode,
            String starttime , String endtime) {

			
			String subSQL = " SELECT COUNT(*) FROM T_PERSONLOG_JN p "
			+ " WHERE p.SOURCE in ( " + source + " ) AND p.CARDNO = ? AND p.CARDNAME = ? "
			+ " AND p.PERSONTYPE = d.dictid ";
			
			if(starttime !=null && !"".equals(starttime)){
			subSQL = subSQL + " AND p.STARTTIME >= '"+starttime+"' " ;
			}
			if(endtime !=null && !"".equals(endtime)){
			subSQL = subSQL + " AND p.STARTTIME <= '"+endtime+"' " ;
			}
			
			String sql = " SELECT d.dictid as code , d.dictname as name , (" + subSQL + ") as count FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE'  "
			+ " ORDER BY d.dictid ";
			
			
			String countsql = "Select count(*) FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE'";
			int count = getJdbcTemplate().queryForInt(countsql);
			List mapList = null;
			if(count>=0){
			mapList = getJdbcTemplate().query(sql, new Object[] { idCode, idName }, new MapRowMapper());
			}
			return mapList;

    }
	
	public List getLogJnCountByBusinessCode(String source , String idName , String idCode,
			                                   String starttime , String endtime) {
		
		
		String subSQL = " SELECT COUNT(*) FROM T_PERSONLOG_JN p "
			          + " WHERE p.SOURCE in ( " + source + " ) AND p.CARDNO = ? AND p.CARDNAME = ? "
			          + " AND p.PERSONTYPE = d.dictid ";
		
		if(starttime !=null && !"".equals(starttime)){
			subSQL = subSQL + " AND p.STARTTIME >= '"+starttime+"' " ;
		}
		if(endtime !=null && !"".equals(endtime)){
			subSQL = subSQL + " AND p.STARTTIME <= '"+endtime+"' " ;
		}
		
		String sql = " SELECT d.dictid as code , d.dictname as name , (" + subSQL + ") as count FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE'  "
	       + " ORDER BY d.dictid ";
		
		
		String countsql = "Select count(*) FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE'";
		int count = getJdbcTemplate().queryForInt(countsql);
		List mapList = null;
		if(count>=0){
		     mapList = getJdbcTemplate().query(sql, new Object[] { idCode, idName }, new MapRowMapper());
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
    
	public List getCompCountByDeptCode(String statisType , String deptCode,  String starttime, String endtime ) {
        String subSQLWhere = "";
		if("1".equals(statisType)){ //按照派出所
			subSQLWhere =  subSQLWhere + " AND t.STACODE ='"+ deptCode +"' ";
		}else{
			subSQLWhere =  subSQLWhere + " AND t.BURCODE ='"+ deptCode +"' ";
		}
		
		if(starttime != null && !"".equals(starttime)){
			subSQLWhere = subSQLWhere + " AND c.STARTTIME >= '"+ starttime +"' ";    			
		}
		if(endtime != null && !"".equals(endtime)){
			subSQLWhere = subSQLWhere + " AND c.STARTTIME <= '"+ endtime +"' ";    			
		}
		
		String subSQL = " SELECT COUNT(*) FROM T_PERSONLOG_JN c , T_COMPANYINFO t "
			          + " WHERE c.cpcode = t.cpcode(+) AND c.EMPSTATUS = d.dictid " + subSQLWhere ;

		
		String sql = " SELECT d.dictid as code , d.dictname as name , (" + subSQL + ") as count FROM SS_DICT_ITEM d "
                   + " WHERE d.dicttypeid = 'cyryFlag' AND d.STATUS='1'  "
	               + " ORDER BY d.sortno ";
		
		
		String countsql = "Select count(*) FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'cyryFlag' AND d.STATUS='1' ";
		int count = getJdbcTemplate().queryForInt(countsql);
		List mapList = null;
		if(count>=0){
		     mapList = getJdbcTemplate().query(sql, new MapRowMapper());
		}
		return mapList;

	}
	
}
