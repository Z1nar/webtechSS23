package de.htwberlin.webtech.service;


import de.htwberlin.webtech.persistence.ReviewEntity;
import de.htwberlin.webtech.persistence.ReviewRepository;
import de.htwberlin.webtech.web.api.api.Review;
import de.htwberlin.webtech.web.api.api.ReviewManipulationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll(){
        List<ReviewEntity> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Review create(ReviewManipulationRequest request) {
        var reviewEntity = new ReviewEntity(request.getId(), request.getFirstNameCustomer(), request.getLastNameCustomer(), request.getRating(), request.getTitle(), request.getRatingDetails());
        reviewEntity = reviewRepository.save(reviewEntity);
        return transformEntity(reviewEntity);
    }


    public Review update(Long id, ReviewManipulationRequest request){
        var reviewEntityOptional = reviewRepository.findById(id);
        if (reviewEntityOptional.isEmpty()){
            return null;
        }

        var reviewEntity = reviewEntityOptional.get();
        reviewEntity.setFirstNameCustomer(request.getFirstNameCustomer());
        reviewEntity.setLastNameCustomer(request.getLastNameCustomer());
        reviewEntity.setRating(request.getRating());
        reviewEntity.setTitle(request.getTitle());
        reviewEntity.setRatingDetails(request.getRatingDetails());
        reviewEntity = reviewRepository.save(reviewEntity);

        return transformEntity(reviewEntity);
    }


    public Review findById(Long id){
        var reviewEntity = reviewRepository.findById(id);
        return reviewEntity.map(this::transformEntity).orElse(null);
    }


    public boolean deleteById(Long id){
        if (!reviewRepository.existsById(id)){
            return false;
        }

        reviewRepository.deleteById(id);
        return true;
    }
    private Review transformEntity(ReviewEntity reviewEntity) {
        return new Review(
                reviewEntity.getId(),
                reviewEntity.getFirstNameCustomer(),
                reviewEntity.getLastNameCustomer(),
                reviewEntity.getRating(),
                reviewEntity.getTitle(),
                reviewEntity.getRatingDetails()
        );
    }

    public boolean deleteByFirstAndLastName(String firstNameCustomer, String lastNameCustomer) {
        var reviewEntityOptional = reviewRepository.findAllByFirstNameCustomer(firstNameCustomer)
                .stream()
                .filter(review -> review.getLastNameCustomer().equals(lastNameCustomer))
                .findFirst();

        if (reviewEntityOptional.isEmpty()) {
            return false;
        }

        var reviewEntity = reviewEntityOptional.get();
        reviewRepository.delete(reviewEntity);
        return true;
    }

}
