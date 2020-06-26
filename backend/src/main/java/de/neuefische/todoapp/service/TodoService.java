package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.ToDoMongoDb;
import de.neuefische.todoapp.db.TodoDb;
import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.TodoStatus;
import de.neuefische.todoapp.model.dto.AddTodoDTO;
import de.neuefische.todoapp.model.dto.UpdateStatusDto;
import de.neuefische.todoapp.utils.IdGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
  private final ToDoMongoDb toDoDb;
  private final IdGenerationService idGenerationService;

  @Autowired
  public TodoService(ToDoMongoDb toDoDb, IdGenerationService idGenerationService) {
    this.toDoDb = toDoDb;
    this.idGenerationService = idGenerationService;
  }

  public Iterable<TodoItem> getAllTodos() {
    return toDoDb.findAll();
  }

  public TodoItem addTodoItem(AddTodoDTO data) {
    TodoItem item = createTodoItem(data);
    toDoDb.save(item);
    return item;
  }

  private TodoItem createTodoItem(AddTodoDTO data) {
    String randomId = idGenerationService.generateRandomId();
    return new TodoItem(randomId, data.getDescription(), TodoStatus.OPEN);
  }

  public TodoItem updateTodoStatus(String id, TodoItem status) {
    Optional<TodoItem> result = toDoDb.findById(id);
    if (result.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } else {
      TodoItem todoItem = result.get();
      todoItem.setStatus(status.getStatus());
      toDoDb.save(todoItem);
      return todoItem;
  }}

  public void deleteTodoItem(String id) {
    toDoDb.deleteById(id);
  }
}

