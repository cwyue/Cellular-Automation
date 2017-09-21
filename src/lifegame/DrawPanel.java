package lifegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

public class DrawPanel extends JPanel{
    
    private boolean[][] arr;
    private int width;
    private int height;
    
    public DrawPanel(boolean[][] arr, int width, int height){
        this.arr = arr;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        int lenX = arr.length;
        int lenY = arr[0].length;
        float unitX = (float)width / lenX;
        float unitY = (float)height / lenY;
        
        for (int x = 0; x < lenX; ++x) {
            for (int y = 0; y < lenY; ++y) {
                Paint paint = arr[x][y] ? Color.ORANGE : Color.DARK_GRAY;//Alive cells are drawn in orange, and dead ones are drawn in dark gray
                LifeRect rect = new LifeRect(unitX * x, unitY * y, unitX, unitY);
                g2.setPaint(paint);
                g2.fill(rect);
                g2.setPaint(Color.LIGHT_GRAY);//draw grids
                g2.draw(rect);
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}