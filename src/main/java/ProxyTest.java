import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Integer value = new Integer(3);
        InvocationHandler handler = new TraceHandler(value);
        Class[] interfaces = new Class[]{Comparable.class};
        Integer proxy = (Integer)Proxy.newProxyInstance(null,interfaces,handler);
        System.out.println(proxy.toString());
        System.out.println(proxy.compareTo(4));
    }

}




class TraceHandler implements InvocationHandler{
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.toGenericString());

        return method.invoke(target,args);
    }
}