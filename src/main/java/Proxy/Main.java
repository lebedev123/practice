package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

/**
 *В результате вызова этого метода динамически генерируется класс (называемый класс-заместитель),
 * реализующий набор интерфейсов, переданных в массиве interfaces, а затем создаётся и возвращается
 * экземпляр этого класса. Поскольку Java интерфейс не определяет никакой реализации объявленных в нём методов,
 * то создаваемый класс-заместитель предоставляет шаблонную реализацию для всех интерфейсных методов—их вызовы
 * перенаправляются специальному объекту—InvocationHandler'у, который и должен предоставлять их реализацию.
 *Интерфейс InvocationHandler содержит всего один метод: Object invoke(Object proxy, Method method, Object[] args),
 *  в этот метод передаётся объект класса-заместителя, для которого был вызван интерфейсный метод (proxy),
 *  сам вызванный метод (method) и его параметры (args).
 *
 */
public class Main {
    public static void main(String[] args) {
        Class[] interfaces = new Class[]{Comparable.class, Callable.class};
        //Создается прокси объект который реализовывает все интерфейсы
        Object proxy = Proxy.newProxyInstance(null,interfaces,new MyProxy(5));
        System.out.println(proxy.getClass());
        System.out.println(proxy.toString());
        Method[] methods = proxy.getClass().getMethods();
        for (Method m: methods) {
            System.out.println(m);
        }
        System.out.println(((Callable)proxy).getClass());
        ((Comparable)proxy).compareTo(5);
    }
    static class MyProxy implements InvocationHandler{
        Integer a;

        public MyProxy(Integer a) {
            this.a = a;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(a,args);
        }
    }
}
