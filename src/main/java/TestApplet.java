import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dos on 04.02.2017.
 */
public class TestApplet extends JApplet {

    public void init() {
        EventQueue.invokeLater(() -> {
            setLayout(new GridLayout());
            ImagePanel panel = new ImagePanel();
            add(panel);
            JLabel label = new JLabel("Hello ?");
            add(label);
        });
    }
}
class ImagePanel extends JPanel{
    private BufferedImage image;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
        setSize(200,200);
    }

    public ImagePanel(){
        try{
            image = ImageIO.read(new File("forsenEmini.jpg"));
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println("PogChamp");
        }

    }
}
