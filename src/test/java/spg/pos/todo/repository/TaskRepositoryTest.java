package spg.pos.todo.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskRepositoryTest {
  @Autowired
  private TaskRepository taskRepository;
  
  @Test
  public void testMe() {
	  Assert.assertNotNull(taskRepository);
  }
}
