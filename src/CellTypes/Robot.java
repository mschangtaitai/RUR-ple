package CellTypes;

public class Robot {
    private int row = 0;
    private int column = 0;
    private int direccion = 0;
    private int coins = 0;

    public Robot(int row, int column){
        this.row = row;
        this.column = column;
    }

    public boolean rotate(){
        this.direccion = (this.direccion+1)%4;
        return true;
    }

    public boolean move(){
        switch (direccion){
            case 0:
                this.column = this.column - 1;
                return true;
            case 1:
                this.row = this.row + 1;
                return true;
            case 2:
                this.column = this.column + 1;
                return true;
            case 3:
                this.row = this.row - 1;
                return true;
            default:
                System.out.println("Movimiento no permitido!");
                return false;
        }
    }

    public boolean pick(){
        this.coins ++;
        return true;
    }
}
