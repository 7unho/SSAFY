package com.ssafy.ws.step3;

public class Magazine extends Book{
    private int year;
    private int month;

    public Magazine(){}

    public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
        super(isbn, title, author, publisher, price, desc);
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
//        return String.format("%s\t|%s\t|%s\t|%s\t|%d\t|%s\t|%d\t|%d\t\n", getIsbn(), getTitle(), getAuthor(), getPublisher(), getPrice(), getDesc(), getYear(), getMonth());
        return getIsbn() + '\t' + "| " + getTitle() + "  \t" + "| " + getAuthor() + '\t' + "| " + getPublisher() + '\t'
                + "| " + getPrice() + '\t' + "| " + getDesc() + '\t' + "| " + getYear() + '\t' + "| " + getMonth() + '\t';
    }
}
