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

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
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
public class TchAlarminforDao extends BaseSpringJdbcDao<TchAlarminfor,java.lang.String>{
	
	public Class getEntityClass() {
		return TchAlarminfor.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" t.XH as xh,"
				+" t.SFZH as sfzh,"
				+" t.XM as xm,"
				+" t.HM1 as hm1,"
				+" t.HM2 as hm2,"
				+" t.XB as xb,"
				+" t.NL as nl,"
				+" t.JG as jg,"
				+" t.HJD as hjd,"
				+" t.ZZ as zz,"
				+" t.SG as sg,"
				+" t.TX as tx,"
				+" t.TSTZ as tstz,"
				+" t.AB as ab,"
				+" t.LADW as ladw,"
				+" t.LASJ as lasj,"
				+" t.JYAQ as jyaq,"
				+" t.TBDW as tbdw,"
				+" t.ID as id,"
				+" t.NAME as name,"
				+" t.ID_NAME as idName,"
				+" t.ID_CODE as idCode,"
				+" t.SEX as sex,"
				+" t.NATION as nation,"
				+" t.BDATE as bdate,"
				+" t.ADDRESS as address,"
				+" t.XZQH as xzqh,"
				+" t.NO_ROOM as noRoom,"
				+" t.IN_TIME as inTime,"
				+" t.FTIME as ftime,"
				+" t.ALARM as alarm,"
				+" t.TYPE as type,"
				+" t.BKLX as bklx,"
				+" t.ALARMTJ as alarmtj,"
				+" t.ZHSJ as zhsj,"
				+" t.PJDW as pjdw,"
				+" t.CLQK as clqk,"
				+" t.PJSJ as pjsj,"
				+" t.BKID as bkid,"
				+" t.BKTEL as bktel,"
				+" t.AUDIT_MARK as auditMark,"
				+" t.BKSJ as bksj,"
				+" t.CZR as czr,"
				+" t.EMPFLAG as empflag,"
				+" t.SFYX as sfyx,"
				+" t.WXYY as wxyy,"
				+" t.SFYZH as sfyzh,"
				+" t.ZHDWMC as zhdwmc,"
				+" t.WZHYY as wzhyy,"
				+" t.CJR as cjr,"
				+" hotel.BUR_CODE as burCode,"
				+" hotel.STA_CODE as staCode,"
				+" hotel.called as hotelname,"
				+" hotel.address as hotelAddress "
				+" from T_CH_ALARMINFOR t , T_HOTEL hotel ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_CH_ALARMINFOR where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ID=? and substr(t.id,1,10)=hotel.code(+)";
	}
	
