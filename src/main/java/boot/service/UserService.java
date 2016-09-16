package boot.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import boot.entity.User;
import boot.repository.UserRepository;

@Service

public class UserService {

	@Resource
	private UserRepository userRepository;

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Transactional

	public void save(User demo) {

		userRepository.save(demo);

	}
	
	 /**

     * 通过id获取demo对象.

     * @param id

     * @return

     */

    public User getById(long id){

       String sql = "select * from t_study where id=?";

       RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

       return jdbcTemplate.queryForObject(sql, rowMapper,id);

    }


}