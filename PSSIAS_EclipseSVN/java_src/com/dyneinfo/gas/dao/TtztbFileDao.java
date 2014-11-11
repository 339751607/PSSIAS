/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

import com.dyneinfo.gas.model.TtztbFile;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TtztbFileDao extends BaseSpringJdbcDao<TtztbFile,Long>{
	
	public Class getEntityClass() {
		return TtztbFile.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" FILEID as fileid,"
				+" FILECONTENT as filecontent,"
				+" TZTBTYPE as tztbtype,"
				+" FILENAME as filename"
				+" from T_TZTB_FILE ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_TZTB_FILE where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? ";
	}
	
	public void save(TtztbFile entity) {
		String sql = "insert into T_TZTB_FILE " 
			 + " (ID,FILEID,FILECONTENT,TZTBTYPE,FILENAME) " 
			 + " values "
			 + " (:id,:fileid,:filecontent,:tztbtype,:filename)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_TZTB_FILE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TtztbFile entity) {
		String sql = "update T_TZTB_FILE set "
					+ " ID=:id,FILEID=:fileid,FILECONTENT=:filecontent,TZTBTYPE=:tztbtype,FILENAME=:filename "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public void removetztbfile(TtztbFile entity) {
		String sql = "delete from  T_TZTB_FILE  where  "
			+ " FILEID=:fileid and TZTBTYPE=:tztbtype" ;
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
				+ "/~ and t.FILEID = '[fileid]' ~/"
				+ "/~ and t.FILECONTENT = '[filecontent]' ~/"
				+ "/~ and t.TZTBTYPE = '[tztbtype]' ~/"
				+ "/~ and t.FILENAME = '[filename]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_T_TZTB_FILE");
		Long id = seq.nextLongValue();
        return id;
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
	
	
	private String createSql = "insert into T_TZTB_FILE " 
		 + " (ID,FILEID,FILECONTENT,TZTBTYPE,FILENAME) " 
		 + " values "
		 + " (?,?,?,?,?)";
	private String updateSql = "update T_TZTB_FILE set "
		+ " ID=?,FILEID=?,FILECONTENT=?,TZTBTYPE=?,FILENAME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TtztbFile entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getId());
						ps.setLong(2, entity.getFileid());
//						ps.setjava.sql.Blob(3, entity.getFilecontent());
						ps.setString(4, entity.getTztbtype());
						ps.setString(5, entity.getFilename());
						lobCreator.setBlobAsBinaryStream(ps, 3, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	//取得照片
	public List getPic(final String FILEGROUP,final String RELATION_ID,String sqlWhere) {
		String sql = "select id,FILEID,FILENAME,TZTBTYPE from T_TZTB_FILE " +
				"where tztbtype = ?  and FILEID = ?  ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return getJdbcTemplate().query(sql, new String[] {FILEGROUP,RELATION_ID },
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						String FILEID = rs.getString("ID");
						String FILENAME = rs.getString("FILENAME");
						String TZTBTYPE = rs.getString("TZTBTYPE");
						results.put("FILEID", FILEID);
						results.put("FILENAME", FILENAME);
						results.put("TZTBTYPE", TZTBTYPE);
						return results;
					}

				});
	}
	
	
	 public Object getFileDownloadByte(final String FILEID,String sqlWhere) {
	    	String sql = "select FILECONTENT from T_TZTB_FILE where  ID =? ";
	    	if(sqlWhere != null && sqlWhere.length() > 0)
				sql = sql + sqlWhere;
			return this.getJdbcTemplate().execute(sql,
					new PreparedStatementCallback() {
						public Object doInPreparedStatement(PreparedStatement ps)
								throws SQLException, DataAccessException {
							ps.setString(1, FILEID);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								InputStream inputStream = rs.getBinaryStream("FILECONTENT");
								try {
									return IOUtils.toByteArray(inputStream);
								} catch (IOException e) {
								}
							}
							return null;
						}
					});
		}
	 
	
	public void createTtztbFile(final TtztbFile entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getFileid());
//				ps.setjava.sql.Blob(3, entity.getFilecontent());
				ps.setString(4, entity.getTztbtype());
				ps.setString(5, entity.getFilename());
			}
		});
	}

	
	public void updateTtztbFile(final TtztbFile entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getId());
				ps.setLong(2, entity.getFileid());
//				ps.setjava.sql.Blob(3, entity.getFilecontent());
				ps.setString(4, entity.getTztbtype());
				ps.setString(5, entity.getFilename());
			}
		});
	}

	
	public void deleteTtztbFile(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
