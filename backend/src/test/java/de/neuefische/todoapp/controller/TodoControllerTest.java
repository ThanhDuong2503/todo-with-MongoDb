package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.db.TodoDb;
import de.neuefische.todoapp.model.TodoItem;
import de.neuefische.todoapp.model.TodoStatus;
import de.neuefische.todoapp.model.dto.AddTodoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTest {

  @LocalServerPort
  public int port;

  @Autowired
  public TestRestTemplate restTemplate;

  @Autowired
  public TodoDb db;

  @BeforeEach
  public void resetDb(){
    db.clearDb();
  }

  @Test
  public void getTodoShouldReturnAllTodoItemsFromDb() {
    //GIVEN
    db.addItem(new TodoItem("1", "first todo", TodoStatus.OPEN));
    db.addItem(new TodoItem("2", "done todo", TodoStatus.DONE));

    //WHEN
    ResponseEntity<TodoItem[]> response = restTemplate.getForEntity(getTodoApiUrl(), TodoItem[].class);

    //THEN
    assertEquals(HttpStatus.OK, response.getStatusCode());
    TodoItem[] items = response.getBody();
    assertEquals(2, items.length);
    assertEquals(new TodoItem("1", "first todo", TodoStatus.OPEN), items[0]);
    assertEquals(new TodoItem("2", "done todo", TodoStatus.DONE), items[1]);
  }

  @Test
  public void putTodoItemShouldAddATodoItemToDb() {
    //GIVEN
    HttpEntity<AddTodoDTO> entity = new HttpEntity<>(new AddTodoDTO("some todo"));

    //WHEN
    ResponseEntity<TodoItem> response = restTemplate.exchange(getTodoApiUrl(), HttpMethod.PUT, entity, TodoItem.class);

    //THEN
    assertEquals(HttpStatus.OK, response.getStatusCode());
    TodoItem addedItem = response.getBody();
    assertEquals("some todo", addedItem.getDescription());
    assertEquals(TodoStatus.OPEN, addedItem.getStatus());
    assertNotNull(addedItem.getId());

    assertEquals(1, db.getAllItems().size());
    assertTrue( db.getAllItems().contains(addedItem));
  }

  private String getTodoApiUrl() {
    return "http://localhost:" + port + "/api/todo";
  }
}