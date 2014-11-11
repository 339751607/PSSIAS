/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.jxy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.jxy.model.SDictitem;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class DictitemDao<E> extends BaseSpringJdbcDao<SDictitem,java.lang.String>{
	
	public Class getEntityClass() {
		return SDictitem.class;
	}
	
	public String getIdentifierPropertyName() {
		return null;
	}
	
	public List getByParentId(String id){
		String sql=getSelectPrefix()+"  where dicttypeid='teHangDwbm' and status='1' and dictlevel=3 and substr(dictid,0,6)= substr(?,0,6)";
		
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{id});
	}
	public List getEmployeeById(String id){
		String sql=" select t.cpempcode as code,t.name as name from t_employee t where t.cyrjzt = '0' and  t.cpcode= ? ";
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{id});
	}
	public List getEmpnameByCode(String code ){
		String sql=" select t.name as name from t_employee t where t.cyrjzt = '0' and  t.cpempcode= ? ";
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{code });
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" DICTTYPEID as dicttypeid,"
				+" DICTID as dictid,"
				+" DICTNAME as dictname,"
				+" STATUS as status,"
				+" SORTNO as sortno,"
				+" DICTLEVEL as dictlevel,"
				+" PARENTID as parentid,"
				+" SEQNO as seqno"
				+" from SS_DICT_ITEM ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_DICT_ITEM where DICTTYPEID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where DICTTYPEID=? ";
	}
	
	public void save(SDictitem entity) {
		String sql = "insert into SS_DICT_ITEM " 
			 + " (DICTTYPEID,DICTID,DICTNAME,STATUS,SORTNO,DICTLEVEL,PARENTID,SEQNO) " 
			 + " values "
			 + " (:dicttypeid,:dictid,:dictname,:status,:sortno,:dictlevel,:parentid,:seqno)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_DICT_ITEM",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SDictitem entity) {
		String sql = "update SS_DICT_ITEM set "
					+ " DICTTYPEID=:dicttypeid,DICTID=:dictid,DICTNAME=:dictname,STATUS=:status,SORTNO=:sortno,DICTLEVEL=:dictlevel,PARENTID=:parentid,SEQNO=:seqno "
					+ " where DICTTYPEID=:dicttypeid";
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
				+ "/~ and t.DICTNAME = '[dictname]' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.SORTNO = '[sortno]' ~/"
				+ "/~ and t.DICTLEVEL = '[dictlevel]' ~/"
				+ "/~ and t.PARENTID = '[parentid]' ~/"
				+ "/~ and t.SEQNO = '[seqno]' ~/"
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
	
	
	private String createSql = "insert into SS_DICT_ITEM " 
		 + " (DICTTYPEID,DICTID,DICTNAME,STATUS,SORTNO,DICTLEVEL,PARENTID,SEQNO) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?)";
	private String updateSql = "update SS_DICT_ITEM set "
		+ " DICTTYPEID=?,DICTID=?,DICTNAME=?,STATUS=?,SORTNO=?,DICTLEVEL=?,PARENTID=?,SEQNO=? "
		+ " where DICTTYPEID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final SDictitem entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getDicttypeid());
						ps.setString(2, entity.getDictid());
						ps.setString(3, entity.getDictname());
						ps.setLong(4, entity.getStatus());
						ps.setLong(5, entity.getSortno());
						ps.setLong(6, entity.getDictlevel());
						ps.setString(7, entity.getParentid());
						ps.setString(8, entity.getSeqno());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createDictitem(final SDictitem entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDicttypeid());
				ps.setString(2, entity.getDictid());
				ps.setString(3, entity.getDictname());
				ps.setLong(4, entity.getStatus());
				ps.setLong(5, entity.getSortno());
				ps.setLong(6, entity.getDictlevel());
				ps.setString(7, entity.getParentid());
				ps.setString(8, entity.getSeqno());
			}
		});
	}

	
	public void updateDictitem(final SDictitem entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getDicttypeid());
				ps.setString(2, entity.getDictid());
				ps.setString(3, entity.getDictname());
				ps.setLong(4, entity.getStatus());
				ps.setLong(5, entity.getSortno());
				ps.setLong(6, entity.getDictlevel());
				ps.setString(7, entity.getParentid());
				ps.setString(8, entity.getSeqno());
			}
		});
	}

	
	public void deleteDictitem(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
