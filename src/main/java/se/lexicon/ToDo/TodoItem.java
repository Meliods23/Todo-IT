package se.lexicon.ToDo;

import java.time.LocalDate;

public class TodoItem {
    private int Id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String description, LocalDate deadLine, boolean done, Person creator)
    {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (description != null) {
            this.description = description;
        }
        if (deadLine != null) {
            this.deadLine = deadLine;
        }
        if (creator != null) {
            this.creator = creator;
        }

        this.done = done;
    }
}
