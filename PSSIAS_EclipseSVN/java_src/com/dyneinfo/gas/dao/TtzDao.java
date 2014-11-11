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
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TtzDao extends BaseSpringJdbcDao<Ttz,Long>{
	
	public Class getEntityClass() {
		return Ttz.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" RQ as rq,"
				+" NR as nr,"
				+" BT as bt,"
				+" FSQT as fsqt,"
				+" t.fsdw as fsdw,"
				+" FSR as fsr,"
				+" t.BURCODE as burcode,"
				+" t.STACODE as stacode,"
				+" USERUNIT as userunit,"
				+" HZFLAG as hzflag"
				+" from T_TZ t ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_TZ where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
//		Ttz ttz = new Ttz();
		return  getSelectPrefix() + " where  ID=? ";
	}
	
	public void save(Ttz entity) {
		String sql = "insert into T_TZ " 
			 + " (ID,RQ,NR,BT,FSQT,FSDW,FSR,BURCODE,STACODE,USERUNIT,HZFLAG) " 
			 + " values "
			 + " (:id,:rq,:nr,:bt,:fsqt,:fsdw,:fsr,:burcode,:stacode,:userunit,:hzflag)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_TZ",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Ttz entity) {
		String sql = "update T_TZ set "
					+ " ID=:id,RQ=:rq,NR=:nr,BT=:bt,FSQT=:fsqt,FSDW=:fsdw,FSR=:fsr,BURCODE=:burcode,STACODE=:stacode,USERUNIT=:userunit,HZFLAG=:hzflag "
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
		String sqlWhere ="";
		String cpcode =(String) pageRequest.getFilters().get("cpcode");
		if(cpcode != null){
			sqlWhere =  sqlWhere + " AND  " 
			+ " ( FSQT = '1' OR FSDW like '%" + cpcode + "%' "; //下发到本旅馆的通知
			Map companyMap = getCompany(cpcode);
			if(companyMap != null ){
				String burCode = companyMap.get("BURCODE")==null?"":(String)companyMap.get("BURCODE");
				String staCode = companyMap.get("STACODE")==null?"":(String)companyMap.get("STACODE");
				//分局不为空，派出所为空，则可以下发到宾馆
				sqlWhere = sqlWhere + "  OR (  T.BURCODE is not null AND T.BURCODE ='"+ burCode +"' and  T.STACODE  is null  ) ";			
				//分局为空，派出所不为空，则要对应相关的派出所 ，
				sqlWhere = sqlWhere + "  OR (  T.BURCODE is null AND T.STACODE is not null " 
				+"   and  T.STACODE ='"+ staCode +"'  ) ";								  
			}	
			sqlWhere = sqlWhere  + " ) ";
		}
	
	
		String sql = getSelectPrefix() + "  where 1=1"
				+ "/~ and substr(t.RQ,0,8) >= '[rqBeginFormat]' ~/"
				+ "/~ and substr(t.RQ,0,8) <= '[rqEndFormat]' ~/"
				+ "/~ and t.NR = '[nr]' ~/"
				+ "/~ and t.BT = '[bt]' ~/"
				+ "/~ and t.FSQT = '[fsqt]' ~/"
				+ "/~ and t.FSDW = '[fsdw]' ~/"
				+ "/~ and t.FSR = '[fsr]' ~/"
				+ "/~ and t.USERUNIT in (select deptid  from SS_DEPT t  where t.parentid = '[burcode]'  or t.deptid = '[burcode]') ~/"
				+ "/~ and t.USERUNIT  = '[stacode]' ~/"
				+ "/~ and [userunit] ~/"
				+ "/~ and t.HZFLAG = '[hzflag]' ~/"
				+ sqlWhere
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public Map getCompany(String cpcode) {
		Map infoMap = null;
		String countsql = " select count(*) " 
		       + " from T_COMPANYINFO t  " 
		       + " where t.cpcode=? ";
		int count = getJdbcTemplate().queryForInt(countsql, new Object[] { cpcode });
		if(count > 0){
		    String sql = " select CPNAME,STACODE , BURCODE  " 
			       + " from T_COMPANYINFO t  " 
			       + " where t.cpcode=? ";		
			infoMap = getJdbcTemplate().queryForMap(sql, new Object[] { cpcode });
		}
		return infoMap;
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
	
	
	private String createSql = "insert into T_TZ " 
		 + " (ID,RQ,NR,BT,FSQT,FSDW,FSR,BURCODE,STACODE,USERUNIT,HZFLAG) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_TZ set "
		+ " ID=?,RQ=?,NR=?,BT=?,FSQT=?,FSDW=?,FSR=?,BURCODE=?,STACODE=?,USERUNIT=?,HZFLAG=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Ttz entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setString(2, entity.getRq());
						ps.setString(3, entity.getNr());
						ps.setString(4, entity.getBt());
						ps.setString(5, entity.getFsqt());
						ps.setString(6, entity.getFsdw());
						ps.setString(7, entity.getFsr());
						ps.setString(8, entity.getBurcode());
						ps.setString(9, entity.getStacode());
						ps.setString(10, entity.getUserunit());
						ps.setString(11, entity.getHzflag());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTtz(final Ttz entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getRq());
				ps.setString(3, entity.getNr());
				ps.setString(4, entity.getBt());
				ps.setString(5, entity.getFsqt());
				ps.setString(6, entity.getFsdw());
				ps.setString(7, entity.getFsr());
				ps.setString(8, entity.getBurcode());
				ps.setString(9, entity.getStacode());
				ps.setString(10, entity.getUserunit());
				ps.setString(11, entity.getHzflag());
			}
		});
	}

	
	public void updateTtz(final Ttz entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setString(2, entity.getRq());
				ps.setString(3, entity.getNr());
				ps.setString(4, entity.getBt());
				ps.setString(5, entity.getFsqt());
				ps.setString(6, entity.getFsdw());
				ps.setString(7, entity.getFsr());
				ps.setString(8, entity.getBurcode());
				ps.setString(9, entity.getStacode());
				ps.setString(10, entity.getUserunit());
				ps.setString(11, entity.getHzflag());
			}
		});
	}

	
	public void deleteTtz(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
