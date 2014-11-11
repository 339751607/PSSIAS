/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

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
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcarinfoDao extends BaseSpringJdbcDao<Tcarinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcarinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "enrolid";
	}
	
	public List getJsz(String name){
		String sql= "select distinct CARID from  T_CARINFO where CARID like '%"+name+"%' and ROWNUM <= 5";
		return getJdbcTemplate().queryForList(sql);
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.ENROLID as enrolid,"
				+" t.CAROWNER as carowner,"
				+" t.CARTYPE as cartype,"
				+" t.BRAND as brand,"
				+" t.COLOR as color,"
				+" t.CARID as carid,"
				+" t.ENGINECODE as enginecode,"
				+" t.BODYCODE as bodycode,"
				+" t.ENROLTIME as enroltime,"
				+" t.OPERATOR as operator,"
				+" t.CPCODE as cpcode,"
				+" t.FLAG as flag,"
				+" t.clsbcode as clsbcode,"				
				+" t.CARPICTURE as carpicture,"
				+" c.DELINAME as deliname,"
				+" c.DELICREDCODE as delicredcode,"
				+" c.delitelephone as delitelephone,"
				+" c.deliaddress as deliaddress,"	//接车人住址 add by zzq 2012/06/12
				+" c.recename as recename,"
				+" c.recetime as recetime,"
				+" c.serveritem as serveritem,"
				+" c.takeoffname as takeoffname,"
				+" c.tocredcode as tocredcode,"
				+" c.totime as totime,"
				+" c.demo as demo"
				+" from T_CARINFO t,T_CARRETURN c ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CARINFO where ENROLID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where t.enrolid=c.enrolid and t.ENROLID=? ";
	}
	
	public void save(Tcarinfo entity) {
		String sql = "insert into T_CARINFO " 
			 + " (ENROLID,CAROWNER,clsbcode,CARTYPE,BRAND,COLOR,CARID,ENGINECODE,BODYCODE,ENROLTIME,OPERATOR,CPCODE,FLAG,CARPICTURE) " 
			 + " values "
			 + " (:enrolid,:carowner,:clsbcode,:cartype,:brand,:color,:carid,:enginecode,:bodycode,:enroltime,:operator,:cpcode,:flag,:carpicture)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_CARINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcarinfo entity) {
		String sql = "update T_CARINFO set "
					+ " ENROLID=:enrolid,clsbcode=:clsbcode,CAROWNER=:carowner,CARTYPE=:cartype,BRAND=:brand,COLOR=:color,CARID=:carid,ENGINECODE=:enginecode,BODYCODE=:bodycode,ENROLTIME=:enroltime,OPERATOR=:operator,CPCODE=:cpcode,FLAG=:flag,CARPICTURE=:carpicture "
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
		String sql = getSelectPrefix() + " where t.enrolid=c.enrolid  "
				+ "/~ and substr(t.enrolid,0,13)= '[deptid]' ~/"
				+ "/~ and t.CAROWNER like '%[carowner]%' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.BRAND = '[brand]' ~/"
				+ "/~ and t.color  like '%[color]%' ~/"
				

			
				+ "/~ and t.clsbcode like '[clsbcode]%' ~/"
				

				
				
				+ "/~ and t.CARID like '[carid]%' ~/"
				+ "/~ and t.ENGINECODE = '[enginecode]' ~/"
				+ "/~ and t.BODYCODE = '[bodycode]' ~/"
				+ "/~ and t.ENROLTIME >= '[enroltimeBeginFormat]' ~/"
				+ "/~ and t.ENROLTIME <= '[enroltimeEndFormat]' ~/"
				+ "/~ and c.TOTIME >= '[totimeBeginFormat]' ~/"
				+ "/~ and c.TOTIME <= '[totimeEndFormat]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and [notExistSql] ~/"
				+ "/~ and [existSql] ~/"
				+ "/~ and c.SERVERITEM like '%[serveritem]%' ~/"
				+ "/~ and c.DELINAME like '%[deliname]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	public Page findByPageRequest1(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String hql = "select  " +
			"  ss.deptname as deptname,"
			+" t.ENROLID as enrolid,"
			+" t.CAROWNER as carowner,"
			+" t.CARTYPE as cartype,"
			+" t.BRAND as brand,"
			+" t.COLOR as color,"
			+" t.CARID as carid,"
			+" t.clsbcode as clsbcode,"	
			+" t.ENGINECODE as enginecode,"
			+" t.BODYCODE as bodycode,"
			+" t.ENROLTIME as enroltime,"
			+" t.OPERATOR as operator,"
			+" t.CPCODE as cpcode,"
			+" t.FLAG as flag,"
			+" t.CARPICTURE as carpicture,"
			+" c.DELINAME as deliname,"
			+" c.DELICREDCODE as delicredcode,"
			+" c.delitelephone as delitelephone,"
			+" c.deliaddress as deliaddress,"	//接车人住址 add by zzq 2012/06/12
			+" c.recename as recename,"
			+" c.recetime as recetime,"
			+" c.serveritem as serveritem,"
			+" c.takeoffname as takeoffname,"
			+" c.tocredcode as tocredcode,"
			+" c.totime as totime,"
			+" c.demo as demo"
			+" from T_CARINFO t,T_CARRETURN c ,ss_dept ss";
		
		
		String sql = hql + " where t.enrolid=c.enrolid and substr(t.enrolid,0,13)= ss.deptid   "
				+ "/~ and ss.deptseq like '[deptid]%' ~/"
				+ "/~ and t.CAROWNER like '%[carowner]%' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.clsbcode like '[clsbcode]%' ~/"
				

				+ "/~ and t.BRAND = '[brand]' ~/"
				+ "/~ and t.COLOR like '%[color]%' ~/"
				+ "/~ and t.CARID like '[carid]%' ~/"
				+ "/~ and t.ENGINECODE = '[enginecode]' ~/"
				+ "/~ and t.BODYCODE = '[bodycode]' ~/"
				+ "/~ and t.ENROLTIME >= '[enroltimeBeginFormat]' ~/"
				+ "/~ and t.ENROLTIME <= '[enroltimeEndFormat]' ~/"
				+ "/~ and c.TOTIME >= '[totimeBeginFormat]' ~/"
				+ "/~ and c.TOTIME <= '[totimeEndFormat]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and [notExistSql] ~/"
				+ "/~ and [existSql] ~/"
				+ "/~ and c.SERVERITEM like '%[serveritem]%' ~/"
				+ "/~ and c.DELINAME like '%[deliname]%' ~/"
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
	
	public int getMaxSequence(String sequence) throws IOException{
		
		String sql="select  max(t.enrolid) from t_carinfo t where substr(t.enrolid,0,21) = ?";
		String  maxSequence="";
		int newSequence=0;
		Object[] obj ={sequence}; 
		try {   
			maxSequence= (String)this.getJdbcTemplate().queryForObject(sql,obj, String.class);
		} catch (EmptyResultDataAccessException ex) {   
			  logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
		}
		
		if(maxSequence!=null&&maxSequence!=""){
			maxSequence=maxSequence.substring(21,24);
			newSequence=Integer.parseInt(maxSequence);
		}

		return newSequence;
	}
	public List getInfoByCarid(String carid){
		String sql=" select  "
				+" t.ENROLID as enrolid,"
				+" t.CAROWNER as carowner,"
				+" t.CARTYPE as cartype,"
				+" t.BRAND as brand,"
				+" t.COLOR as color,"
				+" t.CARID as carid,"
				+" t.ENGINECODE as enginecode,"
				+" t.BODYCODE as bodycode,"
				+" t.ENROLTIME as enroltime,"
				+" t.OPERATOR as operator,"
				+" t.CPCODE as cpcode,"
				+" t.FLAG as flag,"
				+" c.deliname as deliname,"
				+"c.delicredcode as delicredcode,"
				+"c.delitelephone as delitelephone,"
				+"c.deliaddress as deliaddress,"
				+"t.clsbcode as clsbcode,"
				+" t.CARPICTURE as carpicture " 
				+" from t_carinfo t ,T_CARRETURN c where  t.enrolid=c.enrolid and t.carid= ? order by t.enroltime desc ";
		return getJdbcTemplate().queryForList(sql, new Object[]{carid});
	}
	private String createSql = "insert into T_CARINFO " 
		 + " (ENROLID,CAROWNER,CARTYPE,BRAND,COLOR,CARID,ENGINECODE,BODYCODE,ENROLTIME,OPERATOR,CPCODE,FLAG,CARPICTURE,clsbcode) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
						ps.setString(13, entity.getClsbcode());
//						
						lobCreator.setBlobAsBinaryStream(ps, 13, blobIs,(int) blobIn.length());
						ps.setString(14, entity.getClsbcode());
//						
					}
				});
		blobIs.close();
	}
	//修改图片
	public void updatePic(File file,String enrolid) throws IOException{

		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_enrolid = enrolid;
		getJdbcTemplate().execute(
		  " update T_CARINFO set CARPICTURE = ? where ENROLID =? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        ps.setString(2, str_enrolid);
		      }
		  }
		);
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
//				ps.setjava.sql.Blob(13, entity.getCarpicture());
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
//				ps.setjava.sql.Blob(13, entity.getCarpicture());
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
	public List getServeritem(){
		////select code,called from t_diccon t where t.partof =24 order by code
		//String sql="select code,called from t_diccon t where t.partof =24 order by code";
		
		String sql=" select t.dictid,t.dictname,t.dictlevel from SS_DICT_ITEM t where t.dicttypeid = 'serverItem'  order by t.seqno,t.sortno ";
		return getJdbcTemplate().queryForList(sql);
	}
	
	public List getServeritemForLevelOne(){
		////select code,called from t_diccon t where t.partof =24 order by code
		//String sql="select code,called from t_diccon t where t.partof =24 order by code";
		
		String sql=" select t.dictid,t.dictname,t.dictlevel from SS_DICT_ITEM t where t.dicttypeid = 'serverItem' and t.dictlevel =1  order by t.seqno,t.sortno ";
		return getJdbcTemplate().queryForList(sql);
	}
	
	public List getServeritemForLevelTwo(){
		////select code,called from t_diccon t where t.partof =24 order by code
		//String sql="select code,called from t_diccon t where t.partof =24 order by code";
		
		String sql=" select t.dictid,t.dictname,t.dictlevel,t.parentid  from SS_DICT_ITEM t where t.dicttypeid = 'serverItem' and t.dictlevel =2  order by t.seqno,t.sortno ";
		return getJdbcTemplate().queryForList(sql);
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
