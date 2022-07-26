package com.ssafy.staticdefault;

interface Aircon{
    void makeCool();
    default void dry(){
        System.out.println("에어컨 건조 잘못하면 곰팡이 ㅜㅜ");
    }

    static void howto(){
        System.out.println("");
    }
}

class OldisButGoodies1 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각 해줘!");
    }
}

class OldisButGoodies2 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각 해줘 !");
    }
}
class NoWind1 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("바람은 없지만 시원해 ~~");
    }

    @Override
    public void dry() {
        System.out.println("종료 버튼 누르면 건조 후 종료되도록 !");
    }
}
public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = {new OldisButGoodies1(), new OldisButGoodies2()};
        Aircon.howto();
        for(Aircon ac : aircons){
            //
        }
    }
}
