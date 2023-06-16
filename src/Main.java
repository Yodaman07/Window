import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Window app = new Window("Awesome window!", new Dimension(700, 500));
        app.setColor(new Color(213, 212, 234), new Color(46, 13, 255));

        Coordinate[] coords = {
                new Coordinate(25, 0),
                new Coordinate(0, 50),
                new Coordinate(50, 50),
        };

        CoordinateCollection coordCollection = new CoordinateCollection(new Dimension(50, 50), coords);
        //-25 is the offset for the spriteSize width and height in half
        //Currently only works with resizeable windows off
        Dimension pos = new Dimension(app.WINDOW_POS_CENTER_X-25, app.WINDOW_POS_CENTER_Y-25);
        app.renderSprite(coordCollection, pos);
    }
}