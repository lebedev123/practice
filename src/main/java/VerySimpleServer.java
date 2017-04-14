import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dos on 14.10.2016.
 */
public class VerySimpleServer {
    ArrayList clientOutputStream;
    public class  ClientHandler implements Runnable {//Потоки
        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;//сокет полученный как аргумент
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());//поток сокета
                reader = new BufferedReader(isReader);// символы
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {//Пока сообщение не будет пусто,выовдит сообщение и отправляет всем
                    System.out.println("read " + message);
                    tellEveryone(message);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        new VerySimpleServer().go();//Запуск сервера
    }
    public void go(){
        clientOutputStream = new ArrayList();
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            while(true){
                Socket clientSocket = serverSocket.accept();//Блокирует порт до тех пор пока не будет получен запрос
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStream.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got connection");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void  tellEveryone(String message){
        Iterator it = clientOutputStream.iterator();
        while(it.hasNext()){
            try{
                PrintWriter writer = (PrintWriter)it.next();
                writer.println(message);
                writer.flush();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
