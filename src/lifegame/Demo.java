package lifegame;

public class Demo {

    static int[][] TANK = {//seed
        {1, 0, 1},
        {0, 1, 1},
        {0, 1, 0}
    };
    
    static int[][] SHIP = {//seed
        {0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 0}
    };
    
    static int[][] TOAD = {//seed
        {0, 0, 0, 0},
        {0, 1, 1, 1},
        {1, 1, 1, 0}
    };
    
    static int[][] BOAT = {//seed
        {1, 1, 0},
        {1, 0, 1},
        {0, 1, 0}
    };
    
    static int[][] GLIDER = {//seed
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
        {1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    public static void main(String[] args) {
        
        Initialization ini = new Initialization();
        ini.createWorld(0.8, 1.0);//createWorld(scale, ratio), both parameters should be between 0 and 1
//        ini.createWorld(TANK);
//        ini.createWorld(SHIP);
//        ini.createWorld(TOAD);
//        ini.createWorld(BOAT);
//        ini.createWorld(transpose(GLIDER));
        
        for(int i = 0; i < 10000; i++){//update the world and +1s
            ini.timePass();
            sleep(100);//slow down the speed of presentation
        }
    }

    static int[][] transpose(int[][] a){//transpose the map
        int lenI = a.length;
        int lenJ = a[0].length;
        int[][] b = new int[lenJ][lenI];
        for (int i = 0; i < lenI; i++) {
            for (int j = 0; j < lenJ; j++)
                b[j][i] = a[i][j];
        }
        return b;
    }
    
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}