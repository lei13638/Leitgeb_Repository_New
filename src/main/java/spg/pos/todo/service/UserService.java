package spg.pos.todo.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spg.pos.todo.model.User;
import spg.pos.todo.repository.UserRepository;
import spg.pos.todo.repositoryjpa.UserJpaRepository;
/**
 * 
 * @author Dominik
 *
 */
@Service
public class UserService
{
  @Autowired
  private UserRepository userRepository;
  
  public void createNewUser(String name, String email)
  {
    User user = new User(name, email, "", "", new Date(), randomString(6));
    userRepository.save(user);
  }
  
  private String randomString(int length)
  {
    char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    StringBuilder sb = new StringBuilder();
    Random random = new Random();
    
    for (int i = 0; i < length; i++) 
    {
        char c = chars[random.nextInt(chars.length)];
        sb.append(c);
    }
    
    return sb.toString();
  }
}
