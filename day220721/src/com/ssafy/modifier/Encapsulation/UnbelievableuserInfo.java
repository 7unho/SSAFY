package com.ssafy.modifier.Encapsulation;

public class UnbelievableuserInfo {
    private String name = "홍길동";
    private int account = 10000;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) this.name = name;
        else System.out.println("부적절한 name 할당 시도 무시 : " + name);
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        if(account >= 0) this.account = account;
        else System.out.println("부적절한 account 할당 시도 무시 : " + account);
    }
}
