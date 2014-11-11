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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;


import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.dyneinfo.fjy.model.*;
import com.dyneinfo.fjy.dao.*;
import com.dyneinfo.fjy.dao.TemployeeDao.ItemMapper;
import com.dyneinfo.fjy.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TfeijiuwupinDao extends BaseSpringJdbcDao<Tfeijiuwupin,java.lang.String>{
	
	public Class getEntityClass() {
		return Tfeijiuwupin.class;
	}
	
	public String getIdentifierPropertyName() {
		return "wupinxh";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" WUPINXH as wupinxh,"
				+" WUPINMC as wupinmc,"
				+" WUPINLB as wupinlb,"
				+" SHOUGOURQ as shougourq,"
				+" SHOUGOURY as shougoury,"
				+" CHUSHOURY as chushoury,"
				+" CHUSHOURENXB as chushourenxb,"
				+" CHUSHOURENSFZH as chushourensfzh,"
				+" BEIZHU as beizhu,"
				+" ISKEYI as iskeyi,"
				+" CSRLXDH as csrlxdh,"
				+" JBR as jbr,"
				+" JBRSFZH as jbrsfzh,"
				+" JBRLXDH as jbrlxdh,"
				+" SGWPSL as sgwpsl,"
				+" SGWPGG as sgwpgg,"
				+" SGR as sgr,"
				+" SGRLXDH as sgrlxdh,"
				+" WPYS as wpys,"
				+" WPPP as wppp,"
				+" WPXZ as wpxz,"
				+" WPSF as wpsf,"
				+" WPDX as wpdx,"
				+" CASE WHEN WPZL>=1 THEN TO_CHAR(WPZL) ELSE TO_CHAR(WPZL,'0.99') END as wpzl,"
				+" WPBZ as wpbz,"
				+" WPTZ as wptz,"
				+" WPCD as wpcd,"
				+" zlone as zlone,"
				+" zltwo as zltwo,"
				+" CASE WHEN unitprice>=1 THEN TO_CHAR(unitprice) ELSE TO_CHAR(unitprice,'0.99') END  as unitprice,"
				+" CASE WHEN totalprice>=1 THEN TO_CHAR(totalprice) ELSE TO_CHAR(totalprice,'0.99') END  as totalprice,"
				+" zlthree as zlthree,"
				+" zlfour as zlfour,"
				+" x.csrxm as csrxm,"
				+" x.csrxb as csrxb,"
				+" x.csrdh as chushourenlxdh,"
				+" x.npcode as npcode,"
				+" x.npaddress as npaddress,"
				+" x.PRADDRESS as praddress,"
				+" x.hjaddress as hjaddress,"
				+" t.CPCODE as cpcode,"
				+" b.deptname as deptname,"
				+" c.empname as empname "
				+" from T_FEIJIUWUPIN t , ss_dept b, T_EMPLOYEE c ,t_csrxx x where t.cpcode = x.cpcode(+) and  t.CPCODE = b.deptid(+) and t.shougoury  = c.empcode(+)  and t.chushourensfzh=x.idcard(+) ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_FEIJIUWUPIN where WUPINXH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " and  WUPINXH=? ";
	}
	
	public void save(Tfeijiuwupin entity) {
		String sql = "insert into T_FEIJIUWUPIN " 
			 + " (WUPINXH,WUPINMC,WUPINLB,SHOUGOURQ,SHOUGOURY,CHUSHOURENSFZH,BEIZHU,ISKEYI,CSRLXDH,JBR,JBRSFZH,JBRLXDH,SGWPSL,SGWPGG,SGR,SGRLXDH,WPYS,WPPP,WPXZ,WPSF,WPDX,WPZL,WPBZ,WPTZ,WPCD,CPCODE,userid,zlone,zltwo,zlthree,zlfour,unitprice,totalprice) " 
			 + " values "
			 + " (:wupinxh,:wupinmc,:wupinlb,:shougourq,:shougoury,:chushourensfzh,:beizhu,:iskeyi,:csrlxdh,:jbr,:jbrsfzh,:jbrlxdh,:sgwpsl,:sgwpgg,:sgr,:sgrlxdh,:wpys,:wppp,:wpxz,:wpsf,:wpdx,:wpzl,:wpbz,:wptz,:wpcd,:cpcode,:userid,:zlone,:zltwo,:zlthree,:zlfour,:unitprice,:totalprice)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_FEIJIUWUPIN",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Tfeijiuwupin entity) {
		String sql = "update T_FEIJIUWUPIN set "
					+ " WUPINXH=:wupinxh,WUPINMC=:wupinmc,WUPINLB=:wupinlb,SHOUGOURQ=:shougourq,SHOUGOURY=:shougoury,CHUSHOURENSFZH=:chushourensfzh,BEIZHU=:beizhu,ISKEYI=:iskeyi,CSRLXDH=:csrlxdh,JBR=:jbr,JBRSFZH=:jbrsfzh,JBRLXDH=:jbrlxdh,SGWPSL=:sgwpsl,SGWPGG=:sgwpgg,SGR=:sgr,SGRLXDH=:sgrlxdh,WPYS=:wpys,WPPP=:wppp,WPXZ=:wpxz,WPSF=:wpsf,WPDX=:wpdx,WPZL=:wpzl,WPBZ=:wpbz,WPTZ=:wptz,WPCD=:wpcd,CPCODE=:cpcode,zlone=:zlone,zltwo=:zltwo,zlthree=:zlthree,zlfour=:zlfour "
					+ " where WUPINXH=:wupinxh";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest ,String deptseq) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " and b.DEPTSEQ like '"+deptseq+"'||'%' "
				+ "/~ and t.WUPINMC like '%'||{wupinmc}||'%' ~/"
				+ "/~ and t.WUPINLB = ''||{wupinlb}||'' ~/"
				+ "/~ and t.SHOUGOURQ >= ''||{shougourqBeginFormat}||'' ~/"
				+ "/~ and t.SHOUGOURQ <= ''||{shougourqEndFormat}||'' ~/"
				+ "/~ and t.SHOUGOURY = '%'||{shougoury}||'%' ~/"
				+ "/~ and x.csrxm like '%'||{csrxm}||'%' ~/"
				+ "/~ and x.csrxb = ''||{csrxb}||'' ~/"
				+ "/~ and t.CHUSHOURENSFZH like '%'||{chushourensfzh}||'%' ~/"
				+ "/~ and t.BEIZHU = ''||{beizhu}||'' ~/"
				+ "/~ and t.CHUSHOURENLXDH = ''||{chushourenlxdh}||'' ~/"
				+ "/~ and t.ISKEYI = ''||{iskeyi}||'' ~/"
				+ "/~ and t.CSRLXDH = ''||{csrlxdh}||'' ~/"
				+ "/~ and t.JBR = ''||{jbr}||'' ~/"
				+ "/~ and t.JBRSFZH = ''||{jbrsfzh}||'' ~/"
				+ "/~ and t.JBRLXDH = ''||{jbrlxdh}||'' ~/"
				+ "/~ and t.SGWPSL = ''||{sgwpsl}||'' ~/"
				+ "/~ and t.SGWPGG = ''||{sgwpgg}||'' ~/"
				+ "/~ and c.empname like '%'||{empname}||'%' ~/"
				+ "/~ and t.SGRLXDH = ''||{sgrlxdh}||'' ~/"
				+ "/~ and t.WPYS = ''||{wpys}||'' ~/"
				+ "/~ and t.WPPP = ''||{wppp}||'' ~/"
				+ "/~ and t.WPXZ = ''||{wpxz}||'' ~/"
				+ "/~ and t.WPSF = ''||{wpsf}||'' ~/"
				+ "/~ and t.WPDX = ''||{wpdx}||'' ~/"
				+ "/~ and t.WPBZ = ''||{wpbz}||'' ~/"
				+ "/~ and t.WPTZ = ''||{wptz}||'' ~/"
				+ "/~ and t.WPCD = ''||{wpcd}||'' ~/"
				+ "/~ and x.npcode like  {npcode}||'%' ~/"
				+ "/~ and x.npaddress like '%'||{npaddress}||'%' ~/"
				+ "/~ and x.praddress like '%'||{praddress}||'%' ~/"
				+ "/~ and x.hjaddress like '%'||{hjaddress}||'%' ~/"
				+ "/~ and t.CPCODE = {cpcode}  ~/"
				+ "/~ and b.DEPTSEQ like {orgseq}||'%' ~/"
				+" order by  "
				+ "/~ [sortColumns], ~/"
				+ "  wupinxh desc ";
		return pageQuery(sql,pageRequest);
	}
	public Page findQueryList(PageRequest<Map> pageRequest){
		//select t.chushoury,t.SHOUGOURY,sum(t.WPZL) as wpzl,t.CHUSHOURENSFZH,t.SHOUGOURQ,t.csrxb from v_cswp t group by t.CHUSHOURENSFZH, t.SHOUGOURQ ,t.SHOUGOURY,t.chushoury,t.csrxb
	
		String sql="select chushoury, SHOUGOURY, wpzl, CHUSHOURENSFZH, SHOUGOURQ, csrxb,deptseq,shougouryXm,npaddress,praddress"
			+"	from (select t.chushoury, "
			+"   t.SHOUGOURY,"
			+"   sum(t.WPZL) as wpzl,"
			+"   t.CHUSHOURENSFZH,"
			+"   t.SHOUGOURQ,"
			+"   t.csrxb,"
			+"   max(t.deptseq) as deptseq," 
			+"	 t.empname,max(npaddress) as npaddress,max(praddress) as praddress"
			+"   from v_cswp t"
			+"   group by t.CHUSHOURENSFZH, t.SHOUGOURQ, t.SHOUGOURY,t.chushoury,t.csrxb," +
			" t.empname) where 1=1"
			+ "/~ and DEPTSEQ like '%'||{deptseq}||'%'  ~/"
			+ "/~ and SHOUGOURQ >= ''||{shougourqBeginFormat}||'' ~/"
			+ "/~ and SHOUGOURQ <= ''||{shougourqEndFormat}||'' ~/"
			+ "/~ and CHUSHOURY like '%'||{chushoury}||'%' ~/"
			+ "/~ and CHUSHOURENSFZH like '%'||{chushourensfzh}||'%' ~/"
			+ "/~ and csrxb = ''||{csrxb}||'' ~/"
			+ "/~ and npaddress like '%'||{npaddress}||'%'  ~/"
			+ "/~ and praddress like '%'||{praddress}||'%'  ~/"
			+ "/~ and x.hjaddress like '%'||{hjaddress}||'%' ~/"
			+ "/~ and empname like '%'||{empname}||'%'  ~/"
		;
			
		return pageQuery(sql,pageRequest);
	}
	
	public Tfeijiuwupin getTpoliceCheckById(String wupinxh) {
		String sql =	"select  "
			+" WUPINXH as wupinxh,"
			+" WUPINMC as wupinmc,"
			+" WUPINLB as wupinlb,"
			+" SHOUGOURQ as shougourq,"
			+" SHOUGOURY as shougoury,"
			+" CHUSHOURY as chushoury,"
			+" CHUSHOURENXB as chushourenxb,"
			+" CHUSHOURENSFZH as chushourensfzh,"
			+" BEIZHU as beizhu,"
			+" ISKEYI as iskeyi,"
			+" CSRLXDH as csrlxdh,"
			+" JBR as jbr,"
			+" JBRSFZH as jbrsfzh,"
			+" JBRLXDH as jbrlxdh,"
			+" SGWPSL as sgwpsl,"
			+" SGWPGG as sgwpgg,"
			+" x.csrxm as csrxm,"
			+" SGRLXDH as sgrlxdh,"
			+" WPYS as wpys,"
			+" WPPP as wppp,"
			+" WPXZ as wpxz,"
			+" WPSF as wpsf,"
			+" WPDX as wpdx,"
			+" WPZL as wpzl,"
			+" WPBZ as wpbz,"
			+" WPTZ as wptz,"
			+" WPCD as wpcd,"
			+" x.csrxm as chushoury,"
			+" x.csrxb as csrxb,"
			+" x.csrdh as chushourenlxdh,"
			+" x.npcode as npcode,"
			+" x.npaddress as npaddress,"
			+" x.PRADDRESS as praddress,"
			+" x.hjaddress as hjaddress,"
			+" t.CPCODE as cpcode,"
			+" b.deptname as deptname,"
			+" c.fullname as empname"
			+" from T_FEIJIUWUPIN  a,ss_dept b,ss_user c ,t_csrxx x" 
			+" where a.CPCODE = b.deptid and a.shougoury  = c.username  and t.chushourensfzh=x.idcard" +
					"  and a.wupinxh = ?";
		Tfeijiuwupin feijiuwupin = null;
		try {   
			feijiuwupin = (Tfeijiuwupin)getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), new Object[] {wupinxh});
		} 
		catch (EmptyResultDataAccessException ex) {   
			           logger.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");   
		}   
		return feijiuwupin;
	}
	
	 public List<Tfeijiuwupin>  getFjwpList(String csrq,String sfzh){
		 String sql=getSelectPrefix()+" and chushoury=? and CHUSHOURENSFZH=?";
		 List list=new ArrayList();
			list = getJdbcTemplate().queryForList(sql, new Object[]{csrq,sfzh});
			return list;
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
	
	public long  getSeq(){
		OracleSequenceMaxValueIncrementer seq = new OracleSequenceMaxValueIncrementer(getDataSource(),"SEQ_FILE_ATTACH");
		Long id = seq.nextLongValue();
        return id;
	}
	
	
	private String createSql = "insert into T_FEIJIUWUPIN " 
		 + " (WUPINXH,WUPINMC,WUPINLB,SHOUGOURQ,SHOUGOURY,CHUSHOURENSFZH,BEIZHU,ISKEYI,CSRLXDH,JBR,JBRSFZH,JBRLXDH,SGWPSL,SGWPGG,SGR,SGRLXDH,WPYS,WPPP,WPXZ,WPSF,WPDX,WPZL,WPBZ,WPTZ,WPCD,CPCODE,userid) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_FEIJIUWUPIN set "
		+ " WUPINXH=?,WUPINMC=?,WUPINLB=?,SHOUGOURQ=?,SHOUGOURY=?,CHUSHOURENSFZH=?,BEIZHU=?,ISKEYI=?,CSRLXDH=?,JBR=?,JBRSFZH=?,JBRLXDH=?,SGWPSL=?,SGWPGG=?,SGR=?,SGRLXDH=?,WPYS=?,WPPP=?,WPXZ=?,WPSF=?,WPDX=?,WPZL=?,WPBZ=?,WPTZ=?,WPCD=?,CPCODE=? ,userid=?"
		+ " where WUPINXH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
	
	public void deleteTfeijiuwupin(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
public void savePic(byte[] file,byte[] file1,byte[] file2,Tfeijiuwupin entity) throws IOException{
		
		//final File blobIn = new File("spring2004.jpg");
		
		final byte[] f_file = file;
		final byte[] f_file1 = file1;
		final byte[] f_file2 = file2;


		String insertSql = "update T_FEIJIUWUPIN set DDRYZP = ? ,DWZP=?, DDRYSMZP=? where WUPINXH='"+entity.getWupinxh()+"' ";
 		
		
		
	
 		 
 		
		getJdbcTemplate().execute(
				insertSql,
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {

		           		lobCreator.setBlobAsBytes(ps,1,f_file);  
			           lobCreator.setBlobAsBytes(ps,2,f_file1);  
			           lobCreator.setBlobAsBytes(ps,3,f_file2);  

		        
		      }
		  }
		);

     
		
	}
	public Tfeijiuwupin getByrq(String rq,String sfzh){
	String sql="select chushoury, SHOUGOURY, wpzl, CHUSHOURENSFZH, SHOUGOURQ, csrxb,deptseq,shougouryXm from v_cswp where SHOUGOURQ=? and CHUSHOURENSFZH=?";
	Tfeijiuwupin tfeijiuwupin = null;
	try {
		tfeijiuwupin = (Tfeijiuwupin) getSimpleJdbcTemplate().queryForObject(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()),
				new Object[] { rq, sfzh});
	} catch (EmptyResultDataAccessException ex) {
		logger
				.error("忽略此类错误[EmptyResultDataAccessException],允许查询为空时,返回空字符串!");
	}
	return tfeijiuwupin;
	}
	// 取得照片
	public List getPic(String idcard) {
		String sql = "select idcard,cpcode,PIC from t_csrxx p where idcard = ? ";
		  return getJdbcTemplate().query(sql, new String[] {idcard}, new RowMapper() {
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
	//从业人员基本信息 图片id是否存在
	public List getPicIDIsExist(String idcard) {
		String sql = "select idcard,cpcode,PIC from t_csrxx p where idcard = ? and pic is not null";
		  return getJdbcTemplate().query(sql, new String[] {idcard}, new RowMapper() {
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
	
	public List getPicddryzp(String idcard) {
		String sql = "select wupinxh,cpcode ,ddryzp from T_feijiuwupin p where WUPINXH = ? and ddryzp is not null";
		  return getJdbcTemplate().query(sql, new String[] {idcard}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    String ID = rs.getString(1);
	        	    Long LENGTH = rs.getLong(2);
	        	  
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "ddryzp");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", LENGTH);
			        
			        
			        return results;
	           }
	           
	       });
	}
	public List getPicdwzp(String idcard) {
		String sql = "select wupinxh,cpcode ,dwzp from T_feijiuwupin p where WUPINXH = ? and dwzp is not null";
		  return getJdbcTemplate().query(sql, new String[] {idcard}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	    Long LENGTH = rs.getLong(2);
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	  
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "dwzp");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", LENGTH);
			        
			        
			        return results;
	           }
	           
	       });
	}
	public List getPicddrysmzp(String idcard) {
		String sql = "select wupinxh,cpcode ,ddrysmzp from T_feijiuwupin p where WUPINXH = ? and ddrysmzp is not null";
		  return getJdbcTemplate().query(sql, new String[] {idcard}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	    Long LENGTH = rs.getLong(2);
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "ddrysmzp");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", LENGTH);
			        return results;
	           }
	           
	       });
	}
	

}
