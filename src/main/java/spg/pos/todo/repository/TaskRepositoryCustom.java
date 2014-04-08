package spg.pos.todo.repository;

import java.util.List;

import spg.pos.todo.model.MultiTimeTask;
import spg.pos.todo.model.SingleTimeTask;
import spg.pos.todo.model.Task;

/**
 * 
 * @author Dominik
 *
 */

public interface TaskRepositoryCustom
{
  List<SingleTimeTask> findAllSingleTimeTasks();
  SingleTimeTask findSingleTaskByName(String name);
  
  List<MultiTimeTask> findAllMultiTimeTasks();
  MultiTimeTask findMultiTaskByName(String name);
}
