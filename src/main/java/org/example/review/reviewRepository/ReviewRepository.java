package org.example.review.reviewRepository;

import org.example.review.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    List<Review> reviewList = new ArrayList<>();
    int lastId = 0;

    public int create(int score, String writing, int reservation_Id) {
        lastId++;
        Review review = new Review(lastId, score, writing, reservation_Id);
        reviewList.add(review);

        return lastId;
    }

    public List<Review> getReviewAllList() {
        return reviewList;
    }

    public void remove(Review review) {
        reviewList.remove(review);
    }
    public void modify(Review review, int score, String writing) {
        review.setScore(score);
        review.setWriting(writing);
    }
    public Review getReviewListById(int id) {
        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getId() == id) {
                return review;
            }
        }
        return null;
    }
}
