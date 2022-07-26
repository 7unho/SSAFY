package com.ssafy.inter.module;

public class ModuleTest {
    public static void main(String[] args) {
        Object[] objs = {new HandPhone(), new Camera(), new DigCamera(), new Phone()};

        for (Object obj: objs) {
            if(obj instanceof Chargeable){
                Chargeable c = (Chargeable) obj;
                c.charge();
            }
        }
    }
}
