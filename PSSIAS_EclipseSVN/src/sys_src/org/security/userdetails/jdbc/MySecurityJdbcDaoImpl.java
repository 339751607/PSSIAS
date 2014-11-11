/**
 *
 */
package org.security.userdetails.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.sql.DataSource;

import net.java.dev.common.dict.taglib.DictHelpImpl;
import net.java.dev.common.util.DateUtil;
import net.java.dev.common.util.PropertiesFileConfigManager;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.security.userdetails.MyDwxx;
import org.security.userdetails.MyUser;
import org.security.userdetails.MyUserDetails;
import org.springframework.context.ApplicationContextException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.AccountExpiredException;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.DisabledException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.LockedException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import sun.misc.BASE64Decoder;

import com.action.Registered;
import com.dyneinfo.zazh.util.Encry;

public class MySecurityJdbcDaoImpl extends JdbcDaoSupport implements
		UserDetailsService {


	public static final String DEF_USERS_BY_USERNAME_QUERY = " select USERID,USERNAME,PASSWORD,SFZH,EMAILADDRESS,ENABLED,POLICEID,ss_USer.DEPTID,FULLNAME, ss_dept.deptlevel,ss_dept.parentid,ss_dept.deptname,ss_dept.deptcode,ss_dept.deptseq,ss_USer.expirationDate,'' iscode, '' as dwbm, '' as servicedate,'' as status   "
			+ " FROM ss_USer , ss_dept  "
			+ " WHERE ss_USer.deptid = ss_dept.deptid  and   USERNAME=? ";

	public static final String DEF_ROLES_BY_USERNAME_QUERY = " SELECT u.userName as username, r.rolename as roleName   "
			+ "  FROM ss_user u, ss_role r,ss_group g, ss_role_group gr, ss_group_user  ur  "
			+ " WHERE u.userid = ur.userid  "
			+ " AND gr.roleid= r.roleid  AND g.groupid  = ur.groupid  "
			+ " AND u.userName=?";

	public static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = " SELECT r.roleid as id ,r.rolename as group_name, au.authorityname as authority   "
			+ " FROM ss_user u, ss_role r, ss_group  g,  ss_role_group gr,"
			+ " ss_group_user ur,ss_role_authority ra,ss_authority au "
			+ " WHERE u.userid = ur.USERID and ra.roleid = r.roleid and ra.AUTHORITYID =au.authorityid "
			+ " and gr.roleid= r.roleid AND  g.groupid = ur.groupid  " + " AND u.userName=? ";
	
	protected MappingSqlQuery usersByUsernameMapping;
	protected MappingSqlQuery rolesByUsernameMapping;
	protected MappingSqlQuery authoritiesByUsernameMapping;

	
	private String usersByUsernameQuery;
	private String rolesByUsernameQuery;
	private String authoritiesByUsernameQuery;
	
	private String rolePrefix = "";
	private boolean usernameBasedPrimaryKey = true;

	private boolean debug = true;

	private PropertiesFileConfigManager fileConfigManager;
	

	public MySecurityJdbcDaoImpl() {
		this.usersByUsernameQuery = DEF_USERS_BY_USERNAME_QUERY;
		this.rolesByUsernameQuery = DEF_ROLES_BY_USERNAME_QUERY;
		this.authoritiesByUsernameQuery = DEF_AUTHORITIES_BY_USERNAME_QUERY;
		
		this.fileConfigManager = PropertiesFileConfigManager.getInstance();
	
	}

	protected void initDao() throws ApplicationContextException {
		initMappingSqlQueries();
	}

	protected void initMappingSqlQueries() {
		this.usersByUsernameMapping = new UsersByUsernameMapping(
				getDataSource());
		this.rolesByUsernameMapping = new RolesByUsernameMapping(
				getDataSource());
		this.authoritiesByUsernameMapping = new AuthoritiesByUsernameMapping(
				getDataSource());
			}

	@SuppressWarnings("unchecked")
	protected void addCustomAuthorities(String username, List authorities) {

	}	
	private static String decrypt(String path,String cryptograph) throws Exception{
	 	   /** 将文件中的私钥对象读出 */
	 	   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
	 	   Key key = (Key) ois.readObject();
	 	   /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
	 	   Cipher cipher = Cipher.getInstance("RSA");
	 	   cipher.init(Cipher.DECRYPT_MODE, key);
	 	   BASE64Decoder decoder = new BASE64Decoder();
	 	   byte[] b1 = decoder.decodeBuffer(cryptograph);
	 	   /** 执行解密操作 */
	 	   byte[] b = cipher.doFinal(b1);
	 	   return new String(b);
	 	}
	
	
	
	/* (non-Javadoc)
	 * @see org.springframework.security.userdetails.jdbc.JdbcDaoImpl#loadUserByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	//UserDetailsService 服务接口
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
	
		if (debug) {
			// TODO Auto-generated method stub
			System.out.println("用户<" + userName + ">登陆");
		}
		List users = usersByUsernameMapping.execute(userName);

		if (users != null && users.size() == 0) {

			throw new UsernameNotFoundException("User Not Found...");
		}

		MyUserDetails user = (MyUserDetails) users.get(0);

		if (!user.isAccountNonLocked()) {
			throw new LockedException(
					"用户帐号被锁",
					"User account is locked");
		}

		if (user.getExpirationDate() != null
				&& !user.getExpirationDate().equals("1")) {
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
			String date = f.format(d);
			String expirationDate = user.getExpirationDate();
			expirationDate = expirationDate.replace("-", "");
			if (Integer.valueOf(date) >= Integer.valueOf(expirationDate)) {
				throw new DisabledException(
						"用户不可用",
						"User is disabled");
			}
		}
		
		if(!"1".equals(user.getQystatus())&& !"".equals(user.getQystatus())){
			throw new LockedException(
					"企业未正常营业",
					"企业非正常营业");
		}
		//系统注册信息验证
		verify(user);
		String jmType = (String) DictHelpImpl.getInitData("jmType");
		//
		if(!user.getDwbm().equals("")){
			if(user.getIscode().equals("")){
				throw new LockedException(
						"没有软件授权",
						"User account has expired");
			}else{
				Encry en = new Encry();
				String code="";
				if ("1".equals(jmType)) {
					code=en.crypt_pwd("e", "efficiently",user.getIscode());
				}else{
					code=en.crypt_pwd("e", "bslogyes",user.getIscode());
					
				}
				if(!code.equals(user.getDwbm())){
					throw new LockedException(
							"软件授权码错误",
							"User account has expired");
				}	
			}
		}
		if (!user.isAccountNonLockedCs()) {
			throw new LockedException(
					"AbstractUserDetailsAuthenticationProvider.locked",
					"用户被锁定");
		}
		
		System.out.println("user.isAccountNonExpired()="+user.isAccountNonExpiredCs());
		if (!user.isAccountNonExpiredCs()) {
			throw new AccountExpiredException(
					"AbstractUserDetailsAuthenticationProvider.expired",
					"软件过期");
		}
		if (!user.isCredentialsNonExpiredCs()) {
			throw new BadCredentialsException(
					"AbstractUserDetailsAuthenticationProvider.locked",
					"注册错误");
		}
		
		if (debug) {
			System.out.println("用户基本信息<" + user.getUserId() + "><"
					+ user.getUsername() + "><" + user.getPassword() + "><"
					+ user.getEmail() + "><" + user.getExpirationDate() + ">");
		}
		//角色信息
		List dbRoles = rolesByUsernameMapping.execute(user.getUsername());

		if (debug) {
			System.out.println("<" + user.getUsername() + ">有<"
					+ dbRoles.size() + ">个角色" + dbRoles);
		}
		if (dbRoles.size() == 0) {
			throw new UsernameNotFoundException("User Has no Role");
		}
		//扩充角色信息
		GrantedAuthority[] roles = (GrantedAuthority[]) dbRoles
				.toArray(new GrantedAuthority[dbRoles.size()]);
		user.setRoles(roles);

		//权限项信息
		List dbauthorities = authoritiesByUsernameMapping.execute(user
				.getUsername());

		if (debug) {
			System.out.println("<" + user.getUsername() + ">有<"
					+ dbauthorities.size() + ">个权限项" + dbauthorities);
		}
		
		//		if (dbauthorities.size() == 0) {
		//			throw new UsernameNotFoundException("User Has no GrantedAuthority");
		//		}

		if (dbauthorities != null && dbauthorities.size() > 0) {
			for (int i = 0; i < dbauthorities.size(); i++) {
				GrantedAuthority grantedAuthority = (GrantedAuthority) dbauthorities
						.get(i);
				System.out.println("用户:" + user.getUsername() + "权限项>"+grantedAuthority.getAuthority());
				dbRoles.add(new GrantedAuthorityImpl(grantedAuthority
						.getAuthority()));
			}
		}

		addCustomAuthorities(user.getUsername(), dbRoles);

		GrantedAuthority[] authorities = (GrantedAuthority[]) dbRoles
				.toArray(new GrantedAuthority[dbRoles.size()]);

		user.setAuthorities(authorities);

		if (!usernameBasedPrimaryKey) {
			user.setUserName(userName);
		}
		return user;
	}

	protected class UsersByUsernameMapping extends MappingSqlQuery {

		protected UsersByUsernameMapping(DataSource ds) {
			super(ds, usersByUsernameQuery);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet, int)
		 */
		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {

			// TODO Auto-generated method stub
			Integer userId = rs.getInt(1);
			String userName = rs.getString(2);
			String passWord = rs.getString(3);
			String sfzh = rs.getString(4);
			String email = rs.getString(5);
			boolean enabled = rs.getBoolean(6);
			String policeid = rs.getString(7);
			String deptID = rs.getString(8);
			String userxm = rs.getString(9) == null ? "" : rs.getString(9);//姓名
			String deptLevel = rs.getString(10);//部门级别
			String deptParentID = rs.getString(11);//父部门id
			String deptName = rs.getString(12) == null ? "" : rs.getString(12);//部门名
			String deptCode = rs.getString(13) == null ? "" : rs.getString(13);//部门代码
			String deptSeq = rs.getString(14) == null ? "" : rs.getString(14);//部门SEQ
			String expirationDate = rs.getString(15) == null ? "" : rs
					.getString(15);//有效期
			String iscode = rs.getString(16) == null ? "" :rs.getString(16);
			String dwbm = rs.getString(17) == null ? "":rs.getString(17);
			String servicedate = rs.getString(18) == null ? "":rs.getString(18);
			String qystatus = rs.getString(19) == null ? "":rs.getString(19);
			//			MyUserDetails user = new MyUser(userName, passWord, enabled, true, true,true,
			//					new GrantedAuthority[]{new GrantedAuthorityImpl("HOLDER")},
			//					deptid,deptLevel,deptParentID,policeid,sfzh,xm,deptName);
			MyUserDetails user = new MyUser(
					userName,
					passWord,
					enabled,
					true,
					true,
					true,
					new GrantedAuthority[] { new GrantedAuthorityImpl("HOLDER") },
					userId, email, deptID, deptName, deptLevel, deptParentID,
					deptCode, deptSeq, policeid, sfzh, userxm, expirationDate,iscode,dwbm,servicedate,qystatus);
			return user;
		}

	}

	protected class RolesByUsernameMapping extends MappingSqlQuery {

		protected RolesByUsernameMapping(DataSource ds) {
			super(ds, rolesByUsernameQuery);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet, int)
		 */
		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			// TODO Auto-generated method stub
			String roleName = rolePrefix + rs.getString(2);
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl(roleName);
			if (debug) {
				System.out.println("角色名：<" + roleName + ">");
			}
			return authority;
		}
	}

	protected class AuthoritiesByUsernameMapping extends MappingSqlQuery {

		protected AuthoritiesByUsernameMapping(DataSource ds) {
			super(ds, authoritiesByUsernameQuery);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet, int)
		 */
		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			// TODO Auto-generated method stub
			String authorityName = rs.getString(3);
			GrantedAuthorityImpl authority = new GrantedAuthorityImpl(
					authorityName);
			if (debug) {
				//System.out.println("权限名：<" + authorityName +">");
			}
			return authority;
		}
	}

	/**
	 * @return the authoritiesByUsernameQuery
	 */
	public String getRolesByUsernameQuery() {
		return rolesByUsernameQuery;
	}

	/**
	 * @param authoritiesByUsernameQuery the authoritiesByUsernameQuery to set
	 */
	public void setRolesByUsernameQuery(String rolesByUsernameQuery) {
		this.rolesByUsernameQuery = rolesByUsernameQuery;
	}
	
	

