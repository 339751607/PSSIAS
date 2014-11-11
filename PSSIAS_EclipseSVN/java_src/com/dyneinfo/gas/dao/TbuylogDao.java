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
import com.dyneinfo.zazh.model.SsDept;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TbuylogDao extends BaseSpringJdbcDao<Tbuylog,java.lang.String>{
	
	public Class getEntityClass() {
		return Tbuylog.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" NAME as name,"
				+" SEX as sex,"
				+" NATION as nation,"
				+" to_char(to_date(bdate,'yyyy-MM-dd'),'yyyy-MM-dd') as bdate,"
				+" ID_NAME as idName,"
				+" ID_CODE as idCode,"
				+" XZQH as xzqh,"
				+" T.ADDRESS as address,"
				+" WORKUNIT as workunit,"
				+" T.PHONE as phone,"
				+" USE as use,"
				+" BUYTYPE as buytype,"
				+" SORT as sort,"
				+" QUANTITY as quantity,"
				+" to_char(to_date(LOGTIME,'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as logtime,"
				+" to_char(to_date(TRATIME,'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as tratime,"
				+" OPERATOR as operator,"
				+" T.STACODE as stacode,"
				+" T.BURCODE as burcode,"
				+" T.CPCODE as cpcode,"
				+" CPNAME as cpname "
				+" from T_COMPANYINFO b,T_BUYLOG T";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_BUYLOG where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where t.cpcode = b.cpcode and ID=? ";
	}
	
	public void save(Tbuylog entity) {
		String sql = "insert into T_BUYLOG " 
			 + " (ID,NAME,SEX,NATION,BDATE,ID_NAME,ID_CODE,XZQH,ADDRESS,WORKUNIT,PHONE,USE,BUYTYPE,SORT,QUANTITY,LOGTIME,TRATIME,OPERATOR,STACODE,BURCODE,CPCODE) " 
			 + " values "
			 + " (:id,:name,:sex,:nation,:bdate,:idName,:idCode,:xzqh,:address,:workunit,:phone,:use,:buytype,:sort,:quantity,:logtime,:tratime,:operator,:stacode,:burcode,:cpcode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_BUYLOG",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tbuylog entity) {
		String sql = "update T_BUYLOG set "
					+ " ID=:id,NAME=:name,SEX=:sex,NATION=:nation,BDATE=:bdate,ID_NAME=:idName,ID_CODE=:idCode,XZQH=:xzqh,ADDRESS=:address,WORKUNIT=:workunit,PHONE=:phone,USE=:use,BUYTYPE=:buytype,SORT=:sort,QUANTITY=:quantity,LOGTIME=:logtime,TRATIME=:tratime,OPERATOR=:operator,STACODE=:stacode,BURCODE=:burcode "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	
	//取得省
	public List getProv() {
		String sql = "select CODE,CALLED from t_dic_xzqh t where substr(code,3)='0000' order by t.i_code ";
		//System.out.println(sql);
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String CODE = rs.getString(1);
	        	    String CALLED = rs.getString(2);
			        results.put("CODE", CODE);
			        results.put("CALLED", CALLED);
			        return results;
	           }
	           
	       });
	   }
	
	
	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "  where 1=1 and t.cpcode = b.cpcode "
				+ "/~ and t.NAME  like '%[name]%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.NATION = '[nation]' ~/"
				+ "/~ and t.BDATE = '[bdate]' ~/"
				+ "/~ and t.ID_NAME = '[idName]' ~/"
				+ "/~ and t.ID_CODE = '[idCode]' ~/"
				+ "/~ and t.XZQH = '[xzqh]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.WORKUNIT = '[workunit]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.USE = '[use]' ~/"
				+ "/~ and t.BUYTYPE = '[buytype]' ~/"
				+ "/~ and t.SORT = '[sort]' ~/"
				+ "/~ and t.QUANTITY >= '[quantity]' ~/"
				+ "/~ and substr(t.logtime,0,8) >= '[logtimeBeginFormat]' ~/"
				+ "/~ and substr(t.logtime,0,8) <= '[logtimeEndFormat]' ~/"
				+ "/~ and t.TRATIME = '[tratime]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.STACODE = '[stacode]' ~/"
				+ "/~ and t.BURCODE = '[burcode]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	/**
	 * 频繁购油信息查询
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Page pffindByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符.
		// 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能.
		// [column] 为PageRequest.getFilters()中的key
		String sql = "select * from (select name,sex,bdate,id_code as idCode,nation,count(*) as gycs  from T_BUYLOG t  where 1=1 "
				+ "/~ and substr(t.logtime,0,8) >= '[logtimeBeginFormat]' ~/"
				+ "/~ and substr(t.logtime,0,8) <= '[logtimeEndFormat]' ~/"
				+ "/~ and t.STACODE = '[stacode]' ~/"
				+ "/~ and t.BURCODE = '[burcode]' ~/"
				+" group by name,sex,bdate,id_code,nation ) b where 1=1"
				+ "/~ and b.gycs >= '[gycs]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql, pageRequest);
		
