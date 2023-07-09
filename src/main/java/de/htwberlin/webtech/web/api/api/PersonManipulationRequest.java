package de.htwberlin.webtech.web.api.api;

import java.util.Date;

public class PersonManipulationRequest {

    private String firstName;
    private String lastName;
    private String date;

    private String time;

    public PersonManipulationRequest(String firstName, String lastName, String date, String time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
    }

    public PersonManipulationRequest() {}

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
