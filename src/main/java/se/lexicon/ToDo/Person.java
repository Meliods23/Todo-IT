package se.lexicon.ToDo;

public class Person
{
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
    }
}
