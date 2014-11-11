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

import com.dyneinfo.hotel.model.Thotel;
import com.dyneinfo.hotel.model.TtjGuest;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TtjGuestDao extends BaseSpringJdbcDao<TtjGuest,java.lang.String>{
	
	public Class getEntityClass() {
		return TtjGuest.class;
	}
	
	public String getIdentifierPropertyName() {
		return "code";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" CODE as code,"
				+" CALLED as called,"
				+" ADDRESS as address,"
				+" TEL as tel,"
				+" ROOM_NUM as roomNum,"
				+" BED_NUM as bedNum,"
				
				
				+" YWJK as ywjk,"
				+" FJBXX as fjbxx,"
				+" KTVWT as ktvwt,"
				+" FSCG as fscg,"
				+" SWZX as swzx,"
				+" SNF as snf,"
				+" BLQG as blqg,"
				+" YXJF as yxjf,"
				+" RZBZ as rzbz,"
				+" LEGAL_SFZH as legalSfzh,"
				+" I_CODE as icode,"
				+" SPECIAL_TIME as specialTime,"
				+" SPECIAL_UNIT as specialUnit,"
				+" TRANSFLAG as transflag,"
				+" CITY_CODE as cityCode,"
				+" OLD_CODE as oldCode,"
				+" NEW_CODE as newCode,"
				+" LGSYZ as lgsyz,"
				+" LGZL as lgzl,"
				+" LGWZ as lgwz,"
				+" CARDTYPE as cardtype,"
				+" AREA_CODE as areaCode,"
				+" ZRMJ as zrmj,"
				+" STA_CODE as staCode,"
				+" BUR_CODE as burCode,"
				+" LEGAL_PERSON as legalPerson,"
				+" MANAGER as manager,"
				+" TEL_LEGAL as telLegal,"
				+" POLICE_MANAGER as policeManager,"
				+" POLICE_TEL as policeTel,"
				+" POLICEMEN as policemen,"
				+" STATUS as status,"
				+" MOD_TIME as modTime,"
				+" STAR as star,"
				+" GRADE as grade,"
				+" SPECIAL_LICENCE as specialLicence,"
				+" POLICE_LICENCE as policeLicence,"
				+" SUITROOMS as suitrooms,"
				+" STANDARDROOMS as standardrooms,"
				+" DOUBLEROOMS as doublerooms,"
				+" SINGLEROOMS as singlerooms,"
				+" OTHERROOMS as otherrooms,"
				+" WORKMEN as workmen,"
				+" OTHERPLACEMEN as otherplacemen,"
				+" MONITOR_CONTROL as monitorControl,"
				+" COFFER as coffer,"
				+" TECH_DEFEND as techDefend,"
				+" THING_DEFEND as thingDefend,"
				+" KTV as ktv,"
				+" CHESSROOM as chessroom,"
				+" COMMERCE as commerce,"
				+" SAUNA as sauna,"
				+" BOWLING as bowling,"
				+" GAMEROOM as gameroom,"
				+" LOCKTYPE as locktype,"
				+" LOCKNAME as lockname,"
				+" BASICREMARK as basicremark,"
				+" KTV_ROOMS as ktvRooms,"
				+" KTV_MEN as ktvMen,"
				+" KTV_LICENCE as ktvLicence,"
				+" KTV_FIREPROOFING as ktvFireproofing,"
				+" KTV_MONITOR_CONTROL as ktvMonitorControl,"
				+" KTV_CONTRACTOR as ktvContractor,"
				+" KTV_NAME as ktvName,"
				+" KTV_TEL as ktvTel,"
				+" KTV_ID as ktvId,"
				+" CHESS_BOXES as chessBoxes,"
				+" CHESS_FIREPROOFING as chessFireproofing,"
				+" CHESS_MONITOR_CONTROL as chessMonitorControl,"
				+" CHESS_CONTRACTOR as chessContractor,"
				+" CHESS_NAME as chessName,"
				+" CHESS_TEL as chessTel,"
				+" CHESS_ID as chessId,"
				+" COMMERCE_COPY as commerceCopy,"
				+" COMMERCE_FAX as commerceFax,"
				+" COMMERCE_TYPED as commerceTyped,"
				+" COMMERCE_TICKET as commerceTicket,"
				+" COMMERCE_CONTRACTOR as commerceContractor,"
				+" COMMERCE_NAME as commerceName,"
				+" COMMERCE_TEL as commerceTel,"
				+" COMMERCE_ID as commerceId,"
				+" SAUNA_KNEAD as saunaKnead,"
				+" SAUNA_ROOMS as saunaRooms,"
				+" SAUNA_WORKMEN as saunaWorkmen,"
				+" SAUNA_CONTRACTOR as saunaContractor,"
				+" SAUNA_NAME as saunaName,"
				+" SAUNA_TEL as saunaTel,"
				+" SAUNA_ID as saunaId,"
				+" OTHERREMARK as otherremark,"
				+" DEVICE_TYPE as deviceType,"
				+" BA_TIME as baTime,"
				+" FRONT_MANAGER as frontManager,"
				+" FRDH as frdh,"
				+" LGXZ as lgxz,"
				+" TZHYXKZH as tzhyxkzh,"
				+" ZAXKZH as zaxkzh,"
				+" TFS as tfs,"
				+" BZFS as bzfs,"
				+" SRFS as srfs,"
				+" DRFS as drfs,"
				+" QTFS as qtfs,"
				+" RYZS as ryzs,"
				+" DGRS as dgrs,"
				+" MS as ms,"
				+" WFHG as wfhg,"
				+" JFHG as jfhg"
				+" from T_HOTEL ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_HOTEL where CODE=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where CODE=? ";
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
				+ "/~ and t.ROOM_NUM >= [roomNum_Begin] ~/"
				+ "/~ and t.ROOM_NUM <= [roomNum_End] ~/"
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
		sql=""
			+ "select distinct called as hotel, "
			+ "                code, "
			+ "                address, "
			+ "                tel, "
			+ "                nvl(replace(replace(room_num, chr(13), ''), chr(10), ''), "
			+ "                    '0') as room_num, "
			+ "                nvl(replace(replace(bed_num, chr(13), ''), chr(10), ''), "
			+ "                    '0') as bed_num, "
			+ "                (select nvl(sum(incount), '0') "
			+ "                   from t_ch_all_temp "
			+ "                  where replace(DATEN, chr(13) || chr(10), '') >= '20120930' "
			+ "                    and replace(DATEN, chr(13) || chr(10), '') <= '20140930' "
			+ "                    and hotelid = code) as guest_num "
			+ "  from t_hotel a, t_ch_all_temp b "
			+ " where 1 <> 2 "
			+ "   and STATUS = '1' "
			+ "   and a.code = b.hotelid(+) "
			+ " order by code";
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

	public void save(TtjGuest entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(TtjGuest entity) {
		// TODO Auto-generated method stub
		
	}
	public Page findByPageRequest(String sql ,PageRequest<Map> pageRequest) {
		return pageGroupQuery(sql,"select count(*) from ( "+sql+" )",pageRequest,new BeanPropertyRowMapper(getEntityClass()));	
	}

}
