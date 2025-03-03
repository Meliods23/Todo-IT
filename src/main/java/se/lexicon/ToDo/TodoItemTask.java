package se.lexicon.ToDo;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;


    // **********************************************
    // Getter methods
    // **********************************************

    public int getId() {
        return id;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public boolean isAssigned()
    {
        return assigned;
    }

    public String getSummary()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Task is --> ").append(todoItem.getSummary() + "\n")
                .append("Person assigned the task is --> ").append(assignee.getSummary());

        return sb.toString();
    }


    // **********************************************
    // Setter methods
    // **********************************************

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem != null) {
            this.todoItem = todoItem;
        }
    }

    public void setAssignee(Person assignee) {
        if (assignee != null) {
            this.assignee = assignee;
            this.assigned = true;
        }
    }

    // **********************************************
    // Other methods
    // **********************************************
}
