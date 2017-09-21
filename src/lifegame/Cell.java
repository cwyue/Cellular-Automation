package lifegame;

public class Cell {

    private boolean alive;
    private boolean aliveNext;
    
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
        this.aliveNext = alive;
    }
    
    public void timePass() {//To get the cell status in the next turn
        alive = aliveNext;
    }
    
    public void aliveNextReady(int count) {
        switch (count) {
        //Rules of cells:
        //An alive cell with two or three live neighbors survives (survival).
        //A dead cell with exactly three live neighbors becomes an alive cell (birth).
        //In the case that a live cell has zero or one neighbor, it is said to die of loneliness; 
        //if it has more than three neighbors, it is said to die of overcrowding.
        case 2:
            break;//Cell status remains when it has two neighbors.
        case 3:
            aliveNext = true;//Cell status will become alive when it has three neighbors, no matter it is dead or alive in the current turn.
            break;
        //In other cases, cell will be dead.
        default:
            aliveNext = false;
            break;
        }
    }
    
}