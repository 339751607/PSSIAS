/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.model.Temployee;
import com.dyneinfo.jxy.model.Tempworklog;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeejxyDao extends
		BaseSpringJdbcDao<Temployee, java.lang.String> {

	public Class getEntityClass() {
		return Temployee.class;
	}

	public String getIdentifierPropertyName() {
		return "cpempcode";
	}

	public String getSelectPrefix() {
		return "select  " + " CPEMPCODE as cpempcode," + " NAME as name,"
				+ " SEX as sex," + " PERSONID as personid,"
				+ " BIRTH as birth," + " ALIAS as alias," + " FOLK as folk,"
				+ " NATIVEPLACE as nativeplace,"
				+ " POLITYVISAGE as polityvisage," + " SCHOOLAGE as schoolage,"
				+ " HYZK as hyzk," + " STATURE as stature,"
				+ " WEIGHT as weight," + " POSTURE as posture,"
				+ " NPCODE as npcode," + " ADDRESS as address,"
				+ " NPADDRESS as npaddress," + " PHONE as phone,"
				+ " CYRJZT as cyrjzt," + " TEMPORARYCODE as temporarycode,"
				+ " NOWADRESS as nowadress," + " INSERTTIME as inserttime,"
				+ " INDATE as indate," + " EDITTIME as edittime,"
				+ " CPCODE as cpcode," + " b.deptname as deptname "
				+ " from T_EMPLOYEE ";
	}

	public String getSelectSql() {
		return "select  " + " CPEMPCODE as cpempcode," + " NAME as name,"
				+ " SEX as sex," + " PERSONID as personid,"
				+ " BIRTH as birth," + " ALIAS as alias," + " FOLK as folk,"
				+ " NATIVEPLACE as nativeplace,"
				+ " POLITYVISAGE as polityvisage," + " SCHOOLAGE as schoolage,"
				+ " HYZK as hyzk," + " STATURE as stature,"
				+ " WEIGHT as weight," + " POSTURE as posture,"
				+ " NPCODE as npcode," + " ADDRESS as address,"
				+ " NPADDRESS as npaddress," + " PHONE as phone,"
				+ " CYRJZT as cyrjzt," + " TEMPORARYCODE as temporarycode,"
				+ " NOWADRESS as nowadress," + " INSERTTIME as inserttime,"
				+ " INDATE as indate," + " EDITTIME as edittime,"
				+ " CPCODE as cpcode" + " from T_EMPLOYEE ";
	}

	public Temployee getTemployeeById(String cpempcode,String cpcode) {
		String sql = "select  " + " CPEMPCODE as cpempcode," + " NAME as name,"
				+ " SEX as sex," + " PERSONID as personid,"
				+ " BIRTH as birth," + " ALIAS as alias," + " FOLK as folk,"
				+ " NATIVEPLACE as nativeplace,"
				+ " POLITYVISAGE as polityvisage," + " SCHOOLAGE as schoolage,"
				+ " HYZK as hyzk," + " INDATE as indate,"
				+ " STATURE as stature," + " WEIGHT as weight,"
				+ " POSTURE as posture," + " NPCODE as npcode,"
				+ " ADDRESS as address," + " NPADDRESS as npaddress,"
				+ " PHONE as phone," + " CYRJZT as cyrjzt,"
				+ " TEMPORARYCODE as temporarycode,"
				+ " NOWADRESS as nowadress," + " INSERTTIME as inserttime,"
				+ " EDITTIME as edittime," + " CPCODE as cpcode,"
				+ " b.deptname as deptname " + " from T_EMPLOYEE a ,ss_dept b "
				+ " where a.cpcode = b.deptid  and a.cpempcode = ? and a.cpcode=?";
		Temployee employee = null;
		try {
			employee = (Temployee) getSimpleJdbcTemplate().queryForObject(
					sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(getEntityClass()),
					new Object[] { cpempcode,cpcode });
		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return employee;
	}

	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_EMPLOYEE where CPEMPCODE=?";
	}

	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where CPEMPCODE=? ";
	}

	public Tempworklog getTempworklogById(String cpempcode) {
		String sql = getSelectPrefix() + " where CPEMPCODE=? ";
		Tempworklog tempworklog = null;
		try {
			tempworklog = (Tempworklog) getSimpleJdbcTemplate().queryForObject(
					sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(getEntityClass()),
					new Object[] { cpempcode });
		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return tempworklog;
	}

	public void save(Temployee entity) {
		String sql = "insert into T_EMPLOYEE "
				+ " (CPEMPCODE,NAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,SCHOOLAGE,HYZK,CYRJZT,ADDRESS,NOWADRESS,PHONE,PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,CPCODE,INDATE) "
				+ " values "
				+ " (:cpempcode,:name,:alias,:sex,:birth,:stature,:weight,:posture,:polityvisage,:folk,:nativeplace,:schoolage,:hyzk,:cyrjzt,:address,:nowadress,:phone,:personid,:npcode,:npaddress,:temporarycode,:inserttime,:edittime,:cpcode,:indate)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_EMPLOYEE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity, sql); //手工分配
	}

	public void update(Temployee entity) {
		String sql = "update T_EMPLOYEE set "
				+ " CPEMPCODE=:cpempcode,NAME=:name,ALIAS=:alias,SEX=:sex,BIRTH=:birth,STATURE=:stature,WEIGHT=:weight,POSTURE=:posture,POLITYVISAGE=:polityvisage,FOLK=:folk,NATIVEPLACE=:nativeplace,SCHOOLAGE=:schoolage,HYZK=:hyzk,CYRJZT=:cyrjzt,ADDRESS=:address,NOWADRESS=:nowadress,PHONE=:phone,PERSONID=:personid,NPCODE=:npcode,NPADDRESS=:npaddress,TEMPORARYCODE=:temporarycode,INSERTTIME=:inserttime,EDITTIME=:edittime,CPCODE=:cpcode,INDATE=:indate,LEFTDATE=:leftdate "
				+ " where CPEMPCODE=:cpempcode and CPCODE=:cpcode";
		getNamedParameterJdbcTemplate().update(sql,
				new BeanPropertySqlParameterSource(entity));
	}

	public List findAll() {
		String sql = getSelectPrefix();
		return getSimpleJdbcTemplate().query(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix()
				+ " t,ss_dept b where t.cpcode = b.deptid "
				+ "/~ and t.NAME like '%'||{name}||'%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.PERSONID like '%'||{personid}||'%'  ~/"
				+ "/~ and t.BIRTH >= '[birthBeginFormat]' ~/"
				+ "/~ and t.BIRTH <= '[birthEndFormat]' ~/"
				+ "/~ and t.INDATE >= '[indateBeginFormat]' ~/"
				+ "/~ and t.INDATE <= '[indateEndFormat]' ~/"
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
				//+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and b.DEPTSEQ like '%'||{cpcode}||'%' ~/"
				+ "/~ and b.DEPTSEQ like '%'||{deptSeq}||'%' ~/"
				+ "/~ and b.DEPTSEQ like '%'||{deptseq}||'%' ~/"
				+ "/~ and b.DEPTNAME like '%'||{deptname}||'%'  ~/"
				+"  order by edittime desc "
				+ "/~ , [sortColumns] ~/";
		return pageQuery(sql, pageRequest);
	}

	public String getCurrentMax(String sql, String arg)
			throws DataAccessException {
		String currentMaxID = "";
		//String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj = { arg };
		try {
			currentMaxID = (String) this.getJdbcTemplate().queryForObject(sql,
					obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}

	//同一身份证数量，大于0应该禁止录入并且弹出提示
	public int getCountByIdcard(String new_IDCard, String old_IDCard) {
		String sql = "select count(*)   from T_EMPLOYEE  where   (PERSONID = ? or PERSONID =?) ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { new_IDCard, old_IDCard });

		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	public List<Temployee> findCyryByIdcard(String new_IDCard, String old_IDCard) {
		String sql = getSelectSql() + " where (PERSONID = ? or PERSONID =?) ";
		return getSimpleJdbcTemplate().query(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()),
				new Object[] { new_IDCard, old_IDCard });
	}

	public List<Temployee> findCyryByDeptId(String deptid) {
		String sql = getSelectSql() + " where trim(CPCODE)=? and CYRJZT !='1' ";
		return getSimpleJdbcTemplate().query(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()), deptid);
	}

	private String createSql = "insert into T_EMPLOYEE "
			+ " (CPEMPCODE,NAME,ALIAS,SEX,BIRTH,STATURE,WEIGHT,POSTURE,POLITYVISAGE,FOLK,NATIVEPLACE,SCHOOLAGE,HYZK,CYRJZT,ADDRESS,NOWADRESS,PHONE,"
			+ "PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,CPCODE,INDATE,PHOTO) "
			+ " values "
			+ " (:cpempcode,:name,:alias,:sex,:birth,:stature,:weight,:posture,:polityvisage,:folk,:nativeplace,:schoolage,:hyzk,:cyrjzt,:address,:nowadress,:phone,:personid,:npcode,:npaddress,:temporarycode,:cpcode,:indate,:photo)";

	LobHandler lobhandler = new DefaultLobHandler();

	public void savePic(File file, final Temployee entity) throws IOException {

		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpempcode());
						ps.setString(2, entity.getName());
						ps.setString(3, entity.getAlias());
						ps.setString(4, entity.getSex());
						ps.setString(5, entity.getBirth());
						ps.setString(6, entity.getStature());
						ps.setString(7, entity.getWeight());
						ps.setString(8, entity.getPosture());
						ps.setString(9, entity.getPolityvisage());
						ps.setString(10, entity.getFolk());
						ps.setString(11, entity.getNativeplace());
						ps.setString(12, entity.getSchoolage());
						ps.setString(13, entity.getHyzk());
						ps.setString(14, entity.getCyrjzt());
						ps.setString(15, entity.getAddress());
						ps.setString(16, entity.getNowadress());
						ps.setString(17, entity.getPhone());
						ps.setString(18, entity.getPersonid());
						ps.setString(19, entity.getNpcode());
						ps.setString(20, entity.getNpaddress());
						//"PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,CPCODE,INDATE) " 
						ps.setString(21, entity.getTemporarycode());
						ps.setString(22, entity.getCpcode());
						ps.setString(23, entity.getIndate());
						//						ps.setjava.sql.Blob(13, entity.getCarpicture());
						lobCreator.setBlobAsBinaryStream(ps, 24, blobIs,
								(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	public void savePic1(final byte[] file, final Temployee entity) throws IOException {

		
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpempcode());
						ps.setString(2, entity.getName());
						ps.setString(3, entity.getAlias());
						ps.setString(4, entity.getSex());
						ps.setString(5, entity.getBirth());
						ps.setString(6, entity.getStature());
						ps.setString(7, entity.getWeight());
						ps.setString(8, entity.getPosture());
						ps.setString(9, entity.getPolityvisage());
						ps.setString(10, entity.getFolk());
						ps.setString(11, entity.getNativeplace());
						ps.setString(12, entity.getSchoolage());
						ps.setString(13, entity.getHyzk());
						ps.setString(14, entity.getCyrjzt());
						ps.setString(15, entity.getAddress());
						ps.setString(16, entity.getNowadress());
						ps.setString(17, entity.getPhone());
						ps.setString(18, entity.getPersonid());
						ps.setString(19, entity.getNpcode());
						ps.setString(20, entity.getNpaddress());
						//"PERSONID,NPCODE,NPADDRESS,TEMPORARYCODE,INSERTTIME,EDITTIME,CPCODE,INDATE) " 
						ps.setString(21, entity.getTemporarycode());
						ps.setString(22, entity.getCpcode());
						ps.setString(23, entity.getIndate());
						//						ps.setjava.sql.Blob(13, entity.getCarpicture());
						
						ps.setBytes(24, file);
					}
				});
		
	}

	//修改图片
	public void updatePic(File file, String cpempcode) throws IOException {

		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_cpempcode = cpempcode;
		getJdbcTemplate().execute(
				" update T_EMPLOYEE set PHOTO = ? where cpempcode =? ",
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						lobCreator.setBlobAsBinaryStream(ps, 1, blobIs,
								(int) blobIn.length());
						ps.setString(2, str_cpempcode);
					}
				});
		blobIs.close();
	}

	// 取得照片
	public List getPic(String cpempcode,String cpcode) {
		String sql = "select CPEMPCODE,PHOTO from T_EMPLOYEE where cpempcode = ? and cpcode=? ";
		return getJdbcTemplate().query(sql, new String[] { cpempcode ,cpcode},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						//  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
						//  results.put("PICTURE", clobText);
						String ID = rs.getString(1);

						byte[] blobBytes = lobhandler.getBlobAsBytes(rs,
								"PHOTO");
						System.out.println("blobBytes=" + blobBytes);
						results.put("PICTURE", blobBytes);
						results.put("ID", ID);
						return results;
					}

				});
	}

}
