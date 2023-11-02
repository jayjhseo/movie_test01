package org.example.movie.controller;

import org.example.Container;
import org.example.review.reviewController.ReviewController;

public class FirstMovieController {
    ReviewController reviewController = new ReviewController();
    MovieController movieController = new MovieController();

    public void run() {
        while (true) {
            System.out.println("예매하기 / 리뷰작성");
            String command = Container.getSc().nextLine();
            switch (command) {
                case "돌아가기":
                    movieController.run();
                case "예매하기":
                    break;
                case "리뷰작성":
                    reviewController.write();
                    break;
                case "리뷰게시판":
                    reviewController.list();
                    break;
                case "리뷰삭제":
                    reviewController.remove();
                    break;
                case "리뷰수정":
                    reviewController.modify();
                    break;
            }
        }
    }

}
