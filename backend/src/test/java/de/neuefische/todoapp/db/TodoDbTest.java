package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.TodoStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoDbTest {

//  private final TodoDb todoDb = new TodoDb();
//
//  @Test
//  public void getAllItemsShouldReturnAllTodoItems() {
//    //GIVEN
//    todoDb.addItem(new TodoItem("1", "Some todo", TodoStatus.OPEN));
//    todoDb.addItem(new TodoItem("2", "Some other todo item", TodoStatus.DONE));
//
//    //WHEN
//    List<TodoItem> items = todoDb.getAllItems();
//
//    //THEN
//    assertEquals(2, items.size());
//    assertTrue(items.contains(new TodoItem("1", "Some todo", TodoStatus.OPEN)));
//    assertTrue(items.contains(new TodoItem("2", "Some other todo item", TodoStatus.DONE)));
//
//  }
//
//  @Test
//  public void updateTotoStatusShouldUpdatedItemStatus(){
//    //GIVEN
//    todoDb.addItem(new TodoItem("1", "Some todo", TodoStatus.OPEN));
//    todoDb.addItem(new TodoItem("2", "Some other todo item", TodoStatus.IN_PROGRESS));
//
//    //WHEN
//    TodoItem todoItem = todoDb.updateTodoStatus("2", TodoStatus.DONE);
//
//    //THEN
//    assertEquals(todoItem, new TodoItem("2", "Some other todo item", TodoStatus.DONE));
//    List<TodoItem> items = todoDb.getAllItems();
//    assertEquals(2, items.size());
//    assertTrue(items.contains(new TodoItem("1", "Some todo", TodoStatus.OPEN)));
//    assertTrue(items.contains(new TodoItem("2", "Some other todo item", TodoStatus.DONE)));
//  }
//
//  @Test
//  public void deleteTodoItemShouldDeleteItemFromDb(){
//    //GIVEN
//    todoDb.addItem(new TodoItem("1", "Some todo", TodoStatus.OPEN));
//    todoDb.addItem(new TodoItem("2", "Some other todo item", TodoStatus.IN_PROGRESS));
//
//    //WHEN
//    todoDb.deleteTodoItem("2");
//
//    //THEN
//    List<TodoItem> items = todoDb.getAllItems();
//    assertEquals(1, items.size());
//    assertTrue(items.contains(new TodoItem("1", "Some todo", TodoStatus.OPEN)));
//  }
}
