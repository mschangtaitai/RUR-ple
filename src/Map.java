public class Map {
    private Cell[][] map;

    public Map(int x,int y) {
        this.map = new Cell[x][y];

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                this.map[i][j] = new Cell(i, j);
            }
        }
    }
}
