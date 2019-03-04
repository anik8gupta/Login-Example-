package com.saurabh.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@Column(name="User_Name")
	@NotEmpty(message="Please Enter value in Name Field")
	private String userName;
	
	@Column(name="Password")
	@NotEmpty(message="Please Enter value in Password Field")
	private String password;

	@Column(name="User_Type")
	private String utype;
	
	@Column(name="status")
	private int status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
