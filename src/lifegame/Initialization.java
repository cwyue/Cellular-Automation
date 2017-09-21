package lifegame;

import lifegame.Painter;

public class Initialization {

    private World world;
    private Painter painter;
    
    public Initialization() {
        painter = new Painter();
    }
    
    public void createWorld(double d, double e){//Initialize the world
        int lenX = 50;
        int lenY = 50;
        world = new World(lenX, lenY, d, e);
    }
    
    public void createWorld(int[][] seed){//Initialize the world
        int lenX = 50;
        int lenY = 50;
        world = new World(lenX, lenY, seed);
    }
    
    public void timePass(){//update the world
        world.timePass();
        painter.paint(world.aliveArray());//paint the world map
    }
}