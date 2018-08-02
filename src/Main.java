import CellTypes.Wall;
import CellTypes.Pile;
import CellTypes.Robot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            Stream<String> lines = Files.lines(
                    Paths.get("/Users/michaelchan/Desktop/Juegos poo/RUR-ple/TestMapa.txt"),
                    StandardCharsets.UTF_8);
            Vector<String> linesArray = new Vector();
            lines.forEach(s -> linesArray.addElement(s));
            int rows = linesArray.size();
            int columns = linesArray.elementAt(0).length();
            System.out.println(rows + " " + columns);
            Map map = new Map(rows,columns);
            Vector<String> directions = new Vector<>();
            directions.addElement("^");
            directions.addElement(">");
            directions.addElement("v");
            directions.addElement("<");

            Robot robot = new Robot(0,0,0);
            for (int i=0; i<rows; i++) {
                for (int j=0; j<columns; j++){
                    char name = linesArray.elementAt(i).charAt(j);
                    map.getCell(i,j).setName(name);
                    if (Character.toString(name).equals("*")) {
                        map.getCell(i,j).turnWall();
                    } else if (directions.contains(Character.toString(name))){
                        map.getCell(i,j).robotMove();
                    } else{
                        Pile pile = new Pile(i,j,Character.getNumericValue(name));
                        map.getCell(i,j).setPile(pile);
                    }
                    if (directions.contains(Character.toString(name))){
                        int k = directions.indexOf(Character.toString(name));
                        robot = new Robot(i,j,k);
                    }
                }
            }

            System.out.println(map);
            Stream<String> solucion = Files.lines(
                    Paths.get("/Users/michaelchan/Desktop/Juegos poo/RUR-ple/TestSolucion.txt"),
                    StandardCharsets.UTF_8);
            Vector<String> solucionList = new Vector();
            solucion.forEach(s -> solucionList.addElement(s));
            int y = 1;
            for (String i : solucionList) {
                switch(i){
                   case "ROTATE":
                       robot.ROTATE();
                       map.getCell(robot.getRow(),robot.getColumn()).setName(robot.toString().charAt(0));
                       break;
                   case "MOVE":
                       switch(robot.getDirection()){
                           case 0:
                               if (map.getCell((robot.getRow()-1),robot.getColumn()).isWall()){
                                   break;
                               }
                           case 1:
                               if (map.getCell((robot.getRow()),robot.getColumn()+1).isWall()){
                                   break;
                               }
                           case 2:
                               if (map.getCell((robot.getRow()+1),robot.getColumn()).isWall()){
                                   break;
                               }
                           case 3:
                               if (map.getCell((robot.getRow()),robot.getColumn()-1).isWall()){
                                   break;
                               }
                           default:
                               map.getCell(robot.getRow(),robot.getColumn()).setName(robot.toString().charAt(0));
                               robot.MOVE();
                               System.out.println("entro");
                               map.getCell(robot.getRow(),robot.getColumn()).setName(robot.toString().charAt(0));
                               break;
                       }
                   case "PICK":
                       map.getCell(robot.getRow(),robot.getColumn()).getPile().getCoin();
                       robot.PICK();
                       break;
                }
                System.out.println(i);
                System.out.println("Paso: " + y);
                y ++;
                System.out.println(map);
            }


        } catch (IOException exception) {
            System.out.println("Error!");
        }

    }
}
