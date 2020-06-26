package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.TodoItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToDoMongoDb extends PagingAndSortingRepository<TodoItem,String> {
}
