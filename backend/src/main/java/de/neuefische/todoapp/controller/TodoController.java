package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.dto.AddTodoDTO;
import de.neuefische.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<TodoItem> getAllTodos(){
    return todoService.getAllTodos();
  }

  @PutMapping
  public TodoItem addTodo(@RequestBody AddTodoDTO data){
    return todoService.addTodoItem(data);
  }

}