/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.hotel.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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


public class TtjGuest extends BaseEntity {
	
	//alias
	public static final String TABLE_ALIAS = "旅馆入退宿情况统计";
	public static final String ALIAS_CODE = "旅馆代码";
	public static final String ALIAS_YWJK = "ywjk";
	public static final String ALIAS_FJBXX = "fjbxx";
	public static final String ALIAS_KTVWT = "ktvwt";
	public static final String ALIAS_FSCG = "fscg";
	public static final String ALIAS_SWZX = "swzx";
	public static final String ALIAS_SNF = "snf";
	public static final String ALIAS_BLQG = "blqg";
	public static final String ALIAS_YXJF = "yxjf";
	public static final String ALIAS_RZBZ = "????";
	public static final String ALIAS_LEGAL_SFZH = "legalSfzh";
	public static final String ALIAS_I_CODE = "对应输入码";
	public static final String ALIAS_SPECIAL_TIME = "specialTime";
	public static final String ALIAS_SPECIAL_UNIT = "specialUnit";
	public static final String ALIAS_TRANSFLAG = "transflag";
	public static final String ALIAS_CITY_CODE = "市局代码";
	public static final String ALIAS_OLD_CODE = "oldCode";
	public static final String ALIAS_NEW_CODE = "newCode";
	public static final String ALIAS_LGSYZ = "旅馆所有制";
	public static final String ALIAS_LGZL = "旅馆种类";
	public static final String ALIAS_LGWZ = "旅馆位置";
	public static final String ALIAS_CARDTYPE = "读卡设备类型";
	public static final String ALIAS_CALLED = "旅馆名称";
	public static final String ALIAS_AREA_CODE = "所属警务区";
	public static final String ALIAS_ZRMJ = "责任民警";
	public static final String ALIAS_STA_CODE = "所属派出所";
	public static final String ALIAS_BUR_CODE = "所属分局";
	public static final String ALIAS_LEGAL_PERSON = "法定代表人";
	public static final String ALIAS_MANAGER = "负责人";
	public static final String ALIAS_TEL_LEGAL = "法人电话";
	public static final String ALIAS_POLICE_MANAGER = "治安负责人";
	public static final String ALIAS_ADDRESS = "旅馆地址";
	public static final String ALIAS_TEL = "总台电话";
	public static final String ALIAS_POLICE_TEL = "保安部电话";
	public static final String ALIAS_POLICEMEN = "保安人数";
	public static final String ALIAS_STATUS = "状态";
	public static final String ALIAS_MOD_TIME = "状态改变日期";
	public static final String ALIAS_HOTEL_NUM = "营业旅馆数";
	public static final String ALIAS_ROOM_NUM = "客房数";
	public static final String ALIAS_BED_NUM = "床位数";
	public static final String ALIAS_STAR = "星级";
	public static final String ALIAS_GRADE = "等级";
	public static final String ALIAS_SPECIAL_LICENCE = "特行许可证号";
	public static final String ALIAS_POLICE_LICENCE = "治安许可证";
	public static final String ALIAS_SUITROOMS = "套房";
	public static final String ALIAS_STANDARDROOMS = "标准房";
	public static final String ALIAS_DOUBLEROOMS = "双人房";
	public static final String ALIAS_SINGLEROOMS = "单人房";
	public static final String ALIAS_OTHERROOMS = "其他房型";
	public static final String ALIAS_WORKMEN = "从业人数";
	public static final String ALIAS_OTHERPLACEMEN = "外来打工人数";
	public static final String ALIAS_MONITOR_CONTROL = "监控设施";
	public static final String ALIAS_COFFER = "房间保险箱";
	public static final String ALIAS_TECH_DEFEND = "技防";
	public static final String ALIAS_THING_DEFEND = "物防";
	public static final String ALIAS_KTV = "KTV,舞厅";
	public static final String ALIAS_CHESSROOM = "棋牌室";
	public static final String ALIAS_COMMERCE = "商务中心";
	public static final String ALIAS_SAUNA = "桑拿";
	public static final String ALIAS_BOWLING = "保龄球馆";
	public static final String ALIAS_GAMEROOM = "游戏机房";
	public static final String ALIAS_LOCKTYPE = "门锁类型";
	public static final String ALIAS_LOCKNAME = "门锁名称";
	public static final String ALIAS_BASICREMARK = "基本备注";
	public static final String ALIAS_KTV_ROOMS = "KTV间数";
	public static final String ALIAS_KTV_MEN = "舞厅额定人数";
	public static final String ALIAS_KTV_LICENCE = "KTV治安许可证";
	public static final String ALIAS_KTV_FIREPROOFING = "KTV 防火措施";
	public static final String ALIAS_KTV_MONITOR_CONTROL = "KTV 监控措施";
	public static final String ALIAS_KTV_CONTRACTOR = "KTV 承包人";
	public static final String ALIAS_KTV_NAME = "KTV 承包人姓名";
	public static final String ALIAS_KTV_TEL = "KTV 承包人电话";
	public static final String ALIAS_KTV_ID = "KTV 承包人身份证";
	public static final String ALIAS_CHESS_BOXES = "棋牌室包厢数";
	public static final String ALIAS_CHESS_FIREPROOFING = "棋牌室防火措施";
	public static final String ALIAS_CHESS_MONITOR_CONTROL = "棋牌室监控措施";
	public static final String ALIAS_CHESS_CONTRACTOR = "棋牌室承包人";
	public static final String ALIAS_CHESS_NAME = "棋牌室承包人姓名";
	public static final String ALIAS_CHESS_TEL = "棋牌室承包人电话";
	public static final String ALIAS_CHESS_ID = "棋牌室承包人身份证";
	public static final String ALIAS_COMMERCE_COPY = "商务中心复印";
	public static final String ALIAS_COMMERCE_FAX = "商务中心传真";
	public static final String ALIAS_COMMERCE_TYPED = "商务中心打字";
	public static final String ALIAS_COMMERCE_TICKET = "商务中心订票";
	public static final String ALIAS_COMMERCE_CONTRACTOR = "商务中心承包人";
	public static final String ALIAS_COMMERCE_NAME = "商务中心承包人姓名";
	public static final String ALIAS_COMMERCE_TEL = "商务中心承包人电话";
	public static final String ALIAS_COMMERCE_ID = "商务中心承包人身份证";
	public static final String ALIAS_SAUNA_KNEAD = "桑拿按摩";
	public static final String ALIAS_SAUNA_ROOMS = "桑拿按摩间数";
	public static final String ALIAS_SAUNA_WORKMEN = "桑拿房从业人数";
	public static final String ALIAS_SAUNA_CONTRACTOR = "桑拿房承包人";
	public static final String ALIAS_SAUNA_NAME = "桑拿房承包人姓名";
	public static final String ALIAS_SAUNA_TEL = "桑拿房承包人电话";
	public static final String ALIAS_SAUNA_ID = "桑拿房承包人身份证";
	public static final String ALIAS_OTHERREMARK = "附属备注";
	public static final String ALIAS_DEVICE_TYPE = "装机类型";
	public static final String ALIAS_BA_TIME = "baTime";
	public static final String ALIAS_FRONT_MANAGER = "frontManager";
	public static final String ALIAS_FRDH = "frdh";
	public static final String ALIAS_LGXZ = "lgxz";
	public static final String ALIAS_TZHYXKZH = "tzhyxkzh";
	public static final String ALIAS_ZAXKZH = "zaxkzh";
	public static final String ALIAS_TFS = "tfs";
	public static final String ALIAS_BZFS = "bzfs";
	public static final String ALIAS_SRFS = "srfs";
	public static final String ALIAS_DRFS = "drfs";
	public static final String ALIAS_QTFS = "qtfs";
	public static final String ALIAS_RYZS = "ryzs";
	public static final String ALIAS_DGRS = "dgrs";
	public static final String ALIAS_MS = "ms";
	public static final String ALIAS_WFHG = "wfhg";
	public static final String ALIAS_JFHG = "jfhg";
	public static final String ALIAS_INGUEST = "入住旅客";
	public static final String ALIAS_OUTGUEST = "退宿旅客";
	public static final String ALIAS_IN_TIME = "统计时间";
	public static final String ALIAS_DEPT = "辖区";
	public static final String ALIAS_INFOSUM = "上传信息数";
	
