package org.security.userdetails;

import org.springframework.security.GrantedAuthority;

public class MyDwxx {

	private String deptcode;
	private String jmcpid;
	private String jmcpname;
	private int qysl;
	
	
	public MyDwxx(String deptcode, String jmcpid,String jmcpname,int qysl){
		setDeptcode(deptcode);
		setJmcpid(jmcpid);
		setJmcpname(jmcpname);
		setQysl(qysl);
	}
	
	public int getQysl() {
		return qysl;
	}

	public void setQysl(int qysl) {
		this.qysl = qysl;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getJmcpid() {
		return jmcpid;
	}

	public void setJmcpid(String jmcpid) {
		this.jmcpid = jmcpid;
	}

	public String getJmcpname() {
		return jmcpname;
	}

	public void setJmcpname(String jmcpname) {
		this.jmcpname = jmcpname;
	}


	
}
