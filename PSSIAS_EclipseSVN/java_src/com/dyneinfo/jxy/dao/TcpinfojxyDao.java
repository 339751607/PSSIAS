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
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpinfojxyDao extends BaseSpringJdbcDao<Tcpinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcpinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "cpcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CPCODE as cpcode,"
				+" CPNAME as cpname,"
				+" CPADDRESS as cpaddress,"
				+" WORKAREA as workarea,"
				+" PHONE as phone,"
				+" FAX as fax,"
				+" ENROLCAPITAL as enrolcapital,"
				+" POSTALCODE as postalcode,"
				+" STARTDATE as startdate,"
				+" ECONOMY as economy,"
				+" CORPCODE as corpcode,"
				+" CORPNAME as corpname,"
				+" POLICENAME as policename,"
				+" POLICEPHONE as policephone,"
				+" ACREAGE as acreage,"
				+" POLICEUNIT as policeunit,"
				+" SCBACKUPNO as scbackupno,"
				+" SCBACKUPUNIT as scbackupunit,"
				+" BASJ as basj,"
				+" LICENCEUNIT as licenceunit,"
				+" BCRETCODE as bcretcode,"
				+" BCRETUNIT as bcretunit,"
				+" TAXCODE as taxcode,"
				+" TAXUNIT as taxunit,"
				+" LICENCE as licence,"
				+" iscode as iscode,"
				+" typecode as typecode,"
				+" smycode as smycode,"
				+" FLAG as flag,"
				+" STATION as station,"
				+" b.deptname as cpDeptName,"
				+" c.deptname as stationName"
				
				+" from T_COMPANYINFO t,ss_dept b,ss_dept c ";
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
		return getSelectPrefix() + " where cpcode = b.deptid and  t.station = c.deptid and CPCODE=? ";
	}
	
	public void save(Tcpinfo entity) {
		String sql = "insert into T_COMPANYINFO " 
			 + " (CPCODE,CPNAME,CPADDRESS,WORKAREA,PHONE,FAX,ENROLCAPITAL,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,ACREAGE,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,BASJ,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,LICENCE,FLAG,STATION) " 
			 + " values "
			 + " (:cpcode,:cpname,:cpaddress,:workarea,:phone,:fax,:enrolcapital,:postalcode,:startdate,:economy,:corpcode,:corpname,:policename,:policephone,:acreage,:policeunit,:scbackupno,:scbackupunit,:basj,:licenceunit,:bcretcode,:bcretunit,:taxcode,:taxunit,:licence,:flag,:station)";
		
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcpinfo entity) {
		String sql = "update T_COMPANYINFO set "
					+ " CPCODE=:cpcode,CPNAME=:cpname,CPADDRESS=:cpaddress,WORKAREA=:workarea,PHONE=:phone,FAX=:fax,ENROLCAPITAL=:enrolcapital,POSTALCODE=:postalcode,STARTDATE=:startdate,ECONOMY=:economy,CORPCODE=:corpcode,CORPNAME=:corpname,POLICENAME=:policename,POLICEPHONE=:policephone,ACREAGE=:acreage,POLICEUNIT=:policeunit,SCBACKUPNO=:scbackupno,SCBACKUPUNIT=:scbackupunit,BASJ=:basj,LICENCEUNIT=:licenceunit,BCRETCODE=:bcretcode,BCRETUNIT=:bcretunit,TAXCODE=:taxcode,TAXUNIT=:taxunit,LICENCE=:licence,FLAG=:flag,STATION=:station "
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
		String sql = getSelectPrefix() + "  where t.cpcode = b.deptid and  t.station = c.deptid "
		        + "/~ and t.cpcode like '%[cpcode]%' ~/"
				+ "/~ and t.CPNAME like '%[cpname]%' ~/"
				+ "/~ and t.CPADDRESS like '%[cpaddress]%' ~/"
				+ "/~ and t.WORKAREA like '%[workarea]%' ~/"
				+ "/~ and t.PHONE like '%[phone]%' ~/"
				+ "/~ and t.FAX like '%[fax]%' ~/"
				+ "/~ and t.ENROLCAPITAL like '%[enrolcapital]%' ~/"
				+ "/~ and t.POSTALCODE like '%[postalcode]%' ~/"
				+ "/~ and t.STARTDATE >= '[startdateBeginFormat]' ~/"
				+ "/~ and t.STARTDATE <= '[startdateEndFormat]' ~/"
				+ "/~ and t.ECONOMY like '%[economy]%' ~/"
				+ "/~ and t.CORPCODE like '%[corpcode]%' ~/"
				+ "/~ and t.CORPNAME like '%[corpname]%' ~/"
				+ "/~ and t.POLICENAME like '%[policename]%' ~/"
				+ "/~ and t.POLICEPHONE like '%[policephone]%' ~/"
				+ "/~ and t.ACREAGE like '%[acreage]%' ~/"
				+ "/~ and t.POLICEUNIT like '%[policeunit]%' ~/"
				+ "/~ and t.SCBACKUPNO like '%[scbackupno]%' ~/"
				+ "/~ and t.SCBACKUPUNIT like '%[scbackupunit]%' ~/"
				+ "/~ and t.BASJ like '%[basj]%' ~/"
				+ "/~ and t.LICENCEUNIT like '%[licenceunit]%' ~/"
				+ "/~ and t.BCRETCODE like '%[bcretcode]%' ~/"
				+ "/~ and t.BCRETUNIT like '%[bcretunit]%' ~/"
				+ "/~ and t.TAXCODE like '%[taxcode]%' ~/"
				+ "/~ and t.TAXUNIT like '%[taxunit]%' ~/"
				+ "/~ and t.LICENCE like '%[licence]%' ~/"
				+ "/~ and t.FLAG like '%[flag]%' ~/"
				+ "/~ and t.STATION like '%[station]%' ~/"
				+ "/~ and b.deptseq like '[deptseq]%' ~/"
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
	
	
	public String getMaxDwbm(String fjbm) throws IOException{
		String sql="select T_COMPANYINFO_CPCODE.nextval from dual ";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		
		

		return fjmc;
	}


	

	/**
	 * 重配置库中读取企业编码的中间值
	 * 
	 * @return
	 * @throws IOException
	 */
	public String getQybmzjz() throws IOException {
		String qybmzjz = null;
		String sql = "select code from t_config where 1=1";
		qybmzjz = (String) this.getJdbcTemplate().queryForObject(sql,
				String.class);
		return qybmzjz;
	}
	
	
	public void deletePmdwxxb(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	
	
	public void saveDept(SsDept e) {
		System.out.println("222");
		String sql = "insert into ss_dept " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " ('"+e.getDeptcode()+"','"+e.getDeptname()+"','"+e.getDeptdesc()+"','"+e.getDeptcode()+"','"+e.getDeptseq()+"','"+e.getDisplayorder()+"','"+e.getParentid()+"','"+e.getDeptlevel()+"','"+e.getDepttypeid()+"','"+e.getStatus()+"')";
		
		insertWithAssigned(e,sql); //手工分配
	}
	
	public void saveUser(SsUser entity) {
		String sql = "insert into SS_USER " 
			 + " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO,CREATEUSERID,DESCRIPTION,EXPIRATIONDATE) " 
			 + " values "
			 + " (:userid,:username,:password,:fullname,:sex,:sfzh,:policeid,:phone,:mobile,:fax,:address,:zip,:emailaddress,:createdate,:deptid,:enabled,:photo,:createuserid,:description,:expirationdate)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_SS_USER",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public String getUserSeq(){
		String sql=" select SEQ_SS_USER.Nextval from dual ";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		return fjmc;
	}
	
	
	public void insertRoleUser(long roleid, long userid) {
		String sql = "INSERT INTO SS_ROLE_USER (ROLEID,USERID) VALUES(:roleid, :userid)";
		Map namedParameters = new HashMap();
		namedParameters.put("roleid", roleid);
		namedParameters.put("userid", userid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void updateDept(SsDept entity) {
		String sql = "update ss_dept set "
			+ " DEPTNAME=:deptname,DEPTDESC=:deptdesc,DEPTCODE=:deptcode,DEPTSEQ=:deptseq,DISPLAYORDER=:displayorder,PARENTID=:parentid,DEPTLEVEL=:deptlevel,DEPTTYPEID=:depttypeid,STATUS=:status "
			+ " where DEPTID=:deptid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	
	
	//判断是否有子部门
	public int isExistChildDept(String cpcode){
		String sql = "select count(*) from ss_dept where parentid = ? ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public int isExistUser(String cpcode){
		String sql = "select count(*) from ss_user where DEPTID = ? ";
		int totalCount = 0 ;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {cpcode} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
		
	}
	
	public void deleteDept(String code){
		
		getJdbcTemplate().update("delete from ss_dept  where DEPTID = ? ", new Object[] {code});
	}
	public void deleteCpinfo(String code){
		
		getJdbcTemplate().update("delete from T_COMPANYINFO where CPCODE = ? ", new Object[] {code});
	}
	
	//查询企业生成用的id，返回前台删除用户角色
	public void deleteUserandrole(String code){
		String sql=" select t.userid from ss_user t where t.deptid= ?";
		try {   
			int userid= getSimpleJdbcTemplate().queryForInt(sql, new Object[] {code});
			getJdbcTemplate().update("delete from ss_role_user b where  b.userid = ? ", new Object[]{userid});
			getJdbcTemplate().update("delete from ss_user a where a.deptid = ?", new Object[]{code});
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       } 
		
	}
	
	public int cpcode(){
		String sql = "select count(*) from T_COMPANYINFO t,ss_dept b where t.cpcode = b.deptid";
		int count = 0 ;
		try {   
			count = getSimpleJdbcTemplate().queryForInt(sql );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		
		return count;
		
	}
	public void insertiscode(Tcpinfo entity) {
		String sql = "update T_COMPANYINFO set "
					+ " iscode = :iscode,typecode=:typecode,smycode=:smycode"
					+ " where CPCODE= :cpcode ";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	
	

}
