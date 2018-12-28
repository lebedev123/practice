package Chat.CapitChat;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private JFrame frame = new JFrame("Capitalize Client");
    private JTextField dataField = new JTextField(40);
    private JTextArea messageArea = new JTextArea(8, 60);

    public Client() {
        messageArea.setEditable(false);
        frame.getContentPane().add(dataField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        dataField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println(dataField.getText());
                String response;
                try {
                    response = in.readLine();
                    if (response == null || response.equals("")) {
                        System.exit(0);
                    }
                } catch (IOException ex) {
                    response = "Error " + ex;
                }
                messageArea.append(response + "\n");
                dataField.selectAll();
            }
        });
    }

    public void conectToServer() throws IOException {
        String serverAddress = JOptionPane.showInputDialog(frame, "Enter IP Address of the server:",
                "Welcome to the Capitalization Program", JOptionPane.QUESTION_MESSAGE);
        Socket socket = new Socket(serverAddress, 9898);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        for (int i = 0; i < 3; i++) {
            messageArea.append(in.readLine() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.pack();
        client.frame.setVisible(true);
        client.conectToServer();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(34,45);
        map.put(34,46);
        map.put(35,45);
        Iterator i = map.entrySet().iterator();

    }
}
