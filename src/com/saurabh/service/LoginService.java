package com.saurabh.service;

import java.util.List;
import com.saurabh.form.Login;

public interface LoginService {
	public void addLogin(Login login);
	public String listLogins(Login login);
	public void updateLogin(Login login);
}
