package boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HwController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello world";
	}
	
}
