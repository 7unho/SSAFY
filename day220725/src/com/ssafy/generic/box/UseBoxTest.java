package com.ssafy.generic.box;

public class UseBoxTest {
    public static void main(String[] args) {

    }

    private static void useNormalBox(){
        NormalBox nbox = new NormalBox();

        //Object 처리
        nbox.setSome(1);
        nbox.setSome("Hello");

        Object obj = nbox.getSome();
        Integer num = (Integer)obj;

        if (obj instanceof String){
            String str = (String)obj;
            System.out.println(str + " : " + str.length());
        }

        GenericBox<Object> obox = new GenericBox<>();
    }

    private static void useGenericBox(){
        GenericBox<String> sbox = new GenericBox<>();

        sbox.setSome("hello");
        String str = sbox.getSome();

        System.out.printf("%s : %d", str, str.length());

        GenericBox<Integer> ibox = new GenericBox<>();
        ibox.setSome(42);

        System.out.printf("ibox some : %d", ibox.getSome());
    }

    private static void useNumberBox(){
        NumberBox<Number> numbox = new NumberBox<>();
        numbox.addSome(1, 10l, 3.14);

        NumberBox<Integer> dbox = new NumberBox<>();
        dbox.addSome(1, 3, 10);
    }
}
