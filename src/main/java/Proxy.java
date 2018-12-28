import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    public static void main(String[] args) {
        Person person = new Person("adadas");

        IPerson value = (IPerson) java.lang.reflect.Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
                (InvocationHandler) (proxy, method, args1) -> {
                    System.out.println(person + " вызов метода " + method.toString());
                    return method.invoke(person, args);
                }
        );

        System.out.println(value.getName());

    }
}


 interface IPerson {
    public void setName(String name);
    public String getName();
}
class Person implements  IPerson{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}