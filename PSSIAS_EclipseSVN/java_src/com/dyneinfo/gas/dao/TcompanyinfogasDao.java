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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;
import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcompanyinfogasDao extends BaseSpringJdbcDao<Tcompanyinfo,java.lang.String>{
	
	public Class getEntityClass() {
		return Tcompanyinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "cpcode";
	}
	
	public String getMaxDwbm(String fjbm) throws IOException{
		
		 String currentPhase = "";
		 
			if(fjbm == null || "".equals(fjbm)){
				return currentPhase;
			}		   
			
			String sql = "select  max(CPCODE) as CPCODE  from T_COMPANYINFO  where  substr(CPCODE,0," + fjbm.length() + ") = ? ";
			Object[] obj = { fjbm };
			try {
				currentPhase = (String) this.getJdbcTemplate().queryForObject(sql, obj, String.class);
			} catch (Exception e) {
				currentPhase = "";
				e.printStackTrace();
			}
			return currentPhase;
	}
	
	public String getUserSeq(){
		String sql=" select SEQ_SS_USER.Nextval from dual ";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql,String.class);
		return fjmc;
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CPCODE as cpcode,"
				+" CPNAME as cpname,"
				+" LEGA_LNAME as legaLname,"
				+" LEGAL_CARD as legalCard,"
				+" PHONE as phone,"
				+" ADDRESS as address,"
				+" STATUS as status,"
				+" MOD_TIME as modTime,"
				+" GASOLINE_TYPE as gasolineType,"
				+" CPTYPE as cptype,"
				+" MACHINE as machine,"
				+" MONITOR as monitor,"
				+" BURCODE as burcode,"
				+" STACODE as stacode,"
				+" SERVICEDATE as servicedate,"
				+" SERVICEDATEVIEW as servicedateview,"
				+" EXITEND1 as exitend1,"
				+" EXITEND2 as exitend2,"
				+" EXITEND3 as exitend3"
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
			 + " (CPCODE,CPNAME,LEGA_LNAME,LEGAL_CARD,PHONE,ADDRESS,STATUS,MOD_TIME,GASOLINE_TYPE,CPTYPE,MACHINE,MONITOR,BURCODE,STACODE,SERVICEDATE,SERVICEDATEVIEW,EXITEND1,EXITEND2,EXITEND3) " 
			 + " values "
			 + " (:cpcode,:cpname,:legaLname,:legalCard,:phone,:address,:status,:modTime,:gasolineType,:cptype,:machine,:monitor,:burcode,:stacode,:servicedate,:servicedateview,:exitend1,:exitend2,:exitend3)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_COMPANYINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		 insertWithAssigned(entity,sql); //手工分配
	}
	
	public void saveDept(SsDept entity) {
		String sql = "insert into SS_DEPT " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " (:deptid,:deptname,:deptdesc,:deptcode,:deptseq,:displayorder,:parentid,:deptlevel,:depttypeid,:status)";
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void saveUser(SsUser entity) {
		String sql = "insert into SS_USER " 
			 + " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO,CREATEUSERID,DESCRIPTION,EXPIRATIONDATE) " 
			 + " values "
			 + " (:userid,:username,:password,:fullname,:sex,:sfzh,:policeid,:phone,:mobile,:fax,:address,:zip,:emailaddress,:createdate,:deptid,:enabled,:photo,:createuserid,:description,:expirationdate)";
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void insertRoleUser(long roleid, long userid) {
		String sql = "INSERT INTO SS_ROLE_USER (ROLEID,USERID) VALUES(:roleid, :userid)";
		Map namedParameters = new HashMap();
		namedParameters.put("roleid", roleid);
		namedParameters.put("userid", userid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void update(Tcompanyinfo entity) {
		String sql = "update T_COMPANYINFO set "
					+ " CPCODE=:cpcode,CPNAME=:cpname,LEGA_LNAME=:legaLname,LEGAL_CARD=:legalCard,PHONE=:phone,ADDRESS=:address,STATUS=:status,MOD_TIME=:modTime,GASOLINE_TYPE=:gasolineType,CPTYPE=:cptype,MACHINE=:machine,MONITOR=:monitor,BURCODE=:burcode,STACODE=:stacode,SERVICEDATE=:servicedate,SERVICEDATEVIEW=:servicedateview,EXITEND1=:exitend1,EXITEND2=:exitend2,EXITEND3=:exitend3 "
					+ " where CPCODE=:cpcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void updateDept(SsDept entity) {
		String sql = "update SS_DEPT set "
			+ " DEPTNAME=:deptname,DEPTDESC=:deptdesc,DEPTCODE=:deptcode,DEPTSEQ=:deptseq,DISPLAYORDER=:displayorder,PARENTID=:parentid,DEPTLEVEL=:deptlevel,DEPTTYPEID=:depttypeid,STATUS=:status "
			+ " where DEPTID=:deptid";
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
				+ "/~ and t.CPNAME = '[cpname]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.LEGA_LNAME = '[legaLname]' ~/"
				+ "/~ and t.LEGAL_CARD = '[legalCard]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.MOD_TIME >= '[modtimeBeginFormat]' ~/"
				+ "/~ and t.MOD_TIME <= '[modtimeEndFormat]' ~/"
				
				+ "/~ and t.GASOLINE_TYPE = '[gasolineType]' ~/"
				+ "/~ and t.CPTYPE = '[cptype]' ~/"
				+ "/~ and t.MACHINE = '[machine]' ~/"
				+ "/~ and t.MONITOR = '[monitor]' ~/"
				+ "/~ and t.BURCODE = '[burcode]' ~/"
				+ "/~ and t.STACODE = '[stacode]' ~/"
				+ "/~ and t.EXITEND1 = '[exitend1]' ~/"
				+ "/~ and t.EXITEND2 = '[exitend2]' ~/"
				+ "/~ and t.EXITEND3 = '[exitend3]' ~/"
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
		 + " (CPCODE,CPNAME,LEGA_LNAME,LEGAL_CARD,PHONE,ADDRESS,STATUS,MOD_TIME,GASOLINE_TYPE,CPTYPE,MACHINE,MONITOR,BURCODE,STACODE,SERVICEDATE,SERVICEDATEVIEW,EXITEND1,EXITEND2,EXITEND3) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_COMPANYINFO set "
		+ " CPCODE=?,CPNAME=?,LEGA_LNAME=?,LEGAL_CARD=?,PHONE=?,ADDRESS=?,STATUS=?,MOD_TIME=?,GASOLINE_TYPE=?,CPTYPE=?,MACHINE=?,MONITOR=?,BURCODE=?,STACODE=?,SERVICEDATE =?,SERVICEDATEVIEW=?,EXITEND1=?,EXITEND2=?,EXITEND3=? "
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
						ps.setString(3, entity.getLegaLname());
						ps.setString(4, entity.getLegalCard());
						ps.setString(5, entity.getPhone());
						ps.setString(6, entity.getAddress());
						ps.setString(7, entity.getStatus());
						ps.setString(8, entity.getModTime());
						ps.setString(9, entity.getGasolineType());
						ps.setString(10, entity.getCptype());
						ps.setLong(11, entity.getMachine());
						ps.setLong(12, entity.getMonitor());
						ps.setString(13, entity.getBurcode());
						ps.setString(14, entity.getStacode());
						ps.setString(15, entity.getServicedate());
						ps.setDate(16, entity.getServicedateview());
						ps.setString(17, entity.getExitend1());
						ps.setString(18, entity.getExitend2());
						ps.setString(19, entity.getExitend3());
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
				ps.setString(3, entity.getLegaLname());
				ps.setString(4, entity.getLegalCard());
				ps.setString(5, entity.getPhone());
				ps.setString(6, entity.getAddress());
				ps.setString(7, entity.getStatus());
				ps.setString(8, entity.getModTime());
				ps.setString(9, entity.getGasolineType());
				ps.setString(10, entity.getCptype());
				ps.setLong(11, entity.getMachine());
				ps.setLong(12, entity.getMonitor());
				ps.setString(13, entity.getBurcode());
				ps.setString(14, entity.getStacode());
				ps.setString(15, entity.getServicedate());
				ps.setDate(16, entity.getServicedateview());
				ps.setString(17, entity.getExitend1());
				ps.setString(18, entity.getExitend2());
				ps.setString(19, entity.getExitend3());
			}
		});
	}

	
	public void updateTcompanyinfo(final Tcompanyinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCpname());
				ps.setString(3, entity.getLegaLname());
				ps.setString(4, entity.getLegalCard());
				ps.setString(5, entity.getPhone());
				ps.setString(6, entity.getAddress());
				ps.setString(7, entity.getStatus());
				ps.setString(8, entity.getModTime());
				ps.setString(9, entity.getGasolineType());
				ps.setString(10, entity.getCptype());
				ps.setLong(11, entity.getMachine());
				ps.setLong(12, entity.getMonitor());
				ps.setString(13, entity.getBurcode());
				ps.setString(14, entity.getStacode());
				ps.setString(15, entity.getServicedate());
				ps.setDate(16, entity.getServicedateview());
				ps.setString(17, entity.getExitend1());
				ps.setString(18, entity.getExitend2());
				ps.setString(19, entity.getExitend3());
			}
		});
	}

	
	public void deleteTcompanyinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
