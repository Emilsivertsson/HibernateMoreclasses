package org.CodeForPizza;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
// this value is used to differentiate between the subclasses
@DiscriminatorValue("E")
public class Employee extends Person{
    private String department;
    private String hireDate;

    public Employee(int personID, String firstName, String lastName, String department, String hireDate) {
        super(personID, firstName, lastName);
        this.department = department;
        this.hireDate = hireDate;
    }

    public Employee() {

    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
