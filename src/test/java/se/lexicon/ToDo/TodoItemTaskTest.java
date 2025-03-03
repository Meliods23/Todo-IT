package se.lexicon.ToDo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    private TodoItemTask todoItemTask;
    private TodoItem todoItem;
    private Person assignee;

    @BeforeEach
    void setup() {
        assignee = new Person("John", "Doe", "john.doe@example.com", 1);
        todoItem = new TodoItem("Test Task", "Task Description", LocalDate.of(2025, 3, 10), false, assignee, 100);
        todoItemTask = new TodoItemTask();
    }

    @Test
    void getId() {
        assertEquals(0, todoItemTask.getId()); // Default ID since no constructor initializes it
    }

    @Test
    void getTodoItem() {
        assertNull(todoItemTask.getTodoItem()); // Initially, no TodoItem assigned

        todoItemTask.setTodoItem(todoItem);
        assertEquals(todoItem, todoItemTask.getTodoItem());
    }

    @Test
    void getAssignee() {
        assertNull(todoItemTask.getAssignee()); // Initially, no assignee

        todoItemTask.setAssignee(assignee);
        assertEquals(assignee, todoItemTask.getAssignee());
    }

    @Test
    void isAssigned() {
        assertFalse(todoItemTask.isAssigned()); // Should be false by default

        todoItemTask.setAssignee(assignee);
        assertTrue(todoItemTask.isAssigned()); // Setting an assignee should make it true

        todoItemTask.setAssigned(false);
        assertFalse(todoItemTask.isAssigned()); // Manually setting it to false
    }

    @Test
    void getSummary() {
        todoItemTask.setTodoItem(todoItem);
        todoItemTask.setAssignee(assignee);

        String expectedSummary = "Task is --> " + todoItem.getSummary() + "\n" +
                "Person assigned the task is --> " + assignee.getSummary();

        assertEquals(expectedSummary, todoItemTask.getSummary());
    }

    @Test
    void setAssigned() {
        todoItemTask.setAssigned(true);
        assertTrue(todoItemTask.isAssigned());

        todoItemTask.setAssigned(false);
        assertFalse(todoItemTask.isAssigned());
    }

    @Test
    void setTodoItem() {
        todoItemTask.setTodoItem(todoItem);
        assertEquals(todoItem, todoItemTask.getTodoItem());

        todoItemTask.setTodoItem(null);
        assertEquals(todoItem, todoItemTask.getTodoItem()); // Should not change since setter ignores null
    }

    @Test
    void setAssignee() {
        todoItemTask.setAssignee(assignee);
        assertEquals(assignee, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());

        todoItemTask.setAssignee(null);
        assertEquals(assignee, todoItemTask.getAssignee()); // Should not change since setter ignores null
    }

}