package spg.pos.todo.repositoryjpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import spg.pos.todo.model.MultiTimeTask;
import spg.pos.todo.model.Task;
/**
 * 
 * @author Dominik
 *
 */
@Transactional
public class MultiTimeTaskJpaRepository extends AbstractJpaRepository<MultiTimeTask>
{
  @Override
  public MultiTimeTask findById(Long id)
  {
    return (MultiTimeTask)entityManager().find(Task.class, id);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<MultiTimeTask> findAll()
  {
    TypedQuery<Task> query = entityManager().createQuery("SELECT e FROM t_task e WHERE t_type = 'M'", Task.class);

    return (List)query.getResultList();
  }

  public void removeById(Long id)
  {
    entityManager().remove(findById(id));
  }
}
