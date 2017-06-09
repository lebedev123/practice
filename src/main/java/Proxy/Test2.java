package Proxy;

import java.lang.reflect.Proxy;

/**
 * Параметры этого вызова -
 * <p>
 * ClassLoader класса Person
 * <p>
 * Массив типа Class,который должен принимать массив интерфейсов, которые исполняет наш класс (Person).
 * МЕТОДЫ ЭТИХ ИНТЕРФЕЙСОВ БУДУТ ПЕРЕХВАТЫВАТЬСЯ (InvocationHandler-ом).
 * <p>
 * Экземпляр InvocationHandler, который будет перехватывать методы
 * вызываемые для объекта person (на самом деле, вызовы будут идти через вновь созданный personproxy).
 * <p>
 * На выходе получаем экземпляр некого класса(прокси), дающий следующую НУЖНУЮ
 * функциональность (для чего всё это затевалось)
 * он исполняет все методы интерфейсов, переданных во 2м параметре при вызове
 * Proxy.newProxyInstance (в нашем примере это getName,setName,rename). В этом он похож на Person
 * при вызове этих методов этого экземпляра (например personproxy.setName) ВЫЗЫВАЕТСЯ МЕТОД INVOKE InvocationHandler-а.
 * InvocationHandler уже дальше решает, как
 * ему поступить - либо вызвать соответствующий метод реального класса Person, либо делать чтото еще.
 */
public class Test2 {
    public static void main(String[] args) {
        Person person = new Person();

        IPerson personproxy = (IPerson) Proxy.newProxyInstance(Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person));

        personproxy.setName("Гриша");
        String h = personproxy.getName();
        personproxy.rename("Вася");
    }
}

interface IPerson {
    public String getName();

    public void setName(String name);

    public void rename(String new_name);
}

class Person implements IPerson {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rename(String new_name) {
        if (!new_name.equals(name)) this.name = new_name;
    }
}

class NeverSleepingEye implements java.lang.reflect.InvocationHandler {
    private Object obj;

    public NeverSleepingEye(Object f1) {
        obj = f1;
    }

    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args)
            throws Throwable {
        System.out.println("NeverSleepingEye invoke : " + method.getName());
        return method.invoke(obj, args);
    }
}