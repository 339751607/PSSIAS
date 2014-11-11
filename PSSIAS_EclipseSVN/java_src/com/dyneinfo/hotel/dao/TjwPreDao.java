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

import org.springframework.dao.DataAccessException;
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

import com.dyneinfo.hotel.model.*;
import com.dyneinfo.hotel.dao.*;
import com.dyneinfo.hotel.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TjwPreDao extends BaseSpringJdbcDao<TjwPre,java.lang.String>{
	
	public Class getEntityClass() {
		return TjwPre.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectStr() {
		return "select  "
		+" t.ID as id,"
		+" t.X_SN as xsn,"
		+" t.M_FN as mfn,"
		+" t.CHN_N as chnN,"
		+" t.SEX as sex,"
		+" t.BDATE as bdate,"
		+" t.P_NATIONAL as pnational,"
		+" t.PASS_T as passT,"
		+" t.PASS_NO as passNo,"
		+" t.VISA_T as visaT,"
		+" t.VISA_NO as visaNo,"
		+" t.STAY_DATE as stayDate,"
		+" t.QF_UNIT as qfUnit,"
		+" t.IN_DATE as inDate,"
		+" t.IN_PORT as inPort,"
		+" t.P_ADDRESS as paddress,"
		+" t.JD_UNIT as jdUnit,"
		+" t.IN_TIME as inTime,"
		+" t.NO_ROOM as noRoom,"
		+" t.OUT_TIME as outTime,"
		+" t.TRA_TIME as traTime,"
		+" t.PLACE as place,"
		+" t.CREDIT_CODE as creditCode,"
		+" t.CREDIT_NO as creditNo,"
		+" t.STA_CODE as staCode,"
		+" t.BUR_CODE as burCode,"
		+" t.SPM as spm,"
		+" t.INSERT_TIME as insertTime,"
		+" t.MEMO as memo,"
		+" t.REASON as reason,"
		+" t.HOTELID as hotelid,"
		+" hotel.called as hotelname ";
	}

	public String getSelectPrefix() {
		return getSelectStr()+" from T_HOTEL hotel, V_JW_ALL t ";
	}
	public String getSelectPrefix(String tableName) {
		return getSelectStr()+" from T_HOTEL hotel, "+tableName+" t ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_JW_PRE where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where t.hotelid=hotel.code(+) and ID=? ";
	}
	
	public void save(TjwPre entity) {
		String sql = "insert into T_JW_PRE " 
			 + " (ID,X_SN,M_FN,CHN_N,SEX,BDATE,P_NATIONAL,PASS_T,PASS_NO,VISA_T,VISA_NO,STAY_DATE,QF_UNIT,IN_DATE,IN_PORT,P_ADDRESS,JD_UNIT,IN_TIME,NO_ROOM,OUT_TIME,TRA_TIME,PLACE,CREDIT_CODE,CREDIT_NO,STA_CODE,BUR_CODE,SPM,INSERT_TIME,MEMO,REASON,HOTELID,PDAFLAG,DRAGOMANAME,DRAGOMAPHONE,GROUPNO,TRANSFERFLAG,KYRY,FLAGTJ,DAYS,SFZH,ZJYXQ,OPERATOR,CITY_CODE,LEAVEDATE) " 
			 + " values "
			 + " (:id,:xsn,:mfn,:chnN,:sex,:bdate,:pnational,:passT,:passNo,:visaT,:visaNo,:stayDate,:qfUnit,:inDate,:inPort,:paddress,:jdUnit,:inTime,:noRoom,:outTime,:traTime,:place,:creditCode,:creditNo,:staCode,:burCode,:spm,:insertTime,:memo,:reason,:hotelid,:pdaflag,:dragomaname,:dragomaphone,:groupno,:transferflag,:kyry,:flagtj,:days,:sfzh,:zjyxq,:operator,:cityCode,:leavedate)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_JW_PRE",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TjwPre entity) {
		String sql = "update T_JW_PRE set "
					+ " ID=:id,X_SN=:xsn,M_FN=:mfn,CHN_N=:chnN,SEX=:sex,BDATE=:bdate,P_NATIONAL=:pnational,PASS_T=:passT,PASS_NO=:passNo,VISA_T=:visaT,VISA_NO=:visaNo,STAY_DATE=:stayDate,QF_UNIT=:qfUnit,IN_DATE=:inDate,IN_PORT=:inPort,P_ADDRESS=:paddress,JD_UNIT=:jdUnit,IN_TIME=:inTime,NO_ROOM=:noRoom,OUT_TIME=:outTime,TRA_TIME=:traTime,PLACE=:place,CREDIT_CODE=:creditCode,CREDIT_NO=:creditNo,STA_CODE=:staCode,BUR_CODE=:burCode,SPM=:spm,INSERT_TIME=:insertTime,MEMO=:memo,REASON=:reason,HOTELID=:hotelid,PDAFLAG=:pdaflag,DRAGOMANAME=:dragomaname,DRAGOMAPHONE=:dragomaphone,GROUPNO=:groupno,TRANSFERFLAG=:transferflag,KYRY=:kyry,FLAGTJ=:flagtj,DAYS=:days,SFZH=:sfzh,ZJYXQ=:zjyxq,OPERATOR=:operator,CITY_CODE=:cityCode,LEAVEDATE=:leavedate "
					+ " where ID=:id";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}
	public String getWhereStr() {
		return " where t.hotelid=hotel.code(+)"
		+ "/~ and t.X_SN = '[xsn]' ~/"
		+ "/~ and t.M_FN like '%'||upper('[mfn]')||'%' ~/"
		+ "/~ and t.CHN_N like '%[chnN]%' ~/"
		+ "/~ and t.SEX = '[sex]' ~/"
		+ "/~ and t.BDATE >= '[bdate_BeginFormat]' ~/"
		+ "/~ and t.BDATE <= '[bdate_EndFormat]' ~/"
		+ "/~ and t.P_NATIONAL = '[pnational]' ~/"
		+ "/~ and t.PASS_T = '[passT]' ~/"
		+ "/~ and t.PASS_NO like '%[passNo]%' ~/"
		+ "/~ and t.VISA_T = '[visaT]' ~/"
		+ "/~ and t.VISA_NO like '%[visaNo]%' ~/"
		+ "/~ and t.STAY_DATE >= '[stayDate_BeginFormat]' ~/"
		+ "/~ and t.STAY_DATE <= '[stayDate_EndFormat]' ~/"
		+ "/~ and t.QF_UNIT = '[qfUnit]' ~/"
		+ "/~ and t.IN_DATE >= '[inDate_BeginFormat]' ~/"
		+ "/~ and t.IN_DATE <= '[inDate_EndFormat]' ~/"
		+ "/~ and t.IN_PORT = '[inPort]' ~/"
		+ "/~ and t.P_ADDRESS = '[paddress]' ~/"
		+ "/~ and t.JD_UNIT = '[jdUnit]' ~/"
		+ "/~ and t.IN_TIME >= '[inTime_BeginFormat]' ~/"
		+ "/~ and t.IN_TIME <= '[inTime_EndFormat]' ~/"
		+ "/~ and t.NO_ROOM = '[noRoom]' ~/"
		+ "/~ and t.OUT_TIME >= '[outTime_BeginFormat]' ~/"
		+ "/~ and t.OUT_TIME <= '[outTime_EndFormat]' ~/"
		+ "/~ and t.TRA_TIME = '[traTime]' ~/"
		+ "/~ and t.PLACE = '[place]' ~/"
		+ "/~ and t.CREDIT_CODE = '[creditCode]' ~/"
		+ "/~ and t.CREDIT_NO = '[creditNo]' ~/"
		+ "/~ and t.STA_CODE = '[staCode]' ~/"
		+ "/~ and t.BUR_CODE = '[burCode]' ~/"
		+ "/~ and t.SPM = '[spm]' ~/"
		+ "/~ and t.INSERT_TIME = '[insertTime]' ~/"
		+ "/~ and t.MEMO = '[memo]' ~/"
		+ "/~ and t.REASON = '[reason]' ~/"
		+ "/~ and t.HOTELID = '[hotelid]' ~/"
		+ "/~ and hotel.called like '%[hotelname]%' ~/"
		+ "/~ order by [sortColumns] ~/";
	}
	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + getWhereStr();
		return pageQuery(sql,pageRequest);
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
	
	
	private String createSql = "insert into T_JW_PRE " 
		 + " (ID,X_SN,M_FN,CHN_N,SEX,BDATE,P_NATIONAL,PASS_T,PASS_NO,VISA_T,VISA_NO,STAY_DATE,QF_UNIT,IN_DATE,IN_PORT,P_ADDRESS,JD_UNIT,IN_TIME,NO_ROOM,OUT_TIME,TRA_TIME,PLACE,CREDIT_CODE,CREDIT_NO,STA_CODE,BUR_CODE,SPM,INSERT_TIME,MEMO,REASON,HOTELID,PDAFLAG,DRAGOMANAME,DRAGOMAPHONE,GROUPNO,TRANSFERFLAG,KYRY,FLAGTJ,DAYS,SFZH,ZJYXQ,OPERATOR,CITY_CODE,LEAVEDATE) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_JW_PRE set "
		+ " ID=?,X_SN=?,M_FN=?,CHN_N=?,SEX=?,BDATE=?,P_NATIONAL=?,PASS_T=?,PASS_NO=?,VISA_T=?,VISA_NO=?,STAY_DATE=?,QF_UNIT=?,IN_DATE=?,IN_PORT=?,P_ADDRESS=?,JD_UNIT=?,IN_TIME=?,NO_ROOM=?,OUT_TIME=?,TRA_TIME=?,PLACE=?,CREDIT_CODE=?,CREDIT_NO=?,STA_CODE=?,BUR_CODE=?,SPM=?,INSERT_TIME=?,MEMO=?,REASON=?,HOTELID=?,PDAFLAG=?,DRAGOMANAME=?,DRAGOMAPHONE=?,GROUPNO=?,TRANSFERFLAG=?,KYRY=?,FLAGTJ=?,DAYS=?,SFZH=?,ZJYXQ=?,OPERATOR=?,CITY_CODE=?,LEAVEDATE=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TjwPre entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getId());
						ps.setString(2, entity.getXsn());
						ps.setString(3, entity.getMfn());
						ps.setString(4, entity.getChnN());
						ps.setString(5, entity.getSex());
						ps.setString(6, entity.getBdate());
						ps.setString(7, entity.getPnational());
						ps.setString(8, entity.getPassT());
						ps.setString(9, entity.getPassNo());
						ps.setString(10, entity.getVisaT());
						ps.setString(11, entity.getVisaNo());
						ps.setString(12, entity.getStayDate());
						ps.setString(13, entity.getQfUnit());
						ps.setString(14, entity.getInDate());
						ps.setString(15, entity.getInPort());
						ps.setString(16, entity.getPaddress());
						ps.setString(17, entity.getJdUnit());
						ps.setString(18, entity.getInTime());
						ps.setString(19, entity.getNoRoom());
						ps.setString(20, entity.getOutTime());
						ps.setString(21, entity.getTraTime());
						ps.setString(22, entity.getPlace());
						ps.setString(23, entity.getCreditCode());
						ps.setString(24, entity.getCreditNo());
						ps.setString(25, entity.getStaCode());
						ps.setString(26, entity.getBurCode());
						ps.setString(27, entity.getSpm());
						ps.setString(28, entity.getInsertTime());
						ps.setString(29, entity.getMemo());
						ps.setString(30, entity.getReason());
						ps.setString(31, entity.getHotelid());
						ps.setString(32, entity.getPdaflag());
						ps.setString(33, entity.getDragomaname());
						ps.setString(34, entity.getDragomaphone());
						ps.setString(35, entity.getGroupno());
						ps.setLong(36, entity.getTransferflag());
						ps.setString(37, entity.getKyry());
						ps.setString(38, entity.getFlagtj());
						ps.setLong(39, entity.getDays());
						ps.setString(40, entity.getSfzh());
						ps.setString(41, entity.getZjyxq());
						ps.setString(42, entity.getOperator());
						ps.setString(43, entity.getCityCode());
						ps.setString(44, entity.getLeavedate());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTjwPre(final TjwPre entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getXsn());
				ps.setString(3, entity.getMfn());
				ps.setString(4, entity.getChnN());
				ps.setString(5, entity.getSex());
				ps.setString(6, entity.getBdate());
				ps.setString(7, entity.getPnational());
				ps.setString(8, entity.getPassT());
				ps.setString(9, entity.getPassNo());
				ps.setString(10, entity.getVisaT());
				ps.setString(11, entity.getVisaNo());
				ps.setString(12, entity.getStayDate());
				ps.setString(13, entity.getQfUnit());
				ps.setString(14, entity.getInDate());
				ps.setString(15, entity.getInPort());
				ps.setString(16, entity.getPaddress());
				ps.setString(17, entity.getJdUnit());
				ps.setString(18, entity.getInTime());
				ps.setString(19, entity.getNoRoom());
				ps.setString(20, entity.getOutTime());
				ps.setString(21, entity.getTraTime());
				ps.setString(22, entity.getPlace());
				ps.setString(23, entity.getCreditCode());
				ps.setString(24, entity.getCreditNo());
				ps.setString(25, entity.getStaCode());
				ps.setString(26, entity.getBurCode());
				ps.setString(27, entity.getSpm());
				ps.setString(28, entity.getInsertTime());
				ps.setString(29, entity.getMemo());
				ps.setString(30, entity.getReason());
				ps.setString(31, entity.getHotelid());
				ps.setString(32, entity.getPdaflag());
				ps.setString(33, entity.getDragomaname());
				ps.setString(34, entity.getDragomaphone());
				ps.setString(35, entity.getGroupno());
				ps.setLong(36, entity.getTransferflag());
				ps.setString(37, entity.getKyry());
				ps.setString(38, entity.getFlagtj());
				ps.setLong(39, entity.getDays());
				ps.setString(40, entity.getSfzh());
				ps.setString(41, entity.getZjyxq());
				ps.setString(42, entity.getOperator());
				ps.setString(43, entity.getCityCode());
				ps.setString(44, entity.getLeavedate());
			}
		});
	}

	
	public void updateTjwPre(final TjwPre entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getId());
				ps.setString(2, entity.getXsn());
				ps.setString(3, entity.getMfn());
				ps.setString(4, entity.getChnN());
				ps.setString(5, entity.getSex());
				ps.setString(6, entity.getBdate());
				ps.setString(7, entity.getPnational());
				ps.setString(8, entity.getPassT());
				ps.setString(9, entity.getPassNo());
				ps.setString(10, entity.getVisaT());
				ps.setString(11, entity.getVisaNo());
				ps.setString(12, entity.getStayDate());
				ps.setString(13, entity.getQfUnit());
				ps.setString(14, entity.getInDate());
				ps.setString(15, entity.getInPort());
				ps.setString(16, entity.getPaddress());
				ps.setString(17, entity.getJdUnit());
				ps.setString(18, entity.getInTime());
				ps.setString(19, entity.getNoRoom());
				ps.setString(20, entity.getOutTime());
				ps.setString(21, entity.getTraTime());
				ps.setString(22, entity.getPlace());
				ps.setString(23, entity.getCreditCode());
				ps.setString(24, entity.getCreditNo());
				ps.setString(25, entity.getStaCode());
				ps.setString(26, entity.getBurCode());
				ps.setString(27, entity.getSpm());
				ps.setString(28, entity.getInsertTime());
				ps.setString(29, entity.getMemo());
				ps.setString(30, entity.getReason());
				ps.setString(31, entity.getHotelid());
				ps.setString(32, entity.getPdaflag());
				ps.setString(33, entity.getDragomaname());
				ps.setString(34, entity.getDragomaphone());
				ps.setString(35, entity.getGroupno());
				ps.setLong(36, entity.getTransferflag());
				ps.setString(37, entity.getKyry());
				ps.setString(38, entity.getFlagtj());
				ps.setLong(39, entity.getDays());
				ps.setString(40, entity.getSfzh());
				ps.setString(41, entity.getZjyxq());
				ps.setString(42, entity.getOperator());
				ps.setString(43, entity.getCityCode());
				ps.setString(44, entity.getLeavedate());
			}
		});
	}

	
	public void deleteTjwPre(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public List getPic(String id) {
		String sql = "select id,picture from T_JW_PIC where id = ? ";
	       return getJdbcTemplate().query(sql, new String[] {id}, new RowMapper() {
	           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	    Map results = new HashMap();
	        	    String ID = rs.getString(1);
	        	   
		            byte[] blobBytes = lobhandler.getBlobAsBytes(rs, "picture");
		            results.put("PICTURE", blobBytes);
			        results.put("ID", ID);
			        return results;
	           }
	           
	       });
	   }
	

}
