package se.lexicon.ToDo;

public class Person
{
    private static int sequencer = 1;
    private int Id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email)
    {
        if (firstName != null) {
            this.firstName = firstName;
        }
        if (lastName != null) {
            this.lastName = lastName;
        }
        if (email != null) {
            this.email = email;
        }

        Id = sequencer;
        sequencer++;
    }

    public Person(String firstName, String lastName, String email, int id)
    {
        if (firstName != null) {
            this.firstName = firstName;
        }
        if (lastName != null) {
            this.lastName = lastName;
        }
        if (email != null) {
            this.email = email;
        }

        this.Id = id;
    }

    // **********************************************
    // Getter methods
    // **********************************************

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // **********************************************
    // Setter methods
    // **********************************************

    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    // **********************************************
    // Other methods
    // **********************************************

    public String getSummary()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Id : ").append(Id + ", ")
                .append("Name : ").append(firstName + " " + lastName + ", ")
                .append("Email : ").append(email);

        return sb.toString();
    }
}
