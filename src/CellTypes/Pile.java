package CellTypes;

public class Pile {
    private int row = 0;
    private int column = 0;
    private int coins = 0;

    public Pile (int row, int column,int coins){
        this.coins = coins;
        this.row = row;
        this.column = column;
    }

    public boolean getCoin(){
        if (coins > 0){
            coins -= 1;
            return true;
        }else {
            System.out.println("Ya no hay monedas en la pila.");
            return false;
        }
    }
}
