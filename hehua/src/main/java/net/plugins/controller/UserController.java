package net.plugins.controller;

import java.util.Date;

import javax.annotation.Resource;

import net.plugins.model.User;

import net.plugins.service.UserServiceImpl;
import net.util.DatePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController  {
	
	@InitBinder
    public void initDataBinder(WebDataBinder binder) {
		
		DatePropertyEditor propertyEditor = new DatePropertyEditor();
		propertyEditor.setFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, propertyEditor);
    }
	
	@Resource
	@Autowired(required=true)
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/find", method=RequestMethod.GET)
	@ResponseBody
	public User findByAccount(String account){
		
		return userServiceImpl.findByAccount(account);
	}
	
	@RequestMapping(value = "/find2", method=RequestMethod.GET)
	@ResponseBody
	public User findUserWithRoles(String account){
		
		return userServiceImpl.findUserWithRoles(account);
	}
	
	
	@RequestMapping(value = "/list.data", method=RequestMethod.GET)
	@ResponseBody
	public String getList(int page, int size){
		
		return userServiceImpl.getList(page, size);
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(){
		
		User user = new User();
		user.setUser_name("test111");
		user.setFullname("测试更新");
		userServiceImpl.updateUser(user);
	
		return "success";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.GET)
	@ResponseBody
	public String insertUser(){
		User user = new User();
		//user.setUser_name("test_" + new Random(100L).nextInt());
		//user.setFullname("测试新增");
		
		userServiceImpl.insertUser(user);
	
		return "success";
	}
}
