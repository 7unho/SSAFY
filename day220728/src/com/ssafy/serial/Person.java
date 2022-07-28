package com.ssafy.serial;

import java.io.Serializable;

// 안쓰는게 좋다 -> 이클립스에서 나오는 경고를 무시 : 실습용..
@SuppressWarnings("serial")
public class Person implements Serializable {
    private String id;
    private transient String pass;
    private Address addr;

    public Person(String id, String pass, String zipCode, String city) {
        this.id = id;
        this.pass = pass;
        this.addr = new Address(zipCode, city);
    }

    @Override
    public String toString() {
        return String.format("[id = %s, pass = %s, addr = %s]", id, pass, addr);
    }

    class Address implements Serializable{
        private String zipCode;
        private String city;

        public Address(String zipCode, String city) {
            this.zipCode = zipCode;
            this.city = city;
        }
    }
}
