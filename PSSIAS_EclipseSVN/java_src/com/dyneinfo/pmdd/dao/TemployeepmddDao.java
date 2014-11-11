/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.pmdd.model.Cyry;
import com.dyneinfo.pmdd.model.Temployee;
import com.dyneinfo.pmdd.model.Tempworklog;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeepmddDao extends BaseSpringJdbcDao<Temployee,java.lang.String>{
	
	public Class getEntityClass() {
		return Temployee.class;
	}
	
	public String getIdentifierPropertyName() {
		return "empcode";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" EMPCODE as empcode,"
				+" EMPNAME as empname,"
				+" SEX as sex,"
				+" PERSONID as personid,"
				+" BIRTH as birth,"
				+" ALIAS as alias,"
				+" FOLK as folk,"
				+" NATIVEPLACE as nativeplace,"
				+" POLITYVISAGE as polityvisage,"
				+" SCHOOLAGE as schoolage,"
				+" HYZK as hyzk,"
				+" STATURE as stature,"
				+" WEIGHT as weight,"
				+" POSTURE as posture,"
				+" NPCODE as npcode,"
				+" ADDRESS as address,"
				+" NPADDRESS as npaddress,"
				+" PHONE as phone,"
				+" CYRJZT as cyrjzt,"
				+" TEMPORARYCODE as temporarycode,"
				+" NOWADRESS as nowadress,"
				+" INSERTTIME as inserttime,"
				+" RZRQ as rzrq,"
				+" EDITTIME as edittime,"
				+" CPCODE as cpcode,"
				+" b.deptname as deptname "
				+" from T_EMPLOYEE ";
	}
	
	public String getSelectSql() {
		return "select  "
				+" EMPCODE as empcode,"
				+" EMPNAME as empname,"
				+" SEX as sex,"
				+" PERSONID as personid,"
				+" BIRTH as birth,"
				+" ALIAS as alias,"
				+" FOLK as folk,"
				+" NATIVEPLACE as nativeplace,"
				+" POLITYVISAGE as polityvisage,"
				+" SCHOOLAGE as schoolage,"
				+" HYZK as hyzk,"
				+" STATURE as stature,"
				+" WEIGHT as weight,"
				+" POSTURE as posture,"
				+" NPCODE as npcode,"
				+" ADDRESS as address,"
				+" NPADDRESS as npaddress,"
				+" PHONE as phone,"
				+" CYRJZT as cyrjzt,"
				+" TEMPORARYCODE as temporarycode,"
				+" NOWADRESS as nowadress,"
				+" INSERTTIME as inserttime,"
				+" RZRQ as rzrq,"
				+" EDITTIME as edittime,"
				+" CPCODE as cpcode"
				+" from T_EMPLOYEE ";
	}
	
	public Temployee getTemployeeById(String empcode) {
		String sql =	"select  "
			+" EMPCODE as empcode,"
			+" EMPNAME as empname,"
			+" SEX as sex,"
			+" PERSONID as personid,"
			+" BIRTH as birth,"
			+" ALIAS as alias,"
			+" FOLK as folk,"
			+" NATIVEPLACE as nativeplace,"
			+" POLITYVISAGE as polityvisage,"
			+" SCHOOLAGE as schoolage,"
			+" HYZK as hyzk,"
			+" RZRQ as rzrq,"
			+" STATURE as stature,"
			+" WEIGHT as weight,"
			+" POSTURE as posture,"
			+" NPCODE as npcode,"
			+" ADDRESS as address,"
			+" NPADDRESS as npaddress,"
			+" PHONE as phone,"
			+" CYRJZT as cyrjzt,"
			+" TEMPORARYCODE as temporarycode,"
			+" NOWADRESS as nowadress,"
			+" INSERTTIME as inserttime,"
			+" EDITTIME as edittime,"
			+" CPCODE as cpcode,"
			+" b.deptname as deptname "
			+" from T_EMPLOYEE a ,ss_dept b " 
			+" where a.cpcode = b.deptid(+)  and a.empcode = ?";
		Temployee employee = null;
		try {   
			employee = (Temployee)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {empcode});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return employee;
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_EMPLOYEE where EMPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where EMPCODE=? ";
	}
	
	public Tempworklog getTempworklogById(String empcode) {
		String sql= getSelectPrefix() + " where EMPCODE=? ";
		Tempworklog tempworklog = null;
		try {   
			tempworklog = (Tempworklog)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {empcode});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return tempworklog;
	}
	
	public void save(Temployee entity) {
		String sql = "insert into T_EMPLOYEE " 
			 + " (EMPCODE,EMPNAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,SCHOOLAGE,HYZK,CYRJZT,ADDRESS,NOWADRESS,PHONE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,CPCODE,RZRQ) " 
			 + " values "
			 + " (:empcode,:empname,:alias,:sex,:birth,:stature,:weight,:posture,:polityvisage,:folk,:nativeplace,:schoolage,:hyzk,:cyrjzt,:address,:nowadress,:phone,:personid,:npcode,:npaddress,:temporarycode,:inserttime,:edittime,:cpcode,:rzrq)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_EMPLOYEE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Temployee entity) {
		String sql = "update T_EMPLOYEE set "
			+ " EMPCODE=:empcode,EMPNAME=:empname,ALIAS=:alias,SEX=:sex,BIRTH=:birth,STATURE=:stature,WEIGHT=:weight,POSTURE=:posture,POLITYVISAGE=:polityvisage,FOLK=:folk,NATIVEPLACE=:nativeplace,SCHOOLAGE=:schoolage,HYZK=:hyzk,CYRJZT=:cyrjzt,ADDRESS=:address,NOWADRESS=:nowadress,PHONE=:phone,PERSONID=:personid,NPCODE=:npcode,NPADDRESS=:npaddress,TEMPORARYCODE=:temporarycode,INSERTTIME=:inserttime,EDITTIME=:edittime,CPCODE=:cpcode,RZRQ=:rzrq "
			+ " where EMPCODE=:empcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t,ss_dept b where t.cpcode = b.deptid(+) "
				+ "/~ and t.EMPNAME like '%'||{empname}||'%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.PERSONID like '%'||{personid}||'%'  ~/"
				+ "/~ and t.BIRTH >= '[birthBeginFormat]' ~/"
				+ "/~ and t.BIRTH <= '[birthEndFormat]' ~/"
				+ "/~ and t.RZRQ >= '[rzrqBeginFormat]' ~/"
				+ "/~ and t.RZRQ <= '[rzrqEndFormat]' ~/"
				+ "/~ and t.ALIAS = '[alias]' ~/"
				+ "/~ and t.FOLK = '[folk]' ~/"
				+ "/~ and t.NATIVEPLACE = '[nativeplace]' ~/"
				+ "/~ and t.POLITYVISAGE = '[polityvisage]' ~/"
				+ "/~ and t.SCHOOLAGE = '[schoolage]' ~/"
				+ "/~ and t.HYZK = '[hyzk]' ~/"
				+ "/~ and t.STATURE = '[stature]' ~/"
				+ "/~ and t.WEIGHT = '[weight]' ~/"
				+ "/~ and t.POSTURE = '[posture]' ~/"
				+ "/~ and t.NPCODE = '[npcode]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.NPADDRESS = '[npaddress]' ~/"
				+ "/~ and t.PHONE = '[phone]' ~/"
				+ "/~ and t.CYRJZT = '[cyrjzt]' ~/"
				+ "/~ and t.TEMPORARYCODE = '[temporarycode]' ~/"
				+ "/~ and t.NOWADRESS = '[nowadress]' ~/"
				+ "/~ and t.INSERTTIME = '[inserttime]' ~/"
				+ "/~ and t.EDITTIME = '[edittime]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and b.deptname = '[deptname]' ~/"
				+ "/~ and b.DEPTSEQ like '[deptSeq]%' ~/"
				+ "/~ and b.DEPTSEQ like '[deptseq]%' ~/"
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
	
	
	//同一身份证数量，大于0应该禁止录入并且弹出提示
	public int getCountByIdcard(String new_IDCard,String old_IDCard) {
		String sql = "select count(*)   from T_EMPLOYEE  where   (PERSONID = ? or PERSONID =?) ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {new_IDCard,old_IDCard} );   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public List<Temployee> findCyryByIdcard(String new_IDCard,String old_IDCard) {
		String sql=getSelectSql()
			+" where (PERSONID = ? or PERSONID =?) ";
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {new_IDCard,old_IDCard});
	}
	
	public List<Temployee> findCyryByDeptId(String deptid) {
		String sql=getSelectSql()
			+" where trim(CPCODE)=? and CYRJZT !='1' and CYRJZT !='2'";
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), deptid);
	}
	
	

}
