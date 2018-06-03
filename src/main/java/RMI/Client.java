package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

public class Client {
    private Client() {

    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try{
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String resopnse = stub.sayHello();
            System.out.println("response : " + resopnse);
        }catch (Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
