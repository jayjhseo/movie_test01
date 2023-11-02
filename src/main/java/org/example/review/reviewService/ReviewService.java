package org.example.review.reviewService;

import org.example.review.entity.Review;
import org.example.review.reviewRepository.ReviewRepository;

import java.util.List;

public class ReviewService {
    ReviewRepository reviewRepository = new ReviewRepository();

    public int create(int score, String writing, int reservationId) {
        return this.reviewRepository.create(score, writing, reservationId);
    }

    public List<Review> getReviewAllList() {
        return this.reviewRepository.getReviewAllList();
    }

    public void remove(Review review) {
        this.reviewRepository.remove(review);
    }
    public void modify(Review review, int score, String writing) {
        reviewRepository.modify(review, score, writing);
    }
    public Review getReviewListById(int id) {
        return this.reviewRepository.getReviewListById(id);
    }
}
