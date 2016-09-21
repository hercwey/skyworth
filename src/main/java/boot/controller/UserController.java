package boot.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.User;
import boot.service.UserService;

@RestController
public class UserController {

	@Resource

	private UserService userService;
	
	@Resource

	private RedisTemplate<String,String> redisTemplate;

	/**
	 * 
	 * 测试保存数据方法.
	 * 
	 * @return
	 * 
	 */

	@RequestMapping("/save")
	public String save() {

		User u = new User();
		u.setName("zxf");
		u.setAge("34");
		u.setSex("男");

		userService.save(u);// 保存数据.
		this.redisTemplate.opsForValue().set("zhouxiaofeng", "aaaaaaaaaaaaaa");

		return "ok.Demo2Controller.save";

	}
	
    @RequestMapping("/getById")
    public User getById(long id){

       return userService.getById(id);

    }

}