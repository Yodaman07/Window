package rendering;

import java.awt.*;
import java.util.Arrays;

public class Coordinate {
    int x;
    int y;
    Color color = Color.BLACK;

    public Coordinate(int x, int y) {
        //Everything is initialized as a layout coord
        if ((x < 0 || y < 0) ) {
            System.out.println(x + ":" + y);
            //Grid works in the first quadrant
            throw new RuntimeException("Coordinate cannot be less than 0");
        }else{
            this.x = x;
            this.y = y;
        }
    }

    public String getCoordinate() {
        return Arrays.toString(new int[]{this.x, this.y});
    }

    public Coordinate convertToScreen(int h){
        //h is the height of the grid NOT the window
        //(0,0) --> (0,7)
        y = h-y-1;
        return this;
    }

    public Coordinate convertToGrid(int h){
        y = h-(y+1);
        return this;
    }

    public Coordinate setColor(Color color){
        //Use during initialization of coordinate
        this.color = color;
        return this;
    }
}
