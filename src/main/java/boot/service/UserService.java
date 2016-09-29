package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import boot.entity.DeviceInfo;
import boot.entity.User;
import boot.repository.UserRepository;

@Service

public class UserService {
	
	//这里的单引号不能少，否则会报错，被识别是一个对象;

    public static final String CACHE_KEY = "'userInfo'";

	@Resource
	private UserRepository userRepository;

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public List<DeviceInfo> getDeviceId(){
		String sql = "select * from t_u_device_info where LENGTH(DEVICEID)=36 and FK_ACCOUNT like '00000000%' and type =0  and status = 0";

	       RowMapper<DeviceInfo> rowMapper = new BeanPropertyRowMapper<DeviceInfo>(DeviceInfo.class);
	       return jdbcTemplate.query(sql, rowMapper);
	}
	
	 /**

     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml

    */

    public static final String DEMO_CACHE_NAME = "user";
	
	@Transactional
	@CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY)
	public User save(User demo) {

		return userRepository.save(demo);

	}
	
	 /**

     * 通过id获取demo对象.

     * @param id

     * @return

     */
	@Cacheable(value=DEMO_CACHE_NAME,key="'userInfo_'+#id")
    public User getById(long id){

       String sql = "select * from t_study where id=?";

       RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
       System.err.println("===================没走缓存的数据");
       return jdbcTemplate.queryForObject(sql, rowMapper,id);

    }

	 /**

     * http://www.mincoder.com/article/2096.shtml:

     *

     * 修改数据.

     *

     * 在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。@CachePut也可以声明一个方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

 

       @CachePut也可以标注在类上和方法上。使用@CachePut时我们可以指定的属性跟@Cacheable是一样的。

     *

     * @param updated

     * @return

     *

     * @throws NotFoundException

     */

    @CachePut(value = DEMO_CACHE_NAME,key = "'userInfo_'+#updated.getId()")

    //@CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#updated.getId()")//这是清除缓存.

    public User update(User updated){

    	User demoInfo = userRepository.findOne(updated.getId());

       if(demoInfo == null){

           throw new RuntimeException("No find");

       }

       demoInfo.setName(updated.getName());

       demoInfo.setAge(updated.getAge());

       return demoInfo;

    }

   

   

    /**

     * 删除数据.

     * @param id

     */

    @CacheEvict(value = DEMO_CACHE_NAME,key = "'demoInfo_'+#id")//这是清除缓存.

    public void delete(Long id){

       userRepository.delete(id);

    }
}