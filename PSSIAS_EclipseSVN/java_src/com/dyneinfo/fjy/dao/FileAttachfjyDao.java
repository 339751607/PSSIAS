/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.fjy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class FileAttachfjyDao extends BaseSpringJdbcDao<FileAttach, Long> {

	public Class getEntityClass() {
		return FileAttach.class;
	}

	public String getIdentifierPropertyName() {
		return "fileid";
	}

	public String getSelectPrefix() {
		return "select  " + " FILEID as fileid," + " FILENAME as filename,"
				+ " CONTENTTYPE as contenttype," + " FILESIZE as filesize,"
				+ " FILEEXT as fileext," + " FILE_SAVE as fileSave,"
				+ " CONTENT as content," + " FILEPATH as filepath,"
				+ " ABSOLUTEPATH as absolutepath," + " FILEGROUP as filegroup,"
				+ " RELATION_ID as relationId," + " NOTE as note,"
				+ " CREATETIME as createtime," + " CREATOR as creator"
				+ " from FILE_ATTACH ";
	}

	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from FILE_ATTACH where FILEID=?";
	}

	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where FILEID=? ";
	}

	public void save(FileAttach entity) {
		String sql = "insert into FILE_ATTACH "
				+ " (FILEID,FILENAME,CONTENTTYPE,FILESIZE,FILEEXT,FILE_SAVE,FILEPATH,ABSOLUTEPATH,FILEGROUP,RELATION_ID,NOTE,CREATETIME,CREATOR) "
				+ " values "
				+ " (:fileid,:filename,:contenttype,:filesize,:fileext,:fileSave,:filepath,:absolutepath,:filegroup,:relationId,:note,:createtime,:creator)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		insertWithOracleSequence(entity, "SEQ_FILE_ATTACH", sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}

	public void update(FileAttach entity) {
		String sql = "update FILE_ATTACH set "
				+ " FILENAME=:filename,CONTENTTYPE=:contenttype,FILESIZE=:filesize,FILEEXT=:fileext,FILE_SAVE=:fileSave,FILEPATH=:filepath,ABSOLUTEPATH=:absolutepath,FILEGROUP=:filegroup,RELATION_ID=:relationId,NOTE=:note,CREATETIME=:createtime,CREATOR=:creator "
				+ " where FILEID=:fileid";
		getNamedParameterJdbcTemplate().update(sql,
				new BeanPropertySqlParameterSource(entity));
	}

	public List findAll() {
		String sql = getSelectPrefix();
		return getSimpleJdbcTemplate().query(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.FILENAME = '[filename]' ~/"
				+ "/~ and t.CONTENTTYPE = '[contenttype]' ~/"
				+ "/~ and t.FILESIZE = '[filesize]' ~/"
				+ "/~ and t.FILEEXT = '[fileext]' ~/"
				+ "/~ and t.FILE_SAVE = '[fileSave]' ~/"
				+ "/~ and t.CONTENT = '[content]' ~/"
				+ "/~ and t.FILEPATH = '[filepath]' ~/"
				+ "/~ and t.ABSOLUTEPATH = '[absolutepath]' ~/"
				+ "/~ and t.FILEGROUP = '[filegroup]' ~/"
				+ "/~ and t.RELATION_ID = '[relationId]' ~/"
				+ "/~ and t.NOTE = '[note]' ~/"
				+ "/~ and t.CREATETIME = '[createtime]' ~/"
				+ "/~ and t.CREATOR = '[creator]' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql, pageRequest);
	}

	public String getCurrentMax(String sql, String arg)
			throws DataAccessException {
		String currentMaxID = "";
		//String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj = { arg };
		try {
			currentMaxID = (String) this.getJdbcTemplate().queryForObject(sql,
					obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}

	public void removebyPath(String ABSOLUTEPATH) {
		String sql = "delete from FILE_ATTACH  where ABSOLUTEPATH  =:filepath and FILE_SAVE = 'F' and FILEGROUP = 'SS_USER' ";
		Map namedParameters = new HashMap();
		namedParameters.put("filepath", ABSOLUTEPATH);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	public void removebyFileID(java.lang.String FILEID,String sqlWhere) {
		String sql = "delete from FILE_ATTACH where FILEID=? ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		getJdbcTemplate().update(sql, new Object[] {FILEID});
	}
	


	private String createSql = "insert into FILE_ATTACH "
			+ " (FILEID,FILENAME,CONTENTTYPE,FILESIZE,FILEEXT,FILE_SAVE,CONTENT,FILEPATH,ABSOLUTEPATH,FILEGROUP,RELATION_ID,NOTE,CREATETIME,CREATOR) "
			+ " values " + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update FILE_ATTACH set "
			+ " FILENAME=?,CONTENTTYPE=?,FILESIZE=?,FILEEXT=?," +
			" FILE_SAVE=?,CONTENT=?,FILEPATH=?,ABSOLUTEPATH=?," +
			" FILEGROUP=?,RELATION_ID=?,NOTE=?,CREATETIME=?,CREATOR=? "+
			" where FILEID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
	//保存图片
	public void savePic(File file, final FileAttach entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getFileid());
						ps.setString(2, entity.getFilename());
						ps.setString(3, entity.getContenttype());
						ps.setInt(4, entity.getFilesize());
						ps.setString(5, entity.getFileext());
						ps.setString(6, entity.getFileSave());
						//ps.setjava.sql.Blob(7, entity.getContent());
						ps.setString(8, entity.getFilepath());
						ps.setString(9, entity.getAbsolutepath());
						ps.setString(10, entity.getFilegroup());
						ps.setString(11, entity.getRelationId());
						ps.setString(12, entity.getNote());
						ps.setDate(13, entity.getCreatetimeSql());
						ps.setString(14, entity.getCreator());
						lobCreator.setBlobAsBinaryStream(ps, 7, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	//修改图片
	public void updatePic(File file,final FileAttach entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(updateSql, new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
			public void setValues(PreparedStatement ps,LobCreator lobCreator) throws SQLException {
				ps.setString(1, entity.getFilename());
				ps.setString(2, entity.getContenttype());
				ps.setLong(3, entity.getFilesize());
				ps.setString(4, entity.getFileext());
				ps.setString(5, entity.getFileSave());
				lobCreator.setBlobAsBinaryStream(ps, 6, blobIs,(int) blobIn.length());
				ps.setString(7, entity.getFilepath());
				ps.setString(8, entity.getAbsolutepath());
				ps.setString(9, entity.getFilegroup());
				ps.setString(10, entity.getRelationId());
				ps.setString(11, entity.getNote());
				ps.setDate(12, entity.getCreatetimeSql());
				ps.setString(13, entity.getCreator());
				ps.setLong(14, entity.getFileid());
			}
		});
		blobIs.close();
	}

	//修改图片
	public void updatePic(File file,final String FILENAME,final String CONTENTTYPE,
			final Long FILESIZE,final String FILEEXT,
			  final String FILEID,String sqlWhere) throws IOException {
		//final File blobIn = new File("spring2004.jpg");
		String updatePicSql = " update FILE_ATTACH set  FILENAME=?,CONTENTTYPE=?,FILESIZE=?,FILEEXT=?," +
		" CONTENT =?  where FILEID = ?   ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			updatePicSql = updatePicSql + sqlWhere;
		
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		//		final File clobIn = new File("large.txt");
		//		final InputStream clobIs = new FileInputStream(clobIn);
		//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(updatePicSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, FILENAME);
						ps.setString(2, CONTENTTYPE);
						ps.setLong(3, FILESIZE);
						ps.setString(4, FILEEXT);
						//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
						lobCreator.setBlobAsBinaryStream(ps, 5, blobIs,(int) blobIn.length());
						ps.setString(6, FILEID);
						
					}
				});
		blobIs.close();
		//clobReader.close();
	}
	//取得照片
	public List getPic(final String FILE_SAVE,final String FILEGROUP,final String RELATION_ID,String sqlWhere) {
		String sql = "select FILEID,FILENAME,CONTENTTYPE from FILE_ATTACH " +"where FILE_SAVE = ?  and FILEGROUP = ? and RELATION_ID = ?  ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return getJdbcTemplate().query(sql, new String[] { FILE_SAVE,FILEGROUP,RELATION_ID },
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						String FILEID = rs.getString("FILEID");
						String FILENAME = rs.getString("FILENAME");
						String CONTENTTYPE = rs.getString("CONTENTTYPE");
						System.out.println("123456789===================="+FILEID);
						results.put("FILEID", FILEID);
						results.put("FILENAME", FILENAME);
						results.put("CONTENTTYPE", CONTENTTYPE);
						results.put("FILE_SAVE", FILE_SAVE);
						results.put("FILEGROUP", FILEGROUP);
						results.put("RELATION_ID", RELATION_ID);
						return results;
					}

				});
	}
	public List getPicContent(final String FILEID,String sqlWhere) {
		String sql = "select FILEID,FILENAME,CONTENTTYPE,CONTENT,FILE_SAVE,FILEGROUP,RELATION_ID from FILE_ATTACH " +
				"where FILEID = ?  ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return getJdbcTemplate().query(sql, new String[] { FILEID },
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						//  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
						//  results.put("PICTURE", clobText);
						String FILEID = rs.getString("FILEID");
						String FILENAME = rs.getString("FILENAME");
						String CONTENTTYPE = rs.getString("CONTENTTYPE");
						
						byte[] blobBytes = lobhandler.getBlobAsBytes(rs,"CONTENT");
						String FILE_SAVE = rs.getString("FILE_SAVE");
						String FILEGROUP = rs.getString("FILEGROUP");
						String RELATION_ID = rs.getString("RELATION_ID");
						if (blobBytes == null)
							results.put("FlAG", "0");
						else
							results.put("FlAG", "1");
						results.put("CONTENT", blobBytes);
						results.put("FILEID", FILEID);
						results.put("FILENAME", FILENAME);
						results.put("CONTENTTYPE", CONTENTTYPE);
						results.put("FILE_SAVE", FILE_SAVE);
						results.put("FILEGROUP", FILEGROUP);
						results.put("RELATION_ID", RELATION_ID);
						return results;
					}

				});
	}
	
	
	public void saveWebcamFile(byte[] blobBytes, final FileAttach entity) throws IOException {
		final byte[] bPhoto = blobBytes;
		//final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getFileid());
						ps.setString(2, entity.getFilename());
						ps.setString(3, entity.getContenttype());
						ps.setInt(4, entity.getFilesize());
						ps.setString(5, entity.getFileext());
						ps.setString(6, entity.getFileSave());
						//ps.setjava.sql.Blob(7, entity.getContent());
						ps.setString(8, entity.getFilepath());
						ps.setString(9, entity.getAbsolutepath());
						ps.setString(10, entity.getFilegroup());
						ps.setString(11, entity.getRelationId());
						ps.setString(12, entity.getNote());
						ps.setDate(13, entity.getCreatetimeSql());
						ps.setString(14, entity.getCreator());
						//lobCreator.setBlobAsBinaryStream(ps, 7, blobIs,(int) blobIn.length());
						lobCreator.setBlobAsBytes(ps,7,bPhoto);  
					}
				});
		//blobIs.close();
	}
	
	//保存附件
	public void saveFile(File file, final FileAttach entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getFileid());
						ps.setString(2, entity.getFilename());
						ps.setString(3, entity.getContenttype());
						ps.setInt(4, entity.getFilesize());
						ps.setString(5, entity.getFileext());
						ps.setString(6, entity.getFileSave());
						//ps.setjava.sql.Blob(7, entity.getContent());
						ps.setString(8, entity.getFilepath());
						ps.setString(9, entity.getAbsolutepath());
						ps.setString(10, entity.getFilegroup());
						ps.setString(11, entity.getRelationId());
						ps.setString(12, entity.getNote());
						ps.setDate(13, entity.getCreatetimeSql());
						ps.setString(14, entity.getCreator());
						lobCreator.setBlobAsBinaryStream(ps, 7, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	//修改附件
	public void updateFile(File file,final FileAttach entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(updateSql, new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
			public void setValues(PreparedStatement ps,LobCreator lobCreator) throws SQLException {
				ps.setString(1, entity.getFilename());
				ps.setString(2, entity.getContenttype());
				ps.setLong(3, entity.getFilesize());
				ps.setString(4, entity.getFileext());
				ps.setString(5, entity.getFileSave());
				lobCreator.setBlobAsBinaryStream(ps, 6, blobIs,(int) blobIn.length());
				ps.setString(7, entity.getFilepath());
				ps.setString(8, entity.getAbsolutepath());
				ps.setString(9, entity.getFilegroup());
				ps.setString(10, entity.getRelationId());
				ps.setString(11, entity.getNote());
				ps.setDate(12, entity.getCreatetimeSql());
				ps.setString(13, entity.getCreator());
				ps.setLong(14, entity.getFileid());
			}
		});
		blobIs.close();
	}

	//修改附件
	public void updateFile(File file,final String FILENAME,final String CONTENTTYPE,
			final Long FILESIZE,final String FILEEXT,
			  final String FILEID,String sqlWhere) throws IOException {
		String sql = " update FILE_ATTACH set  FILENAME=?,CONTENTTYPE=?,FILESIZE=?,FILEEXT=?," +
		" CONTENT =?  where FILEID = ?   ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		//		final File clobIn = new File("large.txt");
		//		final InputStream clobIs = new FileInputStream(clobIn);
		//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(sql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, FILENAME);
						ps.setString(2, CONTENTTYPE);
						ps.setLong(3, FILESIZE);
						ps.setString(4, FILEEXT);
						//  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
						lobCreator.setBlobAsBinaryStream(ps, 5, blobIs,(int) blobIn.length());
						ps.setString(6, FILEID);
						
						
					}
				});
		blobIs.close();
		//clobReader.close();
	}
	//取得附件
	public List getFile(final String FILE_SAVE,final String FILEGROUP,final String RELATION_ID,String sqlWhere) {
		String sql = "select FILEID,FILENAME,CONTENTTYPE from FILE_ATTACH "
				+ " where FILE_SAVE = ?  and FILEGROUP = ? and RELATION_ID = ? ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return getJdbcTemplate().query(sql, new String[] { FILE_SAVE, FILEGROUP,RELATION_ID},
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						// String clobText = lobhandler.getClobAsString(rs,
						// "PICTURE");
						// results.put("PICTURE", clobText);
						String FILEID = rs.getString("FILEID");
						String FILENAME = rs.getString("FILENAME");
						String CONTENTTYPE = rs.getString("CONTENTTYPE");
						// byte[] blobBytes = lobhandler.getBlobAsBytes(rs,
						// "FILECONTENT");
						// results.put("FILECONTENT", blobBytes);
						results.put("FILEID", FILEID);
						results.put("FILENAME", FILENAME);
						results.put("CONTENTTYPE", CONTENTTYPE);
						return results;
					}
				});
	}
	
	//取得附件
	public List getFileContent(final String FILEID,String sqlWhere) {
		String sql = "select FILEID,FILENAME,CONTENTTYPE,CONTENT,FILE_SAVE,FILEGROUP,RELATION_ID  from FILE_ATTACH " +
				" where FILEID = ?   ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return getJdbcTemplate().query(sql, new String[] { FILEID },
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Map results = new HashMap();
						//  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
						//  results.put("PICTURE", clobText);
						String FILEID = rs.getString("FILEID");
						String FILENAME = rs.getString("FILENAME");
						String CONTENTTYPE = rs.getString("CONTENTTYPE");
						String FILE_SAVE = rs.getString("FILE_SAVE");
						String FILEGROUP = rs.getString("FILEGROUP");
						String RELATION_ID = rs.getString("RELATION_ID");
						// InputStream
						//Reader reader = lobhandler.getClobAsCharacterStream(rs,"CONTENT");
						  byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "CONTENT");            
						results.put("CONTENT", blobBytes);
						results.put("FILEID", FILEID);
						results.put("FILENAME", FILENAME);
						results.put("CONTENTTYPE", CONTENTTYPE);
						results.put("FILE_SAVE", FILE_SAVE);
						results.put("FILEGROUP", FILEGROUP);
						results.put("RELATION_ID", RELATION_ID);

						return results;
					}

				});
	}
	
	public List getFile(String FILEID,String sqlWhere) {
		String sql = "select FILEID,FILENAME,CONTENTTYPE,FILEEXT from FILE_ATTACH  where FILEID = ? ";
		if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
	       return getJdbcTemplate().query(sql, new String[] {FILEID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      
	        	    String FILEID = rs.getString("FILEID");
					String FILENAME = rs.getString("FILENAME");
					String CONTENTTYPE = rs.getString("CONTENTTYPE");
					String FILEEXT = rs.getString("FILEEXT");
	        	  
					results.put("FILEID", FILEID);
					results.put("FILENAME", FILENAME);
					results.put("CONTENTTYPE", CONTENTTYPE);
					results.put("FILEEXT", FILEEXT);
			        
			        return results;
	           }
	           
	       });
	   }
	
	
	
    public Object getFileDownloadByte(final String FILEID,String sqlWhere) {
    	String sql = "select CONTENT from FILE_ATTACH where FILEID =? ";
    	if(sqlWhere != null && sqlWhere.length() > 0)
			sql = sql + sqlWhere;
		return this.getJdbcTemplate().execute(sql,
				new PreparedStatementCallback() {
					public Object doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, FILEID);
						ResultSet rs = ps.executeQuery();
						if (rs.next()) {
							InputStream inputStream = rs.getBinaryStream("CONTENT");
							try {
								return IOUtils.toByteArray(inputStream);
							} catch (IOException e) {
							}
						}
						return null;
					}
				});
	}
    
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_FILE_ATTACH");
		Long id = seq.nextLongValue();
        return id;
	}

	
	
	
	

}
