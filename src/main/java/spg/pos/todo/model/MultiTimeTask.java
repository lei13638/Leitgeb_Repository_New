package spg.pos.todo.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

/**
 * 
 * @author Dominik
 *
 */

@Entity
@DiscriminatorValue("M")
public class MultiTimeTask extends Task
{
  private static final long serialVersionUID = 1L;

  @Column(name = "m_repeat", length = 10, nullable = true)
  @Enumerated(EnumType.STRING)
  private RepeatType repeatType;
  @Column(name = "m_date", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  public MultiTimeTask()
  {
    repeatType = RepeatType.None;
    date = new Date();
  }

  public MultiTimeTask(Long id, User creator,
      Collection<User> worker, String title, TaskStatus status,
      RepeatType repeatType, Date date)
  {
    super(id, creator, worker, title, status);
    this.repeatType = repeatType;
    this.date = date;
  }

  @Override
  public Date getDate()
  {
    return date;
  }

  public DateTime getDateTime()
  {
    return new DateTime(date);
  }

  @Override
  public void accomplished()
  {
    super.accomplished();
    DateTime date = getDateTime();

    if (repeatType == RepeatType.Daily)
      date = date.plusDays(1);
    else if (repeatType == RepeatType.Weekly)
      date = date.plusWeeks(1);
    else
      throw new IllegalStateException("No repeat type set!");

    this.date = date.toDate();
  }

  public void doWeekly()
  {
    repeatType = RepeatType.Weekly;
  }

  public void doDaily()
  {
    repeatType = RepeatType.Daily;
  }

  public enum RepeatType
  {
    None, Weekly, Daily
  }
}
