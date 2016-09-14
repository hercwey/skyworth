package boot.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JsonController {
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(){
		User u = new User();
		
		u.setName("zxf");
		u.setAge("34");
		return u;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JsonController.class, args);
	}
}
