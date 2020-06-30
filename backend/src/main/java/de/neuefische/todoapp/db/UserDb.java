package de.neuefische.todoapp.db;
import de.neuefische.todoapp.model.PlanningUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDb extends PagingAndSortingRepository<PlanningUser,String> {
}
