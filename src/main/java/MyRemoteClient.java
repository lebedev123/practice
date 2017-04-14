import java.rmi.Naming;
/**
 * Created by dos on 22.10.2016.
 */
public class MyRemoteClient {
    public static void main(String[] args){
        new MyRemoteClient().go();
    }
    public void go(){
        try{
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
            String s =service.sayHello();
            System.out.println(s);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
