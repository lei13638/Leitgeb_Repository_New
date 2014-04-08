package spg.pos.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Dominik
 *
 */

@Entity(name = "u_user")
public class User extends Modelbase
{
  private static final long serialVersionUID = 1L;

  @Column(name = "u_name", length = 30, unique = true, nullable = false)
  private String username;
  @Column(name = "u_email", length = 45, unique = true, nullable = false)
  private String emailAddress;
  @Column(name = "u_firstname", length = 30, nullable = false)
  private String firstname;
  @Column(name = "u_lastname", length = 50, nullable = false)
  private String lastname;
  @Temporal(TemporalType.DATE)
  @Column(name = "u_birthday", nullable = false)
  private Date birthday;
  @Column(name = "u_password", length = 60, nullable = false)
  private String password; // Gonnna get hashed

  public User()
  {
    birthday = new Date();
  }

  public User(String username, String emailAddress,
      String firstname, String lastname, Date birthday, String password)
  {
    super(null);
    this.username = username;
    this.emailAddress = emailAddress;
    this.firstname = firstname;
    this.lastname = lastname;
    this.birthday = birthday;
    this.password = password;
  }

  public void setUsername(String username)
  {
    if (username == null || username.isEmpty())
      throw new IllegalArgumentException("Empty username not allowed!");

    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public void setEmailAddress(String emailAddress)
  {
    if (emailAddress == null || emailAddress.isEmpty())
      throw new IllegalArgumentException("Empty emailAddress not allowed!");
    else if (emailAddress.split("\\@").length != 1)
      throw new IllegalArgumentException("No valid emailAddress handed over!");

    this.emailAddress = emailAddress;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setBirthday(Date birthday)
  {
    if (birthday == null)
      throw new IllegalArgumentException(
          "birthday with state null not allowed!");

    this.birthday = birthday;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setPassword(String password)
  {
    if (password == null || password.isEmpty())
      throw new IllegalArgumentException("Empty password not allowed!");
    
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }
}
