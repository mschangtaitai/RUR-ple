import CellTypes.Wall;
import CellTypes.Pile;
import CellTypes.Robot;

public class Map {
    private Cell[][] map;
    private int rows;
    private int columns;

    public Map(int x, int y) {
        this.rows =x ;
        this.columns = y;
        this.map = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.map[i][j] = new Cell(i,j,"a".charAt(0));
            }
        }
    }

    public Cell getCell(int i,int j){
        return this.map[i][j];
    }


    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result += this.map[i][j];
            }
            result += "\n";
        }
        return result;
    }
}
