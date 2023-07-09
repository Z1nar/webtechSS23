package de.htwberlin.webtech.web.api;

import de.htwberlin.webtech.service.ReviewService;
import de.htwberlin.webtech.web.api.api.Review;
import de.htwberlin.webtech.web.api.api.ReviewManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping(path = "/api/v1/reviews")
    public ResponseEntity<List<Review>> fetchReviews() {return ResponseEntity.ok(reviewService.findAll()); }

    @GetMapping(path = "api/v1/reviews/id")
    public ResponseEntity<Review> fetchReviewByID(@PathVariable Long id){
        var review = reviewService.findById(id);
        return review != null? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/reviews")
    public ResponseEntity<Void> createReview(@RequestBody ReviewManipulationRequest request) throws URISyntaxException {
        var review = reviewService.create(request);
        URI uri = new URI("api/v1/reviews/" + review.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewManipulationRequest request){
        var review = reviewService.update(id, request);
        return review != null? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "api/v1/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        boolean successful = reviewService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/reviews/deleteByFirstAndLastName")
    public ResponseEntity<Void> deleteReviewByFirstAndLastName(@RequestParam String firstNameCustomer, @RequestParam String lastNameCustomer) {
        boolean successful = reviewService.deleteByFirstAndLastName(firstNameCustomer, lastNameCustomer);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
