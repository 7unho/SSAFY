package com.ssafy.inter;

public class IronMan implements Heroable{
    int weaponDamage = 100;
    @Override
    public int fire() {
        System.out.println("적의 에너지 감소 : " + weaponDamage);
        return weaponDamage;
    }

    @Override
    public void upgrade() {
        System.out.println("성능 개선");
    }

    @Override
    public void changeShape(boolean isHeroMode) {
        if(isHeroMode){
            System.out.println("장갑 장착");
        } else{
            System.out.println("일반 토니스타크");
        }
    }
}
