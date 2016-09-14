package boot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.User;
@RestController
public class JsonController {
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(){
		User u = new User();
		
		u.setName("zxf");
		u.setAge("34");
		return u;
		
	}
	
}
