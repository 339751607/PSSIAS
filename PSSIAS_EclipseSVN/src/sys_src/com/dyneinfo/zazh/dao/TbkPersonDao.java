/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

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
public class TbkPersonDao extends BaseSpringJdbcDao<TbkPerson,java.lang.String>{
	
	public Class getEntityClass() {
		return TbkPerson.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" XM as xm,"
				+" HJD as hjd,"
				+" SFZH as sfzh,"
				+" HM1 as hm1,"
				+" HM2 as hm2,"
				+" XB as xb,"
				+" BDATE as bdate,"
				+" JG as jg,"
				+" ZZ as zz,"
				+" SG as sg,"
				+" TX as tx,"
				+" TSTZ as tstz,"
				+" XH as xh,"
				+" AB as ab,"
				+" LADW as ladw,"
				+" LASJ as lasj,"
				+" PZR as pzr,"
				+" LXR as lxr,"
				+" LXDH as lxdh,"
				+" ZTSJ as ztsj,"
				+" JYAQ as jyaq,"
				+" TAF1 as taf1,"
				+" TAF2 as taf2,"
				+" TAF3 as taf3,"
				+" TAF4 as taf4,"
				+" TJH1 as tjh1,"
				+" TJH2 as tjh2,"
				+" TJH3 as tjh3,"
				+" TBDW as tbdw,"
				+" BKLX as bklx,"
				+" ALARM_TEL as alarmTel,"
				+" BKPZR as bkpzr,"
				+" CZR as czr,"
				+" BKSJ as bksj,"
				+" CANCELFLAG as cancelflag,"
				+" CANCELTIME as canceltime,"
				+" CANCELCAUSE as cancelcause,"
				+" CANCELNAME as cancelname,"
				+" d.DEPTNAME as deptname "
				+" from T_BK_PERSON t , SS_DEPT d "
				+" where  t.TBDW = d.deptid ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_BK_PERSON where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " AND ID=? ";
	}
	
