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
public class TalarmPersonDao extends BaseSpringJdbcDao<TalarmPerson,Long>{
	
	public Class getEntityClass() {
		return TalarmPerson.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" BKID as bkid,"
				+" BKTYPE as bktype,"
				+" SID as sid,"
				+" ALARMTIME as alarmtime,"
				+" ALARMSOURCE as alarmsource,"
				+" ALARMTYPE as alarmtype,"
				+" BUSINESSTYPE as businesstype,"
				+" BUSINESSTIME as businesstime,"
				+" t.CPCODE as cpcode,"
				+" NAME as name,"
				+" SEX as sex,"
				+" NATION as nation,"
				+" BDATE as bdate,"
				+" IDNAME as idname,"
				+" IDCODE as idcode,"
				+" HJD as hjd,"
				+" ADDRESS as address,"
				+" CLFLAG as clflag,"
				+" CJDW as cjdw,"
				+" CJR as cjr,"
				+" CJSJ as cjsj,"
				+" VALIDFLAG as validflag,"
				+" VOIDCAUSE as voidcause,"
				+" ZHFLAG as zhflag,"
				+" ZHDW as zhdw,"
				+" ZHSJ as zhsj,"
				+" WZHYY as wzhyy,"
				+" CLQK as clqk, "
				+" c.CPNAME as cpname, "
				+" d.DEPTNAME as deptname "
				+" from T_ALARM_PERSON t , T_COMPANYINFO c, SS_DEPT d " 
				+" where t.cpcode = c.cpcode AND c.burcode = d.deptid ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_ALARM_PERSON where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " AND ID=?  ";
	}
	
