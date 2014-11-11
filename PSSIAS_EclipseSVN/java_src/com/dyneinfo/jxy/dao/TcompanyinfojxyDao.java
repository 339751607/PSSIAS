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
public class TcompanyinfojxyDao extends BaseSpringJdbcDao<Tcompanyinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcompanyinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "cpcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CPCODE as cpcode,"
				+" CPNAME as cpname,"
				+" CPADDRESS as cpaddress,"
				+" PHONE as phone,"
				+" FAX as fax,"
				+" POSTALCODE as postalcode,"
				+" STARTDATE as startdate,"
				+" ECONOMY as economy,"
				+" CORPCODE as corpcode,"
				+" CORPNAME as corpname,"
				+" POLICENAME as policename,"
				+" POLICEPHONE as policephone,"
				+" WORKAREA as workarea,"
				+" ENROLCAPITAL as enrolcapital,"
				+" ACREAGE as acreage,"
				+" POLICEUNIT as policeunit,"
				+" SCBACKUPNO as scbackupno,"
				+" SCBACKUPUNIT as scbackupunit,"
				+" LICENCE as licence,"
				+" LICENCEUNIT as licenceunit,"
				+" BCRETCODE as bcretcode,"
				+" BCRETUNIT as bcretunit,"
				+" TAXCODE as taxcode,"
				+" TAXUNIT as taxunit,"
				+" FLAG as flag,"
				+" STATION as station,"
				+" BASJ as basj"
				
				+" from T_COMPANYINFO ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_COMPANYINFO where CPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where CPCODE=? ";
	}
	
	public void save(Tcompanyinfo entity) {
		String sql = "insert into T_COMPANYINFO " 
			 + " (CPCODE,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,FLAG,STATION) " 
			 + " values "
			 + " ('C0'||T_COMPANYINFO_CPCODE.nextval,:cpname,:cpaddress,:phone,:fax,:postalcode,:startdate,:economy,:corpcode,:corpname,:policename,:policephone,:workarea,:enrolcapital,:acreage,:policeunit,:scbackupno,:scbackupunit,:licence,:licenceunit,:bcretcode,:bcretunit,:taxcode,:taxunit,:flag,:station)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"T_COMPANYINFO_CPCODE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcompanyinfo entity) {
		String sql = "update T_COMPANYINFO set "
					+ " CPCODE=:cpcode,CPNAME=:cpname,CPADDRESS=:cpaddress,PHONE=:phone,FAX=:fax,POSTALCODE=:postalcode,STARTDATE=:startdate,ECONOMY=:economy,CORPCODE=:corpcode,CORPNAME=:corpname,POLICENAME=:policename,POLICEPHONE=:policephone,WORKAREA=:workarea,ENROLCAPITAL=:enrolcapital,ACREAGE=:acreage,POLICEUNIT=:policeunit,SCBACKUPNO=:scbackupno,SCBACKUPUNIT=:scbackupunit,LICENCE=:licence,LICENCEUNIT=:licenceunit,BCRETCODE=:bcretcode,BCRETUNIT=:bcretunit,TAXCODE=:taxcode,TAXUNIT=:taxunit,FLAG=:flag,STATION=:station,BASJ=:basj "
					+ " where CPCODE=:cpcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t,ss_dept d where d.deptid=t.cpcode "
		+ "/~ and d.deptSeq like '[deptSeq]%' ~/"
				+ "/~ and t.CPNAME LIKE '%[cpname]%' ~/"
				+ "/~ and t.CPADDRESS like '%[cpaddress]%' ~/"
				+ "/~ and t.PHONE = '%[phone]%' ~/"
				+ "/~ and t.FAX = '[fax]' ~/"
				+ "/~ and t.POSTALCODE = '[postalcode]' ~/"
				+ "/~ and t.STARTDATE = '[startdate]' ~/"
				+ "/~ and t.ECONOMY = '[economy]' ~/"
				+ "/~ and t.CORPCODE = '[corpcode]' ~/"
				+ "/~ and t.CORPNAME = '[corpname]' ~/"
				+ "/~ and t.POLICENAME = '[policename]' ~/"
				+ "/~ and t.POLICEPHONE = '[policephone]' ~/"
				+ "/~ and t.WORKAREA = '[workarea]' ~/"
				+ "/~ and t.ENROLCAPITAL = '[enrolcapital]' ~/"
				+ "/~ and t.ACREAGE = '[acreage]' ~/"
				+ "/~ and t.POLICEUNIT = '[policeunit]' ~/"
				+ "/~ and t.SCBACKUPNO = '[scbackupno]' ~/"
				+ "/~ and t.SCBACKUPUNIT = '[scbackupunit]' ~/"
				+ "/~ and t.LICENCE = '[licence]' ~/"
				+ "/~ and t.LICENCEUNIT = '[licenceunit]' ~/"
				+ "/~ and t.BCRETCODE = '[bcretcode]' ~/"
				+ "/~ and t.BCRETUNIT = '[bcretunit]' ~/"
				+ "/~ and t.TAXCODE = '[taxcode]' ~/"
				+ "/~ and t.TAXUNIT = '[taxunit]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.STATION like '[station]' ~/"
				+ "/~ and t.BASJ = '[basj]' ~/"
				+ "/~ and t.FLAGPACK = '[flagpack]' ~/"
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
	
	
	private String createSql = "insert into T_COMPANYINFO " 
		 + " (CPCODE,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,FLAG,STATION,BASJ,FLAGPACK) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_COMPANYINFO set "
		+ " CPCODE=?,CPNAME=?,CPADDRESS=?,PHONE=?,FAX=?,POSTALCODE=?,STARTDATE=?,ECONOMY=?,CORPCODE=?,CORPNAME=?,POLICENAME=?,POLICEPHONE=?,WORKAREA=?,ENROLCAPITAL=?,ACREAGE=?,POLICEUNIT=?,SCBACKUPNO=?,SCBACKUPUNIT=?,LICENCE=?,LICENCEUNIT=?,BCRETCODE=?,BCRETUNIT=?,TAXCODE=?,TAXUNIT=?,FLAG=?,STATION=?,BASJ=?,FLAGPACK=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcompanyinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getCpname());
						ps.setString(3, entity.getCpaddress());
						ps.setString(4, entity.getPhone());
						ps.setString(5, entity.getFax());
						ps.setString(6, entity.getPostalcode());
						ps.setString(7, entity.getStartdate());
						ps.setString(8, entity.getEconomy());
						ps.setString(9, entity.getCorpcode());
						ps.setString(10, entity.getCorpname());
						ps.setString(11, entity.getPolicename());
						ps.setString(12, entity.getPolicephone());
						ps.setString(13, entity.getWorkarea());
						ps.setLong(14, entity.getEnrolcapital());
						ps.setLong(15, entity.getAcreage());
						ps.setString(16, entity.getPoliceunit());
						ps.setString(17, entity.getScbackupno());
						ps.setString(18, entity.getScbackupunit());
						ps.setString(19, entity.getLicence());
						ps.setString(20, entity.getLicenceunit());
						ps.setString(21, entity.getBcretcode());
						ps.setString(22, entity.getBcretunit());
						ps.setString(23, entity.getTaxcode());
						ps.setString(24, entity.getTaxunit());
						ps.setString(25, entity.getFlag());
						ps.setString(26, entity.getStation());
						ps.setString(27, entity.getBasj());
						ps.setString(28, entity.getFlagpack());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcompanyinfo(final Tcompanyinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCpname());
				ps.setString(3, entity.getCpaddress());
				ps.setString(4, entity.getPhone());
				ps.setString(5, entity.getFax());
				ps.setString(6, entity.getPostalcode());
				ps.setString(7, entity.getStartdate());
				ps.setString(8, entity.getEconomy());
				ps.setString(9, entity.getCorpcode());
				ps.setString(10, entity.getCorpname());
				ps.setString(11, entity.getPolicename());
				ps.setString(12, entity.getPolicephone());
				ps.setString(13, entity.getWorkarea());
				ps.setLong(14, entity.getEnrolcapital());
				ps.setLong(15, entity.getAcreage());
				ps.setString(16, entity.getPoliceunit());
				ps.setString(17, entity.getScbackupno());
				ps.setString(18, entity.getScbackupunit());
				ps.setString(19, entity.getLicence());
				ps.setString(20, entity.getLicenceunit());
				ps.setString(21, entity.getBcretcode());
				ps.setString(22, entity.getBcretunit());
				ps.setString(23, entity.getTaxcode());
				ps.setString(24, entity.getTaxunit());
				ps.setString(25, entity.getFlag());
				ps.setString(26, entity.getStation());
				ps.setString(27, entity.getBasj());
				ps.setString(28, entity.getFlagpack());
			}
		});
	}

	
	public void updateTcompanyinfo(final Tcompanyinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCpname());
				ps.setString(3, entity.getCpaddress());
				ps.setString(4, entity.getPhone());
				ps.setString(5, entity.getFax());
				ps.setString(6, entity.getPostalcode());
				ps.setString(7, entity.getStartdate());
				ps.setString(8, entity.getEconomy());
				ps.setString(9, entity.getCorpcode());
				ps.setString(10, entity.getCorpname());
				ps.setString(11, entity.getPolicename());
				ps.setString(12, entity.getPolicephone());
				ps.setString(13, entity.getWorkarea());
				ps.setLong(14, entity.getEnrolcapital());
				ps.setLong(15, entity.getAcreage());
				ps.setString(16, entity.getPoliceunit());
				ps.setString(17, entity.getScbackupno());
				ps.setString(18, entity.getScbackupunit());
				ps.setString(19, entity.getLicence());
				ps.setString(20, entity.getLicenceunit());
				ps.setString(21, entity.getBcretcode());
				ps.setString(22, entity.getBcretunit());
				ps.setString(23, entity.getTaxcode());
				ps.setString(24, entity.getTaxunit());
				ps.setString(25, entity.getFlag());
				ps.setString(26, entity.getStation());
				ps.setString(27, entity.getBasj());
				ps.setString(28, entity.getFlagpack());
			}
		});
	}

	
	public void deleteTcompanyinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	public void InsertDept(Tcompanyinfo entity){
		String sql = "insert into ss_dept(deptid,deptname,deptdesc,deptcode,deptseq,parentid,deptlevel)" +
				"values('C0'||T_COMPANYINFO_CPCODE.currval,:cpname,:cpname,'C0'||T_COMPANYINFO_CPCODE.currval,'.1000.371000.371005.'||'"+entity.getStation()+"'||'.CO'||T_COMPANYINFO_CPCODE.currval,'"+entity.getStation()+"','5') ";
		insertWithAssigned(entity,sql); //手工分配
	
	}
	//判断是否有子部门
	public int dept(String cpcode){
		String sql = "select count(*) from ss_dept where parentid=?";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public int User(String cpcode){
		String sql = "select count(*) from ss_user where username=?";
		int totalCount = 0 ;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
		
	}
	public int tcpchange(String cpcode,String changecode){
		String sql = "select count(*) from t_cpchange where cpcode=? and changecode=? ";
		int totalCount = 0 ;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode,changecode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
		
	}
	public void updateCpname(String cpname,String code){
		String sql = "update T_COMPANYINFO set " +
				"CPNAME=:cpname where CPCODE=:code";
		String hql= "update ss_dept set deptname=:cpname ,deptdesc=:cpname where deptid=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("cpname",cpname);
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
		getNamedParameterJdbcTemplate().update(hql, namedParameters);
		
	}
	public void updateCpaddress(String cpaddress,String code){
		String sql = "update T_COMPANYINFO set " +
				"CPADDRESS=:cpaddress where CPCODE=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("cpaddress",cpaddress);
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	//s_corpname  , s_policename  ,s_policeunit  ,s_station
	public void updatestation(String station ,String code,String deptid,String deptLevel){
		String sql = "update T_COMPANYINFO set " +
				"station=:deptid where CPCODE=:code";
		String hql = "update ss_dept set deptseq= '"+station+"'," +
				"parentid='"+deptid+"' ,deptlevel='"+deptLevel+"' where deptid=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("deptid",deptid);
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
		getNamedParameterJdbcTemplate().update(hql, namedParameters);
	}
	public void updatepoliceunit(String policeunit ,String code){
		String sql = "update T_COMPANYINFO set " +
				"policeunit=:policeunit where CPCODE=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("policeunit",policeunit);
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void updatepolicename(String policename ,String code){
		String sql = "update T_COMPANYINFO set " +
				"policename=:policename where CPCODE=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("policename",policename );
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	public void updateCorpname(String corpname ,String code){
		String sql = "update T_COMPANYINFO set " +
				"corpname=:corpname where CPCODE=:code";
		Map namedParameters = new HashMap();
		namedParameters.put("corpname",corpname );
		namedParameters.put("code",code);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	

	public void insertCorpname(String cpcode,String beforeconten,String changedate,String aftercontent,String changecode){
		String sql = "insert into  t_cpchange(id,cpcode,changedate,changecode,beforeconten,aftercontent) values(" +
		"SEQ_T_CPCHANGE.nextval,:cpcode,:changedate,:changecode,:beforeconten,:aftercontent)";
		Map namedParameters = new HashMap();
		namedParameters.put("cpcode",cpcode);
		namedParameters.put("changedate",changedate);
		namedParameters.put("beforeconten",beforeconten);
		namedParameters.put("aftercontent",aftercontent);
		namedParameters.put("changecode",changecode);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
		
	}
	public void deletedept(String code){
		
		getJdbcTemplate().update("delete from  ss_dept  where DEPTID = ?", new Object[] {code});
	}
	public void delete(String code){
		
		getJdbcTemplate().update("delete from T_COMPANYINFO where CPCODE = ? ", new Object[] {code});
	}
	
	public String deptname(String deptid){
		String sql = "select deptname FROM ss_dept where deptid = '"+deptid+"'";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		return fjmc;
	}
	public String getbyid1(String id){
		String  sql= "Select Called from t_Diccon where partof='26' and Code||'000000'='"+id+"'";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		return fjmc;
	}

	
	
	
	

}
