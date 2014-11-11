/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class DczyddDao extends BaseSpringJdbcDao<Dczydd,java.lang.String>{
	
	public Class getEntityClass() {
		return Dczydd.class;
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
				+" t.DZ as dz,"
				+" t.GZDW as gzdw,"
				+" t.LXDH as lxdh,"
				+" t.DWMC as dwmc,"
				+" t.DDLX as ddlx,"
				+" t.DWZJ as dwzj,"
				+" t.FLAG as flag,"
				+" t.DDQX as ddqx,"
				+" t.DWMS as dwms,"
				+" t.REMARK as remark,"
				+" t.DDRQ as ddrq,"
				+" t.LRRQ as lrrq,"
				+" t.SDR as sdr,"
				+" t.TIB_FLOWGUID as tibFlowguid,"
				+" t.TIB_ROWGUID as tibRowguid,"
				+" t.OPTIME as optime,"
				+" t.FRDB as frdb,"
				+" t.YXZJ as yxzj,"
				+" t.SQDDJE as sqddje,"
				+" t.SFSH as sfsh,"
				+" t.WPPP as wppp,"
				+" t.WPGG as wpgg,"
				+" t.WPZL as wpzl,"
				+" t.WPXZ as wpxz,"
				+" t.WPLYQKSM as wplyqksm,"
				+" t.WPCQZMCL as wpcqzmcl,"
				+" b.DWMC as dw"
				+" from DCZYDDXXB t,PMDWXXB b,ss_dept c "
				+"  where substr(t.D_NUMBER,0,10)=b.DWBM  and substr(t.D_NUMBER, 0, 10) = c.deptid(+) ";
	}
	
	/**
	 * 车辆
	 * **/
	public String getSelectclPrefix() {
		return "select  "
		+" a.D_NUMBER as dnumber"
		+" from CLZYDDXXB a "
		+"  where  ";
	}
	
	/**
	 * 房产
	 * **/
	public String getSelectfcPrefix() {
		return "select  "
		+" t.D_NUMBER as dnumber"
		+" from FCDYDDXXB t"
		+"  where  ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from DCZYDDXXB where D_NUMBER=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and D_NUMBER=? ";
	}
	
	public void save(Dczydd entity) {
		String sql = "insert into DCZYDDXXB " 
			 + " (TIB_FLOWGUID,TIB_ROWGUID,D_NUMBER,OPTIME,SQR,FRDB,DZ,GZDW,LXDH,YXZJ,ZJHM,SQDDJE,DDQX,DWMC,DWZJ,REMARK,DDRQ,FLAG,HTID,DDLX,DWMS,LRRQ,SDR,SFSH,WPPP,WPGG,WPZL,WPXZ,WPLYQKSM,WPCQZMCL) " 
			 + " values "
			 + " (:tibFlowguid,:tibRowguid,:dnumber,:optime,:sqr,:frdb,:dz,:gzdw,:lxdh,:yxzj,:zjhm,:sqddje,:ddqx,:dwmc,:dwzj,:remark,:ddrq,:flag,:htid,:ddlx,:dwms,:lrrq,:sdr,:sfsh,:wppp,:wpgg,:wpzl,:wpxz,:wplyqksm,:wpcqzmcl)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_DCZYDDXXB",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Dczydd entity) {
		String sql = "update DCZYDDXXB set "
			+ " TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,D_NUMBER=:dnumber,OPTIME=:optime,SQR=:sqr,FRDB=:frdb,DZ=:dz,GZDW=:gzdw,LXDH=:lxdh,YXZJ=:yxzj,ZJHM=:zjhm,SQDDJE=:sqddje,DDQX=:ddqx,DWMC=:dwmc,DWZJ=:dwzj,REMARK=:remark,DDRQ=:ddrq,FLAG=:flag,HTID=:htid,DDLX=:ddlx,DWMS=:dwms,LRRQ=:lrrq,SDR=:sdr,SFSH=:sfsh,WPPP=:wppp,WPGG=:wpgg,WPZL=:wpzl,WPXZ=:wpxz,WPLYQKSM=:wplyqksm,WPCQZMCL=:wpcqzmcl "
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
		String sql = getSelectPrefix() + " "
		        + "/~ and substr(t.d_number,0,'[deptLength]') = '[deptid]' ~/"
		  		+ "/~ and substr(t.d_number,0,10) in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and t.HTID = '[htid]' ~/"
				+ "/~ and t.SQR  like '%[sqr]%' ~/"
				+ "/~ and t.ZJHM like '%[zjhm]%' ~/"
				+ "/~ and t.DZ = '[dz]' ~/"
				+ "/~ and t.GZDW = '[gzdw]' ~/"
				+ "/~ and t.LXDH = '[lxdh]' ~/"
				+ "/~ and t.DWMC like '%[dwmc]%' ~/"
				+ "/~ and t.DDLX = '[ddlx]' ~/"
				+ "/~ and t.DWZJ like '%[dwzj]%' ~/"
				+ "/~ and t.FLAG = '[flag]' ~/"
				+ "/~ and t.DDQX = '[ddqx]' ~/"
				+ "/~ and t.DWMS = '[dwms]' ~/"
				+ "/~ and t.REMARK = '[remark]' ~/"
				+ "/~ and t.DDRQ >= '[ddrqBeginFormat]' ~/"
				+ "/~ and t.DDRQ <= '[ddrqEndFormat]' ~/"
				+ "/~ and t.LRRQ = '[lrrq]' ~/"
				+ "/~ and t.SDR = '[sdr]' ~/"
				+ "/~ and t.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and t.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and t.OPTIME = '[optime]' ~/"
				+ "/~ and t.FRDB = '[frdb]' ~/"
				+ "/~ and t.YXZJ = '[yxzj]' ~/"
				+ "/~ and t.SQDDJE = '[sqddje]' ~/"
				+ "/~ and t.SFSH = '[sfsh]' ~/"
				+ "/~ and b.DWMC like '%[dw]%' ~/"
				+ "/~ and b.PCSDM = '[pcsdm]' ~/"
				+ "/~ and b.FJDM = '[fjdm]' ~/"
				+ "/~ and c.deptseq like '[deptseq]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,pageRequest);
	}
	
	
	
	//	检查表存在字典代码与否
	public int getFindCountById(String HTID) {
		String sql = "select count(HTID) from DCZYDDXXB  where HTID=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {HTID} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	
private LobHandler lobhandler = new DefaultLobHandler();
	
	public List getDDRYZP(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYZP from DCZYDDXXB where D_NUMBER = ? ";
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
	
	
	public List getDWZP(String TBID) {
		String sql = "select D_NUMBER, DWZP from DCZYDDXXB where D_NUMBER = ? ";
	       return getJdbcTemplate().query(sql, new String[] {TBID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    String ID = rs.getString(1);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "DWZP");  
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
	
	

	
	public List getDDRYSMZP(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYSMZP from DCZYDDXXB where D_NUMBER = ? ";
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
	
	

	
	
	//图片id是否存在
	public int getPicIDIsExist(String D_NUMBER) {
		String sql = "select count(D_NUMBER) as  sl  from DCZYDDXXB  where D_NUMBER = ?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,   new Object[] {D_NUMBER} );   
		
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	
	
	
	
	public void removePicById(String D_NUMBER) {

		String sql = " delete from DCZYDDXXB where D_NUMBER=:zpid  ";
		Map namedParameters = new HashMap();
		namedParameters.put("tbid", D_NUMBER);
		getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
	
	
	
	public void savePic(byte[] file,byte[] file1,byte[] file2,Dczydd entity) throws IOException{
		
		//final File blobIn = new File("spring2004.jpg");
		
		final byte[] f_file = file;
		final byte[] f_file1 = file1;
		final byte[] f_file2 = file2;
		
		final String HTID = entity.getHtid();
		final String SQR = entity.getSqr();
		final String D_NUMBER = entity.getDnumber();
		final String ZJHM = entity.getZjhm();
		final String DZ = entity.getDz();
		final String GZDW = entity.getGzdw();
		final String LXDH = entity.getLxdh();
		final String DWMC = entity.getDwmc();
		final String DDLX = entity.getDdlx();
		final String DWZJ = entity.getDwzj();
		final String FLAG = entity.getFlag();
		final String DDQX = entity.getDdqx();
		final String DWMS = entity.getDwms();
		final String REMARK = entity.getRemark();
		final String DDRQ = entity.getDdrq();
		final String LRRQ = entity.getLrrq();
		final String SDR = entity.getSdr();
		final String TIB_FLOWGUID = entity.getTibFlowguid();
		final String TIB_ROWGUID = entity.getTibRowguid();
		final String OPTIME = entity.getOptime();
		final String FRDB = entity.getFrdb();
		final String YXZJ = entity.getYxzj();
		final Long SQDDJE = entity.getSqddje();
		final String SFSH = entity.getSfsh();
		
		final String wppp= entity.getWppp();
		final String wpgg= entity.getWpgg();
		final String wpzl= entity.getWpzl();
		final String wpxz= entity.getWpxz();
		final String wplyqksm= entity.getWplyqksm();
		final String wpcqzmcl= entity.getWpcqzmcl();
		
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
//		
		

		String insertSql = "insert into DCZYDDXXB "
				+ " (HTID,SQR,D_NUMBER,ZJHM,DZ,GZDW,LXDH,DWMC,DDLX,DWZJ,FLAG,DDQX,DWMS,REMARK,DDRQ,LRRQ,SDR,TIB_FLOWGUID,TIB_ROWGUID,"
				+ "OPTIME,FRDB,YXZJ,SQDDJE,SFSH,WPPP,WPGG,WPZL,WPXZ,WPLYQKSM,WPCQZMCL ";

		String insertPara = "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

		int ps_int = 30;
		int ps_int_ddryzp =31;
		int ps_int_dwzp =  31;
		int ps_int_ddfysmzp =31;

		if (file != null) {
			insertSql = insertSql + ",DDRYZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_ddryzp = ps_int;
		}
		if (file1 != null) {
			insertSql = insertSql + ",DWZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_dwzp = ps_int;
		}
		if (file2 != null) {
			insertSql = insertSql + ",DDRYSMZP";
			insertPara = insertPara + ",?";
			ps_int++;
			ps_int_ddfysmzp = ps_int;
		}

		String AllSql = insertSql + ") values " + insertPara + ")";
		
    
		final int  ps_finalint_ddryzp = ps_int_ddryzp;
		final int  ps_finalint_dwzp = ps_int_dwzp;
		final int  ps_finalint_ddfysmzp = ps_int_ddfysmzp;
		
		
	
 		 
 		
		getJdbcTemplate().execute(
				AllSql,
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		        ps.setString(1, HTID);
		        ps.setString(2, SQR);
		        ps.setString(3, D_NUMBER);
		        ps.setString(4, ZJHM);
		        ps.setString(5, DZ);
		        ps.setString(6, GZDW);
		        ps.setString(7, LXDH);
		        ps.setString(8, DWMC);
		        ps.setString(9, DDLX);
		        ps.setString(10, DWZJ);
		        ps.setString(11, FLAG);
		        ps.setString(12, DDQX);
		        ps.setString(13, DWMS);
		        ps.setString(14, REMARK);
		        ps.setString(15, DDRQ);
		        ps.setString(16, LRRQ);
		        ps.setString(17, SDR);
		        ps.setString(18, TIB_FLOWGUID);
		        ps.setString(19, TIB_ROWGUID);
		        ps.setString(20, OPTIME);
		        ps.setString(21, FRDB);
		        ps.setString(22, YXZJ);
		        ps.setLong(23, SQDDJE);
		        ps.setString(24, SFSH);
		        
		        ps.setString(25, wppp);
		        ps.setString(26, wpgg);
		        ps.setString(27, wpzl);
		        ps.setString(28, wpxz);
		        ps.setString(29, wplyqksm);
		        ps.setString(30, wpcqzmcl);
		       
		        if(f_file != null)
		           lobCreator.setBlobAsBytes(ps,ps_finalint_ddryzp,f_file);  
		        if(f_file1 != null)
			           lobCreator.setBlobAsBytes(ps,ps_finalint_dwzp,f_file1);  
		        if(f_file2 != null)
			           lobCreator.setBlobAsBytes(ps,ps_finalint_ddfysmzp,f_file2);  
//		        if (blobIs != null) 
//		        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_ddryzp, blobIs, (int)blobIn.length()); 
//		        if (blobIs1 != null) 
//		        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_dwzp, blobIs1, (int)blobIn1.length()); 
//		        if (blobIs2 != null) 
//		        lobCreator.setBlobAsBinaryStream(ps, ps_finalint_ddfysmzp, blobIs2, (int)blobIn2.length()); 
		        
		      }
		  }
		);
//		if (blobIs != null) {
//			blobIs.close();
//			tmp_blobIs.close();
//		}
//		if (blobIs1 != null) {
//			blobIs1.close();
//			tmp_blobIs1.close();
//		}
//		if (blobIs2 != null) {
//			blobIs2.close();
//			tmp_blobIs2.close();
//		}
		//clobReader.close();
     
		
	}
	
	public void updateRyPic(byte[] file ,String D_NUMBER) throws IOException{
		//System.out.println("=====================savePic");
		//final File blobIn = new File("spring2004.jpg");
//		final File blobIn = file;
//		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_D_NUMBER = D_NUMBER;
//		final File clobIn = new File("large.txt");
//		final InputStream clobIs = new FileInputStream(clobIn);
//		final InputStreamReader clobReader = new InputStreamReader(clobIs);
		
		final byte[] f_file = file;
		
		getJdbcTemplate().execute(
		  " update DCZYDDXXB set DDRYZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		       // lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file);  
		        ps.setString(2, str_D_NUMBER);
		       
			         
		       
		      }
		  }
		);
		//blobIs.close();
		//clobReader.close();

		
	}
	
	
	public void updateRyPicSm(byte[] file ,String D_NUMBER) throws IOException{
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
		  " update DCZYDDXXB set DDRYSMZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		       // lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setString(2, str_D_NUMBER);
		       
		      }
		  }
		);
		//blobIs.close();
		//clobReader.close();

		
	}
	
	public void updateDwPic(byte[] file ,String D_NUMBER) throws IOException{
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
		  " update DCZYDDXXB set DWZP =? where D_NUMBER = ? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		       
		      //  lobCreator.setClobAsCharacterStream(ps, 2, clobReader, (int)clobIn.length());    
		       // lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        lobCreator.setBlobAsBytes(ps,1,f_file); 
		        ps.setString(2, str_D_NUMBER);
		       
		      }
		  }
		);
		//blobIs.close();
		//clobReader.close();

		
	}
	

	
	//得到当前日期最大编号
	public Dczydd getMaxID(String deptID,String currDate) {
		int length = 0;
		if(deptID != null)
			length= deptID.length();
		
		String sql = "select  max(D_NUMBER) as dnumber  from DCZYDDXXB  where substr(D_NUMBER,0,"+length+") = ? and LRRQ= ?";	
		//System.out.println(sql+currDate);
		Dczydd tchPre = null;
		try {   
			tchPre = (Dczydd)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {deptID,currDate});
			       } catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return tchPre;
	}
	
	
	public List<Dczydd> getPmdwxxbById(String zjhm,String dnumber,String yxzj) {
		StringBuffer hql = new StringBuffer(); 
		if(!"".equals(zjhm) && zjhm != null){
			hql.append(" and t.zjhm = '"+zjhm+"'");
		}
		if(!"".equals(dnumber) && dnumber != null){
			hql.append(" and t.D_NUMBER = '"+dnumber+"'");
		}
		if(!"".equals(yxzj) && yxzj != null){
			hql.append(" and t.YXZJ  = "+yxzj);
		}
		String sql = getSelectPrefix() + hql;
		 
		
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Dczydd.class)) ;
	}

	/**
	 * 获得查到的动产
	 * **/
	public List<Fcdydd> getfcddfrom(String zjhm,String dnumber,String yxzj){
		StringBuffer hql = new StringBuffer(); 
		if(!"".equals(zjhm) && zjhm != null){
			hql.append(" t.zjhm = '"+zjhm+"'");
		}
		if(!"".equals(dnumber) && dnumber != null){
			hql.append( " and t.D_NUMBER = '"+dnumber+"'");
		}
		if(!"".equals(yxzj) && yxzj != null){
			hql.append( " and t.YXZJ  = "+yxzj);
		}
		String sql = getSelectfcPrefix() + hql;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Fcdydd.class));
	}
	/**
	 * 获得查到的车辆
	 * **/
	public List<Clzydd> getclddfrom(String dnumber){
		StringBuffer hql = new StringBuffer();  
		if(!"".equals(dnumber) && dnumber != null){
			hql.append("  a.D_NUMBER = '"+dnumber+"'");
		}
		String sql = getSelectclPrefix() + hql;
		
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Clzydd.class));
	}

}
