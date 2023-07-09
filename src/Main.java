import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //64 * 8 for scaled graphics (maybe not)
        Window app = new Window("Awesome window!", new Dimension(256, 256));
        int tileSize = 32;
        app.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        app.initGrid(tileSize);
        app.setGrid();

    }
}