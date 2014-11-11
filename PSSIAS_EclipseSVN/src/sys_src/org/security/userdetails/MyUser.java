/**
 *
 */
package org.security.userdetails;

import java.sql.Date;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.User;

/**
 * @author cui
 *
 */
public class MyUser extends User implements MyUserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 5157710602117592859L;
	private Integer userId;
	private String userName;
	private String email;
	private GrantedAuthority[] authorities;
	private GrantedAuthority[] roles;//角色，单独列出

	private String deptID;//部门id
	private String deptName;//部门名
	private String deptLevel; //部门级别
	private String deptParentID; //父部门
	private String deptCode; //部门代码
	private String deptSeq; //部门seq
	private String deptTypeID; //部门类型
	private String policeID;//警号
	private String sfzh;//身份证号
	private String userXm;//用户姓名
	private String expirationDate;
	private String iscode;
	private String dwbm;
	
	private String qystatus;//企业状态
	private String servicedate;//企业到期日期
	

	boolean credentialsNonExpired = true;
	boolean accountNonExpired = true;
	boolean accountNonLocked = true;

	public MyUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, GrantedAuthority[] authorities,
			Integer userId,String email,String deptID,
			String deptName,String deptLevel,String deptParentID,
			String deptCode,String deptSeq,String str_policeID,
			String str_sfzh,String userxm,String expirationDate,String iscode,String dwbm,String servicedate,String  qystatus) throws IllegalArgumentException {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		 setUserId(userId);
		 setUserName(userName);
		 setEmail(email);
		 setAuthorities(authorities);
		 setDeptID(deptID);
		 setDeptName(deptName);
		 setDeptLevel(deptLevel);
		 setDeptParentID(deptParentID);
		 setDeptCode(deptCode) ;
		 setDeptSeq(deptSeq) ;
		 setPoliceID(str_policeID);
		 setSfzh(str_sfzh);
		 setUserXm(userxm);
		 setExpirationDate(expirationDate);
		 setIscode(iscode);
		 setDwbm(dwbm);
		 setServicedate(servicedate);
		 setQystatus(qystatus);
	}

//	public MyUser(Integer userId, String username, String password,
//			boolean enabled, String email, boolean accountNonExpired,
//			boolean credentialsNonExpired, boolean accountNonLocked,
//			GrantedAuthority[] authorities, String str_deptID,String str_deptLevel,
//			String str_deptParentID,
//			String str_policeID, String str_sfzh, String userxm,String str_deptName,GrantedAuthority[] roles)
//			throws IllegalArgumentException {
//		super(username, password, enabled, accountNonExpired,
//				credentialsNonExpired, accountNonLocked, authorities);
//		this.userId = userId;
//		this.email = email;
//		setUserName(userName);
//		setAuthorities(authorities);
//		setRoles(roles);
//		
//		setDeptID(str_deptID);
//		setDeptLevel(str_deptLevel);
//		setDeptParentID(str_deptParentID);
//		setPoliceID(str_policeID);
//		setSfzh(str_sfzh);
//		setUserXm(userxm);
//		setDeptName(str_deptName);
//
//	}

	/* (non-Javadoc)
	 * @see org.security.userdetails.MyUserDetails#getEmail()
	 */
	public String getEmail() {
		// TODO Auto-generated method stub
		return (this.email);
	}

	/* (non-Javadoc)
	 * @see org.security.userdetails.MyUserDetails#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.security.userdetails.MyUserDetails#getUserId()
	 */
	public Integer getUserId() {
		// TODO Auto-generated method stub
		return (this.userId);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.security.userdetails.MyUserDetails#setUserId(java.lang.Integer)
	 */
	public void setUserId(Integer userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */

	/* (non-Javadoc)
	 * @see org.security.userdetails.MyUserDetails#setUsername(java.lang.String)
	 */
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}

	/**
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the authorities
	 */
	public GrantedAuthority[] getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(GrantedAuthority[] authorities) {
		this.authorities = authorities;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getPoliceID() {
		return policeID;
	}

	public void setPoliceID(String policeID) {
		this.policeID = policeID;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getUserXm() {
		return userXm;
	}

	public void setUserXm(String userXm) {
		this.userXm = userXm;
	}

	public GrantedAuthority[] getRoles() {
		return roles;
	}

	public void setRoles(GrantedAuthority[] roles) {
		this.roles = roles;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptParentID() {
		return deptParentID;
	}

	public void setDeptParentID(String deptParentID) {
		this.deptParentID = deptParentID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptSeq() {
		return deptSeq;
	}

	public void setDeptSeq(String deptSeq) {
		this.deptSeq = deptSeq;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getDeptTypeID() {
		return deptTypeID;
	}

	public void setDeptTypeID(String deptTypeID) {
		this.deptTypeID = deptTypeID;
	}

	public void setAccountNonExpiredCs(boolean v_szaccountNonExpired) {
		
		this.accountNonExpired = v_szaccountNonExpired;
		// TODO Auto-generated method stub
		
	}

	public void setAccountNonLockedCs(boolean v_szaccountNonLocked) {
		// TODO Auto-generated method stub
		this.accountNonLocked = v_szaccountNonLocked;
		
	}

	public void setCredentialsNonExpiredCs(boolean V_szcredentialsNonExpired) {
		// TODO Auto-generated method stub
		this.credentialsNonExpired = V_szcredentialsNonExpired;
		
	}
	
	public boolean isCredentialsNonExpiredCs() {
		return credentialsNonExpired;
	}



	public boolean isAccountNonExpiredCs() {
		return accountNonExpired;
	}



	public boolean isAccountNonLockedCs() {
		return accountNonLocked;
	}
	public String getDwbm() {
		return dwbm;
	}

	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}

	public String getIscode() {
		return iscode;
	}

	public void setIscode(String iscode) {
		this.iscode = iscode;
	}

	public String getQystatus() {
		return qystatus;
	}

	public void setQystatus(String qystatus) {
		this.qystatus = qystatus;
	}

	public String getServicedate() {
		return servicedate;
	}

	public void setServicedate(String servicedate) {
		this.servicedate = servicedate;
	}


}
