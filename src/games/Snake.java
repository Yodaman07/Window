package games;

import rendering.Coordinate;
import rendering.Window;

import java.awt.*;
import java.util.Random;

public class Snake extends Window{
    int tileSize;
    int gridHeight;
    int gridWidth;

    Coordinate fruitPos;
    public Snake(String name, Dimension size) {
        super(name, size);

        int tileSize = 32;
        this.tileSize = tileSize;
        this.gridWidth = super.getWidth()/tileSize;
        this.gridHeight = super.getHeight()/tileSize;

        super.setColor(new Color(213, 212, 234), new Color(46, 13, 255));
        super.initGrid(tileSize);

        Coordinate[] fillCoords = {
                new Coordinate(0,0),
                new Coordinate(0,this.gridHeight-1),
                new Coordinate(this.gridWidth-1,0),
                new Coordinate(this.gridWidth-1,this.gridHeight-1),
        };

        for (int i = 0; i < fillCoords.length; i++) {
            fillCoords[i] = fillCoords[i].convertToScreen(this.gridHeight);
        }

        super.setGrid(fillCoords);
    }

    public void setFruit(){
        Random random = new Random();
        int x = random.nextInt(this.gridWidth);
        int y = random.nextInt(this.gridHeight);
        //Always needs to be a 1 value long array
        Coordinate[] fruit = {
                new Coordinate(x,y).convertToScreen(this.gridHeight).setColor(Color.GREEN)
        };
        super.setGrid(fruit);
        this.fruitPos = fruit[0];
    }

    public void spawnPlayer(){
        Random random = new Random();
        int x = random.nextInt(this.gridWidth);
        int y = random.nextInt(this.gridHeight);
        Coordinate[] player = {
                new Coordinate(x,y).convertToScreen(this.gridHeight).setColor(Color.BLACK)
        };


    }
}