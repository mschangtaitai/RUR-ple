import CellTypes.Wall;
import CellTypes.Pile;
import CellTypes.Robot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            Stream<String> lines = Files.lines(
                    Paths.get("/Users/michaelchan/Desktop/Juegos poo/RUR-ple/TestMapa.txt"),
                    StandardCharsets.UTF_8);
            lines.forEach(s -> System.out.println(s + "  " + s.charAt(1)));
        } catch (IOException exception) {
            System.out.println("Error!");
        }
    }
}
