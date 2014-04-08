package spg.pos.todo.repositoryjpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import spg.pos.todo.model.SingleTimeTask;
import spg.pos.todo.model.Task;
/**
 * 
 * @author Dominik
 *
 */
@Transactional
public class SingleTimeTaskJpaRepository extends AbstractJpaRepository<SingleTimeTask>
{
  @Override
  public SingleTimeTask findById(Long id)
  {
    return (SingleTimeTask)entityManager().find(Task.class, id);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<SingleTimeTask> findAll()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM t_task e where t_type = 'S'", Task.class);
    return (List)query.getResultList();
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<Task> yolo()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM t_task e", Task.class);
    return (List)query.getResultList();
  }

  public void removeById(Long id)
  {
    entityManager().remove(findById(id));
  }
}
