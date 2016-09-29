package boot.controller;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
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
	@Cacheable(value="userCache",key="10001") 
    @RequestMapping("/getById")
    public User getById(long id){
		System.err.println("============================88888888888888888888888888888");
    	String name = this.redisTemplate.opsForValue().get("1000");
    	System.err.println("============================" + name);
       return userService.getById(id);

    }
	
	 @RequestMapping("/test")

	    public String test(){

	      

	       //存入两条数据.

	        User user = new User();

	        user.setName("张三");


	        User user2 = userService.save(user);

	      

	        //不走缓存.

	        System.out.println(userService.getById(user2.getId()));

	        //走缓存.

	        System.out.println(userService.getById(user2.getId()));

	       

	       

	        user = new User();

	        user.setName("李四");


	        User user3 = userService.save(user);

	       

	        //不走缓存.

	        System.out.println(userService.getById(user3.getId()));

	        //走缓存.

	        System.out.println(userService.getById(user3.getId()));

	       

	        System.out.println("============修改数据=====================");

	        //修改数据.

	        User updated = new User();

	        updated.setName("李四-updated");


	        updated.setId(user3.getId());

	        try {

	           System.out.println(userService.update(updated));

	       } catch (Exception e) {

	           e.printStackTrace();

	       }

	       

	        //不走缓存.

	        System.out.println(userService.getById(updated.getId()));

	       

	       return "ok";

	    }

}