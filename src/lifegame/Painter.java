package lifegame;

public class Painter {

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    
    private GameFrame frame;
    private DrawPanel panel;
    
    public Painter() {
        frame = new GameFrame(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    public void paint(boolean[][] arr){
    	frame.remove(panel);
        //panel = new DrawPanel(arr, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        panel = new DrawPanel(arr, arr.length * 10, arr[0].length * 10);//length of each grid is 10
        frame.add(panel);
        frame.paintAll(panel.getGraphics());
    }
    
}