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
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
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
public class ThotelDao extends BaseSpringJdbcDao<Thotel,java.lang.String>{
	
	public Class getEntityClass() {
		return Thotel.class;
	}
	
	public String getIdentifierPropertyName() {
		return "code";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.CODE as code,"
				+" t.CALLED as called,"
				+" t.ADDRESS as address,"
				+" t.STA_CODE as staCode,"
				+" t.BUR_CODE as burCode,"
				+" t.STATUS as status,"
				+" t.MOD_TIME as modTime,"
				+" t.ROOM_NUM as roomNum,"
				+" t.BED_NUM as bedNum,"
				+" t.TEL as tel,"
				+" t.YWJK as ywjk,"
				+" t.FJBXX as fjbxx,"
				+" t.KTVWT as ktvwt,"
				+" t.FSCG as fscg,"
				+" t.SWZX as swzx,"
				+" t.SNF as snf,"
				+" t.BLQG as blqg,"
				+" t.YXJF as yxjf,"
				+" t.RZBZ as rzbz,"
				+" t.LEGAL_SFZH as legalSfzh,"
				+" t.I_CODE as icode,"
				+" t.SPECIAL_TIME as specialTime,"
				+" t.SPECIAL_UNIT as specialUnit,"
				+" t.TRANSFLAG as transflag,"
				+" t.CITY_CODE as cityCode,"
				+" t.OLD_CODE as oldCode,"
				+" t.NEW_CODE as newCode,"
				+" t.LGSYZ as lgsyz,"
				+" t.LGZL as lgzl,"
				+" t.LGWZ as lgwz,"
				+" t.CARDTYPE as cardtype,"
				+" t.AREA_CODE as areaCode,"
				+" t.ZRMJ as zrmj,"
				+" t.LEGAL_PERSON as legalPerson,"
				+" t.MANAGER as manager,"
				+" t.TEL_LEGAL as telLegal,"
				+" t.POLICE_MANAGER as policeManager,"
				+" t.POLICE_TEL as policeTel,"
				+" t.POLICEMEN as policemen,"
				+" t.STAR as star,"
				+" t.GRADE as grade,"
				+" t.SPECIAL_LICENCE as specialLicence,"
				+" t.POLICE_LICENCE as policeLicence,"
				+" t.SUITROOMS as suitrooms,"
				+" t.STANDARDROOMS as standardrooms,"
				+" t.DOUBLEROOMS as doublerooms,"
				+" t.SINGLEROOMS as singlerooms,"
				+" t.OTHERROOMS as otherrooms,"
				+" t.WORKMEN as workmen,"
				+" t.OTHERPLACEMEN as otherplacemen,"
				+" t.MONITOR_CONTROL as monitorControl,"
				+" t.COFFER as coffer,"
				+" t.TECH_DEFEND as techDefend,"
				+" t.THING_DEFEND as thingDefend,"
				+" t.KTV as ktv,"
				+" t.CHESSROOM as chessroom,"
				+" t.COMMERCE as commerce,"
				+" t.SAUNA as sauna,"
				+" t.BOWLING as bowling,"
				+" t.GAMEROOM as gameroom,"
				+" t.LOCKTYPE as locktype,"
				+" t.LOCKNAME as lockname,"
				+" t.BASICREMARK as basicremark,"
				+" t.KTV_ROOMS as ktvRooms,"
				+" t.KTV_MEN as ktvMen,"
				+" t.KTV_LICENCE as ktvLicence,"
				+" t.KTV_FIREPROOFING as ktvFireproofing,"
				+" t.KTV_MONITOR_CONTROL as ktvMonitorControl,"
				+" t.KTV_CONTRACTOR as ktvContractor,"
				+" t.KTV_NAME as ktvName,"
				+" t.KTV_TEL as ktvTel,"
				+" t.KTV_ID as ktvId,"
				+" t.CHESS_BOXES as chessBoxes,"
				+" t.CHESS_FIREPROOFING as chessFireproofing,"
				+" t.CHESS_MONITOR_CONTROL as chessMonitorControl,"
				+" t.CHESS_CONTRACTOR as chessContractor,"
				+" t.CHESS_NAME as chessName,"
				+" t.CHESS_TEL as chessTel,"
				+" t.CHESS_ID as chessId,"
				+" t.COMMERCE_COPY as commerceCopy,"
				+" t.COMMERCE_FAX as commerceFax,"
				+" t.COMMERCE_TYPED as commerceTyped,"
				+" t.COMMERCE_TICKET as commerceTicket,"
				+" t.COMMERCE_CONTRACTOR as commerceContractor,"
				+" t.COMMERCE_NAME as commerceName,"
				+" t.COMMERCE_TEL as commerceTel,"
				+" t.COMMERCE_ID as commerceId,"
				+" t.SAUNA_KNEAD as saunaKnead,"
				+" t.SAUNA_ROOMS as saunaRooms,"
				+" t.SAUNA_WORKMEN as saunaWorkmen,"
				+" t.SAUNA_CONTRACTOR as saunaContractor,"
				+" t.SAUNA_NAME as saunaName,"
				+" t.SAUNA_TEL as saunaTel,"
				+" t.SAUNA_ID as saunaId,"
				+" t.OTHERREMARK as otherremark,"
				+" t.DEVICE_TYPE as deviceType,"
				+" t.BA_TIME as baTime,"
				+" t.FRONT_MANAGER as frontManager,"
				+" t.FRDH as frdh,"
				+" t.LGXZ as lgxz,"
				+" t.TZHYXKZH as tzhyxkzh,"
				+" t.ZAXKZH as zaxkzh,"
				+" t.TFS as tfs,"
				+" t.BZFS as bzfs,"
				+" t.SRFS as srfs,"
				+" t.DRFS as drfs,"
				+" t.QTFS as qtfs,"
				+" t.RYZS as ryzs,"
				+" t.DGRS as dgrs,"
				+" t.MS as ms,"
				+" t.WFHG as wfhg,"
				+" t.JFHG as jfhg"
				+" from T_HOTEL ";
	}
	
