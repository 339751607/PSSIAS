/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.hotel.model.TchPre;
import com.dyneinfo.hotel.model.TchTrack;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TchTrackDao extends BaseSpringJdbcDao<TchTrack,java.lang.String>{
	
	public Class getEntityClass() {
		return TchTrack.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectStr() {
		return "select " 
		+" SEX as sex,"
		+" hotelid as hotelid,"
		+" NO_ROOM as noRoom,"
		+" BDATE as bdate,"
		+" in_time as inTime,"
		+" sta_code as staCode,"
		+" NAME as name,"
		+" ID_NAME as idName,"
		+" ID_CODE as idCode,"
		+" guesttype as guesttype";
	}
	public String getSelectPrefix() {
		return getSelectStr() + " from V_ALL_GUEST t ";
	}
	public String getWhereStr() {
		return " where 1=1 "
		+ "/~ and t.NAME like '%[name]%' ~/"
		+ "/~ and t.ID_CODE like '%[idCode]%' ~/"
		+ "/~ and t.IN_TIME >= '[inTime_BeginFormat]' ~/"
		+ "/~ and t.IN_TIME <= '[inTime_EndFormat]' ~/"
		+ " group by name, id_name, id_code, guesttype)" 
		+ "/~ order by [sortColumns] ~/";
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
		return getSelectPrefix() + " where and ID=? ";
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
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + getWhereStr();
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

	public void save(TchTrack entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(TchTrack entity) {
		// TODO Auto-generated method stub
		
	}

	public Page findByPageRequest(String sql ,PageRequest<Map> pageRequest) {
		return pageGroupQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));	
	}


	
	
	

}
