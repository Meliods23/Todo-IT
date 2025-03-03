package se.lexicon.ToDo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    static TodoItem todoItem;
    static Person creator;

    @BeforeEach
    void setup(){
        creator = new Person("Loai", "Homs", "Loai@example.se", 1);
        todoItem = new TodoItem("Test", "Doing a test", LocalDate.of(2025, 2, 1), false, creator, 1);
    }

    @Test
    void getId() {
        assertEquals(1, todoItem.getId());
    }

    @Test
    void getTitle() {
        assertEquals("Test", todoItem.getTitle());
    }

    @Test
    void getTaskDescription() {
        assertEquals("Doing a test", todoItem.getTaskDescription());
    }

    @Test
    void getDeadLine() {
        assertEquals(LocalDate.of(2025, 2, 1), todoItem.getDeadLine());
    }

    @Test
    void getCreator() {
        assertEquals(creator, todoItem.getCreator());
    }

    @Test
    void isDone() {
        assertFalse(todoItem.isDone());
    }

    @Test
    void getSummary() {
        String expectedSummary = "Id : 1, Title : Test, DeadLine : 2025-02-01\nTask Description --> \nDoing a test";
        assertEquals(expectedSummary, todoItem.getSummary());
    }

    @Test
    void setTitle() {
        todoItem.setTitle("Updated Title");
        assertEquals("Updated Title", todoItem.getTitle());

        // Ensure invalid title (null or empty) does not change the value
        todoItem.setTitle(null);
        assertEquals("Updated Title", todoItem.getTitle());

        todoItem.setTitle("");
        assertEquals("Updated Title", todoItem.getTitle());
    }

    @Test
    void setTaskDescription() {
        todoItem.setTaskDescription("Updated description");
        assertEquals("Updated description", todoItem.getTaskDescription());

        // Ensure invalid description (null) does not change the value
        todoItem.setTaskDescription(null);
        assertEquals("Updated description", todoItem.getTaskDescription());
    }

    @Test
    void setDeadLine() {
        LocalDate newDeadline = LocalDate.of(2025, 3, 1);
        todoItem.setDeadLine(newDeadline);
        assertEquals(newDeadline, todoItem.getDeadLine());

        // Ensure invalid deadline (null) does not change the value
        todoItem.setDeadLine(null);
        assertEquals(newDeadline, todoItem.getDeadLine());
    }

    @Test
    void setDone() {
        todoItem.setDone(true);
        assertTrue(todoItem.isDone());

        todoItem.setDone(false);
        assertFalse(todoItem.isDone());
    }

    @Test
    void setCreator() {
        Person newCreator = new Person("John", "Doe", "john@example.com", 2);
        todoItem.setCreator(newCreator);
        assertEquals(newCreator, todoItem.getCreator());

        // Ensure invalid creator (null) does not change the value
        todoItem.setCreator(null);
        assertEquals(newCreator, todoItem.getCreator());
    }

    @Test
    void isOverdue() {
        // Case: Deadline is in the past
        todoItem.setDeadLine(LocalDate.of(2023, 1, 1));
        assertTrue(todoItem.isOverdue());

        // Case: Deadline is today
        todoItem.setDeadLine(LocalDate.now());
        assertFalse(todoItem.isOverdue());

        // Case: Deadline is in the future
        todoItem.setDeadLine(LocalDate.of(2025, 12, 1));
        assertFalse(todoItem.isOverdue());
    }

    @Test
    void constructorInitialization() {
        TodoItem item = new TodoItem("New Task", "A new description", LocalDate.of(2024, 5, 10), true, creator, 2);
        assertEquals(2, item.getId());
        assertEquals("New Task", item.getTitle());
        assertEquals("A new description", item.getTaskDescription());
        assertEquals(LocalDate.of(2024, 5, 10), item.getDeadLine());
        assertEquals(creator, item.getCreator());
        assertTrue(item.isDone());
    }
}