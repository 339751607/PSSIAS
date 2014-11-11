/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

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

import net.java.dev.common.util.DateUtil;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.pmdd.model.Clzydd;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class ClzyddDao extends BaseSpringJdbcDao<Clzydd, java.lang.String> {

	public Class getEntityClass() {
		return Clzydd.class;
	}

	public String getIdentifierPropertyName() {
		return "dnumber";
	}

	public String getSelectPrefix() {
		return "select  "
				+" a.HTID as htid,"
				+" a.SQR as sqr,"
				+" a.D_NUMBER as dnumber,"
				+" a.ZJHM as zjhm,"
				+" a.GZDW as gzdw,"
				+" a.LXDH as lxdh,"
				+" a.DZ as dz,"
				+" a.CPHM as cphm,"
				+" a.CZMC as czmc,"
				+" a.FDJH as fdjh,"
				+" a.SCCJ as sccj,"
				+" a.CJHM as cjhm,"
				+" a.CSYS as csys,"
				+" a.CLXH as clxh,"
				+" a.YXSGLS as yxsgls,"
				+" a.FRDB as frdb,"
				+" a.DDLX as ddlx,"
				+" a.DDQX as ddqx,"
				+" a.DWMS as dwms,"
				+" a.REMARK as remark,"
				+" a.DDRQ as ddrq,"
				+" a.LRRQ as lrrq,"
				+" a.SDR as sdr,"
				+" a.TIB_FLOWGUID as tibFlowguid,"
				+" a.TIB_ROWGUID as tibRowguid,"
				+" a.OPTIME as optime,"
				+" a.SQDDJE as sqddje,"
				+" a.YXZJ as yxzj,"
				+" a.FLAG as flag,"
				+" a.LB as lb,"
				+" a.SFSH as sfsh,"
				+" b.DWMC as dwmc,"
				+" a.XSZDZ as xszdz"
				+" from CLZYDDXXB a, PMDWXXB b,ss_dept c "
				+"  where substr(a.D_NUMBER,0,10)=b.DWBM  and substr(a.D_NUMBER, 0, 10) = c.deptid(+)  ";
	}
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from CLZYDDXXB where D_NUMBER=?";
	}

	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and D_NUMBER=? ";
	}

	public void save(Clzydd entity) {
		String sql = "insert into CLZYDDXXB "
				+ " (HTID,SQR,D_NUMBER,ZJHM,GZDW,LXDH,DZ,CPHM,CZMC,FDJH,SCCJ,CJHM,CSYS,CLXH,YXSGLS,FRDB,DDLX,DDQX,DWMS,REMARK,DDRQ,LRRQ,SDR,TIB_FLOWGUID,TIB_ROWGUID,OPTIME,SQDDJE,YXZJ,FLAG,LB,SFSH) "
				+ " values "
				+ " (:htid,:sqr,:dnumber,:zjhm,:gzdw,:lxdh,:dz,:cphm,:czmc,:fdjh,:sccj,:cjhm,:csys,:clxh,:yxsgls,:frdb,:ddlx,:ddqx,:dwms,:remark,:ddrq,:lrrq,:sdr,:tibFlowguid,:tibRowguid,:optime,:sqddje,:yxzj,:flag,:lb,:sfsh)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql

		//其它主键生成策略
		//insertWithOracleSequence(entity, "SEQ_CLZYDDXXB", sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}

	public void update(Clzydd entity) {
		String sql = "update CLZYDDXXB set "
				+ " HTID=:htid,SQR=:sqr,D_NUMBER=:dnumber,ZJHM=:zjhm,GZDW=:gzdw,LXDH=:lxdh,DZ=:dz,CPHM=:cphm,CZMC=:czmc,FDJH=:fdjh,SCCJ=:sccj,CJHM=:cjhm,CSYS=:csys,CLXH=:clxh,YXSGLS=:yxsgls,FRDB=:frdb,DDLX=:ddlx,DDQX=:ddqx,DWMS=:dwms,REMARK=:remark,DDRQ=:ddrq,LRRQ=:lrrq,SDR=:sdr,TIB_FLOWGUID=:tibFlowguid,TIB_ROWGUID=:tibRowguid,OPTIME=:optime,SQDDJE=:sqddje,YXZJ=:yxzj,FLAG=:flag,LB=:lb,SFSH=:sfsh,XSZDZ=:xszdz "
				+ " where D_NUMBER=:dnumber";
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
		String sql = getSelectPrefix() + " "
		        + "/~ and substr(a.d_number,0,'[deptLength]') = '[deptid]' ~/"
		        + "/~ and substr(a.d_number,0,10) in ( select d.DEPTID from SS_DEPT d where d.DEPTSEQ like '%.[chdeptid].%' ) ~/"
				+ "/~ and a.HTID = '[htid]' ~/"
				+ "/~ and a.SQR like '%[sqr]%' ~/"
				+ "/~ and a.ZJHM = '[zjhm]' ~/" 
				+ "/~ and a.GZDW = '[gzdw]' ~/"
				+ "/~ and a.LXDH = '[lxdh]' ~/" 
				+ "/~ and a.DZ = '[dz]' ~/"
				+ "/~ and a.CPHM like '%[cphm]%' ~/"
				+ "/~ and a.CZMC like '%[czmc]%' ~/"
				+ "/~ and a.FDJH like '%[fdjh]%' ~/"
				+ "/~ and a.SCCJ = '[sccj]' ~/" 
				+ "/~ and a.CJHM = '[cjhm]' ~/"
				+ "/~ and a.CSYS = '[csys]' ~/" 
				+ "/~ and a.CLXH = '[clxh]' ~/"
				+ "/~ and a.YXSGLS = '[yxsgls]' ~/"
				+ "/~ and a.FRDB = '[frdb]' ~/" 
				+ "/~ and a.DDLX = '[ddlx]' ~/"
				+ "/~ and a.DDQX = '[ddqx]' ~/" 
				+ "/~ and a.DWMS = '[dwms]' ~/"
				+ "/~ and a.REMARK = '[remark]' ~/"
				+ "/~ and a.DDRQ >= '[ddrqBeginFormat]' ~/"
				+ "/~ and a.DDRQ <= '[ddrqEndFormat]' ~/"
				+ "/~ and a.LRRQ = '[lrrq]' ~/"
				+ "/~ and a.SDR = '[sdr]' ~/"
				+ "/~ and a.TIB_FLOWGUID = '[tibFlowguid]' ~/"
				+ "/~ and a.TIB_ROWGUID = '[tibRowguid]' ~/"
				+ "/~ and a.OPTIME = '[optime]' ~/"
				+ "/~ and a.SQDDJE = '[sqddje]' ~/"
				+ "/~ and a.YXZJ = '[yxzj]' ~/" 
				+ "/~ and a.FLAG = '[flag]' ~/"
				+ "/~ and a.LB = '[lb]' ~/" 
				+ "/~ and a.SFSH = '[sfsh]' ~/"
				+ "/~ and b.DWMC like '%[dwmc]%' ~/"
				+ "/~ and b.PCSDM = '[pcsdm]' ~/"
				+ "/~ and b.FJDM = '[fjdm]' ~/"
				+ "/~ and c.deptseq like '[deptseq]%' ~/"
				+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql, pageRequest);
	}

	private LobHandler lobhandler = new DefaultLobHandler();

	

	

	public void savePic(byte[] file,byte[] file1,byte[] file2, Clzydd entity) throws IOException {

		final String HTID = entity.getHtid();
		final String SQR = entity.getSqr();
		final java.lang.String D_NUMBER = entity.getDnumber();
		final String ZJHM = entity.getZjhm();
		final String GZDW = entity.getGzdw();
		final String LXDH = entity.getLxdh();
		final String DZ = entity.getDz();
		final String CPHM = entity.getCphm();
		final String CZMC = entity.getCzmc();
		final String FDJH = entity.getFdjh();
		final String SCCJ = entity.getSccj();
		final String CJHM = entity.getCjhm();
		final String CSYS = entity.getCsys();
		final String CLXH = entity.getClxh();
		final String YXSGLS = entity.getYxsgls();
		final String FRDB = entity.getFrdb();
		final String DDLX = entity.getDdlx();
		final String DDQX = entity.getDdqx();
		final String DWMS = entity.getDwms();
		final String REMARK = entity.getRemark();
		final String DDRQ = entity.getDdrq();
		final String LRRQ = entity.getLrrq();
		final String SDR = entity.getSdr();
		final String TIB_FLOWGUID = entity.getTibFlowguid();
		final String TIB_ROWGUID = entity.getTibRowguid();
		final String OPTIME = entity.getOptime();
		final Long SQDDJE = entity.getSqddje();
		final String YXZJ = entity.getYxzj();
		final String FLAG = entity.getFlag();
		final String LB = entity.getLb();
		final String SFSH = entity.getSfsh();
		final String XSZDZ = entity.getXszdz();
		//	final java.sql.Blob DDRYZP = entity.getDdryzp();
		//	final java.sql.Blob DWZP = entity.getDwzp();

		final byte[] f_file = file;
		final byte[] f_file1 = file1;
		final byte[] f_file2 = file2;
		
		
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
 		
 		
 		
 		String insertSql = "insert into CLZYDDXXB "
			+ " (HTID,SQR,D_NUMBER,ZJHM,GZDW,LXDH,DZ,CPHM,CZMC,FDJH,SCCJ,CJHM,CSYS,CLXH,YXSGLS,FRDB,DDLX,DDQX,DWMS,REMARK,DDRQ,LRRQ,SDR,TIB_FLOWGUID,TIB_ROWGUID,OPTIME,SQDDJE,YXZJ,FLAG,LB,SFSH,XSZDZ";

	String insertPara = "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

	int ps_int = 32;
	int ps_int_ddryzp =33;
	int ps_int_dwzp =  33;
	int ps_int_ddfysmzp =33;

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
						ps.setString(7, DZ);
						ps.setString(8, CPHM);
						ps.setString(9, CZMC);
						ps.setString(10, FDJH);
						ps.setString(11, SCCJ);
						ps.setString(12, CJHM);
						ps.setString(13, CSYS);
						ps.setString(14, CLXH);
						ps.setString(15, YXSGLS);
						ps.setString(16, FRDB);
						ps.setString(17, DDLX);
						ps.setString(18, DDQX);
						ps.setString(19, DWMS);
						ps.setString(20, REMARK);
						ps.setString(21, DDRQ);
						ps.setString(22, LRRQ);
						ps.setString(23, SDR);
						ps.setString(24, TIB_FLOWGUID);
						ps.setString(25, TIB_ROWGUID);
						ps.setString(26, OPTIME);
						ps.setLong(27, SQDDJE);
						ps.setString(28, YXZJ);
						ps.setString(29, FLAG);
						ps.setString(30, LB);
						ps.setString(31, SFSH);
						ps.setString(32, XSZDZ);
						//ps.setjava.sql.Blob(32, DDRYZP);
						//ps.setjava.sql.Blob(33, DWZP);
						 
						        
						        if(f_file != null)
							           lobCreator.setBlobAsBytes(ps,ps_finalint_ddryzp,f_file);  
							        if(f_file1 != null)
								           lobCreator.setBlobAsBytes(ps,ps_finalint_dwzp,f_file1);  
							        if(f_file2 != null)
								           lobCreator.setBlobAsBytes(ps,ps_finalint_ddfysmzp,f_file2); 
					}
				});
		
	}
	
	
	public List getPicRy(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYZP from CLZYDDXXB where D_NUMBER = ? ";
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
	
	
	public List getPicSmRy(String DNUMBER) {
		String sql = "select D_NUMBER, DDRYSMZP from CLZYDDXXB where D_NUMBER = ? ";
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
	public List getPicDw(String DNUMBER) {
		String sql = "select D_NUMBER, DWZP from CLZYDDXXB where D_NUMBER = ? ";
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
	
	public void updatePicRy(byte[] file ,String D_NUMBER) throws IOException{
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
		  " update CLZYDDXXB set DDRYZP =? where D_NUMBER = ? ",
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
		//blobIs.close();
		//clobReader.close();

		
	}
	
	public void updatePicSmRy(byte[] file ,String D_NUMBER) throws IOException{
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
		  " update CLZYDDXXB set DDRYSMZP =? where D_NUMBER = ? ",
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
	
	public void updatePicDw(byte[] file ,String D_NUMBER) throws IOException{
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
		  " update CLZYDDXXB set DWZP =? where D_NUMBER = ? ",
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
	//	blobIs.close();
		//clobReader.close();

		
	}
	
	
	
	
//	检查表存在代码与否
	public int getFindCountById(String HTID) {
		String sql = "select count(HTID) from CLZYDDXXB  where HTID=?  ";
		int  totalCount = 0;
		try {   
			totalCount = getSimpleJdbcTemplate().queryForInt(sql,new Object[] {HTID} );  
		} catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误,允许查询为空时,返回空字符串!");   
			       }   
		return totalCount;
	}
	
	//得到当前日期最大编号
	public String getMaxID(String deptID,String currDate) {
		int length = 0;
		if(deptID != null)
			length= deptID.length();
		
		String sql = "select  max(D_NUMBER) as dnumber  from CLZYDDXXB  where substr(D_NUMBER,0,"+length+") = '"+deptID+"' and LRRQ= '"+currDate+"'";	
		System.out.println(sql+currDate);
		String fcdydd = "";
		try {   
			fcdydd = (String)getJdbcTemplate().queryForObject(sql,  new Object[] {},String.class);
			       } catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return fcdydd;
	}

}
