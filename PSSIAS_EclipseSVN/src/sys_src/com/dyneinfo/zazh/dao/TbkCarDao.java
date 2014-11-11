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
public class TbkCarDao extends BaseSpringJdbcDao<TbkCar,java.lang.String>{
	
	public Class getEntityClass() {
		return TbkCar.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" ID as id,"
				+" CARCODE as carcode,"
				+" BODYCODE as bodycode,"
				+" ENGINECODE as enginecode,"
				+" CARTYPE as cartype,"
				+" BRAND as brand,"
				+" CARMODE as carmode,"
				+" COLOR as color,"
				+" CAROWNER as carowner,"
				+" BKPZR as bkpzr,"
				+" BKLX as bklx,"
				+" BKDW as bkdw,"
				+" BKSJ as bksj,"
				+" JYAQ as jyaq,"
				+" ALARMTEL as alarmtel,"
				+" OPERATOR as operator,"
				+" CANCELFLAG as cancelflag,"
				+" CANCELTIME as canceltime,"
				+" CANCELCAUSE as cancelcause,"
				+" CANCELNAME as cancelname,"
				+" d.DEPTNAME as deptname "
				+" from T_BK_CAR t , SS_DEPT d "
				+" where  t.BKDW = d.deptid ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_BK_CAR where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " AND ID=? ";
	}
	public Number getSeq(){
		String sql = " select SEQ_T_BK_CAR.nextval from dual";
		return getSimpleJdbcTemplate().queryForInt(sql);
	}
	
