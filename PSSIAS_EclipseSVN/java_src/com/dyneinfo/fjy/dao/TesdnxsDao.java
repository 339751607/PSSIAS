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
public class TesdnxsDao extends BaseSpringJdbcDao<Tesdnxs,Long>{
	
	public Class getEntityClass() {
		return Tesdnxs.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DNID as dnid,"
				+" GMRXM as gmrxm,"
				+" GMRXB as gmrxb,"
				+" GMRSFZH as gmrsfzh,"
				+" GMRLXDH as gmrlxdh,"
				+" GMRJTZZ as gmrjtzz,"
				+" JBR as jbr,"
				+" BZ as bz,"
				+" XH as xh"
				+" from T_ESDNXS ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_ESDNXS where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where XH=? ";
	}
	
	public void save(Tesdnxs entity) {
		String sql = "insert into T_ESDNXS " 
			 + " (DNID,GMRXM,GMRXB,GMRSFZH,GMRLXDH,GMRJTZZ,JBR,BZ,XH) " 
			 + " values "
			 + " (:dnid,:gmrxm,:gmrxb,:gmrsfzh,:gmrlxdh,:gmrjtzz,:jbr,:bz,:xh)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_ESDNXS",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tesdnxs entity) {
		String sql = "update T_ESDNXS set "
					+ " DNID=:dnid,GMRXM=:gmrxm,GMRXB=:gmrxb,GMRSFZH=:gmrsfzh,GMRLXDH=:gmrlxdh,GMRJTZZ=:gmrjtzz,JBR=:jbr,BZ=:bz,XH=:xh "
					+ " where XH=:xh";
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
				+ "/~ and t.DNID = '[dnid]' ~/"
				+ "/~ and t.GMRXM = '[gmrxm]' ~/"
				+ "/~ and t.GMRXB = '[gmrxb]' ~/"
				+ "/~ and t.GMRSFZH = '[gmrsfzh]' ~/"
				+ "/~ and t.GMRLXDH = '[gmrlxdh]' ~/"
				+ "/~ and t.GMRJTZZ = '[gmrjtzz]' ~/"
				+ "/~ and t.JBR = '[jbr]' ~/"
				+ "/~ and t.BZ = '[bz]' ~/"
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
	
	
	private String createSql = "insert into T_ESDNXS " 
		 + " (DNID,GMRXM,GMRXB,GMRSFZH,GMRLXDH,GMRJTZZ,JBR,BZ,XH) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_ESDNXS set "
		+ " DNID=?,GMRXM=?,GMRXB=?,GMRSFZH=?,GMRLXDH=?,GMRJTZZ=?,JBR=?,BZ=?,XH=? "
		+ " where XH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Tesdnxs entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getDnid());
						ps.setString(2, entity.getGmrxm());
						ps.setString(3, entity.getGmrxb());
						ps.setString(4, entity.getGmrsfzh());
						ps.setString(5, entity.getGmrlxdh());
						ps.setString(6, entity.getGmrjtzz());
						ps.setString(7, entity.getJbr());
						ps.setString(8, entity.getBz());
						ps.setLong(9, entity.getXh());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTesdnxs(final Tesdnxs entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDnid());
				ps.setString(2, entity.getGmrxm());
				ps.setString(3, entity.getGmrxb());
				ps.setString(4, entity.getGmrsfzh());
				ps.setString(5, entity.getGmrlxdh());
				ps.setString(6, entity.getGmrjtzz());
				ps.setString(7, entity.getJbr());
				ps.setString(8, entity.getBz());
				ps.setLong(9, entity.getXh());
			}
		});
	}

	
	public void updateTesdnxs(final Tesdnxs entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDnid());
				ps.setString(2, entity.getGmrxm());
				ps.setString(3, entity.getGmrxb());
				ps.setString(4, entity.getGmrsfzh());
				ps.setString(5, entity.getGmrlxdh());
				ps.setString(6, entity.getGmrjtzz());
				ps.setString(7, entity.getJbr());
				ps.setString(8, entity.getBz());
				ps.setLong(9, entity.getXh());
			}
		});
	}

	
	public void deleteTesdnxs(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
