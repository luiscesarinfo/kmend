package com.kmend.techchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kmend.techchallenge.model.User;
import com.kmend.techchallenge.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
	    return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces="application/json")
	public List<User> getUsers(Model model) throws Exception {
		List<User> users = userService.listAll();
		return users;
	}	

}
