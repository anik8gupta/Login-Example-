package com.saurabh.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.form.Login;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(Login login) {
		sessionFactory.getCurrentSession().save(login);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Login> listLogins(Login login) {
		Query q=sessionFactory.getCurrentSession().createQuery("from Login where userName=:uname and password=:pwd");
		q.setString("uname",login.getUserName());
		q.setString("pwd", login.getPassword());
		List<Login> li=q.list();
		return li;
	}

	@Override
	public void updateUser(Login login) {
		sessionFactory.getCurrentSession().update(login);
		
	}
	
}
