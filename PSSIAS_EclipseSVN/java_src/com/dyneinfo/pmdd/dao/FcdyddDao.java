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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
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
public class FcdyddDao extends BaseSpringJdbcDao<Fcdydd,java.lang.String>{
	
	public Class getEntityClass() {
		return Fcdydd.class;
	}
	
	public String getIdentifierPropertyName() {
		return "dnumber";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.HTID as htid,"
				+" t.SQR as sqr,"
				+" t.D_NUMBER as dnumber,"
				+" t.ZJHM as zjhm,"
				+" t.GZDW as gzdw,"
				+" t.LXDH as lxdh,"
				+" t.FRDB as frdb,"
				+" t.LB as lb,"
				+" t.FWQW as fwqw,"
				+" t.DZ as dz,"
				+" t.FWSYQZH as fwsyqzh,"
				+" t.JZMJ as jzmj,"
				+" t.TDSYZH as tdsyzh,"
				+" t.ZDMJ as zdmj,"
				+" t.BXXZ as bxxz,"
				+" t.DDLB as ddlb,"
				+" t.DDQX as ddqx,"
				+" t.DWMS as dwms,"
				+" t.REMARK as remark,"
				+" t.DDRQ as ddrq,"
				+" t.LRRQ as lrrq,"
				+" t.SDR as sdr,"
				+" t.SFSH as sfsh,"
				+" t.TIB_FLOWGUID as tibFlowguid,"
				+" t.TIB_ROWGUID as tibRowguid,"
				+" t.OPTIME as optime,"
				+" t.YXZJ as yxzj,"
				+" t.SQDDJE as sqddje,"
				+" t.FLAG as flag,"
				+" b.DWMC as dwmc"
				+" from FCDYDDXXB t, PMDWXXB b,ss_dept c "
				+"  where substr(t.D_NUMBER,0,10)=b.DWBM  and substr(t.D_NUMBER, 0, 10) = c.deptid(+) ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from FCDYDDXXB where D_NUMBER=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and D_NUMBER=? ";
	}
	
