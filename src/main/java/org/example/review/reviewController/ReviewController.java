package org.example.review.reviewController;

import org.example.Container;
import org.example.review.entity.Review;
import org.example.review.reviewService.ReviewService;
import org.example.user.entity.User;

import java.util.List;

public class ReviewController {
    ReviewService reviewService = new ReviewService();
    User user_id;

    public void write() {
        System.out.print("평점(1~5): ");
        int score = Integer.parseInt(Container.getSc().nextLine());
        if (score > 5) {
            System.out.println("평점을 1~5사이의 점수로 등록해주세요.");
            return;
        }
        System.out.print("리뷰 내용: ");
        String writing = Container.getSc().nextLine();

        int id = reviewService.create(score, writing, Container.getLoginedUser().getId());
        System.out.println(id + "번째 리뷰가 등록되었습니다.");

    }

    public void list() {
        List<Review> reviewList = reviewService.getReviewAllList();
        if (reviewList.size() == 0) {
            System.out.println("게시물이 없습니다.");
        } else {
            System.out.println("게시물 번호 / 작성자 / 평점 / 리뷰내용 ");
            for (int i = 0; i < reviewList.size(); i++) {
                Review review = reviewList.get(i);
                System.out.printf("%d / %d / %d / %s\n", review.getId()+1, review.getReservation_id(), review.getScore(), review.getWriting());
            }
        }

    }

    public void remove() {
//        boolean checkId = false;
//        if (Container.getLoginedUser().equals(Container.getLoginedUser().getUser_id())) {
//            checkId = true;
//        } else {
//            System.out.println("회원정보가 일치하지 않습니다.");
//            return;
//        }
        System.out.println("삭제할 리뷰내용의 ID값을 입력해주세요");
        int id = Integer.parseInt(Container.getSc().nextLine()) - 1;
        Review review = reviewService.getReviewListById(id);
        if (review == null) {
            System.out.printf("%d번 리뷰내용이 존재하지 않습니다.\n", id + 1);
            return;
        }
        System.out.printf("%d번 리뷰내용이 삭제 되었습니다.\n", id + 1);
        this.reviewService.remove(review);
    }

    public void modify() {
        if (Container.getLoginedUser().equals(user_id)) {
            System.out.println("회원정보가 일치하지 않습니다.");
            return;
        }
        System.out.println("수정할 리뷰내용의 ID값을 입력해주세요");
        int id = Integer.parseInt(Container.getSc().nextLine()) - 1;
        Review review = reviewService.getReviewListById(id);
        if (review == null) {
            System.out.printf("%d번 리뷰내용이 존재하지 않습니다.\n", id + 1);
            return;
        }
        System.out.print("평점 수정: ");
        int score = Integer.parseInt(Container.getSc().nextLine());
        if (score > 5) {
            System.out.println("평점을 1~5사이의 점수로 등록해주세요.");
            return;
        }
        System.out.print("리뷰 수정: ");
        String writing = Container.getSc().nextLine();

        reviewService.modify(review, score, writing);

        System.out.printf("%d번 리뷰내용이 수정 되었습니다.\n", id + 1);
    }
}
