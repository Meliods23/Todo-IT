package se.lexicon;

import se.lexicon.ToDo.Person;
import se.lexicon.ToDo.TodoItem;
import se.lexicon.ToDo.TodoItemTask;

import java.time.Clock;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Person tester = new Person("Loai", "Alwan", "test@example.com");

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        TodoItem item = new TodoItem("Laundry", "Take laundry to washer.", tomorrow, false, tester);

        TodoItemTask task = new TodoItemTask();
        task.setAssignee(tester);
        task.setTodoItem(item);

        System.out.println("--------------------------------------------------");
        System.out.println(tester.getSummary());
        System.out.println("--------------------------------------------------");
        System.out.println(item.getSummary());
        System.out.println("--------------------------------------------------");
        System.out.println(task.getSummary());
    }
}