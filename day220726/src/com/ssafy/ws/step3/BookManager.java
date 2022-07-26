package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManager extends Book{
    static final int MAX_SIZE = 100;
    static Book[] books = new Book[MAX_SIZE];
    static int size = 0;

    public static void add(Book book){
        books[size++] = book;
    }

    public static void remove(String isbn){
        System.out.printf("********************도서삭제 : %s********************\n", isbn);
        for (int i = 0; i < size; i++) {
            if(isbn.equals(books[i].getIsbn())){
                books[i] = books[size - 1];
                size -= 1;
            }
        }
    }

    public static Book[] getList(){
        return Arrays.copyOfRange(books, 0, size);
    }

    public static Book searchByIsbn(String isbn){
        System.out.printf("********************도서조회 : %s********************\n", isbn);

        for (int i = 0; i < size; i++) {
            if(isbn.equals(books[i].getIsbn())) return books[i];
        }

        return new Book();
    }

    public static Book[] searchByTitle(String title){
        //String.contains();
        Book[] temp = new Book[size];
        int idx = 0;
        System.out.printf("********************도서 제목 포함검색 : %s********************\n", title);

        for (int i = 0; i < size; i++) {
            if(title.contains(books[i].getTitle())) temp[idx++] = books[i];
        }

        return temp;

    }

    public static Magazine[] getMagazine(){
        Magazine[] magazines = new Magazine[size];
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn() != null && books[i] instanceof Magazine) magazines[idx++] = (Magazine) books[i];
        }
        return magazines;
    }

    public static Book[] getBooks(){
        Book[] temp = new Book[size];
        int idx = 0;

        for(int i = 0; i < size; i++){
            if(books[i] instanceof Book) temp[idx++] = books[i];
        }

        return temp;
    }

    public static int getTotalPrice(){
        int totalPrice = 0;

        for(int i = 0; i < size; i ++){
            totalPrice += books[i].getPrice();
        }
        return totalPrice;
    }

    public static double getPriceAvg(){
        int totalPrice = getTotalPrice();

        return totalPrice / size;
    }
}
