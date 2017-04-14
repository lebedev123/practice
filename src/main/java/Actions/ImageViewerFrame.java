package Actions;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;

/**
 * Created by dos on 01.02.2017.
 */
public class ImageViewerFrame extends JFrame {
    private static int DEFAULT_WIDTH = 300;
    private static int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser fileChooser;

    public ImageViewerFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        JLabel finalLabel = label;
        openItem.addActionListener(e -> {
            fileChooser.setCurrentDirectory(new File("."));
            int result = fileChooser.showOpenDialog(ImageViewerFrame.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = fileChooser.getSelectedFile().getPath();
                finalLabel.setIcon(new ImageIcon(name));
                pack();
            }
        });
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));
        label = new JLabel();
        add(label);
        fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
        fileChooser.setFileFilter(filter);
        fileChooser.setAccessory(new ImagePreviewer(fileChooser));
        fileChooser.setFileView(new FileIconView(filter, new ImageIcon(".gif")));
    }

    public static void main(String[] args) {
        ImageViewerFrame imageVeiwerFrame = new ImageViewerFrame();
        imageVeiwerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageVeiwerFrame.setVisible(true);
    }
}

class ImagePreviewer extends JLabel {
    public ImagePreviewer(JFileChooser fileChooser) {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());
        fileChooser.addPropertyChangeListener(evt -> {
            if (evt.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                File f = (File) evt.getNewValue();
                if (f == null) {
                    setIcon(null);
                    return;
                }
                ImageIcon icon = new ImageIcon(f.getPath());
                if (icon.getIconWidth() > getWidth())
                    icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
            }
        });
    }
}

class FileIconView extends FileView {
    private FileFilter filter;
    private Icon icon;

    public FileIconView(FileFilter aFilter, Icon aIcon) {
        filter = aFilter;
        icon = aIcon;
    }
    public Icon getIcon(File f) {
        if (!f.isDirectory() && filter.accept(f)) return icon;
        else return null;
    }

}