package lifegame;

public class World {

    private int lenX;//max width
    private int lenY;//max height
    private Cell[][] cells;//map of cells
    
    private World(int lenX, int lenY) {//construct the world
        this.lenX = lenX;
        this.lenY = lenY;
        cells = new Cell[lenX][lenY];
        for(int x = 0; x < lenX; ++x){
            for(int y = 0; y < lenY; ++y)
                cells[x][y] = new Cell();
        }
    }
    
    public World(int lenX, int lenY, int[][] seed){//construct the world, and determine the statuses of cells by seeds
        this(lenX, lenY);
        for(int x = 0; x < seed.length; ++x){
            for(int y = 0; y < seed[x].length; ++y)
                if(seed[x][y] == 1)
                    cells[x][y].setAlive(true);
        }
    }
    
    public World(int lenX, int lenY, double scale, double ratio) {//construct the world, and determine the statuses of cells by random selection
        this(lenX, lenY);
        for(int x = 0; x < lenX * scale; x++){//only a part of the world is planted
            for(int y = 0; y < lenY * scale; y++)
                if(Math.random() <= ratio)//the status of cell is randomly determined, and the possibility of alive is ratio
                    cells[x][y].setAlive(true);//set them alive
        }
    }
    
    public void timePass(){//to get the world map in the next turn
        for(int x = 0; x < lenX; ++x){
            for(int y = 0; y < lenY; ++y)
                cells[x][y].timePass();//update the status of each cell
        }
        for(int x = 0; x < lenX; ++x){
            for(int y = 0; y < lenY; ++y){
                int count = aliveRoundCount(x, y);
                cells[x][y].aliveNextReady(count);//check the statuses of the neighbors and prepare for the next turn
            }
        }
    }
    
    private int aliveRoundCount(int x, int y){//count the alive neighbors in 3x3 grids
        int count = 0;
        for(int i = -1; i <= 1; i++){
            int tempX  = (x + i + lenX) % lenX;//no boundary
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0)
                    continue;
                int tempY  = (y + j + lenY) % lenY;//no boundary
                if(cells[tempX][tempY].isAlive())
                     count++;
            }
        }
        return count;
    }
    
    public boolean[][] aliveArray(){//get all statuses of cells
        boolean[][] alive = new boolean[lenX][lenY];
        for(int x = 0; x < lenX; x++){
            for(int y = 0; y < lenY; y++)
                alive[x][y] = cells[x][y].isAlive();
        }
        return alive;
    }

}