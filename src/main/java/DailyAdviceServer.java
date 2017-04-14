import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dos on 13.10.2016.
 */
public class DailyAdviceServer {
    String[] adviceList = {"LUL","K3K","PogChamp"};
    public void go(){
        try{
            ServerSocket  serverSocket = new ServerSocket(4242);
            while(true){
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private String getAdvice(){
        int random = (int)(Math.random()*adviceList.length);
        return adviceList[random];
    }
    public static void main(String[] args){
        DailyAdviceClient server = new DailyAdviceClient();
        server.go();
    }
}
