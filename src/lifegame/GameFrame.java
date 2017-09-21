package lifegame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame(int width, int height) {
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        
        setTitle("2-Dimensional Cellular Automation");
        
        Image image = new ImageIcon("logo-icon.jpg").getImage();
        setIconImage(image);
        
        setLocation(screenWidth/2 - width/2, screenHeight/2 - height/2);//show the frame in the center of the screen
        setSize(width + 16, height + 38);
        setResizable(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void remove(Component comp) {
        if(comp != null)
            super.remove(comp);
    }
}