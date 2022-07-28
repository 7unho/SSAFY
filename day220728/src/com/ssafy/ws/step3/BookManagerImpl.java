package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager{
    private static IBookManager instance = new BookManagerImpl();
    private static final int MAX_SIZE = 100;
    private Book[] books = new Book[MAX_SIZE];
    private int size = 0;

    private BookManagerImpl() {
    }

    public static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        if(size < MAX_SIZE) books[size++] = book;
    }

    @Override
    public void remove(String isbn) {

    }

    @Override
    public Book[] getList() {
        return Arrays.copyOfRange(books, 0, size);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        Book book = new Book();
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn().contains(isbn)) book = books[i];
        }

        return book;
    }

    @Override
    public Book[] searchByTitle(String title) {
        Book[] temp = new Book[size];
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if(books[i].getTitle().contains(title)) temp[idx++] = books[i];
        }
        return Arrays.copyOfRange(temp, 0, idx);
    }

    @Override
    public Magazine[] getMagazines() {
        Magazine[] magazines = new Magazine[size];
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if(books[i] instanceof Magazine) magazines[idx++] = (Magazine) books[i];
        }
        return Arrays.copyOfRange(magazines, 0, idx);
    }

    @Override
    public Book[] getBooks() {
        Book[] bookList = new Book[MAX_SIZE];
        int idx = 0;
        for (Book book:books) {
            if(book != null && !(book instanceof Magazine)) bookList[idx++] = book;

        }
        return Arrays.copyOfRange(bookList, 0, idx);
    }

    @Override
    public int getTotalPrice() {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += books[i].getPrice();
        }
        return sum;
    }

    @Override
    public double getPriceAvg() {
        return getTotalPrice() / size;
    }
}
