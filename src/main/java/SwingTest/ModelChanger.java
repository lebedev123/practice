package SwingTest;

import javax.swing.*;

/**
 * Created by dos on 18.01.2017.
 */
public class ModelChanger extends JFrame {
    private JPanel panel;

    public static void main(String[] args) {
        ModelChanger changer = new ModelChanger();
        changer.setSize(500,500);
        changer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changer.setVisible(true);
    }
    private void makeButton(String name, String className) {
        JButton button = new JButton(name);
        panel.add(button);
        button.addActionListener(event -> {
            try {
                panel.setSize(500,500);
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public ModelChanger(){
        panel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos){
            makeButton(info.getName(),info.getClassName());
        }
        add(panel);
    }
}
