import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //64 * 8 for scaled graphics (maybe not)
        Window app = new Window("Awesome window!", new Dimension(256, 256));
        int tileSize = 32;
        app.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        app.initGrid(tileSize);

        Coordinate[] fillCoords = {
                new Coordinate(0,0),
                new Coordinate(1,1),
                new Coordinate(7,6),
                new Coordinate(3,4),
        };

        for (int i = 0; i < fillCoords.length; i++) {
            fillCoords[i] = fillCoords[i].convertToGrid(app.getHeight()/tileSize);
        }

        app.setGrid(fillCoords);
    }
}