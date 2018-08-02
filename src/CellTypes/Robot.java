package CellTypes;

public class Robot {
    private int row = 0;
    private int column = 0;
    private int direction = 0;
    private int coins = 0;
    private String[] directions = {"^",">","v","<"};

    public Robot(int row, int column, int direction){
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public boolean ROTATE(){
        this.direction = (this.direction+1)%4;
        return true;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public int getDirection(){
        return this.direction;
    }

    public boolean MOVE(){
        switch (direction){
            case 0:
                this.row -= 1;
                return true;
            case 1:
                this.column += 1;
                return true;
            case 2:
                this.row +=  1;
                return true;
            case 3:
                this.column -= 1;
                return true;
            default:
                System.out.println("Movimiento no permitido!");
                return false;
        }
    }

    public boolean PICK(){
        this.coins ++;
        return true;
    }

    public String toString() {
        switch (this.direction) {
            case 0: return directions[0];
            case 1: return directions[1];
            case 2: return directions[2];
            case 3: return directions[3];
            default: return "Error";
        }
    }
}
