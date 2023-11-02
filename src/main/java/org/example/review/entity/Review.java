package org.example.review.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    public class Review {
        private int id;
        //리뷰 id(고유번호)

        private int user_id;
        //예매정보id
        //예매정보말고 작성자 추가

        private int score;
        //평점

        private String writing;
        //글(한줄평)
        public Review(int lastId, int score, String writing, int reservation_Id) {
            this.score = score;
            this.writing = writing;
        }
}