	//date formats
	
	//columns START
	private java.lang.String code;
	private java.lang.String ywjk;
	private java.lang.String fjbxx;
	private java.lang.String ktvwt;
	private java.lang.String fscg;
	private java.lang.String swzx;
	private java.lang.String snf;
	private java.lang.String blqg;
	private java.lang.String yxjf;
	private Long rzbz;
	private java.lang.String legalSfzh;
	private java.lang.String icode;
	private java.lang.String specialTime;
	private java.lang.String specialUnit;
	private Long transflag;
	private java.lang.String cityCode;
	private java.lang.String oldCode;
	private java.lang.String newCode;
	private java.lang.String lgsyz;
	private java.lang.String lgzl;
	private java.lang.String lgwz;
	private java.lang.String cardtype;
	private java.lang.String called;
	private java.lang.String areaCode;
	private java.lang.String zrmj;
	private java.lang.String staCode;
	private java.lang.String burCode;
	private java.lang.String legalPerson;
	private java.lang.String manager;
	private java.lang.String telLegal;
	private java.lang.String policeManager;
	private java.lang.String address;
	private java.lang.String tel;
	private java.lang.String policeTel;
	private java.lang.String policemen;
	private java.lang.String status;
	private java.lang.String modTime;
	private java.lang.String roomNum;
	private java.lang.String bedNum;
	private java.lang.String star;
	private java.lang.String grade;
	private java.lang.String specialLicence;
	private java.lang.String policeLicence;
	private java.lang.String suitrooms;
	private java.lang.String standardrooms;
	private java.lang.String doublerooms;
	private java.lang.String singlerooms;
	private java.lang.String otherrooms;
	private java.lang.String workmen;
	private java.lang.String otherplacemen;
	private java.lang.String monitorControl;
	private java.lang.String coffer;
	private java.lang.String techDefend;
	private java.lang.String thingDefend;
	private java.lang.String ktv;
	private java.lang.String chessroom;
	private java.lang.String commerce;
	private java.lang.String sauna;
	private java.lang.String bowling;
	private java.lang.String gameroom;
	private java.lang.String locktype;
	private java.lang.String lockname;
	private java.lang.String basicremark;
	private java.lang.String ktvRooms;
	private java.lang.String ktvMen;
	private java.lang.String ktvLicence;
	private java.lang.String ktvFireproofing;
	private java.lang.String ktvMonitorControl;
	private java.lang.String ktvContractor;
	private java.lang.String ktvName;
	private java.lang.String ktvTel;
	private java.lang.String ktvId;
	private java.lang.String chessBoxes;
	private java.lang.String chessFireproofing;
	private java.lang.String chessMonitorControl;
	private java.lang.String chessContractor;
	private java.lang.String chessName;
	private java.lang.String chessTel;
	private java.lang.String chessId;
	private java.lang.String commerceCopy;
	private java.lang.String commerceFax;
	private java.lang.String commerceTyped;
	private java.lang.String commerceTicket;
	private java.lang.String commerceContractor;
	private java.lang.String commerceName;
	private java.lang.String commerceTel;
	private java.lang.String commerceId;
	private java.lang.String saunaKnead;
	private java.lang.String saunaRooms;
	private java.lang.String saunaWorkmen;
	private java.lang.String saunaContractor;
	private java.lang.String saunaName;
	private java.lang.String saunaTel;
	private java.lang.String saunaId;
	private java.lang.String otherremark;
	private java.lang.String deviceType;
	private java.lang.String baTime;
	private java.lang.String frontManager;
	private java.lang.String frdh;
	private java.lang.String lgxz;
	private java.lang.String tzhyxkzh;
	private java.lang.String zaxkzh;
	private java.lang.String tfs;
	private java.lang.String bzfs;
	private java.lang.String srfs;
	private java.lang.String drfs;
	private java.lang.String qtfs;
	private java.lang.String ryzs;
	private java.lang.String dgrs;
	private java.lang.String ms;
	private java.lang.String wfhg;
	private java.lang.String jfhg;
	//columns END

