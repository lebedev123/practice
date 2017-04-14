/**
 * Created by dos on 14.11.2016.
 */
public class TestThisApple {
    public static void main(String [] args){
        Person person = new Person();
        Apple apple = new Apple();
        person.eat(apple);
    }
}
class Person{
    public void eat(Apple apple){
        Apple peeled = apple.getPeeled();
        System.out.print("Nice");
    }
}
class Peeler{
    static Apple peel(Apple apple){
        return apple;
    }
}
class Apple{
    Apple getPeeled(){
        return Peeler.peel(this);
    }
}
