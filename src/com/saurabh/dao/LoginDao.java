package com.saurabh.dao;

import java.util.List;
import com.saurabh.form.Login;


public interface LoginDao {
	public void addUser(Login login);
	public List<Login> listLogins(Login login);
	public void updateUser(Login login);
}
