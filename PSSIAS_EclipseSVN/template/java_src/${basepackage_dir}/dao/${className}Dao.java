<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

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



<#include "/java_imports.include">
@Component
public class ${className}Dao extends BaseSpringJdbcDao<${className},${table.idColumn.javaType}>{
	
	public Class getEntityClass() {
		return ${className}.class;
	}
	
	public String getIdentifierPropertyName() {
		<#if table.singleId>
		return "${table.idColumn.columnNameLower}";
		<#else>
		return null;
		</#if>
	}
	
	public String getSelectPrefix() {
		return "select  "
				<#list table.columns as column>
				+" ${column.sqlName} as ${column.columnNameFirstLower}<#if column_has_next>,</#if>"
				</#list>
				+" from ${table.sqlName} ";
	}
	
	/**
	 * return sql for deleteById();
	 */
	public String getDeleteByIdSql() {
		return "delete from ${table.sqlName} where ${table.idColumn.sqlName}=?";
	}
	
	/**
	 * return sql for getById();
	 */
	public String getFindByIdSql() {
		return getSelectPrefix() + " where ${table.idColumn.sqlName}=? ";
	}
	
	public void save(${className} entity) {
		String sql = "insert into ${table.sqlName} " 
			 + " (<#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>) " 
			 + " values "
			 + " (<#list table.columns as column>:${column.columnNameLower}<#if column_has_next>,</#if></#list>)";
		//insertWithIdentity(entity,sql); //for sqlserver and mysql
		
		//其它主键生成策略
		insertWithOracleSequence(entity,"SEQ_${table.sqlName}",sql); //oracle sequence: 
		//insertWithDB2Sequence(entity,"sequenceName",sql); //db2 sequence:
		//insertWithUUID(entity,sql); //uuid
		//insertWithAssigned(entity,sql); //手工分配
	}
	
	public void update(${className} entity) {
		String sql = "update ${table.sqlName} set "
					+ " <#list table.columns as column>${column.sqlName}=:${column.columnNameLower}<#if column_has_next>,</#if></#list> "
					+ " where ${table.idColumn.sqlName}=:${table.idColumn.columnNameLower}";
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
			<#list table.columns as column>
			  	<#if column.isNotIdOrVersionField>
				+ "/~ and t.${column.sqlName} = '[${column.columnNameLower}]' ~/"
				</#if>
			</#list>
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
	
	
	private String createSql = "insert into ${table.sqlName} " 
		 + " (<#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>) " 
		 + " values "
		 + " (<#list table.columns as column>?<#if column_has_next>,</#if></#list>)";
	private String updateSql = "update ${table.sqlName} set "
		+ " <#list table.columns as column>${column.sqlName}=?<#if column_has_next>,</#if></#list> "
		+ " where ${table.idColumn.sqlName}=?";
	private LobHandler lobhandler = new DefaultLobHandler();
		
	public void savePic(File file, final ${className} entity) throws IOException {
		final File blobIn = file;
		final InputStream blobIs = new FileInputStream(blobIn);
		getJdbcTemplate().execute(createSql,
				new AbstractLobCreatingPreparedStatementCallback(lobhandler) {
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException {
						<#assign k = 0>
						<#list table.columns as column>
						<#assign k=k+1 />
						ps.set${column.simpleJavaType}(${k}, entity.get${column.columnName}());
					    </#list>
						lobCreator.setBlobAsBinaryStream(ps, 25, blobIs,(int) blobIn.length());
					}
				});
		blobIs.close();
	}
	
	
	public void create${className}(final ${className} entity) {
		getJdbcTemplate().update(createSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				<#assign k = 0>
				<#list table.columns as column>
				<#assign k=k+1 />
				ps.set${column.simpleJavaType}(${k}, entity.get${column.columnName}());
			    </#list>
			}
		});
	}

	
	public void update${className}(final ${className} entity) {
		getJdbcTemplate().update(updateSql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				<#assign k = 0>
				<#list table.columns as column>
				<#assign k=k+1 />
				ps.set${column.simpleJavaType}(${k}, entity.get${column.columnName}());
			    </#list>
			}
		});
	}

	
	public void delete${className}(String arg) {
		getJdbcTemplate().update(getDeleteByIdSql(), new Object[] { arg });
	}
	
	
	
	<#list table.columns as column>
	<#if column.unique && !column.pk>
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		String sql =  getSelectPrefix() + " where ${column.columnNameLower}=?";
		return (${className})getSimpleJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(getEntityClass()), v);
	}	
	</#if>
	</#list>

}
