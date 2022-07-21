package com.ssafy.hw.step4;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
    //코드를 작성하세요.
    int reviewId;
    String pCode;
    String writer;
    String content;

    public Review(){}

    public Review(int reviewId, String pCode, String writer, String content) {
        this.reviewId = reviewId;
        this.pCode = pCode;
        this.writer = writer;
        this.content = content;
    }

    public String toString(){
        return String.format("Review [reviewId=%d, pCode=%s, writer=%s, content=%s]",
                reviewId, pCode, writer, content);
    }
}
