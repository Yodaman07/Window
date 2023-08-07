import java.awt.*;
import java.util.Scanner;

import rendering.Coordinate;
import rendering.Window;


public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Snake snake = new Snake("Snake", new Dimension(512,512));
//        Scanner scanner = new Scanner(System.in);
//        while (true){
//              snake.setFruit();
//              scanner.nextInt();
//        }
        windowTests();
    }

    static void windowTests(){
        Window w = new Window("AMAZING WINDOW", new Dimension(512, 512));
        w.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        w.initGrid(32);

        Coordinate[] coords = {
                //The coords are in a layout format but are grid coordinates. The format changes to grid as soon as we call "convertToGrid"
                new Coordinate(1,1).convertToScreen(w.getHeight()/32),
                new Coordinate(3,3).convertToScreen(w.getHeight()/32).setColor(Color.BLUE),
        };
        w.setGrid(coords);

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        System.out.println("a");
        

        Coordinate[] addedCoords = {
                new Coordinate(1,2).convertToScreen(w.getHeight()/32).setColor(Color.green),
                new Coordinate(5,6).convertToScreen(w.getHeight()/32).setColor(Color.red)
        };
        w.addToGrid(addedCoords);
    }
}