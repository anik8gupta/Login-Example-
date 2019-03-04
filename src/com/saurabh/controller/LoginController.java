package com.saurabh.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saurabh.form.Login;
import com.saurabh.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/index")
	public String getLogin(Model model) {
		return "index";
	}
	@RequestMapping("/adduser1")
	public String addUserMapping(Model model)
	{
		model.addAttribute("login", new Login());
		return "adduser";
	}
	@RequestMapping(
		value = "/user/adduser",
		method = RequestMethod.POST
	)
	public String addUser(@ModelAttribute("login") 
		Login login, BindingResult result) 
	{
		System.out.println("UserName------->"+login.getUserName());
		loginService.addLogin(login);	
		
		return "adduser";
	}
	@RequestMapping("/login")
	public String loginUserMapping(Model model)
	{
		model.addAttribute("login", new Login());
		return "Login";
	}
	@RequestMapping(
			value = "/validuser",
			method = RequestMethod.POST
		)
	public String validateUser(@Valid @ModelAttribute("login") 
	Login login, BindingResult result, HttpSession ses, ModelMap map) 
	{
		String str=loginService.listLogins(login);
		if(result.hasErrors())
		{
			System.out.println("==============="+login.getUserName());
			return "Login";
		}
		else
		{
			if(str.equals("success"))
			{
				ses.setAttribute("login", login);
				return "Success";
			}
			else if(str.equals("logedin"))
			{
				map.addAttribute("msg","User Already Logeed In!");
				return "Login";
			}
			else
			{
				return "invaliduser";
			}
		}
}
	@RequestMapping("/logout")
    public String logout(HttpSession session ) {
		Login login=(Login)session.getAttribute("login");
		login.setStatus(0);
		loginService.updateLogin(login);
	   session.invalidate();
       return "logout";
    }
	@RequestMapping("/profile")
	public String getProfile(Model model) {
		return "Profile";
	}
}
