/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.gas.dao;

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

import com.dyneinfo.gas.model.*;
import com.dyneinfo.gas.dao.*;
import com.dyneinfo.gas.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class TpersonAlarmDao extends BaseSpringJdbcDao<TpersonAlarm,java.lang.String>{
	
	public Class getEntityClass() {
		return TpersonAlarm.class;
	}
	
	public String getIdentifierPropertyName() {
		return "id";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" XH as xh,"
				+" SFZH as sfzh,"
				+" XM as xm,"
				+" HM1 as hm1,"
				+" HM2 as hm2,"
				+" XB as xb,"
				+" to_char( to_date( NL, 'yyyy-MM-dd'), 'yyyy-MM-dd') as nl,"
				+" JG as jg,"
				+" HJD as hjd,"
				+" ZZ as zz,"
				+" SG as sg,"
				+" TX as tx,"
				+" TSTZ as tstz,"
				+" AB as ab,"
				+" LADW as ladw,"
				+" LASJ as lasj,"
				+" JYAQ as jyaq,"
				+" TBDW as tbdw,"
				+" ID as id,"
				+" NAME as name,"
				+" ID_NAME as idName,"
				+" ID_CODE as idCode,"
				+" SEX as sex,"
				+" NATION as nation,"
				+" to_char( to_date(BDATE, 'yyyy-MM-dd'), 'yyyy-MM-dd') as bdate,"
				+" t.ADDRESS as address,"
				+" XZQH as xzqh,"
				+" t.CPCODE as cpcode,"
				+" to_char( to_date(BUYTIME , 'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as buytime,"
				+" to_char(  to_date(ALARMTIME, 'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as alarmtime,"
				+" ALARMSOURCE as alarmsource,"
				+" BKLX as bklx,"
				+" to_char( to_date(ZHSJ, 'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as zhsj,"
				+" PJDW as pjdw,"
				+" CLQK as clqk,"
				+" to_char( to_date(PJSJ, 'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi') as pjsj,"
				+" BKID as bkid,"
				+" ALARMTEL as alarmtel,"
				+" to_char( to_date(BKSJ , 'yyyy-MM-dd hh24:mi'),'yyyy-MM-dd hh24:mi')as bksj,"
				+" CZR as czr,"
				+" EMPFLAG as empflag,"
				+" SFYX as sfyx,"
				+" WXYY as wxyy,"
				+" SFYZH as sfyzh,"
				+" ZHDWMC as zhdwmc,"
				+" WZHYY as wzhyy,"
				+" CJR as cjr,"
				+" b.CPNAME as cpname,"
				+" b.BURCODE as burcode,"
				+" b.STACODE as stacode,"
				+" CLFLAG as clflag"
				+" from t_companyinfo b,T_PERSON_ALARM ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from T_PERSON_ALARM where ID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " t where t.cpcode= b.cpcode and ID=? ";
	}
	
	public void save(TpersonAlarm entity) {
		String sql = "insert into T_PERSON_ALARM " 
			 + " (XH,SFZH,XM,HM1,HM2,XB,NL,JG,HJD,ZZ,SG,TX,TSTZ,AB,LADW,LASJ,JYAQ,TBDW,ID,NAME,ID_NAME,ID_CODE,SEX,NATION,BDATE,ADDRESS,XZQH,CPCODE,BUYTIME,ALARMTIME,ALARMSOURCE,BKLX,ZHSJ,PJDW,CLQK,PJSJ,BKID,ALARMTEL,BKSJ,CZR,EMPFLAG,SFYX,WXYY,SFYZH,ZHDWMC,WZHYY,CJR,CLFLAG) " 
			 + " values "
			 + " (:xh,:sfzh,:xm,:hm1,:hm2,:xb,:nl,:jg,:hjd,:zz,:sg,:tx,:tstz,:ab,:ladw,:lasj,:jyaq,:tbdw,:id,:name,:idName,:idCode,:sex,:nation,:bdate,:address,:xzqh,:cpcode,:buytime,:alarmtime,:alarmsource,:bklx,:zhsj,:pjdw,:clqk,:pjsj,:bkid,:alarmtel,:bksj,:czr,:empflag,:sfyx,:wxyy,:sfyzh,:zhdwmc,:wzhyy,:cjr,:clflag)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_T_PERSON_ALARM",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(TpersonAlarm entity) {
		String sql = "update T_PERSON_ALARM set "
					+ "ZHSJ=:zhsj,PJDW=:pjdw,CLQK=:clqk,CZR=:czr,EMPFLAG=:empflag,SFYX=:sfyx,WXYY=:wxyy,SFYZH=:sfyzh,ZHDWMC=:zhdwmc,WZHYY=:wzhyy,CJR=:cjr,CLFLAG=:clflag "
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
		String sql = getSelectPrefix() + " t where t.cpcode= b.cpcode "
				+ "/~ and t.XH = '[xh]' ~/"
				+ "/~ and t.SFZH = '[sfzh]' ~/"
				+ "/~ and t.XM = '[xm]' ~/"
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
				+ "/~ and t.NAME = '[name]' ~/"
				+ "/~ and t.ID_NAME = '[idName]' ~/"
				+ "/~ and t.ID_CODE = '[idCode]' ~/"
				+ "/~ and t.SEX = '[sex]' ~/"
				+ "/~ and t.NATION = '[nation]' ~/"
				+ "/~ and t.BDATE = '[bdate]' ~/"
				+ "/~ and t.ADDRESS = '[address]' ~/"
				+ "/~ and t.XZQH = '[xzqh]' ~/"
				+ "/~ and b.stacode = '[stacode]' ~/"
				+ "/~ and b.burcode  = '[burcode]' ~/"    
				+ "/~ and t.CPCODE = '[cpcode]' ~/"
				+ "/~ and t.BUYTIME = '[buytime]' ~/"
				+ "/~ and substr(t.ALARMTIME,0,8) >= '[alarmtimeBeginFormat]' ~/"
				+ "/~ and substr(t.ALARMTIME,0,8) <= '[alarmtimeEndFormat]' ~/"
				+ "/~ and t.ALARMSOURCE = '[alarmsource]' ~/"
				+ "/~ and t.BKLX = '[bklx]' ~/"
				+ "/~ and t.ZHSJ = '[zhsj]' ~/"
				+ "/~ and t.PJDW = '[pjdw]' ~/"
				+ "/~ and t.CLQK = '[clqk]' ~/"
				+ "/~ and t.PJSJ = '[pjsj]' ~/"
				+ "/~ and t.BKID = '[bkid]' ~/"
				+ "/~ and t.ALARMTEL = '[alarmtel]' ~/"
				+ "/~ and t.BKSJ = '[bksj]' ~/"
				+ "/~ and t.CZR = '[czr]' ~/"
				+ "/~ and t.EMPFLAG = '[empflag]' ~/"
				+ "/~ and t.SFYX = '[sfyx]' ~/"
				+ "/~ and t.WXYY = '[wxyy]' ~/"
				+ "/~ and t.SFYZH = '[sfyzh]' ~/"
				+ "/~ and t.ZHDWMC = '[zhdwmc]' ~/"
				+ "/~ and t.WZHYY = '[wzhyy]' ~/"
				+ "/~ and t.CJR = '[cjr]' ~/"
				+ "/~ and b.BURCODE = '[burcode]' ~/"
				+ "/~ and b.STACODE = '[stacode]' ~/"
				+ "/~ and b.cpname like  '%[cpname]%' ~/"
				+ "/~ and t.CLFLAG = '[clflag]' ~/"
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
	
	
	private String createSql = "insert into T_PERSON_ALARM " 
		 + " (XH,SFZH,XM,HM1,HM2,XB,NL,JG,HJD,ZZ,SG,TX,TSTZ,AB,LADW,LASJ,JYAQ,TBDW,ID,NAME,ID_NAME,ID_CODE,SEX,NATION,BDATE,ADDRESS,XZQH,CPCODE,BUYTIME,ALARMTIME,ALARMSOURCE,BKLX,ZHSJ,PJDW,CLQK,PJSJ,BKID,ALARMTEL,BKSJ,CZR,EMPFLAG,SFYX,WXYY,SFYZH,ZHDWMC,WZHYY,CJR,CLFLAG) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update T_PERSON_ALARM set "
		+ " XH=?,SFZH=?,XM=?,HM1=?,HM2=?,XB=?,NL=?,JG=?,HJD=?,ZZ=?,SG=?,TX=?,TSTZ=?,AB=?,LADW=?,LASJ=?,JYAQ=?,TBDW=?,ID=?,NAME=?,ID_NAME=?,ID_CODE=?,SEX=?,NATION=?,BDATE=?,ADDRESS=?,XZQH=?,CPCODE=?,BUYTIME=?,ALARMTIME=?,ALARMSOURCE=?,BKLX=?,ZHSJ=?,PJDW=?,CLQK=?,PJSJ=?,BKID=?,ALARMTEL=?,BKSJ=?,CZR=?,EMPFLAG=?,SFYX=?,WXYY=?,SFYZH=?,ZHDWMC=?,WZHYY=?,CJR=?,CLFLAG=? "
		+ " where ID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final TpersonAlarm entity) throws IOException {
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
						ps.setString(28, entity.getCpcode());
						ps.setString(29, entity.getBuytime());
						ps.setString(30, entity.getAlarmtime());
						ps.setString(31, entity.getAlarmsource());
						ps.setString(32, entity.getBklx());
						ps.setString(33, entity.getZhsj());
						ps.setString(34, entity.getPjdw());
						ps.setString(35, entity.getClqk());
						ps.setString(36, entity.getPjsj());
						ps.setString(37, entity.getBkid());
						ps.setString(38, entity.getAlarmtel());
						ps.setString(39, entity.getBksj());
						ps.setString(40, entity.getCzr());
						ps.setString(41, entity.getEmpflag());
						ps.setString(42, entity.getSfyx());
						ps.setString(43, entity.getWxyy());
						ps.setString(44, entity.getSfyzh());
						ps.setString(45, entity.getZhdwmc());
						ps.setString(46, entity.getWzhyy());
						ps.setString(47, entity.getCjr());
						ps.setString(48, entity.getClflag());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createTpersonAlarm(final TpersonAlarm entity) {
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
				ps.setString(28, entity.getCpcode());
				ps.setString(29, entity.getBuytime());
				ps.setString(30, entity.getAlarmtime());
				ps.setString(31, entity.getAlarmsource());
				ps.setString(32, entity.getBklx());
				ps.setString(33, entity.getZhsj());
				ps.setString(34, entity.getPjdw());
				ps.setString(35, entity.getClqk());
				ps.setString(36, entity.getPjsj());
				ps.setString(37, entity.getBkid());
				ps.setString(38, entity.getAlarmtel());
				ps.setString(39, entity.getBksj());
				ps.setString(40, entity.getCzr());
				ps.setString(41, entity.getEmpflag());
				ps.setString(42, entity.getSfyx());
				ps.setString(43, entity.getWxyy());
				ps.setString(44, entity.getSfyzh());
				ps.setString(45, entity.getZhdwmc());
				ps.setString(46, entity.getWzhyy());
				ps.setString(47, entity.getCjr());
				ps.setString(48, entity.getClflag());
			}
		});
	}

	
	public void updateTpersonAlarm(final TpersonAlarm entity) {
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
				ps.setString(28, entity.getCpcode());
				ps.setString(29, entity.getBuytime());
				ps.setString(30, entity.getAlarmtime());
				ps.setString(31, entity.getAlarmsource());
				ps.setString(32, entity.getBklx());
				ps.setString(33, entity.getZhsj());
				ps.setString(34, entity.getPjdw());
				ps.setString(35, entity.getClqk());
				ps.setString(36, entity.getPjsj());
				ps.setString(37, entity.getBkid());
				ps.setString(38, entity.getAlarmtel());
				ps.setString(39, entity.getBksj());
				ps.setString(40, entity.getCzr());
				ps.setString(41, entity.getEmpflag());
				ps.setString(42, entity.getSfyx());
				ps.setString(43, entity.getWxyy());
				ps.setString(44, entity.getSfyzh());
				ps.setString(45, entity.getZhdwmc());
				ps.setString(46, entity.getWzhyy());
				ps.setString(47, entity.getCjr());
				ps.setString(48, entity.getClflag());
			}
		});
	}

	
	public void deleteTpersonAlarm(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	

}
