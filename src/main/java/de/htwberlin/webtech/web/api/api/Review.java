package de.htwberlin.webtech.web.api.api;

import org.springframework.web.multipart.MultipartFile;

public class Review {
    private long id;
    private String firstNameCustomer;
    private String lastNameCustomer;
    private int rating;
    private String title;
    private String ratingDetails;

    public Review(long id, String firstNameCustomer, String lastNameCustomer, int rating, String title, String ratingDetails) {
        this.id = id;
        this.firstNameCustomer = firstNameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.rating = rating;
        this.title = title;
        this.ratingDetails = ratingDetails;
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
