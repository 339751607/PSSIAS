/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.fjy.model.Temployee;
import com.dyneinfo.fjy.model.Tempworklog;
import com.dyneinfo.zazh.model.SsRole;
import com.dyneinfo.zazh.model.SsUser;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TemployeeDao extends
		BaseSpringJdbcDao<Temployee, java.lang.String> {

	public Class getEntityClass() {
		return Temployee.class;
	}

	public String getIdentifierPropertyName() {
		return "empcode";
	}

	/**
	 * 获取人员编码
	 * @param deptID
	 * @param userid
	 * @return
	 */
	public String getemploee(String deptID ,int userid){
		String sql = "select  EMPCODE from T_EMPLOYEE where CPCODE ='"+deptID+"' and USERID="+userid+"";
		return (String) getJdbcTemplate().queryForObject(sql, new Object[]{}, String.class);
	}
	
	public String getSelectPrefix() {
		return "select  " + " t.EMPCODE as empcode," + " t.EMPNAME as empname,"
				+ " t.SEX as sex," + " t.PERSONID as personid,"
				+ " t.BIRTH as birth," + " t.ALIAS as alias,"
				+ " t.FOLK as folk," + " t.NATIVEPLACE as nativeplace,"
				+ " t.POLITYVISAGE as polityvisage,"
				+ " t.SCHOOLAGE as schoolage," + " t.HYZH as hyzh,"
				+ " t.STATURE as stature," + " t.WEIGHT as weight,"
				+ " t.POSTURE as posture," + " t.NPCODE as npcode,"
				+ " t.ADDRESS as address," + " t.NPADDRESS as npaddress,"
				+ " t.PHONE as phone," + " t.CYRJZT as cyrjzt,"
				+ " t.TEMPORARYCODE as temporarycode,"
				+ " t.NOWADRESS as nowadress," + " t.INSERTTIME as inserttime,"
				+ " t.EDITTIME as edittime," + " t.CPCODE as cpcode,"
				+ " t.POSITION as position," + " b.deptname as deptname,"
				+ " c.username as username," + " c.fullname as fullname,"
				+ " c.PASSWORD as password," + " c.ENABLED as enabled, "
				+ " t.USERID as userid " + " from T_EMPLOYEE t ";
	}

	public Temployee getTemployeeById(String empcode) {
		String sql = "select  "
				+ " EMPCODE as empcode,"
				+ " EMPNAME as empname,"
				+ " a.SEX as sex,"
				+ " PERSONID as personid,"
				+ " BIRTH as birth,"
				+ " ALIAS as alias,"
				+ " FOLK as folk,"
				+ " NATIVEPLACE as nativeplace,"
				+ " POLITYVISAGE as polityvisage,"
				+ " SCHOOLAGE as schoolage,"
				+ " HYZH as hyzh,"
				+ " STATURE as stature,"
				+ " WEIGHT as weight,"
				+ " POSTURE as posture,"
				+ " NPCODE as npcode,"
				+ " a.ADDRESS as address,"
				+ " NPADDRESS as npaddress,"
				+ " a.PHONE as phone,"
				+ " CYRJZT as cyrjzt,"
				+ " TEMPORARYCODE as temporarycode,"
				+ " NOWADRESS as nowadress,"
				+ " INSERTTIME as inserttime,"
				+ " EDITTIME as edittime,"
				+ " CPCODE as cpcode,"
				+ " POSITION as position,"
				+ " b.deptname as deptname,"
				+ " c.USERNAME as username,"
				+ " c.PASSWORD as password,"
				+ " c.ENABLED as enabled, "
				+ " a.USERID as userid "
				+ " from T_EMPLOYEE a ,ss_dept b,ss_user c "
				+ " where a.cpcode = b.deptid(+)  and   a.userid = c.userid(+) and a.empcode = ?";
		Temployee employee = null;
		try {
			employee = (Temployee) getSimpleJdbcTemplate().queryForObject(
					sql,
					ParameterizedBeanPropertyRowMapper
							.newInstance(getEntityClass()),
					new Object[] { empcode });
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
		return "delete from T_EMPLOYEE where EMPCODE=?";
	}

	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where EMPCODE=? ";
	}

	public void save(Temployee entity) {
		String sql = "insert into T_EMPLOYEE "
				+ " (EMPCODE,EMPNAME,SEX,PERSONID,BIRTH,ALIAS,FOLK,NATIVEPLACE,POLITYVISAGE,SCHOOLAGE,HYZH,STATURE,WEIGHT,POSTURE,NPCODE,ADDRESS,NPADDRESS,PHONE,CYRJZT,TEMPORARYCODE,NOWADRESS,INSERTTIME,EDITTIME,CPCODE,POSITION,USERID) "
				+ " values "
				+ " (:empcode,:empname,:sex,:personid,:birth,:alias,:folk,:nativeplace,:polityvisage,:schoolage,:hyzh,:stature,:weight,:posture,:npcode,:address,:npaddress,:phone,:cyrjzt,:temporarycode,:nowadress,:inserttime,:edittime,:cpcode,:position,:userid)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_EMPLOYEE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity, sql); //手工分配
	}

	public void update(Temployee entity) {
		String sql = "update T_EMPLOYEE set "
				+ " EMPNAME=:empname,SEX=:sex,PERSONID=:personid,BIRTH=:birth,ALIAS=:alias,FOLK=:folk,NATIVEPLACE=:nativeplace,POLITYVISAGE=:polityvisage,SCHOOLAGE=:schoolage,HYZH=:hyzh,STATURE=:stature,WEIGHT=:weight,POSTURE=:posture,NPCODE=:npcode,ADDRESS=:address,NPADDRESS=:npaddress,PHONE=:phone,CYRJZT=:cyrjzt,TEMPORARYCODE=:temporarycode,NOWADRESS=:nowadress,INSERTTIME=:inserttime,EDITTIME=:edittime,CPCODE=:cpcode,POSITION=:position,USERID=:userid"
				+ " where EMPCODE=:empcode";
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
				+ " ,ss_dept b,ss_user c where t.cpcode = b.deptid  and t.userid=c.userid(+) "
				+ "/~ and t.EMPNAME like '%'||{empname}||'%' ~/"
				+ "/~ and t.SEX = ''||{sex}||'' ~/"
				+ "/~ and t.PERSONID like '%'||{personid}||'%'  ~/"
				+ "/~ and t.BIRTH >= ''||{birthBeginFormat}||'' ~/"
				+ "/~ and t.BIRTH <= ''||{birthEndFormat}||'' ~/"
				+ "/~ and t.ALIAS = ''||{alias}||'' ~/"
				+ "/~ and t.FOLK = ''||{folk}||'' ~/"
				+ "/~ and t.NATIVEPLACE like ''||{nativeplace}||'%'  ~/"
				+ "/~ and t.POLITYVISAGE = ''||{polityvisage}||'' ~/"
				+ "/~ and t.SCHOOLAGE = ''||{schoolage}||'' ~/"
				+ "/~ and t.HYZH = ''||{hyzh}||'' ~/"
				+ "/~ and t.STATURE = ''||{stature}||'' ~/"
				+ "/~ and t.WEIGHT = ''||{weight}||'' ~/"
				+ "/~ and t.POSTURE = ''||{posture}||'' ~/"
				+ "/~ and t.NPCODE like '{npcode}||'%'  ~/"
				+ "/~ and t.ADDRESS like '%'||{address}||'%'  ~/"
				+ "/~ and t.NPADDRESS like '%'||{npaddress}||'%'  ~/"
				+ "/~ and t.PHONE  like '%'||{phone}||'%' ~/"
				+ "/~ and t.CYRJZT = ''||{cyrjzt}||'' ~/"
				+ "/~ and t.TEMPORARYCODE = ''||{temporarycode}||'' ~/"
				+ "/~ and t.NOWADRESS = ''||{nowadress}||'' ~/"
				+ "/~ and t.INSERTTIME = ''||{inserttime}||'' ~/"
				+ "/~ and t.EDITTIME = ''||{edittime}||'' ~/"
				+ "/~ and t.CPCODE = {cpcode} ~/"
				+ "/~ and b.DEPTSEQ like  {deptseq}||'%' ~/"
				+ "/~ and b.DEPTSEQ like  {orgseq}||'%' ~/"
				
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  inserttime desc ";
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
	public int getCountByIdcard(String new_IDCard, String old_IDCard,
			String deptid) {
		String sql = "select count(*)   from T_EMPLOYEE  where   (PERSONID = ? or PERSONID =?)  and CYRJZT = ?";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { new_IDCard, old_IDCard, "1" });

		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	public List getCyry(String deptId){
		String sql = "select EMPCODE,EMPNAME,USERID from T_EMPLOYEE t where t.CYRJZT<>2 and t.cpcode= '"+deptId+"'";
		
		 return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String code = rs.getString(1);
	        	    String name = rs.getString(2);
	        	    String userid = rs.getString(3);
			        results.put("EMPCODE", code);
			        results.put("EMPNAME", name);
			        results.put("USERID", userid);
			        return results;
	           }
	           
	       });
	}
	public void saveTempworklog(Tempworklog entity) {
		String sql = "insert into T_EMPWORKLOG "
				+ " (WORKLOGID,EMPCODE,CPCODE,INDATE,LEFTDATE,EMPTYPE,DEMO) "
				+ " values "
				+ " (:worklogid,:empcode,:cpcode,:indate,:leftdate,:emptype,:demo)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_EMPWORKLOG",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity, sql); //手工分配
	}

	public void saveSsUser(SsUser entity) {
		String sql = "insert into SS_USER "
				+ " (USERID,USERNAME,PASSWORD,FULLNAME,SEX,SFZH,POLICEID,PHONE,MOBILE,FAX,ADDRESS,ZIP,EMAILADDRESS,CREATEDATE,DEPTID,ENABLED,PHOTO) "
				+ " values "
				+ " (:userid,:username,:password,:fullname,:sex,:sfzh,:policeid,:phone,:mobile,:fax,:address,:zip,:emailaddress,:createdate,:deptid,:enabled,:photo)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_SS_USER",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity, sql); //手工分配
	}

	//从业人员基本信息 图片id是否存在
	public int getPicIDIsExist(String ID) {
		String sql = "select count(EMPCODE) as   from T_EMPPIC  where EMPCODE = ?  ";
		int totalCount = 0;
		try {
			totalCount = getJdbcTemplate()
					.queryForInt(sql, new Object[] { ID });

		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	private LobHandler lobhandler = new DefaultLobHandler();

	//从业人员基本信息 保存图片
	public void savePic(String filePath, String ID) {
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");

		final File blobIn = new File(filePath);

		if (blobIn.exists()) {
			try {

				final InputStream blobIs= new FileInputStream(blobIn);

				final String str_id = ID;
				final Long str_length = blobIn.length();
				//		final File clobIn = new File("large.txt");
				//		final InputStream clobIs = new FileInputStream(clobIn);
				//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
				getJdbcTemplate()
						.execute(
								"INSERT INTO T_EMPPIC (EMPCODE, PIC,PICLEN) VALUES (?, ?,?)",
								new AbstractLobCreatingPreparedStatementCallback(
										lobhandler) {
									protected void setValues(
											PreparedStatement ps,
											LobCreator lobCreator)
											throws SQLException {
										ps.setString(1, str_id);
										//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
										lobCreator.setBlobAsBinaryStream(ps, 2,
												blobIs, (int) blobIn.length());
										ps.setLong(3, str_length);
									}
								});

				blobIs.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//clobReader.close();
	}

	//从业人员基本信息 修改图片
	public void updatePic(String filePath, String ID) throws IOException {
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
		final File blobIn = new File(filePath);
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = ID;
		final Long str_length = blobIn.length();
		//		final File clobIn = new File("large.txt");
		//		final InputStream clobIs = new FileInputStream(clobIn);
		//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(
				" update T_EMPPIC set PIC =?,PICLEN = ? where EMPCODE =? ",
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {

						//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
						lobCreator.setBlobAsBinaryStream(ps, 1, blobIs,
								(int) blobIn.length());
						ps.setLong(2, str_length);
						ps.setString(3, str_id);
					}
				});
		blobIs.close();
		//clobReader.close()
	}

	public List<SsRole> findEnterpriseUserNoExistRole(String session_deptId,
			String roleIds) {
		String SELECT_PREFIX_PRE = "select  "
				+ " ROLEID as roleid,"
				+ " ROLENAME as rolename,"
				+ " ROLEDESC as roledesc"
				+ " from SS_ROLE   where "
				+ "roleid in ( select ROLEID from SS_DEPT_ROLE  where  DEPTID = ? ) "
				+ " and roleid  in (" + roleIds + ")";
		System.out.println(session_deptId);
		System.out.println(roleIds);
		Object[] params = new Object[] { session_deptId };
		int[] types = new int[] { Types.BIGINT };
		List listSsMenu = getJdbcTemplate().query(SELECT_PREFIX_PRE, params,
				types, new ItemMapper());
		return listSsMenu;
	}

	public void removeroleUser(java.lang.Long userid) {
		getJdbcTemplate().update("delete from  ss_group_user  where USERID = ?",
				new Object[] { userid });

	}

	public void insertRoleUser(long roleid, long userid) {
		String sql = "INSERT INTO SS_ROLE_USER (ROLEID,USERID) VALUES(:roleid, :userid)";
		Map namedParameters = new HashMap();
		namedParameters.put("roleid", roleid);
		namedParameters.put("userid", userid);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SsRole ssRole = new SsRole();
			ssRole.setRoleid(rs.getLong(1));
			ssRole.setRolename(rs.getString(2));
			ssRole.setRoledesc(rs.getString(3));

			return ssRole;

		}
	}

	public Long getSsUserSeq() {
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(
				getDataSource(), "SEQ_SS_USER");
		Long id = seq.nextLongValue();
		return id;
	}

	public Long getEempworklogSeq() {
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(
				getDataSource(), "SEQ_T_EMPWORKLOG");
		Long id = seq.nextLongValue();
		return id;
	}

	public void updateEmpStatus(String empcode) {
		String sql = " UPDATE T_EMPLOYEE set cyrjzt = '2' where EMPCODE =:empcode ";
		Map namedParameters = new HashMap();
		namedParameters.put("empcode", empcode);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	public void updateUserStatus(String empcode) {
		String sql = " update SS_USER a set ENABLED = '0' where a.username = (select b.username from t_employee b where b.empcode =:empcode) ";

		Map namedParameters = new HashMap();
		namedParameters.put("empcode", empcode);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	public void updateSsUser(SsUser entity) {
		String sql = "update SS_USER set "
				+ " USERNAME=:username,PASSWORD=:password,FULLNAME=:fullname,SEX=:sex,SFZH=:sfzh,ENABLED=:enabled"
				+ " where USERID=:userid";
		getNamedParameterJdbcTemplate().update(sql,
				new BeanPropertySqlParameterSource(entity));
	}
	//从业人员基本信息 保存图片
	public void savePic(final byte[] b, String ID) {
		if(b!=null&&b.length>0){
			final String str_id = ID;
			
			getJdbcTemplate()
			.execute(
					"INSERT INTO T_EMPPIC (EMPCODE, PIC,PICLEN) VALUES (?, ?,?)",
					new AbstractLobCreatingPreparedStatementCallback(
							lobhandler) {
						protected void setValues(
								PreparedStatement ps,
								LobCreator lobCreator)
								throws SQLException {
							ps.setString(1, str_id);
							//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
							ps.setBytes(2, b);
							ps.setLong(3, b.length);
						}
					});
		}
			
	}
	public int getCountUserName(String username) {
		String sql = "select count(USERID) from SS_USER  where USERNAME=?  ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { username });

		} catch (EmptyResultDataAccessException ex) {
			logger
					.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	//从业人员基本信息 修改图片
	public void updatePic(final byte[] b, String ID) throws IOException {
		if(b!=null&&b.length>0){
			final String str_id = ID;
			getJdbcTemplate().execute(
					" update T_EMPPIC set PIC =?,PICLEN = ? where EMPCODE =? ",
					new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
						protected void setValues(PreparedStatement ps,
								LobCreator lobCreator) throws SQLException {

							//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
							ps.setBytes(1, b);
							ps.setLong(2, b.length);
							ps.setString(3, str_id);
						}
					});
		}
	
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