	public void save(Fcdydd entity) {
		String sql = "insert into FCDYDDXXB " 
			 + " (HTID,SQR,D_NUMBER,ZJHM,GZDW,LXDH,FRDB,LB,FWQW,DZ,FWSYQZH,JZMJ,TDSYZH,ZDMJ,BXXZ,DDLB,DDQX,DWMS,REMARK,DDRQ,LRRQ,SDR,SFSH,TIB_FLOWGUID,TIB_ROWGUID,OPTIME,YXZJ,SQDDJE,FLAG) " 
			 + " values "
			 + " (:htid,:sqr,:dnumber,:zjhm,:gzdw,:lxdh,:frdb,:lb,:fwqw,:dz,:fwsyqzh,:jzmj,:tdsyzh,:zdmj,:bxxz,:ddlb,:ddqx,:dwms,:remark,:ddrq,:lrrq,:sdr,:sfsh,:tibFlowguid,:tibRowguid,:optime,:yxzj,:sqddje,:flag)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_FCDYDDXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Fcdydd entity) {
		String sql = "update FCDYDDXXB set "
					+ " HTID=:htid,SQR=:sqr,D_NUMBER=:dnumber,ZJHM=:zjhm,GZDW=:gzdw,LXDH=:lxdh,FRDB=:frdb,LB=:lb,FWQW=:fwqw,DZ=:dz,FWSYQZH=:fwsyqzh,JZMJ=:jzmj,TDSYZH=:tdsyzh,ZDMJ=:zdmj,BXXZ=:bxxz,DDLB=:ddlb,DDQX=:ddqx,DWMS=:dwms,REMARK=:remark,DDRQ=:ddrq,LRRQ=:lrrq,SDR=:sdr,SFSH=:sfsh,TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,OPTIME=:optime,YXZJ=:yxzj,SQDDJE=:sqddje,FLAG=:flag "
					+ " where D_NUMBER=:dnumber";
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
		        + "/~ and substr(t.d_number,0,'[deptLength]') = '[deptid]' ~/"
		        + "/~ and substr(t.d_number,0,10) in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.HTID = '[htid]' ~/"
				+ "/~ and t.SQR like '%[sqr]%' ~/"
				+ "/~ and t.ZJHM = '[zjhm]' ~/"
				+ "/~ and t.GZDW = '[gzdw]' ~/"
				+ "/~ and t.LXDH = '[lxdh]' ~/"
				+ "/~ and t.FRDB = '[frdb]' ~/"
				+ "/~ and t.LB = '[lb]' ~/"
				+ "/~ and t.FWQW like '%[fwqw]%' ~/"
				+ "/~ and t.DZ = '[dz]' ~/"
				+ "/~ and t.FWSYQZH like '%[fwsyqzh]%' ~/"
				+ "/~ and t.JZMJ = '[jzmj]' ~/"
				+ "/~ and t.TDSYZH like '%[tdsyzh]%' ~/"
				+ "/~ and t.ZDMJ = '[zdmj]' ~/"
				+ "/~ and t.BXXZ = '[bxxz]' ~/"
				+ "/~ and t.DDLB = '[ddlb]' ~/"
				+ "/~ and t.DDQX = '[ddqx]' ~/"
				+ "/~ and t.DWMS = '[dwms]' ~/"
				+ "/~ and t.REMARK = '[remark]' ~/"
				+ "/~ and t.DDRQ >= '[ddrqBeginFormat]' ~/"
				+ "/~ and t.DDRQ <= '[ddrqEndFormat]' ~/"
				+ "/~ and t.LRRQ = '[lrrq]' ~/"
				+ "/~ and t.SDR = '[sdr]' ~/"
				+ "/~ and t.SFSH = '[sfsh]' ~/"
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.OPTIME = '[optime]' ~/"
				+ "/~ and t.YXZJ = '[yxzj]' ~/"
				+ "/~ and t.SQDDJE = '[sqddje]' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and b.DWMC like '%[dwmc]%' ~/"
				+ "/~ and b.PCSDM = '[pcsdm]' ~/"
				+ "/~ and b.FJDM = '[fjdm]' ~/"
				+ "/~ and c.deptseq like '[deptseq]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	private LobHandler lobhandler = new DefaultLobHandler();
	
	public void savePic(byte[] file,byte[] file1,byte[] file2, Fcdydd entity) throws IOException {
		
		final String HTID = entity.getHtid();
		final String SQR = entity.getSqr();
		final java.lang.String D_NUMBER = entity.getDnumber();
		final String ZJHM = entity.getZjhm();
		final String GZDW = entity.getGzdw();
		final String LXDH = entity.getLxdh();
		final String FRDB = entity.getFrdb();
		final String LB = entity.getLb();
		final String FWQW = entity.getFwqw();
		final String DZ = entity.getDz();
		final String FWSYQZH = entity.getFwsyqzh();
		final String JZMJ = entity.getJzmj();
		final String TDSYZH = entity.getTdsyzh();
		final String ZDMJ = entity.getZdmj();
		final String BXXZ = entity.getBxxz();
		final String DDLB = entity.getDdlb();
		final String DDQX = entity.getDdqx();
		final String DWMS = entity.getDwms();
		final String REMARK = entity.getRemark();
		final String DDRQ = entity.getDdrq();
		final String LRRQ = entity.getLrrq();
		final String SDR = entity.getSdr();
		final String SFSH = entity.getSfsh();
		final String TIB_FLOWGUID = entity.getTibFlowguid();
		final String TIB_ROWGUID = entity.getTibRowguid();
		final String OPTIME = entity.getOptime();
		final String YXZJ = entity.getYxzj();
		final Long SQDDJE = entity.getSqddje();
		final String FLAG = entity.getFlag();
//		final java.sql.Blob DDRYZP = entity.getDdryzp();
		
		
		
//		final File blobIn = file;
// 		final File blobIn1 = file1;
// 		final File blobIn2 = file2;
// 		
// 		InputStream tmp_blobIs = null;
// 		if(file != null )
// 			tmp_blobIs = new FileInputStream(blobIn);
// 		
// 		InputStream tmp_blobIs1 = null;
// 		if(file1 != null )
// 			tmp_blobIs1 = new FileInputStream(blobIn1);
// 		
// 		InputStream tmp_blobIs2 = null;
// 		if(file2 != null )
// 			tmp_blobIs2 = new FileInputStream(blobIn2);
// 		
// 		
// 		final InputStream blobIs =  tmp_blobIs;
// 		final InputStream blobIs1 = tmp_blobIs1;
// 		final InputStream blobIs2 = tmp_blobIs2;
		
		final byte[] f_file = file;
		final byte[] f_file1 = file1;
		final byte[] f_file2 = file2;
		
		

		String insertSql = "insert into FCDYDDXXB "
				+ " (HTID,SQR,D_NUMBER,ZJHM,GZDW,LXDH,FRDB,LB,FWQW,DZ,FWSYQZH,JZMJ,TDSYZH,ZDMJ,BXXZ,DDLB,DDQX,DWMS,REMARK,DDRQ,LRRQ,SDR,SFSH,TIB_FLOWGUID,TIB_ROWGUID,OPTIME,YXZJ,SQDDJE,FLAG";

		String insertPara = "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

		int ps_int = 29;
		int ps_int_ddryzp =30;
		int ps_int_dwzp =  30;
		int ps_int_ddfysmzp =30;

		if (file != null) {
			insertSql = insertSql + ",DDRYZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_ddryzp = ps_int;
		}
		if (file1 != null) {
			insertSql = insertSql + ",DDRYSMZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_dwzp = ps_int;
		}
		if (file2 != null) {
			insertSql = insertSql + ",DWZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_ddfysmzp = ps_int;
		}

		String AllSql = insertSql + ") values " + insertPara + ")";
		
    
		final int  ps_finalint_ddryzp = ps_int_ddryzp;
		final int  ps_finalint_dwzp = ps_int_dwzp;
		final int  ps_finalint_ddfysmzp = ps_int_ddfysmzp;
		
		
		
		
		

		getJdbcTemplate().execute(AllSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, HTID);
						ps.setString(2, SQR);
						ps.setString(3, D_NUMBER);
						ps.setString(4, ZJHM);
						ps.setString(5, GZDW);
						ps.setString(6, LXDH);
						ps.setString(7, FRDB);
						ps.setString(8, LB);
						ps.setString(9, FWQW);
						ps.setString(10, DZ);
						ps.setString(11, FWSYQZH);
						ps.setString(12, JZMJ);
						ps.setString(13, TDSYZH);
						ps.setString(14, ZDMJ);
						ps.setString(15, BXXZ);
						ps.setString(16, DDLB);
						ps.setString(17, DDQX);
						ps.setString(18, DWMS);
						ps.setString(19, REMARK);
						ps.setString(20, DDRQ);
						ps.setString(21, LRRQ);
						ps.setString(22, SDR);
						ps.setString(23, SFSH);
						ps.setString(24, TIB_FLOWGUID);
						ps.setString(25, TIB_ROWGUID);
						ps.setString(26, OPTIME);
						ps.setString(27, YXZJ);
						ps.setLong(28, SQDDJE);
						ps.setString(29, FLAG);
						
						  if(f_file != null)
					           lobCreator.setBlobAsBytes(ps,ps_finalint_ddryzp,f_file);  
					        if(f_file1 != null)
						           lobCreator.setBlobAsBytes(ps,ps_finalint_dwzp,f_file1);  
					        if(f_file2 != null)
						           lobCreator.setBlobAsBytes(ps,ps_finalint_ddfysmzp,f_file2); 
						
						
//						 if (blobIs != null) 
//						        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_ddryzp, blobIs, (int)blobIn.length()); 
//						        if (blobIs1 != null) 
//						        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_dwzp, blobIs1, (int)blobIn1.length()); 
//						        if (blobIs2 != null) 
//						        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_ddfysmzp, blobIs2, (int)blobIn2.length()); 
					}
				});
		
	}
	
	
	public List getPic(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYZP from FCDYDDXXB where D_NUMBER = ? ";
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
	
	public List getPicture(String sql) {
	       return getJdbcTemplate().query(sql, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, 1);
		            results.put("PICTURE", blobBytes);
			        return results;
	           }
	           
	       });
	}

	
	
	public void updatePic(byte[] file ,String D_NUMBER) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
	
		final byte[] f_file = file;
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_D_NUMBER = D_NUMBER;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		
		getJdbcTemplate().execute(
		  " update FCDYDDXXB set DDRYZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		      //  lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setString(2, str_D_NUMBER);
		       
		      }
		  }
		);
