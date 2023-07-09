package de.htwberlin.webtech.persistence;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first name")
    private String firstName;

    @Column(name = "last name")
    private String lastName;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    public PersonEntity(String firstName, String lastName, String date, String time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
    }

    protected PersonEntity() {
    }

    public long getId() {
        return id;
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

