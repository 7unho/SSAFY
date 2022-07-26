package com.ssafy.ws.step3;

public class BookTest {
    public static void main(String[] args) {
        BookManager.add(new Book(
                "21424",
                "Java Pro",
                "김하나",
                "jaen.kr",
                15000,
                "2"
        ));
        BookManager.add(new Book(
                "21425",
                "Java Pro2",
                "2",
                "jaen.kr",
                25000,
                "2"
        ));

        BookManager.add(new Book(
                "35355",
                "분석설계",
                "2",
                "jaen.kr",
                30000,
                "2"
        ));
        BookManager.add(new Magazine(
                "46789",
                "월간 알고리즘",
                "홍길동",
                "jaen.kr",
                10000,
                "test",
                2021,
                1
        ));

        System.out.println("*************도서 전체 목록**************");
        Book[] books = BookManager.getList();
        Book[] books2;
        Magazine[] magazines = BookManager.getMagazine();

        for (Book book: books) {
            System.out.println(book);
        }

        books2 = BookManager.getBooks();
        System.out.println("*************일반 도서 목록**************");
        for (Book book: books2) {
            System.out.println(book);
        }

        System.out.println("*************잡지 목록**************");
        for (Magazine magazine: magazines) {
            System.out.println(magazine);
        }

    }
}
