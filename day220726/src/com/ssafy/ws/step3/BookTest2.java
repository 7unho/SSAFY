package com.ssafy.ws.step3;

import java.util.Scanner;

public class BookTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        while(true){
            printMenu();
            menu = sc.nextInt();

            if(menu == 10) break;

            switch (menu){
                case 1: {
                    String isbn, title, author, publisher, desc;
                    int price;

                    System.out.print("isbn : ");
                    sc.nextLine();
                    isbn = sc.nextLine();

                    System.out.print("title : ");
                    title = sc.nextLine();

                    System.out.print("author : ");
                    author = sc.nextLine();

                    System.out.print("publisher : ");
                    publisher = sc.nextLine();

                    System.out.print("price : ");
                    price = sc.nextInt();
                    sc.nextLine();

                    System.out.print("desc : ");
                    desc = sc.nextLine();

                    BookManager.add(new Book(
                            isbn,
                            title,
                            author,
                            publisher,
                            price,
                            desc
                    ));
                    break;
                }
                case 2:{
                    System.out.println("********************도서목록********************");
                    Book[] books = BookManager.getList();

                    for ( Book book : books ) {
                        System.out.println(book.toString());
                    }
                    break;
                }
                case 3:{
                    String isbn;

                    System.out.print("조회할 도서의 isbn : ");
                    isbn = sc.next();
                    Book book;

                    book = BookManager.searchByIsbn(isbn);

                    if(book.getIsbn() != null) System.out.println(book.toString());
                    break;
                }
                case 4:{
                    String title;
                    Book[] books;

                    System.out.print("조회할 도서의 title : ");
                    title = sc.next();

                    books = BookManager.searchByTitle(title);

                    for (Book book:books) {
                        System.out.println(book.toString());
                    }

                    break;
                }
                case 5:{
                    Magazine[] magazines;

                    magazines = BookManager.getMagazine();

                    for (Magazine magazine:magazines) {
                        System.out.println(magazine.toString());
                    }
                    break;
                }
                case 6: {
                    Book[] books;

                    books = BookManager.getBooks();

                    for (Book book: books) {
                        System.out.println(book.toString());
                    }

                    break;

                }
                case 7:{
                    int totalPrice;

                    totalPrice = BookManager.getTotalPrice();
                    System.out.printf("도서 리스트의 총 가격은 : %d원 \n", totalPrice);
                    break;

                }
                case 8:{
                    double avgPrice;

                    avgPrice = BookManager.getPriceAvg();
                    System.out.printf("도서 리스트의 평균 가격은 : %.1f원 \n", avgPrice);
                    break;
                }
                case 9:{
                    String isbn;
                    System.out.print("삭제할 도서의 isbn : ");
                    isbn = sc.next();
                    BookManager.remove(isbn);
                    break;
                }
                case 10:
                    break;
            }
        }

    }

    static void printMenu(){
        System.out.print("1. 추가 2. 목록 3. isbn 조회 4. title 조회 5. 잡지 리스트 반환 6. 일반 도서 리스트 반환 " +
                "7. 총 가격 반환 8. 평균 가격 반환 9. 삭제 10. 종료 : ");
    }
}
