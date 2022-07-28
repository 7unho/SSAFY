package com.ssafy.ws.step3;

public class BookTest {
    public static void main(String[] args) {
        IBookManager bm = BookManagerImpl.getInstance();
        Book[] books;
        Magazine[] magazines;

        bm.add(new Book(
                "21424",
                "Java Pro",
                "김하나",
                "jaen.kr",
                15000,
                "Java 기본 문법"
        ));

        bm.add(new Book(
                "21425",
                "Java Pro2",
                "김하나",
                "jaen.kr",
                25000,
                "Java 응용"
        ));

        bm.add(new Book(
                "35355",
                "분석설계",
                "소나무",
                "jaen.kr",
                30000,
                "SW 모델링"
        ));

        bm.add(new Magazine(
                "45678",
                "월간 알고리즘",
                "홍길동",
                "jaen.kr",
                10000,
                "1월 알고리즘",
                2021,
                1
        ));

        System.out.println("*****************도서 전체 목록*****************");
        books = bm.getList();
        for (Book book: books) {
            System.out.println(book);
        }

        System.out.println("*****************일반 도서 목록*****************");
        books = bm.getBooks();
        for (Book book: books) {
            System.out.println(book);
        }

        System.out.println("*****************잡지 목록*****************");
        magazines = bm.getMagazines();
        for (Magazine magazine: magazines) {
            System.out.println(magazine);
        }

        System.out.println("*****************도서 제목 포함검색:Java*****************");
        books = bm.searchByTitle("Java");
        for (Book book: books) {
            System.out.println(book);
        }

        System.out.printf("도서 가격 총합 : %d\n", bm.getTotalPrice());
        System.out.printf("도서 가격 평균 : %.1f\n", bm.getPriceAvg());

    }
}
