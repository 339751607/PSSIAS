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

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
public class ShxxDao extends BaseSpringJdbcDao<Shxx,java.lang.String>{
	
	public Class getEntityClass() {
		return Shxx.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.D_NUMBER as dnumber,"
				+" t.HTID as htid,"
				+" t.SHRXM as shrxm,"
				+" t.SHRSFZHM as shrsfzhm,"
				+" t.LXDH as lxdh,"
				+" t.GZDW as gzdw,"
				+" t.BZ as bz,"
				+" t.SHRQ as shrq,"
				+" t.TDR as tdr,"
				+" t.LRRQ as lrrq,"
				+" t.OPTIME as optime,"
				+" t.DDLX as ddlx,"
				+" t.FLAG as flag,"
				+" t.XH as xh,"
				+" t.YXZJ as yxzj,"
				+" b.dwmc as dwmc "
				+" from SHXXB t, PMDWXXB b,ss_dept c"
				+"  where substr(t.D_NUMBER,0,10)=b.DWBM  and  substr(t.D_NUMBER,0,10)=c.deptid ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SHXXB where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and XH=? ";
	}
	
	public void save(Shxx entity) {
		String sql = "insert into SHXXB " 
			 + " (D_NUMBER,HTID,SHRXM,SHRSFZHM,LXDH,GZDW,BZ,SHRQ,TDR,LRRQ,OPTIME,DDLX,FLAG,XH,YXZJ) " 
			 + " values "
			 + " (:dnumber,:htid,:shrxm,:shrsfzhm,:lxdh,:gzdw,:bz,:shrq,:tdr,:lrrq,:optime,:ddlx,:flag,:xh,:yxzj)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SHXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Shxx entity) {
		String sql = "update SHXXB set "
					+ " D_NUMBER=:dnumber,HTID=:htid,SHRXM=:shrxm,SHRSFZHM=:shrsfzhm,LXDH=:lxdh,GZDW=:gzdw,BZ=:bz,SHRQ=:shrq,TDR=:tdr,LRRQ=:lrrq,OPTIME=:optime,DDLX=:ddlx,FLAG=:flag,YXZJ=:yxzj "
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
		String sql = getSelectPrefix() + "  "
				+ "/~ and t.D_NUMBER = '[dnumber]' ~/"
				+ "/~ and substr(t.d_number,0,'[deptLength]') = '[deptid]' ~/"
		        + "/~ and substr(t.d_number,0,10) in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.HTID = '[htid]' ~/"
				+ "/~ and t.SHRXM like '%[shrxm]%' ~/"
				+ "/~ and t.SHRSFZHM = '[shrsfzhm]' ~/"
				+ "/~ and t.LXDH = '[lxdh]' ~/"
				+ "/~ and t.GZDW = '[gzdw]' ~/"
				+ "/~ and t.BZ = '[bz]' ~/"
				+ "/~ and t.SHRQ >= '[shrqBeginFormat]' ~/"
				+ "/~ and t.SHRQ <= '[shrqEndFormat]' ~/"
				+ "/~ and t.TDR = '[tdr]' ~/"
				+ "/~ and t.LRRQ = '[lrrq]' ~/"
				+ "/~ and t.OPTIME = '[optime]' ~/"
				+ "/~ and t.DDLX = '[ddlx]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and b.PCSDM = '[pcsdm]' ~/"
				+ "/~ and b.FJDM = '[fjdm]' ~/"
				+ "/~ and c.deptseq like '[deptseq]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	private LobHandler lobhandler = new DefaultLobHandler();
	public void savePic(byte[] file, Shxx entity) throws IOException {
		
		final byte[] f_file = file;
		
		final String D_NUMBER = entity.getDnumber();
		final String HTID = entity.getHtid();
		final String SHRXM = entity.getShrxm();
		final String SHRSFZHM = entity.getShrsfzhm();
		final String LXDH = entity.getLxdh();
		final String GZDW = entity.getGzdw();
		final String BZ = entity.getBz();
		final String SHRQ = entity.getShrq();
		final String TDR = entity.getTdr();
		final String LRRQ = entity.getLrrq();
		final String OPTIME = entity.getOptime();
		final String DDLX = entity.getDdlx();
		//final java.sql.Blob SHRZP = entity.getShrzp();
		final String FLAG = entity.getFlag();
		final java.lang.String XH = entity.getXh();
		final java.lang.String yxzj = entity.getYxzj();
		
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		String sql = "insert into SHXXB " 
			 + " (D_NUMBER,HTID,SHRXM,SHRSFZHM,LXDH,GZDW,BZ,SHRQ,TDR,LRRQ,OPTIME,DDLX,SHRZP,FLAG,XH,YXZJ) " 
			 + " values "
			 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		getJdbcTemplate().execute(sql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, D_NUMBER);
						ps.setString(2, HTID);
						ps.setString(3, SHRXM);
						ps.setString(4, SHRSFZHM);
						ps.setString(5, LXDH);
						ps.setString(6, GZDW);
						ps.setString(7, BZ);
						ps.setString(8, SHRQ);
						ps.setString(9, TDR);
						ps.setString(10, LRRQ);
						ps.setString(11, OPTIME);
						ps.setString(12, DDLX);
						//ps.setjava.sql.Blob(13, SHRZP);
						ps.setString(14, FLAG);
						ps.setString(15, XH);
						ps.setString(16, yxzj);
						  lobCreator.setBlobAsBytes(ps,13,f_file);  
						
//						lobCreator.setBlobAsBinaryStream(ps, 13, blobIs,
//								(int) blobIn.length());
					}
				});
		//blobIs.close();
	}
	
	//取得档案编号 当物名称
	public List getDwxx(String sql) {
//		return getJdbcTemplate().query(sql, new RowMapper() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Map results = new HashMap();
//				//HTID,DWMS,SQR,ZJHM,LXDH,GZDW
//				String HTID = rs.getString(1);
//				String DWMS = rs.getString(2);
//				results.put("CODE", CODE);
//				results.put("CALLED", CALLED);
//				return results;
//			}
//
//		});
		return getJdbcTemplate().queryForList(sql);
	}
	
	public int getFindCountById(String sql) {
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql);  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_SHXXB");
		Long id = seq.nextLongValue();
        return id;
	}
	
	public void updateFlagShiFouShuHui(String sql ,String D_NUMBER) {
		Map namedParameters = new HashMap();
		namedParameters.put("dnumber", D_NUMBER);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	
	
	public List getPic(String DNUMBER,String flag) {
		String sql = "select D_NUMBER, SHRZP from SHXXB where D_NUMBER = ? and FLAG = ? ";
	       return getJdbcTemplate().query(sql, new String[] {DNUMBER,flag}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    
	        	    String ID = rs.getString(1);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "SHRZP");    
		          //  System.out.println("blobBytes="+blobBytes);
		            if(blobBytes==null)
		            	results.put("FlAG", "0");
		            else 
		            	results.put("FlAG", "1");
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        return results;
	           }
	           
	       });
	   }
	
	public List getShrPic(String DNUMBER,String flag) {
		String sql = "";
		if(flag!=null&&flag.equals("D")){
			sql = "select D_NUMBER, DDRYZP from DCZYDDXXB where D_NUMBER = ? ";
		}else if(flag!=null&&flag.equals("C")){
			sql = "select D_NUMBER, DDRYZP from CLZYDDXXB where D_NUMBER = ? ";
		}else if(flag!=null&&flag.equals("F")){
			sql = "select D_NUMBER, DDRYZP from FCDYDDXXB where D_NUMBER = ? ";
		}
	       return getJdbcTemplate().query(sql, new String[] {DNUMBER}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    
	        	    String ID = rs.getString(1);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "DDRYZP");    
		          //  System.out.println("blobBytes="+blobBytes);
		            if(blobBytes==null)
		            	results.put("FlAG", "0");
		            else 
		            	results.put("FlAG", "1");
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        return results;
	           }
	           
	       });
	   }
	
	public void updatePic(File file ,String D_NUMBER,String flag) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_D_NUMBER = D_NUMBER;
		final String str_flag = flag;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		
		getJdbcTemplate().execute(
		  " update SHXXB set SHRZP =? where D_NUMBER = ? and FLAG = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        ps.setString(2, str_D_NUMBER);
		        ps.setString(3, str_flag);
		       
		      }
		  }
		);
		blobIs.close();
		//clobReader.close();

		
	}
	
	
	public Shxx getShxxById(String D_NUMBER,String FLAG) {
	    String sql =	getSelectPrefix() + " and D_NUMBER=?  and t.FLAG= ?";	
	   // System.out.println("D_NUMBER='"+D_NUMBER+"'  and FLAG= '"+FLAG+"'");
		Shxx shxx = null;
		try {   
			shxx = (Shxx)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {D_NUMBER,FLAG});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return shxx;
	}
	
	public void updateExt(Shxx entity) {
		String sql = "update SHXXB set "
					+ " D_NUMBER=:dnumber,HTID=:htid,SHRXM=:shrxm,SHRSFZHM=:shrsfzhm,LXDH=:lxdh,GZDW=:gzdw,BZ=:bz,SHRQ=:shrq,TDR=:tdr,LRRQ=:lrrq,OPTIME=:optime,DDLX=:ddlx,FLAG=:flag,YXZJ=:yxzj "
					+ " where FLAG=:flag and D_NUMBER=:dnumber";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	

}