	public String getSelectPrefixListOnly() {
		return "select distinct "
				+" t.CODE as code,"
				+" t.CALLED as called,"
				+" t.ADDRESS as address,"
				+" t.STA_CODE as staCode,"
				+" t.BUR_CODE as burCode,"
				+" t.STATUS as status,"
				+" t.MOD_TIME as modTime,"
				+" to_number(t.ROOM_NUM) as roomNum,"
				+" to_number(t.BED_NUM) as bedNum,"
				+" t.TEL as tel"
				+" from T_HOTEL ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_HOTEL t where CODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " t where CODE=? ";
	}
	
	public void save(Thotel entity) {
		String sql = "insert into T_HOTEL " 
			 + " (CODE,YWJK,FJBXX,KTVWT,FSCG,SWZX,SNF,BLQG,YXJF,RZBZ,LEGAL_SFZH,I_CODE,SPECIAL_TIME,SPECIAL_UNIT,TRANSFLAG,CITY_CODE,OLD_CODE,NEW_CODE,LGSYZ,LGZL,LGWZ,CARDTYPE,CALLED,AREA_CODE,ZRMJ,STA_CODE,BUR_CODE,LEGAL_PERSON,MANAGER,TEL_LEGAL,POLICE_MANAGER,ADDRESS,TEL,POLICE_TEL,POLICEMEN,STATUS,MOD_TIME,ROOM_NUM,BED_NUM,STAR,GRADE,SPECIAL_LICENCE,POLICE_LICENCE,SUITROOMS,STANDARDROOMS,DOUBLEROOMS,SINGLEROOMS,OTHERROOMS,WORKMEN,OTHERPLACEMEN,MONITOR_CONTROL,COFFER,TECH_DEFEND,THING_DEFEND,KTV,CHESSROOM,COMMERCE,SAUNA,BOWLING,GAMEROOM,LOCKTYPE,LOCKNAME,BASICREMARK,KTV_ROOMS,KTV_MEN,KTV_LICENCE,KTV_FIREPROOFING,KTV_MONITOR_CONTROL,KTV_CONTRACTOR,KTV_NAME,KTV_TEL,KTV_ID,CHESS_BOXES,CHESS_FIREPROOFING,CHESS_MONITOR_CONTROL,CHESS_CONTRACTOR,CHESS_NAME,CHESS_TEL,CHESS_ID,COMMERCE_COPY,COMMERCE_FAX,COMMERCE_TYPED,COMMERCE_TICKET,COMMERCE_CONTRACTOR,COMMERCE_NAME,COMMERCE_TEL,COMMERCE_ID,SAUNA_KNEAD,SAUNA_ROOMS,SAUNA_WORKMEN,SAUNA_CONTRACTOR,SAUNA_NAME,SAUNA_TEL,SAUNA_ID,OTHERREMARK,DEVICE_TYPE,BA_TIME,FRONT_MANAGER,FRDH,LGXZ,TZHYXKZH,ZAXKZH,TFS,BZFS,SRFS,DRFS,QTFS,RYZS,DGRS,MS,WFHG,JFHG) " 
			 + " values "
			 + " (:code,:ywjk,:fjbxx,:ktvwt,:fscg,:swzx,:snf,:blqg,:yxjf,:rzbz,:legalSfzh,:icode,:specialTime,:specialUnit,:transflag,:cityCode,:oldCode,:newCode,:lgsyz,:lgzl,:lgwz,:cardtype,:called,:areaCode,:zrmj,:staCode,:burCode,:legalPerson,:manager,:telLegal,:policeManager,:address,:tel,:policeTel,:policemen,:status,:modTime,:roomNum,:bedNum,:star,:grade,:specialLicence,:policeLicence,:suitrooms,:standardrooms,:doublerooms,:singlerooms,:otherrooms,:workmen,:otherplacemen,:monitorControl,:coffer,:techDefend,:thingDefend,:ktv,:chessroom,:commerce,:sauna,:bowling,:gameroom,:locktype,:lockname,:basicremark,:ktvRooms,:ktvMen,:ktvLicence,:ktvFireproofing,:ktvMonitorControl,:ktvContractor,:ktvName,:ktvTel,:ktvId,:chessBoxes,:chessFireproofing,:chessMonitorControl,:chessContractor,:chessName,:chessTel,:chessId,:commerceCopy,:commerceFax,:commerceTyped,:commerceTicket,:commerceContractor,:commerceName,:commerceTel,:commerceId,:saunaKnead,:saunaRooms,:saunaWorkmen,:saunaContractor,:saunaName,:saunaTel,:saunaId,:otherremark,:deviceType,:baTime,:frontManager,:frdh,:lgxz,:tzhyxkzh,:zaxkzh,:tfs,:bzfs,:srfs,:drfs,:qtfs,:ryzs,:dgrs,:ms,:wfhg,:jfhg)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_HOTEL",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Thotel entity) {
		String sql = "update T_HOTEL set "
					+ " CODE=:code,YWJK=:ywjk,FJBXX=:fjbxx,KTVWT=:ktvwt,FSCG=:fscg,SWZX=:swzx,SNF=:snf,BLQG=:blqg,YXJF=:yxjf,RZBZ=:rzbz,LEGAL_SFZH=:legalSfzh,I_CODE=:icode,SPECIAL_TIME=:specialTime,SPECIAL_UNIT=:specialUnit,TRANSFLAG=:transflag,CITY_CODE=:cityCode,OLD_CODE=:oldCode,NEW_CODE=:newCode,LGSYZ=:lgsyz,LGZL=:lgzl,LGWZ=:lgwz,CARDTYPE=:cardtype,CALLED=:called,AREA_CODE=:areaCode,ZRMJ=:zrmj,STA_CODE=:staCode,BUR_CODE=:burCode,LEGAL_PERSON=:legalPerson,MANAGER=:manager,TEL_LEGAL=:telLegal,POLICE_MANAGER=:policeManager,ADDRESS=:address,TEL=:tel,POLICE_TEL=:policeTel,POLICEMEN=:policemen,STATUS=:status,MOD_TIME=:modTime,ROOM_NUM=:roomNum,BED_NUM=:bedNum,STAR=:star,GRADE=:grade,SPECIAL_LICENCE=:specialLicence,POLICE_LICENCE=:policeLicence,SUITROOMS=:suitrooms,STANDARDROOMS=:standardrooms,DOUBLEROOMS=:doublerooms,SINGLEROOMS=:singlerooms,OTHERROOMS=:otherrooms,WORKMEN=:workmen,OTHERPLACEMEN=:otherplacemen,MONITOR_CONTROL=:monitorControl,COFFER=:coffer,TECH_DEFEND=:techDefend,THING_DEFEND=:thingDefend,KTV=:ktv,CHESSROOM=:chessroom,COMMERCE=:commerce,SAUNA=:sauna,BOWLING=:bowling,GAMEROOM=:gameroom,LOCKTYPE=:locktype,LOCKNAME=:lockname,BASICREMARK=:basicremark,KTV_ROOMS=:ktvRooms,KTV_MEN=:ktvMen,KTV_LICENCE=:ktvLicence,KTV_FIREPROOFING=:ktvFireproofing,KTV_MONITOR_CONTROL=:ktvMonitorControl,KTV_CONTRACTOR=:ktvContractor,KTV_NAME=:ktvName,KTV_TEL=:ktvTel,KTV_ID=:ktvId,CHESS_BOXES=:chessBoxes,CHESS_FIREPROOFING=:chessFireproofing,CHESS_MONITOR_CONTROL=:chessMonitorControl,CHESS_CONTRACTOR=:chessContractor,CHESS_NAME=:chessName,CHESS_TEL=:chessTel,CHESS_ID=:chessId,COMMERCE_COPY=:commerceCopy,COMMERCE_FAX=:commerceFax,COMMERCE_TYPED=:commerceTyped,COMMERCE_TICKET=:commerceTicket,COMMERCE_CONTRACTOR=:commerceContractor,COMMERCE_NAME=:commerceName,COMMERCE_TEL=:commerceTel,COMMERCE_ID=:commerceId,SAUNA_KNEAD=:saunaKnead,SAUNA_ROOMS=:saunaRooms,SAUNA_WORKMEN=:saunaWorkmen,SAUNA_CONTRACTOR=:saunaContractor,SAUNA_NAME=:saunaName,SAUNA_TEL=:saunaTel,SAUNA_ID=:saunaId,OTHERREMARK=:otherremark,DEVICE_TYPE=:deviceType,BA_TIME=:baTime,FRONT_MANAGER=:frontManager,FRDH=:frdh,LGXZ=:lgxz,TZHYXKZH=:tzhyxkzh,ZAXKZH=:zaxkzh,TFS=:tfs,BZFS=:bzfs,SRFS=:srfs,DRFS=:drfs,QTFS=:qtfs,RYZS=:ryzs,DGRS=:dgrs,MS=:ms,WFHG=:wfhg,JFHG=:jfhg "
					+ " where CODE=:code";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String sql = getSelectPrefix() + " t where 1=1 "
				+ "/~ and t.YWJK = '[ywjk]' ~/"
				+ "/~ and t.FJBXX = '[fjbxx]' ~/"
				+ "/~ and t.KTVWT = '[ktvwt]' ~/"
				+ "/~ and t.FSCG = '[fscg]' ~/"
				+ "/~ and t.SWZX = '[swzx]' ~/"
				+ "/~ and t.SNF = '[snf]' ~/"
				+ "/~ and t.BLQG = '[blqg]' ~/"
				+ "/~ and t.YXJF = '[yxjf]' ~/"
				+ "/~ and t.RZBZ = '[rzbz]' ~/"
				+ "/~ and t.LEGAL_SFZH = '[legalSfzh]' ~/"
				+ "/~ and t.I_CODE = '[icode]' ~/"
				+ "/~ and t.SPECIAL_TIME = '[specialTime]' ~/"
				+ "/~ and t.SPECIAL_UNIT = '[specialUnit]' ~/"
				+ "/~ and t.TRANSFLAG = '[transflag]' ~/"
				+ "/~ and t.CITY_CODE = '[cityCode]' ~/"
				+ "/~ and t.OLD_CODE = '[oldCode]' ~/"
				+ "/~ and t.NEW_CODE = '[newCode]' ~/"
				+ "/~ and t.LGSYZ = '[lgsyz]' ~/"
				+ "/~ and t.LGZL = '[lgzl]' ~/"
				+ "/~ and t.LGWZ = '[lgwz]' ~/"
				+ "/~ and t.CARDTYPE = '[cardtype]' ~/"
				+ "/~ and t.CALLED like '%[hotelname]%' ~/"
				+ "/~ and t.AREA_CODE = '[areaCode]' ~/"
				+ "/~ and t.ZRMJ = '[zrmj]' ~/"
				+ "/~ and t.STA_CODE = '[staCode]' ~/"
				+ "/~ and t.BUR_CODE = '[burCode]' ~/"
				+ "/~ and t.LEGAL_PERSON = '[legalPerson]' ~/"
				+ "/~ and t.MANAGER = '[manager]' ~/"
				+ "/~ and t.TEL_LEGAL = '[telLegal]' ~/"
				+ "/~ and t.POLICE_MANAGER = '[policeManager]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.TEL = '[tel]' ~/"
				+ "/~ and t.POLICE_TEL = '[policeTel]' ~/"
				+ "/~ and t.POLICEMEN = '[policemen]' ~/"
				+ "/~ and t.STATUS = '[status]' ~/"
				+ "/~ and t.MOD_TIME >= '[modTime_BeginFormat]' ~/"
				+ "/~ and t.MOD_TIME <= '[modTime_EndFormat]' ~/"
				+ "/~ and t.ROOM_NUM = '[roomNum]' ~/"
				+ "/~ and t.BED_NUM >= [bedNum_Begin] ~/"
				+ "/~ and t.BED_NUM <= [bedNum_End] ~/"
				+ "/~ and t.STAR = '[star]' ~/"
				+ "/~ and t.GRADE = '[grade]' ~/"
				+ "/~ and t.SPECIAL_LICENCE like '%[specialLicence]%' ~/"
				+ "/~ and t.POLICE_LICENCE = '[policeLicence]' ~/"
				+ "/~ and t.SUITROOMS = '[suitrooms]' ~/"
				+ "/~ and t.STANDARDROOMS = '[standardrooms]' ~/"
				+ "/~ and t.DOUBLEROOMS = '[doublerooms]' ~/"
				+ "/~ and t.SINGLEROOMS = '[singlerooms]' ~/"
				+ "/~ and t.OTHERROOMS = '[otherrooms]' ~/"
				+ "/~ and t.WORKMEN = '[workmen]' ~/"
				+ "/~ and t.OTHERPLACEMEN = '[otherplacemen]' ~/"
				+ "/~ and t.MONITOR_CONTROL = '[monitorControl]' ~/"
				+ "/~ and t.COFFER = '[coffer]' ~/"
				+ "/~ and t.TECH_DEFEND = '[techDefend]' ~/"
				+ "/~ and t.THING_DEFEND = '[thingDefend]' ~/"
				+ "/~ and t.KTV = '[ktv]' ~/"
				+ "/~ and t.CHESSROOM = '[chessroom]' ~/"
				+ "/~ and t.COMMERCE = '[commerce]' ~/"
				+ "/~ and t.SAUNA = '[sauna]' ~/"
				+ "/~ and t.BOWLING = '[bowling]' ~/"
				+ "/~ and t.GAMEROOM = '[gameroom]' ~/"
				+ "/~ and t.LOCKTYPE = '[locktype]' ~/"
				+ "/~ and t.LOCKNAME = '[lockname]' ~/"
				+ "/~ and t.BASICREMARK = '[basicremark]' ~/"
				+ "/~ and t.KTV_ROOMS = '[ktvRooms]' ~/"
				+ "/~ and t.KTV_MEN = '[ktvMen]' ~/"
				+ "/~ and t.KTV_LICENCE = '[ktvLicence]' ~/"
				+ "/~ and t.KTV_FIREPROOFING = '[ktvFireproofing]' ~/"
				+ "/~ and t.KTV_MONITOR_CONTROL = '[ktvMonitorControl]' ~/"
				+ "/~ and t.KTV_CONTRACTOR = '[ktvContractor]' ~/"
				+ "/~ and t.KTV_NAME = '[ktvName]' ~/"
				+ "/~ and t.KTV_TEL = '[ktvTel]' ~/"
				+ "/~ and t.KTV_ID = '[ktvId]' ~/"
				+ "/~ and t.CHESS_BOXES = '[chessBoxes]' ~/"
				+ "/~ and t.CHESS_FIREPROOFING = '[chessFireproofing]' ~/"
				+ "/~ and t.CHESS_MONITOR_CONTROL = '[chessMonitorControl]' ~/"
				+ "/~ and t.CHESS_CONTRACTOR = '[chessContractor]' ~/"
				+ "/~ and t.CHESS_NAME = '[chessName]' ~/"
				+ "/~ and t.CHESS_TEL = '[chessTel]' ~/"
				+ "/~ and t.CHESS_ID = '[chessId]' ~/"
				+ "/~ and t.COMMERCE_COPY = '[commerceCopy]' ~/"
				+ "/~ and t.COMMERCE_FAX = '[commerceFax]' ~/"
				+ "/~ and t.COMMERCE_TYPED = '[commerceTyped]' ~/"
				+ "/~ and t.COMMERCE_TICKET = '[commerceTicket]' ~/"
				+ "/~ and t.COMMERCE_CONTRACTOR = '[commerceContractor]' ~/"
				+ "/~ and t.COMMERCE_NAME = '[commerceName]' ~/"
				+ "/~ and t.COMMERCE_TEL = '[commerceTel]' ~/"
				+ "/~ and t.COMMERCE_ID = '[commerceId]' ~/"
				+ "/~ and t.SAUNA_KNEAD = '[saunaKnead]' ~/"
				+ "/~ and t.SAUNA_ROOMS = '[saunaRooms]' ~/"
				+ "/~ and t.SAUNA_WORKMEN = '[saunaWorkmen]' ~/"
				+ "/~ and t.SAUNA_CONTRACTOR = '[saunaContractor]' ~/"
				+ "/~ and t.SAUNA_NAME = '[saunaName]' ~/"
				+ "/~ and t.SAUNA_TEL = '[saunaTel]' ~/"
				+ "/~ and t.SAUNA_ID = '[saunaId]' ~/"
				+ "/~ and t.OTHERREMARK = '[otherremark]' ~/"
				+ "/~ and t.DEVICE_TYPE = '[deviceType]' ~/"
				+ "/~ and t.BA_TIME = '[baTime]' ~/"
				+ "/~ and t.FRONT_MANAGER = '[frontManager]' ~/"
				+ "/~ and t.FRDH = '[frdh]' ~/"
				+ "/~ and t.LGXZ = '[lgxz]' ~/"
				+ "/~ and t.TZHYXKZH = '[tzhyxkzh]' ~/"
				+ "/~ and t.ZAXKZH = '[zaxkzh]' ~/"
				+ "/~ and t.TFS = '[tfs]' ~/"
				+ "/~ and t.BZFS = '[bzfs]' ~/"
				+ "/~ and t.SRFS = '[srfs]' ~/"
				+ "/~ and t.DRFS = '[drfs]' ~/"
				+ "/~ and t.QTFS = '[qtfs]' ~/"
				+ "/~ and t.RYZS = '[ryzs]' ~/"
				+ "/~ and t.DGRS = '[dgrs]' ~/"
				+ "/~ and t.MS = '[ms]' ~/"
				+ "/~ and t.WFHG = '[wfhg]' ~/"
				+ "/~ and t.JFHG = '[jfhg]' ~/"
				+ "/~ order by [sortColumns] ~/";
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
	
	
	private String createSql = "insert into T_HOTEL " 
		 + " (CODE,YWJK,FJBXX,KTVWT,FSCG,SWZX,SNF,BLQG,YXJF,RZBZ,LEGAL_SFZH,I_CODE,SPECIAL_TIME,SPECIAL_UNIT,TRANSFLAG,CITY_CODE,OLD_CODE,NEW_CODE,LGSYZ,LGZL,LGWZ,CARDTYPE,CALLED,AREA_CODE,ZRMJ,STA_CODE,BUR_CODE,LEGAL_PERSON,MANAGER,TEL_LEGAL,POLICE_MANAGER,ADDRESS,TEL,POLICE_TEL,POLICEMEN,STATUS,MOD_TIME,ROOM_NUM,BED_NUM,STAR,GRADE,SPECIAL_LICENCE,POLICE_LICENCE,SUITROOMS,STANDARDROOMS,DOUBLEROOMS,SINGLEROOMS,OTHERROOMS,WORKMEN,OTHERPLACEMEN,MONITOR_CONTROL,COFFER,TECH_DEFEND,THING_DEFEND,KTV,CHESSROOM,COMMERCE,SAUNA,BOWLING,GAMEROOM,LOCKTYPE,LOCKNAME,BASICREMARK,KTV_ROOMS,KTV_MEN,KTV_LICENCE,KTV_FIREPROOFING,KTV_MONITOR_CONTROL,KTV_CONTRACTOR,KTV_NAME,KTV_TEL,KTV_ID,CHESS_BOXES,CHESS_FIREPROOFING,CHESS_MONITOR_CONTROL,CHESS_CONTRACTOR,CHESS_NAME,CHESS_TEL,CHESS_ID,COMMERCE_COPY,COMMERCE_FAX,COMMERCE_TYPED,COMMERCE_TICKET,COMMERCE_CONTRACTOR,COMMERCE_NAME,COMMERCE_TEL,COMMERCE_ID,SAUNA_KNEAD,SAUNA_ROOMS,SAUNA_WORKMEN,SAUNA_CONTRACTOR,SAUNA_NAME,SAUNA_TEL,SAUNA_ID,OTHERREMARK,DEVICE_TYPE,BA_TIME,FRONT_MANAGER,FRDH,LGXZ,TZHYXKZH,ZAXKZH,TFS,BZFS,SRFS,DRFS,QTFS,RYZS,DGRS,MS,WFHG,JFHG) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_HOTEL set "
		+ " CODE=?,YWJK=?,FJBXX=?,KTVWT=?,FSCG=?,SWZX=?,SNF=?,BLQG=?,YXJF=?,RZBZ=?,LEGAL_SFZH=?,I_CODE=?,SPECIAL_TIME=?,SPECIAL_UNIT=?,TRANSFLAG=?,CITY_CODE=?,OLD_CODE=?,NEW_CODE=?,LGSYZ=?,LGZL=?,LGWZ=?,CARDTYPE=?,CALLED=?,AREA_CODE=?,ZRMJ=?,STA_CODE=?,BUR_CODE=?,LEGAL_PERSON=?,MANAGER=?,TEL_LEGAL=?,POLICE_MANAGER=?,ADDRESS=?,TEL=?,POLICE_TEL=?,POLICEMEN=?,STATUS=?,MOD_TIME=?,ROOM_NUM=?,BED_NUM=?,STAR=?,GRADE=?,SPECIAL_LICENCE=?,POLICE_LICENCE=?,SUITROOMS=?,STANDARDROOMS=?,DOUBLEROOMS=?,SINGLEROOMS=?,OTHERROOMS=?,WORKMEN=?,OTHERPLACEMEN=?,MONITOR_CONTROL=?,COFFER=?,TECH_DEFEND=?,THING_DEFEND=?,KTV=?,CHESSROOM=?,COMMERCE=?,SAUNA=?,BOWLING=?,GAMEROOM=?,LOCKTYPE=?,LOCKNAME=?,BASICREMARK=?,KTV_ROOMS=?,KTV_MEN=?,KTV_LICENCE=?,KTV_FIREPROOFING=?,KTV_MONITOR_CONTROL=?,KTV_CONTRACTOR=?,KTV_NAME=?,KTV_TEL=?,KTV_ID=?,CHESS_BOXES=?,CHESS_FIREPROOFING=?,CHESS_MONITOR_CONTROL=?,CHESS_CONTRACTOR=?,CHESS_NAME=?,CHESS_TEL=?,CHESS_ID=?,COMMERCE_COPY=?,COMMERCE_FAX=?,COMMERCE_TYPED=?,COMMERCE_TICKET=?,COMMERCE_CONTRACTOR=?,COMMERCE_NAME=?,COMMERCE_TEL=?,COMMERCE_ID=?,SAUNA_KNEAD=?,SAUNA_ROOMS=?,SAUNA_WORKMEN=?,SAUNA_CONTRACTOR=?,SAUNA_NAME=?,SAUNA_TEL=?,SAUNA_ID=?,OTHERREMARK=?,DEVICE_TYPE=?,BA_TIME=?,FRONT_MANAGER=?,FRDH=?,LGXZ=?,TZHYXKZH=?,ZAXKZH=?,TFS=?,BZFS=?,SRFS=?,DRFS=?,QTFS=?,RYZS=?,DGRS=?,MS=?,WFHG=?,JFHG=? "
		+ " where CODE=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final Thotel entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getCode());
						ps.setString(2, entity.getYwjk());
						ps.setString(3, entity.getFjbxx());
						ps.setString(4, entity.getKtvwt());
						ps.setString(5, entity.getFscg());
						ps.setString(6, entity.getSwzx());
						ps.setString(7, entity.getSnf());
						ps.setString(8, entity.getBlqg());
						ps.setString(9, entity.getYxjf());
						ps.setLong(10, entity.getRzbz());
						ps.setString(11, entity.getLegalSfzh());
						ps.setString(12, entity.getIcode());
						ps.setString(13, entity.getSpecialTime());
						ps.setString(14, entity.getSpecialUnit());
						ps.setLong(15, entity.getTransflag());
						ps.setString(16, entity.getCityCode());
						ps.setString(17, entity.getOldCode());
						ps.setString(18, entity.getNewCode());
						ps.setString(19, entity.getLgsyz());
						ps.setString(20, entity.getLgzl());
						ps.setString(21, entity.getLgwz());
						ps.setString(22, entity.getCardtype());
						ps.setString(23, entity.getCalled());
						ps.setString(24, entity.getAreaCode());
						ps.setString(25, entity.getZrmj());
						ps.setString(26, entity.getStaCode());
						ps.setString(27, entity.getBurCode());
						ps.setString(28, entity.getLegalPerson());
						ps.setString(29, entity.getManager());
						ps.setString(30, entity.getTelLegal());
						ps.setString(31, entity.getPoliceManager());
						ps.setString(32, entity.getAddress());
						ps.setString(33, entity.getTel());
						ps.setString(34, entity.getPoliceTel());
						ps.setString(35, entity.getPolicemen());
						ps.setString(36, entity.getStatus());
						ps.setString(37, entity.getModTime());
						ps.setString(38, entity.getRoomNum());
						ps.setString(39, entity.getBedNum());
						ps.setString(40, entity.getStar());
						ps.setString(41, entity.getGrade());
						ps.setString(42, entity.getSpecialLicence());
						ps.setString(43, entity.getPoliceLicence());
						ps.setString(44, entity.getSuitrooms());
						ps.setString(45, entity.getStandardrooms());
						ps.setString(46, entity.getDoublerooms());
						ps.setString(47, entity.getSinglerooms());
						ps.setString(48, entity.getOtherrooms());
						ps.setString(49, entity.getWorkmen());
						ps.setString(50, entity.getOtherplacemen());
						ps.setString(51, entity.getMonitorControl());
						ps.setString(52, entity.getCoffer());
						ps.setString(53, entity.getTechDefend());
						ps.setString(54, entity.getThingDefend());
						ps.setString(55, entity.getKtv());
						ps.setString(56, entity.getChessroom());
						ps.setString(57, entity.getCommerce());
						ps.setString(58, entity.getSauna());
						ps.setString(59, entity.getBowling());
						ps.setString(60, entity.getGameroom());
						ps.setString(61, entity.getLocktype());
						ps.setString(62, entity.getLockname());
						ps.setString(63, entity.getBasicremark());
						ps.setString(64, entity.getKtvRooms());
						ps.setString(65, entity.getKtvMen());
						ps.setString(66, entity.getKtvLicence());
						ps.setString(67, entity.getKtvFireproofing());
						ps.setString(68, entity.getKtvMonitorControl());
						ps.setString(69, entity.getKtvContractor());
						ps.setString(70, entity.getKtvName());
						ps.setString(71, entity.getKtvTel());
						ps.setString(72, entity.getKtvId());
						ps.setString(73, entity.getChessBoxes());
						ps.setString(74, entity.getChessFireproofing());
						ps.setString(75, entity.getChessMonitorControl());
						ps.setString(76, entity.getChessContractor());
						ps.setString(77, entity.getChessName());
						ps.setString(78, entity.getChessTel());
						ps.setString(79, entity.getChessId());
						ps.setString(80, entity.getCommerceCopy());
						ps.setString(81, entity.getCommerceFax());
						ps.setString(82, entity.getCommerceTyped());
						ps.setString(83, entity.getCommerceTicket());
						ps.setString(84, entity.getCommerceContractor());
						ps.setString(85, entity.getCommerceName());
						ps.setString(86, entity.getCommerceTel());
						ps.setString(87, entity.getCommerceId());
						ps.setString(88, entity.getSaunaKnead());
						ps.setString(89, entity.getSaunaRooms());
						ps.setString(90, entity.getSaunaWorkmen());
						ps.setString(91, entity.getSaunaContractor());
						ps.setString(92, entity.getSaunaName());
						ps.setString(93, entity.getSaunaTel());
						ps.setString(94, entity.getSaunaId());
						ps.setString(95, entity.getOtherremark());
						ps.setString(96, entity.getDeviceType());
						ps.setString(97, entity.getBaTime());
						ps.setString(98, entity.getFrontManager());
						ps.setString(99, entity.getFrdh());
						ps.setString(100, entity.getLgxz());
						ps.setString(101, entity.getTzhyxkzh());
						ps.setString(102, entity.getZaxkzh());
						ps.setString(103, entity.getTfs());
						ps.setString(104, entity.getBzfs());
						ps.setString(105, entity.getSrfs());
						ps.setString(106, entity.getDrfs());
						ps.setString(107, entity.getQtfs());
						ps.setString(108, entity.getRyzs());
						ps.setString(109, entity.getDgrs());
						ps.setString(110, entity.getMs());
						ps.setString(111, entity.getWfhg());
						ps.setString(112, entity.getJfhg());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createThotel(final Thotel entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCode());
				ps.setString(2, entity.getYwjk());
				ps.setString(3, entity.getFjbxx());
				ps.setString(4, entity.getKtvwt());
				ps.setString(5, entity.getFscg());
				ps.setString(6, entity.getSwzx());
				ps.setString(7, entity.getSnf());
				ps.setString(8, entity.getBlqg());
				ps.setString(9, entity.getYxjf());
				ps.setLong(10, entity.getRzbz());
				ps.setString(11, entity.getLegalSfzh());
				ps.setString(12, entity.getIcode());
				ps.setString(13, entity.getSpecialTime());
				ps.setString(14, entity.getSpecialUnit());
				ps.setLong(15, entity.getTransflag());
				ps.setString(16, entity.getCityCode());
				ps.setString(17, entity.getOldCode());
				ps.setString(18, entity.getNewCode());
				ps.setString(19, entity.getLgsyz());
				ps.setString(20, entity.getLgzl());
				ps.setString(21, entity.getLgwz());
				ps.setString(22, entity.getCardtype());
				ps.setString(23, entity.getCalled());
				ps.setString(24, entity.getAreaCode());
				ps.setString(25, entity.getZrmj());
				ps.setString(26, entity.getStaCode());
				ps.setString(27, entity.getBurCode());
				ps.setString(28, entity.getLegalPerson());
				ps.setString(29, entity.getManager());
				ps.setString(30, entity.getTelLegal());
				ps.setString(31, entity.getPoliceManager());
				ps.setString(32, entity.getAddress());
				ps.setString(33, entity.getTel());
				ps.setString(34, entity.getPoliceTel());
				ps.setString(35, entity.getPolicemen());
				ps.setString(36, entity.getStatus());
				ps.setString(37, entity.getModTime());
				ps.setString(38, entity.getRoomNum());
				ps.setString(39, entity.getBedNum());
				ps.setString(40, entity.getStar());
				ps.setString(41, entity.getGrade());
				ps.setString(42, entity.getSpecialLicence());
				ps.setString(43, entity.getPoliceLicence());
				ps.setString(44, entity.getSuitrooms());
				ps.setString(45, entity.getStandardrooms());
				ps.setString(46, entity.getDoublerooms());
				ps.setString(47, entity.getSinglerooms());
				ps.setString(48, entity.getOtherrooms());
				ps.setString(49, entity.getWorkmen());
				ps.setString(50, entity.getOtherplacemen());
				ps.setString(51, entity.getMonitorControl());
				ps.setString(52, entity.getCoffer());
				ps.setString(53, entity.getTechDefend());
				ps.setString(54, entity.getThingDefend());
				ps.setString(55, entity.getKtv());
				ps.setString(56, entity.getChessroom());
				ps.setString(57, entity.getCommerce());
				ps.setString(58, entity.getSauna());
				ps.setString(59, entity.getBowling());
				ps.setString(60, entity.getGameroom());
				ps.setString(61, entity.getLocktype());
				ps.setString(62, entity.getLockname());
				ps.setString(63, entity.getBasicremark());
				ps.setString(64, entity.getKtvRooms());
				ps.setString(65, entity.getKtvMen());
				ps.setString(66, entity.getKtvLicence());
				ps.setString(67, entity.getKtvFireproofing());
				ps.setString(68, entity.getKtvMonitorControl());
				ps.setString(69, entity.getKtvContractor());
				ps.setString(70, entity.getKtvName());
				ps.setString(71, entity.getKtvTel());
				ps.setString(72, entity.getKtvId());
				ps.setString(73, entity.getChessBoxes());
				ps.setString(74, entity.getChessFireproofing());
				ps.setString(75, entity.getChessMonitorControl());
				ps.setString(76, entity.getChessContractor());
				ps.setString(77, entity.getChessName());
				ps.setString(78, entity.getChessTel());
				ps.setString(79, entity.getChessId());
				ps.setString(80, entity.getCommerceCopy());
				ps.setString(81, entity.getCommerceFax());
				ps.setString(82, entity.getCommerceTyped());
				ps.setString(83, entity.getCommerceTicket());
				ps.setString(84, entity.getCommerceContractor());
				ps.setString(85, entity.getCommerceName());
				ps.setString(86, entity.getCommerceTel());
				ps.setString(87, entity.getCommerceId());
				ps.setString(88, entity.getSaunaKnead());
				ps.setString(89, entity.getSaunaRooms());
				ps.setString(90, entity.getSaunaWorkmen());
				ps.setString(91, entity.getSaunaContractor());
				ps.setString(92, entity.getSaunaName());
				ps.setString(93, entity.getSaunaTel());
				ps.setString(94, entity.getSaunaId());
				ps.setString(95, entity.getOtherremark());
				ps.setString(96, entity.getDeviceType());
				ps.setString(97, entity.getBaTime());
				ps.setString(98, entity.getFrontManager());
				ps.setString(99, entity.getFrdh());
				ps.setString(100, entity.getLgxz());
				ps.setString(101, entity.getTzhyxkzh());
				ps.setString(102, entity.getZaxkzh());
				ps.setString(103, entity.getTfs());
				ps.setString(104, entity.getBzfs());
				ps.setString(105, entity.getSrfs());
				ps.setString(106, entity.getDrfs());
				ps.setString(107, entity.getQtfs());
				ps.setString(108, entity.getRyzs());
				ps.setString(109, entity.getDgrs());
				ps.setString(110, entity.getMs());
				ps.setString(111, entity.getWfhg());
				ps.setString(112, entity.getJfhg());
			}
		});
	}

	
	public void updateThotel(final Thotel entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getCode());
				ps.setString(2, entity.getYwjk());
				ps.setString(3, entity.getFjbxx());
				ps.setString(4, entity.getKtvwt());
				ps.setString(5, entity.getFscg());
				ps.setString(6, entity.getSwzx());
				ps.setString(7, entity.getSnf());
				ps.setString(8, entity.getBlqg());
				ps.setString(9, entity.getYxjf());
				ps.setLong(10, entity.getRzbz());
				ps.setString(11, entity.getLegalSfzh());
				ps.setString(12, entity.getIcode());
				ps.setString(13, entity.getSpecialTime());
				ps.setString(14, entity.getSpecialUnit());
				ps.setLong(15, entity.getTransflag());
				ps.setString(16, entity.getCityCode());
				ps.setString(17, entity.getOldCode());
				ps.setString(18, entity.getNewCode());
				ps.setString(19, entity.getLgsyz());
				ps.setString(20, entity.getLgzl());
				ps.setString(21, entity.getLgwz());
				ps.setString(22, entity.getCardtype());
				ps.setString(23, entity.getCalled());
				ps.setString(24, entity.getAreaCode());
				ps.setString(25, entity.getZrmj());
				ps.setString(26, entity.getStaCode());
				ps.setString(27, entity.getBurCode());
				ps.setString(28, entity.getLegalPerson());
				ps.setString(29, entity.getManager());
				ps.setString(30, entity.getTelLegal());
				ps.setString(31, entity.getPoliceManager());
				ps.setString(32, entity.getAddress());
				ps.setString(33, entity.getTel());
				ps.setString(34, entity.getPoliceTel());
				ps.setString(35, entity.getPolicemen());
				ps.setString(36, entity.getStatus());
				ps.setString(37, entity.getModTime());
				ps.setString(38, entity.getRoomNum());
				ps.setString(39, entity.getBedNum());
				ps.setString(40, entity.getStar());
				ps.setString(41, entity.getGrade());
				ps.setString(42, entity.getSpecialLicence());
				ps.setString(43, entity.getPoliceLicence());
				ps.setString(44, entity.getSuitrooms());
				ps.setString(45, entity.getStandardrooms());
				ps.setString(46, entity.getDoublerooms());
				ps.setString(47, entity.getSinglerooms());
				ps.setString(48, entity.getOtherrooms());
				ps.setString(49, entity.getWorkmen());
				ps.setString(50, entity.getOtherplacemen());
				ps.setString(51, entity.getMonitorControl());
				ps.setString(52, entity.getCoffer());
				ps.setString(53, entity.getTechDefend());
				ps.setString(54, entity.getThingDefend());
				ps.setString(55, entity.getKtv());
				ps.setString(56, entity.getChessroom());
				ps.setString(57, entity.getCommerce());
				ps.setString(58, entity.getSauna());
				ps.setString(59, entity.getBowling());
				ps.setString(60, entity.getGameroom());
				ps.setString(61, entity.getLocktype());
				ps.setString(62, entity.getLockname());
				ps.setString(63, entity.getBasicremark());
				ps.setString(64, entity.getKtvRooms());
				ps.setString(65, entity.getKtvMen());
				ps.setString(66, entity.getKtvLicence());
				ps.setString(67, entity.getKtvFireproofing());
				ps.setString(68, entity.getKtvMonitorControl());
				ps.setString(69, entity.getKtvContractor());
				ps.setString(70, entity.getKtvName());
				ps.setString(71, entity.getKtvTel());
				ps.setString(72, entity.getKtvId());
				ps.setString(73, entity.getChessBoxes());
				ps.setString(74, entity.getChessFireproofing());
				ps.setString(75, entity.getChessMonitorControl());
				ps.setString(76, entity.getChessContractor());
				ps.setString(77, entity.getChessName());
				ps.setString(78, entity.getChessTel());
				ps.setString(79, entity.getChessId());
				ps.setString(80, entity.getCommerceCopy());
				ps.setString(81, entity.getCommerceFax());
				ps.setString(82, entity.getCommerceTyped());
				ps.setString(83, entity.getCommerceTicket());
				ps.setString(84, entity.getCommerceContractor());
				ps.setString(85, entity.getCommerceName());
				ps.setString(86, entity.getCommerceTel());
				ps.setString(87, entity.getCommerceId());
				ps.setString(88, entity.getSaunaKnead());
				ps.setString(89, entity.getSaunaRooms());
				ps.setString(90, entity.getSaunaWorkmen());
				ps.setString(91, entity.getSaunaContractor());
				ps.setString(92, entity.getSaunaName());
				ps.setString(93, entity.getSaunaTel());
				ps.setString(94, entity.getSaunaId());
				ps.setString(95, entity.getOtherremark());
				ps.setString(96, entity.getDeviceType());
				ps.setString(97, entity.getBaTime());
				ps.setString(98, entity.getFrontManager());
				ps.setString(99, entity.getFrdh());
				ps.setString(100, entity.getLgxz());
				ps.setString(101, entity.getTzhyxkzh());
				ps.setString(102, entity.getZaxkzh());
				ps.setString(103, entity.getTfs());
				ps.setString(104, entity.getBzfs());
				ps.setString(105, entity.getSrfs());
				ps.setString(106, entity.getDrfs());
				ps.setString(107, entity.getQtfs());
				ps.setString(108, entity.getRyzs());
				ps.setString(109, entity.getDgrs());
				ps.setString(110, entity.getMs());
				ps.setString(111, entity.getWfhg());
				ps.setString(112, entity.getJfhg());
			}
		});
	}

	
	public void deleteThotel(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public List getHotelNameBySta(String key) {
		String sql = "select t.called from T_HOTEL t where t.sta_code='"+ key +"' and rownum < 11 ";
		System.out.println(sql);
		return getJdbcTemplate().queryForList(sql);
	}
	public List getHotelNameByName(String name) {
		String sql = "select t.called from T_HOTEL t where t.called like '%"+ name +"%' and rownum < 11 ";
		System.out.println(sql);
		return getJdbcTemplate().queryForList(sql);
	}

	public Page findHotelByStatus(PageRequest<Map> pageRequest) {
		String isOpen = (String)pageRequest.getFilters().get("status");
		String sql = "";
		if(null != isOpen && isOpen.equals("1")){
			sql = getSelectPrefixListOnly() + " t, t_hotel_status_log t1 where t1.hotelid = t.code "
			+ "/~ and t1.MOD_TIME >= '[modTime_BeginFormat]' ~/"
			+ "/~ and t1.MOD_TIME <= '[modTime_EndFormat]' ~/"
			+ "/~ and nvl(t.BED_NUM,0) >= [bedNum_Begin] ~/"
			+ "/~ and nvl(t.BED_NUM,0) <= [bedNum_End] ~/"
			+ "   and t1.STATUS = '1' "
			+ "/~ and t.STA_CODE = '[staCode]' ~/"
			+ "/~ and t.BUR_CODE = '[burCode]' ~/"
			+ "/~ order by [sortColumns] ~/";
		}else{
			sql = getSelectPrefixListOnly() + " t, t_hotel_status_log t1 where t1.hotelid = t.code "
			+ "/~ and t1.MOD_TIME >= '[modTime_BeginFormat]' ~/"
			+ "/~ and t1.MOD_TIME <= '[modTime_EndFormat]' ~/"
			+ "/~ and nvl(t.BED_NUM,0) >= [bedNum_Begin] ~/"
			+ "/~ and nvl(t.BED_NUM,0) <= [bedNum_End] ~/"
			+ "   and t1.STATUS <> '1' "
			+ "/~ and t.STA_CODE = '[staCode]' ~/"
			+ "/~ and t.BUR_CODE = '[burCode]' ~/"
			+ "/~ order by [sortColumns] ~/";
		}
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}

	public Page findHotelOfNullInfo(PageRequest<Map> pageRequest) {
		String sql = ""
			+ "select * "
			+ "  from t_hotel "
			+ " where (status = '1' or status is null) "
			+ "   and (address is null or i_code is null or SPECIAL_LICENCE is null or "
			+ "       star is null or room_num is null or bed_num is null or tel is null or "
			+ "       manager is null or status is null or bur_code is null or "
			+ "       sta_code is null) "
			+ "/~ and STA_CODE = '[staCode]' ~/"
			+ "/~ and BUR_CODE = '[burCode]' ~/"
			+ "/~ order by [sortColumns] ~/";
		return pageQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));
	}
	

}
