/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.dao;

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

import com.dyneinfo.ylcs.model.*;
import com.dyneinfo.ylcs.dao.*;
import com.dyneinfo.ylcs.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpinfoYlDao extends BaseSpringJdbcDao<TcpinfoYl,java.lang.String>{
	
	public Class getEntityClass() {
		return TcpinfoYl.class;
	}
	
	public String getIdentifierPropertyName() {
		return "locode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" LOCODE as locode,"
				+" STATION as station,"
				+" STARTDATE as startdate,"
				+" ACREAGE as acreage,"
				+" ENROLCAPITAL as enrolcapital,"
				+" CPNAME as cpname,"
				+" CPADDRESS as cpaddress,"
				+" PHONE as phone,"
				+" FAX as fax,"
				+" POSTALCODE as postalcode,"
				+" ECONOMY as economy,"
				+" CORPCODE as corpcode,"
				+" CORPNAME as corpname,"
				+" POLICENAME as policename,"
				+" POLICEPHONE as policephone,"
				+" WORKAREA as workarea,"
				+" POLICEUNIT as policeunit,"
				+" SCBACKUPNO as scbackupno,"
				+" SCBACKUPUNIT as scbackupunit,"
				+" LICENCE as licence,"
				+" LICENCEUNIT as licenceunit,"
				+" BCRETCODE as bcretcode,"
				+" BCRETUNIT as bcretunit,"
				+" TAXCODE as taxcode,"
				+" TAXUNIT as taxunit,"
				+" THCODE as thcode,"
				+" FJCODE as fjcode,"
				+" WORKAREASEC as workareasec,"
				+" STOPDATE as stopdate,"
				+" HIS as his,"
				+" JWDZB as jwdzb,"
				+" GDXX as gdxx,"
				+" XFZSL as xfzsl,"
				+" BXSL as bxsl,"
				+" ZAJB as zajb,"
				+" CSXJ as csxj,"
				+" STATE as state,"
				+" POLICELEVELCODE as policelevelcode,"
				+" FLAGPACK as flagpack,"
				+" AUTHORIZATIONCODE as authorizationcode,"
				+" SPJRURL as spjrurl,"
				+" CURRENTSCORE as currentscore,"
				+" JCJB as jcjb"
				+" from T_CPINFO ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPINFO where LOCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where LOCODE=? ";
	}
	
	public void save(TcpinfoYl entity) {
		String sql = "insert into T_CPINFO " 
			 + " (LOCODE,STATION,STARTDATE,ACREAGE,ENROLCAPITAL,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,THCODE,FJCODE,WORKAREASEC,STOPDATE,HIS,JWDZB,GDXX,XFZSL,BXSL,ZAJB,CSXJ,STATE,POLICELEVELCODE,FLAGPACK,AUTHORIZATIONCODE,SPJRURL,CURRENTSCORE,JCJB) " 
			 + " values "
			 + " (:locode,:station,:startdate,:acreage,:enrolcapital,:cpname,:cpaddress,:phone,:fax,:postalcode,:economy,:corpcode,:corpname,:policename,:policephone,:workarea,:policeunit,:scbackupno,:scbackupunit,:licence,:licenceunit,:bcretcode,:bcretunit,:taxcode,:taxunit,:thcode,:fjcode,:workareasec,:stopdate,:his,:jwdzb,:gdxx,:xfzsl,:bxsl,:zajb,:csxj,:state,:policelevelcode,:flagpack,:authorizationcode,:spjrurl,:currentscore,:jcjb)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CPINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TcpinfoYl entity) {
		String sql = "update T_CPINFO set "
					+ " LOCODE=:locode,STATION=:station,STARTDATE=:startdate,ACREAGE=:acreage,ENROLCAPITAL=:enrolcapital,CPNAME=:cpname,CPADDRESS=:cpaddress,PHONE=:phone,FAX=:fax,POSTALCODE=:postalcode,ECONOMY=:economy,CORPCODE=:corpcode,CORPNAME=:corpname,POLICENAME=:policename,POLICEPHONE=:policephone,WORKAREA=:workarea,POLICEUNIT=:policeunit,SCBACKUPNO=:scbackupno,SCBACKUPUNIT=:scbackupunit,LICENCE=:licence,LICENCEUNIT=:licenceunit,BCRETCODE=:bcretcode,BCRETUNIT=:bcretunit,TAXCODE=:taxcode,TAXUNIT=:taxunit,THCODE=:thcode,FJCODE=:fjcode,WORKAREASEC=:workareasec,STOPDATE=:stopdate,HIS=:his,JWDZB=:jwdzb,GDXX=:gdxx,XFZSL=:xfzsl,BXSL=:bxsl,ZAJB=:zajb,CSXJ=:csxj,STATE=:state,POLICELEVELCODE=:policelevelcode,FLAGPACK=:flagpack,AUTHORIZATIONCODE=:authorizationcode,SPJRURL=:spjrurl,CURRENTSCORE=:currentscore,JCJB=:jcjb "
					+ " where LOCODE=:locode";
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
				+ "/~ and t.STATION = '[station]' ~/"
				+ "/~ and t.STARTDATE = '[startdate]' ~/"
				+ "/~ and t.ACREAGE = '[acreage]' ~/"
				+ "/~ and t.ENROLCAPITAL = '[enrolcapital]' ~/"
				+ "/~ and t.CPNAME = '[cpname]' ~/"
				+ "/~ and t.CPADDRESS = '[cpaddress]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.FAX = '[fax]' ~/"
				+ "/~ and t.POSTALCODE = '[postalcode]' ~/"
				+ "/~ and t.ECONOMY = '[economy]' ~/"
				+ "/~ and t.CORPCODE = '[corpcode]' ~/"
				+ "/~ and t.CORPNAME = '[corpname]' ~/"
				+ "/~ and t.POLICENAME = '[policename]' ~/"
				+ "/~ and t.POLICEPHONE = '[policephone]' ~/"
				+ "/~ and t.WORKAREA = '[workarea]' ~/"
				+ "/~ and t.POLICEUNIT = '[policeunit]' ~/"
				+ "/~ and t.SCBACKUPNO = '[scbackupno]' ~/"
				+ "/~ and t.SCBACKUPUNIT = '[scbackupunit]' ~/"
				+ "/~ and t.LICENCE = '[licence]' ~/"
				+ "/~ and t.LICENCEUNIT = '[licenceunit]' ~/"
				+ "/~ and t.BCRETCODE = '[bcretcode]' ~/"
				+ "/~ and t.BCRETUNIT = '[bcretunit]' ~/"
				+ "/~ and t.TAXCODE = '[taxcode]' ~/"
				+ "/~ and t.TAXUNIT = '[taxunit]' ~/"
				+ "/~ and t.THCODE = '[thcode]' ~/"
				+ "/~ and t.FJCODE = '[fjcode]' ~/"
				+ "/~ and t.WORKAREASEC = '[workareasec]' ~/"
				+ "/~ and t.STOPDATE = '[stopdate]' ~/"
				+ "/~ and t.HIS = '[his]' ~/"
				+ "/~ and t.JWDZB = '[jwdzb]' ~/"
				+ "/~ and t.GDXX = '[gdxx]' ~/"
				+ "/~ and t.XFZSL = '[xfzsl]' ~/"
				+ "/~ and t.BXSL = '[bxsl]' ~/"
				+ "/~ and t.ZAJB = '[zajb]' ~/"
				+ "/~ and t.CSXJ = '[csxj]' ~/"
				+ "/~ and t.STATE = '[state]' ~/"
				+ "/~ and t.POLICELEVELCODE = '[policelevelcode]' ~/"
				+ "/~ and t.FLAGPACK = '[flagpack]' ~/"
				+ "/~ and t.AUTHORIZATIONCODE = '[authorizationcode]' ~/"
				+ "/~ and t.SPJRURL = '[spjrurl]' ~/"
				+ "/~ and t.CURRENTSCORE = '[currentscore]' ~/"
				+ "/~ and t.JCJB = '[jcjb]' ~/"
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
	
	
	private String createSql = "insert into T_CPINFO " 
		 + " (LOCODE,STATION,STARTDATE,ACREAGE,ENROLCAPITAL,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,THCODE,FJCODE,WORKAREASEC,STOPDATE,HIS,JWDZB,GDXX,XFZSL,BXSL,ZAJB,CSXJ,STATE,POLICELEVELCODE,FLAGPACK,AUTHORIZATIONCODE,SPJRURL,CURRENTSCORE,JCJB) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CPINFO set "
		+ " LOCODE=?,STATION=?,STARTDATE=?,ACREAGE=?,ENROLCAPITAL=?,CPNAME=?,CPADDRESS=?,PHONE=?,FAX=?,POSTALCODE=?,ECONOMY=?,CORPCODE=?,CORPNAME=?,POLICENAME=?,POLICEPHONE=?,WORKAREA=?,POLICEUNIT=?,SCBACKUPNO=?,SCBACKUPUNIT=?,LICENCE=?,LICENCEUNIT=?,BCRETCODE=?,BCRETUNIT=?,TAXCODE=?,TAXUNIT=?,THCODE=?,FJCODE=?,WORKAREASEC=?,STOPDATE=?,HIS=?,JWDZB=?,GDXX=?,XFZSL=?,BXSL=?,ZAJB=?,CSXJ=?,STATE=?,POLICELEVELCODE=?,FLAGPACK=?,AUTHORIZATIONCODE=?,SPJRURL=?,CURRENTSCORE=?,JCJB=? "
		+ " where LOCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TcpinfoYl entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getLocode());
						ps.setString(2, entity.getStation());
//						ps.setjava.util.Date(3, entity.getStartdate());
						ps.setLong(4, entity.getAcreage());
						ps.setLong(5, entity.getEnrolcapital());
						ps.setString(6, entity.getCpname());
						ps.setString(7, entity.getCpaddress());
						ps.setString(8, entity.getPhone());
						ps.setString(9, entity.getFax());
						ps.setString(10, entity.getPostalcode());
						ps.setString(11, entity.getEconomy());
						ps.setString(12, entity.getCorpcode());
						ps.setString(13, entity.getCorpname());
						ps.setString(14, entity.getPolicename());
						ps.setString(15, entity.getPolicephone());
						ps.setString(16, entity.getWorkarea());
						ps.setString(17, entity.getPoliceunit());
						ps.setString(18, entity.getScbackupno());
						ps.setString(19, entity.getScbackupunit());
						ps.setString(20, entity.getLicence());
						ps.setString(21, entity.getLicenceunit());
						ps.setString(22, entity.getBcretcode());
						ps.setString(23, entity.getBcretunit());
						ps.setString(24, entity.getTaxcode());
						ps.setString(25, entity.getTaxunit());
						ps.setString(26, entity.getThcode());
						ps.setString(27, entity.getFjcode());
						ps.setString(28, entity.getWorkareasec());
//						ps.setjava.util.Date(29, entity.getStopdate());
						ps.setString(30, entity.getHis());
						ps.setString(31, entity.getJwdzb());
						ps.setString(32, entity.getGdxx());
						ps.setInt(33, entity.getXfzsl());
						ps.setInt(34, entity.getBxsl());
						ps.setString(35, entity.getZajb());
						ps.setString(36, entity.getCsxj());
						ps.setString(37, entity.getState());
						ps.setString(38, entity.getPolicelevelcode());
						ps.setString(39, entity.getFlagpack());
						ps.setString(40, entity.getAuthorizationcode());
						ps.setString(41, entity.getSpjrurl());
						ps.setLong(42, entity.getCurrentscore());
						ps.setString(43, entity.getJcjb());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpinfoYl(final TcpinfoYl entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getLocode());
				ps.setString(2, entity.getStation());
//				ps.setjava.util.Date(3, entity.getStartdate());
				ps.setLong(4, entity.getAcreage());
				ps.setLong(5, entity.getEnrolcapital());
				ps.setString(6, entity.getCpname());
				ps.setString(7, entity.getCpaddress());
				ps.setString(8, entity.getPhone());
				ps.setString(9, entity.getFax());
				ps.setString(10, entity.getPostalcode());
				ps.setString(11, entity.getEconomy());
				ps.setString(12, entity.getCorpcode());
				ps.setString(13, entity.getCorpname());
				ps.setString(14, entity.getPolicename());
				ps.setString(15, entity.getPolicephone());
				ps.setString(16, entity.getWorkarea());
				ps.setString(17, entity.getPoliceunit());
				ps.setString(18, entity.getScbackupno());
				ps.setString(19, entity.getScbackupunit());
				ps.setString(20, entity.getLicence());
				ps.setString(21, entity.getLicenceunit());
				ps.setString(22, entity.getBcretcode());
				ps.setString(23, entity.getBcretunit());
				ps.setString(24, entity.getTaxcode());
				ps.setString(25, entity.getTaxunit());
				ps.setString(26, entity.getThcode());
				ps.setString(27, entity.getFjcode());
				ps.setString(28, entity.getWorkareasec());
//				ps.setjava.util.Date(29, entity.getStopdate());
				ps.setString(30, entity.getHis());
				ps.setString(31, entity.getJwdzb());
				ps.setString(32, entity.getGdxx());
				ps.setInt(33, entity.getXfzsl());
				ps.setInt(34, entity.getBxsl());
				ps.setString(35, entity.getZajb());
				ps.setString(36, entity.getCsxj());
				ps.setString(37, entity.getState());
				ps.setString(38, entity.getPolicelevelcode());
				ps.setString(39, entity.getFlagpack());
				ps.setString(40, entity.getAuthorizationcode());
				ps.setString(41, entity.getSpjrurl());
				ps.setLong(42, entity.getCurrentscore());
				ps.setString(43, entity.getJcjb());
			}
		});
	}

	
	public void updateTcpinfoYl(final TcpinfoYl entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getLocode());
				ps.setString(2, entity.getStation());
