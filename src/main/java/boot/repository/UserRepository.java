package boot.repository;

import org.springframework.data.repository.CrudRepository;

import boot.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	 

}