package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.TodoStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
//public class TodoDb {
//
//  private final List<TodoItem> todoItems = new ArrayList<>();
//
//  public void addItem(TodoItem item) {
//    todoItems.add(item);
//  }
//
//  public List<TodoItem> getAllItems() {
//    return todoItems;
//  }
//
//  public void clearDb() {
//    todoItems.clear();
//  }
//
//  private TodoItem findItemById(String id){
//    for (TodoItem todoItem : todoItems) {
//      if (todoItem.getId().equals(id)) {
//        return todoItem;
//      }
//    }
//    return null;
//  }
//
//  public TodoItem updateTodoStatus(String id, TodoStatus status) {
//    TodoItem item = findItemById(id);
//    if(item != null){
//      item.setStatus(status);
//      return item;
//    }
//    return null;
//  }
//
//  public void deleteTodoItem(String id) {
//    TodoItem item = findItemById(id);
//    if(item != null){
//      todoItems.remove(item);
//    }
//  }
//}