//				ps.setjava.util.Date(3, entity.getStartdate());
				ps.setLong(4, entity.getAcreage());
				ps.setLong(5, entity.getEnrolcapital());
				ps.setString(6, entity.getCpname());
				ps.setString(7, entity.getCpaddress());
				ps.setString(8, entity.getPhone());
				ps.setString(9, entity.getFax());
				ps.setString(10, entity.getPostalcode());
				ps.setString(11, entity.getEconomy());
				ps.setString(12, entity.getCorpcode());
				ps.setString(13, entity.getCorpname());
				ps.setString(14, entity.getPolicename());
				ps.setString(15, entity.getPolicephone());
				ps.setString(16, entity.getWorkarea());
				ps.setString(17, entity.getPoliceunit());
				ps.setString(18, entity.getScbackupno());
				ps.setString(19, entity.getScbackupunit());
				ps.setString(20, entity.getLicence());
				ps.setString(21, entity.getLicenceunit());
				ps.setString(22, entity.getBcretcode());
				ps.setString(23, entity.getBcretunit());
				ps.setString(24, entity.getTaxcode());
				ps.setString(25, entity.getTaxunit());
				ps.setString(26, entity.getThcode());
				ps.setString(27, entity.getFjcode());
				ps.setString(28, entity.getWorkareasec());
//				ps.setjava.util.Date(29, entity.getStopdate());
				ps.setString(30, entity.getHis());
				ps.setString(31, entity.getJwdzb());
				ps.setString(32, entity.getGdxx());
				ps.setInt(33, entity.getXfzsl());
				ps.setInt(34, entity.getBxsl());
				ps.setString(35, entity.getZajb());
				ps.setString(36, entity.getCsxj());
				ps.setString(37, entity.getState());
				ps.setString(38, entity.getPolicelevelcode());
				ps.setString(39, entity.getFlagpack());
				ps.setString(40, entity.getAuthorizationcode());
				ps.setString(41, entity.getSpjrurl());
				ps.setLong(42, entity.getCurrentscore());
				ps.setString(43, entity.getJcjb());
			}
		});
	}

	
	public void deleteTcpinfoYl(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
