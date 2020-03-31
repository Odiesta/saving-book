package com.odiesta.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Employee {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty jobTitle;

    public Employee(String firstName, String lastName, String jobTitle) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.jobTitle = new SimpleStringProperty(jobTitle);
    }

    public String getFirstName() {
        return this.firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return this.lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getJobTitle() {
        return this.jobTitle.get();
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

}
