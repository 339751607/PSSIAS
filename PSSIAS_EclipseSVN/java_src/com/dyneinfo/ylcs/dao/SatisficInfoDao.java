/*
 * Powered By [lishicheng]
 */

package com.dyneinfo.ylcs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javacommon.base.BaseSpringJdbcDao;
import net.java.dev.common.dict.taglib.DictHelpImpl;
import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;

import com.dyneinfo.ylcs.model.SatisficInfo;
import com.dyneinfo.zazh.model.DictItem;

/**
 * @author user - 刘涛
 * @notice 目前只支持查询，其他操作暂时不支持。
 * @since 2014-10-29
 */
@Component
public class SatisficInfoDao extends
		BaseSpringJdbcDao<SatisficInfo, java.lang.String> {

	public Class getEntityClass() {
		return SatisficInfo.class;
	}

	public String getIdentifierPropertyName() {
		return "locode";
	}

	public String getSelectPrefix() {
		return "";
	}

	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where LOCODE=? ";
	}

	// public void save(SatisficInfo entity) {
	// String sql = "";
	// //其它主键生成策略
	// //insertWithOracleSequence(entity,"SEQ_T_CPINFO",sql); //oracle sequence:
	// }
	//	
	// public void update(SatisficInfo entity) {
	// String sql = "";
	// getNamedParameterJdbcTemplate().update(sql, new
	// BeanPropertySqlParameterSource(entity));
	// }

	public List findAll() {
		String sql = getSelectPrefix();
		return getSimpleJdbcTemplate().query(
				sql,
				ParameterizedBeanPropertyRowMapper
						.newInstance(getEntityClass()));
	}

	public Page findByPageRequest(PageRequest<Map> pageRequest) {
		// [column]为字符串拼接, {column}为使用占位符.
		// 以下为图方便采用sql拼接,适用性能要求不高的应用,使用占位符方式可以优化性能.
		// [column] 为PageRequest.getFilters()中的key
		String sql = "";
		return pageQuery(sql, pageRequest);
	}

	public String getCurrentMax(String sql, String arg)
			throws DataAccessException {
		String currentMaxID = "";
		// String sql="select max(DWNBM) from CYRYXXB where DWBM=?";
		Object[] obj = { arg };
		try {
			currentMaxID = (String) this.getJdbcTemplate().queryForObject(sql,
					obj, String.class);
		} catch (Exception e) {
			currentMaxID = "";
			e.printStackTrace();
		}
		return currentMaxID;
	}

	private String createSql = "";
	private String updateSql = "";
	private LobHandler lobhandler = new DefaultLobHandler();

	@Override
	public String getDeleteByIdSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(SatisficInfo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SatisficInfo entity) {
		// TODO Auto-generated method stub

	}

	public List<SatisficInfo> statisfic(String p_deptId, int p_d, String p_startTime, String p_endTime, String p_type, String p_deptLevel) {
		
		final String deptId = p_deptId;
		final String deptLevel = p_deptLevel;
		if(p_d<1){
			p_d = 1;
		}
		final int d = p_d;
		final String startTime = p_startTime;
		final String endTime = p_endTime;
		final String type = p_type;
		
		final List<SatisficInfo> list = new ArrayList<SatisficInfo>();
		final List businessDictList =   DictHelpImpl.getDict("DIC_ITEM_VALID_BUSINESSCODE"); 
		businessDictList.remove(0);  // 去掉"000" ----"治安综合"
		
		final List<String> hangyeTypeList = new ArrayList<String>();
		for (int i = 0; i < businessDictList.size(); i++) {
			hangyeTypeList.add(((DictItem)(businessDictList.get(i))).getDictid());
		}
		if(deptLevel.equals("2")){
			for (final String hangyeType: hangyeTypeList) {
				
				this.simpleJdbcTemplate.getJdbcOperations().execute(
						new CallableStatementCreator() {
							public CallableStatement createCallableStatement(
									Connection con) throws SQLException {
								String storedProc = "{call zazh.p_stastic_onload_sta(?,?,?,?,?,?)}";// 调用的sql
								CallableStatement cs = con.prepareCall(storedProc);
								cs.setString(1, deptId);    // 设置输入参数的值  param1--- 当前用户所属组织机构ID (deptid)。 测试数据 "451300000000"
								cs.setFloat(2, d);         // 设置输入参数的值  param2--- 上传n天以上。 测试数据
								cs.setString(3,  startTime); // 设置输入参数的值  param3--- starttime。 测试数据 "20140111"
								cs.setString(4,endTime);   // 设置输入参数的值  param4--- endtime .测试数据"20141211"
								cs.setString(5,  hangyeType);           // 设置输入参数的值  param5--- type  0表示查询全部行业类型 "001" hangyeType
								cs.registerOutParameter(6, OracleTypes.CURSOR);// 注册输出参数的类型
								return cs;
							}
						}, new CallableStatementCallback() {
							public Object doInCallableStatement(CallableStatement cs)
									throws SQLException, DataAccessException {
								cs.execute();
								
								ResultSet rs = (ResultSet) cs.getObject(6);// 获取游标一行的值
								while (rs.next()) {// 转换每行的返回值到Map中
									SatisficInfo s = new SatisficInfo();
									s.setDeptId(rs.getString("deptid"));       
									s.setDeptName(rs.getString("deptName"));
									s.setOpenNum(rs.getString("yinyunNum"));
									s.setUploadNum(rs.getString("scNum"));
									s.setNotUploadNum(rs.getString("nscNum"));
									s.setType(rs.getString("hangyeType"));
									
									list.add(s);
								}
								rs.close();
								return list;
							}
						});
			}
		}else{
			for (final String hangyeType: hangyeTypeList) {
				
				this.simpleJdbcTemplate.getJdbcOperations().execute(
						new CallableStatementCreator() {
							public CallableStatement createCallableStatement(
									Connection con) throws SQLException {
								String storedProc = "{call zazh.p_stastic_onload(?,?,?,?,?,?)}";// 调用的sql
								CallableStatement cs = con.prepareCall(storedProc);
								cs.setString(1, deptId);    // 设置输入参数的值  param1--- 当前用户所属组织机构ID (deptid)。 测试数据 "451300000000"
								cs.setFloat(2, d);         // 设置输入参数的值  param2--- 上传n天以上。 测试数据
								cs.setString(3,  startTime); // 设置输入参数的值  param3--- starttime。 测试数据 "20140111"
								cs.setString(4,endTime);   // 设置输入参数的值  param4--- endtime .测试数据"20141211"
								cs.setString(5,  hangyeType);           // 设置输入参数的值  param5--- type  0表示查询全部行业类型 "001" hangyeType
								cs.registerOutParameter(6, OracleTypes.CURSOR);// 注册输出参数的类型
								return cs;
							}
						}, new CallableStatementCallback() {
							public Object doInCallableStatement(CallableStatement cs)
									throws SQLException, DataAccessException {
								cs.execute();
								
								ResultSet rs = (ResultSet) cs.getObject(6);// 获取游标一行的值
								while (rs.next()) {// 转换每行的返回值到Map中
									SatisficInfo s = new SatisficInfo();
									s.setDeptId(rs.getString("deptid"));       
									s.setDeptName(rs.getString("deptName"));
									s.setOpenNum(rs.getString("yinyunNum"));
									s.setUploadNum(rs.getString("scNum"));
									s.setNotUploadNum(rs.getString("nscNum"));
									s.setType(rs.getString("hangyeType"));
									
									list.add(s);
								}
								rs.close();
								return list;
							}
						});
			}
		}
		
		return list;

	}

}
