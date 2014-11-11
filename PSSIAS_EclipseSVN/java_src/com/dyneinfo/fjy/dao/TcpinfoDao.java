/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TcpinfoDao extends BaseSpringJdbcDao<Tcpinfo,java.lang.String>{
	
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
				+" CPADRESS as cpadress,"
				+" CPTEL as cptel,"
				+" AREA as area,"
				+" CPKIND as cpkind,"
				+" FRNAME as frname,"
				+" FRSEX as frsex,"
				+" FRIDCODE as fridcode,"
				+" CPTYPE as cptype,"
				+" CPSTATE as cpstate,"
				+" SSPCS as sspcs,"
				+" JYFW as jyfw,"
				+" ZAFZR as zafzr,"
				+" ZAFZRDH as zafzrdh,"
				+" KYSJ as kysj,"
				+" CYRS as cyrs,"
				+" GSZZH as gszzh,"
				+" ZCRQ as zcrq,"
				+" STATEGBSJ as stategbsj,"
				+" CREATETIME as createtime,"
				+" CREATEUSERID as createuserid,"
				+" CREATEDEPTID as createdeptid,"
				+" SETUPFLAG as setupflag,"
				+" sfgszzh as sfgszzh,"
				+" sfban as sfban,"
				+" iscode as iscode,"
				+" typecode as typecode,"
				+" orcmmcode as orcmmcode,"
				
				
				+" b.deptname as deptname "
				+" from T_CPINFO t,ss_dept b " 
				+" where t.sspcs = b.deptid ";
	}
	
	
	public Tcpinfo getTcpinfoById(java.lang.String cpcode) {
		String sql = " select  "
			+" CPCODE as cpcode,"
			+" CPNAME as cpname,"
			+" CPADRESS as cpadress,"
			+" CPTEL as cptel,"
			+" AREA as area,"
			+" CPKIND as cpkind,"
			+" FRNAME as frname,"
			+" FRSEX as frsex,"
			+" FRIDCODE as fridcode,"
			+" CPTYPE as cptype,"
			+" CPSTATE as cpstate,"
			+" SSPCS as sspcs,"
			+" JYFW as jyfw,"
			+" ZAFZR as zafzr,"
			+" ZAFZRDH as zafzrdh,"
			+" KYSJ as kysj,"
			+" CYRS as cyrs,"
			+" GSZZH as gszzh,"
			+" ZCRQ as zcrq,"
			+" STATEGBSJ as stategbsj,"
			+" to_char(CREATETIME,'yyyy-MM-dd hh:mm:ss')  as createtime,"
			+" CREATEUSERID as createuserid,"
			+" CREATEDEPTID as createdeptid,"
			+" SETUPFLAG as setupflag,"
			+" sfgszzh as sfgszzh,"
			+" sfban as sfban,"
			+" b.deptname as deptname "
			+" from T_CPINFO a,ss_dept b " 
			+" where a.sspcs = b.deptid and  a.cpcode = ?";
		Tcpinfo tcpinfo = null;
		try {   
			tcpinfo = (Tcpinfo)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {cpcode});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return tcpinfo;
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CPINFO where CPCODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and t.CPCODE=? ";
	}
	
	public void save(Tcpinfo entity) {
		String sql = "insert into T_CPINFO " 
			 + " (CPCODE,CPNAME,CPADRESS,CPTEL,AREA,CPKIND,FRNAME,FRSEX,FRIDCODE,CPTYPE,CPSTATE,SSPCS,JYFW,ZAFZR,ZAFZRDH,KYSJ,CYRS,GSZZH,ZCRQ,CREATEUSERID,CREATEDEPTID,SETUPFLAG,SFGSZZH,SFBAN) " 
			 + " values "
			 + " (:cpcode,:cpname,:cpadress,:cptel,:area,:cpkind,:frname,:frsex,:fridcode,:cptype,:cpstate,:sspcs,:jyfw,:zafzr,:zafzrdh,:kysj,:cyrs,:gszzh,:zcrq,:createuserid,:createdeptid,:setupflag,:sfgszzh,:sfban)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_CPINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tcpinfo entity) {
		String sql = "update T_CPINFO set "
					+ " CPNAME=:cpname,CPADRESS=:cpadress,CPTEL=:cptel,AREA=:area,CPKIND=:cpkind,FRNAME=:frname,FRSEX=:frsex,FRIDCODE=:fridcode,CPTYPE=:cptype,CPSTATE=:cpstate,SSPCS=:sspcs,JYFW=:jyfw,ZAFZR=:zafzr,ZAFZRDH=:zafzrdh,KYSJ=:kysj,CYRS=:cyrs,GSZZH=:gszzh,ZCRQ=:zcrq,STATEGBSJ=:stategbsj,CREATEUSERID=:createuserid,CREATEDEPTID=:createdeptid,SETUPFLAG=:setupflag,SFGSZZH=:sfgszzh,SFBAN=:sfban "
					+ " where CPCODE=:cpcode";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	public void insertiscode(Tcpinfo entity) {
		String sql = "update T_CPINFO set "
					+ " iscode = :iscode,typecode=:typecode ,orcmmcode=:orcmmcode"
					+ " where CPCODE= :cpcode ";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() 
				+ "/~ and t.CPNAME like '%'||{cpname}||'%' ~/"
				
				+ "/~ and t.CPADRESS like '%'||{cpadress}||'%' ~/"
				+ "/~ and t.CPTEL = ''||{cptel}||'' ~/"
				+ "/~ and t.AREA = ''||{area}||'' ~/"
				+ "/~ and t.CPKIND = ''||{cpkind}||'' ~/"
				+ "/~ and t.FRNAME like '%'||{frname}||'%' ~/"
				+ "/~ and t.FRSEX = ''||{frsex}||'' ~/"
				+ "/~ and t.FRIDCODE like '%'||{fridcode}||'%' ~/"
				+ "/~ and t.CPTYPE = ''||{cptype}||'' ~/"
				+ "/~ and t.CPSTATE = ''||{cpstate}||'' ~/"
				+ "/~ and t.JYFW like '%'||{jyfw}||'%' ~/"
				+ "/~ and t.ZAFZR = ''||{zafzr}||'' ~/"
				+ "/~ and t.ZAFZRDH = ''||{zafzrdh}||'' ~/"
				+ "/~ and t.KYSJ >= ''||{kysjBeginFormat}||'' ~/"
				+ "/~ and t.KYSJ <= ''||{kysjEndFormat}||'' ~/"
				+ "/~ and t.CYRS = ''||{cyrs}||'' ~/"
				+ "/~ and t.SFGSZZH = ''||{sfgszzh}||'' ~/"
				+ "/~ and t.SFBAN = ''||{sfban}||'' ~/"
				+ "/~ and t.GSZZH = ''||{gszzh}||'' ~/"
				+ "/~ and t.CREATEUSERID = ''||{createuserid}||'' ~/"
				+ "/~ and t.setupflag = ''||{setupflag}||'' ~/"
				+ "/~ and t.CREATEDEPTID = ''||{createdeptid}||'' ~/"
				+ "/~ and t.ZCRQ >= ''||{zcrqBeginFormat}||'' ~/"
				+ "/~ and t.ZCRQ <= ''||{zcrqEndFormat}||'' ~/"
				+ "/~ and t.stategbsj >= ''||{stategbsjBeginFormat}||'' ~/"
				+ "/~ and t.stategbsj <= ''||{stategbsjEndFormat}||'' ~/"
				+ "/~ and b.DEPTSEQ like  {sspcs}||'%' ~/"
				+ "/~ and b.DEPTSEQ like  {deptSeq}||'%' ~/"
				+ "/~ and t.CPCODE = {cpcode} ~/"
//				+ "/~ and t.SSPCS =  {sspcs} ~/"
				
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  cpcode desc ";
		
		return pageQuery(sql,pageRequest);
	}
	
	
	public String getCurrentMax(String sql) throws DataAccessException {
		String currentMaxID = "";
		try {
			currentMaxID = (String)this.getJdbcTemplate().queryForObject(sql,String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}
	
	//企业负责人
//	public String getCpinfoFzr(String sql) throws DataAccessException {
//		String fzr = "";
//		try {
//			fzr = (String)this.getJdbcTemplate().queryForObject(sql,String.class);
//		} catch (EmptyResultDataAccessException e) {
//			fzr = "";
//			//e.printStackTrace();
//		}
//		return fzr;
//	}
	
	
	public List getCpinfoFzr(String sql) {
		
		return getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String username = rs.getString(1);
				String deptname = rs.getString(2);
				results.put("username", username);
				results.put("deptname", deptname);
				return results;
			}

		});
	}
	public List getCpinfoSta(String sql) {
		
		return getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				//deptname,yysl,qdsl,azs,sumSl
				String deptname = rs.getString(1);
				String yysl = rs.getString(2);
				String qdsl = rs.getString(3);
				String azs = rs.getString(4);
				String sumSl = rs.getString(5);
				results.put("deptname", deptname);
				results.put("yysl", yysl);
				results.put("qdsl", qdsl);
				results.put("azs", azs);
				results.put("sumSl", sumSl);
				return results;
			}

		});
	}
	
	
	//企业代码存在否
	public int getCountCpcode(String Cpcod) {
		String sql = "select count(CPCODE) from T_CPINFO  where CPCODE=? ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { Cpcod });
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	//企业代码存在否
	public int getCountDept(String Cpcod) {
		String sql = "select count(DEPTID) from SS_DEPT  where DEPTID=? ";
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,
					new Object[] { Cpcod });
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	public void insertDeptRole(String roleid, String deptid) {
		String sql = "INSERT INTO SS_DEPT_ROLE (ROLEID,DEPTID) VALUES(?, ?)";
		getJdbcTemplate().update(sql, new Object[] {roleid,deptid});
	}
	
	
	public String gettypecode(String cpcode) {
		String sql = "select typecode from t_cpinfo  where cpcode=? ";
		String totalCount = "";
		try {
			totalCount=(String)this.getJdbcTemplate().queryForObject(sql,new Object[] { cpcode }, String.class);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	public String getorcmmcode(String cpcode) {
		String sql = "select orcmmcode from t_cpinfo  where cpcode=? ";
		String totalCount = "";
		try {
			totalCount=(String)this.getJdbcTemplate().queryForObject(sql,new Object[] { cpcode }, String.class);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	

	
	
	private String createSql = "insert into T_CPINFO " 
		 + " (CPCODE,CPNAME,CPADRESS,CPTEL,AREA,CPKIND,FRNAME,FRSEX,FRIDCODE,CPTYPE,CPSTATE,SSPCS,JYFW,ZAFZR,ZAFZRDH,KYSJ,CYRS,GSZZH,ZCRQ,CREATEUSERID,CREATEDEPTID,SETUPFLAG,SFGSZZH,SFBAN) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CPINFO set "
		+ " CPCODE=?,CPNAME=?,CPADRESS=?,CPTEL=?,AREA=?,CPKIND=?,FRNAME=?,FRSEX=?,FRIDCODE=?,CPTYPE=?,CPSTATE=?,SSPCS=?,JYFW=?,ZAFZR=?,ZAFZRDH=?,KYSJ=?,CYRS=?,GSZZH=?,ZCRQ=?,STATEGBSJ=?,CREATEUSERID=?,CREATEDEPTID=?,SETUPFLAG=?,SFGSZZH=?,SFBAN=? "
		+ " where CPCODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tcpinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCpcode());
						ps.setString(2, entity.getCpname());
						ps.setString(3, entity.getCpadress());
						ps.setString(4, entity.getCptel());
						ps.setString(5, entity.getArea());
						ps.setString(6, entity.getCpkind());
						ps.setString(7, entity.getFrname());
						ps.setString(8, entity.getFrsex());
						ps.setString(9, entity.getFridcode());
						ps.setString(10, entity.getCptype());
						ps.setString(11, entity.getCpstate());
						ps.setString(12, entity.getSspcs());
						ps.setString(13, entity.getJyfw());
						ps.setString(14, entity.getZafzr());
						ps.setString(15, entity.getZafzrdh());
						ps.setString(16, entity.getKysj());
						ps.setInt(17, entity.getCyrs());
						ps.setString(18, entity.getGszzh());
						ps.setString(19, entity.getZcrq());
					//	ps.setString(20, entity.getStategbsj());
						ps.setString(20, entity.getCreateuserid());
						ps.setString(21, entity.getCreatedeptid());
						ps.setString(22, entity.getSetupflag());
						ps.setString(23, entity.getSfgszzh());
						ps.setString(24, entity.getSfban());
						lobCreator.setBlobAsBinaryStream(ps, 26, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTcpinfo(final Tcpinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCpname());
				ps.setString(3, entity.getCpadress());
				ps.setString(4, entity.getCptel());
				ps.setString(5, entity.getArea());
				ps.setString(6, entity.getCpkind());
				ps.setString(7, entity.getFrname());
				ps.setString(8, entity.getFrsex());
				ps.setString(9, entity.getFridcode());
				ps.setString(10, entity.getCptype());
				ps.setString(11, entity.getCpstate());
				ps.setString(12, entity.getSspcs());
				ps.setString(13, entity.getJyfw());
				ps.setString(14, entity.getZafzr());
				ps.setString(15, entity.getZafzrdh());
				ps.setString(16, entity.getKysj());
				ps.setInt(17, entity.getCyrs());
				ps.setString(18, entity.getGszzh());
				ps.setString(19, entity.getZcrq());
				ps.setString(20, entity.getCreateuserid());
				ps.setString(21, entity.getCreatedeptid());
				ps.setString(22, entity.getSetupflag());
				ps.setString(23, entity.getSfgszzh());
				ps.setString(24, entity.getSfban());
			}
		});
	}

	
	public void updateTcpinfo(final Tcpinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCpcode());
				ps.setString(2, entity.getCpname());
				ps.setString(3, entity.getCpadress());
				ps.setString(4, entity.getCptel());
				ps.setString(5, entity.getArea());
				ps.setString(6, entity.getCpkind());
				ps.setString(7, entity.getFrname());
				ps.setString(8, entity.getFrsex());
				ps.setString(9, entity.getFridcode());
				ps.setString(10, entity.getCptype());
				ps.setString(11, entity.getCpstate());
				ps.setString(12, entity.getSspcs());
				ps.setString(13, entity.getJyfw());
				ps.setString(14, entity.getZafzr());
				ps.setString(15, entity.getZafzrdh());
				ps.setString(16, entity.getKysj());
				ps.setInt(17, entity.getCyrs());
				ps.setString(18, entity.getGszzh());
				ps.setString(19, entity.getZcrq());
				ps.setString(20, entity.getCreateuserid());
				ps.setString(21, entity.getCreatedeptid());
				ps.setString(22, entity.getSetupflag());
				ps.setString(23, entity.getSfgszzh());
				ps.setString(24, entity.getSfban());
			}
		});
	}

	
	public void deleteTcpinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	public void deleteSSdeptinfo(String arg) {
		getJdbcTemplate().update(" delete from SS_DEPT where deptid = ? ", new Object[] { arg });
	}
	
	
	
	

}
