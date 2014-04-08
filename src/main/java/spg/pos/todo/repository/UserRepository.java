package spg.pos.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spg.pos.todo.model.User;

/**
 * 
 * @author Dominik
 *
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{

}
