import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by dos on 22.10.2016.
 */
public interface MyRemote extends Remote {
    public String sayHello()throws RemoteException;
}
