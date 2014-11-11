/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.dao;

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

import net.java.dev.common.util.DateUtil;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TchPreDao extends BaseSpringJdbcDao<TchPre,java.lang.String>{
	
	public Class getEntityClass() {
		return TchPre.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectStr() {
		return "select  "
		+" t.ID as id,"
		+" t.NAME as name,"
		+" t.SEX as sex,"
		+" t.NATION as nation,"
		+" t.BDATE as bdate,"
		+" t.ID_NAME as idName,"
		+" t.ID_CODE as idCode,"
		+" t.XZQH as xzqh,"
		+" t.ADDRESS as address,"
		+" t.IN_TIME as inTime,"
		+" t.NO_ROOM as noRoom,"
		+" t.OUT_TIME as outTime,"
		+" t.TRA_TIME as traTime,"
		+" t.CREDIT_CODE as creditCode,"
		+" t.CREDIT_NO as creditNo,"
		+" t.STA_CODE as staCode,"
		+" t.BUR_CODE as burCode,"
		+" t.SPM as spm,"
		+" t.INSERT_TIME as insertTime,"
		+" t.MEMO as memo,"
		+" t.HOTELID as hotelid,"
		+" hotel.called as hotelname ";
	}

	public String getSelectPrefix(String tableName) {
		return getSelectStr()
		+" from T_HOTEL hotel ,"+tableName+" t ";
	}
	public String getWhereStr() {
		return " where t.hotelid=hotel.code(+)"
		+ "/~ and t.NAME like '%[name]%' ~/"
		+ "/~ and t.SEX = '[sex]' ~/"
		+ "/~ and t.NATION = '[nation]' ~/"
		+ "/~ and t.BDATE >= '[bdate_BeginFormat]' ~/"
		+ "/~ and t.BDATE <= '[bdate_EndFormat]' ~/"
		+ "/~ and t.ID_NAME = '[idName]' ~/"
		+ "/~ and t.ID_CODE like '%[idCode]%' ~/"
		+ "/~ and t.XZQH like substr('[province]',0,2)||'%' ~/"
		+ "/~ and t.XZQH like '[xzqh]' ~/"
		+ "/~ and t.ADDRESS = '[address]' ~/"
		+ "/~ and t.IN_TIME >= '[inTime_BeginFormat]' ~/"
		+ "/~ and t.IN_TIME <= '[inTime_EndFormat]' ~/"
		+ "/~ and t.NO_ROOM = '[noRoom]' ~/"
		+ "/~ and t.OUT_TIME >= '[outTime_BeginFormat]' ~/"
		+ "/~ and t.OUT_TIME <= '[outTime_EndFormat]' ~/"
		+ "/~ and t.TRA_TIME = '[traTime]' ~/"
		+ "/~ and t.CREDIT_CODE = '[creditCode]' ~/"
		+ "/~ and t.CREDIT_NO = '[creditNo]' ~/"
		+ "/~ and t.STA_CODE = '[staCode]' ~/"
		+ "/~ and t.BUR_CODE = '[burCode]' ~/"
		+ "/~ and t.SPM = '[spm]' ~/"
		+ "/~ and t.INSERT_TIME = '[insertTime]' ~/"
		+ "/~ and t.MEMO = '[memo]' ~/"
		+ "/~ and t.HOTELID = '[hotelid]' ~/"
		+ "/~ and t.PDAFLAG = '[pdaflag]' ~/"
		+ "/~ and t.DRAGOMANAME = '[dragomaname]' ~/"
		+ "/~ and t.DRAGOMAPHONE = '[dragomaphone]' ~/"
		+ "/~ and t.GROUPNO = '[groupno]' ~/"
		+ "/~ and t.KYRY = '[kyry]' ~/"
		+ "/~ and t.FLAGTJ = '[flagtj]' ~/"
		+ "/~ and t.DAYS = '[days]' ~/"
		+ "/~ and t.FLAGKY = '[flagky]' ~/"
		+ "/~ and t.KYTYPE = '[kytype]' ~/"
		+ "/~ and t.FLAGCQBF = '[flagcqbf]' ~/"
		+ "/~ and hotel.called like '%[hotelname]%' ~/"
		+ "/~ and t.CITY_CODE = '[cityCode]' ~/"
		+ "/~ and t.TLSY = '[tlsy]' ~/";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CH_PRE where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return 
		  getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_PRE t "
		+ " where t.hotelid=hotel.code(+) and ID=? "
		+ " union all "
		+ getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_REC t "
		+ " where t.hotelid=hotel.code(+) and ID=? "
		+ " union all "
		+ getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_HIS t "
		+ " where t.hotelid=hotel.code(+) and ID=? ";
	}
	
	public void save(TchPre entity) {
		String sql = "insert into T_CH_PRE " 
			 + " (ID,NAME,SEX,NATION,BDATE,ID_NAME,ID_CODE,XZQH,ADDRESS,IN_TIME,NO_ROOM,OUT_TIME,TRA_TIME,CREDIT_CODE,CREDIT_NO,STA_CODE,BUR_CODE,SPM,INSERT_TIME,MEMO,HOTELID,PDAFLAG,DRAGOMANAME,DRAGOMAPHONE,GROUPNO,KYRY,FLAGTJ,DAYS,FLAGKY,KYTYPE,FLAGCQBF,HOTELNAME,CITY_CODE,TLSY) " 
			 + " values "
			 + " (:id,:name,:sex,:nation,:bdate,:idName,:idCode,:xzqh,:address,:inTime,:noRoom,:outTime,:traTime,:creditCode,:creditNo,:staCode,:burCode,:spm,:insertTime,:memo,:hotelid,:pdaflag,:dragomaname,:dragomaphone,:groupno,:kyry,:flagtj,:days,:flagky,:kytype,:flagcqbf,:hotelname,:cityCode,:tlsy)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CH_PRE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TchPre entity) {
		String sql = "update T_CH_PRE set "
					+ " ID=:id,NAME=:name,SEX=:sex,NATION=:nation,BDATE=:bdate,ID_NAME=:idName,ID_CODE=:idCode,XZQH=:xzqh,ADDRESS=:address,IN_TIME=:inTime,NO_ROOM=:noRoom,OUT_TIME=:outTime,TRA_TIME=:traTime,CREDIT_CODE=:creditCode,CREDIT_NO=:creditNo,STA_CODE=:staCode,BUR_CODE=:burCode,SPM=:spm,INSERT_TIME=:insertTime,MEMO=:memo,HOTELID=:hotelid,PDAFLAG=:pdaflag,DRAGOMANAME=:dragomaname,DRAGOMAPHONE=:dragomaphone,GROUPNO=:groupno,KYRY=:kyry,FLAGTJ=:flagtj,DAYS=:days,FLAGKY=:flagky,KYTYPE=:kytype,FLAGCQBF=:flagcqbf,HOTELNAME=:hotelname,CITY_CODE=:cityCode,TLSY=:tlsy "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectStr() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = 
			getSelectStr()
		+ " from T_HOTEL hotel ,T_CH_PRE t "
		+ getWhereStr()
		+ " union all "
		+ getSelectStr()
		+ " from T_HOTEL hotel ,T_CH_REC t "
		+ getWhereStr()
		+ " union all "
		+ getSelectStr()
		+ " from T_HOTEL hotel ,T_CH_HIS t "
		+ getWhereStr()
		+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}
	public Page findByPageRequest(PageRequest<Map> pageRequest,String tableName) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix(tableName) + getWhereStr();
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
	
	
	private String createSql = "insert into T_CH_PRE " 
		 + " (ID,NAME,SEX,NATION,BDATE,ID_NAME,ID_CODE,XZQH,ADDRESS,IN_TIME,NO_ROOM,OUT_TIME,TRA_TIME,CREDIT_CODE,CREDIT_NO,STA_CODE,BUR_CODE,SPM,INSERT_TIME,MEMO,HOTELID,PDAFLAG,DRAGOMANAME,DRAGOMAPHONE,GROUPNO,KYRY,FLAGTJ,DAYS,FLAGKY,KYTYPE,FLAGCQBF,HOTELNAME,CITY_CODE,TLSY) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CH_PRE set "
		+ " ID=?,NAME=?,SEX=?,NATION=?,BDATE=?,ID_NAME=?,ID_CODE=?,XZQH=?,ADDRESS=?,IN_TIME=?,NO_ROOM=?,OUT_TIME=?,TRA_TIME=?,CREDIT_CODE=?,CREDIT_NO=?,STA_CODE=?,BUR_CODE=?,SPM=?,INSERT_TIME=?,MEMO=?,HOTELID=?,PDAFLAG=?,DRAGOMANAME=?,DRAGOMAPHONE=?,GROUPNO=?,KYRY=?,FLAGTJ=?,DAYS=?,FLAGKY=?,KYTYPE=?,FLAGCQBF=?,HOTELNAME=?,CITY_CODE=?,TLSY=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TchPre entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getName());
						ps.setString(3, entity.getSex());
						ps.setString(4, entity.getNation());
						ps.setString(5, entity.getBdate());
						ps.setString(6, entity.getIdName());
						ps.setString(7, entity.getIdCode());
						ps.setString(8, entity.getXzqh());
						ps.setString(9, entity.getAddress());
						ps.setString(10, entity.getInTime());
						ps.setString(11, entity.getNoRoom());
						ps.setString(12, entity.getOutTime());
						ps.setString(13, entity.getTraTime());
						ps.setString(14, entity.getCreditCode());
						ps.setString(15, entity.getCreditNo());
						ps.setString(16, entity.getStaCode());
						ps.setString(17, entity.getBurCode());
						ps.setString(18, entity.getSpm());
						ps.setString(19, entity.getInsertTime());
						ps.setString(20, entity.getMemo());
						ps.setString(21, entity.getHotelid());
						ps.setString(22, entity.getPdaflag());
						ps.setString(23, entity.getDragomaname());
						ps.setString(24, entity.getDragomaphone());
						ps.setString(25, entity.getGroupno());
						ps.setString(26, entity.getKyry());
						ps.setString(27, entity.getFlagtj());
						ps.setLong(28, entity.getDays());
						ps.setString(29, entity.getFlagky());
						ps.setString(30, entity.getKytype());
						ps.setString(31, entity.getFlagcqbf());
						ps.setString(32, entity.getHotelname());
						ps.setString(33, entity.getCityCode());
						ps.setString(34, entity.getTlsy());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTchPre(final TchPre entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getIdName());
				ps.setString(7, entity.getIdCode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setString(10, entity.getInTime());
				ps.setString(11, entity.getNoRoom());
				ps.setString(12, entity.getOutTime());
				ps.setString(13, entity.getTraTime());
				ps.setString(14, entity.getCreditCode());
				ps.setString(15, entity.getCreditNo());
				ps.setString(16, entity.getStaCode());
				ps.setString(17, entity.getBurCode());
				ps.setString(18, entity.getSpm());
				ps.setString(19, entity.getInsertTime());
				ps.setString(20, entity.getMemo());
				ps.setString(21, entity.getHotelid());
				ps.setString(22, entity.getPdaflag());
				ps.setString(23, entity.getDragomaname());
				ps.setString(24, entity.getDragomaphone());
				ps.setString(25, entity.getGroupno());
				ps.setString(26, entity.getKyry());
				ps.setString(27, entity.getFlagtj());
				ps.setLong(28, entity.getDays());
				ps.setString(29, entity.getFlagky());
				ps.setString(30, entity.getKytype());
				ps.setString(31, entity.getFlagcqbf());
				ps.setString(32, entity.getHotelname());
				ps.setString(33, entity.getCityCode());
				ps.setString(34, entity.getTlsy());
			}
		});
	}

	
	public void updateTchPre(final TchPre entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getName());
				ps.setString(3, entity.getSex());
				ps.setString(4, entity.getNation());
				ps.setString(5, entity.getBdate());
				ps.setString(6, entity.getIdName());
				ps.setString(7, entity.getIdCode());
				ps.setString(8, entity.getXzqh());
				ps.setString(9, entity.getAddress());
				ps.setString(10, entity.getInTime());
				ps.setString(11, entity.getNoRoom());
				ps.setString(12, entity.getOutTime());
				ps.setString(13, entity.getTraTime());
				ps.setString(14, entity.getCreditCode());
				ps.setString(15, entity.getCreditNo());
				ps.setString(16, entity.getStaCode());
				ps.setString(17, entity.getBurCode());
				ps.setString(18, entity.getSpm());
				ps.setString(19, entity.getInsertTime());
				ps.setString(20, entity.getMemo());
				ps.setString(21, entity.getHotelid());
				ps.setString(22, entity.getPdaflag());
				ps.setString(23, entity.getDragomaname());
				ps.setString(24, entity.getDragomaphone());
				ps.setString(25, entity.getGroupno());
				ps.setString(26, entity.getKyry());
				ps.setString(27, entity.getFlagtj());
				ps.setLong(28, entity.getDays());
				ps.setString(29, entity.getFlagky());
				ps.setString(30, entity.getKytype());
				ps.setString(31, entity.getFlagcqbf());
				ps.setString(32, entity.getHotelname());
				ps.setString(33, entity.getCityCode());
				ps.setString(34, entity.getTlsy());
			}
		});
	}

	
	public void deleteTchPre(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}

	public List getPic(String id) {
		String sql = "select id,picture from T_CH_PIC where id = ? ";
	       return getJdbcTemplate().query(sql, new String[] {id}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, 2);
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
	
	public Page findByPageRequest(PageRequest<Map> pageRequest, TchPre tchPre) {
		String sql = "";
		String outTime = tchPre.getOutTime();
		String inTime = tchPre.getInTime();
		String hotelid = tchPre.getHotelid();
		String roomNum = tchPre.getNoRoom();
		String pid = tchPre.getIdCode();
		if(null == outTime || outTime.equals("")){
			sql = ""
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_PRE t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and (t.OUT_TIME is null or t.OUT_TIME >= '"+ inTime +"')"
				+ " union all "
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_REC t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and (t.OUT_TIME is null or t.OUT_TIME >= '"+ inTime +"')"
				+ " union all "
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_HIS t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and (t.OUT_TIME is null or t.OUT_TIME >= '"+ inTime +"')";
		}else{
			sql = ""
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_PRE t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and ((t.OUT_TIME is null and t.in_time <= '"+ outTime +"') or "
				+ "       (t.out_time is not null and "
				+ "       (t.in_time <= '"+ outTime +"' and t.out_time >= '"+ inTime +"')))"
				+ " union all "
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_REC t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and ((t.OUT_TIME is null and t.in_time <= '"+ outTime +"') or "
				+ "       (t.out_time is not null and "
				+ "       (t.in_time <= '"+ outTime +"' and t.out_time >= '"+ inTime +"')))"
				+ " union all "
				+ getSelectStr()
				+ "  from T_HOTEL hotel, T_CH_HIS t "
				+ " where t.HOTELID = '"+ hotelid +"' "
				+ "   and t.hotelid=hotel.code(+) "
				+ "   and t.NO_ROOM = '"+ roomNum +"' "
				+ "   and t.ID_CODE != '"+ pid +"' "
				+ "   and ((t.OUT_TIME is null and t.in_time <= '"+ outTime +"') or "
				+ "       (t.out_time is not null and "
				+ "       (t.in_time <= '"+ outTime +"' and t.out_time >= '"+ inTime +"')))";
		}
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}


	public Page findByRoommates(PageRequest<Map> pageRequest, String roommates) {
		String sql = ""
		+ getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_PRE t "
		+ " where t.hotelid=hotel.code(+) and t.ID in ("+ roommates +")"
		+ " union all "
		+ getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_REC t "
		+ " where t.hotelid=hotel.code(+) and t.ID in ("+ roommates +")"
		+ " union all "
		+ getSelectStr() 
		+ " from T_HOTEL hotel ,T_CH_HIS t "
		+ " where t.hotelid=hotel.code(+) and t.ID in ("+ roommates +")"
		;
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}

	public TchPre getTchPreById(String id) {
		List list = getSimpleJdbcTemplate().query(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), id,id,id );
		return (TchPre)CollectionHelper.findSingleObject(list);
	}

	public boolean existCar(String enrolid) {
		boolean result = false;
		String sql = "select count(*) from T_CARINFO t where t.enrolid=" + enrolid;
		result = (1 == getJdbcTemplate().queryForInt(sql));
		return result;
	}


	
	
	

}
