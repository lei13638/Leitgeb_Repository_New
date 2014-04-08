package spg.pos.todo.model;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import spg.pos.todo.model.MultiTimeTask;
import spg.pos.todo.model.MultiTimeTask.RepeatType;
import spg.pos.todo.model.Task.TaskStatus;
import spg.pos.todo.model.User;
import spg.pos.todo.repositoryjpa.MultiTimeTaskJpaRepository;
import spg.pos.todo.repositoryjpa.UserJpaRepository;
/**
 * 
 * @author Dominik
 *
 */
public class WhenUsingMultiTimeTaskService
{
  private EntityManagerFactory factory;
  private EntityManager manager;

  @Before
  public void before()
  {
    factory = Persistence.createEntityManagerFactory("BaseService");

    if (factory != null)
      manager = factory.createEntityManager();
  }

  @After
  public void after()
  {
    if (manager != null)
      manager.close();
    if (factory != null)
      factory.close();
  }

  @Test
  public void ensureThatFindAllOnEmptyDBReturnsNoResult()
  {
    MultiTimeTaskJpaRepository service = new MultiTimeTaskJpaRepository();
    service.setEntityManager(manager);
    
    List<MultiTimeTask> tasks = service.findAll();
    assertThat(tasks, notNullValue());
    assertThat(tasks.size(), is(0));
  }

  @Test
  public void ensureThatAfterInsertingATaskHeIsStored()
  {
    User owner = generateAndInsertValidUser();
    Collection<User> worker = new ArrayList<User>();
    worker.add(owner);

    MultiTimeTaskJpaRepository service = new MultiTimeTaskJpaRepository();
    service.setEntityManager(manager);
    
    MultiTimeTask task = new MultiTimeTask(null, owner, worker,
        "Wochenmeeting", TaskStatus.Open, RepeatType.Weekly, new Date());
    service.persist(task);

    MultiTimeTask fromDb = service.findById(task.getId());

    assertThat(fromDb, notNullValue());
    assertThat(fromDb.getCreator(), is(owner));
  }

  @Test
  public void ensureThatAfterInsertingOneElementFindAllReturnsAListWithOneElement()
  {
    User owner = generateAndInsertValidUser();
    Collection<User> worker = new ArrayList<User>();
    worker.add(owner);

    MultiTimeTaskJpaRepository service = new MultiTimeTaskJpaRepository();
    service.setEntityManager(manager);
    
    MultiTimeTask task = new MultiTimeTask(null, owner, worker,
        "Wochenmeeting", TaskStatus.Open, RepeatType.Weekly, new Date());
    service.persist(task);

    List<MultiTimeTask> fromDb = service.findAll();

    assertThat(fromDb, notNullValue());
    assertThat(fromDb.size(), is(1));
  }

  @Test
  public void entureThatAfterInsertingATaskAndDeletingHimHeIsNotStored()
  {
    User owner = generateAndInsertValidUser();
    Collection<User> worker = new ArrayList<User>();
    worker.add(owner);

    MultiTimeTaskJpaRepository service = new MultiTimeTaskJpaRepository();
    service.setEntityManager(manager);
    
    MultiTimeTask task = new MultiTimeTask(null, owner, worker,
        "Wochenmeeting", TaskStatus.Open, RepeatType.Weekly, new Date());
    service.persist(task);
    service.removeById(task.getId());

    MultiTimeTask fromDb = service.findById(task.getId());

    assertThat(fromDb, is(nullValue()));
  }

  private User generateAndInsertValidUser()
  {
    UserJpaRepository service = new UserJpaRepository();
    service.setEntityManager(manager);
    
    User newUser = new User("Fritz", "fritz@box.com", "Fitz", "Box",
        new Date(), "123456");
    service.persist(newUser);
    
    return newUser;
  }
}