//		blobIs.close();
		//clobReader.close();

		
	}
	
	
	
	public List getSmPic(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYSMZP from FCDYDDXXB where D_NUMBER = ? ";
	       return getJdbcTemplate().query(sql, new String[] {DNUMBER}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    
	        	    String ID = rs.getString(1);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "DDRYSMZP");    
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
	
	public void updateSmPic(byte[] file ,String D_NUMBER) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_D_NUMBER = D_NUMBER;
		final byte[] f_file = file;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		
		getJdbcTemplate().execute(
		  " update FCDYDDXXB set DDRYSMZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
//		        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setString(2, str_D_NUMBER);
		       
		      }
		  }
		);
//		blobIs.close();
		//clobReader.close();
	}
	
	
	
	
	public List getDwPic(String DNUMBER) {
		String sql = "select D_NUMBER, DWZP from FCDYDDXXB where D_NUMBER = ? ";
	       return getJdbcTemplate().query(sql, new String[] {DNUMBER}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    
	        	    String ID = rs.getString(1);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "DWZP");    
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
	
	public void updateDwPic(byte[] file ,String D_NUMBER) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final byte[] f_file = file;
		final String str_D_NUMBER = D_NUMBER;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		
		getJdbcTemplate().execute(
		  " update FCDYDDXXB set DWZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		      //  lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setString(2, str_D_NUMBER);
		       
		      }
		  }
		);
//		blobIs.close();
		//clobReader.close();
	}
	
//	检查表存在代码与否
	public int getFindCountById(String HTID) {
		String sql = "select count(HTID) from FCDYDDXXB  where HTID=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {HTID} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	//得到当前日期最大编号
	public Fcdydd getMaxID(String deptID,String currDate) {
		int length = 0;
		if(deptID != null)
			length= deptID.length();
		
		String sql = "select  max(D_NUMBER) as dnumber  from FCDYDDXXB  where substr(D_NUMBER,0,"+length+") = ? and LRRQ= ?";	
		//System.out.println(sql+currDate);
		Fcdydd fcdydd = null;
		try {   
			fcdydd = (Fcdydd)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {deptID,currDate});
			       } catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return fcdydd;
	}

}
