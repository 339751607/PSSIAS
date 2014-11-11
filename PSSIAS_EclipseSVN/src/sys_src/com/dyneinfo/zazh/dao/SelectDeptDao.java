/*
 * Powered By []
 * Web Site: 
 * 
 */

package com.dyneinfo.zazh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;

import net.java.dev.common.dict.taglib.DictHelpImpl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.zazh.model.DictItem;
import com.dyneinfo.zazh.model.SsDept;

/**
 * @author  email: lee(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Component
public class SelectDeptDao extends BaseSpringJdbcDao<SsDept,java.lang.Long>{
	


	@Override
	public String getDeleteByIdSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindByIdSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifierPropertyName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SsDept> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SsDept entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(SsDept entity) {
		// TODO Auto-generated method stub
		
	}
	//查分局
//	public List getFj(String deptseq){
//		String deptseqs[]=deptseq.split("\\.");
//
//		String getFjSql=" select deptid,deptname,deptseq,deptlevel,parentid from SS_dept t where deptlevel=2  and deptseq like '"+deptseq+"%'  ";
//		
//		return getSimpleJdbcTemplate().queryForList(getFjSql, new Object[]{});
//	}
	
	
	public List getFjByMpcode(String mpcode,String deptseq){
	String getFjSql=" select deptid,deptname,deptseq,deptlevel,parentid from SS_dept t where deptseq like '"+deptseq+"%'  and parentid =  '"+mpcode+"'  order by deptid  ";
	return getSimpleJdbcTemplate().queryForList(getFjSql, new Object[]{});
}
	
	
	//根据查派出所
	public List getPcs(String fjId,String deptseq){
		//String deptseqs[]=deptseq.split("\\.");
		
		String getPcsSql=" select deptid,deptname,deptseq,deptlevel,parentid from SS_dept t where   deptseq like '"+deptseq+"%' and deptname like '%派出所%' and parentid=?  order by deptid ";
		
		return getSimpleJdbcTemplate().queryForList(getPcsSql, new Object[]{fjId});
	}
	//根据派出所查企业
	public List getDeptByParentid(String parentid,String deptseq){

		
		String getQySql=" select deptid,deptname,deptseq,deptlevel,parentid from SS_dept t where  parentid=?  order by deptid ";
//		String deptseqs[]=deptseq.split("\\.");	
//		if(deptseqs.length>6){
//			getQySql=getQySql+" and deptseq like '%."+deptseqs[6]+".%'";
//		}
		return getSimpleJdbcTemplate().queryForList(getQySql, new Object[]{parentid});
	}
	//根据id查中文名
	public List getdeptFullName(String _deptseq){
		String sql="select deptname,deptid from ss_dept t where t.deptid in ("+_deptseq+")";
		
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{});
	}
	public Object getParentid(String deptid){
		String sql="select parentid from SS_dept where deptid = '"+deptid+"'";
		return getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				String parentid = rs.getString(1);
				return parentid;
			}

		});
	}
	
	
	public String getSelectPrefix(){
		String sql=" select deptid,deptname,deptseq,deptlevel,parentid from SS_dept t ";
		return sql;
	}
	public List getDeptByParentId(String parentId,String deptseq){
		String deptseqs[]=deptseq.split("\\.");

		String sql=getSelectPrefix()+" where status=1 and parentid= ? order by displayorder ";
		if(deptseqs.length==5){
			sql=sql+" and deptseq like '%."+deptseqs[4]+".%'";
		}
		if(deptseqs.length==6){
			sql=sql+" and deptseq like '%."+deptseqs[5]+".%'";
		}
		if(deptseqs.length==7){
			sql=sql+" and deptseq like '%."+deptseqs[6]+".%'";
		}
		System.out.println("sql:"+sql);
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{parentId});
	}
	public List getDeptByDeptId(String deptid){
		String sql=getSelectPrefix()+" where status=1 and depttypeid='0' and deptid= ? order by displayorder ";
		System.out.println("sql:"+sql);
		return getSimpleJdbcTemplate().queryForList(sql, new Object[]{deptid});
	}
	public List<DictItem> getProvince(){
		Map DictMap=DictHelpImpl.DictMap;
		
		List<DictItem>	 list_p=(List)DictMap.get("T_XZQH_Pzh_CN");
		return list_p;
	}
	public List<DictItem> getCityByProvince(String provinceId){
		Map DictMap=DictHelpImpl.DictMap;
		List<DictItem> list=new ArrayList();
		if(provinceId==null||provinceId.equals(""))return list;
		List<DictItem>	 list_C=(List)DictMap.get("T_XZQH_Czh_CN");
		for(int i=0;i<list_C.size();i++){
			DictItem item=list_C.get(i);
			if(item.getDictid().subSequence(0, 2).equals(provinceId.subSequence(0, 2))){
				list.add(list_C.get(i));
			}
		}
		
		return list;
	}
	public List<DictItem> getCountiesByCity(String cityId){
		
		Map DictMap=DictHelpImpl.DictMap;
		List<DictItem> list=new ArrayList();
		if(cityId==null||cityId.equals(""))return list;
		List<DictItem>	 list_C=(List)DictMap.get("T_XZQH_Xzh_CN");
		for(int i=0;i<list_C.size();i++){
			DictItem item=list_C.get(i);
			if(item.getDictid().subSequence(0, 4).equals(cityId.subSequence(0, 4))){
				list.add(list_C.get(i));
			}
		}
		
		return list;
	}
}
