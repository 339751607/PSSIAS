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

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TfjycpCheckDao extends BaseSpringJdbcDao<TfjycpCheck,java.lang.String>{
	
	public Class getEntityClass() {
		return TfjycpCheck.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.ID as id,"
				+" t.CPCODE as cpcode,"
				+" t.IDCARD as idcard,"
				+" t.CONTENT as content,"
				+" t.CHECKDATE as checkdate,"
				+" t.CHECKTYPE as checktype,"
				+" m.policeno as policeno,"
				+" m.fullname as fullname, "
				+" d.deptname as deptname, "
				+" f.deptname as pcsname, "
				+" t.empcode as empcode, "
				+" e.empname as empname"
				+" from T_FJYCP_CHECK t,t_check_employee m ,ss_dept d,t_employee e,ss_dept f ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_FJYCP_CHECK where t.ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where t.idcard=m.idcard and t.cpcode=d.deptid and t.empcode=e.empcode(+)  and d.parentid=f.deptid(+) and t.ID=? and t.checktype=?  ";
	}
	
	public void save(TfjycpCheck entity) {
		String sql = "insert into T_FJYCP_CHECK " 
			 + " (ID,CPCODE,IDCARD,CONTENT,CHECKDATE,CHECKTYPE,empcode) " 
			 + " values "
			 + " (:id,:cpcode,:idcard,:content,:checkdate,:checktype,:empcode)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
//		insertWithOracleSequence(entity,"SEQ_T_FJYCP_CHECK",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TfjycpCheck entity) {
		String sql = "update T_FJYCP_CHECK set "
					+ " ID=:id,CPCODE=:cpcode,IDCARD=:idcard,CONTENT=:content,CHECKDATE=:checkdate,CHECKTYPE=:checktype,empcode=:empcode "
					+ " where t.ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
//	public TfjycpCheck getById(String id){
//		TfjycpCheck TfjycpCheck=(TfjycpCheck)getSimpleJdbcTemplate().queryForObject(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {id});
//		return TfjycpCheck;
//	}
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + "  where  t.idcard=m.idcard(+) and t.cpcode=d.deptid(+) and t.empcode=e.empcode(+) and d.parentid=f.deptid(+)"
				+ "/~ and t.IDCARD like '%'||{idcard}||'%'  ~/"
				+ "/~ and t.CONTENT like '%'||{content}||'%' ~/"
				+ "/~ and t.CHECKDATE >= ''||{checkdateBeginFormat}||'' ~/"
				+ "/~ and t.CHECKDATE <= ''||{checkdateEndFormat}||'' ~/"
				+ "/~ and t.CHECKTYPE = {checktype} ~/"
				+ "/~ and m.fullname like '%'||{fullname}||'%'  ~/"
				+ "/~ and m.policeno like '%'||{policeno}||'%'  ~/"
				+ "/~ and m.emptype = {emptype} ~/"
				+ "/~ and d.deptname like '%'||{deptname}||'%'  ~/"
				+ "/~ and t.empcode = ''||{empcode}||''  ~/"
				+ "/~ and d.deptseq like  {deptseq}||'%'  ~/"
				+ "/~ and d.deptseq like  {orgseq}||'%'  ~/"
				+ "/~ and t.cpcode =  {cpcode}  ~/"
				+ "/~ and e.empname like '%'||{empname}||'%'  ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  t.CHECKDATE,id desc ";
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
	
	
	private String createSql = "insert into T_FJYCP_CHECK " 
		 + " (ID,CPCODE,IDCARD,CONTENT,CHECKDATE,CHECKTYPE,empcode) " 
		 + " values "
		 + " (?,?,?,?,?,?,?)";
	private String updateSql = "update T_FJYCP_CHECK set "
		+ " ID=?,CPCODE=?,IDCARD=?,CONTENT=?,CHECKDATE=?,CHECKTYPE=? ,empcode=?"
		+ " where t.ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TfjycpCheck entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getCpcode());
						ps.setString(3, entity.getIdcard());
						ps.setString(4, entity.getContent());
						ps.setString(5, entity.getCheckdate());
						ps.setString(6, entity.getChecktype());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTfjycpCheck(final TfjycpCheck entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getCpcode());
				ps.setString(3, entity.getIdcard());
				ps.setString(4, entity.getContent());
				ps.setString(5, entity.getCheckdate());
				ps.setString(6, entity.getChecktype());
			}
		});
	}

	
	public void updateTfjycpCheck(final TfjycpCheck entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getCpcode());
				ps.setString(3, entity.getIdcard());
				ps.setString(4, entity.getContent());
				ps.setString(5, entity.getCheckdate());
				ps.setString(6, entity.getChecktype());
			}
		});
	}

	
	public void deleteTfjycpCheck(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public TfjycpCheck getById(String id,String t_checktype){
		String sql=getSelectPrefix()+" where t.idcard=m.idcard(+) and t.cpcode=d.deptid(+) and t.empcode=e.empcode(+) and d.parentid=f.deptid(+) and t.ID='"+id+"' and t.checktype='"+t_checktype+"'";
		
		TfjycpCheck tfjycpCheck = null;
			try {   
				tfjycpCheck = (TfjycpCheck)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {});
			} 
			catch (EmptyResultDataAccessException ex) {   
				           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
			} 
		return tfjycpCheck;
	}
	public int getByIdcard(String idcard,String emptype){
		String sql=" select count(*) from t_check_employee t where t.idcard=? and t.emptype= ?";
		//System.out.println(sql+"*******");
		return getSimpleJdbcTemplate().queryForInt(sql, new Object[]{idcard,emptype});
	}

}