	public void save(TalarmPerson entity) {
		String sql = "insert into T_ALARM_PERSON " 
			 + " (ID,BKID,BKTYPE,SID,ALARMTIME,ALARMSOURCE,ALARMTYPE,BUSINESSTYPE,BUSINESSTIME,CPCODE,NAME,SEX,NATION,BDATE,IDNAME,IDCODE,HJD,ADDRESS,CLFLAG,CJDW,CJR,CJSJ,VALIDFLAG,VOIDCAUSE,ZHFLAG,ZHDW,ZHSJ,WZHYY,CLQK) " 
			 + " values "
			 + " (:id,:bkid,:bktype,:sid,:alarmtime,:alarmsource,:alarmtype,:businesstype,:businesstime,:cpcode,:name,:sex,:nation,:bdate,:idname,:idcode,:hjd,:address,:clflag,:cjdw,:cjr,:cjsj,:validflag,:voidcause,:zhflag,:zhdw,:zhsj,:wzhyy,:clqk)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_ALARM_PERSON",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TalarmPerson entity) {
		String sql = "update T_ALARM_PERSON set "
					+ " ID=:id,BKID=:bkid,BKTYPE=:bktype,SID=:sid,ALARMTIME=:alarmtime,ALARMSOURCE=:alarmsource,ALARMTYPE=:alarmtype,BUSINESSTYPE=:businesstype,BUSINESSTIME=:businesstime,CPCODE=:cpcode,NAME=:name,SEX=:sex,NATION=:nation,BDATE=:bdate,IDNAME=:idname,IDCODE=:idcode,HJD=:hjd,ADDRESS=:address,CLFLAG=:clflag,CJDW=:cjdw,CJR=:cjr,CJSJ=:cjsj,VALIDFLAG=:validflag,VOIDCAUSE=:voidcause,ZHFLAG=:zhflag,ZHDW=:zhdw,ZHSJ=:zhsj,WZHYY=:wzhyy,CLQK=:clqk "
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
		String sql = getSelectPrefix() 
				+ "/~ and t.BKID = '[bkid]' ~/"
				+ "/~ and t.BKTYPE = '[bktype]' ~/"
				+ "/~ and t.SID = '[sid]' ~/"
				+ "/~ and t.ALARMTIME = '[alarmtime]' ~/"
				+ "/~ and t.ALARMSOURCE = '[alarmsource]' ~/"
				+ "/~ and t.ALARMTYPE = '[alarmtype]' ~/"
				+ "/~ and t.BUSINESSTYPE = '[businesstype]' ~/"
				+ "/~ and t.BUSINESSTIME = '[businesstime]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.NAME = '[name]' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.NATION = '[nation]' ~/"
				+ "/~ and t.BDATE = '[bdate]' ~/"
				+ "/~ and t.IDNAME = '[idname]' ~/"
				+ "/~ and t.IDCODE = '[idcode]' ~/"
				+ "/~ and t.HJD = '[hjd]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.CLFLAG = '[clflag]' ~/"
				+ "/~ and t.CJDW = '[cjdw]' ~/"
				+ "/~ and t.CJR = '[cjr]' ~/"
				+ "/~ and t.CJSJ = '[cjsj]' ~/"
				+ "/~ and t.VALIDFLAG = '[validflag]' ~/"
				+ "/~ and t.VOIDCAUSE = '[voidcause]' ~/"
				+ "/~ and t.ZHFLAG = '[zhflag]' ~/"
				+ "/~ and t.ZHDW = '[zhdw]' ~/"
				+ "/~ and t.ZHSJ = '[zhsj]' ~/"
				+ "/~ and t.WZHYY = '[wzhyy]' ~/"
				+ "/~ and t.CLQK = '[clqk]' ~/"
				+ "/~ and d.DEPTSEQ like '%.[deptseq].%' ~/"
				+ " order by t.CJSJ DESC ";
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
	
	
	private String createSql = "insert into T_ALARM_PERSON " 
		 + " (ID,BKID,BKTYPE,SID,ALARMTIME,ALARMSOURCE,ALARMTYPE,BUSINESSTYPE,BUSINESSTIME,CPCODE,NAME,SEX,NATION,BDATE,IDNAME,IDCODE,HJD,ADDRESS,CLFLAG,CJDW,CJR,CJSJ,VALIDFLAG,VOIDCAUSE,ZHFLAG,ZHDW,ZHSJ,WZHYY,CLQK) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_ALARM_PERSON set "
		+ " ID=?,BKID=?,BKTYPE=?,SID=?,ALARMTIME=?,ALARMSOURCE=?,ALARMTYPE=?,BUSINESSTYPE=?,BUSINESSTIME=?,CPCODE=?,NAME=?,SEX=?,NATION=?,BDATE=?,IDNAME=?,IDCODE=?,HJD=?,ADDRESS=?,CLFLAG=?,CJDW=?,CJR=?,CJSJ=?,VALIDFLAG=?,VOIDCAUSE=?,ZHFLAG=?,ZHDW=?,ZHSJ=?,WZHYY=?,CLQK=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TalarmPerson entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getBkid());
						ps.setString(3, entity.getBktype());
						ps.setString(4, entity.getSid());
						ps.setString(5, entity.getAlarmtime());
						ps.setString(6, entity.getAlarmsource());
						ps.setString(7, entity.getAlarmtype());
						ps.setString(8, entity.getBusinesstype());
						ps.setString(9, entity.getBusinesstime());
						ps.setString(10, entity.getCpcode());
						ps.setString(11, entity.getName());
						ps.setString(12, entity.getSex());
						ps.setString(13, entity.getNation());
						ps.setString(14, entity.getBdate());
						ps.setString(15, entity.getIdname());
						ps.setString(16, entity.getIdcode());
						ps.setString(17, entity.getHjd());
						ps.setString(18, entity.getAddress());
						ps.setString(19, entity.getClflag());
						ps.setString(20, entity.getCjdw());
						ps.setString(21, entity.getCjr());
						ps.setString(22, entity.getCjsj());
						ps.setString(23, entity.getValidflag());
						ps.setString(24, entity.getVoidcause());
						ps.setString(25, entity.getZhflag());
						ps.setString(26, entity.getZhdw());
						ps.setString(27, entity.getZhsj());
						ps.setString(28, entity.getWzhyy());
						ps.setString(29, entity.getClqk());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTalarmPerson(final TalarmPerson entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getBkid());
				ps.setString(3, entity.getBktype());
				ps.setString(4, entity.getSid());
				ps.setString(5, entity.getAlarmtime());
				ps.setString(6, entity.getAlarmsource());
				ps.setString(7, entity.getAlarmtype());
				ps.setString(8, entity.getBusinesstype());
				ps.setString(9, entity.getBusinesstime());
				ps.setString(10, entity.getCpcode());
				ps.setString(11, entity.getName());
				ps.setString(12, entity.getSex());
				ps.setString(13, entity.getNation());
				ps.setString(14, entity.getBdate());
				ps.setString(15, entity.getIdname());
				ps.setString(16, entity.getIdcode());
				ps.setString(17, entity.getHjd());
				ps.setString(18, entity.getAddress());
				ps.setString(19, entity.getClflag());
				ps.setString(20, entity.getCjdw());
				ps.setString(21, entity.getCjr());
				ps.setString(22, entity.getCjsj());
				ps.setString(23, entity.getValidflag());
				ps.setString(24, entity.getVoidcause());
				ps.setString(25, entity.getZhflag());
				ps.setString(26, entity.getZhdw());
				ps.setString(27, entity.getZhsj());
				ps.setString(28, entity.getWzhyy());
				ps.setString(29, entity.getClqk());
			}
		});
	}

	
	public void updateTalarmPerson(final TalarmPerson entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getBkid());
				ps.setString(3, entity.getBktype());
				ps.setString(4, entity.getSid());
				ps.setString(5, entity.getAlarmtime());
				ps.setString(6, entity.getAlarmsource());
				ps.setString(7, entity.getAlarmtype());
				ps.setString(8, entity.getBusinesstype());
				ps.setString(9, entity.getBusinesstime());
				ps.setString(10, entity.getCpcode());
				ps.setString(11, entity.getName());
				ps.setString(12, entity.getSex());
				ps.setString(13, entity.getNation());
				ps.setString(14, entity.getBdate());
				ps.setString(15, entity.getIdname());
				ps.setString(16, entity.getIdcode());
				ps.setString(17, entity.getHjd());
				ps.setString(18, entity.getAddress());
				ps.setString(19, entity.getClflag());
				ps.setString(20, entity.getCjdw());
				ps.setString(21, entity.getCjr());
				ps.setString(22, entity.getCjsj());
				ps.setString(23, entity.getValidflag());
				ps.setString(24, entity.getVoidcause());
				ps.setString(25, entity.getZhflag());
				ps.setString(26, entity.getZhdw());
				ps.setString(27, entity.getZhsj());
				ps.setString(28, entity.getWzhyy());
				ps.setString(29, entity.getClqk());
			}
		});
	}

	
	public void deleteTalarmPerson(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public List getAlarmCountByDeptCode(String statisType , String deptCode,  String starttime, String endtime ) {
      
        String unionSQLWhere = "";
        
		if("1".equals(statisType)){ //按照派出所
			unionSQLWhere =  unionSQLWhere + " AND t.STACODE ='"+ deptCode +"' ";
		}else{
			unionSQLWhere =  unionSQLWhere + " AND t.BURCODE ='"+ deptCode +"' ";
		}
		
		if(starttime != null && !"".equals(starttime)){
			unionSQLWhere = unionSQLWhere + " AND c.ALARMTIME >= '"+ starttime +"' ";    			
		}
		if(endtime != null && !"".equals(endtime)){
			unionSQLWhere = unionSQLWhere + " AND c.ALARMTIME <= '"+ endtime +"' ";    			
		}
		
		String unionSQL = " SELECT ID , c.CPCODE , ALARMSOURCE , ALARMTIME  "
			            + "         FROM ( SELECT ID , CPCODE , ALARMSOURCE , ALARMTIME from  T_ALARM_CAR 　"
			            + "                   UNION ALL  " 
			            + "                SELECT ID , CPCODE , ALARMSOURCE , ALARMTIME from  T_ALARM_PERSON" 
			            + "               ) c , T_COMPANYINFO t　"
			            + " WHERE c.CPCODE = t.CPCODE " + unionSQLWhere;
			            ;
		 
		String subSQL = " SELECT COUNT(ID) FROM (" + unionSQL + ") u "
			          + " WHERE u.ALARMSOURCE = d.code " ;
		
		String sql = " SELECT d.code as code , d.called as name , (" + subSQL + ") as count FROM SS_DATASOURCE d "
        + " WHERE d.isValid = '1' AND d.code <>'000'  "
        + " ORDER BY d.code ";
		
		String countsql = "Select count(*) FROM SS_DATASOURCE d WHERE  d.isValid = '1' AND d.code <>'000' ";
		
		int count = getJdbcTemplate().queryForInt(countsql);
		List mapList = null;
		if(count>=0){
		     mapList = getJdbcTemplate().query(sql, new MapRowMapper());
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
