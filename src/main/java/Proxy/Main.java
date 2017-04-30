package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

/**
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Class[] classes = new Class[]{Comparable.class, Callable.class};
        Object proxy = Proxy.newProxyInstance(null,classes,new MyProxy());
        proxy.getClass();
        ((Comparable)proxy).compareTo(5);
    }
    static class MyProxy implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(args);
            return invoke();
        }
    }
}
