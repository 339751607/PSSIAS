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
public class TcompanyDao extends BaseSpringJdbcDao<Tcompany,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcompany.class;
	}
	
	public String getIdentifierPropertyName() {
		return "cpcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CPCODE as cpcode,"
				+" POLICEUNIT as policeunit,"
				+" SCBACKUPUNIT as scbackupunit,"
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
				+" SCBACKUPNO as scbackupno,"
				+" LICENCE as licence,"
				+" LICENCEUNIT as licenceunit,"
				+" BCRETCODE as bcretcode,"
				+" BCRETUNIT as bcretunit,"
				+" TAXCODE as taxcode,"
				+" TAXUNIT as taxunit,"
				+" STATUS as status,"
				+" MODDATE as moddate,"
				+" BURCODE as burcode,"
				+" STACODE as stacode,"
				+" BASJ as basj,"
				+" BUSINESSCODE as businesscode,"
				+" EXITEND2 as exitend2,"
				+" EXITEND3 as exitend3,"
				+" EXITEND1 as exitend1"
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
	
	public void save(Tcompany entity) {
		String sql = "insert into T_COMPANYINFO " 
			 + " (CPCODE,POLICEUNIT,SCBACKUPUNIT,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,SCBACKUPNO,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,STATUS,MODDATE,BURCODE,STACODE,BASJ,BUSINESSCODE,EXITEND2,EXITEND3,EXITEND1) " 
			 + " values "
			 + " (:cpcode,:policeunit,:scbackupunit,:cpname,:cpaddress,:phone,:fax,:postalcode,:startdate,:economy,:corpcode,:corpname,:policename,:policephone,:workarea,:enrolcapital,:acreage,:scbackupno,:licence,:licenceunit,:bcretcode,:bcretunit,:taxcode,:taxunit,:status,:moddate,:burcode,:stacode,:basj,:businesscode,:exitend2,:exitend3,:exitend1)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_COMPANYINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcompany entity) {
		String sql = "update T_COMPANYINFO set "
					+ " CPCODE=:cpcode,POLICEUNIT=:policeunit,SCBACKUPUNIT=:scbackupunit,CPNAME=:cpname,CPADDRESS=:cpaddress,PHONE=:phone,FAX=:fax,POSTALCODE=:postalcode,STARTDATE=:startdate,ECONOMY=:economy,CORPCODE=:corpcode,CORPNAME=:corpname,POLICENAME=:policename,POLICEPHONE=:policephone,WORKAREA=:workarea,ENROLCAPITAL=:enrolcapital,ACREAGE=:acreage,SCBACKUPNO=:scbackupno,LICENCE=:licence,LICENCEUNIT=:licenceunit,BCRETCODE=:bcretcode,BCRETUNIT=:bcretunit,TAXCODE=:taxcode,TAXUNIT=:taxunit,STATUS=:status,MODDATE=:moddate,BURCODE=:burcode,STACODE=:stacode,BASJ=:basj,BUSINESSCODE=:businesscode,EXITEND2=:exitend2,EXITEND3=:exitend3,EXITEND1=:exitend1 "
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
		String columns = " select  "
						+" CPCODE as cpcode,"
						+" POLICEUNIT as policeunit,"
						+" SCBACKUPUNIT as scbackupunit,"
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
						+" SCBACKUPNO as scbackupno,"
						+" LICENCE as licence,"
						+" LICENCEUNIT as licenceunit,"
						+" BCRETCODE as bcretcode,"
						+" BCRETUNIT as bcretunit,"
						+" TAXCODE as taxcode,"
						+" TAXUNIT as taxunit,"
						+" t.STATUS as status,"
						+" MODDATE as moddate,"
						+" BURCODE as burcode,"
						+" STACODE as stacode,"
						+" BASJ as basj,"
						+" BUSINESSCODE as businesscode,"
						+" EXITEND2 as exitend2,"
						+" EXITEND3 as exitend3,"
						+" EXITEND1 as exitend1,"
						+" b.DEPTNAME as burname ,"
						+" s.DEPTNAME as staname " 
						+" from T_COMPANYINFO t , SS_DEPT b, SS_DEPT s ";
		
		String sql = columns + "  where t.BURCODE = b.DEPTID(+) AND t.STACODE = s.DEPTID(+) "
				+ "/~ and t.POLICEUNIT = '[policeunit]' ~/"
				+ "/~ and t.SCBACKUPUNIT = '[scbackupunit]' ~/"
				+ "/~ and t.CPNAME like '%[cpname]%' ~/"
				+ "/~ and t.CPADDRESS = '[cpaddress]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
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
				+ "/~ and t.SCBACKUPNO = '[scbackupno]' ~/"
				+ "/~ and t.LICENCE = '[licence]' ~/"
				+ "/~ and t.LICENCEUNIT = '[licenceunit]' ~/"
				+ "/~ and t.BCRETCODE = '[bcretcode]' ~/"
				+ "/~ and t.BCRETUNIT = '[bcretunit]' ~/"
				+ "/~ and t.TAXCODE = '[taxcode]' ~/"
				+ "/~ and t.TAXUNIT = '[taxunit]' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.MODDATE = '[moddate]' ~/"
				+ "/~ and t.MODDATE >= '[moddatestart]' ~/"
				+ "/~ and t.MODDATE <= '[moddateend]' ~/"
				+ "/~ and t.BURCODE = '[burcode]' ~/"
				+ "/~ and t.STACODE = '[stacode]' ~/"
				+ "/~ and t.BASJ = '[basj]' ~/"
				+ "/~ and t.BUSINESSCODE = '[businesscode]' ~/"
				+ "/~ and t.EXITEND2 = '[exitend2]' ~/"
				+ "/~ and t.EXITEND3 = '[exitend3]' ~/"
				+ "/~ and t.EXITEND1 = '[exitend1]' ~/"
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
		 + " (CPCODE,POLICEUNIT,SCBACKUPUNIT,CPNAME,CPADDRESS,PHONE,FAX,POSTALCODE,STARTDATE,ECONOMY,CORPCODE,CORPNAME,POLICENAME,POLICEPHONE,WORKAREA,ENROLCAPITAL,ACREAGE,SCBACKUPNO,LICENCE,LICENCEUNIT,BCRETCODE,BCRETUNIT,TAXCODE,TAXUNIT,STATUS,MODDATE,BURCODE,STACODE,BASJ,BUSINESSCODE,EXITEND2,EXITEND3,EXITEND1) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_COMPANYINFO set "
		+ " CPCODE=?,POLICEUNIT=?,SCBACKUPUNIT=?,CPNAME=?,CPADDRESS=?,PHONE=?,FAX=?,POSTALCODE=?,STARTDATE=?,ECONOMY=?,CORPCODE=?,CORPNAME=?,POLICENAME=?,POLICEPHONE=?,WORKAREA=?,ENROLCAPITAL=?,ACREAGE=?,SCBACKUPNO=?,LICENCE=?,LICENCEUNIT=?,BCRETCODE=?,BCRETUNIT=?,TAXCODE=?,TAXUNIT=?,STATUS=?,MODDATE=?,BURCODE=?,STACODE=?,BASJ=?,BUSINESSCODE=?,EXITEND2=?,EXITEND3=?,EXITEND1=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcompany entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getPoliceunit());
						ps.setString(3, entity.getScbackupunit());
						ps.setString(4, entity.getCpname());
						ps.setString(5, entity.getCpaddress());
						ps.setString(6, entity.getPhone());
						ps.setString(7, entity.getFax());
						ps.setString(8, entity.getPostalcode());
						ps.setString(9, entity.getStartdate());
						ps.setString(10, entity.getEconomy());
						ps.setString(11, entity.getCorpcode());
						ps.setString(12, entity.getCorpname());
						ps.setString(13, entity.getPolicename());
						ps.setString(14, entity.getPolicephone());
						ps.setString(15, entity.getWorkarea());
						ps.setLong(16, entity.getEnrolcapital());
						ps.setLong(17, entity.getAcreage());
						ps.setString(18, entity.getScbackupno());
						ps.setString(19, entity.getLicence());
						ps.setString(20, entity.getLicenceunit());
						ps.setString(21, entity.getBcretcode());
						ps.setString(22, entity.getBcretunit());
						ps.setString(23, entity.getTaxcode());
						ps.setString(24, entity.getTaxunit());
						ps.setString(25, entity.getStatus());
						ps.setString(26, entity.getModdate());
						ps.setString(27, entity.getBurcode());
						ps.setString(28, entity.getStacode());
						ps.setString(29, entity.getBasj());
						ps.setString(30, entity.getBusinesscode());
						ps.setString(31, entity.getExitend2());
						ps.setString(32, entity.getExitend3());
						ps.setString(33, entity.getExitend1());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcompany(final Tcompany entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getPoliceunit());
				ps.setString(3, entity.getScbackupunit());
				ps.setString(4, entity.getCpname());
				ps.setString(5, entity.getCpaddress());
				ps.setString(6, entity.getPhone());
				ps.setString(7, entity.getFax());
				ps.setString(8, entity.getPostalcode());
				ps.setString(9, entity.getStartdate());
				ps.setString(10, entity.getEconomy());
				ps.setString(11, entity.getCorpcode());
				ps.setString(12, entity.getCorpname());
				ps.setString(13, entity.getPolicename());
				ps.setString(14, entity.getPolicephone());
				ps.setString(15, entity.getWorkarea());
				ps.setLong(16, entity.getEnrolcapital());
				ps.setLong(17, entity.getAcreage());
				ps.setString(18, entity.getScbackupno());
				ps.setString(19, entity.getLicence());
				ps.setString(20, entity.getLicenceunit());
				ps.setString(21, entity.getBcretcode());
				ps.setString(22, entity.getBcretunit());
				ps.setString(23, entity.getTaxcode());
				ps.setString(24, entity.getTaxunit());
				ps.setString(25, entity.getStatus());
				ps.setString(26, entity.getModdate());
				ps.setString(27, entity.getBurcode());
				ps.setString(28, entity.getStacode());
				ps.setString(29, entity.getBasj());
				ps.setString(30, entity.getBusinesscode());
				ps.setString(31, entity.getExitend2());
				ps.setString(32, entity.getExitend3());
				ps.setString(33, entity.getExitend1());
			}
		});
	}

	
	public void updateTcompany(final Tcompany entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getPoliceunit());
				ps.setString(3, entity.getScbackupunit());
				ps.setString(4, entity.getCpname());
				ps.setString(5, entity.getCpaddress());
				ps.setString(6, entity.getPhone());
				ps.setString(7, entity.getFax());
				ps.setString(8, entity.getPostalcode());
				ps.setString(9, entity.getStartdate());
				ps.setString(10, entity.getEconomy());
				ps.setString(11, entity.getCorpcode());
				ps.setString(12, entity.getCorpname());
				ps.setString(13, entity.getPolicename());
				ps.setString(14, entity.getPolicephone());
				ps.setString(15, entity.getWorkarea());
				ps.setLong(16, entity.getEnrolcapital());
				ps.setLong(17, entity.getAcreage());
				ps.setString(18, entity.getScbackupno());
				ps.setString(19, entity.getLicence());
				ps.setString(20, entity.getLicenceunit());
				ps.setString(21, entity.getBcretcode());
				ps.setString(22, entity.getBcretunit());
				ps.setString(23, entity.getTaxcode());
				ps.setString(24, entity.getTaxunit());
				ps.setString(25, entity.getStatus());
				ps.setString(26, entity.getModdate());
				ps.setString(27, entity.getBurcode());
				ps.setString(28, entity.getStacode());
				ps.setString(29, entity.getBasj());
				ps.setString(30, entity.getBusinesscode());
				ps.setString(31, entity.getExitend2());
				ps.setString(32, entity.getExitend3());
				ps.setString(33, entity.getExitend1());
			}
		});
	}

	
	public void deleteTcompany(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public List getCompCountByDeptCode(String statisType , String deptCode, String status ) {
            String subSQLWhere = "";
    		if("1".equals(statisType)){ //按照派出所
    			subSQLWhere =  subSQLWhere + " AND c.STACODE ='"+ deptCode +"' ";
    		}else{
    			subSQLWhere =  subSQLWhere + " AND c.BURCODE ='"+ deptCode +"' ";
    		}
    		
    		if(status!=null && !"".equals(status)){
    			subSQLWhere = subSQLWhere + " AND c.STATUS ='"+ status +"' ";    			
    		}
    		String subSQL = " SELECT COUNT(*) FROM T_COMPANYINFO c "
    			          + " WHERE c.BUSINESSCODE = d.code " + subSQLWhere ;

    		
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
