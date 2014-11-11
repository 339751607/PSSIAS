/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.zazh.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

import com.dyneinfo.zazh.model.*;
import com.dyneinfo.zazh.dao.*;
import com.dyneinfo.zazh.dao.SsMenuDao.ItemMapper;
import com.dyneinfo.zazh.service.*;

/**
 * @author lisc email:lishicheng(a)gmail.com
 */

@Component
public class SsGroupDao extends BaseSpringJdbcDao<SsGroup,java.lang.Long>{
	
	public Class getEntityClass() {
		return SsGroup.class;
	}
	
	public String getIdentifierPropertyName() {
		return "groupid";
	}
	
	public String getSelectPrefix() {
		return "select  "
				+" GROUPID as groupid,"
				+" ORGID as orgid,"
				+" PARENTGROUPID as parentgroupid,"
				+" GROUPLEVEL as grouplevel,"
				+" GROUPNAME as groupname,"
				+" GROUPDESC as groupdesc,"
				+" GROUPTYPE as grouptype,"
				+" GROUPSEQ as groupseq,"
				+" STARTDATE as startdate,"
				+" ENDDATE as enddate,"
				+" GROUPSTATUS as groupstatus,"
				+" MANAGER as manager,"
				+" CREATETIME as createtime,"
				+" LASTUPDATE as lastupdate,"
				+" ISLEAF as isleaf,"
				+" DISPLAYORDER as displayorder"
				+" from SS_GROUP ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from SS_GROUP where GROUPID=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where GROUPID=? ";
	}
	
