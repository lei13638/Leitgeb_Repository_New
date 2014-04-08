package spg.pos.todo.servicejpa;

/**
 * Interface for the 'abstract factory' to be used for providing all services. This approach is required when not using
 * e.g. Spring.
 */
public interface ServiceJpaFactory {

    MultiTimeTaskServiceJpa multiTimeTaskService();
    SingleTimeTaskServiceJpa singleTimeService();
    UserServiceJpa userService();
}
