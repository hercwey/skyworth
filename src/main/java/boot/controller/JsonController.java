package boot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.User;
import boot.service.UserService;
@RestController
public class JsonController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(){
		
		User u = this.userService.getById(1L);
		
		return u;
		
	}
	
	@RequestMapping("/getException")
	@ResponseBody
	public String getException(){
		Integer i = 100/0;
		System.err.println(i);
		return "exception";
		
	}
	
}
