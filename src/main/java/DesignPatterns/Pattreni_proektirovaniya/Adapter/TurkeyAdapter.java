package DesignPatterns.Pattreni_proektirovaniya.Adapter;


import DesignPatterns.Pattreni_proektirovaniya.Stategy.Duck;

/**
 * Инкапсулирует индюшку и расширяет утку - ваще класс
 */
public class TurkeyAdapter extends Duck {
    Turkey turkey;


    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (Integer i : new Integer[]{1,2,3,4,5}){
            turkey.fly();
        }
    }
}
