package com.ssafy.ws.step3;

public class Book {
    String isbn;
    String title;
    String author;
    String publisher;
    int price;
    String desc;

    public Book(){

    }

    public Book(String isbn, String title, String author, String publisher, int price, String desc){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }


    public String toString(){
        return String.format("%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s", this.isbn, this.title, this.author, this.publisher, this.price, this.desc);
    }
}