	public void save(TchAlarminfor entity) {
		String sql = "insert into T_CH_ALARMINFOR " 
			 + " (XH,SFZH,XM,HM1,HM2,XB,NL,JG,HJD,ZZ,SG,TX,TSTZ,AB,LADW,LASJ,JYAQ,TBDW,ID,NAME,ID_NAME,ID_CODE,SEX,NATION,BDATE,ADDRESS,XZQH,NO_ROOM,IN_TIME,FTIME,ALARM,TYPE,BKLX,ALARMTJ,ZHSJ,PJDW,CLQK,PJSJ,BKID,BKTEL,AUDIT_MARK,BKSJ,CZR,EMPFLAG,SFYX,WXYY,SFYZH,ZHDWMC,WZHYY,CJR) " 
			 + " values "
			 + " (:xh,:sfzh,:xm,:hm1,:hm2,:xb,:nl,:jg,:hjd,:zz,:sg,:tx,:tstz,:ab,:ladw,:lasj,:jyaq,:tbdw,:id,:name,:idName,:idCode,:sex,:nation,:bdate,:address,:xzqh,:noRoom,:inTime,:ftime,:alarm,:type,:bklx,:alarmtj,:zhsj,:pjdw,:clqk,:pjsj,:bkid,:bktel,:auditMark,:bksj,:czr,:empflag,:sfyx,:wxyy,:sfyzh,:zhdwmc,:wzhyy,:cjr)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_CH_ALARMINFOR",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TchAlarminfor entity) {
		String sql = "update T_CH_ALARMINFOR set "
					+ " XH=:xh,SFZH=:sfzh,XM=:xm,HM1=:hm1,HM2=:hm2,XB=:xb,NL=:nl,JG=:jg,HJD=:hjd,ZZ=:zz,SG=:sg,TX=:tx,TSTZ=:tstz,AB=:ab,LADW=:ladw,LASJ=:lasj,JYAQ=:jyaq,TBDW=:tbdw,ID=:id,NAME=:name,ID_NAME=:idName,ID_CODE=:idCode,SEX=:sex,NATION=:nation,BDATE=:bdate,ADDRESS=:address,XZQH=:xzqh,NO_ROOM=:noRoom,IN_TIME=:inTime,FTIME=:ftime,ALARM=:alarm,TYPE=:type,BKLX=:bklx,ALARMTJ=:alarmtj,ZHSJ=:zhsj,PJDW=:pjdw,CLQK=:clqk,PJSJ=:pjsj,BKID=:bkid,BKTEL=:bktel,AUDIT_MARK=:auditMark,BKSJ=:bksj,CZR=:czr,EMPFLAG=:empflag,SFYX=:sfyx,WXYY=:wxyy,SFYZH=:sfyzh,ZHDWMC=:zhdwmc,WZHYY=:wzhyy,CJR=:cjr "
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
		String sql = getSelectPrefix() + "  where 1=1 and substr(t.id,1,10)=hotel.code(+) "
				+ "/~ and t.XH = '[xh]' ~/"
				+ "/~ and t.SFZH = '[sfzh]' ~/"
				+ "/~ and t.XM like '%[xm]%' ~/"
				+ "/~ and t.HM1 = '[hm1]' ~/"
				+ "/~ and t.HM2 = '[hm2]' ~/"
				+ "/~ and t.XB = '[xb]' ~/"
				+ "/~ and t.NL = '[nl]' ~/"
				+ "/~ and t.JG = '[jg]' ~/"
				+ "/~ and t.HJD = '[hjd]' ~/"
				+ "/~ and t.ZZ = '[zz]' ~/"
				+ "/~ and t.SG = '[sg]' ~/"
				+ "/~ and t.TX = '[tx]' ~/"
				+ "/~ and t.TSTZ = '[tstz]' ~/"
				+ "/~ and t.AB = '[ab]' ~/"
				+ "/~ and t.LADW = '[ladw]' ~/"
				+ "/~ and t.LASJ = '[lasj]' ~/"
				+ "/~ and t.JYAQ = '[jyaq]' ~/"
				+ "/~ and t.TBDW = '[tbdw]' ~/"
				+ "/~ and t.NAME like '%[name]%' ~/"
				+ "/~ and t.ID_NAME = '[idName]' ~/"
				+ "/~ and t.ID_CODE like '%[idCode]%' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.NATION = '[nation]' ~/"
				+ "/~ and t.BDATE = '[bdate]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.XZQH like substr('[province]',0,2)||'%' ~/"
				+ "/~ and t.XZQH = '[xzqh]' ~/"
				+ "/~ and t.NO_ROOM = '[noRoom]' ~/"
				+ "/~ and t.IN_TIME = '[inTime]' ~/"
				+ "/~ and t.FTIME = '[ftime]' ~/"
				+ "/~ and t.ALARM = '[alarm]' ~/"
				+ "/~ and t.TYPE = '[type]' ~/"
				+ "/~ and t.BKLX = '[bklx]' ~/"
				+ "/~ and t.ALARMTJ = '[alarmtj]' ~/"
				+ "/~ and t.ZHSJ = '[zhsj]' ~/"
				+ "/~ and t.PJDW = '[pjdw]' ~/"
				+ "/~ and t.CLQK = '[clqk]' ~/"
				+ "/~ and t.PJSJ >= '[pjsj_BeginFormat]' ~/"
				+ "/~ and t.PJSJ <= '[pjsj_EndFormat]' ~/"
				+ "/~ and t.BKID = '[bkid]' ~/"
				+ "/~ and t.BKTEL = '[bktel]' ~/"
				+ "/~ and t.AUDIT_MARK = '[auditMark]' ~/"
				+ "/~ and t.BKSJ = '[bksj]' ~/"
				+ "/~ and t.CZR = '[czr]' ~/"
				+ "/~ and t.EMPFLAG = '[empflag]' ~/"
				+ "/~ and t.SFYX = '[sfyx]' ~/"
				+ "/~ and t.WXYY = '[wxyy]' ~/"
				+ "/~ and t.SFYZH = '[sfyzh]' ~/"
				+ "/~ and t.ZHDWMC = '[zhdwmc]' ~/"
				+ "/~ and t.WZHYY = '[wzhyy]' ~/"
				+ "/~ and t.CJR = '[cjr]' ~/"
				+ "/~ and hotel.STA_CODE = '[staCode]' ~/"
				+ "/~ and hotel.BUR_CODE = '[burCode]' ~/"
				+ "/~ and hotel.called like '%[hotelname]%' ~/"
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
	
	
	private String createSql = "insert into T_CH_ALARMINFOR " 
		 + " (XH,SFZH,XM,HM1,HM2,XB,NL,JG,HJD,ZZ,SG,TX,TSTZ,AB,LADW,LASJ,JYAQ,TBDW,ID,NAME,ID_NAME,ID_CODE,SEX,NATION,BDATE,ADDRESS,XZQH,NO_ROOM,IN_TIME,FTIME,ALARM,TYPE,BKLX,ALARMTJ,ZHSJ,PJDW,CLQK,PJSJ,BKID,BKTEL,AUDIT_MARK,BKSJ,CZR,EMPFLAG,SFYX,WXYY,SFYZH,ZHDWMC,WZHYY,CJR) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_CH_ALARMINFOR set "
		+ " XH=?,SFZH=?,XM=?,HM1=?,HM2=?,XB=?,NL=?,JG=?,HJD=?,ZZ=?,SG=?,TX=?,TSTZ=?,AB=?,LADW=?,LASJ=?,JYAQ=?,TBDW=?,ID=?,NAME=?,ID_NAME=?,ID_CODE=?,SEX=?,NATION=?,BDATE=?,ADDRESS=?,XZQH=?,NO_ROOM=?,IN_TIME=?,FTIME=?,ALARM=?,TYPE=?,BKLX=?,ALARMTJ=?,ZHSJ=?,PJDW=?,CLQK=?,PJSJ=?,BKID=?,BKTEL=?,AUDIT_MARK=?,BKSJ=?,CZR=?,EMPFLAG=?,SFYX=?,WXYY=?,SFYZH=?,ZHDWMC=?,WZHYY=?,CJR=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TchAlarminfor entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setString(1, entity.getXh());
						ps.setString(2, entity.getSfzh());
						ps.setString(3, entity.getXm());
						ps.setString(4, entity.getHm1());
						ps.setString(5, entity.getHm2());
						ps.setString(6, entity.getXb());
						ps.setString(7, entity.getNl());
						ps.setString(8, entity.getJg());
						ps.setString(9, entity.getHjd());
						ps.setString(10, entity.getZz());
						ps.setString(11, entity.getSg());
						ps.setString(12, entity.getTx());
						ps.setString(13, entity.getTstz());
						ps.setString(14, entity.getAb());
						ps.setString(15, entity.getLadw());
						ps.setString(16, entity.getLasj());
						ps.setString(17, entity.getJyaq());
						ps.setString(18, entity.getTbdw());
						ps.setString(19, entity.getId());
						ps.setString(20, entity.getName());
						ps.setString(21, entity.getIdName());
						ps.setString(22, entity.getIdCode());
						ps.setString(23, entity.getSex());
						ps.setString(24, entity.getNation());
						ps.setString(25, entity.getBdate());
						ps.setString(26, entity.getAddress());
						ps.setString(27, entity.getXzqh());
						ps.setString(28, entity.getNoRoom());
						ps.setString(29, entity.getInTime());
						ps.setString(30, entity.getFtime());
						ps.setString(31, entity.getAlarm());
						ps.setString(32, entity.getType());
						ps.setString(33, entity.getBklx());
						ps.setString(34, entity.getAlarmtj());
						ps.setString(35, entity.getZhsj());
						ps.setString(36, entity.getPjdw());
						ps.setString(37, entity.getClqk());
						ps.setString(38, entity.getPjsj());
						ps.setString(39, entity.getBkid());
						ps.setString(40, entity.getBktel());
						ps.setString(41, entity.getAuditMark());
						ps.setString(42, entity.getBksj());
						ps.setString(43, entity.getCzr());
						ps.setString(44, entity.getEmpflag());
						ps.setString(45, entity.getSfyx());
						ps.setString(46, entity.getWxyy());
						ps.setString(47, entity.getSfyzh());
						ps.setString(48, entity.getZhdwmc());
						ps.setString(49, entity.getWzhyy());
						ps.setString(50, entity.getCjr());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTchAlarminfor(final TchAlarminfor entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getXh());
				ps.setString(2, entity.getSfzh());
				ps.setString(3, entity.getXm());
				ps.setString(4, entity.getHm1());
				ps.setString(5, entity.getHm2());
				ps.setString(6, entity.getXb());
				ps.setString(7, entity.getNl());
				ps.setString(8, entity.getJg());
				ps.setString(9, entity.getHjd());
				ps.setString(10, entity.getZz());
				ps.setString(11, entity.getSg());
				ps.setString(12, entity.getTx());
				ps.setString(13, entity.getTstz());
				ps.setString(14, entity.getAb());
				ps.setString(15, entity.getLadw());
				ps.setString(16, entity.getLasj());
				ps.setString(17, entity.getJyaq());
				ps.setString(18, entity.getTbdw());
				ps.setString(19, entity.getId());
				ps.setString(20, entity.getName());
				ps.setString(21, entity.getIdName());
				ps.setString(22, entity.getIdCode());
				ps.setString(23, entity.getSex());
				ps.setString(24, entity.getNation());
				ps.setString(25, entity.getBdate());
				ps.setString(26, entity.getAddress());
				ps.setString(27, entity.getXzqh());
				ps.setString(28, entity.getNoRoom());
				ps.setString(29, entity.getInTime());
				ps.setString(30, entity.getFtime());
				ps.setString(31, entity.getAlarm());
				ps.setString(32, entity.getType());
				ps.setString(33, entity.getBklx());
				ps.setString(34, entity.getAlarmtj());
				ps.setString(35, entity.getZhsj());
				ps.setString(36, entity.getPjdw());
				ps.setString(37, entity.getClqk());
				ps.setString(38, entity.getPjsj());
				ps.setString(39, entity.getBkid());
				ps.setString(40, entity.getBktel());
				ps.setString(41, entity.getAuditMark());
				ps.setString(42, entity.getBksj());
				ps.setString(43, entity.getCzr());
				ps.setString(44, entity.getEmpflag());
				ps.setString(45, entity.getSfyx());
				ps.setString(46, entity.getWxyy());
				ps.setString(47, entity.getSfyzh());
				ps.setString(48, entity.getZhdwmc());
				ps.setString(49, entity.getWzhyy());
				ps.setString(50, entity.getCjr());
			}
		});
	}

	
	public void updateTchAlarminfor(final TchAlarminfor entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, entity.getXh());
				ps.setString(2, entity.getSfzh());
				ps.setString(3, entity.getXm());
				ps.setString(4, entity.getHm1());
				ps.setString(5, entity.getHm2());
				ps.setString(6, entity.getXb());
				ps.setString(7, entity.getNl());
				ps.setString(8, entity.getJg());
				ps.setString(9, entity.getHjd());
				ps.setString(10, entity.getZz());
				ps.setString(11, entity.getSg());
				ps.setString(12, entity.getTx());
				ps.setString(13, entity.getTstz());
				ps.setString(14, entity.getAb());
				ps.setString(15, entity.getLadw());
				ps.setString(16, entity.getLasj());
				ps.setString(17, entity.getJyaq());
				ps.setString(18, entity.getTbdw());
				ps.setString(19, entity.getId());
				ps.setString(20, entity.getName());
				ps.setString(21, entity.getIdName());
				ps.setString(22, entity.getIdCode());
				ps.setString(23, entity.getSex());
				ps.setString(24, entity.getNation());
				ps.setString(25, entity.getBdate());
				ps.setString(26, entity.getAddress());
				ps.setString(27, entity.getXzqh());
				ps.setString(28, entity.getNoRoom());
				ps.setString(29, entity.getInTime());
				ps.setString(30, entity.getFtime());
				ps.setString(31, entity.getAlarm());
				ps.setString(32, entity.getType());
				ps.setString(33, entity.getBklx());
				ps.setString(34, entity.getAlarmtj());
				ps.setString(35, entity.getZhsj());
				ps.setString(36, entity.getPjdw());
				ps.setString(37, entity.getClqk());
				ps.setString(38, entity.getPjsj());
				ps.setString(39, entity.getBkid());
				ps.setString(40, entity.getBktel());
				ps.setString(41, entity.getAuditMark());
				ps.setString(42, entity.getBksj());
				ps.setString(43, entity.getCzr());
				ps.setString(44, entity.getEmpflag());
				ps.setString(45, entity.getSfyx());
				ps.setString(46, entity.getWxyy());
				ps.setString(47, entity.getSfyzh());
				ps.setString(48, entity.getZhdwmc());
				ps.setString(49, entity.getWzhyy());
				ps.setString(50, entity.getCjr());
			}
		});
	}

	
	public void deleteTchAlarminfor(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
