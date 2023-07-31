package rendering;

public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinate() {
        return new int[]{this.x, this.y};
    }

    public Coordinate convertToGrid(int h){
        //(0,0) --> (0,7)
        return new Coordinate(x,h-y-1);

    }
}
