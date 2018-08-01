import CellTypes.Wall;
import CellTypes.Pile;
import CellTypes.Robot;

public class Cell {
    private int row = 0;
    private int column = 0;
    private boolean isWall = false;
    private boolean hasRobot = false;
    private Pile pile;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean RobotMove(){
        this.hasRobot = !this.hasRobot;
        return this.hasRobot;
    }
}
