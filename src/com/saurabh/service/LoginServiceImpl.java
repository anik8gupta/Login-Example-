package com.saurabh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.dao.LoginDao;
import com.saurabh.form.Login;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired 
	private LoginDao loginDao;

	@Transactional
	public void addLogin(Login login) {
		loginDao.addUser(login);
		
	}

	@Transactional
	public String listLogins(Login login) {
		List<Login> li=loginDao.listLogins(login);
		if(li.size()>0)
		{
			Login l=li.get(0);
			if(l.getStatus()==0)
			{
				l.setStatus(1);
				updateLogin(l);
				return "success";
			}
			else{
				return "logedin";
			}
		}
		else
		{
			return "fail";
		}
	}
	@Transactional
	public void updateLogin(Login login) {
		loginDao.updateUser(login);
		
	}
}
