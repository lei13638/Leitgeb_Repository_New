package spg.pos.todo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.mysema.query.jpa.impl.JPAQuery;

import spg.pos.todo.model.MultiTimeTask;
import spg.pos.todo.model.QMultiTimeTask;
import spg.pos.todo.model.QSingleTimeTask;
import spg.pos.todo.model.QTask;
import spg.pos.todo.model.SingleTimeTask;
import spg.pos.todo.model.Task;
import spg.pos.todo.repository.TaskRepositoryCustom;

/**
 * 
 * @author Dominik
 *
 */

public class TaskRepositoryImpl implements TaskRepositoryCustom
{
  @PersistenceContext
  EntityManager entityManager;

  public List<SingleTimeTask> findAllSingleTimeTasks()
  {
    JPAQuery query = new JPAQuery(entityManager);

    QSingleTimeTask task = QSingleTimeTask.singleTimeTask;

    query.from(task).orderBy(task.title.asc());
    return query.list(task);
  }

  public SingleTimeTask findSingleTaskByName(String name)
  {
    JPAQuery query = new JPAQuery(entityManager);

    QSingleTimeTask task = QSingleTimeTask.singleTimeTask;

    query.from(task).where(task.title.eq(name));
    return query.list(task).get(0);
  }

  public List<MultiTimeTask> findAllMultiTimeTasks()
  {
    JPAQuery query = new JPAQuery(entityManager);

    QMultiTimeTask task = QMultiTimeTask.multiTimeTask;

    query.from(task).orderBy(task.title.asc());
    return query.list(task);
  }

  public MultiTimeTask findMultiTaskByName(String name)
  {
    JPAQuery query = new JPAQuery(entityManager);

    QMultiTimeTask task = QMultiTimeTask.multiTimeTask;

    query.from(task).where(task.title.eq(name));
    return query.list(task).get(0);
  }
}