//		return pageQuery(sql+" order by b.sta_code", "select count(*) from  (" + sql + ")",
//				pageRequest);
		
	}
	
	
	public String getCurrentMax(String prefixID) throws DataAccessException {
		 String currentPhase = "";
		 
		if(prefixID == null || "".equals(prefixID)){
			return currentPhase;
		}		   
		
		String sql = "select  max(id) as ID  from T_BUYLOG  where  substr(ID,0," + prefixID.length() + ") = ? ";
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
	 * 大量购油信息查询
	 * @param pageRequest
	 * @return
	 */
	public Page dlfindByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "  where 1=1 and t.cpcode = b.cpcode "
		+ "/~ and t.NAME = '[name]' ~/"
		+ "/~ and t.SEX = '[sex]' ~/"
		+ "/~ and t.NATION = '[nation]' ~/"
		+ "/~ and t.BDATE = '[bdate]' ~/"
		+ "/~ and t.ID_NAME = '[idName]' ~/"
		+ "/~ and t.ID_CODE = '[idCode]' ~/"
		+ "/~ and t.XZQH = '[xzqh]' ~/"
		+ "/~ and t.ADDRESS = '[address]' ~/"
		+ "/~ and t.WORKUNIT = '[workunit]' ~/"
		+ "/~ and t.PHONE = '[phone]' ~/"
		+ "/~ and t.USE = '[use]' ~/"
		+ "/~ and t.BUYTYPE = '[buytype]' ~/"
		+ "/~ and t.SORT = '[sort]' ~/"
		+ "/~ and t.QUANTITY >= '[quantity]' ~/"
		+ "/~ and substr(t.logtime,0,8) >= '[logtimeBeginFormat]' ~/"
		+ "/~ and substr(t.logtime,0,8) <= '[logtimeEndFormat]' ~/"
		+ "/~ and t.TRATIME = '[tratime]' ~/"
		+ "/~ and t.OPERATOR = '[operator]' ~/"
		+ "/~ and t.STACODE = '[stacode]' ~/"
		+ "/~ and t.BURCODE = '[burcode]' ~/"
		+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	/**
	 * 集中购油信息查询
	 * @param pageRequest
	 * @return
	 */
	public Page jzfindByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql =" select * from (select t.stacode,count(*)as gycs from T_BUYLOG t where 1=1"
			+ "/~ and t.BURCODE = '[burcode]' ~/"
			+ "/~ and t.stacode = '[stacode]' ~/"
			+ "/~ and substr(t.logtime,0,8) >= '[logtimeBeginFormat]' ~/"
			+ "/~ and substr(t.logtime,0,8) <= '[logtimeEndFormat]' ~/"
			+"group by stacode)"
			+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	/**
	 * 高危人购油信息查询
	 * @param pageRequest
	 * @return
	 */
	public Page gwfindByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "  where 1=1 and t.cpcode = b.cpcode "
		+ "/~ and t.NAME = '[name]' ~/"
		+ "/~ and t.SEX = '[sex]' ~/"
		+ "/~ and t.NATION = '[nation]' ~/"
		+ "/~ and t.BDATE = '[bdate]' ~/"
		+ "/~ and t.ID_NAME = '[idName]' ~/"
		+ "/~ and t.ID_CODE = '[idCode]' ~/"
		+ "/~ and [xzqh] ~/"
		+ "/~ and t.ADDRESS = '[address]' ~/"
		+ "/~ and t.WORKUNIT = '[workunit]' ~/"
		+ "/~ and t.PHONE = '[phone]' ~/"
		+ "/~ and t.USE = '[use]' ~/"
		+ "/~ and t.BUYTYPE = '[buytype]' ~/"
		+ "/~ and t.SORT = '[sort]' ~/"
		+ "/~ and t.QUANTITY >= '[quantity]' ~/"
		+ "/~ and substr(t.logtime,0,8) >= '[logtimeBeginFormat]' ~/"
		+ "/~ and substr(t.logtime,0,8) <= '[logtimeEndFormat]' ~/"
		+ "/~ and t.TRATIME = '[tratime]' ~/"
		+ "/~ and t.OPERATOR = '[operator]' ~/"
		+ "/~ and t.STACODE = '[stacode]' ~/"
		+ "/~ and t.BURCODE = '[burcode]' ~/"
		+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	public List<SsDept> findAllBureau() {
		
		String sql = "select CODE,CALLED,PARENTID AS CITY_CODE from V_DEPT_TREE  t where deptlevel=2 order by CODE asc ";

		List hotelBsRoomsConfigList = getJdbcTemplate().query(sql,
				new SsDeptMapper());
		return hotelBsRoomsConfigList;
	}
	
	
	protected class SsDeptMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SsDept ssDept = new SsDept();
			ssDept.setDeptcode(rs.getString("CODE"));
			ssDept.setDeptname(rs.getString("CALLED"));

			return ssDept;

		}
	}
	
	
	/**
	 * 获取组织机构信息
	 * @return
	 */
	public List<SsDept> findDept(String sqlWhere) {
		
		
		String sql = "select CODE,CALLED,PARENTID as CITY_CODE,deptlevel as chessTel from V_DEPT_TREE t where 1=1" ;
		if (sqlWhere != null && sqlWhere.length() > 0 )
			sql = sql +sqlWhere;
		sql = sql +" order by CODE asc ";
		List hotelBsRoomsConfigList = getJdbcTemplate().query(sql,
				new TbuylogssDeptMapper());
		return hotelBsRoomsConfigList;
	}
	
	/**
	 * 获取企业信息
	 * @return
	 */
	public List<SsDept> findComp(String sqlWhere) {
		
		
		String sql = "select CPCODE AS CODE, CPNAME AS CALLED  from T_COMPANYINFO where 1=1" ;
		if (sqlWhere != null && sqlWhere.length() > 0 )
			sql = sql +sqlWhere;
		sql = sql +" order by CODE asc ";
		List hotelBsRoomsConfigList = getJdbcTemplate().query(sql,
				new TbuylogsCompMapper());
		return hotelBsRoomsConfigList;
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
	/**
	 * 不能公用，查询组织机构信息使用
	 * @author f
	 *
	 */
	protected class TbuylogssDeptMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SsDept ssDept = new SsDept();
			ssDept.setDeptcode(rs.getString("CODE"));
			ssDept.setDeptname(rs.getString("CALLED"));
			ssDept.setDeptlevel(rs.getInt("chessTel"));
			ssDept.setParentid(rs.getString("CITY_CODE"));
			
			return ssDept;
			
		}
	}
	
	/**
	 * 不能公用，查询组织机构信息使用
	 * @author f
	 *
	 */
	protected class TbuylogsCompMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SsDept ssDept = new SsDept();
			ssDept.setDeptcode(rs.getString("CODE"));
			ssDept.setDeptname(rs.getString("CALLED"));
			return ssDept;
			
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
	
	
	private String createSql = "insert into T_BUYLOG " 
		 + " (ID,NAME,SEX,NATION,BDATE,ID_NAME,ID_CODE,XZQH,ADDRESS,WORKUNIT,PHONE,USE,BUYTYPE,SORT,QUANTITY,LOGTIME,TRATIME,OPERATOR,STACODE,BURCODE ) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
	private String updateSql = "update T_BUYLOG set "
		+ " ID=?,NAME=?,SEX=?,NATION=?,BDATE=?,ID_NAME=?,ID_CODE=?,XZQH=?,ADDRESS=?,WORKUNIT=?,PHONE=?,USE=?,BUYTYPE=?,SORT=?,QUANTITY=?,LOGTIME=?,TRATIME=?,OPERATOR=?,STACODE=?,BURCODE=?  "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tbuylog entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getName());
						ps.setString(3, entity.getSex());
						ps.setString(4, entity.getNation());
						ps.setString(5, entity.getBdate());
						ps.setString(6, entity.getIdName());
						ps.setString(7, entity.getIdCode());
						ps.setString(8, entity.getXzqh());
						ps.setString(9, entity.getAddress());
						ps.setString(10, entity.getWorkunit());
						ps.setString(11, entity.getPhone());
						ps.setString(12, entity.getUse());
						ps.setString(13, entity.getBuytype());
						ps.setString(14, entity.getSort());
						ps.setLong(15, entity.getQuantity());
						ps.setString(16, entity.getLogtime());
						ps.setString(17, entity.getTratime());
						ps.setString(18, entity.getOperator());
						ps.setString(19, entity.getStacode());
						ps.setString(20, entity.getBurcode());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTbuylog(final Tbuylog entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getIdName());
				ps.setString(7, entity.getIdCode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setString(10, entity.getWorkunit());
				ps.setString(11, entity.getPhone());
				ps.setString(12, entity.getUse());
				ps.setString(13, entity.getBuytype());
				ps.setString(14, entity.getSort());
				ps.setLong(15, entity.getQuantity());
				ps.setString(16, entity.getLogtime());
				ps.setString(17, entity.getTratime());
				ps.setString(18, entity.getOperator());
				ps.setString(19, entity.getStacode());
				ps.setString(20, entity.getBurcode());
			}
		});
	}

	
	public void updateTbuylog(final Tbuylog entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getIdName());
				ps.setString(7, entity.getIdCode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setString(10, entity.getWorkunit());
				ps.setString(11, entity.getPhone());
				ps.setString(12, entity.getUse());
				ps.setString(13, entity.getBuytype());
				ps.setString(14, entity.getSort());
				ps.setLong(15, entity.getQuantity());
				ps.setString(16, entity.getLogtime());
				ps.setString(17, entity.getTratime());
				ps.setString(18, entity.getOperator());
				ps.setString(19, entity.getStacode());
				ps.setString(20, entity.getBurcode());
			}
		});
	}

	
	public void deleteTbuylog(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