	public void save(SsGroup entity) {
		String sql = "insert into SS_GROUP " 
			 + " (GROUPID,ORGID,PARENTGROUPID,GROUPLEVEL,GROUPNAME,GROUPDESC,GROUPTYPE,GROUPSEQ,STARTDATE,ENDDATE,GROUPSTATUS,MANAGER,CREATETIME,LASTUPDATE,ISLEAF,DISPLAYORDER) " 
			 + " values "
			 + " (:groupid,:orgid,:parentgroupid,:grouplevel,:groupname,:groupdesc,:grouptype,:groupseq,:startdate,:enddate,:groupstatus,:manager,:createtime,:lastupdate,:isleaf,:displayorder)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_SS_GROUP",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(SsGroup entity) {
		String sql = "update SS_GROUP set "
					+ " GROUPID=:groupid,ORGID=:orgid,PARENTGROUPID=:parentgroupid,GROUPLEVEL=:grouplevel,GROUPNAME=:groupname,GROUPDESC=:groupdesc,GROUPTYPE=:grouptype,GROUPSEQ=:groupseq,STARTDATE=:startdate,ENDDATE=:enddate,GROUPSTATUS=:groupstatus,MANAGER=:manager,CREATETIME=:createtime,LASTUPDATE=:lastupdate,ISLEAF=:isleaf,DISPLAYORDER=:displayorder "
					+ " where GROUPID=:groupid";
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
				+ "/~ and t.ORGID = '[orgid]' ~/"
				+ "/~ and t.PARENTGROUPID = '[parentgroupid]' ~/"
				+ "/~ and t.GROUPLEVEL = '[grouplevel]' ~/"
				+ "/~ and t.GROUPNAME = '[groupname]' ~/"
				+ "/~ and t.GROUPDESC = '[groupdesc]' ~/"
				+ "/~ and t.GROUPTYPE = '[grouptype]' ~/"
				+ "/~ and t.GROUPSEQ = '[groupseq]' ~/"
				+ "/~ and t.STARTDATE = '[startdate]' ~/"
				+ "/~ and t.ENDDATE = '[enddate]' ~/"
				+ "/~ and t.GROUPSTATUS = '[groupstatus]' ~/"
				+ "/~ and t.MANAGER = '[manager]' ~/"
				+ "/~ and t.CREATETIME = '[createtime]' ~/"
				+ "/~ and t.LASTUPDATE = '[lastupdate]' ~/"
				+ "/~ and t.ISLEAF = '[isleaf]' ~/"
				+ "/~ and t.DISPLAYORDER = '[displayorder]' ~/"
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
	
	
	private String createSql = "insert into SS_GROUP " 
		 + " (GROUPID,ORGID,PARENTGROUPID,GROUPLEVEL,GROUPNAME,GROUPDESC,GROUPTYPE,GROUPSEQ,STARTDATE,ENDDATE,GROUPSTATUS,MANAGER,CREATETIME,LASTUPDATE,ISLEAF,DISPLAYORDER) " 
		 + " values "
		 + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String updateSql = "update SS_GROUP set "
		+ " GROUPID=?,ORGID=?,PARENTGROUPID=?,GROUPLEVEL=?,GROUPNAME=?,GROUPDESC=?,GROUPTYPE=?,GROUPSEQ=?,STARTDATE=?,ENDDATE=?,GROUPSTATUS=?,MANAGER=?,CREATETIME=?,LASTUPDATE=?,ISLEAF=?,DISPLAYORDER=? "
		+ " where GROUPID=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final SsGroup entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						ps.setLong(1, entity.getGroupid());
						ps.setLong(2, entity.getOrgid());
						ps.setLong(3, entity.getParentgroupid());
						ps.setInt(4, entity.getGrouplevel());
						ps.setString(5, entity.getGroupname());
						ps.setString(6, entity.getGroupdesc());
						ps.setString(7, entity.getGrouptype());
						ps.setString(8, entity.getGroupseq());
						ps.setDate(9, (Date) entity.getStartdate());
						ps.setDate(10, (Date) entity.getEnddate());
						ps.setString(11, entity.getGroupstatus());
						ps.setString(12, entity.getManager());
						ps.setDate(13, (Date) entity.getCreatetime());
						ps.setDate(14, (Date) entity.getLastupdate());
						ps.setString(15, entity.getIsleaf());
						ps.setInt(16, entity.getDisplayorder());
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void createSsGroup(final SsGroup entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getGroupid());
				ps.setLong(2, entity.getOrgid());
				ps.setLong(3, entity.getParentgroupid());
				ps.setInt(4, entity.getGrouplevel());
				ps.setString(5, entity.getGroupname());
				ps.setString(6, entity.getGroupdesc());
				ps.setString(7, entity.getGrouptype());
				ps.setString(8, entity.getGroupseq());
				ps.setDate(9, (Date) entity.getStartdate());
				ps.setDate(10, (Date) entity.getEnddate());
				ps.setString(11, entity.getGroupstatus());
				ps.setString(12, entity.getManager());
				ps.setDate(13, (Date) entity.getCreatetime());
				ps.setDate(14, (Date) entity.getLastupdate());
				ps.setString(15, entity.getIsleaf());
				ps.setInt(16, entity.getDisplayorder());
			}
		});
	}

	
	public void updateSsGroup(final SsGroup entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, entity.getGroupid());
				ps.setLong(2, entity.getOrgid());
				ps.setLong(3, entity.getParentgroupid());
				ps.setInt(4, entity.getGrouplevel());
				ps.setString(5, entity.getGroupname());
				ps.setString(6, entity.getGroupdesc());
				ps.setString(7, entity.getGrouptype());
				ps.setString(8, entity.getGroupseq());
				ps.setDate(9, (Date)entity.getStartdate());
				ps.setDate(10,(Date)entity.getEnddate());
				ps.setString(11, entity.getGroupstatus());
				ps.setString(12, entity.getManager());
				ps.setDate(13, (Date) entity.getCreatetime());
				ps.setDate(14, (Date) entity.getLastupdate());
				ps.setString(15, entity.getIsleaf());
				ps.setInt(16, entity.getDisplayorder());
			}
		});
	}

	
	public void deleteSsGroup(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}

	public List<SsGroup> getByParentId(SsGroup ssGroup) {
		
		String sql  = getSelectPrefix()
		            + " where 1=1 ";
		if(ssGroup.getParentgroupid()!= null ){
			sql +=  " AND PARENTGROUPID = " + ssGroup.getParentgroupid() ;
		}
		if(ssGroup.getGrouptype() != null && !"".equals(ssGroup.getGrouptype())){		            
			sql +=  " AND GROUPTYPE = '" + ssGroup.getGrouptype() + "' " ;
		}
		if(ssGroup.getGroupseq() != null && !"".equals(ssGroup.getGroupseq())){		            
			sql +=  " AND GROUPSEQ = '" + ssGroup.getGroupseq() + "' " ;
		}
		sql += " order by GROUPSEQ , DISPLAYORDER ";
		

		List listSsGroup = getJdbcTemplate().query(sql ,new ItemMapper());		
		return listSsGroup;
	}
	protected class ItemMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {	
			SsGroup ssGroup = new SsGroup();
			ssGroup.setGroupid(rs.getLong(1));
			//ssGroup.setOrgid(rs.getLong(2));
			ssGroup.setParentgroupid(rs.getLong(3));
			ssGroup.setGrouplevel(rs.getInt(4));
			ssGroup.setGroupname(rs.getString(5));
		    ssGroup.setGroupdesc(rs.getString(6));
            ssGroup.setGrouptype(rs.getString(7));
            ssGroup.setGroupseq(rs.getString(8));

//			+" STARTDATE as startdate,"
//			+" ENDDATE as enddate,"
            ssGroup.setGroupstatus(rs.getString(11));
//			+" MANAGER as manager,"
//			+" CREATETIME as createtime,"
//			+" LASTUPDATE as lastupdate,"

            ssGroup.setIsleaf(rs.getString(15));
            ssGroup.setDisplayorder(rs.getInt(16));

			
			return ssGroup;

		}
	}
	public Number getChildGroupCount(Long parentgroupid) {
        String sql = " SELECT count(*) FROM SS_GROUP "
        	       + " WHERE  PARENTGROUPID = ? ";
        Object[] params = new Object[] { parentgroupid };
		int[] types = new int[] { Types.BIGINT };
		
		Number count = getJdbcTemplate().queryForInt(sql , params, types);		
		return count;
	}
	public void updateGroupseq(String groupseq,Long groupid) {
		String sql = " UPDATE SS_GROUP SET GROUPSEQ = '" + groupseq + "' "
                   + " WHERE GROUPID = " + groupid ;
        getJdbcTemplate().update(sql);	
	}
	public void updateIsleaf(String isleaf,Long groupid) {
	   String sql = " UPDATE  SS_GROUP SET ISLEAF = '" + isleaf + "' "
                  + " WHERE GROUPID = " + groupid ;

       getJdbcTemplate().update(sql);	
       
	}
	public List<SsGroup> getByGroupSeq(String groupseq)
	{   
		SsGroup ssGroup = new SsGroup();
		ssGroup.setGroupseq(groupseq);
		
		List<SsGroup> groupList = getByParentId(ssGroup);
	    return groupList;
    }
	public void updateGroupDisplayorder4NewParentCopy(Long parentgroupid,int displayorder,Long src_parentid) throws DataAccessException{

		String sql = " UPDATE SS_GROUP SET DISPLAYORDER = DISPLAYORDER+1 " 
                   + " WHERE PARENTGROUPID = " + parentgroupid  
	               + " AND DISPLAYORDER >= " + displayorder 
	               + " AND GROUPID NOT IN (SELECT GROUPID FROM  SS_GROUP WHERE PARENTGROUPID = "+src_parentid+"  ) ";

	    getJdbcTemplate().update(sql);	
	        
	}
	
	public void updateGroupDisplayorder4DelOrCut(Long parentgroupid,int displayorder) throws DataAccessException{

		String sql = " UPDATE SS_GROUP SET DISPLAYORDER = DISPLAYORDER-1 " 
                   + " WHERE  PARENTGROUPID = "+parentgroupid+"  AND DISPLAYORDER > "+displayorder;

	    getJdbcTemplate().update(sql);	
	}
	public void updateSrcGroup(String groupseq, int displayorder,Long parentgroupid,int grouplevel,Long groupid) throws DataAccessException{

		String sql = " UPDATE SS_GROUP SET GROUPSEQ ='" + groupseq + "' , DISPLAYORDER = " + displayorder + " , "
			       + " PARENTGROUPID = " + parentgroupid + " , GROUPLEVEL = " + grouplevel
			       + " WHERE GROUPID = " + groupid ;

	    getJdbcTemplate().update(sql);	
	}
	public void updateSrcChildGroup(String groupseq,int grouplevel,Long groupid) throws DataAccessException{
		String sql = " UPDATE SS_GROUP SET    GROUPSEQ = '" + groupseq + "' ,   GROUPLEVEL = " + grouplevel
                   + " WHERE GROUPID = " + groupid ;
        getJdbcTemplate().update(sql);
	}
	
	public void  updateGroupDisplayorder4NewParent(Long parentgroupid,int displayorder) throws DataAccessException{

		String sql = " UPDATE SS_GROUP SET DISPLAYORDER = DISPLAYORDER+1 " 
            + " WHERE  PARENTGROUPID = "+parentgroupid+"  AND DISPLAYORDER  >=  "+displayorder;
        
        getJdbcTemplate().update(sql);
	}
	
	public Number getGroupSeq() {
		String sql = "SELECT SEQ_SS_GROUP.nextval AS ID FROM DUAL";
		Number totalCount = (Number) getJdbcTemplate().queryForInt(sql);
	    return totalCount;
	}
	public void deleteGroupRoleByGroupid(Long id) {
		String sql = " DELETE FROM SS_ROLE_GROUP WHERE GROUPID = " + id;
	    getJdbcTemplate().execute(sql);
	}
	public void deleteGroupUserByGroupid(Long id) {
		String sql = " DELETE FROM SS_GROUP_USER WHERE GROUPID = " + id;
		getJdbcTemplate().execute(sql);
	}
	public void updateGroupName(String  groupname,String groupdesc,Long groupid) throws DataAccessException{
	
        String sql = " UPDATE SS_GROUP SET GROUPNAME = '" + groupname + "' ,  GROUPDESC = '" + groupdesc + "' "
                   + " WHERE  GROUPID = " + groupid ;
        getJdbcTemplate().update(sql);
	}
	public void deleteRoleGroupbyGroupid(String groupid) {
        String sql = "DELETE FROM SS_ROLE_GROUP WHERE GROUPID = "+groupid; 
        getJdbcTemplate().execute(sql);
	
	}

	public void insertRoleGroup(final String roleid,final String groupid) {
		String sql =" INSERT INTO SS_ROLE_GROUP "
			       + " ( ROLEID ,GROUPID) " 
			       + " VALUES " 
			       + " ( ?, ?) " ;
		getJdbcTemplate().update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, roleid);
				ps.setString(2, groupid);
			
			}
		});
	}
	

	
}
