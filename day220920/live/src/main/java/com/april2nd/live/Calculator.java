package com.april2nd.live1;

public class Calculator {
    private int su1;
    private int su2;
    private String oper;
    private int result;

    public Calculator(int su1, int su2, String oper) {
        super();
        this.su1 = su1;
        this.su2 = su2;
        this.oper = oper;
        choice();
    }

    private void choice() {
        if(oper.equals("+")) plus();
        else if(oper.equals("-")) minus();
        else if(oper.equals("*")) multi();
        else if(oper.equals("/")) div();
    }
    private void plus() {result = su1+su2;}
    private void minus() {result = su1-su2;}
    private void multi() {result = su1*su2;}
    private void div() {result = su1/su2;}

    public String getResult() {
        return "결과값: "+su1+" "+oper+" "+su2+" = "+result;
    }


}