	public TtjGuest(){
	}

	public TtjGuest(
		java.lang.String code
	){
		this.code = code;
	}

	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setYwjk(java.lang.String value) {
		this.ywjk = value;
	}
	
	public java.lang.String getYwjk() {
		return this.ywjk;
	}
	public void setFjbxx(java.lang.String value) {
		this.fjbxx = value;
	}
	
	public java.lang.String getFjbxx() {
		return this.fjbxx;
	}
	public void setKtvwt(java.lang.String value) {
		this.ktvwt = value;
	}
	
	public java.lang.String getKtvwt() {
		return this.ktvwt;
	}
	public void setFscg(java.lang.String value) {
		this.fscg = value;
	}
	
	public java.lang.String getFscg() {
		return this.fscg;
	}
	public void setSwzx(java.lang.String value) {
		this.swzx = value;
	}
	
	public java.lang.String getSwzx() {
		return this.swzx;
	}
	public void setSnf(java.lang.String value) {
		this.snf = value;
	}
	
	public java.lang.String getSnf() {
		return this.snf;
	}
	public void setBlqg(java.lang.String value) {
		this.blqg = value;
	}
	
	public java.lang.String getBlqg() {
		return this.blqg;
	}
	public void setYxjf(java.lang.String value) {
		this.yxjf = value;
	}
	
	public java.lang.String getYxjf() {
		return this.yxjf;
	}
	public void setRzbz(Long value) {
		this.rzbz = value;
	}
	
	public Long getRzbz() {
		return this.rzbz;
	}
	public void setLegalSfzh(java.lang.String value) {
		this.legalSfzh = value;
	}
	
	public java.lang.String getLegalSfzh() {
		return this.legalSfzh;
	}
	public void setIcode(java.lang.String value) {
		this.icode = value;
	}
	
	public java.lang.String getIcode() {
		return this.icode;
	}
	public void setSpecialTime(java.lang.String value) {
		this.specialTime = value;
	}
	
	public java.lang.String getSpecialTime() {
		return this.specialTime;
	}
	public void setSpecialUnit(java.lang.String value) {
		this.specialUnit = value;
	}
	
	public java.lang.String getSpecialUnit() {
		return this.specialUnit;
	}
	public void setTransflag(Long value) {
		this.transflag = value;
	}
	
	public Long getTransflag() {
		return this.transflag;
	}
	public void setCityCode(java.lang.String value) {
		this.cityCode = value;
	}
	
	public java.lang.String getCityCode() {
		return this.cityCode;
	}
	public void setOldCode(java.lang.String value) {
		this.oldCode = value;
	}
	
	public java.lang.String getOldCode() {
		return this.oldCode;
	}
	public void setNewCode(java.lang.String value) {
		this.newCode = value;
	}
	
	public java.lang.String getNewCode() {
		return this.newCode;
	}
	public void setLgsyz(java.lang.String value) {
		this.lgsyz = value;
	}
	
	public java.lang.String getLgsyz() {
		return this.lgsyz;
	}
	public void setLgzl(java.lang.String value) {
		this.lgzl = value;
	}
	
	public java.lang.String getLgzl() {
		return this.lgzl;
	}
	public void setLgwz(java.lang.String value) {
		this.lgwz = value;
	}
	
	public java.lang.String getLgwz() {
		return this.lgwz;
	}
	public void setCardtype(java.lang.String value) {
		this.cardtype = value;
	}
	
	public java.lang.String getCardtype() {
		return this.cardtype;
	}
	public void setCalled(java.lang.String value) {
		this.called = value;
	}
	
	public java.lang.String getCalled() {
		return this.called;
	}
	public void setAreaCode(java.lang.String value) {
		this.areaCode = value;
	}
	
	public java.lang.String getAreaCode() {
		return this.areaCode;
	}
	public void setZrmj(java.lang.String value) {
		this.zrmj = value;
	}
	
	public java.lang.String getZrmj() {
		return this.zrmj;
	}
	public void setStaCode(java.lang.String value) {
		this.staCode = value;
	}
	
	public java.lang.String getStaCode() {
		return this.staCode;
	}
	public void setBurCode(java.lang.String value) {
		this.burCode = value;
	}
	
	public java.lang.String getBurCode() {
		return this.burCode;
	}
	public void setLegalPerson(java.lang.String value) {
		this.legalPerson = value;
	}
	
	public java.lang.String getLegalPerson() {
		return this.legalPerson;
	}
	public void setManager(java.lang.String value) {
		this.manager = value;
	}
	
