import javax.swing.*;

/**
 * Created by dos on 05.10.2016.
 */
public class TextField {
    JTextArea text;
    public static void main(String [ ] args){
        TextField field1 = new TextField();
        field1.go();
    }
    public void go(){
        JTextField field = new JTextField(20);
        JTextField textField = new JTextField("Your name");
        System.out.println(field.getText());
        field.setText("Anything");
        field.setText(" ");
    }
}
