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
public class TtjGuestRepeatDao extends BaseSpringJdbcDao<TtjGuestRepeat,java.lang.String>{
	
	public Class getEntityClass() {
		return TtjGuestRepeat.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectStr() {
		return "";
	}

	public String getSelectPrefix(String tableName) {
		return getSelectStr()
		+" from T_HOTEL hotel ,"+tableName+" t ";
	}
	public String getWhereStr() {
		return " ";
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
		return "";
	}
	
	public void save(TtjGuestRepeat entity) {
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
	
	public void update(TtjGuestRepeat entity) {
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
		String sql = "";
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}
	public Page findByPageRequest(PageRequest<Map> pageRequest,String tableName) {
		String sql = ""
			+ "select * "
			+ "  from (select id_name idName, "
			+ "               id_code idCode, "
			+ "               count(id) inCount, "
			+ "               (select t.NAME "
			+ "                  from "+ tableName +" t "
			+ "                 where t.ID_NAME = c.ID_NAME "
			+ "                   and t.id_code = c.id_code "
			+ "                   and rownum = 1) as name "
			+ "          from "+ tableName +" c "
			+ "         where 1 = 1 "
			+ "/~ and in_time >= '[inTime_BeginFormat]' ~/"
			+ "/~ and in_time <= '[inTime_EndFormat]' ~/"
			+ "/~ and BUR_CODE = '[burCode]' ~/"
			+ "/~ and sta_code = '[staCode]' ~/"
			+ "         group by id_name, id_code) "
			+ " where 1 = 1 "
			+ "/~ and inCount >= '[inCount]' ~/"
			+ "/~ order by [sortColumns] ~/";
		
		Page page = pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
		return page;
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
		
	
	

	

	
	public void deleteTchPre(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}

	
	public Page findByPageRequest(PageRequest<Map> pageRequest, TtjGuestRepeat tchPre) {
		String sql = "";
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}

	public TtjGuestRepeat getTchPreById(String id) {
		List list = getSimpleJdbcTemplate().query(getFindByIdSql(), ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), id,id,id );
		return (TtjGuestRepeat)CollectionHelper.findSingleObject(list);
	}



	
	
	

}
