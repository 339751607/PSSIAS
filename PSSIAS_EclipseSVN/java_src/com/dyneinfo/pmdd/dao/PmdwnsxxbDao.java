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
import java.sql.SQLException;
import java.util.List;

import net.java.dev.common.util.SpringTagFunctions;

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

import com.dyneinfo.pmdd.dao.*;
import com.dyneinfo.pmdd.model.*;
import com.dyneinfo.pmdd.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class PmdwnsxxbDao<E,PK extends Serializable> extends BaseSpringJdbcDao<Pmdwnsxxb,java.lang.String>{
	
	public Class getEntityClass() {
		return Pmdwnsxxb.class;
	}
	
	public String getIdentifierPropertyName() {
		return "dwbm";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.TIB_FLOWGUID as tibFlowguid,"
				+" t.TIB_ROWGUID as tibRowguid,"
				+" t.DWBM as dwbm,"
				+" t.NSND as nsnd,"
				+" t.TH_TYPE as thType,"
				+" t.NSRQ as nsrq,"
				+" t.NSJG as nsjg,"
				+" t.NSYJ as nsyj,"
				+" t.NSYJQSR as nsyjqsr,"
				+" t.NSYJJBR as nsyjjbr,"
				+" b.DWMC as dwmc"
				+" from PMDWNSXXB t, PMDWXXB b"
				+" where t.DWBM=b.DWBM ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from PMDWNSXXB where DWBM=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return "select  "
		+" t.TIB_FLOWGUID as tibFlowguid,"
		+" t.TIB_ROWGUID as tibRowguid,"
		+" t.DWBM as dwbm,"
		+" t.NSND as nsnd,"
		+" t.TH_TYPE as thType,"
		+" t.NSRQ as nsrq,"
		+" t.NSJG as nsjg,"
		+" t.NSYJ as nsyj,"
		+" t.NSYJQSR as nsyjqsr,"
		+" t.NSYJJBR as nsyjjbr,"
		+" p.dwmc as dwmc "
		+" from PMDWNSXXB  t,pmdwxxb p  where t.dwbm=p.dwbm and t.DWBM=? and t.NSND=?";
		//pmdwnsxxb t, pmdwxxb p where t.dwbm=p.dwbm
	}
	
	public void save(Pmdwnsxxb entity) {
		String sql = "insert into PMDWNSXXB " 
			 + " (TIB_FLOWGUID,TIB_ROWGUID,DWBM,NSND,TH_TYPE,NSRQ,NSJG,NSYJ,NSYJQSR,NSYJJBR) " 
			 + " values "
			 + " (:tibFlowguid,:tibRowguid,:dwbm,:nsnd,:thType,:nsrq,:nsjg,:nsyj,:nsyjqsr,:nsyjjbr)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_PMDWNSXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Pmdwnsxxb entity) {
		String sql = "update PMDWNSXXB set "
					+ " TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,DWBM=:dwbm,NSND=:nsnd,TH_TYPE=:thType,NSRQ=:nsrq,NSJG=:nsjg,NSYJ=:nsyj,NSYJQSR=:nsyjqsr,NSYJJBR=:nsyjjbr "
					+ " where DWBM=:dwbm";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;	
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String PreSql = "select  "
			+" t.TIB_FLOWGUID as tibFlowguid,"
			+" t.TIB_ROWGUID as tibRowguid,"
			+" t.DWBM as dwbm,"
			+" t.NSND as nsnd,"
			+" t.TH_TYPE as thType,"
			+" t.NSRQ as nsrq,"
			+" t.NSJG as nsjg,"
			+" t.NSYJ as nsyj,"
			+" t.NSYJQSR as nsyjqsr,"
			+" t.NSYJJBR as nsyjjbr,"
			+" b.DWMC as dwmc"
			+" from PMDWNSXXB t, PMDWXXB b,ss_dept c"
			+" where t.DWBM=b.DWBM and t.DWBM = c.deptid(+)  ";
		
		String sql = PreSql
				+ "/~ and t.DWBM = '[deptid]' ~/"
		  		+ "/~ and t.DWBM in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.NSND = '[nsnd]' ~/"
				+ "/~ and t.TH_TYPE = '[thType]' ~/"
				+ "/~ and t.NSRQ = '[nsrq]' ~/"
				+ "/~ and t.NSJG = '[nsjg]' ~/"
				+ "/~ and t.NSYJ = '[nsyj]' ~/"
				+ "/~ and t.NSYJQSR = '[nsyjqsr]' ~/"
				+ "/~ and t.NSYJJBR = '[nsyjjbr]' ~/"
				+ "/~ and b.DWMC like '%[dwmc]%' ~/"
				+ "/~ and b.PCSDM = '[pcsdm]' ~/"
				+ "/~ and b.FJDM = '[fjdm]' ~/"
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
	public List findDwbm(String deptId,String chDeptId){
		String hsql="";
		if(chDeptId!=null){
			hsql="and DWBM in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%."+chDeptId+".%' )";
		}
		if(deptId!=null){
			hsql="and DWBM ='"+deptId+"'";
		}
		String sql = " select DWBM,DWMC from PMDWXXB where DWBM not in "
				+ " (select DWBM from PMDWNSXXB where NSND = (select to_char(sysdate,'yyyy') as year from dual) and nsjg = '1') "
				+ hsql;
		return 	this.getJdbcTemplate().queryForList(sql);
	}
	
	//	检查单位编码是否存在
	public int getFindCountById(String dwbm,String nsnd) {
		String sql = "select count(DWBM) from PMDWNSXXB  where DWBM=? and NSND=? ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {dwbm,nsnd} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	public E getById(PK id,String nsnd) {
		List list = getSimpleJdbcTemplate().query(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[]{id,nsnd});
		return (E)CollectionHelper.findSingleObject(list);
	}

	
	private String createSql = "insert into PMDWNSXXB " 
		 + " (TIB_FLOWGUID,TIB_ROWGUID,DWBM,NSND,TH_TYPE,NSRQ,NSJG,NSYJ,NSYJQSR,NSYJJBR) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update PMDWNSXXB set "
		+ " TIB_FLOWGUID=?,TIB_ROWGUID=?,DWBM=?,NSND=?,TH_TYPE=?,NSRQ=?,NSJG=?,NSYJ=?,NSYJQSR=?,NSYJJBR=? "
		+ " where DWBM=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Pmdwnsxxb entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getTibFlowguid());
						ps.setString(2, entity.getTibRowguid());
						ps.setString(3, entity.getDwbm());
						ps.setString(4, entity.getNsnd());
						ps.setString(5, entity.getThType());
						ps.setString(6, entity.getNsrq());
						ps.setString(7, entity.getNsjg());
						ps.setString(8, entity.getNsyj());
						ps.setString(9, entity.getNsyjqsr());
						ps.setString(10, entity.getNsyjjbr());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createPmdwnsxxb(final Pmdwnsxxb entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getDwbm());
				ps.setString(4, entity.getNsnd());
				ps.setString(5, entity.getThType());
				ps.setString(6, entity.getNsrq());
				ps.setString(7, entity.getNsjg());
				ps.setString(8, entity.getNsyj());
				ps.setString(9, entity.getNsyjqsr());
				ps.setString(10, entity.getNsyjjbr());
			}
		});
	}

	
	public void updatePmdwnsxxb(final Pmdwnsxxb entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getTibFlowguid());
				ps.setString(2, entity.getTibRowguid());
				ps.setString(3, entity.getDwbm());
				ps.setString(4, entity.getNsnd());
				ps.setString(5, entity.getThType());
				ps.setString(6, entity.getNsrq());
				ps.setString(7, entity.getNsjg());
				ps.setString(8, entity.getNsyj());
				ps.setString(9, entity.getNsyjqsr());
				ps.setString(10, entity.getNsyjjbr());
			}
		});
	}

	
	public void deletePmdwnsxxb(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