private MyUserDetails verify(MyUserDetails user) {
	    	
	
			
		
		String license_key = "";
		String valid_time = "";
		String Remind_day = "";
		String dept_count = "";
		String Remind_dept_count = "";
		// 解密密文
		String de_license_key = "";
		String de_valid_time = "";
		String de_Remind_day = "";
		String de_dept_count = "";
		String de_Remind_dept_count = "";
		
		boolean credentialsNonExpired = false;
		boolean accountNonExpired = false;
		boolean accountNonLocked = true;
		String path = "";
		try {
			license_key = this.fileConfigManager.getProperty("sys.license_key");
			valid_time = this.fileConfigManager.getProperty("sys.valid_time");
			Remind_day = this.fileConfigManager.getProperty("sys.Remind_day");
			dept_count = this.fileConfigManager.getProperty("sys.dept_count");
			Remind_dept_count = this.fileConfigManager.getProperty("sys.Remind_dept_count");
			

			File f = new PropertiesConfiguration("sys_config.properties").getFile();
			f = f.getParentFile();
			path = f.getAbsolutePath();
			//System.out.println(path + "\\dyne\\PrivateKey");
			de_license_key = decrypt(path + "/dyne/PrivateKey", license_key);// 解密密文
			System.out.println("de_valid_time+++++++++++++++++++++++"+de_license_key);
			de_valid_time = decrypt(path + "/dyne/PrivateKey", valid_time);// 解密密文
			System.out.println("de_valid_time+++++++++++++++++++++++"+de_valid_time);
			de_Remind_day = decrypt(path + "/dyne/PrivateKey", Remind_day);// 解密密文
			System.out.println("de_Remind_day+++++++++++++++++++++++"+de_Remind_day);
			de_dept_count = decrypt(path + "/dyne/PrivateKey", dept_count);// 解密密文
			System.out.println("de_dept_count+++++++++++++++++++++++"+de_dept_count);
			de_Remind_dept_count = decrypt(path + "/dyne/PrivateKey", Remind_dept_count);// 解密密文
			System.out.println("de_Remind_dept_count+++++++++++++++++++++++"+de_Remind_dept_count);
			System.out.println(de_license_key + "===de_license_key");
			if(StringUtils.isNotEmpty(de_license_key) && StringUtils.equals(de_license_key, "dyne_hotel_2011")){
				credentialsNonExpired = true;
			} else{
				credentialsNonExpired = false;
			}
			System.out.println("credentialsNonExpired="+credentialsNonExpired);
			
		
	        int inDays = 0;
			
			if (de_valid_time != null && de_valid_time.length() > 0) {
				Date currdate = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//String serviceDates = format.format(accountDateExpired);
				String currDates = format.format(currdate);
				String days = DateUtil.getTwoDay(de_valid_time, currDates);// 获取两个日期之间间隔天数
				System.out.println("days="+days);
				if (days != null)
					inDays = Integer.parseInt(days);
				if (inDays < 0)
					accountNonExpired = false;
				else 
					accountNonExpired = true;
			}
			System.out.println("accountNonExpired="+accountNonExpired);
			System.out.println("accountNonLocked="+accountNonLocked);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		user.setCredentialsNonExpiredCs(credentialsNonExpired);
		user.setAccountNonExpiredCs(accountNonExpired);
		user.setAccountNonLockedCs(accountNonLocked);
		return user;
	}
	/**
	 * @return the authoritiesByUsernameQuery
	 */
	public String getAuthoritiesByUsernameQuery() {
		return authoritiesByUsernameQuery;
	}

	/**
	 * @param authoritiesByUsernameQuery the authoritiesByUsernameQuery to set
	 */
	public void setAuthoritiesByUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
	}

	/**
	 * @return the usersByUsernameQuery
	 */
	public String getUsersByUsernameQuery() {
		return usersByUsernameQuery;
	}

	/**
	 * @param usersByUsernameQuery the usersByUsernameQuery to set
	 */
	public void setUsersByUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
	}

	/**
	 * @return the rolePrefix
	 */
	public String getRolePrefix() {
		return rolePrefix;
	}

	/**
	 * @param rolePrefix the rolePrefix to set
	 */
	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

	/**
	 * @return the usernameBasedPrimaryKey
	 */
	public boolean isUsernameBasedPrimaryKey() {
		return usernameBasedPrimaryKey;
	}

	/**
	 * @param usernameBasedPrimaryKey the usernameBasedPrimaryKey to set
	 */
	public void setUsernameBasedPrimaryKey(boolean usernameBasedPrimaryKey) {
		this.usernameBasedPrimaryKey = usernameBasedPrimaryKey;
	}

	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

}
