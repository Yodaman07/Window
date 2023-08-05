import java.awt.*;

import rendering.Coordinate;
import rendering.Window;
import rendering.CoordinateCollection;
import games.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window w = new Window("AMAZING WINDOW", new Dimension(512, 512));
        w.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        w.initGrid(32);

        Coordinate[] coords = {
                new Coordinate(11,5).convertToGrid(w.getHeight()/32),
                new Coordinate(3,3).convertToGrid(w.getHeight()/32).setColor(Color.BLUE),
        };

        w.setGrid(coords);
    }
}