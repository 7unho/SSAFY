package com.ssafy.hw.step4;

/**
 * 상품 정보를 나타내는 클래스
 */
public class Product {
    //코드를 작성하세요.
    String pCode;
    String pName;
    int price;
    int quantity;
    String brand;
    String desc;

    public Product(){}

    public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
        this.pCode = pCode;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.desc = desc;
    }

    public String toString(){
        return String.format("Product [pCode=%s, pName=%s, price=%d, quantity=%d, brand=%s, desc=%s입니다.]",
                pCode, pName, price, quantity, brand, desc);
    }
}
