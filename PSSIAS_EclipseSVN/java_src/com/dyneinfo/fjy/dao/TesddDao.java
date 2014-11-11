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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TesddDao extends BaseSpringJdbcDao<Tesdd,java.lang.String>{
	
	public Class getEntityClass() {
		return Tesdd.class;
	}
	
	public String getIdentifierPropertyName() {
		return "dnid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DNID as dnid,"
				+" DDLX as ddlx,"
				+" DNPP as dnpp,"
				+" DNXH as dnxh,"
				+" ZBH as zbh,"
				+" YPH as yph,"
				+" ZC as zc,"
				+" CPCODE as cpcode,"
				+" CHUSHOURY as chushoury,"
				+" CHUSHOURENXB as chushourenxb,"
				+" CHUSHOURENSFZH as chushourensfzh,"
				+" BEIZHU as beizhu,"
				+" CHUSHOURENLXDH as chushourenlxdh,"
				+" MACDZ as macdz,"
				+" SGSJ as sgsj,"
				+" DQSJH as dqsjh,"
				+" CSRJTZZ as csrjtzz,"
				+" CSRDH as csrdh,"
				+" GMSJ as gmsj,"
				+" JBR as jbr,"
				+" b.deptname as deptname,"
				+" c.FULLNAME as jbrXm "
				+" from T_ESDD t , ss_dept b,SS_user c  where t.CPCODE = b.deptid and t.jbr  = c.username";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_ESDD where DNID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and DNID=? ";
	}
	
	public void save(Tesdd entity) {
		String sql = "insert into T_ESDD " 
			 + " (DNID,DDLX,DNPP,DNXH,ZBH,YPH,ZC,CPCODE,CHUSHOURY,CHUSHOURENXB,CHUSHOURENSFZH,BEIZHU,CHUSHOURENLXDH,MACDZ,SGSJ,DQSJH,CSRJTZZ,CSRDH,GMSJ,JBR) " 
			 + " values "
			 + " (:dnid,:ddlx,:dnpp,:dnxh,:zbh,:yph,:zc,:cpcode,:chushoury,:chushourenxb,:chushourensfzh,:beizhu,:chushourenlxdh,:macdz,:sgsj,:dqsjh,:csrjtzz,:csrdh,:gmsj,:jbr)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_ESDD",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tesdd entity) {
		String sql = "update T_ESDD set "
					+ " DNID=:dnid,DDLX=:ddlx,DNPP=:dnpp,DNXH=:dnxh,ZBH=:zbh,YPH=:yph,ZC=:zc,CPCODE=:cpcode,CHUSHOURY=:chushoury,CHUSHOURENXB=:chushourenxb,CHUSHOURENSFZH=:chushourensfzh,BEIZHU=:beizhu,CHUSHOURENLXDH=:chushourenlxdh,MACDZ=:macdz,SGSJ=:sgsj,DQSJH=:dqsjh,CSRJTZZ=:csrjtzz,CSRDH=:csrdh,GMSJ=:gmsj,JBR=:jbr "
					+ " where DNID=:dnid";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "    "
				+ "/~ and t.DDLX = '[ddlx]' ~/"
				+ "/~ and t.DNPP like {dnppLike} ~/"
				+ "/~ and t.DNXH like '%[dnxh]%' ~/"
				+ "/~ and t.ZBH like '%[zbh]%' ~/"
				+ "/~ and t.YPH like '%[yph]%' ~/"
				+ "/~ and t.ZC = '[zc]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.CHUSHOURY like '%[chushoury]%' ~/"
				+ "/~ and t.CHUSHOURENXB = '[chushourenxb]' ~/"
				+ "/~ and t.CHUSHOURENSFZH = '[chushourensfzh]' ~/"
				+ "/~ and t.BEIZHU = '[beizhu]' ~/"
				+ "/~ and t.CHUSHOURENLXDH = '[chushourenlxdh]' ~/"
				+ "/~ and t.MACDZ like '%[macdz]%' ~/"
				+ "/~ and t.SGSJ >= '[sgsjBeginFormat]' ~/"
				+ "/~ and t.SGSJ <= '[sgsjEndFormat]' ~/"
				+ "/~ and t.DQSJH = '[dqsjh]' ~/"
				+ "/~ and t.CSRJTZZ = '[csrjtzz]' ~/"
				+ "/~ and t.CSRDH = '[csrdh]' ~/"
				+ "/~ and t.GMSJ = '[gmsj]' ~/"
				+ "/~ and t.JBR = '[jbr]' ~/"
				+ "/~ and b.DEPTSEQ like {deptSeq}||'%' ~/"
				+ "/~ and b.deptname like '%[deptname]%' ~/"
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
	
	
	private String createSql = "insert into T_ESDD " 
		 + " (DNID,DDLX,DNPP,DNXH,ZBH,YPH,ZC,CPCODE,CHUSHOURY,CHUSHOURENXB,CHUSHOURENSFZH,BEIZHU,CHUSHOURENLXDH,MACDZ,SGSJ,DQSJH,CSRJTZZ,CSRDH,GMSJ,JBR) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_ESDD set "
		+ " DNID=?,DDLX=?,DNPP=?,DNXH=?,ZBH=?,YPH=?,ZC=?,CPCODE=?,CHUSHOURY=?,CHUSHOURENXB=?,CHUSHOURENSFZH=?,BEIZHU=?,CHUSHOURENLXDH=?,MACDZ=?,SGSJ=?,DQSJH=?,CSRJTZZ=?,CSRDH=?,GMSJ=?,JBR=? "
		+ " where DNID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tesdd entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getDnid());
						ps.setString(2, entity.getDdlx());
						ps.setString(3, entity.getDnpp());
						ps.setString(4, entity.getDnxh());
						ps.setString(5, entity.getZbh());
						ps.setString(6, entity.getYph());
						ps.setString(7, entity.getZc());
						ps.setString(8, entity.getCpcode());
						ps.setString(9, entity.getChushoury());
						ps.setString(10, entity.getChushourenxb());
						ps.setString(11, entity.getChushourensfzh());
						ps.setString(12, entity.getBeizhu());
						ps.setString(13, entity.getChushourenlxdh());
						ps.setString(14, entity.getMacdz());
						ps.setString(15, entity.getSgsj());
						ps.setString(16, entity.getDqsjh());
						ps.setString(17, entity.getCsrjtzz());
						ps.setString(18, entity.getCsrdh());
						ps.setString(19, entity.getGmsj());
						ps.setString(20, entity.getJbr());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTesdd(final Tesdd entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDnid());
				ps.setString(2, entity.getDdlx());
				ps.setString(3, entity.getDnpp());
				ps.setString(4, entity.getDnxh());
				ps.setString(5, entity.getZbh());
				ps.setString(6, entity.getYph());
				ps.setString(7, entity.getZc());
				ps.setString(8, entity.getCpcode());
				ps.setString(9, entity.getChushoury());
				ps.setString(10, entity.getChushourenxb());
				ps.setString(11, entity.getChushourensfzh());
				ps.setString(12, entity.getBeizhu());
				ps.setString(13, entity.getChushourenlxdh());
				ps.setString(14, entity.getMacdz());
				ps.setString(15, entity.getSgsj());
				ps.setString(16, entity.getDqsjh());
				ps.setString(17, entity.getCsrjtzz());
				ps.setString(18, entity.getCsrdh());
				ps.setString(19, entity.getGmsj());
				ps.setString(20, entity.getJbr());
			}
		});
	}

	
	public void updateTesdd(final Tesdd entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDnid());
				ps.setString(2, entity.getDdlx());
				ps.setString(3, entity.getDnpp());
				ps.setString(4, entity.getDnxh());
				ps.setString(5, entity.getZbh());
				ps.setString(6, entity.getYph());
				ps.setString(7, entity.getZc());
				ps.setString(8, entity.getCpcode());
				ps.setString(9, entity.getChushoury());
				ps.setString(10, entity.getChushourenxb());
				ps.setString(11, entity.getChushourensfzh());
				ps.setString(12, entity.getBeizhu());
				ps.setString(13, entity.getChushourenlxdh());
				ps.setString(14, entity.getMacdz());
				ps.setString(15, entity.getSgsj());
				ps.setString(16, entity.getDqsjh());
				ps.setString(17, entity.getCsrjtzz());
				ps.setString(18, entity.getCsrdh());
				ps.setString(19, entity.getGmsj());
				ps.setString(20, entity.getJbr());
			}
		});
	}

	
	public void deleteTesdd(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
