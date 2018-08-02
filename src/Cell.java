import CellTypes.Wall;
import CellTypes.Pile;
import CellTypes.Robot;

public class Cell {
    private char name;
    private int row = 0;
    private int column = 0;
    private boolean isWall = false;
    private boolean hasRobot = false;
    private Pile pile;

    public Cell(int row, int column, char name) {
        this.row = row;
        this.column = column;
        this.name = name;
    }

    public void setName(char name){
        this.name = name;
    }

    public boolean robotMove(){
        this.hasRobot = !this.hasRobot;
        return this.hasRobot;
    }

    public void turnWall(){
        this.isWall = true;
    }

    public boolean isWall(){
        return this.isWall;
    }

    public void setPile(Pile Pile){
        this.pile = Pile;
    }

    public Pile getPile(){
        return this.pile;
    }

    public String toString() {
        if (Character.toString(name).equals("0")){
            return " ";
        }
        return Character.toString(name);
    }
}