	public void save(TbkCar entity) {
		String sql = "insert into T_BK_CAR " 
			 + " (ID,CARCODE,BODYCODE,ENGINECODE,CARTYPE,BRAND,CARMODE,COLOR,CAROWNER,BKPZR,BKLX,BKDW,BKSJ,JYAQ,ALARMTEL,OPERATOR,CANCELFLAG,CANCELTIME,CANCELCAUSE,CANCELNAME) " 
			 + " values "
			 + " (:id,:carcode,:bodycode,:enginecode,:cartype,:brand,:carmode,:color,:carowner,:bkpzr,:bklx,:bkdw,:bksj,:jyaq,:alarmtel,:operator,:cancelflag,:canceltime,:cancelcause,:cancelname)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		//insertWithOracleSequence(entity,"SEQ_T_BK_CAR",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TbkCar entity) {
		String sql = "update T_BK_CAR set "
					+ " ID=:id,CARCODE=:carcode,BODYCODE=:bodycode,ENGINECODE=:enginecode,CARTYPE=:cartype,BRAND=:brand,CARMODE=:carmode,COLOR=:color,CAROWNER=:carowner,BKPZR=:bkpzr,BKLX=:bklx,BKDW=:bkdw,BKSJ=:bksj,JYAQ=:jyaq,ALARMTEL=:alarmtel,OPERATOR=:operator,CANCELFLAG=:cancelflag,CANCELTIME=:canceltime,CANCELCAUSE=:cancelcause,CANCELNAME=:cancelname "
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
				+ "/~ and t.CARCODE like '%[prefix]'||'[carcode]%' ~/"
				+ "/~ and t.BODYCODE = '[bodycode]' ~/"
				+ "/~ and t.ENGINECODE = '[enginecode]' ~/"
				+ "/~ and t.CARTYPE = '[cartype]' ~/"
				+ "/~ and t.BRAND = '[brand]' ~/"
				+ "/~ and t.CARMODE = '[carmode]' ~/"
				+ "/~ and t.COLOR = '[color]' ~/"
				+ "/~ and t.CAROWNER = '[carowner]' ~/"
				+ "/~ and t.BKPZR = '[bkpzr]' ~/"
				+ "/~ and t.BKLX = '[bklx]' ~/"
				+ "/~ and t.BKDW = '[bkdw]' ~/"
				+ "/~ and t.BKSJ = '[bksj]' ~/"
				+ "/~ and t.JYAQ = '[jyaq]' ~/"
				+ "/~ and t.ALARMTEL = '[alarmtel]' ~/"
				+ "/~ and t.OPERATOR = '[operator]' ~/"
				+ "/~ and t.CANCELFLAG = '[cancelflag]' ~/"
				+ "/~ and t.CANCELTIME = '[canceltime]' ~/"
				+ "/~ and t.CANCELCAUSE = '[cancelcause]' ~/"
				+ "/~ and t.CANCELNAME = '[cancelname]' ~/"
				+ "/~ and d.DEPTSEQ like '%.[deptseq].%' ~/"
				+ "  ORDER BY t.BKSJ DESC  ";
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
	
	
	private String createSql = "insert into T_BK_CAR " 
		 + " (ID,CARCODE,BODYCODE,ENGINECODE,CARTYPE,BRAND,CARMODE,COLOR,CAROWNER,BKPZR,BKLX,BKDW,BKSJ,JYAQ,ALARMTEL,OPERATOR,CANCELFLAG,CANCELTIME,CANCELCAUSE,CANCELNAME) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_BK_CAR set "
		+ " ID=?,CARCODE=?,BODYCODE=?,ENGINECODE=?,CARTYPE=?,BRAND=?,CARMODE=?,COLOR=?,CAROWNER=?,BKPZR=?,BKLX=?,BKDW=?,BKSJ=?,JYAQ=?,ALARMTEL=?,OPERATOR=?,CANCELFLAG=?,CANCELTIME=?,CANCELCAUSE=?,CANCELNAME=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TbkCar entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getCarcode());
						ps.setString(3, entity.getBodycode());
						ps.setString(4, entity.getEnginecode());
						ps.setString(5, entity.getCartype());
						ps.setString(6, entity.getBrand());
						ps.setString(7, entity.getCarmode());
						ps.setString(8, entity.getColor());
						ps.setString(9, entity.getCarowner());
						ps.setString(10, entity.getBkpzr());
						ps.setString(11, entity.getBklx());
						ps.setString(12, entity.getBkdw());
						ps.setString(13, entity.getBksj());
						ps.setString(14, entity.getJyaq());
						ps.setString(15, entity.getAlarmtel());
						ps.setString(16, entity.getOperator());
						ps.setString(17, entity.getCancelflag());
						ps.setString(18, entity.getCanceltime());
						ps.setString(19, entity.getCancelcause());
						ps.setString(20, entity.getCancelname());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTbkCar(final TbkCar entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getCarcode());
				ps.setString(3, entity.getBodycode());
				ps.setString(4, entity.getEnginecode());
				ps.setString(5, entity.getCartype());
				ps.setString(6, entity.getBrand());
				ps.setString(7, entity.getCarmode());
				ps.setString(8, entity.getColor());
				ps.setString(9, entity.getCarowner());
				ps.setString(10, entity.getBkpzr());
				ps.setString(11, entity.getBklx());
				ps.setString(12, entity.getBkdw());
				ps.setString(13, entity.getBksj());
				ps.setString(14, entity.getJyaq());
				ps.setString(15, entity.getAlarmtel());
				ps.setString(16, entity.getOperator());
				ps.setString(17, entity.getCancelflag());
				ps.setString(18, entity.getCanceltime());
				ps.setString(19, entity.getCancelcause());
				ps.setString(20, entity.getCancelname());
			}
		});
	}

	
	public void updateTbkCar(final TbkCar entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getCarcode());
				ps.setString(3, entity.getBodycode());
				ps.setString(4, entity.getEnginecode());
				ps.setString(5, entity.getCartype());
				ps.setString(6, entity.getBrand());
				ps.setString(7, entity.getCarmode());
				ps.setString(8, entity.getColor());
				ps.setString(9, entity.getCarowner());
				ps.setString(10, entity.getBkpzr());
				ps.setString(11, entity.getBklx());
				ps.setString(12, entity.getBkdw());
				ps.setString(13, entity.getBksj());
				ps.setString(14, entity.getJyaq());
				ps.setString(15, entity.getAlarmtel());
				ps.setString(16, entity.getOperator());
				ps.setString(17, entity.getCancelflag());
				ps.setString(18, entity.getCanceltime());
				ps.setString(19, entity.getCancelcause());
				ps.setString(20, entity.getCancelname());
			}
		});
	}

	
	public void deleteTbkCar(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	//图片id是否存在
	public int getPicIDIsExist(String KBID) {
		String sql = "select count(BKID) as   from T_BK_CAR_PIC  where BKID = ?  ";
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
		  "INSERT INTO T_BK_CAR_PIC (ID , BKID, PICTURE ) VALUES (SEQ_T_BK_CAR_PIC.nextval,?, ? )",
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
		  " update T_BK_CAR_PIC set PICTURE =? where BKID =? ",
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
		String sql = "select BKID,  PICTURE from T_BK_CAR_PIC where BKID = ? ";
	
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
