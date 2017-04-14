import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dos on 13.10.2016.
 */
public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;
    //Создаем GUI и слушатель кнопки, вызываем setUpNetworking
    public void go(){
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);
    }
    //Создаем сокет и Printworker
    //Присваиваем Printwriter переменной writer
    public void setUpNetworking(){
        try{
            socket = new Socket("127.0.0.1",5000);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networkong established");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    //Получаем текст из текстового поля и отправляем его на сервер с помощью writer
    public class SendButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                writer.println(outgoing.getText());
                writer.flush();
            }catch (Exception ex){
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    public static void main(String [] args){
        new SimpleChatClientA().go();
    }
}
