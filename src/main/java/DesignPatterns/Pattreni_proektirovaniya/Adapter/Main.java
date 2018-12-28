package DesignPatterns.Pattreni_proektirovaniya.Adapter;

import DesignPatterns.Pattreni_proektirovaniya.Stategy.Duck;
import DesignPatterns.Pattreni_proektirovaniya.Stategy.MallarDuck;


/**
 * По сути это никакой нахуй не паттерн а маневр ушами с композицей
 * TurkeyAdapter сборная солянка из индюшки и припил к ней имплементации утки
 * В итоге получаем в каждой имплементации методов утки вызов определенных нужных нам методов индюшки.
 *
 * Называется посадили индюшку, открываем рот и включаем кассету с крияканьем -> индюшка крякает  = Adapter.
 */
public class Main {
    public static void main(String[] args) {
        MallarDuck duck = new  MallarDuck(); // Та самая гребанная утка из stategy
        WildTurkey wildTurkey = new WildTurkey(); //Индюшка нихуя не утка но будем лепить из нее утку
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey); // Ща буит мясо
        System.out.println("Turkey says ...");
        wildTurkey.gobble();
        wildTurkey.fly();
        System.out.println("The duck says");
        testDuck(duck);
        System.out.println("TurkeyAdapter says");
        testDuck(turkeyAdapter);

    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
