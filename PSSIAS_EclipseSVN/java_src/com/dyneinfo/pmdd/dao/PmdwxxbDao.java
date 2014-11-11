/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

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

import com.dyneinfo.zazh.model.SsDept;
import com.dyneinfo.zazh.model.SsUser;
import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class PmdwxxbDao extends BaseSpringJdbcDao<Pmdwxxb,java.lang.String>{
	
	public Class getEntityClass() {
		return Pmdwxxb.class;
	}
	
	public String getIdentifierPropertyName() {
		return "optime";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" TIB_FLOWGUID as tibFlowguid,"
				+" TIB_ROWGUID as tibRowguid,"
				+" DWBM as dwbm,"
				+" OPTIME as optime,"
				+" DWMC as dwmc,"
				+" DWDZ as dwdz,"
				+" LXDH as lxdh,"
				+" CZ as cz,"
				+" YZBM as yzbm,"
				+" KYRQ as kyrq,"
				+" DWZT as dwzt,"
				+" FRXM as frxm,"
				+" ZGBM as zgbm,"
				+" FZR as fzr,"
				+" ZAFZR as zafzr,"
				+" BABDH as babdh,"
				+" JYFW as jyfw,"
				+" ZCZB as zczb,"
				+" ZDMJ as zdmj,"
				+" TXXKZH as txxkzh,"
				+" TXXKZFZDW as txxkzfzdw,"
				+" YYZZBH as yyzzbh,"
				+" YYZZFZDW as yyzzfzdw,"
				+" FLAG as flag,"
				+" XZQHMC as xzqhmc,"
				+" XZQHDM as xzqhdm,"
				+" FJDM as fjdm,"
				+" PCSDM as pcsdm,"
				+" ISCODE as iscode,"
				+" SMYCODE as smycode,"
				+" TYPECODE as typecode"
				
				+" from PMDWXXB ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from PMDWXXB where DWBM=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DWBM=? ";
	}
	
	public void save(Pmdwxxb entity) {
		String sql = "insert into PMDWXXB " 
			 + " (TIB_FLOWGUID,TIB_ROWGUID,DWBM,OPTIME,DWMC,DWDZ,LXDH,CZ,YZBM,KYRQ,DWZT,FRXM,ZGBM,FZR,ZAFZR,BABDH,JYFW,ZCZB,ZDMJ,TXXKZH,TXXKZFZDW,YYZZBH,YYZZFZDW,FLAG,XZQHMC,XZQHDM,FJDM,PCSDM) " 
			 + " values "
			 + " (:tibFlowguid,:tibRowguid,:dwbm,:optime,:dwmc,:dwdz,:lxdh,:cz,:yzbm,:kyrq,:dwzt,:frxm,:zgbm,:fzr,:zafzr,:babdh,:jyfw,:zczb,:zdmj,:txxkzh,:txxkzfzdw,:yyzzbh,:yyzzfzdw,:flag,:xzqhmc,:xzqhdm,:fjdm,:pcsdm)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_PMDWXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Pmdwxxb entity) {
		String sql = "update PMDWXXB set "
					+ " TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,DWBM=:dwbm,OPTIME=:optime,DWMC=:dwmc,DWDZ=:dwdz,LXDH=:lxdh,CZ=:cz,YZBM=:yzbm,KYRQ=:kyrq,DWZT=:dwzt,FRXM=:frxm,ZGBM=:zgbm,FZR=:fzr,ZAFZR=:zafzr,BABDH=:babdh,JYFW=:jyfw,ZCZB=:zczb,ZDMJ=:zdmj,TXXKZH=:txxkzh,TXXKZFZDW=:txxkzfzdw,YYZZBH=:yyzzbh,YYZZFZDW=:yyzzfzdw,FLAG=:flag,XZQHMC=:xzqhmc,XZQHDM=:xzqhdm,FJDM=:fjdm,PCSDM=:pcsdm "
					+ " where DWBM=:dwbm";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	public void updatecode(Pmdwxxb entity){
		String sql = "update PMDWXXB set ISCODE = :iscode,SMYCODE = :smycode,TYPECODE = :typecode" +
					 " where DWBM = :dwbm";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	//	检查表存在字典代码与否
	public int getFindCountById(String dwbm) {
		String sql = "select count(DWBM) from PMDWXXB  where DWBM=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {dwbm} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public Pmdwxxb getPmdwxxbById(String  dwbm) {
		String sql = getSelectPrefix() + "  where DWBM='"+dwbm+"'  ";
		return (Pmdwxxb)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	
	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t,ss_dept c where t.DWBM = c.deptid(+) "
		  		+ "/~ and t.DWBM = '[deptid]' ~/"
		  		+ "/~ and t.DWBM in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.DWBM = '[dwbm]' ~/"
				+ "/~ and t.DWMC like '%[dwmc]%' ~/"
				+ "/~ and t.DWDZ like '%[dwdz]%' ~/"
				+ "/~ and t.LXDH = '[lxdh]' ~/"
				+ "/~ and t.CZ = '[cz]' ~/"
				+ "/~ and t.YZBM = '[yzbm]' ~/"
				+ "/~ and t.KYRQ >= '[kyrqBeginFormat]' ~/"
				+ "/~ and t.KYRQ <= '[kyrqEndFormat]' ~/"
				+ "/~ and t.DWZT = '[dwzt]' ~/"
				+ "/~ and t.FRXM = '[frxm]' ~/"
				+ "/~ and t.ZGBM = '[zgbm]' ~/"
				+ "/~ and t.FZR like '%[fzr]%' ~/"
				+ "/~ and t.ZAFZR = '[zafzr]' ~/"
				+ "/~ and t.BABDH = '[babdh]' ~/"
				+ "/~ and t.JYFW = '[jyfw]' ~/"
				+ "/~ and t.ZCZB = '[zczb]' ~/"
				+ "/~ and t.ZDMJ = '[zdmj]' ~/"
				+ "/~ and t.TXXKZH = '[txxkzh]' ~/"
				+ "/~ and t.TXXKZFZDW = '[txxkzfzdw]' ~/"
				+ "/~ and t.YYZZBH = '[yyzzbh]' ~/"
				+ "/~ and t.YYZZFZDW = '[yyzzfzdw]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.XZQHMC = '[xzqhmc]' ~/"
				+ "/~ and t.XZQHDM = '[xzqhdm]' ~/"
				+ "/~ and t.FJDM = '[fjdm]' ~/"
				+ "/~ and t.PCSDM = '[pcsdm]' ~/"
				+ "/~ and c.deptseq like '[deptseq]%' ~/"
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
	
	public String getFjmcByFjdm(String fjdm){
		String sql="select dictname from SS_DICT_ITEM where dictid= ?";
		String fjmc=(String)this.getJdbcTemplate().queryForObject(sql, new Object[]{fjdm},String.class);
		return fjmc;
	}


	public int getMaxDwbm(String fjbm) throws IOException{
		
		String sql="select max(dwbm) from  pmdwxxb t where substr(t.dwbm,0,6) = ? ";
//		String sql2 ="select code from T_CONFIG ";
		String  maxSequence="";
		String  qybmz ="";
		int newSequence=0;
		Object[] obj ={fjbm}; 
		try {   
			maxSequence= this.getJdbcTemplate().queryForObject(sql,obj, String.class).toString();
//			qybmz =(String)this.getJdbcTemplate().queryForObject(sql2, obj,String.class);
		} catch (EmptyResultDataAccessException ex) {   
			  logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
		}
		if(maxSequence!=null && maxSequence!="" && maxSequence.length() >= 10){
			maxSequence=maxSequence.substring(6,10).toString();
			System.out.println();
			newSequence=Integer.parseInt(maxSequence.trim().toString());
		}

		return newSequence;
	}
	
	/*
	 * 企业编码从
	 */
	public String getZjzDwbm() throws IOException{
		
		String sql ="select code from T_CONFIG where 1=1";
		
		String qybmz=null;
		try {   
			qybmz =(String) this.getJdbcTemplate().queryForObject(sql, String.class);
			
		} catch (EmptyResultDataAccessException ex) {   
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
		}
		return qybmz;
	}
	
	
	public int getQyjs() {
		String sql="select count(*) from  pmdwxxb";
		int  qyjs=0;

		try {   
			qyjs= this.getJdbcTemplate().queryForInt(sql);
		} catch (EmptyResultDataAccessException ex) {   
			  logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
		}
		return qyjs;
	}
	
	
	
	public List getRegistrationInfo() {
		String sql = "select XZRQ,XZJS,XZQH,MD5 from T_XTKZ ";
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String XZRQ = rs.getString(1);
	        	    String XZJS = rs.getString(2);
	        	    String XZQH = rs.getString(3);
	        	    String MD5 = rs.getString(4);
			        results.put("XZRQ", XZRQ);
			        results.put("XZJS", XZJS);
			        results.put("XZQH", XZQH);
			        results.put("MD5", MD5);
			        return results;
	           }
	           
	       });
	   }
	
	
	
	private String createSql = "insert into PMDWXXB " 
		 + " (TIB_FLOWGUID,TIB_ROWGUID,DWBM,OPTIME,DWMC,DWDZ,LXDH,CZ,YZBM,KYRQ,DWZT,FRXM,ZGBM,FZR,ZAFZR,BABDH,JYFW,ZCZB,ZDMJ,TXXKZH,TXXKZFZDW,YYZZBH,YYZZFZDW,FLAG,XZQHMC,XZQHDM,FJDM,PCSDM) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update PMDWXXB set "
		+ " TIB_FLOWGUID=?,TIB_ROWGUID=?,DWBM=?,OPTIME=?,DWMC=?,DWDZ=?,LXDH=?,CZ=?,YZBM=?,KYRQ=?,DWZT=?,FRXM=?,ZGBM=?,FZR=?,ZAFZR=?,BABDH=?,JYFW=?,ZCZB=?,ZDMJ=?,TXXKZH=?,TXXKZFZDW=?,YYZZBH=?,YYZZFZDW=?,FLAG=?,XZQHMC=?,XZQHDM=?,FJDM=?,PCSDM=? "
		+ " where DWBM=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Pmdwxxb entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getTibFlowguid());
						ps.setString(2, entity.getTibRowguid());
						ps.setString(3, entity.getDwbm());
						ps.setString(4, entity.getOptime());
						ps.setString(5, entity.getDwmc());
						ps.setString(6, entity.getDwdz());
						ps.setString(7, entity.getLxdh());
						ps.setString(8, entity.getCz());
						ps.setString(9, entity.getYzbm());
						ps.setString(10, entity.getKyrq());
						ps.setString(11, entity.getDwzt());
						ps.setString(12, entity.getFrxm());
						ps.setString(13, entity.getZgbm());
						ps.setString(14, entity.getFzr());
						ps.setString(15, entity.getZafzr());
						ps.setString(16, entity.getBabdh());
						ps.setString(17, entity.getJyfw());
						ps.setString(18, entity.getZczb());
						ps.setString(19, entity.getZdmj());
						ps.setString(20, entity.getTxxkzh());
						ps.setString(21, entity.getTxxkzfzdw());
						ps.setString(22, entity.getYyzzbh());
						ps.setString(23, entity.getYyzzfzdw());
						ps.setString(24, entity.getFlag());
						ps.setString(25, entity.getXzqhmc());
						ps.setString(26, entity.getXzqhdm());
						ps.setString(27, entity.getFjdm());
						ps.setString(28, entity.getPcsdm());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createPmdwxxb(final Pmdwxxb entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getDwbm());
				ps.setString(4, entity.getOptime());
				ps.setString(5, entity.getDwmc());
				ps.setString(6, entity.getDwdz());
				ps.setString(7, entity.getLxdh());
				ps.setString(8, entity.getCz());
				ps.setString(9, entity.getYzbm());
				ps.setString(10, entity.getKyrq());
				ps.setString(11, entity.getDwzt());
				ps.setString(12, entity.getFrxm());
				ps.setString(13, entity.getZgbm());
				ps.setString(14, entity.getFzr());
				ps.setString(15, entity.getZafzr());
				ps.setString(16, entity.getBabdh());
				ps.setString(17, entity.getJyfw());
				ps.setString(18, entity.getZczb());
				ps.setString(19, entity.getZdmj());
				ps.setString(20, entity.getTxxkzh());
				ps.setString(21, entity.getTxxkzfzdw());
				ps.setString(22, entity.getYyzzbh());
				ps.setString(23, entity.getYyzzfzdw());
				ps.setString(24, entity.getFlag());
				ps.setString(25, entity.getXzqhmc());
				ps.setString(26, entity.getXzqhdm());
				ps.setString(27, entity.getFjdm());
				ps.setString(28, entity.getPcsdm());
			}
		});
	}

	
	public void updatePmdwxxb(final Pmdwxxb entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getDwbm());
				ps.setString(4, entity.getOptime());
				ps.setString(5, entity.getDwmc());
				ps.setString(6, entity.getDwdz());
				ps.setString(7, entity.getLxdh());
				ps.setString(8, entity.getCz());
				ps.setString(9, entity.getYzbm());
				ps.setString(10, entity.getKyrq());
				ps.setString(11, entity.getDwzt());
				ps.setString(12, entity.getFrxm());
				ps.setString(13, entity.getZgbm());
				ps.setString(14, entity.getFzr());
				ps.setString(15, entity.getZafzr());
				ps.setString(16, entity.getBabdh());
				ps.setString(17, entity.getJyfw());
				ps.setString(18, entity.getZczb());
				ps.setString(19, entity.getZdmj());
				ps.setString(20, entity.getTxxkzh());
				ps.setString(21, entity.getTxxkzfzdw());
				ps.setString(22, entity.getYyzzbh());
				ps.setString(23, entity.getYyzzfzdw());
				ps.setString(24, entity.getFlag());
				ps.setString(25, entity.getXzqhmc());
				ps.setString(26, entity.getXzqhdm());
				ps.setString(27, entity.getFjdm());
				ps.setString(28, entity.getPcsdm());
			}
		});
	}

	
	public void deletePmdwxxb(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	
	public void saveDept(SsDept entity) {
		String sql = "insert into SS_DEPT " 
			 + " (DEPTID,DEPTNAME,DEPTDESC,DEPTCODE,DEPTSEQ,DISPLAYORDER,PARENTID,DEPTLEVEL,DEPTTYPEID,STATUS) " 
			 + " values "
			 + " (:deptid,:deptname,:deptdesc,:deptcode,:deptseq,:displayorder,:parentid,:deptlevel,:depttypeid,:status)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_SS_DEPT",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
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
		String sql = "update SS_DEPT set "
			+ " DEPTNAME=:deptname,DEPTDESC=:deptdesc,DEPTCODE=:deptcode,DEPTSEQ=:deptseq,DISPLAYORDER=:displayorder,PARENTID=:parentid,DEPTLEVEL=:deptlevel,DEPTTYPEID=:depttypeid,STATUS=:status "
			+ " where DEPTID=:deptid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	public String getsmycode(String dwbm){
		String sql="select smycode from PMDWXXB where  dwbm = ?";
		String fjmc="";
		try {   
			fjmc=(String)this.getJdbcTemplate().queryForObject(sql, new Object[]{dwbm},String.class);
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		} 
		return fjmc;
	}
	public String gettypecode(String dwbm){
		String fjmc="";
		String sql="select typecode from PMDWXXB where dwbm = ?";
		try {
		fjmc=(String)this.getJdbcTemplate().queryForObject(sql, new Object[]{dwbm},String.class);
		}catch (EmptyResultDataAccessException ex) {   
	           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		} 
		return fjmc;
	}

}
