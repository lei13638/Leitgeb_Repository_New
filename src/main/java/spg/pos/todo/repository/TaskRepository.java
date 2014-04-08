package spg.pos.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spg.pos.todo.model.Task;

/**
 * 
 * @author Dominik
 *
 */

@Repository
public interface TaskRepository extends TaskRepositoryCustom, CrudRepository<Task, Long>
{
  
}
