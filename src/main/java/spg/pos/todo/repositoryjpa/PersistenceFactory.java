package spg.pos.todo.repositoryjpa;
/**
 * 
 * @author Dominik
 *
 */
public interface PersistenceFactory
{
  SingleTimeTaskJpaRepository classRoomRepository();

  MultiTimeTaskJpaRepository curriculumRepository();

  UserJpaRepository curriculumSubjectRepository();
}
