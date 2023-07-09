package de.htwberlin.webtech.persistence;

import jakarta.persistence.*;

@Entity(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "customer first name")
    private String firstNameCustomer;
    @Column(name = "customer last name")
    private String lastNameCustomer;
    @Column(name = "rating")
    private int rating;
    @Column(name = "title")
    private String title;
    @Column(name = "rating details")
    private String ratingDetails;

    public ReviewEntity(long id, String firstNameCustomer, String lastNameCustomer, int rating, String title, String ratingDetails) {
        this.id = id;
        this.firstNameCustomer = firstNameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.rating = rating;
        this.title = title;
        this.ratingDetails = ratingDetails;
    }

    protected ReviewEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstNameCustomer() {
        return firstNameCustomer;
    }

    public void setFirstNameCustomer(String firstNameCustomer) {
        this.firstNameCustomer = firstNameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRatingDetails() {
        return ratingDetails;
    }

    public void setRatingDetails(String ratingDetails) {
        this.ratingDetails = ratingDetails;
    }

}
