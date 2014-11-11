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

import com.dyneinfo.jxy.dao.*;
import com.dyneinfo.jxy.model.*;
import com.dyneinfo.jxy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class VupdatacountDao extends BaseSpringJdbcDao<Vupdatacount,java.lang.String>{
	
	public Class getEntityClass() {
		return Vupdatacount.class;
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
	
	public void save(Vupdatacount entity) {
		String sql = "insert into T_COMPANYINFO " 
			 + " (CPCODE,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,FLAG,STATION,BASJ) " 
			 + " values "
			 + " (:cpcode,:cpname,:cpaddress,:phone,:fax,:postalcode,:startdate,:economy,:corpcode,:corpname,:policename,:policephone,:workarea,:enrolcapital,:acreage,:policeunit,:scbackupno,:scbackupunit,:licence,:licenceunit,:bcretcode,:bcretunit,:taxcode,:taxunit,:flag,:station,:basj)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_COMPANYINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Vupdatacount entity) {
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
		
		String hsql = "select " +
				"cpname," +
				"intime as startdate," +
				"policename," +
				"corpname," +
				"upcount as count" +
				"  from v_updatacount t,ss_dept s";
		
		String sql = hsql + "  where 1=1  and t.station=s.deptid"
		+ "/~ and s.deptSeq like '[deptSeq]%' ~/"
				+ "/~ and t.cpname like '%[cpname]%' ~/"
				+ "/~ and t.corpname like '%[corpname]%' ~/"
				+ "/~ and s.deptseq like '[station]%' ~/"
				+ "/~ and t.intime >= '[birthBeginFormat]' ~/"
				+ "/~ and t.intime <= '[birthEndFormat]' ~/"
				+ "/~ and t.datatype like '%[datatype]%' ~/"
				+ "/~ and t.upcount like '[count]' ~/"
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
		 + " (CPCODE,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,POLICEUNIT,SCBACKUPNO,SCBACKUPUNIT,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,FLAG,STATION,BASJ) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_COMPANYINFO set "
		+ " CPCODE=?,CPNAME=?,CPADDRESS=?,PHONE=?,FAX=?,POSTALCODE=?,STARTDATE=?,ECONOMY=?,CORPCODE=?,CORPNAME=?,POLICENAME=?,POLICEPHONE=?,WORKAREA=?,ENROLCAPITAL=?,ACREAGE=?,POLICEUNIT=?,SCBACKUPNO=?,SCBACKUPUNIT=?,LICENCE=?,LICENCEUNIT=?,BCRETCODE=?,BCRETUNIT=?,TAXCODE=?,TAXUNIT=?,FLAG=?,STATION=?,BASJ=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Vupdatacount entity) throws IOException {
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
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createVupdatacount(final Vupdatacount entity) {
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
			}
		});
	}

	
	public void updateVupdatacount(final Vupdatacount entity) {
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
			}
		});
	}

	
	public void deleteVupdatacount(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
