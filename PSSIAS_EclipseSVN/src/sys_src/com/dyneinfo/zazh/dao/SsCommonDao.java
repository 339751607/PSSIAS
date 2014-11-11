package com.dyneinfo.zazh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javacommon.base.CustomerContextHolder;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

@Component
public class SsCommonDao extends JdbcDaoSupport {

	public String getCurrentMax(String sql, String arg)
			throws DataAccessException {
		String currentMaxID = "";
		//String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj = { arg };
		try {
			currentMaxID = (String) this.getJdbcTemplate().queryForObject(sql,obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}

	//取得手机品牌代码
	public List getSjpp(String sql) {
		//select *  from T_DIC_SJPP
		return getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String CODE = rs.getString(1);
				String CALLED = rs.getString(2);
				results.put("CODE", CODE);
				results.put("CALLED", CALLED);
				return results;
			}

		});
	}
	
	public int update(String Sql) {
		int totalCount = 0;
		try {
			totalCount = getJdbcTemplate().update(Sql);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	//根据id查中文名
	public List getdeptFullName(String _deptseq){
//		String sql="Select deptname,deptid,deptseq  From ss_dept t "+
//		"where deptid not in ("+DictHelpImpl.getInitData("prcode")+") "+
//		"START WITH deptid = '"+_deptseq+"'"+
//		"CONNECT BY PRIOR parentid = deptid";
		String sql="Select deptname,deptid,deptseq  From ss_dept t where deptid= '"+_deptseq+"'";
		
		return getJdbcTemplate().queryForList(sql, new Object[]{});
	}

	//取得手机型号代码

	public List getSjxh(String sqlwhere) {
		String sql = "select CODE,CALLED,PPCODE from T_DIC_SJXH  ";
		if (sqlwhere != null && sqlwhere.length() > 0)
			sql = sql + sqlwhere;
		return getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String CODE = rs.getString(1);
				String CALLED = rs.getString(2);
				String PPCODE = rs.getString(3);

				results.put("CODE", CODE);
				results.put("CALLED", CALLED);
				results.put("PPCODE", PPCODE);
				return results;
			}

		});
	}
	
	
	//从业人员基本信息 图片id是否存在
	public int getPicIDIsExist(String ID) {
		String sql = "select count(EMPCODE) as   from T_EMPPIC  where EMPCODE = ?  ";
		int totalCount = 0;
		try {
			totalCount = getJdbcTemplate()
					.queryForInt(sql, new Object[] { ID });

		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	
	private LobHandler lobhandler = new DefaultLobHandler();
	//从业人员基本信息 保存图片
	
	public void savePic(File file,Long Length ,String ID) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = ID;
		final Long str_length = Length;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(
		  "INSERT INTO T_EMPPIC (EMPCODE, PIC,PICLEN) VALUES (?, ?,?)",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		        ps.setString(1, str_id);
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		        lobCreator.setBlobAsBinaryStream(ps, 2, blobIs, (int)blobIn.length()); 
		        ps.setLong(3, str_length);
		      }
		  }
		);
		blobIs.close();
		//clobReader.close();
	}
	//从业人员基本信息 修改图片
	public void updatePic(File file,Long Length ,String ID) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = ID;
		final Long str_length = Length;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(
		  " update T_EMPPIC set PIC =?,PICLEN = ? where EMPCODE =? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        ps.setLong(2, str_length);
		        ps.setString(3, str_id);
		      }
		  }
		);
		blobIs.close();
		//clobReader.close()
	}
	
	public void savePic(byte[] file,long Length ,String ID) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = ID;
		final long str_length = Length;
		final byte[] f_file = file;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(
		  "INSERT INTO T_EMPPIC (EMPCODE, PIC,PICLEN) VALUES (?, ?,?)",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		        ps.setString(1, str_id);
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		        //lobCreator.setBlobAsBinaryStream(ps, 2, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,2,f_file);  
		        ps.setLong(3, str_length);
		      }
		  }
		);
		//blobIs.close();
		//clobReader.close();
	}
	//从业人员基本信息 修改图片
	public void updatePic(byte[] file,long Length ,String ID) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = ID;
		final long str_length = Length;
		final byte[] f_file = file;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		getJdbcTemplate().execute(
		  " update T_EMPPIC set PIC =?,PICLEN = ? where EMPCODE =? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		       // lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		       
			    lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setLong(2, str_length);
		        ps.setString(3, str_id);
		      }
		  }
		);
//		blobIs.close();
		//clobReader.close()
	}
	
	
	//从业人员基本信息 取得照片
	public List getPic(String ID) {
		String sql = "select EMPCODE, PICLEN, PIC from T_EMPPIC where EMPCODE = ? ";
	       return getJdbcTemplate().query(sql, new String[] {ID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    String ID = rs.getString(1);
	        	    Long LENGTH = rs.getLong(2);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "PIC");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", LENGTH);
			        return results;
	           }
	           
	       });
	   }
	
	
	//取得省
	public List getProv() {
		String sql = "select CODE,CALLED from t_dic_xzqh t where substr(code,3)='0000' order by t.i_code ";
		//System.out.println(sql);
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String CODE = rs.getString(1);
	        	    String CALLED = rs.getString(2);
			        results.put("CODE", CODE);
			        results.put("CALLED", CALLED);
			        return results;
	           }
	           
	       });
	   }
	
	//发布范围（单位） 
	public List getNotice_issuescope(Long noticeID) {
		String sql = "select DEPTID,DEPTNAME from SS_DEPT where  DEPTID in (select DEPTID from SS_NOTICE_ATTEND where ISDEPT = 1 and  NOTICEID = ? )";
		return getJdbcTemplate().query(sql,new Object[] { noticeID }, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String DEPTID = rs.getString(1);
				String DEPTNAME = rs.getString(2);

				results.put("DEPTID", DEPTID);
				results.put("DEPTNAME", DEPTNAME);
				return results;
			}

		});
	}
	//通知 参与人员
	public List getNotice_participants(Long noticeID) {
		String sql = "select USERNAME,FULLNAME from SS_USER where  USERNAME in (select USERID from SS_NOTICE_ATTEND where ISDEPT = 0 and  NOTICEID = ? )";
		return getJdbcTemplate().query(sql, new Object[] { noticeID },new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map results = new HashMap();
				String USERNAME = rs.getString(1);
				String FULLNAME = rs.getString(2);

				results.put("USERNAME", USERNAME);
				results.put("FULLNAME", FULLNAME);
				return results;
			}

		});
	}
	
	
	public int getNoticePopCount(String Sql) {
//		CustomerContextHolder.setCustomerType("gas");
		System.out.println("=================="+getJdbcTemplate().getDataSource().toString());
		int totalCount = 0;
		try {
			totalCount = getJdbcTemplate().queryForInt(Sql);
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}
	
	
	

}
