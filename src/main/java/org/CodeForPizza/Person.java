package org.CodeForPizza;

import jakarta.persistence.*;

@Entity
// this annotation is used to specify that this class is the parent class of the inheritance
@Inheritance
// discriminator column is used to differentiate between the subclasses
//all wiil be saved into the same table, but the discriminator column will be used to differentiate between the subclasses
@DiscriminatorColumn(name= "discriminator",discriminatorType = DiscriminatorType.STRING)
// this value is used to differentiate between the subclasses
@DiscriminatorValue("p")
public class Person {
    @Id
    private int personID;
    private String firstName;
    private String lastName;

    public Person(int personID, String firstName, String lastName) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
