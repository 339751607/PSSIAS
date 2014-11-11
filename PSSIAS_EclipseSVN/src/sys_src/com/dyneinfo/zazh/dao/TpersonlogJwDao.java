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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.dao.TpersonlogJnDao.MapRowMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonlogJwDao extends BaseSpringJdbcDao<TpersonlogJw,Long>{
	
	public Class getEntityClass() {
		return TpersonlogJw.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" PERSONID as personid,"
				+" PASS_T as passT,"
				+" PASS_NO as passNo,"
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
				+" from T_PERSONLOG_JW ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_PERSONLOG_JW where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TpersonlogJw entity) {
		String sql = "insert into T_PERSONLOG_JW " 
			 + " (ID,PERSONID,PASS_T,PASS_NO,SOURCE,SID,PERSONTYPE,EMPSTATUS,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,CPCODE, KEYFORPIC ) " 
			 + " values "
			 + " (:id,:personid,:passT,:passNo,:source,:sid,:persontype,:empstatus,:starttime,:endtime,:inserttime,:updatetime,:tableforpic,:fieldforpic,:cpcode,:keyforpic)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_PERSONLOG_JW",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpersonlogJw entity) {
		String sql = "update T_PERSONLOG_JW set "
					+ " ID=:id,PERSONID=:personid,PASS_T=:passT,PASS_NO=:passNo,SOURCE=:source,SID=:sid,PERSONTYPE=:persontype,EMPSTATUS=:empstatus,STARTTIME=:starttime,ENDTIME=:endtime,INSERTTIME=:inserttime,UPDATETIME=:updatetime,TABLEFORPIC=:tableforpic,FIELDFORPIC=:fieldforpic,CPCODE=:cpcode,KEYFORPIC=:keyforpic "
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
				+ "/~ and t.PASS_T = '[passT]' ~/"
				+ "/~ and t.PASS_NO = '[passNo]' ~/"
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
				+" PASS_T as passT,"
				+" PASS_NO as passNo,"
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
				+" t.CPCODE as cpcode, "
				+" c.CPNAME as cpname "
				+" from T_PERSONLOG_JW  t , T_COMPANYINFO c " 
				+" where t.cpcode = c.cpcode(+) "
				+" and t.SOURCE in (select code from SS_DATASOURCE where isvalid='1' ) "
				+ "/~ and t.PERSONID = '[personid]' ~/"			
				+ "/~ and t.PASS_T = '[passT]' ~/"
				+ "/~ and t.PASS_NO = '[passNo]' ~/"				
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.PERSONTYPE = '[persontype]' ~/"
				+ "/~ and t.EMPSTATUS = '[empstatus]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ " order by t.STARTTIME desc";
		return pageQuery(sql,pageRequest);
	}
	public Page findLogsInfoByPageRequestForItem(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select  "
				+" ID as id,"
				+" PERSONID as personid,"
				+" PASS_T as passT,"
				+" PASS_NO as passNo,"
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
				+" t.CPCODE as cpcode, "
				+" c.CPNAME as cpname "
				+" from T_PERSONLOG_JW  t , T_COMPANYINFO c " 
				+" where t.cpcode = c.cpcode(+) "
				+" /~ and t.SOURCE in ([source]) ~/ "
				+ "/~ and t.PERSONID = '[personid]' ~/"			
				+ "/~ and t.PASS_T = '[passT]' ~/"
				+ "/~ and t.PASS_NO = '[passNo]' ~/"				
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.PERSONTYPE = '[persontype]' ~/"
				+ "/~ and t.EMPSTATUS = '[empstatus]' ~/"
				+ "/~ and t.STARTTIME >= '[starttime]' ~/"
				+ "/~ and t.STARTTIME <= '[endtime]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
				+ "/~ and t.UPDATETIME = '[updatetime]' ~/"
				+ "/~ and t.TABLEFORPIC = '[tableforpic]' ~/"
				+ "/~ and t.FIELDFORPIC = '[fieldforpic]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ " order by t.STARTTIME desc";
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
	
	
	private String createSql = "insert into T_PERSONLOG_JW " 
		 + " (ID,PERSONID,PASS_T,PASS_NO,SOURCE,SID,PERSONTYPE,EMPSTATUS,STARTTIME,ENDTIME,INSERTTIME,UPDATETIME,TABLEFORPIC,FIELDFORPIC,CPCODE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_PERSONLOG_JW set "
		+ " ID=?,PERSONID=?,PASS_T=?,PASS_NO=?,SOURCE=?,SID=?,PERSONTYPE=?,EMPSTATUS=?,STARTTIME=?,ENDTIME=?,INSERTTIME=?,UPDATETIME=?,TABLEFORPIC=?,FIELDFORPIC=?,CPCODE=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpersonlogJw entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setLong(2, entity.getPersonid());
					    ps.setString(3, entity.getPassT());
						ps.setString(4, entity.getPassNo());
						ps.setString(5, entity.getSource());
						ps.setString(6, entity.getSid());
						ps.setString(7, entity.getPersontype());
						ps.setString(8, entity.getEmpstatus());
						ps.setString(9, entity.getStarttime());
						ps.setObject(10, entity.getEndtime());
						ps.setDate(11, (java.sql.Date)entity.getInserttime());
						ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
						ps.setString(13, entity.getTableforpic());
						ps.setString(14, entity.getFieldforpic());
						ps.setString(15, entity.getCpcode());
						ps.setString(16, entity.getKeyforpic());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpersonlogJw(final TpersonlogJw entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getPersonid());
				ps.setString(3, entity.getPassT());
				ps.setString(4, entity.getPassNo());
				ps.setString(5, entity.getSource());
				ps.setString(6, entity.getSid());
				ps.setString(7, entity.getPersontype());
				ps.setString(8, entity.getEmpstatus());
				ps.setString(9, entity.getStarttime());
				ps.setObject(10, entity.getEndtime());
				ps.setDate(11, (java.sql.Date)entity.getInserttime());
				ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
				ps.setString(13, entity.getTableforpic());
				ps.setString(14, entity.getFieldforpic());
				ps.setString(15, entity.getCpcode());
				ps.setString(16, entity.getKeyforpic());
			}
		});
	}

	
	public void updateTpersonlogJw(final TpersonlogJw entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getPersonid());
				ps.setString(3, entity.getPassT());
				ps.setString(4, entity.getPassNo());
				ps.setString(5, entity.getSource());
				ps.setString(6, entity.getSid());
				ps.setString(7, entity.getPersontype());
				ps.setString(8, entity.getEmpstatus());
				ps.setString(9, entity.getStarttime());
				ps.setObject(10, entity.getEndtime());
				ps.setDate(11, (java.sql.Date)entity.getInserttime());
				ps.setDate(12, (java.sql.Date)entity.getUpdatetime());
				ps.setString(13, entity.getTableforpic());
				ps.setString(14, entity.getFieldforpic());
				ps.setString(15, entity.getCpcode());
				ps.setString(16, entity.getKeyforpic());
			}
		});
	}

	
	public void deleteTpersonlogJw(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public List getLogJnCountByBusinessCode(String source , String passT , String passNo,
			                                  String s_starttime , String s_endtime) {
			
		 String subSQL = " SELECT COUNT(*) FROM T_PERSONLOG_JW p "
	          + " WHERE p.SOURCE in ( " + source + " ) AND p.PASS_NO = ? AND p.PASS_T = ? "
	          + " AND p.PERSONTYPE = d.dictid ";
		 
		 if(s_starttime !=null && !"".equals(s_starttime)){
			 subSQL = subSQL + " AND p.starttime >= '"+s_starttime+"' " ;
		 }
		 if(s_endtime !=null && !"".equals(s_endtime)){
			 subSQL = subSQL + " AND p.starttime <= '"+s_endtime+"' " ;
		 }
			
		 String sql = " SELECT d.dictid as code , d.dictname as name , (" + subSQL + ") as count FROM SS_DICT_ITEM d " 
		            + " WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE'  "
	                + " ORDER BY d.dictid ";		
		
		String countsql = "Select count(*) FROM SS_DICT_ITEM d WHERE d.dicttypeid = 'DIC_ITEM_BUSINESSTYPE' ";
		int count = getJdbcTemplate().queryForInt(countsql);
		List mapList = null;
		if(count>=0){
		     mapList = getJdbcTemplate().query(sql, new Object[] { passNo, passT }, new MapRowMapper());
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

}