	public java.lang.String getManager() {
		return this.manager;
	}
	public void setTelLegal(java.lang.String value) {
		this.telLegal = value;
	}
	
	public java.lang.String getTelLegal() {
		return this.telLegal;
	}
	public void setPoliceManager(java.lang.String value) {
		this.policeManager = value;
	}
	
	public java.lang.String getPoliceManager() {
		return this.policeManager;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setPoliceTel(java.lang.String value) {
		this.policeTel = value;
	}
	
	public java.lang.String getPoliceTel() {
		return this.policeTel;
	}
	public void setPolicemen(java.lang.String value) {
		this.policemen = value;
	}
	
	public java.lang.String getPolicemen() {
		return this.policemen;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setModTime(java.lang.String value) {
		this.modTime = value;
	}
	
	public java.lang.String getModTime() {
		return this.modTime;
	}
	public void setRoomNum(java.lang.String value) {
		this.roomNum = value;
	}
	
	public java.lang.String getRoomNum() {
		return this.roomNum;
	}
	public void setBedNum(java.lang.String value) {
		this.bedNum = value;
	}
	
	public java.lang.String getBedNum() {
		return this.bedNum;
	}
	public void setStar(java.lang.String value) {
		this.star = value;
	}
	
	public java.lang.String getStar() {
		return this.star;
	}
	public void setGrade(java.lang.String value) {
		this.grade = value;
	}
	
	public java.lang.String getGrade() {
		return this.grade;
	}
	public void setSpecialLicence(java.lang.String value) {
		this.specialLicence = value;
	}
	
	public java.lang.String getSpecialLicence() {
		return this.specialLicence;
	}
	public void setPoliceLicence(java.lang.String value) {
		this.policeLicence = value;
	}
	
	public java.lang.String getPoliceLicence() {
		return this.policeLicence;
	}
	public void setSuitrooms(java.lang.String value) {
		this.suitrooms = value;
	}
	
	public java.lang.String getSuitrooms() {
		return this.suitrooms;
	}
	public void setStandardrooms(java.lang.String value) {
		this.standardrooms = value;
	}
	
	public java.lang.String getStandardrooms() {
		return this.standardrooms;
	}
	public void setDoublerooms(java.lang.String value) {
		this.doublerooms = value;
	}
	
	public java.lang.String getDoublerooms() {
		return this.doublerooms;
	}
	public void setSinglerooms(java.lang.String value) {
		this.singlerooms = value;
	}
	
	public java.lang.String getSinglerooms() {
		return this.singlerooms;
	}
	public void setOtherrooms(java.lang.String value) {
		this.otherrooms = value;
	}
	
	public java.lang.String getOtherrooms() {
		return this.otherrooms;
	}
	public void setWorkmen(java.lang.String value) {
		this.workmen = value;
	}
	
	public java.lang.String getWorkmen() {
		return this.workmen;
	}
	public void setOtherplacemen(java.lang.String value) {
		this.otherplacemen = value;
	}
	
	public java.lang.String getOtherplacemen() {
		return this.otherplacemen;
	}
	public void setMonitorControl(java.lang.String value) {
		this.monitorControl = value;
	}
	
	public java.lang.String getMonitorControl() {
		return this.monitorControl;
	}
	public void setCoffer(java.lang.String value) {
		this.coffer = value;
	}
	
	public java.lang.String getCoffer() {
		return this.coffer;
	}
	public void setTechDefend(java.lang.String value) {
		this.techDefend = value;
	}
	
	public java.lang.String getTechDefend() {
		return this.techDefend;
	}
	public void setThingDefend(java.lang.String value) {
		this.thingDefend = value;
	}
	
	public java.lang.String getThingDefend() {
		return this.thingDefend;
	}
	public void setKtv(java.lang.String value) {
		this.ktv = value;
	}
	
	public java.lang.String getKtv() {
		return this.ktv;
	}
	public void setChessroom(java.lang.String value) {
		this.chessroom = value;
	}
	
	public java.lang.String getChessroom() {
		return this.chessroom;
	}
	public void setCommerce(java.lang.String value) {
		this.commerce = value;
	}
	
	public java.lang.String getCommerce() {
		return this.commerce;
	}
	public void setSauna(java.lang.String value) {
		this.sauna = value;
	}
	
	public java.lang.String getSauna() {
		return this.sauna;
	}
	public void setBowling(java.lang.String value) {
		this.bowling = value;
	}
	
	public java.lang.String getBowling() {
		return this.bowling;
	}
	public void setGameroom(java.lang.String value) {
		this.gameroom = value;
	}
	
	public java.lang.String getGameroom() {
		return this.gameroom;
	}
	public void setLocktype(java.lang.String value) {
		this.locktype = value;
	}
	
	public java.lang.String getLocktype() {
		return this.locktype;
	}
	public void setLockname(java.lang.String value) {
		this.lockname = value;
	}
	
	public java.lang.String getLockname() {
		return this.lockname;
	}
	public void setBasicremark(java.lang.String value) {
		this.basicremark = value;
	}
	
	public java.lang.String getBasicremark() {
		return this.basicremark;
	}
	public void setKtvRooms(java.lang.String value) {
		this.ktvRooms = value;
	}
	
	public java.lang.String getKtvRooms() {
		return this.ktvRooms;
	}
	public void setKtvMen(java.lang.String value) {
		this.ktvMen = value;
	}
	
	public java.lang.String getKtvMen() {
		return this.ktvMen;
	}
	public void setKtvLicence(java.lang.String value) {
		this.ktvLicence = value;
	}
	
	public java.lang.String getKtvLicence() {
		return this.ktvLicence;
	}
	public void setKtvFireproofing(java.lang.String value) {
		this.ktvFireproofing = value;
	}
	
	public java.lang.String getKtvFireproofing() {
		return this.ktvFireproofing;
	}
	public void setKtvMonitorControl(java.lang.String value) {
		this.ktvMonitorControl = value;
	}
	
	public java.lang.String getKtvMonitorControl() {
		return this.ktvMonitorControl;
	}
	public void setKtvContractor(java.lang.String value) {
		this.ktvContractor = value;
	}
	
	public java.lang.String getKtvContractor() {
		return this.ktvContractor;
	}
	public void setKtvName(java.lang.String value) {
		this.ktvName = value;
	}
	
	public java.lang.String getKtvName() {
		return this.ktvName;
	}
	public void setKtvTel(java.lang.String value) {
		this.ktvTel = value;
	}
	
	public java.lang.String getKtvTel() {
		return this.ktvTel;
	}
	public void setKtvId(java.lang.String value) {
		this.ktvId = value;
	}
	
	public java.lang.String getKtvId() {
		return this.ktvId;
	}
	public void setChessBoxes(java.lang.String value) {
		this.chessBoxes = value;
	}
	
	public java.lang.String getChessBoxes() {
		return this.chessBoxes;
	}
	public void setChessFireproofing(java.lang.String value) {
		this.chessFireproofing = value;
	}
	
	public java.lang.String getChessFireproofing() {
		return this.chessFireproofing;
	}
	public void setChessMonitorControl(java.lang.String value) {
		this.chessMonitorControl = value;
	}
	
	public java.lang.String getChessMonitorControl() {
		return this.chessMonitorControl;
	}
	public void setChessContractor(java.lang.String value) {
		this.chessContractor = value;
	}
	
	public java.lang.String getChessContractor() {
		return this.chessContractor;
	}
	public void setChessName(java.lang.String value) {
		this.chessName = value;
	}
	
	public java.lang.String getChessName() {
		return this.chessName;
	}
	public void setChessTel(java.lang.String value) {
		this.chessTel = value;
	}
	
	public java.lang.String getChessTel() {
		return this.chessTel;
	}
	public void setChessId(java.lang.String value) {
		this.chessId = value;
	}
	
	public java.lang.String getChessId() {
		return this.chessId;
	}
	public void setCommerceCopy(java.lang.String value) {
		this.commerceCopy = value;
	}
	
	public java.lang.String getCommerceCopy() {
		return this.commerceCopy;
	}
	public void setCommerceFax(java.lang.String value) {
		this.commerceFax = value;
	}
	
	public java.lang.String getCommerceFax() {
		return this.commerceFax;
	}
	public void setCommerceTyped(java.lang.String value) {
		this.commerceTyped = value;
	}
	
	public java.lang.String getCommerceTyped() {
		return this.commerceTyped;
	}
	public void setCommerceTicket(java.lang.String value) {
		this.commerceTicket = value;
	}
	
	public java.lang.String getCommerceTicket() {
		return this.commerceTicket;
	}
	public void setCommerceContractor(java.lang.String value) {
		this.commerceContractor = value;
	}
	
	public java.lang.String getCommerceContractor() {
		return this.commerceContractor;
	}
	public void setCommerceName(java.lang.String value) {
		this.commerceName = value;
	}
	
	public java.lang.String getCommerceName() {
		return this.commerceName;
	}
	public void setCommerceTel(java.lang.String value) {
		this.commerceTel = value;
	}
	
	public java.lang.String getCommerceTel() {
		return this.commerceTel;
	}
	public void setCommerceId(java.lang.String value) {
		this.commerceId = value;
	}
	
	public java.lang.String getCommerceId() {
		return this.commerceId;
	}
	public void setSaunaKnead(java.lang.String value) {
		this.saunaKnead = value;
	}
	
	public java.lang.String getSaunaKnead() {
		return this.saunaKnead;
	}
	public void setSaunaRooms(java.lang.String value) {
		this.saunaRooms = value;
	}
	
	public java.lang.String getSaunaRooms() {
		return this.saunaRooms;
	}
	public void setSaunaWorkmen(java.lang.String value) {
		this.saunaWorkmen = value;
	}
	
	public java.lang.String getSaunaWorkmen() {
		return this.saunaWorkmen;
	}
	public void setSaunaContractor(java.lang.String value) {
		this.saunaContractor = value;
	}
	
	public java.lang.String getSaunaContractor() {
		return this.saunaContractor;
	}
	public void setSaunaName(java.lang.String value) {
		this.saunaName = value;
	}
	
	public java.lang.String getSaunaName() {
		return this.saunaName;
	}
	public void setSaunaTel(java.lang.String value) {
		this.saunaTel = value;
	}
	
	public java.lang.String getSaunaTel() {
		return this.saunaTel;
	}
	public void setSaunaId(java.lang.String value) {
		this.saunaId = value;
	}
	
	public java.lang.String getSaunaId() {
		return this.saunaId;
	}
	public void setOtherremark(java.lang.String value) {
		this.otherremark = value;
	}
	
	public java.lang.String getOtherremark() {
		return this.otherremark;
	}
	public void setDeviceType(java.lang.String value) {
		this.deviceType = value;
	}
	
	public java.lang.String getDeviceType() {
		return this.deviceType;
	}
	public void setBaTime(java.lang.String value) {
		this.baTime = value;
	}
	
	public java.lang.String getBaTime() {
		return this.baTime;
	}
	public void setFrontManager(java.lang.String value) {
		this.frontManager = value;
	}
	
	public java.lang.String getFrontManager() {
		return this.frontManager;
	}
	public void setFrdh(java.lang.String value) {
		this.frdh = value;
	}
	
	public java.lang.String getFrdh() {
		return this.frdh;
	}
	public void setLgxz(java.lang.String value) {
		this.lgxz = value;
	}
	
	public java.lang.String getLgxz() {
		return this.lgxz;
	}
	public void setTzhyxkzh(java.lang.String value) {
		this.tzhyxkzh = value;
	}
	
	public java.lang.String getTzhyxkzh() {
		return this.tzhyxkzh;
	}
	public void setZaxkzh(java.lang.String value) {
		this.zaxkzh = value;
	}
	
	public java.lang.String getZaxkzh() {
		return this.zaxkzh;
	}
	public void setTfs(java.lang.String value) {
		this.tfs = value;
	}
	
	public java.lang.String getTfs() {
		return this.tfs;
	}
	public void setBzfs(java.lang.String value) {
		this.bzfs = value;
	}
	
	public java.lang.String getBzfs() {
		return this.bzfs;
	}
	public void setSrfs(java.lang.String value) {
		this.srfs = value;
	}
	
	public java.lang.String getSrfs() {
		return this.srfs;
	}
	public void setDrfs(java.lang.String value) {
		this.drfs = value;
	}
	
	public java.lang.String getDrfs() {
		return this.drfs;
	}
	public void setQtfs(java.lang.String value) {
		this.qtfs = value;
	}
	
	public java.lang.String getQtfs() {
		return this.qtfs;
	}
	public void setRyzs(java.lang.String value) {
		this.ryzs = value;
	}
	
	public java.lang.String getRyzs() {
		return this.ryzs;
	}
	public void setDgrs(java.lang.String value) {
		this.dgrs = value;
	}
	
	public java.lang.String getDgrs() {
		return this.dgrs;
	}
	public void setMs(java.lang.String value) {
		this.ms = value;
	}
	
	public java.lang.String getMs() {
		return this.ms;
	}
	public void setWfhg(java.lang.String value) {
		this.wfhg = value;
	}
	
	public java.lang.String getWfhg() {
		return this.wfhg;
	}
	public void setJfhg(java.lang.String value) {
		this.jfhg = value;
	}
	
	public java.lang.String getJfhg() {
		return this.jfhg;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("Code",getCode())
			.append("Ywjk",getYwjk())
			.append("Fjbxx",getFjbxx())
			.append("Ktvwt",getKtvwt())
			.append("Fscg",getFscg())
			.append("Swzx",getSwzx())
			.append("Snf",getSnf())
			.append("Blqg",getBlqg())
			.append("Yxjf",getYxjf())
			.append("Rzbz",getRzbz())
			.append("LegalSfzh",getLegalSfzh())
			.append("Icode",getIcode())
			.append("SpecialTime",getSpecialTime())
			.append("SpecialUnit",getSpecialUnit())
			.append("Transflag",getTransflag())
			.append("CityCode",getCityCode())
			.append("OldCode",getOldCode())
			.append("NewCode",getNewCode())
			.append("Lgsyz",getLgsyz())
			.append("Lgzl",getLgzl())
			.append("Lgwz",getLgwz())
			.append("Cardtype",getCardtype())
			.append("Called",getCalled())
			.append("AreaCode",getAreaCode())
			.append("Zrmj",getZrmj())
			.append("StaCode",getStaCode())
			.append("BurCode",getBurCode())
			.append("LegalPerson",getLegalPerson())
			.append("Manager",getManager())
			.append("TelLegal",getTelLegal())
			.append("PoliceManager",getPoliceManager())
			.append("Address",getAddress())
			.append("Tel",getTel())
			.append("PoliceTel",getPoliceTel())
			.append("Policemen",getPolicemen())
			.append("Status",getStatus())
			.append("ModTime",getModTime())
			.append("RoomNum",getRoomNum())
			.append("BedNum",getBedNum())
			.append("Star",getStar())
			.append("Grade",getGrade())
			.append("SpecialLicence",getSpecialLicence())
			.append("PoliceLicence",getPoliceLicence())
			.append("Suitrooms",getSuitrooms())
			.append("Standardrooms",getStandardrooms())
			.append("Doublerooms",getDoublerooms())
			.append("Singlerooms",getSinglerooms())
			.append("Otherrooms",getOtherrooms())
			.append("Workmen",getWorkmen())
			.append("Otherplacemen",getOtherplacemen())
			.append("MonitorControl",getMonitorControl())
			.append("Coffer",getCoffer())
			.append("TechDefend",getTechDefend())
			.append("ThingDefend",getThingDefend())
			.append("Ktv",getKtv())
			.append("Chessroom",getChessroom())
			.append("Commerce",getCommerce())
			.append("Sauna",getSauna())
			.append("Bowling",getBowling())
			.append("Gameroom",getGameroom())
			.append("Locktype",getLocktype())
			.append("Lockname",getLockname())
			.append("Basicremark",getBasicremark())
			.append("KtvRooms",getKtvRooms())
			.append("KtvMen",getKtvMen())
			.append("KtvLicence",getKtvLicence())
			.append("KtvFireproofing",getKtvFireproofing())
			.append("KtvMonitorControl",getKtvMonitorControl())
			.append("KtvContractor",getKtvContractor())
			.append("KtvName",getKtvName())
			.append("KtvTel",getKtvTel())
			.append("KtvId",getKtvId())
			.append("ChessBoxes",getChessBoxes())
			.append("ChessFireproofing",getChessFireproofing())
			.append("ChessMonitorControl",getChessMonitorControl())
			.append("ChessContractor",getChessContractor())
			.append("ChessName",getChessName())
			.append("ChessTel",getChessTel())
			.append("ChessId",getChessId())
			.append("CommerceCopy",getCommerceCopy())
			.append("CommerceFax",getCommerceFax())
			.append("CommerceTyped",getCommerceTyped())
			.append("CommerceTicket",getCommerceTicket())
			.append("CommerceContractor",getCommerceContractor())
			.append("CommerceName",getCommerceName())
			.append("CommerceTel",getCommerceTel())
			.append("CommerceId",getCommerceId())
			.append("SaunaKnead",getSaunaKnead())
			.append("SaunaRooms",getSaunaRooms())
			.append("SaunaWorkmen",getSaunaWorkmen())
			.append("SaunaContractor",getSaunaContractor())
			.append("SaunaName",getSaunaName())
			.append("SaunaTel",getSaunaTel())
			.append("SaunaId",getSaunaId())
			.append("Otherremark",getOtherremark())
			.append("DeviceType",getDeviceType())
			.append("BaTime",getBaTime())
			.append("FrontManager",getFrontManager())
			.append("Frdh",getFrdh())
			.append("Lgxz",getLgxz())
			.append("Tzhyxkzh",getTzhyxkzh())
			.append("Zaxkzh",getZaxkzh())
			.append("Tfs",getTfs())
			.append("Bzfs",getBzfs())
			.append("Srfs",getSrfs())
			.append("Drfs",getDrfs())
			.append("Qtfs",getQtfs())
			.append("Ryzs",getRyzs())
			.append("Dgrs",getDgrs())
			.append("Ms",getMs())
			.append("Wfhg",getWfhg())
			.append("Jfhg",getJfhg())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCode())
			.append(getYwjk())
			.append(getFjbxx())
			.append(getKtvwt())
			.append(getFscg())
			.append(getSwzx())
			.append(getSnf())
			.append(getBlqg())
			.append(getYxjf())
			.append(getRzbz())
			.append(getLegalSfzh())
			.append(getIcode())
			.append(getSpecialTime())
			.append(getSpecialUnit())
			.append(getTransflag())
			.append(getCityCode())
			.append(getOldCode())
			.append(getNewCode())
			.append(getLgsyz())
			.append(getLgzl())
			.append(getLgwz())
			.append(getCardtype())
			.append(getCalled())
			.append(getAreaCode())
			.append(getZrmj())
			.append(getStaCode())
			.append(getBurCode())
			.append(getLegalPerson())
			.append(getManager())
			.append(getTelLegal())
			.append(getPoliceManager())
			.append(getAddress())
			.append(getTel())
			.append(getPoliceTel())
			.append(getPolicemen())
			.append(getStatus())
			.append(getModTime())
			.append(getRoomNum())
			.append(getBedNum())
			.append(getStar())
			.append(getGrade())
			.append(getSpecialLicence())
			.append(getPoliceLicence())
			.append(getSuitrooms())
			.append(getStandardrooms())
			.append(getDoublerooms())
			.append(getSinglerooms())
			.append(getOtherrooms())
			.append(getWorkmen())
			.append(getOtherplacemen())
			.append(getMonitorControl())
			.append(getCoffer())
			.append(getTechDefend())
			.append(getThingDefend())
			.append(getKtv())
			.append(getChessroom())
			.append(getCommerce())
			.append(getSauna())
			.append(getBowling())
			.append(getGameroom())
			.append(getLocktype())
			.append(getLockname())
			.append(getBasicremark())
			.append(getKtvRooms())
			.append(getKtvMen())
			.append(getKtvLicence())
			.append(getKtvFireproofing())
			.append(getKtvMonitorControl())
			.append(getKtvContractor())
			.append(getKtvName())
			.append(getKtvTel())
			.append(getKtvId())
			.append(getChessBoxes())
			.append(getChessFireproofing())
			.append(getChessMonitorControl())
			.append(getChessContractor())
			.append(getChessName())
			.append(getChessTel())
			.append(getChessId())
			.append(getCommerceCopy())
			.append(getCommerceFax())
			.append(getCommerceTyped())
			.append(getCommerceTicket())
			.append(getCommerceContractor())
			.append(getCommerceName())
			.append(getCommerceTel())
			.append(getCommerceId())
			.append(getSaunaKnead())
			.append(getSaunaRooms())
			.append(getSaunaWorkmen())
			.append(getSaunaContractor())
			.append(getSaunaName())
			.append(getSaunaTel())
			.append(getSaunaId())
			.append(getOtherremark())
			.append(getDeviceType())
			.append(getBaTime())
			.append(getFrontManager())
			.append(getFrdh())
			.append(getLgxz())
			.append(getTzhyxkzh())
			.append(getZaxkzh())
			.append(getTfs())
			.append(getBzfs())
			.append(getSrfs())
			.append(getDrfs())
			.append(getQtfs())
			.append(getRyzs())
			.append(getDgrs())
			.append(getMs())
			.append(getWfhg())
			.append(getJfhg())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TtjGuest == false) return false;
		if(this == obj) return true;
		TtjGuest other = (TtjGuest)obj;
		return new EqualsBuilder()
			.append(getCode(),other.getCode())
			.append(getYwjk(),other.getYwjk())
			.append(getFjbxx(),other.getFjbxx())
			.append(getKtvwt(),other.getKtvwt())
			.append(getFscg(),other.getFscg())
			.append(getSwzx(),other.getSwzx())
			.append(getSnf(),other.getSnf())
			.append(getBlqg(),other.getBlqg())
			.append(getYxjf(),other.getYxjf())
			.append(getRzbz(),other.getRzbz())
			.append(getLegalSfzh(),other.getLegalSfzh())
			.append(getIcode(),other.getIcode())
			.append(getSpecialTime(),other.getSpecialTime())
			.append(getSpecialUnit(),other.getSpecialUnit())
			.append(getTransflag(),other.getTransflag())
			.append(getCityCode(),other.getCityCode())
			.append(getOldCode(),other.getOldCode())
			.append(getNewCode(),other.getNewCode())
			.append(getLgsyz(),other.getLgsyz())
			.append(getLgzl(),other.getLgzl())
			.append(getLgwz(),other.getLgwz())
			.append(getCardtype(),other.getCardtype())
			.append(getCalled(),other.getCalled())
			.append(getAreaCode(),other.getAreaCode())
			.append(getZrmj(),other.getZrmj())
			.append(getStaCode(),other.getStaCode())
			.append(getBurCode(),other.getBurCode())
			.append(getLegalPerson(),other.getLegalPerson())
			.append(getManager(),other.getManager())
			.append(getTelLegal(),other.getTelLegal())
			.append(getPoliceManager(),other.getPoliceManager())
			.append(getAddress(),other.getAddress())
			.append(getTel(),other.getTel())
			.append(getPoliceTel(),other.getPoliceTel())
			.append(getPolicemen(),other.getPolicemen())
			.append(getStatus(),other.getStatus())
			.append(getModTime(),other.getModTime())
			.append(getRoomNum(),other.getRoomNum())
			.append(getBedNum(),other.getBedNum())
			.append(getStar(),other.getStar())
			.append(getGrade(),other.getGrade())
			.append(getSpecialLicence(),other.getSpecialLicence())
			.append(getPoliceLicence(),other.getPoliceLicence())
			.append(getSuitrooms(),other.getSuitrooms())
			.append(getStandardrooms(),other.getStandardrooms())
			.append(getDoublerooms(),other.getDoublerooms())
			.append(getSinglerooms(),other.getSinglerooms())
			.append(getOtherrooms(),other.getOtherrooms())
			.append(getWorkmen(),other.getWorkmen())
			.append(getOtherplacemen(),other.getOtherplacemen())
			.append(getMonitorControl(),other.getMonitorControl())
			.append(getCoffer(),other.getCoffer())
			.append(getTechDefend(),other.getTechDefend())
			.append(getThingDefend(),other.getThingDefend())
			.append(getKtv(),other.getKtv())
			.append(getChessroom(),other.getChessroom())
			.append(getCommerce(),other.getCommerce())
			.append(getSauna(),other.getSauna())
			.append(getBowling(),other.getBowling())
			.append(getGameroom(),other.getGameroom())
			.append(getLocktype(),other.getLocktype())
			.append(getLockname(),other.getLockname())
			.append(getBasicremark(),other.getBasicremark())
			.append(getKtvRooms(),other.getKtvRooms())
			.append(getKtvMen(),other.getKtvMen())
			.append(getKtvLicence(),other.getKtvLicence())
			.append(getKtvFireproofing(),other.getKtvFireproofing())
			.append(getKtvMonitorControl(),other.getKtvMonitorControl())
			.append(getKtvContractor(),other.getKtvContractor())
			.append(getKtvName(),other.getKtvName())
			.append(getKtvTel(),other.getKtvTel())
			.append(getKtvId(),other.getKtvId())
			.append(getChessBoxes(),other.getChessBoxes())
			.append(getChessFireproofing(),other.getChessFireproofing())
			.append(getChessMonitorControl(),other.getChessMonitorControl())
			.append(getChessContractor(),other.getChessContractor())
			.append(getChessName(),other.getChessName())
			.append(getChessTel(),other.getChessTel())
			.append(getChessId(),other.getChessId())
			.append(getCommerceCopy(),other.getCommerceCopy())
			.append(getCommerceFax(),other.getCommerceFax())
			.append(getCommerceTyped(),other.getCommerceTyped())
			.append(getCommerceTicket(),other.getCommerceTicket())
			.append(getCommerceContractor(),other.getCommerceContractor())
			.append(getCommerceName(),other.getCommerceName())
			.append(getCommerceTel(),other.getCommerceTel())
			.append(getCommerceId(),other.getCommerceId())
			.append(getSaunaKnead(),other.getSaunaKnead())
			.append(getSaunaRooms(),other.getSaunaRooms())
			.append(getSaunaWorkmen(),other.getSaunaWorkmen())
			.append(getSaunaContractor(),other.getSaunaContractor())
			.append(getSaunaName(),other.getSaunaName())
			.append(getSaunaTel(),other.getSaunaTel())
			.append(getSaunaId(),other.getSaunaId())
			.append(getOtherremark(),other.getOtherremark())
			.append(getDeviceType(),other.getDeviceType())
			.append(getBaTime(),other.getBaTime())
			.append(getFrontManager(),other.getFrontManager())
			.append(getFrdh(),other.getFrdh())
			.append(getLgxz(),other.getLgxz())
			.append(getTzhyxkzh(),other.getTzhyxkzh())
			.append(getZaxkzh(),other.getZaxkzh())
			.append(getTfs(),other.getTfs())
			.append(getBzfs(),other.getBzfs())
			.append(getSrfs(),other.getSrfs())
			.append(getDrfs(),other.getDrfs())
			.append(getQtfs(),other.getQtfs())
			.append(getRyzs(),other.getRyzs())
			.append(getDgrs(),other.getDgrs())
			.append(getMs(),other.getMs())
			.append(getWfhg(),other.getWfhg())
			.append(getJfhg(),other.getJfhg())
			.isEquals();
	}
}

