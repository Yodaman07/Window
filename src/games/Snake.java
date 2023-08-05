package games;

import rendering.Coordinate;
import rendering.Window;

import java.awt.*;
import java.util.Random;

public class Snake extends Window{

    public Snake(String name, Dimension size) {
        super(name, size);

        int tileSize = 32;
        super.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        super.initGrid(tileSize);

        Coordinate[] fillCoords = {
                new Coordinate(0,0),
                new Coordinate(0,7),
                new Coordinate(7,0),
                new Coordinate(7,7),
        };

        for (int i = 0; i < fillCoords.length; i++) {
            fillCoords[i] = fillCoords[i].convertToGrid(super.getHeight()/tileSize);
        }

        super.setGrid(fillCoords);
    }

    public void setFruit(){
        Random random = new Random();
        int x = random.nextInt(8);
        int y = random.nextInt(8);
    }

}