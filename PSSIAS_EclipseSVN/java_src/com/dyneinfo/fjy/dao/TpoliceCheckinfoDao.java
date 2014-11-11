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
import java.util.ArrayList;
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
public class TpoliceCheckinfoDao extends BaseSpringJdbcDao<TpoliceCheckinfo,Long>{
	
	public Class getEntityClass() {
		return TpoliceCheckinfo.class;
	}
	
	public String getIdentifierPropertyName() {
		return "checkinfoid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CHECKINFOID as checkinfoid,"
				+" CHECKID as checkid,"
				+" ITEM as item,"
				+" DETAIL as detail"
				+" from T_POLICE_CHECKINFO ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_POLICE_CHECKINFO where CHECKINFOID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where CHECKINFOID=? ";
	}
	
	public void save(TpoliceCheckinfo entity) {
		String sql = "insert into T_POLICE_CHECKINFO " 
			 + " (CHECKINFOID,CHECKID,ITEM,DETAIL) " 
			 + " values "
			 + " (:checkinfoid,:checkid,:item,:detail)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_POLICE_CHECKINFO",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpoliceCheckinfo entity) {
		String sql = "update T_POLICE_CHECKINFO set "
					+ " CHECKINFOID=:checkinfoid,CHECKID=:checkid,ITEM=:item,DETAIL=:detail "
					+ " where CHECKINFOID=:checkinfoid";
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
				+ "/~ and t.CHECKID = '[checkid]' ~/"
				+ "/~ and t.ITEM = '[item]' ~/"
				+ "/~ and t.DETAIL = '[detail]' ~/"
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
	public List<TpoliceCheckinfo> getCheckList(String checkid){
		
		 String sql="select (case  when t.checktype = '1' " +
		 		" then (select dictname from ss_dict_item d where d.dicttypeid='D_check_item' " +
		 		" and d.status='1' and d.dictid=c.item) else (select dictname from ss_dict_item d " +
		 		" where d.dicttypeid='D_mainTain_item' and d.status='1' and d.dictid=c.item)  end) item," +
		 		" c.detail from t_fjycp_check t,t_police_checkinfo c where t.id=c.checkid and checkid = ?";
		 List list=new ArrayList();
			list = getJdbcTemplate().queryForList(sql, new Object[]{checkid});
			return list;
	}
	
	private String createSql = "insert into T_POLICE_CHECKINFO " 
		 + " (CHECKINFOID,CHECKID,ITEM,DETAIL) " 
		 + " values "
		 + " (?,?,?,?)";
	private String updateSql = "update T_POLICE_CHECKINFO set "
		+ " CHECKINFOID=?,CHECKID=?,ITEM=?,DETAIL=? "
		+ " where CHECKINFOID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpoliceCheckinfo entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getCheckinfoid());
						ps.setString(2, entity.getCheckid());
						ps.setString(3, entity.getItem());
						ps.setString(4, entity.getDetail());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpoliceCheckinfo(final TpoliceCheckinfo entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getCheckinfoid());
				ps.setString(2, entity.getCheckid());
				ps.setString(3, entity.getItem());
				ps.setString(4, entity.getDetail());
			}
		});
	}

	
	public void updateTpoliceCheckinfo(final TpoliceCheckinfo entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getCheckinfoid());
				ps.setString(2, entity.getCheckid());
				ps.setString(3, entity.getItem());
				ps.setString(4, entity.getDetail());
			}
		});
	}

	
	public void deleteTpoliceCheckinfo(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
