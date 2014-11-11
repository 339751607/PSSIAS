/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.pmdd.dao;

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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SdcpuploadpmddDao extends BaseSpringJdbcDao<Sdcpupload,java.lang.Long>{
	
	public Class getEntityClass() {
		return Sdcpupload.class;
	}
	
	public String getIdentifierPropertyName() {
		return "xh";
	}
	
	public String getSelectPrefix() {
		

		
		
		
		
		
		
		
		
		
		

		return " select c.deptseq as deptseq, c.deptname as cityname,nvl(b.scjs,0) as scjs,"+
		"nvl(d.id,0) as scsjl,"+
		"nvl(a.pmd,0)-nvl(b.scjs,0 ) as wscjs,"+
		"nvl(to_char((scjs/a.pmd)*100,'fm9999999990.0'),0)||'%' as scl "+
		" from ";
		
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from STAT_DATA_CP_UPLOAD where XH=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where XH=? ";
	}
	
	public void save(Sdcpupload entity) {
		String sql = "insert into STAT_DATA_CP_UPLOAD " 
			 + " (XH,CITYCODE,CITYNAME,SCJS,WSCJS,SCL,LXWSCJS,TJRQ,SCSJL) " 
			 + " values "
			 + " (:xh,:citycode,:cityname,:scjs,:wscjs,:scl,:lxwscjs,:tjrq,:scsjl)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_STAT_DATA_CP_UPLOAD",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(Sdcpupload entity) {
		String sql = "update STAT_DATA_CP_UPLOAD set "
					+ " XH=:xh,CITYCODE=:citycode,CITYNAME=:cityname,SCJS=:scjs,WSCJS=:wscjs,SCL=:scl,LXWSCJS=:lxwscjs,TJRQ=:tjrq,SCSJL=:scsjl "
					+ " where XH=:xh";
		getNamedParameterJdbcTemplate().update(sql, new BeanPropertySqlParameterSource(entity));
	}
	
	public List findAll() {
		String sql = getSelectPrefix() ;
		return getSimpleJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key
		String hql ="( select sum(scjs.b) as scjs,dept.deptname from "+       
		           	"(select dept.deptid,dept.deptname,dept.deptseq from ss_dept dept where dept.deptlevel = '3') dept,"+
		            "(  select nvl(count(distinct s.id),0)as b ,ss.deptseq,ss.deptname  ,substr(ss.deptseq,0,32) as deps from"+
		            "(select  substr(d_number,0,10) id,ddrq rq from DCZYDDXXB  union "+
		            " select  substr(d_number,0,10) id ,ddrq rq from  FCDYDDXXB  union "+
		            " select  substr(d_number,0,10) id ,ddrq rq from  clzyddxxb"+
		            " ) s ,pmdwxxb p ,ss_dept ss"+
		            "  where  s.id = p.dwbm "+
		            "/~ and s.rq >= '[s_starttimeBegin]' ~/"+
		            "/~ and s.rq <= '[a.enroltime]' ~/"+
		            "  and p.dwbm=ss.deptid  group by ss.deptseq ,ss.deptname ) scjs"+	      
		            "  where  scjs.deptseq like dept.deptseq||'%'  "+
		            " group by dept.deptname,scjs.b)b,(select dept.deptid,dept.deptname,dept.deptseq from ss_dept dept where dept.deptlevel = '3')c,";	
	
		String mql= "(select distinct a.deptname as deptname,sum(b.id) as id from "+
			      	"(select dept.deptid,dept.deptname,dept.deptseq from ss_dept dept where dept.deptlevel = '3') a,"+
			      	"( select count(s.id)as id ,ss.deptseq  from "+
			      	"(select  substr(d_number,0,10) id,ddrq rq from DCZYDDXXB  union all "+
			      	"select  substr(d_number,0,10) id ,ddrq rq from  FCDYDDXXB  union all "+
			      	"select  substr(d_number,0,10) id ,ddrq rq from  clzyddxxb "+
			      	" ) s ,pmdwxxb p ,ss_dept ss"+
			      	" where  s.id = p.dwbm "+
			      	"/~ and s.rq >= '[s_starttimeBegin]' ~/"+
			        "/~ and s.rq <= '[a.enroltime]' ~/"+
			      	"and p.dwbm=ss.deptid group by ss.deptseq  )b "+
			      	"where  b.deptseq like a.Deptseq||'%' group by a.deptname) d,";
		String pql="(select sum(pmdd.a) as pmd,dept.deptname from   ("+
					"SELECT  deptseq,deptname,count(*) as a  from ss_dept  WHERE deptid in (select dwbm from pmdwxxb )  group by deptseq,deptname) pmdd,"+
			         "(select dept.deptid,dept.deptname,dept.deptseq from ss_dept dept where dept.deptlevel = '3') dept"+
			         " where  pmdd.deptseq like dept.deptseq||'%' group by dept.deptname) a";
		
		
		
		
		String sql = getSelectPrefix()+hql+mql+pql+
					"  where c.deptname=a.deptname(+) and c.deptname=b.deptname(+) and c.deptname=d.deptname(+) " +
					"/~ and deptseq like '%.[deptid].%' ~/"+
					 "/~  order by [sortColumns] ~/";
		System.out.println(sql);
					 
		
		
		
		
		
		
		
		
		
//		String sql = "select * from  (select  t.CITYCODE as citycode,t.CITYNAME as cityname,avg(t.scjs) as scjs,avg(t.wscjs) as wscjs,avg(t.scl) as scl,sum(t.scsjl) as scsjl from STAT_DATA_CP_UPLOAD t " +
//				" where 1=1 " 
//				+ "/~ and t.TJRQ >= '[s_starttimeBegin]' ~/"
//				+ "/~ and t.TJRQ <= '[a.enroltime]' ~/"+
//				"  group by  citycode,t.cityname) " + " t ,ss_dept ss where  t.citycode=ss.deptid  "
//				+ "/~ and t.CITYCODE = '[citycode]' ~/"
//				+ "/~ and  ss.deptlevel='[deptlevel]' ~/"				
//				
//				+ "/~ order by [sortColumns] ~/";
		
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
	
	
	private String createSql = "insert into STAT_DATA_CP_UPLOAD " 
		 + " (XH,CITYCODE,CITYNAME,SCJS,WSCJS,SCL,LXWSCJS,TJRQ,SCSJL) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update STAT_DATA_CP_UPLOAD set "
		+ " XH=?,CITYCODE=?,CITYNAME=?,SCJS=?,WSCJS=?,SCL=?,LXWSCJS=?,TJRQ=?,SCSJL=? "
		+ " where XH=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		


	
	public void deleteSdcpupload(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	public Page findByPageRequest1(PageRequest<Map> pageRequest,String deptseq) {
		// [column]为字符串拼接, {column}为使用占位符. 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能. 
		// [column] 为PageRequest.getFilters()中的key

		
		
		String sql =" select ss.deptname as deptname  from "+
        			"(select  substr(d_number,0,10) id,ddrq rq from DCZYDDXXB " +
        			"/~ where ddrq >= '[s_starttimeBegin]' ~/"+ 
        			"/~ and ddrq <= '[a.enroltime]' ~/"+
        			" union "+
        			"  select  substr(d_number,0,10) id ,ddrq rq from  FCDYDDXXB  " +
        			"/~ where ddrq >= '[s_starttimeBegin]' ~/"+ 
        			"/~ and ddrq <= '[a.enroltime]' ~/"+
        			" union "+
        			" select  substr(d_number,0,10) id ,ddrq rq from  clzyddxxb "+
        			"/~ where ddrq >= '[s_starttimeBegin]' ~/"+ 
        			"/~ and ddrq <= '[a.enroltime]' ~/"+
        			") s ,pmdwxxb p ,ss_dept ss "+
        			"   where  s.id (+)= p.dwbm and s.id is null "+
        			"   and p.dwbm=ss.deptid " +
        			" and ss.deptseq like '"+deptseq+"%'"+
        			
					 "/~  order by [sortColumns] ~/";
		System.out.println(sql);
					 
		
		
		
		
		
		
		
		
		

		return pageQuery(sql,pageRequest);
	}
	
	
	

}