	public void save(TbkPerson entity) {
		String sql = "insert into T_BK_PERSON " 
			 + " (ID,XM,HJD,SFZH,HM1,HM2,XB,BDATE,JG,ZZ,SG,TX,TSTZ,XH,AB,LADW,LASJ,PZR,LXR,LXDH,ZTSJ,JYAQ,TAF1,TAF2,TAF3,TAF4,TJH1,TJH2,TJH3,TBDW,BKLX,ALARM_TEL,BKPZR,CZR,BKSJ,CANCELFLAG,CANCELTIME,CANCELCAUSE,CANCELNAME) " 
			 + " values "
			 + " (:id,:xm,:hjd,:sfzh,:hm1,:hm2,:xb,:bdate,:jg,:zz,:sg,:tx,:tstz,:xh,:ab,:ladw,:lasj,:pzr,:lxr,:lxdh,:ztsj,:jyaq,:taf1,:taf2,:taf3,:taf4,:tjh1,:tjh2,:tjh3,:tbdw,:bklx,:alarmTel,:bkpzr,:czr,:bksj,:cancelflag,:canceltime,:cancelcause,:cancelname)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_BK_PERSON",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TbkPerson entity) {
		String sql = "update T_BK_PERSON set "
					+ " ID=:id,XM=:xm,HJD=:hjd,SFZH=:sfzh,HM1=:hm1,HM2=:hm2,XB=:xb,BDATE=:bdate,JG=:jg,ZZ=:zz,SG=:sg,TX=:tx,TSTZ=:tstz,XH=:xh,AB=:ab,LADW=:ladw,LASJ=:lasj,PZR=:pzr,LXR=:lxr,LXDH=:lxdh,ZTSJ=:ztsj,JYAQ=:jyaq,TAF1=:taf1,TAF2=:taf2,TAF3=:taf3,TAF4=:taf4,TJH1=:tjh1,TJH2=:tjh2,TJH3=:tjh3,TBDW=:tbdw,BKLX=:bklx,ALARM_TEL=:alarmTel,BKPZR=:bkpzr,CZR=:czr,BKSJ=:bksj,CANCELFLAG=:cancelflag,CANCELTIME=:canceltime,CANCELCAUSE=:cancelcause,CANCELNAME=:cancelname "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix()
				+ "/~ and t.XM like '%[xm]%' ~/"
				+ "/~ and t.HJD = '[hjd]' ~/"
				+ "/~ and t.SFZH like '%[sfzh]%' ~/"
				+ "/~ and t.HM1 = '[hm1]' ~/"
				+ "/~ and t.HM2 = '[hm2]' ~/"
				+ "/~ and t.XB = '[xb]' ~/"
				+ "/~ and t.BDATE = '[bdate]' ~/"
				+ "/~ and t.JG = '[jg]' ~/"
				+ "/~ and t.ZZ = '[zz]' ~/"
				+ "/~ and t.SG = '[sg]' ~/"
				+ "/~ and t.TX = '[tx]' ~/"
				+ "/~ and t.TSTZ = '[tstz]' ~/"
				+ "/~ and t.XH = '[xh]' ~/"
				+ "/~ and t.AB = '[ab]' ~/"
				+ "/~ and t.LADW = '[ladw]' ~/"
				+ "/~ and t.LASJ = '[lasj]' ~/"
				+ "/~ and t.PZR = '[pzr]' ~/"
				+ "/~ and t.LXR = '[lxr]' ~/"
				+ "/~ and t.LXDH = '[lxdh]' ~/"
				+ "/~ and t.ZTSJ = '[ztsj]' ~/"
				+ "/~ and t.JYAQ = '[jyaq]' ~/"
				+ "/~ and t.TAF1 = '[taf1]' ~/"
				+ "/~ and t.TAF2 = '[taf2]' ~/"
				+ "/~ and t.TAF3 = '[taf3]' ~/"
				+ "/~ and t.TAF4 = '[taf4]' ~/"
				+ "/~ and t.TJH1 = '[tjh1]' ~/"
				+ "/~ and t.TJH2 = '[tjh2]' ~/"
				+ "/~ and t.TJH3 = '[tjh3]' ~/"
				+ "/~ and t.TBDW = '[tbdw]' ~/"
				+ "/~ and t.BKLX = '[bklx]' ~/"
				+ "/~ and t.ALARM_TEL = '[alarmTel]' ~/"
				+ "/~ and t.BKPZR = '[bkpzr]' ~/"
				+ "/~ and t.CZR = '[czr]' ~/"
				+ "/~ and t.BKSJ = '[bksj]' ~/"
				+ "/~ and t.CANCELFLAG = '[cancelflag]' ~/"
				+ "/~ and t.CANCELTIME = '[canceltime]' ~/"
				+ "/~ and t.CANCELCAUSE = '[cancelcause]' ~/"
				+ "/~ and t.CANCELNAME = '[cancelname]' ~/"
				+ "/~ and d.DEPTSEQ like '%.[deptseq].%' ~/"
				+ " ORDER BY  t.BKSJ desc ";
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
	
	
	private String createSql = "insert into T_BK_PERSON " 
		 + " (ID,XM,HJD,SFZH,HM1,HM2,XB,BDATE,JG,ZZ,SG,TX,TSTZ,XH,AB,LADW,LASJ,PZR,LXR,LXDH,ZTSJ,JYAQ,TAF1,TAF2,TAF3,TAF4,TJH1,TJH2,TJH3,TBDW,BKLX,ALARM_TEL,BKPZR,CZR,BKSJ,CANCELFLAG,CANCELTIME,CANCELCAUSE,CANCELNAME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_BK_PERSON set "
		+ " ID=?,XM=?,HJD=?,SFZH=?,HM1=?,HM2=?,XB=?,BDATE=?,JG=?,ZZ=?,SG=?,TX=?,TSTZ=?,XH=?,AB=?,LADW=?,LASJ=?,PZR=?,LXR=?,LXDH=?,ZTSJ=?,JYAQ=?,TAF1=?,TAF2=?,TAF3=?,TAF4=?,TJH1=?,TJH2=?,TJH3=?,TBDW=?,BKLX=?,ALARM_TEL=?,BKPZR=?,CZR=?,BKSJ=?,CANCELFLAG=?,CANCELTIME=?,CANCELCAUSE=?,CANCELNAME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TbkPerson entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getXm());
						ps.setString(3, entity.getHjd());
						ps.setString(4, entity.getSfzh());
						ps.setString(5, entity.getHm1());
						ps.setString(6, entity.getHm2());
						ps.setString(7, entity.getXb());
						ps.setString(8, entity.getBdate());
						ps.setString(9, entity.getJg());
						ps.setString(10, entity.getZz());
						ps.setString(11, entity.getSg());
						ps.setString(12, entity.getTx());
						ps.setString(13, entity.getTstz());
						ps.setString(14, entity.getXh());
						ps.setString(15, entity.getAb());
						ps.setString(16, entity.getLadw());
						ps.setString(17, entity.getLasj());
						ps.setString(18, entity.getPzr());
						ps.setString(19, entity.getLxr());
						ps.setString(20, entity.getLxdh());
						ps.setString(21, entity.getZtsj());
						ps.setString(22, entity.getJyaq());
						ps.setString(23, entity.getTaf1());
						ps.setString(24, entity.getTaf2());
						ps.setString(25, entity.getTaf3());
						ps.setString(26, entity.getTaf4());
						ps.setString(27, entity.getTjh1());
						ps.setString(28, entity.getTjh2());
						ps.setString(29, entity.getTjh3());
						ps.setString(30, entity.getTbdw());
						ps.setString(31, entity.getBklx());
						ps.setString(32, entity.getAlarmTel());
						ps.setString(33, entity.getBkpzr());
						ps.setString(34, entity.getCzr());
						ps.setString(35, entity.getBksj());
						ps.setString(36, entity.getCancelflag());
						ps.setString(37, entity.getCanceltime());
						ps.setString(38, entity.getCancelcause());
						ps.setString(39, entity.getCancelname());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTbkPerson(final TbkPerson entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getXm());
				ps.setString(3, entity.getHjd());
				ps.setString(4, entity.getSfzh());
				ps.setString(5, entity.getHm1());
				ps.setString(6, entity.getHm2());
				ps.setString(7, entity.getXb());
				ps.setString(8, entity.getBdate());
				ps.setString(9, entity.getJg());
				ps.setString(10, entity.getZz());
				ps.setString(11, entity.getSg());
				ps.setString(12, entity.getTx());
				ps.setString(13, entity.getTstz());
				ps.setString(14, entity.getXh());
				ps.setString(15, entity.getAb());
				ps.setString(16, entity.getLadw());
				ps.setString(17, entity.getLasj());
				ps.setString(18, entity.getPzr());
				ps.setString(19, entity.getLxr());
				ps.setString(20, entity.getLxdh());
				ps.setString(21, entity.getZtsj());
				ps.setString(22, entity.getJyaq());
				ps.setString(23, entity.getTaf1());
				ps.setString(24, entity.getTaf2());
				ps.setString(25, entity.getTaf3());
				ps.setString(26, entity.getTaf4());
				ps.setString(27, entity.getTjh1());
				ps.setString(28, entity.getTjh2());
				ps.setString(29, entity.getTjh3());
				ps.setString(30, entity.getTbdw());
				ps.setString(31, entity.getBklx());
				ps.setString(32, entity.getAlarmTel());
				ps.setString(33, entity.getBkpzr());
				ps.setString(34, entity.getCzr());
				ps.setString(35, entity.getBksj());
				ps.setString(36, entity.getCancelflag());
				ps.setString(37, entity.getCanceltime());
				ps.setString(38, entity.getCancelcause());
				ps.setString(39, entity.getCancelname());
			}
		});
	}

	
	public void updateTbkPerson(final TbkPerson entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getXm());
				ps.setString(3, entity.getHjd());
				ps.setString(4, entity.getSfzh());
				ps.setString(5, entity.getHm1());
				ps.setString(6, entity.getHm2());
				ps.setString(7, entity.getXb());
				ps.setString(8, entity.getBdate());
				ps.setString(9, entity.getJg());
				ps.setString(10, entity.getZz());
				ps.setString(11, entity.getSg());
				ps.setString(12, entity.getTx());
				ps.setString(13, entity.getTstz());
				ps.setString(14, entity.getXh());
				ps.setString(15, entity.getAb());
				ps.setString(16, entity.getLadw());
				ps.setString(17, entity.getLasj());
				ps.setString(18, entity.getPzr());
				ps.setString(19, entity.getLxr());
				ps.setString(20, entity.getLxdh());
				ps.setString(21, entity.getZtsj());
				ps.setString(22, entity.getJyaq());
				ps.setString(23, entity.getTaf1());
				ps.setString(24, entity.getTaf2());
				ps.setString(25, entity.getTaf3());
				ps.setString(26, entity.getTaf4());
				ps.setString(27, entity.getTjh1());
				ps.setString(28, entity.getTjh2());
				ps.setString(29, entity.getTjh3());
				ps.setString(30, entity.getTbdw());
				ps.setString(31, entity.getBklx());
				ps.setString(32, entity.getAlarmTel());
				ps.setString(33, entity.getBkpzr());
				ps.setString(34, entity.getCzr());
				ps.setString(35, entity.getBksj());
				ps.setString(36, entity.getCancelflag());
				ps.setString(37, entity.getCanceltime());
				ps.setString(38, entity.getCancelcause());
				ps.setString(39, entity.getCancelname());
			}
		});
	}

	
	public void deleteTbkPerson(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public Number getSeq(){
		String sql = " select SEQ_T_BK_PERSON.nextval from dual";
		return getSimpleJdbcTemplate().queryForInt(sql);
	}
	
	//图片id是否存在
	public int getPicIDIsExist(String KBID) {
		String sql = "select count(BKID) as   from T_BK_PERSON_PIC  where BKID = ?  ";
		// System.out.println("getPicIDIsExist="+sql);
		int totalCount = 0;
		try {
			totalCount = getSimpleJdbcTemplate().queryForInt(sql, new Object[] { KBID });
		} catch (EmptyResultDataAccessException ex) {
			logger.error("忽略此类错误,允许查询为空时,返回空字符串!");
		}
		return totalCount;
	}

	public void savePic(File file ,String BKID) throws IOException{

		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = BKID;

		getJdbcTemplate().execute(
		  "INSERT INTO T_BK_PERSON_PIC (ID , BKID, PICTURE ) VALUES (SEQ_T_BK_PERSON_PIC.nextval,?, ? )",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {
		    	  
		        ps.setString(1, str_id);		     
		        lobCreator.setBlobAsBinaryStream(ps, 2, blobIs, (int)blobIn.length());	
		        
		      }
		  }
		);
		blobIs.close();		
	}
	
	public void updatePic(File file , String BKID) throws IOException{

		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		final String str_id = BKID;
		getJdbcTemplate().execute(
		  " update T_BK_PERSON_PIC set PICTURE =? where BKID =? ",
		  new AbstractLobCreatingPreparedStatementCallback(lobhandler) {                         
		      protected void setValues(PreparedStatement ps, LobCreator lobCreator) 
		          throws SQLException {		       
		    	  
		        lobCreator.setBlobAsBinaryStream(ps, 1, blobIs, (int)blobIn.length()); 
		        ps.setString(2, str_id);
		        
		      }
		  }
		);
		blobIs.close();
		//clobReader.close();		
	}
	
	public List getPic(String ID) {
		String sql = "select BKID,  PICTURE from T_BK_PERSON_PIC where BKID = ? ";
	
	       return getJdbcTemplate().query(sql, new String[] {ID}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
			      //  String clobText = lobhandler.getClobAsString(rs, "PICTURE");                      
			      //  results.put("PICTURE", clobText);
	        	    String ID = rs.getString(1);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "PICTURE");                      
			        results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        results.put("LENGTH", blobBytes.length);
			        return results;
	           }
	           
	       });
	   }
}
