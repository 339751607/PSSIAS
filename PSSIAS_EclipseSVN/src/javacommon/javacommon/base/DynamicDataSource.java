package javacommon.base;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @describe 实现动态数据源切换逻辑
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements
		ApplicationContextAware {

	private Logger log = Logger.getLogger(this.getClass());

	public static Map<Object, Object> _targetDataSources;

	private ApplicationContext ctx;

	/**
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 * @describe 数据源为空或者为zazh时，自动切换至默认数据源，即在配置文件中定义的dataSource数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		String dataSourceName = DBContextHolder.getDBType();
		if (dataSourceName == null) {
			dataSourceName = "dataSource";
		} else {
			this.selectDataSource(dataSourceName);
			if (dataSourceName.equals("zazh"))
				dataSourceName = "dataSource";
		}
//		System.out.println("-------->切换至数据源" + dataSourceName);
		return dataSourceName;
	}

	public void setTargetDs(Map<Object, Object> targetDataSources) {
		DynamicDataSource._targetDataSources = targetDataSources;
		super.setTargetDataSources(DynamicDataSource._targetDataSources);
		super.afterPropertiesSet();
	}

	public void addTargetDataSource(String key, BasicDataSource dataSource) {
		DynamicDataSource._targetDataSources.put(key, dataSource);
		this.setTargetDs(DynamicDataSource._targetDataSources);
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	public BasicDataSource createDataSource(String driverClassName, String url,
			String username, String password) {
		BasicDataSource dataSource = new BasicDataSource();
		BasicDataSource parent = (BasicDataSource) this.ctx
				.getBean("zazhdataSource");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setDefaultAutoCommit(parent.getDefaultAutoCommit());
		dataSource.setDefaultReadOnly(parent.getDefaultReadOnly());
		dataSource.setMaxActive(parent.getMaxActive());
		dataSource.setMaxIdle(parent.getMaxIdle());
		dataSource.setMaxWait(parent.getMaxWait());
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			log.error("数据源未能正常连接", e);
		}
		return dataSource;
	}

	/**
	 * @param serverId
	 * @throws Exception
	 * @describe 数据源存在时不做处理，不存在时创建新的数据源链接，并将新数据链接添加至缓存
	 */
	public void selectDataSource(String serverId) {
		Object sid = DBContextHolder.getDBType();
		if ("zazh".equals(serverId)) {
			DBContextHolder.setDBType("zazh");
			return;
		}
		if (null == DynamicDataSource._targetDataSources) {
			DynamicDataSource._targetDataSources = new HashMap<Object, Object>();
		}
		Object obj = DynamicDataSource._targetDataSources.get(serverId);
		if (obj != null && sid.equals(serverId)) {
			return;
		} else {
			BasicDataSource dataSource = this.getDataSource(serverId);
			if (null != dataSource)
				this.setDataSource(serverId, dataSource);
		}
	}

	/**
	 * @describe 查询serverId对应的数据源记录
	 * @param serverId
	 * @return
	 * @throws Exception
	 */
	public BasicDataSource getDataSource(String serverId) {
		this.selectDataSource("zazh");
		this.determineCurrentLookupKey();
		Connection conn = null;
		HashMap<String, Object> map = null;
		try {
			conn = this.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM SS_DATASOURCE WHERE isvalid=1 and DBS_NAME = ?");
			ps.setString(1, serverId);
			ResultSet rs = ps.executeQuery();
			map = new HashMap<String, Object>();
			if (rs.next()) {
				map.put("DBS_ID", rs.getInt("ID"));
				map.put("DBS_DriverClassName", rs
						.getString("DBS_DriverClassName"));
				map.put("DBS_URL", rs.getString("DBS_URL"));
				map.put("DBS_UserName", rs.getString("DBS_UserName"));
				map.put("DBS_Password", rs.getString("DBS_Password"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
		if (null != map) {
			String driverClassName = map.get("DBS_DriverClassName").toString();
			String url = map.get("DBS_URL").toString();
			String userName = map.get("DBS_UserName").toString();
			String password = map.get("DBS_Password").toString();
			BasicDataSource dataSource = this.createDataSource(driverClassName,
					url, userName, password);
			return dataSource;
		}
		return null;
	}

	/**
	 * @param serverId
	 * @param dataSource
	 */
	public void setDataSource(String serverId, BasicDataSource dataSource) {
		this.addTargetDataSource(serverId, dataSource);
		DBContextHolder.setDBType(serverId);
	}

	public java.util.logging.Logger getParentLogger()
			throws SQLFeatureNotSupportedException {
		return java.util.logging.Logger.getLogger(this.getClass().getName());
	}

}