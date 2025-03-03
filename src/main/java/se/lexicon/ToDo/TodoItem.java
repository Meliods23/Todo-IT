package se.lexicon.ToDo;

import java.time.LocalDate;

public class TodoItem {

    private int Id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator)
    {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (taskDescription != null) {
            this.taskDescription = taskDescription;
        }
        if (deadLine != null) {
            this.deadLine = deadLine;
        }
        if (creator != null) {
            this.creator = creator;
        }

        this.done = done;
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator, int id)
    {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
        if (taskDescription != null) {
            this.taskDescription = taskDescription;
        }
        if (deadLine != null) {
            this.deadLine = deadLine;
        }
        if (creator != null) {
            this.creator = creator;
        }

        this.done = done;
        this.Id = id;
    }

    // **********************************************
    // Getter methods
    // **********************************************


    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public Person getCreator() {
        return creator;
    }

    public boolean isDone() {
        return done;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id : ").append(Id + ", ")
                .append("Title : ").append(title + ", ")
                .append("DeadLine : ").append(deadLine + "\n")
                .append("Task Description --> \n").append(taskDescription);

        return sb.toString();
    }

    // **********************************************
    // Setter methods
    // **********************************************


    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void setTaskDescription(String description) {
        if (description != null) {
            this.taskDescription = description;
        }
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine != null) {
            this.deadLine = deadLine;
        }
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public void setCreator(Person creator) {
        if (creator != null) {
            this.creator = creator;
        }
    }

    // **********************************************
    // Other methods
    // **********************************************

    public boolean isOverdue()
    {
        return LocalDate.now().isAfter(deadLine);
    }
}
