package de.neuefische.todoapp.service;

import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.TodoStatus;
import de.neuefische.todoapp.model.dto.AddTodoDTO;
import de.neuefische.todoapp.utils.IdGenerationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class TodoServiceTest {

//  private final TodoDb todoDb = mock(TodoDb.class);
//  private final IdGenerationService idGenerationService = mock(IdGenerationService.class);
//  private final TodoService todoService = new TodoService(todoDb, idGenerationService);
//
//  @Test
//  public void addTodoItemSchouldAddItemToDb(){
//    //GIVEN
//    AddTodoDTO todoItem = new AddTodoDTO("some description");
//    when(idGenerationService.generateRandomId()).thenReturn("someId");
//
//    //WHEN
//   TodoItem item = todoService.addTodoItem(todoItem);
//
//    //THEN
//    TodoItem expectedItem = new TodoItem("someId","some description", TodoStatus.OPEN);
//
//    assertEquals(expectedItem,item );
//    verify(todoDb).addItem(eq(expectedItem));
//
//  }
}
