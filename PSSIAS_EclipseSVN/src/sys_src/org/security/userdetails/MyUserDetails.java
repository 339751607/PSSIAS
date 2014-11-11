/**
 *
 */
package org.security.userdetails;

import java.sql.Date;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * @author cui
 * 
 */
public interface MyUserDetails extends UserDetails {

	Integer getUserId();

	String getUserName();

	String getEmail();

	GrantedAuthority[] getAuthorities();
	
	GrantedAuthority[] getRoles();
	
	String getExpirationDate();
	
	

	String getDeptID();//部门id
	
	String getDeptName();//部门名
	
	String getDeptLevel();
	
	String getDeptParentID();
	
	String getDeptCode();
	
	String getDeptSeq();
	
	String getDeptTypeID();

	String getPoliceID();

	String getSfzh();

	String getUserXm();
	String getDwbm();
	
	String getQystatus();
	String getServicedate();
	
	String getIscode();
	
	
	
	
	
	//扩充
	void setUserId(Integer userId);

	void setUserName(String userName);

	void setEmail(String email);

	void setAuthorities(GrantedAuthority[] authorities);
	
	void setRoles(GrantedAuthority[] roles);
	 
	void setExpirationDate(String expirationDate);
	
	
	//扩充

	void setDeptID(String deptID);
	
	void setDeptName(String deptName);
	
	void setDeptLevel(String deptLevel);
	
	void setDeptParentID(String deptParentID);
	
	void setDeptCode(String deptCode) ;
	
	void setDeptSeq(String deptSeq) ;

	void setPoliceID(String policeid);

	void setSfzh(String userxm);

	void setUserXm(String userxm);

	void setCredentialsNonExpiredCs(boolean credentialsNonExpired);

	void setAccountNonExpiredCs(boolean accountNonExpired);

	void setAccountNonLockedCs(boolean accountNonLocked);
	
	 boolean isCredentialsNonExpiredCs();
	 
	 boolean isAccountNonExpiredCs();
	 
	 boolean isAccountNonLockedCs() ;
	
	

}
