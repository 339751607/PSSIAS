/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.CallableStatementCallback;
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
public class VcsrxxStaDao extends BaseSpringJdbcDao<VcsrxxSta,java.lang.String>{
	
	public Class getEntityClass() {
		return VcsrxxSta.class;
	}
	
	public String getIdentifierPropertyName() {
		return "idcard";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" IDCARD as idcard,"
				+" CSRXM as csrxm,"
				+" CPCODE as cpcode,"
				+" NPCODE as npcode,"
				+" NPADDRESS as npaddress,"
				+" WPZL as wpzl,"
				+" DEPTNAME as deptname,"
				+" DEPTSEQ as deptseq,"
				+" WUPINXH as wupinxh,"
				+" SHOUGOURQ as shougourq"
				+" from V_CSRXX_STA ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from V_CSRXX_STA where IDCARD=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where IDCARD=? ";
	}
	
	public void save(VcsrxxSta entity) {
		String sql = "insert into V_CSRXX_STA " 
			 + " (IDCARD,CSRXM,CPCODE,NPCODE,NPADDRESS,WUPINLB,CALLED,WPZL,DEPTNAME,DEPTSEQ,WUPINXH,SHOUGOURQ) " 
			 + " values "
			 + " (:idcard,:csrxm,:cpcode,:npcode,:npaddress,:wupinlb,:called,:wpzl,:deptname,:deptseq,:wupinxh,:shougourq)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_CSRXX_STA",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(VcsrxxSta entity) {
		String sql = "update V_CSRXX_STA set "
					+ " IDCARD=:idcard,CSRXM=:csrxm,CPCODE=:cpcode,NPCODE=:npcode,NPADDRESS=:npaddress,WUPINLB=:wupinlb,CALLED=:called,WPZL=:wpzl,DEPTNAME=:deptname,DEPTSEQ=:deptseq,WUPINXH=:wupinxh,SHOUGOURQ=:shougourq "
					+ " where IDCARD=:idcard";
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
				+ "/~ and t.CSRXM = '[csrxm]' ~/"
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.NPCODE = '[npcode]' ~/"
				+ "/~ and t.NPADDRESS = '[npaddress]' ~/"
				+ "/~ and t.WPZL = '[wpzl]' ~/"
				+ "/~ and t.DEPTNAME = '[deptname]' ~/"
				+ "/~ and t.DEPTSEQ like '[deptseq]%' ~/"
				+ "/~ and t.WUPINXH = '[wupinxh]' ~/"
				+ "/~ and t.SHOUGOURQ = '[shougourq]' ~/"
				+ "/~ and t.IDCARD = '[idcard]' ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  shougourq desc ";
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
	
	
	private String createSql = "insert into V_CSRXX_STA " 
		 + " (IDCARD,CSRXM,CPCODE,NPCODE,NPADDRESS,WUPINLB,CALLED,WPZL,DEPTNAME,DEPTSEQ,WUPINXH,SHOUGOURQ) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update V_CSRXX_STA set "
		+ " IDCARD=?,CSRXM=?,CPCODE=?,NPCODE=?,NPADDRESS=?,WUPINLB=?,CALLED=?,WPZL=?,DEPTNAME=?,DEPTSEQ=?,WUPINXH=?,SHOUGOURQ=? "
		+ " where IDCARD=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final VcsrxxSta entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getIdcard());
						ps.setString(2, entity.getCsrxm());
						ps.setString(3, entity.getCpcode());
						ps.setString(4, entity.getNpcode());
						ps.setString(5, entity.getNpaddress());
						ps.setString(6, entity.getWupinlb());
						ps.setString(7, entity.getCalled());
						ps.setString(8, entity.getWpzl());
						ps.setString(9, entity.getDeptname());
						ps.setString(10, entity.getDeptseq());
						ps.setString(11, entity.getWupinxh());
						ps.setString(12, entity.getShougourq());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createVcsrxxSta(final VcsrxxSta entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getIdcard());
				ps.setString(2, entity.getCsrxm());
				ps.setString(3, entity.getCpcode());
				ps.setString(4, entity.getNpcode());
				ps.setString(5, entity.getNpaddress());
				ps.setString(6, entity.getWupinlb());
				ps.setString(7, entity.getCalled());
				ps.setString(8, entity.getWpzl());
				ps.setString(9, entity.getDeptname());
				ps.setString(10, entity.getDeptseq());
				ps.setString(11, entity.getWupinxh());
				ps.setString(12, entity.getShougourq());
			}
		});
	}

	
	public void updateVcsrxxSta(final VcsrxxSta entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getIdcard());
				ps.setString(2, entity.getCsrxm());
				ps.setString(3, entity.getCpcode());
				ps.setString(4, entity.getNpcode());
				ps.setString(5, entity.getNpaddress());
				ps.setString(6, entity.getWupinlb());
				ps.setString(7, entity.getCalled());
				ps.setString(8, entity.getWpzl());
				ps.setString(9, entity.getDeptname());
				ps.setString(10, entity.getDeptseq());
				ps.setString(11, entity.getWupinxh());
				ps.setString(12, entity.getShougourq());
			}
		});
	}

	
	public void deleteVcsrxxSta(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public Object getXML(String sql){
		   //使用 Object execute(String callString, CallableStatementCallback action)接口
		 return getJdbcTemplate().execute(sql,new CallableStatementCallback(){
		    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		    	cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
		        cs.execute();
		        ResultSet rst =(ResultSet)cs.getObject(1);
		        ArrayList list = new ArrayList();
		        while (rst.next()) {
		        	Map results = new HashMap();
	                for (int j = 1; j <= rst.getMetaData().getColumnCount(); j++) {
	                    String key = rst.getMetaData().getColumnName(j)
	                            .toLowerCase();
	                    String value = rst.getString(j);	                   
	                    if (value == null) {
	                        // 为空则加入空字符串z
	                        value = "";
	                    }
	                    results.put(key, value);
	                }
	                list.add(results);
	            }
				return list;
		    } 
		   });
	
	}
	

}
