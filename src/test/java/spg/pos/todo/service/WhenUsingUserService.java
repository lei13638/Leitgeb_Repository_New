package spg.pos.todo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * A very useful test case for the service layer.
 * 
 * @author Dominik
 */
@ContextConfiguration(classes = ServiceTestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class WhenUsingUserService extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserService userService;
	
	@Test
	public void ensureThatThereIsAtLeastOneTestAsOurTeacherDid() {
		Assert.assertNotNull(userService);
	}
}
